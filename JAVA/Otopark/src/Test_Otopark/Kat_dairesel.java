package Test_Otopark;

public class Kat_dairesel {
	private Düðüm etkin;
	private int düðüm_sayýsý = 0, patlatýlan_düðüm_sayýsý = 0;

	public Kat_dairesel() {
		setEtkin(null);
		araba_yerleþtir();
	}

	private void araba_yerleþtir() {
		for (int i = 0; i < 30; i++) {
			ekle();
			setDüðüm_sayýsý(getDüðüm_sayýsý() + 1);
		}
	}

	public void ekle() {// baÄŸlÄ± diziye eleman ekler.
		if (etkin == null) {// liste yeni yaratÄ±lÄ±yorsa;
			Düðüm yeniDüðüm = new Düðüm();
			etkin = yeniDüðüm;
			etkin.setSonraki(etkin);// baÄŸlÄ± listeyi dairesel hale getirmek iÃ§in
		} else {// listede birden fazla eleman varsa;
			Düðüm yeniDüðüm = new Düðüm();
			Düðüm simdiki = etkin, gecici = etkin;
			do {
				gecici = gecici.getSonraki();
				simdiki = gecici.getSonraki();
			} while (simdiki != etkin);
			gecici.setSonraki(yeniDüðüm);
			yeniDüðüm.setSonraki(etkin);
		}
	}

	public void çýkar_daireselden(int n) {
		n = n % getDüðüm_sayýsý();
		for (int i = 0; i < n - 1; i++) {
			if (doluMu()) {
				etkin = etkin.getSonraki();
			}
		}
		Araba.setSayaç(Araba.getSayaç() - 1);
		setDüðüm_sayýsý(getDüðüm_sayýsý() - 1);
		setPatlatýlan_düðüm_sayýsý(getPatlatýlan_düðüm_sayýsý() + 1);
		etkin = etkin.getSonraki().getSonraki();
	}

	public boolean doluMu() {
		if (etkin == etkin.getSonraki())// etkin kendine eÅŸit olduÄŸunda
			// yani baÄŸlÄ± listede sadece bir dÃ¼ÄŸÃ¼m kaldÄ±ÄŸÄ±nda
			// doluMu sorusuna "hayÄ±r boÅŸ" yanÄ±tÄ±nÄ± verir
			return false;
		else
			return true;
	}

	public Düðüm getEtkin() {
		return etkin;
	}

	public void setEtkin(Düðüm etkin) {
		this.etkin = etkin;
	}

	public int getDüðüm_sayýsý() {
		return düðüm_sayýsý;
	}

	public void setDüðüm_sayýsý(int düðüm_sayýsý) {
		this.düðüm_sayýsý = düðüm_sayýsý;
	}

	public int getPatlatýlan_düðüm_sayýsý() {
		return patlatýlan_düðüm_sayýsý;
	}

	public void setPatlatýlan_düðüm_sayýsý(int patlatýlan_düðüm_sayýsý) {
		this.patlatýlan_düðüm_sayýsý = patlatýlan_düðüm_sayýsý;
	}
}
