package deva;

import java.util.StringTokenizer;
import java.util.Vector;

import veri_tabani.Kategori_veri_tabani;

//Bitkiye ilişkin bilgiler(bitki adı, kategori,bitkinin latince ismi,bitkinin özellikleri,miktarı,fiyatı,bitki resminin diskteki yeri ve adı,bilgi sayısı(önerilen hastalıklar için),önerilen hastalıklar)
// Bitkiye ilişkin bilgiler(dosyadaki hali)(bitki adı# kategori(bitkiler için 0,bitki
// çayları için 1,vitaminler için 2)#bitkinin latince ismi#bitkinin
// özellikleri( _ ile ayrılıdır)#miktarı#fiyatı#bitki resminin diskteki
// yeri#bitki resminin diskteki adı#bilgi sayısı(önerilen hastalıklar
// için)#önerilen hastalıklar(>>ile ayrılmıştır)
public class Bitki {
	private String adi = "asd", latince_adi = "";
	private BitkiLocationData Lokasyon = new BitkiLocationData("", "");
	private BitkiPrice Pazarlama = new BitkiPrice();
	private int kategori;
	private Vector<String> onerilen_hastaliklar;
	private Vector<String> ozellikleri;

	public Bitki(String adi, String kategori, String latince_adi, int miktari,
			float fiyati, String diskteki_yeri, String diskteki_adi,
			Vector<String> onerilen_hastaliklar, Vector<String> ozellikleri) {
		setAdi(adi);
		setKategori(Integer.parseInt(kategori));
		setLatince_adi(latince_adi);
		setMiktari(miktari);
		setFiyati(fiyati);
		setDiskteki_yeri(diskteki_yeri);
		setDiskteki_adi(diskteki_adi);
		setOnerilen_hastaliklar(onerilen_hastaliklar);
		setOzellikleri(ozellikleri);
	}

	public Bitki(String adi, String kategori, String latince_adi,
			String ozellikleri, String miktari, String fiyati,
			String diskteki_yeri, String diskteki_adi) {
		setAdi(adi);
		setKategori(Integer.parseInt(kategori));
		setLatince_adi(latince_adi);
		setMiktari(Integer.parseInt(miktari));
		setFiyati(Float.parseFloat(fiyati));
		setDiskteki_yeri(diskteki_yeri);
		setDiskteki_adi(diskteki_adi);
		setOnerilen_hastaliklar(new Vector<String>());
		setOzellikleri(new Vector<String>());
		ozellik_ekle(ozellikleri);
	}

	private void ozellik_ekle(String ozellikleri) {
		StringTokenizer st3 = new StringTokenizer(ozellikleri, "_");
		while (st3.hasMoreTokens()) {
			getOzellikleri().add(st3.nextToken());// ozellik ekleniyor
		}
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public int getKategori() {
		return kategori;
	}

	public void setKategori(int kategori) {
		this.kategori = kategori;
	}

	public String getLatince_adi() {
		return latince_adi;
	}

	public void setLatince_adi(String latince_adi) {
		this.latince_adi = latince_adi;
	}

	public String getDiskteki_yeri() {
		return Lokasyon.getDiskteki_yeri();
	}

	public void setDiskteki_yeri(String diskteki_yeri) {
		this.Lokasyon.setDiskteki_yeri(diskteki_yeri);
	}

	public String getDiskteki_adi() {
		return Lokasyon.getDiskteki_adi();
	}

	public void setDiskteki_adi(String diskteki_adi) {
		this.Lokasyon.setDiskteki_adi(diskteki_adi);
	}

	public int getMiktari() {
		return Pazarlama.getMiktari();
	}

	public void setMiktari(int miktari) {
		this.Pazarlama.setMiktari(miktari);
	}

	public float getFiyati() {
		return Pazarlama.getFiyati();
	}

	public void setFiyati(float fiyati) {
		this.Pazarlama.setFiyati(fiyati);
	}

	public Vector<String> getOnerilen_hastaliklar() {
		return onerilen_hastaliklar;
	}

	public void setOnerilen_hastaliklar(Vector<String> onerilen_hastaliklar) {
		this.onerilen_hastaliklar = onerilen_hastaliklar;
	}

	public Vector<String> getOzellikleri() {
		return ozellikleri;
	}

	public void setOzellikleri(Vector<String> ozellikleri) {
		this.ozellikleri = ozellikleri;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Adi           : ");
		stringBuilder.append(adi);
		stringBuilder.append("\nKategori      : ");
		stringBuilder.append(kategorisi());
		stringBuilder.append("\nLatince adi   : ");
		stringBuilder.append(latince_adi);
		stringBuilder.append(Ozellikleri_toString());
		stringBuilder.append("\n\nDiskteki Yeri : ");
		stringBuilder.append(Lokasyon.getDiskteki_yeri());
		stringBuilder.append("\nDiskteki Adi  : ");
		stringBuilder.append(Lokasyon.getDiskteki_adi());
		stringBuilder.append("\nMiktari       : ");
		stringBuilder.append(Pazarlama.getMiktari());
		stringBuilder.append(" Paket");
		stringBuilder.append("\nFiyati        : ");
		stringBuilder.append(Pazarlama.getFiyati());
		stringBuilder.append("\n\nOnerilen Hastaliklar\n");
		stringBuilder.append(Onerilen_hastaliklar_toString());

		return stringBuilder.toString();
	}

	private String kategorisi() {
		for (int i = 0; i < Kategori_veri_tabani.getKategoriler().size(); i++) {
			if (Kategori_veri_tabani.getKategoriler().elementAt(i)
					.getKategori_no() == getKategori()) {
				return Kategori_veri_tabani.getKategoriler().elementAt(i)
						.getKategori_adi();
			}
		}
		return uyari();
	}

	private String uyari() {
		String uyari = "Kategorilenmemis\n"
				+ "Eger boyle bir urun bitki veri tabaninda bulunuyorsa\n"
				+ "1)Varsa lutfen kategori.txt dosyasindaki hatayi duzeltin\n"
				+ "2)Bitki veri tabanina veri yanlis girilmis olabilir\n"
				+ "3)Varsa lutfen bitki.txt dosyasindaki hatayi duzeltin\n";
		return uyari;
	}

	public String Onerilen_hastaliklar_toString() {
		String metin = "";
		for (int i = 0; i < onerilen_hastaliklar.size(); i++) {
			metin += "\n" + onerilen_hastaliklar.elementAt(i);
		}
		return metin;
	}

	public String Ozellikleri_toString() {
		String metin = "";
		for (int i = 0; i < ozellikleri.size(); i++) {
			metin += "\n" + ozellikleri.elementAt(i);
		}
		return metin;
	}

}
