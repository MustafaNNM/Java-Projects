
public class Test {

	private static OddNumbers teksayılar;
	private static Series it;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		setTeksayılar(new OddNumbers());
		getTeksayılar().setStart(99);
		getTeksayılar().create_numbers();
		it = getTeksayılar();
		for(int i=0;i<getTeksayılar().getTekSayılarListesi().size();i++){
		System.out.println(it.getNext());
		//interface kullanılarak
		}
		//System.out.println("####\n"+teksayılar.toString());
		//normal yontemle yazdırılması
	}

	public static void setTeksayılar(OddNumbers teksayılar) {
		Test.teksayılar = teksayılar;
	}

	public static OddNumbers getTeksayılar() {
		return teksayılar;
	}

}
