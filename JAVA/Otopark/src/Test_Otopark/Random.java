package Test_Otopark;
public class Random {

	public static int random(int mod) {
		int sayı = (int) (Math.random() * 1000 % mod);// [0-(mod-1)] arasında
														// sayı üretir
		return sayı;
	}
}
