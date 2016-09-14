#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>

struct Ogrenci {
        int ogr_no;
        char ad_soyad[31];
        int sinifi;
        int donem_kredi_sayisi;
        float donem_agirlik_ort;
        struct Ogrenci *sonraki;
};

struct Not {
        int ogr_nr;
        int ogr_notu;
        struct Not *no_sonraki;
        struct Not *no_onceki;
        struct Not *ogr_sonraki;
};
struct Ders {

        int ders_kodu;
        char ders_adi[26];
        int ders_kredisi;
        int dersi_alan_ogr_sayisi;
        float dersin_not_ort;

        struct Not *ders_ptr;//Siz bunu pointer yapmamistiniz ama bende oyle kabul etmiyo

};

int menu(void);
void baslik_yazdir();
void ogr_no_al(int *ogrno);
void ders_kodu_al(int *derskal);
void ders_donemini_al(int *dersdonem);
void ders_notu_al(int *);
void Sinif_kod_al(int *sinif_kod);
void ogr_noile_ekle(struct Ogrenci **bas_ptr, int no);
int ders_kodu_bul(struct Ders *ders_bas_ptr,int kod);
void ogr_bilgilerinin_listelenmesi(struct Ogrenci **bas_ptr, int no);
struct Ogrenci *arama (struct Ogrenci **bas_ptr, int no);
struct Ogrenci *ogr_silinmesi(struct Ogrenci **bas_ptr, int no);
//struct Not *no_gore_arama(struct Ders **bas_ptr, int no);
//struct Not *nota_gore_arama(struct Ders **bas_ptr, int no);
void ogr_yazdir(int , char [], int , int , float );
void onbir(struct Ogrenci **bas_ptr, int ogrno,struct Ders **ders);

int menu(void)
{
        int secim;

        system("CLS");
        printf("\n\n"
               "                >> Ogrenci-Ders Takip Sistemi-2 <<\n\n\n"
               "     1. Yeni Bir Ogrenci Eklenmesi\n"
               "     2. Yeni Bir Ders Eklenmesi\n"
               "     3. Ogrencilerin Notlarinin Eklenmesi\n"
               "     4. Ogrencinin Notunun Guncellenmesi\n"
               "     5. Yeni Bir Ogrencinin Silinmesi\n"
               "     6. Bir Dersin Bilgilerini Ve Onu Alan Ogrencilerin Listelenmesi\n"
               "     7. Notu Belirli Bir Notun Ustunde Olan Ogrencilerin Liztelenmesi\n"
               "     8. Notu Belirli Bir Notun Altinda Olan Ogrencilerin Liztelenmesi\n"
               "     9. Bir Doneme Ait Derslerin Listelenmesi\n"
               "    10. Bir Ogrencinin Bilgilerinin Listelenmesi\n"
               "    11. Bir Ogrencinin Bilgilerinin Ve Aldigi Derslerin Listelenmesi\n"
               "    12. Bir Sinifta Okuyan Ogrencilerin Listelenmesi\n"
               "    13. Cikis !!!\n");

        do {
                printf("\n  Seciminizi Giriniz: ");
                scanf("%d", &secim);

        } while(secim<1 || secim>13);

        return secim;
}

void baslik_yazdir()
{
        system("CLS");
        printf("\n\n"
               "                >> Ogrenci-Ders Takip Sistemi-2 <<\n\n\n");
}

void ogr_no_al(int *ogrno)
{

        do {
                baslik_yazdir();
                printf("    Ogrenci Numarasini Giriniz: ");
                scanf("%d",&(*ogrno));
        } while((*ogrno)<1 || (*ogrno)>10000);

}

void Sinif_kod_al(int *sinif_kod)
{

        do {
                baslik_yazdir();
                printf("    Sinifi Giriniz: ");
                scanf("%d",&(*sinif_kod));
        } while((*sinif_kod)<1 || (*sinif_kod)>4);

}

