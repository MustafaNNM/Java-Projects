import java.net.Socket;

class Handler implements Runnable {
	private final Socket socket;

	Handler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		System.out.println("merhaba client ben server paralel calisiyor");
	}

	/**
	 * @return the socket
	 */
	public Socket getSocket() {
		return socket;
	}
}
