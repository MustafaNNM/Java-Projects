package Test_Otopark;
public class Random {

	public static int random(int mod) {
		int say� = (int) (Math.random() * 1000 % mod);// [0-(mod-1)] aras�nda
														// say� �retir
		return say�;
	}
}
