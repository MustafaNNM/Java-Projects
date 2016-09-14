package sirket;
import java.util.Vector;

public class isyerBilgi {
	
	private String isYerAdi,isYerAdresi,isYerEPosta;
	String telefon;
	private String faks;
	Vector<isIlan> isIlanVector;
	
	public isyerBilgi(String isYerAdi,String isYerAdresi,String isYerEPosta,String telefon,String faks) {
		isIlanVector=new Vector<isIlan>();
		this.isYerAdi=isYerAdi;
		this.faks=faks;
		this.isYerAdresi=isYerAdresi;
		this.isYerEPosta=isYerEPosta;
		this.telefon=telefon;

		
	}
	public isyerBilgi()
	{
		isIlanVector=new Vector<isIlan>();
	
	}
	

	public void disp() {
		System.out.println(isYerAdi);

	}

	public String getIsYerAdi() {
		return isYerAdi;
	}

	public void setIsYerAdi(String isYerAdi) {
		this.isYerAdi = isYerAdi;
	}

	public String getIsYerAdresi() {
		return isYerAdresi;
	}

	public void setIsYerAdresi(String isYerAdresi) {
		this.isYerAdresi = isYerAdresi;
	}

	public String getIsYerEPosta() {
		return isYerEPosta;
	}

	public void setIsYerEPosta(String isYerEPosta) {
		this.isYerEPosta = isYerEPosta;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getFaks() {
		return faks;
	}

	public void setFaks(String faks) {
		this.faks = faks;
	}

	public Vector<isIlan> getIsIlanVector() {
		return isIlanVector;
	}

	public void setIsIlanVector(Vector<isIlan> isIlanVector) {
		this.isIlanVector = isIlanVector;
	}
	/*
	 * yeni bir is ilan verme 2secim 3
	 */

	




}
