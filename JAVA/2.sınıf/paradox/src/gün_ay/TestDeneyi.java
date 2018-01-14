package gün_ay;

public class TestDeneyi {
	private static Deneyler çakışma_deneyleri;

	public static void main(final String[] args) {
		// 4 türde deneyi 10'ar defa yaptıran metot
		setÇakışma_deneyleri(new Deneyler());
	}

	@SuppressWarnings("unused")
	private static Deneyler getÇakışma_deneyleri() {
		return çakışma_deneyleri;
	}

	private static void setÇakışma_deneyleri(Deneyler çakışma_deneyleri) {
		TestDeneyi.çakışma_deneyleri = çakışma_deneyleri;
	}

}
