#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define BOYUT_L_S_R 9

void kabarcik_artan(int L[],const int boyut);
void kabarcik_azalan(int S[],const int boyut);
int basamaklarina_ayir(int sayi,int n[]);
double azalan_diziyi_birlestir(int is[],const int eleman_sayisi);
double artan_diziyi_birlestir(int is[],const int boyut,const int eleman_sayisi);

int azalan(int,int);
int artan(int,int);

int main()
{
        int L[9]= {0},S[9]= {0},R[9]= {0};
        double sayi,v[100]= {0};
        int i,j,uygun_mu=1,seri_bulundu_mu=0;
        int sayi_basamag;
        int rakamlar[9];
        double sayi_L,sayi_S,sayi_R;
        int son,bas,serinin_uzunlugu;

        do {
                if(uygun_mu==0) {
                        printf("Hatali veri girisi!\nLutfen tekrar sayi giriniz\n\n");
                }
                printf("Sayi Giriniz\n\n");
                scanf("%lf",&sayi);
                for(i=0; i<BOYUT_L_S_R; i++) {
                        rakamlar[i]=0;
                }
                sayi_basamag=basamaklarina_ayir(sayi,rakamlar);
                uygun_mu=0;
                for(i=1; i<sayi_basamag; i++) {
                        if(rakamlar[0]!=rakamlar[i]) {
                                uygun_mu=1;
                                break;
                        }
                }
                printf("sayi basamag: **** %d\n\n",sayi_basamag);
        } while(uygun_mu==0 || sayi_basamag<2 || sayi_basamag>9);

        v[0]=sayi;//Uygun sayi Seri listesine kaydediliyor

        printf("(1)v[0]:%0.f\n\n",v[0]);

        for(j=0; j<sayi_basamag; j++) {
                L[j]=S[j]=rakamlar[j];
        }
        printf("\nL ve S vektorlerinin ayni cikmasi gerekiyor\n(2)L vektoru\n\n");
        j=0;
        do {
                printf("%d",L[j]);
                j+=1;
        } while(j!=9);
        printf("\n(3)S vektoru\n\n");
        j=0;
        do {
                printf("%d",S[j]);
                j+=1;
        } while(j!=9);
        printf("\n\n");
        kabarcik_azalan(L,BOYUT_L_S_R);
        kabarcik_artan(S,BOYUT_L_S_R);

        sayi_L=azalan_diziyi_birlestir(L,sayi_basamag);
        sayi_S=artan_diziyi_birlestir(S,BOYUT_L_S_R,sayi_basamag);
        for(i=0; i<BOYUT_L_S_R; i++) {
                rakamlar[i]=0;
        }
        printf("(4)L sayisi %0.f\n\n",sayi_L);
        printf("(5)S sayisi %0.f\n\n",sayi_S);
        sayi_R=sayi_L-sayi_S;
        printf("(6)R sayisi %0.f\n\n",sayi_R);
        sayi_basamag=basamaklarina_ayir(sayi_R,R);
        i=0;
        do {
                v[++i]=sayi_R;

                //Arama yapiliyor
                for(j=0; j<i; j++) {
                        if(v[i]==v[j]) {
                                seri_bulundu_mu=1;
                                bas=j;
                                printf("\n\n*************v[i]:%0.lf v[j]:%0.lf\n\n",v[i],v[j]);
                                break;
                        }
                }
                //dizilerin elemanlari "0" sifirlaniyor
                for(j=0; j<BOYUT_L_S_R; j++) {
                        L[j]=S[j]=0;
                }
                for(j=0; j<sayi_basamag; j++) {
                        L[j]=S[j]=R[j];
                }
                printf("\n\n#####L vektoru\n\n");
                j=0;
                do {
                        printf("%d",L[j]);
                        j+=1;
                } while(j!=9);
                printf("\n\n#####S vektoru\n\n");
                j=0;
                do {
                        printf("%d",S[j]);
                        j+=1;
                } while(j!=9);
                printf("\n\n");
                kabarcik_azalan(L,BOYUT_L_S_R);
                kabarcik_artan(S,BOYUT_L_S_R);
                sayi_L=azalan_diziyi_birlestir(L,sayi_basamag);
                sayi_S=artan_diziyi_birlestir(S,BOYUT_L_S_R,sayi_basamag);
                printf("**L sayisi %0.lf\n\n",sayi_L);
                printf("**S sayisi %0.lf\n\n",sayi_S);
                sayi_R=sayi_L-sayi_S;
                printf("*R sayisi %0.lf\n\n",sayi_R);
                sayi_basamag=basamaklarina_ayir(sayi_R,R);
                if(i==100) {
                        //Seri cok uzun
                        break;
                }
        } while(seri_bulundu_mu==0);//seri_bulundu_mu==0
        son=i;
        serinin_uzunlugu=son-bas;
        if(serinin_uzunlugu==1){
        printf("Kapali Sayi\n\n");
        }

        switch(serinin_uzunlugu) {
        case 100:
                printf("Seri 100 adimda olusmadi\n");
                break;
        default:
                printf("serinin_uzunlugu:%d\n",serinin_uzunlugu);
                printf("%d adimda sayiya ulasildi\n",son);//break; yazilsa da, yazilmasa da olur
        }
        for(j=bas; j<son; j++) {
                printf("v[%d]:%0.lf\n",j,v[j]);
        }
        getchar();//Kullanicinin ekran ciktisini okuyabilmesi icin (klavyeden veri almayi bekleyen fonksiyon)
        return 0;
}


void kabarcik_azalan(int L[],const int boyut)
{
        int tur,sayici;

        void yerDegistir(int*,int*);
        for(tur=1; tur<boyut; tur++) {
                for(sayici=0; sayici<boyut-1; sayici++) {
                        if(azalan(L[sayici],L[sayici+1]))
                                yerDegistir(&L[sayici],&L[sayici+1]);
                }
        }
}
void kabarcik_artan(int S[],const int boyut)
{
        int tur,sayici;

        void yerDegistir(int*,int*);
        for(tur=1; tur<boyut; tur++) {
                for(sayici=0; sayici<boyut-1; sayici++) {
                        if(artan(S[sayici],S[sayici+1]))
                                yerDegistir(&S[sayici],&S[sayici+1]);
                }
        }
}
void yerDegistir(int *eleman1ptr,int *eleman2ptr)
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
int basamaklarina_ayir(int sayi,int n[])
{
        //sayi basamaklarina ayriliyor

        int i,kalan;
        i=0;
        do {
                kalan=sayi%10;
                sayi-=kalan;
                sayi/=10;
                n[i]=kalan;//sayinin rakamlari diziye aktariliyor
                i++;
        } while(sayi!=0);
        return i;//basamak sayisi
}
double azalan_diziyi_birlestir(int is[],const int eleman_sayisi)
{
        double sayi_L=0,sonuc;
        int i;
        for(i=0; i<eleman_sayisi; i++) {
                sonuc=is[i]*pow(10,(eleman_sayisi-i-1));
                sayi_L+=sonuc;
        }

        return sayi_L;
}
double artan_diziyi_birlestir(int is[],const int boyut,const int eleman_sayisi)
{
        double sayi_S=0,sonuc;
        int i;
        for(i=boyut-eleman_sayisi; i<boyut; i++) {
                sonuc=is[i]*pow(10,(boyut-i-1));
                sayi_S+=sonuc;
        }

        return sayi_S;
}
