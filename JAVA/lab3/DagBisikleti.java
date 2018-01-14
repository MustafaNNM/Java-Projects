public class DagBisikleti extends Bisiklet {
	// DagBisikleti alt sinifi tek bir degisken iceriyor
	public int koltukYuksekligi;
	// DagBisikleti alt sinifi bir yapici iceriyor
	public DagBisikleti(final int baslangicYukseklik, final int baslangicRitm,
			final int baslangicHiz, final int baslangicVites) {
		super(baslangicRitm, baslangicHiz, baslangicVites);
		koltukYuksekligi = baslangicYukseklik;
	}
	// DagBisikleti alt sinifi bir metot iceriyor
	public void setKoltukYuksekligi(final int yeniYukseklik) {
		koltukYuksekligi = yeniYukseklik;
	}
}