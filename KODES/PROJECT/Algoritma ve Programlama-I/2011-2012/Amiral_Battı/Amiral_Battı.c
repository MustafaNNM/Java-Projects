#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ALANiN_BOYUTUNU_AYARLA N=uygun_sayi()

int uygun_sayi();
void gemilerin_yazdirilmasi(int alan,int boyut,int gemiler[alan][boyut][boyut]);
void savas_alaninin_yazdirilmasi(int boyut,char savas_alani[boyut][boyut]);
void batti_mi_yi_sifirla(int gemi_sayisi,int **batti_mi[gemi_sayisi],int gemilerin_uzunluklari[gemi_sayisi]);
void rastgele_gemilerin_yerlestirilmesi(int alan,int boyut,int gemiler[alan][boyut][boyut],int gemi_sayisi,int gemilerin_uzunluklari[gemi_sayisi],int **batti_mi[gemi_sayisi]);
void ilk_geminin_yerlestirilmesi(int alan,int boyut,int gemiler[alan][boyut][boyut],int uzunluk,int gemi_sayisi,int **batti_mi[gemi_sayisi]);
void kalan_gemilerin_yerlestirilmesi(int alan,int boyut,int gemiler[alan][boyut][boyut],int gemi_sayisi,int gemilerin_uzunluklari[gemi_sayisi],int **batti_mi[gemi_sayisi]);
void atis(int alan,int boyut,int gemiler[alan][boyut][boyut],char savas_alani[boyut][boyut],int gemi_sayisi,int **batti_mi[gemi_sayisi]);
void yazdir(int gemi_sayisi,int **batti_mi[gemi_sayisi]);
int uygun_sayi()
{
    int N;
    int fark_int;
    double fark_double;
    double fark;
    int teklik_ciftlik;//0:Cift 1:Tek
    int uygunluk;

    do
    {
        do
        {
            printf("NXN lik oyun icin Cift olan bir sayi giriniz[3-25]\n");

            scanf("%d",&N);
            fflush(stdin);
            printf("\n");
            fark_double=(float)N/2;
            fark_int=N/2;

            fark=fark_double-fark_int;

            if(fark==0)
            {
                teklik_ciftlik=0;//Cift
            }
            else
            {
                teklik_ciftlik=1;//Tek
                printf("Cift olan bir sayi girmeniz gerekmektedir!\n");
            }
        }
        while(teklik_ciftlik==1);

        if(N<4||N>24)
        {
            uygunluk=0;
            printf("Uygun aralikta bir sayi giriniz![2-25]\n");
        }
        else
        {
            uygunluk=1;
        }
    }
    while(uygunluk==0);

    return N;
}

void batti_mi_yi_sifirla(int gemi_sayisi,int **batti_mi[gemi_sayisi],int gemilerin_uzunluklari[gemi_sayisi])
{
    int k=0;
    int gemilerin_uzunluklari_toplami=0;
    for(k=0; k<gemi_sayisi; k++)
    {
        gemilerin_uzunluklari_toplami+=gemilerin_uzunluklari[k];
    }

    int boyut=gemilerin_uzunluklari_toplami*4;
    printf("boyut:%d\n",boyut);
    for(k=0; k<boyut; k++)
    {

        batti_mi[k]=0;

        //printf("batti_mi[%d]:%d",k,**batti_mi[k]);
    }

}
void atis(int alan,int boyut,int gemiler[alan][boyut][boyut],char savas_alani[boyut][boyut],int gemi_sayisi,int **batti_mi[gemi_sayisi])
{
    char sutun;
    int satir;
    do
    {
        printf("\nAtis icin satiri giriniz:");
        scanf("%d",&satir);
        fflush(stdin);
    }
    while(satir<1||satir>boyut);
    do
    {
        printf("\nAtis icin sutunu giriniz:");
        scanf("%c",&sutun);
        fflush(stdin);
    }
    while(sutun-65<0||sutun-65>boyut-1);
    if(savas_alani[satir-1][sutun-65]=='O')
    {
        if(gemiler[0][satir-1][sutun-65]==1)
        {
            savas_alani[satir-1][sutun-65]='I';
            //int *ptr;
            //ptr=&batti_mi[0][0][0];
            //ptr[0]=0;
            //printf("batti_mi[0][0][0]:%d\n",batti_mi[0][0][0]);
            printf("Tebrikler, tam isabet, ");
        }
        else
        {
            printf("Uzgunum, karavana,\n");
            savas_alani[satir-1][sutun-65]='K';
        }
    }
    else
    {
        printf("Acemi misiniz?Buraya daha once atis yapmistiniz\n");
    }
}
void gemilerin_yazdirilmasi(int alan,int boyut,int gemiler[alan][boyut][boyut])
{
    int i,j;

    printf("    ");
    for(i=0; i<boyut; i++)
    {
        printf("%c",i+65);
    }
    printf("\n");
    for(i=0; i<boyut; i++)
    {
        printf("%3d ",i+1);
        for(j=0; j<boyut; j++)
        {
            printf("%d",gemiler[0][i][j]);
        }
        printf("\n");
    }
}

