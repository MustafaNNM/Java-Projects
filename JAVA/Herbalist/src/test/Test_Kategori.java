package test;

import java.io.IOException;

import deva.Kategori;

import veri_tabani.Kategori_veri_tabani;

public class Test_Kategori {

	private static Kategori_veri_tabani kategori_veri_tabaný;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		setKategori_veri_tabani(new Kategori_veri_tabani("kategori.txt"));
		getKategori_veri_tabani();
		Kategori kategori = new Kategori(Kategori_veri_tabani.getKategoriler().size(),"Çiçekler");
		kategori_veri_tabaný.add_kategori(kategori);
		System.out.println(Kategori_veri_tabani.getKategoriler().lastElement().getKategori_adi());
		kategori_veri_tabaný.update_file();
	}

	public static void setKategori_veri_tabani(Kategori_veri_tabani kategori_veri_tabani) {
		Test_Kategori.kategori_veri_tabaný = kategori_veri_tabani;
	}

	public static Kategori_veri_tabani getKategori_veri_tabani() {
		return kategori_veri_tabaný;
	}

}
