import java.util.Vector;

public class Masalar {
	private Vector<Masa> masalar;// Elemanlarý Masa nesnesi olan vektör
	private int masa_sayýsý;
	public Masalar() {
		// Ödevde belirtilen 10 tane masa oluþturuluyor
		setMasalar(new Vector<Masa>());
		setMasa_sayýsý(10);
		getMasalar().setSize(getMasa_sayýsý());
	}

	public void grup_yerleþtir(int masa_no, int gruptaki_kiþi_sayýsý) {
		getMasalar().set(masa_no, new Masa(gruptaki_kiþi_sayýsý));
		getMasalar().elementAt(masa_no).müþteri_yerleþtir(masa_no);
	}

	public void grup_ekle(int masa_no, int ek_müþteri) {
		getMasalar().elementAt(masa_no).müþteri_ekle(masa_no,ek_müþteri);
		getMasalar().elementAt(masa_no).setSandalye_sayýsý(6);
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

	public int getMasa_sayýsý() {
		return masa_sayýsý;
	}

	public void setMasa_sayýsý(int masa_sayýsý) {
		this.masa_sayýsý = masa_sayýsý;
	}
}
