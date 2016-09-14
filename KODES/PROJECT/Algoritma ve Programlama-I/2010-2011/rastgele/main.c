#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    int mod,sayi;
    srand(time(NULL));
    printf("En fazla kac olsun?\n");
    scanf("%d",&mod);
    sayi=rand()%mod+1;
    printf("rastgelen sayi:%d\n",sayi);
    return main();
}
