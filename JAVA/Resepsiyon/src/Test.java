public class Test {

	private static ��letme restoran;

	public static void main(String[] args) {
		// Yeni bir i�letme kuruluyor
		setRestoran(new ��letme());
		int yerle�emeyenler=restoran.masalar�_yerle�tir();
		System.out.println("Yerle�emeyen m��teri say�s�: "+yerle�emeyenler);
	}

	public static ��letme getRestoran() {
		return restoran;
	}

	public static void setRestoran(��letme restoran) {
		Test.restoran = restoran;
	}

}
