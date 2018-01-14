
public class Main {

	private static Provider p;
	private static Consumer c;
	private static Thread t;
	private static Thread t2;
	static Counter counter;
	
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		setP(new Provider());
		setC(new Consumer());
		counter =new Counter();
		t=new Thread(counter.increase());
		t2=new Thread(counter.increase());
		p.setT(t);
		c.setT(t2);
		p.sleeptime=2000;
		c.sleeptime=500;
	}

	/**
	 * @return the p
	 */
	public static Provider getP() {
		return p;
	}

	/**
	 * @param p the p to set
	 */
	public static void setP(Provider p) {
		Main.p = p;
	}

	/**
	 * @return the c
	 */
	public static Consumer getC() {
		return c;
	}

	/**
	 * @param c the c to set
	 */
	public static void setC(Consumer c) {
		Main.c = c;
	}

}
