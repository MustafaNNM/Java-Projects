package gün_ay_yýl;

import java.util.Vector;

public class Ýstatistik {
	private Vector<Vector<Integer>> veriler;// Yaþýt kiþilerin sayýsýný gösteren
											// matris
	private Vector<Integer> verilerin_toplamý;// Dört türdeki (5,10,100 ve 250)
	// deneylerin sonuçlarýný
	// çakýþmalara göre toplamak
	// için
	private Yýl matris;
	private static Vector<Integer> kiþi_sayýsý;// Kiþi miktarlarýný tutan vektör

	public Ýstatistik() {
		// Dört türdeki (5,10,100 ve 250) deneylerin sonuçlarýný hesaplamak için
		setVeriler(Metot.matris(4, 10));// her deneyi kendi içerisinde toplamak
		// için
		setMatris(new Yýl());
		setVerilerin_toplamý(new Vector<Integer>());
		getVerilerin_toplamý().setSize(getVeriler().size());// her deney
															// gruplarýný kendi
		// içerisinde toplamak için
		ayarlar();
		reset();
	}

	private static void ayarlar() {
		// Deneylerde kullanýlmasý istenen kiþi miktarlarý ayarlanýyor
		setKiþi_sayýsý(new Vector<Integer>());
		getKiþi_sayýsý().setSize(4);
		getKiþi_sayýsý().set(0, 5);
		getKiþi_sayýsý().set(1, 10);
		getKiþi_sayýsý().set(2, 100);
		getKiþi_sayýsý().set(3, 250);
	}

	public Vector<Vector<Integer>> getVeriler() {
		return veriler;
	}

	public void setVeriler(Vector<Vector<Integer>> veriler) {
		this.veriler = veriler;
	}

	// Verilerin deðeri 0'a eþitleniyor
	public void reset() {
		int i, j;
		for (i = 0; i < veriler.size(); i++) {
			for (j = 0; j < veriler.elementAt(i).size(); j++) {
				veriler.elementAt(i).set(j, 0);
			}
		}
	}

	public int hesapla(int deney_türü, int deney_no) {
		// Çakýþmalar sayýlýyor
		int i, j, toplam = 0;
		for (i = 0; i < matris.getAylar().size(); i++) {
			for (j = 0; j < matris.getAylar().elementAt(i).size(); j++) {
				if (1 < matris.getAylar().elementAt(i).elementAt(j)) {
					toplam += matris.getAylar().elementAt(i).elementAt(j);
				}
			}
		}
		getVeriler().elementAt(deney_türü).set(deney_no, toplam);// Her deney
		// gruplarýný
		// kendi
		// içerisinde
		// toplamak
		// için
		return toplam;
	}

	// her deney gruplarýný kendi içerisinde topluyor
	public void toplamlarý_hesapla() {
		int i, j, toplam;
		for (i = 0; i < getVeriler().size(); i++) {
			toplam = 0;
			for (j = 0; j < getVeriler().elementAt(i).size(); j++) {
				toplam += getVeriler().elementAt(i).elementAt(j);
			}
			getVerilerin_toplamý().set(i, toplam);
		}
	}

	public String verilerin_ortalamasý_toString() {
		System.out.println("Kiþi_sayýsý Ortalamalar");
		for (int i = 0; i < getVerilerin_toplamý().size(); i++) {
			System.out.printf("%-10d:%7.2f\n", getKiþi_sayýsý().elementAt(i),
					(float) getVerilerin_toplamý().elementAt(i) / 10);
		}
		return null;
	}

	public String toString() {
		int i, j;
		System.out.printf("Ýstatistik Kiþi_sayýsý\nDeney_no");
		for (i = 0; i < getKiþi_sayýsý().size(); i++) {
			System.out.printf("%8d", getKiþi_sayýsý().elementAt(i));
		}
		System.out.flush();
		System.out.println();
		for (i = 0; i < veriler.elementAt(0).size(); i++) {
			System.out.printf("%-8d", i + 1);
			for (j = 0; j < veriler.size(); j++) {
				System.out.printf("%8d", veriler.elementAt(j).elementAt(i));
			}
			System.out.flush();
			System.out.println();
		}
		return null;
	}

	public Yýl getMatris() {
		return matris;
	}

	public void setMatris(Yýl matris) {
		this.matris = matris;
	}

	protected static Vector<Integer> getKiþi_sayýsý() {
		return kiþi_sayýsý;
	}

	protected static void setKiþi_sayýsý(final Vector<Integer> kiþi_sayýsý) {
		Ýstatistik.kiþi_sayýsý = kiþi_sayýsý;
	}

	private Vector<Integer> getVerilerin_toplamý() {
		return verilerin_toplamý;
	}

	private void setVerilerin_toplamý(Vector<Integer> verilerin_toplamý) {
		this.verilerin_toplamý = verilerin_toplamý;
	}
}
