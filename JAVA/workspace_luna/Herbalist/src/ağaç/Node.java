package a�a�;

import deva.Bitki;

public class Node {
	private Bitki bitki;
	private Node left_node;
	private Node right_node;
	private static int node_say�s�=0;
	
	public Node(Bitki bitki) {
		setBitki(bitki);
		setLeft_node(null);
		setRight_node(null);
	}

	public Bitki getBitki() {
		return bitki;
	}

	public void setBitki(Bitki bitki) {
		this.bitki = bitki;
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

	public String toString() {
		return bitki.toString();
	}

	public boolean remove(String value, Node parent) {

		if (value.compareTo(this.getBitki().getAd�()) < 0) {

			if (left_node != null){
				return left_node.remove(value, this);
			}
			else
			{
				return false;
			}
		} else if (value.compareTo(this.getBitki().getAd�()) > 0) {

			if (right_node != null){

				return right_node.remove(value, this);
			}
			else{

				return false;
			}
		} else {

			if (left_node != null && right_node != null) {

				this.getBitki().setAd�(right_node.minValue());

				right_node.remove(this.getBitki().getAd�(), this);

			} else if (parent.left_node == this) {

				parent.left_node = (left_node != null) ? left_node : right_node;

			} else if (parent.right_node == this) {

				parent.right_node = (left_node != null) ? left_node
						: right_node;

			}

			return true;

		}

	}

	public String minValue() {

		if (left_node == null){
			return this.getBitki().getAd�();
		}
		else{
			return left_node.minValue();
		}
	}

	public static void setNode_say�s�(int node_say�s�) {
		Node.node_say�s� = node_say�s�;
	}

	public static int getNode_say�s�() {
		return node_say�s�;
	}

}
