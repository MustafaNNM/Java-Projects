import javax.swing.JOptionPane;


public class Sicaklikhesapla {
	
	private int n;
	private static Ay[] aylar;
	private static int aysayisi;
	
	public Sicaklikhesapla(){
		getN();		
		int aygunsayi[]={31,28,31,30,31,30,31,31,30,31,30,31};
		int k=n;
		int ay=0,AyinSonGun=0;
		while(k>0)									//while dongusu kullanicidan verilen degeri(k)
		{											//sayarak ay ve gunleri belirler aygunsayi dizide
			AyinSonGun=0;							//tutar.
			for(int i=0;i<aygunsayi[ay] && k>0;i++) // kac ay kac gun oldugunu ogrenince
			{										// buldugumuz gun kadar random sicaklik uretilir
				k--;
				AyinSonGun++;				//son ayin gunleri sayiyor
			}
			ay++;
		}
		setAysayisi(ay);
		aylar	=new Ay[aysayisi]; //ay sayisi belirlendikten sonra toplam ay sayina esit boyutta dizi yaratiyor
		
		for(int i=0;i<aysayisi;i++){   //for dongude her ayin nesneleri yaratilip ilk degerler ataniyor
			int month=aygunsayi[i];
			if(i==aysayisi-1)
				aylar[i]=new Ay(AyinSonGun,i);  //son ayin gun sayisi ayi tamlamayabilir
			else								// onun icin AyinSonGun degiskeni max olarak ilkliyor
				aylar[i]=new Ay(month,i);
		}
		
		
		printAylar(); //ekrana sicaklik degerleri 1 ocaktan baslayak yazar !!!test icindir!!!
	}
	
	
	private void printAylar() {// test icin! sicaklik degerleri aylik olarak hepsini yazar.
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
		aysayisi=sayi;	//setter metot aysayisi degisken icin
	}

	private void getN() {	//kullanicidan giris olarak gun sayisini alir
		n=Integer.parseInt(JOptionPane.showInputDialog("Gün Sayisi:"));
	}
	
	private static void StandardSapmaListele() {	//standart sapmayi hesaplar ve ekrana yazar
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
			for(int i=0;i<aylar[j].max;i++) //standart sampa hesaplaniyor
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
