package Otopark;

public class Test_�arp��ma {
	private static Hegzaplex apartman;
	private static int kat_no;
	private static int n;
	private static Class<? extends Object> apartman_t�r�;

	public static void main(String[] args) {
		setApartman(new Hegzaplex());// Otopark� olu�turur
		System.out.println(getApartman());// Otoparktaki arabalar� yazd�r�r
		while (1 < Araba.getSaya�()) {
			��kar_Hegzaplexten();
		}
		System.out.printf(
				"**************Sondan %d. Araba kald�*****************\n",
				+Araba.getSaya�());
		��kar_Hegzaplexten();
	}

	private static void ��kar_Hegzaplexten() {
		setKat_no(Random.random(getApartman().getKatlar().size()));
		setApartman_t�r�(getApartman().getKatlar().elementAt(kat_no).getClass());
		System.out.println("Kat t�r�:" + getApartman_t�r�() + "\nkat no:"
				+ kat_no);
		if (getApartman_t�r�().toString().equals("class Otopark.Kat_dairesel")) {
			System.out.println("Yeniden random bir say� �retmek gerekiyor");
			setN(1 + Random.random(15));
			((Kat_dairesel) getApartman().getKatlar().elementAt(kat_no))
					.��kar_daireselden(n);
			if (((Kat_dairesel) getApartman().getKatlar().elementAt(kat_no))
					.getPatlat�lan_d���m_say�s�() == 30) {
				getApartman().getKatlar().removeElementAt(kat_no);
				System.out.println("Bu katta eleman kalmad�");
			}
		} else {
			if (getApartman_t�r�().toString()
					.equals("class Otopark.Kat_kuyruk")) {
				((Kat_kuyruk) getApartman().getKatlar().elementAt(kat_no))
						.��kar_kuyruktan();
				if (((Kat_kuyruk) getApartman().getKatlar().elementAt(kat_no))
						.getPatlat�lan_araba_say�s�() == 30) {
					getApartman().getKatlar().removeElementAt(kat_no);
					System.out.println("Bu katta eleman kalmad�");
				}
			} else {
				((Kat_y���t) getApartman().getKatlar().elementAt(kat_no))
						.��kar_y���ttan();
				if (((Kat_y���t) getApartman().getKatlar().elementAt(kat_no))
						.getPatlat�lan_araba_say�s�() == 30) {
					getApartman().getKatlar().removeElementAt(kat_no);
					System.out.println("Bu katta eleman kalmad�");
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
