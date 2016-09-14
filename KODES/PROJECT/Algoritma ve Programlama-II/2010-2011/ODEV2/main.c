#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define BOYUT 100

struct personel/*Personel bilgilerinin
alýnmasýnda ve yazdýrýlmasýnda kullanýldý*/
{
    int no;
    char ad_soyad[26];
    char tarih[9];
    char unvan[16];
    float ucret_katsayisi;
    int sure;
};

struct mesai/*Mesai bilgilerinin
alýnmasýnda ve yazdýrýlmasýnda kullanýldý*/
{
    int no;
    int gun_no;
    int giris_saati;
    int giris_dakikasi;
    int cikis_saati;
    int cikis_dakikasi;
};

/*Menuler*/
void menu(void);

void sorgulama_alt_menu(void);

void guncelleme_alt_menu(void);

/*A bölümü*/
void bir_personelin_bilgilerinin_listelenmesi(void);

void personel_ve_mesai_kayit_listelenmesi(void);

void unvana_gore_personelin_listelenmesi(void);

void personel_istatistigi(void);

void geciken_personeller(void);

void ozel_mesai_kayitlari(void);

/*B bölümü*/

void ekle_personel(void);

void guncelle_personel(void);

void ekle_mesai(void);

void sil_personel(void);

void yedekle_dosya_personel(void);

/*C bölümü*/

void arama_programi(void);

int main()
{
    char secim;

    do
    {
        menu();
        fflush(stdin);
        secim=getchar();
        switch (secim)
        {
        case 'a':
        case 'A':
            do
            {
                sorgulama_alt_menu();
                fflush(stdin);
                secim=getchar();
                switch (secim)
                {
                case '1':bir_personelin_bilgilerinin_listelenmesi();
                    break;
                case '2':personel_ve_mesai_kayit_listelenmesi();
                    break;
                case '3':unvana_gore_personelin_listelenmesi();
                    break;
                case '4':personel_istatistigi();
                    break;
                case '5':geciken_personeller();
                    break;
                case '6':ozel_mesai_kayitlari();
                    break;
                case '7':
                    break;
                case 'q':
                case 'Q':exit(EXIT_SUCCESS);
                    break;
                default:
                    break;
                }
            }
            while (secim!='7');
            break;
        case 'b':
        case 'B':
            do
            {
                guncelleme_alt_menu();
                fflush(stdin);
                secim=getchar();
                switch (secim)
                {
                case '1':ekle_personel();
                    break;
                case '2':guncelle_personel();
                    break;
                case '3':ekle_mesai();
                    break;
                case '4':sil_personel();
                    break;
                case '5':yedekle_dosya_personel();
                    break;
                case '6':
                    break;
                case 'q':
                case 'Q':exit(EXIT_SUCCESS);
                    break;
                default:
                    break;
                }
            }
            while (secim!='6');
            break;
        case 'c':
        case 'C':arama_programi();
            break;
        case 'q':
        case 'Q':exit(EXIT_SUCCESS);
            break;
        default:
            break;
        }
    }
    while (secim!='q');

    return 0;
}

void menu(void)
/*Ana menu olarak kullanýldý*/
{
    printf("A) Sorgulama Programi\n");
    printf("B) Guncelleme Programi\n");
    printf("C) Personel Yedekleme Dosyasinda Ikili Arama Programi\n");
    printf("Q) Cikis\n");
    printf("Seciminiz{[a/A]/[b/B]/[c/C]/[q/Q]}\n?");
}

void sorgulama_alt_menu()/*A bölümünün menüsü olarak kullanýldý*/
{
    printf("1) Bir personelin bilgilerinin listelenmesi\n");
    printf("2) Bir personelin bilgilerinin ve o ay icin mesai kayitlarinin listelenmesi\n");
    printf("3) Belirli bir unvana sahip personelin listelenmesi\n");
    printf("4) Ise alinan personel sayilarinin yillara gore dagiliminin listelenmesi\n");
    printf("5) Mesaiye gec gelen personelin listelenmesi\n");
    printf("6) Belirli bir gunun mesai kayitlarinin listelenmesi\n");
    printf("7) Ana menu\n");
    printf("Q) Cikis\n");
    printf("Seciminiz{[1-7]/[q/Q]}\n?");
}

