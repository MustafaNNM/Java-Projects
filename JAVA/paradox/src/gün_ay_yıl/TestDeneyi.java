package gün_ay_yıl;

public class TestDeneyi {
	private static Deneyler çakışma_deneyleri;

	public static void main(String[] args) {
		// 4 türde deneyi 10'ar defa yaptıran metot
		long startTime = System.currentTimeMillis();
		setÇakışma_deneyleri(new Deneyler());
		long stopTime = System.currentTimeMillis();
		System.out.println("stopTime-startTime:" + (stopTime - startTime));// 100
																			// milis->1
																			// sn
	}

	public static Deneyler getÇakışma_deneyleri() {
		return çakışma_deneyleri;
	}

	public static void setÇakışma_deneyleri(Deneyler çakışma_deneyleri) {
		TestDeneyi.çakışma_deneyleri = çakışma_deneyleri;
	}

}
