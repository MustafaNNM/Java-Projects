package Test_Otopark;

public class Araba_listesi {
	public static String[] renkler = { "K�rm�z�", "Turuncu", "Sar�", "Ye�il",
			"Mavi", "Mor", "Magenta", "Beyaz", "Siyah", "Kahverengi", "Ela",
			"Kristal", "Metalik", "Penbe", "Lacivert", "Gri" };

	public String random_araba() {
		// Rastgele araba �retir
		return renkler[Random.random(renkler.length)];
	}
}