void ilk_geminin_yerlestirilmesi(int alan,int boyut,int gemiler[alan][boyut][boyut],int uzunluk,int gemi_sayisi,int **batti_mi[gemi_sayisi])
{
    int baslangic_konumu_satir,baslangic_konumu_sutun,bitis_konumu_satir,bitis_konumu_sutun;
    int uygun_mu;
    int yon;
    //int i,j;
    int i;
    int bakildi_mi[4];
    int toplam;
    //int ilk_gemi_batti_mi[uzunluk][4];
    //ilk_gemi_batti_mi[i][0];//satir bilgisi tutuluyor
    //ilk_gemi_batti_mi[i][1];//sutun bilgisi tutuluyor
    //ilk_gemi_batti_mi[i][2];//batti-batmadi bilgisi tutuluyor
    //ilk_gemi_batti_mi[i][3];//gemi no tutuluyor
    //ilk_gemi_batti_mi dizisinin adresi batti_mi[0] a atanmali
    //batti_mi[0]=&ilk_gemi_batti_mi[0][0];
    //gemi no bilgisi zaten sifir degisiklik yapmaya gerek yok
    //bati-batmadi bilgisi zaten sifir degisiklik yapmaya gerek yok
    //x-y(koordinat bilgisi degisicek)
    /*{
            int *ptr=&ilk_gemi_batti_mi[0][0];
            batti_mi[0]=&ptr;
            for(i=0; i<uzunluk; i++) {
                    for(j=0; j<4; j++) {
                            ilk_gemi_batti_mi[i][j]=0;
                    }
            }
    }*/

    baslangic_konumu_satir=rand()%boyut;
    baslangic_konumu_sutun=rand()%boyut;
    printf("satir:%d\n",baslangic_konumu_satir+1);
    printf("sutun:%c\n",baslangic_konumu_sutun+65);
    for(i=0; i<4; i++)
    {
        bakildi_mi[i]=0;
    }
    do
    {
        yon=rand()%4;
        printf("yon:%d\n",yon);
        //bitis boktasi hesaplaniyor
        //illa ki bir yone girecek
        switch(yon)
        {
        case 0:
            if(bakildi_mi[0]==0)
            {
                bitis_konumu_satir=baslangic_konumu_satir-uzunluk+1;
                bitis_konumu_sutun=baslangic_konumu_sutun;
                if(bitis_konumu_satir>-1)
                {
                    uygun_mu=1;
                }
                else
                {
                    uygun_mu=0;
                }
            }
            break;//kuzey
        case 1:
            if(bakildi_mi[1]==0)
            {
                bitis_konumu_satir=baslangic_konumu_satir+uzunluk-1;
                bitis_konumu_sutun=baslangic_konumu_sutun;
                if(bitis_konumu_satir<boyut)
                {
                    uygun_mu=1;
                }
                else
                {
                    uygun_mu=0;
                }
            }
            break;//guney
        case 2:
            if(bakildi_mi[2]==0)
            {
                bitis_konumu_sutun=baslangic_konumu_sutun-uzunluk+1;
                bitis_konumu_satir=baslangic_konumu_satir;
                if(bitis_konumu_sutun>-1)
                {
                    uygun_mu=1;
                }
                else
                {
                    uygun_mu=0;
                }
            }
            break;//bati
        case 3:
            if(bakildi_mi[3]==0)
            {
                bitis_konumu_sutun=baslangic_konumu_sutun+uzunluk-1;
                bitis_konumu_satir=baslangic_konumu_satir;
                if(bitis_konumu_sutun<boyut)
                {
                    uygun_mu=1;
                }
                else
                {
                    uygun_mu=0;
                }
            }
            break;//dogu
        }
        bakildi_mi[yon]=1;
        toplam=0;
        for(i=0; i<4; i++)
        {
            toplam+=bakildi_mi[i];
        }
    }
    while(uygun_mu==0);

    //baslangic konumu ve yon belirlendi bitis noktasinin matrisin disina cikmadigi kontrol edildi
    //simdide gemiyi yerlestirelim
    switch(yon)
    {
    case 0://kuzey
        for(i=0; i<uzunluk; i++)
        {
            gemiler[0][baslangic_konumu_satir-i][baslangic_konumu_sutun]=1;
            //geminin bulundugu yer parselleniyor
            gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun]=1;
            //ilk_gemi_batti_mi[i][0]=baslangic_konumu_satir-i;//satir bilgisi tutuluyor
            //ilk_gemi_batti_mi[i][1]=baslangic_konumu_sutun;//sutun bilgisi tutuluyor
        }
        //geminin etrafi parselleniyor
        //geminin sol tarafi matrisin icerisindemi
        if(baslangic_konumu_sutun>0)
        {
            for(i=0; i<uzunluk; i++)
            {
                gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun-1]=1;
            }
        }
        //geminin sag tarafi matrisin icerisindemi
        if(baslangic_konumu_sutun+1<boyut)
        {
            for(i=0; i<uzunluk; i++)
            {
                gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun+1]=1;
            }
        }
        //bitis satirinin bi ustuyle baslangic satirinin bir alti parselleniyor
        //ustu parselleniyor
        if(bitis_konumu_satir>0)
        {
            gemiler[1][bitis_konumu_satir-1][baslangic_konumu_sutun]=1;
        }
        //alti parselleniyor
        if(baslangic_konumu_satir+1<boyut)
        {
            gemiler[1][baslangic_konumu_satir+1][baslangic_konumu_sutun]=1;
        }
        break;
    case 1://guney
        for(i=0; i<uzunluk; i++)
        {
            gemiler[0][baslangic_konumu_satir+i][baslangic_konumu_sutun]=1;
            //geminin bulundugu yer parselleniyor
            gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun]=1;
            //ilk_gemi_batti_mi[i][0]=baslangic_konumu_satir+i;//satir bilgisi tutuluyor
            //ilk_gemi_batti_mi[i][1]=baslangic_konumu_sutun;//sutun bilgisi tutuluyor
        }
        //geminin etrafi parselleniyor
        //geminin sol tarafi matrisin icerisindemi
        if(baslangic_konumu_sutun>0)
        {
            for(i=0; i<uzunluk; i++)
            {
                gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun-1]=1;
            }
        }
        //geminin sag tarafi matrisin icerisindemi
        if(baslangic_konumu_sutun+1<boyut)
        {
            for(i=0; i<uzunluk; i++)
            {
                gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun+1]=1;
            }
        }
        //baslangic satirinin bi ustuyle bitis satirinin bir alti parselleniyor
        //ustu parselleniyor
        if(baslangic_konumu_satir>0)
        {
            gemiler[1][baslangic_konumu_satir-1][baslangic_konumu_sutun]=1;
        }
        //alti parselleniyor
        if(bitis_konumu_satir+1<boyut)
        {
            gemiler[1][bitis_konumu_satir+1][bitis_konumu_sutun]=1;
        }
        break;
    case 2://bati
        for(i=0; i<uzunluk; i++)
        {
            gemiler[0][baslangic_konumu_satir][baslangic_konumu_sutun-i]=1;
            //geminin bulundugu yer parselleniyor
            gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun-i]=1;
            //ilk_gemi_batti_mi[i][0]=baslangic_konumu_satir;//satir bilgisi tutuluyor
            //ilk_gemi_batti_mi[i][1]=baslangic_konumu_sutun-i;//sutun bilgisi tutuluyor
        }
        //geminin etrafi parselleniyor
        //geminin ust tarafi matrisin icerisindemi
        if(baslangic_konumu_satir>0)
        {
            for(i=0; i<uzunluk; i++)
            {
                gemiler[1][baslangic_konumu_satir-1][baslangic_konumu_sutun-i]=1;
            }
        }
        //geminin alt tarafi matrisin icerisindemi
        if(baslangic_konumu_satir+1<boyut)
        {
            for(i=0; i<uzunluk; i++)
            {
                gemiler[1][baslangic_konumu_satir+1][baslangic_konumu_sutun-i]=1;
            }
        }
        //bitis sutununun sol tarafiyla baslangic sutununun sag tarafi parselleniyor
        //sag parselleniyor
        if(baslangic_konumu_sutun+1<boyut)
        {
            gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun+1]=1;
        }
        //sol parselleniyor
        if(bitis_konumu_sutun>0)
        {
            gemiler[1][baslangic_konumu_satir][bitis_konumu_sutun-1]=1;
        }
        break;
    case 3://dogu
        for(i=0; i<uzunluk; i++)
        {
            gemiler[0][baslangic_konumu_satir][baslangic_konumu_sutun+i]=1;
            //geminin bulundugu yer parselleniyor
            gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun+i]=1;
            //ilk_gemi_batti_mi[i][0]=baslangic_konumu_satir;//satir bilgisi tutuluyor
            //ilk_gemi_batti_mi[i][1]=baslangic_konumu_sutun+i;//sutun bilgisi tutuluyor
        }
        //geminin etrafi parselleniyor
        //geminin ust tarafi matrisin icerisindemi
        if(baslangic_konumu_satir>0)
        {
            for(i=0; i<uzunluk; i++)
            {
                gemiler[1][baslangic_konumu_satir-1][baslangic_konumu_sutun+i]=1;
            }
        }
        //geminin alt tarafi matrisin icerisindemi
        if(baslangic_konumu_satir+1<boyut)
        {
            for(i=0; i<uzunluk; i++)
            {
                gemiler[1][baslangic_konumu_satir+1][baslangic_konumu_sutun+i]=1;
            }
        }
        //bitis konumunun sag tarafi ile baslangicin sol tarafi parselleniyor
        //sag tarafi parselleniyor
        if(bitis_konumu_sutun+1<boyut)
        {
            gemiler[1][baslangic_konumu_satir][bitis_konumu_sutun+1]=1;
        }
        //sol tarafi parselleniyor
        if(baslangic_konumu_sutun>0)
        {
            gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun-1]=1;
        }
        break;
    }
    printf("\nilk gemi eklendi:asagida\n\n");
    gemilerin_yazdirilmasi(alan,boyut,gemiler);
}
void rastgele_gemilerin_yerlestirilmesi(int alan,int boyut,int gemiler[alan][boyut][boyut],int gemi_sayisi,int gemilerin_uzunluklari[gemi_sayisi],int **batti_mi[gemi_sayisi])
{
    ilk_geminin_yerlestirilmesi(alan,boyut,gemiler,gemilerin_uzunluklari[0],gemi_sayisi,batti_mi);

    //kalan_gemilerin_yerlestirilmesi(alan,boyut,gemiler,gemi_sayisi,gemilerin_uzunluklari,batti_mi);
}

