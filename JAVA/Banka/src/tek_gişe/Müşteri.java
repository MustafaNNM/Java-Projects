package tek_giþe;

public class Müþteri {
	private int no;
	private int giþe_no;
	private int süre;
	private static int sayaç = 0;

	public Müþteri() {
		setSüre(10 + Random.random(991));// 10-1000 arasýnda
		// random bir
		// sayý(süre[sn cinsinden])
		// üretiliyor
		setNo(getSayaç());
		setSayaç(getSayaç() + 1);
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getGiþe_no() {
		return giþe_no;
	}

	public void setGiþe_no(int giþe_no) {
		this.giþe_no = giþe_no;
	}

	public static int getSayaç() {
		return sayaç;
	}

	public static void setSayaç(int sayaç) {
		Müþteri.sayaç = sayaç;
	}

	public int getSüre() {
		return süre;
	}

	public void setSüre(int süre) {
		this.süre = süre;
	}
}
