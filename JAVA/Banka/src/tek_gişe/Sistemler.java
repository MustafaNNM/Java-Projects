package tek_gi�e;

public class Sistemler {
	private static int N;
	// Sistemi vektor olarak olu�turabilirdik ama farkl� iki m��teri
	// s�n�f�ndan(�ncelikli ve �nceliksiz) elemanlar bar�nd�r�yor. Yani b�yle
	// olmas� �art
	private �ncelikli_Sistem �ncelikli_sistem;// �ncelikli m��teri s�n�f�n�
												// kullan�yor
	private �nceliksiz_Sistem �nceliksiz_sistem;// �nceliksiz m��teri s�n�f�n�
												// kullan�yor
	private �nceliksiz_M��teriler �nceliksiz_m��teriler;
	private �ncelikli_M��teriler �ncelikli_m��teriler;

	public Sistemler() {
		// setN(Random.random(101));// Bankaya en �ok 100 m��teri gelsin diye
		setN(100);
		// M��teriler i�in �ncelikli ve �nceliksiz kuyruk yap�lar� olu�turuluyor
		set�nceliksiz_m��teriler(new �nceliksiz_M��teriler(getN()));
		set�ncelikli_m��teriler(new �ncelikli_M��teriler(getN()));
		// Kuyruk yap�lar�na ayn� de�erlere sahip N tane m��teri nesnesi
		// ekleniyor
		farkl�_iki_kuyruk_olu�tur();
		// Ayn� m��teriler i�in iki ayr� banka olu�turuluyor
		set�nceliksiz_sistem(new �nceliksiz_Sistem(getN()));
		set�ncelikli_sistem(new �ncelikli_Sistem(getN()));
		// M��teri kuyruklar� bitene kadar sistemler �al��t�r�l�yor
		sistemleri_�al��t�r();
	}

	private void farkl�_iki_kuyruk_olu�tur() {
		M��teri m��teri;
		for (int i = 0; i < getN(); i++) {
			m��teri = new M��teri();
			// Ayn� m��teri iki kuyru�a da ekleniyor
			get�nceliksiz_m��teriler().m��teri_ekle(m��teri);
			get�ncelikli_m��teriler().m��teri_ekle(m��teri);
		}
	}

	private void sistemleri_�al��t�r() {
		// Ayn� m��teriler iki farkl� sistemde i�lem g�r�yor
		�nceliksiz_sistemi_�al��t�r();
		�ncelikli_sistemi_�al��t�r();
	}

	private void �nceliksiz_sistemi_�al��t�r() {
		// M��teriler geli� s�ralar�na g�re i�leme tabi tutulur
		// M��teri kuyruklar� bitene kadar sistem �al��t�r�l�yor
		M��teri m��teri = new M��teri();
		int gi�e_no, m��terinin_veznede_bekledi�i_s�re, m��terinin_kuyrukta_bekledi�i_s�re, m��terilerin_kuyrukta_bekledi�i_s�re;
		get�nceliksiz_sistem().get�nceliksiz_Banka().getVezne()
				.setToplam_bekletme_s�resi(0);
		for (int i = 0; i < getN(); i++) {
			// ��leme tabi tutulacak olan m��teri kuyruktan al�n�yor
			m��terinin_kuyrukta_bekledi�i_s�re = get�nceliksiz_sistem()
					.get�nceliksiz_Banka().getVezne()
					.getToplam_bekletme_s�resi();

			m��teri = get�nceliksiz_m��teriler().m��teri_��kar();
			m��teri.setGi�e_no(0);
			gi�e_no = 0;
			m��terinin_veznede_bekledi�i_s�re = m��teri.getS�re();
			get�nceliksiz_sistem().get�nceliksiz_Banka().getVezne()
					.setI�lem_s�resi(m��teri.getS�re());
			get�nceliksiz_sistem()
					.get�nceliksiz_Banka()
					.getVezne()
					.setToplam_bekletme_s�resi(
							get�nceliksiz_sistem().get�nceliksiz_Banka()
									.getVezne().getToplam_bekletme_s�resi()
									+ m��teri.getS�re());
			m��terilerin_kuyrukta_bekledi�i_s�re = get�nceliksiz_sistem()
					.get�nceliksiz_Banka().getVezne()
					.getToplam_bekletme_s�resi();
			System.out.println("Gi�e no:" + gi�e_no + "\nm��teri.getNo():"
					+ m��teri.getNo() + "\nm��terinin_veznede_bekledi�i_s�re:"
					+ m��terinin_veznede_bekledi�i_s�re
					+ "\nm��terinin_kuyrukta_bekledi�i_s�re:"
					+ m��terinin_kuyrukta_bekledi�i_s�re
					+ "\nm��terinin_bankada_bekledi�i_s�re:"
					+ m��terilerin_kuyrukta_bekledi�i_s�re);
			�nceliksiz_sistem_i�in_rapor_haz�rla(gi�e_no,m��teri.getNo(),
					m��terinin_veznede_bekledi�i_s�re,
					m��terinin_kuyrukta_bekledi�i_s�re,
					m��terilerin_kuyrukta_bekledi�i_s�re);
		}
	}

