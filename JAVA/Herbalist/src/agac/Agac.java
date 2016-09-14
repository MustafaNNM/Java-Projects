package agac;

import java.util.Vector;

public class Agac {
	public Node node;
	public int node_say�s�=0;

	private Vector<String> preorder;
	private Vector<String> inorder;
	private Vector<String> postorder;

	public Agac() {
		setPreorder(new Vector<String>());
		setInorder(new Vector<String>());
		setPostorder(new Vector<String>());
		node = null;
		node_say�s�++;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	// Ağaca bir düğüm eklemeyi sağlayan metot
	public void insert(Node newnode) {
		if (node == null) {
			node = newnode;
		} else {
			Node current = node;
			Node parent;
			while (true) {
				parent = current;
				if (newnode.getBitki().getAdi().compareTo(
						current.getBitki().getAdi()) < 0) {
					current = current.getLeft_node();// K���kse sola
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

		if (node == null)

			return false;

		else {

			if (node.getBitki().getAdi().compareTo(value) == 0) {

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
			System.out.println("Bulunamadı\n");
			return "Bulunamadı";
		} else {
			int sonuc;
			if ((sonuc = data.compareTo(wanted.getBitki().getAdi())) == 0) {
				System.out.println("Bulundu\n");
				// System.out.println("Bulunan:\n" + wanted.toString());
				return wanted.toString();
			} else {
				if (sonuc < 0) {
					return find(wanted.getLeft_node(), data);
				} else {
					return find(wanted.getRight_node(), data);
				}
			}
		}
	}

	// **************** Listeleme
	// Metotlar ************************************************

	// Ağacın preOrder Dolaşılması
	public void preOrder(Node localnode, int duzey) {
		if (localnode != null) {
			// System.out.println(localnode.getBitki().getAdı());
			preorder.add("Duzey: " + duzey + "Bitki Adı: "
					+ localnode.getBitki().getAdi() + "\n");
			preOrder(localnode.getLeft_node(), ++duzey);
			preOrder(localnode.getRight_node(), duzey);
		}
	}

	// Agacın inOrder Dolaşılması
	public void inOrder(Node localnode, int duzey) {
		if (localnode != null) {
			inOrder(localnode.getLeft_node(), duzey);
			// System.out.println(localnode.getBitki().getAdı());
			inorder.add("Duzey: " + duzey + "Bitki Adı: "
					+ localnode.getBitki().getAdi() + "\n");
			inOrder(localnode.getRight_node(), duzey);
		}
	}

	// Agacın postOrder Dolaşılması
	public void postOrder(Node localnode, int duzey) {
		if (localnode != null) {
			postOrder(localnode.getLeft_node(), duzey);
			postOrder(localnode.getRight_node(), duzey);
			// System.out.println(localnode.getBitki().getAdı());
			postorder.add("Duzey: " + duzey + "Bitki Adi: "
					+ localnode.getBitki().getAdi() + "\n");
		}
	}

	// Duzey listeleme
	public void duzey_listele(Node localnode) {

	}

	public String preOrder_yazdir() {
		String metin = "";
		for (int i = 0; i < preorder.size(); i++) {
			metin += preorder.elementAt(i);
		}
		return metin;
	}

	public String inOrder_yazdir() {
		String metin = "";
		for (int i = 0; i < inorder.size(); i++) {
			metin += inorder.elementAt(i);
		}
		return metin;
	}

	public String postOrder_yazdir() {
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
} // class Agac

