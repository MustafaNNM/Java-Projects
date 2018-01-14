package needless;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;


public class Kisi {
	private String ad� = "", adresi = "", telefon = "", e_posta = "",
			uyru�u = "", do�um_yeri = "", do�um_tarihi = "", medeni_durum = "",
			cinsiyet = "", ��renci = "";
	private Queue<Bilgi> bilgiler = new LinkedList<Bilgi>();
	private Vector<Integer> satin_alinanlar;

	public Kisi(String ad�, String adresi, String telefon, String e_posta,
			String uyru�u, String do�um_yeri, String do�um_tarihi,
			String medeni_durum, String cinsiyet, String ��renci) {
		setAd�(ad�);
		setAdresi(adresi);
		setTelefon(telefon);
		setE_posta(e_posta);
		setUyru�u(uyru�u);
		setDo�um_yeri(do�um_yeri);
		setDo�um_tarihi(do�um_tarihi);
		setMedeni_durum(medeni_durum);
		setCinsiyet(cinsiyet);
		set��renci(��renci);
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

	public void setAd�(String ad�) {
		this.ad� = ad�;
	}

	public String getAd�() {
		return ad�;
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

	public void setUyru�u(String uyru�u) {
		this.uyru�u = uyru�u;
	}

	public String getUyru�u() {
		return uyru�u;
	}

	public void setDo�um_yeri(String do�um_yeri) {
		this.do�um_yeri = do�um_yeri;
	}

	public String getDo�um_yeri() {
		return do�um_yeri;
	}

	public void setDo�um_tarihi(String do�um_tarihi) {
		this.do�um_tarihi = do�um_tarihi;
	}

	public String getDo�um_tarihi() {
		return do�um_tarihi;
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

	public void set��renci(String ��renci) {
		this.��renci = ��renci;
	}

	public String get��renci() {
		return ��renci;
	}

	public void setSatin_alinanlar(Vector<Integer> satin_alinanlar) {
		this.satin_alinanlar = satin_alinanlar;
	}

	public Vector<Integer> getSatin_alinanlar() {
		return satin_alinanlar;
	}

	public String yazdir2() {
		return "\nAd�          : " + ad� + "\nAdresi       : " + adresi
				+ "\nTelefon      : " + telefon + "\nE_posta      : " + e_posta
				+ "\nUyru�u       : " + uyru�u + "\nDo�um yeri   : "
				+ do�um_yeri + "\nDo�um tarihi : " + do�um_tarihi
				+ "\nMedeni durum : " + medeni_durum + "\nCinsiyet     : "
				+ cinsiyet + "\n��renci      : " + ��renci
				+ "\nDaha �nce oturdu�u evlere ili�kin detaylar:\n"+yazdir();
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
