
public class Renkler {
	private static String[] renkler=new String[] { "yavru a�z�", "cam g�be�i", "van dyke kahverengisi",
			"hint sar�s�", "alizarin k�rm�z�s�", "kadmiyum sar�s�",
			"gece yar�s� siyah�", "prusya mavisi", "titanyum beyaz�",
			"koyu siena" };

	public Renkler(String[] renkler) {
		this.setRenkler(renkler);
	}

	/**
	 * @return the renkler
	 */
	public static String[] getRenkler() {
		return renkler;
	}

	/**
	 * @param renkler the renkler to set
	 */
	public void setRenkler(String[] renkler) {
		Renkler.renkler = renkler;
	}

	public static String random_renk() {
		// TODO Auto-generated method stub
		return renkler[(int) (Math.random() * renkler.length)];
	}
}