void ogr_noile_ekle(struct Ogrenci **bas_ptr, int no)
{
        struct Ogrenci *yeni;
        struct Ogrenci *simdiki;
        struct Ogrenci *onceki;

        yeni=malloc(sizeof(struct Ogrenci));

        yeni->ogr_no=no;
        printf("  Ogrencinin Bilgilerini Giriniz: \n");
        printf("\n     Ad Soyad: ");
        fflush(stdin);
        gets(yeni->ad_soyad);
        printf("\n     Sinif: ");
        scanf("%d.",&yeni->sinifi);
        yeni->donem_agirlik_ort=0;
        yeni->donem_kredi_sayisi=0;

        if((*bas_ptr)==NULL) {

                (*bas_ptr)=yeni;
                yeni->sonraki=NULL;

        } else {
                if(yeni->ogr_no < (*bas_ptr)->ogr_no) {

                        yeni->sonraki=(*bas_ptr);
                        (*bas_ptr)=yeni;

                } else {
                        onceki=NULL;
                        simdiki=(*bas_ptr);
                        while(yeni->ogr_no < simdiki->ogr_no || simdiki->sonraki!=NULL) {
                                onceki=simdiki;
                                simdiki=simdiki->sonraki;
                        }
                        if(simdiki->sonraki==NULL) {
                                simdiki->sonraki=yeni;
                                yeni->sonraki=NULL;
                        } else {
                                onceki->sonraki=yeni;
                                yeni->sonraki=simdiki;
                        }
                }
        }
}

struct Ogrenci *ogr_silinmesi(struct Ogrenci **bas_ptr, int no) {
        struct Ogrenci *gecici;
        struct Ogrenci *onceki;

        if((*bas_ptr)->ogr_no==no) {
                gecici=(*bas_ptr);
                (*bas_ptr)=gecici->sonraki;
                return gecici;
        } else {
                gecici=(*bas_ptr);
                onceki=NULL;

                while(gecici!=NULL && gecici->ogr_no<no) {
                        onceki=gecici;
                        gecici=gecici->sonraki;
                }

                onceki->sonraki=gecici->sonraki;
                return gecici;
        }
}

struct Ogrenci *arama (struct Ogrenci **bas_ptr, int no) {
        struct Ogrenci *gecici;
        gecici=*bas_ptr;

        while (gecici!=NULL && gecici->ogr_no <=no) {
                if (gecici->ogr_no==no) return gecici;
                gecici=gecici->sonraki;
        }

        return NULL;
}

void ogr_bilgilerinin_listelenmesi(struct Ogrenci **bas_ptr, int no)
{

        //struct Ogrenci *onceki;
        struct Ogrenci *simdiki;

        //onceki=NULL;
        simdiki=(*bas_ptr);

        while(simdiki!=NULL && simdiki->ogr_no !=no) {
                //onceki=simdiki;
                simdiki=simdiki->sonraki;
        }

        ogr_yazdir(simdiki->ogr_no,simdiki->ad_soyad,simdiki->sinifi,simdiki->donem_kredi_sayisi,simdiki->donem_agirlik_ort);
}

void ogr_yazdir(int ogrNo, char ogrAdSoyad[], int ogrSinif, int ogrAgarlikKrediSayisi, float ogrAgarlikNotOrt)
{
        printf("\n  %s  %s               %s  %s  %s \n","Ogrenci No","Ad Soyad","Sinif","Kredi Sayisi","Not Ort");
        printf("   -------    -------------------    -----   ----------    -----\n");
        printf("     %-7d  %-23s  %-8d  %-8d  %-9.2f\n",ogrNo,ogrAdSoyad,ogrSinif,ogrAgarlikKrediSayisi,ogrAgarlikNotOrt);
}

void ders_donemini_al(int *dersdonem)
{

        do {
                baslik_yazdir();
                printf("    Ders Donemini Giriniz: ");
                scanf("%d",&(*dersdonem));
        } while((*dersdonem)<1 || (*dersdonem)>8);

}

void ders_ekle(struct Ders **ders,int kod)
{
        struct Ders *yeni_ders;

        yeni_ders=malloc(sizeof(struct Ders));

        baslik_yazdir();
        printf("   Dersin Kodu : %d\n",kod);
        printf("   Dersin Bilgilerini Giriniz: \n");

        yeni_ders->ders_kodu=kod;
        printf("\n        Adi: ");
        fflush(stdin);
        gets(yeni_ders->ders_adi);
        printf("\n        Kredisi: ");
        scanf("%d",&yeni_ders->ders_kredisi);
        yeni_ders->dersi_alan_ogr_sayisi=0;
        yeni_ders->dersin_not_ort=0.0;

        (*ders)=yeni_ders;
        yeni_ders->ders_ptr->ogr_sonraki=yeni_ders->ders_ptr;
        yeni_ders->ders_ptr->no_onceki=yeni_ders->ders_ptr;
        yeni_ders->ders_ptr->no_sonraki=yeni_ders->ders_ptr;

}

void ders_kodu_al(int *derskal)
{
        do {
                baslik_yazdir();
                printf("    Ders Kodunu Giriniz: ");
                scanf("%d",&(*derskal));
        } while((*derskal)<10 || (*derskal)>89);
}

