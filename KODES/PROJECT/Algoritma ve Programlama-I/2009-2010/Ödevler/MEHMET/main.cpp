#include <iostream>
#include <iomanip>
using namespace std;
#include "tarih.h"
#include "personel.h"
#include "tek_bagli_liste.h"
#include "cift_bagli_liste.h"
int menu();
int main(){
    //Cift_Bagli_Liste cift;
    Tek_Bagli_Liste *tek;
    Personel *kisi;
    int secim,no,sure,d_g,d_a,d_y,a_g,a_a,a_y;
    char ad[13],soyad[13],unvan[13];
    float m_k;
    do
    {
    secim=menu();
    switch(secim)
    {
     case 1:
     cout<<"Personel no giriniz\n?";
     cin>>no;
     //if(tek->ara(no)==gecici->getpersonel_no()){
     cout<<"Personel ad giriniz\n?";
     cin>>ad;
     cout<<"Personel soyad giriniz\n?";
     cin>>soyad;
     cout<<"Personel unvan giriniz\n?";
     cin>>unvan;
     cout<<"Personel maas katsayisi giriniz\n?";
     cin>>m_k;
     cout<<"Personel dogum-atanma gun-ay-yil verilerini aralarinda bosluk birakarak giriniz\n?";
     cin>>d_g>>d_a>>d_y>>a_g>>a_a>>a_y;sure=0;
     kisi=new Personel(no,sure,ad,soyad,unvan,m_k,d_g,d_a,d_y,a_g,a_a,a_y);//yeni gelen personel icin Personel sinifindan bir nesne turetiliyor
     tek->ekle(kisi);
     //cift.ekle(kisi);
     //}
     break;
     case 2:break;
     case 3:break;
     case 4:break;
     case 5:break;
     case 6:break;
     case 7:break;
     case 8:break;
     case 9:break;
     case 10:break;
     case 11:break;
     case 12:break;
    }
    }while(secim!=0);
    return 0;
    }
int menu(){
    int sayi;
    cout<<
    "  0) Cikis\n"<<
    "  1) Ilk defa memur olan bir personelin kuruma atanmasi\n"<<
    "  2) Baska bir kurumdan nakil olan bir personelin kuruma atanmasi\n"<<
    "  3) Bir personelin unvan ve maas katsayisinin guncellenmesi\n"<<
    "  4) Bir personelin silinmesi\n"<<
    "  5) Bir personelin bilgilerinin listelenmesi\n"<<
    "  6) Tum personelin, personel numarasi sirasina gore listelenmesi\n"<<
    "  7) Tum personelin, kuruma atanma tarihi sirasina gore listelenmesi\n"<<
    "  8) Belirli bir tarihten sonra kuruma atanan personelin listelenmesi\n"<<
    "  9) Belirli bir yilda kuruma atanan personelin listelenmesi\n"<<
    " 10) Belirli bir tarihten once dogmus personelin listelenmesi\n"<<
    " 11) Belirli bir ayda dogmus personelin listelenmesi\n"<<
    " 12) Belirli bir unvana sahip personelden,\n     "<<
    "kuruma en son atanan personelin bilgilerinin listelenmesi\n"<<
    endl;
    do{
    cout<<"Seciminiz\n?";
    cin>>sayi;
    }while(sayi<0&&sayi>12);
    return sayi;
    }
