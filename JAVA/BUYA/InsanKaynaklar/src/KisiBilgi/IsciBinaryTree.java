package KisiBilgi;

public class IsciBinaryTree {
	
	private IsciDugum root;
	private static int duzey=0;
	
	public IsciBinaryTree(){
		root=null;
	}
	
	public IsciDugum getRoot() {
		return root;
	}

	public void setRoot(IsciDugum root) {
		this.root = root;
	}
	

	public boolean isEmpty()
	    {
	        return root == null;
	    }
	   
	
	/**
	* Insert a new node
	**/
		public void insert(IsciDugum newNode)
		{
			root = insert(newNode, root);
		}
		
		/**
		* Internal method to insert into a subtree.
		**/
		private IsciDugum insert(IsciDugum newNode, IsciDugum current)
		{
			if( current == null ) // the node is null
			{
				current = newNode;
			}
			else if(newNode.getAdi().compareTo(current.getAdi())<0) // it is less than current
			{
				current.leftChild = insert(newNode,current.leftChild);
				if(height(current.leftChild) - height(current.rightChild) == 2) // there is an imbalance
				{
						if(newNode.getAdi().compareTo(current.leftChild.getAdi())<0 ) // see what kind of imbalance it is
						{
							current = rotateWithLeftChild(current);
						}
						else
						{
						current = doubleWithLeftChild(current);
						}
				}	
			}
			else if(newNode.getAdi().compareTo(current.getAdi()) >0 ) // it is greater than current
			{
				current.rightChild = insert(newNode,current.rightChild);
				if(height(current.rightChild) - height(current.leftChild) == 2) // there is an imbalance
				{
					if(newNode.getAdi().compareTo( current.rightChild.getAdi()) > 0) // see what kind of imbalance it is
					{
						current = rotateWithRightChild(current);
					}
					else
					{
						current = doubleWithRightChild(current);
					}
				}
			}
			current.height = Math.max(height(current.leftChild), height(current.rightChild)) + 1;
			return current;
			}

   
/***** ROTATION CODE *****/
	
	/**
	* Rotate binary tree node with left child.
	* For AVL trees, this is a single rotation for case 1.
	* Update heights, then return new root.
	**/
	private IsciDugum rotateWithLeftChild( IsciDugum k2 )
	{
		IsciDugum k1 = k2.leftChild;
		k2.leftChild = k1.rightChild;
		k1.rightChild = k2;
		k2.height = Math.max( height( k2.leftChild ), height( k2.rightChild ) ) + 1;
		k1.height = Math.max( height( k1.leftChild ), k2.height ) + 1;
		return k1;
	}

	/**
	* Rotate binary tree node with right child.
	* For AVL trees, this is a single rotation for case 4.
	* Update heights, then return new root.
	**/
	private IsciDugum rotateWithRightChild(IsciDugum k1 )
	{
		IsciDugum k2 = k1.rightChild;
		k1.rightChild = k2.leftChild;
		k2.leftChild = k1;
		k1.height = Math.max( height( k1.leftChild ), height( k1.rightChild ) ) + 1;
		k2.height = Math.max( height( k2.rightChild ), k1.height ) + 1;
		return k2;
	}

	/**
	* Double rotate binary tree node: first left child
	* with its right child; then node k3 with new left child.
	* For AVL trees, this is a double rotation for case 2.
	* Update heights, then return new root.
	**/
	private IsciDugum doubleWithLeftChild( IsciDugum k3 )
	{
		k3.leftChild = rotateWithRightChild( k3.leftChild );
		return rotateWithLeftChild( k3 );
	}

	/**
	* Double rotate binary tree node: first right child
	* with its left child; then node k1 with new right child.
	* For AVL trees, this is a double rotation for case 3.
	* Update heights, then return new root.
	**/
	private IsciDugum doubleWithRightChild( IsciDugum k1 )
	{
		k1.rightChild = rotateWithLeftChild( k1.rightChild );
		return rotateWithRightChild( k1 );
	}
	
