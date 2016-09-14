#ifndef OGRENCI_DIZISI_H
#define OGRENCI_DIZISI_H

#include <iostream>
#include <iomanip>
#include <string.h>

#include "ogrenci.h"
#include "bilgisayar.h"

#include "tarih.h"

using namespace std;

class Ogrenci_dizisi
{
        friend ostream &operator<<(ostream &output, Ogrenci_dizisi &);
        friend istream &operator>>(istream &input, Ogrenci_dizisi &);
        friend ostream &operator<<(ostream &output, Ogrenci_dizisi* &);
        friend istream &operator>>(istream &input, Ogrenci_dizisi* &);
private:
        Ogrenci *ogrenci[1000];
public:
        Ogrenci_dizisi();
        virtual ~Ogrenci_dizisi();
        void setOgrenci(Ogrenci* []);
        Ogrenci ** getOgrenci(void);
        bool noya_gore_ogrenci_var_mi(int);
        void nolu_ogrenciyi_kaydet(int);
        void nolu_ogrenciyi_sil(int);
        void update(void);
        void siniftaki_ogrencileri_listele();
        void ogrencileri_ada_gore_listele();
        void tarihe_gore_ogrenci_listele(Tarih);
        void yila_gore_ogrenci_listele(int);
        void ogrencileri_seriye_gore_listele();
        void marka_modele_gore_listele();
};

#endif // OGRENCI_DIZISI_H
