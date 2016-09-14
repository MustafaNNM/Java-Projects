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
        Yer_bilgileri yer;
        Kalkis_zamani kalkis;
        Koltuk_bilgileri koltuk;
};
typedef struct ucus_bilgileri Ucus_bilgileri;

struct bilet_bilgileri {
        int ucus_no;
        char yolcu_tc_kimlik_no[12];
        float fiyati;
};
typedef struct bilet_bilgileri Bilet_bilgileri;

Bilet_bilgileri bilet_oku(FILE *fptr);
void ucus_ekle();
void ucus_sil();
void zaman_duzenle();
void kayit_ekle();
void dosya_sonuna_ekle();
int menu(void);
int ucus_no_gir(void);
#define UCUSA_GIT fseek(ufptr,(ucus_no-1)*sizeof(Ucus_bilgileri),SEEK_SET);
#define UCUSU_OKU fread(&ucus,sizeof(Ucus_bilgileri),1,ufptr);
#define UCUSU_YAZ fwrite(&ucus,sizeof(Ucus_bilgileri),1,ufptr);
#define UCUSA_GIT_OKU UCUSA_GIT UCUSU_OKU
#define UCUSA_GIT_YAZ UCUSA_GIT UCUSU_YAZ
int main()
{
        int secim;
        for(;;) {
                secim=menu();
                fflush(stdin);
                switch(secim) {
                case 1:
                        ucus_ekle();
                        break;
                case 2:
                        ucus_sil();
                        break;
                case 3:
                        zaman_duzenle();
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
void ucus_ekle()
{
        FILE *ufptr;
        Ucus_bilgileri ucus= {
                0,{"",""},{0,0},{0,0,0}
        };
        int ucus_no;
        char *dosya_adi= "ucus.dat",*amac="rb+";
        if ((ufptr=fopen(dosya_adi,amac))==NULL) {
                printf("%s acilamadi!\n",dosya_adi);//Dosya acilamadiginda ekrana mesaj gönderiliyor
        }
        //Dosya acilirsa diger islemler yapilmaktadir
        else {
                do {
                        ucus_no=ucus_no_gir();
                        UCUSA_GIT_OKU
                        fflush(stdin);
                        if(ucus.no!=0) {
                                printf("Mevcut bir ucusu eklemeye calisiyorsunuz!\n");
                        }
                } while(ucus.no!=0);
                ucus.no=ucus_no;
                printf("Ucusun kalkis yerini giriniz\n?");
                gets(ucus.yer.kalkis);
                fflush(stdin);
                printf("Ucusun varis yerini giriniz\n?");
                gets(ucus.yer.varis);
                fflush(stdin);
                printf("Ucus saatini giriniz\n?");
                scanf("%d",&ucus.kalkis.saat);
                fflush(stdin);
                printf("Ucus dakikasini giriniz\n?");
                scanf("%d",&ucus.kalkis.dakika);
                fflush(stdin);
                printf("Koltuk miktarini giriniz\n?");
                scanf("%d",&ucus.koltuk.kapasite);
                fflush(stdin);
                ucus.koltuk.bos_olan=ucus.koltuk.kapasite;
                printf("Koltuk fiyatini giriniz\n?");
                scanf("%f",&ucus.koltuk.fiyati);
                fflush(stdin);
                UCUSA_GIT_YAZ
                UCUSA_GIT_OKU
                fflush(stdin);
                printf("Ucus No Kalkis Yeri          Varis Yeri           Zamani Kapasite Bos Koltuk Doluluk %% Fiyati\n");
                printf("------- -------------------- -------------------- ------ -------- ---------- --------- ------\n");
                printf("%-8d%-21s%-21s%02d:%02d  %-9d%-11d%-10.2f%-6.2f\n",ucus.no,ucus.yer.kalkis,ucus.yer.varis,ucus.kalkis.saat,ucus.kalkis.dakika,ucus.koltuk.kapasite,ucus.koltuk.bos_olan,(float)(ucus.koltuk.kapasite-ucus.koltuk.bos_olan)*100/ucus.koltuk.kapasite,ucus.koltuk.fiyati);
        }
        fclose(ufptr);
}
void ucus_sil()
{
        FILE *ufptr,*bfptr,*yfptr;
        Ucus_bilgileri ucus= {
                0,{"",""},{0,0},{0,0,0}
        };
        Bilet_bilgileri veri;
        int ucus_no;
        char *dosya_adi[3]= {"ucus.dat","bilet.txt","yeni.txt"},*amac[3]= {"rb+","r","w"};
        if ((ufptr=fopen(dosya_adi[0],amac[0]))==NULL) {
                printf("%s acilamadi!\n",dosya_adi[0]);//Dosya acilamadiginda ekrana mesaj gönderiliyor
        }
        //Dosya acilirsa diger islemler yapilmaktadir
        else {
                if ((bfptr=fopen(dosya_adi[1],amac[1]))==NULL) {
                        printf("%s acilamadi!\n",dosya_adi[1]);//Dosya acilamadiginda ekrana mesaj gönderiliyor
                }
                //Dosya acilirsa diger islemler yapilmaktadir
                else {
                        if ((yfptr=fopen(dosya_adi[2],amac[2]))==NULL) {
                                printf("%s acilamadi!\n",dosya_adi[2]);//Dosya acilamadiginda ekrana mesaj gönderiliyor
                        }
                        //Dosya acilirsa diger islemler yapilmaktadir
                        else {
                                ucus_no=ucus_no_gir();
                                UCUSA_GIT_OKU
                                ucus.no=0;
                                UCUSA_GIT_YAZ
                                veri=bilet_oku(bfptr);
                                while(!feof(bfptr)) {
                                        if(veri.ucus_no!=ucus_no) {
                                                fprintf(yfptr,"%d %s %.2f\n",veri.ucus_no,veri.yolcu_tc_kimlik_no,veri.fiyati);
                                        }
                                        veri=bilet_oku(bfptr);
                                }
                        }
                        fclose(yfptr);
                }
                fclose(bfptr);
        }
        fclose(ufptr);
        remove(dosya_adi[1]);
        rename(dosya_adi[2],dosya_adi[1]);
}
void zaman_duzenle()
{
        FILE *ufptr;
        Ucus_bilgileri ucus= {
                0,{"",""},{0,0},{0,0,0}
        };
        int ucus_no;
        char *dosya_adi= "ucus.dat",*amac="rb+";
        if ((ufptr=fopen(dosya_adi,amac))==NULL) {
                printf("%s acilamadi!\n",dosya_adi);//Dosya acilamadiginda ekrana mesaj gönderiliyor
        }
        //Dosya acilirsa diger islemler yapilmaktadir
        else {
                ucus_no=ucus_no_gir();
                UCUSA_GIT_OKU
                fflush(stdin);
                if(ucus.no!=0) {
                        printf("Ucus No Kalkis Yeri          Varis Yeri           Zamani Kapasite Bos Koltuk Doluluk %% Fiyati\n");
                        printf("------- -------------------- -------------------- ------ -------- ---------- --------- ------\n");
                        printf("%-8d%-21s%-21s%02d:%02d  %-9d%-11d%-10.2f%-6.2f\n",ucus.no,ucus.yer.kalkis,ucus.yer.varis,ucus.kalkis.saat,ucus.kalkis.dakika,ucus.koltuk.kapasite,ucus.koltuk.bos_olan,(float)(ucus.koltuk.kapasite-ucus.koltuk.bos_olan)*100/ucus.koltuk.kapasite,ucus.koltuk.fiyati);
                        printf("Ucus saatini giriniz\n?");
                        scanf("%d",&ucus.kalkis.saat);
                        fflush(stdin);
                        printf("Ucus dakikasini giriniz\n?");
                        scanf("%d",&ucus.kalkis.dakika);
                        fflush(stdin);
                        UCUSA_GIT_YAZ
                        printf("Ucus No Kalkis Yeri          Varis Yeri           Zamani Kapasite Bos Koltuk Doluluk %% Fiyati\n");
                        printf("------- -------------------- -------------------- ------ -------- ---------- --------- ------\n");
                        printf("%-8d%-21s%-21s%02d:%02d  %-9d%-11d%-10.2f%-6.2f\n",ucus.no,ucus.yer.kalkis,ucus.yer.varis,ucus.kalkis.saat,ucus.kalkis.dakika,ucus.koltuk.kapasite,ucus.koltuk.bos_olan,(float)(ucus.koltuk.kapasite-ucus.koltuk.bos_olan)*100/ucus.koltuk.kapasite,ucus.koltuk.fiyati);
                } else {
                        printf("#%d numarali ucus bulunamamistir!\n",ucus_no);
                }
        }
        fclose(ufptr);
}
void kayit_ekle()
{
        FILE *ufptr,*bfptr;
        Ucus_bilgileri ucus= {
                0,{"",""},{0,0},{0,0,0}
        };

        Bilet_bilgileri veri;
        int ucus_no,kademe=0,satis_miktari;//b_sayisi=bilet sayisi,brut=toplam kazanc
        float doluluk,satis_oncesi_doluluk_orani=0;
        float bilet_katsayilari[10]= {1,1.1,1.2,1.3,1.4,1.5,1.6,1.7,1.8,1.9},bilet_fiyatlari[10]= {0}; //dolu koltuk oranina gore
        int satis_kademeleri[10]= {0};
        int i;
        float bos_koltuk;
        float tutar=0;
        char *dosya_adi[2]= {"ucus.dat","bilet.txt"},*amac[2]= {"rb+","a"};
        if ((ufptr=fopen(dosya_adi[0],amac[0]))==NULL) {
                printf("%s acilamadi!\n",dosya_adi[0]);//Dosya acilamadiginda ekrana mesaj gönderiliyor
        }
        //Dosya acilirsa diger islemler yapilmaktadir
        else {
                if ((bfptr=fopen(dosya_adi[1],amac[1]))==NULL) {
                        printf("%s acilamadi!\n",dosya_adi[1]);//Dosya acilamadiginda ekrana mesaj gönderiliyor
                }
                //Dosya acilirsa diger islemler yapilmaktadir
                else {
                        do {
                                ucus_no=ucus_no_gir();
                                UCUSA_GIT_OKU
                                if(ucus.no==0) {
                                        printf("#%d numarali ucus bulunamamistir!\n",ucus_no);
                                }
                                fflush(stdin);
                        } while(ucus.no==0);
                        printf("Ucus No Kalkis Yeri          Varis Yeri           Zamani Kapasite Bos Koltuk Doluluk %%\n");
                        printf("------- -------------------- -------------------- ------ -------- ---------- ---------\n");
                        doluluk=(float)(ucus.koltuk.kapasite-ucus.koltuk.bos_olan)*100/ucus.koltuk.kapasite;
                        bos_koltuk=ucus.koltuk.bos_olan;
                        printf("%.f\n",doluluk);
                        if(doluluk!=100) {
                                printf("%-8d%-21s%-21s%02d:%02d  %-9d%-11d%-5.2f\n",ucus.no,ucus.yer.kalkis,ucus.yer.varis,ucus.kalkis.saat,ucus.kalkis.dakika,ucus.koltuk.kapasite,ucus.koltuk.bos_olan,doluluk);
                                char devam_mi;
                                do {
                                        printf("Satin almak istediginiz bilet sayisini giriniz\n?Cikis[0]");
                                        scanf("%d",&satis_miktari);
                                        fflush(stdin);
                                        while(satis_miktari>ucus.koltuk.bos_olan) {
                                                printf("Yetersiz ucus alani!\nIstenilen miktarda koltuk bulunmamaktadir!\nCikis[0]");
                                                printf("Satin almak istediginiz bilet sayisini giriniz\n?");
                                                scanf("%d",&satis_miktari);
                                                fflush(stdin);
                                        }
                                        if(satis_miktari>0) {
                                                satis_oncesi_doluluk_orani=doluluk;
                                                for(i=0; i<10; i++) {
                                                        satis_kademeleri[i]=bilet_fiyatlari[i]=0;
                                                }
                                                for(i=0; i<satis_miktari; i++) {
                                                        kademe=satis_oncesi_doluluk_orani/10;
                                                        satis_kademeleri[kademe]++;//Kademeye gore satilan bilet sayisi artiriliyor
                                                        --bos_koltuk;
                                                        satis_oncesi_doluluk_orani=(float)(ucus.koltuk.kapasite-bos_koltuk)*100/ucus.koltuk.kapasite;
                                                }
                                                for(i=0; i<10; i++) {
                                                        if(satis_kademeleri[i]) {
                                                                tutar+=bilet_fiyatlari[satis_kademeleri[i]]=bilet_katsayilari[satis_kademeleri[i]]*ucus.koltuk.fiyati;
                                                                printf("%d adet %.2f TL lik\n",satis_kademeleri[i],bilet_fiyatlari[satis_kademeleri[i]]);
                                                        }
                                                }
                                                printf("Toplam: %.2f TL",tutar);
                                                do {
                                                        printf("Biletleri satin almak istiyor musunuz\n?[E/e]/[H/h]");
                                                        scanf("%c",&devam_mi);
                                                        fflush(stdin);
                                                } while((devam_mi=='e'||devam_mi=='h'||devam_mi=='E'||devam_mi=='H')==0);
                                        } else {
                                                devam_mi='h';
                                                break;
                                        }
                                } while(devam_mi=='h'||devam_mi=='H');
                                if(devam_mi=='e'||devam_mi=='E') {
                                        UCUSA_GIT_OKU
                                        ucus.koltuk.bos_olan=bos_koltuk;
                                        UCUSA_GIT_YAZ
                                        for(i=0; i<10; i++) {
                                                if(satis_kademeleri[i]) {
                                                        do {
                                                                veri.ucus_no=ucus_no;
                                                                veri.fiyati=bilet_fiyatlari[i];
                                                                printf("1 adet musteri Tc nosu giriniz\n");
                                                                gets(veri.yolcu_tc_kimlik_no);
                                                                fflush(stdin);
                                                                fprintf(bfptr,"%d %s %.2f\n",veri.ucus_no,veri.yolcu_tc_kimlik_no,veri.fiyati);
                                                                fflush(stdin);
                                                        } while(--satis_kademeleri[i]);
                                                }
                                        }
                                }
                        } else {
                                printf("Ucus dolmustur!\n");
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
void dosya_sonuna_ekle()
{

        FILE *bfptr;

        Bilet_bilgileri veri= {
                0,"",0
        };
        char *dosya_adi="bilet.txt",*amac="a";
        if((bfptr=fopen(dosya_adi,amac))==NULL) {
                /*Dosya acilamassa*/
                printf("%s dosyasi acilamadi!\n",dosya_adi);
        } else {
                /*Dosya acilirsa*/
                printf("Ucus numarasini giriniz\n?");
                scanf("%d",&veri.ucus_no);
                fflush(stdin);
                printf("Tc numarasini giriniz\n?");
                gets(veri.yolcu_tc_kimlik_no);
                fflush(stdin);
                printf("Fiyati giriniz\n?");
                scanf("%f",&veri.fiyati);
                fflush(stdin);
                fprintf(bfptr,"%d %s %.2f\n",veri.ucus_no,veri.yolcu_tc_kimlik_no,veri.fiyati);
                fflush(stdin);
        }
        fclose(bfptr);
}
int menu(void)
{
        int secim;
        printf("\n\n1) Yeni bir ucusun eklenmesi\n");
        printf("2) Bir ucusun kaydinin silinmesi\n");
        printf("3) Bir ucusun kalkis zamaninin degistirilmesi\n");
        printf("4) Bir ucusa iliskin bilet satilmasi\n");
        printf("5) Cikis\n");
        printf("Seciminiz {[1-5]}\n?");
        scanf("%d", &secim);
        fflush(stdin);
        while(secim<1 || secim>5) {
                printf("\nHatali girdiniz!!!\nSeciminizi tekrar giriniz:{[1-5]}\n?");
                scanf("%d", &secim);
        }
        return secim;
}
int ucus_no_gir(void)
{
        int ucus_no;

        printf("Ucus numarasini giriniz\n[0-1000]?");
        scanf("%d",&ucus_no);
        fflush(stdin);
        while(ucus_no<0 || ucus_no>1000) {
                printf("\nHatali girdiniz!!!\nUcus noyu tekrar giriniz:\n[0-1000]?");
                scanf("%d", &ucus_no);
                fflush(stdin);
        }

        return ucus_no;
}
