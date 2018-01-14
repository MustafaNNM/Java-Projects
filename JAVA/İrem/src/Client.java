
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

//http://www.javaworld.com/article/2076864/java-concurrency/building-an-internet-chat-system.html#ChatClientChatClient
@SuppressWarnings("unused")
public class Client {

	private boolean stop = false;
	private Socket s;
	private BufferedReader line;
	private PrintWriter out;

	public Client() {

		try {
			s = new Socket("localhost", 8080);
		} catch (ConnectException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			line = new BufferedReader(new InputStreamReader(System.in));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			out = new PrintWriter(s.getOutputStream(), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			new Thread(new listenServer(s)).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			while (!isStop()) {
				System.out.println("Göndermek istediðiniz mesajý giriniz:");
				String msg = line.readLine();
				if (msg != null) {
					try {
						out.println(msg);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				/*
				 * if (msg.equals("LOGOUT")) { setStop(true); }
				 */
			}
		} catch (IOException ex) {
			System.err.println("Hata client constructor");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Client();
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	private class listenServer implements Runnable {

		private Socket s;
		private boolean stop = false;

		public boolean isStop() {
			return stop;
		}

		public void setStop(boolean stop) {
			this.stop = stop;
		}

		public listenServer(Socket s) {
			super();
			this.s = s;
		}

		/*
		 * public String tokenizer(String msg) { String[] tokens =
		 * msg.split(":"); return tokens[1]; }
		 */
		public void run() {
			BufferedReader in = null;
			String msg = null;
			try {
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			while (!isStop()) {
				try {
					msg = in.readLine();
				} catch (ConnectException e) {
					e.printStackTrace();
				} catch (SocketException e) {
					e.printStackTrace();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (msg != null) {
					System.out.println("Yeni mesaj:" + msg);
				} else {

				}

			}

		}

	}
}
