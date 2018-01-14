/*
 * Created on 07.Mar.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author cenk
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TestOgrenci {

	public static void main(String args[]) {
		Ogrenci ogr1=new Ogrenci();
		Ogrenci ogr2=new Ogrenci(3333,"ali","veli","bornova");
		ogr1.setNumara(2222);
		ogr1.setAd("ahmet");
		ogr1.setSoyad("demir");
		ogr1.setAdres("konak");
		System.out.println("2. Ogrenci Adresi" +ogr1.getAdres());
		for (int i=0;i<5;i++) 
			ogr1.kitap_oku();
		ogr1.kimlik_yaz();
		ogr2.kitap_oku();
		ogr2.kimlik_yaz();
		
	}
}
