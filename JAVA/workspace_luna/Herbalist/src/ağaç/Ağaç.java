package a�a�;

import java.util.Vector;

public class A�a� {
	public Node node;
	public int node_say�s�=0;

	private Vector<String> preorder;
	private Vector<String> inorder;
	private Vector<String> postorder;

	public A�a�() {
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

	// Agaca bir d�g�m eklemeyi saglayan metot
	public void insert(Node newnode) {
		if (node == null) {
			node = newnode;
		} else {
			Node current = node;
			Node parent;
			while (true) {
				parent = current;
				if (newnode.getBitki().getAd�().compareTo(
						current.getBitki().getAd�()) < 0) {
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

		if (node == null){

			return false;
		}
		else {

			if (node.getBitki().getAd�().compareTo(value) == 0) {

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
			System.out.println("Bulunamad�\n");
			return "Bulunamad�";
		} else {
			int sonu�;
			if ((sonu� = data.compareTo(wanted.getBitki().getAd�())) == 0) {
				System.out.println("Bulundu\n");
				// System.out.println("Bulunan:\n" + wanted.toString());
				return wanted.toString();
			} else {
				if (sonu� < 0) {
					return find(wanted.getLeft_node(), data);
				} else {
					return find(wanted.getRight_node(), data);
				}
			}
		}
	}

	// **************** Listeleme
	// Metotlar� ************************************************

	// Agac�n preOrder Dolas�lmas�
	public void preOrder(Node localnode, int d�zey) {
		if (localnode != null) {
			// System.out.println(localnode.getBitki().getAd�());
			preorder.add("D�zey: " + d�zey + "Bitki Ad�: "
					+ localnode.getBitki().getAd�() + "\n");
			preOrder(localnode.getLeft_node(), ++d�zey);
			preOrder(localnode.getRight_node(), d�zey);
		}
	}

	// Agac�n inOrder Dolas�lmas�
	public void inOrder(Node localnode, int d�zey) {
		if (localnode != null) {
			inOrder(localnode.getLeft_node(), d�zey);
			// System.out.println(localnode.getBitki().getAd�());
			inorder.add("D�zey: " + d�zey + "Bitki Ad�: "
					+ localnode.getBitki().getAd�() + "\n");
			inOrder(localnode.getRight_node(), d�zey);
		}
	}

	// Agac�n postOrder Dolas�lmas�
	public void postOrder(Node localnode, int d�zey) {
		if (localnode != null) {
			postOrder(localnode.getLeft_node(), d�zey);
			postOrder(localnode.getRight_node(), d�zey);
			// System.out.println(localnode.getBitki().getAd�());
			postorder.add("D�zey: " + d�zey + "Bitki Ad�: "
					+ localnode.getBitki().getAd�() + "\n");
		}
	}

	// D�zey listeleme
	public void d�zey_listele(Node localnode) {

	}

	public String preOrder_yazd�r() {
		String metin = "";
		for (int i = 0; i < preorder.size(); i++) {
			metin += preorder.elementAt(i);
		}
		return metin;
	}

	public String inOrder_yazd�r() {
		String metin = "";
		for (int i = 0; i < inorder.size(); i++) {
			metin += inorder.elementAt(i);
		}
		return metin;
	}

	public String postOrder_yazd�r() {
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
} // class A�a�

