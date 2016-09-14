#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

typedef struct ucus Ucus;
typedef struct bilet Bilet;

struct ucus {
        int ucus_no;
        char kalkis_yeri[21];
        char varis_yeri[21];
        char kalkis_zamani[5];
        int koltuk_kapasitesi;
        int bos_koltuk_sayisi;
        float baslangic_bilet_fiyati;
        Ucus* sonraki_ucus;//alfabetik sıra
        Bilet* satilan_biletler;//tek bağlı liste
};
struct bilet {
        char tc_no[12];
        float bilet_fiyati;
        Bilet* tc_kimlik_noya_gore_sonraki;
};

int menu(void);
int ucus_no_gir(void);
void tc_ekle(int ucus_no,Bilet** bas,Bilet* yeni);
int bos_mu(Bilet *bas);
void tumunu_sil(int ucus_no,Bilet **bas);
void listele(int ucus_no,Bilet *bas);
void bilet_sil(Bilet **sPtr,char tc_no[],int ucus_no);
void tcyle_ucus_listele(Ucus *bas,char tc_no[]);
void tc_listele(Ucus *bas,char tc_no[]);
void tcyle_ucuslari_listele(Ucus *ucus_listesi[]);
void buradan_kalkan_ucuslar(Ucus* ucus,char kalkis_yeri[]);
void kalkis_yerine_gore_ucuslari_listele(Ucus ucus_listesi[]);
void hash_ekle(Ucus *bas, Ucus  *yeni);
void buradan_buraya_ucuslar(Ucus* ucus,char kalkis_yeri[],char varis_yeri[]);
void kalkis_ve_varis_yerine_gore_ucuslari_listele(Ucus ucus_listesi[]);
void ucus_listele(Ucus* ucus);
void ucuslari_listele(Ucus ucus_listesi[]);
void* bir_ucus(int ucus_no);
void printf_ucus(Ucus *data_ucus);

