public class MemurTest {
	public static void main (String args[]) {
		Otomobil o1=new Otomobil("WW","06ABC07",2003);
		Memur m1=new Memur("Ahmet", "Demir", 500356, o1);
		m1.ekranaYaz();
		//veya
		System.out.println("Memur Bilgileri:\n\n"+m1+"\n");
	}
}