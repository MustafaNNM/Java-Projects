package Test_Otopark;

public class Kat_dairesel {
	private D���m etkin;
	private int d���m_say�s� = 0, patlat�lan_d���m_say�s� = 0;

	public Kat_dairesel() {
		setEtkin(null);
		araba_yerle�tir();
	}

	private void araba_yerle�tir() {
		for (int i = 0; i < 30; i++) {
			ekle();
			setD���m_say�s�(getD���m_say�s�() + 1);
		}
	}

	public void ekle() {// bağlı diziye eleman ekler.
		if (etkin == null) {// liste yeni yaratılıyorsa;
			D���m yeniD���m = new D���m();
			etkin = yeniD���m;
			etkin.setSonraki(etkin);// bağlı listeyi dairesel hale getirmek için
		} else {// listede birden fazla eleman varsa;
			D���m yeniD���m = new D���m();
			D���m simdiki = etkin, gecici = etkin;
			do {
				gecici = gecici.getSonraki();
				simdiki = gecici.getSonraki();
			} while (simdiki != etkin);
			gecici.setSonraki(yeniD���m);
			yeniD���m.setSonraki(etkin);
		}
	}

	public void ��kar_daireselden(int n) {
		n = n % getD���m_say�s�();
		for (int i = 0; i < n - 1; i++) {
			if (doluMu()) {
				etkin = etkin.getSonraki();
			}
		}
		Araba.setSaya�(Araba.getSaya�() - 1);
		setD���m_say�s�(getD���m_say�s�() - 1);
		setPatlat�lan_d���m_say�s�(getPatlat�lan_d���m_say�s�() + 1);
		etkin = etkin.getSonraki().getSonraki();
	}

	public boolean doluMu() {
		if (etkin == etkin.getSonraki())// etkin kendine eşit olduğunda
			// yani bağlı listede sadece bir düğüm kaldığında
			// doluMu sorusuna "hayır boş" yanıtını verir
			return false;
		else
			return true;
	}

	public D���m getEtkin() {
		return etkin;
	}

	public void setEtkin(D���m etkin) {
		this.etkin = etkin;
	}

	public int getD���m_say�s�() {
		return d���m_say�s�;
	}

	public void setD���m_say�s�(int d���m_say�s�) {
		this.d���m_say�s� = d���m_say�s�;
	}

	public int getPatlat�lan_d���m_say�s�() {
		return patlat�lan_d���m_say�s�;
	}

	public void setPatlat�lan_d���m_say�s�(int patlat�lan_d���m_say�s�) {
		this.patlat�lan_d���m_say�s� = patlat�lan_d���m_say�s�;
	}
}
