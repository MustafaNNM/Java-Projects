public class Balon {
	public int no;
	private String renk;
	public Balon sonraki;

	public Balon(int no) {
		this.no = no;
		String str[] = { "yavru a�z�", "cam g�be�i", "van dyke kahverengisi",
				"hint sar�s�", "alizarin k�rm�z�s�", "kadmiyum sar�s�",
				"gece yar�s� siyah�", "prusya mavisi", "titanyum beyaz�",
				"koyu siena" };
		this.renk = str[(int) (Math.random() * str.length)];
	}

	public void yazdir() {
		System.out.println("Balonun numaras�:" + no + "\t" + "Balonun rengi:"
				+ renk);
	}
}