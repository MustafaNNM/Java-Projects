package tek_gi�e;

public class �ncelikli_Sistem {
	//Bankalar s�n�f�na denk bir s�n�f
	//Bu s�n�fta gerekseydi Vector<Banka> kullan�labilirdi
	private Banka �ncelikli_Banka;

	public �ncelikli_Sistem(int n) {
		set�ncelikli_Banka(new Banka(n));
	}

	public Banka get�ncelikli_Banka() {
		return �ncelikli_Banka;
	}

	public void set�ncelikli_Banka(Banka �ncelikli_Banka) {
		this.�ncelikli_Banka = �ncelikli_Banka;
	}
}
