#include <iostream>
#include <iomanip>
using namespace std;
#include "tarih.h"
#include "personel.h"
#include "cift_bagli_liste.h"
Cift_Bagli_Liste::Cift_Bagli_Liste(){bas->sonraki_tarih_ayarla(bas);bas->onceki_tarih_ayarla(bas);}
Personel *Cift_Bagli_Liste::ara(int no)
{
    Personel *gecici;
    gecici=bas->sonrakioku();
    while((gecici!=NULL)&&(gecici->getpersonel_no()<=no))
    {
        if(gecici->getpersonel_no()==no) return gecici;
        gecici=gecici->sonrakioku();
    }
    return NULL;
}
void Cift_Bagli_Liste::ekle(Personel *yeni){
    Personel *gecici;
    gecici=bas->sonraki_tarih_oku();
    while (gecici!=bas && gecici->geta_tarih()<yeni->geta_tarih())
    {
        gecici=gecici->sonraki_tarih_oku();
    }
    yeni->sonraki_tarih_ayarla(gecici);
    yeni->onceki_tarih_ayarla(gecici->onceki_tarih_oku());
    gecici->onceki_tarih_oku()->sonraki_tarih_ayarla(yeni);
    gecici->onceki_tarih_ayarla(yeni);
    }
void Cift_Bagli_Liste::sil(int no){
    Personel *kisi;
    kisi=ara(no);
    if (kisi)//kisi listede bulunduysa
    {
    //once kisiyi listeden cikar
    kisi->onceki_tarih_oku()->sonraki_tarih_ayarla(kisi->sonraki_tarih_oku());
    kisi->sonraki_tarih_oku()->onceki_tarih_ayarla(kisi->onceki_tarih_oku());
    free(kisi);//sonra kisiyi yok et
    cout<<"Personel silindi\n"<<endl;}
    else
    cout<<"Bu numaraya sahip bir personel yok\n"<<endl;
    }
bool Cift_Bagli_Liste::bos()
{
    return  bas->sonraki_tarih_oku()==bas;
}
void Cift_Bagli_Liste::listele(){
    Personel *gecici;
    gecici=bas->sonraki_tarih_oku();
    while (gecici!=bas)
    {
        cout<<gecici<<endl;
        gecici=gecici->sonraki_tarih_oku();
    }
}
