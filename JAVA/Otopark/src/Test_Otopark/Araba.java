package Test_Otopark;

public class Araba {
	private static Araba_listesi t�ret;
	private static int saya� = 0;
	private int no;
	private String renk = "";

	public Araba() {
		setT�ret(new Araba_listesi());
		setSaya�(getSaya�() + 1);
		setNo(getSaya�());
		setRenk(t�ret.random_araba());
	}

	public static Araba_listesi getT�ret() {
		return t�ret;
	}

	public static void setT�ret(Araba_listesi t�ret) {
		Araba.t�ret = t�ret;
	}

	public String getRenk() {
		return renk;
	}

	public void setRenk(String renk) {
		this.renk = renk;
	}

	public static int getSaya�() {
		return saya�;
	}

	public static void setSaya�(int saya�) {
		Araba.saya� = saya�;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

}
