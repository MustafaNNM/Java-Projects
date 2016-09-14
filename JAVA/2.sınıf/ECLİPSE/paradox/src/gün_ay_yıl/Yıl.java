package g�n_ay_y�l;

import java.util.Vector;

public class Y�l extends Metot {

	private Vector<Vector<Integer>> aylar = new Vector<Vector<Integer>>();// Elemanlar�
																			// vekt�rlerden
																			// olu�an
																			// bir
																			// vekt�r
																			// tasarl�yoruz

	// Y�l olu�turuluyor
	public Y�l() {
		setAylar(matris(12, 31));// 12x31 lik vekt�rlerden olu�an veri yap�s�
		// olu�turuluyor
		g�n_ayar�();// Her Ay�n g�n say�s� ayn� olmad��� i�in boyutlarda
					// d�zenlemeye gidiliyor.
		reset();// veriler s�f�rlan�yor
	}

	// Boyutlarda
	// d�zenlemeye gidiliyor.
	public void g�n_ayar�() {
		remove(1, 30);
		remove(1, 29);
		remove(1, 28);
		remove(3, 30);
		remove(5, 30);
		remove(8, 30);
		remove(10, 30);
	}

	public void remove(int ay, int g�n) {
		aylar.elementAt(ay).removeElementAt(g�n);
	}

	// Veriler 0'a e�itleniyor
	public void reset() {
		int ay, g�n;
		for (ay = 0; ay < aylar.size(); ay++) {
			for (g�n = 0; g�n < aylar.elementAt(ay).size(); g�n++) {
				aylar.elementAt(ay).set(g�n, 0);// Sadece ilk kullan�m i�in
												// ilkleme yap�l�yor
			}
		}
	}

	public Vector<Vector<Integer>> getAylar() {
		return aylar;
	}

	public void setAylar(Vector<Vector<Integer>> y�l) {
		this.aylar = y�l;
	}

	public String toString() {
		String metin = "";
		int ay, g�n;
		for (ay = 0; ay < aylar.size(); ay++) {
			for (g�n = 0; g�n < aylar.elementAt(ay).size(); g�n++) {
				metin += " " + aylar.elementAt(ay).elementAt(g�n);
			}
			metin += "\n";
		}
		return metin;
	}
}
