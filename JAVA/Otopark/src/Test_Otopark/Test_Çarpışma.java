package Test_Otopark;

public class Test_Çarpýþma {
	private static Hegzaplex apartman;
	private static int kat_no;
	private static int n;
	private static Class<? extends Object> apartman_türü;

	public static void main(String[] args) {
		long total_time = 0;
		int sayaç = 0;
		// Max performans ölçücü
		do {
			total_time = 0;
			sayaç = 0;
			do {
				long startTime = System.currentTimeMillis();
				test();
				sayaç++;
				long stopTime = System.currentTimeMillis();
				total_time += stopTime - startTime;
			} while (total_time < 300);// 100 milisaniye->1 sn
			System.out.println("Total Time:" + total_time + "Sayaç:" + sayaç);
		} while (sayaç < 1500);// max 1903 kez otopark problemi çözüldü 3
								// saniyede
		System.out.println("Total Time:" + total_time + "Sayaç:" + sayaç);
		// 1 salisede çözülen problem miktarý 4.86 ile 6.2 arasýnda deðiþiyor
	}

	public static void test() {
		setApartman(new Hegzaplex());// Otoparký oluþturur
		while (1 < Araba.getSayaç()) {
			çýkar_Hegzaplexten();
		}
		çýkar_Hegzaplexten();
	}

	private static void çýkar_Hegzaplexten() {
		setKat_no(Random.random(getApartman().getKatlar().size()));
		setApartman_türü(getApartman().getKatlar().elementAt(kat_no).getClass());
		if (getApartman_türü().toString().equals(
				"class Test_Otopark.Kat_dairesel")) {
			setN(1 + Random.random(15));
			((Kat_dairesel) getApartman().getKatlar().elementAt(kat_no))
					.çýkar_daireselden(n);
			if (((Kat_dairesel) getApartman().getKatlar().elementAt(kat_no))
					.getPatlatýlan_düðüm_sayýsý() == 30) {
				getApartman().getKatlar().removeElementAt(kat_no);
			}
		} else {
			if (getApartman_türü().toString().equals(
					"class Test_Otopark.Kat_kuyruk")) {
				((Kat_kuyruk) getApartman().getKatlar().elementAt(kat_no))
						.çýkar_kuyruktan();
				if (((Kat_kuyruk) getApartman().getKatlar().elementAt(kat_no))
						.getPatlatýlan_araba_sayýsý() == 30) {
					getApartman().getKatlar().removeElementAt(kat_no);
				}
			} else {
				((Kat_yýðýt) getApartman().getKatlar().elementAt(kat_no))
						.çýkar_yýðýttan();
				if (((Kat_yýðýt) getApartman().getKatlar().elementAt(kat_no))
						.getPatlatýlan_araba_sayýsý() == 30) {
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

	public static Class<? extends Object> getApartman_türü() {
		return apartman_türü;
	}

	public static void setApartman_türü(Class<? extends Object> apartman_türü) {
		Test_Çarpýþma.apartman_türü = apartman_türü;
	}

	public int getN() {
		return n;
	}

	public static void setN(int n_atla) {
		n = n_atla;
	}

}
