public class Test {

	private static Ýþletme restoran;

	public static void main(String[] args) {
		// Yeni bir iþletme kuruluyor
		setRestoran(new Ýþletme());
		int yerleþemeyenler=restoran.masalarý_yerleþtir();
		System.out.println("Yerleþemeyen müþteri sayýsý: "+yerleþemeyenler);
	}

	public static Ýþletme getRestoran() {
		return restoran;
	}

	public static void setRestoran(Ýþletme restoran) {
		Test.restoran = restoran;
	}

}
