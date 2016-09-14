#include <stdio.h>
#include <stdlib.h>
#include <time.h>

enum OlayTipi {BOZULMA,LATKA_TAMIR, LATKA_BITIR, JIM_TAMIR, JIM_BITIR};
typedef struct olay
{
    float olayZamani;
    enum OlayTipi olayAdi;
}Olay;
typedef struct olayDugumu
{
    Olay olayVerisi;
    struct olayDugumu *sonraki;
}OlayDugumu;
typedef struct aracDugumu
{

    float bozulmaZamani;

    struct aracDugumu *sonraki;

}AracDugumu;
float rasgeleSayi();
float U(float,float); //Surekli dagilis fonksiyonu
void olayEkle(OlayDugumu*,OlayDugumu*);
OlayDugumu* olayCikar(OlayDugumu*);
void aracEkle(AracDugumu*, float);
AracDugumu *aracCikar(AracDugumu*);
int olayKuyruguBosMu(OlayDugumu *);
int aracKuyruguBosMu(AracDugumu *);
int aracSayisi(AracDugumu *);
void BD(float,int*,AracDugumu*,int*,int*,int,OlayDugumu*,float [],float [],float []);
void LR(float,int *,AracDugumu *,float *,int *,OlayDugumu *,float [],float [],float []);
void JR(float,int *,AracDugumu *,float *,int *,float *,OlayDugumu *,float [],float [],float []);
void LD(int *,AracDugumu *,float zaman,float *,int *,OlayDugumu *,float [],float [],float []);
void JD(int *,AracDugumu *,float,float *,int *,float *,OlayDugumu *,float [],float [],float []);
char *tipBelirle(enum OlayTipi);
int main()
{
    int i;
    float zaman=0.0,jimSure=0,toplamBeklemeSuresi=0;
    AracDugumu *aracKuyruguBasi;
    OlayDugumu *olayKuyruguBasi, *yeniOlayDugumu;
    Olay yeniOlay;
    enum OlayTipi sonrakiOlay;
    float bitis[50]={0.0},baslangic[50]={0.0},tablo[50]={0.0};
    int toplamBozulma=0, latkaMesgul=0, jimMesgul=0, aracKuyruguEsigi, toplamTamir=0;
    srand(time(NULL));
    olayKuyruguBasi = malloc(sizeof(OlayDugumu));
    olayKuyruguBasi->sonraki = NULL; // bos olay kuyrugu olsuturuyoruz
    aracKuyruguBasi = malloc(sizeof(AracDugumu)); //bos arac kuyrugu olusturuluyor
    aracKuyruguBasi->sonraki = NULL;
    printf("Arac kuyrugu esigini (THRESHOLD) giriniz: ");
    scanf("%d",&aracKuyruguEsigi);

    //bozulan araclar olay kuyruguna ekleniyor
    while (zaman<=24)
    {
        zaman+=0.16; // 0.16 saat 10 dk ye esit. araclarin garaja gelis suresini de hesaba katiyoruz.
        if (zaman > 24)
            break;
        yeniOlay.olayAdi=BOZULMA;
        yeniOlay.olayZamani=zaman;
        yeniOlayDugumu=malloc(sizeof(OlayDugumu));
        if (yeniOlayDugumu == NULL)
        {
            printf("Bellekte yer yok");
            return 0;
        }
        yeniOlayDugumu->olayVerisi = yeniOlay;
        yeniOlayDugumu->sonraki = NULL;
        olayEkle(olayKuyruguBasi,yeniOlayDugumu);
        zaman+=U(0.5,2.5);
    }
    //let's the game begin.
    zaman = 0;
    while (!olayKuyruguBosMu(olayKuyruguBasi))
    {
        OlayDugumu *cikarilan;
        if (olayKuyruguBosMu(olayKuyruguBasi))
            break;
        cikarilan=olayCikar(olayKuyruguBasi);
        zaman=cikarilan->olayVerisi.olayZamani;
        sonrakiOlay=cikarilan->olayVerisi.olayAdi;
        free(cikarilan);
        switch (sonrakiOlay)
        {
            case BOZULMA:
                BD(zaman,&toplamBozulma,aracKuyruguBasi,&latkaMesgul,&jimMesgul,aracKuyruguEsigi,olayKuyruguBasi,baslangic,bitis,tablo);
            break;
            case LATKA_TAMIR:
                LR(zaman,&latkaMesgul,aracKuyruguBasi,&toplamBeklemeSuresi,&toplamTamir,olayKuyruguBasi,baslangic,bitis,tablo);
            break;
            case JIM_TAMIR:
                JR(zaman,&jimMesgul,aracKuyruguBasi,&toplamBeklemeSuresi,&toplamTamir,&jimSure,olayKuyruguBasi,baslangic,bitis,tablo);
            break;
            case LATKA_BITIR:
                LD(&latkaMesgul, aracKuyruguBasi, zaman, &toplamBeklemeSuresi, &toplamTamir, olayKuyruguBasi,baslangic,bitis,tablo);
            break;
            case JIM_BITIR:
                JD(&jimMesgul, aracKuyruguBasi, zaman, &toplamBeklemeSuresi, &toplamTamir, &jimSure, olayKuyruguBasi,baslangic,bitis,tablo);
            break;
        }
    }
    printf("Gunisigi Sirketi Simulasyonu\n");
    printf("Arac Kuyrugu Esigi: %d\n", aracKuyruguEsigi);
    printf("Toplam Bozulmalar: %d\n", toplamBozulma);
    printf("Toplam Tamir Edilenler: %d\n", toplamTamir);
    printf("Ortalama Tamir Bekleme Süresi: %.2f\n",(float)toplamBeklemeSuresi/toplamTamir);
    printf("Jim'in Calistigi Sure: %.2f\n", jimSure);
    printf("Jim'in Arac Kullanmamasindan olusan kayip: %.2f\n", jimSure*15.0);
    for (i=0; i<50; i++)
    {
        printf("%d arac %.2f saat\n",i+1,tablo[i]);
    }
    return 0;
}
float rasgeleSayi ()
{
    float aralik = RAND_MAX+1;
    float temel = rand()/aralik;
    float guzelDeger = rand()/aralik;
    return temel+guzelDeger/aralik;
    //tam anlamiyla surekli dagilima yakin sayi ureten fonksiyon
}
float U(float alt, float ust)
{
    return alt+(ust-alt)*rasgeleSayi();
}
void olayEkle(OlayDugumu *olayKuyruguBasi, OlayDugumu *yeniOlayDugumu)
{
    OlayDugumu *gecici,*onceki;
    if (olayKuyruguBosMu(olayKuyruguBasi))
    {
        olayKuyruguBasi->sonraki = yeniOlayDugumu;
    }
    else if (yeniOlayDugumu->olayVerisi.olayZamani <= olayKuyruguBasi->sonraki->olayVerisi.olayZamani)
    {
        yeniOlayDugumu->sonraki = olayKuyruguBasi->sonraki;
        olayKuyruguBasi->sonraki = yeniOlayDugumu;
    }
    else
    {
        gecici = olayKuyruguBasi->sonraki;
        onceki = olayKuyruguBasi->sonraki;
        while (gecici != NULL && yeniOlayDugumu->olayVerisi.olayZamani > gecici->olayVerisi.olayZamani)
        {
            onceki=gecici;
            gecici=gecici->sonraki;
        }
        onceki->sonraki = yeniOlayDugumu;
        yeniOlayDugumu->sonraki = gecici;
    }
    printf("%.2f -- %s olayi eklendi.\n",yeniOlayDugumu->olayVerisi.olayZamani,tipBelirle(yeniOlayDugumu->olayVerisi.olayAdi));
}
void aracEkle(AracDugumu *aracKuyruguBasi,float bozulmaZamani)
{
    AracDugumu *gecici,*onceki;
    AracDugumu *eklenecek;

    eklenecek = malloc(sizeof(AracDugumu));
    if (eklenecek == NULL)
    {
        printf("bellekte yeterli yer yok");
        return;
    }
    eklenecek->bozulmaZamani=bozulmaZamani;
    eklenecek->sonraki = NULL;
    if (aracKuyruguBasi->sonraki == NULL)
        aracKuyruguBasi->sonraki = eklenecek;
    else
    {
        gecici=aracKuyruguBasi->sonraki;
        onceki=aracKuyruguBasi->sonraki;
        while (gecici != NULL)
        {
            onceki=gecici;
            gecici=gecici->sonraki;
        }
        onceki->sonraki=eklenecek;
    }
}
AracDugumu *aracCikar(AracDugumu *aracKuyruguBasi)
{
    AracDugumu *cikarilan;
    cikarilan = aracKuyruguBasi->sonraki;
    aracKuyruguBasi->sonraki=aracKuyruguBasi->sonraki->sonraki;
    return cikarilan;
}
OlayDugumu* olayCikar(OlayDugumu *olayKuyruguBasi)
{
    OlayDugumu *cikarilan;
    cikarilan = olayKuyruguBasi->sonraki;
    olayKuyruguBasi->sonraki=olayKuyruguBasi->sonraki->sonraki;
    return cikarilan;
}
int olayKuyruguBosMu(OlayDugumu *olayKuyruguBasi)
{
    if (olayKuyruguBasi->sonraki == NULL)
        return 1;
    else
        return 0;
}

