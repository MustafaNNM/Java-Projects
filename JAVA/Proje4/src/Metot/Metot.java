package Metot;
import java.util.Vector;

public class Metot {

	public static Vector<Vector<Integer>> matris(int n, int m) {
		// nxm boyutlar�nda vekt�rlerden olu�an veri yap�s� haz�rlan�yor
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
}
