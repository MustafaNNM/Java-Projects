/**
 * Bu sinifin amaci temel bisiklet nesnelerini betimlemektir
 * @author emre
 */
public class Bisiklet {
	// Bisiklet sinifi uc adet degisken iceriyor
	public int hiz;
	public int ritm;
	public int vites;
	// Bisiklet sinifi bir adet yapici/yapilandirici iceriyor
	public Bisiklet(final int baslangicRitm, final int baslangicHiz,
			final int baslangicVites) {
		vites = baslangicVites;
		ritm = baslangicRitm;
		hiz = baslangicHiz;
	}
	// Bisiklet sinifi bes metot iceriyor
	public void durumuYaz() {
		System.out.println("R:" + ritm 
				+ " V:" + vites + " H:" + hiz);
	}
	public void frenUygula(final int azaltim) {
		hiz -= azaltim;
	}
	public void hizlan(final int arttirim) {
		hiz += arttirim;
	}
	public void setRitm(final int yeniRitm) {
		ritm = yeniRitm;
	}
	public void setVites(final int yeniVites) {
		vites = yeniVites;
	}
}