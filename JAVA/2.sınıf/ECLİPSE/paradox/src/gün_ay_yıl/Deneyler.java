package gün_ay_yýl;

public class Deneyler {
	private static Yýllar kaç_sene;
	private static Ýstatistikler rapor_klasörü;
	private static int tekrar;
	private static Doðum_tarihi random_tarih;

	public Deneyler() {
		setTekrar(10);
		setRapor_klasörü(new Ýstatistikler(3));
		setKaç_sene(new Yýllar(3));
		setRandom_tarih(new Doðum_tarihi());
		deneyler();// Tekrar sayýsýna göre deneyler yapýlýyor
	}

	public static void deneyler() {
		int i;
		// n=5,10,100 ve 250 için deney tekrar miktarýnca tekarlanýyor
		for (i = 0; i < Ýstatistik.getKiþi_sayýsý().size(); i++) {
			deney(i, getTekrar(), Ýstatistik.getKiþi_sayýsý().elementAt(i));
		}
		getRapor_klasörü().toString();// Toplu istatistik bilgileri yazdýrýlýyor
		getRapor_klasörü().verilerin_ortalamasý_toString();// //Toplam çakýþma
															// bilgileri
															// yazdýrýlýyor
	}

	public static void deney(int deney_türü, int deney_tekrar_sayýsý,
			int kaç_kiþiyle) {
		int i, j, k, deney_no, sonuç, yýl = 1990;
		for (i = 0; i < deney_tekrar_sayýsý; i++) {
			random(kaç_kiþiyle);// Deney yapýlýyor:Rastgele artýrma iþlemleri
			deney_no = i;
			for (k = 0; k < getRapor_klasörü().getRaporlar().size(); k++) {
				getRapor_klasörü().getRaporlar().elementAt(k)
						.setMatris(getKaç_sene().getSeneler().elementAt(k));// yýl
																			// verileri
																			// matrise
				// aktarýlýyor
				sonuç = getRapor_klasörü().getRaporlar().elementAt(k)
						.hesapla(deney_türü, deney_no);// Sadece bir
				// deneydeki yýl
				// matrisindeki
				// birden fazla
				// çakýþmalarý
				// topluyor
				getRapor_klasörü().getRaporlar().elementAt(k)
						.toplamlarý_hesapla();// toplamlar toplanýyor
				System.out
						.printf("Denek_miktarý:%d Deney_no:%d %d'lý Yaþýt kiþilerin sayýsý:%d\n",
								kaç_kiþiyle, deney_no + 1, (yýl + k), sonuç);
				System.out.flush();
			}
			System.out.println((i + 1) + ". Deney Sonuçlarý****************\n"
					+ getKaç_sene());
			for (j = 0; j < kaç_sene.getSeneler().size(); j++) {
				kaç_sene.getSeneler().elementAt(j).reset();// Veriler
															// sýfýrlanýyor
			}
		}
	}

	public static void random(int n) {
		int i, tut, yýl, ay, gün;
		for (i = 0; i < n; i++) {
			// Rastgele tarih üretiliyor
			ay = getRandom_tarih().random_ay();
			gün = getRandom_tarih().random_gün();
			yýl = getRandom_tarih().random_yýl();
			// Veri bir artýrýlýyor
			tut = kaç_sene.getSeneler().elementAt(yýl).getAylar().elementAt(ay)
					.elementAt(gün);
			kaç_sene.getSeneler().elementAt(yýl).getAylar().elementAt(ay)
					.set(gün, tut + 1);
		}
	}

	public static Yýllar getKaç_sene() {
		return kaç_sene;
	}

	public static void setKaç_sene(Yýllar kaç_sene) {
		Deneyler.kaç_sene = kaç_sene;
	}

	public static int getTekrar() {
		return tekrar;
	}

	public static void setTekrar(int tekrar) {
		Deneyler.tekrar = tekrar;
	}

	public static Ýstatistikler getRapor_klasörü() {
		return rapor_klasörü;
	}

	public void setRapor_klasörü(Ýstatistikler rapor_klasörü) {
		Deneyler.rapor_klasörü = rapor_klasörü;
	}

	public static Doðum_tarihi getRandom_tarih() {
		return random_tarih;
	}

	public static void setRandom_tarih(Doðum_tarihi random_tarih) {
		Deneyler.random_tarih = random_tarih;
	}

}
