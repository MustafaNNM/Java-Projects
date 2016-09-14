#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct yer_bilgileri {
        char kalkis[21];
        char varis[21];
};
struct kalkis_zamani {
        int saat;
        int dakika;
};
struct koltuk_bilgileri {
        int kapasite;
        int bos_olan;
        float fiyati;
};

typedef struct yer_bilgileri Yer_bilgileri;
typedef struct kalkis_zamani Kalkis_zamani;
typedef struct koltuk_bilgileri Koltuk_bilgileri;

struct ucus_bilgileri {
        int no;
        struct yer_bilgileri yer;
        struct kalkis_zamani kalkis;
        struct koltuk_bilgileri koltuk;
};

typedef struct ucus_bilgileri Ucus_bilgileri;

struct bilet_bilgileri {
        int ucus_no;
        char yolcu_tc_kimlik_no[12];
        float fiyati;
};

typedef struct bilet_bilgileri Bilet_bilgileri;

Bilet_bilgileri bilet_oku(FILE *fptr);

void ucus_listele();
void ucus_satilan_bilet_listele();
void kalkis_yerine_gore_ucus_listele();
void birinci_level_ucuslari_listele();/*Doluluk orani %50 ve %50'den az olan ucuslarin listelenmesi*/
void tc_ye_gore_gorusmeler();
void sirala(int *deger,float *deger2,int *deger3,int boyut);
void degistir_i(int *a,int *b);
void degistir_f(float *a,float *b);

int menu(void);
int ucus_no_gir(void);
#define UCUSA_GIT fseek(ufptr,(ucus_no-1)*sizeof(Ucus_bilgileri),SEEK_SET);
#define UCUSU_OKU fread(&ucus,sizeof(Ucus_bilgileri),1,ufptr);
#define UCUSA_GIT_OKU UCUSA_GIT UCUSU_OKU

