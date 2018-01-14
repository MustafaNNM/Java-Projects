package hash_table;

import java.util.Hashtable;
import java.util.Vector;

import dert.Hastalık;

public class Hash_Table {
	private Hashtable<String, Hastalık> hash;

	// Örnek 46 Maraş

	public Hash_Table(Vector<Hastalık> hastalıklar) {
		hash= new Hashtable<String, Hastalık>();
		for (final Hastalık hastalık : hastalıklar) {
			hash.put(hastalık.getAdı(), hastalık);
			// System.out.println(kisi.yazdir2() + "*******");
		}
	}

	public Hashtable<String, Hastalık> getHash() {
		return hash;
	}

	public void setHash(Hashtable<String, Hastalık> hash) {
		this.hash = hash;
	}

	public String hastalık_hash_table_de_var_mı(String hastalık_adı) {
		if(hash.get(hastalık_adı)!=null){ 
			return "Bulundu";
		}else{
			return "Bulunamadı";	
		}
	}

	public String hastalık_toString(String hastalık_adı) {
		String yanıt = "";
		yanıt = hastalık_hash_table_de_var_mı(hastalık_adı);

		if (yanıt.compareTo("Bulundu") == 0) {
			Hastalık hastalık = hash.get(hastalık_adı);
			return hastalık.toString();
		} else {
			System.out.println("Bulunamadı\n");
			return yanıt;
		}
	}
}
