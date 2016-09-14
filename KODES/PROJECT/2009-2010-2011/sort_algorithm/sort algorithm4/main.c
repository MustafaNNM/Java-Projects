#include <stdio.h>
#include <stdlib.h>

int main()
{
    int sayi[4]={0},a,b,c,d,e,tur,karsilastirma,tut;
    for (a=1;a<=4;++a)
    {
        for (b=1;b<=4;++b)
        {
            for (c=1;c<=4;++c)
            {
                for (d=1;d<=4;++d)
                {
                    sayi[0]=a;
                    sayi[1]=b;
                    sayi[2]=c;
                    sayi[3]=d;
                    printf("\nSayilar:\n");
                    for (e=0;e<4;++e)
                    {
                        printf("*%d",sayi[e]);
                    }
                    for (tur=0;tur<=2;++tur)//eleman sayisi-1
                    {
                        for (karsilastirma=2;karsilastirma>=0;--karsilastirma)
                            //karsilastirma sayisi her turda azaliyor
                            //karsilastirma yapilirken asagidan yukari dogru yapiliyor
                            //n:eleman sayisi dersek n-1 karsilastirma vardir.
                        {
                            if (sayi[karsilastirma]<sayi[karsilastirma+1])
                            {
                                tut=sayi[karsilastirma];
                                sayi[karsilastirma]=sayi[karsilastirma+1];
                                sayi[karsilastirma+1]=tut;
                            }
                        }
                        //n-1 tur vardir.
                    }
                    printf("\nBuyukten kucuge:\n");
                    for (e=0;e<4;++e){printf("*%d",sayi[e]);}
                    printf("\nKucukten buyuge:\n");
                    for(e=3;e>=0;--e){printf("*%d",sayi[e]);}
                }
            }
        }
    }
    return 0;
}
