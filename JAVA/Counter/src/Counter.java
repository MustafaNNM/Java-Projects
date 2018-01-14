
public class Counter implements Runnable {

	int i=0;
	private int count;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		yuz_defa_arttir();
	}

	/**
	 * 
	 */
	synchronized private void yuz_defa_arttir() {
		for(i=0;i<100;i++) {
		
			setCount(getCount() + 1);
		}
	}

	public int getCount() {
		return count;
	}

	 public void setCount(int count) {
		this.count = count;
	}

}