int main()
{
        int secim;
        for(;;) {
                secim=menu();
                fflush(stdin);
                switch(secim) {
                case 1:
                        ucus_listele();
                        break;
                case 2:
                        ucus_satilan_bilet_listele();
                        break;
                case 3:
                        kalkis_yerine_gore_ucus_listele();
                        break;
                case 4:
                        birinci_level_ucuslari_listele();
                        break;
                case 5:
                        tc_ye_gore_gorusmeler();
                        break;
                default:
                        exit(EXIT_SUCCESS);
                }
        }
        return 0;
}
void ucus_listele()
{
        FILE *ufptr;

        Ucus_bilgileri ucus= {
                0,{"",""},{0,0},{0,0,0}
        };

        int ucus_no;
        char *dosya_adi= "ucus.dat",*amac="r";
        if ((ufptr=fopen(dosya_adi,amac))==NULL) {
                printf("%s acilamadi!\n",dosya_adi);//Dosya acilamadiginda ekrana mesaj gönderiliyor
        }
        //Dosya acilirsa diger islemler yapilmaktadir
        else {
                ucus_no=ucus_no_gir();
                UCUSA_GIT_OKU
                fflush(stdin);
                if(ucus.no!=0) {
                        printf("Ucus No Kalkis Yeri          Varis Yeri           Zamani Kapasite Bos Koltuk Doluluk %%\n");
                        printf("------- -------------------- -------------------- ------ -------- ---------- ---------\n");
                        printf("%-8d%-21s%-21s%02d:%02d  %-9d%-11d%-5.2f\n",ucus.no,ucus.yer.kalkis,ucus.yer.varis,ucus.kalkis.saat,ucus.kalkis.dakika,ucus.koltuk.kapasite,ucus.koltuk.bos_olan,(float)(ucus.koltuk.kapasite-ucus.koltuk.bos_olan)*100/ucus.koltuk.kapasite);
                } else {
                        printf("#%d numarali ucus bulunamamistir!\n",ucus_no);
                }
        }
        fclose(ufptr);
}
void ucus_satilan_bilet_listele()
{
        FILE *ufptr,*bfptr;
        Ucus_bilgileri ucus= {
                0,{"",""},{0,0},{0,0,0}
        };

        Bilet_bilgileri veri;
        int ucus_no,b_sayisi=0;//b_sayisi=bilet sayisi,brut=toplam kazanc
        float brut=0,ort_bilet_fiyati;
        char *dosya_adi[2]= {"ucus.dat","bilet.txt"},*amac="r";
        if ((ufptr=fopen(dosya_adi[0],amac))==NULL) {
                printf("%s acilamadi!\n",dosya_adi[0]);//Dosya acilamadiginda ekrana mesaj gönderiliyor
        }
        //Dosya acilirsa diger islemler yapilmaktadir
        else {
                if ((bfptr=fopen(dosya_adi[1],amac))==NULL) {
                        printf("%s acilamadi!\n",dosya_adi[1]);//Dosya acilamadiginda ekrana mesaj gönderiliyor
                }
                //Dosya acilirsa diger islemler yapilmaktadir
                else {
                        ucus_no=ucus_no_gir();
                        UCUSA_GIT_OKU
                        if(ucus.no!=0) {
                                printf("Ucus No Kalkis Yeri          Varis Yeri           Zamani Kapasite Bos Koltuk Doluluk %%\n");
                                printf("------- -------------------- -------------------- ------ -------- ---------- ---------\n");
                                printf("%-8d%-21s%-21s%02d:%02d  %-9d%-11d%-5.2f\n",ucus.no,ucus.yer.kalkis,ucus.yer.varis,ucus.kalkis.saat,ucus.kalkis.dakika,ucus.koltuk.kapasite,ucus.koltuk.bos_olan,(float)(ucus.koltuk.kapasite-ucus.koltuk.bos_olan)*100/ucus.koltuk.kapasite);
                                printf("Satilan Biletler:\n");
                                printf("TC Kimlik No Fiyati\n");
                                printf("------------ ------\n");
                                veri=bilet_oku(bfptr);
                                while(!feof(bfptr)) {
                                        if(ucus_no==veri.ucus_no) {
                                                ++b_sayisi;/*bilet sayisi artiriliyor*/
                                                brut+=veri.fiyati;/*kazanc ara hesabi*/
                                                printf("%-13s%6.2f\n",veri.yolcu_tc_kimlik_no,veri.fiyati);
                                        }
                                        veri=bilet_oku(bfptr);
                                }
                                rewind(bfptr);
                                if(b_sayisi) {
                                        /*bilet sayisi 1 ya da daha fazlaysa*/
                                        ort_bilet_fiyati=brut/b_sayisi;
                                } else {
                                        ort_bilet_fiyati=0;
                                        /*bilet sayisi sifirsa*/
                                }
                                printf("------------------------------------\n");
                                printf("Toplam bilet sayisi: %d\n",b_sayisi);
                                printf("Toplam kazanc: %.2f TL\n",brut);
                                printf("Ortalama bilet fiyati: %.2f TL\n\n",ort_bilet_fiyati);
                                b_sayisi=0;
                        } else {
                                printf("#%d numarali ucus bulunamamistir!\n",ucus_no);
                        }
                }
                fclose(bfptr);
        }
        fclose(ufptr);
}
void kalkis_yerine_gore_ucus_listele()
{
        char kalkis_yeri[21];

        FILE *ufptr;
        Ucus_bilgileri ucus= {
                0,{"",""},{0,0},{0,0,0}
        };
        int x,y,z,t;
        char *dosya_adi= "ucus.dat",*amac="r";
        if ((ufptr=fopen(dosya_adi,amac))==NULL) {
                printf("%s acilamadi!\n",dosya_adi);/*Dosya acilamadiginda ekrana mesaj gonderiliyor*/
        }
        //Dosya acilirsa diger islemler yapilmaktadir
        else {
                printf("Kalkis yerini giriniz:\n?");
                gets(kalkis_yeri);
                y=strlen(kalkis_yeri);
                printf("Ucus No Kalkis Yeri          Varis Yeri           Zamani Kapasite Bos Koltuk Doluluk %%\n");
                printf("------- -------------------- -------------------- ------ -------- ---------- ---------\n");
                x=-1;
                UCUSU_OKU
                while(!feof(ufptr)) {
                        x++;
                        if(ucus.no!=0) {
                                z=strncmp(kalkis_yeri,ucus.yer.kalkis,y);
                                t=strlen(ucus.yer.kalkis);
                                if(t==y&&z==0) {//Eslesme olursa
                                        printf("%-8d%-21s%-21s%02d:%02d  %-9d%-11d%-5.2f\n",x+1,ucus.yer.kalkis,ucus.yer.varis,ucus.kalkis.saat,ucus.kalkis.dakika,ucus.koltuk.kapasite,ucus.koltuk.bos_olan,(float)(ucus.koltuk.kapasite-ucus.koltuk.bos_olan)*100/ucus.koltuk.kapasite);
                                }
                        }
                        UCUSU_OKU
                }
        }
        fclose(ufptr);
}
/*Doluluk orani %50 ve %50'den az olan ucuslarin listelenmesi*/
void birinci_level_ucuslari_listele()
{
        FILE *ufptr;

        Ucus_bilgileri ucus= {
                0,{"",""},{0,0},{0,0,0}
        };

        int sayac_ucus=0;
        int ucus_nolari[50]= {0},bos_koltuk[50]= {0};
        float doluluk_orani;
        float doluluk_oranlari[50]= {0};

        char *dosya_adi= "ucus.dat",*amac="r";

        if ((ufptr=fopen(dosya_adi,amac))==NULL) {
                printf("%s acilamadi!\n",dosya_adi);/*Dosya acilamadiginda ekrana mesaj gönderiliyor*/
        }
        /*Dosya acilirsa diger islemler yapilmaktadir*/
        else {
                UCUSU_OKU
                fflush(stdin);
                while(!feof(ufptr)) {
                        if(ucus.no!=0) {/*Ucus silinmediyse*/
                                if(ucus.koltuk.bos_olan) {
                                        /*bos koltuk sayisi 1 ya da daha fazlaysa*/
                                        doluluk_orani=(float)(ucus.koltuk.kapasite-ucus.koltuk.bos_olan)*100/ucus.koltuk.kapasite;
                                } else {
                                        doluluk_orani=100;
                                        /*bos koltuk sayisi sifirsa(tum koltuklar doluysa)*/
                                }
                                if(doluluk_orani<=50) {
                                        ucus_nolari[sayac_ucus]=ucus.no;
                                        bos_koltuk[sayac_ucus]=ucus.koltuk.bos_olan;
                                        doluluk_oranlari[sayac_ucus++]=doluluk_orani;
                                }
                        }
                        UCUSU_OKU
                        fflush(stdin);
                }
                sirala(ucus_nolari,doluluk_oranlari,bos_koltuk,sayac_ucus);
                printf("Ucus No Kalkis Yeri          Varis Yeri           Zamani Kapasite Bos Koltuk Doluluk %%\n");
                printf("------- -------------------- -------------------- ------ -------- ---------- ---------\n");
                int i;
                for(i=0; i<sayac_ucus; i++) {
                        fseek(ufptr,(ucus_nolari[i]-1)*sizeof(Ucus_bilgileri),SEEK_SET);
                        UCUSU_OKU
                        printf("%-8d%-21s%-21s%02d:%02d  %-9d%-11d%-5.2f\n",ucus.no,ucus.yer.kalkis,ucus.yer.varis,ucus.kalkis.saat,ucus.kalkis.dakika,ucus.koltuk.kapasite,ucus.koltuk.bos_olan,(float)(ucus.koltuk.kapasite-ucus.koltuk.bos_olan)*100/ucus.koltuk.kapasite);
                }
        }
        fclose(ufptr);
}
void tc_ye_gore_gorusmeler()
{
        FILE *ufptr,*bfptr;
        Ucus_bilgileri ucus= {
                0,{"",""},{0,0},{0,0,0}
        };
        Bilet_bilgileri veri;
        int t,y,z;
        char tc_no[12]= {""};
        char *dosya_adi[2]= {"ucus.dat","bilet.txt"},*amac="r";
        if ((ufptr=fopen(dosya_adi[0],amac))==NULL) {
                printf("%s acilamadi!\n",dosya_adi[0]);//Dosya acilamadiginda ekrana mesaj gönderiliyor
        }
        //Dosya acilirsa diger islemler yapilmaktadir
        else {
                if ((bfptr=fopen(dosya_adi[1],amac))==NULL) {
                        printf("%s acilamadi!\n",dosya_adi[1]);//Dosya acilamadiginda ekrana mesaj gönderiliyor
                }
                //Dosya acilirsa diger islemler yapilmaktadir
                else {
                        printf("Tc numarasini giriniz\n?");
                        gets(tc_no);
                        y=strlen(tc_no);
                        printf("Ucus No Kalkis Yeri          Varis Yeri           Zamani Fiyati\n");
                        printf("------- -------------------- -------------------- ------ ------\n");
                        veri=bilet_oku(bfptr);
                        while(!feof(bfptr)) {
                                z=strncmp(tc_no,veri.yolcu_tc_kimlik_no,y);
                                t=strlen(veri.yolcu_tc_kimlik_no);
                                if(t==y&&z==0) { /*Eslesme olursa*/
                                        fseek(ufptr,(veri.ucus_no-1)*sizeof(Ucus_bilgileri),SEEK_SET);
                                        UCUSU_OKU
                                        if(ucus.no!=0) {/*Ucus silinmediyse*/
                                                printf("%-7d%-21s%-21s%02d:%02d  %-5.2f\n",veri.ucus_no,ucus.yer.kalkis,ucus.yer.varis,ucus.kalkis.saat,ucus.kalkis.dakika,veri.fiyati);
                                        } else {
                                                printf("#%d nolu ucus bulunamadi!\n\n",veri.ucus_no);
                                        }
                                }
                                veri=bilet_oku(bfptr);
                        }
                }
                fclose(bfptr);
        }
        fclose(ufptr);
}
Bilet_bilgileri bilet_oku(FILE *fptr)
{
        Bilet_bilgileri veri;

        fscanf(fptr,"%d%%",&veri.ucus_no);
        fgets(veri.yolcu_tc_kimlik_no,12,fptr);
        fscanf(fptr,"%f",&veri.fiyati);

        return veri;
}
void sirala(int *deger,float *deger2,int *deger3,int boyut)
{
        int karsilastirma;
        int ch=1;
        while(ch) {
                ch=0;
                for (karsilastirma=boyut-2; karsilastirma>-1; karsilastirma--) {
                        if ((deger2[karsilastirma+1]<deger2[karsilastirma])||(deger2[karsilastirma+1]==deger2[karsilastirma]&&deger3[karsilastirma+1]>deger3[karsilastirma])) {
                                degistir_i(&deger[karsilastirma+1],&deger[karsilastirma]);
                                degistir_f(&deger2[karsilastirma+1],&deger2[karsilastirma]);
                                degistir_i(&deger3[karsilastirma+1],&deger3[karsilastirma]);
                                ch=1;
                        }
                }
        }
}
void degistir_i(int *a,int *b)//iki sayiyi birbirine atamak için kullanildi
{
        int tut;
        //verilen iki sayinin yerleri degisiyor
        tut=*a;
        *a=*b;
        *b=tut;
}
void degistir_f(float *a,float *b)//iki sayiyi birbirine atamak için kullanildi
{
        float tut;
        //verilen iki sayinin yerleri degisiyor
        tut=*a;
        *a=*b;
        *b=tut;
}
int menu(void)
{
        int secim;
        printf("\n\n1) Bir ucusun bilgilerinin listelenmesi\n");
        printf("2) Bir ucusun bilgilerinin ve o ucusa iliskin\n");
        printf("   satilan biletlerin listelenmesi\n");
        printf("3) Bir yerden kalkan ucuslarin bilgilerinin listelenmesi\n");
        printf("4) Koltuk doluluk orani %%50'nin altinda olan ucuslarin listelenmesi\n");
        printf("5) Bir yolcunun biletlerinin listelenmesi\n");
        printf("6) Cikis\n");
        printf("Seciminiz {[1-6]}\n?");
        scanf("%d", &secim);
        fflush(stdin);
        while(secim<1 || secim>6) {
                printf("\nHatali girdiniz!!!\nSeciminizi tekrar giriniz:\n");
                scanf("%d", &secim);
        }
        return secim;
}
int ucus_no_gir(void)
{
        int ucus_no;

        printf("Ucus numarasini giriniz\n?");
        scanf("%d",&ucus_no);
        fflush(stdin);
        while(ucus_no<0 || ucus_no>1000) {
                printf("\nHatali girdiniz!!!\nUcus noyu tekrar giriniz:\n?");
                scanf("%d", &ucus_no);
                fflush(stdin);
        }

        return ucus_no;
}
