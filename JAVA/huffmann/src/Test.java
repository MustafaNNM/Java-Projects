public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String metin = "1234567890*-��po�uytrewqasdfghjkl�i.��mnbvcxz<zxcvbnm��.,i�lkjhgfdsaqwertyu�op��1234567890*-��po�uytrewqasdfghjkl�i.��mnbvcxz<zxcvbnm��.,i�lkjhgfdsaqwertyu�op��";
		hufman huffman = new hufman();
		for (int i = 0; i < metin.length(); i++) {
			huffman.harfi_ekle("" + metin.charAt(i));
		}
		huffman.vekt�re_aktar();
		huffman.a�a�_olu�tur();
		System.out.println("\n\n" + "Encoding\n");
		huffman.encoding(huffman.nodes.peek(), "");
		//System.out.println("\n\n" + "Encoded Harfler");//dosyaya yaz�lmas� gerek 
		//System.out.println(huffman.harfler_encoded + "\n\n");
		huffman.�ifrele(metin);
		System.out.println("\n\n" + "Decoding");
		huffman.decoding(huffman.nodes.peek(), "");
		System.out.println("\n\n" + "Decoded");
		System.out.println(huffman.harfler_decoded);
		//�ifreledikten sonra sifrelenmi� harflere g�re a�a� olu�turmak gerekiyor
		huffman.�ifre_��z();
		System.out.println("Encoded Metin");//dosyaya yaz�lmas� gerek
		System.out.println(huffman.encoded);
		System.out.println("Decoded String");//dosyaya yaz�lmas� gerek 
		System.out.println(huffman.decoded + "\n\n");
		
	}
}
