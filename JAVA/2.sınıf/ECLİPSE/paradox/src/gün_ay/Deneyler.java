package gün_ay;

public class Deneyler {
	private static Yıl sene;
	private static İstatistik deney_raporu;
	private static int tekrar;
	private static Doğum_tarihi random_tarih;

	public Deneyler() {
		setTekrar(10);
		setDeney_raporu(new İstatistik());
		setSene(new Yıl());
		setRandom_tarih(new Doğum_tarihi());
		
		deneyler();// Tekrar sayısına göre deneyler yapılıyor
	}

	private static void deneyler() {
		int i;
		// n=5,10,100 ve 250 için deney tekrar miktarınca tekarlanıyor
		for (i = 0; i < İstatistik.getKişi_sayısı().size(); i++) {
			deney(i, getTekrar(), İstatistik.getKişi_sayısı().elementAt(i));
		}
		getDeney_raporu().toString();// İstatistik bilgileri yazdırılıyor
		getDeney_raporu().verilerin_ortalaması_toString();// //Toplam çakışma
															// bilgileri
															// yazdırılıyor
	}

	private static void deney(int deney_türü, int deney_tekrar_sayısı,
			int kaç_kişiyle) {
		int i, deney_no;
		int sonuç = 0;
		for (i = 0; i < deney_tekrar_sayısı; i++) {
			random(kaç_kişiyle);// Deney yapılıyor:Rastgele artırma işlemleri
			deney_no = i;
			deney_raporu.setMatris(getSene());// yıl verileri matrise
												// aktarılıyor
			sonuç = deney_raporu.hesapla(deney_türü, deney_no);// Sadece bir
																// deneydeki yıl
																// matrisindeki
																// birden fazla
																// çakışmaları
																// topluyor
			deney_raporu.toplamları_hesapla();// toplamlar toplanıyor
			System.out.printf(
					"Denek_miktarı:%d Deney_no:%d Yaşıt kişilerin sayısı:%d\n",
					kaç_kişiyle, deney_no + 1, sonuç);
			System.out
					.printf("%-2d. Deney Sonuçları\n\n%s\n\n",
							(i + 1), getSene());
			getSene().reset();// Veriler sıfırlanıyor
		}
	}

	private static void random(int n) {
		int i, tut, ay, gün;
		for (i = 0; i < n; i++) {
			// Rastgele tarih üretiliyor
			ay = getRandom_tarih().random_ay();
			gün = getRandom_tarih().random_gün();
			// Veri bir artırılıyor
			tut = getSene().getAylar().elementAt(ay).elementAt(gün);
			getSene().getAylar().elementAt(ay).set(gün, tut + 1);
			// Veri birden büyük olurssa çakışma olmuş oluyor
		}
	}

	public static Yıl getSene() {
		return sene;
	}

	public static void setSene(Yıl sene) {
		Deneyler.sene = sene;
	}

	private static int getTekrar() {
		return tekrar;
	}

	private static void setTekrar(int tekrar) {
		Deneyler.tekrar = tekrar;
	}

	public static İstatistik getDeney_raporu() {
		return deney_raporu;
	}

	public static void setDeney_raporu(İstatistik deney_raporu) {
		Deneyler.deney_raporu = deney_raporu;
	}

	public static Doğum_tarihi getRandom_tarih() {
		return random_tarih;
	}

	public static void setRandom_tarih(Doğum_tarihi random_tarih) {
		Deneyler.random_tarih = random_tarih;
	}
}
