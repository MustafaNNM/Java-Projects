import java.util.Hashtable;


public class Hash_Table {
	
	private Hashtable<String, Node> hash;
	public	Hash_Table() {
		setHash(new Hashtable<String, Node>());
	}
	public Hashtable<String, Node> getHash() {
		return hash;
	}
	public void setHash(Hashtable<String, Node> hash) {
		this.hash = hash;
	}
}
