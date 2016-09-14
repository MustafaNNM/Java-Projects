package test;

import java.io.IOException;

import veri_taban�.Bitki_veri_taban�;
import a�a�.A�a�;
import a�a�.Node;

public class Test_A�a� {

	public static void main(String[] args) throws IOException {

		Bitki_veri_taban� datebase;
		datebase = new Bitki_veri_taban�("bitki.txt");

		A�a� tree = new A�a�();
		Node newyeninode = new Node(null);
		for(int i=0;i<datebase.getBitkiler().size();i++){
			newyeninode = new Node(datebase.getBitkiler().elementAt(i));
			tree.insert(newyeninode);	
		}
		
		tree.find(tree.node,"51");
		System.out.println("pre");
		tree.preOrder(tree.getNode(), 0);
		System.out.println("in");
		tree.inOrder(tree.getNode(), 0);
		System.out.println("post");
		tree.postOrder(tree.getNode(), 0);
		//String aranan = "51";
		/*
		 * System.out.println("Aranan" + aranan); tree.find(tree.node, aranan);
		 * //tree.remove("51"); tree.find(tree.node, aranan);
		 * System.out.println("pre"); tree.preOrder(tree.getNode(),0);
		 * System.out.println("in"); tree.inOrder(tree.getNode(),0);
		 * System.out.println("post"); tree.postOrder(tree.getNode(),0);
		 * tree.find(tree.node, aranan); System.out.println("pre");
		 * tree.preOrder(tree.getNode(),0); System.out.println("in");
		 * tree.inOrder(tree.getNode(),0); System.out.println("post");
		 * tree.postOrder(tree.getNode(),0); aranan = "51";
		 * System.out.println("Aranan" + aranan); tree.find(tree.node, aranan);
		 * //tree.remove(aranan); tree.find(tree.node, aranan); aranan = "57";
		 * System.out.println("Aranan" + aranan); tree.find(tree.node, aranan);
		 * //tree.remove(aranan); tree.find(tree.node, aranan); aranan = "58";
		 * System.out.println("Aranan" + aranan); tree.find(tree.node, aranan);
		 * //tree.remove(aranan); tree.find(tree.node, aranan); aranan = "55";
		 * System.out.println("Aranan" + aranan); tree.find(tree.node, aranan);
		 * //tree.remove(aranan); tree.find(tree.node, aranan); aranan = "65";
		 * System.out.println("Aranan" + aranan); tree.find(tree.node, aranan);
		 * //tree.remove(aranan); tree.find(tree.node, aranan);
		 * System.out.println("pre"); tree.preOrder(tree.getNode(),0);
		 * System.out.println("in"); tree.inOrder(tree.getNode(),0);
		 * System.out.println("post");
		 */
		//System.out.println(datebase.getBitkiler().elementAt(0).toString());
		// datebase.getBitkiler().add(tree.getNode().getBitki());
		//datebase.update_file();
	}
}
