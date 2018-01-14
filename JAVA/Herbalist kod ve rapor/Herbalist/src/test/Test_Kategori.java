package test;

import java.io.IOException;

import deva.Kategori;

import veri_taban�.Kategori_veri_taban�;

public class Test_Kategori {

	private static Kategori_veri_taban� kategori_veri_taban�;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		setKategori_veri_taban�(new Kategori_veri_taban�("kategori.txt"));
		getKategori_veri_taban�();
		Kategori kategori = new Kategori(Kategori_veri_taban�.getKategoriler().size(),"�i�ekler");
		kategori_veri_taban�.add_kategori(kategori);
		System.out.println(Kategori_veri_taban�.getKategoriler().lastElement().getKategori_ad�());
		kategori_veri_taban�.update_file();
	}

	public static void setKategori_veri_taban�(Kategori_veri_taban� kategori_veri_taban�) {
		Test_Kategori.kategori_veri_taban� = kategori_veri_taban�;
	}

	public static Kategori_veri_taban� getKategori_veri_taban�() {
		return kategori_veri_taban�;
	}

}
