
public class Test {

	private static OddNumbers teksay�lar;
	private static Series it;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		setTeksay�lar(new OddNumbers());
		getTeksay�lar().setStart(99);
		getTeksay�lar().create_numbers();
		it = getTeksay�lar();
		for(int i=0;i<getTeksay�lar().getTekSay�larListesi().size();i++){
		System.out.println(it.getNext());
		//interface kullan�larak
		}
		//System.out.println("####\n"+teksay�lar.toString());
		//normal yontemle yazd�r�lmas�
	}

	public static void setTeksay�lar(OddNumbers teksay�lar) {
		Test.teksay�lar = teksay�lar;
	}

	public static OddNumbers getTeksay�lar() {
		return teksay�lar;
	}

}
