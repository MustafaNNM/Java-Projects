/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sinav;
import java.util.*;
import sun.nio.cs.Surrogate.Generator;
/**
 *
 * @author Tsogtgerel
 */
public class Main {

    public static void main(String[] args) {

        int OgrSayi;


        do{

        System.out.println("Ogrenci sayiyi 100-200 arasinda bir sayi giriniz:");
        Scanner DegerAl=new Scanner(System.in);
        OgrSayi=DegerAl.nextInt();
        if(OgrSayi<100  || OgrSayi>200)
            System.out.println("hatalı giris!");

    }while(OgrSayi<100  || OgrSayi>200);

        //System.out.println("Ogrenci sayi:"+OgrSayi);
        
        int[] SinifKapasite=new int[5];
        int Toplam=0;
        
            
        for(int i=0; i<5; i++){
            System.out.println((i+1)+":numarali sinif kapasitesini giriniz");

            Scanner KapasiteDeger=new Scanner(System.in);
            SinifKapasite[i]=KapasiteDeger.nextInt();
            Toplam+=SinifKapasite[i];
        }
        while(Toplam<OgrSayi)
        {Toplam=0;
        System.out.println("HATA! " +
                "Ogrenci sayisi sinif kapasiteyi astigi icin sinif kapasiteyi tekrar giriniz:");
         for(int i=0; i<5; i++){
            System.out.println(i+":numarali sinif kapasitesini giriniz");

            Scanner KapasiteDeger=new Scanner(System.in);
            SinifKapasite[i]=KapasiteDeger.nextInt();
            Toplam+=SinifKapasite[i];}
        System.out.println("T:"+Toplam);

        }
        for(int i=0; i<4; i++)
            for(int j=i+1; j<5; j++){
            if(SinifKapasite[i]>SinifKapasite[j])
            { int gecici;
            gecici= SinifKapasite[i];
            SinifKapasite[i]=SinifKapasite[j];
            SinifKapasite[j]=gecici;}
            }
        int SiradanToplam=0,DolduralacakSinifSayi;
        for( DolduralacakSinifSayi=0; OgrSayi>SiradanToplam; DolduralacakSinifSayi++)
            SiradanToplam+=SinifKapasite[DolduralacakSinifSayi];
        System.out.println("fsahnre:"+DolduralacakSinifSayi);
        int oran;
        oran=(OgrSayi*100)/SiradanToplam;
        System.out.println("Oran:"+oran);
        int[] SiniflaraAtama=new int[5];
        int toplam=0;
        for(int i=0; i<DolduralacakSinifSayi; i++)

        {
            SiniflaraAtama[i]=SinifKapasite[i]*oran/100;
            toplam+=SiniflaraAtama[i];

        }
        SiniflaraAtama[DolduralacakSinifSayi-1]=SiniflaraAtama[DolduralacakSinifSayi-1]
                +((OgrSayi-toplam));
        System.out.println( SiniflaraAtama[DolduralacakSinifSayi-1]);



//////////////////////////////////////////////////////////////////////////////////////////////////

        Ogrenci[] ogrenciler=new Ogrenci[OgrSayi];
        Random generator=new Random();
        int[] RandomIndex= new int[OgrSayi];
        //String[] RandomString=new String[10];
        for(int i=0; i<OgrSayi; i++){
                RandomIndex[i]=generator.nextInt(OgrSayi);
               // RandomString[i]=generator.

          //System.out.println(RandomIndex[i]);
        }
        ogrenciler[0].setOgrNo(RandomIndex[0]);
        System.out.println("Ogr Atanmissa"+ogrenciler[0].getOgrNo());



    
    }
}
