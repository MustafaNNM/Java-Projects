package gün_ay_yýl;

import java.util.Vector;

public class Ýstatistikler {
	private static Vector<Ýstatistik> raporlar;// Elemanlarý birer
												// rapor(Ýstatistik nesnesi)
												// olan vektör

	public Ýstatistikler(int kaç_rapor) {
		// Raporlarýn miktarý belirleniyor
		int i;
		raporlar = new Vector<Ýstatistik>();// Bellekten yer ayrýlýyor
		raporlar.setSize(kaç_rapor);// Vektörün boyutu ayarlanýyor
		for (i = 0; i < raporlar.size(); i++) {
			raporlar.set(i, new Ýstatistik());// Bellekten yer ayrýlýyor
		}
	}

	public Vector<Ýstatistik> getRaporlar() {
		return raporlar;
	}

	public static void setRaporlar(Vector<Ýstatistik> raporlar) {
		Ýstatistikler.raporlar = raporlar;
	}

	public String verilerin_ortalamasý_toString() {
		int i, yýl = 1990;
		for (i = 0; i < raporlar.size(); i++) {
			System.out.println("\n" + (yýl + i)
					+ " Doðumlu olanlarýn çakýþma listesi\n");
			raporlar.elementAt(i).verilerin_ortalamasý_toString();
			System.out.println();
		}
		return null;
	}

	public String toString() {
		int i, yýl = 1990;
		for (i = 0; i < raporlar.size(); i++) {
			System.out.println("\n" + (yýl + i)
					+ " Doðumlu olanlarýn istatistik verileri\n");
			raporlar.elementAt(i).toString();
			System.out.println();
		}
		return null;
	}
}
