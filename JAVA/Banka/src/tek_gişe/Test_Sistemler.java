package tek_giþe;

public class Test_Sistemler {
	private static Sistemler sistem;

	public static void main(String[] args) {
		sistemi_test_et();
		istatistik_yap();
		raporu_yazdýr();
		kuyrukta_daha_az_bekleyenleri_listele();
	}

	private static void sistemi_test_et() {
		setSistem(new Sistemler());
	}

	private static void istatistik_yap() {
		int önceliksiz_kuyrukta_beklenen_süre = 0, öncelikli_kuyrukta_beklenen_süre = 0, önceliksiz_kuyrukta_beklenen_toplam_süre = 0, öncelikli_kuyrukta_beklenen_toplam_süre = 0, evet = 1;

		float süre_kazancý_yüzde, önceliksiz_kuyruktaki_müþterilerin_ortalama_bekleme_süresi, öncelikli_kuyruktaki_müþterilerin_ortalama_bekleme_süresi;
		for (int i = 0; i < getSistem().getN(); i++) {
			önceliksiz_kuyrukta_beklenen_toplam_süre += önceliksiz_kuyrukta_beklenen_süre = getSistem()
					.getÖnceliksiz_sistem().getÖnceliksiz_Banka()
					.getRapor_klasörü().getRaporlar().elementAt(i)
					.getMüþterinin_kuyrukta_beklediði_süre();

			öncelikli_kuyrukta_beklenen_toplam_süre += öncelikli_kuyrukta_beklenen_süre = getSistem()
					.getÖncelikli_sistem().getÖncelikli_Banka()
					.getRapor_klasörü().getRaporlar().elementAt(i)
					.getMüþterinin_kuyrukta_beklediði_süre();

			// Kuyrukta daha az bekleme yapýldýysa
			if (öncelikli_kuyrukta_beklenen_süre < önceliksiz_kuyrukta_beklenen_süre) {
				getSistem().getÖnceliksiz_sistem().getÖnceliksiz_Banka()
						.getRapor_klasörü().getRaporlar().elementAt(i)
						.setDaha_az_bekledi_mi(evet);// Müþterinin önceliksiz
														// kuyrukta daha az
														// beklediði
														// belirtiliyor

				getSistem().getÖncelikli_sistem().getÖncelikli_Banka()
						.getRapor_klasörü().getRaporlar().elementAt(i)
						.setDaha_az_bekledi_mi(evet);// Müþterinin öncelikli
														// kuyrukta daha az
														// beklediði
														// belirtiliyor

			}
		}
		önceliksiz_kuyruktaki_müþterilerin_ortalama_bekleme_süresi = önceliksiz_kuyrukta_beklenen_toplam_süre
				/ getSistem().getN();
		System.out
				.println("önceliksiz_kuyruktaki_müþterilerin_ortalama_bekleme_süresi: "
						+ önceliksiz_kuyruktaki_müþterilerin_ortalama_bekleme_süresi);
		öncelikli_kuyruktaki_müþterilerin_ortalama_bekleme_süresi = öncelikli_kuyrukta_beklenen_toplam_süre
				/ getSistem().getN();
		System.out
				.println("öncelikli_kuyruktaki_müþterilerin_ortalama_bekleme_süresi: "
						+ öncelikli_kuyruktaki_müþterilerin_ortalama_bekleme_süresi);

		süre_kazancý_yüzde = (önceliksiz_kuyruktaki_müþterilerin_ortalama_bekleme_süresi - öncelikli_kuyruktaki_müþterilerin_ortalama_bekleme_süresi)
				* 100 / önceliksiz_kuyrukta_beklenen_süre;

		System.out.println("Süre_kazancý: %" + süre_kazancý_yüzde);
	}

	private static void raporu_yazdýr() {
		// Ayný müþterilerin girmiþ olduklarý farklý kuyruklarýn istatistik
		// bilgileri ekrana yazdýrýlýyor
		System.out.println(getSistem().getÖnceliksiz_sistem()
				.getÖnceliksiz_Banka().getRapor_klasörü().toString());
		System.out.println("**************************");
		System.out.println(getSistem().getÖncelikli_sistem()
				.getÖncelikli_Banka().getRapor_klasörü().toString());
	}

	private static void kuyrukta_daha_az_bekleyenleri_listele() {
		System.out.println("Öncelikli kuyrukta daha az bekleyenler\n");
		for (int i = 0; i < getSistem().getN(); i++) {

			// Müþteri öncelikli kuyrukta daha az beklediyse
			if (getSistem().getÖnceliksiz_sistem().getÖnceliksiz_Banka()
					.getRapor_klasörü().getRaporlar().elementAt(i)
					.getDaha_az_bekledi_mi() == 1) {
				System.out.println(getSistem().getÖnceliksiz_sistem()
						.getÖnceliksiz_Banka().getRapor_klasörü().getRaporlar()
						.elementAt(i).toString());// Müþteriye ait istatistiki
													// bilgiler ekrana
													// yazdýrýlýyor
			}
		}
	}

	public static Sistemler getSistem() {
		return sistem;
	}

	public static void setSistem(Sistemler sistem) {
		Test_Sistemler.sistem = sistem;
	}

}
