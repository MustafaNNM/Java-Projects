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
		String ad�="Mara� otu",diskteki_ad�="Maragee",diskteki_yeri="C:\\",latince_ad�="Marageeka Botanika";
		Vector<String> �zellikleri=new Vector<String>();
		�zellikleri.add("Anestezi");
		float fiyat�=(float) 1.9;
		int miktar�=23;
		Vector<String> �nerilen_hastal�klar=new Vector<String>();
		�nerilen_hastal�klar.add("A�r�");
		�nerilen_hastal�klar.add("Depresyon");
		�nerilen_hastal�klar.add("Psikolojik Hastal�klar");
		botan.setAd�(ad�);
		botan.setDiskteki_ad�(diskteki_ad�);
		botan.setDiskteki_yeri(diskteki_yeri);
		botan.setFiyat�(fiyat�);
		botan.setLatince_ad�(latince_ad�);
		botan.setMiktar�(miktar�);
		botan.set�nerilen_hastal�klar(�nerilen_hastal�klar);
		botan.set�zellikleri(�zellikleri);
		botan.setKategori(-1);
		System.out.println(botan);
	}

}
