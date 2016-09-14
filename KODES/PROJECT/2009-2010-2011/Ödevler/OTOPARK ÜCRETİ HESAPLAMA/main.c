#include <stdio.h>
#include <stdlib.h>

int main()
{
    char max,arac_turu,devam;
    //   max : rekor ücret için değişken b,o veya t değerlini alıyor
    //   arac_turu : Otoparka gelen aracın türü
    //   devam : Başka araç bilgisinin eklenip eklenmeyeceğine dair değişken
    float normal_ucret,odenecek_ucret,agirlik,ortalama_gelir,arac_sayisi;
    //   normal_ucret : Araç türüne göre normalin 2 ya da 3 katı ücret ödeniyor
    //   agirlik:Otoparka gelen aracın kg cinsinden ağırlığı
    //   ortalama_gelir:Araç tipine göre gelirin araç sayısına oranı
    float dakika;//park süresinin gün saat dakika cinsinden eş değerleri
    int gun,saat;//fakat 20 dakika ve üzeri artı bir saat olarak kabul ediliyor
    int i,park_suresi,zaman,toplam_arac_sayisi,toplam_gelir;
    //i:sayac,park_suresi:dakika cinsinden
    int b_tipi_arac_sayisi=0,o_tipi_arac_sayisi=0,t_tipi_arac_sayisi=0;//Herbir araç tipi için sayaç
    int b_tipi_toplam_gelir=0,o_tipi_toplam_gelir=0,t_tipi_toplam_gelir=0;//Herbir araç tipi için gelir miktarı
    int b_tipi_park_suresi=0,o_tipi_park_suresi=0,t_tipi_park_suresi=0;//Herbir araç tipi için park süresi
    int b_tipi_max_park_suresi=0,o_tipi_max_park_suresi=0,t_tipi_max_park_suresi=0;//Herbir araç tipi için maximum park süresi
    int b_tipi_max_gelir=0,o_tipi_max_gelir=0,t_tipi_max_gelir=0;//Herbir araç tipi için maximum gelir miktarı
    int o_tipi_min_park_suresi=0,o_tipi_min_gelir=0;//Otobüs için minimum park süresi ve gelir değişkenleri
    int rekor_ucret,agir_arac=0,kontrol_degiskeni;//rekor_ucret:En çok ücret ödeyen aracın ödediği ücret
    //agir_arac:Ağırlığı 10 tondan büyük tırlar için sayaç
    //kontrol_degiskeni:Hata mesajı yazdırmanın kontrolü için

    do
    {
        kontrol_degiskeni=1;//Kontrol değişkeni 1 ise ekrana hata mesajı yazdırılmıyor
        do
        {
            if(0 == kontrol_degiskeni)
            {
                printf("Hatali girdiniz\n");
            }
            printf("Arac turunu giriniz:{[b/B]/[o/O]/[t/T]}\n?");
            fflush(stdin);
            arac_turu=getchar();
            kontrol_degiskeni=0;//Kontrol değişkeni 0 ise ekrana hata mesajı yazdırılıyor
        }
        while('b' != arac_turu && 'B' != arac_turu && 'o' != arac_turu && 'O' != arac_turu && 't' != arac_turu && 'T' != arac_turu);
        //Kullanıcı doğru karakterlerden birini girinceye kadar döngü sürüyor
        do
        {
            printf("Aracin agirligini kg cinsinden giriniz:\n?");
            scanf("%f",&agirlik);
        }
        while(0 >= agirlik);
        //Ağırlık 0'dan büyük olana dek döngü çalışıyor
        do
        {
            printf("Aracin otoparkta kalis suresini dakika cinsinden giriniz:\n?");
            scanf("%d",&park_suresi);
        }
        while(0 >= park_suresi);
        //Park süresi 0'dan büyük olana dek döngü çalışıyor
        zaman=park_suresi;
        dakika=zaman%60;
        saat=zaman/60;
        gun=saat/24;
        saat-=gun*24;
        printf("Bu %c tipi arac otoparkta %d gun %d saat %02.2f dakika kalmistir\n",arac_turu,gun,saat,dakika);
        if(20 < dakika)
        {
            ++saat;    //20 üzeri 1 saat olarak kabul ediliyor
        }
        normal_ucret=(5+20*gun+saat);
        switch(arac_turu)
        {
        case 'b':
        case 'B':
            b_tipi_toplam_gelir+=odenecek_ucret=normal_ucret;
            ++b_tipi_arac_sayisi;
            b_tipi_park_suresi+=park_suresi;
            if(b_tipi_max_park_suresi<park_suresi)
            {
                b_tipi_max_gelir=odenecek_ucret;
                b_tipi_max_park_suresi=park_suresi;
            }
            break;
        case 'o':
        case 'O':
            o_tipi_toplam_gelir+=odenecek_ucret=2*normal_ucret;
            ++o_tipi_arac_sayisi;
            o_tipi_park_suresi+=park_suresi;
            if(o_tipi_max_park_suresi < park_suresi)
            //maximum değerden daha büyük bir değerle karşılaşırsa
            {
                o_tipi_max_gelir=odenecek_ucret;
                o_tipi_max_park_suresi=park_suresi;
            }
            if(o_tipi_min_park_suresi > park_suresi || o_tipi_min_gelir == 0)
            //minimum değerden daha küçük bir değerle karşılaşırsa
            {
                o_tipi_min_gelir=odenecek_ucret;
                o_tipi_min_park_suresi=park_suresi;
            }
            break;
        default:
            t_tipi_toplam_gelir+=odenecek_ucret=3*normal_ucret;
            ++t_tipi_arac_sayisi;
            t_tipi_park_suresi+=park_suresi;
            if(10000 < agirlik)
            {
                ++agir_arac;
            }
            if(t_tipi_max_park_suresi<park_suresi)
            {
                t_tipi_max_gelir=odenecek_ucret;
                t_tipi_max_park_suresi=park_suresi;
            }
        }
        printf("Odemesi gereken ucret: %.2f TL dir.\n",odenecek_ucret);
        kontrol_degiskeni=1;
        do
        {
            if(0 == kontrol_degiskeni)
            {
                printf("Hatali girdiniz\n");
            }
            printf("Baska bir arac eklemek istermisiniz:{[e/E]/[h/H]}\n?");
            fflush(stdin);
            devam=getchar();
            kontrol_degiskeni=0;
        }
        while('e' != devam && 'E' != devam && 'h' != devam && 'H' != devam);
        //Giriş kontrolü yapılıyor
    }
    while('e' == devam || 'E' == devam);
    //Kullanıcı yeni bir araç bilgisi eklemek isterse döngü devam ediyor
    toplam_arac_sayisi=b_tipi_arac_sayisi+o_tipi_arac_sayisi+t_tipi_arac_sayisi;
    toplam_gelir=b_tipi_toplam_gelir+o_tipi_toplam_gelir+t_tipi_toplam_gelir;
    printf("\nTum araclardan elde edilen toplam gelir: %d TL dir.\n\n",toplam_gelir);
    for(i=1; i<=3; ++i)
    {
        switch(i)
        {
        case 1:
        case 2://for döngüsünden sadece iki defa yararlanmak için
            switch(i)
            {
                //araç türlerine göre değişken değerleri belirleniyor
            case 1:
                arac_turu='B';
                zaman=b_tipi_max_park_suresi;
                odenecek_ucret=b_tipi_max_gelir;
                break;
            default:
                arac_turu='O';
                zaman=o_tipi_max_park_suresi;
                odenecek_ucret=o_tipi_min_gelir;
            }
            dakika=zaman%60;
            saat=zaman/60;
            gun=saat/24;
            saat-=gun*24;
            printf("En %s\notoparkta kalan %c tipi aracin kalis suresi : %d gun %02d saat %02.2f dakika\nodedigi ucret: %.2f TL dir.\n",(i==1)?"uzun":"kisa",arac_turu,gun,saat,dakika,odenecek_ucret);
            break;
        }
        switch(i)
        {
            //araç türlerine göre değişken değerleri belirleniyor
        case 1:
            arac_sayisi=b_tipi_arac_sayisi;
            arac_turu='B';
            zaman=b_tipi_park_suresi;
            toplam_gelir=b_tipi_toplam_gelir;
            break;
        case 2:
            arac_sayisi=o_tipi_arac_sayisi;
            arac_turu='O';
            zaman=o_tipi_park_suresi;
            toplam_gelir=o_tipi_toplam_gelir;
            break;
        default:
            arac_sayisi=t_tipi_arac_sayisi;
            arac_turu='T';
            zaman=t_tipi_park_suresi;
            toplam_gelir=t_tipi_toplam_gelir;
            break;
        }
        printf("%c tipi arac sayisi :      %.0f   yuzdesi :      %%%.2f\n%c tipi araclardan elde edilen gelir miktari: %d TL dir.\n",arac_turu,arac_sayisi,(float)(100*arac_sayisi/toplam_arac_sayisi),arac_turu,toplam_gelir);
        if(0 == zaman)
        {
            dakika=saat=gun=0;
        }
        else
        {
            dakika=((zaman%60)/arac_sayisi);
            saat=(zaman/arac_sayisi)/60;
            gun=saat/24;
            saat-=gun*24;
        }
        if(0 == arac_sayisi)
        {
            ortalama_gelir=0;
        }
        else
        {
            ortalama_gelir=(float)(toplam_gelir/arac_sayisi);
        }
        printf("%c tipi araclarin ortalama park suresi :      %d gun %d saat %.2f dakika dir.\n%c tipi araclardan elde edilen ortalama gelir:%.2f TL dir.\n\n",arac_turu,gun,saat,dakika,arac_turu,ortalama_gelir);
    }
    printf("Agirligi 10 tondan fazla olan T tipi araclarin sayisi: %d\n\n",agir_arac);
    if(b_tipi_max_gelir>o_tipi_max_gelir && b_tipi_max_gelir>t_tipi_max_gelir)
    {
        max='B';
        rekor_ucret=b_tipi_max_gelir;
    }
    else if(o_tipi_max_gelir>t_tipi_max_gelir)
    {
        max='O';
        rekor_ucret = o_tipi_max_gelir;
    }
    else
    {
        max = 'T';
        rekor_ucret=t_tipi_max_gelir;
    }
    printf("En cok ucret odeyen aracin tipi: %c ve odedigi ucret: %d\n",max,rekor_ucret);
    getchar();
    return 0;
}
