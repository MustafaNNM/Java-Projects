import java.util.Vector;

public class Masalar {
	private Vector<Masa> masalar;// Elemanlar� Masa nesnesi olan vekt�r
	private int masa_say�s�;
	public Masalar() {
		// �devde belirtilen 10 tane masa olu�turuluyor
		setMasalar(new Vector<Masa>());
		setMasa_say�s�(10);
		getMasalar().setSize(getMasa_say�s�());
	}

	public void grup_yerle�tir(int masa_no, int gruptaki_ki�i_say�s�) {
		getMasalar().set(masa_no, new Masa(gruptaki_ki�i_say�s�));
		getMasalar().elementAt(masa_no).m��teri_yerle�tir(masa_no);
	}

	public void grup_ekle(int masa_no, int ek_m��teri) {
		getMasalar().elementAt(masa_no).m��teri_ekle(masa_no,ek_m��teri);
		getMasalar().elementAt(masa_no).setSandalye_say�s�(6);
	}
	public Vector<Masa> getMasalar() {
		return masalar;
	}

	public void setMasalar(Vector<Masa> masalar) {
		this.masalar = masalar;
	}

	public String toString() {
		for (int i = 0; i < getMasalar().size(); i++) {
			getMasalar().elementAt(i).toString();
		}
		return null;
	}

	public int getMasa_say�s�() {
		return masa_say�s�;
	}

	public void setMasa_say�s�(int masa_say�s�) {
		this.masa_say�s� = masa_say�s�;
	}
}
