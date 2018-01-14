package tek_gişe;

public class Önceliksiz_Sistem {
	private Banka önceliksiz_Banka;

	public Önceliksiz_Sistem(int n) {
		setÖnceliksiz_Banka(new Banka(n));
	}

	public Banka getÖnceliksiz_Banka() {
		return önceliksiz_Banka;
	}

	public void setÖnceliksiz_Banka(Banka önceliksiz_Banka) {
		this.önceliksiz_Banka = önceliksiz_Banka;
	}

}
