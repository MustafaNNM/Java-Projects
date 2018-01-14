/* Class: BListe
 * Author: Umut BENZER
 * 
 * �ncelikli ve normal kuyruk olu�turmak i�in kullan�lan s�n�ft�r.
 * �ncelikli ya da normal olaca�� constructordaki oncelikli
 * ifadesinin de�erine g�re belirlenir.
 * 
 * Kuyruk ile �ncelikli kuyruk metotlar� aras�nda �ok ufak farklar
 * oldu�u i�in ikisini birle�ik yapmak uygun g�r��m��t�r.
 */

public class BListe {
	private Musteri bas; // Kuyru�un ilk eleman�n�n referans�
	private Musteri son; // Kuyru�un son eleman�n�n referans�
	private boolean oncelikli; // Kuyru�un �zelli�i

	/* �lk yarat�ld���nda bo� olan bir kuyruk */
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
	 * M��teri nesnesini gelen verilere uygun bir �ekilde yarat�r ve ekle
	 * metoduna g�nderir.
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
	 * M��teriyi listenin �ncelikli olup olmama durumuna uygun bir �ekilde
	 * kuyru�un uygun yerine ya da sonuna atar.
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

	/* S�radaki m��teriyi al ve ��kar */
	public Musteri cikar() {
		Musteri dondurulecek = bas;
		if (bas != null) {
			bas = bas.sonraki;
		}
		return dondurulecek;
	}

	/* Kuyru�un bitip bitmedi�ini d�nd�r�r. */
	public boolean bosMu() {
		return (bas == null ? true : false);
	}

}
