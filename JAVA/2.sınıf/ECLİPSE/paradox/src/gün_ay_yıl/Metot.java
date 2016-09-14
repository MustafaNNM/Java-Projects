package g�n_ay_y�l;

import java.util.Vector;

public class Metot {
	private Vector<Integer> g�n_miktarlar�;

	public Metot() {
		// Aylar�n g�n say�lar�na g�re vekt�r olu�turuyor
		setG�n_miktarlar�(new Vector<Integer>());
		getG�n_miktarlar�().setSize(12);
		for (int i = 0; i < getG�n_miktarlar�().size(); i++) {
			getG�n_miktarlar�().set(i, 31);
		}
		getG�n_miktarlar�().set(1, 28);// �ubat 28 �eker
		getG�n_miktarlar�().set(3, 30);// Nisan 30 �eker
		getG�n_miktarlar�().set(5, 30);// Haziran 30 �eker
		getG�n_miktarlar�().set(8, 30);// Eyl�l 30 �eker
		getG�n_miktarlar�().set(10, 30);// Kas�m 30 �eker
	}

	// nxm boyutlar�nda vekt�rlerden olu�an veri yap�s� haz�rlan�yor
	public static Vector<Vector<Integer>> matris(int n, int m) {
		Vector<Vector<Integer>> matris = new Vector<Vector<Integer>>();
		int i;
		// Aylar olu�turuluyor
		matris.setSize(n);// Bir y�l 12 ayd�r
		for (i = 0; i < matris.size(); i++) {
			matris.set(i, new Vector<Integer>());
			// Aylar ba�lang��ta 31 g�n olarak ayarlan�yor
			matris.elementAt(i).setSize(m);
		}
		return matris;
	}

	public Vector<Integer> getG�n_miktarlar�() {
		return g�n_miktarlar�;
	}

	public void setG�n_miktarlar�(Vector<Integer> g�n_miktarlar�) {
		this.g�n_miktarlar� = g�n_miktarlar�;
	}
}