	private void �nceliksiz_sistem_i�in_rapor_haz�rla(int gi�e_no,int m��teri_no,
			int m��terinin_veznede_bekledi�i_s�re,
			int m��terinin_kuyrukta_bekledi�i_s�re, int toplam_bekletme_s�resi) {
		// Raporun kaydedilece�i belirlenip numaraland�r�l�yor
		get�nceliksiz_sistem().get�nceliksiz_Banka().getRapor_klas�r�()
				.getRaporlar().elementAt(m��teri_no).setNo(m��teri_no);// Rapora
																		// kay�t
																		// yap�l�rken
																		// m��teri_no
																		// index
																		// olarak
																		// kullan�l�yor
		get�nceliksiz_sistem().get�nceliksiz_Banka().getRapor_klas�r�()
		.getRaporlar().elementAt(m��teri_no).setGi�e_no(gi�e_no);
		get�nceliksiz_sistem().get�nceliksiz_Banka().getRapor_klas�r�()
				.getRaporlar().elementAt(m��teri_no)
				.setVeznedeki_i�lem_s�resi(m��terinin_veznede_bekledi�i_s�re);// M��terinin
																				// ne
																				// kadar
																				// kuyrukta
																				// bekledi�i
																				// (��lem
																				// s�resi)
																				// gi�ede
																				// rapora
																				// kaydediliyor

		get�nceliksiz_sistem()
				.get�nceliksiz_Banka()
				.getRapor_klas�r�()
				.getRaporlar()
				.elementAt(m��teri_no)
				.setM��terinin_kuyrukta_bekledi�i_s�re(
						m��terinin_kuyrukta_bekledi�i_s�re);// M��terinin ne
															// kadar
															// kuyrukta
															// bekledi�i
															// rapora
															// kaydediliyor

		get�nceliksiz_sistem().get�nceliksiz_Banka().getRapor_klas�r�()
				.getRaporlar().elementAt(m��teri_no)
				.setBankada_bekledi�i_s�re(toplam_bekletme_s�resi);// Gi�e
																	// bir
																	// m��terinin
																	// i�ini
																	// maximum
																	// ne
																	// kadar
																	// s�rede
																	// halletti�ini
																	// rapora
																	// kaydediyor

	}

	private void �ncelikli_sistemi_�al��t�r() {
		// M��teriler i�lem s�relerine g�re i�leme tabi tutulur
		// M��teri kuyruklar� bitene kadar sistem �al��t�r�l�yor
		M��teri m��teri = new M��teri();
		int gi�e_no,m��terinin_veznede_bekledi�i_s�re, m��terinin_kuyrukta_bekledi�i_s�re, m��terilerin_kuyrukta_bekledi�i_s�re;
		// Veznedar�n gelmesi bekleniyor
		get�ncelikli_sistem().get�ncelikli_Banka().getVezne()
				.setToplam_bekletme_s�resi(0);
		for (int i = 0; i < getN(); i++) {
			// ��leme tabi tutulacak olan m��teri kuyruktan al�n�yor
			m��terinin_kuyrukta_bekledi�i_s�re = get�ncelikli_sistem()
					.get�ncelikli_Banka().getVezne()
					.getToplam_bekletme_s�resi();

			m��teri = get�ncelikli_m��teriler().m��teri_��kar();
			gi�e_no=0;
			m��terinin_veznede_bekledi�i_s�re = m��teri.getS�re();
			get�ncelikli_sistem().get�ncelikli_Banka().getVezne()
					.setI�lem_s�resi(m��teri.getS�re());
			get�ncelikli_sistem()
					.get�ncelikli_Banka()
					.getVezne()
					.setToplam_bekletme_s�resi(
							get�ncelikli_sistem().get�ncelikli_Banka()
									.getVezne().getToplam_bekletme_s�resi()
									+ m��teri.getS�re());
			m��terilerin_kuyrukta_bekledi�i_s�re = get�ncelikli_sistem()
					.get�ncelikli_Banka().getVezne()
					.getToplam_bekletme_s�resi();
			System.out.println("m��teri.getNo():" + m��teri.getNo()
					+ "\nm��terinin_veznede_bekledi�i_s�re:"
					+ m��terinin_veznede_bekledi�i_s�re
					+ "\nm��terinin_kuyrukta_bekledi�i_s�re:"
					+ m��terinin_kuyrukta_bekledi�i_s�re
					+ "\nm��terinin_bankada_bekledi�i_s�re:"
					+ m��terilerin_kuyrukta_bekledi�i_s�re);
			�ncelikli_sistem_i�in_rapor_haz�rla(gi�e_no,m��teri.getNo(),
					m��terinin_veznede_bekledi�i_s�re,
					m��terinin_kuyrukta_bekledi�i_s�re,
					m��terilerin_kuyrukta_bekledi�i_s�re);
		}
	}

