package g�n_ay_y�l;

import java.util.Vector;

public class Y�llar {
	private static Vector<Y�l> seneler;

	// Y�llar olu�turuluyor
	public Y�llar(int ka�_y�l) {
		int i;
		seneler = new Vector<Y�l>();
		seneler.setSize(ka�_y�l);// 1990,1991 ve 1992 y�llar� i�in
		for (i = 0; i < seneler.size(); i++) {
			seneler.set(i, new Y�l());
		}
	}

	public Vector<Y�l> getSeneler() {
		return seneler;
	}

	public static void setSeneler(Vector<Y�l> seneler) {
		Y�llar.seneler = seneler;
	}

	public String toString() {
		String metin = "";
		int i, y�l = 1990;
		for (i = 0; i < seneler.size(); i++) {
			metin += "\n" + (y�l + i) + " Do�umlu olanlar�n �ak��ma listesi\n"
					+ seneler.elementAt(i).toString();
		}
		return metin;
	}

}
