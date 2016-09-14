#include <iostream>
#include <iomanip>
#include <string.h>

#include "ogrenci_dizisi.h"
#include "ogrenci.h"
#include "bilgisayar.h"
#include "tarih.h"

using namespace std;

ostream &operator<<(ostream &output, Ogrenci_dizisi &ogrenci_dizisi)
{
        int i;
        for(i=0; i<1000; i++) {
                if(ogrenci_dizisi.getOgrenci()[i]!=NULL) {
                        output<<ogrenci_dizisi.getOgrenci()[i]<<"\n";
                }
        }

        return output;
}
istream &operator>>(istream &input, Ogrenci_dizisi &ogrenci_dizisi)
{
        int i;

        cout<<"tum ogrencilerin bilgilerini giriniz\n";

        for(i=0; i<1000; i++) {
                input>>ogrenci_dizisi.getOgrenci()[i];
        }

        return input;
}
ostream &operator<<(ostream &output, Ogrenci_dizisi* &ogrenci_dizisi)
{
        int i;
        for(i=0; i<1000; i++) {
                if(ogrenci_dizisi->getOgrenci()[i]!=NULL) {
                        output<<ogrenci_dizisi->getOgrenci()[i]<<"\n";
                }
        }
        return output;
}
istream &operator>>(istream &input, Ogrenci_dizisi* &ogrenci_dizisi)
{
        int i;

        cout<<"tum ogrencilerin bilgilerini giriniz\n";

        for(i=0; i<1000; i++) {
                input>>ogrenci_dizisi->getOgrenci()[i];
        }

        return input;
}
Ogrenci_dizisi::Ogrenci_dizisi()
{
        //ctor
        int i;
        for(i=0; i<1000; i++) {
                getOgrenci()[i]=NULL;
        }
}
Ogrenci_dizisi::~Ogrenci_dizisi()
{
        //dtor
        delete [] ogrenci;
}
void Ogrenci_dizisi::setOgrenci(Ogrenci* ogr[])
{
        int i;

        for(i=0; i<1000; i++) {
                ogrenci[i]=ogr[i];
        }

}
Ogrenci ** Ogrenci_dizisi::getOgrenci(void)
{
        return ogrenci;
}
bool Ogrenci_dizisi::noya_gore_ogrenci_var_mi(int numara)
{
        bool varmi;
        if(getOgrenci()[numara-1]!=NULL) {
                varmi=true;
        } else {
                varmi=false;
        }
        return varmi;
}
void Ogrenci_dizisi::nolu_ogrenciyi_kaydet(int numara)
{
        this->ogrenci[numara-1]=new Ogrenci();
        this->ogrenci[numara-1]->setOgrenci_numarasi(numara);
        cin>>this->ogrenci[numara-1];
}
void Ogrenci_dizisi::update(void)
{
        int i=0,sinif;
        float ort;
        for(i=0; i<1000; i++) {
                if(this->getOgrenci()[i]!=NULL) {
                        cout<<i+1<<" numarali ogrencinin bilgilerini guncelliyorsunuz ! \n";
                        cout<<"Ogrenci guncellemek istediginiz yeni sinifi giriniz\n";
                        cin>>sinif;
                        cout<<"Ogrenci guncellemek istediginiz yeni ortalamasini giriniz\n";
                        cin>>ort;
                        this->getOgrenci()[i]->setSinifi(sinif);
                        this->getOgrenci()[i]->setNot_ortalamasi(ort);
                }
        }
}
void Ogrenci_dizisi::nolu_ogrenciyi_sil(int numara)
{
        this->ogrenci[numara-1]=NULL;
}
void Ogrenci_dizisi::siniftaki_ogrencileri_listele()
{
        int i,sinif,j=0;

        cout<<"Listelemek istediginiz ogrencileri sinifini giriniz\n";
        cin>>sinif;

        cout<<"\nOgr No  Ad          Soyad            Sinif  Not Ort"<<endl;
        cout<<"------  ----------  ---------------  -----  -------"<<endl;
        for(i=0; i<1000; i++) {
                if(this->getOgrenci()[i]!=NULL&&this->getOgrenci()[i]->getSinifi()==sinif) {
                        cout<<this->getOgrenci()[i];
                        j++; //siniftaki ogrenci sayisi tutmak icin
                }
        }
        cout << "sinifin ogrenci sayisi :\t"<<j;
}
void Ogrenci_dizisi::ogrencileri_ada_gore_listele()
{
        int i;
        char ad[16];
        cout<<"Listelemek istediginiz ogrencileri adini giriniz\n";
        cin>>setw(16)>>ad;
        cout<<"\nOgr No  Ad          Soyad            Sinif  Not Ort"<<endl;
        cout<<"------  ----------  ---------------  -----  -------"<<endl;
        for(i=0; i<1000; i++) {
                if(this->getOgrenci()[i]!=NULL&&strcmp(this->getOgrenci()[i]->getAdi(),ad)==0) {
                        cout<<this->getOgrenci()[i];
                }

        }
}
void Ogrenci_dizisi::tarihe_gore_ogrenci_listele(Tarih tarih)
{
        int i=0;
        for(i=0; i<1000; i++) {
                if(this->getOgrenci()[i]!=NULL&&this->getOgrenci()[i]->getDogum_tarihi()<tarih) {
                        {
                                cout<<this->ogrenci[i];
                        }
                }
        }
}
void Ogrenci_dizisi::yila_gore_ogrenci_listele(int yil)
{
        int i=0;
        for(i=0; i<1000; i++) {
                if(this->getOgrenci()[i]!=NULL&&this->getOgrenci()[i]->getKayit_tarihi().getYil()>yil) {
                        {
                                cout<<this->ogrenci[i];
                        }
                }
        }
}
void Ogrenci_dizisi::ogrencileri_seriye_gore_listele()
{
        int i;
        char seri[13];
        cout<<"Listelemek istediginiz bilgisayarin seri nosunu giriniz\n";
        cin>>setw(13)>>seri;
        cout<<"\nOgr No  Ad          Soyad            Sinif  Not Ort"<<endl;
        cout<<"------  ----------  ---------------  -----  -------"<<endl;
        for(i=0; i<1000; i++) {
                if(this->getOgrenci()[i]!=NULL&&strcmp(this->getOgrenci()[i]->getTasinabilir_bilgisayar().getSeri(),seri)==0) {
                        cout<<this->getOgrenci()[i];
                }
        }
}
void Ogrenci_dizisi::marka_modele_gore_listele()
{
        int i=0;
        char marka[11];
        char model[11];

        cout<<"Listelemek istediginiz ogrencinin bilgisayarinin markasini giriniz \n";
        cin>>setw(11)>>marka;
        cout<<"Listelemek istediginiz ogrencinin bilgisayarinin modelini giriniz \n";
        cin>>setw(11)>>model;

        for(i=0; i<1000; i++) {
                if(this->getOgrenci()[i]!=NULL &&strcmp(this->getOgrenci()[i]->getTasinabilir_bilgisayar().getMarka(),marka)==0 &&strcmp(this->getOgrenci()[i]->getTasinabilir_bilgisayar().getModel(),model)==0) {
                        cout<<this->getOgrenci()[i];
                }
        }
}
