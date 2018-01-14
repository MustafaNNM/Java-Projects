package Otopark;

import java.util.Iterator;
import java.util.Vector;

public class Hegzaplex {
	private Vector<Object> katlar;

	public Hegzaplex() {
		setKatlar(new Vector<Object>());
		triplex();
		triplex();
	}

	public void triplex() {
		katlar.add(new Kat_kuyruk());
		katlar.add(new Kat_yýðýt());
		katlar.add(new Kat_dairesel());
	}

	public Vector<Object> getKatlar() {
		return katlar;
	}

	public void setKatlar(Vector<Object> katlar) {
		this.katlar = katlar;
	}

	public String toString() {
		String metin = "";
		Iterator<Object> itr = katlar.iterator();
		System.out
				.println("Initial Size of Hegzaplex :" + katlar.size() + "\n");
		while (itr.hasNext()) {
			Object iteratorValue = (Object) itr.next();
			metin += "\n\nHegzaplex Next Floor:\n\n" + iteratorValue;
		}
		return metin;
	}
}
