
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.*;
import java.nio.channels.IllegalBlockingModeException;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("unused")
public class Server {

	private int userCount;
	private List<Socket> activeUsers;
	private boolean stop = false;
	private ServerSocket ss;

	public Server() {

		try {
			ss = new ServerSocket(8080);
		} catch (IOException ex) {
			System.err.println("Hata server socket acilmasinda");
		} catch (Exception ex) {
			System.err.println("Hata server socket acilmasinda");
		}

		userCount = 0;
		activeUsers = new ArrayList<Socket>();

		while (!isStop()) {
			Socket s;
			try {
				s = ss.accept();
				activeUsers.add(s);
				new Thread(new ClientThread(s)).start();
			} catch (IllegalBlockingModeException e) {
				e.printStackTrace();
			} catch (SocketTimeoutException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		try {
			Server server = new Server();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	private class ClientThread implements Runnable {

		private Socket s;
		// private String username;
		private boolean stop = false;

		public ClientThread(Socket s) {
			super();
			try {
				this.s = s;
			}  catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// this.username = username;
		}

		@Override
		public void run() {
			BufferedReader in = null;
			String msg = null;
			try {
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			}  catch (ConnectException e) {
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
			// PrintWriter out = new PrintWriter(s.getOutputStream());

			while (!isStop()) {
				try {
					msg = in.readLine();
					System.out.println("Gelen mesaj:"+msg);
				}  catch (ConnectException e) {
					e.printStackTrace();
				} catch (SocketException e) {
					System.err.println("baðlantý kesildi");
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
					broadcast(msg);
				} else {
				}
				/*
				 * if (msg.equals("LOGOUT")) { setStop(true);
				 * activeUsers.remove(s); //s.close(); }
				 */
			}
		}

		public void broadcast(String msg) {
			PrintWriter out=null;
			for (Socket s : activeUsers) {
				if (s != this.s) {
					try {
						out = new PrintWriter(s.getOutputStream());
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
						out.println(msg);
					} catch (Exception ex) {
						System.err.println("Hata server broadcast ta");
					}
				}
			}
		}

		public boolean isStop() {
			return stop;
		}

		public void setStop(boolean stop) {
			this.stop = stop;
		}
	}
}
