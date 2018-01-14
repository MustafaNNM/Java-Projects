package ��_gi�e;

import java.util.Comparator;
import java.util.PriorityQueue;


public class �ncelikli_M��teriler {
	Comparator<? super M��teri> comparator = new M��teriComparator();
	private PriorityQueue<M��teri> kuyruk;

	public �ncelikli_M��teriler(int n) {
		setKuyruk(new PriorityQueue<M��teri>(n, comparator));
	}

	public void m��teri_ekle(M��teri m��teri) {
		kuyruk.add(m��teri);
	}

	public M��teri m��teri_��kar() {
		M��teri m��teri = new M��teri();
		if (0 < kuyruk.size()) {
			m��teri = kuyruk.remove();
		}
		return m��teri;
	}

	public PriorityQueue<M��teri> getKuyruk() {
		return kuyruk;
	}

	public void setKuyruk(PriorityQueue<M��teri> kuyruk) {
		this.kuyruk = kuyruk;
	}
}
