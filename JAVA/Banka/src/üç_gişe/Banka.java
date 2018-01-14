package üç_giþe;

import java.util.Vector;

import tek_giþe.Ýstatistikler;

public class Banka {
	private int giþe_sayýsý;
	private Vector<Giþe> vezneler;
	private Ýstatistikler rapor_klasörü;

	public Banka(int n) {
		setVezneler(new Vector<Giþe>());
		setGiþe_sayýsý(3);
		getVezneler().setSize(getGiþe_sayýsý());
		for(int i=0;i<getVezneler().size();i++){
			getVezneler().set(i, new Giþe());	
		}
		setRapor_klasörü(new Ýstatistikler(n));
	}

	public Vector<Giþe> getVezneler() {
		return vezneler;
	}

	public void setVezneler(Vector<Giþe> vezneler) {
		this.vezneler = vezneler;
	}

	public int getGiþe_sayýsý() {
		return giþe_sayýsý;
	}

	public void setGiþe_sayýsý(int giþe_sayýsý) {
		this.giþe_sayýsý = giþe_sayýsý;
	}

	public Ýstatistikler getRapor_klasörü() {
		return rapor_klasörü;
	}

	public void setRapor_klasörü(Ýstatistikler rapor_klasörü) {
		this.rapor_klasörü = rapor_klasörü;
	}
}
