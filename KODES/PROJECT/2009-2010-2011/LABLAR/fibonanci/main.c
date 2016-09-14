#include <stdio.h>
#include <stdlib.h>

int main()
{
    int sayi=2,a[2],b[2],istenen;

    a[0]=a[1]=1;
    printf("Kacinci fibonanci sayisini goruntulemek istersiniz:");
    scanf("%d",&istenen);
    do
    {
        if(istenen==1||istenen==2){printf("%d\n",a[0]);}
        else
        {
            do
            {
                b[0]=a[0]+a[1];
                b[1]=a[0];
                a[0]=b[0];
                a[1]=b[1];
                ++sayi;
            }
            while(sayi<istenen);
            printf("%d\n",b[0]);
        }
        sayi=2;a[0]=a[1]=1;//ilk degerlere dönülüyor
        printf("Kacinci fibonanci sayisini goruntulemek istersiniz:");
        scanf("%d",&istenen);
    }
    while(istenen!=0);
    return 0;
}
