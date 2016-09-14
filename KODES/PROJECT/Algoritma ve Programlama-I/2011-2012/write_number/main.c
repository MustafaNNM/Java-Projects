#include <stdio.h>
#include <stdlib.h>

int main()
{
    static int a=5;
    int *ptr_a;
    void*nesne;
    int **ptr_ptr_a;
    //nesne=*ptr_a;
    nesne=4202496;
    printf("*ptr_a:%d\n",*ptr_a);
    printf("&a:%d\n",&a);
    printf("nesne:%d\n",nesne);
    ptr_a=nesne;
    printf("nesneden *ptr_a:%d\n",*ptr_a);
    //ptr_ptr_a=*ptr_a;
    //printf("*ptr_ptr_a%d\n",*ptr_ptr_a);
    getchar();
    return 0;
}
