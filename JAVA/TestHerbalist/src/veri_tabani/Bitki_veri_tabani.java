package veri_tabani;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import deva.Bitki;

public class Bitki_veri_tabani {
	private Vector<Bitki> bitkiler;
	private String kullandigi_dosya = "";

	public Bitki_veri_tabani(String dosya_adi) {
		setKullandigi_dosya(dosya_adi);
		setBitkiler(bitki_verilerini_oku.dosya_oku(getKullandigi_dosya()));
	}

	public Vector<Bitki> getBitkiler() {
		return bitkiler;
	}

	public void setBitkiler(Vector<Bitki> bitkiler) {
		this.bitkiler = bitkiler;
	}

	public String getKullandigi_dosya() {
		return kullandigi_dosya;
	}

	public void setKullandigi_dosya(String kullandigi_dosya) {
		this.kullandigi_dosya = kullandigi_dosya;
	}

	// Bitkiye ilişkin bilgiler(bitki adı# kategori(bitkiler için 0,bitki
	// çayları için 1,vitaminler için 2)#bitkinin latince ismi#bitkinin
	// özellikleri( _ ile ayrılıdır)#miktarı#fiyatı#bitki resminin diskteki
	// yeri#bitki resminin diskteki adı#bilgi sayısı(önerilen hastalıklar
	// için)#önerilen hastalıklar(>>ile ayrılmıştır)
	public synchronized void add_botan() {
		// bitki yoksa ekleme yapılamalıdır

		String bitki_adi = "", yeni_bitkinin_adi = "";
		int bitki_zaten_var_mi = 0;
		int evet = 1, hayir = 0;

		// Burası üst menüde yapılamalı
		for (int i = 0; i < bitkiler.size(); i++) {
			bitki_adi = bitkiler.elementAt(i).getAdi();
			if (yeni_bitkinin_adi.compareTo(bitki_adi) == 0) {
				bitki_zaten_var_mi = evet;
			}
		}
		if (bitki_zaten_var_mi == hayir) {
			// Bitki yeni_bitki; //=new Bitki(yeni_bitkinin_adı,
			// yeni_bitkinin_adı, yeni_bitkinin_adı, yeni_bitkinin_adı,
			// yeni_bitkinin_adı, yeni_bitkinin_adı, yeni_bitkinin_adı,
			// yeni_bitkinin_adı);
			// bitkiler.add(yeni_bitki);
		}

	}

	public synchronized void remove(String data) {
		String bitki_adi = "";
		for (int i = 0; i < bitkiler.size(); i++) {
			bitki_adi = bitkiler.elementAt(i).getAdi();
			if (bitki_adi.compareTo(data) == 0) {
				bitkiler.remove(i);
				break;
			}
		}
	}

	public synchronized void update_file() {
		String metin = "";

		try {
			dosyayi_guncelle(metin);
		} catch (final IOException e) {
		}
	}

	private void dosyayi_guncelle(String metin) throws IOException {
		Bitki bitki;
		final BufferedWriter out = new BufferedWriter(new FileWriter(
				getKullandigi_dosya()));
		final PrintWriter pw = new PrintWriter(out);
		// buffer için flussh metodu var
		for (int i = 0; i < bitkiler.size(); i++) {
			bitki = bitkiler.elementAt(i);
			metin += bitki.getAdi() + "#" + bitki.getKategori() + "#"
					+ bitki.getLatince_adi() + "#"
					+ bitkinin_Ozellikleri(bitki) + "#"
					+ bitki.getMiktari() + "#" + bitki.getFiyati() + "#"
					+ bitki.getDiskteki_yeri() + "#"
					+ bitki.getDiskteki_adi() + "#"
					+ bitki.getOnerilen_hastaliklar().size();
			if (bitki.getOnerilen_hastaliklar().size() != 0) {
				metin += faydali_oldugu_hastaliklar(bitki);
			}
			pw.println(metin);
			pw.flush();
			metin = "";
		}
		out.close();
	}

	private String faydali_oldugu_hastaliklar(Bitki bitki) {
		String metin = "";
		for (int i = 0; i < bitki.getOnerilen_hastaliklar().size(); i++) {
			metin += ">>" + bitki.getOnerilen_hastaliklar().elementAt(i);
		}
		return metin;
	}

	private String bitkinin_Ozellikleri(Bitki bitki) {
		String metin = "";
		int n = bitki.getOzellikleri().size() - 1;
		for (int i = 0; i < n; i++) {
			metin += bitki.getOzellikleri().elementAt(i) + "_";
		}
		metin += bitki.getOzellikleri().lastElement();
		return metin;
	}

	public String urunleri_listele(float min, float max) {
		String metin="";
		float bitkinin_fiyati;
		for(int i=0;i<bitkiler.size();i++){
			bitkinin_fiyati=bitkiler.elementAt(i).getFiyati();
			if(min<=bitkinin_fiyati&&bitkinin_fiyati<=max){
				metin+=bitkiler.elementAt(i).getAdi()+"\n";
			}
		}
		return metin;
	}
}
