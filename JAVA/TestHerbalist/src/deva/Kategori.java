package deva;

public class Kategori {
	//Kategoriye iliskin bilgiler(kategori_no#Kategori_adi)
	private int kategori_no=0;
	private String kategori_adi="";
	public Kategori(int kategori_no,String kategori_adi){
		setKategori_no(kategori_no);
		setKategori_adi(kategori_adi);
	}
	public String getKategori_adi() {
		return kategori_adi;
	}
	public void setKategori_adi(String kategori_adi) {
		this.kategori_adi = kategori_adi;
	}
	public int getKategori_no() {
		return kategori_no;
	}
	public void setKategori_no(int kategori_no) {
		this.kategori_no = kategori_no;
	}
	
	public String toString(){
		return "Kategori No: "+kategori_no+"Kategori_Adi: "+kategori_adi+"\n";
	}
}
