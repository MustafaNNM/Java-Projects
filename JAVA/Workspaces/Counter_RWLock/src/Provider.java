/**
 * 
 */

/**
 * @author MehmetAkif-PC
 *
 */
public class Provider implements Runnable {

	private Thread t;
	public int sleeptime;


	/**
	 * 
	 */
	public Provider() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while(true) {
			try {
				t.sleep(sleeptime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @return the t
	 */
	public Thread getT() {
		return t;
	}

	/**
	 * @param t the t to set
	 */
	public void setT(Thread t) {
		this.t = t;
	}

}
