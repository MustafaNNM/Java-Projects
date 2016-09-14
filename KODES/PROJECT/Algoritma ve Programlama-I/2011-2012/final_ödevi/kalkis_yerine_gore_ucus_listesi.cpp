#include "kalkis_yerine_gore_ucus_listesi.h"

#include "ucus.h"
#include <iostream>

using namespace std;

Kalkis_Yerine_Gore_Ucus_Listesi::Kalkis_Yerine_Gore_Ucus_Listesi()
{
        //ctor
        hash_tablosu->setAda_gore_sonraki_ucus(hash_tablosu);
        hash_tablosu->setAda_gore_onceki_ucus(hash_tablosu);

}

Kalkis_Yerine_Gore_Ucus_Listesi::~Kalkis_Yerine_Gore_Ucus_Listesi()
{
        //dtor
}