void guncelleme_alt_menu(void)/*B bölümünün menüsü olarak kullanýldý*/
{
    printf("1) Yeni bir personelin eklenmesi\n");
    printf("2) Bir personelin bilgilerinin guncellenmesi\n");
    printf("3) Belirli bir gunun mesai kayitlarinin eklenmesi\n");
    printf("4) Bir personelin kaydinin silinmesi\n");
    printf("5) Personel dosyasinin yedeginin alinmasi\n");
    printf("6) Ana menu\n");
    printf("Q) Cikis\n");
    printf("Seciminiz{[1-6]/[q/Q]}\n?");
}

void bir_personelin_bilgilerinin_listelenmesi(void)
/*Kullanýcýdan bilgilerini görmek istediði personelin numarasý alýnarak
o personelin var olan tüm bilgileri formatlý bir þekilde yazdýrýlýr*/
{
    int no;
    struct personel kisi=
    {
        0,"","","",0,0
    };

    FILE *pfptr;

    if ((pfptr=fopen("personel.dat","r"))==NULL)
    {
        printf("Dosya acilamadi!\n");
    }
    else
    {
        printf("Listelenmesini istediginiz personelin nosunu giriniz{Cikis[0]}\n?");
        fflush(stdin);
        scanf("%d",&no);
        fseek(pfptr,(no-1)*sizeof(struct personel),SEEK_SET);
        fread(&kisi,sizeof(struct personel),1,pfptr);
        while (no!=0)
        {
            if (kisi.no==-1)
            {
                printf("Personel#%d hakkinda bilgi yok!\n",no);
            }
            else
            {
                printf("Per No Ad Soyad                  Ise Gir Tar Unvani          Ucr Katsayisi\n");
                printf("------ ------------------------- ----------- --------------- -------------\n");
                printf("%-7d%-26s",kisi.no,kisi.ad_soyad);
                putchar(kisi.tarih[0]);
                putchar(kisi.tarih[1]);
                printf(".");
                putchar(kisi.tarih[2]);
                putchar(kisi.tarih[3]);
                printf(".");
                putchar(kisi.tarih[4]);
                putchar(kisi.tarih[5]);
                putchar(kisi.tarih[6]);
                putchar(kisi.tarih[7]);
                printf("  %-16s%.2f\n",kisi.unvan,kisi.ucret_katsayisi);
            }
            printf("Listelenmesini istediginiz personelin nosunu giriniz{Cikis[0]}\n?");
            fflush(stdin);
            scanf("%d",&no);
            fseek(pfptr,(no-1)*sizeof(struct personel),SEEK_SET);
            fread(&kisi,sizeof(struct personel),1,pfptr);
        }
    }
    fclose(pfptr);
}

void personel_ve_mesai_kayit_listelenmesi(void)/**/
{
    int no;
    struct personel kisi=
    {
        0,"","","",0,0
    };
    struct mesai is;

    FILE *pfptr;
    FILE *mfptr;

    if ((pfptr=fopen("personel.dat","r"))==NULL)
    {
        printf("Dosya=personel.dat acilamadi!\n");
    }
    else
    {
        if ((mfptr=fopen("mesai.txt","r"))==NULL)
        {
            printf("Dosya=mesai.txt acilamadi!\n");
        }
        else
        {
            printf("Listelenmesini istediginiz personelin nosunu giriniz{Cikis[0]}\n?");
            fflush(stdin);
            scanf("%d",&no);
            while (no!=0)
            {
                fseek(pfptr,(no-1)*sizeof(struct personel),SEEK_SET);
                fread(&kisi,sizeof(struct personel),1,pfptr);
                if (kisi.no==-1)
                {
                    printf("Personel#%d hakkinda bilgi yok!\n",no);
                }
                else
                {
                    printf("Per No Ad Soyad                  Sure        Ucret\n");
                    printf("------ ------------------------- ----------- -------\n");
                    printf("%-7d%-26s%02d sa %02d dk %.2f\n",kisi.no,kisi.ad_soyad,kisi.sure/60,kisi.sure%60,(kisi.sure/60+(kisi.sure%60)/60)*kisi.ucret_katsayisi*10);
                }
                printf("Mesai Kayitlari:\n");
                printf("Gun No Gir Saati Cik Saati\n");
                printf("------ --------- ---------\n");
                do
                {
                    fscanf(mfptr,"%d%d%d%d%d%d",&is.no,&is.gun_no,&is.giris_saati,&is.giris_dakikasi,&is.cikis_saati,&is.cikis_dakikasi);
                    if (is.no==no)
                    {
                        printf("%-7d%02d:%02d     %02d:%02d\n",is.gun_no,is.giris_saati,is.giris_dakikasi,is.cikis_saati,is.cikis_dakikasi);
                    }
                }
                while (!feof(mfptr));
                printf("Listelenmesini istediginiz personelin nosunu giriniz{Cikis[0]}\n?");
                fflush(stdin);
                scanf("%d",&no);
            }
        }
        fclose(mfptr);
    }
    fclose(pfptr);
}

