#include <stdio.h>
#include <stdlib.h>

long us_al(long sayi,long us){if(us==0){if(sayi==0){return -1;}else{return 1;}}return sayi*us_al(sayi,us-1);}
int main()
{
    long sayi,us;
    printf("Sayi gir:\n");scanf("%ld",&sayi);printf("Kuvvetini gir:\n?");scanf("%ld",&us);
    if(us_al(sayi,us)==-1){printf("0^0:Tanimsizdir\n");}else{printf("%ld^%ld:%ld\n",sayi,us,us_al(sayi,us));}
    return main();
}
