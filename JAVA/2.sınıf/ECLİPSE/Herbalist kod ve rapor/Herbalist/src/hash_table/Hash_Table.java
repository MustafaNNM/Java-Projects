package hash_table;

import java.util.Hashtable;
import java.util.Vector;

import dert.Hastal�k;

public class Hash_Table {
	private Hashtable<String, Hastal�k> hash;

	// �rnek 46 Mara�

	public Hash_Table(Vector<Hastal�k> hastal�klar) {
		hash= new Hashtable<String, Hastal�k>();
		for (final Hastal�k hastal�k : hastal�klar) {
			hash.put(hastal�k.getAd�(), hastal�k);
			// System.out.println(kisi.yazdir2() + "*******");
		}
	}

	public Hashtable<String, Hastal�k> getHash() {
		return hash;
	}

	public void setHash(Hashtable<String, Hastal�k> hash) {
		this.hash = hash;
	}

	public String hastal�k_hash_table_de_var_m�(String hastal�k_ad�) {
		String yan�t = "";
		
		if(hash.get(hastal�k_ad�)!=null){ 
		yan�t="Bulundu";
		}
		yan�t="Bulunamad�";
		return yan�t;
	}

	public String hastal�k_toString(String hastal�k_ad�) {
		String yan�t = "";
		yan�t = hastal�k_hash_table_de_var_m�(hastal�k_ad�);

		if (yan�t.compareTo("Bulundu") == 0) {
			Hastal�k hastal�k = hash.get(hastal�k_ad�);
			yan�t = hastal�k.toString();
			return yan�t;
		} else {
			System.out.println("Bulunamad�\n");
		}
		return yan�t;
	}
}