void unvana_gore_personelin_listelenmesi(void)/**/
{
    int i,j,k,x,y,z;
    int gecici_no;
    int nolar[BOYUT];
    char unvan[16];
    const char *s1;
    float kat_sayilar[BOYUT];
    float gecici_kat_sayi;

    struct personel kisi=
    {
        0,"","","",0,0
    };

    FILE *pfptr;

    if ((pfptr=fopen("personel.dat","r"))==NULL)
    {
        printf("Dosya=personel.dat acilamadi!\n");
    }
    else
    {
        printf("Listelenmesini istediginiz personelin unvanini giriniz{Cikis[0]}\n?");
        fflush(stdin);
        gets(unvan);
        s1=unvan;
        y=strlen(s1);//\n den önceki uzunluðu hesaplýyor
        do
        {
            for (i=0;i<=99;i++)
            {
                nolar[i]=0;
                kat_sayilar[i]=0;
            }
            i=0;
            j=0;
            k=0;
            fread(&kisi,sizeof(struct personel),1,pfptr);
            while (!feof(pfptr))
            {
                if (kisi.no!=-1)
                {
                    x=memcmp(kisi.unvan,unvan,y);//karakter farkýný buluyor karakterler birer birer eþleþirse sýfýr döndürüyor
                   s1=kisi.unvan;
                   z=strlen(s1);
                    if (y==z&&x==0)
                    {
                        nolar[k]=kisi.no;
                        printf("%d\n",kisi.no);
                        kat_sayilar[k]=kisi.ucret_katsayisi;
                        ++k;
                    }
                }
                fread(&kisi,sizeof(struct personel),1,pfptr);
            }
            for (i=0;i<=k-1;i++)
            {
                for (j=0;j<=k-2;j++)
                {
                    if (kat_sayilar[j]<kat_sayilar[j+1])
                    {
                        gecici_no=nolar[j+1];
                        nolar[j+1]=nolar[j];
                        nolar[j]=gecici_no;
                        gecici_kat_sayi=kat_sayilar[j+1];
                        kat_sayilar[j+1]=kat_sayilar[j];
                        kat_sayilar[j]=gecici_kat_sayi;
                    }
                }
            }
            printf("Sira Per No Ad Soyad                  Ise Gir Tar Ucr Katsayisi\n");
            printf("---- ------ ------------------------- ----------- -------------\n");
            for (i=0;i<=k-1;i++)
            {
                fseek(pfptr,(nolar[i]-1)*sizeof(struct personel),SEEK_SET);
                fread(&kisi,sizeof(struct personel),1,pfptr);
                printf("%-5d%-7d%-26s",i+1,kisi.no,kisi.ad_soyad);
                putchar(kisi.tarih[0]);
                putchar(kisi.tarih[1]);
                printf(".");
                putchar(kisi.tarih[2]);
                putchar(kisi.tarih[3]);
                printf(".");
                putchar(kisi.tarih[4]);
                putchar(kisi.tarih[5]);
                putchar(kisi.tarih[6]);
                putchar(kisi.tarih[7]);
                printf("  %.2f\n",kisi.ucret_katsayisi);
            }
            printf("Listelenmesini istediginiz personelin unvanini giriniz{Cikis[0]}\n?");
            fflush(stdin);
            gets(unvan);
            fseek(pfptr,(0)*sizeof(struct personel),SEEK_SET);
        }
        while (*unvan!='0');
    }
    fclose(pfptr);
}

