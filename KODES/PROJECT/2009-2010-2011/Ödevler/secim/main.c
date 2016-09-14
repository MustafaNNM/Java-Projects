#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

#define SATIR 8
#define BOYUT 4

void oku(FILE *fptr,int *d);
void beklet(int tur);
int maximum_bul(int boyut,int deger[][boyut],int sutun);
void ad_ayarla(int boyut,int deger[][boyut],int sutun);
void sirala(int boyut,int deger[][boyut]);
void degistir(int *a,int *b);

int main()
{
    FILE *cfptr;
    int parti_il[SATIR][BOYUT]= {{0}}; //8 satır ve 4 sütundan oluşmaktadır // Hesaplama gereği tüm elemanları sıfırlanmıştır
    //8 satır herbir parti için bilgiler içermektedir
    //#1.sütun Herhangi bir il için partilerin toplam oy miktarları
    //2. kopyasının oluşturulma nedeni:ilki heseplama gereği kontenjana bağlı olarak 2 ye bölünmüştür
    //#2.sütun Herhangi bir il için partilerin toplam millet vekillleri miktarları
    //#3.sütun Herhangi bir il için partilerin toplam oy miktarları
    //#4.sütun Parti adlarını sıralı yazdırmak için kullanılmıştır
    int parti_genel[SATIR][BOYUT]= {{0}}; //8 satır ve 4 sütundan oluşmaktadır // Hesaplama gereği tüm elemanları sıfırlanmıştır
    //8 satır herbir parti için bilgiler içermektedir
    //#1.sütun Türkiye geneli için partilerin toplam oy miktarları
    //#2.sütun Türkiye geneli için partilerin toplam millet vekilleri miktarları
    //#3.sütun Partilerin birinci olarak çıktıkları illerin sayısı
    //#4.sütun Partilerin millet vekili çıkartamadıkları illerin sayısı
    int parti_adi[SATIR]={65,66,67,68,69,70,71,72};//Parti adlarını yazdırmak için kullanılmıştır
    int i,max;//i:sayaç olarak kullanılmıştır
    int il_plaka_no,kontenjan,toplam_milletvekili=0,toplam_gecerli_oy=0,gecerli_oy=0;
    char *dosya_adi[2]= {"secim.txt"},*amac= {"r"};
    if ((cfptr=fopen(dosya_adi[0],amac))==NULL)
    {
        printf("Dosya acilamadi!\n");//Dosya açılamadığında ekrana mesaj gönderiliyor
    }
    //Dosya açılırsa diğer işlemler yapılmaktadır
    else
    {
        //Dosyadan sayılar okunmaktadır
        oku(cfptr,&il_plaka_no);oku(cfptr,&kontenjan);
        for(i=0; i<SATIR; ++i){oku(cfptr,&parti_il[i][0]);}
        while (!feof(cfptr))
        {
            toplam_milletvekili+=kontenjan;//Türkiyedeki millet vekili kontenjanları hesaplanıyor
            for (i=0; i<SATIR; ++i)
            {
                parti_genel[i][0]+=parti_il[i][2]=parti_il[i][0];//0:oy miktarları 1:millet vekilleri sayıları için 2:oy miktarları
                gecerli_oy+=parti_il[i][0];//İl genelindeki geçerli oy miktarları hesaplanıyor
            }
            toplam_gecerli_oy+=gecerli_oy;//Türkiye genelindeki geçerli oy miktarları hesaplanıyor
            printf("Il Plaka Kodu:%d\n",il_plaka_no);
            printf("Milletvekili Kontenjani:%d\n",kontenjan);
            printf("Gecerli Oy Sayisi:%d\n",gecerli_oy);
            printf("            Oy Say Oy Yuzde MV Say\n");
            printf("            ------ -------- ------\n");
            for(i=1; i<=kontenjan; ++i)
            {
                max=maximum_bul(BOYUT,parti_il,0);//En Fazla oyu alan parti bulunuyor
                ++parti_il[max][1];//En fazla oy alan partinin millet vekili sayısı 1 artırılıyor
                parti_il[max][0]/=2;//En fazla oy alan partinin oy miktarı yarıya indiriliyor
            }
            max=maximum_bul(BOYUT,parti_il,1);//En fazla oy alan parti aranıyor
            ++parti_genel[max][2];//Partilerin illerden birinci olarak çıktıkları illerin sayısı
            for(i=0; i<SATIR; ++i)
            {
                parti_genel[i][1]+=parti_il[i][1];//Herbir partinin Türkiye geneli millet vekilleri sayıları hesaplanıyor
                if(0==parti_il[i][1])
                {
                    ++parti_genel[i][3];//Parti millet vekili çıkartamamışsa yenilgi olarak sayılır
                }
            }
            ad_ayarla(BOYUT,parti_il,3);
            for(i=0; i<SATIR; ++i)
            {
                sirala(BOYUT,parti_il);
                //Dosyadan bilgileri okunan ille ilgili istatistik bilgileri yazdırılıyor
                printf("%c Partisi%9d %8.2f%7d\n",parti_il[i][3],parti_il[i][2],(float)parti_il[i][2]*100/gecerli_oy,parti_il[i][1]);
                parti_il[i][0]=parti_il[i][1]=0;//Tekrar eden işlemler için bilgiler sıfırlanıyor
            }
            gecerli_oy=0;//Tekrar eden işlemler için bilgiler sıfırlanıyor
            printf("\nDevam etmek icin bir tusa basiniz...\n");
            beklet(1);//Kullanıcıdan belirtilen miktar kadar karakter girmesi bekleniyor
            //Dosyadan sayılar okunmaktadır.Eğer dosya sonuna gelinmişse döngüden çıkılıyor
            oku(cfptr,&il_plaka_no);oku(cfptr,&kontenjan);
            for(i=0; i<SATIR; ++i)
            {
                oku(cfptr,&parti_il[i][0]);
            }
        }
        //Türkiye geneli istatistik bilgileri yazdırılıyor
        printf("Turkiye Geneli\nMilletvekili Kontenjani:%d\nGecerli Oy Sayisi:%d\n",toplam_milletvekili,toplam_gecerli_oy);
        printf("            Oy Say Oy Yuzde MV Say MV Yuzde Il 1.lik Say 0 MV Il Say\n");
        printf("            ------ -------- ------ -------- ------------ -----------\n");
        for (i=0; i<SATIR; ++i)
        {
            printf("%c Partisi%8d%8.2f%7d%9.2f%10d%12d\n",parti_adi[i],parti_genel[i][0],(float)parti_genel[i][0]*100/toplam_gecerli_oy,parti_genel[i][1],(float)parti_genel[i][1]*100/toplam_milletvekili,parti_genel[i][2],parti_genel[i][3]);
        }
        printf("\n");
        max=maximum_bul(BOYUT,parti_genel,1);
        printf("Iktidar Partisi: %c Partisi\n",parti_adi[max]);
        parti_genel[max][1]=0;
        max=maximum_bul(BOYUT,parti_genel,1);
        printf("Ana Muhalefet Partisi: %c Partisi\n",parti_adi[max]);
    }
    fclose(cfptr);
    beklet(3);//Kullanıcının bilgileri okumasına fırsat vermek için programın kapatılması karakter girilmesini gerektiriyor
    return 0;
}
void oku(FILE *fptr,int *d){fscanf(fptr,"%d",d);}//Dosyadan sayılar okunmaktadır.
void beklet(int tur)//Yazılanların okunması için program durdurucu
{
    int i;
    for(i=0; i<tur; ++i){getch();}
}
int maximum_bul(int boyut,int deger[][boyut],int sutun)//verilen vektördeki en büyük elemanı buluyor
{
    int i,max[2]= {0}; //0:maximum miktar 1:maksimum miktara ait adres
    //Sekiz farklı değer karşılaştırılmaya tabii tutulup
    //maximum değere bağlı olarak
    //fonksiyon geriye maximum değerin sıra nosunu dönderiyor
    for (i=0;i<SATIR; ++i)
    {
        if (max[0]<deger[i][sutun])
        {
            max[0]=deger[i][sutun];//Büyüklük karşılaştırılması yapılıyor
            max[1]=i;
        }
    }
    return max[1];
}
void ad_ayarla(int boyut,int deger[][boyut],int sutun)
{
    int i,sayi=65;
    //vektöre A-H arası sayısal değerler veriliyor(ASCII)
    for(i=0; i<SATIR; ++i){deger[i][sutun]=sayi;++sayi;}
}
void sirala(int boyut,int deger[][boyut])
{
    int tur,karsilastirma;

    for (tur=0; tur<SATIR-1; ++tur)//eleman sayısı-1
    {
        for (karsilastirma=SATIR-2; karsilastirma>=0; --karsilastirma)
            //karşılaştırma yapılırken aşağıdan yukarı dogru yapılıyor
            //n:eleman sayısı dersek n-1 karşılaştırma vardır.
        {
            if (deger[karsilastirma][2]<deger[karsilastirma+1][2])//Oy miktarına göre partiler sıralanıyor
            {
                //oy miktarlarının yerleri değişiyor
                degistir(&deger[karsilastirma][2],&deger[karsilastirma+1][2]);
                //millet vekilleri sayılarının yerleri değişiyor
                degistir(&deger[karsilastirma][1],&deger[karsilastirma+1][1]);
                //parti adlarının yerleri değişiyor
                degistir(&deger[karsilastirma][3],&deger[karsilastirma+1][3]);
            }
        }
        //n-1 tur vardır.
    }
}
void degistir(int *a,int *b)//iki sayıyı birbirine atamak için kullanıldı
{
    int tut;
    //verilen iki sayının yerleri değişiyor
    tut=*a;
    *a=*b;
    *b=tut;
}
