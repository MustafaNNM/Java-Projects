package veri_tabani;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import deva.Kategori;

public class Kategori_veri_tabani {
	private static Vector<Kategori> kategoriler;
	private int aranan_kategori_kacinci_sirada_bulundu;
	private static String kullandigi_dosya = "";

	public Kategori_veri_tabani(String dosya_adi) {
		setKullandigi_dosya(dosya_adi);
		setKategoriler(bitki_kategorilerini_oku
				.dosya_oku(getKullandigi_dosya()));
	}

	public static Vector<Kategori> getKategoriler() {
		return kategoriler;
	}

	public void setKategoriler(Vector<Kategori> kategoriler) {
		Kategori_veri_tabani.kategoriler = kategoriler;
	}

	public static String getKullandigi_dosya() {
		return kullandigi_dosya;
	}

	public void setKullandigi_dosya(String kullandigi_dosya) {
		Kategori_veri_tabani.kullandigi_dosya = kullandigi_dosya;
	}

	// Kategoriye iliskin bilgiler(kategori_no#Kategori_adi)
	public void add_kategori(Kategori kategori) {
		kategoriler.add(kategori);
	}

	public void update_file() {
		String metin = "";

		try {
			dosyayi_guncelle(metin);
		} catch (final IOException e) {
		}
	}

	private void dosyayi_guncelle(String metin) throws IOException {
		Kategori kategori;
		final BufferedWriter out = new BufferedWriter(new FileWriter(
				getKullandigi_dosya()));
		final PrintWriter pw = new PrintWriter(out);
		// buffer için flussh metodu var
		for (int i = 0; i < kategoriler.size(); i++) {
			kategori = kategoriler.elementAt(i);
			metin += i + "#" + kategori.getKategori_adi();
			pw.println(metin);
			pw.flush();
			metin = "";
		}
		out.close();
	}

	public int bitkinin_kategorisini_bul(int aranan) {
		for (int i = 0; i < kategoriler.size(); i++) {
			if (aranan == kategoriler.elementAt(i).getKategori_no()) {
				return i;
			}
		}
		return kategoriler.size();
	}

	public String kategoriyi_arastir(String aranan) {
		String yanit = "Boyle Bir Kategori Bulunmamaktadır";
		int i;
		for (i = 0; i < kategoriler.size(); i++) {
			if (aranan.compareTo(kategoriler.elementAt(i).getKategori_adi()) == 0) {
				setAranan_kategori_kacinci_sirada_bulundu(i);
				yanit ="Bulundu";
				return yanit;
			}
		}
		setAranan_kategori_kacinci_sirada_bulundu(i);
		return yanit;
	}

	public void setAranan_kategori_kacinci_sirada_bulundu(
			int aranan_kategori_kacinci_sirada_bulundu) {
		this.aranan_kategori_kacinci_sirada_bulundu = aranan_kategori_kacinci_sirada_bulundu;
	}

	public int getAranan_kategori_kacinci_sirada_bulundu() {
		return aranan_kategori_kacinci_sirada_bulundu;
	}
	public String toString(){
		String metin="";
		for (int i = 0; i < kategoriler.size(); i++) {
				metin+=kategoriler.elementAt(i).toString()+"\n\n";
		}
		return metin;
	}
	public void kategoriyi_sil(){
		kategoriler.removeElementAt(getAranan_kategori_kacinci_sirada_bulundu());
	}
}
