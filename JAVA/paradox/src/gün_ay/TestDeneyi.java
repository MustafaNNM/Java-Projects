package g�n_ay;

public class TestDeneyi {
	private static Deneyler �ak��ma_deneyleri;

	public static void main(final String[] args) {
		// 4 t�rde deneyi 10'ar defa yapt�ran metot
		set�ak��ma_deneyleri(new Deneyler());
	}

	@SuppressWarnings("unused")
	private static Deneyler get�ak��ma_deneyleri() {
		return �ak��ma_deneyleri;
	}

	private static void set�ak��ma_deneyleri(Deneyler �ak��ma_deneyleri) {
		TestDeneyi.�ak��ma_deneyleri = �ak��ma_deneyleri;
	}

}
