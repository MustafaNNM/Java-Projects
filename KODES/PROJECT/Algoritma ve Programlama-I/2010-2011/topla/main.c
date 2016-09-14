#include <stdio.h>
#include <stdlib.h>
int topla(int);
int topla2(int,int);
int topla3(int);
int main()
{
    printf("%d\n",topla(10));
    printf("%d\n",topla3(10));
    printf("%d",topla2(10,20));
    return 0;
}
int topla(int sayi)
{
    if(sayi==0){return 0;}
    else{
    return sayi+topla(sayi-1);
    }
}
int topla2(int sayi1,int sayi2)
{
    return sayi1+sayi2;
}
int topla3(int sayi)
{
    return sayi*(sayi+1)/2;
}
