package tek_gişe;

public class Öncelikli_Sistem {
	//Bankalar sınıfına denk bir sınıf
	//Bu sınıfta gerekseydi Vector<Banka> kullanılabilirdi
	private Banka öncelikli_Banka;

	public Öncelikli_Sistem(int n) {
		setÖncelikli_Banka(new Banka(n));
	}

	public Banka getÖncelikli_Banka() {
		return öncelikli_Banka;
	}

	public void setÖncelikli_Banka(Banka öncelikli_Banka) {
		this.öncelikli_Banka = öncelikli_Banka;
	}
}
