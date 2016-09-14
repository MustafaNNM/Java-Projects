#include <stdio.h>
#include <stdlib.h>


void iki_ile_carp(int *a);
void carp_iki_ile(int **a);

int main()
{
    int a=2;
    int *aptr;
    printf("a:%d\n",a);
    aptr=&a;
    iki_ile_carp(&a);
    printf("a:%d\n",a);
    iki_ile_carp(aptr);
    printf("a:%d\n",a);
    carp_iki_ile(&aptr);
    printf("a:%d\n",a);

    return 0;
}
void iki_ile_carp(int *a)
{
    *a*=2;
}
void carp_iki_ile(int **a)
{
    **a*=2;
}
