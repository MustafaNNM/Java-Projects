public class Müþteri {
	private static Müþteri_listesi türet;
	private String ad = "";
	private String soyad = "";
	private Müþteri_hesabý hesap;

	public Müþteri() {
		// Müþterinin beleþenleri(ad,soyad,hesap) oluþturuluyor
		türet = new Müþteri_listesi();
		setAd(türet.random_ad());
		setSoyad(türet.random_soyad());
		hesap = new Müþteri_hesabý();
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

	public static Müþteri_listesi getTüret() {
		return türet;
	}

	public static void setTüret(Müþteri_listesi türet) {
		Müþteri.türet = türet;
	}

	public Müþteri_hesabý getHesap() {
		return hesap;
	}

	public void setHesap(Müþteri_hesabý hesap) {
		this.hesap = hesap;
	}
	public String toString(){
		String metin="";
		metin+="Adý: "+ad+" Soyadý: "+soyad+hesap;
		System.out.println(metin);
		return null;
	}
}
