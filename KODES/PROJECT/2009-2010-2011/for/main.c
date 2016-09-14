#include <stdio.h>
#include <stdlib.h>

void ikizkenar();
void kare();

int main()
{
    ikizkenar();
    kare();
    ikizkenar();
    return main();
}
void ikizkenar()
{
    int yukseklik;
    int i,j;
    int bosluk,dolgu;
    char h1,h2,h3;
    printf("yuksekligi giriniz:\n?");
    fflush(stdin);
    scanf("%d",&yukseklik);
    printf("sol dolguyu giriniz\n?");
    fflush(stdin);
    scanf("%c",&h1);
    printf("dolguyu giriniz\n?");
    fflush(stdin);
    scanf("%c",&h2);
    printf("sag dolguyu giriniz\n?");
    fflush(stdin);
    scanf("%c",&h3);
    for(i=0; i<yukseklik; i++)
    {
        bosluk=yukseklik-1-i;
        dolgu=yukseklik-1-bosluk;
        //bosluk býrakýlýyor
        for(j=bosluk; j>0; j--)
        {
            printf(" ");
        }
        //sol dolgu býrakýlýyor
        for(j=0; j<dolgu; j++)
        {
            printf("%c",h1);
        }
        printf("%c",h2);
        //sag dolgu
        for(j=0; j<dolgu; j++)
        {
            printf("%c",h3);
        }
        printf("\n");
    }
}
void kare()
{
    int i,j,uzunluk;

    printf("karenin bir kenarinin uzunlugunu giriniz\?");
    fflush(stdin);
    scanf("%d",&uzunluk);
    for(i=0; i<uzunluk; i++)
    {
        for(j=0; j<uzunluk; j++)
        {
            printf("x ");
        }
        printf("\n");
    }
}
