/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sinav;
import java.util.*;
/**
 *
 * @author Tsogtgerel
 */
public class Main {

    public static void main(String[] args) {
/////////////////////////////////////////////////////////////////////////////
        int OgrSayi;


        do{

        System.out.println("Ogrenci sayiyi 100-200 arasinda bir sayi giriniz:");
        Scanner DegerAl=new Scanner(System.in);
        OgrSayi=DegerAl.nextInt();
        if(OgrSayi<100  || OgrSayi>200)
            System.out.println("hatalı giris!");

    }while(OgrSayi<100  || OgrSayi>200);

        //System.out.println("Ogrenci sayi:"+OgrSayi);



        //////////////////////////////////////////////////////////////////////
        
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



        //////////////////////////////////////////////////
        for(int i=0; i<4; i++)
            for(int j=i+1; j<5; j++){
            if(SinifKapasite[i]>SinifKapasite[j])
            { int gecici;
            gecici= SinifKapasite[i];
            SinifKapasite[i]=SinifKapasite[j];
            SinifKapasite[j]=gecici;}
            }


        int SiradanSiniflarinToplami=0,DolduralacakSinifSayi;
        for( DolduralacakSinifSayi=0; OgrSayi>SiradanSiniflarinToplami; DolduralacakSinifSayi++)
            SiradanSiniflarinToplami+=SinifKapasite[DolduralacakSinifSayi];
        System.out.println("fsahnre:"+DolduralacakSinifSayi);

        /////////////////////////////////////////////////////////////////
        int oran;
        oran=(OgrSayi*100)/SiradanSiniflarinToplami;
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
        System.out.println( "son sınıfa atılan halı"+SiniflaraAtama[DolduralacakSinifSayi-1]);



//////////////////////////////////////////////////////////////////////////////////////////////////

        Ogrenci ogrenciler[]=new Ogrenci[OgrSayi];
        for(int i=0;i<OgrSayi;i++){
        Ogrenci cool=new Ogrenci();
        ogrenciler[i]=cool;
        
        }
        int i,j=0,sinir=0;
        for( i=0; i<DolduralacakSinifSayi; i++){
            sinir+=SiniflaraAtama[i];
            
            for(; j<sinir; j++)
            {System.out.print("Sinif numara:"+(i+1)+"j="+j);
                ogrenciler[j].yazdir();
            }
        }



    }
}
