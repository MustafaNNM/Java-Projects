#include <stdio.h>
#include <stdlib.h>

int main()
{
    int *ptr_a;
    void*nesne;

    nesne=4202496;
    printf("nesne:%d\n",nesne);
    ptr_a=nesne;
    printf("nesneden *ptr_a:%d\n",*ptr_a);
    getchar();
    return 0;
}
