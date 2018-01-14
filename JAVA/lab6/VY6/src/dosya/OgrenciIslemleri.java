package dosya;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;

import veri.Ogrenci;

/**
 * Bu sinifin amaci dosyadan ogrencileri okumak ve ogrencileri dosyaya
 * kaydetmektir
 * 
 * Veri yapilari dersi kapsaminda dosya islemlerini kavratmak amaciyla
 * yazilmistir
 * 
 * @author emre
 * 
 */
public class OgrenciIslemleri {

	public static void main(final String[] args) {
		final Vector<Ogrenci> ogrenciler = OgrenciIslemleri
				.ogrencileriOku("ogrenciler.txt");

		for (final Ogrenci ogrenci : ogrenciler) {
			System.out.println(ogrenci);
		}
	}

	/**
	 * Ogrenci kaydetme metodu Bu metodun islevi parametre olarak verilen
	 * ogrencinin bilgilerini yine parametre olarak verilen dosyaya eklemektir.
	 * Son parametreye gore dosyanin sonuna yeni bir kayit olarak ekleyebilecegi
	 * gibi, dosyayi sifirdan yaratipta ekleyebilir
	 * 
	 * @param ogrenci
	 *            Kaydedilecek olan ogrenci
	 * @param dosyaAdi
	 *            Hangi dosyaya kaydedecegiz
	 * @param sonunaEkle
	 *            Dosya sonuna ekleme mi yapacagiz, yoksa dosyayi sifirlayacak
	 *            miyiz?
	 * @return Islem basarili olursa true, olmazsa hata olusursa false
	 */
	public static boolean ogrenciEkle(final Ogrenci ogrenci,
			final String dosyaAdi, final boolean sonunaEkle) {
		try {
			// Yazmak icin dosyayi uygun sekilde acmaliyiz
			final PrintWriter pw = new PrintWriter(new BufferedWriter(
					new FileWriter(dosyaAdi, sonunaEkle)));
			// Ogrenci bilgilerini yaziyoruz
			pw.println(ogrenci.getNumara() + "\t" + ogrenci.getIsim() + "\t"
					+ ogrenci.getSinif() + "\t" + ogrenci.getGirisYili());
			// dosyayi kapatiyoruz
			pw.close();
			return true;
		} catch (final IOException e) {
			// bir hata olusursa ekrana yaziyoruz
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Verilen ogrenci vektorunu dolasarak ogrencileri kaydeden metod
	 * 
	 * @param ogrenciler
	 *            Kaydedilecek ogrenciler
	 * @param dosyaAdi
	 *            Kaydedecegimiz dosya
	 * @param sonunaEkle
	 *            Dosya yeniden yaratilacak mi?
	 */
	public static void ogrencileriKaydet(final Vector<Ogrenci> ogrenciler,
			final String dosyaAdi, final boolean sonunaEkle) {
		boolean yenidenYarat = !sonunaEkle;
		for (final Ogrenci ogrenci : ogrenciler) {
			// Eger sonuna eklenmeyecekse dosyayi sadece ilk ogrenci icin tekrar
			// yaratmaliyiz
			if (yenidenYarat) {
				ogrenciEkle(ogrenci, dosyaAdi, false);
				yenidenYarat = !yenidenYarat;
			} else {
				ogrenciEkle(ogrenci, dosyaAdi, true);
			}
		}
	}

	/**
	 * Bu metodun islevi parametre olarak ismi verilen dosyayi satir satir
	 * okuyarak her satirda belli bir bicimde saklanmis olan ogrenci bilgileri
	 * elde etmek ve bu bilgileri bir vektor olarak metodu cagiran yere
	 * dondurmektir
	 * 
	 * @param fileName
	 * @return
	 */
	public static Vector<Ogrenci> ogrencileriOku(final String fileName) {

		final Vector<Ogrenci> ogrenciler = new Vector<Ogrenci>();

		// burada tanimliyoruz boylece finally blogunda gorulebiliyor
		BufferedReader input = null;
		try {
			// her okumada tek satir okuyacak sekilde kullanabilecegimiz yapi
			input = new BufferedReader(new FileReader(fileName));
			String line = null; // while dongusu icinde tanimlamiyoruz
			while ((line = input.readLine()) != null) {
				ogrenciler.add(ogrenciUret(line));
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
		return ogrenciler;
	}

	/**
	 * Asagidaki metodun amaci dosyadan okunan bir satiri parcalayarak ogrenci
	 * sinifi icerisinde saklamak
	 * 
	 * @param bilgiler
	 *            dosyadan okunan satir
	 * @return ogrenci nesnesi
	 */
	private static Ogrenci ogrenciUret(final String bilgiler) {
		final StringTokenizer st = new StringTokenizer(bilgiler, "\t");
		final Ogrenci ogrenci = new Ogrenci();
		ogrenci.setNumara(st.nextToken());
		ogrenci.setIsim(st.nextToken());
		ogrenci.setSinif(Integer.parseInt(st.nextToken()));
		ogrenci.setGirisYili(Integer.parseInt(st.nextToken()));
		return ogrenci;
	}
}
