#include <stdio.h>
#include <stdlib.h>

int main()
{
    float a,b,c,max;

    fflush(stdin);
    printf("Gir sayi\n");
    scanf("%f",&a);
    fflush(stdin);
    scanf("%f",&b);
    fflush(stdin);
    scanf("%f",&c);
    fflush(stdin);
    if (a>b && a>c)
    {
        max=a;
    }
    else
    {
        if (b>c)
        {
            max=b;
        }
        else
        {
            max=c;
        }
    }
    printf("%.2f",max);
    return 0;
}
