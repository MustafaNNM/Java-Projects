#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int uygun_sayi();
int rakam_to_harf(int rakam);
void int_atama_islemi(int boyut,int gemiler[boyut][boyut]);
void char_atama_islemi(int boyut,char savas_alani[boyut][boyut]);
void char_yazdirma_islemi(int boyut,char savas_alani[boyut][boyut]);
void int_yazdirma_islemi(int boyut,int dizi[boyut][boyut]);
int uzunluk_al(int boyut);
void gemi_yerlestir(int boyut,int gemiler[boyut][boyut],int uzunluk);
int yerlestir_dogrultu_bati_dogu(int boyut,int gemiler[boyut][boyut],int uzunluk,int baslangic_noktasi_x,int baslangic_noktasi_y,int koordinatlar[boyut][boyut]);
int yerlestir_dogrultu_kuzey_guney(int boyut,int gemiler[boyut][boyut],int uzunluk,int baslangic_noktasi_x,int baslangic_noktasi_y,int koordinatlar[boyut][boyut]);
void atis_yap(int boyut,int gemiler[boyut][boyut],char savas_alani[boyut][boyut]);

#define ALANiN_BOYUTUNU_AYARLA N=uygun_sayi()
#define GEMiLERi_RESETLE int_atama_islemi(N,gemiler)
#define ALANi_RESETLE char_atama_islemi(N,savas_alani)
#define GEMiLERi_YAZDIR int_yazdirma_islemi(N,gemiler)
#define ALANi_YAZDIR char_yazdirma_islemi(N,savas_alani)
#define ATiS_YAP atis_yap(N,gemiler,savas_alani)
#define GEMi_YERLESTiR gemi_yerlestir(N,gemiler,geminin_uzunlugu)

