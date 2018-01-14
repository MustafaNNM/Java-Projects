package deva;

public class Kategori {
	//Kategoriye iliþkin bilgiler(kategori_no#Kategori_adý)
	private int kategori_no=0;
	private String kategori_adý="";
	public Kategori(int kategori_no,String kategori_adý){
		setKategori_no(kategori_no);
		setKategori_adý(kategori_adý);
	}
	public String getKategori_adý() {
		return kategori_adý;
	}
	public void setKategori_adý(String kategori_adý) {
		this.kategori_adý = kategori_adý;
	}
	public int getKategori_no() {
		return kategori_no;
	}
	public void setKategori_no(int kategori_no) {
		this.kategori_no = kategori_no;
	}
	
	public String toString(){
		return "Kategori No: "+kategori_no+"Kategori_Adý: "+kategori_adý+"\n";
	}
}
