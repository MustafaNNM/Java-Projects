package g�n_ay_y�l;

public class Random {

	public int random(int mod) {
		int say� = (int) (Math.random() * 1000 % mod);// [0-(mod-1)] aras�nda
														// say� �retir
		return say�;
	}
}
