#ifndef CIFT_BAGLI_LISTE_H_INCLUDED
#define CIFT_BAGLI_LISTE_H_INCLUDED
#include "tarih.h"
#include "personel.h"
class Cift_Bagli_Liste{
    private:
    Personel *bas;
    public:
    Cift_Bagli_Liste();
    Personel *ara(int);
    void ekle(Personel *);
    void sil(int);
    bool bos();
    void listele();
    };
#endif // CIFT_BAGLI_LISTE_H_INCLUDED
