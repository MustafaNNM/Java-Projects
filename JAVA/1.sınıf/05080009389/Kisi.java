public class Kisi {
	public String tcKimlikNo;
	public String adSoyad;
	Adres adres;
	public Kisi( String tc,String as, Adres adr) {
		tcKimlikNo=tc;
		adSoyad=as;
		adres=adr;
	}
	public String gettcKimlikNo() { return tcKimlikNo;}
	public String getAdSoyad() { return adSoyad;}
	public Adres getAdres() { return adres;}
	public void settcKimlikNo(String tc) {tcKimlikNo=tc;}
	public void setAdSoyad(String as) {adSoyad=as;}
	public void setAdres(Adres adr) {adres=adr;}
	public String toString() {
		return
		"Tc Kimlik No:" + tcKimlikNo +
		"\nAd Soyad:" + adSoyad +
		"\nAdres:" + adres;}
}