void personel_istatistigi(void)/*Ýþe baþladýklarý zamana ait bir istatistik*/
{
    float sene[12];
    int i;
    float toplam=0;

    FILE *pfptr;

    struct personel kisi=
    {
        0,"","","",0,0
    };

    if ((pfptr=fopen("personel.dat","r"))==NULL)
    {
        printf("Dosya=personel.dat acilmadi!\n");
    }
    else
    {
        for (i=0;i<=11;i++)
        {
            sene[i]=0;
        }
        fread(&kisi,sizeof(struct personel),1,pfptr);
        do
        {
            if (kisi.no!=-1)
            {
                switch (kisi.tarih[4])
                {
                case '1':/*2000'den önceki yýllarýn sayacý*/
                    ++sene[11];
                    break;
                case '2':/*2000 li yýllar ise*/
                    switch (kisi.tarih[6])
                    {
                    case '0':/*2010'den öncekiler*/
                        switch (kisi.tarih[7])
                        {
                        case '0':/*yýl 2000 sayacý*/
                            ++sene[0];
                            break;
                        case '1':/*Yýl 2001 sayacý*/
                            ++sene[1];
                            break;
                        case '2':/*Yýl 2002 sayacý*/
                            ++sene[2];
                            break;
                        case '3':/*Yýl 2003 sayacý*/
                            ++sene[3];
                            break;
                        case '4':/*Yýl 2004 sayacý*/
                            ++sene[4];
                        case '5':/*Yýl 2005 sayacý*/
                            ++sene[5];
                            break;
                        case '6':/*Yýl 2006 sayacý*/
                            ++sene[6];
                            break;
                        case '7':/*Yýl 2007 sayacý*/
                            ++sene[7];
                            break;
                        case '8':/*Yýl 2008 sayacý*/
                            ++sene[8];
                            break;
                        case '9':/*Yýl 2009 sayacý*/
                            ++sene[9];
                            break;
                        }
                        break;
                    case '1':/*Yýl 2010 sayacý*/
                        ++sene[10];
                        break;
                    }
                    break;
                }
            }
            fread(&kisi,sizeof(struct personel),1,pfptr);
        }
        while (!feof(pfptr));
        if (kisi.tarih[4]==0)
        {
            printf("Personel dosyasi=personal.dat hicbir eleman icermemektedir!\n");
        }
        for (i=0;i<=11;i++)
        {
            toplam+=sene[i];
        }
        printf("Yil  Per Say Yuzde\n");
        printf("---- ------- -----\n");
        printf("2000'den once %.0f  %.2f\n",sene[11],sene[11]*100/toplam);
        printf("2000 %-8.0f%.2f\n",sene[0],sene[0]*100/toplam);
        printf("2001 %-8.0f%.2f\n",sene[1],sene[1]*100/toplam);
        printf("2002 %-8.0f%.2f\n",sene[2],sene[2]*100/toplam);
        printf("2003 %-8.0f%.2f\n",sene[3],sene[3]*100/toplam);
        printf("2004 %-8.0f%.2f\n",sene[4],sene[4]*100/toplam);
        printf("2005 %-8.0f%.2f\n",sene[5],sene[5]*100/toplam);
        printf("2006 %-8.0f%.2f\n",sene[6],sene[6]*100/toplam);
        printf("2007 %-8.0f%.2f\n",sene[7],sene[7]*100/toplam);
        printf("2008 %-8.0f%.2f\n",sene[8],sene[8]*100/toplam);
        printf("2009 %-8.0f%.2f\n",sene[9],sene[9]*100/toplam);
        printf("2010 %-8.0f%.2f\n",sene[10],sene[10]*100/toplam);
        printf("------------------\n");
        printf("Toplam %.0f\n",toplam);
    }
    fclose(pfptr);
}

