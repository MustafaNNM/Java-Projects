package tr.edu.ege.actual;

public class MyCounter implements Runnable {

	int count = 0;
	private boolean stop = false;

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while (!isStop()) {
			System.out.println(String.format("Thread %s Counted %d", Thread.currentThread().getName(), count++));
			try {
				if (count == 10) {
					this.setStop(true);
				}
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyCounter target = new MyCounter();
		Thread t = new Thread(target, "t1");
		t.start();
		t.join();
		System.out.println("Bitti");
	}
}
