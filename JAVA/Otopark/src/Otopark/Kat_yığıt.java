package Otopark;

import java.util.Stack;
import java.util.Vector;

public class Kat_y���t {
	private Stack<Araba> s;
	private Vector<Araba> garaj;
	private int araba_say�s� = 0, patlat�lan_araba_say�s� = 0;

	public Vector<Araba> getGaraj() {
		return garaj;
	}

	public void setGaraj(Vector<Araba> garaj) {
		this.garaj = garaj;
	}

	public static int getS�ra_no() {
		return s�ra_no;
	}

	public static void setS�ra_no(int s�ra_no) {
		Kat_y���t.s�ra_no = s�ra_no;
	}

	static int s�ra_no = 0;

	public Kat_y���t() {
		setGaraj(new Vector<Araba>());
		setS(new Stack<Araba>());
		araba_yerle�tir();
	}

	private void araba_yerle�tir() {
		int araba_miktar� = 30;
		setAraba_say�s�(araba_miktar�);
		for (int i = 0; i < 30; i++) {
			s.add(new Araba());
		}
	}

	public void ��kar_y���ttan() {
		if (0 < getAraba_say�s�()) {
			Araba.setSaya�(Araba.getSaya�() - 1);
			setAraba_say�s�(getAraba_say�s�() - 1);
			setPatlat�lan_araba_say�s�(getPatlat�lan_araba_say�s�() + 1);
			System.out.println("silinen:" + s.pop());// eleman y���ttan
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

	public int getAraba_say�s�() {
		return araba_say�s�;
	}

	public void setAraba_say�s�(int araba_say�s�) {
		this.araba_say�s� = araba_say�s�;
	}

	public int getPatlat�lan_araba_say�s�() {
		return patlat�lan_araba_say�s�;
	}

	public void setPatlat�lan_araba_say�s�(int patlat�lan_araba_say�s�) {
		this.patlat�lan_araba_say�s� = patlat�lan_araba_say�s�;
	}
}
