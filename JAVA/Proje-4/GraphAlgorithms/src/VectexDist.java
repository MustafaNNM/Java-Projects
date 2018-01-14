class VertexDist implements Comparable{
	
	int value;
	int index;
	
	public VertexDist(int val, int ind){
		value = val;
		index = ind;	
	}

	@Override
	public int compareTo(Object o) {
		if(value > ((VertexDist)o).value)
			return 1;
		if(value < ((VertexDist)o).value)
			return -1;
		return 0;
	}
	
}