package aðaç;

import java.util.Vector;

public class Aðaç {
	public Node node;
	public int node_sayýsý=0;

	private Vector<String> preorder;
	private Vector<String> inorder;
	private Vector<String> postorder;

	public Aðaç() {
		setPreorder(new Vector<String>());
		setInorder(new Vector<String>());
		setPostorder(new Vector<String>());
		node = null;
		node_sayýsý++;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	// Agaca bir dügüm eklemeyi saglayan metot
	public void insert(Node newnode) {
		if (node == null) {
			node = newnode;
		} else {
			Node current = node;
			Node parent;
			while (true) {
				parent = current;
				if (newnode.getBitki().getAdý().compareTo(
						current.getBitki().getAdý()) < 0) {
					current = current.getLeft_node();// Küçükse sola
					if (current == null) {
						parent.setLeft_node(newnode);
						return;
					}
				} else {
					current = current.getRight_node();
					if (current == null) {
						parent.setRight_node(newnode);
						return;
					}
				}
			}
		} // end else not node
	} // end insert()

	public boolean remove(String value) {

		if (node == null){

			return false;
		}
		else {

			if (node.getBitki().getAdý().compareTo(value) == 0) {

				Node auxnode = new Node(null);

				auxnode.setLeft_node(node);

				boolean result = node.remove(value, auxnode);

				node = auxnode.getLeft_node();

				return result;

			} else {

				return node.remove(value, null);

			}

		}

	}

	public String find(Node wanted, String data) {

		if (wanted == null) {
			System.out.println("Bulunamadý\n");
			return "Bulunamadý";
		} else {
			int sonuç;
			if ((sonuç = data.compareTo(wanted.getBitki().getAdý())) == 0) {
				System.out.println("Bulundu\n");
				// System.out.println("Bulunan:\n" + wanted.toString());
				return wanted.toString();
			} else {
				if (sonuç < 0) {
					return find(wanted.getLeft_node(), data);
				} else {
					return find(wanted.getRight_node(), data);
				}
			}
		}
	}

	// **************** Listeleme
	// Metotlarý ************************************************

	// Agacýn preOrder Dolasýlmasý
	public void preOrder(Node localnode, int düzey) {
		if (localnode != null) {
			// System.out.println(localnode.getBitki().getAdý());
			preorder.add("Düzey: " + düzey + "Bitki Adý: "
					+ localnode.getBitki().getAdý() + "\n");
			preOrder(localnode.getLeft_node(), ++düzey);
			preOrder(localnode.getRight_node(), düzey);
		}
	}

	// Agacýn inOrder Dolasýlmasý
	public void inOrder(Node localnode, int düzey) {
		if (localnode != null) {
			inOrder(localnode.getLeft_node(), düzey);
			// System.out.println(localnode.getBitki().getAdý());
			inorder.add("Düzey: " + düzey + "Bitki Adý: "
					+ localnode.getBitki().getAdý() + "\n");
			inOrder(localnode.getRight_node(), düzey);
		}
	}

	// Agacýn postOrder Dolasýlmasý
	public void postOrder(Node localnode, int düzey) {
		if (localnode != null) {
			postOrder(localnode.getLeft_node(), düzey);
			postOrder(localnode.getRight_node(), düzey);
			// System.out.println(localnode.getBitki().getAdý());
			postorder.add("Düzey: " + düzey + "Bitki Adý: "
					+ localnode.getBitki().getAdý() + "\n");
		}
	}

	// Düzey listeleme
	public void düzey_listele(Node localnode) {

	}

	public String preOrder_yazdýr() {
		String metin = "";
		for (int i = 0; i < preorder.size(); i++) {
			metin += preorder.elementAt(i);
		}
		return metin;
	}

	public String inOrder_yazdýr() {
		String metin = "";
		for (int i = 0; i < inorder.size(); i++) {
			metin += inorder.elementAt(i);
		}
		return metin;
	}

	public String postOrder_yazdýr() {
		String metin = "";
		for (int i = 0; i < postorder.size(); i++) {
			metin += postorder.elementAt(i);
		}
		return metin;
	}

	public void setPreorder(Vector<String> preorder) {
		this.preorder = preorder;
	}

	public Vector<String> getPreorder() {
		return preorder;
	}

	public void setInorder(Vector<String> inorder) {
		this.inorder = inorder;
	}

	public Vector<String> getInorder() {
		return inorder;
	}

	public void setPostorder(Vector<String> postorder) {
		this.postorder = postorder;
	}

	public Vector<String> getPostorder() {
		return postorder;
	}
} // class Aðaç

