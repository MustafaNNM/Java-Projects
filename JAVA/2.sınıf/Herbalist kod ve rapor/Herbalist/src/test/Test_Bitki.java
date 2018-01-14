package test;

import java.io.IOException;
import java.util.Vector;

import deva.Bitki;

public class Test_Bitki {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Bitki botan=new Bitki("0","-1", "0", "0", "0","0","0","0");
		String adý="Maraþ otu",diskteki_adý="Maragee",diskteki_yeri="C:\\",latince_adý="Marageeka Botanika";
		Vector<String> özellikleri=new Vector<String>();
		özellikleri.add("Anestezi");
		float fiyatý=(float) 1.9;
		int miktarý=23;
		Vector<String> önerilen_hastalýklar=new Vector<String>();
		önerilen_hastalýklar.add("Aðrý");
		önerilen_hastalýklar.add("Depresyon");
		önerilen_hastalýklar.add("Psikolojik Hastalýklar");
		botan.setAdý(adý);
		botan.setDiskteki_adý(diskteki_adý);
		botan.setDiskteki_yeri(diskteki_yeri);
		botan.setFiyatý(fiyatý);
		botan.setLatince_adý(latince_adý);
		botan.setMiktarý(miktarý);
		botan.setÖnerilen_hastalýklar(önerilen_hastalýklar);
		botan.setÖzellikleri(özellikleri);
		botan.setKategori(-1);
		System.out.println(botan);
	}

}
