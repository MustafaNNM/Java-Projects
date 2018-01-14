import java.util.Vector;

public class Müþteriler {
	private Vector<Müþteri> müþteriler;// Elemanlarý Müþteri nesnesi olan vektör
	private int N, max_müþteri_sayýsý;// Ödevde belirtilen sabitler

	public Müþteriler() {
		// [0-50] arasýnda müþteri oluþturuluyor
		int i;
		setMüþteriler(new Vector<Müþteri>());
		max_müþteri_sayýsý = 50;
		setN(Random.random(max_müþteri_sayýsý + 1));
		müþteriler.setSize(getN());
		for (i = 0; i < müþteriler.size(); i++) {
			müþteriler.set(i, new Müþteri());
		}
	}

	public Vector<Müþteri> getMüþteriler() {
		return müþteriler;
	}

	public void setMüþteriler(Vector<Müþteri> müþteriler) {
		this.müþteriler = müþteriler;
	}

	private int getN() {
		return N;
	}

	private void setN(int n) {
		N = n;
	}
}
