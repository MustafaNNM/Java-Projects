public class Personel {
	int sicilno;
	String adSoyad;
	Adres adr;
	int saatUcreti;
	
	public Personel(int sno, String as, Adres a, int s_ucret) {
		sicilno=sno;
		adSoyad=as;
		adr=a;
		saatUcreti=s_ucret;
	}
	
	public int getSicilno() { return sicilno;}
	public String getAdSoyad() { return adSoyad;}
	public Adres getAdres() { return adr;}
	public int getSaatUcreti() { return saatUcreti;}
	
	public void setSicilno(int yeni_sno) {
		sicilno=yeni_sno;
	}
	
	public void setAdSoyad(String yeni_as) {
		adSoyad=yeni_as;
	}
	
	public void setAdres(Adres yeni_adres) {
		adr=yeni_adres;
	}
	
	public void setSaatUcreti(int yeni_ucret) {
		saatUcreti=yeni_ucret;
	}
	
	public int maasHesapla(int toplamCalismaSaati) {
		return saatUcreti*toplamCalismaSaati;
	}
	
	public void bilgiListele() {
		System.out.println("Sicilno=" + sicilno + " Ad Soyad=" + adSoyad
		+ "\nAdres Bilgileri:" + adr + " Saat Ucreti=" + saatUcreti);
	}
}