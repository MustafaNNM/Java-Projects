
public class Paralel_say {

	private static Counter counter;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		setCounter(new Counter());
		for(i=0;i<100;i++) {
			
			new Thread(counter).start();
		} 
		try {//
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(counter.getCount());
	}

	public static Counter getCounter() {
		return counter;
	}

	public static void setCounter(Counter counter) {
		Paralel_say.counter = counter;
	}

}
