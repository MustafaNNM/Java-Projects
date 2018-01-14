package ChatApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Server extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText;
	private JTextArea chatWindow;
	
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private ServerSocket server;
	private Socket connection;
	
	//user interface is initilized first on constractor
	public Server(){
		super("Server Side Chat");
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
		  new ActionListener(){
			 public void actionPerformed(ActionEvent event){
				 sendMessage(event.getActionCommand());
				 userText.setText("");
			}
		});
		add(userText, BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow));
		setSize(300,150);
		setVisible(true);	
	}
	
	//set up and run server
	
	public void startRunning(){
		try{
			server = new ServerSocket(6789,100);
			while(true){
				try{
					waitForConnection();
					setupStreams();
					whileChatting();
				}catch(EOFException eofException){
					showMessage("\n Server ended the connection! ");
				}finally{
					closeCrap();
				}
				
			}
		}catch(IOException e){}
	}
  
	//wait for connection, then display connection information
	private void waitForConnection()  throws IOException{
		showMessage("Wait for someone to connect...");
		connection = server.accept();
		showMessage("Wait for someone to connecte to "+connection.getInetAddress().getHostName());
		
	}
	//get Stream to send and receive data
	 private void setupStreams() throws IOException{
			output = new ObjectOutputStream(connection.getOutputStream());
			output.flush();
			input = new ObjectInputStream(connection.getInputStream());
			showMessage("\n Streams are now setup!\n");
		}
	//during the chat conversation
	 private void whileChatting() throws IOException{
		String message ="Your are now connected ";
		sendMessage(message);
		ableToType(true);
		do{
		  try{
			  message = (String)input.readObject();
			  showMessage("\n"+ message);
		  }catch(ClassNotFoundException classNotFoundException){
			  showMessage("\n i dont know what you sent");
		  }
		}while(!message.equals("CLIENT - END"));
			
	}
	 //close stream and socket after you are done chatting
		private void closeCrap() {
			showMessage("\n Closing connections... \n");
			ableToType(false);
			try{
				output.close();
				input.close();
				connection.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
     //send a message to client
		private void sendMessage(String message){
			try{
				output.writeObject("SERVER-"+message);
				output.flush();
				showMessage("\nSERVER -"+ message);
			}catch(IOException e){
				chatWindow.append("\n ERROE: I cant send that message");
			}
		}
	//update chatWindow
		private void showMessage(final String text){
			SwingUtilities.invokeLater(
					new Runnable(){
						public void run(){
							chatWindow.append(text);
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
		

	

}
