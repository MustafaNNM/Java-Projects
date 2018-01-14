package Metot;
import java.util.Vector;

public class Metot {

	public static Vector<Vector<Integer>> matris(int n, int m) {
		// nxm boyutlarýnda vektörlerden oluþan veri yapýsý hazýrlanýyor
		Vector<Vector<Integer>> matris = new Vector<Vector<Integer>>();
		int i;
		// Aylar oluþturuluyor
		matris.setSize(n);// Bir yýl 12 aydýr
		for (i = 0; i < matris.size(); i++) {
			matris.set(i, new Vector<Integer>());
			// Aylar baþlangýçta 31 gün olarak ayarlanýyor
			matris.elementAt(i).setSize(m);
		}
		return matris;
	}
}
