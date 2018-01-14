package veri_tabaný;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import deva.Kategori;

public class bitki_kategorilerini_oku {
	//Kategoriye iliþkin bilgiler(kategori_no#Kategori_adý)
	public static Vector<Kategori> dosya_oku(final String fileName) {
		
		Vector<Kategori> kategoriler=new Vector<Kategori>();
		int no;
		// burada tanimliyoruz boylece finally blogunda gorulebiliyor
				BufferedReader input = null;
				try {
					// her okumada tek satir okuyacak sekilde kullanabilecegimiz yapi
					input = new BufferedReader(new FileReader(fileName));

					String line = null; // while dongusu icinde tanimlamiyoruz
					while ((line = input.readLine()) != null) {
						final StringTokenizer st = new StringTokenizer(line, "#");
						no=Integer.parseInt(st.nextToken());
						Kategori kategori=new Kategori(no,st.nextToken());
						kategoriler.add(kategori);
					}
				} catch (final FileNotFoundException ex) {
					// Dosya bulunamadi hatasi
					// Bir hata olusursa ekrana yaziyoruz
					ex.printStackTrace();
				} catch (final IOException ex) {
					// Herhangi bir I/O hatasi
					// Bir hata olusursa ekrana yaziyoruz
					ex.printStackTrace();
				} finally {
					try {
						if (input != null) {
							// actigimiz dosyayi kapatmaliyiz
							input.close();
						}
					} catch (final IOException ex) {
						// Bir hata olusursa ekrana yaziyoruz
						ex.printStackTrace();
					}
				}
		return kategoriler;
	}

}
