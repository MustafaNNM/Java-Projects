#include <iostream>
using namespace std;
#include "aday.h"
#include "oncelik_kuyrugu.h"
Oncelik_Kuyrugu::Oncelik_Kuyrugu()
{
    ilk=NULL;
    bekleyen_sayisi=0;
}
void Oncelik_Kuyrugu::ekle(Aday *yeni)
{
    Aday *gecici, *onceki;

    if (ilk==NULL)//kuyruk bossa
        ilk=yeni;
    else
        if (yeni->boyOku()>ilk->boyOku()) {//kuyrugun en onune eklenecekse
            yeni->sonrakiAyarla(ilk);
            ilk=yeni;
        } else {
            onceki=ilk;
            gecici=ilk->sonrakiOku();
            while ((gecici!=NULL) && (gecici->boyOku()>yeni->boyOku())) {//eklenecek uygun yer araniyor
                onceki=gecici;
                gecici=gecici->sonrakiOku();
            }
            yeni->sonrakiAyarla(gecici);//onceki nesnesi ile gecici nesnesi arasina ekleniyor
            onceki->sonrakiAyarla(yeni);
        }

    bekleyen_sayisi++;
}
void Oncelik_Kuyrugu::bastanSil()
{
    Aday *gecici=ilk;

    ilk=ilk->sonrakiOku();
    gecici->yazdir();//silinmeden once yazdiriliyor
    delete gecici;
    bekleyen_sayisi--;
}
bool Oncelik_Kuyrugu::bos()
{
     return  bekleyen_sayisi==0;
     //return  ilk==NULL;
}
int Oncelik_Kuyrugu::bekleyen_sayisiOku()
{
    return bekleyen_sayisi;
}
void Oncelik_Kuyrugu::listele()
{
    Aday *gecici=ilk;

    while(gecici!=NULL) {
        gecici->yazdir();
        gecici=gecici->sonrakiOku();
    }
}
