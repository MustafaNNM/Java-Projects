package test;

import veri_tabani.Hastalik_veri_tabani;

public class Test_Hastalik {
	private static Hastalik_veri_tabani hastalik_veri_tabani;

	public static void main(String[] args) {
		setHastalik_veri_tabani(new Hastalik_veri_tabani("hastalık.txt"));
		System.out.println(hastalik_veri_tabani.toString());
	}
	public static void setHastalik_veri_tabani(Hastalik_veri_tabani hastalik_veri_tabani) {
		Test_Hastalik.hastalik_veri_tabani = hastalik_veri_tabani;
	}
	public static Hastalik_veri_tabani getHastalik_veri_tabani() {
		return hastalik_veri_tabani;
	}



}
