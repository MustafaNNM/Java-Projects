#include <stdio.h>
#include <stdlib.h>

int main()
{
    int buyuk,kucuk,kalan;
    printf("gir sayi:\n");
    scanf("%d",&buyuk);
    fflush(stdin);
    printf("gir sayi:\n");
    scanf("%d",&kucuk);
    fflush(stdin);
    if(buyuk<kucuk){kalan=kucuk;kucuk=buyuk;buyuk=kalan;}
    kalan=buyuk%kucuk;
    while(kalan!=0)
    {
        buyuk=kucuk;
        kucuk=kalan;
        kalan=buyuk%kucuk;
    }
    printf("obeb:%d\n",kucuk);
    return main();
}
