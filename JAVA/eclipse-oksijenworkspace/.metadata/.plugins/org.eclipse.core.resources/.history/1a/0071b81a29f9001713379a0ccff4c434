import java.util.*;

public class Proje2 {
	
	public static void main(String[] Args){	
		int m,n;
		do{
			System.out.println("m degerini (balon sayisini) giriniz:");
			Scanner str1 = new Scanner(System.in);
			m = str1.nextInt();
		}while(m<=0);
		do{
			System.out.println("n degerini (kac balonda bir patlatma isleminin yapilacagini) giriniz:");
			Scanner str2 = new Scanner(System.in);
			n = str2.nextInt();
		}while(n<=0);
		//girdiler alindi.
		
		Stack<BListe> yigit = new Stack<BListe>(); //yigit olusturuldu.
		
		int sayac1=1;
		int	sayac2=1;
		int katNo=1;
		
		while(sayac1<=m){
			BListe gecici = new BListe(katNo);
			System.out.println("\n"+katNo+". kattaki listedeki balonlar:");
			sayac2=1;
			while(sayac2<=10 && sayac1<=m){	
				gecici.Ekle(sayac1);
				sayac1++;
				sayac2++;
			}
			gecici.yazdir();
			yigit.push(gecici);
			katNo++;
			//kucuk dongude her bir liste 10 eleman sayisina ulasinca o anki liste
			//yigita atýlýr, kat no artýrýlýp
			//dongunun basina donulup yeni katin listesi olusturulur.
			
		}
		
		System.out.println("----------------------------------------------------------------------------");
		
		int problemSayisi=0;	//cozulen problemleri saymak icin
		long zaman;				//problemlerin cozuldugu aralikta gecen zaman
		final long baslangic = System.currentTimeMillis();	//sistem saati degeri milisaniye olarak alindi.
		while(!yigit.empty()){
			BListe gecici = yigit.pop();
			gecici.patlat(n);
			problemSayisi++;
		}//yigit bosalana kadar her bir eleman gecici listeye atilip patlat metoduna maruz 
		//birakildi ve her bir liste bir balon problemi sayildi.
				
		final long bitis = System.currentTimeMillis();	//islem bitince sistem saatine bakildi.
		
		zaman=bitis-baslangic;
		if(zaman==0){
			System.out.println("Problemin cozum suresi, sistem saatinin algilayabilecegi kadar buyuk degil.");
		}
		else{
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("\n\n"+problemSayisi+" problem cozuldu.");
			System.out.println("1 adet problem yaklasik "+zaman/(long)problemSayisi+" milisaniyede cozuldu.");
			System.out.println("1 saniyede cozulebilecek balon problemi sayisi	= "+(long)1000*problemSayisi/zaman);
		}
	}
}
