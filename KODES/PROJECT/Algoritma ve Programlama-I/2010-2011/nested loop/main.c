#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
    int x,y,z,sayac=0,xkare,payda;
    float toplam=0;

    for (x=-3;x<=3;++x)
    {
        for (y=-3;y<=3;++y)
        {
            xkare=x*x;
            payda=x*x-y*y;
            if (payda!=0)
            {
                for (z=-3;z<=3;++z)
                {
                    ++sayac;
                    printf("%.2f\n",toplam+=(float)((-xkare+y*z*z-3*x*y*z)/payda));
                }
            }
        }
    }
    printf("%.2f\n",(float)(toplam/sayac));
    return 0;
}
