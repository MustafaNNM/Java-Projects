public class ��letme {
	private int m��teri_say�s�, yerle�emeyenler;
	private Masalar yeni_masalar;
	private int grup_no;

	public ��letme() {
		// ��letmeye Yeni masalar getiriliyor
		setYeni_masalar(new Masalar());
		setM��teri_say�s�(1 + Random.random(50));
		setYerle�emeyenler(0);
		System.out.println("Restorana " + getM��teri_say�s�() + " ki�i geldi");
		grup_no = 0;
	}

	public int masalar�_yerle�tir() {
		int masa_birle�tirildimi, kullan�lan_masa_say�s� = 0, N;
		int evet = 1, hay�r = 0;
		masa_birle�tirildimi = hay�r;
		for (int i = 0; i < 5; i++) {
			if (0 < getM��teri_say�s�()) {
				if (masa_birle�tirildimi == hay�r) {
					N = 1 + Random.random(getM��teri_say�s�() % 7);// Yeni
																	// m��teri
																	// grubu
					if (4 < N) {
						setM��teri_say�s�(getM��teri_say�s�() - N);
						masa_birle�tirildimi = evet;
						kullan�lan_masa_say�s� += 2;
						grup_no++;
						System.out.println(grup_no + ". Grup: " + N
								+ "ki�i i�in 2 masa birle�tirildi");
						yeni_masalar.grup_yerle�tir(i, N);
						yeni_masalar.getMasalar().elementAt(i)
								.setDoluluk_oran�(100 / 6 * N);
						yeni_masalar.getMasalar().elementAt(i).toString();
					} else {
						setM��teri_say�s�(getM��teri_say�s�() - N);
						kullan�lan_masa_say�s�++;
						grup_no++;
						System.out.println(grup_no + ". Grup: " + N + "ki�i");
						yeni_masalar.grup_yerle�tir(i, N);
						yeni_masalar.getMasalar().elementAt(i)
								.setDoluluk_oran�(100 / 4 * N);
						yeni_masalar.getMasalar().elementAt(i).toString();
					}
				} else {// masa_birle�tirildimi=evet
					N = 1 + Random.random(getM��teri_say�s�() % 5);// Yeni
																	// m��teri
																	// grubu
					setM��teri_say�s�(getM��teri_say�s�() - N);
					kullan�lan_masa_say�s�++;
					grup_no++;
					System.out.println(grup_no + ". Grup: " + N + "ki�i");
					yeni_masalar.grup_yerle�tir(i, N);
					yeni_masalar.getMasalar().elementAt(i)
							.setDoluluk_oran�(100 / 4 * N);
					yeni_masalar.getMasalar().elementAt(i).toString();
				}
			} else {
				break;
			}
		}
		int son;
		if (masa_birle�tirildimi == evet) {
			son = 9;
			yeni_masalar.getMasalar().removeElementAt(9);
		} else {
			son = 10;
		}
		masa_birle�tirildimi = hay�r;
		for (int i1 = 5; i1 < son; i1++) {
			if (0 < getM��teri_say�s�()) {
				if (masa_birle�tirildimi == hay�r) {
					N = 1 + Random.random(getM��teri_say�s�() % 7);// Yeni
																	// m��teri
																	// grubu
					if (4 < N) {
						setM��teri_say�s�(getM��teri_say�s�() - N);
						masa_birle�tirildimi = evet;
						kullan�lan_masa_say�s� += 2;
						son--;
						grup_no++;
						System.out.println(grup_no + ". Grup: " + N
								+ "ki�i i�in 2 masa birle�tirildi");
						yeni_masalar.grup_yerle�tir(i1, N);
						yeni_masalar.getMasalar().elementAt(i1)
								.setDoluluk_oran�(100 / 6 * N);
						yeni_masalar.getMasalar().elementAt(i1).toString();
					} else {
						setM��teri_say�s�(getM��teri_say�s�() - N);
						kullan�lan_masa_say�s�++;
						grup_no++;
						System.out.println(grup_no + ". Grup: " + N + "ki�i");
						yeni_masalar.grup_yerle�tir(i1, N);
						yeni_masalar.getMasalar().elementAt(i1)
								.setDoluluk_oran�(100 / 4 * N);
						yeni_masalar.getMasalar().elementAt(i1).toString();
					}
				} else {// masa_birle�tirildimi=evet
					N = 1 + Random.random(getM��teri_say�s�() % 5);// Yeni
																	// m��teri
																	// grubu
					setM��teri_say�s�(getM��teri_say�s�() - N);
					kullan�lan_masa_say�s�++;
					grup_no++;
					System.out.println(grup_no + ". Grup: " + N + "ki�i");
					yeni_masalar.grup_yerle�tir(i1, N);
					yeni_masalar.getMasalar().elementAt(i1)
							.setDoluluk_oran�(100 / 4 * N);
					yeni_masalar.getMasalar().elementAt(i1).toString();
				}
			} else {
				break;
			}
		}
		if (masa_birle�tirildimi == evet) {
			yeni_masalar.getMasalar().removeElementAt(8);
		}
		System.out.println("Kullan�lan_masa_say�s�:" + kullan�lan_masa_say�s�
				+ "\nBo�_masa_say�s�:" + (10 - kullan�lan_masa_say�s�));
		setYerle�emeyenler(getM��teri_say�s�());
		return getYerle�emeyenler();
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

	public int getM��teri_say�s�() {
		return m��teri_say�s�;
	}

	public void setM��teri_say�s�(int m��teri_say�s�) {
		this.m��teri_say�s� = m��teri_say�s�;
	}

	public int getYerle�emeyenler() {
		return yerle�emeyenler;
	}

	public void setYerle�emeyenler(int yerle�emeyenler) {
		this.yerle�emeyenler = yerle�emeyenler;
	}

}
