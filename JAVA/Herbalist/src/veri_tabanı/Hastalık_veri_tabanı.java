package veri_tabaný;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import dert.Hastalýk;

public class Hastalýk_veri_tabaný {
	private static Vector<Hastalýk> hastalýklar;
	private String kullandýðý_dosya = "";

	public Hastalýk_veri_tabaný(String dosya_adý) {
		setKullandýðý_dosya(dosya_adý);
		setHastalýklar(hastalýk_verilerini_oku.dosya_oku(getKullandýðý_dosya()));
	}

	public static void setHastalýklar(Vector<Hastalýk> hastalýklar) {
		Hastalýk_veri_tabaný.hastalýklar = hastalýklar;
	}

	public static Vector<Hastalýk> getHastalýklar() {
		return hastalýklar;
	}

	public void setKullandýðý_dosya(String kullandýðý_dosya) {
		this.kullandýðý_dosya = kullandýðý_dosya;
	}

	public String getKullandýðý_dosya() {
		return kullandýðý_dosya;
	}

	// Hastalýklara iliþkin bilgiler(Hastalýk adý,belirtileri
	// ,nedenleri,tedavisi,önerilen bitkiler )
	// Hastalýk adý#belirtileri(_ ile tutuluyor)#nedenleri(_ ile
	// tutuluyor)#tedavisi(_ ile tutuluyor)#bilgi_sayýsý>>önerilen bitkiler(>>
	// ile tutuluyor)

	public synchronized void update_file() {
		String metin = "";
		Hastalýk hastalýk;

		try {
			final BufferedWriter out = new BufferedWriter(new FileWriter(
					getKullandýðý_dosya()));
			final PrintWriter pw = new PrintWriter(out);
			// buffer için flussh metodu var
			for (int i = 0; i < hastalýklar.size(); i++) {
				hastalýk = hastalýklar.elementAt(i);
				metin += hastalýk.getAdý() + "#"
						+ hastalýðýn_belirtileri(hastalýk) + "#"
						+ hastalýðýn_nedenleri(hastalýk) + "#"
						+ hastalýðýn_tedavisi(hastalýk) + "#"
						+ hastalýk.getBilgi_sayýsý();
				if (hastalýk.getÖnerilen_bitkiler().size() != 0) {
					metin += faydalý_olabilecek_bitkiler(hastalýk);
				}
				pw.println(metin);
				pw.flush();
				metin = "";
			}
			out.close();
			
		} catch (final IOException e) {
		}
	}

	private String faydalý_olabilecek_bitkiler(Hastalýk hastalýk) {
		String metin = "";
		for (int i = 1; i < hastalýk.getÖnerilen_bitkiler().size(); i++) {
			metin += ">>" + hastalýk.getÖnerilen_bitkiler().elementAt(i);
		}
		return metin;
	}

	private String hastalýðýn_tedavisi(Hastalýk hastalýk) {
		String metin = "";
		for (int i = 0; i < hastalýk.getTedavisi().size(); i++) {
			metin += "_" + hastalýk.getTedavisi().elementAt(i);
		}
		return metin;
	}

	private String hastalýðýn_nedenleri(Hastalýk hastalýk) {
		String metin = "";
		for (int i = 0; i < hastalýk.getNedenleri().size(); i++) {
			metin += "_" + hastalýk.getNedenleri().elementAt(i);
		}
		return metin;
	}

	private String hastalýðýn_belirtileri(Hastalýk hastalýk) {
		String metin = "";
		for (int i = 0; i < hastalýk.getBelirtileri().size(); i++) {
			metin += "_" + hastalýk.getBelirtileri().elementAt(i);
		}
		return metin;
	}

	public String toString() {
		String metin = "";
		for (int i = 0; i < hastalýklar.size(); i++) {
			metin += hastalýklar.elementAt(i).toString();
		}
		return metin;
	}
	// Hastalýk arama ve ekleme iþlemleri hash table ile iþ birliði içerisinde
	// yapýlýyor
}
