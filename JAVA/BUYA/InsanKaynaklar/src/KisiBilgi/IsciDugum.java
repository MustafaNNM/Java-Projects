package KisiBilgi;
import java.util.*;
public class IsciDugum {
	
	private String adi,evAdresi,e_posta,uyrugu,dogumYeri,medeniDurum,yabanciDil,ilgiAlan,referanKisiler;
	private int telefon,dogumTarihi;
	public String getYabanciDil() {
		return yabanciDil;
	}


	public void setYabanciDil(String yabanciDil) {
		this.yabanciDil = yabanciDil;
	}


	public String getIlgiAlan() {
		return ilgiAlan;
	}


	public void setIlgiAlan(String ilgiAlan) {
		this.ilgiAlan = ilgiAlan;
	}
	


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public String getReferanKisiler() {
		return referanKisiler;
	}


	public void setReferanKisiler(String referanKisiler) {
		this.referanKisiler = referanKisiler;
	}


	Vector<IsDeneyimi> isDeneyimi=new Vector<IsDeneyimi>();
    Vector<EgitimDurum> egitimDurumu=new Vector<EgitimDurum>();
	IsciDugum leftChild,rightChild;
	int height;	
	
	
	public IsciDugum() {
	}


	public IsciDugum(String adi, String evAdresi, String ePosta, String uyrugu,
			String dogumYeri, String medeniDurum,String yabanciDil,
			String ilgiAlan, int telefon, int dogumTarihi,String referansKisi,
			Vector<IsDeneyimi> isDeneyimi, Vector<EgitimDurum> egitimDurumu) {
		this.setAdi(adi);
		this.evAdresi = evAdresi;
		e_posta = ePosta;
		this.uyrugu = uyrugu;
		this.dogumYeri = dogumYeri;
		this.medeniDurum = medeniDurum;
		this.yabanciDil = yabanciDil;
		this.ilgiAlan = ilgiAlan;
		this.telefon = telefon;
		this.dogumTarihi = dogumTarihi;
		this.isDeneyimi = isDeneyimi;
		this.egitimDurumu = egitimDurumu;
		this.referanKisiler=referansKisi;
		leftChild = null;
		rightChild = null;
	}


	public IsciDugum getLeftChild() {
		return leftChild;
	}


	public IsciDugum getRightChild() {
		return rightChild;
	}


	public void displayIsciDugum(){
		System.out.println("ISCI BILGILERI:\n"+"\tAdi:"+getAdi()+"\n\tEv Adresi:"+evAdresi+"\n\tTelefon NO:"+telefon+
				"\n\tE-posta:"+e_posta+"\n\tUyrugu:"+uyrugu+"\n\tDogum Yeri:"+dogumYeri+"\n\tDogum Tarihi:"+dogumTarihi+
				"\n\tMedeni Durumu:"+medeniDurum+"\n\tYabanci Dil:"+yabanciDil+"\n\tIlgi Alanlar:"+ilgiAlan+"\n\tReferans Kisiler:"+referanKisiler);

		for(int i=0; i<isDeneyimi.size();i++)
			isDeneyimi.elementAt(i).displayIsDeneyim();
		for(int j=0; j<egitimDurumu.size(); j++)
			egitimDurumu.elementAt(j).displayEgitim();
	}
	
	


	public Vector<IsDeneyimi> getIsDeneyimi() {
		return isDeneyimi;
	}


	public void setIsDeneyimi(Vector<IsDeneyimi> isDeneyimi) {
		this.isDeneyimi = isDeneyimi;
	}


	public Vector<EgitimDurum> getEgitimDurumu() {
		return egitimDurumu;
	}


	public void setEgitimDurumu(Vector<EgitimDurum> egitimDurumu) {
		this.egitimDurumu = egitimDurumu;
	}


	public void setAdi(String adi) {
		this.adi = adi;
	}


	public String getAdi() {
		return adi;
	}


	public String getEvAdresi() {
		return evAdresi;
	}


	public void setEvAdresi(String evAdresi) {
		this.evAdresi = evAdresi;
	}


	public String getE_posta() {
		return e_posta;
	}


	public void setE_posta(String ePosta) {
		e_posta = ePosta;
	}


	public String getUyrugu() {
		return uyrugu;
	}


	public void setUyrugu(String uyrugu) {
		this.uyrugu = uyrugu;
	}


	public String getDogumYeri() {
		return dogumYeri;
	}


	public void setDogumYeri(String dogumYeri) {
		this.dogumYeri = dogumYeri;
	}


	public String getMedeniDurum() {
		return medeniDurum;
	}


	public void setMedeniDurum(String medeniDurum) {
		this.medeniDurum = medeniDurum;
	}


	public int getTelefon() {
		return telefon;
	}


	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}


	public int getDogumTarihi() {
		return dogumTarihi;
	}


	public void setDogumTarihi(int dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}


}
