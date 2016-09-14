#ifndef UCUS_NUMARASINA_GORE_UCUS_LISTESI_H
#define UCUS_NUMARASINA_GORE_UCUS_LISTESI_H

#include "ucus.h"
#include <iostream>

using namespace std;

class Ucus_Numarasina_Gore_Ucus_Listesi
{
        friend ostream &operator<<(ostream &cikti, const Ucus_Numarasina_Gore_Ucus_Listesi &liste);
public:
        Ucus_Numarasina_Gore_Ucus_Listesi();
        virtual ~Ucus_Numarasina_Gore_Ucus_Listesi();
        void Normal_ucus_ekle(Ucus*);
        Ucus* Ucus_ara(int);
        //set functions
        void setUcus_listesi(Ucus* liste);
        //get functions
        Ucus* getUcus_listesi();
protected:
private:
        Ucus* ucus_listesi;//tek-baðlý liste
};

#endif // UCUS_NUMARASINA_GORE_UCUS_LISTESI_H
