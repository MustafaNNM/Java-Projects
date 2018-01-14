package Test_Otopark;

import java.util.LinkedList;
import java.util.Queue;

public class Kat_kuyruk {
	private Queue<Araba> q;
	private int araba_say�s� = 0, patlat�lan_araba_say�s� = 0;

	public Kat_kuyruk() {
		setQ(new LinkedList<Araba>());
		araba_yerle�tir();
	}

	public Queue<Araba> getQ() {
		return q;
	}

	public void setQ(Queue<Araba> q) {
		this.q = q;
	}

	private void araba_yerle�tir() {
		int araba_miktar� = 30;
		setAraba_say�s�(araba_miktar�);
		for (int i = 0; i < araba_miktar�; i++) {
			q.add(new Araba());
		}
	}

	public void ��kar_kuyruktan() {
		if (0 < getAraba_say�s�()) {
			Araba.setSaya�(Araba.getSaya�() - 1);
			setAraba_say�s�(getAraba_say�s�() - 1);
			setPatlat�lan_araba_say�s�(getPatlat�lan_araba_say�s�() + 1);
		}
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
