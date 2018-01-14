import java.util.Hashtable;

public class Hash_Table_Harfler {
	private Hashtable<String, Harf> hash_harfler;

	public Hash_Table_Harfler() {
		setHash_harfler(new Hashtable<String, Harf>());
	}

	public Hashtable<String, Harf> getHash_harfler() {
		return hash_harfler;
	}

	public void setHash_harfler(Hashtable<String, Harf> hash_harfler) {
		this.hash_harfler = hash_harfler;
	}
}
