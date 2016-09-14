import java.util.Vector;

public class Masa {
	private int sandalye_sayýsý;
	private float doluluk_oraný;
	private Vector<Müþteri> sandalyeler;// Elemanlarý Müþteri nesnesi olan
										// vektör

	public Masa(int müþteri_sayýsý) {
		// Masaya belirtilen miktarda müþteri oturuyor
		setSandalyeler(new Vector<Müþteri>());
		getSandalyeler().setSize(müþteri_sayýsý);
		setSandalye_sayýsý(4);
	}

	public void müþteri_yerleþtir(int masa_no) {
		for (int i = 0; i < getSandalyeler().size(); i++) {
			getSandalyeler().set(i, new Müþteri());
			getSandalyeler().elementAt(i).getHesap().setMasa_no(masa_no + 1);
		}
	}

	public void müþteri_ekle(int masa_no, int ek_müþteri) {
		getSandalyeler().add(new Müþteri());
		getSandalyeler().lastElement().getHesap().setMasa_no(masa_no + 1);
		if (1 < ek_müþteri) {
			getSandalyeler().add(new Müþteri());
			getSandalyeler().lastElement().getHesap().setMasa_no(masa_no + 1);
		}
	}

	private Vector<Müþteri> getSandalyeler() {
		return sandalyeler;
	}

	private void setSandalyeler(Vector<Müþteri> sandalyeler) {
		this.sandalyeler = sandalyeler;
	}

	public String toString() {
		for (int i = 0; i < getSandalyeler().size(); i++) {
			getSandalyeler().elementAt(i).toString();
		}
		System.out.println("Doluluk_oraný: " + getDoluluk_oraný());
		return null;
	}

	public int getSandalye_sayýsý() {
		return sandalye_sayýsý;
	}

	public void setSandalye_sayýsý(int sandalye_sayýsý) {
		this.sandalye_sayýsý = sandalye_sayýsý;
	}

	public float getDoluluk_oraný() {
		return doluluk_oraný;
	}

	public void setDoluluk_oraný(float doluluk_oraný) {
		this.doluluk_oraný = doluluk_oraný;
	}
}
