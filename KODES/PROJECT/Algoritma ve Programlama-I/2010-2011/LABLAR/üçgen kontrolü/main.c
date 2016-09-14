#include <stdio.h>
#include <stdlib.h>

int main()
{
    int  kenar1,kenar2,kenar3,uzun_kenar,kisa_kenar1,kisa_kenar2;

    printf("Ucgenin kenar uzunluklarini giriniz:");
    scanf("%d %d %d",&kenar1,&kenar2,&kenar3);

    if (kenar1>kenar2 && kenar1>kenar3)     //en uzun kenari ve kisa kenarlari
    {
        uzun_kenar=kenar1;                  //bulmak icin 3 sayinin en buyugunu
        kisa_kenar1=kenar2;                 //bulma algoritmasi uygulaniyor...
        kisa_kenar2=kenar3;
    }
    else
        if (kenar2>kenar3)
        {
            uzun_kenar=kenar2;
            kisa_kenar1=kenar1;
            kisa_kenar2=kenar3;
        }
        else
        {
            uzun_kenar=kenar3;
            kisa_kenar1=kenar1;
            kisa_kenar2=kenar2;
        }

    if (uzun_kenar>=kisa_kenar1+kisa_kenar2)
        printf("Girilen sayilar bir ucgen olusturmuyor!");
    else
        if (uzun_kenar*uzun_kenar==kisa_kenar1*kisa_kenar1+kisa_kenar2*kisa_kenar2)
            printf("Bu ucgen, bir dik ucgendir");
        else
            if (uzun_kenar*uzun_kenar>kisa_kenar1*kisa_kenar1+kisa_kenar2*kisa_kenar2)
                printf("Bu ucgen, genis acili bir ucgendir");
            else printf("Bu ucgen, dar acili bir ucgendir");

    return 0;
}
