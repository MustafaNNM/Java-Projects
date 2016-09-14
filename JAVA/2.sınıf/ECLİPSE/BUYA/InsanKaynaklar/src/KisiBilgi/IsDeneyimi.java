package KisiBilgi;

public class IsDeneyimi {
	
	private String isyerAdi,isyerAdresi,isyerPozisyon,isyerGorevi;
	

	
	public IsDeneyimi(String isyerAdi, String isyerAdresi,
			String isyerPozisyon, String isyerGorevi) {
		super();
		this.isyerAdi = isyerAdi;
		this.isyerAdresi = isyerAdresi;
		this.isyerPozisyon = isyerPozisyon;
		this.isyerGorevi = isyerGorevi;
	}
	



	public void displayIsDeneyim(){
		System.out.println("Is Deneyimi:\n"+"\tIsyer Adi:"+isyerAdi+"\n\tIs Yer Adresi:"+isyerAdresi+
				"\n\tIsyer Pozisyon:"+isyerPozisyon+"\n\tIsyer Gorevi"+isyerGorevi);
	}



	public String getIsyerAdi() {
		return isyerAdi;
	}



	public String getIsyerAdresi() {
		return isyerAdresi;
	}



	public String getIsyerPozisyon() {
		return isyerPozisyon;
	}



	public String getIsyerGorevi() {
		return isyerGorevi;
	}
	

}
