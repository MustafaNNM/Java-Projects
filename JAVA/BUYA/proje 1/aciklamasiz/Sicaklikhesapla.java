import javax.swing.JOptionPane;


public class Sicaklikhesapla {
	
	private int n;
	//private static final String	aylarDosyasý="aylar.txt";
	private static Ay[] aylar;
	private static int aysayisi;
	
	public Sicaklikhesapla(){
		getN();		
		//aylar	=new Ay[aysayisi];
		int aygunsayi[]={31,28,31,30,31,30,31,31,30,31,30,31};
		int k=n;
		int ay=0,AyinSonGun=0;
		while(k>0)
		{
			AyinSonGun=0;
			for(int i=0;i<aygunsayi[ay] && k>0;i++)
			{
				k--;
				AyinSonGun++;				
			}
			ay++;
		}
		setAysayisi(ay);
		aylar	=new Ay[aysayisi];
		System.out.println(aysayisi);
		for(int i=0;i<aysayisi;i++){
			int month=aygunsayi[i];
			if(i==aysayisi-1)
				aylar[i]=new Ay(AyinSonGun,i);
			else
				aylar[i]=new Ay(month,i);
		}
		/*
		try {
			readAylar();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,aylarDosyasý+" kayip !");
		}
		*/
		
		printAylar();
	}
	
	
	private void printAylar() {
		String Aylar[]={"Ocak","Subat","Mart","Nisan","Mayis","Haziran","Temmuz","Agustos",
				"Eylul","Ekim","Kasim","Aralik"};
		for(int i=0;i<aysayisi;i++){
			System.out.println(Aylar[i]);
			for(int j=0;j<aylar[i].max;j++){
				System.out.println(aylar[i].sicakliklar[j]+" "+(aylar[i].deger+1));
			}
		}
	}

	private void setAysayisi(int sayi)
	{
		aysayisi=sayi;
	}

	private void getN() {
		n=Integer.parseInt(JOptionPane.showInputDialog("Gün Sayisi:"));
	}
	
	private static void StandardSapmaListele() {
		double[] ortalama=new double[aysayisi];
		double sum=0;
		double Std=0;
		
		String Aylar[]={"Ocak","Subat","Mart","Nisan","Mayis","Haziran","Temmuz","Agustos",
				"Eylul","Ekim","Kasim","Aralik"};
		for(int j=0;j<aysayisi;j++){
			
		
		for(int i=0;i<aylar[j].max;i++)
		{
			ortalama[j]+=aylar[j].sicakliklar[i];
		}
		for(int i=0;i<aylar[j].max;i++)
			sum+=Math.pow((aylar[j].sicakliklar[i]-(ortalama[j]/aylar[j].max)),2);
		Std=Math.sqrt(sum/aylar[j].max);
		
		System.out.println(Aylar[j]+" "+(int)ortalama[j]/aylar[j].max+" std:"+Std);
		sum=0;
		
		}
		
		
		
	}


	public static void main(String[] args) {
		new Sicaklikhesapla();
		StandardSapmaListele();
		
	}


	
	
	
}
