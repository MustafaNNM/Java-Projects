#include <stdio.h>
#include <stdlib.h>
#include <string.h>


struct personel
{
    int no;
    char ad_soyad[26];
    char unvan[16];
    float ucret_katsayisi;
};
struct tarih
{
    char gun[3];
    char ay[3];
    char yil[5];
    int gg;
    int aa;
    int yyyy;
};
struct mesai
{
    int no;
    int personel_no;
    int gun_no;
    int giris_saati;
    int giris_dakikasi;
    int cikis_saati;
    int cikis_dakikasi;
    float saatlik_ucret;
    float maas;
    float saat_sure;
    float dakika_sure;
};
void ana_menu(void);
void sorgulama_menu(void);
void personel_bilgisi_listele(void);
void mesai_kayitlarini_listele(void);
void tum_personel_bilgilerini_listele(void);
void unvana_gore_personel_listelenmesi(void);
void belirli_bir_gunun_mesai_kayitlarini_listele(void);
void personel_maaslari(void);
void dosya_birlestirme(void);
int main()
{
    char secim;
    do
    {
        ana_menu();
        fflush(stdin);
        secim=getchar();
        switch (secim)
        {
        case 'a':
        case 'A':
            sorgulama_menu();
            fflush(stdin);
            secim=getchar();
            switch (secim)
            {
            case '1':
                personel_bilgisi_listele();
                break;
            case '2':
                mesai_kayitlarini_listele();
                break;
            case '3':
                tum_personel_bilgilerini_listele();
                break;
            case '4':
                break;
            case '5':
                unvana_gore_personel_listelenmesi();
                break;
            case '6':
                belirli_bir_gunun_mesai_kayitlarini_listele();
                break;
            case '7':
                personel_maaslari();
                break;
            case '8':
                break;
            }
            break;
        case 'b':
        case 'B':
            break;
        case 'c':
        case 'C':
            dosya_birlestirme();
            break;
        }
    }
    while (secim!='q'&&secim!='Q');
    return 0;
}
void ana_menu(void)
{
    printf("A) Sorgulama Programi\n");
    printf("B) Personel Bilgilerini Guncelleme Programi\n");
    printf("C) Iki Subenin Personel Dosyalarini Birlestirme Programi\n");
    printf("Q) Cikis");
    printf("Seciminiz {[a/A],[b/B],[c/C],[q/Q]}\n?");
}
void sorgulama_menu(void)
{
    printf("1) Bir personelin bilgilerinin listelenmesi\n");
    printf("2) Bir personelin bilgilerinin ve o ay icin mesai kayitlarinin listelenmesi\n");
    printf("3) Tum personelin bilgilerinin listelenmesi\n");
    printf("4) Belirli bir tarihten once ise girmis olan personelin listelenmesi\n");
    printf("5) Belirli bir unvana sahip personelin listelenmesi\n");
    printf("6) Belirli bir gunun mesai kayitlarinin listelenmesi\n");
    printf("7) Tum personelin alacaklari ucretlerin listelenmesi\n");
    printf("8) Ana menu\n");
    printf("Seciminiz {[1-7]/[q/Q]}\n?");
}
void personel_bilgisi_listele(void)
{
    int no;
    struct personel kisi;
    struct tarih zaman;

    FILE *pfptr;

    if ((pfptr=fopen("personel.txt","r"))==NULL)
        printf("Dosya acilamadi\n");
    else
    {
        printf("Aramak istediginiz personelin nosunu giriniz\n?");
        scanf("%d",&no);
        fscanf(pfptr,"%d",&kisi.no);
        fgets(kisi.ad_soyad,26,pfptr);
        fgets(zaman.gun,3,pfptr);
        fgets(zaman.ay,3,pfptr);
        fgets(zaman.yil,5,pfptr);
        fgets(kisi.unvan,16,pfptr);
        fscanf(pfptr,"%f",&kisi.ucret_katsayisi);
        do
        {
            if (no==kisi.no)
            {
                printf("Per No  Ad Soyad                  Ise Gir Tar  Unvani         Ucr Katsayisi\n");
                printf("------  ------------------------  -----------  -----------    -------------\n");
                printf("%-8d%-26s%s.%s.%-7s%s%.2f\n",kisi.no,kisi.ad_soyad,zaman.gun,zaman.ay,zaman.yil,kisi.unvan,kisi.ucret_katsayisi);
                break;
            }
            else
            {
                fscanf(pfptr,"%d",&kisi.no);
                fgets(kisi.ad_soyad,26,pfptr);
                fgets(zaman.gun,3,pfptr);
                fgets(zaman.ay,3,pfptr);
                fgets(zaman.yil,5,pfptr);
                fgets(kisi.unvan,16,pfptr);
                fscanf(pfptr,"%f",&kisi.ucret_katsayisi);
            }
        }
        while (!feof(pfptr));
    }
    fclose(pfptr);
}
void mesai_kayitlarini_listele(void)
{
    int no;

    struct personel kisi;
    struct tarih zaman;
    struct mesai is;

    FILE *pfptr;
    FILE *mfptr;

    if ((pfptr=fopen("personel.txt","r"))==NULL)
        printf("Dosya acilamadi\n");
    else
    {
        if ((mfptr=fopen("mesai.txt","r"))==NULL)
            printf("Dosya acilamadi\n");
        else
        {
            printf("Aramak istediginiz personelin nosunu giriniz\n?");
            scanf("%d",&no);
            fscanf(pfptr,"%d",&kisi.no);
            fgets(kisi.ad_soyad,26,pfptr);
            fgets(zaman.gun,3,pfptr);
            fgets(zaman.ay,3,pfptr);
            fgets(zaman.yil,5,pfptr);
            fgets(kisi.unvan,16,pfptr);
            fscanf(pfptr,"%f",&kisi.ucret_katsayisi);

            do
            {
                if (no==kisi.no)
                {
                    printf("Per No  Ad Soyad                  Unvani\n");
                    printf("------  ------------------------  -----------\n");
                    printf("%-8d%-26s%s\n",kisi.no,kisi.ad_soyad,kisi.unvan);
                    break;
                }
                else
                {
                    fscanf(pfptr,"%d",&kisi.no);
                    fgets(kisi.ad_soyad,26,pfptr);
                    fgets(zaman.gun,3,pfptr);
                    fgets(zaman.ay,3,pfptr);
                    fgets(zaman.yil,5,pfptr);
                    fgets(kisi.unvan,16,pfptr);
                    fscanf(pfptr,"%f",&kisi.ucret_katsayisi);
                }
            }
            while (!feof(pfptr));

            printf("Mesai Kayitlari:\n");
            printf("Gun No  Gir Saati   Cik Saati\n");
            printf("------  ---------   ---------\n");

            do
            {
                fscanf(mfptr,"%d%d%d%d%d%d",&kisi.no,&is.no,&is.giris_saati,&is.giris_dakikasi,&is.cikis_saati,&is.cikis_dakikasi);
                if (no==kisi.no)
                {
                    printf("%-8d%-2d:%-9d%-2d:%-2d\n",is.no,is.giris_saati,is.giris_dakikasi,is.cikis_saati,is.cikis_dakikasi);
                }
            }
            while (!feof(mfptr));
        }
        fclose(mfptr);
    }
    fclose(pfptr);
}
void tum_personel_bilgilerini_listele(void)
{
    struct personel kisi;
    struct tarih zaman;

    FILE *pfptr;

    if ((pfptr=fopen("personel.txt","r"))==NULL)
        printf("Dosya acilamadi\n");
    else
    {
        printf("Per No  Ad Soyad                  Ise Gir Tar  Unvani         Ucr Katsayisi\n");
        printf("------  ------------------------  -----------  -----------    -------------\n");
        fscanf(pfptr,"%d",&kisi.no);
        fgets(kisi.ad_soyad,26,pfptr);
        fgets(zaman.gun,3,pfptr);
        fgets(zaman.ay,3,pfptr);
        fgets(zaman.yil,5,pfptr);
        fgets(kisi.unvan,16,pfptr);
        fscanf(pfptr,"%f",&kisi.ucret_katsayisi);
        do
        {
            printf("%-8d%-26s%s.%s.%-7s%s%.2f\n",kisi.no,kisi.ad_soyad,zaman.gun,zaman.ay,zaman.yil,kisi.unvan,kisi.ucret_katsayisi);
            fscanf(pfptr,"%d",&kisi.no);
            fgets(kisi.ad_soyad,26,pfptr);
            fgets(zaman.gun,3,pfptr);
            fgets(zaman.ay,3,pfptr);
            fgets(zaman.yil,5,pfptr);
            fgets(kisi.unvan,16,pfptr);
            fscanf(pfptr,"%f",&kisi.ucret_katsayisi);
        }
        while (!feof(pfptr));
    }
    fclose(pfptr);
}
void unvana_gore_personel_listelenmesi(void)
{
    struct personel kisi;
    struct tarih zaman;
    char yazi[15];

    FILE *pfptr;

    printf("Gormek istediginiz unvani giriniz\n?");
    scanf("%s",yazi);
    if ((pfptr=fopen("personel.txt","r"))==NULL)
        printf("Dosya acilamadi\n");
    else
    {
        printf("Per No  Ad Soyad                  Ise Gir Tar  Ucr Katsayisi\n");
        printf("------  ------------------------  -----------  -------------\n");
        do
        {
            fscanf(pfptr,"%d",&kisi.no);
            fgets(kisi.ad_soyad,26,pfptr);
            fgets(zaman.gun,3,pfptr);
            fgets(zaman.ay,3,pfptr);
            fgets(zaman.yil,5,pfptr);
            fgets(kisi.unvan,16,pfptr);
            fscanf(pfptr,"%f",&kisi.ucret_katsayisi);

            if (*yazi==*kisi.unvan)
            {
                printf("%-8d%-26s%s.%s.%-7s%.2f\n",kisi.no,kisi.ad_soyad,zaman.gun,zaman.ay,zaman.yil,kisi.ucret_katsayisi);
            }
        }
        while (!feof(pfptr));
    }
    fclose(pfptr);
}
void belirli_bir_gunun_mesai_kayitlarini_listele(void)
{

    int no;

    struct personel kisi;
    struct mesai is;


    FILE *mfptr;

    printf("Gormek istediginiz gunun nosunu giriniz\n?");
    scanf("%d",&no);

    if ((mfptr=fopen("mesai.txt","r"))==NULL)
        printf("Dosya acilamadi\n");
    else
    {
        printf("Per No  Gir Saati   Cik Saati\n");
        printf("------  ---------   ---------\n");
        do
        {
            fscanf(mfptr,"%d%d%d%d%d%d",&kisi.no,&is.no,&is.giris_saati,&is.giris_dakikasi,&is.cikis_saati,&is.cikis_dakikasi);
            if (no==is.no)
            {
                printf("%-8d%-2d:%-9d%-2d:%-2d\n",kisi.no,is.giris_saati,is.giris_dakikasi,is.cikis_saati,is.cikis_dakikasi);
            }
        }
        while (!feof(mfptr));
    }
    fclose(mfptr);
}
void dosya_birlestirme(void)
{
    int sayi1,sayi2;
    float katsayi1,katsayi2;
    char yazi1[49],yazi2[49];
    int w,okundu=0,tut_sayi2;

    FILE *afPtr;
    FILE *bfPtr;
    FILE *cfPtr;

    if ((afPtr=fopen("personel.txt","r"))==NULL)
        printf("Dosya acilamadi\n");
    else
    {
        if ((bfPtr=fopen("personel2.txt","r"))==NULL)
            printf("Dosya acilamadi\n");
        else
        {
            if ((cfPtr=fopen("gecici.txt","w+"))==NULL)
                printf("Dosya acilamadi\n");
            else
            {
                fscanf(afPtr,"%d",&sayi1);
                fgets(yazi1,49,afPtr);
                fscanf(afPtr,"%f",&katsayi1);
                fscanf(bfPtr,"%d",&sayi2);
                tut_sayi2=sayi2;
                fgets(yazi2,49,bfPtr);
                fscanf(bfPtr,"%f",&katsayi2);
                do
                {
                    if (sayi1>sayi2)
                    {
                        do
                        {
                            fprintf(cfPtr,"%d",sayi2);
                            fprintf(cfPtr,"%s",yazi2);
                            fprintf(cfPtr,"%.2f\n",katsayi2);
                            if (okundu!=1)
                            {
                                fscanf(afPtr,"%d",&sayi1);
                                fgets(yazi1,49,afPtr);
                                fscanf(afPtr,"%f",&katsayi1);
                                okundu=1;
                            }
                            fscanf(bfPtr,"%d",&sayi2);
                            if (!feof(bfPtr))
                            {
                                tut_sayi2=sayi2;
                            }
                            fgets(yazi2,49,bfPtr);
                            fscanf(bfPtr,"%f",&katsayi2);
                        }
                        while (sayi1>sayi2);
                        fprintf(cfPtr,"%d",sayi1);
                        fprintf(cfPtr,"%s",yazi1);
                        fprintf(cfPtr,"%.2f\n",katsayi1);
                    }
                    else
                    {
                        fprintf(cfPtr,"%d",sayi1);
                        fprintf(cfPtr,"%s",yazi1);
                        fprintf(cfPtr,"%.2f\n",katsayi1);
                        fprintf(cfPtr,"%d",sayi2);
                        fprintf(cfPtr,"%s",yazi2);
                        fprintf(cfPtr,"%.2f\n",katsayi2);
                        fscanf(afPtr,"%d",&sayi1);
                        fgets(yazi1,49,afPtr);
                        fscanf(afPtr,"%f",&katsayi1);
                        fscanf(bfPtr,"%d",&sayi2);
                        if (!feof(bfPtr))
                        {
                            tut_sayi2=sayi2;
                        }
                        fgets(yazi2,49,bfPtr);
                        fscanf(bfPtr,"%f",&katsayi2);
                    }
                }
                while (!feof(afPtr)||!feof(bfPtr));
                if (feof(afPtr))
                {
                    w=5;
                }
                else
                {
                    w=0;
                }
                switch (w)
                {
                case 0:
                    do
                    {
                        fprintf(cfPtr,"%d",sayi2);
                        if (!feof(bfPtr))
                        {
                            tut_sayi2=sayi2;
                        }
                        fprintf(cfPtr,"%s",yazi2);
                        fprintf(cfPtr,"%.2f\n",katsayi2);
                        fscanf(bfPtr,"%d",&sayi2);
                        if (feof(bfPtr))
                        {
                            break;
                        }
                        fgets(yazi2,49,bfPtr);
                        fscanf(bfPtr,"%f",&katsayi2);
                    }
                    while (w!=5);
                    break;
                case 5:
                    do
                    {
                        fprintf(cfPtr,"%d",sayi1);
                        fprintf(cfPtr,"%s",yazi1);
                        fprintf(cfPtr,"%.2f\n",katsayi1);
                        fscanf(afPtr,"%d",&sayi1);
                        if (feof(afPtr))
                        {
                            w=0;
                            break;
                        }
                        fgets(yazi1,49,afPtr);
                        fscanf(afPtr,"%f",&katsayi1);
                    }
                    while (w!=0);
                    break;
                }
            }
            fclose(afPtr);
        }
        fclose(bfPtr);
    }
    fclose(cfPtr);
    printf("\nDosyalar birlestirildi\n");
    remove("personel.txt");
    remove("personel2.txt");
    rename("gecici.txt","personel.txt");
    printf("Bilgi icin bilgi.txt dosyasina bakiniz!\n\n");
    if ((cfPtr=fopen("bilgi.txt","w+"))==NULL)
        printf("Dosya acilamadi\n");
    else
    {
        fprintf(cfPtr,"Dosyadaki bilgiler personel dosyasina aktarilmistir.");
    }
    fclose(cfPtr);
}
void personel_maaslari(void)
{
    struct personel kisi;
    struct tarih zaman;
    struct mesai is;

    FILE *pfptr;
    FILE *mfptr;

    if ((pfptr=fopen("personel.txt","r"))==NULL)
        printf("Dosya acilamadi\n");
    else
    {
        if ((mfptr=fopen("mesai.txt","r"))==NULL)
            printf("Dosya acilamadi\n");
        else
        {
            printf("saatlik ucreti giriniz\n?");
            scanf("%f",&is.saatlik_ucret);
            printf("Per No  Ad Soyad                 Sure         Ucret\n");
            printf("------  ------------------------ ------------ -------------\n");
            do
            {
                    fscanf(pfptr,"%d",&kisi.no);
                    fgets(kisi.ad_soyad,26,pfptr);
                    fgets(zaman.gun,3,pfptr);
                    fgets(zaman.ay,3,pfptr);
                    fgets(zaman.yil,5,pfptr);
                    fgets(kisi.unvan,16,pfptr);
                    fscanf(pfptr,"%f",&kisi.ucret_katsayisi);
                    do{
                    fscanf(mfptr,"%d%d%d%d%d%d",&is.no,&is.gun_no,&is.giris_saati,&is.giris_dakikasi,&is.cikis_saati,&is.cikis_dakikasi);
                    }while(is.no!=kisi.no&&(!feof(mfptr)));
                    if(feof(mfptr)){rewind(mfptr);continue;}
                        do
                        {
                            is.saat_sure+=(is.cikis_saati*60+is.cikis_dakikasi-is.giris_saati*60-is.giris_dakikasi)/60;
                            is.dakika_sure+=(is.cikis_saati*60+is.cikis_dakikasi-is.giris_saati*60-is.giris_dakikasi)%60;
                            if(is.dakika_sure==60){is.dakika_sure=0;++is.saat_sure;}
                            fscanf(mfptr,"%d%d%d%d%d%d",&is.no,&is.gun_no,&is.giris_saati,&is.giris_dakikasi,&is.cikis_saati,&is.cikis_dakikasi);
                        }while(kisi.no==is.no&&(!feof(mfptr)));
                        is.maas=is.saatlik_ucret*kisi.ucret_katsayisi*(is.saat_sure+is.dakika_sure/60);
                        printf("%-8d%s%-2.0f sa %-2.0f dk  %4.3f\n",kisi.no,kisi.ad_soyad,is.saat_sure,is.dakika_sure,is.maas);
                        is.saat_sure=is.dakika_sure=0;
                        rewind(mfptr);
            }
            while (!feof(pfptr));
        }
        fclose(mfptr);
    }
    fclose(pfptr);
}
