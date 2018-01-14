package veri_taban�;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import dert.Hastal�k;

public class Hastal�k_veri_taban� {
	private static Vector<Hastal�k> hastal�klar;
	private String kulland���_dosya = "";

	public Hastal�k_veri_taban�(String dosya_ad�) {
		setKulland���_dosya(dosya_ad�);
		setHastal�klar(hastal�k_verilerini_oku.dosya_oku(getKulland���_dosya()));
	}

	public static void setHastal�klar(Vector<Hastal�k> hastal�klar) {
		Hastal�k_veri_taban�.hastal�klar = hastal�klar;
	}

	public static Vector<Hastal�k> getHastal�klar() {
		return hastal�klar;
	}

	public void setKulland���_dosya(String kulland���_dosya) {
		this.kulland���_dosya = kulland���_dosya;
	}

	public String getKulland���_dosya() {
		return kulland���_dosya;
	}

	// Hastal�klara ili�kin bilgiler(Hastal�k ad�,belirtileri
	// ,nedenleri,tedavisi,�nerilen bitkiler )
	// Hastal�k ad�#belirtileri(_ ile tutuluyor)#nedenleri(_ ile
	// tutuluyor)#tedavisi(_ ile tutuluyor)#bilgi_say�s�>>�nerilen bitkiler(>>
	// ile tutuluyor)

	public synchronized void update_file() {
		String metin = "";
		Hastal�k hastal�k;

		try {
			final BufferedWriter out = new BufferedWriter(new FileWriter(
					getKulland���_dosya()));
			final PrintWriter pw = new PrintWriter(out);
			// buffer i�in flussh metodu var
			for (int i = 0; i < hastal�klar.size(); i++) {
				hastal�k = hastal�klar.elementAt(i);
				metin += hastal�k.getAd�() + "#"
						+ hastal���n_belirtileri(hastal�k) + "#"
						+ hastal���n_nedenleri(hastal�k) + "#"
						+ hastal���n_tedavisi(hastal�k) + "#"
						+ hastal�k.getBilgi_say�s�();
				if (hastal�k.get�nerilen_bitkiler().size() != 0) {
					metin += faydal�_olabilecek_bitkiler(hastal�k);
				}
				pw.println(metin);
				pw.flush();
				metin = "";
			}
			out.close();
			
		} catch (final IOException e) {
		}
	}

	private String faydal�_olabilecek_bitkiler(Hastal�k hastal�k) {
		String metin = "";
		for (int i = 1; i < hastal�k.get�nerilen_bitkiler().size(); i++) {
			metin += ">>" + hastal�k.get�nerilen_bitkiler().elementAt(i);
		}
		return metin;
	}

	private String hastal���n_tedavisi(Hastal�k hastal�k) {
		String metin = "";
		for (int i = 0; i < hastal�k.getTedavisi().size(); i++) {
			metin += "_" + hastal�k.getTedavisi().elementAt(i);
		}
		return metin;
	}

	private String hastal���n_nedenleri(Hastal�k hastal�k) {
		String metin = "";
		for (int i = 0; i < hastal�k.getNedenleri().size(); i++) {
			metin += "_" + hastal�k.getNedenleri().elementAt(i);
		}
		return metin;
	}

	private String hastal���n_belirtileri(Hastal�k hastal�k) {
		String metin = "";
		for (int i = 0; i < hastal�k.getBelirtileri().size(); i++) {
			metin += "_" + hastal�k.getBelirtileri().elementAt(i);
		}
		return metin;
	}

	public String toString() {
		String metin = "";
		for (int i = 0; i < hastal�klar.size(); i++) {
			metin += hastal�klar.elementAt(i).toString();
		}
		return metin;
	}
	// Hastal�k arama ve ekleme i�lemleri hash table ile i� birli�i i�erisinde
	// yap�l�yor
}
