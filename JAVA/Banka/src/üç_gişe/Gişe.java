package üç_giþe;

public class Giþe {
	private int iþlem_süresi, toplam_bekletme_süresi;
	//Önceliðe göre müþteri iþlemleri yapýlýyor
	public Giþe() {
		//iþlem_süresi müþteri giþedeyken alýnýyor
		setToplam_bekletme_süresi(0);
	}

	public int getIþlem_süresi() {
		return iþlem_süresi;
	}

	public void setIþlem_süresi(int iþlem_süresi) {
		this.iþlem_süresi = iþlem_süresi;
	}

	public int getToplam_bekletme_süresi() {
		return toplam_bekletme_süresi;
	}

	public void setToplam_bekletme_süresi(int toplam_bekletme_süresi) {
		this.toplam_bekletme_süresi = toplam_bekletme_süresi;
	}

}