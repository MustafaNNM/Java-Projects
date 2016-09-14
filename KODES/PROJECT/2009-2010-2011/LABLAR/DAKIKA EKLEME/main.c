#include <stdio.h>
#include <stdlib.h>

int main()
{
    int ss,dd,ek;//ss=saat dd=dakika ek=ek dakika
    //olarak kullanilan degiskenlerdir.

    printf("Or:[4-30]\nSaati giriniz:\n");
    fflush(stdin);//karakter temizlemesi yapiliyor
    scanf("%d-%d",&ss,&dd);//Kullanicidan ss-dd seklinde zaman belirtmesi isteniyor
    printf("Ek dakikayi giriniz\n");
    fflush(stdin);   //karakter temizlemesi yapiliyor
    scanf("%d",&ek);//Kullanicidan saatin üzerine eklenecek olan ek dakika aliniyor
    ek+=dd;        //dakika ek dakika ile toplanýyor
    dd=ek%60;     //yeni dakika hesaplaniyor
    ek-=dd;      //yeni saat
    ss+=ek/60;  //hesaplamasi
    ss=ss%24;  //yapiliyor
    printf("Yeni saat %02d:%02d\n",ss,dd);
    ss=dd=ek=0;//bir sonraki hesaplama için bütün degerler sifirlaniyor

    return main();
}
