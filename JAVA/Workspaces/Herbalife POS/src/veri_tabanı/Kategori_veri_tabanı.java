package veri_tabaný;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import deva.Kategori;

public class Kategori_veri_tabaný {
	private static Vector<Kategori> kategoriler;
	private int aranan_kategori_kaçýnçý_sýrada_bulundu;
	private static String kullandýðý_dosya = "";

	public Kategori_veri_tabaný(String dosya_adý) {
		setKullandýðý_dosya(dosya_adý);
		setKategoriler(bitki_kategorilerini_oku
				.dosya_oku(getKullandýðý_dosya()));
	}

	public static Vector<Kategori> getKategoriler() {
		return kategoriler;
	}

	public void setKategoriler(Vector<Kategori> kategoriler) {
		Kategori_veri_tabaný.kategoriler = kategoriler;
	}

	public static String getKullandýðý_dosya() {
		return kullandýðý_dosya;
	}

	public void setKullandýðý_dosya(String kullandýðý_dosya) {
		Kategori_veri_tabaný.kullandýðý_dosya = kullandýðý_dosya;
	}

	// Kategoriye iliþkin bilgiler(kategori_no#Kategori_adý)
	public void add_kategori(Kategori kategori) {
		kategoriler.add(kategori);
	}

	public void update_file() {
		String metin = "";
		Kategori kategori;

		try {
			final BufferedWriter out = new BufferedWriter(new FileWriter(
					getKullandýðý_dosya()));
			final PrintWriter pw = new PrintWriter(out);
			// buffer için flussh metodu var
			for (int i = 0; i < kategoriler.size(); i++) {
				kategori = kategoriler.elementAt(i);
				metin += i + "#" + kategori.getKategori_adý();
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

	public String kategoriyi_araþtýr(String aranan) {
		String yanýt = "Böyle Bir Kategori Bulunmamaktadýr";
		int i;
		for (i = 0; i < kategoriler.size(); i++) {
			if (aranan.compareTo(kategoriler.elementAt(i).getKategori_adý()) == 0) {
				setAranan_kategori_kaçýnçý_sýrada_bulundu(i);
				yanýt ="Bulundu";
				return yanýt;
			}
		}
		setAranan_kategori_kaçýnçý_sýrada_bulundu(i);
		return yanýt;
	}

	public void setAranan_kategori_kaçýnçý_sýrada_bulundu(
			int aranan_kategori_kaçýnçý_sýrada_bulundu) {
		this.aranan_kategori_kaçýnçý_sýrada_bulundu = aranan_kategori_kaçýnçý_sýrada_bulundu;
	}

	public int getAranan_kategori_kaçýnçý_sýrada_bulundu() {
		return aranan_kategori_kaçýnçý_sýrada_bulundu;
	}
	public String toString(){
		String metin="";
		for (int i = 0; i < kategoriler.size(); i++) {
				metin+=kategoriler.elementAt(i).toString()+"\n\n";
		}
		return metin;
	}
	public void kategoriyi_sil(){
		kategoriler.removeElementAt(getAranan_kategori_kaçýnçý_sýrada_bulundu());
	}
}
