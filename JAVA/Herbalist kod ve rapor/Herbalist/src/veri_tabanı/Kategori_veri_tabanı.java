package veri_taban�;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import deva.Kategori;

public class Kategori_veri_taban� {
	private static Vector<Kategori> kategoriler;
	private int aranan_kategori_ka��n��_s�rada_bulundu;
	private static String kulland���_dosya = "";

	public Kategori_veri_taban�(String dosya_ad�) {
		setKulland���_dosya(dosya_ad�);
		setKategoriler(bitki_kategorilerini_oku
				.dosya_oku(getKulland���_dosya()));
	}

	public static Vector<Kategori> getKategoriler() {
		return kategoriler;
	}

	public void setKategoriler(Vector<Kategori> kategoriler) {
		Kategori_veri_taban�.kategoriler = kategoriler;
	}

	public static String getKulland���_dosya() {
		return kulland���_dosya;
	}

	public void setKulland���_dosya(String kulland���_dosya) {
		Kategori_veri_taban�.kulland���_dosya = kulland���_dosya;
	}

	// Kategoriye ili�kin bilgiler(kategori_no#Kategori_ad�)
	public void add_kategori(Kategori kategori) {
		kategoriler.add(kategori);
	}

	public void update_file() {
		String metin = "";
		Kategori kategori;

		try {
			final BufferedWriter out = new BufferedWriter(new FileWriter(
					getKulland���_dosya()));
			final PrintWriter pw = new PrintWriter(out);
			// buffer i�in flussh metodu var
			for (int i = 0; i < kategoriler.size(); i++) {
				kategori = kategoriler.elementAt(i);
				metin += i + "#" + kategori.getKategori_ad�();
				pw.println(metin);
				pw.flush();
				metin = "";
			}
			out.close();
		} catch (final IOException e) {
		}
	}

	public int bitkinin_kategorisini_bul(int aranan) {
		for (int i = 0; i < kategoriler.size(); i++) {
			if (aranan == kategoriler.elementAt(i).getKategori_no()) {
				return i;
			}
		}
		return kategoriler.size();
	}

	public String kategoriyi_ara�t�r(String aranan) {
		String yan�t = "B�yle Bir Kategori Bulunmamaktad�r";
		int i;
		for (i = 0; i < kategoriler.size(); i++) {
			if (aranan.compareTo(kategoriler.elementAt(i).getKategori_ad�()) == 0) {
				setAranan_kategori_ka��n��_s�rada_bulundu(i);
				yan�t ="Bulundu";
				return yan�t;
			}
		}
		setAranan_kategori_ka��n��_s�rada_bulundu(i);
		return yan�t;
	}

	public void setAranan_kategori_ka��n��_s�rada_bulundu(
			int aranan_kategori_ka��n��_s�rada_bulundu) {
		this.aranan_kategori_ka��n��_s�rada_bulundu = aranan_kategori_ka��n��_s�rada_bulundu;
	}

	public int getAranan_kategori_ka��n��_s�rada_bulundu() {
		return aranan_kategori_ka��n��_s�rada_bulundu;
	}
	public String toString(){
		String metin="";
		for (int i = 0; i < kategoriler.size(); i++) {
				metin+=kategoriler.elementAt(i).toString()+"\n\n";
		}
		return metin;
	}
	public void kategoriyi_sil(){
		kategoriler.removeElementAt(getAranan_kategori_ka��n��_s�rada_bulundu());
	}
}
