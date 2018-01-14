package Otopark;

public class Test_Çarpýþma {
	private static Hegzaplex apartman;
	private static int kat_no;
	private static int n;
	private static Class<? extends Object> apartman_türü;

	public static void main(String[] args) {
		setApartman(new Hegzaplex());// Otoparký oluþturur
		System.out.println(getApartman());// Otoparktaki arabalarý yazdýrýr
		while (1 < Araba.getSayaç()) {
			çýkar_Hegzaplexten();
		}
		System.out.printf(
				"**************Sondan %d. Araba kaldý*****************\n",
				+Araba.getSayaç());
		çýkar_Hegzaplexten();
	}

	private static void çýkar_Hegzaplexten() {
		setKat_no(Random.random(getApartman().getKatlar().size()));
		setApartman_türü(getApartman().getKatlar().elementAt(kat_no).getClass());
		System.out.println("Kat türü:" + getApartman_türü() + "\nkat no:"
				+ kat_no);
		if (getApartman_türü().toString().equals("class Otopark.Kat_dairesel")) {
			System.out.println("Yeniden random bir sayý üretmek gerekiyor");
			setN(1 + Random.random(15));
			((Kat_dairesel) getApartman().getKatlar().elementAt(kat_no))
					.çýkar_daireselden(n);
			if (((Kat_dairesel) getApartman().getKatlar().elementAt(kat_no))
					.getPatlatýlan_düðüm_sayýsý() == 30) {
				getApartman().getKatlar().removeElementAt(kat_no);
				System.out.println("Bu katta eleman kalmadý");
			}
		} else {
			if (getApartman_türü().toString()
					.equals("class Otopark.Kat_kuyruk")) {
				((Kat_kuyruk) getApartman().getKatlar().elementAt(kat_no))
						.çýkar_kuyruktan();
				if (((Kat_kuyruk) getApartman().getKatlar().elementAt(kat_no))
						.getPatlatýlan_araba_sayýsý() == 30) {
					getApartman().getKatlar().removeElementAt(kat_no);
					System.out.println("Bu katta eleman kalmadý");
				}
			} else {
				((Kat_yýðýt) getApartman().getKatlar().elementAt(kat_no))
						.çýkar_yýðýttan();
				if (((Kat_yýðýt) getApartman().getKatlar().elementAt(kat_no))
						.getPatlatýlan_araba_sayýsý() == 30) {
					getApartman().getKatlar().removeElementAt(kat_no);
					System.out.println("Bu katta eleman kalmadý");
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
