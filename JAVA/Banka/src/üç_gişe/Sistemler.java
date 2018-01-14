package ��_gi�e;

import java.util.Vector;

public class Sistemler {
	private static int N;
	private �ncelikli_Sistem �ncelikli_sistem;
	private �nceliksiz_Sistem �nceliksiz_sistem;
	private �nceliksiz_M��teriler �nceliksiz_m��teriler;
	private �ncelikli_M��teriler �ncelikli_m��teriler;

	public Sistemler() {
		// setN(Random.random(101));// Bankaya en �ok 100 m��teri gelsin diye
		setN(10);
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
		System.out.println("�nceliksiz");
		�nceliksiz_sistemi_�al��t�r();
		System.out
				.println("***************************\n*******************************\n********************************");
		System.out.println("�ncelikli");
		�ncelikli_sistemi_�al��t�r();
	}

	private void �nceliksiz_sistemi_�al��t�r() {
		// M��teriler geli� s�ralar�na g�re i�leme tabi tutulur
		// M��teri kuyruklar� bitene kadar sistem �al��t�r�l�yor
		M��teri m��teri = new M��teri();
		int olay_miktar� = getN(), bankadan_��kanlar = 0;
		Vector<Integer> m��teri_no = new Vector<Integer>(), gi�e_no = new Vector<Integer>(), gi�e_dolu_mu = new Vector<Integer>(), m��terinin_bekledi�i_s�re = new Vector<Integer>(), m��terinin_veznede_bekledi�i_s�re = new Vector<Integer>(), m��terinin_kuyrukta_bekledi�i_s�re = new Vector<Integer>(), m��terilerin_kuyrukta_bekledi�i_s�re = new Vector<Integer>();
		m��teri_no.setSize(3);
		gi�e_no.setSize(3);
		gi�e_dolu_mu.setSize(3);
		m��terinin_bekledi�i_s�re.setSize(3);
		m��terinin_veznede_bekledi�i_s�re.setSize(3);
		m��terinin_kuyrukta_bekledi�i_s�re.setSize(3);
		m��terilerin_kuyrukta_bekledi�i_s�re.setSize(3);

		for (int k = 0; k < get�nceliksiz_sistem().get�nceliksiz_Banka()
				.getGi�e_say�s�(); k++) {
			m��teri_no.setElementAt(0, k);
			gi�e_no.set(k, 0);
			gi�e_dolu_mu.set(k, 0);
			m��terinin_bekledi�i_s�re.set(k, 0);
			m��terinin_veznede_bekledi�i_s�re.set(k, 0);
			m��terinin_kuyrukta_bekledi�i_s�re.set(k, 0);
			m��terilerin_kuyrukta_bekledi�i_s�re.set(k, 0);
			get�nceliksiz_sistem().get�nceliksiz_Banka().getVezneler()
					.elementAt(k).setToplam_bekletme_s�resi(0);// Veznedar
																// bekleniyor
		}
		do {

			for (int j = 0; j < get�nceliksiz_sistem().get�nceliksiz_Banka()
					.getGi�e_say�s�(); j++) {
				// Gi�e bo�sa ��leme tabi tutulacak olan m��teri kuyruktan
				// al�n�yor
				if (m��terinin_veznede_bekledi�i_s�re.elementAt(j) == 0
						&& bankadan_��kanlar != getN()) {
					olay_miktar�--;
					gi�e_dolu_mu.set(j, 1);
					m��terinin_kuyrukta_bekledi�i_s�re.setElementAt(
							get�nceliksiz_sistem().get�nceliksiz_Banka()
									.getVezneler().elementAt(j)
									.getToplam_bekletme_s�resi(), j);
					m��teri = get�nceliksiz_m��teriler().m��teri_��kar();
					m��teri.setGi�e_no(j);
					gi�e_no.set(j, m��teri.getGi�e_no());
					m��teri_no.set(j, m��teri.getNo());
					m��terinin_bekledi�i_s�re.set(j, m��teri.getS�re());
					m��terinin_veznede_bekledi�i_s�re.setElementAt(
							m��teri.getS�re(), j);
					get�nceliksiz_sistem().get�nceliksiz_Banka().getVezneler()
							.elementAt(j).setI�lem_s�resi(m��teri.getS�re());

					get�nceliksiz_sistem()
							.get�nceliksiz_Banka()
							.getVezneler()
							.elementAt(j)
							.setToplam_bekletme_s�resi(
									get�nceliksiz_sistem()
											.get�nceliksiz_Banka()
											.getVezneler().elementAt(j)
											.getToplam_bekletme_s�resi()
											+ m��teri.getS�re());

					m��terilerin_kuyrukta_bekledi�i_s�re.setElementAt(
							get�nceliksiz_sistem().get�nceliksiz_Banka()
									.getVezneler().elementAt(j)
									.getToplam_bekletme_s�resi(), j);
				}

			}
			// Gi�elerden her hangi biri bo� de�ilse
			int min = 0;
			min = m��terinin_veznede_bekledi�i_s�re.elementAt(0);
			if (min > m��terinin_veznede_bekledi�i_s�re.elementAt(1)
					&& min > m��terinin_veznede_bekledi�i_s�re.elementAt(2))// ikisindende
																			// b�y�k
																			// de�ilse
			{
				min = m��terinin_veznede_bekledi�i_s�re.elementAt(1);// herhangi
																		// biri
																		// k���k
																		// kabul
																		// ediliyor
				if (min > m��terinin_veznede_bekledi�i_s�re.elementAt(2)) {
					min = m��terinin_veznede_bekledi�i_s�re.elementAt(2); // �art�
																			// sa�larsa
																			// en
																			// k���k
																			// say�
					// if 'e girmezse en k���k
					// say�:m��terinin_veznede_bekledi�i_s�re.elementAt(1);
				}
				// if 'e girmezse en k���k
				// say�:m��terinin_veznede_bekledi�i_s�re.elementAt(0);
			}

			for (int z = 0; z < 3; z++) {
				m��terinin_veznede_bekledi�i_s�re.setElementAt(
						m��terinin_veznede_bekledi�i_s�re.elementAt(z)
								- min, z);
				if (m��terinin_veznede_bekledi�i_s�re.elementAt(z) == 0&& bankadan_��kanlar != getN()) {
					bankadan_��kanlar++;
					gi�e_dolu_mu.set(z, 0);
					System.out
							.println("Gi�e no:"
									+ gi�e_no.elementAt(z)
									+ "\nm��teri_no.elementAt(z):"
									+ m��teri_no.elementAt(z)
									+ "\nm��terinin_veznede_bekledi�i_s�re:"
									+ m��terinin_bekledi�i_s�re.elementAt(z)
									+ "\nm��terinin_kuyrukta_bekledi�i_s�re:"
									+ m��terinin_kuyrukta_bekledi�i_s�re
											.elementAt(z)
									+ "\nm��terinin_bankada_bekledi�i_s�re:"
									+ m��terilerin_kuyrukta_bekledi�i_s�re
											.elementAt(z));
					�nceliksiz_sistem_i�in_rapor_haz�rla(gi�e_no.elementAt(z),
							m��teri_no.elementAt(z),
							m��terinin_veznede_bekledi�i_s�re.elementAt(z),
							m��terinin_kuyrukta_bekledi�i_s�re.elementAt(z),
							m��terilerin_kuyrukta_bekledi�i_s�re.elementAt(z));
				}
				if (bankadan_��kanlar == getN()) {
					break;
				}
			}
		} while (0 < olay_miktar�);
		do{
			// Gi�elerden her hangi biri bo� de�ilse
						int min = 0;
						min = m��terinin_veznede_bekledi�i_s�re.elementAt(0);
						if (min > m��terinin_veznede_bekledi�i_s�re.elementAt(1)
								&& min > m��terinin_veznede_bekledi�i_s�re.elementAt(2))// ikisindende
																						// b�y�k
																						// de�ilse
						{
							min = m��terinin_veznede_bekledi�i_s�re.elementAt(1);// herhangi
																					// biri
																					// k���k
																					// kabul
																					// ediliyor
							if (min > m��terinin_veznede_bekledi�i_s�re.elementAt(2)) {
								min = m��terinin_veznede_bekledi�i_s�re.elementAt(2); // �art�
																						// sa�larsa
																						// en
																						// k���k
																						// say�
								// if 'e girmezse en k���k
								// say�:m��terinin_veznede_bekledi�i_s�re.elementAt(1);
							}
							// if 'e girmezse en k���k
							// say�:m��terinin_veznede_bekledi�i_s�re.elementAt(0);
						}
			for (int z = 0; z < 3; z++) {
				
				if (m��terinin_veznede_bekledi�i_s�re.elementAt(z) > 0
						&& bankadan_��kanlar != getN()) {
					m��terinin_veznede_bekledi�i_s�re.setElementAt(
							m��terinin_veznede_bekledi�i_s�re.elementAt(z)
									- min, z);
					bankadan_��kanlar++;
					gi�e_dolu_mu.set(z, 0);
					System.out
							.println("Gi�e no:"
									+ gi�e_no.elementAt(z)
									+ "\nm��teri_no.elementAt(z):"
									+ m��teri_no.elementAt(z)
									+ "\nm��terinin_veznede_bekledi�i_s�re:"
									+ m��terinin_bekledi�i_s�re.elementAt(z)
									+ "\nm��terinin_kuyrukta_bekledi�i_s�re:"
									+ m��terinin_kuyrukta_bekledi�i_s�re
											.elementAt(z)
									+ "\nm��terinin_bankada_bekledi�i_s�re:"
									+ m��terilerin_kuyrukta_bekledi�i_s�re
											.elementAt(z));
					�ncelikli_sistem_i�in_rapor_haz�rla(gi�e_no.elementAt(z),
							m��teri_no.elementAt(z),
							m��terinin_veznede_bekledi�i_s�re.elementAt(z),
							m��terinin_kuyrukta_bekledi�i_s�re.elementAt(z),
							m��terilerin_kuyrukta_bekledi�i_s�re.elementAt(z));
				}
				if (bankadan_��kanlar == getN()) {
					break;
				}
			}
		}while (bankadan_��kanlar != getN());
	}

