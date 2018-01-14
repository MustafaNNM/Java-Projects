public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String metin = "1234567890*-üðpoýuytrewqasdfghjklþi.çömnbvcxz<zxcvbnmöç.,iþlkjhgfdsaqwertyuýopðü1234567890*-üðpoýuytrewqasdfghjklþi.çömnbvcxz<zxcvbnmöç.,iþlkjhgfdsaqwertyuýopðü";
		hufman huffman = new hufman();
		for (int i = 0; i < metin.length(); i++) {
			huffman.harfi_ekle("" + metin.charAt(i));
		}
		huffman.vektöre_aktar();
		huffman.aðaç_oluþtur();
		System.out.println("\n\n" + "Encoding\n");
		huffman.encoding(huffman.nodes.peek(), "");
		//System.out.println("\n\n" + "Encoded Harfler");//dosyaya yazýlmasý gerek 
		//System.out.println(huffman.harfler_encoded + "\n\n");
		huffman.þifrele(metin);
		System.out.println("\n\n" + "Decoding");
		huffman.decoding(huffman.nodes.peek(), "");
		System.out.println("\n\n" + "Decoded");
		System.out.println(huffman.harfler_decoded);
		//Þifreledikten sonra sifrelenmiþ harflere göre aðaç oluþturmak gerekiyor
		huffman.þifre_çöz();
		System.out.println("Encoded Metin");//dosyaya yazýlmasý gerek
		System.out.println(huffman.encoded);
		System.out.println("Decoded String");//dosyaya yazýlmasý gerek 
		System.out.println(huffman.decoded + "\n\n");
		
	}
}
