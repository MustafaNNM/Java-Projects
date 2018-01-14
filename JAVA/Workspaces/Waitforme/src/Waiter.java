

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author MehmetAkif-PC
 *
 */
public class Waiter implements Runnable {
	private Object lock = new Object();
	// private Lock lock;

	/**
	 * @return the lock
	 */
	public Object getLock() {
		return lock;
	}

	/**
	 * @param lock the lock to set
	 */
	public void setLock(Object lock) {
		this.lock = lock;
	}

	public Waiter() {
		System.out.println("Waiter oluþturuluyor");
		lock = new ReentrantLock();
	}

	/**
	 * @return the lock
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public synchronized void run() {
		System.out.println("Waiter çalýþtýrýlýyor");
		synchronized (lock) {
			try {
				lock.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("IllegalThreadStateException !");
				e.printStackTrace();
			} // yazýlým kapatýlacaðý zaman unlock() yapýlmasý gerekiyor

		}
	}
}
