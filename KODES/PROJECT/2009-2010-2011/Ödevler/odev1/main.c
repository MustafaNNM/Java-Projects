#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
    int brut_maas;
    int top_brut_maas=0;
    float net_maas;
    char medeni_hal;
    int kac_cocuk;
    int yardim_aile=0;
    int yardim_cocuk=0;
    char ozur;
    float vergi_katsayi=1;
    float vergi_gelir=0;
    int banknot_200,banknot_100,banknot_50,banknot_20,banknot_10,banknot_5,banknot_1;
    printf("Brut maas miktarini giriniz:\n?");
    scanf("%d",&brut_maas);
    printf("Medeni durumunu giriniz\n?");
    fflush(stdin);
    scanf("%c",&medeni_hal);
    if(medeni_hal!='b'&&medeni_hal!='B')
    {
        if(medeni_hal!='d'&&medeni_hal!='D')
        {
            yardim_aile+=50;
        }
        printf("Edindigi cocuk miktarini giriniz\n?");
        fflush(stdin);
        scanf("%d",&kac_cocuk);
        switch(kac_cocuk)
        {
            case 1:yardim_cocuk+=30;top_brut_maas+=yardim_cocuk+yardim_aile+brut_maas;break;
            case 2:yardim_cocuk+=55;top_brut_maas+=yardim_cocuk+yardim_aile+brut_maas;break;
            case 3:yardim_cocuk+=75;top_brut_maas+=yardim_cocuk+yardim_aile+brut_maas;break;
            default:yardim_cocuk+=15*(kac_cocuk-3)+75;top_brut_maas+=yardim_cocuk+yardim_aile+brut_maas;break;
        }
    }
    printf("Sahis engelli mi\n?");
    fflush(stdin);
    scanf("%c",&ozur);
    if(ozur=='e'||ozur=='E')
    {
        vergi_katsayi=0.5;
    }
    //do-while kullanýlarakta yapýlabilir
    if(top_brut_maas<=1000)
    {
        vergi_katsayi*=0.15;
        vergi_gelir=(float)top_brut_maas*vergi_katsayi;
    }
    else
    {
        if(top_brut_maas<=2000)
        {
            vergi_katsayi*=0.2;
            vergi_gelir=(float)top_brut_maas*vergi_katsayi;
        }
        else
        {
            if(top_brut_maas<=3000)
            {
                vergi_katsayi*=0.25;
                vergi_gelir=(float)top_brut_maas*vergi_katsayi;
            }
            else
            {
                vergi_katsayi*=0.3;
                vergi_gelir=(float)top_brut_maas*vergi_katsayi;
            }
        }
    }
    printf("Brut maasi       :%d\n",brut_maas);
    printf("Aile yardimi     :%d\n",yardim_aile);
    printf("Cocuk yardimi    :%d\n",yardim_cocuk);
    printf("Toplam brut maasi:%d\n",top_brut_maas);
    printf("Gelir vergisi orani:%.2f\n",vergi_katsayi);
    printf("Gelir vergisi miktari:%% %.2f\n",vergi_gelir);
    printf("Net maaasi:%.2f\n",net_maas=top_brut_maas*(1-vergi_katsayi));
    net_maas=round(net_maas);
    banknot_200=net_maas/200;
    net_maas-=banknot_200*200;
    printf("%d adet 200 luk banknot\n",banknot_200);
    banknot_100=net_maas/100;
    net_maas-=banknot_100*100;
    printf("%d adet 100 luk banknot\n",banknot_100);
    banknot_50=net_maas/50;
    net_maas-=banknot_50*50;
    printf("%d adet  50 lik banknot\n",banknot_50);
    banknot_20=net_maas/20;
    net_maas-=banknot_20*20;
    printf("%d adet  20 lik banknot\n",banknot_20);
    banknot_10=net_maas/10;
    net_maas-=banknot_10*10;
    printf("%d adet  10 luk banknot\n",banknot_10);
    banknot_5=net_maas/5;
    net_maas-=banknot_5*5;
    printf("%d adet   5 lik banknot\n",banknot_5);
    banknot_1=net_maas;//pek gerekli degil ama...
    printf("%d adet   1 lik banknot\n",banknot_1);
    return 0;
}