	private IsciDugum getSuccessor(IsciDugum delNode) {
		IsciDugum successorParent = delNode;
		IsciDugum successor = delNode;
		IsciDugum current = delNode.rightChild;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
	
		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
/**
* Delete a node from AVL Tree
**/

	public void remove(String ad)
	{
		
	    root = remove(ad, root);
	    if(isEmpty())
		{
			System.out.println("Empty tree");
			return ;
		}
	    balanceRoot();
	}

/**
* Internal method to remove a number
**/

	public IsciDugum remove(String ad, IsciDugum node)
	{
	
		if( node == null)
		{
			System.out.println(ad+" Not found in AVL Tree\n");
			return null;
		}
		else
		{
	/**
	* search for delNum to be deleted
	**/
			if(ad.compareTo(node.getAdi()) >0)
			{
				node.rightChild = remove( ad, node.rightChild);
			}
			else if(ad.compareTo( node.getAdi())<0)
			{
				node.leftChild = remove( ad, node.leftChild);
			}
			
			/**
			* name found, delete if a descendant is null
			**/
			else if( node.leftChild == null)
			{
				node = node.rightChild;
			}
			else if( node.rightChild == null)
			{
				node = node.leftChild;
			}
			
			/**
			* no descendant is null, rotate on heavier side
			**/
			else if( height( node.leftChild ) < height( node.rightChild ))
			{
				node = rotateWithRightChild(node);
				IsciDugum successor=getSuccessor(node.leftChild);
				successor.leftChild=node.leftChild.leftChild;
				successor.height= Math.max(height(successor.leftChild), height(successor.rightChild)) + 1;
				node.leftChild=successor;
				
			}
			else
			{
				node = rotateWithLeftChild( node );
				IsciDugum successor=getSuccessor(node.rightChild);
				successor.leftChild=node.rightChild.leftChild;
				successor.height= Math.max(height(successor.leftChild), height(successor.rightChild)) + 1;
				node.rightChild=successor;		
				
			}
			
			
	/**
	* reconstruct weight information
	**/
			if( node != null )
				{
				node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
				}
		}
	return node;
	}



	public void balanceRoot()
	{
	
		if(height(root.leftChild) - height(root.rightChild) == 2) // there is an imbalance
		{
			if((height(root.leftChild.leftChild)-height(root.leftChild.rightChild))>=0 ) // see what kind of imbalance it is
			{
				root = rotateWithLeftChild(root);
			}
			else
			{
				root = doubleWithLeftChild(root);
			}
		}
		
		
		else if(height(root.rightChild) - height(root.leftChild) == 2) // there is an imbalance
		{
			if((height(root.rightChild.rightChild)-height(root.rightChild.leftChild))>=0 ) // see what kind of imbalance it is
			{
				root = rotateWithRightChild(root);
			}
			else
			{
				root = doubleWithRightChild(root);
			}
		}
		
		root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
		
	}
   
    public void preorder(IsciDugum localRoot)
    {
    	if(localRoot!=null)
    	{
    		duzey++;
    	System.out.println("Duzey:"+duzey+" Kisi ad:"+localRoot.getAdi());
        preorder(localRoot.leftChild);
        preorder(localRoot.rightChild);
        duzey--;
    	}
    }
   
    public void inorder(IsciDugum localRoot)
    {
    	if(localRoot!=null)
    	{
    		duzey++;
        inorder(localRoot.leftChild);
        System.out.println("Duzey:"+duzey+" Kisi ad:"+localRoot.getAdi());
        inorder(localRoot.rightChild);
        duzey--;
    	}
    }
    public void postorder(IsciDugum localRoot)
    {
    	if(localRoot!=null)
    	{
    		duzey++;
        postorder(localRoot.leftChild);
        postorder(localRoot.rightChild);
        System.out.println("Duzey:"+duzey+" Kisi ad:"+localRoot.getAdi());
        duzey--;
    	}
    }
    public IsciDugum bul(String input) {
    	IsciDugum a=agactanArama(root,input);
    	if(a==null)
    		System.out.println("kaydiniz bulunamadi\n");
    	return a;
    	
    }
    private IsciDugum agactanArama(IsciDugum localroot, String input) {
    	if(localroot==null)
    		return localroot;
		IsciDugum current=localroot;
		String a=current.getAdi();
		if(input.compareTo(a)==0)
		{
			return localroot;
		}
		IsciDugum b=agactanArama(localroot.leftChild, input);
		if(b==null)
		b=agactanArama(localroot.rightChild, input);
			return b;
	}
  
 	
    private static int height(IsciDugum current)
    {
    return current == null ? -1 : current.height;
    }
    
	public void ortalamaGoreListele(double ortalama,IsciDugum localRoot)
	{
		if(localRoot!=null)
    	{
				
				{	for(int i=0;i<localRoot.egitimDurumu.size();i++)
					if(localRoot.egitimDurumu.elementAt(i).getNotOrtalama()>ortalama)
					System.out.println(localRoot.getAdi()+", okulu:"+localRoot.egitimDurumu.get(i).getOkulAdi()+
							", ortamasi:"+localRoot.egitimDurumu.get(i).getNotOrtalama());
			        ortalamaGoreListele(ortalama, localRoot.leftChild);
			        ortalamaGoreListele(ortalama, localRoot.rightChild);}
    	}
		
	}
	
	public void yabanciDilBilen(String dil,IsciDugum localRoot)
	{
		if(localRoot!=null)	
		{
			if(dil.compareTo(localRoot.getYabanciDil())==0)
			{
				System.out.println(localRoot.getAdi());
			}
			yabanciDilBilen(dil, localRoot.leftChild);
			yabanciDilBilen(dil, localRoot.rightChild);
			
			
		}
	}

	public IsciDugum find(String adi)
	{
		IsciDugum current=root;
		
		int comparatorValue=adi.compareTo(current.getAdi());
		while(comparatorValue!=0)
		{
			if(comparatorValue<0)
				current=current.leftChild;
			else
				current=current.rightChild;
				
			if(current==null)
				return null;
					
			}
			return current;
	}
	
	

}