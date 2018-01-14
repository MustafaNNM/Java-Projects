package test;

import java.io.IOException;

import deva.Kategori;

import veri_tabaný.Kategori_veri_tabaný;

public class Test_Kategori {

	private static Kategori_veri_tabaný kategori_veri_tabaný;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		setKategori_veri_tabaný(new Kategori_veri_tabaný("kategori.txt"));
		getKategori_veri_tabaný();
		Kategori kategori = new Kategori(Kategori_veri_tabaný.getKategoriler().size(),"Çiçekler");
		kategori_veri_tabaný.add_kategori(kategori);
		System.out.println(Kategori_veri_tabaný.getKategoriler().lastElement().getKategori_adý());
		kategori_veri_tabaný.update_file();
	}

	public static void setKategori_veri_tabaný(Kategori_veri_tabaný kategori_veri_tabaný) {
		Test_Kategori.kategori_veri_tabaný = kategori_veri_tabaný;
	}

	public static Kategori_veri_tabaný getKategori_veri_tabaný() {
		return kategori_veri_tabaný;
	}

}
