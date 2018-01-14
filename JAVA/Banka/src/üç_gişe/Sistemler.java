package üç_giþe;

import java.util.Vector;

public class Sistemler {
	private static int N;
	private Öncelikli_Sistem öncelikli_sistem;
	private Önceliksiz_Sistem önceliksiz_sistem;
	private Önceliksiz_Müþteriler önceliksiz_müþteriler;
	private Öncelikli_Müþteriler öncelikli_müþteriler;

	public Sistemler() {
		// setN(Random.random(101));// Bankaya en çok 100 müþteri gelsin diye
		setN(10);
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
		System.out.println("önceliksiz");
		önceliksiz_sistemi_çalýþtýr();
		System.out
				.println("***************************\n*******************************\n********************************");
		System.out.println("öncelikli");
		öncelikli_sistemi_çalýþtýr();
	}

	private void önceliksiz_sistemi_çalýþtýr() {
		// Müþteriler geliþ sýralarýna göre iþleme tabi tutulur
		// Müþteri kuyruklarý bitene kadar sistem çalýþtýrýlýyor
		Müþteri müþteri = new Müþteri();
		int olay_miktarý = getN(), bankadan_çýkanlar = 0;
		Vector<Integer> müþteri_no = new Vector<Integer>(), giþe_no = new Vector<Integer>(), giþe_dolu_mu = new Vector<Integer>(), müþterinin_beklediði_süre = new Vector<Integer>(), müþterinin_veznede_beklediði_süre = new Vector<Integer>(), müþterinin_kuyrukta_beklediði_süre = new Vector<Integer>(), müþterilerin_kuyrukta_beklediði_süre = new Vector<Integer>();
		müþteri_no.setSize(3);
		giþe_no.setSize(3);
		giþe_dolu_mu.setSize(3);
		müþterinin_beklediði_süre.setSize(3);
		müþterinin_veznede_beklediði_süre.setSize(3);
		müþterinin_kuyrukta_beklediði_süre.setSize(3);
		müþterilerin_kuyrukta_beklediði_süre.setSize(3);

		for (int k = 0; k < getÖnceliksiz_sistem().getÖnceliksiz_Banka()
				.getGiþe_sayýsý(); k++) {
			müþteri_no.setElementAt(0, k);
			giþe_no.set(k, 0);
			giþe_dolu_mu.set(k, 0);
			müþterinin_beklediði_süre.set(k, 0);
			müþterinin_veznede_beklediði_süre.set(k, 0);
			müþterinin_kuyrukta_beklediði_süre.set(k, 0);
			müþterilerin_kuyrukta_beklediði_süre.set(k, 0);
			getÖnceliksiz_sistem().getÖnceliksiz_Banka().getVezneler()
					.elementAt(k).setToplam_bekletme_süresi(0);// Veznedar
																// bekleniyor
		}
		do {

			for (int j = 0; j < getÖnceliksiz_sistem().getÖnceliksiz_Banka()
					.getGiþe_sayýsý(); j++) {
				// Giþe boþsa Ýþleme tabi tutulacak olan müþteri kuyruktan
				// alýnýyor
				if (müþterinin_veznede_beklediði_süre.elementAt(j) == 0
						&& bankadan_çýkanlar != getN()) {
					olay_miktarý--;
					giþe_dolu_mu.set(j, 1);
					müþterinin_kuyrukta_beklediði_süre.setElementAt(
							getÖnceliksiz_sistem().getÖnceliksiz_Banka()
									.getVezneler().elementAt(j)
									.getToplam_bekletme_süresi(), j);
					müþteri = getÖnceliksiz_müþteriler().müþteri_çýkar();
					müþteri.setGiþe_no(j);
					giþe_no.set(j, müþteri.getGiþe_no());
					müþteri_no.set(j, müþteri.getNo());
					müþterinin_beklediði_süre.set(j, müþteri.getSüre());
					müþterinin_veznede_beklediði_süre.setElementAt(
							müþteri.getSüre(), j);
					getÖnceliksiz_sistem().getÖnceliksiz_Banka().getVezneler()
							.elementAt(j).setIþlem_süresi(müþteri.getSüre());

					getÖnceliksiz_sistem()
							.getÖnceliksiz_Banka()
							.getVezneler()
							.elementAt(j)
							.setToplam_bekletme_süresi(
									getÖnceliksiz_sistem()
											.getÖnceliksiz_Banka()
											.getVezneler().elementAt(j)
											.getToplam_bekletme_süresi()
											+ müþteri.getSüre());

					müþterilerin_kuyrukta_beklediði_süre.setElementAt(
							getÖnceliksiz_sistem().getÖnceliksiz_Banka()
									.getVezneler().elementAt(j)
									.getToplam_bekletme_süresi(), j);
				}

			}
			// Giþelerden her hangi biri boþ deðilse
			int min = 0;
			min = müþterinin_veznede_beklediði_süre.elementAt(0);
			if (min > müþterinin_veznede_beklediði_süre.elementAt(1)
					&& min > müþterinin_veznede_beklediði_süre.elementAt(2))// ikisindende
																			// büyük
																			// deðilse
			{
				min = müþterinin_veznede_beklediði_süre.elementAt(1);// herhangi
																		// biri
																		// küçük
																		// kabul
																		// ediliyor
				if (min > müþterinin_veznede_beklediði_süre.elementAt(2)) {
					min = müþterinin_veznede_beklediði_süre.elementAt(2); // þartý
																			// saðlarsa
																			// en
																			// küçük
																			// sayý
					// if 'e girmezse en küçük
					// sayý:müþterinin_veznede_beklediði_süre.elementAt(1);
				}
				// if 'e girmezse en küçük
				// sayý:müþterinin_veznede_beklediði_süre.elementAt(0);
			}

			for (int z = 0; z < 3; z++) {
				müþterinin_veznede_beklediði_süre.setElementAt(
						müþterinin_veznede_beklediði_süre.elementAt(z)
								- min, z);
				if (müþterinin_veznede_beklediði_süre.elementAt(z) == 0&& bankadan_çýkanlar != getN()) {
					bankadan_çýkanlar++;
					giþe_dolu_mu.set(z, 0);
					System.out
							.println("Giþe no:"
									+ giþe_no.elementAt(z)
									+ "\nmüþteri_no.elementAt(z):"
									+ müþteri_no.elementAt(z)
									+ "\nmüþterinin_veznede_beklediði_süre:"
									+ müþterinin_beklediði_süre.elementAt(z)
									+ "\nmüþterinin_kuyrukta_beklediði_süre:"
									+ müþterinin_kuyrukta_beklediði_süre
											.elementAt(z)
									+ "\nmüþterinin_bankada_beklediði_süre:"
									+ müþterilerin_kuyrukta_beklediði_süre
											.elementAt(z));
					önceliksiz_sistem_için_rapor_hazýrla(giþe_no.elementAt(z),
							müþteri_no.elementAt(z),
							müþterinin_veznede_beklediði_süre.elementAt(z),
							müþterinin_kuyrukta_beklediði_süre.elementAt(z),
							müþterilerin_kuyrukta_beklediði_süre.elementAt(z));
				}
				if (bankadan_çýkanlar == getN()) {
					break;
				}
			}
		} while (0 < olay_miktarý);
		do{
			// Giþelerden her hangi biri boþ deðilse
						int min = 0;
						min = müþterinin_veznede_beklediði_süre.elementAt(0);
						if (min > müþterinin_veznede_beklediði_süre.elementAt(1)
								&& min > müþterinin_veznede_beklediði_süre.elementAt(2))// ikisindende
																						// büyük
																						// deðilse
						{
							min = müþterinin_veznede_beklediði_süre.elementAt(1);// herhangi
																					// biri
																					// küçük
																					// kabul
																					// ediliyor
							if (min > müþterinin_veznede_beklediði_süre.elementAt(2)) {
								min = müþterinin_veznede_beklediði_süre.elementAt(2); // þartý
																						// saðlarsa
																						// en
																						// küçük
																						// sayý
								// if 'e girmezse en küçük
								// sayý:müþterinin_veznede_beklediði_süre.elementAt(1);
							}
							// if 'e girmezse en küçük
							// sayý:müþterinin_veznede_beklediði_süre.elementAt(0);
						}
			for (int z = 0; z < 3; z++) {
				
				if (müþterinin_veznede_beklediði_süre.elementAt(z) > 0
						&& bankadan_çýkanlar != getN()) {
					müþterinin_veznede_beklediði_süre.setElementAt(
							müþterinin_veznede_beklediði_süre.elementAt(z)
									- min, z);
					bankadan_çýkanlar++;
					giþe_dolu_mu.set(z, 0);
					System.out
							.println("Giþe no:"
									+ giþe_no.elementAt(z)
									+ "\nmüþteri_no.elementAt(z):"
									+ müþteri_no.elementAt(z)
									+ "\nmüþterinin_veznede_beklediði_süre:"
									+ müþterinin_beklediði_süre.elementAt(z)
									+ "\nmüþterinin_kuyrukta_beklediði_süre:"
									+ müþterinin_kuyrukta_beklediði_süre
											.elementAt(z)
									+ "\nmüþterinin_bankada_beklediði_süre:"
									+ müþterilerin_kuyrukta_beklediði_süre
											.elementAt(z));
					öncelikli_sistem_için_rapor_hazýrla(giþe_no.elementAt(z),
							müþteri_no.elementAt(z),
							müþterinin_veznede_beklediði_süre.elementAt(z),
							müþterinin_kuyrukta_beklediði_süre.elementAt(z),
							müþterilerin_kuyrukta_beklediði_süre.elementAt(z));
				}
				if (bankadan_çýkanlar == getN()) {
					break;
				}
			}
		}while (bankadan_çýkanlar != getN());
	}

