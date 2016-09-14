package agaclar;

import java.util.Vector;
import agac.Agac;

public class Vector_Agac {
	private Vector<Agac> agaclar;
	private int aranan_urun_hangi_kategoride_bulundu;

	public Vector_Agac(int kategori_cesidi) {
		setAgaclar(new Vector<Agac>());
		agaclar.setSize(kategori_cesidi);
		for (int i = 0; i < kategori_cesidi; i++) {
			agaclar.set(i, new Agac());
		}
	}

	public Vector<Agac> getAgaclar() {
		return agaclar;
	}

	public void setAgaclar(Vector<Agac> agaclar) {
		this.agaclar = agaclar;
	}
	
	public String find(String data){
		String yanit="";
		for(int i=0;i<agaclar.size();i++){
			yanit=agaclar.elementAt(i).find(agaclar.elementAt(i).getNode(), data);
			if(yanit.compareTo("Bulunamadi")!=0){
				//Bulunduysa diğer kategorilerde arama yapmaya gerek yok
				setAranan_urun_hangi_kategoride_bulundu(i);
				return yanit;
			}
		}
		return yanit;
	}

	public void setAranan_urun_hangi_kategoride_bulundu(
			int aranan_urun_hangi_kategoride_bulundu) {
		this.aranan_urun_hangi_kategoride_bulundu = aranan_urun_hangi_kategoride_bulundu;
	}

	public int getAranan_urun_hangi_kategoride_bulundu() {
		return aranan_urun_hangi_kategoride_bulundu;
	}
	
}
