package needless;
//bize anlat�rken a��klamalar� yapar�z
public class Bilgi {
	private int fiyat, metrekare, yap�m_y�l�;
	private String kira = "", il = "", il�e = "";
	
	Bilgi bilgi=this;

	public Bilgi(String kira, String il, String il�e, int fiyat, int metrekare,int yap�m_y�l�) {
		setKira(kira);
		setIl(il);
		setIl(il�e);
		setFiyat(fiyat);
		setMetrekare(metrekare);
		setYap�m_y�l�(yap�m_y�l�);
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

	public void setYap�m_y�l�(int yap�m_y�l�) {
		this.yap�m_y�l� = yap�m_y�l�;
	}

	public int getYap�m_y�l�() {
		return yap�m_y�l�;
	}

	public void setIl(String il) {
		this.il = il;
	}

	public String getIl() {
		return il;
	}

	public void setIl�e(String il�e) {
		this.il�e = il�e;
	}

	public String getIl�e() {
		return il�e;
	}

	public String yazdir() {
		return   "kira: " + kira +
				 " il: " + il + 
				 " il�e: " + il�e +
				 "fiyat: "+ fiyat + 
				 " metrekare: " + metrekare + 
				 " yap�m y�l�: "+ yap�m_y�l�;
	}
	
}
