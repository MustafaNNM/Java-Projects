package test;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import deva.Bitki;

public class BitkiTest {

	@Test
	public void test() {
		Bitki botan=new Bitki("0","-1", "0", "0", "0","0","0","0");
		String adi="Maraþ otu",diskteki_adi="Maragee",diskteki_yeri="C:\\",latince_adi="Marageeka Botanika";
		Vector<String> ozellikleri=new Vector<String>();
		ozellikleri.add("Anestezi");
		float fiyati=(float) 1.9;
		int miktari=23;
		Vector<String> onerilen_hastaliklar=new Vector<String>();
		onerilen_hastaliklar.add("Agri");
		onerilen_hastaliklar.add("Depresyon");
		onerilen_hastaliklar.add("Psikolojik Hastaliklar");
		botan.setAdi(adi);
		botan.setDiskteki_adi(diskteki_adi);
		botan.setDiskteki_yeri(diskteki_yeri);
		botan.setFiyati(fiyati);
		botan.setLatince_adi(latince_adi);
		botan.setMiktari(miktari);
		botan.setOnerilen_hastaliklar(onerilen_hastaliklar);
		botan.setOzellikleri(ozellikleri);
		botan.setKategori(-1);
		
		assertEquals("Maraþ otu",botan.getAdi());
		System.out.println(botan);
	}

}
