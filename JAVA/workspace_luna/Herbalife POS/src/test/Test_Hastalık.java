package test;

import veri_taban�.Hastal�k_veri_taban�;

public class Test_Hastal�k {
	private static Hastal�k_veri_taban� hastal�k_veri_taban�;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setHastal�k_veri_taban�(new Hastal�k_veri_taban�("hastal�k.txt"));
		System.out.println(hastal�k_veri_taban�.toString());
	}
	public static void setHastal�k_veri_taban�(Hastal�k_veri_taban� hastal�k_veri_taban�) {
		Test_Hastal�k.hastal�k_veri_taban� = hastal�k_veri_taban�;
	}
	public static Hastal�k_veri_taban� getHastal�k_veri_taban�() {
		return hastal�k_veri_taban�;
	}



}
