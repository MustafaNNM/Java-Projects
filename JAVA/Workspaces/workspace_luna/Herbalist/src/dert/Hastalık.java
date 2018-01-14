package dert;

import java.util.StringTokenizer;
import java.util.Vector;

//Hastalýklara iliþkin bilgiler(Hastalýk adý,belirtileri ,nedenleri,tedavisi,önerilen bitkiler )
//Hastalýk adý#belirtileri(_ ile tutuluyor)#nedenleri(_ ile tutuluyor)#tedavisi(_ ile tutuluyor)#bilgi_sayýsý>>önerilen bitkiler(>> ile tutuluyor)
public class Hastalýk {
	public static StringTokenizer st;
	private String adý = "";
	private int bilgi_sayýsý;
	private Vector<String> belirtileri;
	private Vector<String> nedenleri;
	private Vector<String> tedavisi;
	private Vector<String> önerilen_bitkiler;

	public Hastalýk(String adý, Vector<String> belirtileri,
			Vector<String> nedenleri, Vector<String> tedavisi,
			Vector<String> önerilen_bitkiler) {
		setAdý(adý);
		setBelirtileri(belirtileri);
		setNedenleri(nedenleri);
		setTedavisi(tedavisi);
		setÖnerilen_bitkiler(önerilen_bitkiler);
	}

	public Hastalýk(String adý, String belirtileri, String nedenleri,
			String tedavisi, String önerilen_bitkiler) {
		setAdý(adý);
		System.out.println("adý: " + adý + "\n");
		degiskenler_icin_hafizadan_yer_ayýrt();
		hastalikla_ilgili_bilgileri_ekle(belirtileri, nedenleri, tedavisi,
				önerilen_bitkiler);
	}

	/**
	 * 
	 */
	private void degiskenler_icin_hafizadan_yer_ayýrt() {
		setBelirtileri(new Vector<String>());
		setNedenleri(new Vector<String>());
		setTedavisi(new Vector<String>());
		setÖnerilen_bitkiler(new Vector<String>());
	}

	/**
	 * @param belirtileri
	 * @param nedenleri
	 * @param tedavisi
	 * @param önerilen_bitkiler
	 * @throws NumberFormatException
	 */
	private void hastalikla_ilgili_bilgileri_ekle(String belirtileri,
			String nedenleri, String tedavisi, String önerilen_bitkiler)
			throws NumberFormatException {
		belirtileri_ekle(belirtileri);
		nedenleri_ekle(nedenleri);
		tedavi_yontemlerini_ekle(tedavisi);
		onerilen_bitkileri_ekle(önerilen_bitkiler);
	}

	/**
	 * @param önerilen_bitkiler
	 * @throws NumberFormatException
	 */
	private void onerilen_bitkileri_ekle(String önerilen_bitkiler)
			throws NumberFormatException {
		st = new StringTokenizer(önerilen_bitkiler, ">>");
		setBilgi_sayýsý(Integer.parseInt(st.nextToken()));
		while (st.hasMoreTokens()) {
			getÖnerilen_bitkiler().add(st.nextToken());// tedaviler ekleniyor
		}
	}

	/**
	 * @param tedavisi
	 */
	private void tedavi_yontemlerini_ekle(String tedavisi) {
		st = new StringTokenizer(tedavisi, "_");
		while (st.hasMoreTokens()) {
			getTedavisi().add(st.nextToken());// tedaviler ekleniyor
		}
	}

	/**
	 * @param nedenleri
	 */
	private void nedenleri_ekle(String nedenleri) {
		st = new StringTokenizer(nedenleri, "_");
		while (st.hasMoreTokens()) {
			getNedenleri().add(st.nextToken());// nedenler ekleniyor
		}
	}

	/**
	 * @param belirtileri
	 */
	private void belirtileri_ekle(String belirtileri) {
		st = new StringTokenizer(belirtileri, "_");
		while (st.hasMoreTokens()) {
			getBelirtileri().add(st.nextToken());// belirtiler ekleniyor
		}
	}

	public String getAdý() {
		return adý;
	}

	public void setAdý(String adý) {
		this.adý = adý;
	}

	public void setBelirtileri(Vector<String> belirtileri) {
		this.belirtileri = belirtileri;
	}

	public Vector<String> getBelirtileri() {
		return belirtileri;
	}

	public void setNedenleri(Vector<String> nedenleri) {
		this.nedenleri = nedenleri;
	}

	public Vector<String> getNedenleri() {
		return nedenleri;
	}

	public void setTedavisi(Vector<String> tedavisi) {
		this.tedavisi = tedavisi;
	}

	public Vector<String> getTedavisi() {
		return tedavisi;
	}

	public void setÖnerilen_bitkiler(Vector<String> önerilen_bitkiler) {
		this.önerilen_bitkiler = önerilen_bitkiler;
	}

	public Vector<String> getÖnerilen_bitkiler() {
		return önerilen_bitkiler;
	}

	public void setBilgi_sayýsý(int bilgi_sayýsý) {
		this.bilgi_sayýsý = bilgi_sayýsý;
	}

	public int getBilgi_sayýsý() {
		return bilgi_sayýsý;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Adý              :");
		stringBuilder.append(adý);
		stringBuilder.append("\nBelirtileri      :");
		stringBuilder.append(belirtileri_toString());
		stringBuilder.append("\nNedenleri        :");
		stringBuilder.append(nedenleri_toString());
		stringBuilder.append("\nTedavisi         :");
		stringBuilder.append(tedavisi_toString());
		stringBuilder.append("\nÖnerilen Bitkiler:");
		stringBuilder.append(önerilen_bitkiler_toString());
		System.out.println(stringBuilder.toString());
		return stringBuilder.toString();
	}

	public void add_önerilen_bitki(String önerilen_bitki) {
		önerilen_bitkiler.add(önerilen_bitki);
	}

	private String önerilen_bitkiler_toString() {
		String metin = "";
		for (int i = 0; i < önerilen_bitkiler.size(); i++) {
			metin += önerilen_bitkiler.elementAt(i);
		}
		return metin;
	}

	public void add_tedavi(String önerilen_tedavi) {
		tedavisi.add(önerilen_tedavi);
	}

	private String tedavisi_toString() {
		String metin = "";
		for (int i = 0; i < tedavisi.size(); i++) {
			metin += tedavisi.elementAt(i);
		}
		return metin;
	}

	public void add_neden(String yeni_neden) {
		nedenleri.add(yeni_neden);
	}

	private String nedenleri_toString() {
		String metin = "";
		for (int i = 0; i < nedenleri.size(); i++) {
			metin += nedenleri.elementAt(i);
		}
		return metin;
	}

	private String belirtileri_toString() {
		String metin = "";
		for (int i = 0; i < belirtileri.size(); i++) {
			metin += belirtileri.elementAt(i);
		}
		return metin;
	}
}
