#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
    int a,x=0;

    printf("sayi giriniz:?");
    scanf("%d",&a);
    fflush(stdin);

    x=pow(2,a);

    printf("\n2^%d:%d\n",a,x);

    return 0;
}
