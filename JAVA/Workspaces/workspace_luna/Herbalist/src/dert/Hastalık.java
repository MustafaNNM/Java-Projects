package dert;

import java.util.StringTokenizer;
import java.util.Vector;

//Hastal�klara ili�kin bilgiler(Hastal�k ad�,belirtileri ,nedenleri,tedavisi,�nerilen bitkiler )
//Hastal�k ad�#belirtileri(_ ile tutuluyor)#nedenleri(_ ile tutuluyor)#tedavisi(_ ile tutuluyor)#bilgi_say�s�>>�nerilen bitkiler(>> ile tutuluyor)
public class Hastal�k {
	public static StringTokenizer st;
	private String ad� = "";
	private int bilgi_say�s�;
	private Vector<String> belirtileri;
	private Vector<String> nedenleri;
	private Vector<String> tedavisi;
	private Vector<String> �nerilen_bitkiler;

	public Hastal�k(String ad�, Vector<String> belirtileri,
			Vector<String> nedenleri, Vector<String> tedavisi,
			Vector<String> �nerilen_bitkiler) {
		setAd�(ad�);
		setBelirtileri(belirtileri);
		setNedenleri(nedenleri);
		setTedavisi(tedavisi);
		set�nerilen_bitkiler(�nerilen_bitkiler);
	}

	public Hastal�k(String ad�, String belirtileri, String nedenleri,
			String tedavisi, String �nerilen_bitkiler) {
		setAd�(ad�);
		System.out.println("ad�: " + ad� + "\n");
		degiskenler_icin_hafizadan_yer_ay�rt();
		hastalikla_ilgili_bilgileri_ekle(belirtileri, nedenleri, tedavisi,
				�nerilen_bitkiler);
	}

	/**
	 * 
	 */
	private void degiskenler_icin_hafizadan_yer_ay�rt() {
		setBelirtileri(new Vector<String>());
		setNedenleri(new Vector<String>());
		setTedavisi(new Vector<String>());
		set�nerilen_bitkiler(new Vector<String>());
	}

	/**
	 * @param belirtileri
	 * @param nedenleri
	 * @param tedavisi
	 * @param �nerilen_bitkiler
	 * @throws NumberFormatException
	 */
	private void hastalikla_ilgili_bilgileri_ekle(String belirtileri,
			String nedenleri, String tedavisi, String �nerilen_bitkiler)
			throws NumberFormatException {
		belirtileri_ekle(belirtileri);
		nedenleri_ekle(nedenleri);
		tedavi_yontemlerini_ekle(tedavisi);
		onerilen_bitkileri_ekle(�nerilen_bitkiler);
	}

	/**
	 * @param �nerilen_bitkiler
	 * @throws NumberFormatException
	 */
	private void onerilen_bitkileri_ekle(String �nerilen_bitkiler)
			throws NumberFormatException {
		st = new StringTokenizer(�nerilen_bitkiler, ">>");
		setBilgi_say�s�(Integer.parseInt(st.nextToken()));
		while (st.hasMoreTokens()) {
			get�nerilen_bitkiler().add(st.nextToken());// tedaviler ekleniyor
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

	public String getAd�() {
		return ad�;
	}

	public void setAd�(String ad�) {
		this.ad� = ad�;
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

	public void set�nerilen_bitkiler(Vector<String> �nerilen_bitkiler) {
		this.�nerilen_bitkiler = �nerilen_bitkiler;
	}

	public Vector<String> get�nerilen_bitkiler() {
		return �nerilen_bitkiler;
	}

	public void setBilgi_say�s�(int bilgi_say�s�) {
		this.bilgi_say�s� = bilgi_say�s�;
	}

	public int getBilgi_say�s�() {
		return bilgi_say�s�;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Ad�              :");
		stringBuilder.append(ad�);
		stringBuilder.append("\nBelirtileri      :");
		stringBuilder.append(belirtileri_toString());
		stringBuilder.append("\nNedenleri        :");
		stringBuilder.append(nedenleri_toString());
		stringBuilder.append("\nTedavisi         :");
		stringBuilder.append(tedavisi_toString());
		stringBuilder.append("\n�nerilen Bitkiler:");
		stringBuilder.append(�nerilen_bitkiler_toString());
		System.out.println(stringBuilder.toString());
		return stringBuilder.toString();
	}

	public void add_�nerilen_bitki(String �nerilen_bitki) {
		�nerilen_bitkiler.add(�nerilen_bitki);
	}

	private String �nerilen_bitkiler_toString() {
		String metin = "";
		for (int i = 0; i < �nerilen_bitkiler.size(); i++) {
			metin += �nerilen_bitkiler.elementAt(i);
		}
		return metin;
	}

	public void add_tedavi(String �nerilen_tedavi) {
		tedavisi.add(�nerilen_tedavi);
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
