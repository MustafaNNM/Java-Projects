package tek_giþe;

public class Sistemler {
	private static int N;
	// Sistemi vektor olarak oluþturabilirdik ama farklý iki müþteri
	// sýnýfýndan(öncelikli ve önceliksiz) elemanlar barýndýrýyor. Yani böyle
	// olmasý þart
	private Öncelikli_Sistem öncelikli_sistem;// Öncelikli müþteri sýnýfýný
												// kullanýyor
	private Önceliksiz_Sistem önceliksiz_sistem;// Önceliksiz müþteri sýnýfýný
												// kullanýyor
	private Önceliksiz_Müþteriler önceliksiz_müþteriler;
	private Öncelikli_Müþteriler öncelikli_müþteriler;

	public Sistemler() {
		// setN(Random.random(101));// Bankaya en çok 100 müþteri gelsin diye
		setN(100);
		// Müþteriler için öncelikli ve önceliksiz kuyruk yapýlarý oluþturuluyor
		setÖnceliksiz_müþteriler(new Önceliksiz_Müþteriler(getN()));
		setÖncelikli_müþteriler(new Öncelikli_Müþteriler(getN()));
		// Kuyruk yapýlarýna ayný deðerlere sahip N tane müþteri nesnesi
		// ekleniyor
		farklý_iki_kuyruk_oluþtur();
		// Ayný müþteriler için iki ayrý banka oluþturuluyor
		setÖnceliksiz_sistem(new Önceliksiz_Sistem(getN()));
		setÖncelikli_sistem(new Öncelikli_Sistem(getN()));
		// Müþteri kuyruklarý bitene kadar sistemler çalýþtýrýlýyor
		sistemleri_çalýþtýr();
	}

	private void farklý_iki_kuyruk_oluþtur() {
		Müþteri müþteri;
		for (int i = 0; i < getN(); i++) {
			müþteri = new Müþteri();
			// Ayný müþteri iki kuyruða da ekleniyor
			getÖnceliksiz_müþteriler().müþteri_ekle(müþteri);
			getÖncelikli_müþteriler().müþteri_ekle(müþteri);
		}
	}

	private void sistemleri_çalýþtýr() {
		// Ayný müþteriler iki farklý sistemde iþlem görüyor
		önceliksiz_sistemi_çalýþtýr();
		öncelikli_sistemi_çalýþtýr();
	}

	private void önceliksiz_sistemi_çalýþtýr() {
		// Müþteriler geliþ sýralarýna göre iþleme tabi tutulur
		// Müþteri kuyruklarý bitene kadar sistem çalýþtýrýlýyor
		Müþteri müþteri = new Müþteri();
		int giþe_no, müþterinin_veznede_beklediði_süre, müþterinin_kuyrukta_beklediði_süre, müþterilerin_kuyrukta_beklediði_süre;
		getÖnceliksiz_sistem().getÖnceliksiz_Banka().getVezne()
				.setToplam_bekletme_süresi(0);
		for (int i = 0; i < getN(); i++) {
			// Ýþleme tabi tutulacak olan müþteri kuyruktan alýnýyor
			müþterinin_kuyrukta_beklediði_süre = getÖnceliksiz_sistem()
					.getÖnceliksiz_Banka().getVezne()
					.getToplam_bekletme_süresi();

			müþteri = getÖnceliksiz_müþteriler().müþteri_çýkar();
			müþteri.setGiþe_no(0);
			giþe_no = 0;
			müþterinin_veznede_beklediði_süre = müþteri.getSüre();
			getÖnceliksiz_sistem().getÖnceliksiz_Banka().getVezne()
					.setIþlem_süresi(müþteri.getSüre());
			getÖnceliksiz_sistem()
					.getÖnceliksiz_Banka()
					.getVezne()
					.setToplam_bekletme_süresi(
							getÖnceliksiz_sistem().getÖnceliksiz_Banka()
									.getVezne().getToplam_bekletme_süresi()
									+ müþteri.getSüre());
			müþterilerin_kuyrukta_beklediði_süre = getÖnceliksiz_sistem()
					.getÖnceliksiz_Banka().getVezne()
					.getToplam_bekletme_süresi();
			System.out.println("Giþe no:" + giþe_no + "\nmüþteri.getNo():"
					+ müþteri.getNo() + "\nmüþterinin_veznede_beklediði_süre:"
					+ müþterinin_veznede_beklediði_süre
					+ "\nmüþterinin_kuyrukta_beklediði_süre:"
					+ müþterinin_kuyrukta_beklediði_süre
					+ "\nmüþterinin_bankada_beklediði_süre:"
					+ müþterilerin_kuyrukta_beklediði_süre);
			önceliksiz_sistem_için_rapor_hazýrla(giþe_no,müþteri.getNo(),
					müþterinin_veznede_beklediði_süre,
					müþterinin_kuyrukta_beklediði_süre,
					müþterilerin_kuyrukta_beklediði_süre);
		}
	}

