public class Pazarlamaci extends Personel {
	int miktar, birimFiyat;
		
	public Pazarlamaci(int sno, String as, Adres a, int s_ucret, int m, 
	                   int bf) {
	       super(sno,as,a,s_ucret);
	       miktar=m;
	       birimFiyat=bf;
	}
	
	// miktar, birimFiyat ve komisyon deðiþkenleri için getter ve setter
	// metotlarý diðer sýnýflarda olduðu gibi yazýnýz...
	
	public int maasHesapla(int toplamCalismaSaati) {
		return (saatUcreti * toplamCalismaSaati) + (miktar * birimFiyat);
	}
	
	public void bilgiListele() {
		super.bilgiListele();
		System.out.println("Miktar=" + miktar + " Birim Fiyat=" + birimFiyat);
	}
}