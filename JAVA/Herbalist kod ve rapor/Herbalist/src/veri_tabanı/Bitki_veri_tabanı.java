package veri_taban�;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import deva.Bitki;

public class Bitki_veri_taban� {
	private Vector<Bitki> bitkiler;
	private String kulland���_dosya = "";

	public Bitki_veri_taban�(String dosya_ad�) {
		setKulland���_dosya(dosya_ad�);
		setBitkiler(bitki_verilerini_oku.dosya_oku(getKulland���_dosya()));
	}

	public Vector<Bitki> getBitkiler() {
		return bitkiler;
	}

	public void setBitkiler(Vector<Bitki> bitkiler) {
		this.bitkiler = bitkiler;
	}

	public String getKulland���_dosya() {
		return kulland���_dosya;
	}

	public void setKulland���_dosya(String kulland���_dosya) {
		this.kulland���_dosya = kulland���_dosya;
	}

	// Bitkiye ili�kin bilgiler(bitki ad�# kategori(bitkiler i�in 0,bitki
	// �aylar� i�in 1,vitaminler i�in 2)#bitkinin latince ismi#bitkinin
	// �zellikleri( _ ile ayr�l�d�r)#miktar�#fiyat�#bitki resminin diskteki
	// yeri#bitki resminin diskteki ad�#bilgi say�s�(�nerilen hastal�klar
	// i�in)#�nerilen hastal�klar(>>ile ayr�lm��t�r)
	public synchronized void add_botan() {
		// bitki yoksa ekleme yap�lamal�d�r

		String bitki_ad� = "", yeni_bitkinin_ad� = "";
		int bitki_zaten_var_m� = 0;
		int evet = 1, hay�r = 0;

		// Buras� �st men�de yap�lamal�
		for (int i = 0; i < bitkiler.size(); i++) {
			bitki_ad� = bitkiler.elementAt(i).getAd�();
			if (yeni_bitkinin_ad�.compareTo(bitki_ad�) == 0) {
				bitki_zaten_var_m� = evet;
			}
		}
		if (bitki_zaten_var_m� == hay�r) {
			// Bitki yeni_bitki; //=new Bitki(yeni_bitkinin_ad�,
			// yeni_bitkinin_ad�, yeni_bitkinin_ad�, yeni_bitkinin_ad�,
			// yeni_bitkinin_ad�, yeni_bitkinin_ad�, yeni_bitkinin_ad�,
			// yeni_bitkinin_ad�);
			// bitkiler.add(yeni_bitki);
		}

	}

	public synchronized void remove(String data) {
		String bitki_ad� = "";
		for (int i = 0; i < bitkiler.size(); i++) {
			bitki_ad� = bitkiler.elementAt(i).getAd�();
			if (bitki_ad�.compareTo(data) == 0) {
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
					getKulland���_dosya()));
			final PrintWriter pw = new PrintWriter(out);
			// buffer i�in flussh metodu var
			for (int i = 0; i < bitkiler.size(); i++) {
				bitki = bitkiler.elementAt(i);
				metin += bitki.getAd�() + "#" + bitki.getKategori() + "#"
						+ bitki.getLatince_ad�() + "#"
						+ bitkinin_�zellikleri(bitki) + "#"
						+ bitki.getMiktar�() + "#" + bitki.getFiyat�() + "#"
						+ bitki.getDiskteki_yeri() + "#"
						+ bitki.getDiskteki_ad�() + "#"
						+ bitki.get�nerilen_hastal�klar().size();
				if (bitki.get�nerilen_hastal�klar().size() != 0) {
					metin += faydal�_oldu�u_hastal�klar(bitki);
				}
				pw.println(metin);
				pw.flush();
				metin = "";
			}
			out.close();
		} catch (final IOException e) {
		}
	}

	private String faydal�_oldu�u_hastal�klar(Bitki bitki) {
		String metin = "";
		for (int i = 0; i < bitki.get�nerilen_hastal�klar().size(); i++) {
			metin += ">>" + bitki.get�nerilen_hastal�klar().elementAt(i);
		}
		return metin;
	}

	private String bitkinin_�zellikleri(Bitki bitki) {
		String metin = "";
		int n = bitki.get�zellikleri().size() - 1;
		for (int i = 0; i < n; i++) {
			metin += bitki.get�zellikleri().elementAt(i) + "_";
		}
		metin += bitki.get�zellikleri().lastElement();
		return metin;
	}

	public String �r�nleri_listele(float min, float max) {
		String metin="";
		float bitkinin_fiyat�;
		for(int i=0;i<bitkiler.size();i++){
			bitkinin_fiyat�=bitkiler.elementAt(i).getFiyat�();
			if(min<=bitkinin_fiyat�&&bitkinin_fiyat�<=max){
				metin+=bitkiler.elementAt(i).getAd�()+"\n";
			}
		}
		return metin;
	}
}
