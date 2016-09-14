#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

struct personel
{
    char tel_no[8];
    char adi[11];
    char soyadi[13];
    char adresi[13];
    char abone_tipi;
    struct personel *tel_noya_gore_sonraki;
    struct mesai *o_personelin_mesai_verileri_listesinin_liste_basi_dugumu;
};

struct mesai
{
    char tarih[9];
    char aranan_numara[11];
    char baslangic_zamani[5];
    int sure;//dakika
    struct mesai *ayni_personel_icin_gune_gore_onceki;
    struct mesai *ayni_personel_icin_gune_gore_sonraki;
    struct mesai *ayni_gun_icin_sonraki;
};



int main()
{
    struct personel tel_no[100];//hash tablosu tek bagli liste

    struct personel *p_s_adi[26]=
    {
        NULL
    };//hash tablosu dairesel tek bagli


    struct mesai *gun[31]=
    {
        NULL
    };
    return 0;
}
