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

struct istatistik
{
    int gor_sayi;
    int gor_suresi;
    float ortalama;
};

int menu();
void tumunu_listele();//silinecek
void abone_listele();
void abone_gorusme_listele();
void birime_gore_abone_listele();
void abone_sayi_ve_yuzdesi();
void gune_gore_gorusmeler();
void gorusme_sayi_ve_sureleri();
void mecburi_kontor_yukleme();
void sirala(int *deger,int *deger2);
void degistir(int *a,int *b);
struct gorusme gorusme_oku(FILE *fptr);
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
            abone_listele();
            break;
        case 2:
            abone_gorusme_listele();
            break;
        case 3:
            birime_gore_abone_listele();
            break;
        case 4:
            abone_sayi_ve_yuzdesi();
            break;
        case 5:
            gune_gore_gorusmeler();
            break;
        case 6:
            gorusme_sayi_ve_sureleri();
            break;
        case 7:
            mecburi_kontor_yukleme();
            break;
        default:
            exit(EXIT_SUCCESS);
        }
    }
    return 0;
}
void abone_listele()
{
    FILE *fptr;
    struct abone kisi=
    {
        "","",0,0
    };
    int dahili_tel_no;
    char *dosya_adi= "abone.dat",*amac="r",*abone_tipi[5]= {"Bos","Akademik","Idari","Yonetici","Diger"};
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
            printf("Tel No Ad Soyad                  Birimi                         Tip      Kontor\n");
            printf("------ ------------------------- ------------------------------ -------- ------\n");
            printf("%-7d%-26s%-31s%-9s%d\n",dahili_tel_no,kisi.adi_soyadi,kisi.birim_adi,abone_tipi[kisi.abone_tipi],kisi.hazir_kontor);
        }
        else
        {
            printf("#%d dahili numarali abone bulunamamistir!\n",dahili_tel_no);
        }
    }
    fclose(fptr);
}
void abone_gorusme_listele()
{
    FILE *afptr,*gfptr;
    struct abone kisi=
    {
        "","",0,0
    };
    struct gorusme veri;
    int dahili_tel_no,x,bs,bd,g_sayisi=0,gunduz=0,gece=0,harcanan=0;//x=sayac bs=bitis saati bd=bitis dakikasi g_sayisi=gorusme sayisi
    char *dosya_adi[2]= {"abone.dat","gorusme.txt"},*amac="r",*abone_tipi[5]= {"Bos","Akademik","Idari","Yonetici","Diger"};
    if ((afptr=fopen(dosya_adi[0],amac))==NULL)
    {
        printf("abone.dat acilamadi!\n");//Dosya acilamadiginda ekrana mesaj gönderiliyor
    }
    //Dosya acilirsa diger islemler yapilmaktadir
    else
    {
        if ((gfptr=fopen(dosya_adi[1],amac))==NULL)
        {
            printf("gorusme.txt acilamadi!\n");//Dosya acilamadiginda ekrana mesaj gönderiliyor
        }
        //Dosya acilirsa diger islemler yapilmaktadir
        else
        {
            printf("Abonenin dahili telefon numarasini giriniz\n?");
            scanf("%d",&dahili_tel_no);
            fseek(afptr,(dahili_tel_no-100)*sizeof(struct abone),SEEK_SET);
            fread(&kisi,sizeof(struct abone),1,afptr);
            if(kisi.abone_tipi!=0)
            {
                printf("Tel No Ad Soyad                  Birimi                         Tip      Kontor\n");
                printf("------ ------------------------- ------------------------------ -------- ------\n");
                printf("%-7d%-26s%-31s%-9s%d\n",dahili_tel_no,kisi.adi_soyadi,kisi.birim_adi,abone_tipi[kisi.abone_tipi],kisi.hazir_kontor);
                printf("Dis Hat Gorusmeleri:\n");
                printf("Aranan Tel No Gun No Baslangic Bitis\n");
                printf("------------- ------ --------- -----\n");
                veri=gorusme_oku(gfptr);
                while(!feof(gfptr))
                {
                    if(dahili_tel_no==veri.arayan)
                    {
                        bd=(veri.baslangic_dakikasi+veri.sure)%60;
                        bs=veri.baslangic_saati+bd/60;
                        for(x=0; x<3; x++)
                        {
                            printf("%c",veri.aranan[x]);
                        }
                        printf("-");
                        for(x=3; x<10; x++)
                        {
                            printf("%c",veri.aranan[x]);
                        }
                        printf("   %-7d%02d:%02d     %02d:%02d\n",veri.gun_no,veri.baslangic_saati,veri.baslangic_dakikasi,bs,bd);
                        ++g_sayisi;//görüsme sayisi artiriliyor
                        kisi.hazir_kontor-=harcanan;
                        fseek(afptr,(dahili_tel_no-100)*sizeof(struct abone),SEEK_SET);
                        fwrite(&kisi,sizeof(struct abone),1,afptr);
                    }
                    veri=gorusme_oku(gfptr);
                }
                rewind(gfptr);
                printf("------------------------------------\n");
                printf("Toplam gorusme sayisi:%d\n",g_sayisi);
                printf("Toplam gunduz gorusme suresi:%d\n",gunduz);
                printf("Toplam gece gorusme suresi:%d\n",gece);
                printf("Toplam harcadigi kontor miktari:\n");
                g_sayisi=0;
            }
            else
            {
                printf("#%d dahili numarali abone bulunamamistir!\n",dahili_tel_no);
            }
        }
        fclose(gfptr);
    }
    fclose(afptr);
}
void birime_gore_abone_listele()
{
    char birim_adi[31];

    FILE *fptr;
    struct abone kisi=
    {
        "","",0,0
    };
    int x,y,z,t;
    char *dosya_adi= "abone.dat",*amac="r",*abone_tipi[5]= {"Bos","Akademik","Idari","Yonetici","Diger"};
    if ((fptr=fopen(dosya_adi,amac))==NULL)
    {
        printf("abone.dat acilamadi!\n");//Dosya acilamadiginda ekrana mesaj gonderiliyor
    }
    //Dosya acilirsa diger islemler yapilmaktadir
    else
    {
        printf("Birim adini giriniz:\n?");
        gets(birim_adi);
        y=strlen(birim_adi);
        printf("Tel No Ad Soyad                  Birimi                         Tip      Kontor\n");
        printf("------ ------------------------- ------------------------------ -------- ------\n");
        x=-1;
        fread(&kisi,sizeof(struct abone),1,fptr);
        while(!feof(fptr))
        {
            x++;
            z=strncmp(birim_adi,kisi.birim_adi,y);
            t=strlen(kisi.birim_adi);
            if(kisi.abone_tipi!=0)
            {
                if(t==y&&z==0)//Eslesme olursa
                {
                    printf("%-7d%-26s%-31s%-9s%d\n",x+100,kisi.adi_soyadi,kisi.birim_adi,abone_tipi[kisi.abone_tipi],kisi.hazir_kontor);
                }
            }
            fread(&kisi,sizeof(struct abone),1,fptr);
        }
    }
    fclose(fptr);
}
void abone_sayi_ve_yuzdesi()
{
    FILE *fptr;
    struct abone kisi=
    {
        "","",0,0
    };
    int x=0,sayac[5]= {0},kayit_sayisi=0,tip[5]= {0,1,2,3,4};
    char *dosya_adi= "abone.dat",*amac="r",*abone_tipi[5]= {"Bos","Akademik","Idari","Yonetici","Diger"};
    if ((fptr=fopen(dosya_adi,amac))==NULL)
    {
        printf("abone.dat acilamadi!\n");//Dosya acilamadiginda ekrana mesaj gönderiliyor
    }
    //Dosya acilirsa diger islemler yapilmaktadir
    else
    {
        fread(&kisi,sizeof(struct abone),1,fptr);
        while(!feof(fptr))
        {
            sayac[kisi.abone_tipi]++;
            fread(&kisi,sizeof(struct abone),1,fptr);
        }
        sirala(sayac,tip);
        for(x=0; x<5; x++)
        {
            kayit_sayisi+=sayac[x];
        }
        printf("kayit_sayisi:%d\n",kayit_sayisi);
        printf("Abone Tipi Abone Sayisi Yuzde\n");
        printf("---------- ------------ -----\n");
        for(x=1; x<5; x++)
        {
            printf("%-11s%-13d%03.02f\n",abone_tipi[tip[x]],sayac[x],(float)sayac[x]*100/kayit_sayisi);
        }
        printf("-----------------------------\n");
        printf("%-11s%-13d%03.02f\n",abone_tipi[0],sayac[0],(float)sayac[0]*100/kayit_sayisi);
    }
    fclose(fptr);
}
void gune_gore_gorusmeler()
{
    FILE *afptr,*gfptr;
    struct abone kisi=
    {
        "","",0,0
    };
    struct gorusme veri;
    int gun_no,x;//x=sayac bs=bitis saati bd=bitis dakikasi g_sayisi=gorusme sayisi
    char *dosya_adi[2]= {"abone.dat","gorusme.txt"},*amac="r";
    if ((afptr=fopen(dosya_adi[0],amac))==NULL)
    {
        printf("abone.dat acilamadi!\n");//Dosya acilamadiginda ekrana mesaj gönderiliyor
    }
    //Dosya acilirsa diger islemler yapilmaktadir
    else
    {
        if ((gfptr=fopen(dosya_adi[1],amac))==NULL)
        {
            printf("gorusme.txt acilamadi!\n");//Dosya acilamadiginda ekrana mesaj gönderiliyor
        }
        //Dosya acilirsa diger islemler yapilmaktadir
        else
        {
            printf("Gun numarasini giriniz\n?");
            scanf("%d",&gun_no);
            printf("Arayan Tel No Arayan Ad Soyad           Aranan Tel No  Baslangic Sure\n");
            printf("------------- ------------------------- -------------- --------- ----\n");
            veri=gorusme_oku(gfptr);
            while(!feof(gfptr))
            {
                if(veri.gun_no==gun_no)
                {
                    fseek(afptr,(veri.arayan-100)*sizeof(struct abone),SEEK_SET);
                    fread(&kisi,sizeof(struct abone),1,afptr);
                    printf("%-14d%-26s",veri.arayan,kisi.adi_soyadi);
                    for(x=0; x<3; x++)
                    {
                        printf("%c",veri.aranan[x]);
                    }
                    printf("-");
                    for(x=3; x<10; x++)
                    {
                        printf("%c",veri.aranan[x]);
                    }
                    printf("    %02d:%02d     %d\n",veri.baslangic_saati,veri.baslangic_dakikasi,veri.sure);
                }
                if(veri.gun_no>gun_no)
                {
                    break;
                }
                veri=gorusme_oku(gfptr);
            }
        }
        fclose(gfptr);
    }
    fclose(afptr);
}
void gorusme_sayi_ve_sureleri()
{
    FILE *fptr;
    struct gorusme veri;
    struct istatistik gun[31]= {{0}};
    int i=0;
    char *dosya_adi= "gorusme.txt",*amac="r";
    if ((fptr=fopen(dosya_adi,amac))==NULL)
    {
        printf("gorusme.txt acilamadi!\n");//Dosya acilamadiginda ekrana mesaj gönderiliyor
    }
    //Dosya acilirsa diger islemler yapilmaktadir
    else
    {
        while(!feof(fptr))
        {
            veri=gorusme_oku(fptr);
            ++gun[veri.gun_no].gor_sayi;
            gun[veri.gun_no].gor_suresi+=veri.sure;
        }
        printf("Gun Top Gor Sayisi Top Gor Suresi(dk) Ortalama Gor Suresi(dk)\n");
        printf("--- -------------- ------------------ -----------------------\n");
        for(i=0; i<31; i++)
        {
            if(gun[i].gor_sayi!=0)
            {
                gun[i].ortalama=(float)gun[i].gor_sayi/gun[i].gor_suresi;
            }
            else
            {
                gun[i].ortalama=0;
            }
            printf("%-4d%-15d%-19d%03.02f\n",i+1,gun[i].gor_sayi,gun[i].gor_suresi,gun[i].ortalama);
        }
    }
    fclose(fptr);
}
void mecburi_kontor_yukleme()
{
    FILE *fptr;
    struct abone kisi=
    {
        "","",0,0
    };
    int x;
    char *dosya_adi= "abone.dat",*amac="r",*abone_tipi[5]= {"Bos","Akademik","Idari","Yonetici","Diger"};
    if ((fptr=fopen(dosya_adi,amac))==NULL)
    {
        printf("abone.dat acilamadi!\n");//Dosya acilamadiginda ekrana mesaj gönderiliyor
    }
    //Dosya acilirsa diger islemler yapilmaktadir
    else
    {
        printf("Tel No Ad Soyad                  Birimi                         Tip      Kontor\n");
        printf("------ ------------------------- ------------------------------ -------- ------\n");
        x=-1;
        while(!feof(fptr))
        {
            x++;
            fread(&kisi,sizeof(struct abone),1,fptr);
            if(kisi.abone_tipi!=0&&kisi.hazir_kontor<-100)
            {
                printf("%-7d%-26s%-31s%-9s%d\n",x+100,kisi.adi_soyadi,kisi.birim_adi,abone_tipi[kisi.abone_tipi],kisi.hazir_kontor);
            }
        }
    }
    fclose(fptr);
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
int menu(void)
{
    int secim;
    printf("\n\n1) Bir abonenin bilgilerinin listelenmesi\n");
    printf("2) Bir abonenin bilgilerinin ve o ay yapmis\n");
    printf("   oldugu dis hat gorusmelerinin listelenmesi\n");
    printf("3) Bir birimdeki abonelerin bilgilerinin listelenmesi\n");
    printf("4) Abone tipine gore abone sayilarinin ve yuzdelerinin listelenmesi\n");
    printf("5) Bir gun yapilan gorusmelerin listelenmesi\n");
    printf("6) Gune gore gorusme sayilarinin ve surelerinin listelenmesi\n");
    printf("7) Dis hat gorusmesi yapabilmek icin kontor\n");
    printf("   yuklemesi gereken abonelerin listelenmesi\n");
    printf("8) Cikis\n");
    printf("Seciminiz {[1-8]}\n?");
    scanf("%d", &secim);
    fflush(stdin);
    while(secim<1 || secim>8)
    {
        printf("\nHatali girdiniz!!!\nSeciminizi tekrar giriniz:\n");
        scanf("%d", &secim);
    }
    return secim;
}
void sirala(int *deger,int *deger2)
{
    int tur,karsilastirma;

    for (tur=0; tur<3; ++tur)//eleman sayısı-1
    {
        for (karsilastirma=3; karsilastirma>=1; --karsilastirma)
            //karşılaştırma yapılırken aşağıdan yukarı dogru yapılıyor
            //n:eleman sayısı dersek n-1 karşılaştırma vardır.
        {
            if (deger[karsilastirma]<deger[karsilastirma+1])//Oy miktarına göre partiler sıralanıyor
            {
                degistir(&deger[karsilastirma],&deger[karsilastirma+1]);
                degistir(&deger2[karsilastirma],&deger2[karsilastirma+1]);
            }
        }
        //n-1 tur vardır.
    }
}
void degistir(int *a,int *b)//iki sayıyı birbirine atamak için kullanıldı
{
    int tut;
    //verilen iki sayının yerleri değişiyor
    tut=*a;
    *a=*b;
    *b=tut;
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
