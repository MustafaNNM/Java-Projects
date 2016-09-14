package test;

import java.io.IOException;

import veri_tabani.Bitki_veri_tabani;

public class Test {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Bitki_veri_tabani datebase = new Bitki_veri_tabani("bitki.txt");
		datebase.add_botan();
		datebase.update_file();
	}

}
