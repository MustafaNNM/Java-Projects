package deva;

public class Kategori {
	//Kategoriye ili�kin bilgiler(kategori_no#Kategori_ad�)
	private int kategori_no=0;
	private String kategori_ad�="";
	public Kategori(int kategori_no,String kategori_ad�){
		setKategori_no(kategori_no);
		setKategori_ad�(kategori_ad�);
	}
	public String getKategori_ad�() {
		return kategori_ad�;
	}
	public void setKategori_ad�(String kategori_ad�) {
		this.kategori_ad� = kategori_ad�;
	}
	public int getKategori_no() {
		return kategori_no;
	}
	public void setKategori_no(int kategori_no) {
		this.kategori_no = kategori_no;
	}
	
	public String toString(){
		return "Kategori No: "+kategori_no+"Kategori_Ad�: "+kategori_ad�+"\n";
	}
}
