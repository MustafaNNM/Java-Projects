package ��_gi�e;

public class �nceliksiz_Sistem {
	//Bankalar s�n�f�na denk bir s�n�f
	//Bu s�n�fta gerekseydi Vector<Banka> kullan�labilirdi
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
