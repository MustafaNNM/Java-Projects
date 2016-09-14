#include <stdio.h>
#include <stdlib.h>

int main()
{
    int yukseklik=10;
    int i,j;
    for(i=yukseklik;i>0;i--)//10 defa
    {
        for(j=0;j<i;j++)//i tane//satýrýn uzunlýgu belirleniyor
        {
            printf("x");
        }
        printf("\n");
    }

    return 0;
}
