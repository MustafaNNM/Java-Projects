#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

#define BOYUT 10
#define BINARY 2
#define DECIMAL 10
#define RANDOM_BINARY rand()%2
#define RANDOM_DECIMAL rand()%10

int main()
{
        int i;
        int dizi[BOYUT]= {0};
        double sayi;
        double sonuc;
        srand(time(NULL));

        dizi[0]=RANDOM_BINARY;//x:{0-(BOYUT-1)} ,sayi:bir degisken

        // Hatirlatma
        //    dizi[0]=RANDOM_BINARY;
        //    dizi[1]=RANDOM_BINARY;//x:{0-(BOYUT-1)} ,sayi:bir degisken

        printf("dizi[%d]: %d\n",0,dizi[0]);

        for(i=BOYUT-1; i>0; i--) {
                dizi[i]=RANDOM_DECIMAL;//Uretilen en buyuk sayý 9 olur,en kucuk sayý 0 olur
                printf("dizi[%d]: %d\n",i,dizi[i]);
        }

        for(i=BOYUT-1; i>0; i--) {
                printf("dizi[%d]: %0.f\n",i,(float)dizi[i]*pow(10,i-1));
        }

        printf("********\n");
        sayi=0;
        for(i=BOYUT-1; i>0; i--) {
                sonuc=(float)dizi[i]*pow(10,(i-1));
                printf("sonuc: %.0f\n",sonuc);
                printf("Sayi: %.0f\n",sayi);
                sayi+=sonuc;
        }
        if(dizi[0]) { //if(dizi[0]==1)
                sayi*=-1;
        }

        printf("Sayi: %.0f\n",sayi);

        return 0;
}
