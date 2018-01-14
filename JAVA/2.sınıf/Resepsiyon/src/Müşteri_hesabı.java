public class Müþteri_hesabý {
	private int masa_no, tutar;// Müþterinin oturduðu masa no ve yediði yemeðin
								// tutarý

	public Müþteri_hesabý() {
		setMasa_no(0);
		setTutar(5 + Random.random(45));// Müþterinin ödeyeceði tutar
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
