package tek_gi�e;

public class Banka {
	private Gi�e vezne;
	private �statistikler rapor_klas�r�;

	public Banka(int n) {
		setVezne(new Gi�e());
		setRapor_klas�r�(new �statistikler(n));
	}

	public Gi�e getVezne() {
		return vezne;
	}

	public void setVezne(Gi�e vezne) {
		this.vezne = vezne;
	}

	public �statistikler getRapor_klas�r�() {
		return rapor_klas�r�;
	}

	public void setRapor_klas�r�(�statistikler rapor_klas�r�) {
		this.rapor_klas�r� = rapor_klas�r�;
	}

}