int main()
{
        char devam_mi;
        char tc_no[12];
        int secim,i;
        int ucus_no,kademe=0,satis_miktari;//b_sayisi=bilet sayisi,brut=toplam kazanc
        int bos_koltuk;
        float doluluk=0,satis_oncesi_doluluk_orani=0;
        float tutar=0;
        float bilet_katsayilari[10]= {1,1.1,1.2,1.3,1.4,1.5,1.6,1.7,1.8,1.9},bilet_fiyatlari[10]= {0}; //dolu koltuk oranina gore
        int satis_miktarlari[10]= {0};

        Bilet* veri;
        Ucus* data_ucus=NULL;
        Ucus* ucus_listesi[9000]= {NULL};//isaretci dizisi
        Ucus hash_tablosu[26];//Dairesel tek bagli liste

        for (i=0; i<26; i++) {
                hash_tablosu[i].sonraki_ucus=&hash_tablosu[i];
        }
        for(;;) {
                secim=menu();
                switch(secim) {
                case 1:
                        ucus_no=ucus_no_gir();
                        if(ucus_listesi[ucus_no-1000]!=NULL) {
                                printf("Ekleme yapilamaz!#%d nolu ucus mevcut!",ucus_no);
                        } else {
                                data_ucus=bir_ucus(ucus_no);
                                ucus_listesi[ucus_no-1000]=data_ucus;//Ucus ekleniyor;
                                hash_ekle(&hash_tablosu[data_ucus->kalkis_yeri[0]-'a'],data_ucus);
                                printf("Ucus No Kalkis Yeri          Varis Yeri           Zamani Kapasite Bos Koltuk Doluluk %%\n");
                                printf("------- -------------------- -------------------- ------ -------- ---------- ---------\n");
                                printf_ucus(data_ucus);
                        }
                        break;
                case 2:
                        ucus_no=ucus_no_gir();
                        if(ucus_listesi[ucus_no-1000]!=NULL) {
                                printf("Yeni kalkis saatini giriniz[hh:mm]\n?");
                                fflush(stdin);
                                data_ucus=ucus_listesi[ucus_no-1000];
                                scanf("%c%c%*c%c%c",&data_ucus->kalkis_zamani[0],&data_ucus->kalkis_zamani[1],&data_ucus->kalkis_zamani[2],&data_ucus->kalkis_zamani[3]);
                                data_ucus->kalkis_zamani[4]='\0';
                                fflush(stdin);
                        } else {
                                printf("Duzenleme yapilamaz!#%d nolu ucus bulunamadi!",ucus_no);
                        }
                        break;
                case 3:
                        do {
                                ucus_no=ucus_no_gir();
                                if(ucus_listesi[ucus_no-1000]==NULL) {
                                        printf("#%d numarali ucus bulunamamistir!\n",ucus_no);
                                }
                                fflush(stdin);
                        } while(ucus_listesi[ucus_no-1000]==NULL);
                        data_ucus=ucus_listesi[ucus_no-1000];
                        printf("Ucus No Kalkis Yeri          Varis Yeri           Zamani Kapasite Bos Koltuk Doluluk %%\n");
                        printf("------- -------------------- -------------------- ------ -------- ---------- ---------\n");
                        doluluk=(float)(data_ucus->koltuk_kapasitesi-data_ucus->bos_koltuk_sayisi)*100/data_ucus->koltuk_kapasitesi;
                        bos_koltuk=data_ucus->bos_koltuk_sayisi;
                        if(doluluk!=100) {
                                printf_ucus(data_ucus);
                                do {
                                        printf("Satin almak istediginiz bilet sayisini giriniz\n?Cikis[0]");
                                        scanf("%d",&satis_miktari);
                                        fflush(stdin);
                                        while(satis_miktari>data_ucus->bos_koltuk_sayisi) {
                                                printf("Yetersiz ucus alani!\nIstenilen miktarda koltuk bulunmamaktadir!\nCikis[0]");
                                                printf("Satin almak istediginiz bilet sayisini giriniz\n?");
                                                scanf("%d",&satis_miktari);
                                                fflush(stdin);
                                        }
                                        if(satis_miktari>0) {
                                                satis_oncesi_doluluk_orani=doluluk;
                                                for(i=0; i<10; i++) {
                                                        satis_miktarlari[i]=bilet_fiyatlari[i]=0;
                                                }
                                                for(i=0; i<satis_miktari; i++) {
                                                        kademe=satis_oncesi_doluluk_orani/10;
                                                        satis_miktarlari[kademe]++;//Kademeye gore satilan bilet sayisi artiriliyor
                                                        --bos_koltuk;
                                                        satis_oncesi_doluluk_orani=(float)(data_ucus->koltuk_kapasitesi-bos_koltuk)*100/data_ucus->koltuk_kapasitesi;
                                                }
                                                tutar=0;
                                                for(i=0; i<10; i++) {
                                                        if(satis_miktarlari[i]) {
                                                                tutar+=bilet_fiyatlari[i]=satis_miktarlari[i]*bilet_katsayilari[i]*data_ucus->baslangic_bilet_fiyati;
                                                                printf("%d adet %.2f TL lik\n",satis_miktarlari[i],bilet_fiyatlari[i]/satis_miktarlari[i]);
                                                        }
                                                }
                                                printf("Toplam: %.2f TL",tutar);
                                                do {
                                                        printf("\vBiletleri satin almak istiyor musunuz\n?[E/e]/[H/h]");
                                                        scanf("%c",&devam_mi);
                                                        fflush(stdin);
                                                } while((devam_mi=='e'||devam_mi=='h'||devam_mi=='E'||devam_mi=='H')==0);
                                        } else {
                                                devam_mi='h';
                                                break;
                                        }
                                } while(devam_mi=='h'||devam_mi=='H');
                                if(devam_mi=='e'||devam_mi=='E') {
                                        data_ucus->bos_koltuk_sayisi=bos_koltuk;
                                        for(i=0; i<10; i++) {
                                                if(satis_miktarlari[i]) {
                                                        int miktar=satis_miktarlari[i];
                                                        do {
                                                                veri=malloc(sizeof(Bilet));
                                                                veri->bilet_fiyati=bilet_fiyatlari[i]/satis_miktarlari[i];
                                                                printf("1 adet musteri Tc nosu giriniz\n");
                                                                fflush(stdin);
                                                                gets(veri->tc_no);
                                                                fflush(stdin);
                                                                veri->tc_kimlik_noya_gore_sonraki=NULL;
                                                                tc_ekle(ucus_no,&data_ucus->satilan_biletler,veri);
                                                        } while(--miktar);
                                                }
                                        }
                                }
                        } else {
                                printf("Ucus dolmustur!\n");
                        }
                        break;
                case 4:
                        do {
                                ucus_no=ucus_no_gir();
                                if(ucus_listesi[ucus_no-1000]==NULL) {
                                        printf("#%d numarali ucus bulunamamistir!\n",ucus_no);
                                }
                                fflush(stdin);
                        } while(ucus_listesi[ucus_no-1000]==NULL);
                        data_ucus=ucus_listesi[ucus_no-1000];
                        tumunu_sil(data_ucus->ucus_no,&data_ucus->satilan_biletler);
                        //data_ucus->bos_koltuk_sayisi=data_ucus->koltuk_kapasitesi;
                        free(data_ucus);
                        break;
                case 5:
                        do {
                                ucus_no=ucus_no_gir();
                                if(ucus_listesi[ucus_no-1000]==NULL) {
                                        printf("#%d numarali ucus bulunamamistir!\n",ucus_no);
                                }
                                fflush(stdin);
                        } while(ucus_listesi[ucus_no-1000]==NULL);
                        data_ucus=ucus_listesi[ucus_no-1000];
                        printf("Satilan Biletler:\n");
                        printf("TC Kimlik No Fiyati\n");
                        printf("------------ ------\n");
                        listele(ucus_no,data_ucus->satilan_biletler);
                        printf("Silmek istediginiz biletin Tc nosunu giriniz\n?");
                        gets(tc_no);
                        fflush(stdin);
                        data_ucus->bos_koltuk_sayisi++;
                        bilet_sil(&data_ucus->satilan_biletler,tc_no,data_ucus->ucus_no);
                        printf("Bilgilerin guncel hali:\nSatilan Biletler:\n");
                        printf("TC Kimlik No Fiyati\n");
                        printf("------------ ------\n");
                        listele(ucus_no,data_ucus->satilan_biletler);
                        break;
                case 6:
                        kalkis_yerine_gore_ucuslari_listele(hash_tablosu);
                        break;
                case 7:
                        kalkis_ve_varis_yerine_gore_ucuslari_listele(hash_tablosu);
                        break;
                case 8:
                        do {
                                ucus_no=ucus_no_gir();
                                if(ucus_listesi[ucus_no-1000]==NULL) {
                                        printf("#%d numarali ucus bulunamamistir!\n",ucus_no);
                                }
                                fflush(stdin);
                        } while(ucus_listesi[ucus_no-1000]==NULL);
                        data_ucus=ucus_listesi[ucus_no-1000];
                        printf("Ucus No Kalkis Yeri          Varis Yeri           Zamani Kapasite Bos Koltuk Doluluk %%\n");
                        printf("------- -------------------- -------------------- ------ -------- ---------- ---------\n");
                        printf("%-8d%-21s%-21s%c%c:%c%c  %-9d%-11d%-5.2f\n",data_ucus->ucus_no,data_ucus->kalkis_yeri,data_ucus->varis_yeri,data_ucus->kalkis_zamani[0],data_ucus->kalkis_zamani[1],data_ucus->kalkis_zamani[2],data_ucus->kalkis_zamani[3],data_ucus->koltuk_kapasitesi,data_ucus->bos_koltuk_sayisi,doluluk);
                        printf("Satilan Biletler:\n");
                        printf("TC Kimlik No Fiyati\n");
                        printf("------------ ------\n");
                        listele(ucus_no,data_ucus->satilan_biletler);
                        break;
                case 9:
                        ucuslari_listele(hash_tablosu);
                        break;
                case 10:
                        tcyle_ucuslari_listele(ucus_listesi);
                        break;
                default:
                        exit(EXIT_SUCCESS);
                }
        }

        return 0;
}
int menu(void)
{
        int c;

        printf("0)  Cikis\n");
        printf("1)  Yeni bir ucusun eklenmesi\n");
        printf("2)  Bir ucusun kalkis zamaninin guncellenmesi\n");
        printf("3)  Bir ucusa iliskin bilet satilmasi\n");
        printf("4)  Bir ucusun iptal edilmesi\n");
        printf("5)  Bir ucus icin satilan bir biletin iptal edilmesi\n");
        printf("6)  Bir yerden kalkan ucuslarin bilgilerinin listelenmesi\n");
        printf("7)  Bir yerden bir yere olan ucuslarin bilgilerinin listelenmesi\n");
        printf("8)  Bir ucusun bilgilerinin ve o ucusa iliskin satilan biletlerin listelenmesi\n");
        printf("9)  Koltuk doluluk orani %%50'nin altinda olan ucuslarin listelenmesi\n");
        printf("10) Bir yolcunun biletlerinin listelenmesi\n");


        do {
                printf("\nSeciminizi giriniz\n?");
                scanf("%d",&c);
        } while (c<0 || c>10);

        return c;
}

