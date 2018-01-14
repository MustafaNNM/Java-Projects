
package izmirhavasicaklik;
import java.util.*;

public class Main {

   
    public static void main(String[] args) {
         Scanner DegerAl=new Scanner(System.in);
         int KullanicidanGirilenGun=DegerAl.nextInt();
         int AySayac=0;
         int[][] TumGunlukSicaklikDeger=new int[12][];

         if(KullanicidanGirilenGun>334)
         {  int k=KullanicidanGirilenGun-334;
            AySayac++;
            TumGunlukSicaklikDeger[11]=new int[k+1];
            for (int i=k;i>0;i--){
                TumGunlukSicaklikDeger[11][i]=Gun.GunlukSicaklik(KullanicidanGirilenGun);
                KullanicidanGirilenGun--;
            }
         }
          if(KullanicidanGirilenGun>304){
             int k=KullanicidanGirilenGun-304;
             AySayac++;
             TumGunlukSicaklikDeger[10]=new int[k+1];
            for (int i=k;i>0;i--){
                TumGunlukSicaklikDeger[10][i]=Gun.GunlukSicaklik(KullanicidanGirilenGun);
                KullanicidanGirilenGun--;
            }}
         if(KullanicidanGirilenGun>273){
             int k=KullanicidanGirilenGun-273;
             AySayac++;
             TumGunlukSicaklikDeger[9]=new int[k+1];
            for (int i=k;i>0;i--){
                TumGunlukSicaklikDeger[9][i]=Gun.GunlukSicaklik(KullanicidanGirilenGun);
                KullanicidanGirilenGun--;
            }}
         if(KullanicidanGirilenGun>243){
             int k=KullanicidanGirilenGun-243;
             AySayac++;
             TumGunlukSicaklikDeger[8]=new int[k+1];
            for (int i=k;i>0;i--){
                TumGunlukSicaklikDeger[8][i]=Gun.GunlukSicaklik(KullanicidanGirilenGun);
                KullanicidanGirilenGun--;
            }}
         if(KullanicidanGirilenGun>212){
             int k=KullanicidanGirilenGun-212;
             AySayac++;
             TumGunlukSicaklikDeger[7]=new int[k+1];
            for (int i=k;i>0;i--){
                TumGunlukSicaklikDeger[7][i]=Gun.GunlukSicaklik(KullanicidanGirilenGun);
                KullanicidanGirilenGun--;
            }}
         if(KullanicidanGirilenGun>181){
             int k=KullanicidanGirilenGun-181;
             AySayac++;
             TumGunlukSicaklikDeger[6]=new int[k+1];
            for (int i=k;i>0;i--){
                TumGunlukSicaklikDeger[6][i]=Gun.GunlukSicaklik(KullanicidanGirilenGun);
                KullanicidanGirilenGun--;
            }}
         if(KullanicidanGirilenGun>151){
             int k=KullanicidanGirilenGun-151;
             AySayac++;
             TumGunlukSicaklikDeger[5]=new int[k+1];
            for (int i=k;i>0;i--){
                TumGunlukSicaklikDeger[5][i]=Gun.GunlukSicaklik(KullanicidanGirilenGun);
                KullanicidanGirilenGun--;
            }}
         if(KullanicidanGirilenGun>120){
             int k=KullanicidanGirilenGun-120;
             AySayac++;
             TumGunlukSicaklikDeger[4]=new int[k+1];
            for (int i=k;i>0;i--){
                TumGunlukSicaklikDeger[4][i]=Gun.GunlukSicaklik(KullanicidanGirilenGun);
                KullanicidanGirilenGun--;
            }}
         if(KullanicidanGirilenGun>90){
             int k=KullanicidanGirilenGun-90;
             AySayac++;
             TumGunlukSicaklikDeger[3]=new int[k+1];
            for (int i=k;i>0;i--){
                TumGunlukSicaklikDeger[3][i]=Gun.GunlukSicaklik(KullanicidanGirilenGun);
                KullanicidanGirilenGun--;
            }}
         if(KullanicidanGirilenGun>59){
             int k=KullanicidanGirilenGun-59;
             AySayac++;
             TumGunlukSicaklikDeger[2]=new int[k+1];
            for (int i=k;i>0;i--){
                TumGunlukSicaklikDeger[2][i]=Gun.GunlukSicaklik(KullanicidanGirilenGun);
                KullanicidanGirilenGun--;
            }}
         if(KullanicidanGirilenGun>31){
             int k=KullanicidanGirilenGun-31;
             AySayac++;
             TumGunlukSicaklikDeger[1]=new int[k+1];
            for (int i=k;i>0;i--){
                TumGunlukSicaklikDeger[1][i]=Gun.GunlukSicaklik(KullanicidanGirilenGun);
                KullanicidanGirilenGun--;
            }}
         if(KullanicidanGirilenGun>0){
             int k=KullanicidanGirilenGun;
             AySayac++;
             TumGunlukSicaklikDeger[0]=new int[k+1];
            for (int i=k;i>0;i--){
                TumGunlukSicaklikDeger[0][i]=Gun.GunlukSicaklik(KullanicidanGirilenGun);
                KullanicidanGirilenGun--;
            }}
        
//System.out.println(TumGunlukSicaklikDeger[6].length);

//         for(int i=1; i<TumGunlukSicaklikDeger[6].length; i++)
  //           System.out.println(i+" "+TumGunlukSicaklikDeger[6][i]);
double[] StandardSapmaListesi=new double[AySayac];
         for(int i=0;i<AySayac;i++){
            StandardSapmaListesi[i]=StandartSapmaHesaplama.StandardSapma(TumGunlukSicaklikDeger,TumGunlukSicaklikDeger[i].length,i);
            System.out.println("sapma"+(i+1)+"   "+StandardSapmaListesi[i]);}
            double b1=0,b2=0,b3=0,gecici;
            for(int i=0;i<AySayac;i++){
                if(b1<StandardSapmaListesi[i]){
                    b1=StandardSapmaListesi[i];
                    if(b2<b1){
                        gecici=b2;
                        b2=b1;
                        b1=gecici;
                    }
                    if(b3<b2){
                        gecici=b3;
                        b3=b2;
                        b2=gecici;
                    }
                }
            }
            System.out.println(" 1nci "+b1+" 2nci "+b2+" 3ncü "+b3);
            double Kucuk=b3,KucukOrta=b3,KucukEn=b3;
            for(int i=0;i<AySayac;i++){
                if(Kucuk>StandardSapmaListesi[i]){
                    Kucuk=StandardSapmaListesi[i];
                    if(Kucuk<KucukOrta){
                        gecici=KucukOrta;
                        KucukOrta=Kucuk;
                        Kucuk=gecici;
                    }
                    if(KucukOrta<KucukEn){
                        gecici=KucukEn;
                        KucukEn=KucukOrta;
                        KucukOrta=gecici;
                    }
                }
            }

            System.out.println(" 1nci "+Kucuk+" 2nci "+KucukOrta+" 3ncü "+KucukEn);



    }

}
