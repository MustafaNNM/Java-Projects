package tek_gi�e;

public class Test_Sistemler {
	private static Sistemler sistem;

	public static void main(String[] args) {
		sistemi_test_et();
		istatistik_yap();
		raporu_yazd�r();
		kuyrukta_daha_az_bekleyenleri_listele();
	}

	private static void sistemi_test_et() {
		setSistem(new Sistemler());
	}

	private static void istatistik_yap() {
		int �nceliksiz_kuyrukta_beklenen_s�re = 0, �ncelikli_kuyrukta_beklenen_s�re = 0, �nceliksiz_kuyrukta_beklenen_toplam_s�re = 0, �ncelikli_kuyrukta_beklenen_toplam_s�re = 0, evet = 1;

		float s�re_kazanc�_y�zde, �nceliksiz_kuyruktaki_m��terilerin_ortalama_bekleme_s�resi, �ncelikli_kuyruktaki_m��terilerin_ortalama_bekleme_s�resi;
		for (int i = 0; i < getSistem().getN(); i++) {
			�nceliksiz_kuyrukta_beklenen_toplam_s�re += �nceliksiz_kuyrukta_beklenen_s�re = getSistem()
					.get�nceliksiz_sistem().get�nceliksiz_Banka()
					.getRapor_klas�r�().getRaporlar().elementAt(i)
					.getM��terinin_kuyrukta_bekledi�i_s�re();

			�ncelikli_kuyrukta_beklenen_toplam_s�re += �ncelikli_kuyrukta_beklenen_s�re = getSistem()
					.get�ncelikli_sistem().get�ncelikli_Banka()
					.getRapor_klas�r�().getRaporlar().elementAt(i)
					.getM��terinin_kuyrukta_bekledi�i_s�re();

			// Kuyrukta daha az bekleme yap�ld�ysa
			if (�ncelikli_kuyrukta_beklenen_s�re < �nceliksiz_kuyrukta_beklenen_s�re) {
				getSistem().get�nceliksiz_sistem().get�nceliksiz_Banka()
						.getRapor_klas�r�().getRaporlar().elementAt(i)
						.setDaha_az_bekledi_mi(evet);// M��terinin �nceliksiz
														// kuyrukta daha az
														// bekledi�i
														// belirtiliyor

				getSistem().get�ncelikli_sistem().get�ncelikli_Banka()
						.getRapor_klas�r�().getRaporlar().elementAt(i)
						.setDaha_az_bekledi_mi(evet);// M��terinin �ncelikli
														// kuyrukta daha az
														// bekledi�i
														// belirtiliyor

			}
		}
		�nceliksiz_kuyruktaki_m��terilerin_ortalama_bekleme_s�resi = �nceliksiz_kuyrukta_beklenen_toplam_s�re
				/ getSistem().getN();
		System.out
				.println("�nceliksiz_kuyruktaki_m��terilerin_ortalama_bekleme_s�resi: "
						+ �nceliksiz_kuyruktaki_m��terilerin_ortalama_bekleme_s�resi);
		�ncelikli_kuyruktaki_m��terilerin_ortalama_bekleme_s�resi = �ncelikli_kuyrukta_beklenen_toplam_s�re
				/ getSistem().getN();
		System.out
				.println("�ncelikli_kuyruktaki_m��terilerin_ortalama_bekleme_s�resi: "
						+ �ncelikli_kuyruktaki_m��terilerin_ortalama_bekleme_s�resi);

		s�re_kazanc�_y�zde = (�nceliksiz_kuyruktaki_m��terilerin_ortalama_bekleme_s�resi - �ncelikli_kuyruktaki_m��terilerin_ortalama_bekleme_s�resi)
				* 100 / �nceliksiz_kuyrukta_beklenen_s�re;

		System.out.println("S�re_kazanc�: %" + s�re_kazanc�_y�zde);
	}

	private static void raporu_yazd�r() {
		// Ayn� m��terilerin girmi� olduklar� farkl� kuyruklar�n istatistik
		// bilgileri ekrana yazd�r�l�yor
		System.out.println(getSistem().get�nceliksiz_sistem()
				.get�nceliksiz_Banka().getRapor_klas�r�().toString());
		System.out.println("**************************");
		System.out.println(getSistem().get�ncelikli_sistem()
				.get�ncelikli_Banka().getRapor_klas�r�().toString());
	}

	private static void kuyrukta_daha_az_bekleyenleri_listele() {
		System.out.println("�ncelikli kuyrukta daha az bekleyenler\n");
		for (int i = 0; i < getSistem().getN(); i++) {

			// M��teri �ncelikli kuyrukta daha az beklediyse
			if (getSistem().get�nceliksiz_sistem().get�nceliksiz_Banka()
					.getRapor_klas�r�().getRaporlar().elementAt(i)
					.getDaha_az_bekledi_mi() == 1) {
				System.out.println(getSistem().get�nceliksiz_sistem()
						.get�nceliksiz_Banka().getRapor_klas�r�().getRaporlar()
						.elementAt(i).toString());// M��teriye ait istatistiki
													// bilgiler ekrana
													// yazd�r�l�yor
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
