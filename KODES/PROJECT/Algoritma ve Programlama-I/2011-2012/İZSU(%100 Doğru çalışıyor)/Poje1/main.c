#include <stdio.h>
#include <stdlib.h>

int main()
{
        //Faturalama yapilacak abonelerin bitip bitmedigini kontrol etmek için
        int devam_mi;
        char var_mi;
        //Hata mesaji için
        int sayac;
        //Kullanici girdileri için
        int abone_tipi_kodu;
        int onceki_sayac_degeri;
        int simdiki_sayac_degeri;
        int sayac_okunali_kac_gun_oldu;
        //Konutlar için
        float su_kademe_1_konut=13;
        float su_kademe_2_konut=7;
        //Is yerleri için
        float su_kademe_1_is_yeri=10;
        float su_kademe_2_is_yeri=0;
        //Güne ve abone tipine göre degisen su sinirlari için
        float su_kademe_1;
        float su_kademe_2;
        //Su tüketim tarifesi için
        float konut_kademe_1_birim_fiyati=2.24;
        float konut_kademe_2_birim_fiyati=5.78;
        float konut_kademe_3_birim_fiyati=9.33;
        float is_yeri_kademe_1_birim_fiyati=7.71;
        float is_yeri_kademe_2_birim_fiyati=8.88;
        float kamu_birim_fiyat=6.64;
        float turistik_tesis_birim_fiyati=5.78;
        //Atik su tarifesi için
        float atik_su_konut=1.91;
        float atik_su_is_yeri=3.79;
        float atik_su_kamu_kurumu=2.56;
        float atik_su_turistik_tesisler=1.91;
        //Faturalandirma için
        float toplam_fatura=0;
        float ara_toplam=0;
        float A,B,C;
        float kdv=0;
        float su_tuketim_bedeli=0;
        float atik_su_ucreti=0;
        float su_miktari;
        float su_tuketim_miktari;
        //Günlük ortalama su tüketim miktarlari için
        float gunluk_konut_ortalama_su;
        float gunluk_isyeri_ortalama_su;
        float gunluk_kamu_ortalama_su;
        float gunluk_tesis_ortalama_su;
        //Aylik ortalama su tüketim miktarlari için
        float aylik_konut_ortalama_su;
        float aylik_isyeri_ortalama_su;
        float aylik_kamu_ortalama_su;
        float aylik_tesis_ortalama_su;
        int konut_toplam_su=0;
        int isyeri_toplam_su=0;
        int kamu_toplam_su=0;
        int tesis_toplam_su=0;
        int konut_toplam_gun=0;
        int isyeri_toplam_gun=0;
        int kamu_toplam_gun=0;
        int tesis_toplam_gun=0;
        //Istatistik hesabi için
        float toplam_gelir_kdvden=0;
        float toplam_gelir_sudan=0;
        float toplam_gelir_atik_sudan=0;
        float konut_su_tuketim_bedeli=0;
        float isyeri_su_tuketim_bedeli=0;
        float kamu_su_tuketim_bedeli=0;
        float tesis_su_tuketim_bedeli=0;
        float toplam_su_tuketim_miktari=0;
        int toplam_gun=0;
        //(Su ile ilgili)En büyük ve en küçük değer bulma işlemleri için
        float ortalama_su;
        float gunluk_konut_max_ort_su=0;
        float aylik_max_su_ucreti=0;
        float aylik_max_ucretlinin_su_miktari=0;
        int aylik_max_su_tuketen_abone_tipi;
        //(Atik su ile ilgili)En büyük ve en küçük değer bulma işlemleri için
        float max_atik_su_ucreti=0;
        float max_ucretlinin_su_miktari=0;
        int max_atik_su_uretenin_abone_tipi;
        //yüzde hesabi için
        float yuzde_konut_kademe_1_asmayanlar;
        float yuzde_isyeri_kademe_1_asmayanlar;
        //Her abone tipine göre yüzde hesabi için
        float konut_yuzde;
        float isyeri_yuzde;
        float kamu_yuzde;
        float tesis_yuzde;
        //özel sayac
        int sayac_konut_kademe_1_asilmadi=0;
        int sayac_isyeri_kademe_1_asildi=0;
        //Her abone tipi için sayaç
        int sayac_konut=0;
        int sayac_isyeri=0;
        int sayac_kamu=0;
        int sayac_tesis=0;
        //Toplam abone sayisi için
        int sayac_aboneler=0;

        do {
                sayac=0;
                do {
                        sayac++;
                        if(sayac>1) {
                                printf("***Hatali veri!***\n\nTekrar giriniz\n\n");
                        }
                        printf("Abone tipi kodu:\n?");
                        scanf("%d",&abone_tipi_kodu);
                        switch(abone_tipi_kodu) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                                devam_mi=0;
                                break;
                        default:
                                devam_mi=1;
                        }
                } while(devam_mi);
                sayac=0;
                do {
                        sayac++;
                        if(sayac>1) {
                                printf("***Hatali veri!***\n\nTekrar giriniz\n\n");
                        }
                        printf("Onceki sayac degeri:\n?");
                        scanf("%d",&onceki_sayac_degeri);
                } while(0>onceki_sayac_degeri);
                sayac=0;
                do {
                        sayac++;
                        if(sayac>1) {
                                printf("***Hatali veri!***\n\nTekrar giriniz\n\n");
                        }
                        printf("Simdiki sayac degeri:\n?");
                        scanf("%d",&simdiki_sayac_degeri);
                } while(onceki_sayac_degeri>simdiki_sayac_degeri);
                sayac=0;
                do {
                        sayac++;
                        if(sayac>1) {
                                printf("***Hatali veri!***\n\nTekrar giriniz\n\n");
                        }
                        printf("Onceki ve simdiki sayac okuma\ntarihleri arasinda gecen gun farki:\n?");
                        scanf("%d",&sayac_okunali_kac_gun_oldu);
                } while(1>sayac_okunali_kac_gun_oldu);
                su_miktari=su_tuketim_miktari=(float)simdiki_sayac_degeri-onceki_sayac_degeri;
                switch(abone_tipi_kodu) {
                case 1://Konutsa
                        ortalama_su=(float)su_tuketim_miktari/sayac_okunali_kac_gun_oldu;
                        if(gunluk_konut_max_ort_su<ortalama_su) {
                                gunluk_konut_max_ort_su=ortalama_su;
                        }
                        sayac_konut++;
                        konut_toplam_su+=su_tuketim_miktari;
                        konut_toplam_gun+=sayac_okunali_kac_gun_oldu;

                        su_kademe_1=(float)su_kademe_1_konut*sayac_okunali_kac_gun_oldu/30;
                        su_kademe_2=(float)su_kademe_2_konut*sayac_okunali_kac_gun_oldu/30;

                        atik_su_ucreti=(float)atik_su_konut*su_tuketim_miktari;
                        if(su_kademe_1<su_miktari) {
                                su_miktari-=(float)su_kademe_1;
                                A=(float)su_kademe_1*konut_kademe_1_birim_fiyati;
                                if(su_kademe_2<su_miktari) {
                                        su_miktari-=(float)su_kademe_2;
                                        B=(float)su_kademe_2*konut_kademe_2_birim_fiyati;
                                        if(0<su_miktari) {
                                                C=(float)su_miktari*konut_kademe_3_birim_fiyati;
                                        } else {
                                                C=0;
                                        }
                                } else {
                                        B=(float)su_miktari*konut_kademe_2_birim_fiyati;
                                        C=0;
                                }
                        } else {
                                sayac_konut_kademe_1_asilmadi++;
                                A=(float)su_miktari*konut_kademe_1_birim_fiyati;
                                B=0;
                                C=0;
                        }
                        konut_su_tuketim_bedeli+=su_tuketim_bedeli=A+B+C;
                        break;
                case 2://Isyeriyse
                        sayac_isyeri++;
                        isyeri_toplam_su+=su_tuketim_miktari;
                        isyeri_toplam_gun+=sayac_okunali_kac_gun_oldu;

                        su_kademe_1=(float)su_kademe_1_is_yeri*sayac_okunali_kac_gun_oldu/30;
                        su_kademe_2=(float)su_kademe_2_is_yeri*sayac_okunali_kac_gun_oldu/30;

                        atik_su_ucreti=(float)su_tuketim_miktari*atik_su_is_yeri;
                        if(su_kademe_1<su_miktari) {
                                su_miktari-=(float)su_kademe_1;
                                A=(float)su_kademe_1*is_yeri_kademe_1_birim_fiyati;
                                if(su_kademe_2<su_miktari) {
                                        sayac_isyeri_kademe_1_asildi++;
                                        B=(float)su_miktari*is_yeri_kademe_2_birim_fiyati;
                                }
                        } else {
                                A=(float)su_miktari*is_yeri_kademe_1_birim_fiyati;
                                B=0;
                        }
                        isyeri_su_tuketim_bedeli+=su_tuketim_bedeli=A+B;
                        break;
                case 3://Kamu kurumuysa
                        sayac_kamu++;
                        kamu_toplam_su+=su_tuketim_miktari;
                        kamu_toplam_gun+=sayac_okunali_kac_gun_oldu;
                        kamu_su_tuketim_bedeli+=su_tuketim_bedeli=(float)su_tuketim_miktari*kamu_birim_fiyat;
                        atik_su_ucreti=(float)su_tuketim_miktari*atik_su_kamu_kurumu;
                        break;
                case 4://Turistik Tesisse
                        sayac_tesis++;
                        tesis_toplam_su+=su_tuketim_miktari;
                        tesis_toplam_gun+=sayac_okunali_kac_gun_oldu;
                        tesis_su_tuketim_bedeli+=su_tuketim_bedeli=(float)su_tuketim_miktari*turistik_tesis_birim_fiyati;
                        atik_su_ucreti=(float)su_tuketim_miktari*atik_su_turistik_tesisler;
                        break;
                }
                if(aylik_max_su_ucreti<su_tuketim_bedeli) {
                        aylik_max_su_ucreti=su_tuketim_bedeli;
                        aylik_max_su_tuketen_abone_tipi=abone_tipi_kodu;
                        aylik_max_ucretlinin_su_miktari=su_tuketim_miktari;
                }
                if(max_atik_su_ucreti<atik_su_ucreti) {
                        max_atik_su_ucreti=atik_su_ucreti;
                        max_atik_su_uretenin_abone_tipi=abone_tipi_kodu;
                        max_ucretlinin_su_miktari=su_tuketim_miktari;
                }
                printf("Abone Tipi :");

                switch(abone_tipi_kodu) {
                case 1:
                        printf("Konut\n");
                        break;
                case 2:
                        printf("Isyeri\n");
                        break;
                case 3:
                        printf("Kamu Kurumu\n");
                        break;
                case 4:
                        printf("Turistik Tesis\n");
                        break;
                }
                printf("Su tuketim miktari: %07.2f\n",su_tuketim_miktari);
                printf("Su tuketim bedeli : %07.2f\n",su_tuketim_bedeli);
                printf("Atik su ucreti    : %07.2f\n",atik_su_ucreti);
                toplam_gelir_atik_sudan+=atik_su_ucreti;
                ara_toplam=(float)su_tuketim_bedeli+atik_su_ucreti;
                toplam_gelir_kdvden+=kdv=(float)ara_toplam*8/100;
                printf("KDV ucreti        : %07.2f\n",kdv);
                toplam_fatura=(float)ara_toplam+kdv;
                printf("Toplam fatura     : %07.2f\n",toplam_fatura);
                do {
                        printf("Baska abone var mi\n?");
                        fflush(stdin);
                        scanf("%c",&var_mi);
                        switch(var_mi) {
                        case 'e':
                        case 'E':
                                devam_mi=1;
                                break;
                        case 'h':
                        case 'H':
                                devam_mi=0;
                                break;
                        default:
                                devam_mi=2;
                        }
                } while(devam_mi==2);
        } while(var_mi=='e'||var_mi=='E');

        toplam_gun=konut_toplam_gun+isyeri_toplam_gun+kamu_toplam_gun+tesis_toplam_gun;
        toplam_su_tuketim_miktari=(float)konut_toplam_su+isyeri_toplam_su+kamu_toplam_su+tesis_toplam_su;
        //Kademe 1 i aşıp aşmama durumu için yüzde hesabı
        yuzde_konut_kademe_1_asmayanlar=(float)sayac_konut_kademe_1_asilmadi*100/sayac_konut;
        yuzde_isyeri_kademe_1_asmayanlar=(float)sayac_isyeri_kademe_1_asildi*100/sayac_isyeri;
        //Her abone tipi için abone sayılarına göre yuzdeleri
        sayac_aboneler=sayac_konut+sayac_isyeri+sayac_kamu+sayac_tesis;
        konut_yuzde=(float)sayac_konut*100/sayac_aboneler;
        isyeri_yuzde=(float)sayac_isyeri*100/sayac_aboneler;
        kamu_yuzde=(float)sayac_kamu*100/sayac_aboneler;
        tesis_yuzde=(float)sayac_tesis*100/sayac_aboneler;
        //Her abone tipi için günlük ortalama su miktarı
        gunluk_konut_ortalama_su=(float)konut_toplam_su/konut_toplam_gun;
        gunluk_isyeri_ortalama_su=(float)isyeri_toplam_su/isyeri_toplam_gun;
        gunluk_kamu_ortalama_su=(float)kamu_toplam_su/kamu_toplam_gun;
        gunluk_tesis_ortalama_su=(float)tesis_toplam_su/tesis_toplam_gun;
        //Her abone tipi için aylik ortalama su miktarı
        aylik_konut_ortalama_su=(float)gunluk_konut_ortalama_su*30;
        aylik_isyeri_ortalama_su=(float)gunluk_isyeri_ortalama_su*30;
        aylik_kamu_ortalama_su=(float)gunluk_kamu_ortalama_su*30;
        aylik_tesis_ortalama_su=(float)gunluk_tesis_ortalama_su*30;
        //Istatistikler listeleniyor
        //1)
        printf("Abone Tipi     Abone Sayisi Yuzdesi Gunluk Ortalama Su Tuketim Miktari\n");
        printf("Konut          %-12d %06.2f  %06.2f ton\n",sayac_konut,konut_yuzde,gunluk_konut_ortalama_su);
        printf("Isyeri         %-12d %06.2f  %06.2f ton\n",sayac_isyeri,isyeri_yuzde,gunluk_isyeri_ortalama_su);
        printf("Kamu Kurumu    %-12d %06.2f  %06.2f ton\n",sayac_kamu,kamu_yuzde,gunluk_kamu_ortalama_su);
        printf("Turistik Tesis %-12d %06.2f  %06.2f ton\n\n",sayac_tesis,tesis_yuzde,gunluk_tesis_ortalama_su);
        //2)
        printf("Aylik su tuketim miktari 1. kademeyi asmayan konut abonelerinin\n");
        printf("Sayisi: %d Yuzdesi: %.2f\n\n",sayac_konut_kademe_1_asilmadi,yuzde_konut_kademe_1_asmayanlar);
        //3)
        printf("Aylik su tuketim miktari 1. kademeyi asan isyeri abonelerinin\n");
        printf("Sayisi: %d Yuzdesi: %.2f\n\n",sayac_isyeri_kademe_1_asildi,yuzde_isyeri_kademe_1_asmayanlar);
        //4)
        printf("Gunluk ortalama su tuketim miktari en yuksek olan\nKonut tipi abonenin\n");
        //5)
        printf("Gunluk ortalama su tuketim miktari: %.2f\n\n",gunluk_konut_max_ort_su);
        //Su ile ilgili
        printf("Abone tipi:");
        switch(aylik_max_su_tuketen_abone_tipi) {
        case 1:
                printf("Konut\n");
                break;
        case 2:
                printf("Isyeri\n");
                break;
        case 3:
                printf("Kamu Kurumu\n");
                break;
        case 4:
                printf("Turistik Tesis\n");
                break;
        }
        printf("Aylik su tuketim miktari: %.2f\n",aylik_max_ucretlinin_su_miktari);
        printf("Odedigi aylik su tuketim ucreti: %.2f\n",aylik_max_su_ucreti);
        //6)
        printf("Aylik atik su ucreti en yuksek olan abonenin\n");
        printf("Abone tipi:");
        switch(max_atik_su_uretenin_abone_tipi) {
        case 1:
                printf("Konut\n");
                break;
        case 2:
                printf("Isyeri\n");
                break;
        case 3:
                printf("Kamu Kurumu\n");
                break;
        case 4:
                printf("Turistik Tesis\n");
                break;
        }
        //Atik su ile ilgili
        printf("Aylik su tuketim miktari: %.2f\n",max_ucretlinin_su_miktari);//(Uygun degisken adi verilemedi)Aylik atik su ucreti en yuksek olan abonenin
        printf("Odedigi aylik atik su ucreti: %.2f\n\n",max_atik_su_ucreti);
        //7)
        printf("Abone Tipi     Toplam Su Tuketim Miktari\n");
        printf("Konut          %5d ton\n",konut_toplam_su);
        printf("Isyeri         %5d ton\n",isyeri_toplam_su);
        printf("Kamu Kurumu    %5d ton\n",kamu_toplam_su);
        printf("Turistik Tesis %5d ton\n\n",tesis_toplam_su);
        //Toplam su tüketim miktari
        printf("Toplam         %5.0f ton\n\n",toplam_su_tuketim_miktari);
        //8)
        //Her abone tipi icin elde edilen aylik toplam su tuketim ucretleri
        printf("Abone Tipi     Toplam Su Tuketim Ucreti\n");
        printf("Konut          %7.2f TL\n",konut_su_tuketim_bedeli);
        printf("Isyeri         %7.2f TL\n",isyeri_su_tuketim_bedeli);
        printf("Kamu Kurumu    %7.2f TL\n",kamu_su_tuketim_bedeli);
        printf("Turistik Tesis %7.2f TL\n\n",tesis_su_tuketim_bedeli);
        //Aylik toplam su tuketim ucreti
        toplam_gelir_sudan=konut_su_tuketim_bedeli+isyeri_su_tuketim_bedeli+kamu_su_tuketim_bedeli+tesis_su_tuketim_bedeli;
        printf("Toplam         %7.2f TL\n\n",toplam_gelir_sudan);
        //9)
        //Aylik toplam atik sudan elde edilen gelir
        printf("Tum abonelerden elde edilen aylik toplam atik su ucreti: %.2f\n\n",toplam_gelir_atik_sudan);
        //10)
        //Toplam gelir KDV'den
        printf("Devlete odenen aylik toplam KDV tutari: %7.2f\n\n",toplam_gelir_kdvden);
        //Programın hemen kapanmamasi için
        fflush(stdin);//yeni bir karakterin okunmasi icin
        getchar();
        fflush(stdin);
        getchar();
        fflush(stdin);
        getchar();
        return 0;
}
