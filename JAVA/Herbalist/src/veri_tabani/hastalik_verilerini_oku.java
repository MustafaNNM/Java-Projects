package veri_tabani;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import dert.Hastalik;

public class hastalik_verilerini_oku {
	// Hastalıklara ilişkin bilgiler(Hastalık adı,belirtileri
	// ,nedenleri,tedavisi,önerilen bitkiler )
	// Hastalık adı#belirtileri(_ ile tutuluyor)#nedenleri(_ ile
	// tutuluyor)#tedavisi(_ ile tutuluyor)#bilgi_sayısı>>önerilen bitkiler(>>
	// ile tutuluyor)
	public static Vector<Hastalik> dosya_oku(final String fileName) {
		Vector<Hastalik> hastaliklar = new Vector<Hastalik>();

		// burada tanimliyoruz boylece finally blogunda gorulebiliyor
		BufferedReader input = null;
		try {
			input = hastaliklari_olustur(fileName, hastaliklar);
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
		return hastaliklar;
	}

	private static BufferedReader hastaliklari_olustur(final String fileName,
			Vector<Hastalik> hastaliklar) throws FileNotFoundException,
			IOException {
		BufferedReader input;
		// her okumada tek satir okuyacak sekilde kullanabilecegimiz yapi
		input = new BufferedReader(new FileReader(fileName));

		String line = null; // while dongusu icinde tanimlamiyoruz
		Hastalik hastalik;
		StringTokenizer st;
		while ((line = input.readLine()) != null) {
			st = new StringTokenizer(line, "#");
			hastalik = new Hastalik(st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken());
			hastaliklar.add(hastalik);
		}
		return input;
	}
}