void geciken_personeller(void)/*iþe saat 09:00 itibariyle
gelen personellerin kaç kez geç geldiklerinin sayýmýný yapýyor*/
{
    int i;
    int gecikenler[BOYUT][2];

    struct mesai is=
    {
        0,0,0,0,0,0
    };

    FILE *mfptr;

    if ((mfptr=fopen("mesai.txt","r"))==NULL)
    {
        printf("Dosya=mesai.txt acilamadi!");
    }
    else
    {
        printf("Per No Kac Kez Gec Gelmis\n");
        printf("------ ------------------\n");
        for (i=0;i<=BOYUT-1;i++)
        {
            gecikenler[i][0]=0;/*Gec geldi ise 1 gec gelmedi ise 0*/
            gecikenler[i][1]=0;/*Gecikmelerin sayýsý*/
        }
        fscanf(mfptr,"%d%d%d%d%d%d",&is.no,&is.gun_no,&is.giris_saati,&is.giris_dakikasi,&is.cikis_saati,&is.cikis_dakikasi);
        do
        {
            gecikenler[is.no-1][0]=1;
            ++gecikenler[is.no-1][1];
            fscanf(mfptr,"%d%d%d%d%d%d",&is.no,&is.gun_no,&is.giris_saati,&is.giris_dakikasi,&is.cikis_saati,&is.cikis_dakikasi);
        }
        while (!feof(mfptr));
        for (i=0;i<=BOYUT-1;i++)
        {
            if (gecikenler[i][0]==1)
            {
                printf("%-7d%d\n",i+1,gecikenler[i][1]);
            }
        }
    }
    fclose(mfptr);
}

void ozel_mesai_kayitlari(void)/*Kullanýcýdan bilgilerini görmek istediði
personelin numarasý alýnarak, personel bilgileri, o ayki toplam çalýþma süresi,
alacaðý ücret ve mesai kayýtlarý listelenmektedir*/
{
    int sayac;/*ortalama çalýþma süresini hesaplamak için personelleri sayýyor*/
    int gun_no;
    int toplam_saat;
    float toplam_dakika;

    struct mesai is=
    {
        0,0,0,0,0,0
    };

    struct personel kisi=
    {
        0,"","","",0,0
    };

    FILE *pfptr;
    FILE *mfptr;

    if ((mfptr=fopen("mesai.txt","r"))==NULL)
    {
        printf("Dosya=mesai.txt acilamadi!");
    }
    else
    {
        if ((pfptr=fopen("personel.dat","r"))==NULL)
        {
            printf("Dosya=personel.dat acilamadi!");
        }
        else
        {

            printf("Gormek istediginiz gunun nosunu giriniz{Cikis[0]}\n?");
            scanf("%d",&gun_no);
            while (gun_no!=0)
            {
                toplam_saat=0;
                toplam_dakika=0;
                sayac=0;
                printf("Per No Ad Soyad                  Gir Saati Cik Saati Sure\n");
                printf("------ ------------------------- --------- --------- -----------\n");
                fscanf(mfptr,"%d%d%d%d%d%d",&is.no,&is.gun_no,&is.giris_saati,&is.giris_dakikasi,&is.cikis_saati,&is.cikis_dakikasi);
                do
                {
                    if (is.gun_no==gun_no)
                    {
                        fseek(pfptr,(is.no-1)*sizeof(struct personel),SEEK_SET);
                        fread(&kisi,sizeof(struct personel),1,pfptr);
                        printf("%-7d%-26s",kisi.no,kisi.ad_soyad);
                        printf("%02d:%02d     %02d:%02d     ",is.giris_saati,is.giris_dakikasi,is.cikis_saati,is.cikis_dakikasi);
                        printf("%02d sa ",(is.cikis_saati*60+is.cikis_dakikasi-is.giris_saati*60-is.giris_dakikasi)/60);
                        printf("%02d dk\n",(is.cikis_saati*60+is.cikis_dakikasi-is.giris_saati*60-is.giris_dakikasi)%60);
                        toplam_saat+=(is.cikis_saati*60+is.cikis_dakikasi-is.giris_saati*60-is.giris_dakikasi)/60;
                        toplam_dakika+=(float)((is.cikis_saati*60+is.cikis_dakikasi-is.giris_saati*60-is.giris_dakikasi)%60);
                        ++sayac;
                    }
                    fscanf(mfptr,"%d%d%d%d%d%d",&is.no,&is.gun_no,&is.giris_saati,&is.giris_dakikasi,&is.cikis_saati,&is.cikis_dakikasi);
                }
                while (!feof(mfptr));
                if (sayac==0)
                {
                    printf("Istediginiz gune ait bilgi bulunamamistir!\n");
                }
                else
                {
                    printf("Gun#%d icin calisma surelerinin ortalamasi: %.0f sa ",gun_no,(toplam_saat*60+toplam_dakika)/(sayac*60));
                    printf("%.2f dk\n",(toplam_saat*60/sayac)%60+toplam_dakika/sayac);
                }
                printf("Gormek istediginiz gunun nosunu giriniz{Cikis[0]}\n?");
                fflush(stdin);
                scanf("%d",&gun_no);
            }
        }
        fclose(pfptr);
    }
    fclose(mfptr);
}

