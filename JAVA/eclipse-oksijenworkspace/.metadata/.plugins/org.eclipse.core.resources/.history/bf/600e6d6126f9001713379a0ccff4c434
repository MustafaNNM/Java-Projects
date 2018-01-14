public class BListe {
	Balon etkin;
	int katNumarasý;

	public BListe(int katNumarasý) {// constructor
		this.katNumarasý = katNumarasý;
		etkin = null;
	}

	public void Ekle(int no) {// baðlý diziye eleman ekler.
		if (etkin == null) {// liste yeni yaratýlýyorsa;
			Balon yeniBalon = new Balon(no);
			etkin = yeniBalon;
			etkin.sonraki = etkin;// baðlý listeyi dairesel hale getirmek için
		} else {// listede birden fazla eleman varsa;
			Balon yeniBalon = new Balon(no);
			Balon simdiki = etkin, gecici = etkin;
			do {
				gecici = gecici.sonraki;
				simdiki = gecici.sonraki;
			} while (simdiki != etkin);
			gecici.sonraki = yeniBalon;
			yeniBalon.sonraki = etkin;
		}
	}

	public void patlat(int n) {
		Balon kaldi = etkin.sonraki;// silinecek olan balon
		if (n == 1) {//eðer balonlarý teker teker silmemiz isteniyorsa
			while (kaldi.sonraki != etkin) {
				kaldi = kaldi.sonraki;
			}
			System.out.println(katNumarasý+".kattaki "+n+".sýradaki balonlar patlatýlmaktadýr. "+"\nListedeki balonlar:\n");
			yazdir();
			while (doluMu()) {
				System.out.println("\nSilinen; ");
				etkin.yazdir();
				kaldi.sonraki = etkin.sonraki;
				etkin = etkin.sonraki;
				System.out.println("\nListedeki balonlar:\n");
				yazdir();
			}
		} else {
			System.out.print("\n"+katNumarasý+".katta ilk balondan itibaren her "+n+".balon patlatýlmaktadýr.\n\n");
			while (doluMu()) {
				System.out.println(katNumarasý+".katta kalan balonlar:");
				yazdir();
				int sayac = 1;
				while (sayac < n - 1) {// n defa dönmek için..
					sayac++;
					etkin = etkin.sonraki;
					kaldi = kaldi.sonraki;
				}
				System.out.println("\n"+katNumarasý+".katta "+"patlatýlan; ");
				kaldi.yazdir();// her turda kat numarasý ve n deðerinin
								// yazdýrýlmasý
				// istenmiþtir.
				System.out.println();// bir satýr alta geçelim
				etkin.sonraki = kaldi.sonraki;
				etkin = etkin.sonraki;
				kaldi = kaldi.sonraki.sonraki;
			}// döngüden çýkýldýðýnda elimizde sadece bir balon kalmýþ
				// olacaktýr.
		}
		System.out.println("\n\n"+katNumarasý+".katta "+"kalan;\t");
		etkin.yazdir();// onu da ekrana yazdýralým.
	}

	public void yazdir() {
		Balon dolas;// listemiz dairesel olduðu için sonuna gelinip
		// gelinmediðini anlamak için ayrýca bir balon oluþturmak
		// lazýmdýr.
		dolas = etkin;
		do {
			dolas.yazdir();// ve dolaþýrken elemanlarý balon sýnýfýnda bulunan
			// yazdýr yardýmýyla teker teker yazdýrýr.
			dolas = dolas.sonraki;
		} while (dolas != etkin);
	}

	public boolean doluMu() {// patlat metodu için gereklidir.
		if (etkin == etkin.sonraki)// etkin kendine eþit olduðunda
			// yani baðlý listede sadece bir balon kaldýðýnda
			// doluMu sorusuna "hayýr boþ" yanýtýný verir
			return false;
		else
			return true;
	}

}
