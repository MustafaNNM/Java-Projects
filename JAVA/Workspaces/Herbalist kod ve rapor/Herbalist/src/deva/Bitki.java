package deva;

import java.util.StringTokenizer;
import java.util.Vector;

import veri_tabaný.Kategori_veri_tabaný;

//Bitkiye iliþkin bilgiler(bitki adý, kategori,bitkinin latince ismi,bitkinin özellikleri,miktarý,fiyatý,bitki resminin diskteki yeri ve adý,bilgi sayýsý(önerilen hastalýklar için),önerilen hastalýklar)
// Bitkiye iliþkin bilgiler(dosyadaki hali)(bitki adý# kategori(bitkiler için 0,bitki
// çaylarý için 1,vitaminler için 2)#bitkinin latince ismi#bitkinin
// özellikleri( _ ile ayrýlýdýr)#miktarý#fiyatý#bitki resminin diskteki
// yeri#bitki resminin diskteki adý#bilgi sayýsý(önerilen hastalýklar
// için)#önerilen hastalýklar(>>ile ayrýlmýþtýr)
public class Bitki {
	private String adý = "asd", latince_adý = "", diskteki_yeri = "",
			diskteki_adý = "";
	private int miktarý;// paket cinsinden
	private float fiyatý;
	private int kategori;
	private Vector<String> önerilen_hastalýklar;
	private Vector<String> özellikleri;

	public Bitki(String adý, String kategori, String latince_adý, int miktarý,
			float fiyatý, String diskteki_yeri, String diskteki_adý,
			Vector<String> önerilen_hastalýklar, Vector<String> özellikleri) {
		setAdý(adý);
		setKategori(Integer.parseInt(kategori));
		setLatince_adý(latince_adý);
		setMiktarý(miktarý);
		setFiyatý(fiyatý);
		setDiskteki_yeri(diskteki_yeri);
		setDiskteki_adý(diskteki_adý);
		setÖnerilen_hastalýklar(önerilen_hastalýklar);
		setÖzellikleri(özellikleri);
	}

	public Bitki(String adý, String kategori, String latince_adý,
			String özellikleri, String miktarý, String fiyatý,
			String diskteki_yeri, String diskteki_adý) {
		setAdý(adý);
		setKategori(Integer.parseInt(kategori));
		setLatince_adý(latince_adý);
		setMiktarý(Integer.parseInt(miktarý));
		setFiyatý(Float.parseFloat(fiyatý));
		setDiskteki_yeri(diskteki_yeri);
		setDiskteki_adý(diskteki_adý);

		setÖnerilen_hastalýklar(new Vector<String>());
		setÖzellikleri(new Vector<String>());

		StringTokenizer st3 = new StringTokenizer(özellikleri, "_");
		while (st3.hasMoreTokens()) {
			getÖzellikleri().add(st3.nextToken());// özellik ekleniyor
		}
	}

	public String getAdý() {
		return adý;
	}

	public void setAdý(String adý) {
		this.adý = adý;
	}

	public int getKategori() {
		return kategori;
	}

	public void setKategori(int kategori) {
		this.kategori = kategori;
	}

	public String getLatince_adý() {
		return latince_adý;
	}

	public void setLatince_adý(String latince_adý) {
		this.latince_adý = latince_adý;
	}

	public String getDiskteki_yeri() {
		return diskteki_yeri;
	}

	public void setDiskteki_yeri(String diskteki_yeri) {
		this.diskteki_yeri = diskteki_yeri;
	}

	public String getDiskteki_adý() {
		return diskteki_adý;
	}

	public void setDiskteki_adý(String diskteki_adý) {
		this.diskteki_adý = diskteki_adý;
	}

	public int getMiktarý() {
		return miktarý;
	}

	public void setMiktarý(int miktarý) {
		this.miktarý = miktarý;
	}

	public float getFiyatý() {
		return fiyatý;
	}

	public void setFiyatý(float fiyatý) {
		this.fiyatý = fiyatý;
	}

	public Vector<String> getÖnerilen_hastalýklar() {
		return önerilen_hastalýklar;
	}

	public void setÖnerilen_hastalýklar(Vector<String> önerilen_hastalýklar) {
		this.önerilen_hastalýklar = önerilen_hastalýklar;
	}

	public Vector<String> getÖzellikleri() {
		return özellikleri;
	}

	public void setÖzellikleri(Vector<String> özellikleri) {
		this.özellikleri = özellikleri;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Adý           : ");
		stringBuilder.append(adý);
		stringBuilder.append("\nKategori      : ");
		stringBuilder.append(kategorisi());
		stringBuilder.append("\nLatince adý   : ");
		stringBuilder.append(latince_adý);
		stringBuilder.append("\nÖzellikleri   : ");
		stringBuilder.append(özellikleri_toString());
		stringBuilder.append("\n\nDiskteki Yeri : ");
		stringBuilder.append(diskteki_yeri);
		stringBuilder.append("\nDiskteki Adý  : ");
		stringBuilder.append(diskteki_adý);
		stringBuilder.append("\nMiktarý       : ");
		stringBuilder.append(miktarý);
		stringBuilder.append(" Paket");
		stringBuilder.append("\nFiyatý        : ");
		stringBuilder.append(fiyatý);
		stringBuilder.append("\n\nÖnerilen Hastalýklar\n");
		stringBuilder.append(önerilen_hastalýklar_toString());

		return stringBuilder.toString();
	}

	private String kategorisi() {
		for (int i = 0; i < Kategori_veri_tabaný.getKategoriler().size(); i++) {
			if (Kategori_veri_tabaný.getKategoriler().elementAt(i)
					.getKategori_no() == getKategori()) {
				return Kategori_veri_tabaný.getKategoriler().elementAt(i)
						.getKategori_adý();
			}
		}
		String uyarý = "Kategorilenmemiþ\n"
				+ "Eðer böyle bir ürün bitki veri tabanýnda bulunuyorsa\n"
				+ "1)Varsa lütfen kategori.txt dosyasýndaki hatayý düzeltin\n"
				+ "2)Bitki veri tabanýna veri yanlýþ girilmiþ olabilir\n"
				+ "3)Varsa lütfen bitki.txt dosyasýndaki hatayý düzeltin\n";
		return uyarý;
	}

	public String önerilen_hastalýklar_toString() {
		String metin = "";
		for (int i = 0; i < önerilen_hastalýklar.size(); i++) {
			metin += "\n" + önerilen_hastalýklar.elementAt(i);
		}
		return metin;
	}

	public String özellikleri_toString() {
		String metin = "";
		for (int i = 0; i < özellikleri.size(); i++) {
			metin += "\n" + özellikleri.elementAt(i);
		}
		return metin;
	}

}
