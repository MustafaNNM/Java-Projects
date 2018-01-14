package aðaçlar;

import java.util.Vector;

import aðaç.Aðaç;

public class Vector_Aðaç {
	private Vector<Aðaç> aðaçlar;
	private int aranan_ürün_hangi_kategoride_bulundu;

	public Vector_Aðaç(int kategori_çeþidi) {
		setAðaçlar(new Vector<Aðaç>());
		aðaçlar.setSize(kategori_çeþidi);
		for (int i = 0; i < kategori_çeþidi; i++) {
			aðaçlar.set(i, new Aðaç());
		}
	}

	public Vector<Aðaç> getAðaçlar() {
		return aðaçlar;
	}

	public void setAðaçlar(Vector<Aðaç> aðaçlar) {
		this.aðaçlar = aðaçlar;
	}
	
	public String find(String data){
		String yanýt="";
		for(int i=0;i<aðaçlar.size();i++){
			yanýt=aðaçlar.elementAt(i).find(aðaçlar.elementAt(i).getNode(), data);
			if(yanýt.compareTo("Bulunamadý")!=0){
				//Bulunduysa diðer kategorilerde arama yapmaya gerek yok
				setAranan_ürün_hangi_kategoride_bulundu(i);
				return yanýt;
			}
		}
		return yanýt;
	}

	public void setAranan_ürün_hangi_kategoride_bulundu(
			int aranan_ürün_hangi_kategoride_bulundu) {
		this.aranan_ürün_hangi_kategoride_bulundu = aranan_ürün_hangi_kategoride_bulundu;
	}

	public int getAranan_ürün_hangi_kategoride_bulundu() {
		return aranan_ürün_hangi_kategoride_bulundu;
	}
	
}
