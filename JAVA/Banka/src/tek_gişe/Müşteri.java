package tek_gi�e;

public class M��teri {
	private int no;
	private int gi�e_no;
	private int s�re;
	private static int saya� = 0;

	public M��teri() {
		setS�re(10 + Random.random(991));// 10-1000 aras�nda
		// random bir
		// say�(s�re[sn cinsinden])
		// �retiliyor
		setNo(getSaya�());
		setSaya�(getSaya�() + 1);
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getGi�e_no() {
		return gi�e_no;
	}

	public void setGi�e_no(int gi�e_no) {
		this.gi�e_no = gi�e_no;
	}

	public static int getSaya�() {
		return saya�;
	}

	public static void setSaya�(int saya�) {
		M��teri.saya� = saya�;
	}

	public int getS�re() {
		return s�re;
	}

	public void setS�re(int s�re) {
		this.s�re = s�re;
	}
}
