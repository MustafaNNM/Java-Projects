package needless;
public class Tree {
	private TreeNode root;

	public Tree() {
		root = null;
	}

	public TreeNode getRoot() {
		return root;
	}

	// Agacýn preOrder Dolasýlmasý
	public void preOrder(TreeNode localRoot) {
		if (localRoot != null) {
			localRoot.displayNode();
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	// Agacýn inOrder Dolasýlmasý
	public void inOrder(TreeNode localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			localRoot.displayNode();
			inOrder(localRoot.rightChild);
		}
	}

	// Agacýn postOrder Dolasýlmasý
	public void postOrder(TreeNode localRoot) {
		if (localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			localRoot.displayNode();
		}
	}

	// Agaca bir dügüm eklemeyi saglayan metot
	public void insert(Kisi yeni_kisi_verisi) {
		TreeNode newNode = new TreeNode();
		newNode.kisi_verisi = yeni_kisi_verisi;
		if (root == null)
			root = newNode;
		else {
			TreeNode current = root;
			TreeNode parent;

			while (true) {
				parent = current;
				if (0>=yeni_kisi_verisi.getAdý().compareTo(current.kisi_verisi.getAdý())) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		} // end else not root
	} // end insert()
	
	
} // class Tree
