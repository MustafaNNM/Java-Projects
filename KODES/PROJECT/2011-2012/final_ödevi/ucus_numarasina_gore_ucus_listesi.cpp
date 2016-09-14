#include "ucus_numarasina_gore_ucus_listesi.h"
#include "ucus.h"

#include <iostream>

using namespace std;

Ucus_Numarasina_Gore_Ucus_Listesi::Ucus_Numarasina_Gore_Ucus_Listesi()
{
        ucus_listesi=NULL;
}

ostream &operator<<(ostream &cikti, const Ucus_Numarasina_Gore_Ucus_Listesi &liste)
{
        Ucus* gecici=liste.ucus_listesi;
        while(gecici!=NULL) {
                cikti<<gecici;
                gecici=gecici->getSonraki_ucus();
        }

        return cikti;
}

Ucus_Numarasina_Gore_Ucus_Listesi::~Ucus_Numarasina_Gore_Ucus_Listesi()
{
        //dtor
}

void Ucus_Numarasina_Gore_Ucus_Listesi::Normal_ucus_ekle(Ucus* yeni)
{
        Ucus *gecici, *onceki;

        if (getUcus_listesi()==NULL) {//kuyruk bossa
                yeni->setSonraki_ucus(NULL);
                ucus_listesi=yeni;
        } else if (yeni->getUcus_no()<getUcus_listesi()->getUcus_no()) { //en basa eklenecekse
                yeni->setSonraki_ucus(getUcus_listesi());
                setUcus_listesi(yeni);
        } else {//araya ya da sona eklenecekse
                onceki=getUcus_listesi();
                gecici=getUcus_listesi()->getSonraki_ucus();
                while ((gecici!=NULL) && (gecici->getUcus_no(),yeni->getUcus_no())) {//eklenecek uygun yer araniyor
                        onceki=gecici;
                        gecici=gecici->getSonraki_ucus();
                }
                yeni->setSonraki_ucus(gecici);//gecici NULL ise en sona, degilse onceki dugumu ile gecici dugumu arasina ekleniyor
                onceki->setSonraki_ucus(yeni);
        }

        cout<<"Eklenen Ucus:\n"<<*yeni<<endl;
}
Ucus* Ucus_Numarasina_Gore_Ucus_Listesi::Ucus_ara(int no){
    Ucus *gecici;

    gecici=getUcus_listesi();

    while (gecici!=NULL)//||gecici->getUcus_no()>no
    {
        if (gecici->getUcus_no()==no)
        {
            return gecici;
        }
        gecici=gecici->getSonraki_ucus();
    }
    return NULL;
}
void Ucus_Numarasina_Gore_Ucus_Listesi::setUcus_listesi(Ucus *liste)
{
        ucus_listesi=liste;
}

Ucus* Ucus_Numarasina_Gore_Ucus_Listesi::getUcus_listesi()
{
        return ucus_listesi;
}
