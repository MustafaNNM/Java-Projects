package g�n_ay_y�l;

import java.util.Vector;

public class �statistik {
	private Vector<Vector<Integer>> veriler;// Ya��t ki�ilerin say�s�n� g�steren
											// matris
	private Vector<Integer> verilerin_toplam�;// D�rt t�rdeki (5,10,100 ve 250)
	// deneylerin sonu�lar�n�
	// �ak��malara g�re toplamak
	// i�in
	private Y�l matris;
	private static Vector<Integer> ki�i_say�s�;// Ki�i miktarlar�n� tutan vekt�r

	public �statistik() {
		// D�rt t�rdeki (5,10,100 ve 250) deneylerin sonu�lar�n� hesaplamak i�in
		setVeriler(Metot.matris(4, 10));// her deneyi kendi i�erisinde toplamak
		// i�in
		setMatris(new Y�l());
		setVerilerin_toplam�(new Vector<Integer>());
		getVerilerin_toplam�().setSize(getVeriler().size());// her deney
															// gruplar�n� kendi
		// i�erisinde toplamak i�in
		ayarlar();
		reset();
	}

	private static void ayarlar() {
		// Deneylerde kullan�lmas� istenen ki�i miktarlar� ayarlan�yor
		setKi�i_say�s�(new Vector<Integer>());
		getKi�i_say�s�().setSize(4);
		getKi�i_say�s�().set(0, 5);
		getKi�i_say�s�().set(1, 10);
		getKi�i_say�s�().set(2, 100);
		getKi�i_say�s�().set(3, 250);
	}

	public Vector<Vector<Integer>> getVeriler() {
		return veriler;
	}

	public void setVeriler(Vector<Vector<Integer>> veriler) {
		this.veriler = veriler;
	}

	// Verilerin de�eri 0'a e�itleniyor
	public void reset() {
		int i, j;
		for (i = 0; i < veriler.size(); i++) {
			for (j = 0; j < veriler.elementAt(i).size(); j++) {
				veriler.elementAt(i).set(j, 0);
			}
		}
	}

	public int hesapla(int deney_t�r�, int deney_no) {
		// �ak��malar say�l�yor
		int i, j, toplam = 0;
		for (i = 0; i < matris.getAylar().size(); i++) {
			for (j = 0; j < matris.getAylar().elementAt(i).size(); j++) {
				if (1 < matris.getAylar().elementAt(i).elementAt(j)) {
					toplam += matris.getAylar().elementAt(i).elementAt(j);
				}
			}
		}
		getVeriler().elementAt(deney_t�r�).set(deney_no, toplam);// Her deney
		// gruplar�n�
		// kendi
		// i�erisinde
		// toplamak
		// i�in
		return toplam;
	}

	// her deney gruplar�n� kendi i�erisinde topluyor
	public void toplamlar�_hesapla() {
		int i, j, toplam;
		for (i = 0; i < getVeriler().size(); i++) {
			toplam = 0;
			for (j = 0; j < getVeriler().elementAt(i).size(); j++) {
				toplam += getVeriler().elementAt(i).elementAt(j);
			}
			getVerilerin_toplam�().set(i, toplam);
		}
	}

	public String verilerin_ortalamas�_toString() {
		System.out.println("Ki�i_say�s� Ortalamalar");
		for (int i = 0; i < getVerilerin_toplam�().size(); i++) {
			System.out.printf("%-10d:%7.2f\n", getKi�i_say�s�().elementAt(i),
					(float) getVerilerin_toplam�().elementAt(i) / 10);
		}
		return null;
	}

	public String toString() {
		int i, j;
		System.out.printf("�statistik Ki�i_say�s�\nDeney_no");
		for (i = 0; i < getKi�i_say�s�().size(); i++) {
			System.out.printf("%8d", getKi�i_say�s�().elementAt(i));
		}
		System.out.flush();
		System.out.println();
		for (i = 0; i < veriler.elementAt(0).size(); i++) {
			System.out.printf("%-8d", i + 1);
			for (j = 0; j < veriler.size(); j++) {
				System.out.printf("%8d", veriler.elementAt(j).elementAt(i));
			}
			System.out.flush();
			System.out.println();
		}
		return null;
	}

	public Y�l getMatris() {
		return matris;
	}

	public void setMatris(Y�l matris) {
		this.matris = matris;
	}

	protected static Vector<Integer> getKi�i_say�s�() {
		return ki�i_say�s�;
	}

	protected static void setKi�i_say�s�(final Vector<Integer> ki�i_say�s�) {
		�statistik.ki�i_say�s� = ki�i_say�s�;
	}

	private Vector<Integer> getVerilerin_toplam�() {
		return verilerin_toplam�;
	}

	private void setVerilerin_toplam�(Vector<Integer> verilerin_toplam�) {
		this.verilerin_toplam� = verilerin_toplam�;
	}
}
