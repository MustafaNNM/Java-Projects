package Test_Otopark;

import java.util.LinkedList;
import java.util.Queue;

public class Kat_kuyruk {
	private Queue<Araba> q;
	private int araba_sayısı = 0, patlatılan_araba_sayısı = 0;

	public Kat_kuyruk() {
		setQ(new LinkedList<Araba>());
		araba_yerleştir();
	}

	public Queue<Araba> getQ() {
		return q;
	}

	public void setQ(Queue<Araba> q) {
		this.q = q;
	}

	private void araba_yerleştir() {
		int araba_miktarı = 30;
		setAraba_sayısı(araba_miktarı);
		for (int i = 0; i < araba_miktarı; i++) {
			q.add(new Araba());
		}
	}

	public void çıkar_kuyruktan() {
		if (0 < getAraba_sayısı()) {
			Araba.setSayaç(Araba.getSayaç() - 1);
			setAraba_sayısı(getAraba_sayısı() - 1);
			setPatlatılan_araba_sayısı(getPatlatılan_araba_sayısı() + 1);
		}
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
