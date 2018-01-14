package Test_Otopark;

public class Araba {
	private static Araba_listesi türet;
	private static int sayaç = 0;
	private int no;
	private String renk = "";

	public Araba() {
		setTüret(new Araba_listesi());
		setSayaç(getSayaç() + 1);
		setNo(getSayaç());
		setRenk(türet.random_araba());
	}

	public static Araba_listesi getTüret() {
		return türet;
	}

	public static void setTüret(Araba_listesi türet) {
		Araba.türet = türet;
	}

	public String getRenk() {
		return renk;
	}

	public void setRenk(String renk) {
		this.renk = renk;
	}

	public static int getSayaç() {
		return sayaç;
	}

	public static void setSayaç(int sayaç) {
		Araba.sayaç = sayaç;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

}
