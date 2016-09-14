package veri_taban�;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import dert.Hastal�k;

public class hastal�k_verilerini_oku {
	// Hastal�klara ili�kin bilgiler(Hastal�k ad�,belirtileri
	// ,nedenleri,tedavisi,�nerilen bitkiler )
	// Hastal�k ad�#belirtileri(_ ile tutuluyor)#nedenleri(_ ile
	// tutuluyor)#tedavisi(_ ile tutuluyor)#bilgi_say�s�>>�nerilen bitkiler(>>
	// ile tutuluyor)
	public static Vector<Hastal�k> dosya_oku(final String fileName) {
		Vector<Hastal�k> hastal�klar = new Vector<Hastal�k>();

		// burada tanimliyoruz boylece finally blogunda gorulebiliyor
		BufferedReader input = null;
		try {
			// her okumada tek satir okuyacak sekilde kullanabilecegimiz yapi
			input = new BufferedReader(new FileReader(fileName));

			String line = null; // while dongusu icinde tanimlamiyoruz
			Hastal�k hastal�k;
			StringTokenizer st;
			while ((line = input.readLine()) != null) {
				st = new StringTokenizer(line, "#");
				hastal�k = new Hastal�k(st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken());
				hastal�klar.add(hastal�k);
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
		return hastal�klar;
	}
}
