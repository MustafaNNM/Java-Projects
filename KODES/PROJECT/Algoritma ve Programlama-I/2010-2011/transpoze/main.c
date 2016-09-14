#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    int dizi[4][2]={{0}};
    int dizi2[2][4]={{0}};
    int i,j;

    srand(time(NULL));

    for(i=0;i<4;++i)
    {
        for(j=0;j<2;++j)
        {
            dizi[i][j]=rand()%98+1;
        }
    }

    for(i=0;i<4;++i)
    {
        for(j=0;j<2;++j)
        {
            printf("%d ",dizi[i][j]);
        }
        printf("\n");
    }
    printf("\n");

    for(i=0;i<4;++i)
    {
        for(j=0;j<2;++j)
        {
            dizi2[j][i]=dizi[i][j];
        }
    }

    for(j=0;j<2;++j)
    {
        for(i=0;i<4;++i)
        {
            printf("%d ",dizi[i][j]);
        }
        printf("\n");
    }
    getchar();
    return 0;

}
