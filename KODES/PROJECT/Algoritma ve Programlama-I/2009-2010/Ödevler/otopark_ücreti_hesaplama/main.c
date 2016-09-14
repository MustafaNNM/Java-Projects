#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
    int gg,ga,gs,gd;/*giris gunu,giris ayi,giris dakikasi*/
    int cg,ca,cs,cd;/*cýkýs gunu,cýkýs ayý,cýkýs saati,cýkýs dakikasi*/
    int gbu,gnbu,sbu,bu,u;/*giris birim ucreti,gunluk birim ucret,saatlik birim ucret,birim ucret,ucret*/
    int d,z,w;/*gun farki,saat farki,dakika farki*/
    int x,y;/*gun hesabinda kullanilan ara degiskenler*/
    printf("Otopark Ucreti hesaplama\nLutfen sizden istenen bilgileri giriniz\nArac turleri:\nb/B:binek\no/O:minibus/otobus\nt/T:kamyon/tir\nArac turu:\n");
    switch (getchar())
    {
    case 'b':case 'B':bu=1;break;
    case 'o':case 'O':bu=2;break;
    case 't':case 'T':bu=3;break;
    }
    printf("Giris gun,ay,saat ve dakikasini aralarinda bosluk birakarak giriniz:\n");
    fflush(stdin);
    scanf("%d %d %d %d",&gg,&ga,&gs,&gd);
    switch (ga)
    {
    case 12:x=gg+334;break;
    case 11:x=gg+304;break;
    case 10:x=gg+273;break;
    case 9:x=gg+243;break;
    case 8:x=gg+212;break;
    case 7:x=gg+181;break;
    case 6:x=gg+151;break;
    case 5:x=gg+120;break;
    case 4:x=gg+90;break;
    case 3:x=gg+59;break;
    case 2:x=gg+31;break;
    default:x=gg;
    }
    printf("Cikis gun,ay,saat ve dakikasini aralarinda bosluk birakarak giriniz:\n");
    fflush(stdin);
    scanf("%d %d %d %d",&cg,&ca,&cs,&cd);
    for(i=1;i<=ca;++i)
    {
    switch (ca)
    {
    }
    }
    if (cd<gd){cd=cd+60;cs=cs-1;}
    if (cs<gs){cs=cs+24;y=y-1;}
    d=y-x;
    z=cs-gs;
    w=cd-gd;
    printf("Otoparkta kaldiginiz sure :\n %d gun %d saat %d dakika\n",d,z,w);
    if (w>20){z=z+1;if (z==24) {d=d+1;z=0;}}
    gbu=5;gnbu=20;sbu=1;u=bu*(gbu+d*gnbu+z*sbu);
    printf("Odemeniz gereken ucret:\n%d TL\n",u);
    return main();
}


