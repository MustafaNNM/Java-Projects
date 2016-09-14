#include <stdio.h>
#include <stdlib.h>

int main()
{
    int sayac,satir_uzunlugu,sayi;
    printf("Desen kac satirdan olussun\n?");
    scanf("%d",&sayac);
    printf("Satir uzunlugu ne kadar olsun\n?");
    scanf("%d",&satir_uzunlugu);
    while(sayac>0){
    if(1==sayac%2){sayi=0;}else{sayi=1;}
    while(sayi<=16){
    printf("%s",sayi%2?"*":" ");
    sayi++;
    }
    printf("\n");
    sayac--;
    }

    return 0;
}
