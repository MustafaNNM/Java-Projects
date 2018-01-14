import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
	@Override
	public int compare(Node v1, Node v2) {
		String a = "" + ((Node) v1).getFre(), b = "" + ((Node) v2).getFre();
		return a.compareTo(b);
	}
}