	private void önceliksiz_sistem_için_rapor_hazýrla(int giþe_no,int müþteri_no,
			int müþterinin_veznede_beklediði_süre,
			int müþterinin_kuyrukta_beklediði_süre, int toplam_bekletme_süresi) {
		// Raporun kaydedileceði belirlenip numaralandýrýlýyor
		getÖnceliksiz_sistem().getÖnceliksiz_Banka().getRapor_klasörü()
				.getRaporlar().elementAt(müþteri_no).setNo(müþteri_no);// Rapora
																		// kayýt
																		// yapýlýrken
																		// müþteri_no
																		// index
																		// olarak
																		// kullanýlýyor
		getÖnceliksiz_sistem().getÖnceliksiz_Banka().getRapor_klasörü()
		.getRaporlar().elementAt(müþteri_no).setGiþe_no(giþe_no);
		getÖnceliksiz_sistem().getÖnceliksiz_Banka().getRapor_klasörü()
				.getRaporlar().elementAt(müþteri_no)
				.setVeznedeki_iþlem_süresi(müþterinin_veznede_beklediði_süre);// Müþterinin
																				// ne
																				// kadar
																				// kuyrukta
																				// beklediði
																				// (Ýþlem
																				// süresi)
																				// giþede
																				// rapora
																				// kaydediliyor

		getÖnceliksiz_sistem()
				.getÖnceliksiz_Banka()
				.getRapor_klasörü()
				.getRaporlar()
				.elementAt(müþteri_no)
				.setMüþterinin_kuyrukta_beklediði_süre(
						müþterinin_kuyrukta_beklediði_süre);// Müþterinin ne
															// kadar
															// kuyrukta
															// beklediði
															// rapora
															// kaydediliyor

		getÖnceliksiz_sistem().getÖnceliksiz_Banka().getRapor_klasörü()
				.getRaporlar().elementAt(müþteri_no)
				.setBankada_beklediði_süre(toplam_bekletme_süresi);// Giþe
																	// bir
																	// müþterinin
																	// iþini
																	// maximum
																	// ne
																	// kadar
																	// sürede
																	// hallettiðini
																	// rapora
																	// kaydediyor

	}

	private void öncelikli_sistemi_çalýþtýr() {
		// Müþteriler iþlem sürelerine göre iþleme tabi tutulur
		// Müþteri kuyruklarý bitene kadar sistem çalýþtýrýlýyor
		Müþteri müþteri = new Müþteri();
		int giþe_no,müþterinin_veznede_beklediði_süre, müþterinin_kuyrukta_beklediði_süre, müþterilerin_kuyrukta_beklediði_süre;
		// Veznedarýn gelmesi bekleniyor
		getÖncelikli_sistem().getÖncelikli_Banka().getVezne()
				.setToplam_bekletme_süresi(0);
		for (int i = 0; i < getN(); i++) {
			// Ýþleme tabi tutulacak olan müþteri kuyruktan alýnýyor
			müþterinin_kuyrukta_beklediði_süre = getÖncelikli_sistem()
					.getÖncelikli_Banka().getVezne()
					.getToplam_bekletme_süresi();

			müþteri = getÖncelikli_müþteriler().müþteri_çýkar();
			giþe_no=0;
			müþterinin_veznede_beklediði_süre = müþteri.getSüre();
			getÖncelikli_sistem().getÖncelikli_Banka().getVezne()
					.setIþlem_süresi(müþteri.getSüre());
			getÖncelikli_sistem()
					.getÖncelikli_Banka()
					.getVezne()
					.setToplam_bekletme_süresi(
							getÖncelikli_sistem().getÖncelikli_Banka()
									.getVezne().getToplam_bekletme_süresi()
									+ müþteri.getSüre());
			müþterilerin_kuyrukta_beklediði_süre = getÖncelikli_sistem()
					.getÖncelikli_Banka().getVezne()
					.getToplam_bekletme_süresi();
			System.out.println("müþteri.getNo():" + müþteri.getNo()
					+ "\nmüþterinin_veznede_beklediði_süre:"
					+ müþterinin_veznede_beklediði_süre
					+ "\nmüþterinin_kuyrukta_beklediði_süre:"
					+ müþterinin_kuyrukta_beklediði_süre
					+ "\nmüþterinin_bankada_beklediði_süre:"
					+ müþterilerin_kuyrukta_beklediði_süre);
			öncelikli_sistem_için_rapor_hazýrla(giþe_no,müþteri.getNo(),
					müþterinin_veznede_beklediði_süre,
					müþterinin_kuyrukta_beklediði_süre,
					müþterilerin_kuyrukta_beklediði_süre);
		}
	}

