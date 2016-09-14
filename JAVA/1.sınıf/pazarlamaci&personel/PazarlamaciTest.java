public class PazarlamaciTest {
	public static void main(String args[]) {
		Adres a1=new Adres("Bornova","Konak");
		Personel p1=new Personel(1001,"Ahmet Demir",a1,50);
		p1.bilgiListele();
		System.out.println("MAAS:");
		System.out.println(p1.maasHesapla(160));
		System.out.println();
		Adres a2=new Adres("Buca","Manisa");
		Pazarlamaci p2=new Pazarlamaci(1002,"Mehmet Tunc",a2,40,100,5);
		p2.bilgiListele();
		System.out.println("MAAS:");
		System.out.println(p2.maasHesapla(120));
		System.out.println();
	}
}