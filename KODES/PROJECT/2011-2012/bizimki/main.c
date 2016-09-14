#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int RakamdanHarfeDonusturme(int rakam)
{
        /* RAKAM degiskeninde gelen rakamin hangi harfe karsilik gel-
               digini geri gonderir.*/
        rakam = rakam + 65;
        return rakam;
}
void SavasAlanininSifirlanmasi(int *satir,int *sutun,int N)
{
        int i,j;

        for (i=0; i<=N; i++) {
                for (j=0; j<=N; j++)
                        satir[i] = 0;
                sutun[j] = 0;
        }
}
void GemilerinCizilmesi(int *satir,int *sutun)
{

        /* Bu fonksiyon gemiler dizisinde yer alan gemi yerlesim
           ve gemi durumu bilgilerini kullanarak guncel oyun ala-
           nini ekrana cizer.                                      */

        int i,N;
        int j;

        // Koordinant ekseninin �st k�sm�n�n �izimi
        printf("\n* ");
        for (i=1; i<=N; i++) {
                printf("%d ",i%10);
        }
        printf("\n");
        // Bitti

        for (i=0; i<N; i++) {
                printf("%c ",RakamdanHarfeDonusturme(i)); // Harf ekseninin ekrana yazma
                for (j=0; j<N; j++) {
                        if (satir[i]==0 && satir[j]==0) { // Konumdaki geminin durmunu al // Haritan�n o k�sm� bo�.
                                if (satir[i]==1 && satir[j]==1)  // O k�s�mda gemi var ama vurulmam��.
                                        printf("0 ");
                                break;
                                if (satir[i]==2 && satir[j]==2) // O k�s�mda gemi var vurulmu� ama bat�r�lmam��.
                                        printf("I ");
                                break;
                                if (satir[i]==3 && satir[j]==3) // O k�s�mda gemi var veeeeeeeeee art�k yok ��nk� bat�r�lm��.
                                        printf("B ");
                                break;
                                if (satir[i]==4 && satir[j]==4)
                                        printf("K "); // Karavana
                                break;
                        }
                }
                printf("\n");

        }
        printf("\n");

}
void ilkGemininYerlestirilmesi(int *GemilerinUzunlugu,int N )
{
        int i,j,k,m,yon,gecerli;
        int GemiSayisi=N/2;
        int satir[GemiSayisi],sutun[GemiSayisi],x[GemiSayisi],y[GemiSayisi];
        //gecerli 1 ise gemi yerleşebilir 0 ise tekrar ratgele bir değer atanır
        for (i=0; i<=GemiSayisi; i++) {
                for (j=0; j<=GemiSayisi; j++)
                        satir[i]=rand()%N+1;
                sutun[j]=rand()%N+1;
                x[i]=satir[i];
                y[j]=sutun[j];
        }
        yon=rand()%4+1;
        // 1=kuzey 2=guney 3=dogu 4=batı
        for (k=0; k<=N; k++) {
                for (m=0; m<=N; m++) {

                        for (i=0; i<=GemiSayisi; i++) {
                                if (yon==1) {
                                        if (k==0) gecerli=0;
                                        else if (k>=GemilerinUzunlugu[i])
                                                gecerli=1;
                                }
                                if (yon==2) {
                                        if (k==N) gecerli=0;
                                        else if (k>=GemilerinUzunlugu[i])
                                                gecerli=1;
                                }
                                if (yon==3) {
                                        if (m==0)gecerli=0;
                                        else if (m>=GemilerinUzunlugu[i])
                                                gecerli=1;
                                }
                                if (yon==4) {
                                        if (m==N) gecerli=0;
                                        else if (m>=GemilerinUzunlugu[i])
                                                gecerli=1;
                                }
                        }
                }
        }
}
void  kalanGemilerinYerlestirilmesi(int *GemilerinUzunlugu,int N)
{
    int GemiSayisi=N/2;
        int k,x[GemiSayisi],y[GemiSayisi],i,j,olmadi,yon,gecerli;
        {
                do {
                        ilkGemininYerlestirilmesi(GemilerinUzunlugu,N);

                        switch (yon) {
                        case '1':
                        case '2':
                                do {
                                        for (k=0; k<=GemiSayisi; k++) {
                                                for (i=0; i<=GemilerinUzunlugu[k]; i++) {
                                                        if (y[i]+1==1) olmadi= 1;
                                                        else olmadi= 0;
                                                        if (y[i]-1==-1) olmadi= 1;
                                                        else olmadi= 0;
                                                }
                                                for (i=0; i<=GemilerinUzunlugu[k]; i++) {
                                                        if (x[i]+1==1) olmadi= 1;
                                                        else olmadi= 0;
                                                        if (x[i]-1==-1) olmadi= 1;
                                                        else olmadi= 0;
                                                }
                                        }
                                } while (olmadi==0);
                                break;
                        case '3':
                        case '4':
                                do {
                                        for (k=0; k<=GemiSayisi; k++) {
                                                for (j=0; j<=GemilerinUzunlugu[k]; j++) {
                                                        if (y[j]+1==1) olmadi= 1;
                                                        else olmadi= 0;
                                                        if (y[j]-1==-1) olmadi= 1;
                                                        else olmadi= 0;
                                                }
                                                for (j=0; j<=GemilerinUzunlugu[k]; k++) {
                                                        if (x[j]+1==1) olmadi= 1;
                                                        else olmadi= 0;
                                                        if (x[j]-1==-1) olmadi= 1;
                                                        else olmadi= 0;
                                                }
                                        }
                                } while (olmadi==0);
                                break;
                        }
                } while (olmadi==0 || gecerli==0);
        }
}

int main() {
                int N,i,GemiSayisi,GemilerinUzunluklariToplami=0;
                int AtisYapmaHakki;
                int j;

                do {
                        printf("savas alaninin bir koordinat uzunlugunu giriniz:");
                        scanf("%d",&N);
                } while ( (N<2 || N>25) || (N%2!=0));

                                int SAVASALANI[N][N];

                                for(i=0;i<N;i++){
                                for(j=0;i<N;j++){
                                SAVASALANI[i][j]=0;
                                }
                                }
                                int satir[N/2];
                                int sutun[N/2];
                                GemiSayisi=N/2;
                                int GemilerinUzunlugu[GemiSayisi];
                                printf("oyun alanina % d tane gemi yerlecektir",GemiSayisi);
                for (i=0; i<=GemiSayisi;i++) {
                        do {
                                printf("%d. geminin uzunlugunu giriniz:",i+1);
                                scanf("%d",&GemilerinUzunlugu[i]);
                        } while (GemilerinUzunlugu[i]<2 || GemilerinUzunlugu[i]> (N/2+1) );
                        GemilerinUzunluklariToplami+=GemilerinUzunlugu[i];
                }
                AtisYapmaHakki=N*N -GemilerinUzunluklariToplami;
                printf(" oyun basliyor...");
                SavasAlanininSifirlanmasi(satir,sutun,N);
                ilkGemininYerlestirilmesi(GemilerinUzunlugu, N);
                for (i=1; i<=GemiSayisi; i++) {
                        kalanGemilerinYerlestirilmesi(GemilerinUzunlugu, N );
                }
                return 0;
        }
