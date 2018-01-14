package clientside;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.IllegalBlockingModeException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Client extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText=null;
	private JTextArea chatWindow=null;
	private ObjectOutputStream output=null;
	private ObjectInputStream input=null;
	private String message="";
	private String serverIP="";
	private Socket connection=null;
	
	public Client(String host){
		super("Client Side Chat");
		serverIP = host;
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent event){
					sendMessage(event.getActionCommand());
					userText.setText("");
				}
			}		
		);	
		add(userText, BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow),BorderLayout.CENTER);
		setSize(300,150);
		setVisible(true);
	}
	  //connect server
	
	public void startRunning(){
		try { 
		try {
			connectToServer();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("bir yerde hata var IO");
			e1.printStackTrace();
		}
		try {
			setupStreams();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("bir yerde hata var IO2");
			e1.printStackTrace();
		}
		try {
			whileChatting();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("bir yerde hata var IO3");
			e1.printStackTrace();
		}
		}catch(NullPointerException e)
		{System.out.println("bir yerde nullllll hata var final öncesi");
			e.printStackTrace();
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("bir yerde hata var final öncesi");
			e1.printStackTrace();
		}
		finally{
			System.out.println("bir yerde hata var 4");
			try {
				closeCrap();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("burada kesin hata var");
				e.printStackTrace();
			}
		}
		
		
	}
	
	//connect to server
	private void connectToServer() throws UnknownHostException, IOException{
		
		showMessage("Attempting connection...\n");
		
		try {
			connection = new Socket(serverIP,6789);
		} catch(UnknownHostException e){
			showMessage("Bilinmeyen baðlantý hatasý\n");
			e.printStackTrace();
		}
		catch (ConnectException e1) {
			// TODO Auto-generated catch block
			System.out.println("bir yerde hata var connect 5");
			e1.printStackTrace();
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("bir yerde hata var IO 6");
			e1.printStackTrace();
		}catch(SecurityException e)
		{
			e.printStackTrace();
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}catch(IllegalBlockingModeException e)
		{
			e.printStackTrace();
		}catch(Exception e)
		{
			System.out.println("bir yerde baðlantý soket hatasý var");
			e.printStackTrace();
		}
		InetAddress inetAddress = null;
		try {
			inetAddress = connection.getInetAddress();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
		if(inetAddress!=null) {
			showMessage("Attempting connected to "+ inetAddress);
		}
		else {
			showMessage("Baðlantý baþarýsýz!");
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block		
			e.printStackTrace();
		}	
	}
	
	//set up stream to send and receive messages
	private void setupStreams() throws IOException{
		OutputStream outputStream = null;
		try {
			outputStream = connection.getOutputStream();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			
			output = new ObjectOutputStream(outputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			output.flush();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		InputStream inputStream = null;
		try {
			inputStream = connection.getInputStream();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			
			input = new ObjectInputStream(inputStream);
		} catch (IOException e) {
			showMessage("burada hata var ama anlamadým");	
			e.printStackTrace();
		}
		showMessage("Your Stream are now good\n");	
	}
	//thread
	//while chatting with server
	private void whileChatting() throws IOException {
		ableToType(true);
		do{
			try{
				message = (String) input.readObject();
				showMessage("\n"+ message);
				
			}catch(ClassNotFoundException e){
				showMessage("I dont know that object type\n");
			}
		}while(!message.equals("SERVER-END"));
		
	}
	
//send message to server
	private void sendMessage(String message){
		try{
			output.writeObject("CLIENT-" + message);
			output.flush();
			showMessage("CLIENT -"+message);
		}catch(IOException e){
		chatWindow.append("\n Something messed up sending message hoss!");
	      }
	}

//show Message 
private void showMessage(final String m){
	SwingUtilities.invokeLater(
			new Runnable(){
					public void run(){
						chatWindow.append(m);
			  }
			}
		);
}

//let user type stuff into their box
	private void ableToType(final boolean tof){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						userText.setEditable(tof);
					}
				}
			);
		
	}	
	
//close stream and socket after you are done chatting
	private void closeCrap() {
			showMessage("\n Closing connections... \n");
			ableToType(false);
			try {
				output.close();
			} catch (IOException e1) {
				showMessage("output kapatýlamýyor");
				e1.printStackTrace();
			}
			
			try {
				input.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				showMessage("input kapatýlamýyor");
				e1.printStackTrace();
			}
			try{
				connection.close();
			}catch(IOException e){
				showMessage("baðlantý kapatýlamýyor");
				e.printStackTrace();
			}
		}

	

}
