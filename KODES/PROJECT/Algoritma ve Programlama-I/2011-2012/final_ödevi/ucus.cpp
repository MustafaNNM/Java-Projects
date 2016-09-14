#include "ucus.h"


#include <iostream>
#include <iomanip>
#include <cctype>

using namespace std;

Ucus::Ucus(int no,int normal,int luks):ucus_no(no),normal_ks(normal),luks_ks(luks)
{
        //ctor
        kalkis_yeri[0]='\0';
        varis_yeri[0]='\0';
        kalkis_zamani[0]='\0';
}
Ucus::Ucus(int no,char *kalkis,char *varis,char *zaman,int normal,int luks):ucus_no(no),normal_ks(normal),luks_ks(luks)
{
        //ctor
        setKalkis_yeri(kalkis);
        setVaris_yeri(varis);
        setKalkis_zamani(zaman);
}
//asiri yuklenmis cikti operatoru
ostream &operator<<(ostream &cikti, const Ucus &ucus)
{
        cikti <<"Ucus no:"<<setw(-5)<<ucus.ucus_no<<"\n"
        <<"Kalkis yeri"<<setw(-20)<<ucus.kalkis_yeri<<"\n"
        <<"Varis yeri"<<setw(-20)<<ucus.varis_yeri<<"\n"
        <<"Kalkis zamani"<<setw(-5)<<ucus.kalkis_zamani<<"\n"
        <<"Normal koltuk sayisi"<<setw(-5)<<ucus.normal_ks<<"\n"
        <<"Luks koltuk sayisi"<<setw(-5)<<ucus.luks_ks<<"\n";

        return cikti;
}

//asiri yuklenmis girdi operatoru
istream &operator>>(istream &girdi, Ucus &ucus)
{
        cout<<"Kalkis yerini giriniz:";
        girdi>>setw(21)>>ucus.kalkis_yeri;
        ucus.kalkis_yeri[20]='\0';
        int i;
        for(i=0; i<20; i++) {
                ucus.kalkis_yeri[i]=tolower(ucus.kalkis_yeri[i]);
        }
        girdi.ignore();
        cout<<"Varis yerini giriniz:";
        girdi>>setw(21)>>ucus.varis_yeri;
        ucus.varis_yeri[20]='\0';
        for(i=0; i<20; i++) {
                ucus.varis_yeri[i]=tolower(ucus.varis_yeri[i]);
        }
        girdi.ignore();
        cout<<"Kalkis saatini giriniz:";
        girdi>>setw(6)>>ucus.kalkis_zamani;
        ucus.kalkis_zamani[5]='\0';
        girdi.ignore();
        return girdi;
}

Ucus::~Ucus()
{
        //dtor
}
//set functions

void Ucus::setKalkis_yeri(char *kalkis)
{
        int i;
        for(i=0; i<21; i++) {
                kalkis_yeri[i]=tolower(kalkis[i]);
        }
}
void Ucus::setVaris_yeri(char *varis)
{
        int i;
        for(i=0; i<21; i++) {
                varis_yeri[i]=tolower(varis[i]);
        }
}
void Ucus::setKalkis_zamani(char *zaman)
{
        int i;
        for(i=0; i<6; i++) {
                kalkis_zamani[i]=zaman[i];
        }
}
void Ucus::setSonraki_ucus(Ucus *yeni)
{
        sonraki_ucus=yeni;
}
void Ucus::setAda_gore_sonraki_ucus(Ucus *yeni)
{
        ada_gore_sonraki_ucus=yeni;
}
void Ucus::setAda_gore_onceki_ucus(Ucus *yeni)
{
        ada_gore_onceki_ucus=yeni;
}
//get functions
int Ucus::getUcus_no()
{
        return ucus_no;
}
char *Ucus::getKalkis_yeri()
{
        return kalkis_yeri;
}
char *Ucus::getVaris_yeri()
{
        return varis_yeri;
}
char *Ucus::getKalkis_zamani()
{
        return kalkis_zamani;
}
int Ucus::getNormal_ks()
{
        return normal_ks;
}
int Ucus::getLuks_ks()
{
        return luks_ks;
}
Ucus* Ucus::getSonraki_ucus()
{
        return sonraki_ucus;
}
Ucus* Ucus::getAda_gore_sonraki_ucus()
{
        return ada_gore_sonraki_ucus;
}
Ucus* Ucus::getAda_gore_onceki_ucus()
{
        return ada_gore_onceki_ucus;
}
