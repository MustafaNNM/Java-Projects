#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a,b,c,min,ort,max;

    for (a=1; a<=3; ++a)
    {
        for (b=1; b<=3; ++b)
        {
            for (c=1; c<=3; ++c)
            {
                if (a>=b&&a>=c)
                {
                    max=a;
                    if (b>=c)
                    {
                        ort=b;
                        min=c;
                        printf("*1*");
                    }
                    else
                    {
                        ort=c;
                        min=b;
                        printf("*2*");
                    }
                }
                else
                {
                    if (b>=c)
                    {
                        max=b;
                        if (a>c)
                        {
                            ort=a;
                            min=c;
                            printf("*3*");
                        }
                        else
                        {
                            ort=c;
                            min=a;
                            printf("*4*");
                        }
                    }
                    else
                    {
                        max=c;
                        if (a>b)
                        {
                            ort=a;
                            min=b;
                            printf("*5*");
                        }
                        else
                        {
                            ort=b;
                            min=a;
                            printf("*6*");
                        }
                    }
                }

                printf("min:%d ort:%d max:%d\n",min,ort,max);
                min=ort=max=0;
            }
        }
    }

    return 0;
}
