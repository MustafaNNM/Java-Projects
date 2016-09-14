#include <stdio.h>
#include <stdlib.h>

int com(int);

int main()
{
    int a,b,sayac=0;
    printf("Kac sayinin karsilastirmasini yapicaksiniz\n{Cikis icin sifir [0] giriniz}\n?");
    scanf("%d",&b);
    fflush(stdin);

    while(b!=0)
    {
        printf("Gir sayi:\n?");
        fflush(stdin);
        scanf("%d",&a);

        do
        {
            a=com(a);
            ++sayac;
            //printf("Sayac:%d\n",sayac);
        }
        while(sayac!=b-1);

        sayac=0;
        printf("Simdiki max:%d\n",a);
        printf("Kac sayinin karsilastirmasini yapicaksiniz\n{Cikis icin sifir [0] giriniz}\n?");
        scanf("%d",&b);
        fflush(stdin);
    }

    return 0;
}

int com(int a)
{
    int b;
    //printf("Simdiki max:%d\n",a);
    fflush(stdin);
    printf("Gir sayi:\n?");
    scanf("%d",&b);
    fflush(stdin);

    if(a>b)
    {
        return a;
    }
    else
    {
        return b;
    }
}