void kalan_gemilerin_yerlestirilmesi(int alan,int boyut,int gemiler[alan][boyut][boyut],int gemi_sayisi,int gemilerin_uzunluklari[gemi_sayisi],int **batti_mi[gemi_sayisi])
{
    int baslangic_konumu_satir,baslangic_konumu_sutun,bitis_konumu_satir,bitis_konumu_sutun;
    int ekledi_mi;
    int yon;
    int i,k;
    int bakildi_mi[4];
    int toplam,girdi_mi;
    //int eklenebilir_mi[4];
    for(k=1; k<gemi_sayisi; k++)
    {
        //int gemi_batti_mi[gemilerin_uzunluklari[k]][4];
        //gemi_batti_mi[i][0];//satir bilgisi tutuluyor
        //gemi_batti_mi[i][1];//sutun bilgisi tutuluyor
        //gemi_batti_mi[i][2];//batti-batmadi bilgisi tutuluyor
        //gemi_batti_mi[i][3];//gemi no tutuluyor
        //gemi_batti_mi dizisinin adresi batti_mi[0] a atanmali
        //batti_mi[0]=&ilk_gemi_batti_mi[0][0];
        //gemi no bilgisi k ya bagli olarak degismeli
        //bati-batmadi bilgisi zaten sifir degisiklik yapmaya gerek yok
        //x-y(koordinat bilgisi degisicek)
        /*{
                int *ptr=&gemi_batti_mi[0][0];
                batti_mi[k]=&ptr;
                //printf("%d. adres:%s\n",k,gemi_batti_mi[0][0]);
                for(i=0; i<gemilerin_uzunluklari[k]; i++) {
                        gemi_batti_mi[i][0]=0;//satir bilgisi tutuluyor
                        gemi_batti_mi[i][1]=0;//sutun bilgisi tutuluyor
                        gemi_batti_mi[i][2]=0;//batti-batmadi bilgisi tutuluyor
                        gemi_batti_mi[i][3]=k;//gemi no tutuluyor
                }
        }*/
        ekledi_mi=0;
        //gemile yerlestiriliyor
        printf("k:%d\n",k);
        do
        {
            do
            {
                baslangic_konumu_satir=rand()%boyut;
                baslangic_konumu_sutun=rand()%boyut;
                printf("satir:%d\n",baslangic_konumu_satir+1);
                printf("sutun:%c\n",baslangic_konumu_sutun+65);
            }
            while(gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun]==1);
            for(i=0; i<4; i++)
            {
                bakildi_mi[i]=0;
                //eklenebilir_mi[i]=0;
            }
            do
            {
                do
                {
                    yon=rand()%4;
                    printf("yon:%d",yon);
                }
                while(bakildi_mi[yon]==1);
                //bitis boktasi hesaplaniyor
                //illa ki bir yone girecek
                switch(yon)
                {
                case 0:
                    //yone ilk defa bakiyorsak
                    bakildi_mi[0]=1;
                    //bakilmadiysa giricek
                    //bitis konumunun uygunlugunu kontrol ediyoruz
                    bitis_konumu_satir=baslangic_konumu_satir-gemilerin_uzunluklari[k]+1;
                    bitis_konumu_sutun=baslangic_konumu_satir;
                    if(bitis_konumu_satir>-1)
                    {
                        //gemiyi yerlestirebiliyorsak gemiyi yerlestirmeye calisacagiz
                        //geminin bulundugu yer musait mi
                        girdi_mi=0;
                        for(i=0; i<gemilerin_uzunluklari[k]; i++)
                        {
                            if(gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun]==1)
                            {
                                girdi_mi=1;
                                break;
                            }
                        }

                        if(girdi_mi==0)
                        {
                            ekledi_mi=1;
                            for(i=0; i<gemilerin_uzunluklari[k]; i++)
                            {
                                gemiler[0][baslangic_konumu_satir-i][baslangic_konumu_sutun]=1;
                                //geminin bulundugu yer parselleniyor
                                gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun]=1;
                                //gemi_batti_mi[i][0]=baslangic_konumu_satir-i;//satir bilgisi tutuluyor
                                //gemi_batti_mi[i][1]=baslangic_konumu_sutun;//sutun bilgisi tutuluyor
                                //printf("satir:%d\n",gemi_batti_mi[i][0]);
                                //printf("sutun:%d\n",gemi_batti_mi[i][1]);
                            }
                            //geminin etrafi parselleniyor
                            //geminin sol tarafi matrisin icerisindemi
                            if(baslangic_konumu_sutun>0)
                            {
                                for(i=0; i<gemilerin_uzunluklari[k]; i++)
                                {
                                    gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun-1]=1;
                                }
                            }
                            //geminin sag tarafi matrisin icerisindemi
                            if(baslangic_konumu_sutun+1<boyut)
                            {
                                for(i=0; i<gemilerin_uzunluklari[k]; i++)
                                {
                                    gemiler[1][baslangic_konumu_satir-i][baslangic_konumu_sutun+1]=1;
                                }
                            }
                            //bitis satirinin bi ustuyle baslangic satirinin bir alti parselleniyor
                            //ustu parselleniyor
                            if(bitis_konumu_satir>0)
                            {
                                gemiler[1][bitis_konumu_satir-1][baslangic_konumu_sutun]=1;
                            }
                            //alti parselleniyor
                            if(baslangic_konumu_satir+1<boyut)
                            {
                                gemiler[1][bitis_konumu_satir+1][baslangic_konumu_sutun]=1;
                            }
                            printf("###ekledi_mi:%d\n",ekledi_mi);
                            gemilerin_yazdirilmasi(alan,boyut,gemiler);
                        }

                    }
                    else
                    {
                        //eklenebilir_mi[0]=0;//eklenebilir mi:1>>(olumsuz)#0>>(olumlu)
                    }

                    break;//kuzey
                case 1:
                    bakildi_mi[0]=1;
                    bitis_konumu_satir=baslangic_konumu_satir+gemilerin_uzunluklari[k]-1;
                    bitis_konumu_sutun=baslangic_konumu_sutun;
                    if(bitis_konumu_satir<boyut)
                    {
                        //gemiyi yerlestirebiliyorsak gemiyi yerlestirmeye calisacagiz
                        //geminin bulundugu yer musait mi
                        girdi_mi=0;
                        for(i=0; i<gemilerin_uzunluklari[k]; i++)
                        {
                            if(gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun]==1)
                            {
                                girdi_mi=1;
                                break;
                            }
                        }
                        if(girdi_mi==0)
                        {
                            ekledi_mi=1;
                            for(i=0; i<gemilerin_uzunluklari[k]; i++)
                            {
                                gemiler[0][baslangic_konumu_satir+i][baslangic_konumu_sutun]=1;
                                //geminin bulundugu yer parselleniyor
                                gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun]=1;
                                //gemi_batti_mi[i][0]=baslangic_konumu_satir+i;//satir bilgisi tutuluyor
                                //gemi_batti_mi[i][1]=baslangic_konumu_sutun;//sutun bilgisi tutuluyor
                                //printf("satir:%d\n",gemi_batti_mi[i][0]);
                                //printf("sutun:%d\n",gemi_batti_mi[i][1]);
                            }
                            //geminin etrafi parselleniyor
                            //geminin sol tarafi matrisin icerisindemi
                            if(baslangic_konumu_sutun>0)
                            {
                                for(i=0; i<gemilerin_uzunluklari[k]; i++)
                                {
                                    gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun-1]=1;
                                }
                            }
                            //geminin sag tarafi matrisin icerisindemi
                            if(baslangic_konumu_sutun+1<boyut)
                            {
                                for(i=0; i<gemilerin_uzunluklari[k]; i++)
                                {
                                    gemiler[1][baslangic_konumu_satir+i][baslangic_konumu_sutun+1]=1;
                                }
                            }
                            //baslangic satirinin bi ustuyle bitis satirinin bir alti parselleniyor
                            //ustu parselleniyor
                            if(baslangic_konumu_satir>0)
                            {
                                gemiler[1][baslangic_konumu_satir-1][baslangic_konumu_sutun]=1;
                            }
                            //alti parselleniyor
                            if(bitis_konumu_satir+1<boyut)
                            {
                                gemiler[1][bitis_konumu_satir+1][bitis_konumu_sutun]=1;
                            }
                            printf("###ekledi_mi:%d\n",ekledi_mi);
                            gemilerin_yazdirilmasi(alan,boyut,gemiler);
                        }
                    }
                    else
                    {
                        //eklenebilir_mi[1]=0;//eklenebilir mi:1>>(olumsuz)#0>>(olumlu)
                    }

                    break;//guney
                case 2:
                    bakildi_mi[0]=1;
                    bitis_konumu_sutun=baslangic_konumu_sutun-gemilerin_uzunluklari[k]+1;
                    bitis_konumu_satir=baslangic_konumu_satir;
                    if(bitis_konumu_sutun>-1)
                    {
                        //gemiyi yerlestirebiliyorsak gemiyi yerlestirmeye calisacagiz
                        //geminin bulundugu yer musait mi
                        girdi_mi=0;
                        for(i=0; i<gemilerin_uzunluklari[k]; i++)
                        {
                            if(gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun-i]==1)
                            {
                                girdi_mi=1;
                                break;
                            }
                        }
                        if(girdi_mi==0)
                        {
                            ekledi_mi=1;
                            for(i=0; i<gemilerin_uzunluklari[k]; i++)
                            {
                                gemiler[0][baslangic_konumu_satir][baslangic_konumu_sutun-i]=1;
                                //geminin bulundugu yer parselleniyor
                                gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun-i]=1;
                                //gemi_batti_mi[i][0]=baslangic_konumu_satir;//satir bilgisi tutuluyor
                                //gemi_batti_mi[i][1]=baslangic_konumu_sutun-i;//sutun bilgisi tutuluyor
                                //printf("satir:%d\n",gemi_batti_mi[i][0]);
                                //printf("sutun:%d\n",gemi_batti_mi[i][1]);
                            }
                            //geminin etrafi parselleniyor
                            //geminin ust tarafi matrisin icerisindemi
                            if(baslangic_konumu_satir>0)
                            {
                                for(i=0; i<gemilerin_uzunluklari[k]; i++)
                                {
                                    gemiler[1][baslangic_konumu_satir-1][baslangic_konumu_sutun-i]=1;
                                }
                            }
                            //geminin alt tarafi matrisin icerisindemi
                            if(baslangic_konumu_satir+1<boyut)
                            {
                                for(i=0; i<gemilerin_uzunluklari[k]; i++)
                                {
                                    gemiler[1][baslangic_konumu_satir+1][baslangic_konumu_sutun-i]=1;
                                }
                            }
                            //bitis sutununun sol tarafiyla baslangic sutununun sag tarafi parselleniyor
                            //sag parselleniyor
                            if(baslangic_konumu_sutun+1<boyut)
                            {
                                gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun+1]=1;
                            }
                            //sol parselleniyor
                            if(bitis_konumu_sutun>0)
                            {
                                gemiler[1][baslangic_konumu_satir][bitis_konumu_sutun-1]=1;
                            }
                            printf("###ekledi_mi:%d\n",ekledi_mi);
                            gemilerin_yazdirilmasi(alan,boyut,gemiler);
                        }
                    }
                    else
                    {
                        //eklenebilir_mi[2]=0;
                    }
                    break;//bati
                case 3:
                    bakildi_mi[0]=1;
                    bitis_konumu_sutun=baslangic_konumu_sutun+gemilerin_uzunluklari[k]-1;
                    bitis_konumu_satir=baslangic_konumu_satir;
                    if(bitis_konumu_sutun<boyut)
                    {
                        //gemiyi yerlestirebiliyorsak gemiyi yerlestirmeye calisacagiz
                        //geminin bulundugu yer musait mi
                        girdi_mi=0;
                        for(i=0; i<gemilerin_uzunluklari[k]; i++)
                        {
                            if(gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun+i]==1)
                            {
                                girdi_mi=1;
                                break;
                            }
                        }
                        if(girdi_mi==0)
                        {
                            ekledi_mi=1;
                            for(i=0; i<gemilerin_uzunluklari[k]; i++)
                            {
                                gemiler[0][baslangic_konumu_satir][baslangic_konumu_sutun+i]=1;
                                //geminin bulundugu yer parselleniyor
                                gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun+i]=1;
                                //gemi_batti_mi[i][0]=baslangic_konumu_satir;//satir bilgisi tutuluyor
                                //gemi_batti_mi[i][1]=baslangic_konumu_sutun+i;//sutun bilgisi tutuluyor
                                //printf("satir:%d\n",gemi_batti_mi[i][0]);
                                //printf("sutun:%d\n",gemi_batti_mi[i][1]);
                            }
                            //geminin etrafi parselleniyor
                            //geminin ust tarafi matrisin icerisindemi
                            if(baslangic_konumu_satir>0)
                            {
                                for(i=0; i<gemilerin_uzunluklari[k]; i++)
                                {
                                    gemiler[1][baslangic_konumu_satir-1][baslangic_konumu_sutun+i]=1;
                                }
                            }
                            //geminin alt tarafi matrisin icerisindemi
                            if(baslangic_konumu_satir+1<boyut)
                            {
                                for(i=0; i<gemilerin_uzunluklari[k]; i++)
                                {
                                    gemiler[1][baslangic_konumu_satir+1][baslangic_konumu_sutun+i]=1;
                                }
                            }
                            //bitis konumunun sag tarafi ile baslangicin sol tarafi parselleniyor
                            //sag tarafi parselleniyor
                            if(bitis_konumu_sutun+1<boyut)
                            {
                                gemiler[1][bitis_konumu_satir][bitis_konumu_sutun+1]=1;
                            }
                            //sol tarafi parselleniyor
                            if(baslangic_konumu_sutun>0)
                            {
                                gemiler[1][baslangic_konumu_satir][baslangic_konumu_sutun-1]=1;
                            }
                            printf("###ekledi_mi:%d\n",ekledi_mi);
                            gemilerin_yazdirilmasi(alan,boyut,gemiler);
                        }
                    }
                    else
                    {
                        //eklenebilir_mi[3]=0;
                    }

                    break;//dogu
                }

                bakildi_mi[yon]=1;

                toplam=0;
                for(i=0; i<4; i++)
                {
                    toplam+=bakildi_mi[i];
                }
                if(toplam==4)
                {
                    break;
                }
                if(girdi_mi==0&&ekledi_mi==1)
                {
                    printf("\n************************Geminiz eklendi\n");
                }
            }
            while(ekledi_mi==0);  //
            printf("toplam:%d",toplam);
            printf("ekledi_mi:%d\n",ekledi_mi);
            //toplam=4 ise ekledi_mi:0 oldugu surece yeni bir baslangic noktasi belirlicek
        }
        while(ekledi_mi==0);
    }
}
void savas_alaninin_yazdirilmasi(int boyut,char savas_alani[boyut][boyut])
{
    int i,j;

    printf("    ");
    for(i=0; i<boyut; i++)
    {
        printf("%c",i+65);
    }
    printf("\n");
    for(i=0; i<boyut; i++)
    {
        printf("%3d ",i+1);
        for(j=0; j<boyut; j++)
        {
            printf("%c",savas_alani[i][j]);
        }
        printf("\n");
    }
}