	private void öncelikli_sistem_için_rapor_hazýrla(int giþe_no,int müþteri_no,
			int müþterinin_veznede_beklediði_süre,
			int müþterinin_kuyrukta_beklediði_süre, int toplam_bekletme_süresi) {
		// Raporun kaydedileceði belirlenip numaralandýrýlýyor
		getÖncelikli_sistem().getÖncelikli_Banka().getRapor_klasörü()
				.getRaporlar().elementAt(müþteri_no).setNo(müþteri_no);// Rapora
																		// kayýt
																		// yapýlýrken
																		// müþteri_no
																		// index
																		// olarak
																		// kullanýlýyor
		getÖncelikli_sistem().getÖncelikli_Banka().getRapor_klasörü()
		.getRaporlar().elementAt(müþteri_no).setGiþe_no(giþe_no);
		getÖncelikli_sistem().getÖncelikli_Banka().getRapor_klasörü()
				.getRaporlar().elementAt(müþteri_no)
				.setVeznedeki_iþlem_süresi(müþterinin_veznede_beklediði_süre);// Müþterinin
																				// ne
																				// kadar
																				// kuyrukta
																				// beklediði
																				// (Ýþlem
																				// süresi)
																				// giþede
																				// rapora
																				// kaydediliyor

		getÖncelikli_sistem()
				.getÖncelikli_Banka()
				.getRapor_klasörü()
				.getRaporlar()
				.elementAt(müþteri_no)
				.setMüþterinin_kuyrukta_beklediði_süre(
						müþterinin_kuyrukta_beklediði_süre);// Müþterinin ne
															// kadar
															// kuyrukta
															// beklediði
															// rapora
															// kaydediliyor

		getÖncelikli_sistem().getÖncelikli_Banka().getRapor_klasörü()
				.getRaporlar().elementAt(müþteri_no)
				.setBankada_beklediði_süre(toplam_bekletme_süresi);// Giþe
																	// bir
																	// müþterinin
																	// iþini
																	// maximum
																	// ne
																	// kadar
																	// sürede
																	// hallettiðini
																	// rapora
																	// kaydediyor

	}

	public Öncelikli_Sistem getÖncelikli_sistem() {
		return öncelikli_sistem;
	}

	public void setÖncelikli_sistem(Öncelikli_Sistem öncelikli_sistem) {
		this.öncelikli_sistem = öncelikli_sistem;
	}

	public Önceliksiz_Sistem getÖnceliksiz_sistem() {
		return önceliksiz_sistem;
	}

	public void setÖnceliksiz_sistem(Önceliksiz_Sistem önceliksiz_sistem) {
		this.önceliksiz_sistem = önceliksiz_sistem;
	}

	public Önceliksiz_Müþteriler getÖnceliksiz_müþteriler() {
		return önceliksiz_müþteriler;
	}

	public void setÖnceliksiz_müþteriler(
			Önceliksiz_Müþteriler önceliksiz_müþteriler) {
		this.önceliksiz_müþteriler = önceliksiz_müþteriler;
	}

	public Öncelikli_Müþteriler getÖncelikli_müþteriler() {
		return öncelikli_müþteriler;
	}

	public void setÖncelikli_müþteriler(
			Öncelikli_Müþteriler öncelikli_müþteriler) {
		this.öncelikli_müþteriler = öncelikli_müþteriler;
	}

	public int getN() {
		return N;
	}

	public static void setN(int n) {
		N = n;
	}
}
