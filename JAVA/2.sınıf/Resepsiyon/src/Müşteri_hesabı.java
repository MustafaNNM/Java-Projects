public class M��teri_hesab� {
	private int masa_no, tutar;// M��terinin oturdu�u masa no ve yedi�i yeme�in
								// tutar�

	public M��teri_hesab�() {
		setMasa_no(0);
		setTutar(5 + Random.random(45));// M��terinin �deyece�i tutar
	}

	public int getMasa_no() {
		return masa_no;
	}

	public void setMasa_no(int masa_no) {
		this.masa_no = masa_no;
	}

	public int getTutar() {
		return tutar;
	}

	public void setTutar(int tutar) {
		this.tutar = tutar;
	}

	public String toString() {
		String metin = " ";
		metin += "Masa no:" + masa_no + "Tutar:" + tutar + " Lira";
		return metin;
	}
}