void ders_notu_al(int *dnot)
{

        do {
                baslik_yazdir();
                printf("    Ders Notunu Giriniz: ");
                scanf("%d",&(*dnot));
        } while((*dnot)<0 || (*dnot)>100);

}

/*void ders_notu_ekle(struct Ders **ders, struct Ogrenci *ogr[])//Araya ekleme yapmiyo
{
        int no,dnot,hash;
        char onay;

        if(ders!=NULL) {
                do {

                        ogr_no_al(&no);
                        hash=(int)(no-1)/101;

                        if(arama(&ogr[hash],no)==NULL) {
                                baslik_yazdir();
                                printf("    BU NUMARADA OGRENCI BULUNMAMAKTADIR!!!\n\n");
                                onay='h';
                                system("pause");
                        } else {
                                ders_notu_al(&dnot);
                                notu_ogrno_ekle(&ders,no,dnot);
                                notu_not_ekle(&ders,no,dnot);

                        }

                        printf("\n Bir Ogrencinin Daha Notunu Giricekmisiniz ? (E/H) ");
                        fflush(stdin);
                        onay=getchar();
                } while (onay=='e' || onay=='E');

        } else {
                baslik_yazdir();
                printf("    BU NUMARADA DERS BULUNMAMAKTADIR!!!\n\n");
                system("pause");
        }


}
*/
void notu_ogrno_ekle(struct Ders **ders,int ogrno, int dnot)
{
        struct Not *yeni;
        struct Not *onceki;
        struct Not *simdiki;
        struct Ders *gecici;
        gecici=(*ders);

        yeni=malloc(sizeof(struct Not));
        yeni->ogr_nr=ogrno;
        yeni->ogr_notu=dnot;


        if(gecici->ders_ptr->ogr_sonraki==gecici->ders_ptr) {
                gecici->ders_ptr->ogr_sonraki=yeni;
                yeni->ogr_sonraki=gecici->ders_ptr;
        } else {
                if(yeni->ogr_nr < gecici->ders_ptr->ogr_sonraki->ogr_nr) {
                        yeni->ogr_sonraki=gecici->ders_ptr->ogr_sonraki;
                        gecici->ders_ptr->ogr_sonraki=yeni;
                } else {
                        onceki=NULL;
                        simdiki=gecici->ders_ptr->ogr_sonraki;
                        while(yeni->ogr_nr < simdiki->ogr_nr || simdiki->ogr_sonraki!=gecici->ders_ptr) {
                                onceki=simdiki;
                                simdiki=simdiki->ogr_sonraki;
                        }
                        if(simdiki->ogr_sonraki==gecici->ders_ptr) {
                                simdiki->ogr_sonraki=yeni;
                                yeni->ogr_sonraki=gecici->ders_ptr;
                        } else {
                                onceki->ogr_sonraki=yeni;
                                yeni->ogr_sonraki=simdiki;
                        }
                }
        }

}

void notu_not_ekle(struct Ders **ders,int ogrno, int dnot)//Ortaya ekleme yapmiyo
{
        struct Not *yeni;
        struct Ders *gecici;
        struct Not *bir_ders;

        yeni=malloc(sizeof(struct Not));
        yeni->ogr_nr=ogrno;
        yeni->ogr_notu=dnot;

        gecici=(*ders);
        bir_ders=gecici->ders_ptr->no_sonraki;

        while (bir_ders!=gecici->ders_ptr && bir_ders->ogr_notu<yeni->ogr_notu)
                bir_ders=bir_ders->no_sonraki;

        yeni->no_sonraki=bir_ders;
        yeni->no_onceki=bir_ders->no_onceki;
        bir_ders->no_onceki->no_sonraki=yeni;
        bir_ders->no_onceki=yeni;

        /* printf("fonksyon");
           if(bir_ders->no_sonraki==bir_ders)
               {
                   bir_ders->no_sonraki=yeni;
                   yeni->no_sonraki=bir_ders;
                   yeni->no_onceki=bir_ders;
                   bir_ders->no_onceki=yeni;
                   printf("111");
               }
               else
               {
                   if(yeni->ogr_notu < bir_ders->no_sonraki->ogr_notu)
                   {
                       yeni->no_sonraki=bir_ders->no_sonraki;
                       bir_ders->no_sonraki->no_onceki=yeni;
                       yeni->no_onceki=bir_ders;
                       bir_ders->no_sonraki=yeni;
                       printf("222");
                   }
                   else
                   {
                       onceki=bir_ders->no_onceki;
                       simdiki=bir_ders;
                       while(yeni->ogr_notu < simdiki->ogr_notu && simdiki->no_sonraki!=bir_ders)
                       {
                           printf("while");
                           onceki=simdiki;
                           simdiki=simdiki->no_sonraki;
                       }
                               if(simdiki->no_sonraki==bir_ders)
                               {
                                   simdiki->no_sonraki=yeni;
                                   yeni->no_onceki=simdiki;
                                   yeni->no_sonraki=bir_ders;
                                   bir_ders->no_onceki=yeni;
                                   printf("333");
                               }
                               else
                               {
                                   printf("girdi");
                                   yeni->no_sonraki=simdiki;
                                   yeni->no_onceki=onceki;
                                   onceki->no_sonraki=yeni;
                                   onceki->no_sonraki=yeni;
                                   printf("444");
                               }
                   }
               }
        */
}

