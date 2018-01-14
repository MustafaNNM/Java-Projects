package tr.edu.ege.ssd.thread.states;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleLockTest {

	public SimpleLockTest() {
		super();
		Count count = new Count();
		Provider provider = new Provider(count);
		Consumer consumer = new Consumer(count);
		Thread p1 = new Thread(provider, "p1");
		Thread c1 = new Thread(consumer, "c1");
		Thread c2 = new Thread(consumer, "c2");
		Thread c3 = new Thread(consumer, "c3");
		p1.start();
		c1.start();
		c2.start();
		c3.start();
	}

	public static void main(String[] args) throws InterruptedException {
		new SimpleLockTest();
	}

	class Count {
		private int count = 0;
		private Lock lock = new ReentrantLock();

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public Lock getLock() {
			return lock;
		}

		public void setReadWriteLock(Lock lock) {
			this.lock = lock;
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

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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
				count.getLock().lock();
				System.out.println(String.format("\t\t\t Thread{%s} locked", Thread.currentThread().getName()));				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(String.format("Thread{%s} on %d:%d consuming %d", Thread.currentThread().getName(),
						minute, second, count.getCount()));
				count.getLock().unlock();
				System.out.println(String.format("\t\t\t Thread{%s} unlocked", Thread.currentThread().getName()));
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}