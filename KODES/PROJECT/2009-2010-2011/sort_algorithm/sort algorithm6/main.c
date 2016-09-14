#include <stdio.h>
#include <stdlib.h>

void com(int);

int main()
{
    int a;
    printf("Gir sayi:\n?");
    scanf("%d",&a);
    com(a);
    return 0;
}

void com(int a)
{
    int b,max;

    max=a;
    printf("Simdiki max:%d\n",max);
    fflush(stdin);
    printf("Gir sayi:\n?");
    scanf("%d",&b);
    fflush(stdin);
    if(a>b){com(a);}else{com(b);}
}
