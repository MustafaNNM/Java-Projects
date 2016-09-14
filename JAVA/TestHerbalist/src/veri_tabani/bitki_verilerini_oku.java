package veri_tabani;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import deva.Bitki;

public class bitki_verilerini_oku {
	// Bitkiye ilişkin bilgiler(bitki adı# kategori(bitkiler için 0,bitki
	// çayları için 1,vitaminler için 2)#bitkinin latince ismi#bitkinin
	// özellikleri( _ ile ayrılıdır)#miktarı#fiyatı#bitki resminin diskteki
	// yeri#bitki resminin diskteki adı#bilgi sayısı(önerilen hastalıklar
	// için)#önerilen hastalıklar(>>ile ayrılmıştır)
	// final Vector<Kisi> kisiler =
	// kisileriOku("kullanıcılar.txt");

	public static Vector<Bitki> dosya_oku(final String fileName) {
		Vector<Bitki> bitkiler = new Vector<Bitki>();

		// burada tanimliyoruz boylece finally blogunda gorulebiliyor
		BufferedReader input = null;
		try {
			// her okumada tek satir okuyacak sekilde kullanabilecegimiz yapi
			input = new BufferedReader(new FileReader(fileName));

			bitkileri_olustur(bitkiler, input);
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

	private static void bitkileri_olustur(Vector<Bitki> bitkiler,
			BufferedReader input) throws IOException {
		String line = null; // while dongusu icinde tanimlamiyoruz
		Bitki bitki;
		while ((line = input.readLine()) != null) {
			bitki = bitki_olustur(line);
			bitkiler.add(bitki);
		}
	}

	private static Bitki bitki_olustur(String line) {
		Bitki bitki;
		StringTokenizer st;
		st = new StringTokenizer(line, "#");
		bitki = new Bitki(st.nextToken(), st.nextToken(),
				st.nextToken(), st.nextToken(), st.nextToken(),
				st.nextToken(), st.nextToken(), st.nextToken());
		String onerilen_hastaliklar = st.nextToken();
		onerilen_hastaliklar(bitki, onerilen_hastaliklar);
		return bitki;
	}

	private static void onerilen_hastaliklar(Bitki bitki,
			String onerilen_hastaliklar) {
		StringTokenizer st2;

		int bilgi_sayisi;
		st2 = new StringTokenizer(onerilen_hastaliklar, ">>");
		bilgi_sayisi = Integer.parseInt(st2.nextToken());

		while (bilgi_sayisi > 0) {
			bilgi_sayisi--;
			hastalik(bitki, st2);
		}
	}

	private static void hastalik(Bitki bitki, StringTokenizer st2) {
		StringTokenizer st3;
		String tum_hastaliklar;
		tum_hastaliklar = st2.nextToken();
		st3 = new StringTokenizer(tum_hastaliklar, ">>");
		while (st3.hasMoreTokens()) {
			bitki.getOnerilen_hastaliklar().add(st3.nextToken());
		}
	}

}