void ekle_personel(void)/*Ayný numarada personel yoksa yeni personel kaydediyor*/
{
    int no;
    struct personel kisi=
    {
        0,"","","",0,0
    };

    FILE *pfptr;

    if ((pfptr=fopen("personel.dat","r+"))==NULL)
    {
        printf("Dosya=personel.dat acilamadi!\n");
    }
    else
    {
        do
        {
            printf("Eklemek istediginiz personelin nosunu giriniz{Cikis[0]}\n?");
            fflush(stdin);
            scanf("%d",&no);
            if (no==0)
            {
                break;
            }
            fseek(pfptr,(no-1)*sizeof(struct personel),SEEK_SET);
            fread(&kisi,sizeof(struct personel),1,pfptr);
            while (no!=0&&kisi.no==-1)
            {
                kisi.no=no;
                printf("Ad soyad giriniz\n?");
                fflush(stdin);
                gets(kisi.ad_soyad);
                printf("Ise giris tarihini ggaayyyy seklinde giriniz\n?");
                fflush(stdin);
                gets(kisi.tarih);
                printf("Unvani giriniz\n?");
                fflush(stdin);
                gets(kisi.unvan);
                printf("Ucret katsayisini giriniz\n?");
                fflush(stdin);
                scanf("%f",&kisi.ucret_katsayisi);
                printf("Bir ayda calistigi toplam sure (dk) miktarini giriniz\n?");
                fflush(stdin);
                scanf("%d",&kisi.sure);
                fseek(pfptr,(no-1)*sizeof(struct personel),SEEK_SET);
                fwrite(&kisi,sizeof(struct personel),1,pfptr);
                printf("Eklemek istediginiz personelin nosunu giriniz{Cikis[0]}\n?");
                fflush(stdin);
                scanf("%d",&no);
                fseek(pfptr,(no-1)*sizeof(struct personel),SEEK_SET);
                fread(&kisi,sizeof(struct personel),1,pfptr);
            }
            if (kisi.no==no)
            {
                printf("Girdiginiz degere sahip bir personel var!\n");
            }
        }
        while (no!=0);
    }
    fclose(pfptr);
}

void guncelle_personel(void)/*Personelin maaþ katsayýsýný ve unvanýný güncelliyor*/
{
    int no;
    struct personel kisi=
    {
        0,"","","",0,0
    };

    FILE *pfptr;

    if ((pfptr=fopen("personel.dat","r+"))==NULL)
    {
        printf("Dosya=personel.dat acilamadi!\n");
    }
    else
    {

        do
        {
            do
            {
                printf("Guncellemek istediginiz personelin nosunu giriniz{Cikis[0]}\n?");
                fflush(stdin);
                scanf("%d",&no);
                if (no==0)
                {
                    break;
                }
                fseek(pfptr,(no-1)*sizeof(struct personel),SEEK_SET);
                fread(&kisi,sizeof(struct personel),1,pfptr);
            }
            while (kisi.no==-1);
            if (no==0)
            {
                break;
            }
            printf("Unvani giriniz\n?");
            fflush(stdin);
            gets(kisi.unvan);
            printf("Ucret katsayisini giriniz\n?");
            fflush(stdin);
            scanf("%f",&kisi.ucret_katsayisi);
            fseek(pfptr,(no-1)*sizeof(struct personel),SEEK_SET);
            fwrite(&kisi,sizeof(struct personel),1,pfptr);
        }
        while (no!=0);
    }
    fclose(pfptr);
}

