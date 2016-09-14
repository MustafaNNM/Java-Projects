#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void gemilerin_yazdirilmasi(int alan,int boyut,int gemiler[alan][boyut][boyut]);
void savas_alaninin_yazdirilmasi(int boyut,char savas_alani[boyut][boyut]);
void rastgele_gemilerin_yerlestirilmesi(int alan,int boyut,int gemiler[alan][boyut][boyut],int gemi_sayisi,int gemilerin_uzunluklari[gemi_sayisi]);
void ilk_geminin_yerlestirilmesi(int alan,int boyut,int gemiler[alan][boyut][boyut],int uzunluk);
//void kalan_gemilerin_yerlestirilmesi(int alan,int boyut,int gemiler[alan][boyut][boyut],int gemi_sayisi,int gemilerin_uzunluklari[gemi_sayisi]);

int main()
{
        srand(time(NULL));

        int i,j;//sayac
        int N;//Savas alaninin bir kenarinin uzunlugu

        do {
                printf("Savas alaninin bir kenar uzunlugunu giriniz:");
                scanf("%d",&N);
        } while((N<2||N>25)&&(N%2!=0));
        int gemi_sayisi=N/2;
        int gemilerin_uzunluklari[gemi_sayisi];
        int uzunluk;
        int limit=N/2+1;
        int atis_yapma_hakki=N*N;
        for(i=0; i<gemi_sayisi; i++) {
                do {
                        printf("\n%d. geminin uzunlugunu giriniz:",i+1);
                        scanf("%d",&uzunluk);
                } while(uzunluk<2||uzunluk>limit);
                atis_yapma_hakki-=gemilerin_uzunluklari[i]=uzunluk;
        }
        printf("\nToplam atis yapma hakkiniz: %d\nOyun basliyor...\n",atis_yapma_hakki);
        //0: gemilerin bulundugu yerler icin 1: yeni geminin eklenemeyecegi yerler icin
        int gemiler[2][N][N];//gemilerin tutuldugu ve de yeni geminin eklenemeyecegi yerler tutuluyor
        //int *gemilerptr=&gemiler[0][0][0];
        char savas_alani[N][N];
        //char *savas_alaniptr=&savas_alani[0][0];

        for(i=0; i<N; i++) {
                for(j=0; j<N; j++) {
                        gemiler[0][i][j]=0;
                        gemiler[1][i][j]=0;
                        savas_alani[i][j]='O';
                }
        }
        //kontrol amacli gemileri yazdiralim mi?
        gemilerin_yazdirilmasi(2,N,gemiler);
        //kontrol amacli savas alanini yazdiralim mi?
        savas_alaninin_yazdirilmasi(N,savas_alani);

        rastgele_gemilerin_yerlestirilmesi(2,N,gemiler,gemi_sayisi,gemilerin_uzunluklari);
gemilerin_yazdirilmasi(2,N,gemiler);
        //Atis yaptirilmasi gerekiyor
        getchar();
        getchar();
        getchar();
        return 0;
}
void rastgele_gemilerin_yerlestirilmesi(int alan,int boyut,int gemiler[alan][boyut][boyut],int gemi_sayisi,int gemilerin_uzunluklari[gemi_sayisi])
{
        ilk_geminin_yerlestirilmesi(alan,boyut,gemiler,gemilerin_uzunluklari[0]);
        //kalan_gemilerin_yerlestirilmesi(alan,boyut,gemiler,gemi_sayisi,gemilerin_uzunluklari);
}
void ilk_geminin_yerlestirilmesi(int alan,int boyut,int gemiler[alan][boyut][boyut],int uzunluk)
{
        int baslangic_konumu_satir,baslangic_konumu_sutun,bitis_konumu_satir,bitis_konumu_sutun;
        int uygun_mu;
        int yon;
        int i;

        baslangic_konumu_satir=rand()%boyut;
        baslangic_konumu_sutun=rand()%boyut;

        do {
                yon=rand()%4;
                //bitis boktasi hesaplaniyor
                //illa ki bir yone girecek
                switch(yon) {
                case 0:
                        bitis_konumu_satir=baslangic_konumu_satir-uzunluk;
                        if(bitis_konumu_satir>0) {
                                uygun_mu=1;
                        } else {
                                uygun_mu=0;
                        }
                        break;//kuzey
                case 1:
                        bitis_konumu_satir=baslangic_konumu_satir+uzunluk;
                        if(bitis_konumu_satir<boyut) {
                                uygun_mu=1;
                        } else {
                                uygun_mu=0;
                        }
                        break;//guney
                case 2:
                        bitis_konumu_sutun=baslangic_konumu_sutun-uzunluk;
                        if(bitis_konumu_sutun>0) {
                                uygun_mu=1;
                        } else {
                                uygun_mu=0;
                        }
                        break;//bati
                case 3:
                        bitis_konumu_sutun=baslangic_konumu_sutun+uzunluk;
                        if(bitis_konumu_sutun<boyut) {
                                uygun_mu=1;
                        } else {
                                uygun_mu=0;
                        }
                        break;//dogu
                }
        } while(uygun_mu==0);

        //baslangic konumu ve yon belirlendi bitis noktasinin matrisin disina cýkmadigi kontrol edildi
        //simdide gemiyi yerlestirelim
        switch(yon) {
        case 0://kuzey
                for(i=0; i<uzunluk; i++) {
                        gemiler[0][baslangic_konumu_satir-i][baslangic_konumu_sutun]=1;
                        //geminin bulundugu yer parselleniyor
                        gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun]=1;
                }
                //geminin etrafi parselleniyor
                //geminin sol tarafý matrisin icerisindemi
                if(baslangic_konumu_sutun>0) {
                        for(i=0; i<uzunluk; i++) {
                                gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun-1]=1;
                        }
                }
                //geminin sag tarafý matrisin icerisindemi
                if(baslangic_konumu_sutun+1<boyut) {
                        for(i=0; i<uzunluk; i++) {
                                gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun+1]=1;
                        }
                }
                break;
        case 1://guney
                for(i=0; i<uzunluk; i++) {
                        gemiler[0][baslangic_konumu_satir+i][baslangic_konumu_sutun]=1;
                        //geminin bulundugu yer parselleniyor
                        gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun]=1;
                }
                //geminin etrafi parselleniyor
                //geminin sol tarafý matrisin icerisindemi
                if(baslangic_konumu_sutun>0) {
                        for(i=0; i<uzunluk; i++) {
                                gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun-1]=1;
                        }
                }
                //geminin sag tarafý matrisin icerisindemi
                if(baslangic_konumu_sutun+1<boyut) {
                        for(i=0; i<uzunluk; i++) {
                                gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun+1]=1;
                        }
                }
                break;
        case 2://bati
                for(i=0; i<uzunluk; i++) {
                        gemiler[0][baslangic_konumu_satir][baslangic_konumu_sutun-i]=1;
                        //geminin bulundugu yer parselleniyor
                        gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun-i]=1;
                }
                //geminin etrafi parselleniyor
                //geminin ust tarafý matrisin icerisindemi
                if(baslangic_konumu_satir>0) {
                        for(i=0; i<uzunluk; i++) {
                                gemiler[1][baslangic_konumu_satir-1][baslangic_konumu_sutun-i]=1;
                        }
                }
                //geminin alt tarafý matrisin icerisindemi
                if(baslangic_konumu_satir+1<boyut) {
                        for(i=0; i<uzunluk; i++) {
                                gemiler[1][baslangic_konumu_satir+1][baslangic_konumu_sutun-i]=1;
                        }
                }
                break;
        case 3://dogu
                for(i=0; i<uzunluk; i++) {
                        gemiler[0][baslangic_konumu_satir][baslangic_konumu_sutun+i]=1;
                        //geminin bulundugu yer parselleniyor
                        gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun+i]=1;
                }
                //geminin etrafi parselleniyor
                //geminin ust tarafý matrisin icerisindemi
                if(baslangic_konumu_satir>0) {
                        for(i=0; i<uzunluk; i++) {
                                gemiler[1][baslangic_konumu_satir-1][baslangic_konumu_sutun+i]=1;
                        }
                }
                //geminin alt tarafý matrisin icerisindemi
                if(baslangic_konumu_satir+1<boyut) {
                        for(i=0; i<uzunluk; i++) {
                                gemiler[1][baslangic_konumu_satir+1][baslangic_konumu_sutun+i]=1;
                        }
                }
                break;
        }
}
/*void kalan_gemilerin_yerlestirilmesi(int alan,int boyut,int gemiler[alan][boyut][boyut],int gemi_sayisi,int gemilerin_uzunluklari[gemi_sayisi]);
{
        int k;
        int baslangic_konumu_satir,baslangic_konumu_sutun,bitis_konumu_satir,bitis_konumu_sutun;
        int uygun_mu;
        int bakildi_mi[4];

        for(k=1; k<gemi_sayisi; k++) {
        do{
                baslangic_konumu_satir=rand()%boyut;
                baslangic_konumu_sutun=rand()%boyut;
                for(i=0;i<4;i++){
                    bakildi_mi[i]=0;
                }
                do {
                        yon=rand()%4;
                        //bitis boktasi hesaplaniyor
                        //illa ki bir yone girecek
                        switch(yon) {
                        case 0:
                                if(bakildi_mi[0]==0) {
                                        bitis_konumu_satir=baslangic_konumu_satir-uzunluk;
                                        if(bitis_konumu_satir>0) {
                                                uygun_mu=1;
                                        } else {
                                                uygun_mu=0;
                                        }
                                }
                                break;//kuzey
                        case 1:
                                if(bakildi_mi[1]==0) {
                                        bitis_konumu_satir=baslangic_konumu_satir+uzunluk;
                                        if(bitis_konumu_satir<boyut) {
                                                uygun_mu=1;
                                        } else {
                                                uygun_mu=0;
                                        }
                                }
                                break;//guney
                        case 2:
                                if(bakildi_mi[2]==0) {
                                        bitis_konumu_sutun=baslangic_konumu_sutun-uzunluk;
                                        if(bitis_konumu_sutun>0) {
                                                uygun_mu=1;
                                        } else {
                                                uygun_mu=0;
                                        }
                                }
                                break;//bati
                        case 3:
                                if(bakildi_mi[3]==0) {
                                        bitis_konumu_sutun=baslangic_konumu_sutun+uzunluk;
                                        if(bitis_konumu_sutun<boyut) {
                                                uygun_mu=1;
                                        } else {
                                                uygun_mu=0;
                                        }
                                }
                                break;//dogu
                        }
                        bakildi_mi[yon]=1;
                        for(i=0;i<4;i++){
                            toplam+=bakildi_mi[i];
                        }
                        if(toplam==4){
                        break;
                        }
                } while(uygun_mu==0);
        }while(uygun_mu==0);
                //baslangic konumu ve yon belirlendi bitis noktasinin matrisin disina cýkmadigi kontrol edildi
                //simdide gemiyi yerlestirelim
                switch(yon) {
                case 0://kuzey
                        for(i=0; i<uzunluk; i++) {
                                gemiler[0][baslangic_konumu_satir-i][baslangic_konumu_sutun]=1;
                                //geminin bulundugu yer parselleniyor
                                gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun]=1;
                        }
                        //geminin etrafi parselleniyor
                        //geminin sol tarafý matrisin icerisindemi
                        if(baslangic_konumu_sutun>0) {
                                for(i=0; i<uzunluk; i++) {
                                        gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun-1]=1;
                                }
                        }
                        //geminin sag tarafý matrisin icerisindemi
                        if(baslangic_konumu_sutun+1<boyut) {
                                for(i=0; i<uzunluk; i++) {
                                        gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun+1]=1;
                                }
                        }
                        break;
                case 1://guney
                        for(i=0; i<uzunluk; i++) {
                                gemiler[0][baslangic_konumu_satir+i][baslangic_konumu_sutun]=1;
                                //geminin bulundugu yer parselleniyor
                                gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun]=1;
                        }
                        //geminin etrafi parselleniyor
                        //geminin sol tarafý matrisin icerisindemi
                        if(baslangic_konumu_sutun>0) {
                                for(i=0; i<uzunluk; i++) {
                                        gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun-1]=1;
                                }
                        }
                        //geminin sag tarafý matrisin icerisindemi
                        if(baslangic_konumu_sutun+1<boyut) {
                                for(i=0; i<uzunluk; i++) {
                                        gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun+1]=1;
                                }
                        }
                        break;
                case 2://bati
                        for(i=0; i<uzunluk; i++) {
                                gemiler[0][baslangic_konumu_satir][baslangic_konumu_sutun-i]=1;
                                //geminin bulundugu yer parselleniyor
                                gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun-i]=1;
                        }
                        //geminin etrafi parselleniyor
                        //geminin ust tarafý matrisin icerisindemi
                        if(baslangic_konumu_satir>0) {
                                for(i=0; i<uzunluk; i++) {
                                        gemiler[1][baslangic_konumu_satir-1][baslangic_konumu_sutun-i]=1;
                                }
                        }
                        //geminin alt tarafý matrisin icerisindemi
                        if(baslangic_konumu_satir+1<boyut) {
                                for(i=0; i<uzunluk; i++) {
                                        gemiler[1][baslangic_konumu_satir+1][baslangic_konumu_sutun-i]=1;
                                }
                        }
                        break;
                case 3://dogu
                        for(i=0; i<uzunluk; i++) {
                                gemiler[0][baslangic_konumu_satir][baslangic_konumu_sutun+i]=1;
                                //geminin bulundugu yer parselleniyor
                                gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun+i]=1;
                        }
                        //geminin etrafi parselleniyor
                        //geminin ust tarafý matrisin icerisindemi
                        if(baslangic_konumu_satir>0) {
                                for(i=0; i<uzunluk; i++) {
                                        gemiler[1][baslangic_konumu_satir-1][baslangic_konumu_sutun+i]=1;
                                }
                        }
                        //geminin alt tarafý matrisin icerisindemi
                        if(baslangic_konumu_satir+1<boyut) {
                                for(i=0; i<uzunluk; i++) {
                                        gemiler[1][baslangic_konumu_satir+1][baslangic_konumu_sutun+i]=1;
                                }
                        }
                        break;
                }

        }
}*/
void gemilerin_yazdirilmasi(int alan,int boyut,int gemiler[alan][boyut][boyut])
{
        int i,j;

        printf("    ");
        for(i=0; i<boyut; i++) {
                printf("%c",i+65);
        }
        printf("\n");
        for(i=0; i<boyut; i++) {
                printf("%3d ",i+1);
                for(j=0; j<boyut; j++) {
                        printf("%d",gemiler[0][i][j]);
                }
                printf("\n");
        }
}
void savas_alaninin_yazdirilmasi(int boyut,char savas_alani[boyut][boyut])
{
        int i,j;

        printf("    ");
        for(i=0; i<boyut; i++) {
                printf("%c",i+65);
        }
        printf("\n");
        for(i=0; i<boyut; i++) {
                printf("%3d ",i+1);
                for(j=0; j<boyut; j++) {
                        printf("%c",savas_alani[i][j]);
                }
                printf("\n");
        }
}
