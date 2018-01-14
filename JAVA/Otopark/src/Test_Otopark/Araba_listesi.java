package Test_Otopark;

public class Araba_listesi {
	public static String[] renkler = { "Kırmızı", "Turuncu", "Sarı", "Yeşil",
			"Mavi", "Mor", "Magenta", "Beyaz", "Siyah", "Kahverengi", "Ela",
			"Kristal", "Metalik", "Penbe", "Lacivert", "Gri" };

	public String random_araba() {
		// Rastgele araba üretir
		return renkler[Random.random(renkler.length)];
	}
}
