/*
 * Created on 07.Mar.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author cenk
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Ogrenci {
	// INSTANCE VARIABLES
	private int numara;
	private String ad, soyad, adres;
	private int bilgi_miktar;

	// CONSTRUCTORS
	public Ogrenci() {
		numara = 0;
		ad = "";
		soyad = "";
		adres = "";
		bilgi_miktar = 0;
	}
	public Ogrenci(int n, String a, String s, String adr) {
		numara = n;
		ad = a;
		soyad = s;
		adres = adr;
		bilgi_miktar = 0;
	}
	// GETTER ve SETTER METOTLAR

	public String getAd() {
		return ad;
	}

	public String getAdres() {
		return adres;
	}

	public int getNumara() {
		return numara;
	}

	public String getSoyad() {
		return soyad;
	}

	public int getBilgi_miktar() {
		return bilgi_miktar;
	}

	public void setAd(String string) {
		ad = string;
	}

	public void setAdres(String string) {
		adres = string;
	}

	public void setNumara(int i) {
		numara = i;
	}

	public void setSoyad(String string) {
		soyad = string;
	}

	public void setBilgi_miktar(int i) {
		bilgi_miktar = i;
	}

	// BEHAVIOUR

	void kitap_oku() {
		bilgi_miktar++;
	}

	void kimlik_yaz() {
		System.out.println(
			"Numara:"
				+ numara + "\n"
				+ "Ad ve Soyad:"
				+ ad + " " 
				+ soyad + "\n"
				+ "Adres:"
				+ adres + "\n"
				+ "Bilgi Düzeyi:"
				+ bilgi_miktar + "\n");
	}

}
