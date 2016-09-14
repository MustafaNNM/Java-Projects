public class Memur {
	private String ad, soyad;
	private int sicilno;
	Otomobil oto;

	public Memur(String a, String s, int sno, Otomobil o) {
		ad=a;
		soyad=s;
		sicilno=sno;
		oto=o;
	}

	public String adOkuma() { return ad; }
	public String soyadOkuma() { return soyad; }
	public int sicilNoOkuma() { return sicilno; }
	public Otomobil otoOkuma() { return oto;}

	public void adAtama(String yeniad) { ad=yeniad;}
	public void soyadAtama(String yenisoyad) { soyad=yenisoyad;}
	public void sicilNoAtama(int yenisicilno) { sicilno=yenisicilno;}
	public void OtoAtama(Otomobil yenioto) { oto=yenioto;}

	public void ekranaYaz() {
		System.out.println("AD:" + ad + " SOYAD:" + soyad);
			System.out.println();
			 System.out.println("SICILNO:" + sicilno);
			 System.out.println();
			System.out.println("OTOMOBIL BILGILERI:");
			System.out.println();
			System.out.println(oto);
			System.out.println();
	}

	public String toString() {
		return "AD:" + ad + " SOYAD:" + soyad + "\n\nSICILNO:" + sicilno +
			"\n\nOTOMOBIL BILGILERI:\n\n" + oto;
	}
}
