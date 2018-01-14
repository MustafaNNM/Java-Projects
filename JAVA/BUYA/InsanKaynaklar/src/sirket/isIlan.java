package sirket;

import Heap.Heap;

public class isIlan {
	private String isTanimi;
	private String elemanOzellikleri;
	Heap ilanHeap;
	public isIlan(String isTanimi,String elemanOzellikleri)
	{
		this.setIsTanimi(isTanimi);
		this.elemanOzellikleri=elemanOzellikleri;
		ilanHeap=new Heap();
		
	}
	public isIlan()
	{
		ilanHeap=new Heap();
		
	}
	
	public void displayIlan()
	{
		System.out.println("Is tanimi:"+isTanimi+"\nEleman ozellikleri:"+elemanOzellikleri);
		
	}
	

	
	public void setIsTanimi(String isTanimi) {
		this.isTanimi = isTanimi;
	}
	public String getIsTanimi() {
		return isTanimi;
	}
	public String getElemanOzellikleri() {
		return elemanOzellikleri;
	}
	public void setElemanOzellikleri(String elemanOzellikleri) {
		this.elemanOzellikleri = elemanOzellikleri;
	}
	public Heap getIlanHeap() {
		return ilanHeap;
	}
	public void setIlanHeap(Heap ilanHeap) {
		this.ilanHeap = ilanHeap;
	}
	

}
