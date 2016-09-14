#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void gemilerin_yazdirilmasi(int alan,int boyut,int gemiler[alan][boyut][boyut]);
void savas_alaninin_yazdirilmasi(int boyut,char savas_alani[boyut][boyut]);
void rastgele_gemilerin_yerlestirilmesi(int alan,int boyut,int gemiler[alan][boyut][boyut],int gemi_sayisi,int gemilerin_uzunluklari[gemi_sayisi]);
void ilk_geminin_yerlestirilmesi(int alan,int boyut,int gemiler[alan][boyut][boyut],int uzunluk);
void kalan_gemilerin_yerlestirilmesi(int alan,int boyut,int gemiler[alan][boyut][boyut],int gemi_sayisi,int gemilerin_uzunluklari[gemi_sayisi]);
void atis(int alan,int boyut,int gemiler[alan][boyut][boyut],char savas_alani[boyut][boyut]);

int main()
{
        srand(time(NULL));

        int i,j;//sayac
        int N;//Savas alaninin bir kenarinin uzunlugu

        do {
                printf("Savas alaninin bir kenar uzunlugunu giriniz:");
                scanf("%d",&N);
        } while(N<2||N>25||N%2==1);
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

        char savas_alani[N][N];

        for(i=0; i<N; i++) {
                for(j=0; j<N; j++) {
                        gemiler[0][i][j]=0;
                        gemiler[1][i][j]=0;
                        savas_alani[i][j]='O';
                }
        }
        rastgele_gemilerin_yerlestirilmesi(2,N,gemiler,gemi_sayisi,gemilerin_uzunluklari);
        //Atis yaptirilmasi gerekiyor
        for(i=atis_yapma_hakki-1;i>0;--i){
            atis(2,N,gemiler,savas_alani);
            printf("kalan atis yapma hakkiniz:%d\n",i);
            savas_alaninin_yazdirilmasi(N,savas_alani);
        }
        getchar();
        getchar();
        return 0;
}
void atis(int alan,int boyut,int gemiler[alan][boyut][boyut],char savas_alani[boyut][boyut])
{
        char sutun;
        int satir;
        do {
                printf("\nAtis icin satiri giriniz:");
                scanf("%d",&satir);
                fflush(stdin);
        } while(satir<1||satir>boyut);
        do {
                printf("\nAtis icin sutunu giriniz:");
                scanf("%c",&sutun);
                fflush(stdin);
        } while(sutun-65<0||sutun-65>boyut-1);
        if(savas_alani[satir-1][sutun-65]=='O') {
                if(gemiler[0][satir-1][sutun-65]==1) {
                        savas_alani[satir-1][sutun-65]='I';
                        printf("Tebrikler, tam isabet, ");
                } else {
                        printf("Uzgunum, karavana, ");
                        savas_alani[satir-1][sutun-65]='K';
                }
        } else {
                printf("Acemi misiniz?Buraya daha once atis yapmistiniz\n");
        }
}
void rastgele_gemilerin_yerlestirilmesi(int alan,int boyut,int gemiler[alan][boyut][boyut],int gemi_sayisi,int gemilerin_uzunluklari[gemi_sayisi])
{
        ilk_geminin_yerlestirilmesi(alan,boyut,gemiler,gemilerin_uzunluklari[0]);

        kalan_gemilerin_yerlestirilmesi(alan,boyut,gemiler,gemi_sayisi,gemilerin_uzunluklari);
}
void ilk_geminin_yerlestirilmesi(int alan,int boyut,int gemiler[alan][boyut][boyut],int uzunluk)
{
        int baslangic_konumu_satir,baslangic_konumu_sutun,bitis_konumu_satir,bitis_konumu_sutun;
        int uygun_mu;
        int yon;
        int i;
        int bakildi_mi[4];
        int toplam;

        baslangic_konumu_satir=rand()%boyut;
        baslangic_konumu_sutun=rand()%boyut;
        for(i=0; i<4; i++) {
                bakildi_mi[i]=0;
        }
        do {
                yon=rand()%4;
                switch(yon) {
                case 0:
                        if(bakildi_mi[0]==0) {
                                bitis_konumu_satir=baslangic_konumu_satir-uzunluk+1;
                                bitis_konumu_sutun=baslangic_konumu_sutun;
                                if(bitis_konumu_satir>-1) {
                                        uygun_mu=1;
                                } else {
                                        uygun_mu=0;
                                }
                        }
                        break;//kuzey
                case 1:
                        if(bakildi_mi[1]==0) {
                                bitis_konumu_satir=baslangic_konumu_satir+uzunluk-1;
                                bitis_konumu_sutun=baslangic_konumu_sutun;
                                if(bitis_konumu_satir<boyut) {
                                        uygun_mu=1;
                                } else {
                                        uygun_mu=0;
                                }
                        }
                        break;//guney
                case 2:
                        if(bakildi_mi[2]==0) {
                                bitis_konumu_sutun=baslangic_konumu_sutun-uzunluk+1;
                                bitis_konumu_satir=baslangic_konumu_satir;
                                if(bitis_konumu_sutun>-1) {
                                        uygun_mu=1;
                                } else {
                                        uygun_mu=0;
                                }
                        }
                        break;//bati
                case 3:
                        if(bakildi_mi[3]==0) {
                                bitis_konumu_sutun=baslangic_konumu_sutun+uzunluk-1;
                                bitis_konumu_satir=baslangic_konumu_satir;
                                if(bitis_konumu_sutun<boyut) {
                                        uygun_mu=1;
                                } else {
                                        uygun_mu=0;
                                }
                        }
                        break;//dogu
                }
                bakildi_mi[yon]=1;
                toplam=0;
                for(i=0; i<4; i++) {
                        toplam+=bakildi_mi[i];
                }
        } while(uygun_mu==0);

        //baslangic konumu ve yon belirlendi bitis noktasinin matrisin disina cikmadigi kontrol edildi
        //simdide gemiyi yerlestirelim
        switch(yon) {
        case 0://kuzey
                for(i=0; i<uzunluk; i++) {
                        gemiler[0][baslangic_konumu_satir-i][baslangic_konumu_sutun]=1;
                        //geminin bulundugu yer parselleniyor
                        gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun]=1;
                }
                //geminin etrafi parselleniyor
                //geminin sol tarafi matrisin icerisindemi
                if(baslangic_konumu_sutun>0) {
                        for(i=0; i<uzunluk; i++) {
                                gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun-1]=1;
                        }
                }
                //geminin sag tarafi matrisin icerisindemi
                if(baslangic_konumu_sutun+1<boyut) {
                        for(i=0; i<uzunluk; i++) {
                                gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun+1]=1;
                        }
                }
                //bitis satirinin bi ustuyle baslangic satirinin bir alti parselleniyor
                //ustu parselleniyor
                if(bitis_konumu_satir>0) {
                        gemiler[1][bitis_konumu_satir-1][baslangic_konumu_sutun]=1;
                }
                //alti parselleniyor
                if(baslangic_konumu_satir+1<boyut) {
                        gemiler[1][baslangic_konumu_satir+1][baslangic_konumu_sutun]=1;
                }
                break;
        case 1://guney
                for(i=0; i<uzunluk; i++) {
                        gemiler[0][baslangic_konumu_satir+i][baslangic_konumu_sutun]=1;
                        //geminin bulundugu yer parselleniyor
                        gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun]=1;
                }
                //geminin etrafi parselleniyor
                //geminin sol tarafi matrisin icerisindemi
                if(baslangic_konumu_sutun>0) {
                        for(i=0; i<uzunluk; i++) {
                                gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun-1]=1;
                        }
                }
                //geminin sag tarafi matrisin icerisindemi
                if(baslangic_konumu_sutun+1<boyut) {
                        for(i=0; i<uzunluk; i++) {
                                gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun+1]=1;
                        }
                }
                //baslangic satirinin bi ustuyle bitis satirinin bir alti parselleniyor
                //ustu parselleniyor
                if(baslangic_konumu_satir>0) {
                        gemiler[1][baslangic_konumu_satir-1][baslangic_konumu_sutun]=1;
                }
                //alti parselleniyor
                if(bitis_konumu_satir+1<boyut) {
                        gemiler[1][bitis_konumu_satir+1][bitis_konumu_sutun]=1;
                }
                break;
        case 2://bati
                for(i=0; i<uzunluk; i++) {
                        gemiler[0][baslangic_konumu_satir][baslangic_konumu_sutun-i]=1;
                        //geminin bulundugu yer parselleniyor
                        gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun-i]=1;
                }
                //geminin etrafi parselleniyor
                //geminin ust tarafi matrisin icerisindemi
                if(baslangic_konumu_satir>0) {
                        for(i=0; i<uzunluk; i++) {
                                gemiler[1][baslangic_konumu_satir-1][baslangic_konumu_sutun-i]=1;
                        }
                }
                //geminin alt tarafi matrisin icerisindemi
                if(baslangic_konumu_satir+1<boyut) {
                        for(i=0; i<uzunluk; i++) {
                                gemiler[1][baslangic_konumu_satir+1][baslangic_konumu_sutun-i]=1;
                        }
                }
                //bitis sutununun sol tarafiyla baslangic sutununun sag tarafi parselleniyor
                //sag parselleniyor
                if(baslangic_konumu_sutun+1<boyut) {
                        gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun+1]=1;
                }
                //sol parselleniyor
                if(bitis_konumu_sutun>0) {
                        gemiler[1][baslangic_konumu_satir][bitis_konumu_sutun-1]=1;
                }
                break;
        case 3://dogu
                for(i=0; i<uzunluk; i++) {
                        gemiler[0][baslangic_konumu_satir][baslangic_konumu_sutun+i]=1;
                        //geminin bulundugu yer parselleniyor
                        gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun+i]=1;
                }
                //geminin etrafi parselleniyor
                //geminin ust tarafi matrisin icerisindemi
                if(baslangic_konumu_satir>0) {
                        for(i=0; i<uzunluk; i++) {
                                gemiler[1][baslangic_konumu_satir-1][baslangic_konumu_sutun+i]=1;
                        }
                }
                //geminin alt tarafi matrisin icerisindemi
                if(baslangic_konumu_satir+1<boyut) {
                        for(i=0; i<uzunluk; i++) {
                                gemiler[1][baslangic_konumu_satir+1][baslangic_konumu_sutun+i]=1;
                        }
                }
                //bitis konumunun sag tarafi ile baslangicin sol tarafi parselleniyor
                //sag tarafi parselleniyor
                if(bitis_konumu_sutun+1<boyut) {
                        gemiler[1][baslangic_konumu_satir][bitis_konumu_sutun+1]=1;
                }
                //sol tarafi parselleniyor
                if(baslangic_konumu_sutun>0) {
                        gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun-1]=1;
                }
                break;
        }
}
void kalan_gemilerin_yerlestirilmesi(int alan,int boyut,int gemiler[alan][boyut][boyut],int gemi_sayisi,int gemilerin_uzunluklari[gemi_sayisi])
{
        int baslangic_konumu_satir,baslangic_konumu_sutun,bitis_konumu_satir,bitis_konumu_sutun;
        int ekledi_mi;
        int yon;
        int i,k;
        int bakildi_mi[4];
        int toplam,girdi_mi;
        int eklenebilir_mi[4];
        for(k=1; k<gemi_sayisi; k++) {
                ekledi_mi=0;
                //gemiler yerlestiriliyor
                do {
                        do {
                                baslangic_konumu_satir=rand()%boyut;
                                baslangic_konumu_sutun=rand()%boyut;
                        } while(gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun]==1);
                        for(i=0; i<4; i++) {
                                bakildi_mi[i]=0;
                                eklenebilir_mi[i]=0;
                        }
                        do {
                                do {
                                        yon=rand()%4;
                                } while(bakildi_mi[yon]==1);
                                //bitis boktasi hesaplaniyor
                                //illa ki bir yone girecek
                                switch(yon) {
                                case 0:
                                        //yone ilk defa bakiyorsak
                                        bakildi_mi[0]=1;
                                        //bakilmadiysa giricek
                                        //bitis konumunun uygunlugunu kontrol ediyoruz
                                        bitis_konumu_satir=baslangic_konumu_satir-gemilerin_uzunluklari[k]+1;
                                        bitis_konumu_sutun=baslangic_konumu_satir;

                                        if(bitis_konumu_satir>-1) {
                                                //gemiyi yerlestirebiliyorsak gemiyi yerlestirmeye calisacagiz
                                                //geminin bulundugu yer musait mi
                                                girdi_mi=0;
                                                for(i=0; i<gemilerin_uzunluklari[k]; i++) {
                                                        if(gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun]==1) {
                                                                girdi_mi=1;
                                                                break;
                                                        }
                                                }

                                                if(girdi_mi==0) {
                                                        ekledi_mi=1;
                                                        for(i=0; i<gemilerin_uzunluklari[k]; i++) {
                                                                gemiler[0][baslangic_konumu_satir-i][baslangic_konumu_sutun]=1;
                                                                //geminin bulundugu yer parselleniyor
                                                                gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun]=1;
                                                        }
                                                        //geminin etrafi parselleniyor
                                                        //geminin sol tarafi matrisin icerisindemi
                                                        if(baslangic_konumu_sutun>0) {
                                                                for(i=0; i<gemilerin_uzunluklari[k]; i++) {
                                                                        gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun-1]=1;
                                                                }
                                                        }
                                                        //geminin sag tarafi matrisin icerisindemi
                                                        if(baslangic_konumu_sutun+1<boyut) {
                                                                for(i=0; i<gemilerin_uzunluklari[k]; i++) {
                                                                        gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun+1]=1;
                                                                }
                                                        }
                                                        //bitis satirinin bi ustuyle baslangic satirinin bir alti parselleniyor
                                                        //ustu parselleniyor
                                                        if(bitis_konumu_satir>0) {
                                                                gemiler[1][bitis_konumu_satir-1][baslangic_konumu_sutun]=1;
                                                        }
                                                        //alti parselleniyor
                                                        if(baslangic_konumu_satir+1<boyut) {
                                                                gemiler[1][bitis_konumu_satir+1][baslangic_konumu_sutun]=1;
                                                        }
                                                }

                                        } else {
                                                eklenebilir_mi[0]=0;//eklenebilir mi:1>>(olumsuz)#0>>(olumlu)
                                        }

                                        break;//kuzey
                                case 1:
                                        bakildi_mi[0]=1;
                                        bitis_konumu_satir=baslangic_konumu_satir+gemilerin_uzunluklari[k]-1;
                                        bitis_konumu_sutun=baslangic_konumu_sutun;
                                        if(bitis_konumu_satir<boyut) {
                                                //gemiyi yerlestirebiliyorsak gemiyi yerlestirmeye calisacagiz
                                                //geminin bulundugu yer musait mi
                                                girdi_mi=0;
                                                for(i=0; i<gemilerin_uzunluklari[k]; i++) {
                                                        if(gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun]==1) {
                                                                girdi_mi=1;
                                                                break;
                                                        }
                                                }
                                                if(girdi_mi==0) {
                                                        ekledi_mi=1;
                                                        for(i=0; i<gemilerin_uzunluklari[k]; i++) {
                        gemiler[0][baslangic_konumu_satir+i][baslangic_konumu_sutun]=1;
                        //geminin bulundugu yer parselleniyor
                        gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun]=1;
                }
                //geminin etrafi parselleniyor
                //geminin sol tarafi matrisin icerisindemi
                if(baslangic_konumu_sutun>0) {
                        for(i=0; i<gemilerin_uzunluklari[k]; i++) {
                                gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun-1]=1;
                        }
                }
                //geminin sag tarafi matrisin icerisindemi
                if(baslangic_konumu_sutun+1<boyut) {
                        for(i=0; i<gemilerin_uzunluklari[k]; i++) {
                                gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun+1]=1;
                        }
                }
                //baslangic satirinin bi ustuyle bitis satirinin bir alti parselleniyor
                //ustu parselleniyor
                if(baslangic_konumu_satir>0) {
                        gemiler[1][baslangic_konumu_satir-1][baslangic_konumu_sutun]=1;
                }
                //alti parselleniyor
                if(bitis_konumu_satir+1<boyut) {
                        gemiler[1][bitis_konumu_satir+1][bitis_konumu_sutun]=1;
                }
                                                }
                                        } else {
                                                eklenebilir_mi[1]=0;//eklenebilir mi:1>>(olumsuz)#0>>(olumlu)
                                        }

                                        break;//guney
                                case 2:
                                        bakildi_mi[0]=1;
                                        bitis_konumu_sutun=baslangic_konumu_sutun-gemilerin_uzunluklari[k]+1;
                                        bitis_konumu_satir=baslangic_konumu_satir;
                                        if(bitis_konumu_sutun>-1) {
                                                //gemiyi yerlestirebiliyorsak gemiyi yerlestirmeye calisacagiz
                                                //geminin bulundugu yer musait mi
                                                girdi_mi=0;
                                                for(i=0; i<gemilerin_uzunluklari[k]; i++) {
                                                        if(gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun-i]==1) {
                                                                girdi_mi=1;
                                                                break;
                                                        }
                                                }
                                                if(girdi_mi==0) {
                                                        ekledi_mi=1;
                                                        for(i=0; i<gemilerin_uzunluklari[k]; i++) {
                                                                gemiler[0][baslangic_konumu_satir][baslangic_konumu_sutun-i]=1;
                                                                //geminin bulundugu yer parselleniyor
                                                                gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun-i]=1;
                                                        }
                                                        //geminin etrafi parselleniyor
                                                        //geminin ust tarafi matrisin icerisindemi
                                                        if(baslangic_konumu_satir>0) {
                                                                for(i=0; i<gemilerin_uzunluklari[k]; i++) {
                                                                        gemiler[1][baslangic_konumu_satir-1][baslangic_konumu_sutun-i]=1;
                                                                }
                                                        }
                                                        //geminin alt tarafi matrisin icerisindemi
                                                        if(baslangic_konumu_satir+1<boyut) {
                                                                for(i=0; i<gemilerin_uzunluklari[k]; i++) {
                                                                        gemiler[1][baslangic_konumu_satir+1][baslangic_konumu_sutun-i]=1;
                                                                }
                                                        }
                                                        //bitis sutununun sol tarafiyla baslangic sutununun sag tarafi parselleniyor
                                                        //sag parselleniyor
                                                        if(baslangic_konumu_sutun+1<boyut) {
                                                                gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun+1]=1;
                                                        }
                                                        //sol parselleniyor
                                                        if(bitis_konumu_sutun>0) {
                                                                gemiler[1][baslangic_konumu_satir][bitis_konumu_sutun-1]=1;
                                                        }
                                                }
                                        } else {
                                                eklenebilir_mi[2]=0;
                                        }
                                        break;//bati
                                case 3:
                                        bakildi_mi[0]=1;
                                        bitis_konumu_sutun=baslangic_konumu_sutun+gemilerin_uzunluklari[k]-1;
                                        bitis_konumu_satir=baslangic_konumu_satir;
                                        if(bitis_konumu_sutun<boyut) {
                                                //gemiyi yerlestirebiliyorsak gemiyi yerlestirmeye calisacagiz
                                                //geminin bulundugu yer musait mi
                                                girdi_mi=0;
                                                for(i=0; i<gemilerin_uzunluklari[k]; i++) {
                                                        if(gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun+i]==1) {
                                                                girdi_mi=1;
                                                                break;
                                                        }
                                                }
                                                if(girdi_mi==0) {
                                                        ekledi_mi=1;
                                                        for(i=0; i<gemilerin_uzunluklari[k]; i++) {
                                                                gemiler[0][baslangic_konumu_satir][baslangic_konumu_sutun+i]=1;
                                                                //geminin bulundugu yer parselleniyor
                                                                gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun+i]=1;
                                                        }
                                                        //geminin etrafi parselleniyor
                                                        //geminin ust tarafi matrisin icerisindemi
                                                        if(baslangic_konumu_satir>0) {
                                                                for(i=0; i<gemilerin_uzunluklari[k]; i++) {
                                                                        gemiler[1][baslangic_konumu_satir-1][baslangic_konumu_sutun+i]=1;
                                                                }
                                                        }
                                                        //geminin alt tarafi matrisin icerisindemi
                                                        if(baslangic_konumu_satir+1<boyut) {
                                                                for(i=0; i<gemilerin_uzunluklari[k]; i++) {
                                                                        gemiler[1][baslangic_konumu_satir+1][baslangic_konumu_sutun+i]=1;
                                                                }
                                                        }
                                                        //bitis konumunun sag tarafi ile baslangicin sol tarafi parselleniyor
                                                        //sag tarafi parselleniyor
                                                        if(bitis_konumu_sutun+1<boyut) {
                                                                gemiler[1][bitis_konumu_satir][bitis_konumu_sutun+1]=1;
                                                        }
                                                        //sol tarafi parselleniyor
                                                        if(baslangic_konumu_sutun>0) {
                                                                gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun-1]=1;
                                                        }
                                                }
                                        } else {
                                                eklenebilir_mi[3]=0;
                                        }

                                        break;//dogu
                                }

                                bakildi_mi[yon]=1;

                                toplam=0;
                                for(i=0; i<4; i++) {
                                        toplam+=bakildi_mi[i];
                                }
                                if(toplam==4) {
                                        break;
                                }
                        } while(ekledi_mi==0);
                        //toplam=4 ise ekledi_mi:0 oldugu surece yeni bir baslangic noktasi belirlicek
                } while(ekledi_mi==0);
        }
}
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
