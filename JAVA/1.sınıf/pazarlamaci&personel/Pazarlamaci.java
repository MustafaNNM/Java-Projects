public class Pazarlamaci extends Personel {
	int miktar, birimFiyat;
		
	public Pazarlamaci(int sno, String as, Adres a, int s_ucret, int m, 
	                   int bf) {
	       super(sno,as,a,s_ucret);
	       miktar=m;
	       birimFiyat=bf;
	}
	
	// miktar, birimFiyat ve komisyon de�i�kenleri i�in getter ve setter
	// metotlar� di�er s�n�flarda oldu�u gibi yaz�n�z...
	
	public int maasHesapla(int toplamCalismaSaati) {
		return (saatUcreti * toplamCalismaSaati) + (miktar * birimFiyat);
	}
	
	public void bilgiListele() {
		super.bilgiListele();
		System.out.println("Miktar=" + miktar + " Birim Fiyat=" + birimFiyat);
	}
}