	private void �nceliksiz_sistem_i�in_rapor_haz�rla(int gi�e_no,
			int m��teri_no, int m��terinin_veznede_bekledi�i_s�re,
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
		int olay_miktar� = getN(), bankadan_��kanlar = 0;
		Vector<Integer> m��teri_no = new Vector<Integer>(), gi�e_no = new Vector<Integer>(), gi�e_dolu_mu = new Vector<Integer>(), m��terinin_bekledi�i_s�re = new Vector<Integer>(), m��terinin_veznede_bekledi�i_s�re = new Vector<Integer>(), m��terinin_kuyrukta_bekledi�i_s�re = new Vector<Integer>(), m��terilerin_kuyrukta_bekledi�i_s�re = new Vector<Integer>();
		m��teri_no.setSize(3);
		gi�e_no.setSize(3);
		gi�e_dolu_mu.setSize(3);
		m��terinin_bekledi�i_s�re.setSize(3);
		m��terinin_veznede_bekledi�i_s�re.setSize(3);
		m��terinin_kuyrukta_bekledi�i_s�re.setSize(3);
		m��terilerin_kuyrukta_bekledi�i_s�re.setSize(3);

		for (int k = 0; k < get�ncelikli_sistem().get�ncelikli_Banka()
				.getGi�e_say�s�(); k++) {
			m��teri_no.setElementAt(0, k);
			gi�e_no.set(k, 0);
			gi�e_dolu_mu.set(k, 0);
			m��terinin_bekledi�i_s�re.set(k, 0);
			m��terinin_veznede_bekledi�i_s�re.set(k, 0);
			m��terinin_kuyrukta_bekledi�i_s�re.set(k, 0);
			m��terilerin_kuyrukta_bekledi�i_s�re.set(k, 0);
			get�ncelikli_sistem().get�ncelikli_Banka().getVezneler()
					.elementAt(k).setToplam_bekletme_s�resi(0);// Veznedar
																// bekleniyor
		}
		do {

			for (int j = 0; j < get�ncelikli_sistem().get�ncelikli_Banka()
					.getGi�e_say�s�(); j++) {
				// Gi�e bo�sa ��leme tabi tutulacak olan m��teri kuyruktan
				// al�n�yor
				if (m��terinin_veznede_bekledi�i_s�re.elementAt(j) == 0&& bankadan_��kanlar != getN()) {
					olay_miktar�--;
					gi�e_dolu_mu.set(j, 1);
					m��terinin_kuyrukta_bekledi�i_s�re.setElementAt(
							get�ncelikli_sistem().get�ncelikli_Banka()
									.getVezneler().elementAt(j)
									.getToplam_bekletme_s�resi(), j);
					m��teri = get�ncelikli_m��teriler().m��teri_��kar();
					m��teri.setGi�e_no(j);
					gi�e_no.set(j, m��teri.getGi�e_no());
					m��teri_no.set(j, m��teri.getNo());
					m��terinin_bekledi�i_s�re.set(j, m��teri.getS�re());
					m��terinin_veznede_bekledi�i_s�re.setElementAt(
							m��teri.getS�re(), j);
					get�ncelikli_sistem().get�ncelikli_Banka().getVezneler()
							.elementAt(j).setI�lem_s�resi(m��teri.getS�re());

					get�ncelikli_sistem()
							.get�ncelikli_Banka()
							.getVezneler()
							.elementAt(j)
							.setToplam_bekletme_s�resi(
									get�ncelikli_sistem().get�ncelikli_Banka()
											.getVezneler().elementAt(j)
											.getToplam_bekletme_s�resi()
											+ m��teri.getS�re());

					m��terilerin_kuyrukta_bekledi�i_s�re.setElementAt(
							get�ncelikli_sistem().get�ncelikli_Banka()
									.getVezneler().elementAt(j)
									.getToplam_bekletme_s�resi(), j);
				}

			}
			// Gi�elerden her hangi biri bo� de�ilse
			int min = 0;
			min = m��terinin_veznede_bekledi�i_s�re.elementAt(0);
			if (min > m��terinin_veznede_bekledi�i_s�re.elementAt(1)
					&& min > m��terinin_veznede_bekledi�i_s�re.elementAt(2))// ikisindende
																			// b�y�k
																			// de�ilse
			{
				min = m��terinin_veznede_bekledi�i_s�re.elementAt(1);// herhangi
																		// biri
																		// k���k
																		// kabul
																		// ediliyor
				if (min > m��terinin_veznede_bekledi�i_s�re.elementAt(2)) {
					min = m��terinin_veznede_bekledi�i_s�re.elementAt(2); // �art�
																			// sa�larsa
																			// en
																			// k���k
																			// say�
					// if 'e girmezse en k���k
					// say�:m��terinin_veznede_bekledi�i_s�re.elementAt(1);
				}
				// if 'e girmezse en k���k
				// say�:m��terinin_veznede_bekledi�i_s�re.elementAt(0);
			}

			for (int z = 0; z < 3; z++) {
				m��terinin_veznede_bekledi�i_s�re.setElementAt(
						m��terinin_veznede_bekledi�i_s�re.elementAt(z)
								- min, z);
				if (m��terinin_veznede_bekledi�i_s�re.elementAt(z) == 0
						&& bankadan_��kanlar != getN()) {
					bankadan_��kanlar++;
					gi�e_dolu_mu.set(z, 0);
					System.out
							.println("Gi�e no:"
									+ gi�e_no.elementAt(z)
									+ "\nm��teri_no.elementAt(z):"
									+ m��teri_no.elementAt(z)
									+ "\nm��terinin_veznede_bekledi�i_s�re:"
									+ m��terinin_bekledi�i_s�re.elementAt(z)
									+ "\nm��terinin_kuyrukta_bekledi�i_s�re:"
									+ m��terinin_kuyrukta_bekledi�i_s�re
											.elementAt(z)
									+ "\nm��terinin_bankada_bekledi�i_s�re:"
									+ m��terilerin_kuyrukta_bekledi�i_s�re
											.elementAt(z));
					�ncelikli_sistem_i�in_rapor_haz�rla(gi�e_no.elementAt(z),
							m��teri_no.elementAt(z),
							m��terinin_veznede_bekledi�i_s�re.elementAt(z),
							m��terinin_kuyrukta_bekledi�i_s�re.elementAt(z),
							m��terilerin_kuyrukta_bekledi�i_s�re.elementAt(z));
				}
				if (bankadan_��kanlar == getN()) {
					break;
				}
			}
		} while (0 < olay_miktar�);
		do{
			// Gi�elerden her hangi biri bo� de�ilse
						int min = 0;
						min = m��terinin_veznede_bekledi�i_s�re.elementAt(0);
						if (min > m��terinin_veznede_bekledi�i_s�re.elementAt(1)
								&& min > m��terinin_veznede_bekledi�i_s�re.elementAt(2))// ikisindende
																						// b�y�k
																						// de�ilse
						{
							min = m��terinin_veznede_bekledi�i_s�re.elementAt(1);// herhangi
																					// biri
																					// k���k
																					// kabul
																					// ediliyor
							if (min > m��terinin_veznede_bekledi�i_s�re.elementAt(2)) {
								min = m��terinin_veznede_bekledi�i_s�re.elementAt(2); // �art�
																						// sa�larsa
																						// en
																						// k���k
																						// say�
								// if 'e girmezse en k���k
								// say�:m��terinin_veznede_bekledi�i_s�re.elementAt(1);
							}
							// if 'e girmezse en k���k
							// say�:m��terinin_veznede_bekledi�i_s�re.elementAt(0);
						}
			for (int z = 0; z < 3; z++) {
				
				if (m��terinin_veznede_bekledi�i_s�re.elementAt(z) > 0
						|| bankadan_��kanlar != getN()) {
					m��terinin_veznede_bekledi�i_s�re.setElementAt(
							m��terinin_veznede_bekledi�i_s�re.elementAt(z)
									- min, z);
					bankadan_��kanlar++;
					gi�e_dolu_mu.set(z, 0);
					System.out
							.println("Gi�e no:"
									+ gi�e_no.elementAt(z)
									+ "\nm��teri_no.elementAt(z):"
									+ m��teri_no.elementAt(z)
									+ "\nm��terinin_veznede_bekledi�i_s�re:"
									+ m��terinin_bekledi�i_s�re.elementAt(z)
									+ "\nm��terinin_kuyrukta_bekledi�i_s�re:"
									+ m��terinin_kuyrukta_bekledi�i_s�re
											.elementAt(z)
									+ "\nm��terinin_bankada_bekledi�i_s�re:"
									+ m��terilerin_kuyrukta_bekledi�i_s�re
											.elementAt(z));
					�ncelikli_sistem_i�in_rapor_haz�rla(gi�e_no.elementAt(z),
							m��teri_no.elementAt(z),
							m��terinin_veznede_bekledi�i_s�re.elementAt(z),
							m��terinin_kuyrukta_bekledi�i_s�re.elementAt(z),
							m��terilerin_kuyrukta_bekledi�i_s�re.elementAt(z));
				}
				if (bankadan_��kanlar == getN()) {
					break;
				}
			}
		}while (bankadan_��kanlar != getN());
	}

	private void �ncelikli_sistem_i�in_rapor_haz�rla(int gi�e_no,
			int m��teri_no, int m��terinin_veznede_bekledi�i_s�re,
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
