#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int deger_ata(int alt,int ust,char *s)
{
    int sayi;
    do
    {
        printf("%s",s);
        scanf("%d",&sayi);
    }
    while(alt>sayi||sayi>ust);
    return sayi;
    }
    int main()
{
    int mevcut,max=0,min=100,i,basarisiz=0;
    float s=0,ort=0;
    int notlar[100]= {0};

    mevcut=deger_ata(2,100,"mevcut");
    for(i=0; i<mevcut; ++i)
    {
        ort+=notlar[i]=deger_ata(0,100,"puan");
        if(max<notlar[i])
        {
            max=notlar[i];
        }
        if(min>notlar[i])
        {
            min=notlar[i];
        }
    }
    ort/=(float)(mevcut);
    printf("sinif not ortalamasi:%.2f\n",ort);
    for(i=0; i<mevcut; ++i)
    {
        s+=pow(notlar[i]-ort,2);
        if((notlar[i]-ort)<0)
        {
            ++basarisiz;
        }
    }
    s/=(float)(mevcut-1);
    s=sqrt(s);
    printf("basarili ogrenci sayisi:%d yuzdesi:%%%.2f\n",mevcut-basarisiz,(float)(mevcut-basarisiz)/mevcut*100);
    printf("max:%d min:%d standart sapma:%.2f\n",max,min,s);
    return 0;
}