void not_gunceleme(struct Ders **ders,int ogrno)
{



}

struct Not *nota_gore_arama(struct Ders **bas_ptr, int no) {
        struct Ders *gecici;
        struct Not *bir_ders;
        gecici=*bas_ptr;
        bir_ders=gecici->ders_ptr;

        while (bir_ders->no_sonraki!=gecici->ders_ptr) {
                if (bir_ders->ogr_nr==no)
                        return bir_ders;
                bir_ders=bir_ders->no_sonraki;
        }

        return NULL;
}

struct Not *no_gore_arama(struct Ders **bas_ptr, int no) {
        struct Ders *gecici;
        struct Not *bir_ders;

        gecici=*bas_ptr;
        bir_ders=gecici->ders_ptr;

        while (bir_ders->ogr_sonraki!=gecici->ders_ptr) {
                if (bir_ders->ogr_nr==no)
                        return bir_ders;
                bir_ders=bir_ders->ogr_sonraki;
        }

        return NULL;
}
/*
void ogr_notu_sil(struct Ders **ders,int ogrno)//5 cade kulanmak icin yazim ama yanlis olabilir
{
        struct Ders *gecici;
        struct Not *bir_ders;
        struct Not *silinecek;

        gecici=(*ders);
        bir_ders=gecici->ders_ptr->no_sonraki;

        silinecek=nota_gore_arama(&ders,ogrno);

        while (bir_ders!=gecici->ders_ptr && bir_ders->ogr_notu!=silinecek->ogr_notu)
                bir_ders=bir_ders->no_sonraki;

        silinecek->no_sonraki=bir_ders;
        silinecek->no_onceki=bir_ders->no_onceki;
        bir_ders->no_onceki->no_sonraki=silinecek;
        bir_ders->no_onceki=silinecek;
}
*/
void bir_sinifin_ogrencileri(struct Ogrenci **bas_ptr,int sinifkod)//Sadece gecicide sorun var niye ise oraya gelince kesiliyo
{
        struct Ogrenci *gecici;
        int ogr_say=0,alt_60=0;
        float genel_ort=0.0;

        gecici=(*bas_ptr);

        printf("\n  %s  %s               %s  %s  %s \n","Ogrenci No","Ad Soyad","Sinif","Kredi Sayisi","Not Ort");
        printf("   -------    -------------------    -----   ----------    -----\n");

        do {
                if(gecici->sinifi==sinifkod) {
                        printf("     %-7d  %-23s  %-8d  %-8d  %-9.2f\n",gecici->ogr_no,gecici->ad_soyad,gecici->sinifi,gecici->donem_kredi_sayisi,gecici->donem_agirlik_ort);
                        gecici=gecici->sonraki;
                        ogr_say++;
                        genel_ort+=gecici->donem_agirlik_ort;
                        if(gecici->donem_agirlik_ort<60)
                                alt_60++;
                }

        } while(gecici->sonraki!=NULL);
}

/*void onbir(struct Ogrenci **bas_ptr, int ogrno,struct Ders **ders)//Liste icinde arama yapilicak o ogrenci varsa ders bilgileri yazilicak
{
        struct Ogrenci *gecici;
        struct Ders *yedek;
        yedek=(*ders);
        gecici=(*bas_ptr);

        while (gecici!=NULL && gecici->ogr_no !=ogrno) {
                gecici=gecici->sonraki;
        }
        ogr_yazdir(gecici->ogr_no,gecici->ad_soyad,gecici->sinifi,gecici->donem_kredi_sayisi,gecici->donem_agirlik_ort);

        // nota_gore_arama(&yedek, int ogrno);

}*/

