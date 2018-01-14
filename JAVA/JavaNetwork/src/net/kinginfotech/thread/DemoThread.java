package net.kinginfotech.thread;

public class DemoThread {

	public static void main(String[] args) {
		while(true){	
		
		Thread t1 = new Thread(new MyThread("thread1"));
		Thread t2 = new Thread(new MyThread("thread2"));
		Thread t3 = new Thread(new MyThread("thread3"));
		Thread t4 = new Thread(new MyThread("thread4"));
		Thread t5 = new Thread(new MyThread("thread5"));
		
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t5.start();
		}
		

	}

}
