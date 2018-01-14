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

public class Client2 {
    public static void main(String[] args) throws IOException {
	
	String hostname = "localhost";
	int port = 6789;

	// declaration section:
	// clientSocket: our client socket
	// os: output stream
	// is: input stream
	
        Socket clientSocket = null;  
        DataOutputStream os = null;
        BufferedReader is = null;
	
	// Initialization section:
	// Try to open a socket on the given port
	// Try to open input and output streams
	
        try {
            clientSocket = new Socket(hostname, port);
            os = new DataOutputStream(clientSocket.getOutputStream());
            is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Host bilinmiyor: " + hostname);
        } catch (IOException e) {
            System.err.println("bağlantı için I / O alınamadı.: " + hostname);
        }
	
	// If everything has been initialized then we want to write some data
	// to the socket we have opened a connection to on the given port
	
	if (clientSocket == null || os == null || is == null) {
	    System.err.println( "Bazıları hatalı, null gönderilen değişken var" );
	    return;
	}

	try {
	  while ( true ) {
		System.out.print( "Kullanıcı numarasını gir(Bağlantıyı durdurmak için 0, server'ı durdurmak -1): " );
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String keyboardInput = br.readLine();
		os.writeBytes(keyboardInput + "\n" );
               

		int n = Integer.parseInt( keyboardInput );
		if ( n == 0 || n == -1 ) {
		    break;
                }
                String responseLine = is.readLine();
		System.out.println("Sonuçlar:" + responseLine);
		  
	   }
	    
	    // clean up:
	    // close the output stream
	    // close the input stream
	    // close the socket
	   
	 os.close();
	 is.close();        
         clientSocket.close(); 
	} catch (UnknownHostException e) {
	    System.err.println("Bilinmeyen host a bağlantı kurmaya çalışıyor: " + e);
	} catch (IOException e) {
	    System.err.println("IOException:  " + e);
	}
          
    }           
}