int main()
{
        srand(time(NULL));
        int N;
        ALANiN_BOYUTUNU_AYARLA;
        int gemiler[N][N];
        char savas_alani[N][N];
        int geminin_uzunlugu;
        int gemi_sayisi;
        int i=0;
        int uzunluklar_toplami=0;
        int atis_hakki;

        GEMiLERi_RESETLE;//matrise sifir yazdiriliyor tekrar oynamak istersek gerekiyor
        ALANi_RESETLE;//savas alaninin tumune "O" yazdiriliyor

        GEMiLERi_YAZDIR;//Gemilerin bulundugu yeri gosterir Oyunda kullanýlmasi gerekmiyor kontrol amacli
        ALANi_YAZDIR;
        gemi_sayisi=N/2;
        //gemi sayisinca islem tekrar etmeli
        for(i=0; i<gemi_sayisi; i++) {
                printf("%d. gemi icin ",i+1);
                geminin_uzunlugu=uzunluk_al(N);//Kriterlere gore uygun bir gemi uzunlugu belirleniyor
                GEMi_YERLESTiR;//belirtilen uzunlukta bir gemi yerlestirir
                uzunluklar_toplami+=geminin_uzunlugu;
                //GEMiLERi_YAZDIR;//kontrol amacli
        }
        atis_hakki=N*N-uzunluklar_toplami;
        printf("%d atis hakkiniz vardir.\nIyi sanslar!\nOyun basliyor...\n\n",atis_hakki);
        //gemilere atis yaptiriyoruz
        for(i=0; i<atis_hakki; i++) {
                atis_yap(N,gemiler,savas_alani);
                printf("kalan atis yapma hakkiniz:%d\n",atis_hakki-i-1);
                ALANi_YAZDIR;
        }
        return 0;
}
void atis_yap(int boyut,int gemiler[boyut][boyut],char savas_alani[boyut][boyut])
{
        char x;
        int y;
        do {
                printf("\nAtis icin satiri giriniz:");
                scanf("%d",&y);
                fflush(stdin);
        } while(y<1||y>boyut);
        do {
                printf("\nAtis icin sutunu giriniz:");
                scanf("%c",&x);
                fflush(stdin);
        } while(x-65<0||x-65>boyut-1);
        if(savas_alani[y-1][x-65]=='O') {
                if(gemiler[y-1][x-65]==1) {
                        savas_alani[y-1][x-65]='I';
                        printf("Tebrikler, tam isabet, ");
                } else {
                        printf("Uzgunum, karavana, ");
                        savas_alani[y-1][x-65]='K';
                }
        } else {
                printf("Acemi misiniz?Buraya daha once atis yapmistiniz\n");
        }
}
int yerlestir_dogrultu_bati_dogu(int boyut,int gemiler[boyut][boyut],int uzunluk,int baslangic_noktasi_x,int baslangic_noktasi_y,int koordinatlar[boyut][boyut])
{
        int min=0,max=boyut-1;
        int bitis_noktasi_x=baslangic_noktasi_x+uzunluk-1,bitis_noktasi_y=baslangic_noktasi_y;
        int i;
        int yerlesti_mi;

        //maske[y][x] y sabit x ilerlicez

        //geminin onu arkasi musait mi?

        //bastan onceki yer alan ici mi
        if(min<=baslangic_noktasi_x-1&&baslangic_noktasi_x-1<=max) {
                //gemi var mi yok mu
                if(gemiler[baslangic_noktasi_y][baslangic_noktasi_x-1]==1) {
                        yerlesti_mi=0;
                        return yerlesti_mi;
                }
        }
        //bitisten sonraki yer alan ici mi
        if(min<=bitis_noktasi_x+1&&bitis_noktasi_x+1<=max) {
                //gemi var mi yok mu
                if(gemiler[bitis_noktasi_y][bitis_noktasi_x+1]==1) {
                        yerlesti_mi=0;
                        return yerlesti_mi;
                }
        }
        //ust taraf alan icinde mi
        if(min<=baslangic_noktasi_y-1&&baslangic_noktasi_y-1<=max) {
                //ust tarafta gemi var mi
                for(i=baslangic_noktasi_x; i<=bitis_noktasi_x; i++) {
                        if(gemiler[baslangic_noktasi_y-1][i]==1) {
                                yerlesti_mi=0;
                                return yerlesti_mi;
                        }
                }
        }
        //alt taraf alan icinde mi
        if(min<=baslangic_noktasi_y+1&&baslangic_noktasi_y+1<=max) {
                //alt tarafta gemi var mi
                for(i=baslangic_noktasi_x; i<=bitis_noktasi_x; i++) {
                        if(gemiler[baslangic_noktasi_y+1][i]==1) {
                                yerlesti_mi=0;
                                return yerlesti_mi;
                        }
                }
        }
        for(i=baslangic_noktasi_x; i<=bitis_noktasi_x; i++) {
                if(gemiler[baslangic_noktasi_y][i]==1) {
                        yerlesti_mi=0;
                        return yerlesti_mi;
                }
        }
        for(i=baslangic_noktasi_x; i<=bitis_noktasi_x; i++) {
                gemiler[baslangic_noktasi_y][i]=1;
                koordinatlar[baslangic_noktasi_y][i]=1;//tekrar gemi eklenemez
        }
        //ust taraf alan icinde mi
        if(min<=baslangic_noktasi_y-1&&baslangic_noktasi_y-1<=max) {
                //ust tarafa gemi eklenemez
                for(i=baslangic_noktasi_x; i<=bitis_noktasi_x; i++) {
                        koordinatlar[baslangic_noktasi_y-1][i]=1;
                }
        }
        //alt taraf alan icinde mi
        if(min<=baslangic_noktasi_y+1&&baslangic_noktasi_y+1<=max) {
                //alt tarafa gemi eklenemez
                for(i=baslangic_noktasi_x; i<=bitis_noktasi_x; i++) {
                        koordinatlar[baslangic_noktasi_y+1][i]=1;
                }
        }
        yerlesti_mi=1;

        return yerlesti_mi;
}
int yerlestir_dogrultu_kuzey_guney(int boyut,int gemiler[boyut][boyut],int uzunluk,int baslangic_noktasi_x,int baslangic_noktasi_y,int koordinatlar[boyut][boyut])
{
        int min=0,max=boyut-1;
        int bitis_noktasi_y=baslangic_noktasi_y+uzunluk-1,bitis_noktasi_x=baslangic_noktasi_x;
        int i;
        int yerlesti_mi;

        //maske[y][x] x sabit y ilerlicez

        //geminin onu arkasi musait mi?

        //bastan onceki yer alan ici mi
        if(min<=baslangic_noktasi_y-1&&baslangic_noktasi_y-1<=max) {
                //gemi var mi yok mu
                if(gemiler[baslangic_noktasi_y-1][baslangic_noktasi_x]==1) {
                        yerlesti_mi=0;
                        return yerlesti_mi;
                }
        }
        //bitisten sonraki yer alan ici mi
        if(min<=bitis_noktasi_y+1&&bitis_noktasi_y+1<=max) {
                //gemi var mi yok mu
                if(gemiler[bitis_noktasi_y+1][bitis_noktasi_x]==1) {
                        yerlesti_mi=0;
                        return yerlesti_mi;
                }
        }
        //sol taraf alan icinde mi
        if(min<=baslangic_noktasi_x-1&&baslangic_noktasi_x-1<=max) {
                //sol tarafta gemi var mi
                for(i=baslangic_noktasi_y; i<=bitis_noktasi_y; i++) {
                        if(gemiler[i][baslangic_noktasi_x-1]==1) {
                                yerlesti_mi=0;
                                return yerlesti_mi;
                        }
                }
        }
        //sag taraf alan icinde mi
        if(min<=baslangic_noktasi_x+1&&baslangic_noktasi_x+1<=max) {
                //sag tarafta gemi var mi
                for(i=baslangic_noktasi_y; i<=bitis_noktasi_y; i++) {
                        if(gemiler[i][baslangic_noktasi_x+1]==1) {
                                yerlesti_mi=0;
                                return yerlesti_mi;
                        }
                }
        }
        for(i=baslangic_noktasi_y; i<=bitis_noktasi_y; i++) {
                if(gemiler[i][baslangic_noktasi_x]==1) {
                        yerlesti_mi=0;
                        return yerlesti_mi;
                }
        }
        for(i=baslangic_noktasi_y; i<=bitis_noktasi_y; i++) {
                gemiler[i][baslangic_noktasi_x]=1;
                koordinatlar[i][baslangic_noktasi_x]=1;
        }
        //sol taraf alan icinde mi
        if(min<=baslangic_noktasi_x-1&&baslangic_noktasi_x-1<=max) {
                //sol tarafa gemi eklenemez
                for(i=baslangic_noktasi_y; i<=bitis_noktasi_y; i++) {
                        koordinatlar[i][baslangic_noktasi_x-1]=1;
                }
        }
        //sag taraf alan icinde mi
        if(min<=baslangic_noktasi_x+1&&baslangic_noktasi_x+1<=max) {
                //sag tarafta gemi var mi
                for(i=baslangic_noktasi_y; i<=bitis_noktasi_y; i++) {
                        koordinatlar[i][baslangic_noktasi_x+1]=1;
                }
        }
        yerlesti_mi=1;

        return yerlesti_mi;
}
void gemi_yerlestir(int boyut,int gemiler[boyut][boyut],int uzunluk)
{
        int baslangic_noktasi_x,baslangic_noktasi_y;
        int bitis_noktasi_x,bitis_noktasi_y;
        int min=0,max=boyut-1;
        int yon,i;//0:Dogu 1:Guney 2:Bati 3:Kuzey
        int yerlesti_mi;
        int yonler_toplami;
        int yonler[4]= {0};
        int koordinatlar[boyut][boyut];

        int_atama_islemi(boyut,koordinatlar);

        do {
                do {
                        baslangic_noktasi_x=rand()%boyut;//ikinci boyut satir
                        baslangic_noktasi_y=rand()%boyut;//birinci boyut sutun
                } while(koordinatlar[baslangic_noktasi_y][baslangic_noktasi_x]==1);
                koordinatlar[baslangic_noktasi_y][baslangic_noktasi_x]=1;
                for(i=0; i<4; i++) {
                        yonler[i]=0;
                }

                do {
                        do {
                                yon=rand()%4;
                        } while(yonler[yon]==1);
                        switch(yon) {
                                //0:Dogu 1:Guney 2:Bati 3:Kuzey
                        case 0:
                        case 2:
                                yonler[yon]++;
                                bitis_noktasi_x=baslangic_noktasi_x+uzunluk-1;
                                while(min>bitis_noktasi_x||bitis_noktasi_x>max) {
                                        baslangic_noktasi_x=rand()%boyut;//ikinci boyut satir
                                        bitis_noktasi_x=baslangic_noktasi_x+uzunluk-1;
                                }
                                yerlesti_mi=yerlestir_dogrultu_bati_dogu(boyut,gemiler,uzunluk,baslangic_noktasi_x,baslangic_noktasi_y,koordinatlar);
                                break;//Dogu
                        case 1:
                        case 3:
                                yonler[yon]++;
                                bitis_noktasi_y=baslangic_noktasi_y+uzunluk-1;
                                while(min>bitis_noktasi_y||bitis_noktasi_y>max) {
                                        baslangic_noktasi_y=rand()%boyut;//ikinci boyut satir
                                        bitis_noktasi_y=baslangic_noktasi_y+uzunluk-1;
                                }
                                yerlesti_mi=yerlestir_dogrultu_kuzey_guney(boyut,gemiler,uzunluk,baslangic_noktasi_x,baslangic_noktasi_y,koordinatlar);
                                break;//Guney
                        }
                        if(yerlesti_mi==1) {
                                return;
                        }
                        yonler_toplami=yonler[0]+yonler[1]+yonler[2]+yonler[3];
                } while(yonler_toplami!=4);
        } while(yerlesti_mi==0);
}
int uzunluk_al(int boyut)
{
        int uzunluk;
        int min=2,max=boyut/2+1;
        do {
                printf("uzunluk giriniz\n");
                scanf("%d",&uzunluk);
                fflush(stdin);
                printf("\n");
        } while(min>uzunluk||uzunluk>max);
        return uzunluk;
}
int rakam_to_harf(int rakam)
{
        return rakam+=65;
}
void int_yazdirma_islemi(int boyut,int dizi[boyut][boyut])
{
        int i,j;

        printf("*  ");

        for(i=0; i<boyut; i++) {
                printf("%c",rakam_to_harf(i));
        }
        printf("\n");
        for(i=0; i<boyut; i++) {
                printf("%-3d",i+1);
                for(j=0; j<boyut; j++) {
                        printf("%d",dizi[i][j]);
                }
                printf("\n");
        }
}
void char_yazdirma_islemi(int boyut,char savas_alani[boyut][boyut])
{
        int i,j;

        printf("*  ");

        for(i=0; i<boyut; i++) {
                printf("%c",rakam_to_harf(i));
        }
        printf("\n");
        for(i=0; i<boyut; i++) {
                printf("%-3d",i+1);
                for(j=0; j<boyut; j++) {
                        printf("%c",savas_alani[i][j]);
                }
                printf("\n");
        }
}
void char_atama_islemi(int boyut,char savas_alani[boyut][boyut])
{
        int i,j;
        for(i=0; i<boyut; i++) {
                for(j=0; j<boyut; j++) {
                        savas_alani[i][j]='O';
                }
        }
}
void int_atama_islemi(int boyut,int gemiler[boyut][boyut])
{
        int i,j;
        for(i=0; i<boyut; i++) {
                for(j=0; j<boyut; j++) {
                        gemiler[i][j]=0;
                }
        }
}
int uygun_sayi()
{
        int N;
        int fark_int;
        double fark_double;
        double fark;
        int teklik_ciftlik;//0:Cift 1:Tek
        int uygunluk;

        do {
                do {
                        printf("NXN lik oyun icin Cift olan bir sayi giriniz[3-25]\n");

                        scanf("%d",&N);
                        fflush(stdin);
                        printf("\n");
                        fark_double=(float)N/2;
                        fark_int=N/2;

                        fark=fark_double-fark_int;

                        if(fark==0) {
                                teklik_ciftlik=0;//Cift
                        } else {
                                teklik_ciftlik=1;//Tek
                                printf("Cift olan bir sayi girmeniz gerekmektedir!\n");
                        }
                } while(teklik_ciftlik==1);

                if(N<4||N>24) {
                        uygunluk=0;
                        printf("Uygun aralikta bir sayi giriniz![2-25]\n");
                } else {
                        uygunluk=1;
                }
        } while(uygunluk==0);

        return N;
}
