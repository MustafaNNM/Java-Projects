#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

int x;

#define BOYUT x

void diziptr(int *d,int boyut);
void diziduzenle(int boyut,int dizi[][boyut]);
void diziyi_yazdir(int boyut,const int dizi[boyut]);
void diziyiarttiryazdir(int []);
int main()
{
    srand(time(NULL));
    x=10+rand()%10;
    int dizi[BOYUT][BOYUT];
    int i,j,tut;
    int a[10]={0};


    diziptr(&dizi[0][0],BOYUT*BOYUT);

    for(i=0;i<BOYUT;++i)
    {
        for(j=0;j<BOYUT;++j)
        {
            printf(" %3d",dizi[i][j]);
        }
        printf("\n\n");
    }

    printf("\n");
    for(i=1;i<BOYUT;++i)
    {
        for(j=0;j<i;++j)
        {
            tut=dizi[i][j];
            dizi[i][j]=dizi[j][i];
            dizi[j][i]=tut;
        }
    }
    printf("\n");
    for(i=0;i<BOYUT;++i)
    {
        for(j=0;j<BOYUT;++j)
        {
            printf(" %3d",dizi[i][j]);
        }
        printf("\n\n");
    }
    diziduzenle(BOYUT,dizi);
    printf("\n");
    for(i=0;i<BOYUT;++i)
    {
        for(j=0;j<BOYUT;++j)
        {
            printf(" %3d",dizi[i][j]);
        }
        printf("\n\n");
    }
    diziptr(&a[0],BOYUT);
    printf("\n");
    for(i=0;i<BOYUT;++i)
    {
        printf(" %3d",a[i]);
    }
    printf("\n");
    diziyiarttiryazdir(a);printf("\n");
    diziyi_yazdir(BOYUT,a);
    printf("\n");
    diziyiarttiryazdir(a);
    printf("\n");
    for(i=0;i<BOYUT;++i)
    {
        printf(" %3d",a[i]);
    }
    getchar();
    return 0;
}

void diziptr(int *d,int boyut)
{
    int i;

    for(i=0;i<boyut;++i)
    {
            d[i]=rand()%98+1;
    }
}

void diziduzenle(int boyut,int dizi[][boyut])
{
    int i,j;

    for(i=0;i<10;++i)
    {
        for(j=0;j<10;++j)
        {
            dizi[i][j]=rand()%98+1;
        }
    }
}
void diziyi_yazdir(int boyut,const int dizi[boyut])
{
    int i;

    for(i=0;i<boyut;++i)
    {
        printf(" %3d",dizi[i]);
    }
}
void diziyiarttiryazdir(int a[])
{
    int i;
    for(i=0;i<10;++i)
    {
        ++a[i];
        printf(" *%3d",a[i]);
    }
}
