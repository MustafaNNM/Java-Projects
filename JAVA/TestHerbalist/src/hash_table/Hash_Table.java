package hash_table;

import java.util.Hashtable;
import java.util.Vector;

import dert.Hastalik;

public class Hash_Table {
	private Hashtable<String, Hastalik> hash;

	// Ornek 46 Maras

	public Hash_Table(Vector<Hastalik> hastaliklar) {
		hash= new Hashtable<String, Hastalik>();
		for (final Hastalik hastalik : hastaliklar) {
			hash.put(hastalik.getAdi(), hastalik);
			// System.out.println(kisi.yazdir2() + "*******");
		}
	}

	public Hashtable<String, Hastalik> getHash() {
		return hash;
	}

	public void setHash(Hashtable<String, Hastalik> hash) {
		this.hash = hash;
	}

	public String hastalik_hash_table_de_var_mi(String hastalik_adi) {
		String yanit = "";
		
		if(hash.get(hastalik_adi)!=null){ 
		yanit="Bulundu";
		}
		yanit="Bulunamadi";
		return yanit;
	}

	public String hastalik_toString(String hastalik_adi) {
		String yanit = "";
		yanit = hastalik_hash_table_de_var_mi(hastalik_adi);

		if (yanit.compareTo("Bulundu") == 0) {
			Hastalik hastalik = hash.get(hastalik_adi);
			yanit = hastalik.toString();
			return yanit;
		} else {
			System.out.println("Bulunamadi\n");
		}
		return yanit;
	}
}