int main()
{
        system("color A");

        struct Ogrenci *ogr[101]= {NULL};
        struct Ogrenci *gecici;
        struct Ders *dersler[80] = {NULL};

        int secim,ogrno,hash,ders_donem_kod,derskal;
        int min,max,j=0/*,sinif_kod*/;



        do {
                secim=menu();
                switch(secim) {

                case 1:

                        ogr_no_al(&ogrno);
                        hash=(int)(ogrno-1)/101;

                        if(arama(&ogr[hash],ogrno)==NULL) {
                                baslik_yazdir();
                                ogr_noile_ekle(&ogr[hash],ogrno);
                                printf("\n");
                                system("pause");
                        } else {
                                baslik_yazdir();
                                printf("    BU NUMARADA OGRENCI BULUNMAKTADIR!!!\n\n");
                                system("pause");
                        }

                        break;

                case 2:
                        ders_donemini_al(&ders_donem_kod);
                        min=(ders_donem_kod*10)-10;
                        max=min+10;

                        while(dersler[min]!=NULL && dersler[max]!=dersler[min]) {
                                min++;
                        }
                        ders_ekle(&dersler[min],(min+10));

                        printf("\n");
                        system("pause");
                        break;

                case 3:
                        ders_kodu_al(&derskal);
                        //ders_notu_ekle(dersler[derskal-10],&ogr);
                        break;

                case 4://Sadece kontroler yapildi ama islem yapilmadi..yani ogrenci listelerde aranicak varsa notu degisicek tabiki ntu degisince sirali oldugu icin yeni yerine atanicak
                        ders_kodu_al(&derskal);
                        if(dersler[derskal-10]!=NULL) {
                                ogr_no_al(&ogrno);
                                hash=(int)(ogrno-1)/101;

                                if(arama(&ogr[hash],ogrno)!=NULL) {
                                        // not_gunceleme(dersler[derskal-10],ogrno);
                                } else {
                                        baslik_yazdir();
                                        printf("    BU NUMARADA OGRENCI BULUNMAMAKTADIR!!!\n\n");
                                        system("pause");
                                }
                        } else {
                                baslik_yazdir();
                                printf("    BU NUMARADA DERS BULUNMAMAKTADIR!!!\n\n");
                                system("pause");
                        }
                        break;

                case 5://ogrenciyi sildik butun derslerde o ogrenci varmi diye bakiyoruz varsa siliyoruz
                        ogr_no_al(&ogrno);
                        hash=(int)(ogrno-1)/101;

                        if(arama(&ogr[hash],ogrno)==NULL) {
                                baslik_yazdir();
                                printf("    BU NUMARADA OGRENCI BULUNMAMAKTADIR!!!\n\n");
                                system("pause");
                        } else {
                                baslik_yazdir();
                                gecici=ogr_silinmesi(&ogr[hash],ogrno);
                                ogr_yazdir(gecici->ogr_no,gecici->ad_soyad,gecici->sinifi,gecici->donem_kredi_sayisi,gecici->donem_agirlik_ort);
                                printf("   Silme Islemi Basariyla Gerceklesmistir...\n");
                                free(gecici);
                                while(dersler[j]!=NULL) {
                                        // ogr_notu_sil(&dersler[j],ogrno);
                                }
                                system("pause");
                        }

                        break;

                case 6:
                        break;

                case 7:
                        break;

                case 8:
                        break;

                case 9:
                        break;

                case 10://biti
                        ogr_no_al(&ogrno);
                        hash=(int)(ogrno-1)/100+1;

                        if(arama(&ogr[hash],ogrno)==NULL) {
                                baslik_yazdir();
                                printf("    BU NUMARADA OGRENCI BULUNMAMAKTADIR!!!\n\n");
                                system("pause");
                        } else {
                                baslik_yazdir();
                                ogr_bilgilerinin_listelenmesi(&ogr[hash],ogrno);
                                system("pause");
                        }
                        break;

                case 11://yazdik ama calisiyo mu kontrol edemedik
                        ogr_no_al(&ogrno);
                        do {
                                hash=(int)(j-1)/101;
                                //onbir(&dersler[hash],ogrno,&dersler);
                                j++;
                        } while(dersler[j]!=NULL );
                        break;

                case 12:/*
                        Sinif_kod_al(&sinif_kod);
                        do {
                                hash=(int)(j-1)/101;
                                bir_sinifin_ogrencileri(&dersler[hash],sinif_kod);
                                j++;
                        } while(dersler[j]!=NULL);
*/
                        break;


                }

        } while(secim!=13);
        return 0;
}
