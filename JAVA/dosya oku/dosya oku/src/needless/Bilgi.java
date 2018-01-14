package needless;
//bize anlatırken açıklamaları yaparız
public class Bilgi {
	private int fiyat, metrekare, yapım_yılı;
	private String kira = "", il = "", ilçe = "";
	
	Bilgi bilgi=this;

	public Bilgi(String kira, String il, String ilçe, int fiyat, int metrekare,int yapım_yılı) {
		setKira(kira);
		setIl(il);
		setIl(ilçe);
		setFiyat(fiyat);
		setMetrekare(metrekare);
		setYapım_yılı(yapım_yılı);
		//System.out.println(this.yazdir());
	}

	public void setKira(String kira) {
		this.kira = kira;
	}

	public String getKira() {
		return kira;
	}

	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}

	public int getFiyat() {
		return fiyat;
	}

	public void setMetrekare(int metrekare) {
		this.metrekare = metrekare;
	}

	public int getMetrekare() {
		return metrekare;
	}

	public void setYapım_yılı(int yapım_yılı) {
		this.yapım_yılı = yapım_yılı;
	}

	public int getYapım_yılı() {
		return yapım_yılı;
	}

	public void setIl(String il) {
		this.il = il;
	}

	public String getIl() {
		return il;
	}

	public void setIlçe(String ilçe) {
		this.ilçe = ilçe;
	}

	public String getIlçe() {
		return ilçe;
	}

	public String yazdir() {
		return   "kira: " + kira +
				 " il: " + il + 
				 " ilçe: " + ilçe +
				 "fiyat: "+ fiyat + 
				 " metrekare: " + metrekare + 
				 " yapım yılı: "+ yapım_yılı;
	}
	
}
