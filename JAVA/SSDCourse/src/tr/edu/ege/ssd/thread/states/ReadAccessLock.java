package tr.edu.ege.ssd.thread.states;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAccessLock {

	public static void main(String[] args) throws InterruptedException {
		Count count = new Count();
		Provider provider = new Provider(count);
		Consumer consumer = new Consumer(count);
		Thread p1 = new Thread(provider,"P1");
		Thread c1 = new Thread(consumer,"c1");
		Thread c2 = new Thread(consumer,"c2");
		Thread c3 = new Thread(consumer,"c3");
		p1.start();
		c1.start();
		c2.start();
		c3.start();
	}
}

class Count {
	private int count = 0;
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

	public void setReadWriteLock(ReadWriteLock readWriteLock) {
		this.readWriteLock = readWriteLock;
	}

	public int increase() {
		this.count = count + 1;
		return count;
	}

}

class Provider implements Runnable {
	private Count count;
	private boolean stop = false;

	public Provider(Count count) {
		super();
		this.count = count;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while (!this.isStop()) {
			count.getReadWriteLock().writeLock().lock();
			System.err.println(String.format("\t\t\tThread{%s} locked", Thread.currentThread().getName()));
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			LocalDateTime now = LocalDateTime.now();
			int minute = now.getMinute();
			int second = now.getSecond();
			System.err.println(String.format("Thread{%s} on %d:%d providing %d", Thread.currentThread().getName(),
					minute, second, count.increase()));
			count.getReadWriteLock().writeLock().unlock();
			System.err.println(String.format("\t\t\tThread{%s} unlocked", Thread.currentThread().getName()));
		}
	}
}

class Consumer implements Runnable {
	private Count count;
	private boolean stop = false;

	public Consumer(Count count) {
		super();
		this.count = count;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while (!this.isStop()) {
			LocalDateTime now = LocalDateTime.now();
			int minute = now.getMinute();
			int second = now.getSecond();
			count.getReadWriteLock().readLock().lock();
			System.out.println(String.format("\t\t\tThread{%s} locked", Thread.currentThread().getName()));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(String.format("Thread{%s} on %d:%d consuming %d", Thread.currentThread().getName(),
					minute, second, count.getCount()));
			count.getReadWriteLock().readLock().unlock();
			System.out.println(String.format("\t\t\tThread{%s} unlocked", Thread.currentThread().getName()));
		}
	}
}