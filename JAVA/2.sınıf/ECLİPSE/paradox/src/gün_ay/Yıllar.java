package g�n_ay;

import java.util.Vector;

public class Y�llar {
	private static Vector<Y�l> seneler;

	// Y�llar olu�turuluyor
	public Y�llar() {
		int i;
		seneler.setSize(3);// 1990,1991 ve 1992 y�llar� i�in
		for (i = 0; i < 3; i++) {
			seneler.set(i, new Y�l());
		}
	}

	public static Vector<Y�l> getSeneler() {
		return seneler;
	}

	public static void setSeneler(Vector<Y�l> seneler) {
		Y�llar.seneler = seneler;
	}

	public String toString() {
		String metin = "";
		int i, y�l = 1990;
		for (i = 0; i < seneler.size(); i++) {
			metin += (y�l + i) + "Do�umlu olanlar�n �ak��ma listesi\n\n\n"
					+ seneler.elementAt(i).toString();
		}
		return metin;
	}
}
