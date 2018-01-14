package gün_ay_yýl;

import java.util.Vector;

public class Yýl extends Metot {

	private Vector<Vector<Integer>> aylar = new Vector<Vector<Integer>>();// Elemanlarý
																			// vektörlerden
																			// oluþan
																			// bir
																			// vektör
																			// tasarlýyoruz

	// Yýl oluþturuluyor
	public Yýl() {
		setAylar(matris(12, 31));// 12x31 lik vektörlerden oluþan veri yapýsý
		// oluþturuluyor
		gün_ayarý();// Her Ayýn gün sayýsý ayný olmadýðý için boyutlarda
					// düzenlemeye gidiliyor.
		reset();// veriler sýfýrlanýyor
	}

	// Boyutlarda
	// düzenlemeye gidiliyor.
	public void gün_ayarý() {
		remove(1, 30);
		remove(1, 29);
		remove(1, 28);
		remove(3, 30);
		remove(5, 30);
		remove(8, 30);
		remove(10, 30);
	}

	public void remove(int ay, int gün) {
		aylar.elementAt(ay).removeElementAt(gün);
	}

	// Veriler 0'a eþitleniyor
	public void reset() {
		int ay, gün;
		for (ay = 0; ay < aylar.size(); ay++) {
			for (gün = 0; gün < aylar.elementAt(ay).size(); gün++) {
				aylar.elementAt(ay).set(gün, 0);// Sadece ilk kullaným için
												// ilkleme yapýlýyor
			}
		}
	}

	public Vector<Vector<Integer>> getAylar() {
		return aylar;
	}

	public void setAylar(Vector<Vector<Integer>> yýl) {
		this.aylar = yýl;
	}

	public String toString() {
		String metin = "";
		int ay, gün;
		for (ay = 0; ay < aylar.size(); ay++) {
			for (gün = 0; gün < aylar.elementAt(ay).size(); gün++) {
				metin += " " + aylar.elementAt(ay).elementAt(gün);
			}
			metin += "\n";
		}
		return metin;
	}
}
