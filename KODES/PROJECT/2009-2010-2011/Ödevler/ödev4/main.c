#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

struct mesai
{
    int personel_no;
    int gun_no;
    int giris_saati;
    int giris_dakikasi;
    int cikis_saati;
    int cikis_dakikasi;
    struct mesai *ayni_personel_icin_gune_gore_onceki;
    struct mesai *ayni_personel_icin_gune_gore_sonraki;
    struct mesai *ayni_gun_icin_sonraki;
};

struct personel
{
    int personel_no;
    char tc_kimlik_no[12];
    char ad_soyad[26];
    char unvan[16];
    float ucret_katsayisi;
    struct personel *tc_kimlik_noya_gore_sonraki;
    struct mesai *o_personelin_mesai_verileri_listesinin_liste_basi_dugumu;
};

struct personel *ara(struct personel *bas,char *tc);

void coklu_listele(struct personel *bas[]);

void tek_listele(struct personel *bas);

void unvanli_tc_listele(struct personel *bas,char *unvan);

void unvana_gore_personel_listele(struct personel bas[]);

void tc_ekle(struct personel *bas, struct personel *yeni);//tc kimlik noya göre küçükten büyüðe sýralý ekleme iþlemi yapýyor

void ana_tc_listele(struct personel bas[]);

void tc_listele(struct personel *bas,char *tc);

void ana_geciken_listele(struct mesai *bas[]);

void geciken_listele(struct mesai *bas);

void mesai_ekle(struct mesai *bas, struct mesai *yeni);

void mesai_listele(struct mesai *bas);

void gun_ekle(struct mesai **bas,struct mesai *yeni);

void aylik_listele(struct personel *bas[]);

void gun_listele(struct mesai *bas);

void gune_gore_mesai_listele(struct mesai *bas[]);

void gelmeyen_listele(struct personel *bas[]);

int menu(void);// Menüyü yazdýrýyor

int hash(char tc[12]);// Tc kimlik no'nun rakamlarý toplamýný döndürüyor.

int bos_mu(struct mesai *bas);

