package veri_taban�;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import deva.Bitki;

public class bitki_verilerini_oku {
	// Bitkiye ili�kin bilgiler(bitki ad�# kategori(bitkiler i�in 0,bitki
	// �aylar� i�in 1,vitaminler i�in 2)#bitkinin latince ismi#bitkinin
	// �zellikleri( _ ile ayr�l�d�r)#miktar�#fiyat�#bitki resminin diskteki
	// yeri#bitki resminin diskteki ad�#bilgi say�s�(�nerilen hastal�klar
	// i�in)#�nerilen hastal�klar(>>ile ayr�lm��t�r)
	// final Vector<Kisi> kisiler =
	// kisileriOku("kullan�c�lar.txt");

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
			int bilgi_say�s�;
			while ((line = input.readLine()) != null) {
				st = new StringTokenizer(line, "#");
				bitki = new Bitki(st.nextToken(), st.nextToken(),
						st.nextToken(), st.nextToken(), st.nextToken(),
						st.nextToken(), st.nextToken(), st.nextToken());
				String �nerilen_hastal�klar = st.nextToken();
				st2 = new StringTokenizer(�nerilen_hastal�klar, ">>");
				bilgi_say�s� = Integer.parseInt(st2.nextToken());
				String t�m_hastal�klar = "";
				while (bilgi_say�s� > 0) {
					bilgi_say�s�--;
					t�m_hastal�klar = st2.nextToken();
					st3 = new StringTokenizer(t�m_hastal�klar, ">>");
					while (st3.hasMoreTokens()) {
						bitki.get�nerilen_hastal�klar().add(st3.nextToken());
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
