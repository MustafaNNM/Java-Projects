package g�n_ay_y�l;

import java.util.Vector;

public class �statistikler {
	private static Vector<�statistik> raporlar;// Elemanlar� birer
												// rapor(�statistik nesnesi)
												// olan vekt�r

	public �statistikler(int ka�_rapor) {
		// Raporlar�n miktar� belirleniyor
		int i;
		raporlar = new Vector<�statistik>();// Bellekten yer ayr�l�yor
		raporlar.setSize(ka�_rapor);// Vekt�r�n boyutu ayarlan�yor
		for (i = 0; i < raporlar.size(); i++) {
			raporlar.set(i, new �statistik());// Bellekten yer ayr�l�yor
		}
	}

	public Vector<�statistik> getRaporlar() {
		return raporlar;
	}

	public static void setRaporlar(Vector<�statistik> raporlar) {
		�statistikler.raporlar = raporlar;
	}

	public String verilerin_ortalamas�_toString() {
		int i, y�l = 1990;
		for (i = 0; i < raporlar.size(); i++) {
			System.out.println("\n" + (y�l + i)
					+ " Do�umlu olanlar�n �ak��ma listesi\n");
			raporlar.elementAt(i).verilerin_ortalamas�_toString();
			System.out.println();
		}
		return null;
	}

	public String toString() {
		int i, y�l = 1990;
		for (i = 0; i < raporlar.size(); i++) {
			System.out.println("\n" + (y�l + i)
					+ " Do�umlu olanlar�n istatistik verileri\n");
			raporlar.elementAt(i).toString();
			System.out.println();
		}
		return null;
	}
}
