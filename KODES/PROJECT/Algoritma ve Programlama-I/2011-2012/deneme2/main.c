#include <stdio.h>
#include <stdlib.h>

int main()
{
        int i,k,j;//sayac
        int N;//Savas alaninin bir kenarinin uzunlugu

        do {
                printf("Savas alaninin bir kenar uzunlugunu giriniz:");
                scanf("%d",&N);
        } while(N<2||N>25||N%2==1);
        int gemi_sayisi=N/2;
        int gemilerin_uzunluklari[gemi_sayisi];
        int uzunluk;
        int limit=gemi_sayisi+1;
        int atis_yapma_hakki=N*N;

        int *batti_mi[gemi_sayisi];
        for(i=0; i<gemi_sayisi; i++) {
                do {
                        printf("\n%d. geminin uzunlugunu giriniz:",i+1);
                        scanf("%d",&uzunluk);
                } while(uzunluk<2||uzunluk>limit);
                atis_yapma_hakki-=gemilerin_uzunluklari[i]=uzunluk;
                {
                        int a[gemilerin_uzunluklari[i]][4];
                        for(j=0; j<gemilerin_uzunluklari[i]; j++) {
                                for(k=0; k<4; k++) {
                                a[j][k]=0;
                                printf("a[%d][%d]:%d",j+1,k+1,a[j][k]);
                                }
                                printf("\n");
                        }
                        batti_mi[i]=&a[0][0];

                        for(j=0; j<gemilerin_uzunluklari[i]; j++) {
                                for(k=0; k<4; k++) {
                                batti_mi[i][j*4+k]=0;
                                printf("batti_mi[gemi no:%d][%d]:%d\n",i+1,j*4+k+1,batti_mi[i][j*4+k]);
                                }
                                }

                }
        }
        return 0;
}
