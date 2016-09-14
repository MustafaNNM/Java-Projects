#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct abone//abone_oku() fonksiyonu yapilabilir gorusme()...
{
    char no[8];
    char adi_soyadi[26];
    char adres[31];
    int  abone_tipi;
    int  on_odenmis_kontor;
};

struct gorusme
{
    char arayan_no[8];
    char aranan_no[11];
    int  gun_no;//tarih
    int  baslangic_saati;
    int  baslangic_dakikasi;
    int  sure;//dakika
};
struct abone kisi_oku(FILE *fptr);
struct gorusme gorusme_oku(FILE *fptr);
int ana_menu(void);
void abone_ekle();
void adres_guncelle();
void gorusme_ekle();

int main()
{
    int secim;
    for(;;)
    {
        secim=ana_menu();
        switch (secim)
        {
        case '1':
            abone_ekle();
            break;
        case '2':
            adres_guncelle();
            break;
        case '3':
            gorusme_ekle();
            break;
        default:
            exit(EXIT_SUCCESS);
        }
    }

    return 0;
}
void abone_ekle()
{
    FILE *afptr,*gfptr;
    struct abone kisi;
    struct abone yeni;
    double x,y;
    char *dosya_adi[2]= {"abone.txt","gecici.txt"},*amac[2]= {"r","w"};
    if ((afptr=fopen(dosya_adi[0],amac[0]))==NULL)
    {
        printf("Dosya acilamadi!\n");//Dosya açılamadığında ekrana mesaj gönderiliyor
    }
    //Dosya açılırsa diğer işlemler yapılmaktadır
    else
    {
         kisi=kisi_oku(afptr);
        printf("%-8s%-26s%-31s%d%d\n",kisi.no,kisi.adi_soyadi,kisi.adres,kisi.abone_tipi,kisi.on_odenmis_kontor);
        if ((gfptr=fopen(dosya_adi[1],amac[1]))==NULL)
        {
            printf("Dosya acilamadi!\n");//Dosya açılamadığında ekrana mesaj gönderiliyor
        }
        //Dosya açılırsa diğer işlemler yapılmaktadır
        else
        {
                printf("1\n");

                kisi=kisi_oku(afptr);
                printf("%-8s%-26s%-31s%d%d\n",kisi.no,kisi.adi_soyadi,kisi.adres,kisi.abone_tipi,kisi.on_odenmis_kontor);

                printf("2\n");
                y=atoi(kisi.no);
                do
                {
                    printf("2\n");
                    printf("Eklemek istediginiz kisinin telefon numarasini giriniz\n?");
                    gets(yeni.no);
                    x=atoi(yeni.no);
                }
                while(x==y);
                while(!feof(afptr))
                {
                    kisi=kisi_oku(afptr);
                    y=atoi(kisi.no);
                    if(x==y)
                    {
                        break;
                    }
                }
                rewind(afptr);
            printf("Kisinin adi ve soyadini giriniz\n?");
            gets(yeni.adi_soyadi);
            printf("Kisinin adresini giriniz\n?");
            gets(yeni.adres);
            printf("Kisinin abone tipini giriniz\n?");
            scanf("%d",&yeni.abone_tipi);
            printf("Kisinin kontor miktarini giriniz\n?");
            scanf("%d",&yeni.on_odenmis_kontor);
            if(x<y)
            {
                printf("once yeni");
                fprintf (gfptr,"%-8s%-26s%-31s%d %d\n",yeni.no,yeni.adi_soyadi,yeni.adres,yeni.abone_tipi,yeni.on_odenmis_kontor);
            }
            else
            {
                printf("once kisi");
                while(!feof(afptr)&&x>y)
                {
                    fprintf (gfptr,"%-8s%-26s%-31s%d %d\n",kisi.no,kisi.adi_soyadi,kisi.adres,kisi.abone_tipi,kisi.on_odenmis_kontor);
                    kisi=kisi_oku(afptr);
                    y=atoi(kisi.no);
                }
                fprintf (gfptr,"%-8s%-26s%-31s%d %d\n",yeni.no,yeni.adi_soyadi,yeni.adres,yeni.abone_tipi,yeni.on_odenmis_kontor);
                while(!feof(afptr))
                {
                    kisi=kisi_oku(afptr);
                    fprintf (gfptr,"%-8s%-26s%-31s%d %d\n",kisi.no,kisi.adi_soyadi,kisi.adres,kisi.abone_tipi,kisi.on_odenmis_kontor);
                }
            }
        }
        fclose(gfptr);
    }
    fclose(afptr);
    remove("abone.txt");
    rename("gecici.txt","yeni.txt");
}
void adres_guncelle()
{
    printf("yapilmadi\n");
}
void gorusme_ekle()
{
    printf("yapilmadi\n");
}
int ana_menu(void)
{
    int secim;
    printf("1) Yeni bir abonenin eklenmesi\n");
    printf("2) Bir abonenin adres bilgisinin guncellenmesi\n");
    printf("3) Gorusme dosyasinin sonuna, yapilan görüsmelere iliskin kayitlarin eklenmesi\n");
    printf("4) Cikis");
    printf("Seciminiz {[1-4]}\n?");
    printf("\nSeciminizi Giriniz:\n");
    scanf("%d", &secim);
    while(secim<1 || secim>4)
    {
        printf("\nHatali girdiniz!!!\nSeciminizi tekrar giriniz:\n");
        scanf("%d", &secim);
    }
    return secim;
}
struct abone kisi_oku(FILE *fptr)
{
    struct abone kisi;
    fgets(kisi.no,8,fptr);
    fgets(kisi.adi_soyadi,26,fptr);
    fgets(kisi.adres,31,fptr);
    fscanf(fptr,"%d",&kisi.abone_tipi);
    fscanf(fptr,"%d\n",&kisi.on_odenmis_kontor);
    return kisi;
}
struct gorusme gorusme_oku(FILE *fptr)
{
    struct gorusme veri;
    fgets(veri.arayan_no,8,fptr);
    fgets(veri.aranan_no,11,fptr);
    fscanf(fptr,"%d",&veri.gun_no);
    fscanf(fptr,"%d",&veri.baslangic_saati);
    fscanf(fptr,"%d",&veri.baslangic_dakikasi);
    fscanf(fptr,"%d\n",&veri.sure);
    return veri;
}
