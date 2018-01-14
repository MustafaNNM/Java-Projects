package veri_tabaný;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import dert.Hastalýk;

public class hastalýk_verilerini_oku {
	// Hastalýklara iliþkin bilgiler(Hastalýk adý,belirtileri
	// ,nedenleri,tedavisi,önerilen bitkiler )
	// Hastalýk adý#belirtileri(_ ile tutuluyor)#nedenleri(_ ile
	// tutuluyor)#tedavisi(_ ile tutuluyor)#bilgi_sayýsý>>önerilen bitkiler(>>
	// ile tutuluyor)
	public static Vector<Hastalýk> dosya_oku(final String fileName) {
		Vector<Hastalýk> hastalýklar = new Vector<Hastalýk>();

		// burada tanimliyoruz boylece finally blogunda gorulebiliyor
		BufferedReader input = null;
		try {
			// her okumada tek satir okuyacak sekilde kullanabilecegimiz yapi
			input = new BufferedReader(new FileReader(fileName));

			String line = null; // while dongusu icinde tanimlamiyoruz
			Hastalýk hastalýk;
			StringTokenizer st;
			while ((line = input.readLine()) != null) {
				st = new StringTokenizer(line, "#");
				hastalýk = new Hastalýk(st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken());
				hastalýklar.add(hastalýk);
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
		return hastalýklar;
	}
}
