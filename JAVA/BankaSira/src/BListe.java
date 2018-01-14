/* Class: BListe
 * Author: Umut BENZER
 * 
 * Öncelikli ve normal kuyruk oluþturmak için kullanýlan sýnýftýr.
 * Öncelikli ya da normal olacaðý constructordaki oncelikli
 * ifadesinin deðerine göre belirlenir.
 * 
 * Kuyruk ile öncelikli kuyruk metotlarý arasýnda çok ufak farklar
 * olduðu için ikisini birleþik yapmak uygun görüþmüþtür.
 */

public class BListe {
	private Musteri bas; // Kuyruðun ilk elemanýnýn referansý
	private Musteri son; // Kuyruðun son elemanýnýn referansý
	private boolean oncelikli; // Kuyruðun özelliði

	/* Ýlk yaratýldýðýnda boþ olan bir kuyruk */
	public BListe() {
		bas = null;
		son = null;
		oncelikli = false;
	}

	public BListe(boolean oncelikli) {
		this.oncelikli = oncelikli;
		bas = null;
		son = null;
	}

	/*
	 * Müþteri nesnesini gelen verilere uygun bir þekilde yaratýr ve ekle
	 * metoduna gönderir.
	 */
	public void ekle(int musteriNo, int islemSuresi, int FIFOBeklemeSuresi) {
		Musteri yeniMusteri = new Musteri(musteriNo, islemSuresi,
				FIFOBeklemeSuresi);
		ekle(yeniMusteri);
	}

	public void ekle(int musteriNo, int islemSuresi) {
		Musteri yeniMusteri = new Musteri(musteriNo, islemSuresi);
		ekle(yeniMusteri);
	}

	/*
	 * Müþteriyi listenin öncelikli olup olmama durumuna uygun bir þekilde
	 * kuyruðun uygun yerine ya da sonuna atar.
	 */
	private void ekle(Musteri yeniMusteri) {
		if (oncelikli) {
			Musteri onceki = null;
			Musteri etkin = bas;

			while (etkin != null && yeniMusteri.islemSuresi > etkin.islemSuresi) {
				onceki = etkin;
				etkin = etkin.sonraki;
			}

			if (onceki == null) {
				bas = yeniMusteri;
			} else {
				onceki.sonraki = yeniMusteri;
			}
			yeniMusteri.sonraki = etkin;

		} else {

			if (son != null) {
				son.sonraki = yeniMusteri;
				son = yeniMusteri;
			} else {
				bas = yeniMusteri;
				son = yeniMusteri;
			}
		}

	}

	/* Sýradaki müþteriyi al ve çýkar */
	public Musteri cikar() {
		Musteri dondurulecek = bas;
		if (bas != null) {
			bas = bas.sonraki;
		}
		return dondurulecek;
	}

	/* Kuyruðun bitip bitmediðini döndürür. */
	public boolean bosMu() {
		return (bas == null ? true : false);
	}

}
