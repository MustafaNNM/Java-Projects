public class Node {
	private String harf;
	private int fre;
	private Node left_node, right_node;
	String code="";

	public Node() {
		setFre(1);
	}

	public String getHarf() {
		return harf;
	}

	public void setHarf(String harf) {
		this.harf = harf;
	}

	public int getFre() {
		return fre;
	}

	public void setFre(int fre) {
		this.fre = fre;
	}

	public String toString() {
		return "harf: " + harf + " fre: " + fre;
	}

	public Node getLeft_node() {
		return left_node;
	}

	public void setLeft_node(Node left_node) {
		this.left_node = left_node;
	}

	public Node getRight_node() {
		return right_node;
	}

	public void setRight_node(Node right_node) {
		this.right_node = right_node;
	}
}
