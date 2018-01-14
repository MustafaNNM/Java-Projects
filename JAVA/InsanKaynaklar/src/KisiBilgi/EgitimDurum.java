package KisiBilgi;

public class EgitimDurum {
	
	private String okulAdi,bolumu;
	private int baslangicTarih,bitisTarih;
	private double notOrtalama;
	
	
	public EgitimDurum(String okulAdi, String bolumu, int baslangicTarih,
			int bitisTarih, double notOrtalama) {
		super();
		this.okulAdi = okulAdi;
		this.bolumu = bolumu;
		this.baslangicTarih = baslangicTarih;
		this.bitisTarih = bitisTarih;
		this.notOrtalama = notOrtalama;
	}
	

	
	public void setOkulAdi(String okulAdi) {
		this.okulAdi = okulAdi;
	}



	public void setBolumu(String bolumu) {
		this.bolumu = bolumu;
	}



	public void setBaslangicTarih(int baslangicTarih) {
		this.baslangicTarih = baslangicTarih;
	}



	public void setBitisTarih(int bitisTarih) {
		this.bitisTarih = bitisTarih;
	}



	public String getOkulAdi() {
		return okulAdi;
	}



	public String getBolumu() {
		return bolumu;
	}



	public int getBaslangicTarih() {
		return baslangicTarih;
	}



	public int getBitisTarih() {
		return bitisTarih;
	}



	public double getNotOrtalama() {
		return notOrtalama;
	}



	public void setNotOrtalama(double notOrtalama) {
		this.notOrtalama = notOrtalama;
	}



	public void displayEgitim(){
		System.out.println("Egitim Durumu:\n"+"\tOkul adi:"+okulAdi+"\n\tBolumu:"+bolumu+"\n\tBaslangic Tarih"+
				baslangicTarih+"\n\tBitis Tarih:"+bitisTarih+"\n\tNot Ortalama:"+notOrtalama);
	}

}
