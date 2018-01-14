/* Class: Musteri
 * Author: Didem KAYALI
 * 
 * Müþteri bilgilerinin tutulduðu veri sýnýfýdýr. Normal
 * sýralý bekleme bilgileri FIFOBeklemeSuresi deðiþkeninde
 * tutulurken öncelikli kuyrukta ne kadar beklediði
 * PBeklemeSuresi deðiþkeninde tutulmaktadýr.
 */

public class Musteri {
	public final int musteriNo;
	public final int islemSuresi;
	public Musteri sonraki;
	public int FIFOBeklemeSuresi;
	public int PBeklemeSuresi;

	/*
	 * Musteri sýnýfý için iki constructor bulunmaktadýr. Müþterileri hem normal
	 * kuyrukta hem de öncelikli kuyrukta sýraladýktan sonra ne kadar
	 * beklediklerini karþýlaþtýrmak için iki bekleme sürsinin de ne kadar
	 * olduðunu bilmek önemlidir.
	 * 
	 * Programda önce standart kuyruk simüle edilir. Daha sonra buradan gelen
	 * verileri de kullanarak öncelikli kuyruðu simüle etmek üzere kuyruk
	 * yeniden oluþturulur. Bu yeniden oluþturma esnasýnda standart bekleme
	 * süreleri daha önce hesaplanmýþ olduðu için müþteri bilgileri içine
	 * atýlabilir.
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