int aracKuyruguBosMu(AracDugumu *aracKuyruguBasi)
{
    if (aracKuyruguBasi->sonraki == NULL)
        return 1;
    else
        return 0;
}
void BD(float zaman,int *toplamBozulma,AracDugumu *aracKuyruguBasi,int *latkaMesgul,int *jimMesgul,int aracKuyruguEsigi,OlayDugumu *olayKuyruguBasi,float baslangic[],float bitis[],float tablo[])
{
    Olay yeniOlay;
    OlayDugumu *yeniOlayDugumu;

    (*toplamBozulma)++;
    bitis[aracSayisi(aracKuyruguBasi)]=zaman;
    tablo[aracSayisi(aracKuyruguBasi)]=bitis[aracSayisi(aracKuyruguBasi)]-baslangic[aracSayisi(aracKuyruguBasi)];
    aracEkle(aracKuyruguBasi, zaman);
    baslangic[aracSayisi(aracKuyruguBasi)]=zaman;
    yeniOlayDugumu=malloc(sizeof(OlayDugumu));
        if (yeniOlayDugumu == NULL)
        {
            printf("Bellekte yer yok");
            return;
        }
    if (*latkaMesgul == 0)
    {
        yeniOlay.olayAdi=LATKA_TAMIR;
        yeniOlay.olayZamani=zaman;
        yeniOlayDugumu->olayVerisi = yeniOlay;
        yeniOlayDugumu->sonraki = NULL;
        olayEkle(olayKuyruguBasi, yeniOlayDugumu);
    }
    else if (aracSayisi(aracKuyruguBasi) >= aracKuyruguEsigi && *jimMesgul == 0)
    {
        yeniOlay.olayAdi=JIM_TAMIR;
        yeniOlay.olayZamani=zaman;
        yeniOlayDugumu->olayVerisi = yeniOlay;
        yeniOlayDugumu->sonraki = NULL;
        olayEkle(olayKuyruguBasi, yeniOlayDugumu);
    }
}
void LR(float zaman,int *latkaMesgul,AracDugumu *aracKuyruguBasi,float *toplamBeklemeSuresi,int *toplamTamir,OlayDugumu *olayKuyruguBasi,float baslangic[],float bitis[],float tablo[])
{
    AracDugumu *cikarilan;
    float beklemeSuresi,tamirSuresi,geriGitmeSuresi;
    Olay yeniOlay;
    OlayDugumu *yeniOlayDugumu;

    *latkaMesgul = 1;
    bitis[aracSayisi(aracKuyruguBasi)]=zaman;
    tablo[aracSayisi(aracKuyruguBasi)]=bitis[aracSayisi(aracKuyruguBasi)]-baslangic[aracSayisi(aracKuyruguBasi)];
    cikarilan=aracCikar(aracKuyruguBasi);
    baslangic[aracSayisi(aracKuyruguBasi)]=zaman;
    beklemeSuresi = zaman-cikarilan->bozulmaZamani;
    free(cikarilan);
    *toplamBeklemeSuresi += beklemeSuresi;
    (*toplamTamir)++;
    tamirSuresi = U(2.0,5.0);
    yeniOlayDugumu=malloc(sizeof(OlayDugumu));
    if (yeniOlayDugumu == NULL)
    {
            printf("Bellekte yer yok");
            return;
    }
    yeniOlay.olayAdi=LATKA_BITIR;
    yeniOlay.olayZamani=zaman+tamirSuresi;
    yeniOlayDugumu->olayVerisi = yeniOlay;
    yeniOlayDugumu->sonraki = NULL;
    olayEkle(olayKuyruguBasi,yeniOlayDugumu);
    if (rasgeleSayi()>=0.9)
    {
        yeniOlayDugumu=malloc(sizeof(OlayDugumu));
        if (yeniOlayDugumu == NULL)
        {
            printf("Bellekte yer yok");
            return;
        }
        geriGitmeSuresi=U(1.0,2.0);
        yeniOlay.olayAdi=BOZULMA;
        yeniOlay.olayZamani=zaman+tamirSuresi+geriGitmeSuresi;
        yeniOlayDugumu->olayVerisi = yeniOlay;
        yeniOlayDugumu->sonraki = NULL;
        olayEkle(olayKuyruguBasi,yeniOlayDugumu);
    }
}
void JR(float zaman,int *jimMesgul,AracDugumu *aracKuyruguBasi,float *toplamBeklemeSuresi,int *toplamTamir,float *jimSure,OlayDugumu *olayKuyruguBasi,float baslangic[],float bitis[],float tablo[])
{
    AracDugumu *cikarilan;
    float beklemeSuresi,tamirSuresi,geriGitmeSuresi;
    Olay yeniOlay;
    OlayDugumu *yeniOlayDugumu;

    *jimMesgul = 1;
    bitis[aracSayisi(aracKuyruguBasi)]=zaman;
    tablo[aracSayisi(aracKuyruguBasi)]=bitis[aracSayisi(aracKuyruguBasi)]-baslangic[aracSayisi(aracKuyruguBasi)];
    cikarilan=aracCikar(aracKuyruguBasi);
    baslangic[aracSayisi(aracKuyruguBasi)]=zaman;
    beklemeSuresi = zaman-cikarilan->bozulmaZamani;
    free(cikarilan);
    *toplamBeklemeSuresi += beklemeSuresi;
    (*toplamTamir)++;
    tamirSuresi = 0.25; //jim icin sabitti
    yeniOlayDugumu=malloc(sizeof(OlayDugumu));
    if (yeniOlayDugumu == NULL)
    {
            printf("Bellekte yer yok");
            return;
    }
    yeniOlay.olayAdi=JIM_BITIR;
    yeniOlay.olayZamani=zaman+tamirSuresi;
    yeniOlayDugumu->olayVerisi = yeniOlay;
    yeniOlayDugumu->sonraki = NULL;
    olayEkle(olayKuyruguBasi,yeniOlayDugumu);
    *jimSure+=tamirSuresi;
    if (rasgeleSayi()>=0.3)
    {
        geriGitmeSuresi=U(1.0,2.0);
        yeniOlayDugumu=malloc(sizeof(OlayDugumu));
        if (yeniOlayDugumu == NULL)
        {
            printf("Bellekte yer yok");
            return;
        }
        yeniOlay.olayAdi=BOZULMA;
        yeniOlay.olayZamani=zaman+tamirSuresi+geriGitmeSuresi;
        yeniOlayDugumu->olayVerisi = yeniOlay;
        yeniOlayDugumu->sonraki = NULL;
        olayEkle(olayKuyruguBasi,yeniOlayDugumu);
    }
}
void LD(int *latkaMesgul,AracDugumu *aracKuyruguBasi,float zaman,float *toplamBeklemeSuresi,int *toplamTamir,OlayDugumu *olayKuyruguBasi,float baslangic[],float bitis[],float tablo[])
{
    *latkaMesgul = 0;

    if (aracSayisi(aracKuyruguBasi) > 0)
        LR(zaman,latkaMesgul,aracKuyruguBasi,toplamBeklemeSuresi,toplamTamir,olayKuyruguBasi,baslangic,bitis,tablo);
}
void JD(int *jimMesgul,AracDugumu *aracKuyruguBasi,float zaman,float *toplamBeklemeSuresi,int *toplamTamir,float *jimSure,OlayDugumu *olayKuyruguBasi,float baslangic[],float bitis[],float tablo[])
{
    *jimMesgul = 0;

    if (aracSayisi(aracKuyruguBasi) > 0)
        JR(zaman,jimMesgul,aracKuyruguBasi,toplamBeklemeSuresi,toplamTamir,jimSure,olayKuyruguBasi,baslangic,bitis,tablo);
}
int aracSayisi (AracDugumu *aracKuyruguBasi) //bozuk araclar kuyrugundaki aracsayisini bulmak icin
{
    int elemanSay=0;
    AracDugumu *gecici;

    gecici = aracKuyruguBasi->sonraki;
    while (gecici != NULL)
    {
        gecici=gecici->sonraki;
        elemanSay++;
    }
    return elemanSay;
}
char *tipBelirle(enum OlayTipi tip) //ara durum ciktilari icin enum tipten string e cevirme
{
    if (tip == BOZULMA)
        return "BOZULMA";

    if (tip == LATKA_TAMIR)
        return "LATKA TAMIR";

    if (tip == LATKA_BITIR)
        return "LATKA BITIR";

    if (tip == JIM_TAMIR)
        return "JIM TAMIR";

    if (tip == JIM_BITIR)
        return "JIM BITIR";

        return "";
}
