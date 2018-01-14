/*
 * Created on 07.Mar.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author cenk
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TestOgrenci2 {

	public static void main(String[] args) {
		LisansustuOgrenci luogr =
			new LisansustuOgrenci(
				5555,
				"can",
				"tuna",
				"buca",
				"nesneye dayali programlama",
				"erdur");
		luogr.kitap_oku();
		luogr.kitap_oku();
		luogr.kimlik_yaz();
	}
}
