package Test_Otopark;

public class Test_�arp��ma {
	private static Hegzaplex apartman;
	private static int kat_no;
	private static int n;
	private static Class<? extends Object> apartman_t�r�;

	public static void main(String[] args) {
		long total_time = 0;
		int saya� = 0;
		// Max performans �l��c�
		do {
			total_time = 0;
			saya� = 0;
			do {
				long startTime = System.currentTimeMillis();
				test();
				saya�++;
				long stopTime = System.currentTimeMillis();
				total_time += stopTime - startTime;
			} while (total_time < 300);// 100 milisaniye->1 sn
			System.out.println("Total Time:" + total_time + "Saya�:" + saya�);
		} while (saya� < 1500);// max 1903 kez otopark problemi ��z�ld� 3
								// saniyede
		System.out.println("Total Time:" + total_time + "Saya�:" + saya�);
		// 1 salisede ��z�len problem miktar� 4.86 ile 6.2 aras�nda de�i�iyor
	}

	public static void test() {
		setApartman(new Hegzaplex());// Otopark� olu�turur
		while (1 < Araba.getSaya�()) {
			��kar_Hegzaplexten();
		}
		��kar_Hegzaplexten();
	}

	private static void ��kar_Hegzaplexten() {
		setKat_no(Random.random(getApartman().getKatlar().size()));
		setApartman_t�r�(getApartman().getKatlar().elementAt(kat_no).getClass());
		if (getApartman_t�r�().toString().equals(
				"class Test_Otopark.Kat_dairesel")) {
			setN(1 + Random.random(15));
			((Kat_dairesel) getApartman().getKatlar().elementAt(kat_no))
					.��kar_daireselden(n);
			if (((Kat_dairesel) getApartman().getKatlar().elementAt(kat_no))
					.getPatlat�lan_d���m_say�s�() == 30) {
				getApartman().getKatlar().removeElementAt(kat_no);
			}
		} else {
			if (getApartman_t�r�().toString().equals(
					"class Test_Otopark.Kat_kuyruk")) {
				((Kat_kuyruk) getApartman().getKatlar().elementAt(kat_no))
						.��kar_kuyruktan();
				if (((Kat_kuyruk) getApartman().getKatlar().elementAt(kat_no))
						.getPatlat�lan_araba_say�s�() == 30) {
					getApartman().getKatlar().removeElementAt(kat_no);
				}
			} else {
				((Kat_y���t) getApartman().getKatlar().elementAt(kat_no))
						.��kar_y���ttan();
				if (((Kat_y���t) getApartman().getKatlar().elementAt(kat_no))
						.getPatlat�lan_araba_say�s�() == 30) {
					getApartman().getKatlar().removeElementAt(kat_no);
				}
			}
		}
	}

	public static Hegzaplex getApartman() {
		return apartman;
	}

	public static void setApartman(Hegzaplex daireler) {
		apartman = daireler;
	}

	public int getKat_no() {
		return kat_no;
	}

	public static void setKat_no(int no) {
		kat_no = no;
	}

	public static Class<? extends Object> getApartman_t�r�() {
		return apartman_t�r�;
	}

	public static void setApartman_t�r�(Class<? extends Object> apartman_t�r�) {
		Test_�arp��ma.apartman_t�r� = apartman_t�r�;
	}

	public int getN() {
		return n;
	}

	public static void setN(int n_atla) {
		n = n_atla;
	}

}
