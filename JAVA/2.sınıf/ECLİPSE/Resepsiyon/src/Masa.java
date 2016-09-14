import java.util.Vector;

public class Masa {
	private int sandalye_say�s�;
	private float doluluk_oran�;
	private Vector<M��teri> sandalyeler;// Elemanlar� M��teri nesnesi olan
										// vekt�r

	public Masa(int m��teri_say�s�) {
		// Masaya belirtilen miktarda m��teri oturuyor
		setSandalyeler(new Vector<M��teri>());
		getSandalyeler().setSize(m��teri_say�s�);
		setSandalye_say�s�(4);
	}

	public void m��teri_yerle�tir(int masa_no) {
		for (int i = 0; i < getSandalyeler().size(); i++) {
			getSandalyeler().set(i, new M��teri());
			getSandalyeler().elementAt(i).getHesap().setMasa_no(masa_no + 1);
		}
	}

	public void m��teri_ekle(int masa_no, int ek_m��teri) {
		getSandalyeler().add(new M��teri());
		getSandalyeler().lastElement().getHesap().setMasa_no(masa_no + 1);
		if (1 < ek_m��teri) {
			getSandalyeler().add(new M��teri());
			getSandalyeler().lastElement().getHesap().setMasa_no(masa_no + 1);
		}
	}

	private Vector<M��teri> getSandalyeler() {
		return sandalyeler;
	}

	private void setSandalyeler(Vector<M��teri> sandalyeler) {
		this.sandalyeler = sandalyeler;
	}

	public String toString() {
		for (int i = 0; i < getSandalyeler().size(); i++) {
			getSandalyeler().elementAt(i).toString();
		}
		System.out.println("Doluluk_oran�: " + getDoluluk_oran�());
		return null;
	}

	public int getSandalye_say�s�() {
		return sandalye_say�s�;
	}

	public void setSandalye_say�s�(int sandalye_say�s�) {
		this.sandalye_say�s� = sandalye_say�s�;
	}

	public float getDoluluk_oran�() {
		return doluluk_oran�;
	}

	public void setDoluluk_oran�(float doluluk_oran�) {
		this.doluluk_oran� = doluluk_oran�;
	}
}
