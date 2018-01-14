package test;

import veri_tabanı.Hastalık_veri_tabanı;

public class Test_Hastalık {
	private static Hastalık_veri_tabanı hastalık_veri_tabanı;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setHastalık_veri_tabanı(new Hastalık_veri_tabanı("hastalık.txt"));
		System.out.println(hastalık_veri_tabanı.toString());
	}
	public static void setHastalık_veri_tabanı(Hastalık_veri_tabanı hastalık_veri_tabanı) {
		Test_Hastalık.hastalık_veri_tabanı = hastalık_veri_tabanı;
	}
	public static Hastalık_veri_tabanı getHastalık_veri_tabanı() {
		return hastalık_veri_tabanı;
	}



}
