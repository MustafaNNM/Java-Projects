import java.util.Vector;

public class M��teriler {
	private Vector<M��teri> m��teriler;// Elemanlar� M��teri nesnesi olan vekt�r
	private int N, max_m��teri_say�s�;// �devde belirtilen sabitler

	public M��teriler() {
		// [0-50] aras�nda m��teri olu�turuluyor
		int i;
		setM��teriler(new Vector<M��teri>());
		max_m��teri_say�s� = 50;
		setN(Random.random(max_m��teri_say�s� + 1));
		m��teriler.setSize(getN());
		for (i = 0; i < m��teriler.size(); i++) {
			m��teriler.set(i, new M��teri());
		}
	}

	public Vector<M��teri> getM��teriler() {
		return m��teriler;
	}

	public void setM��teriler(Vector<M��teri> m��teriler) {
		this.m��teriler = m��teriler;
	}

	private int getN() {
		return N;
	}

	private void setN(int n) {
		N = n;
	}
}
