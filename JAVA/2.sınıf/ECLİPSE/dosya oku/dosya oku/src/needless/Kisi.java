package needless;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;


public class Kisi {
	private String adý = "", adresi = "", telefon = "", e_posta = "",
			uyruðu = "", doðum_yeri = "", doðum_tarihi = "", medeni_durum = "",
			cinsiyet = "", öðrenci = "";
	private Queue<Bilgi> bilgiler = new LinkedList<Bilgi>();
	private Vector<Integer> satin_alinanlar;

	public Kisi(String adý, String adresi, String telefon, String e_posta,
			String uyruðu, String doðum_yeri, String doðum_tarihi,
			String medeni_durum, String cinsiyet, String öðrenci) {
		setAdý(adý);
		setAdresi(adresi);
		setTelefon(telefon);
		setE_posta(e_posta);
		setUyruðu(uyruðu);
		setDoðum_yeri(doðum_yeri);
		setDoðum_tarihi(doðum_tarihi);
		setMedeni_durum(medeni_durum);
		setCinsiyet(cinsiyet);
		setÖðrenci(öðrenci);
	}

	public void konut_al(int ilan_no) {
		satin_alinanlar.add(ilan_no);
	}

	public String konut_listele() {
		// for (final Kisi kisi : kisiler) {
		// System.out.println(kisi.yazdir2());
		// }
		String liste = "";
		Iterator<Integer> ilan_nolari = satin_alinanlar.iterator();
		while (ilan_nolari.hasNext()) {
			liste += ilan_nolari.next() + " ";
		}
		return liste;
	}

	public void setAdý(String adý) {
		this.adý = adý;
	}

	public String getAdý() {
		return adý;
	}

	public void setAdresi(String adresi) {
		this.adresi = adresi;
	}

	public String getAdresi() {
		return adresi;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setE_posta(String e_posta) {
		this.e_posta = e_posta;
	}

	public String getE_posta() {
		return e_posta;
	}

	public void setUyruðu(String uyruðu) {
		this.uyruðu = uyruðu;
	}

	public String getUyruðu() {
		return uyruðu;
	}

	public void setDoðum_yeri(String doðum_yeri) {
		this.doðum_yeri = doðum_yeri;
	}

	public String getDoðum_yeri() {
		return doðum_yeri;
	}

	public void setDoðum_tarihi(String doðum_tarihi) {
		this.doðum_tarihi = doðum_tarihi;
	}

	public String getDoðum_tarihi() {
		return doðum_tarihi;
	}

	public void setMedeni_durum(String medeni_durum) {
		this.medeni_durum = medeni_durum;
	}

	public String getMedeni_durum() {
		return medeni_durum;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setÖðrenci(String öðrenci) {
		this.öðrenci = öðrenci;
	}

	public String getÖðrenci() {
		return öðrenci;
	}

	public void setSatin_alinanlar(Vector<Integer> satin_alinanlar) {
		this.satin_alinanlar = satin_alinanlar;
	}

	public Vector<Integer> getSatin_alinanlar() {
		return satin_alinanlar;
	}

	public String yazdir2() {
		return "\nAdý          : " + adý + "\nAdresi       : " + adresi
				+ "\nTelefon      : " + telefon + "\nE_posta      : " + e_posta
				+ "\nUyruðu       : " + uyruðu + "\nDoðum yeri   : "
				+ doðum_yeri + "\nDoðum tarihi : " + doðum_tarihi
				+ "\nMedeni durum : " + medeni_durum + "\nCinsiyet     : "
				+ cinsiyet + "\nÖðrenci      : " + öðrenci
				+ "\nDaha önce oturduðu evlere iliþkin detaylar:\n"+yazdir();
	}


	public void asd(Bilgi bil){
		bilgiler.add(bil);
	}
	public String yazdir() {
		Iterator<Bilgi> bagaj_kuyrugu = bilgiler.iterator();/*
														 * Kuyruktaki elemanlar
														 * FIFO yapisina
														 * aktarildi
														 */
		String liste="";
		while (bagaj_kuyrugu.hasNext()) {
			Bilgi siradaki_bilgi = (Bilgi) bagaj_kuyrugu.next();/*
																 * Siradaki
																 * bilgi
																 * iteratore
																 * aktariliyor
																 */
			liste+=siradaki_bilgi.yazdir()+"\n";
		}
		return liste;
	}

}
