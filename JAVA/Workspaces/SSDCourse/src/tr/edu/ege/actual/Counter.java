package tr.edu.ege.actual;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Counter {
	
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	private int count = 0;
	
	public ReentrantReadWriteLock getReentrantLock() {
		return lock;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int increase() {
		this.count = this.count + 1;
		return this.count;
	}

	public static String writeTouchTime() {
		LocalDateTime now = LocalDateTime.now();
		return String.format("%d:%d", now.getMinute(), now.getSecond());
	}

	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		Thread p1 = new Thread(new Provider(counter), "P1");
		Thread c1 = new Thread(new Consumer(counter), "C1");
		Thread c2 = new Thread(new Consumer(counter), "C2");
		Thread c3 = new Thread(new Consumer(counter), "C3");

		p1.start();
		c1.start();
		c2.start();
		c3.start();

	}
}

class Provider implements Runnable {

	private Counter counter;
	private boolean stop = false;

	public Provider(Counter count) {
		super();
		this.counter = count;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void run() {
		while (!isStop()) {
			counter.getReentrantLock().writeLock().lock();
			System.out.println(String.format("%s Provider %s is locked", Counter.writeTouchTime(),
					Thread.currentThread().getName()));
				try {
					Thread.sleep(2050);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.counter.increase();
				System.err.println(String.format("%s Provider %s is touched on count: %d", Counter.writeTouchTime(),
						Thread.currentThread().getName(), this.counter.getCount()));
				counter.getReentrantLock().writeLock().unlock();
			System.out.println(String.format("%s Provider %s is unlocked", Counter.writeTouchTime(),
					Thread.currentThread().getName()));
		}
	}
}

class Consumer implements Runnable {
	private Counter counter;
	private boolean stop = false;

	public Consumer(Counter counter) {
		super();
		this.counter = counter;
	}

	public Consumer(boolean stop) {
		super();
		this.stop = stop;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while (!isStop()) {
				counter.getReentrantLock().readLock().lock();
				System.out.println(String.format("%s Consumer %s is locked", Counter.writeTouchTime(),
						Thread.currentThread().getName()));
				try {
					Thread.sleep(250);
					System.out.println(String.format("%s Consumer %s is touched on count: %d", Counter.writeTouchTime(),
							Thread.currentThread().getName(), this.counter.getCount()));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				counter.getReentrantLock().readLock().unlock();
				System.out.println(String.format("%s Consumer %s is unlocked", Counter.writeTouchTime(),
						Thread.currentThread().getName()));
		}
	}
}