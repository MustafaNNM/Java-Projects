public class BListe {
	Balon etkin = null;
	int katNumaras�;

	public BListe(int katNumaras�) {// constructor
		this.katNumaras� = katNumaras�;
		etkin = null;
	}

	public void Ekle(int no) {// ba�l� diziye eleman ekler.
		if (etkin == null) {// liste yeni yarat�l�yorsa;
			Balon yeniBalon = new Balon(no);
			etkin = yeniBalon;
			etkin.setSonraki(etkin);// ba�l� listeyi dairesel hale getirmek i�in
		} else {// listede birden fazla eleman varsa;
			Balon yeniBalon = new Balon(no);
			Balon simdiki = etkin, gecici = etkin;
			do {
				gecici = gecici.getSonraki();
				simdiki = gecici.getSonraki();
			} while (simdiki != etkin);
			gecici.setSonraki(yeniBalon);
			yeniBalon.setSonraki(etkin);
		}
	}

	public void patlat(int n) {
		Balon kaldi = etkin.getSonraki();// silinecek olan balon
		if (n == 1) {// e�er balonlar� teker teker silmemiz isteniyorsa
			while (kaldi.getSonraki() != etkin) {
				kaldi = kaldi.getSonraki();
			}
			System.out.println(katNumaras� + ".kattaki " + n + ".s�radaki balonlar patlat�lmaktad�r. "
					+ "\nListedeki balonlar:\n");
			System.out.println(toString());
			while (doluMu()) {
				System.out.println("\nSilinen; ");
				System.out.println(etkin.toString());
				kaldi.setSonraki(etkin.getSonraki());
				etkin = etkin.getSonraki();
				System.out.println("\nListedeki balonlar:\n");
				System.out.println(toString());
			}
		} else {
			System.out.print(
					"\n" + katNumaras� + ".katta ilk balondan itibaren her " + n + ".balon patlat�lmaktad�r.\n\n");
			while (doluMu()) {
				System.out.println(katNumaras� + ".katta kalan balonlar:");
				System.out.println(toString());
				int sayac = 1;
				while (sayac < n - 1) {// n defa d�nmek i�in..
					sayac++;
					etkin = etkin.getSonraki();
					kaldi = kaldi.getSonraki();
				}
				System.out.println("\n" + katNumaras� + ".katta " + "patlat�lan; ");
				System.out.println(kaldi.toString());// her turda kat numaras� ve n de�erinin
				// yazd�r�lmas�
				// istenmi�tir.
				System.out.println();// bir sat�r alta ge�elim
				etkin.setSonraki(kaldi.getSonraki());
				etkin = etkin.getSonraki();
				kaldi = kaldi.getSonraki().getSonraki();
			} // d�ng�den ��k�ld���nda elimizde sadece bir balon kalm��
				// olacakt�r.
		}
		System.out.println("\n\n" + katNumaras� + ".katta " + "kalan;\t");
		System.out.println(etkin.toString());// onu da ekrana yazd�ral�m.
	}

	public String toString() {
		String balonlar = "";
		Balon dolas;// listemiz dairesel oldu�u i�in sonuna gelinip
		// gelinmedi�ini anlamak i�in ayr�ca bir balon olu�turmak
		// laz�md�r.
		dolas = etkin;
		do {
			balonlar += dolas.toString() + "\n";// ve dola��rken elemanlar� balon s�n�f�nda bulunan
			// yazd�r yard�m�yla teker teker yazd�r�r.
			dolas = dolas.getSonraki();
		} while (dolas != etkin);
		return balonlar;
	}

	public boolean doluMu() {// patlat metodu i�in gereklidir.
		if (etkin == etkin.getSonraki()) {// etkin kendine e�it oldu�unda
											// yani ba�l� listede sadece bir balon kald���nda
											// doluMu sorusuna "hay�r bo�" yan�t�n� verir
			return false;
		} else {
			return true;
		}
	}

}
