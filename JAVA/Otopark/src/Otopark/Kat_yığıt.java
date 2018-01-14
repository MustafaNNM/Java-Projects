package Otopark;

import java.util.Stack;
import java.util.Vector;

public class Kat_yığıt {
	private Stack<Araba> s;
	private Vector<Araba> garaj;
	private int araba_sayısı = 0, patlatılan_araba_sayısı = 0;

	public Vector<Araba> getGaraj() {
		return garaj;
	}

	public void setGaraj(Vector<Araba> garaj) {
		this.garaj = garaj;
	}

	public static int getSıra_no() {
		return sıra_no;
	}

	public static void setSıra_no(int sıra_no) {
		Kat_yığıt.sıra_no = sıra_no;
	}

	static int sıra_no = 0;

	public Kat_yığıt() {
		setGaraj(new Vector<Araba>());
		setS(new Stack<Araba>());
		araba_yerleştir();
	}

	private void araba_yerleştir() {
		int araba_miktarı = 30;
		setAraba_sayısı(araba_miktarı);
		for (int i = 0; i < 30; i++) {
			s.add(new Araba());
		}
	}

	public void çıkar_yığıttan() {
		if (0 < getAraba_sayısı()) {
			Araba.setSayaç(Araba.getSayaç() - 1);
			setAraba_sayısı(getAraba_sayısı() - 1);
			setPatlatılan_araba_sayısı(getPatlatılan_araba_sayısı() + 1);
			System.out.println("silinen:" + s.pop());// eleman yığıttan
														// siliniyor
		}
	}

	public Stack<Araba> getS() {
		return s;
	}

	public void setS(Stack<Araba> s) {
		this.s = s;
	}

	public String toString() {
		String metin = "";
		java.util.Iterator<Araba> itr = s.iterator();
		System.out.println("Initial Size of Stack  :" + s.size());
		while (itr.hasNext()) {
			Araba iteratorValue = (Araba) itr.next();
			metin += "\n" + iteratorValue;
		}
		metin += "\n\n**************";
		return metin;
	}

	public String remove_all_elements() {
		String metin = "";
		while (!s.empty()) {
			metin += "\n" + s.pop();
		}
		metin += "\n\n**************";
		return metin;
	}

	public int getAraba_sayısı() {
		return araba_sayısı;
	}

	public void setAraba_sayısı(int araba_sayısı) {
		this.araba_sayısı = araba_sayısı;
	}

	public int getPatlatılan_araba_sayısı() {
		return patlatılan_araba_sayısı;
	}

	public void setPatlatılan_araba_sayısı(int patlatılan_araba_sayısı) {
		this.patlatılan_araba_sayısı = patlatılan_araba_sayısı;
	}
}
