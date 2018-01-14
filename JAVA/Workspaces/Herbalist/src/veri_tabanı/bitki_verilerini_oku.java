package veri_tabaný;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import deva.Bitki;

public class bitki_verilerini_oku {
	// Bitkiye iliþkin bilgiler(bitki adý# kategori(bitkiler için 0,bitki
	// çaylarý için 1,vitaminler için 2)#bitkinin latince ismi#bitkinin
	// özellikleri( _ ile ayrýlýdýr)#miktarý#fiyatý#bitki resminin diskteki
	// yeri#bitki resminin diskteki adý#bilgi sayýsý(önerilen hastalýklar
	// için)#önerilen hastalýklar(>>ile ayrýlmýþtýr)
	// final Vector<Kisi> kisiler =
	// kisileriOku("kullanýcýlar.txt");

	public static Vector<Bitki> dosya_oku(final String fileName) {
		Vector<Bitki> bitkiler = new Vector<Bitki>();

		// burada tanimliyoruz boylece finally blogunda gorulebiliyor
		BufferedReader input = null;
		try {
			// her okumada tek satir okuyacak sekilde kullanabilecegimiz yapi
			input = new BufferedReader(new FileReader(fileName));

			String line = null; // while dongusu icinde tanimlamiyoruz
			Bitki bitki;
			StringTokenizer st;
			StringTokenizer st2;
			StringTokenizer st3;
			int bilgi_sayýsý;
			while ((line = input.readLine()) != null) {
				st = new StringTokenizer(line, "#");
				bitki = new Bitki(st.nextToken(), st.nextToken(),
						st.nextToken(), st.nextToken(), st.nextToken(),
						st.nextToken(), st.nextToken(), st.nextToken());
				String önerilen_hastalýklar = st.nextToken();
				st2 = new StringTokenizer(önerilen_hastalýklar, ">>");
				bilgi_sayýsý = Integer.parseInt(st2.nextToken());
				String tüm_hastalýklar = "";
				while (bilgi_sayýsý > 0) {
					bilgi_sayýsý--;
					tüm_hastalýklar = st2.nextToken();
					st3 = new StringTokenizer(tüm_hastalýklar, ">>");
					while (st3.hasMoreTokens()) {
						bitki.getÖnerilen_hastalýklar().add(st3.nextToken());
					}
				}
				bitkiler.add(bitki);
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
		return bitkiler;
	}

}
