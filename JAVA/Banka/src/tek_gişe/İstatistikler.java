package tek_gi�e;

import java.util.Vector;

public class �statistikler {
	private Vector<�statistik> raporlar;

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

	public void setRaporlar(Vector<�statistik> raporlar) {
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