int main()
{
    struct personel *p_no[9000]=
    {
        NULL
    };//iþaretçi dizisi personel bilgisi ptrlerini tutuyor

    struct personel tc[100];//hash tablosu dairesel tek baðlý liste baþý ptrlerini tutuyor

    struct mesai *gun[31]=
    {
        NULL
    };//iþaretçi dizisi bir aylýk mesai bilgilerinin hergününün liste baþý ptrlerini tutuyor

    struct mesai *birgun;//mesai bilgisini tutmak için bir eleman

    int i,no,gun_no,secim;//i=sayac, secim: menude yönlendirme yapmak için kullanýlmýþtýr.

    char tc_no[12];

    //bu kýsým tc kimlik noya göre sýralý bir þekilde
    //personel bilgilerini tutacak olan listenin liste baþý ptrlerini tutuyor
    for (i=0;i<100;i++)
    {
        //Düðümler iþaretçilere baðlanýyor
        tc[i].tc_kimlik_noya_gore_sonraki=&tc[i];//liste basi dugumune sahip dairesel tek bagli liste ilkleniyor
    }

    do //kullanýcýyý gerçekleþtirmek istediði þeye yönlendirmek için oluþturulmuþtur
    {
        secim=menu();
        switch (secim)
        {
        case 1://Yeni bir personelin eklenmesi için kullanýlýmýþtýr
            printf("Personel noyu giriniz\n?");
            fflush(stdin);
            scanf("%d",&no);
            if (p_no[no-1000]==NULL)
            {
                printf("TC noyu giriniz\n?");
                fflush(stdin);
                gets(tc_no);
                if (ara(&tc[hash(tc_no)],tc_no)==NULL)
                {
                    do
                    {
                        p_no[no-1000]=malloc(sizeof(struct personel));
                    }
                    while (p_no[no-1000]==NULL);

                    p_no[no-1000]->personel_no=no;
                    strcpy(p_no[no-1000]->tc_kimlik_no,tc_no);
                    printf("Ad soyad giriniz\n?");
                    gets(p_no[no-1000]->ad_soyad);
                    printf("Unvan giriniz\n?");
                    gets(p_no[no-1000]->unvan);
                    printf("Ucret katsayisi giriniz\n?");
                    scanf("%f",&p_no[no-1000]->ucret_katsayisi);
                    p_no[no-1000]->o_personelin_mesai_verileri_listesinin_liste_basi_dugumu=NULL;
                    tc_ekle(&tc[hash(tc_no)],p_no[no-1000]);
                }
                else
                {
                    printf("#%s Tc kimlik nolu personel mevcut!\n",tc_no);
                }
            }
            else
            {
                printf("Personel#%d mevcut!\n",no);
            }
            break;
        case 2://Bir personelin bilgilerinin güncellenmesi için kullanýlýmýþtýr
            printf("Personel noyu giriniz\n?");
            fflush(stdin);
            scanf("%d",&no);
            if (p_no[no-1000]!=NULL)
            {
                printf("Unvan giriniz\n?");
                fflush(stdin);
                gets(p_no[no-1000]->unvan);
                printf("Ucret katsayisi giriniz\n?");
                fflush(stdin);
                scanf("%f",&p_no[no-1000]->ucret_katsayisi);
            }
            else
            {
                printf("Personel#%d mevcut degil!\n\n",no);
            }
            /*personel_guncelle();*/
            break;
        case 3://Belirli bir günün mesai kayýtlarýnýn eklenmesi için kullanýlýmýþtýr
            printf("Gun no giriniz{Cikis[0]}\n?");
            fflush(stdin);
            scanf("%d",&gun_no);
            do
            {
                do
                {
                    printf("Personel noyu giriniz\n?");
                    fflush(stdin);
                    scanf("%d",&no);
                    if (p_no[no-1000]->personel_no!=no)
                    {
                        printf("Personel#%d mevcut degil!\n\n",no);
                    }
                }
                while (p_no[no-1000]->personel_no!=no);

                if (p_no[no-1000]->o_personelin_mesai_verileri_listesinin_liste_basi_dugumu==NULL)
                {
                    p_no[no-1000]->o_personelin_mesai_verileri_listesinin_liste_basi_dugumu=malloc(sizeof(struct mesai));
                    p_no[no-1000]->o_personelin_mesai_verileri_listesinin_liste_basi_dugumu->ayni_personel_icin_gune_gore_onceki=p_no[no-1000]->o_personelin_mesai_verileri_listesinin_liste_basi_dugumu;
                    p_no[no-1000]->o_personelin_mesai_verileri_listesinin_liste_basi_dugumu->ayni_personel_icin_gune_gore_sonraki=p_no[no-1000]->o_personelin_mesai_verileri_listesinin_liste_basi_dugumu;
                    p_no[no-1000]->o_personelin_mesai_verileri_listesinin_liste_basi_dugumu=p_no[no-1000]->o_personelin_mesai_verileri_listesinin_liste_basi_dugumu;
                }

                birgun=malloc(sizeof(struct mesai));
                birgun->personel_no=no;
                birgun->gun_no=gun_no;
                printf("Giris-cikis saat ve dakikasini aralarinda bosluk birakarak giriniz\n?");
                scanf("%d %d %d %d",&birgun->giris_saati,&birgun->giris_dakikasi,&birgun->cikis_saati,&birgun->cikis_dakikasi);
                mesai_ekle(p_no[no-1000]->o_personelin_mesai_verileri_listesinin_liste_basi_dugumu,birgun);
                gun_ekle(&gun[gun_no-1],birgun);
                printf("Gun no giriniz{Cikis[0]}\n?");
                fflush(stdin);
                scanf("%d",&gun_no);
            }
            while (gun_no!=0);
            break;
        case 6://Bir personelin bilgilerinin listelenmesi için kullanýlýmýþtýr
            ana_tc_listele(tc);
            break;
        case 7://Bir personelin bilgilerinin ve o ay için mesai kayýtlarýnýn listelenmesi için kullanýlýmýþtýr
            aylik_listele(p_no);
            break;
        case 8://Tüm personelin bilgilerinin listelenmesi için kullanýlýmýþtýr
            coklu_listele(p_no);
            break;
        case 9://Belirli bir ünvana sahip personelin listelenmesi için kullanýlýmýþtýr
            unvana_gore_personel_listele(tc);
            break;
        case 10://Belirli bir günün mesai kayýtlarýnýn listelenmesi için kullanýlýmýþtýr
            gune_gore_mesai_listele(gun);
            break;
        case 11://Mesaiye geç gelen personel sayýlarýnýn listelenmesi için kullanýlýmýþtýr
            ana_geciken_listele(gun);
            break;
        case 12://O ay mesaiye hiç gelmeyen personelin listelenmesi için kullanýlýmýþtýr
            gelmeyen_listele(p_no);
            break;
        }
    }
    while (secim!=0);//kontrol yapýlýyor kullanýcý yanlýþ bir deðer girerse tekrar soruyor

    return 0;
}
struct personel *ara(struct personel *bas,char *tc)//tc listede bulunursa isaretcisi dondurulur, bulunamazsa NULL dondurulur
{
    struct personel *gecici;

