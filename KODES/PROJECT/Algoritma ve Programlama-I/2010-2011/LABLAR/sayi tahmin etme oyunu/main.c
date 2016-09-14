#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    int sayi, tahmin, sayac;
    char devam;

    do {

        srand(time(NULL));//srand(tohum) fonksiyonu, rand() tarafindan uretilecek sayi icin bir baþlangic noktasi ayarlar.
                          //time() fonksiyonu sistemin mevcut takvim saatini dondurur.
        sayi=1+rand()%100;//rand() fonksiyonu, 0-MAX(en az 32767) arasinda bir tamsayi dondurur.
        sayac=0;

        do {
            printf("Lutfen tahmini sayinizi giriniz:");
            scanf("%d", &tahmin);
            sayac++;

            if (tahmin<sayi){
                printf("YUKARI! ");}
            else
                if (tahmin>sayi)
                {
                    printf("ASAGI! ");}
                else//tahmin=sayi
                    printf("Tebrikler! Dogru tahmin ettiniz.\n%d tahminde bilgisayarin tuttugu sayiyi buldunuz.\n", sayac);
        } while (sayi!=tahmin);

        do {
            printf("Bir kere daha oynamak ister misiniz(e/E/h/H)?");
            fflush(stdin);
            devam=getchar();
        } while (devam!='e' && devam!='E' && devam!='h' && devam!='H');

    } while (devam=='e' || devam=='E');

    return 0;
}
