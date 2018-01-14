
public class Counter {

	private int count;

	public int getCount() {
		return count;
	}

	 public void setCount(int count) {
		this.count = count;
	}

	public Runnable  increase() {
		// TODO Auto-generated method stub
		count++;
		return null;
	}

}
