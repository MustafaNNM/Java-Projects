package üç_giþe;

import java.util.Comparator;
import java.util.PriorityQueue;


public class Öncelikli_Müþteriler {
	Comparator<? super Müþteri> comparator = new MüþteriComparator();
	private PriorityQueue<Müþteri> kuyruk;

	public Öncelikli_Müþteriler(int n) {
		setKuyruk(new PriorityQueue<Müþteri>(n, comparator));
	}

	public void müþteri_ekle(Müþteri müþteri) {
		kuyruk.add(müþteri);
	}

	public Müþteri müþteri_çýkar() {
		Müþteri müþteri = new Müþteri();
		if (0 < kuyruk.size()) {
			müþteri = kuyruk.remove();
		}
		return müþteri;
	}

	public PriorityQueue<Müþteri> getKuyruk() {
		return kuyruk;
	}

	public void setKuyruk(PriorityQueue<Müþteri> kuyruk) {
		this.kuyruk = kuyruk;
	}
}
