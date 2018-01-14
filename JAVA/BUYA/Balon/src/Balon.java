public class Balon {
		private String renk;
	private Balon sonraki;

	public Balon(int no) {
		this.no = no;
		this.renk = Renkler.random_renk();
	}


	/**
	 * @return the sonraki
	 */
	public Balon getSonraki() {
		return sonraki;
	}

	/**
	 * @param sonraki the sonraki to set
	 */
	public void setSonraki(Balon sonraki) {
		this.sonraki = sonraki;
	}
	private int no;
	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}

	/**
	 * @return the renk
	 */
	public String getRenk() {
		return renk;
	}

	/**
	 * @param renk the renk to set
	 */
	public void setRenk(String renk) {
		this.renk = renk;
	}

	public String toString() {
		return "Balonun numarasý:" + no + "\t" + "Balonun rengi:"+ renk;
	}

}