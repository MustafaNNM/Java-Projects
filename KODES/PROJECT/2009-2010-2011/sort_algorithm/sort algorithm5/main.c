#include <stdio.h>
#include <stdlib.h>

void max();

int main()
{
    max();
    return main();
}
void max()
{
    float a,b,c,max;//a,b,c degerleri sayilarin temsili için olusturuldu.

    fflush(stdin);
    printf("gir a\n?");
    scanf("%f",&a);
    fflush(stdin);
    printf("gir b\n?");
    scanf("%f",&b);

    if (a<b)
    {
        fflush(stdin);
        printf("gir c\n?");
        scanf("%f",&c);
        if (b<c)
        {
            max=c;//2
        }
        else
        {
            max=b;//2
        }
    }
    else
    {
        fflush(stdin);
        printf("gir c\n?");
        scanf("%f",&c);
        if (a<c)
        {
            max=c;//2
        }
        else
        {
            max=a;//2
        }
    }
    printf("a:%.2f b:%.2f c:%.2f max:%.2f\n",a,b,c,max);
}
