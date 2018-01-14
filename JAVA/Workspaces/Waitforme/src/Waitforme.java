
public class Waitforme implements Runnable {
	private Object lock = new Object();
	private static Waitforme w;
	private static Thread async_client;

	public static void main(String[] args) {
		setW(new Waitforme());
		async_client = new Thread(w);
		async_client.start();
	}

	/**
	 * @return the lock
	 */
	public Object getLock() {
		return lock;
	}

	/**
	 * @param lock
	 *            the lock to set
	 */
	public void setLock(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * @return the w
	 */
	public static Waitforme getW() {
		return w;
	}

	/**
	 * @param w
	 *            the w to set
	 */
	public static void setW(Waitforme w) {
		Waitforme.w = w;
	}

}
