public class Ýþletme {
	private int müþteri_sayýsý, yerleþemeyenler;
	private Masalar yeni_masalar;
	private int grup_no;

	public Ýþletme() {
		// Ýþletmeye Yeni masalar getiriliyor
		setYeni_masalar(new Masalar());
		setMüþteri_sayýsý(1 + Random.random(50));
		setYerleþemeyenler(0);
		System.out.println("Restorana " + getMüþteri_sayýsý() + " kiþi geldi");
		grup_no = 0;
	}

	public int masalarý_yerleþtir() {
		int masa_birleþtirildimi, kullanýlan_masa_sayýsý = 0, N;
		int evet = 1, hayýr = 0;
		masa_birleþtirildimi = hayýr;
		for (int i = 0; i < 5; i++) {
			if (0 < getMüþteri_sayýsý()) {
				if (masa_birleþtirildimi == hayýr) {
					N = 1 + Random.random(getMüþteri_sayýsý() % 7);// Yeni
																	// müþteri
																	// grubu
					if (4 < N) {
						setMüþteri_sayýsý(getMüþteri_sayýsý() - N);
						masa_birleþtirildimi = evet;
						kullanýlan_masa_sayýsý += 2;
						grup_no++;
						System.out.println(grup_no + ". Grup: " + N
								+ "kiþi için 2 masa birleþtirildi");
						yeni_masalar.grup_yerleþtir(i, N);
						yeni_masalar.getMasalar().elementAt(i)
								.setDoluluk_oraný(100 / 6 * N);
						yeni_masalar.getMasalar().elementAt(i).toString();
					} else {
						setMüþteri_sayýsý(getMüþteri_sayýsý() - N);
						kullanýlan_masa_sayýsý++;
						grup_no++;
						System.out.println(grup_no + ". Grup: " + N + "kiþi");
						yeni_masalar.grup_yerleþtir(i, N);
						yeni_masalar.getMasalar().elementAt(i)
								.setDoluluk_oraný(100 / 4 * N);
						yeni_masalar.getMasalar().elementAt(i).toString();
					}
				} else {// masa_birleþtirildimi=evet
					N = 1 + Random.random(getMüþteri_sayýsý() % 5);// Yeni
																	// müþteri
																	// grubu
					setMüþteri_sayýsý(getMüþteri_sayýsý() - N);
					kullanýlan_masa_sayýsý++;
					grup_no++;
					System.out.println(grup_no + ". Grup: " + N + "kiþi");
					yeni_masalar.grup_yerleþtir(i, N);
					yeni_masalar.getMasalar().elementAt(i)
							.setDoluluk_oraný(100 / 4 * N);
					yeni_masalar.getMasalar().elementAt(i).toString();
				}
			} else {
				break;
			}
		}
		int son;
		if (masa_birleþtirildimi == evet) {
			son = 9;
			yeni_masalar.getMasalar().removeElementAt(9);
		} else {
			son = 10;
		}
		masa_birleþtirildimi = hayýr;
		for (int i1 = 5; i1 < son; i1++) {
			if (0 < getMüþteri_sayýsý()) {
				if (masa_birleþtirildimi == hayýr) {
					N = 1 + Random.random(getMüþteri_sayýsý() % 7);// Yeni
																	// müþteri
																	// grubu
					if (4 < N) {
						setMüþteri_sayýsý(getMüþteri_sayýsý() - N);
						masa_birleþtirildimi = evet;
						kullanýlan_masa_sayýsý += 2;
						son--;
						grup_no++;
						System.out.println(grup_no + ". Grup: " + N
								+ "kiþi için 2 masa birleþtirildi");
						yeni_masalar.grup_yerleþtir(i1, N);
						yeni_masalar.getMasalar().elementAt(i1)
								.setDoluluk_oraný(100 / 6 * N);
						yeni_masalar.getMasalar().elementAt(i1).toString();
					} else {
						setMüþteri_sayýsý(getMüþteri_sayýsý() - N);
						kullanýlan_masa_sayýsý++;
						grup_no++;
						System.out.println(grup_no + ". Grup: " + N + "kiþi");
						yeni_masalar.grup_yerleþtir(i1, N);
						yeni_masalar.getMasalar().elementAt(i1)
								.setDoluluk_oraný(100 / 4 * N);
						yeni_masalar.getMasalar().elementAt(i1).toString();
					}
				} else {// masa_birleþtirildimi=evet
					N = 1 + Random.random(getMüþteri_sayýsý() % 5);// Yeni
																	// müþteri
																	// grubu
					setMüþteri_sayýsý(getMüþteri_sayýsý() - N);
					kullanýlan_masa_sayýsý++;
					grup_no++;
					System.out.println(grup_no + ". Grup: " + N + "kiþi");
					yeni_masalar.grup_yerleþtir(i1, N);
					yeni_masalar.getMasalar().elementAt(i1)
							.setDoluluk_oraný(100 / 4 * N);
					yeni_masalar.getMasalar().elementAt(i1).toString();
				}
			} else {
				break;
			}
		}
		if (masa_birleþtirildimi == evet) {
			yeni_masalar.getMasalar().removeElementAt(8);
		}
		System.out.println("Kullanýlan_masa_sayýsý:" + kullanýlan_masa_sayýsý
				+ "\nBoþ_masa_sayýsý:" + (10 - kullanýlan_masa_sayýsý));
		setYerleþemeyenler(getMüþteri_sayýsý());
		return getYerleþemeyenler();
	}

	public Masalar getYeni_masalar() {
		return yeni_masalar;
	}

	public void setYeni_masalar(Masalar yeni_masalar) {
		this.yeni_masalar = yeni_masalar;
	}

	public int getGrup_no() {
		return grup_no;
	}

	public void setGrup_no(int grup_no) {
		this.grup_no = grup_no;
	}

	public int getMüþteri_sayýsý() {
		return müþteri_sayýsý;
	}

	public void setMüþteri_sayýsý(int müþteri_sayýsý) {
		this.müþteri_sayýsý = müþteri_sayýsý;
	}

	public int getYerleþemeyenler() {
		return yerleþemeyenler;
	}

	public void setYerleþemeyenler(int yerleþemeyenler) {
		this.yerleþemeyenler = yerleþemeyenler;
	}

}
