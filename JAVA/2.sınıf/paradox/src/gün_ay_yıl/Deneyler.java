package g�n_ay_y�l;

public class Deneyler {
	private static Y�llar ka�_sene;
	private static �statistikler rapor_klas�r�;
	private static int tekrar;
	private static Do�um_tarihi random_tarih;

	public Deneyler() {
		setTekrar(10);
		setRapor_klas�r�(new �statistikler(3));
		setKa�_sene(new Y�llar(3));
		setRandom_tarih(new Do�um_tarihi());
		deneyler();// Tekrar say�s�na g�re deneyler yap�l�yor
	}

	public static void deneyler() {
		int i;
		// n=5,10,100 ve 250 i�in deney tekrar miktar�nca tekarlan�yor
		for (i = 0; i < �statistik.getKi�i_say�s�().size(); i++) {
			deney(i, getTekrar(), �statistik.getKi�i_say�s�().elementAt(i));
		}
		getRapor_klas�r�().toString();// Toplu istatistik bilgileri yazd�r�l�yor
		getRapor_klas�r�().verilerin_ortalamas�_toString();// //Toplam �ak��ma
															// bilgileri
															// yazd�r�l�yor
	}

	public static void deney(int deney_t�r�, int deney_tekrar_say�s�,
			int ka�_ki�iyle) {
		int i, j, k, deney_no, sonu�, y�l = 1990;
		for (i = 0; i < deney_tekrar_say�s�; i++) {
			random(ka�_ki�iyle);// Deney yap�l�yor:Rastgele art�rma i�lemleri
			deney_no = i;
			for (k = 0; k < getRapor_klas�r�().getRaporlar().size(); k++) {
				getRapor_klas�r�().getRaporlar().elementAt(k)
						.setMatris(getKa�_sene().getSeneler().elementAt(k));// y�l
																			// verileri
																			// matrise
				// aktar�l�yor
				sonu� = getRapor_klas�r�().getRaporlar().elementAt(k)
						.hesapla(deney_t�r�, deney_no);// Sadece bir
				// deneydeki y�l
				// matrisindeki
				// birden fazla
				// �ak��malar�
				// topluyor
				getRapor_klas�r�().getRaporlar().elementAt(k)
						.toplamlar�_hesapla();// toplamlar toplan�yor
				System.out
						.printf("Denek_miktar�:%d Deney_no:%d %d'l� Ya��t ki�ilerin say�s�:%d\n",
								ka�_ki�iyle, deney_no + 1, (y�l + k), sonu�);
				System.out.flush();
			}
			System.out.println((i + 1) + ". Deney Sonu�lar�****************\n"
					+ getKa�_sene());
			for (j = 0; j < ka�_sene.getSeneler().size(); j++) {
				ka�_sene.getSeneler().elementAt(j).reset();// Veriler
															// s�f�rlan�yor
			}
		}
	}

	public static void random(int n) {
		int i, tut, y�l, ay, g�n;
		for (i = 0; i < n; i++) {
			// Rastgele tarih �retiliyor
			ay = getRandom_tarih().random_ay();
			g�n = getRandom_tarih().random_g�n();
			y�l = getRandom_tarih().random_y�l();
			// Veri bir art�r�l�yor
			tut = ka�_sene.getSeneler().elementAt(y�l).getAylar().elementAt(ay)
					.elementAt(g�n);
			ka�_sene.getSeneler().elementAt(y�l).getAylar().elementAt(ay)
					.set(g�n, tut + 1);
		}
	}

	public static Y�llar getKa�_sene() {
		return ka�_sene;
	}

	public static void setKa�_sene(Y�llar ka�_sene) {
		Deneyler.ka�_sene = ka�_sene;
	}

	public static int getTekrar() {
		return tekrar;
	}

	public static void setTekrar(int tekrar) {
		Deneyler.tekrar = tekrar;
	}

	public static �statistikler getRapor_klas�r�() {
		return rapor_klas�r�;
	}

	public void setRapor_klas�r�(�statistikler rapor_klas�r�) {
		Deneyler.rapor_klas�r� = rapor_klas�r�;
	}

	public static Do�um_tarihi getRandom_tarih() {
		return random_tarih;
	}

	public static void setRandom_tarih(Do�um_tarihi random_tarih) {
		Deneyler.random_tarih = random_tarih;
	}

}