int ucus_no_gir(void)
{
        int ucus_no;

        printf("Ucus numarasini giriniz\n[1000-9999]?");
        scanf("%d",&ucus_no);
        fflush(stdin);
        while(ucus_no<1000 || ucus_no>9999) {
                printf("\nHatali girdiniz!!!\nUcus noyu tekrar giriniz:\n[1000-9999]?");
                scanf("%d", &ucus_no);
                fflush(stdin);
        }

        return ucus_no;
}
void tc_ekle(int ucus_no,Bilet** bas,Bilet* yeni)
{
        Bilet *gecici, *onceki;

        if (*bas==NULL) {//kuyruk bossa
                yeni->tc_kimlik_noya_gore_sonraki=NULL;
                *bas=yeni;
        } else if (memcmp(yeni->tc_no,(*bas)->tc_no,11)<0) { //en basa eklenecekse
                yeni->tc_kimlik_noya_gore_sonraki=*bas;
                *bas=yeni;
        } else {//araya ya da sona eklenecekse
                onceki=*bas;
                gecici=(*bas)->tc_kimlik_noya_gore_sonraki;
                while ((gecici!=NULL) && (memcmp(gecici->tc_no,yeni->tc_no,11)<0)) {//eklenecek uygun yer araniyor
                        onceki=gecici;
                        gecici=gecici->tc_kimlik_noya_gore_sonraki;
                }
                yeni->tc_kimlik_noya_gore_sonraki=gecici;//gecici NULL ise en sona, degilse onceki dugumu ile gecici dugumu arasina ekleniyor
                onceki->tc_kimlik_noya_gore_sonraki=yeni;
        }
        printf("Ucus No Tc No       Bilet fiyati\n");
        printf("------- ----------- ------------\n");
        printf("%-8d%-12s%.2f\n",ucus_no,yeni->tc_no,yeni->bilet_fiyati);
}
void tumunu_sil(int ucus_no,Bilet **bas)
{
        Bilet *silinen=*bas;
        printf("Ucus No Tc No       Bilet fiyati\n");
        printf("------- ----------- ------------\n");

        while(silinen!=NULL) {
                printf("%-8d%-12s%.2f\n",ucus_no,silinen->tc_no,silinen->bilet_fiyati);
                free(silinen);//bellekten siliniyor
                *bas=(*bas)->tc_kimlik_noya_gore_sonraki;//*bas=gecilistele(ucus_no,data_ucus->satilan_biletler);ci->sonraki ya da *bas=silinen.sonraki seklinde de yazilabilir
                silinen=*bas;
        }
}
void listele(int ucus_no,Bilet *bas)//kuyrugun ilk dugumunun adresi call-by-value ile aktariliyor
{
        int b_sayisi=0;
        float brut=0,ort_bilet_fiyati;
        printf("Ucus No Tc No       Bilet fiyati\n");
        printf("------- ----------- ------------\n");
        while(bas!=NULL) {
                ++b_sayisi;/*bilet sayisi artiriliyor*/
                brut+=bas->bilet_fiyati;/*kazanc ara hesabi*/
                printf("%-8d%-12s%.2f\n",ucus_no,bas->tc_no,bas->bilet_fiyati);
                bas=bas->tc_kimlik_noya_gore_sonraki;//bas bir sonraki dugumu gosteriyor ama main'deki ilk degismiyor
        }
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
}
void bilet_sil(Bilet **sPtr,char tc_no[],int ucus_no)
{
        Bilet* onceki; /* pointer to previous node in list */
        Bilet* simdiki; /* pointer to current node in list */
        Bilet* gecici; /* temporary node pointer */
        /* delete first node */
        if ( memcmp((*sPtr)->tc_no,tc_no,11)==0) {
                gecici = *sPtr; /* hold onto node being removed */
                *sPtr = ( *sPtr )->tc_kimlik_noya_gore_sonraki; /* de-thread the node */
                printf("Ucus No Tc No       Bilet fiyati\n");
                printf("------- ----------- ------------\n");
                printf("%-8d%-12s%.2f\n",ucus_no,gecici->tc_no,gecici->bilet_fiyati);
                free( gecici ); /* free the de-threaded node */
        } /* end if */
        else {
                onceki = *sPtr;
                simdiki = ( *sPtr )->tc_kimlik_noya_gore_sonraki;
                /* loop to find the correct location in the list */
                while ( simdiki != NULL && memcmp(simdiki->tc_no,tc_no,11)!=0) {
                        onceki = simdiki; /* walk to ... */
                        simdiki = simdiki->tc_kimlik_noya_gore_sonraki; /* ... next node */
                } /* end while */

                /* delete node at currentPtr */
                if ( simdiki != NULL ) {
                        gecici = simdiki;
                        onceki->tc_kimlik_noya_gore_sonraki = simdiki->tc_kimlik_noya_gore_sonraki;
                        printf("Ucus No Tc No       Bilet fiyati\n");
                        printf("------- ----------- ------------\n");
                        printf("%-8d%-12s%.2f\n",ucus_no,gecici->tc_no,gecici->bilet_fiyati);
                        free( gecici );
                } /* end if */
        }
}
void tc_listele(Ucus *bas,char tc_no[])
{
        Bilet* gecici=bas->satilan_biletler;

        while(gecici!=NULL&&memcmp(gecici->tc_no,tc_no,11)<=0) {
                if (memcmp(gecici->tc_no,tc_no,11)==0) {
                        printf("%-8d%-21s%-21s%c%c:%c%c  %.2f\n",bas->ucus_no,bas->kalkis_yeri,bas->varis_yeri,bas->kalkis_zamani[0],bas->kalkis_zamani[1],bas->kalkis_zamani[2],bas->kalkis_zamani[3],bas->baslangic_bilet_fiyati);
                }
                gecici=gecici->tc_kimlik_noya_gore_sonraki;
        }
}
void tcyle_ucus_listele(Ucus *bas,char tc_no[])
{
        tc_listele(bas,tc_no);
}
void tcyle_ucuslari_listele(Ucus *ucus_listesi[])
{
        int i;
        char tc[12];

        printf("TC noyu giriniz\n?");
        fflush(stdin);
        gets(tc);
        for (i=0; i<9999; i++) {
                tcyle_ucus_listele(ucus_listesi[i],tc);
        }
}
void buradan_kalkan_ucuslar(Ucus* ucus,char kalkis_yeri[])
{
        Ucus *gecici;
        float doluluk;
        gecici=ucus->sonraki_ucus;
        printf("Ucus No Kalkis Yeri          Varis Yeri           Zamani Kapasite Bos Koltuk Doluluk %%\n");
        printf("------- -------------------- -------------------- ------ -------- ---------- ---------\n");

        while (gecici!=ucus&& strcmp(gecici->kalkis_yeri,kalkis_yeri)<=0) {
                if (strcmp(gecici->kalkis_yeri,kalkis_yeri)==0) {
                        doluluk=(float)(gecici->koltuk_kapasitesi-gecici->bos_koltuk_sayisi)*100/gecici->koltuk_kapasitesi;
                        printf("%-8d%-21s%-21s%c%c:%c%c  %-9d%-11d%-5.2f\n",gecici->ucus_no,gecici->kalkis_yeri,gecici->varis_yeri,gecici->kalkis_zamani[0],gecici->kalkis_zamani[1],gecici->kalkis_zamani[2],gecici->kalkis_zamani[3],gecici->koltuk_kapasitesi,gecici->bos_koltuk_sayisi,doluluk);
                }
                gecici=gecici->sonraki_ucus;
        }
}
void kalkis_yerine_gore_ucuslari_listele(Ucus ucus_listesi[])
{
        char kalkis_yeri[21];
        int i;
        printf("Kalkis yerini giriniz\n?");
        fflush(stdin);
        gets(kalkis_yeri);
        fflush(stdin);
        i=0;
        while(kalkis_yeri[i]!='\0') {
                kalkis_yeri[i]=tolower(kalkis_yeri[i]);
                i++;
        }
        buradan_kalkan_ucuslar(&ucus_listesi[kalkis_yeri[0]-'a'],kalkis_yeri);
}
void hash_ekle(Ucus *bas, Ucus  *yeni)
{
        Ucus *onceki, *gecici;

        onceki=bas;
        gecici=bas->sonraki_ucus;

        while ((gecici!=bas)&&(strcmp(gecici->kalkis_yeri, yeni->kalkis_yeri)<0||(strcmp(gecici->kalkis_yeri, yeni->kalkis_yeri)==0&&strcmp(gecici->kalkis_zamani,yeni->kalkis_zamani)<=0))) {
                onceki=gecici;
                gecici=gecici->sonraki_ucus;
        }
        yeni->sonraki_ucus=gecici;
        onceki->sonraki_ucus=yeni;
}
void buradan_buraya_ucuslar(Ucus* ucus,char kalkis_yeri[],char varis_yeri[])
{
        Ucus *gecici;
        float doluluk;
        gecici=ucus->sonraki_ucus;
        printf("Ucus No Kalkis Yeri          Varis Yeri           Zamani Kapasite Bos Koltuk Doluluk %%\n");
        printf("------- -------------------- -------------------- ------ -------- ---------- ---------\n");

        while (gecici!=ucus&& strcmp(gecici->kalkis_yeri,kalkis_yeri)<=0) {
                if (strcmp(gecici->kalkis_yeri,kalkis_yeri)==0&&strcmp(gecici->varis_yeri,varis_yeri)==0) {
                        doluluk=(float)(gecici->koltuk_kapasitesi-gecici->bos_koltuk_sayisi)*100/gecici->koltuk_kapasitesi;
                        printf("%-8d%-21s%-21s%c%c:%c%c  %-9d%-11d%-5.2f\n",gecici->ucus_no,gecici->kalkis_yeri,gecici->varis_yeri,gecici->kalkis_zamani[0],gecici->kalkis_zamani[1],gecici->kalkis_zamani[2],gecici->kalkis_zamani[3],gecici->koltuk_kapasitesi,gecici->bos_koltuk_sayisi,doluluk);
                }
                gecici=gecici->sonraki_ucus;
        }
}
void kalkis_ve_varis_yerine_gore_ucuslari_listele(Ucus ucus_listesi[])
{
        char kalkis_yeri[21];
        char varis_yeri[21];
        int i;
        printf("Kalkis yerini giriniz\n?");
        fflush(stdin);
        gets(kalkis_yeri);
        fflush(stdin);
        i=0;
        while(kalkis_yeri[i]!='\0') {
                kalkis_yeri[i]=tolower(kalkis_yeri[i]);
                i++;
        }
        printf("Varis yerini giriniz\n?");
        fflush(stdin);
        gets(varis_yeri);
        fflush(stdin);
        i=0;
        while(varis_yeri[i]!='\0') {
                varis_yeri[i]=tolower(varis_yeri[i]);
                i++;
        }
        buradan_buraya_ucuslar(&ucus_listesi[kalkis_yeri[0]-'a'],kalkis_yeri,varis_yeri);
}
void ucus_listele(Ucus* ucus)
{
        Ucus *gecici;
        float doluluk;
        gecici=ucus->sonraki_ucus;

        while (gecici!=ucus) {
                doluluk=(float)(gecici->koltuk_kapasitesi-gecici->bos_koltuk_sayisi)*100/gecici->koltuk_kapasitesi;
                if(doluluk<=50) {
                        printf("%-8d%-21s%-21s%c%c:%c%c  %-9d%-11d%-5.2f\n",gecici->ucus_no,gecici->kalkis_yeri,gecici->varis_yeri,gecici->kalkis_zamani[0],gecici->kalkis_zamani[1],gecici->kalkis_zamani[2],gecici->kalkis_zamani[3],gecici->koltuk_kapasitesi,gecici->bos_koltuk_sayisi,doluluk);
                }
                gecici=gecici->sonraki_ucus;
        }
}
void ucuslari_listele(Ucus ucus_listesi[])
{
        int i;
        printf("Ucus No Kalkis Yeri          Varis Yeri           Zamani Kapasite Bos Koltuk Doluluk %%\n");
        printf("------- -------------------- -------------------- ------ -------- ---------- ---------\n");
        for (i=0; i<26; i++) {
                ucus_listele(&ucus_listesi[i]);
        }
}
void* bir_ucus(int ucus_no)
{
        Ucus* data_ucus;
        int i;
        do {
                data_ucus=malloc(sizeof(Ucus));
        } while(data_ucus==NULL);
        data_ucus->ucus_no=ucus_no;
        printf("Kalkis yerini giriniz\n?");
        fflush(stdin);
        gets(data_ucus->kalkis_yeri);
        fflush(stdin);
        i=0;
        while(data_ucus->kalkis_yeri[i]!='\0') {
                data_ucus->kalkis_yeri[i]=tolower(data_ucus->kalkis_yeri[i]);
                i++;
        }
        printf("Varis yerini giriniz\n?");
        gets(data_ucus->varis_yeri);
        fflush(stdin);
        i=0;
        while(data_ucus->kalkis_yeri[i]!='\0') {
                data_ucus->varis_yeri[i]=tolower(data_ucus->varis_yeri[i]);
                i++;
        }
        printf("Kalkis saatini giriniz[hh:mm]\n?");
        scanf("%c%c%*c%c%c",&data_ucus->kalkis_zamani[0],&data_ucus->kalkis_zamani[1],&data_ucus->kalkis_zamani[2],&data_ucus->kalkis_zamani[3]);
        data_ucus->kalkis_zamani[4]='\0';
        fflush(stdin);
        printf("Koltuk kapasitesini giriniz\n?");
        scanf("%d",&data_ucus->koltuk_kapasitesi);
        data_ucus->bos_koltuk_sayisi=data_ucus->koltuk_kapasitesi;
        printf("Baslangic bilet fiyatini giriniz\n?");
        scanf("%f",&data_ucus->baslangic_bilet_fiyati);
        data_ucus->sonraki_ucus=NULL;
        data_ucus->satilan_biletler=NULL;
        return data_ucus;
}
void printf_ucus(Ucus *data_ucus)
{
        float doluluk;
        doluluk=(float)(data_ucus->koltuk_kapasitesi-data_ucus->bos_koltuk_sayisi)*100/data_ucus->koltuk_kapasitesi;
        printf("%-8d%-21s%-21s%c%c:%c%c  %-9d%-11d%-5.2f\n",data_ucus->ucus_no,data_ucus->kalkis_yeri,data_ucus->varis_yeri,data_ucus->kalkis_zamani[0],data_ucus->kalkis_zamani[1],data_ucus->kalkis_zamani[2],data_ucus->kalkis_zamani[3],data_ucus->koltuk_kapasitesi,data_ucus->bos_koltuk_sayisi,doluluk);
}
