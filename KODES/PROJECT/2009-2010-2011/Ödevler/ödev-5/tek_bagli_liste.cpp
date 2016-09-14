#include <iostream>
#include <iomanip>
#include "personel.h"
#include "tek_bagli_liste.h"
using namespace std;
Tek_Bagli_Liste::Tek_Bagli_Liste(){ilk=NULL;}
Personel *Tek_Bagli_Liste::ara(int no)
{
    Personel *gecici;
    gecici=ilk.sonrakioku();
    while((gecici!=NULL)&&(gecici->getpersonel_no()<=no))
    {
        if(gecici->getpersonel_no()==no) return gecici;
        gecici=gecici->sonrakioku();
    }

    return NULL;
}
void Tek_Bagli_Liste::ekle(Personel yeni)
{
    Personel *gecici,*onceki;
    if(ara(yeni.getpersonel_no())==NULL)
    {
    if (ilk==NULL)//kuyruk bossa
        ilk=yeni;
    else
        if (yeni.getpersonel_no()<ilk.getpersonel_no()) {//kuyrugun en onune eklenecekse
            yeni.sonrakiayarla(ilk);
            ilk=yeni;
        } else {
            onceki=ilk;
            gecici=ilk.sonrakioku();
            while ((gecici!=NULL) && (gecici->getpersonel_no()<yeni.getpersonel_no())) {//eklenecek uygun yer araniyor
                onceki=gecici;
                gecici=gecici->sonrakioku();
            }
            yeni.sonrakiayarla(gecici);//onceki nesnesi ile gecici nesnesi arasina ekleniyor
            onceki->sonrakiayarla(yeni);
        }
    }
}
void Tek_Bagli_Liste::bastansil()
{
    Personel gecici=ilk;

    ilk=ilk.sonrakioku();
    cout<<gecici<<endl;//silinmeden once yazdiriliyor
    delete gecici;
}
bool Tek_Bagli_Liste::bos()
{
    return  ilk==NULL;
}
void Tek_Bagli_Liste::listele()
{
    Personel gecici=ilk;

    while(gecici!=NULL) {
        cout<<gecici<<endl;
        gecici=gecici.sonrakioku();
    }
}
ostream &operator<<(ostream& output,const Tek_Bagli_Liste &personel)
{
    output<<personel.ilk;//buraya do while mý gerekiyor hocaya sor
    return output;
}
