package test;

import java.io.IOException;

import veri_taban�.Bitki_veri_taban�;

public class Test {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Bitki_veri_taban� datebase = new Bitki_veri_taban�("bitki.txt");
		datebase.add_botan();
		datebase.update_file();
	}

}
