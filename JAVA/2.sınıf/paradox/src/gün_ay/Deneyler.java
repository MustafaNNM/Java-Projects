package g�n_ay;

public class Deneyler {
	private static Y�l sene;
	private static �statistik deney_raporu;
	private static int tekrar;
	private static Do�um_tarihi random_tarih;

	public Deneyler() {
		setTekrar(10);
		setDeney_raporu(new �statistik());
		setSene(new Y�l());
		setRandom_tarih(new Do�um_tarihi());
		
		deneyler();// Tekrar say�s�na g�re deneyler yap�l�yor
	}

	private static void deneyler() {
		int i;
		// n=5,10,100 ve 250 i�in deney tekrar miktar�nca tekarlan�yor
		for (i = 0; i < �statistik.getKi�i_say�s�().size(); i++) {
			deney(i, getTekrar(), �statistik.getKi�i_say�s�().elementAt(i));
		}
		getDeney_raporu().toString();// �statistik bilgileri yazd�r�l�yor
		getDeney_raporu().verilerin_ortalamas�_toString();// //Toplam �ak��ma
															// bilgileri
															// yazd�r�l�yor
	}

	private static void deney(int deney_t�r�, int deney_tekrar_say�s�,
			int ka�_ki�iyle) {
		int i, deney_no;
		int sonu� = 0;
		for (i = 0; i < deney_tekrar_say�s�; i++) {
			random(ka�_ki�iyle);// Deney yap�l�yor:Rastgele art�rma i�lemleri
			deney_no = i;
			deney_raporu.setMatris(getSene());// y�l verileri matrise
												// aktar�l�yor
			sonu� = deney_raporu.hesapla(deney_t�r�, deney_no);// Sadece bir
																// deneydeki y�l
																// matrisindeki
																// birden fazla
																// �ak��malar�
																// topluyor
			deney_raporu.toplamlar�_hesapla();// toplamlar toplan�yor
			System.out.printf(
					"Denek_miktar�:%d Deney_no:%d Ya��t ki�ilerin say�s�:%d\n",
					ka�_ki�iyle, deney_no + 1, sonu�);
			System.out
					.printf("%-2d. Deney Sonu�lar�\n\n%s\n\n",
							(i + 1), getSene());
			getSene().reset();// Veriler s�f�rlan�yor
		}
	}

	private static void random(int n) {
		int i, tut, ay, g�n;
		for (i = 0; i < n; i++) {
			// Rastgele tarih �retiliyor
			ay = getRandom_tarih().random_ay();
			g�n = getRandom_tarih().random_g�n();
			// Veri bir art�r�l�yor
			tut = getSene().getAylar().elementAt(ay).elementAt(g�n);
			getSene().getAylar().elementAt(ay).set(g�n, tut + 1);
			// Veri birden b�y�k olurssa �ak��ma olmu� oluyor
		}
	}

	public static Y�l getSene() {
		return sene;
	}

	public static void setSene(Y�l sene) {
		Deneyler.sene = sene;
	}

	private static int getTekrar() {
		return tekrar;
	}

	private static void setTekrar(int tekrar) {
		Deneyler.tekrar = tekrar;
	}

	public static �statistik getDeney_raporu() {
		return deney_raporu;
	}

	public static void setDeney_raporu(�statistik deney_raporu) {
		Deneyler.deney_raporu = deney_raporu;
	}

	public static Do�um_tarihi getRandom_tarih() {
		return random_tarih;
	}

	public static void setRandom_tarih(Do�um_tarihi random_tarih) {
		Deneyler.random_tarih = random_tarih;
	}
}
