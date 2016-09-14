package Heap;

import java.util.Vector;

public class Heap {
	public Vector<Node> heap;
	private int currentSize;
	
	public Heap(){
		currentSize=0;
		heap=new Vector<Node>();
		
	}
		
	public boolean isEmpty()
	{
		return currentSize==0;		
	}
	
	public int insert(double key)
	{
		Node newNode=new Node(key);
		heap.add(currentSize, newNode);
		trickleUp(currentSize++);
		return currentSize;
	}
	
	public void trickleUp(int index)
	{
		int parent=(index-1)/2;
		Node bottom=heap.elementAt(index);
		while(index>0 && heap.elementAt(parent).getKey()<bottom.getKey())
		{
			
			heap.insertElementAt(heap.elementAt(parent), index);
			index=parent;
			parent=(parent-1)/2;
		}
		heap.insertElementAt(bottom,index);
	}
	
		
	public Node remove()
	{
		Node root=heap.elementAt(0);
		heap.remove(0);
		trickleDown(0);
		return root;
	}
	
	public void trickleDown(int index)
	{
		int largerChild;
		Node top=heap.elementAt(index);
		while(index<currentSize/2)//while node has at
								//least one child
		{
			int leftChild=2*index+1;
			int rightChild=leftChild+1;
									//find larger child
			if(rightChild<currentSize && heap.elementAt(leftChild).getKey()<
					heap.elementAt(rightChild).getKey())
				largerChild=rightChild;
			else
				largerChild=leftChild;
										//top >=largerChild?
			if(top.getKey()>=heap.elementAt(rightChild).getKey())
				break;
										//shift child up
			heap.insertElementAt(heap.elementAt(largerChild),index);
			index=largerChild;			//go down
			
		}
		heap.insertElementAt(top, index);		//root to index
		
	}
	public boolean change(int index, int newValue)
	{
		if(index<0 && index>=currentSize)
			return false;
		double oldValue=heap.elementAt(index).getKey();
		heap.elementAt(index).setKey(newValue);
		if(oldValue<newValue)
			trickleUp(index);
		else
			trickleDown(index);
		return true;
	}
	public void displayHeap()
	{
		System.out.print("Heap array:");
		for(int m=0; m<currentSize; m++)
			if(heap.elementAt(m)!=null)
				System.out.print(heap.elementAt(m).getKey()+" ");
			else
				System.out.print("--");
		System.out.println();
		
		int nBlanks=32;
		int itemsPerRow=1;
		int column=0;
		int j=0;
		String dots="................................";
		System.out.println(dots+dots);
		while(currentSize>0)
		{
			if(column==0)
				for(int k=0; k<nBlanks; k++)
					System.out.print(' ');
			System.out.print(heap.elementAt(j).getKey());
			if(++j==currentSize)
				break;
			if(++column==itemsPerRow)
			{
				nBlanks/=2;
				itemsPerRow*=2;
				column=0;
				System.out.println();

			}
			else
				for(int k=0; k<nBlanks*2-2; k++)
					System.out.print(' ');
					


			
		}

		System.out.println("\n"+dots+dots);


	}
	
	

}


