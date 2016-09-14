#include <stdio.h>
#include <stdlib.h>

struct ogrenci
{
    int no;
    float ort;
    struct ogrenci *onceki;
    struct ogrenci *sonraki;
};

void d_cift_sirali_ekle(struct ogrenci *liste_basi_ptr, struct ogrenci *yeni);
void kucukten_buyuge_listele(struct ogrenci *liste_basi_ptr);
void buyukten_kucuge_listele(struct ogrenci *liste_basi_ptr);
struct ogrenci *ara(struct ogrenci *liste_basi_ptr, int no);
void toplu_sil(struct ogrenci *liste_basi_ptr, float min_ort);

int main()
{
    struct ogrenci liste_basi;
    struct ogrenci *birOgrenci;
    int no,secim;
    float min_ort;

    liste_basi.sonraki=&liste_basi;//liste basi dugumune sahip dairesel cift bagli liste ilkleniyor
    liste_basi.onceki=&liste_basi;

    do
    {
        printf("1.Yeni bir ogrenci ekleme\n");
        printf("2.Ogrencileri not ortalamalarina gore kucukten buyuge dogru listeleme\n");
        printf("3.Ogrencileri not ortalamalarina gore buyukten kucuge dogru listeleme\n");
        printf("4.Bir ogrencinin not ortalamasini goruntuleme\n");
        printf("5.Bir ogrencinin not ortalamasini guncelleme\n");
        printf("6.Bir ogrenciyi silme\n");
        printf("7.Ortalamasi dusuk olan ogrencileri silme\n");
        printf("8.Cikis\n");
        printf("Seciminizi giriniz:");
        scanf("%d",&secim);
        switch (secim)
        {
        case 1:
            birOgrenci=malloc(sizeof(struct ogrenci));//yeni ogrenci icin bellekten yer ayriliyor
            printf("Ogrencinin numarasini giriniz:");
            scanf("%d",&birOgrenci->no);
            printf("Ogrencinin not ortalamasini giriniz:");
            scanf("%f",&birOgrenci->ort);
            d_cift_sirali_ekle(&liste_basi,birOgrenci);//yeni ogrenci, not ortalamasina gore listenin uygun yerine eklenir
            printf("Ogrenci eklendi\n");
            break;
        case 2:
            kucukten_buyuge_listele(&liste_basi);
            break;
        case 3:
            buyukten_kucuge_listele(&liste_basi);
            break;
        case 4:
            printf("Ogrencinin numarasini giriniz:");
            scanf("%d",&birOgrenci->no);
            birOgrenci=ara(&liste_basi,no);
            if (birOgrenci)
            {
                printf("Bu numaraya sahip bir ogrenci yoktur\n");
            }
            else
            {
                printf("Ogrencinin not ortalamasi:%f",birOgrenci->ort);
            }
            break;
        case 5:
            printf("Ogrencinin numarasini giriniz:");
            scanf("%d",&no);
            birOgrenci=ara(&liste_basi,no);
            if (birOgrenci)
            {
                printf("Ogrencinin  yeni not ortalamasini giriniz:\n");
                scanf("%f",&birOgrenci->ort);
                if (birOgrenci->ort<birOgrenci->onceki->ort||birOgrenci->ort>birOgrenci->sonraki->ort)
                {
                    birOgrenci->onceki->sonraki=birOgrenci->sonraki;
                    birOgrenci->sonraki->onceki=birOgrenci->onceki;
                    d_cift_sirali_ekle(&liste_basi,birOgrenci);
                }
                printf("Bu numaraya sahip bir ogrenci yoktur\n");
            }
            break;
        case 6:
            printf("Ogrencinin numarasini giriniz:");
            scanf("%d",&no);
            birOgrenci=ara(&liste_basi,no);
            if (birOgrenci)
            {
                birOgrenci->onceki->sonraki=birOgrenci->sonraki;
                birOgrenci->sonraki->onceki=birOgrenci->onceki;
                free(birOgrenci);
                printf("Ogrenci silindi.\n");
            }
            break;
        case 7:printf("Min not ort gir:");
        scanf("%f",&min_ort);
        toplu_sil(&liste_basi,min_ort);
            break;
        }
    }
    while (secim!=8);

    return 0;
}

void d_cift_sirali_ekle(struct ogrenci *liste_basi_ptr, struct ogrenci *yeni)
{
    struct ogrenci *gecici;

    gecici=liste_basi_ptr->sonraki;//gecici ilk dugum
    while (gecici!=liste_basi_ptr && gecici->ort<yeni->ort)
        gecici=gecici->sonraki;

    yeni->sonraki=gecici;
    yeni->onceki=gecici->onceki;
    gecici->onceki->sonraki=yeni;
    gecici->onceki=yeni;
}

void kucukten_buyuge_listele(struct ogrenci *liste_basi_ptr)
{
    struct ogrenci *gecici;

    printf("Ogr No Not Ortalamasi\n");
    printf("------ --------------\n");

    gecici=liste_basi_ptr->sonraki;
    while (gecici!=liste_basi_ptr)
    {
        printf("%-6d %.2f\n",gecici->no,gecici->ort);
        gecici=gecici->sonraki;
    }
}

void buyukten_kucuge_listele(struct ogrenci *liste_basi_ptr)
{
    struct ogrenci *gecici;

    printf("Ogr No Not Ortalamasi\n");
    printf("------ --------------\n");

    gecici=liste_basi_ptr->onceki;
    while (gecici!=liste_basi_ptr)
    {
        printf("%-6d %.2f\n",gecici->no,gecici->ort);
        gecici=gecici->onceki;
    }
}
struct ogrenci *ara(struct ogrenci *liste_basi_ptr, int no)
{
    struct ogrenci *gecici;

    gecici=liste_basi_ptr->sonraki;//gecici ilk dugum

    while (gecici!=liste_basi_ptr)
    {
        if (gecici->no==no)
        if (gecici->no==no)
        {
            return gecici;
        }
        gecici=gecici->sonraki;
    }
    return NULL;
}
void toplu_sil(struct ogrenci *liste_basi_ptr, float min_ort)
{
    struct ogrenci *gecici;
    int en_az_bir_silindi=0;

    gecici=liste_basi_ptr->sonraki;//gecici ilk dugum

    while (gecici!=liste_basi_ptr&&(gecici->ort<min_ort))
    {
        liste_basi_ptr->sonraki=gecici->sonraki;
        printf("%d numarali ogrenci silindi\n",gecici->no);
        free(gecici);
        gecici=liste_basi_ptr->sonraki;
    }
    if (en_az_bir_silindi==0)
    {
        printf("Not ortalamasi bu degerin altinda olan ogrenci yok!\n");
    }
    else
    {
        gecici->onceki=liste_basi_ptr;
    }
}