void ekle_mesai(void)/*personelin o gün için giriþ/çýkýþ zamanýna
iliþkin veriler kullanýcýdan alýnarak “mesai.txt” dosyasýnýn sonuna
ekleniyor ve personelin bu ayda çalýþtýðý toplam süre güncelleniyor.*/
{
    int gun_no;
    int personel_no;

    struct mesai is=
    {
        0,0,0,0,0,0
    };

    struct personel kisi=
    {
        0,"","","",0,0
    };

    FILE *pfptr;
    FILE *mfptr;

    if ((pfptr=fopen("personel.dat","r"))==NULL)
    {
        printf("Dosya=personel.dat acilamadi!\n");
    }
    else
    {
        if ((mfptr=fopen("mesai.txt","a+"))==NULL)
        {
            printf("Dosya=personel.dat acilamadi!\n");
        }
        else
        {
            printf("Eklemek istediginiz gun nosunu giriniz{Cikis[0]}\n?");
            fflush(stdin);
            scanf("%d",&gun_no);
            while(gun_no!=0)
            {
            printf("Eklemek istediginiz personel nosunu giriniz\n?");
            fflush(stdin);
            scanf("%d",&personel_no);
            fseek(pfptr,(personel_no-1)*sizeof(struct personel),SEEK_SET);
            fread(&kisi,sizeof(struct personel),1,pfptr);
            if (kisi.no==personel_no)
            {
                printf("Giris-cikis saat ve dakikasini aralarinda bosluk biraakarak giriniz\n?");
                scanf("%d %d %d %d",&is.giris_saati,&is.giris_dakikasi,&is.cikis_saati,&is.cikis_dakikasi);
                fprintf(mfptr," %d %d %d %d %d %d\n",personel_no,gun_no,is.giris_saati,is.giris_dakikasi,is.cikis_saati,is.cikis_dakikasi);
                fseek(pfptr,(personel_no-1)*sizeof(struct personel),SEEK_SET);
                kisi.sure+=is.cikis_saati*60+is.cikis_dakikasi-is.giris_saati*60-is.giris_dakikasi;
                fwrite(&kisi,sizeof(struct personel),1,pfptr);
            }
            else
            {
                printf("Bu numaraya sahip personel bulunmamaktadir!\n");
            }
            printf("Eklemek istediginiz gun nosunu giriniz{Cikis[0]}\n?");
            fflush(stdin);
            scanf("%d",&gun_no);
            }
        }
        fclose(mfptr);
    }
    fclose(pfptr);
}

void sil_personel(void)/*Önce personel numarasý kullanýcýdan alýnýp, personel varsa
o personele iliþkin bilgiler ve o personelin tüm mesai kayýtlarý (varsa) silinir.*/
{
    int no;

    struct personel kisi=
    {
        0,"","","",0,0
    };
    struct mesai is=
    {
        0,0,0,0,0,0
    };

    FILE *pfptr;
    FILE *mfptr;
    FILE *gfptr;

    if ((pfptr=fopen("personel.dat","r+"))==NULL)
    {
        printf("Dosya acilamadi!\n");
    }
    else
    {
        do
        {
            printf("Silinmesini istediginiz personelin nosunu giriniz{Cikis[0]}\n?");
            fflush(stdin);
            scanf("%d",&no);
            if (no!=0)
            {
                fseek(pfptr,(no-1)*sizeof(struct personel),SEEK_SET);
                kisi.no=-1;
                fwrite(&kisi,sizeof(struct personel),1,pfptr);
                if ((mfptr=fopen("mesai.txt","r"))==NULL)
                {
                    printf("Dosya=mesai.txt acilamadi!\n");
                    break;
                }
                else
                {
                    do
                    {
                        fscanf(mfptr,"%d%d%d%d%d%d",&is.no,&is.gun_no,&is.giris_saati,&is.giris_dakikasi,&is.cikis_saati,&is.cikis_dakikasi);
                        if (is.no==no)
                        {
                            rewind(mfptr);
                            break;
                        }
                    }
                    while (!feof(mfptr));
                    if (is.no==no)
                    {
                        if ((gfptr=fopen("gecici.txt","w+"))==NULL)
                        {
                            printf("Dosya=gecici.txt acilamadi!\n");
                            break;
                        }
                        else
                        {
                            fscanf(mfptr,"%d%d%d%d%d%d",&is.no,&is.gun_no,&is.giris_saati,&is.giris_dakikasi,&is.cikis_saati,&is.cikis_dakikasi);
                            while (kisi.no!=no&&!feof(mfptr))
                            {
                                fprintf(gfptr,"%d%d%d%d%d%d",is.no,is.gun_no,is.giris_saati,is.giris_dakikasi,is.cikis_saati,is.cikis_dakikasi);
                                fscanf(mfptr,"%d%d%d%d%d%d",&is.no,&is.gun_no,&is.giris_saati,&is.giris_dakikasi,&is.cikis_saati,&is.cikis_dakikasi);
                            }
                        }
                        fclose(gfptr);
                        remove("mesai.txt");
                        rename("gecici.txt","mesai.txt");
                    }
                }
                fclose(mfptr);
            }
        }
        while (no!=0);
    }
    fclose(pfptr);
}

