package gün_ay;

import java.util.Vector;

public class Yýllar {
	private static Vector<Yýl> seneler;

	// Yýllar oluþturuluyor
	public Yýllar() {
		int i;
		seneler.setSize(3);// 1990,1991 ve 1992 yýllarý için
		for (i = 0; i < 3; i++) {
			seneler.set(i, new Yýl());
		}
	}

	public static Vector<Yýl> getSeneler() {
		return seneler;
	}

	public static void setSeneler(Vector<Yýl> seneler) {
		Yýllar.seneler = seneler;
	}

	public String toString() {
		String metin = "";
		int i, yýl = 1990;
		for (i = 0; i < seneler.size(); i++) {
			metin += (yýl + i) + "Doðumlu olanlarýn çakýþma listesi\n\n\n"
					+ seneler.elementAt(i).toString();
		}
		return metin;
	}
}
