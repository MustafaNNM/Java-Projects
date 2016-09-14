#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>

typedef struct ogrenci Ogrenci;

struct ogrenci {
        int ogrenci_numarasi;
        char adi_soyadi[31];
        int sinifi;
        int donemlik_aldigi_kredi_sayisi;
        float donemlik_agirlikli_not_ortalamasi;
        Ogrenci *sonraki_ogrenci;
};

int menu(void);
int hash(int ogrenci_numarasi);
void hash_ekle(Ogrenci** bas,Ogrenci* yeni);
void ogrenci_listele(Ogrenci *bas,int ogrenci_numarasi);
void tek_bagli_ogrenci_listele(Ogrenci *bas);
void hash_tablosu_listele(Ogrenci* hash_tablosu[]);
void yeni_ogrenci_ekle(Ogrenci* ogrenci_listesi[],Ogrenci* hash_tablosu[]);


void* bir_ogrenci(int ogrenci_numarasi);
int ogrenci_numarasi_gir(void);
void printf_ogrenci(Ogrenci bir_ogrenci);
void printf_ogrenci_ptr(Ogrenci* bir_ogrenci);

int main()
{
        int secim;
        //int ogrenci_numarasi;

        //Ogrenci* bir_ogrenci=NULL;
        Ogrenci* hash_tablosu[100]= {NULL}; //Tek bagli liste
        Ogrenci* ogrenci_listesi[10000]= {NULL}; //isaretci dizisi hizli erisim icin

        for (; ; ) {
                secim=menu();
                switch (secim) {
                case 1:
                        //Yeni bir ogrencinin eklenmesi
                        yeni_ogrenci_ekle(ogrenci_listesi,hash_tablosu);
                        break;
                case 2:
                        //Yeni bir dersin eklenmesi
                        break;
                case 3:
                        //Bir dersi alan ogrencilerin notlarinin eklenmesi
                        break;
                case 4:
                        //Bir dersi alan bir ogrencinin notunun guncellenmesi
                        break;
                case 5:
                        //Bir ogrecinin silinmesi
                        break;
                case 6:
                        //Bir dersin bilgilerinin ve o dersi alan ogrencilerin listelenmesi
                        break;
                case 7:
                        //Bir dersi alan ogrencilerden, notu belirli bir notun ustunde olan ogrencilerin listelenmesi
                        break;
                case 8:
                        //Bir dersi alan ogrencilerden, notu belirli bir notun altinda olan ogrencilerin listelenmesi
                        break;
                case 9:
                        //Bir donemin derslerinin listelenmesi
                        break;
                case 10:
                        //Bir ogrencinin bilgilerinin listelenmesi
                        break;
                case 11:
                        //Bir ogrencinin bilgilerinin ve aldigi derslerin listelenmesi
                        break;
                case 12:
                        //Bir sinifta okuyan ogrencilerin listelenmesi
                        break;
                default:
                        //Cikis
                        exit(EXIT_SUCCESS);
                        break;
                }

        }
        return 0;
}
int menu(void)
{
        int secim;

        printf("0)  Cikis\n");
        printf("1)  Yeni Bir Ogrenci Eklenmesi\n");
        printf("2)  Yeni Bir Ders Eklenmesi\n");
        printf("3)  Ogrencilerin Notlarinin Eklenmesi\n");
        printf("4)  Ogrencinin Notunun Guncellenmesi\n");
        printf("5)  Yeni Bir Ogrencinin Silinmesi\n");
        printf("6)  Bir Dersin Bilgilerini Ve Onu Alan Ogrencilerin Listelenmesi\n");
        printf("7)  Notu Belirli Bir Notun Ustunde Olan Ogrencilerin Listelenmesi\n");
        printf("8)  Notu Belirli Bir Notun Altinda Olan Ogrencilerin Liztelenmesi\n");
        printf("9)  Bir Doneme Ait Derslerin Listelenmesi\n");
        printf("10) Bir Ogrencinin Bilgilerinin Listelenmesi\n");
        printf("11) Bir Ogrencinin Bilgilerinin Ve Aldigi Derslerin Listelenmesi\n");
        printf("12) Bir Sinifta Okuyan Ogrencilerin Listelenmesi\n");


        do {
                printf("\nSeciminizi giriniz\n?");
                scanf("%d",&secim);
        } while (secim<0 || secim>12);

        return secim;
}
int hash(int ogrenci_numarasi)
{
        return (ogrenci_numarasi-1)/100+1;
}
void hash_ekle(Ogrenci** bas,Ogrenci* yeni)
{
        Ogrenci *gecici, *onceki;

        if (*bas==NULL) {//kuyruk bossa
                yeni->sonraki_ogrenci=NULL;
                *bas=yeni;
        } else if (yeni->ogrenci_numarasi<(*bas)->ogrenci_numarasi) { //en basa eklenecekse
                yeni->sonraki_ogrenci=*bas;
                *bas=yeni;
        } else {//araya ya da sona eklenecekse
                onceki=*bas;
                gecici=(*bas)->sonraki_ogrenci;
                while ((gecici!=NULL) && (gecici->ogrenci_numarasi<yeni->ogrenci_numarasi)) {//eklenecek uygun yer araniyor
                        onceki=gecici;
                        gecici=gecici->sonraki_ogrenci;
                }
                yeni->sonraki_ogrenci=gecici;//gecici NULL ise en sona, degilse onceki dugumu ile gecici dugumu arasina ekleniyor
                onceki->sonraki_ogrenci=yeni;
        }
        //printf("Ogr No  Ad Soyad                       Sinif Kredi Say Not Ort\n");
        //printf("------- ------------------------------ ----- --------- -------\n");
        //printf_ogrenci_ptr(yeni);

}
void ogrenci_listele(Ogrenci *bas,int ogrenci_numarasi)
{
        Ogrenci* gecici=bas->sonraki_ogrenci;

        while((gecici!=NULL)&&(gecici->ogrenci_numarasi<ogrenci_numarasi)) {
                if (gecici->ogrenci_numarasi==ogrenci_numarasi) {
                        printf_ogrenci_ptr(gecici);
                }
                gecici=gecici->sonraki_ogrenci;
        }
}
void tek_bagli_ogrenci_listele(Ogrenci *bas)//kuyrugun ilk dugumunun adresi call-by-value ile aktariliyor
{
        while(bas!=NULL) {
                printf_ogrenci_ptr(bas);
                bas=bas->sonraki_ogrenci;//bas bir sonraki dugumu gosteriyor ama main'deki ilk degismiyor
        }
}
void hash_tablosu_listele(Ogrenci* hash_tablosu[])
{
        //int i=0;

        printf("Ogr No  Ad Soyad                       Sinif Kredi Say Not Ort\n");
        printf("------- ------------------------------ ----- --------- -------\n");

        //for (i=0; i<100; i++) {
        printf("%d ",1+1);
        //hash_tablosu[1].adi_soyadi[0]='m';
        //printf_ogrenci(hash_tablosu[1]);
        tek_bagli_ogrenci_listele(hash_tablosu[1]);
        //}
}
void yeni_ogrenci_ekle(Ogrenci* ogrenci_listesi[],Ogrenci* hash_tablosu[])
{
        //int i;
        int ogrenci_numarasi;
        Ogrenci* data_ogrenci;
        ogrenci_numarasi=ogrenci_numarasi_gir();//Ogrenci numarasi aliniyor
        if(ogrenci_listesi[ogrenci_numarasi-1]!=NULL) {
                printf("Ekleme yapilamaz!#%d nolu ogrenci mevcut!",ogrenci_numarasi);
        } else {
                data_ogrenci=bir_ogrenci(ogrenci_numarasi);
                ogrenci_listesi[ogrenci_numarasi-1]=data_ogrenci;//Ucus ekleniyor;
                hash_ekle(&hash_tablosu[hash(ogrenci_numarasi)],data_ogrenci);
                //printf_ogrenci_ptr(hash_tablosu[1]);
                //tek_bagli_ogrenci_listele(&hash_tablosu[1]);
                //hash_tablosu[1].adi_soyadi[0]='m';
                //hash_tablosu[1].ogrenci_numarasi=77;
                //printf("Ogr No  Ad Soyad                       Sinif Kredi Say Not Ort\n");
                //printf("------- ------------------------------ ----- --------- -------\n");
                //printf_ogrenci_ptr(data_ogrenci);
                hash_tablosu_listele(hash_tablosu);
                //printf_ogrenci_ptr(ogrenci_listesi[ogrenci_numarasi-1]);
        }
}
void* bir_ogrenci(int ogrenci_numarasi)
{
        Ogrenci* data_ogrenci;

        do {
                data_ogrenci=malloc(sizeof(Ogrenci));
        } while(data_ogrenci==NULL);

        data_ogrenci->ogrenci_numarasi=ogrenci_numarasi;
        printf("Ogrencinin adini soyadini giriniz\n?");
        fflush(stdin);
        gets(data_ogrenci->adi_soyadi);
        fflush(stdin);
        printf("Ogrencinin sinifini giriniz\n?");
        scanf("%d",&data_ogrenci->sinifi);
        fflush(stdin);
        data_ogrenci->donemlik_aldigi_kredi_sayisi=0;
        data_ogrenci->donemlik_agirlikli_not_ortalamasi=0;
        data_ogrenci->sonraki_ogrenci=NULL;
        //data_ogrenci->satilan_biletler=NULL;

        return data_ogrenci;
}
int ogrenci_numarasi_gir(void)
{
        int ogrenci_numarasi;

        printf("Ogrenci numarasini giriniz\n[1-10000]?");
        scanf("%d",&ogrenci_numarasi);
        fflush(stdin);
        while(ogrenci_numarasi<1 || ogrenci_numarasi>10000) {
                printf("\nHatali girdiniz!!!\nOgrenci numarasini tekrar giriniz:\n[1-10000]?");
                scanf("%d", &ogrenci_numarasi);
                fflush(stdin);
        }

        return ogrenci_numarasi;
}
void printf_ogrenci(Ogrenci bir_ogrenci)
{
        //printf("Ogr No  Ad Soyad                       Sinif Kredi Say Not Ort\n");
        //printf("------- ------------------------------ ----- --------- -------\n");
        printf("%-8d%-31s%-6d%-10d%.2f\n",bir_ogrenci.ogrenci_numarasi,bir_ogrenci.adi_soyadi,bir_ogrenci.sinifi,bir_ogrenci.donemlik_aldigi_kredi_sayisi,bir_ogrenci.donemlik_agirlikli_not_ortalamasi);
}
void printf_ogrenci_ptr(Ogrenci* bir_ogrenci)
{
        //printf("Ogr No  Ad Soyad                       Sinif Kredi Say Not Ort\n");
        //printf("------- ------------------------------ ----- --------- -------\n");
        if (bir_ogrenci!=NULL) {
                printf("%-8d%-31s%-6d%-10d%.2f\n",bir_ogrenci->ogrenci_numarasi,bir_ogrenci->adi_soyadi,bir_ogrenci->sinifi,bir_ogrenci->donemlik_aldigi_kredi_sayisi,bir_ogrenci->donemlik_agirlikli_not_ortalamasi);
        } else {
                printf("null print_ogr_ptr");
        }
}
