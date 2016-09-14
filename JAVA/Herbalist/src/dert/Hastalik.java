package dert;

import java.util.StringTokenizer;
import java.util.Vector;

//Hastalıklara ilişkin bilgiler(Hastalık adı,belirtileri ,nedenleri,tedavisi,önerilen bitkiler )
//Hastalık adı#belirtileri(_ ile tutuluyor)#nedenleri(_ ile tutuluyor)#tedavisi(_ ile tutuluyor)#bilgi_sayısı>>önerilen bitkiler(>> ile tutuluyor)
public class Hastalik {
	public static StringTokenizer st;
	private String adi = "";
	private Vector<String> belirtileri, nedenleri;
	private HastalikData Operasyon = new HastalikData();

	public Hastalik(String adi, Vector<String> belirtileri,
			Vector<String> nedenleri, Vector<String> tedavisi,
			Vector<String> onerilen_bitkiler) {
		setAdi(adi);
		setBelirtileri(belirtileri);
		setNedenleri(nedenleri);
		setTedavisi(tedavisi);
		setOnerilen_bitkiler(onerilen_bitkiler);
	}

	public Hastalik(String adi, String belirtileri, String nedenleri,
			String tedavisi, String onerilen_bitkiler) {
		setAdi(adi);
		System.out.println("adi: " + adi + "\n");
		setBelirtileri(new Vector<String>());
		setNedenleri(new Vector<String>());
		setTedavisi(new Vector<String>());
		setOnerilen_bitkiler(new Vector<String>());
		belirtileri(belirtileri);
		nedenleri(nedenleri);
		tedaviler(tedavisi);
		onerilen_bitkiler(onerilen_bitkiler);
	}

	private void belirtileri(String belirtileri) {
		st = new StringTokenizer(belirtileri, "_");
		while (st.hasMoreTokens()) {
			getBelirtileri().add(st.nextToken());// belirtiler ekleniyor
		}
	}

	private void nedenleri(String nedenleri) {
		st = new StringTokenizer(nedenleri, "_");
		while (st.hasMoreTokens()) {
			getNedenleri().add(st.nextToken());// nedenler ekleniyor
		}
	}

	private void tedaviler(String tedavisi) {
		st = new StringTokenizer(tedavisi, "_");
		while (st.hasMoreTokens()) {
			getTedavisi().add(st.nextToken());// tedaviler ekleniyor
		}
	}

	private void onerilen_bitkiler(String onerilen_bitkiler) {
		st = new StringTokenizer(onerilen_bitkiler, ">>");
		setBilgi_sayisi(Integer.parseInt(st.nextToken()));
		while (st.hasMoreTokens()) {
			getOnerilen_bitkiler().add(st.nextToken());// onerilen bitkiler ekleniyor
		}
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
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
		this.Operasyon.setTedavisi(tedavisi);
	}

	public Vector<String> getTedavisi() {
		return Operasyon.getTedavisi();
	}

	public void setOnerilen_bitkiler(Vector<String> onerilen_bitkiler) {
		this.Operasyon.setOnerilen_bitkiler(onerilen_bitkiler);
	}

	public Vector<String> getOnerilen_bitkiler() {
		return Operasyon.getOnerilen_bitkiler();
	}

	public void setBilgi_sayisi(int bilgi_sayisi) {
		this.Operasyon.setBilgi_sayisi(bilgi_sayisi);
	}

	public int getBilgi_sayisi() {
		return Operasyon.getBilgi_sayisi();
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Adi              :");
		stringBuilder.append(adi);
		stringBuilder.append("\nBelirtileri      :");
		stringBuilder.append(belirtileri_toString());
		stringBuilder.append("\nNedenleri        :");
		stringBuilder.append(nedenleri_toString());
		stringBuilder.append("\nTedavisi         :");
		stringBuilder.append(tedavisi_toString());
		stringBuilder.append("\nOnerilen Bitkiler:");
		stringBuilder.append(Onerilen_bitkiler_toString());
		System.out.println(stringBuilder.toString());
		return stringBuilder.toString();
	}

	public void add_Onerilen_bitki(String onerilen_bitki) {
		Operasyon.getOnerilen_bitkiler().add(onerilen_bitki);
	}

	private String Onerilen_bitkiler_toString() {
		String metin = "";
		for (int i = 0; i < Operasyon.getOnerilen_bitkiler().size(); i++) {
			metin += Operasyon.getOnerilen_bitkiler().elementAt(i);
		}
		return metin;
	}

	public void add_tedavi(String onerilen_tedavi) {
		Operasyon.getTedavisi().add(onerilen_tedavi);
	}

	private String tedavisi_toString() {
		String metin = "";
		for (int i = 0; i < Operasyon.getTedavisi().size(); i++) {
			metin += Operasyon.getTedavisi().elementAt(i);
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
