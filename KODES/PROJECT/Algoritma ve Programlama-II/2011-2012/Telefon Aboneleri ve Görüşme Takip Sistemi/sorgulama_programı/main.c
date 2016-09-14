#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct abone
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
    int  gun_no;
    int  baslangic_saati;
    int  baslangic_dakikasi;
    int  sure;
};

int ana_menu();

void abone_bilgi_noya_gore(char no[]);
char abone_bilgi_ada_gore(char ad[]);
void abone_bilgi_ve_gorusmeleri();
void tum_abone_bilgileri();

void noya_gore_gorusmeler(char no[]);
void gune_gore_gorusmeler(int no);
void tum_gorusme_bilgileri();

struct abone kisi_oku(FILE *fptr);
struct gorusme gorusme_oku(FILE *fptr);

int main()
{
    int secim,no;
    char kriter[8];
    for(;;)
    {
        secim=ana_menu();
        switch (secim)
        {
        case 1:
            do
            {
                printf("Bilgilerini gormek istediginiz abonenin telefon numarasini giriniz\n{Cikis[#]}?");
                fflush(stdin);
                gets(kriter);
                abone_bilgi_noya_gore(kriter);
            }
            while(kriter[0]!='#');
            break;
        case 2:
            abone_bilgi_ve_gorusmeleri();
            break;
        case 3:
            do
            {
                printf("Bilgilerini gormek istediginiz abonenin adini soyadini giriniz\n{Cikis[#]}?");
                fflush(stdin);
                gets(kriter);
                abone_bilgi_ada_gore(kriter);
            }
            while(kriter[0]!='#');
            break;
        case 4:
            tum_abone_bilgileri();
            break;
        case 5:
            printf("Gormek istedigi gunun numarasini giriniz\n{Cikis[#]}?");
            scanf("%d",&no);
            gune_gore_gorusmeler(no);
            break;
        case 6:
            tum_gorusme_bilgileri();
            break;
        default:
            exit(EXIT_SUCCESS);
        }
    }

    return 0;
}
void abone_bilgi_noya_gore(char no[])
{
    FILE *fptr;
    struct abone kisi;
    const char *s1;
    int x,y,z;
    char *dosya_adi= {"abone.txt"},*amac= {"r"},*abone_tipi[4]= {"Sahis","Isyeri","Kamu","Guvenlik"};
    if ((fptr=fopen(dosya_adi,amac))==NULL)
    {
        printf("Dosya acilamadi!\n");//Dosya acilamadiginda ekrana mesaj gönderiliyor
    }
    //Dosya acilirsa diger islemler yapilmaktadir
    else
    {

        if(no[0]!='#')
        {
            s1=no;
            y=strlen(s1);
            do
            {
                kisi=kisi_oku(fptr);
                z=strlen(kisi.no);
                x=strcmp(no,kisi.no);
                if(feof(fptr))
                {
                    break;
                }
                if(z!=y)
                {
                    continue;
                    no[0]='#';
                }
            }
            while(x!=0);
            if(x==0)//bulunca
            {
                printf("Tel No  Ad Soyad                  Adres                          Tip      Kont\n");
                printf("------- ------------------------- ------------------------------ -------- ----\n");
                printf("%-8s%-26s%-31s%-9s%d\n",kisi.no,kisi.adi_soyadi,kisi.adres,abone_tipi[kisi.abone_tipi-1],kisi.on_odenmis_kontor);
            }
        }
    }
}
char abone_bilgi_ada_gore(char ad[])
{
    FILE *fptr;
    struct abone kisi;
    //const char *s1;
    int x,y;
    char *dosya_adi= {"abone.txt"},*amac= {"r"},*abone_tipi[4]= {"Sahis","Isyeri","Kamu","Guvenlik"};
    if ((fptr=fopen(dosya_adi,amac))==NULL)
    {
        printf("Dosya acilamadi!\n");//Dosya acilamadiginda ekrana mesaj gönderiliyor
    }
    //Dosya acilirsa diger islemler yapilmaktadir
    else
    {
        printf("Tel No  Ad Soyad                  Adres                          Tip      Kont\n");
        printf("------- ------------------------- ------------------------------ -------- ----\n");
        do
        {
            kisi=kisi_oku(fptr);
            y=strlen(ad);
            x=strncmp(ad,kisi.adi_soyadi,y);
            //printf("x:%d",x);
            if(x==0)
            {
                printf("%-8s%-26s%-31s%-9s%d\n",kisi.no,kisi.adi_soyadi,kisi.adres,abone_tipi[kisi.abone_tipi-1],kisi.on_odenmis_kontor);
            }
        }
        while(!feof(fptr));
    }
    return ad[0];
}
void abone_bilgi_ve_gorusmeleri()
{
    char no[8];
    printf("Bilgilerini gormek istediginiz abonenin telefon numarasini giriniz\n{Cikis[#]}?");
    fflush(stdin);
    gets(no);
    while(no[0]!='#')
    {
        abone_bilgi_noya_gore(no);
        noya_gore_gorusmeler(no);
        printf("Bilgilerini gormek istediginiz abonenin telefon numarasini giriniz\n{Cikis[#]}?");
        fflush(stdin);
        gets(no);
    }
    fflush(stdin);
}
void tum_abone_bilgileri()
{
    FILE *fptr;
    struct abone kisi;
    char *dosya_adi= {"abone.txt"},*amac= {"r"},*abone_tipi[4]= {"Sahis","Isyeri","Kamu","Guvenlik"};
    if ((fptr=fopen(dosya_adi,amac))==NULL)
    {
        printf("Dosya acilamadi!void noya_gore_gorusmeler(int no)\n");//Dosya açılamadığında ekrana mesaj gönderiliyor
    }
    //Dosya açılırsa diğer işlemler yapılmaktadır
    else
    {
        printf("Tel No  Ad Soyad                  Adres                          Tip      Kont\n");
        printf("------- ------------------------- ------------------------------ -------- ----\n");
        int abone_sayisi[4]= {0};
        kisi=kisi_oku(fptr);
        do
        {
            printf("%-8s%-26s%-31s%-9s%d\n",kisi.no,kisi.adi_soyadi,kisi.adres,abone_tipi[kisi.abone_tipi-1],kisi.on_odenmis_kontor);
            abone_sayisi[kisi.abone_tipi-1]++;
            kisi=kisi_oku(fptr);
        }
        while (!feof(fptr));
        printf("\nAbone Tipi Abone Sayisi");
        printf("\n---------- ------------");
        int i;
        for(i=0; i<4; i++)
        {
            printf("\n%-11s%d",abone_tipi[i],abone_sayisi[i]);
        }
    }
    fclose(fptr);
}
void noya_gore_gorusmeler(char no[])
{
    FILE *fptr;
    struct gorusme veri;
    int i,x,y,bd=0,bs=0,g_sayisi=0,g_suresi=0;
    char *dosya_adi= {"gorusme.txt"},*amac= {"r"};
    if ((fptr=fopen(dosya_adi,amac))==NULL)
    {
        printf("Dosya acilamadi!\n");//Dosya acilamadiginda ekrana mesaj gönderiliyor
    }
    //Dosya acilirsa diger islemler yapilmaktadir
    else
    {
        printf("Aranan Tel No Gun No Baslangic Bitis\n");
        printf("------------- ------ --------- -----\n");
        x=atoi(no);
        do
        {
            veri=gorusme_oku(fptr);
            y=atoi(veri.arayan_no);
            if(x==y)
            {
                //bitis saati hesaplanıyor
                bd=(veri.baslangic_dakikasi+veri.sure)%60;
                bs=veri.baslangic_saati+bd/60;
                for(i=0;i<3;i++)
                {
                    printf("%c",veri.aranan_no[i]);
                }
                printf("-");
                for(i=3;i<10;i++)
                {
                    printf("%c",veri.aranan_no[i]);
                }
                printf("   %-7d%02d:%02d     %02d:%02d\n",veri.gun_no,veri.baslangic_saati,veri.baslangic_dakikasi,bs,bd);
                ++g_sayisi;//görüsme sayisi artiriliyor
                g_suresi+=veri.sure;//görüsme suresi artırılıyor
            }
        }
        while(!feof(fptr));
        printf("-------------------------\n");
        printf("Toplam gorusme sayisi:%d\n",g_sayisi);
        printf("Toplam gorusme suresi:%d\n\n",g_suresi);
    }
    fclose(fptr);
}
void gune_gore_gorusmeler(int no)
{
    FILE *fptr;
    struct gorusme veri;
    int bd=0,bs=0;
    char *dosya_adi= {"gorusme.txt"},*amac= {"r"};
    if ((fptr=fopen(dosya_adi,amac))==NULL)
    {
        printf("Dosya acilamadi!\n");//Dosya acilamadiginda ekrana mesaj gönderiliyor
    }
    //Dosya acilirsa diger islemler yapilmaktadir
    else
    {
        printf("Aranan Tel No Gun No Baslangic Bitis\n");
        printf("------------- ------ --------- -----\n");
        while(!feof(fptr))
        {
            veri=gorusme_oku(fptr);
            if(veri.gun_no==no)
            {
                //bitis saati hesaplanıyor
                bd=(veri.baslangic_dakikasi+veri.sure)%60;
                bs=veri.baslangic_saati+bd/60;
                printf("%-8s %-7d%02d:%02d     %02d:%02d\n",veri.aranan_no,veri.gun_no,veri.baslangic_saati,veri.baslangic_dakikasi,bs,bd);
            }
        }
    }
    fclose(fptr);
}
void tum_gorusme_bilgileri()
{
    FILE *gfptr,*afptr;
    struct abone kisi;
    struct gorusme veri;
    int x=0,g_sayisi=0,g_suresi=0;
    char *dosya_adi[2]= {"gorusme.txt","abone.txt"},*amac= {"r"};
    if ((afptr=fopen(dosya_adi[1],amac))==NULL)
    {
        printf("abone.txt acilamadi!\n");//Dosya açılamadığında ekrana mesaj gönderiliyor
    }
    //Dosya açılırsa diğer işlemler yapılmcase :break;aktadır
    else
    {
        if ((gfptr=fopen(dosya_adi[0],amac))==NULL)
        {
            printf("gorusme.txt acilamadi!\n");//Dosya açılamadığında ekrana mesaj gönderiliyor
        }
        //Dosya açılırsa diğer işlemler yapılmaktadır
        else
        {
            printf("Tel No  Ad Soyad                  Top Gor Sayisi Top Gor Suresi\n");
            printf("------- ------------------------- -------------- --------------\n");
            while(!feof(afptr))
            {
                kisi=kisi_oku(afptr);
                while(!feof(gfptr))
                {
                    veri=gorusme_oku(gfptr);
                    x=strcmp(kisi.no,veri.arayan_no);
                    if(x==0)
                    {
                        g_sayisi++;
                        g_suresi+=veri.sure;
                    }
                }
                printf("%-8s%-26s%-15d%d\n",kisi.no,kisi.adi_soyadi,g_sayisi,g_suresi);
                g_sayisi=g_suresi=0;
                rewind(gfptr);
            }
        }
        fclose(gfptr);
    }
    fclose(afptr);
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
int ana_menu(void)
{
    int secim;
    printf("\n\n1) Telefon numarasi verilen bir abonenin bilgilerinin listelenmesi\n");
    printf("2) Bir abonenin bilgilerinin ve o ay yapmis oldugu gorusmelerin listelenmesi\n");
    printf("3) Verilen bir ad soyada sahip abonelerin bilgilerinin listelenmesi\n");
    printf("4) Tum abonelerin bilgilerinin listelenmesi\n");
    printf("5) Verilen bir gun yapilan gorusmelerin listelenmesi\n");
    printf("6) Tum abonelerin o ay yapmis olduklari gorusme toplamlarinin listelenmesi\n");
    printf("7) Cikis");
    printf("Seciminiz {[1-7]}\n?");
    printf("\nSeciminizi Giriniz:\n");
    scanf("%d", &secim);
    while(secim<1&&secim>7)
    {
        printf("\nHatali girdiniz!!!\nSeciminizi tekrar giriniz:\n");
        scanf("%d", &secim);
    }
    return secim;
}
