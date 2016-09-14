#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main()
{
    int tutulan,x,sayac=0;

    srand(time(NULL));
    tutulan=rand()%100+1;

    do
    {
        printf("Gir sayi[0-100]\n");
        fflush(stdin);
        scanf("%d",&x);
        ++sayac;
        if (x>tutulan)
        {
            printf("ASAGI\n");
        }
        else
        {
            if (x!=tutulan)
            {
                printf("YUKARI\n");
            }
            else
            {
                printf("TEBRIKLER!\n%d kerede tahmin ettiniz!\n",sayac);
            }
        }
    }
    while (x!=tutulan);
    sayac=0;

    return main();
}