    gecici=bas->tc_kimlik_noya_gore_sonraki;

    while (gecici!=bas && 0<=memcmp(tc,gecici->tc_kimlik_no,11))//dikkat:liste tc noya gore sirali, burada numaraya gore arama yapiliyor
    {
        if (memcmp(gecici->tc_kimlik_no,tc,11)==0) return gecici;
        gecici=gecici->tc_kimlik_noya_gore_sonraki;
    }

    return NULL;
}
void coklu_listele(struct personel *bas[])
{
    int i;

    printf("Per No TC Kimlik No Ad Soyad                  Unvani            Ucr  Katsayisi\n");
    printf("------ ------------ ------------------------- ----------------- --------------\n");

    for (i=0;i<9000;i++)
    {
        tek_listele(bas[i]);
    }
}
void tek_listele(struct personel *bas)
{
    if (bas!=NULL)
    {
        printf("%-7d%-13s%-26s%-18s%02.1f\n",bas->personel_no,bas->tc_kimlik_no,bas->ad_soyad,bas->unvan,bas->ucret_katsayisi);
    }
}
void unvana_gore_personel_listele(struct personel bas[])
{
    char unvan[16];

    int i;

    printf("Unvan giriniz\n?");
    fflush(stdin);
    gets(unvan);
    printf("Per No TC Kimlik No Ad Soyad                  Unvani            Ucr  Katsayisi\n");
    printf("------ ------------ ------------------------- ----------------- --------------\n");

    for (i=0;i<100;i++)
    {
        unvanli_tc_listele(&bas[i],unvan);
    }
}
void tc_ekle(struct personel *bas, struct personel *yeni)
{
    struct personel *onceki, *gecici;

    onceki=bas;
    gecici=bas->tc_kimlik_noya_gore_sonraki;

    while (gecici!=bas && memcmp(gecici->tc_kimlik_no,yeni->tc_kimlik_no,11)<0)
    {
        onceki=gecici;
        gecici=gecici->tc_kimlik_noya_gore_sonraki;
    }

    yeni->tc_kimlik_noya_gore_sonraki=gecici;
    onceki->tc_kimlik_noya_gore_sonraki=yeni;
}
void ana_tc_listele(struct personel bas[])
{
    char tc[12];

    printf("TC noyu giriniz\n?");
    fflush(stdin);
    gets(tc);
    tc_listele(&bas[hash(tc)],tc);
}
void tc_listele(struct personel *bas,char *tc)
{
    struct personel *gecici;

    gecici=bas->tc_kimlik_noya_gore_sonraki;

    while (gecici!=bas && memcmp(gecici->tc_kimlik_no,tc,11)<=0)
    {
        if (memcmp(gecici->tc_kimlik_no,tc,11)==0)
        {
            printf("Per No TC Kimlik No Ad Soyad                  Unvani            Ucr  Katsayisi\n");
            printf("------ ------------ ------------------------- ----------------- --------------\n");
            printf("%-7d%-13s%-26s%-18s%02.1f\n",gecici->personel_no,gecici->tc_kimlik_no,gecici->ad_soyad,gecici->unvan,gecici->ucret_katsayisi);
            break;
        }
        gecici=gecici->tc_kimlik_noya_gore_sonraki;
    }
}
void ana_geciken_listele(struct mesai *bas[])
{
    int i;

    printf("Gun No Kac Kisi Gec Gelmis\n");
    printf("------ -------------------\n");

    for (i=0;i<31;i++)
    {
        printf("%-7d",i+1);
        geciken_listele(bas[i]);
    }
}
void geciken_listele(struct mesai *bas)
{
    int sayac=0;

    while (bas!=NULL)
    {
        if ((bas->giris_saati+bas->giris_dakikasi)>9)
        {
            ++sayac;
        }
        bas=bas->ayni_gun_icin_sonraki;
    }

    printf("%d\n",sayac);
}
void unvanli_tc_listele(struct personel *bas,char *unvan)
{
    struct personel *gecici;

    int uzunluk;

    uzunluk=strlen(unvan);
    gecici=bas->tc_kimlik_noya_gore_sonraki;

    while (gecici!=bas)
    {
        if (memcmp(gecici->unvan,unvan,uzunluk)==0)
        {
            printf("%-7d%-13s%-26s%-18s%02.1f\n",gecici->personel_no,gecici->tc_kimlik_no,gecici->ad_soyad,gecici->unvan,gecici->ucret_katsayisi);
        }
        gecici=gecici->tc_kimlik_noya_gore_sonraki;
    }
}
void mesai_ekle(struct mesai *bas, struct mesai *yeni)
{
    struct mesai *gecici;

    gecici=bas->ayni_personel_icin_gune_gore_sonraki;

    while (gecici!=bas && gecici->gun_no<yeni->gun_no)
    {
        gecici=gecici->ayni_personel_icin_gune_gore_sonraki;
    }

    yeni->ayni_personel_icin_gune_gore_sonraki=gecici;
    yeni->ayni_personel_icin_gune_gore_onceki=gecici->ayni_personel_icin_gune_gore_onceki;
    gecici->ayni_personel_icin_gune_gore_onceki->ayni_personel_icin_gune_gore_sonraki=yeni;
    gecici->ayni_personel_icin_gune_gore_onceki=yeni;
}
void mesai_listele(struct mesai *bas)
{
    struct mesai *gecici;

    gecici=bas->ayni_personel_icin_gune_gore_sonraki;

    while (gecici!=bas)
    {
        printf("%-7d%02d:%02d     %02d:%02d\n",gecici->gun_no,gecici->giris_saati,gecici->giris_dakikasi,gecici->cikis_saati,gecici->cikis_dakikasi);
        gecici=gecici->ayni_personel_icin_gune_gore_sonraki;
    }
}
void gun_ekle(struct mesai **bas,struct mesai *yeni)
{
    if (*bas==NULL)  //kuyruk bossa
    {
        yeni->ayni_gun_icin_sonraki=NULL;
        *bas=yeni;
        printf("Per No Gir Saati Cik Saati\n");
        printf("------ --------- ---------\n");
        printf("%-7d%02d:%02d     %02d:%02d\n",(*bas)->personel_no,(*bas)->giris_saati,(*bas)->giris_dakikasi,(*bas)->cikis_saati,(*bas)->cikis_dakikasi);
    }
    else
    {
        yeni->ayni_gun_icin_sonraki=*bas;
        *bas=yeni;
    }
}
void aylik_listele(struct personel *bas[])
{
    int no;

    printf("Personel noyu giriniz\n?");
    fflush(stdin);
    scanf("%d",&no);

    if (bas[no-1000]!=NULL)
    {
        printf("Per No TC Kimlik No Ad Soyad                  Unvani            Ucr  Katsayisi\n");
        printf("------ ------------ ------------------------- ----------------- --------------\n");
        tek_listele(bas[no-1000]);
        printf("Mesai Verileri:\n");
        printf("Gun No Gir Saati Cik Saati\n");
        printf("------ --------- ---------\n");
        if (!bos_mu(bas[no-1000]->o_personelin_mesai_verileri_listesinin_liste_basi_dugumu))//mesai listesi bos degilse...
        {
            mesai_listele(bas[no-1000]->o_personelin_mesai_verileri_listesinin_liste_basi_dugumu);//o listedeki tum bilgiler gun sirasina gore listeleniyor
        }
        else
        {
            printf("Personel#%d mesaiye hic gelmemis!\n",no);
        }
    }
    else
    {
        printf("Personel#%d mevcut degil!\n\n",no);
    }
}
void gune_gore_mesai_listele(struct mesai *bas[])
{
    int no;

    printf("Gun noyu giriniz\n?");
    fflush(stdin);
    scanf("%d",&no);
    printf("Per No Gir Saati Cik Saati Sure\n");
    printf("------ --------- --------- -----------\n");
    gun_listele(bas[no-1]);//o salonda bekleyen tum adaylar boy sirasina gore listeleniyor
}
void gun_listele(struct mesai *bas)
{
    int top_dk=0,sayac=0,hh,mm,ort_sa,sa,dk;
    float ort_dk;

    while (bas!=NULL)
    {
        sa=bas->cikis_saati-bas->giris_saati;
        dk=bas->cikis_dakikasi-bas->giris_dakikasi;
        top_dk+=(bas->cikis_saati-bas->giris_saati)*60+bas->cikis_dakikasi-bas->giris_dakikasi;
        sayac++;
        printf("%-7d%02d:%02d     %02d:%02d     %02d sa %02d dk\n",bas->personel_no,bas->giris_saati,bas->giris_dakikasi,bas->cikis_saati,bas->cikis_dakikasi,sa,dk);
        bas=bas->ayni_gun_icin_sonraki;//bas bir sonraki dugumu gosteriyor ama main'deki ilk degismiyor
    }
    hh=top_dk/60;
    mm=top_dk%60;
    ort_sa=hh/sayac;
    ort_dk=(float)(((hh-ort_sa*sayac)*60+mm)/sayac);
    printf("Bu gun icin calisma surelerinin ortalamasi: %02d sa %02.2f dk\n",ort_sa,ort_dk);
}
void gelmeyen_listele(struct personel *bas[])
{
    int i;

    printf("Per No TC Kimlik No Ad Soyad                  Unvani            Ucr  Katsayisi\n");
    printf("------ ------------ ------------------------- ----------------- --------------\n");

    for (i=0;i<9000;i++)
    {
        if (bas[i]!=NULL)
        {
            if (bos_mu(bas[i]->o_personelin_mesai_verileri_listesinin_liste_basi_dugumu))//mesai listesi bos degilse...
            {
                tek_listele(bas[i]);
            }
        }
    }
}
int menu(void)
{
    int c;

    printf("0)Cikis\n");
    printf("1)Yeni bir personelin eklenmesi\n");
    printf("2)Bir personelin bilgilerinin guncellenmesi\n");
    printf("3)Belirli bir gunun mesai kayitlarinin eklenmesi\n");
    printf("4)Bir personelin kaydinin silinmesi\n");
    printf("5)O aya iliskin mesai verilerinin silinmesi\n");
    printf("6)Bir personelin bilgilerinin listelenmesi\n");
    printf("7)Bir personelin bilgilerinin ve o ay icin mesai kayitlarinin listelenmesi\n");
    printf("8)Tum personelin bilgilerinin listelenmesi\n");
    printf("9)Belirli bir unvana sahip personelin listelenmesi\n");
    printf("10)Belirli bir gunun mesai kayitlarinin listelenmesi\n");
    printf("11)Mesaiye gec gelen personel sayilarinin listelenmesi\n");
    printf("12)O ay mesaiye hic gelmeyen personelin listelenmesi\n");

    do
    {
        printf("\nSeciminizi giriniz\n?");
        scanf("%d",&c);
    }
    while (c<0 || c>13);//kontrol yapýlýyor kullanýcý yanlýþ bir deðer girerse tekrar soruyor

    return c;
}
int hash(char tc[12])// Tc kimlik no'nun rakamlarý toplamýný döndürüyor.
{
    int sum=0,i;

    for (i=0;i<11;i++)
    {
        sum+=tc[i]-48;
    }
    return sum;
}
int bos_mu(struct mesai *bas)
{
    return bas==NULL;//liste bossa 1(dogru) dondurur, degilse 0(yanlis) dondurur.
}
