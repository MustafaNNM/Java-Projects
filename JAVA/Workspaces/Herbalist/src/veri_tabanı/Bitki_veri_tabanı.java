package veri_tabaný;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import deva.Bitki;

public class Bitki_veri_tabaný {
	private Vector<Bitki> bitkiler;
	private String kullandýðý_dosya = "";

	public Bitki_veri_tabaný(String dosya_adý) {
		setKullandýðý_dosya(dosya_adý);
		setBitkiler(bitki_verilerini_oku.dosya_oku(getKullandýðý_dosya()));
	}

	public Vector<Bitki> getBitkiler() {
		return bitkiler;
	}

	public void setBitkiler(Vector<Bitki> bitkiler) {
		this.bitkiler = bitkiler;
	}

	public String getKullandýðý_dosya() {
		return kullandýðý_dosya;
	}

	public void setKullandýðý_dosya(String kullandýðý_dosya) {
		this.kullandýðý_dosya = kullandýðý_dosya;
	}

	// Bitkiye iliþkin bilgiler(bitki adý# kategori(bitkiler için 0,bitki
	// çaylarý için 1,vitaminler için 2)#bitkinin latince ismi#bitkinin
	// özellikleri( _ ile ayrýlýdýr)#miktarý#fiyatý#bitki resminin diskteki
	// yeri#bitki resminin diskteki adý#bilgi sayýsý(önerilen hastalýklar
	// için)#önerilen hastalýklar(>>ile ayrýlmýþtýr)
	public synchronized void add_botan() {
		// bitki yoksa ekleme yapýlamalýdýr

		String bitki_adý = "", yeni_bitkinin_adý = "";
		int bitki_zaten_var_mý = 0;
		int evet = 1, hayýr = 0;

		// Burasý üst menüde yapýlamalý
		for (int i = 0; i < bitkiler.size(); i++) {
			bitki_adý = bitkiler.elementAt(i).getAdý();
			if (yeni_bitkinin_adý.compareTo(bitki_adý) == 0) {
				bitki_zaten_var_mý = evet;
			}
		}
		if (bitki_zaten_var_mý == hayýr) {
			// Bitki yeni_bitki; //=new Bitki(yeni_bitkinin_adý,
			// yeni_bitkinin_adý, yeni_bitkinin_adý, yeni_bitkinin_adý,
			// yeni_bitkinin_adý, yeni_bitkinin_adý, yeni_bitkinin_adý,
			// yeni_bitkinin_adý);
			// bitkiler.add(yeni_bitki);
		}

	}

	public synchronized void remove(String data) {
		String bitki_adý = "";
		for (int i = 0; i < bitkiler.size(); i++) {
			bitki_adý = bitkiler.elementAt(i).getAdý();
			if (bitki_adý.compareTo(data) == 0) {
				bitkiler.remove(i);
				break;
			}
		}
	}

	public synchronized void update_file() {
		String metin = "";
		Bitki bitki;

		try {
			final BufferedWriter out = new BufferedWriter(new FileWriter(
					getKullandýðý_dosya()));
			final PrintWriter pw = new PrintWriter(out);
			// buffer için flussh metodu var
			for (int i = 0; i < bitkiler.size(); i++) {
				bitki = bitkiler.elementAt(i);
				metin += bitki.getAdý() + "#" + bitki.getKategori() + "#"
						+ bitki.getLatince_adý() + "#"
						+ bitkinin_özellikleri(bitki) + "#"
						+ bitki.getMiktarý() + "#" + bitki.getFiyatý() + "#"
						+ bitki.getDiskteki_yeri() + "#"
						+ bitki.getDiskteki_adý() + "#"
						+ bitki.getÖnerilen_hastalýklar().size();
				if (bitki.getÖnerilen_hastalýklar().size() != 0) {
					metin += faydalý_olduðu_hastalýklar(bitki);
				}
				pw.println(metin);
				pw.flush();
				metin = "";
			}
			out.close();
		} catch (final IOException e) {
		}
	}

	private String faydalý_olduðu_hastalýklar(Bitki bitki) {
		String metin = "";
		for (int i = 0; i < bitki.getÖnerilen_hastalýklar().size(); i++) {
			metin += ">>" + bitki.getÖnerilen_hastalýklar().elementAt(i);
		}
		return metin;
	}

	private String bitkinin_özellikleri(Bitki bitki) {
		String metin = "";
		int n = bitki.getÖzellikleri().size() - 1;
		for (int i = 0; i < n; i++) {
			metin += bitki.getÖzellikleri().elementAt(i) + "_";
		}
		metin += bitki.getÖzellikleri().lastElement();
		return metin;
	}

	public String ürünleri_listele(float min, float max) {
		String metin="";
		float bitkinin_fiyatý;
		for(int i=0;i<bitkiler.size();i++){
			bitkinin_fiyatý=bitkiler.elementAt(i).getFiyatý();
			if(min<=bitkinin_fiyatý&&bitkinin_fiyatý<=max){
				metin+=bitkiler.elementAt(i).getAdý()+"\n";
			}
		}
		return metin;
	}
}
