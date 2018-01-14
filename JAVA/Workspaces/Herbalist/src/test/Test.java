package test;

import java.io.IOException;

import veri_tabaný.Bitki_veri_tabaný;

public class Test {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Bitki_veri_tabaný datebase = new Bitki_veri_tabaný("bitki.txt");
		datebase.add_botan();
		datebase.update_file();
	}

}
