/* Class: Musteri
 * Author: Didem KAYALI
 * 
 * M��teri bilgilerinin tutuldu�u veri s�n�f�d�r. Normal
 * s�ral� bekleme bilgileri FIFOBeklemeSuresi de�i�keninde
 * tutulurken �ncelikli kuyrukta ne kadar bekledi�i
 * PBeklemeSuresi de�i�keninde tutulmaktad�r.
 */

public class Musteri {
	public final int musteriNo;
	public final int islemSuresi;
	public Musteri sonraki;
	public int FIFOBeklemeSuresi;
	public int PBeklemeSuresi;

	/*
	 * Musteri s�n�f� i�in iki constructor bulunmaktad�r. M��terileri hem normal
	 * kuyrukta hem de �ncelikli kuyrukta s�ralad�ktan sonra ne kadar
	 * beklediklerini kar��la�t�rmak i�in iki bekleme s�rsinin de ne kadar
	 * oldu�unu bilmek �nemlidir.
	 * 
	 * Programda �nce standart kuyruk sim�le edilir. Daha sonra buradan gelen
	 * verileri de kullanarak �ncelikli kuyru�u sim�le etmek �zere kuyruk
	 * yeniden olu�turulur. Bu yeniden olu�turma esnas�nda standart bekleme
	 * s�releri daha �nce hesaplanm�� oldu�u i�in m��teri bilgileri i�ine
	 * at�labilir.
	 */
	public Musteri(int musteriNo, int islemSuresi) {
		this.musteriNo = musteriNo;
		this.islemSuresi = islemSuresi;
		this.FIFOBeklemeSuresi = 0;
	}

	public Musteri(int musteriNo, int islemSuresi, int FIFOBeklemeSuresi) {
		this.musteriNo = musteriNo;
		this.islemSuresi = islemSuresi;
		this.FIFOBeklemeSuresi = FIFOBeklemeSuresi;
	}

}