	private void �ncelikli_sistem_i�in_rapor_haz�rla(int gi�e_no,int m��teri_no,
			int m��terinin_veznede_bekledi�i_s�re,
			int m��terinin_kuyrukta_bekledi�i_s�re, int toplam_bekletme_s�resi) {
		// Raporun kaydedilece�i belirlenip numaraland�r�l�yor
		get�ncelikli_sistem().get�ncelikli_Banka().getRapor_klas�r�()
				.getRaporlar().elementAt(m��teri_no).setNo(m��teri_no);// Rapora
																		// kay�t
																		// yap�l�rken
																		// m��teri_no
																		// index
																		// olarak
																		// kullan�l�yor
		get�ncelikli_sistem().get�ncelikli_Banka().getRapor_klas�r�()
		.getRaporlar().elementAt(m��teri_no).setGi�e_no(gi�e_no);
		get�ncelikli_sistem().get�ncelikli_Banka().getRapor_klas�r�()
				.getRaporlar().elementAt(m��teri_no)
				.setVeznedeki_i�lem_s�resi(m��terinin_veznede_bekledi�i_s�re);// M��terinin
																				// ne
																				// kadar
																				// kuyrukta
																				// bekledi�i
																				// (��lem
																				// s�resi)
																				// gi�ede
																				// rapora
																				// kaydediliyor

		get�ncelikli_sistem()
				.get�ncelikli_Banka()
				.getRapor_klas�r�()
				.getRaporlar()
				.elementAt(m��teri_no)
				.setM��terinin_kuyrukta_bekledi�i_s�re(
						m��terinin_kuyrukta_bekledi�i_s�re);// M��terinin ne
															// kadar
															// kuyrukta
															// bekledi�i
															// rapora
															// kaydediliyor

		get�ncelikli_sistem().get�ncelikli_Banka().getRapor_klas�r�()
				.getRaporlar().elementAt(m��teri_no)
				.setBankada_bekledi�i_s�re(toplam_bekletme_s�resi);// Gi�e
																	// bir
																	// m��terinin
																	// i�ini
																	// maximum
																	// ne
																	// kadar
																	// s�rede
																	// halletti�ini
																	// rapora
																	// kaydediyor

	}

	public �ncelikli_Sistem get�ncelikli_sistem() {
		return �ncelikli_sistem;
	}

	public void set�ncelikli_sistem(�ncelikli_Sistem �ncelikli_sistem) {
		this.�ncelikli_sistem = �ncelikli_sistem;
	}

	public �nceliksiz_Sistem get�nceliksiz_sistem() {
		return �nceliksiz_sistem;
	}

	public void set�nceliksiz_sistem(�nceliksiz_Sistem �nceliksiz_sistem) {
		this.�nceliksiz_sistem = �nceliksiz_sistem;
	}

	public �nceliksiz_M��teriler get�nceliksiz_m��teriler() {
		return �nceliksiz_m��teriler;
	}

	public void set�nceliksiz_m��teriler(
			�nceliksiz_M��teriler �nceliksiz_m��teriler) {
		this.�nceliksiz_m��teriler = �nceliksiz_m��teriler;
	}

	public �ncelikli_M��teriler get�ncelikli_m��teriler() {
		return �ncelikli_m��teriler;
	}

	public void set�ncelikli_m��teriler(
			�ncelikli_M��teriler �ncelikli_m��teriler) {
		this.�ncelikli_m��teriler = �ncelikli_m��teriler;
	}

	public int getN() {
		return N;
	}

	public static void setN(int n) {
		N = n;
	}
}
