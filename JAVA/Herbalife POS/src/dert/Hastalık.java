package dert;

import java.util.StringTokenizer;
import java.util.Vector;

//Hastalıklara ilişkin bilgiler(Hastalık adı,belirtileri ,nedenleri,tedavisi,önerilen bitkiler )
//Hastalık adı#belirtileri(_ ile tutuluyor)#nedenleri(_ ile tutuluyor)#tedavisi(_ ile tutuluyor)#bilgi_sayısı>>önerilen bitkiler(>> ile tutuluyor)
public class Hastalık {
	public static StringTokenizer st;
	private String adı = "";
	private int bilgi_sayısı;
	private Vector<String> belirtileri, nedenleri, tedavisi, önerilen_bitkiler;

	public Hastalık(String adı, Vector<String> belirtileri,
			Vector<String> nedenleri, Vector<String> tedavisi,
			Vector<String> önerilen_bitkiler) {
		setAdı(adı);
		setBelirtileri(belirtileri);
		setNedenleri(nedenleri);
		setTedavisi(tedavisi);
		setÖnerilen_bitkiler(önerilen_bitkiler);
	}

	public Hastalık(String adı, String belirtileri, String nedenleri,
			String tedavisi, String önerilen_bitkiler) {
		setAdı(adı);
		System.out.println("adı: " + adı + "\n");
		setBelirtileri(new Vector<String>());
		setNedenleri(new Vector<String>());
		setTedavisi(new Vector<String>());
		setÖnerilen_bitkiler(new Vector<String>());
		st = new StringTokenizer(belirtileri, "_");
		while (st.hasMoreTokens()) {
			getBelirtileri().add(st.nextToken());// belirtiler ekleniyor
		}
		st = new StringTokenizer(nedenleri, "_");
		while (st.hasMoreTokens()) {
			getNedenleri().add(st.nextToken());// nedenler ekleniyor
		}
		st = new StringTokenizer(tedavisi, "_");
		while (st.hasMoreTokens()) {
			getTedavisi().add(st.nextToken());// tedaviler ekleniyor
		}
		st = new StringTokenizer(önerilen_bitkiler, ">>");
		setBilgi_sayısı(Integer.parseInt(st.nextToken()));
		while (st.hasMoreTokens()) {
			getÖnerilen_bitkiler().add(st.nextToken());// tedaviler ekleniyor
		}
	}

	public String getAdı() {
		return adı;
	}

	public void setAdı(String adı) {
		this.adı = adı;
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

	public void setBilgi_sayısı(int bilgi_sayısı) {
		this.bilgi_sayısı = bilgi_sayısı;
	}

	public int getBilgi_sayısı() {
		return bilgi_sayısı;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Adı              :");
		stringBuilder.append(adı);
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
