import java.util.Comparator;
import java.util.PriorityQueue;

public class �ncelik_Kuyru�u {
	Comparator<?> comparator = new NodeComparator();
	private PriorityQueue<Node> nodes;
	public	�ncelik_Kuyru�u() {
		setNodes(new PriorityQueue<Node>(16,
				extracted(comparator)));
	}
	@SuppressWarnings("unchecked")
	private static Comparator<? super Node> extracted(Comparator<?> comparator) {
		return (Comparator<? super Node>) comparator;
	}

	public PriorityQueue<Node> getNodes() {
		return nodes;
	}

	public void setNodes(PriorityQueue<Node> nodes) {
		this.nodes = nodes;
	}

}
