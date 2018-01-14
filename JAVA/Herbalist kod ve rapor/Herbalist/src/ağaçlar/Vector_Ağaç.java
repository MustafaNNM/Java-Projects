package a�a�lar;

import java.util.Vector;

import a�a�.A�a�;

public class Vector_A�a� {
	private Vector<A�a�> a�a�lar;
	private int aranan_�r�n_hangi_kategoride_bulundu;

	public Vector_A�a�(int kategori_�e�idi) {
		setA�a�lar(new Vector<A�a�>());
		a�a�lar.setSize(kategori_�e�idi);
		for (int i = 0; i < kategori_�e�idi; i++) {
			a�a�lar.set(i, new A�a�());
		}
	}

	public Vector<A�a�> getA�a�lar() {
		return a�a�lar;
	}

	public void setA�a�lar(Vector<A�a�> a�a�lar) {
		this.a�a�lar = a�a�lar;
	}
	
	public String find(String data){
		String yan�t="";
		for(int i=0;i<a�a�lar.size();i++){
			yan�t=a�a�lar.elementAt(i).find(a�a�lar.elementAt(i).getNode(), data);
			if(yan�t.compareTo("Bulunamad�")!=0){
				//Bulunduysa di�er kategorilerde arama yapmaya gerek yok
				setAranan_�r�n_hangi_kategoride_bulundu(i);
				return yan�t;
			}
		}
		return yan�t;
	}

	public void setAranan_�r�n_hangi_kategoride_bulundu(
			int aranan_�r�n_hangi_kategoride_bulundu) {
		this.aranan_�r�n_hangi_kategoride_bulundu = aranan_�r�n_hangi_kategoride_bulundu;
	}

	public int getAranan_�r�n_hangi_kategoride_bulundu() {
		return aranan_�r�n_hangi_kategoride_bulundu;
	}
	
}
