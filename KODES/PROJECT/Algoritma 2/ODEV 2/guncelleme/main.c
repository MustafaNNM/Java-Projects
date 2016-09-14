#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct abone
{
    char adi_soyadi[26];
    char birim_adi[31];
    int abone_tipi;
    int hazir_kontor;
};

struct gorusme
{
    int arayan;
    char aranan[11];
    int gun_no;//tarih
    int baslangic_saati;
    int baslangic_dakikasi;
    int sure;//dakika
};

int menu();
struct gorusme gorusme_oku(FILE *fptr);
void abone_ekle();
void abone_sil();
void kontor_yukle();
void kayit_ekle();
void tumunu_listele();

int main()
{
    int secim;
    for(;;)
    {
        secim=menu();
        fflush(stdin);
        switch(secim)
        {
        case 1:
            abone_ekle();
            break;
        case 2:
            abone_sil();
            break;
        case 3:
            kontor_yukle();
            break;
        case 4:
            kayit_ekle();
            break;
        default:
            exit(EXIT_SUCCESS);
        }
    }
    return 0;
}
void abone_ekle()
{
    FILE *fptr;
    struct abone kisi=
    {
        "","",0,0
    };
    int dahili_tel_no;
    char *dosya_adi= "abone.dat",*amac="rb+";
    if ((fptr=fopen(dosya_adi,amac))==NULL)
    {
        printf("abone.dat acilamadi!\n");//Dosya acilamadiginda ekrana mesaj gönderiliyor
    }
    //Dosya acilirsa diger islemler yapilmaktadir
    else
    {
        do
        {
            printf("Abonenin dahili telefon numarasini giriniz\n?");
            fflush(stdin);
            scanf("%d",&dahili_tel_no);
            fseek(fptr,(dahili_tel_no-100)*sizeof(struct abone),SEEK_SET);
            fread(&kisi,sizeof(struct abone),1,fptr);
        }
        while(kisi.abone_tipi!=0);
        printf("Abonenin adini soyadini giriniz\n?");
        fflush(stdin);
        gets(kisi.adi_soyadi);
        printf("Birim adini giriniz\n?");
        fflush(stdin);
        gets(kisi.birim_adi);
        printf("Abone tipini giriniz\n?");
        fflush(stdin);
        scanf("%d",&kisi.abone_tipi);
        printf("Hazir Kontor miktarini giriniz\n?");
        fflush(stdin);
        scanf("%d",&kisi.hazir_kontor);
        fflush(stdin);
        fseek(fptr,(dahili_tel_no-100)*sizeof(struct abone),SEEK_SET);
        fwrite(&kisi,sizeof(struct abone),1,fptr);
    }
    fclose(fptr);
}
void abone_sil()
{
    FILE *afptr,*gfptr,*yfptr;
    struct abone kisi=
    {
        "","",0,0
    };
    struct gorusme veri;
    int dahili_tel_no;
    char *dosya_adi[3]= {"abone.dat","gorusme.txt","yeni.txt"},*amac[3]= {"rb+","r","w"};
    if ((afptr=fopen(dosya_adi[0],amac[0]))==NULL)
    {
        printf("abone.dat acilamadi!\n");//Dosya acilamadiginda ekrana mesaj gönderiliyor
    }
    //Dosya acilirsa diger islemler yapilmaktadir
    else
    {
        if ((gfptr=fopen(dosya_adi[1],amac[1]))==NULL)
        {
            printf("gorusme.txt acilamadi!\n");//Dosya acilamadiginda ekrana mesaj gönderiliyor
        }
        //Dosya acilirsa diger islemler yapilmaktadir
        else
        {
            if ((yfptr=fopen(dosya_adi[2],amac[2]))==NULL)
            {
                printf("yeni.txt acilamadi!\n");//Dosya acilamadiginda ekrana mesaj gönderiliyor
            }
            //Dosya acilirsa diger islemler yapilmaktadir
            else
            {
                printf("Abonenin dahili telefon numarasini giriniz\n?");
                scanf("%d",&dahili_tel_no);
                fseek(afptr,(dahili_tel_no-100)*sizeof(struct abone),SEEK_SET);
                fread(&kisi,sizeof(struct abone),1,afptr);
                kisi.abone_tipi=0;
                fseek(afptr,(dahili_tel_no-100)*sizeof(struct abone),SEEK_SET);
                fwrite(&kisi,sizeof(struct abone),1,afptr);
                veri=gorusme_oku(gfptr);
                while(!feof(gfptr))
                {
                    if(veri.arayan!=dahili_tel_no)
                    {
                        fprintf(yfptr,"%d %s %02d %02d %02d %03d\n",veri.arayan,veri.aranan,veri.gun_no,veri.baslangic_saati,veri.baslangic_dakikasi,veri.sure);
                    }
                    veri=gorusme_oku(gfptr);
                }
            }
            fclose(yfptr);
        }
        fclose(gfptr);
    }
    fclose(afptr);
remove("gorusme.txt");
rename("yeni.txt","gorusme.txt");
}
void kontor_yukle()
{
    FILE *fptr;
    struct abone kisi=
    {
        "","",0,0
    };
    int dahili_tel_no,kontor;
    char *dosya_adi= "abone.dat",*amac="rb+";
    if ((fptr=fopen(dosya_adi,amac))==NULL)
    {
        printf("abone.dat acilamadi!\n");//Dosya acilamadiginda ekrana mesaj gönderiliyor
    }
    //Dosya acilirsa diger islemler yapilmaktadir
    else
    {
        printf("Abonenin dahili telefon numarasini giriniz\n?");
        scanf("%d",&dahili_tel_no);
        fseek(fptr,(dahili_tel_no-100)*sizeof(struct abone),SEEK_SET);
        fread(&kisi,sizeof(struct abone),1,fptr);
        if(kisi.abone_tipi!=0)
        {
            printf("Yuklemek istenen kontor miktarini giriniz\n");
            scanf("%d",&kontor);
            kisi.hazir_kontor+=kontor;
            fseek(fptr,(dahili_tel_no-100)*sizeof(struct abone),SEEK_SET);
            fwrite(&kisi,sizeof(struct abone),1,fptr);
        }
        else
        {
            printf("#%d dahili numarali abone bulunamamistir!\n",dahili_tel_no);
        }
    }
    fclose(fptr);
}
void kayit_ekle()
{
    printf("yapilmadi");
}
int menu(void)
{
    int secim;
    printf("\n\n1) Yeni bir abonenin eklenmesi\n");
    printf("2) Bir abonenin kaydinin silinmesi\n");
    printf("3) Bir abonenin kontor yuklemesi\n");
    printf("4) Yapilan dis hat gorusmelerine iliskin kayitlarin eklenmesi\n");
    printf("5) Cikis\n");
    printf("Seciminiz {[1-5]}\n?");
    scanf("%d", &secim);
    fflush(stdin);
    while(secim<1 || secim>5)
    {
        printf("\nHatali girdiniz!!!\nSeciminizi tekrar giriniz:\n");
        scanf("%d", &secim);
    }
    return secim;
}
void tumunu_listele()
{
    FILE *fptr;
    struct abone kisi=
    {
        "","",0,0
    };
    int x;
    char *dosya_adi= "abone.dat",*amac="r";
    if ((fptr=fopen(dosya_adi,amac))==NULL)
    {
        printf("abone.dat acilamadi!\n");//Dosya acilamadiginda ekrana mesaj gönderiliyor
    }
    //Dosya acilirsa diger islemler yapilmaktadir
    else
    {
        x=-1;
        while(!feof(fptr))
        {
            x++;
            fread(&kisi,sizeof(struct abone),1,fptr);
            if(kisi.abone_tipi!=0)
            {
                printf("x:%d#%s#%s#%d#%d#\n",x+100,kisi.adi_soyadi,kisi.birim_adi,kisi.abone_tipi,kisi.hazir_kontor);
            }
        }
    }
    fclose(fptr);
}
struct gorusme gorusme_oku(FILE *fptr)
{
    struct gorusme veri;
    fscanf(fptr,"%d\n",&veri.arayan);
    fgets(veri.aranan,11,fptr);
    fscanf(fptr,"%d",&veri.gun_no);
    fscanf(fptr,"%d",&veri.baslangic_saati);
    fscanf(fptr,"%d",&veri.baslangic_dakikasi);
    fscanf(fptr,"%d",&veri.sure);
    return veri;
}
