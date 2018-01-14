import java.util.Comparator;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Vector;

public class hufman {

	Hashtable<String, Node> hash = new Hashtable<String, Node>();
	Comparator<?> comparator = new NodeComparator();
	PriorityQueue<Node> nodes = new PriorityQueue<Node>(16,
			extracted(comparator));
	Vector<Harf> harfler = new Vector<Harf>();
	Hashtable<String, Harf> hash_harfler = new Hashtable<String, Harf>();
	String harfler_encoded = "", harfler_decoded = "", encoded = "",
			decoded = "";

	public void harfi_ekle(String ch) {

		if (hash.get(ch) == null) {
			// System.out.println(harf);
			Node node = new Node();
			node.setHarf(ch);
			hash.put(ch, node);
			Harf harf = new Harf();
			harf.harf = ch;
			harf.fre = 1;
			harfler.addElement(harf);
		} else {
			// System.out.println("Bulundu");
			hash.get(ch).setFre(hash.get(ch).getFre() + 1);
			// System.out.println(hash.get(ch).getHarf());
		}

	}

	@SuppressWarnings("unchecked")
	private static Comparator<? super Node> extracted(Comparator<?> comparator) {
		return (Comparator<? super Node>) comparator;
	}

	public void vektöre_aktar() {
		for (int i = 0; i < harfler.size(); i++) {
			nodes.add(hash.get(harfler.elementAt(i).harf));
		}
	}

	public void hash_aktar() {
		for (int i = 0; i < harfler.size(); i++) {
			hash_harfler.put(harfler.elementAt(i).harf, harfler.elementAt(i));
		}
	}

	public String vektör_toString() {
		String metin = "";
		int boyut = nodes.size();
		for (int i = 0; i < boyut; i++) {
			System.out.println("size: " + nodes.size());
			Node node = nodes.poll();
			metin += node.toString() + "\n";
		}
		return metin;
	}

	public void aðaç_oluþtur() {
		Node min1, min2, parent;
		int boyut = nodes.size();
		while (boyut > 1) {
			if (boyut > 1) {
				min1 = nodes.poll();
				min2 = nodes.poll();
				parent = new Node();
				parent.setHarf(min1.getHarf() + min2.getHarf());
				parent.setFre(min1.getFre() + min2.getFre());
				parent.setLeft_node(min1);
				parent.setRight_node(min2);
				nodes.add(parent);
			}
			boyut = nodes.size();
		}
	}

	// Agacýn preOrder Dolasýlmasý
	public void encoding(Node localnode, String code) {
		if (localnode != null) {
			if (localnode.getLeft_node() == null
					&& localnode.getRight_node() == null) {
				System.out.println(localnode.getHarf() + " Fre: "
						+ localnode.getFre() + " Code: " + code);
				System.out.flush();
				harfler_encoded += code;
				Harf harf = new Harf();
				harf.harf = localnode.getHarf();
				harf.code = code;
				hash_harfler.put(harf.harf, harf);
			}
			encoding(localnode.getLeft_node(), code + "0");
			encoding(localnode.getRight_node(), code + "1");
		}
	}

	public void þifrele(String code) {
		// hash_aktar();
		for (int i = 0; i < code.length(); i++) {
			encoded += "" + hash_harfler.get("" + code.charAt(i)).code;
		}
		//System.out.println("þifre\n" + encoded);
	}

	// Agacýn preOrder Dolasýlmasý
	public void decoding(Node localnode, String code) {
		if (localnode != null) {
			if (localnode.getLeft_node() == null
					&& localnode.getRight_node() == null) {
				System.out.println("Code: " + code+" = "+localnode.getHarf());
				harfler_decoded += "Code: " + code+" = "+localnode.getHarf()
						+ "\n";
			}
			decoding(localnode.getLeft_node(), code + "0");
			decoding(localnode.getRight_node(), code + "1");
		}
	}

	public void þifre_çöz() {
		for (int i = 0; i < encoded.length(); i++) {
			harfi_bul(nodes.peek());
		}
	}

	int sýradaki_harf;

	public void harfi_bul(Node localnode) {
		int bulundu = 0;
		if (localnode != null) {
			if (localnode.getLeft_node() == null
					&& localnode.getRight_node() == null) {
				//System.out.println(localnode.getHarf());
				decoded += localnode.getHarf();
				bulundu = 1;
			}
			if (bulundu == 1) {
				return;
			}
			if (sýradaki_harf == encoded.length()) {
				return;
			}
			String binary = "" + encoded.charAt(sýradaki_harf);
			sýradaki_harf++;
			if (binary.compareTo("0") == 0) {
				harfi_bul(localnode.getLeft_node());
			} else {
				harfi_bul(localnode.getRight_node());
			}
		}
	}

}
