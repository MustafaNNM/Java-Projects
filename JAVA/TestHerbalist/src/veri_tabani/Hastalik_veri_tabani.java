package veri_tabani;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import dert.Hastalik;

public class Hastalik_veri_tabani {
	private static Vector<Hastalik> hastaliklar;
	private String kullandigi_dosya = "";

	public Hastalik_veri_tabani(String dosya_adi) {
		setKullandigi_dosya(dosya_adi);
		setHastaliklar(hastalik_verilerini_oku.dosya_oku(getKullandigi_dosya()));
	}

	public static void setHastaliklar(Vector<Hastalik> hastaliklar) {
		Hastalik_veri_tabani.hastaliklar = hastaliklar;
	}

	public static Vector<Hastalik> getHastaliklar() {
		return hastaliklar;
	}

	public void setKullandigi_dosya(String kullandigi_dosya) {
		this.kullandigi_dosya = kullandigi_dosya;
	}

	public String getKullandigi_dosya() {
		return kullandigi_dosya;
	}

	// Hastaliklara iliskin bilgiler(Hastalık adı,belirtileri
	// ,nedenleri,tedavisi,önerilen bitkiler )
	// Hastalık adı#belirtileri(_ ile tutuluyor)#nedenleri(_ ile
	// tutuluyor)#tedavisi(_ ile tutuluyor)#bilgi_sayısı>>önerilen bitkiler(>>
	// ile tutuluyor)

	public synchronized void update_file() {
		String metin = "";

		try {
			dosyayi_guncelle(metin);
			
		} catch (final IOException e) {
		}
	}

	private void dosyayi_guncelle(String metin) throws IOException {
		Hastalik hastalik;
		final BufferedWriter out = new BufferedWriter(new FileWriter(
				getKullandigi_dosya()));
		final PrintWriter pw = new PrintWriter(out);
		// buffer için flussh metodu var
		for (int i = 0; i < hastaliklar.size(); i++) {
			hastalik = hastaliklar.elementAt(i);
			metin += hastalik.getAdi() + "#"
					+ hastaligin_belirtileri(hastalik) + "#"
					+ hastaligin_nedenleri(hastalik) + "#"
					+ hastaligin_tedavisi(hastalik) + "#"
					+ hastalik.getBilgi_sayisi();
			if (hastalik.getOnerilen_bitkiler().size() != 0) {
				metin += faydali_olabilecek_bitkiler(hastalik);
			}
			pw.println(metin);
			pw.flush();
			metin = "";
		}
		out.close();
	}

	private String faydali_olabilecek_bitkiler(Hastalik hastalik) {
		String metin = "";
		for (int i = 1; i < hastalik.getOnerilen_bitkiler().size(); i++) {
			metin += ">>" + hastalik.getOnerilen_bitkiler().elementAt(i);
		}
		return metin;
	}

	private String hastaligin_tedavisi(Hastalik hastalik) {
		String metin = "";
		for (int i = 0; i < hastalik.getTedavisi().size(); i++) {
			metin += "_" + hastalik.getTedavisi().elementAt(i);
		}
		return metin;
	}

	private String hastaligin_nedenleri(Hastalik hastalik) {
		String metin = "";
		for (int i = 0; i < hastalik.getNedenleri().size(); i++) {
			metin += "_" + hastalik.getNedenleri().elementAt(i);
		}
		return metin;
	}

	private String hastaligin_belirtileri(Hastalik hastalik) {
		String metin = "";
		for (int i = 0; i < hastalik.getBelirtileri().size(); i++) {
			metin += "_" + hastalik.getBelirtileri().elementAt(i);
		}
		return metin;
	}

	public String toString() {
		String metin = "";
		for (int i = 0; i < hastaliklar.size(); i++) {
			metin += hastaliklar.elementAt(i).toString();
		}
		return metin;
	}
	// Hastalık arama ve ekleme işlemleri hash table ile iş birliği içerisinde
	// yapılıyor
}
