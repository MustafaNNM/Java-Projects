package g�n_ay_y�l;

public class TestDeneyi {
	private static Deneyler �ak��ma_deneyleri;

	public static void main(String[] args) {
		// 4 t�rde deneyi 10'ar defa yapt�ran metot
		long startTime = System.currentTimeMillis();
		set�ak��ma_deneyleri(new Deneyler());
		long stopTime = System.currentTimeMillis();
		System.out.println("stopTime-startTime:" + (stopTime - startTime));// 100
																			// milis->1
																			// sn
	}

	public static Deneyler get�ak��ma_deneyleri() {
		return �ak��ma_deneyleri;
	}

	public static void set�ak��ma_deneyleri(Deneyler �ak��ma_deneyleri) {
		TestDeneyi.�ak��ma_deneyleri = �ak��ma_deneyleri;
	}

}
