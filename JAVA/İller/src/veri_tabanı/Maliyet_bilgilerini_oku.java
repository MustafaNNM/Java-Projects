package veri_tabaný;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

public class Maliyet_bilgilerini_oku {
	public static Vector<Integer> dosya_oku(String filename){
		Vector<Integer> weight=new Vector<Integer>();
		
		// burada tanimliyoruz boylece finally blogunda gorulebiliyor
		BufferedReader input = null;
		try {
			// her okumada tek satir okuyacak sekilde kullanabilecegimiz yapi
			input = new BufferedReader(new FileReader(filename));

			String line = null; // while dongusu icinde tanimlamiyoruz
			int no;
			while ((line = input.readLine()) != null) {
				weight.add(new Vector<Integer>());
				final StringTokenizer st = new StringTokenizer(line, "_");
				no=Integer.parseInt(st.nextToken());
				weight.add(no);
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
		return weight;
	}
}