void yedekle_dosya_personel(void)/*“personel.dat” dosyasýndaki (dolu) kayýtlarý,
personel numarasýna göre sýralý olarak içeren “personel_yedek.dat”
isimli doðrudan eriþimli bir dosya oluþturulmaktadýr.*/
{
    int i;

    struct personel kisi=
    {
        0,"","","",0,0
    };

    FILE *pfptr;
    FILE *ypfptr;

    if ((pfptr=fopen("personel.dat","r"))==NULL)
    {
        printf("Dosya=personel.dat acilamadi!");
    }
    else
    {
        if ((ypfptr=fopen("yedek_personel.dat","w+"))==NULL)
        {
            printf("Dosya=yedek_personel.dat acilamadi!");
        }
        else
        {
            for (i=0;i<=100;i++)
            {
                fwrite(&kisi,sizeof(struct personel),1,ypfptr);
            }
            fread(&kisi,sizeof(struct personel),1,pfptr);
            do
            {
                if (kisi.no!=-1)
                {
                    fseek(ypfptr,(kisi.no-1)*sizeof(struct personel),SEEK_SET);
                    fwrite(&kisi,sizeof(struct personel),1,ypfptr);
                }
                fread(&kisi,sizeof(struct personel),1,pfptr);
            }
            while (!feof(pfptr));
        }
        fclose(ypfptr);
    }
    fclose(pfptr);
}

void arama_programi(void)/*Kullanýcýdan bilgilerini görmek istediði
personelin numarasý alýnarak, “personel_yedek.dat” dosyasýnda
aranýyor ve varsa personel bilgileri listeleniyor*/
{
    int no;
    struct personel kisi=
    {
        0,"","","",0,0
    };

    FILE *pfptr;

    if ((pfptr=fopen("personel.dat","r"))==NULL)
    {
        printf("Dosya acilamadi!\n");
    }
    else
    {
        printf("Listelenmesini istediginiz personelin nosunu giriniz{Cikis[0]}\n?");
        fflush(stdin);
        scanf("%d",&no);
        fseek(pfptr,(no-1)*sizeof(struct personel),SEEK_SET);
        fread(&kisi,sizeof(struct personel),1,pfptr);
        while (no!=0)
        {
            if (kisi.no==-1)
            {
                printf("Personel#%d hakkinda bilgi yok!\n",no);
            }
            else
            {
                printf("Per No Ad Soyad                  Ise Gir Tar Unvani          Ucr Katsayisi\n");
                printf("------ ------------------------- ----------- --------------- -------------\n");
                printf("%-7d%-26s",kisi.no,kisi.ad_soyad);
                putchar(kisi.tarih[0]);
                putchar(kisi.tarih[1]);
                printf(".");
                putchar(kisi.tarih[2]);
                putchar(kisi.tarih[3]);
                printf(".");
                putchar(kisi.tarih[4]);
                putchar(kisi.tarih[5]);
                putchar(kisi.tarih[6]);
                putchar(kisi.tarih[7]);
                printf("  %-16s%.2f\n",kisi.unvan,kisi.ucret_katsayisi);
            }
            printf("Listelenmesini istediginiz personelin nosunu giriniz{Cikis[0]}\n?");
            fflush(stdin);
            scanf("%d",&no);
            fseek(pfptr,(no-1)*sizeof(struct personel),SEEK_SET);
            fread(&kisi,sizeof(struct personel),1,pfptr);
        }
    }
    fclose(pfptr);
}
