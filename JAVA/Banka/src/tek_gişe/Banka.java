package tek_giþe;

public class Banka {
	private Giþe vezne;
	private Ýstatistikler rapor_klasörü;

	public Banka(int n) {
		setVezne(new Giþe());
		setRapor_klasörü(new Ýstatistikler(n));
	}

	public Giþe getVezne() {
		return vezne;
	}

	public void setVezne(Giþe vezne) {
		this.vezne = vezne;
	}

	public Ýstatistikler getRapor_klasörü() {
		return rapor_klasörü;
	}

	public void setRapor_klasörü(Ýstatistikler rapor_klasörü) {
		this.rapor_klasörü = rapor_klasörü;
	}

}
