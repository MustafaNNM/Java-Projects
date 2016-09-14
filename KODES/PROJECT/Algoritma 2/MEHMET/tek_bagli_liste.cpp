#include <iostream>
#include <iomanip>
#include "tarih.h"
#include "personel.h"
#include "tek_bagli_liste.h"
using namespace std;
Tek_Bagli_Liste::Tek_Bagli_Liste(){
    ilk->sonraki_ayarla(ilk);
    }
Personel *Tek_Bagli_Liste::ara(int no)
{
    Personel *gecici;
    cout<<"ok"<<endl;
    ilk->setm_k(3.4);
    cout<<ilk->getm_k();
    printf("%d",ilk->getpersonel_no());
    gecici=ilk->sonrakioku();
    while((gecici!=ilk)&&(gecici->getpersonel_no()<=no))
    { cout<<"ok"<<endl;
        if(gecici->getpersonel_no()==no) return gecici;
        gecici=gecici->sonrakioku();
    }

    return NULL;
}
void Tek_Bagli_Liste::ekle(Personel *yeni)
{
Personel *onceki,*gecici;
cout<<"ok"<<endl;
    onceki=ilk;cout<<"ok"<<endl;
    gecici=ilk;
    //gecici=ilk->sonrakioku();cout<<"ok"<<endl;
    while(gecici!=ilk && gecici->getpersonel_no()<yeni->getpersonel_no())
    {cout<<"ok"<<endl;
        onceki=gecici;
        gecici=gecici->sonrakioku();
    }

    yeni->sonraki_ayarla(gecici);
    onceki->sonraki_ayarla(yeni);
}
void Tek_Bagli_Liste::sil(int no)
{
    Personel *onceki,*gecici,*silinecek_ptr;
    silinecek_ptr=ara(no);

    if(ilk==silinecek_ptr)//silinecek dugum, ilk dugum ise...
        ilk=ilk->sonrakioku();//ilk_ptr'yi guncelle
    else {
        onceki=ilk;
        gecici=ilk->sonrakioku();
        while(gecici!=silinecek_ptr)
        {
            onceki=gecici;
            gecici=gecici->sonrakioku();
        }

        onceki->sonraki_ayarla(gecici->sonrakioku());
    }
    delete silinecek_ptr;
}
bool Tek_Bagli_Liste::bos()
{
    return  ilk==ilk->sonrakioku();
}
void Tek_Bagli_Liste::listele()
{
    Personel *gecici;

    gecici=ilk->sonrakioku();;
    while(gecici!=ilk) {
        cout<<gecici<<endl;
        gecici=gecici->sonrakioku();
    }
}
ostream &operator<<(ostream& output,const Tek_Bagli_Liste &personel)
{
    output<<personel.ilk;//buraya do while mý gerekiyor hocaya sor
    return output;
}
