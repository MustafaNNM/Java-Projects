package tek_gi�e;

public class �nceliksiz_Sistem {
	private Banka �nceliksiz_Banka;

	public �nceliksiz_Sistem(int n) {
		set�nceliksiz_Banka(new Banka(n));
	}

	public Banka get�nceliksiz_Banka() {
		return �nceliksiz_Banka;
	}

	public void set�nceliksiz_Banka(Banka �nceliksiz_Banka) {
		this.�nceliksiz_Banka = �nceliksiz_Banka;
	}

}
