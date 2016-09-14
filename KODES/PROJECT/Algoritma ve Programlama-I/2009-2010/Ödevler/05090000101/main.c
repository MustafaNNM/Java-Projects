#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
    float fgh;
    int personel_no,cocuk_sayisi,seviye=0;//seviye:Calisanin maas araligini belirlemek icin
    int banknot_200,banknot_100,banknot_50,banknot_20,banknot_10,banknot_5,banknot_1;
    int say_banknot_200=0,say_banknot_100=0,say_banknot_50=0;
    int say_banknot_20=0,say_banknot_10=0,say_banknot_5=0,say_banknot_1=0;
    int personel_sayisi=0,ucten_fazla_cocuklular=0;
    int net_maas_az=0;//1000 TL’nin altinda net maas alan calisanlarin sayisi
    int miktar_seviye_1=0,miktar_seviye_2=0,miktar_seviye_3=0,miktar_seviye_4=0;
    int net_vergi_rekormeni,vergi_rekormeni,vergi_rekormeni_net_maasi;
    int evli_calisan_sayisi=0,bekar_calisan_sayisi=0,dul_calisan_sayisi=0;
    int evlilerin_cocuk_sayisi=0,dullarin_cucuk_sayisi=0;
    float brut_maas,top_brut_maas,oran_vergi,g_v_kesintisi;
    float net_maas,brut_maas_genel_top=0,net_maas_genel_top=0;
    float seviye_1_g_v_kesintisi=0,seviye_2_g_v_kesintisi=0,seviye_3_g_v_kesintisi=0,seviye_4_g_v_kesintisi=0;
    float en_yuksek_net_maas=0,rekor_vergi,net_rekor_vergi;
    char medeni_hal;

    printf("Personel noyu giriniz\n?");
    scanf("%d",&personel_no);
    while(0<personel_no)
    {
        ++personel_sayisi;
        do
        {
            printf("%d nolu personelin brut maasi giriniz\n?",personel_no);
            scanf("%f",&brut_maas);
            if(760.5>brut_maas)
            {
                printf("Hatali girdiniz!\n");
            }
        }
        while(760.5>brut_maas);
        do
        {
            printf("Medeni durumunu giriniz (e/E:evli, b/B:bekar, d/D:dul)\n?");
            fflush(stdin);
            medeni_hal=getchar();
            fflush(stdin);
        }
        while(medeni_hal!='e'&&medeni_hal!='E'&&medeni_hal!='b'&&medeni_hal!='B'&&medeni_hal!='d'&&medeni_hal!='D');
        if(medeni_hal!='b'&&medeni_hal!='B')
        {
            printf("Cocuk sayisini giriniz\n?");
            scanf("%d",&cocuk_sayisi);
            //top_cocuk_sayisi+=cocuk_sayisi;
            if(medeni_hal!='d'&&medeni_hal!='D')//evliyse
            {
                evlilerin_cocuk_sayisi+=cocuk_sayisi;
                ++evli_calisan_sayisi;
                brut_maas+=50;//Calisanlarin brut maaslarina evli olanlar için 50 TL aile yardimi
            }
            else//dulsa
            {
                dullarin_cucuk_sayisi+=cocuk_sayisi;
                ++dul_calisan_sayisi;
            }
            switch(cocuk_sayisi)
            {
            case 1:
                brut_maas+=30;
                break;
            case 2:
                brut_maas+=55;
                break;
            case 3:
                brut_maas+=75;
                break;
            default:
                brut_maas+=15*(cocuk_sayisi-3)+75;
                ++ucten_fazla_cocuklular;
                break;
            }
        }
        else//bekarsa
        {
            ++bekar_calisan_sayisi;
        }
        brut_maas_genel_top+=top_brut_maas=brut_maas;
        brut_maas=top_brut_maas;
        while(0<brut_maas)
        {
            ++seviye;
            brut_maas-=1000;
        }
        printf("Seviye:%d\n",seviye);
        switch(seviye)
        {
        case 1:
            oran_vergi=0.15;
            seviye_1_g_v_kesintisi+=g_v_kesintisi=top_brut_maas*oran_vergi;
            ++miktar_seviye_1;
            break;
        case 2:
            oran_vergi=0.2;
            seviye_2_g_v_kesintisi+=g_v_kesintisi=top_brut_maas*oran_vergi;
            ++miktar_seviye_2;
            break;
        case 3:
            oran_vergi=0.25;
            seviye_3_g_v_kesintisi+=g_v_kesintisi=top_brut_maas*oran_vergi;
            ++miktar_seviye_3;
            break;
        default :
            oran_vergi=0.3;
            seviye_4_g_v_kesintisi+=g_v_kesintisi=top_brut_maas*oran_vergi;
            ++miktar_seviye_4;
            break;
        }
        seviye=0;
        printf("Toplam brut maasi :%.2f TL\n",top_brut_maas);
        printf("Gelir vergisi kesintisi :%.2f TL\n",g_v_kesintisi);
        brut_maas_genel_top+=net_maas=top_brut_maas-g_v_kesintisi;
        printf("Net maasi :%.2f TL\n",net_maas);
        if(en_yuksek_net_maas<net_maas)
        {
            en_yuksek_net_maas=net_maas;
            net_vergi_rekormeni=personel_no;
            net_rekor_vergi=g_v_kesintisi;
        }
        if(rekor_vergi<g_v_kesintisi)
        {
            rekor_vergi=g_v_kesintisi;
            vergi_rekormeni=personel_no;
            vergi_rekormeni_net_maasi=net_maas;
        }
        if(1000>net_maas)
        {
            ++net_maas_az;/*1000 TL’nin altýnda net maaþ alan çalýþanlarýn sayýsý*/
        }
        net_maas=round(net_maas);
        say_banknot_200+=banknot_200=net_maas/200;
        net_maas-=banknot_200*200;
        printf("%d adet 200 luk banknot\n",banknot_200);
        say_banknot_100+=banknot_100=net_maas/100;
        net_maas-=banknot_100*100;
        printf("%d adet 100 luk banknot\n",banknot_100);
        say_banknot_50+=banknot_50=net_maas/50;
        net_maas-=banknot_50*50;
        printf("%d adet  50 lik banknot\n",banknot_50);
        say_banknot_20+=banknot_20=net_maas/20;
        net_maas-=banknot_20*20;
        printf("%d adet  20 lik banknot\n",banknot_20);
        say_banknot_10+=banknot_10=net_maas/10;
        net_maas-=banknot_10*10;
        printf("%d adet  10 luk banknot\n",banknot_10);
        say_banknot_5+=banknot_5=net_maas/5;
        net_maas-=banknot_5*5;
        printf("%d adet   5 lik banknot\n",banknot_5);
        say_banknot_1+=banknot_1=net_maas;//pek gerekli degil ama...
        printf("%d adet   1 lik banknot\n",banknot_1);
        printf("Personel noyu giriniz\n?");
        scanf("%d",&personel_no);
    }
    if(0<personel_sayisi)
    {
        printf("Tum calisanlarin brut maaslarinin ortalamasi :%.2f TL\n",(float)brut_maas_genel_top/personel_sayisi);
        printf("Tum calisanlara bir ayda odenen net maaslarin toplam tutari :%.2f TL\n",net_maas_genel_top);
        printf("1000 TL’nin altinda net maas alan calisanlarin sayisi:%d\n",net_maas_az);
        printf("%d adet 200 luk banknot\n",say_banknot_200);
        printf("%d adet 100 luk banknot\n",say_banknot_100);
        printf("%d adet  50 lik banknot\n",say_banknot_50);
        printf("%d adet  20 lik banknot\n",say_banknot_20);
        printf("%d adet  10 luk banknot\n",say_banknot_10);
        printf("%d adet   5 lik banknot\n",say_banknot_5);
        printf("%d adet   1 lik banknot\n",say_banknot_1);
        if(0<miktar_seviye_1)
        {
            printf("Toplam brut maasi 1000 TL veya altinda olanlar icin");
            printf("\nortalama gelir vergisi kesintileri :%.2f\n",(float)seviye_1_g_v_kesintisi/miktar_seviye_1);
        }
        if(0<miktar_seviye_2)
        {
            printf("Toplam brut maasi 1000 TL'den yuksek,\n");
            printf("2000 TL veya altinda olanlar icin\n");
            printf("ortalama gelir vergisi kesintileri   :%.2f\n",(float)seviye_2_g_v_kesintisi/miktar_seviye_2);
        }
        if(0<miktar_seviye_3)
        {
            printf("Toplam brut maasi 2000 TL'den yuksek,\n");
            printf("3000 TL veya altinda olanlar icin\n");
            printf("ortalama gelir vergisi kesintileri   :%.2f\n",(float)seviye_3_g_v_kesintisi/miktar_seviye_3);
        }
        if(0<miktar_seviye_4)
        {
            printf("Toplam brut maasi 3000 TL'den yuksek olanlar icin\n");
            printf("ortalama gelir vergisi kesintileri   :%.2f\n",(float)seviye_4_g_v_kesintisi/miktar_seviye_4);
        }
        printf("\nNet maasi en yuksek olan calisanin\n");
        printf("personel numarasi       : %d\n",net_vergi_rekormeni);
        printf("net maasi               : %.2f TL\n",en_yuksek_net_maas);
        printf("gelir vergisi kesintisi : %.2f TL\n\n",net_rekor_vergi);
        if(0<evli_calisan_sayisi)
        {
            printf("Evli olan calisanlarin sayilari  : %d yuzdesi : %% %.2f\n",evli_calisan_sayisi,(float)evli_calisan_sayisi/personel_sayisi*100);
        }
        if(0<bekar_calisan_sayisi)
        {
            printf("Bekar olan calisanlarin sayilari : %d yuzdesi : %% %.2f\n",bekar_calisan_sayisi,(float)bekar_calisan_sayisi/personel_sayisi*100);
        }
        if(0<dul_calisan_sayisi)
        {
            printf("Dul olan calisanlarin sayilari   : %d yuzdesi : %% %.2f\n",dul_calisan_sayisi,(float)dul_calisan_sayisi/personel_sayisi*100);
        }
        if(0<personel_sayisi-bekar_calisan_sayisi)
        {
            printf("\n\nEvli ve dul olan calisanlar dikkate alindiginda,\n");
            printf("cocuk_sayisi : %d\n",evlilerin_cocuk_sayisi+dullarin_cucuk_sayisi);
            printf("personel_sayisi : %d\n",personel_sayisi);
            printf("bekar_calisan_sayisi : %d\n",bekar_calisan_sayisi);
            fgh=(evlilerin_cocuk_sayisi+dullarin_cucuk_sayisi)/(personel_sayisi-bekar_calisan_sayisi);
            printf("fgh : %f\n\n\n",fgh);
            printf("kisi basina ortalama cocuk sayisi: %.2f\n",(float)((evlilerin_cocuk_sayisi+dullarin_cucuk_sayisi)/(personel_sayisi-bekar_calisan_sayisi)));
        }
        printf("3'ten fazla cocugu olan calisanlarin sayisi  :%d\n",ucten_fazla_cocuklular);
    }

    return 0;
}
