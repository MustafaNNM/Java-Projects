package tek_giþe;

import java.util.LinkedList;
import java.util.Queue;

public class Önceliksiz_Müþteriler {
	private Queue<Müþteri> kuyruk;
	public Önceliksiz_Müþteriler(int n) {
		setKuyruk(new LinkedList<Müþteri>());
	}
	public Queue<Müþteri> getKuyruk() {
		return kuyruk;
	}
	public void setKuyruk(Queue<Müþteri> kuyruk) {
		this.kuyruk = kuyruk;
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

}
