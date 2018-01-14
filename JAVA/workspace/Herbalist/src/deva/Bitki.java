package deva;

import java.util.StringTokenizer;
import java.util.Vector;

import veri_taban�.Kategori_veri_taban�;

//Bitkiye ili�kin bilgiler(bitki ad�, kategori,bitkinin latince ismi,bitkinin �zellikleri,miktar�,fiyat�,bitki resminin diskteki yeri ve ad�,bilgi say�s�(�nerilen hastal�klar i�in),�nerilen hastal�klar)
// Bitkiye ili�kin bilgiler(dosyadaki hali)(bitki ad�# kategori(bitkiler i�in 0,bitki
// �aylar� i�in 1,vitaminler i�in 2)#bitkinin latince ismi#bitkinin
// �zellikleri( _ ile ayr�l�d�r)#miktar�#fiyat�#bitki resminin diskteki
// yeri#bitki resminin diskteki ad�#bilgi say�s�(�nerilen hastal�klar
// i�in)#�nerilen hastal�klar(>>ile ayr�lm��t�r)
public class Bitki {
	private String ad� = "asd", latince_ad� = "", diskteki_yeri = "",
			diskteki_ad� = "";
	private int miktar�;// paket cinsinden
	private float fiyat�;
	private int kategori;
	private Vector<String> �nerilen_hastal�klar;
	private Vector<String> �zellikleri;

	public Bitki(String ad�, String kategori, String latince_ad�, int miktar�,
			float fiyat�, String diskteki_yeri, String diskteki_ad�,
			Vector<String> �nerilen_hastal�klar, Vector<String> �zellikleri) {
		setAd�(ad�);
		setKategori(Integer.parseInt(kategori));
		setLatince_ad�(latince_ad�);
		setMiktar�(miktar�);
		setFiyat�(fiyat�);
		setDiskteki_yeri(diskteki_yeri);
		setDiskteki_ad�(diskteki_ad�);
		set�nerilen_hastal�klar(�nerilen_hastal�klar);
		set�zellikleri(�zellikleri);
	}

	public Bitki(String ad�, String kategori, String latince_ad�,
			String �zellikleri, String miktar�, String fiyat�,
			String diskteki_yeri, String diskteki_ad�) {
		setAd�(ad�);
		setKategori(Integer.parseInt(kategori));
		setLatince_ad�(latince_ad�);
		setMiktar�(Integer.parseInt(miktar�));
		setFiyat�(Float.parseFloat(fiyat�));
		setDiskteki_yeri(diskteki_yeri);
		setDiskteki_ad�(diskteki_ad�);

		set�nerilen_hastal�klar(new Vector<String>());
		set�zellikleri(new Vector<String>());

		StringTokenizer st3 = new StringTokenizer(�zellikleri, "_");
		while (st3.hasMoreTokens()) {
			get�zellikleri().add(st3.nextToken());// �zellik ekleniyor
		}
	}

	public String getAd�() {
		return ad�;
	}

	public void setAd�(String ad�) {
		this.ad� = ad�;
	}

	public int getKategori() {
		return kategori;
	}

	public void setKategori(int kategori) {
		this.kategori = kategori;
	}

	public String getLatince_ad�() {
		return latince_ad�;
	}

	public void setLatince_ad�(String latince_ad�) {
		this.latince_ad� = latince_ad�;
	}

	public String getDiskteki_yeri() {
		return diskteki_yeri;
	}

	public void setDiskteki_yeri(String diskteki_yeri) {
		this.diskteki_yeri = diskteki_yeri;
	}

	public String getDiskteki_ad�() {
		return diskteki_ad�;
	}

	public void setDiskteki_ad�(String diskteki_ad�) {
		this.diskteki_ad� = diskteki_ad�;
	}

	public int getMiktar�() {
		return miktar�;
	}

	public void setMiktar�(int miktar�) {
		this.miktar� = miktar�;
	}

	public float getFiyat�() {
		return fiyat�;
	}

	public void setFiyat�(float fiyat�) {
		this.fiyat� = fiyat�;
	}

	public Vector<String> get�nerilen_hastal�klar() {
		return �nerilen_hastal�klar;
	}

	public void set�nerilen_hastal�klar(Vector<String> �nerilen_hastal�klar) {
		this.�nerilen_hastal�klar = �nerilen_hastal�klar;
	}

	public Vector<String> get�zellikleri() {
		return �zellikleri;
	}

	public void set�zellikleri(Vector<String> �zellikleri) {
		this.�zellikleri = �zellikleri;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Ad�           : ");
		stringBuilder.append(ad�);
		stringBuilder.append("\nKategori      : ");
		stringBuilder.append(kategorisi());
		stringBuilder.append("\nLatince ad�   : ");
		stringBuilder.append(latince_ad�);
		stringBuilder.append("\n�zellikleri   : ");
		stringBuilder.append(�zellikleri_toString());
		stringBuilder.append("\n\nDiskteki Yeri : ");
		stringBuilder.append(diskteki_yeri);
		stringBuilder.append("\nDiskteki Ad�  : ");
		stringBuilder.append(diskteki_ad�);
		stringBuilder.append("\nMiktar�       : ");
		stringBuilder.append(miktar�);
		stringBuilder.append(" Paket");
		stringBuilder.append("\nFiyat�        : ");
		stringBuilder.append(fiyat�);
		stringBuilder.append("\n\n�nerilen Hastal�klar\n");
		stringBuilder.append(�nerilen_hastal�klar_toString());

		return stringBuilder.toString();
	}

	private String kategorisi() {
		for (int i = 0; i < Kategori_veri_taban�.getKategoriler().size(); i++) {
			if (Kategori_veri_taban�.getKategoriler().elementAt(i)
					.getKategori_no() == getKategori()) {
				return Kategori_veri_taban�.getKategoriler().elementAt(i)
						.getKategori_ad�();
			}
		}
		String uyar� = "Kategorilenmemi�\n"
				+ "E�er b�yle bir �r�n bitki veri taban�nda bulunuyorsa\n"
				+ "1)Varsa l�tfen kategori.txt dosyas�ndaki hatay� d�zeltin\n"
				+ "2)Bitki veri taban�na veri yanl�� girilmi� olabilir\n"
				+ "3)Varsa l�tfen bitki.txt dosyas�ndaki hatay� d�zeltin\n";
		return uyar�;
	}

	public String �nerilen_hastal�klar_toString() {
		String metin = "";
		for (int i = 0; i < �nerilen_hastal�klar.size(); i++) {
			metin += "\n" + �nerilen_hastal�klar.elementAt(i);
		}
		return metin;
	}

	public String �zellikleri_toString() {
		String metin = "";
		for (int i = 0; i < �zellikleri.size(); i++) {
			metin += "\n" + �zellikleri.elementAt(i);
		}
		return metin;
	}

}
