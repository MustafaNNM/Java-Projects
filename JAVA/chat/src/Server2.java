/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Baran Kaya
 */
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server2 {
    public static void main(String args[]) {
	int port = 6789;
	Server2 server = new Server2( port );
	server.startServer();
    }

    // declare a server socket and a client socket for the server;
    // declare the number of connections

    ServerSocket echoServer = null;
    Socket clientSocket = null;
    int numConnections = 0;
    int port;
	
    public Server2( int port ) {
	this.port = port;
    }

    public void stopServer() {
	System.out.println( "Sunucu temizleniyor." );
	System.exit(0);
    }

    public void startServer() {
	// Try to open a server socket on the given port
	// Note that we can't choose a port less than 1024 if we are not
	// privileged users (root)
	
        try {
	    echoServer = new ServerSocket(port);
        }
        catch (IOException e) {
	    System.out.println(e);
        }   
	
	System.out.println( "Sunucu başladı ve bağlantıları bekliyor." );
	System.out.println( "Multi-threading ile, birden fazla bağlantılara izin verilir." );
	System.out.println( "Sunucuyu durdurmak için -1 gönderin." );

	// Whenever a connection is received, start a new thread to process the connection
	// and wait for the next connection.
	
	while ( true ) {
	    try {
		clientSocket = echoServer.accept();
		numConnections ++;
		Server2Connection oneconnection = new Server2Connection(clientSocket, numConnections, this);
		new Thread(oneconnection).start();
                
	    }   
	    catch (IOException e) {
		System.out.println(e);
	    }
	}
       
    }
}

class Server2Connection implements Runnable {
    BufferedReader is;
    PrintStream os;
    Socket clientSocket;
    int id;
    Server2 server;
    Connection conn;
    Statement st;
    ResultSet rs;
    private int sleepTime;
    private Random random = new Random();
    Random rastgele = new Random();
    
    public Server2Connection(Socket clientSocket, int id, Server2 server) {
	this.clientSocket = clientSocket;
	this.id = id;
	this.server = server;
       this.sleepTime = random.nextInt(5000);
	System.out.println( "Bağlantı " + id + "ile kurulan: " + clientSocket );
	try {
	    is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	    os = new PrintStream(clientSocket.getOutputStream());
	} catch (IOException e) {
	    System.out.println(e);
	}
    }

    public void run() {
        String line;
	try {
	    boolean serverStop = false;

            while (true) {
                line = is.readLine();
		System.out.println( "Alındı" + line + " bağlantıdan" + id + "." );
                int n = Integer.parseInt(line);
		if ( n == -1 ) {
		    serverStop = true;
		    break;
		}
		if ( n == 0 ) break;
                if( n==1 ){
                    os.println(""+Sorgu1().toString());
                }else if(n==2){
                     os.println(""+Sorgu1().toString()+""+Sorgu2().toString());
                }if(n==3){
                    os.println(""+Sorgu1().toString()+""+Sorgu2().toString()+""+Sorgu3().toString());
                }else if(n==4){
                    os.println(""+Sorgu1().toString()+""+Sorgu2().toString()+""+Sorgu3().toString()+Sorgu4().toString());
                }   
            }
            System.out.println( "Connection " + id + " closed." );
            is.close();
            os.close();
            clientSocket.close();
            System.out.format("Thread number: %d ", Thread.currentThread().getId());
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.format("Thread number: %s Terminated Sleep Time: %s%n",Thread.currentThread().getId(),sleepTime);

	    if ( serverStop ) server.stopServer();
	} catch (IOException e) {
	    System.out.println(e);
	}
        
        try {
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(Server2Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
            os.close();
        try {
            clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server2Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void connect() {
        try
     {
        String host="jdbc:mysql://localhost/filmborsaveritabani";
        String u_name="root";
        String u_password="1234";
        conn=DriverManager.getConnection(host,u_name,u_password);
     }
     catch(SQLException err){
         System.out.println( err.getMessage( ) );
     }
    }
    public ArrayList<String> Sorgu1(){
        ArrayList<String> output=new ArrayList<String>();
        try
        {
        connect();
         st = (Statement) conn.createStatement();
         
        rs=st.executeQuery("select * from filmler");
            
        @SuppressWarnings("unused")
		ResultSetMetaData md=rs.getMetaData();
        while(rs.next())
            {
                for ( int i = 1; i <= 4; i++ )
                     //System.out.printf( "%-8s\t", rs.getObject( i ) );
                    output.add(String.format( "%-8s\t", rs.getObject( i )));
                //System.out.println();
     
            }
    
        }
        catch(Exception ex)
        {
            System.out.println("hata var");   
        }
        return output;
    }
    
    public ArrayList<String> Sorgu2(){
        ArrayList<String> output=new ArrayList<String>();
        Double sondeger=rastgele.nextDouble();
        try
        {
        connect();
        String sorgu="update borsa set SonDeger='"+sondeger+"' where Hisse='Bilmuh'";
         st = (Statement) conn.createStatement();
         
        //rs=st.executeQuery("select * from borsa");
        st.executeUpdate(sorgu);
            
        /*ResultSetMetaData md=rs.getMetaData();
        while(rs.next())
            {
                for ( int i = 1; i <= md.getColumnCount(); i++ )
                     //System.out.printf( "%-8s\t", rs.getObject( i ) );
                    output.add(String.format( "%-8s\t", rs.getObject( i )));
                //System.out.println();
     
            }*/
    
        }
        catch(Exception ex)
        {
            System.out.println(ex);   
        }
        return output;
    }
    
    public ArrayList<String> Sorgu3(){
        ArrayList<String> output=new ArrayList<String>();
        try
        {
        connect();
         st = (Statement) conn.createStatement();
         
        rs=st.executeQuery("select * from filmler where yonetmen = 'Mustafa Akkad'");
            
        @SuppressWarnings("unused")
		ResultSetMetaData md=rs.getMetaData();
        while(rs.next())
            {
                for ( int i = 1; i <= 4; i++ )
                     //System.out.printf( "%-8s\t", rs.getObject( i ) );
                    output.add(String.format( "%-8s\t", rs.getObject( i )));
                //System.out.println();
     
            }
    
        }
        catch(Exception ex)
        {
            System.out.println(ex);   
        }
        return output;
    }
    public ArrayList<String> Sorgu4(){
        ArrayList<String> output=new ArrayList<String>();
        try
        {
        connect();
         st = (Statement) conn.createStatement();
         
        rs=st.executeQuery("select * from borsa where Hisse = 'Bilmuh'");
            
        @SuppressWarnings("unused")
		ResultSetMetaData md=rs.getMetaData();
        while(rs.next())
            {
                for ( int i = 1; i <= 4; i++ )
                     //System.out.printf( "%-8s\t", rs.getObject( i ) );
                    output.add(String.format( "%-8s\t", rs.getObject( i )));
                //System.out.println();
     
            }
    
        }
        catch(Exception ex)
        {
            System.out.println(ex);   
        }
        return output;
    }
}
