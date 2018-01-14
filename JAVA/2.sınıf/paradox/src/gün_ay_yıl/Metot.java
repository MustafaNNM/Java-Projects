package gün_ay_yýl;

import java.util.Vector;

public class Metot {
	private Vector<Integer> gün_miktarlarý;

	public Metot() {
		// Aylarýn gün sayýlarýna göre vektör oluþturuyor
		setGün_miktarlarý(new Vector<Integer>());
		getGün_miktarlarý().setSize(12);
		for (int i = 0; i < getGün_miktarlarý().size(); i++) {
			getGün_miktarlarý().set(i, 31);
		}
		getGün_miktarlarý().set(1, 28);// Þubat 28 çeker
		getGün_miktarlarý().set(3, 30);// Nisan 30 çeker
		getGün_miktarlarý().set(5, 30);// Haziran 30 çeker
		getGün_miktarlarý().set(8, 30);// Eylül 30 çeker
		getGün_miktarlarý().set(10, 30);// Kasým 30 çeker
	}

	// nxm boyutlarýnda vektörlerden oluþan veri yapýsý hazýrlanýyor
	public static Vector<Vector<Integer>> matris(int n, int m) {
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

	public Vector<Integer> getGün_miktarlarý() {
		return gün_miktarlarý;
	}

	public void setGün_miktarlarý(Vector<Integer> gün_miktarlarý) {
		this.gün_miktarlarý = gün_miktarlarý;
	}
}
