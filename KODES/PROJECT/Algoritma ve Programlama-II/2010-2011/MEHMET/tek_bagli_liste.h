#ifndef TEK_BAGLI_LISTE_H_INCLUDED
#define TEK_BAGLI_LISTE_H_INCLUDED
#include "tarih.h"
#include "personel.h"
class Tek_Bagli_Liste {
    private:
    Personel *ilk;
    public:
    Tek_Bagli_Liste();
    Personel *ara(int);
    void ekle(Personel *);
    void sil(int);
    bool bos();
    void listele();
    friend ostream &operator<<( ostream&, const Tek_Bagli_Liste & );
    };
#endif // TEK_BAGLI_LISTE_H_INCLUDED