	private void önceliksiz_sistem_için_rapor_hazýrla(int giþe_no,
			int müþteri_no, int müþterinin_veznede_beklediði_süre,
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
		int olay_miktarý = getN(), bankadan_çýkanlar = 0;
		Vector<Integer> müþteri_no = new Vector<Integer>(), giþe_no = new Vector<Integer>(), giþe_dolu_mu = new Vector<Integer>(), müþterinin_beklediði_süre = new Vector<Integer>(), müþterinin_veznede_beklediði_süre = new Vector<Integer>(), müþterinin_kuyrukta_beklediði_süre = new Vector<Integer>(), müþterilerin_kuyrukta_beklediði_süre = new Vector<Integer>();
		müþteri_no.setSize(3);
		giþe_no.setSize(3);
		giþe_dolu_mu.setSize(3);
		müþterinin_beklediði_süre.setSize(3);
		müþterinin_veznede_beklediði_süre.setSize(3);
		müþterinin_kuyrukta_beklediði_süre.setSize(3);
		müþterilerin_kuyrukta_beklediði_süre.setSize(3);

		for (int k = 0; k < getÖncelikli_sistem().getÖncelikli_Banka()
				.getGiþe_sayýsý(); k++) {
			müþteri_no.setElementAt(0, k);
			giþe_no.set(k, 0);
			giþe_dolu_mu.set(k, 0);
			müþterinin_beklediði_süre.set(k, 0);
			müþterinin_veznede_beklediði_süre.set(k, 0);
			müþterinin_kuyrukta_beklediði_süre.set(k, 0);
			müþterilerin_kuyrukta_beklediði_süre.set(k, 0);
			getÖncelikli_sistem().getÖncelikli_Banka().getVezneler()
					.elementAt(k).setToplam_bekletme_süresi(0);// Veznedar
																// bekleniyor
		}
		do {

			for (int j = 0; j < getÖncelikli_sistem().getÖncelikli_Banka()
					.getGiþe_sayýsý(); j++) {
				// Giþe boþsa Ýþleme tabi tutulacak olan müþteri kuyruktan
				// alýnýyor
				if (müþterinin_veznede_beklediði_süre.elementAt(j) == 0&& bankadan_çýkanlar != getN()) {
					olay_miktarý--;
					giþe_dolu_mu.set(j, 1);
					müþterinin_kuyrukta_beklediði_süre.setElementAt(
							getÖncelikli_sistem().getÖncelikli_Banka()
									.getVezneler().elementAt(j)
									.getToplam_bekletme_süresi(), j);
					müþteri = getÖncelikli_müþteriler().müþteri_çýkar();
					müþteri.setGiþe_no(j);
					giþe_no.set(j, müþteri.getGiþe_no());
					müþteri_no.set(j, müþteri.getNo());
					müþterinin_beklediði_süre.set(j, müþteri.getSüre());
					müþterinin_veznede_beklediði_süre.setElementAt(
							müþteri.getSüre(), j);
					getÖncelikli_sistem().getÖncelikli_Banka().getVezneler()
							.elementAt(j).setIþlem_süresi(müþteri.getSüre());

					getÖncelikli_sistem()
							.getÖncelikli_Banka()
							.getVezneler()
							.elementAt(j)
							.setToplam_bekletme_süresi(
									getÖncelikli_sistem().getÖncelikli_Banka()
											.getVezneler().elementAt(j)
											.getToplam_bekletme_süresi()
											+ müþteri.getSüre());

					müþterilerin_kuyrukta_beklediði_süre.setElementAt(
							getÖncelikli_sistem().getÖncelikli_Banka()
									.getVezneler().elementAt(j)
									.getToplam_bekletme_süresi(), j);
				}

			}
			// Giþelerden her hangi biri boþ deðilse
			int min = 0;
			min = müþterinin_veznede_beklediði_süre.elementAt(0);
			if (min > müþterinin_veznede_beklediði_süre.elementAt(1)
					&& min > müþterinin_veznede_beklediði_süre.elementAt(2))// ikisindende
																			// büyük
																			// deðilse
			{
				min = müþterinin_veznede_beklediði_süre.elementAt(1);// herhangi
																		// biri
																		// küçük
																		// kabul
																		// ediliyor
				if (min > müþterinin_veznede_beklediði_süre.elementAt(2)) {
					min = müþterinin_veznede_beklediði_süre.elementAt(2); // þartý
																			// saðlarsa
																			// en
																			// küçük
																			// sayý
					// if 'e girmezse en küçük
					// sayý:müþterinin_veznede_beklediði_süre.elementAt(1);
				}
				// if 'e girmezse en küçük
				// sayý:müþterinin_veznede_beklediði_süre.elementAt(0);
			}

			for (int z = 0; z < 3; z++) {
				müþterinin_veznede_beklediði_süre.setElementAt(
						müþterinin_veznede_beklediði_süre.elementAt(z)
								- min, z);
				if (müþterinin_veznede_beklediði_süre.elementAt(z) == 0
						&& bankadan_çýkanlar != getN()) {
					bankadan_çýkanlar++;
					giþe_dolu_mu.set(z, 0);
					System.out
							.println("Giþe no:"
									+ giþe_no.elementAt(z)
									+ "\nmüþteri_no.elementAt(z):"
									+ müþteri_no.elementAt(z)
									+ "\nmüþterinin_veznede_beklediði_süre:"
									+ müþterinin_beklediði_süre.elementAt(z)
									+ "\nmüþterinin_kuyrukta_beklediði_süre:"
									+ müþterinin_kuyrukta_beklediði_süre
											.elementAt(z)
									+ "\nmüþterinin_bankada_beklediði_süre:"
									+ müþterilerin_kuyrukta_beklediði_süre
											.elementAt(z));
					öncelikli_sistem_için_rapor_hazýrla(giþe_no.elementAt(z),
							müþteri_no.elementAt(z),
							müþterinin_veznede_beklediði_süre.elementAt(z),
							müþterinin_kuyrukta_beklediði_süre.elementAt(z),
							müþterilerin_kuyrukta_beklediði_süre.elementAt(z));
				}
				if (bankadan_çýkanlar == getN()) {
					break;
				}
			}
		} while (0 < olay_miktarý);
		do{
			// Giþelerden her hangi biri boþ deðilse
						int min = 0;
						min = müþterinin_veznede_beklediði_süre.elementAt(0);
						if (min > müþterinin_veznede_beklediði_süre.elementAt(1)
								&& min > müþterinin_veznede_beklediði_süre.elementAt(2))// ikisindende
																						// büyük
																						// deðilse
						{
							min = müþterinin_veznede_beklediði_süre.elementAt(1);// herhangi
																					// biri
																					// küçük
																					// kabul
																					// ediliyor
							if (min > müþterinin_veznede_beklediði_süre.elementAt(2)) {
								min = müþterinin_veznede_beklediði_süre.elementAt(2); // þartý
																						// saðlarsa
																						// en
																						// küçük
																						// sayý
								// if 'e girmezse en küçük
								// sayý:müþterinin_veznede_beklediði_süre.elementAt(1);
							}
							// if 'e girmezse en küçük
							// sayý:müþterinin_veznede_beklediði_süre.elementAt(0);
						}
			for (int z = 0; z < 3; z++) {
				
				if (müþterinin_veznede_beklediði_süre.elementAt(z) > 0
						|| bankadan_çýkanlar != getN()) {
					müþterinin_veznede_beklediði_süre.setElementAt(
							müþterinin_veznede_beklediði_süre.elementAt(z)
									- min, z);
					bankadan_çýkanlar++;
					giþe_dolu_mu.set(z, 0);
					System.out
							.println("Giþe no:"
									+ giþe_no.elementAt(z)
									+ "\nmüþteri_no.elementAt(z):"
									+ müþteri_no.elementAt(z)
									+ "\nmüþterinin_veznede_beklediði_süre:"
									+ müþterinin_beklediði_süre.elementAt(z)
									+ "\nmüþterinin_kuyrukta_beklediði_süre:"
									+ müþterinin_kuyrukta_beklediði_süre
											.elementAt(z)
									+ "\nmüþterinin_bankada_beklediði_süre:"
									+ müþterilerin_kuyrukta_beklediði_süre
											.elementAt(z));
					öncelikli_sistem_için_rapor_hazýrla(giþe_no.elementAt(z),
							müþteri_no.elementAt(z),
							müþterinin_veznede_beklediði_süre.elementAt(z),
							müþterinin_kuyrukta_beklediði_süre.elementAt(z),
							müþterilerin_kuyrukta_beklediði_süre.elementAt(z));
				}
				if (bankadan_çýkanlar == getN()) {
					break;
				}
			}
		}while (bankadan_çýkanlar != getN());
	}

	private void öncelikli_sistem_için_rapor_hazýrla(int giþe_no,
			int müþteri_no, int müþterinin_veznede_beklediði_süre,
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
