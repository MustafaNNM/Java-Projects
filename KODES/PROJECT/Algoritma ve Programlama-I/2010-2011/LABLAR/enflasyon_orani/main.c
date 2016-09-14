#include <stdio.h>
#include <stdlib.h>

int main()
{
    int urun_kodu;
    float simdiki_fiyati,gecen_ayki_fiyati,enflasyon_orani;

    printf("Urun kodunu giriniz:");
    scanf("%d",&urun_kodu);
    printf("Urunun simdiki fiyatini giriniz:");
    scanf("%f",&simdiki_fiyati);
    printf("Urunun gecen ayki fiyatini giriniz:");
    scanf("%f",&gecen_ayki_fiyati);

    enflasyon_orani=(simdiki_fiyati-gecen_ayki_fiyati)/gecen_ayki_fiyati*100;
    printf("%d kodlu urundeki bir aylik enflasyon orani:%%%f\n",urun_kodu,enflasyon_orani);

    return 0;
}