void yazdir(int gemi_sayisi,int **batti_mi[gemi_sayisi])
{
    //printf("iptal edildi\n");
    printf("a[0]:%d a[1]:%d a[2]:%d a[3]:%d\n",batti_mi[0][0][0],batti_mi[0][0][1],batti_mi[0][0][2],batti_mi[0][0][3]);
    printf("a[0]:%d a[1]:%d a[2]:%d a[3]:%d\n",batti_mi[0][1][0],batti_mi[0][1][1],batti_mi[0][1][2],batti_mi[0][1][3]);
    printf("a[0]:%d a[1]:%d a[2]:%d a[3]:%d\n",batti_mi[0][2][0],batti_mi[0][2][1],batti_mi[0][2][2],batti_mi[0][2][3]);
    printf("a[0]:%d a[1]:%d a[2]:%d a[3]:%d\n",batti_mi[0][3][0],batti_mi[0][3][1],batti_mi[0][3][2],batti_mi[0][3][3]);
    batti_mi[0][0][0]=78;
}
int main()
{
    srand(time(NULL));

    int i=0,j=0;//sayac
    int N;//Savas alaninin bir kenarinin uzunlugu
    ALANiN_BOYUTUNU_AYARLA;
    int gemi_sayisi=N/2;
    int gemilerin_uzunluklari[gemi_sayisi];
    int uzunluk=0;
    int limit=gemi_sayisi+1;
    int atis_yapma_hakki=N*N;
    int **batti_mi[gemi_sayisi];

    for(i=0; i<gemi_sayisi; i++)
    {
        do
        {
            printf("\n%d. geminin uzunlugunu giriniz:",i+1);
            scanf("%d",&uzunluk);
        }
        while(uzunluk<2||uzunluk>limit);

        atis_yapma_hakki-=gemilerin_uzunluklari[i]=uzunluk;
        {
            int a[gemilerin_uzunluklari[i]][4];
            int *ptr=&a[0][0];
            int j=0,k=0;
            for(j=0; j<gemilerin_uzunluklari[i]; j++)
            {
                for(k=0; k<4; k++)
                {
                    a[j][k]=5;
                    //printf("a[%d][%d]:%d",j,k,a[j][k]);
                }
            }
            batti_mi[i]=&ptr;
        }
    }

    //yazdir(gemi_sayisi,batti_mi);

    //printf("batti_mi[0][0][0]:%d\n",batti_mi[0][0][0]);

    batti_mi_yi_sifirla(gemi_sayisi,batti_mi,gemilerin_uzunluklari);

    printf("\nToplam atis yapma hakkiniz: %d\nOyun basliyor...\n",atis_yapma_hakki);
    //0: gemilerin bulundugu yerler icin 1: yeni geminin eklenemeyecegi yerler icin
    int gemiler[2][N][N];//gemilerin tutuldugu ve de yeni geminin eklenemeyecegi yerler tutuluyor
    //int *gemilerptr=&gemiler[0][0][0];
    char savas_alani[N][N];
    //char *savas_alaniptr=&savas_alani[0][0];

    for(i=0; i<N; i++)
    {
        for(j=0; j<N; j++)
        {
            gemiler[0][i][j]=0;
            gemiler[1][i][j]=0;
            savas_alani[i][j]='O';
        }
    }
    //kontrol amacli gemileri yazdiralim mi?
    //gemilerin_yazdirilmasi(2,N,gemiler);
    //kontrol amacli savas alanini yazdiralim mi?
    //savas_alaninin_yazdirilmasi(N,savas_alani);

    rastgele_gemilerin_yerlestirilmesi(2,N,gemiler,gemi_sayisi,gemilerin_uzunluklari,batti_mi);
    //yazdir(gemi_sayisi,batti_mi);
    gemilerin_yazdirilmasi(2,N,gemiler);
    //Atis yaptirilmasi gerekiyor
    for(i=atis_yapma_hakki-1; i>0; --i)
    {
        atis(2,N,gemiler,savas_alani,gemi_sayisi,batti_mi);
        savas_alaninin_yazdirilmasi(N,savas_alani);
        printf("kalan atis yapma hakkiniz:%d",i);
    }
    getchar();
    getchar();
    return 0;
}
