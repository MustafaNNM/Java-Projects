#include <stdio.h>
#include <stdlib.h>

struct abone//abone_oku() fonksiyonu yapilabilir gorusme()...
{
    char no[8];
    char adi_soyadi[26];
    char adres[31];
    int  abone_tipi;
    int  on_odenmis_kontor;
};

struct yukleme
{
    char telefon_numarasi[8];
    int yuklenen_kontor_miktari;
};
struct abone kisi_oku(FILE *fptr);
struct yukleme kontor(FILE *fptr);
int main()
{
    FILE *afptr,*kfptr,*gfptr;
    struct abone kisi;
    struct yukleme kontor_yukle;
    double x,y;
    char *dosya_adi[3]= {"abone.txt","kontor_yukleme.txt","gecici.txt"},*amac[2]= {"r","w"};
    if ((afptr=fopen(dosya_adi[0],amac[0]))==NULL)
    {
        printf("abone.txt acilamadi!\n");//Dosya açýlamadýðýnda ekrana mesaj gönderiliyor
    }
    //Dosya açýlýrsa diðer iþlemler yapýlmaktadýr
    else
    {
        if ((kfptr=fopen(dosya_adi[1],amac[0]))==NULL)
        {
            printf("kontor_yukleme acilamadi!\n");//Dosya açýlamadýðýnda ekrana mesaj gönderiliyor
        }
        //Dosya açýlýrsa diðer iþlemler yapýlmaktadýr
        else
        {
            if ((gfptr=fopen(dosya_adi[2],amac[1]))==NULL)
            {
                printf("gecici.txt dosyasi acilamadi!\n");//Dosya açýlamadýðýnda ekrana mesaj gönderiliyor
            }
            //Dosya açýlýrsa diðer iþlemler yapýlmaktadýr
            else
            {
                kontor_yukle=kontor(kfptr);
                y=atoi(kontor_yukle.telefon_numarasi);
                while(!feof(afptr))
                {
                    kisi=kisi_oku(afptr);
                    x=atoi(kisi.no);
                    while(x<y)
                    {
                        fprintf (gfptr,"%-8s%-26s%-31s%d %d\n",kisi.no,kisi.adi_soyadi,kisi.adres,kisi.abone_tipi,kisi.on_odenmis_kontor);
                        kisi=kisi_oku(afptr);
                        x=atoi(kisi.no);
                    }
                    while(x==y)
                    {
                        kisi.on_odenmis_kontor+=kontor_yukle.yuklenen_kontor_miktari;
                        kontor_yukle=kontor(kfptr);
                        y=atoi(kontor_yukle.telefon_numarasi);
                    }
                    fprintf (gfptr,"%-8s%-26s%-31s%d %d\n",kisi.no,kisi.adi_soyadi,kisi.adres,kisi.abone_tipi,kisi.on_odenmis_kontor);
                }
            }
        }
    }
    return 0;
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
struct yukleme kontor(FILE *fptr)
{
    struct yukleme kontor_al;
    fgets(kontor_al.telefon_numarasi,8,fptr);
    fscanf(fptr,"%d\n",&kontor_al.yuklenen_kontor_miktari);
    return kontor_al;
}
