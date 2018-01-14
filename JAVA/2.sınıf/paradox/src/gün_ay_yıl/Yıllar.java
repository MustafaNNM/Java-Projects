package gün_ay_yýl;

import java.util.Vector;

public class Yýllar {
	private static Vector<Yýl> seneler;

	// Yýllar oluþturuluyor
	public Yýllar(int kaç_yýl) {
		int i;
		seneler = new Vector<Yýl>();
		seneler.setSize(kaç_yýl);// 1990,1991 ve 1992 yýllarý için
		for (i = 0; i < seneler.size(); i++) {
			seneler.set(i, new Yýl());
		}
	}

	public Vector<Yýl> getSeneler() {
		return seneler;
	}

	public static void setSeneler(Vector<Yýl> seneler) {
		Yýllar.seneler = seneler;
	}

	public String toString() {
		String metin = "";
		int i, yýl = 1990;
		for (i = 0; i < seneler.size(); i++) {
			metin += "\n" + (yýl + i) + " Doðumlu olanlarýn çakýþma listesi\n"
					+ seneler.elementAt(i).toString();
		}
		return metin;
	}

}
