package tek_giþe;

import java.util.Vector;

public class Ýstatistikler {
	private Vector<Ýstatistik> raporlar;

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

	public void setRaporlar(Vector<Ýstatistik> raporlar) {
		this.raporlar = raporlar;
	}

	public String toString() {
		int i;
		for (i = 0; i < raporlar.size(); i++) {
			System.out.println(raporlar.elementAt(i).toString());
			System.out.println();
		}
		return "";
	}
}
