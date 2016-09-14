#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define BOYUT_DIZI 9
#define BOYUT_VECTOR 100

void artan_sirala(int kucuk_artan[],int boyut_kucuk_artan,int basamak_sayisi);             //kucuk_artan sýralandý..
void azalan_sirala(int buyuk_azalan[],int basamak_sayisi);          //buyuk_azalan sýralandý..
void yer_degistir(int*,int*);
double buyuk_azalan_birlestir(int buyuk_azalan[],int basamak_sayisi);
double kucuk_artan_birlestir(int kucuk_artan[],int boyut_kucuk_artan,int basamak_sayisi);

int main()
{
        double sayi;
        int birler_basamagi;
        int basamak[BOYUT_DIZI];
        int i,j,k;
        int basamak_sayisi;
        int tekrar_sayi_girsin_mi;
        double vector[BOYUT_VECTOR]= {0};
        int buyuk_azalan[BOYUT_DIZI]= {0};
        int kucuk_artan[BOYUT_DIZI]= {0};
        double R,L,S;//R=L-S
        int ilk,son,uzunluk;
        int bulundu_mu;
        do {

                do {
                        for(j=0; j<BOYUT_DIZI; j++) {
                                basamak[j]=0;
                        }

                        printf("Bir sayi giriniz(sayi en az 2 en cok 9 basamakli olmalidir):");
                        scanf("%lf",&sayi);

                        i=0;
                        do {
                                birler_basamagi=(int)sayi%10;
                                basamak[i]=birler_basamagi;
                                i++;
                                sayi=(int)sayi/10;
                        } while(sayi!=0);

                        basamak_sayisi=i;

                } while(basamak_sayisi>9||basamak_sayisi<2);

                tekrar_sayi_girsin_mi=1;

                for(i=1; i<basamak_sayisi; i++) {
                        if(basamak[0]!=basamak[i]) {
                                tekrar_sayi_girsin_mi=0;
                        }
                }

        } while(tekrar_sayi_girsin_mi==1);

        vector[0]=sayi;

        for(k=0; k<basamak_sayisi; k++) {
                kucuk_artan[BOYUT_DIZI-k-1]=buyuk_azalan[k]=basamak[k];
        }

        artan_sirala(kucuk_artan,BOYUT_DIZI,basamak_sayisi);                      //kucuk_artan sýralandý..
        azalan_sirala(buyuk_azalan,basamak_sayisi); //buyuk_azalan sýralandý..

        L=buyuk_azalan_birlestir(buyuk_azalan,basamak_sayisi);
        S=kucuk_artan_birlestir(kucuk_artan,BOYUT_DIZI,basamak_sayisi);

        R=L-S;

        i=0;
        do {
                if(i==99) {
                        break;
                }

                vector[++i]=R;

                bulundu_mu=0;

                for(j=0; j<i; j++) {
                        if(vector[i]==vector[j]) {
                                bulundu_mu=1;
                                ilk=j;
                                break;
                        }
                }

                j=0;
                do {
                        birler_basamagi=(int)R%10;
                        basamak[j]=birler_basamagi;
                        j++;
                        R=(int)R/10;
                } while(R!=0);

                basamak_sayisi=j;

                for(j=0; j<BOYUT_DIZI; j++) {
                        buyuk_azalan[j]=kucuk_artan[j]=0;
                }

                for(k=0; k<basamak_sayisi; k++) {
                        kucuk_artan[BOYUT_DIZI-k-1]=buyuk_azalan[k]=basamak[k];
                }

                artan_sirala(kucuk_artan,BOYUT_DIZI,basamak_sayisi);                      //kucuk_artan sýralandý..
                azalan_sirala(buyuk_azalan,basamak_sayisi); //buyuk_azalan sýralandý..

                L=buyuk_azalan_birlestir(buyuk_azalan,basamak_sayisi);
                S=kucuk_artan_birlestir(kucuk_artan,BOYUT_DIZI,basamak_sayisi);

                R=L-S;

        } while(bulundu_mu==0);

        son=i;
        uzunluk=son-ilk;

        if(ilk==0) {
                printf("Kapali Sayi bulundu\n");
        }

        if(son!=99) {
                printf("Seri uzunlugu:%d\n",uzunluk);
                printf("%d. adimda sayiya ulasildi\n",son);
        }

        for(j=ilk; j<son; j++) {
                printf("vector[%d]:%0.lf\n",j,vector[j]);
        }

        getchar();

        return 0;
}
void yer_degistir(int *eleman1ptr,int *eleman2ptr)
{
        int gecici;
        //Sayilarin birbiriyle yerdegistirmesi saglaniyor
        gecici=*eleman1ptr;
        *eleman1ptr=*eleman2ptr;
        *eleman2ptr=gecici;
}
int azalan (int a,int b)
{
        return b>a;//b buyuk a ise TRUE donduruyor
}
int artan (int a,int b)
{
        return b<a;//b kucuk a ise TRUE donduruyor
}
void artan_sirala(int kucuk_artan[],int boyut_kucuk_artan,int basamak_sayisi)
{
        int tur,sayici;

        for(tur=1; tur<boyut_kucuk_artan; tur++) {
                for(sayici=boyut_kucuk_artan-basamak_sayisi; sayici<boyut_kucuk_artan-1; sayici++) {
                        if(artan(kucuk_artan[sayici],kucuk_artan[sayici+1]))
                                yer_degistir(&kucuk_artan[sayici],&kucuk_artan[sayici+1]);
                }
        }
}
void azalan_sirala(int buyuk_azalan[],int basamak_sayisi)
{
        int tur,sayici;

        for(tur=1; tur<basamak_sayisi; tur++) {
                for(sayici=0; sayici<basamak_sayisi-1; sayici++) {
                        if(azalan(buyuk_azalan[sayici],buyuk_azalan[sayici+1]))
                                yer_degistir(&buyuk_azalan[sayici],&buyuk_azalan[sayici+1]);
                }
        }
}
double buyuk_azalan_birlestir(int buyuk_azalan[],int basamak_sayisi)
{
        double L=0,basamak_degeri;
        int i;
        for(i=0; i<basamak_sayisi; i++) {
                basamak_degeri=buyuk_azalan[i]*pow(10,(basamak_sayisi-i-1));
                L+=basamak_degeri;
        }

        return L;
}
double kucuk_artan_birlestir(int kucuk_artan[],int boyut_kucuk_artan,int basamak_sayisi)
{
        double S=0,basamak_degeri;
        int i;

        for(i=boyut_kucuk_artan-basamak_sayisi; i<boyut_kucuk_artan; i++) {
                basamak_degeri=kucuk_artan[i]*pow(10,(boyut_kucuk_artan-i-1));
                S+=basamak_degeri;
        }

        return S;
}

