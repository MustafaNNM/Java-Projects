#include <stdio.h>
#include <stdlib.h>

int main()
{
    int sayi[3]={0},a,b,c,tur,karsilastirma,tut;
    for (a=1;a<=3;++a)
    {
        for (b=1;b<=3;++b)
        {
            for (c=1;c<=3;++c)
            {
                sayi[0]=a;
                sayi[1]=b;
                sayi[2]=c;
                for (tur=0;tur<=2;++tur)//eleman sayısı-1
                {
                    for (karsilastirma=1;karsilastirma>=0;--karsilastirma)//birinci turda 2 ikinci turda bir karşılaştırma yeterli
                    {
                        if (sayi[karsilastirma]<sayi[karsilastirma+1])
                        {
                            tut=sayi[karsilastirma];
                            sayi[karsilastirma]=sayi[karsilastirma+1];
                            sayi[karsilastirma+1]=tut;
                        }
                    }
                }
                printf("Buyukten kucuge:\n");
                printf("a:%d b:%d c:%d \n",sayi[0],sayi[1],sayi[2]);
            }
        }
    }
    return 0;
}
