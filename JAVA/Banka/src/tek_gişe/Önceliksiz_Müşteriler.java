package tek_gi�e;

import java.util.LinkedList;
import java.util.Queue;

public class �nceliksiz_M��teriler {
	private Queue<M��teri> kuyruk;
	public �nceliksiz_M��teriler(int n) {
		setKuyruk(new LinkedList<M��teri>());
	}
	public Queue<M��teri> getKuyruk() {
		return kuyruk;
	}
	public void setKuyruk(Queue<M��teri> kuyruk) {
		this.kuyruk = kuyruk;
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

}
