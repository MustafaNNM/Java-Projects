package tr.edu.ege.ssd.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class TCPServer {
	private static final int PORT = 8080;
	private final static Logger mylogger = Logger.getLogger(TCPServer.class.getName());
	
	ServerSocket welcomeSocket;

	public TCPServer() {				
		try {
			welcomeSocket = new ServerSocket(PORT);		
			handleMessages();
		} catch (Exception e) {
			mylogger.severe(String.format("Cannot start server on %d",PORT));
			e.printStackTrace();
		}
	}

	public void handleMessages() throws Exception {
		String clientSentence;
		String capitalizedSentence;

		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			mylogger.info(String.format("Received %s",clientSentence));			
			capitalizedSentence = clientSentence.toUpperCase() + '\n';
			outToClient.writeBytes(capitalizedSentence);
			outToClient.flush();
			connectionSocket.close();
		}
	}

	public static void main(String argv[]) {
		new TCPServer();
	}

}