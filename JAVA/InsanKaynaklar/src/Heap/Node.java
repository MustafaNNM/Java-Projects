package Heap;


import KisiBilgi.*;

public class Node {
	private double iseUygunlugu;
	private IsciDugum birIlanIliskinBasvurularinReferans;//ilgili dugume basvuranlarin referans
	
	public Node(double key){
		iseUygunlugu=key;
		
	}

	public double getKey() {
		return iseUygunlugu;
	}

	public void setKey(int iData) {
		this.iseUygunlugu = iData;
	}

	public IsciDugum getBirIlanIliskinBasvurularinReferans() {
		return birIlanIliskinBasvurularinReferans;
	}

	public void setBirIlanIliskinBasvurularinReferans(
			IsciDugum birIlanIliskinBasvurularinReferans) {
		this.birIlanIliskinBasvurularinReferans = birIlanIliskinBasvurularinReferans;
	}
	
	

}
