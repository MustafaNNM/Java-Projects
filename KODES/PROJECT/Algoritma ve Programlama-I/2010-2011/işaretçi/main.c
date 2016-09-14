#include <stdio.h>
#include <stdlib.h>

void ptr(int *sayiprt)
{
    printf("*sayiptr:%d\n",*sayiprt);
    *sayiprt*=3;
}
void ptr_ptr(int **sayiptr)
{
    printf("**sayiptr:%d\n",**sayiptr);
    **sayiptr*=2;
}
int main()
{
    int sayi;
    int *sayiptr;
    sayi=5;
    printf("sayi:%d\n",sayi);
    ptr(&sayi);
    sayiptr=&sayi;
    printf("sayi:%d\n",sayi);
    ptr_ptr(&sayiptr);
    printf("sayi:%d\n",sayi);
    return 0;
}
