public class M��teri {
	private static M��teri_listesi t�ret;
	private String ad = "";
	private String soyad = "";
	private M��teri_hesab� hesap;

	public M��teri() {
		// M��terinin bele�enleri(ad,soyad,hesap) olu�turuluyor
		t�ret = new M��teri_listesi();
		setAd(t�ret.random_ad());
		setSoyad(t�ret.random_soyad());
		hesap = new M��teri_hesab�();
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public static M��teri_listesi getT�ret() {
		return t�ret;
	}

	public static void setT�ret(M��teri_listesi t�ret) {
		M��teri.t�ret = t�ret;
	}

	public M��teri_hesab� getHesap() {
		return hesap;
	}

	public void setHesap(M��teri_hesab� hesap) {
		this.hesap = hesap;
	}
	public String toString(){
		String metin="";
		metin+="Ad�: "+ad+" Soyad�: "+soyad+hesap;
		System.out.println(metin);
		return null;
	}
}
