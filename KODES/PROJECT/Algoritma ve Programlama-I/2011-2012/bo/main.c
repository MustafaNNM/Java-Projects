#include <stdio.h>
#include <stdlib.h>

int main()
{
    int ogrenciNo=0,control=0,dersSay=0,i=0,krediSay=0,topKrediSay=0,dersNotu=0,topDersNotu=0,agirlik=0,top_agirlik=0;
    int genelKrediTop=0,max3ders=0,min60=0,notOrt35=0,notOrt85=0,bursBuyuk300=0;
    int okulBirincisiNo=0,okulBirincisiTopKrediSay=0,maxBursOgrenciNo=0,maxBursKrediTop=0;
    int basariliKizSay=0,basariliErkekSay=0,basariliOgrenciSay=0,basarisizOgrenciSay=0,ogrenciSay=0,erkekSay=0,kizSay=0;
    int evdeKalanSay=0,yurttaKalanSay=0,aileKalanSay=0;
    int yurtBasariliSay=0,aileBasariliSay=0,evBasariliSay=0,basarisizKizSay=0,basarisizErkekSay=0;

    float not_ort=0,burs=0,kizBasariYuzde=0,erkekBasariYuzde=0,genelBasariYuzde=0,kizNotTop=0,erkekNotTop=0,kizNotOrt=0,erkekNotOrt=0;
    float genelNotOrt=0,genelKrediOrt=0,min60yuzde=0,notOrt35yuzde=0,notOrt85yuzde=0,maxNotOrt=0;
    float okulBirincisiNotOrt=0,maxBurs=0;
    float okulBirincisiBurs=0,maxBursNotOrt=0,topBursMiktari=0;
    float aileBasariYuzde=0,yurtBasariYuzde=0,evBasariYuzde=0;



    char cinsiyet;
    char ikamet;




    do   // do-while döngü yapisinin baslangici.
    {

        printf("\nOgrenci numarasini giriniz(cikis icin 0 ya da negatif sayi girin):");
        scanf("%d",&ogrenciNo);


        if(ogrenciNo<=0)  // buradaki if yapisi, do while döngü yapisinin en az 1 kere çalismasini engellemek için kullanilmistir.
        {

            break;
        }

        printf("\nCinsiyetini giriniz(E/e:erkek, K/k:kiz):");
        scanf(" %c",&cinsiyet);



        while(cinsiyet!='e' && cinsiyet!='E' && cinsiyet!='k' && cinsiyet!='K')  // cinsiyet için hata kontrolü...
        {

            printf("\nHatali giris yaptiniz.Lutfen cinsiyeti tekrar giriniz(E/e:erkek, K/k:kiz):");
            scanf(" %c",&cinsiyet);
            fflush(stdin);   // tampon bellegin temizlenmesi için kullanilmistir.
        }


        printf("\nikamet yerini giriniz(A/a:ailesiyle, Y/y:yurtta, E/e:evde):");
        scanf(" %c",&ikamet);
        fflush(stdin);


        while(ikamet!='a' && ikamet!='A' && ikamet!='y' && ikamet!='Y' && ikamet!='e' && ikamet!='E') // cinsiyet icin hata kontrolü..
        {

            printf("\nHatali giris yaptiniz.\nLutfen ikamet yerini giriniz(A/a:ailesiyle, Y/y:yurtta, E/e:evde):");
            scanf("%s",&ikamet);

        }

        printf("\nBu donem aldiginiz ders sayisini girin(1-10):");
        scanf("%d",&dersSay) ;


        while(dersSay<1 || dersSay>10) // while döngü yapisi ile ders sayisinin 1 ile 10 arasinda olmasi saglanir..
        {

            printf("\nHatali giris yaptiniz.\nLutfen ders sayisini belirtilen aralikta girin(1-10):");
            scanf("%d",&dersSay);

        }



        for(i=1; i<=dersSay; i++) // burdaki for yapisi; her dersin ayri ayri kredilerini alabilmek icin kullanilmistir..
        {

            printf("\nDersin kredisini girin(1-10):");
            scanf("%d",&krediSay);

            while(krediSay<1 || krediSay>10) // kredi sayisi hata kontrolü..
            {

                printf("\nHatali giris yaptiniz.\nLutfen kredi sayisini tekrar girin(1-10):");
                scanf("%d",&krediSay);
            }

            topKrediSay+=krediSay;    // Ogrencinin toplam kredi sayisi bulunur..


            printf("\nDers notunu girin(1-100):");
            scanf("%d",&dersNotu);

            while(dersNotu<1 || dersNotu>100)  // ders notu hata kontrolü...
            {

                printf("\nHatali giris yaptiniz.\nLutfen ders notunu tekrar giriniz(1-100):");
                scanf("%d",&dersNotu);

            }
            if(dersNotu<60)  // ogrencinin 60 dan kücük notunun olup olmamasinin belirlenmesi..
            {

                control=1;

            }



            topDersNotu+=dersNotu;

            agirlik=krediSay*dersNotu;
            top_agirlik+=agirlik;  // toplam agirligi ders sayisina böldügümüzde not ortalamasina erisecegiz..

        }
        genelKrediTop+=topKrediSay;  // bilgileri alinan ögrencinin ders kredileri toplaminin bütün ögrencilerin kredileri toplamina eklenmesi..
        not_ort=(float)top_agirlik/(float)topKrediSay; //float kullanimi tip uyusmazligini engellemek icin kullanilis..




        if(cinsiyet=='e' || cinsiyet=='E')
        {

            erkekNotTop=erkekNotTop+not_ort; //erkeklerin kendi icindeki not ortalamasina erismek icin...
            erkekSay++;

        }
        else if(cinsiyet=='k' || cinsiyet=='K')
        {

            kizNotTop=kizNotTop+not_ort;  // kizlarin kendi icinde not ortalamasina erismek icin...
            kizSay++;

        }

        // ogrencinin not ortalamasina göre alacagi bursun belirlenmesi ve basarili olup olmadiginin belirlenmesi islemi...
        // basarili kiz sayilari, kizlarin basari yüzdelerinin bulunmasi icin..
        // basarili erkek sayilari, erkeklerin basari yüzdelerinin bulunmasi icin..
        // basarili ögrenci sayilari ise okulun genel basari yüzdesinin hesaplanmasi için..

        if(not_ort>=90)
        {


            burs=(200+not_ort*1.8);

            if(cinsiyet == 'e' || cinsiyet =='E')
            {

                basariliErkekSay++;
                basariliOgrenciSay++;
            }
            else
            {

                basariliKizSay++;
                basariliOgrenciSay++;
            }

        }

        else if(not_ort>=80)
        {

            burs=(190+not_ort*1.5);

            if(cinsiyet=='e' || cinsiyet=='E')
            {

                basariliErkekSay++;
                basariliOgrenciSay++;
            }
            else
            {

                basariliKizSay++;
                basariliOgrenciSay++;
            }

        }

        else if(not_ort>=70)
        {

            burs=(170+not_ort*1.3);

            if(cinsiyet=='e' || cinsiyet=='E')
            {

                basariliErkekSay++;
                basariliOgrenciSay++;
            }
            else
            {

                basariliKizSay++;
                basariliOgrenciSay++;
            }

        }

        else if(not_ort>=60)
        {

            burs=(140+not_ort*1.2);

            if(cinsiyet=='e' || cinsiyet=='E')
            {


                basariliErkekSay++;
                basariliOgrenciSay++;
            }
            else
            {

                basariliKizSay++;
                basariliOgrenciSay++;
            }

        }
        else   // not  ortalamasi 60 dan kücük ise basarili kiz veya erkek ögrencilerin sayaclari artiriliyor..
        {


            burs=100;

            if(cinsiyet=='e' || cinsiyet=='E')
            {


                basarisizErkekSay++;
                basarisizOgrenciSay++;
            }
            else
            {

                basarisizKizSay++;
                basarisizOgrenciSay++;

            }


        }

        if(dersSay<=3)  // En fazla 3 ders alan ögrencilerin bulunabilmesi icin..
        {

            max3ders++;

        }

        if(control==0)  // 110.satirda  eger 60 dan küçük ders notu varsa control=1 oluyordu. eðer control=0, yani baslangiç degeri ise;
            // ögrencinin hicbir dersinin notunun 60 dan kücük olmadigini bulup min60 sayacini artirarak,
            // hicbir notu 60 dan az olmayanlarin sayisini bulmus oluyoruz..
        {

            min60++;



        }

        control=0;      // control degiskeni degerinin yeniden sifira atayarak bir önceki degerde kalmamasi saglaniyor..

        if(not_ort<35)
        {

            notOrt35++;  // not ortalamasi 35 ten az olanlarin sayilari ve yuzdelerinin bulunmasi icin...

        }

        if(not_ort>85)
        {

            notOrt85++;   // not ortalamasi 85 ten fazla olanlarin sayilari ve yuzdelerinin bulunmasi icin...

        }




        // ikamet adreslerine göre burslarin hesaplanmasi ve hangi ikamet adresinin daha basarili oldugunun bulunmasi için kullanilmistir..

        switch(ikamet)
        {


        case 'e':

            burs=(burs+burs*0.5);
            evdeKalanSay++;
            if(not_ort>=60)
            {

                evBasariliSay++;

            }

            break;

        case 'E':

            burs=(burs+burs*0.5);
            evdeKalanSay++;

            if(not_ort>=60)
            {

                evBasariliSay++;

            }

            break;

        case 'y':

            burs=(burs+burs*0.3);
            yurttaKalanSay++;

            if(not_ort>=60)
            {

                yurtBasariliSay++;

            }

            break;

        case 'Y':

            burs=(burs+burs*0.3);
            yurttaKalanSay++;

            if(not_ort>=60)
            {

                yurtBasariliSay++;

            }

            break;

        case 'a':

            aileKalanSay++;

            if(not_ort>=60)
            {

                aileBasariliSay++;

            }

            break;

        case 'A':

            aileKalanSay++;

            if(not_ort>=60)
            {

                aileBasariliSay++;

            }

            break;

        default:
            break;

        }   // switc case yapisinin bitisi..

        if(burs>300)  // 300 TL den fazla burs alacak ögrencilerin sayisinin hesaplanmasi..
        {

            bursBuyuk300++;

        }

        if(not_ort>maxNotOrt)  // okul birincisinin belirlenmesi ve okul birincisine ait istenilen bilgilerin elde edilmesi..
        {

            maxNotOrt=not_ort;
            okulBirincisiNo=ogrenciNo;
            okulBirincisiTopKrediSay=topKrediSay;
            okulBirincisiNotOrt=not_ort;
            okulBirincisiBurs=burs;

        }

        if(burs>maxBurs)    // en fazla burs alan öðrencinin belirlenmesi ve o kiþiye ait istenilen bilgilerin elde edilmesi..
        {

            maxBurs=burs;
            maxBursOgrenciNo=ogrenciNo;
            maxBursKrediTop=topKrediSay;
            maxBursNotOrt=not_ort;

        }

        topBursMiktari+=burs;   // ögrencilere her ay ödenecek toplam burs miktarinin belirlenmesi icin...


        // Öðrenciye ait istenilen bazi bilgilerin yazdirilmasi...

        printf("\nOgrenci numarasi:%d",ogrenciNo);
        printf("\nBu donem aldigi derslerin toplam kredisi:%d",topKrediSay);
        printf("\nBu donemki agirlikli not ortalamasi:%.2f",not_ort);
        printf("\nGelecek donem alacagi toplam burs miktari:%.2f\n",burs);



        topKrediSay=0;  // tampon bellegin temizlenmesi..
        top_agirlik=0;  // tampon bellegin temizlenmesi..

        ogrenciSay=basariliOgrenciSay+basarisizOgrenciSay;





    }
    while(ogrenciNo>0) ; // do while döngü yapisinin bitisi. Yani yeni ögrenci bilgi girisi yok..



    //bütün ögrencilere ait istenilen istatistiksel bilgilerin hesaplanmasi..
    // kullanilan float'lar tip uyusmazligini ortadan kaldirmak icin...
    ogrenciSay=basariliOgrenciSay+basarisizOgrenciSay;
    kizBasariYuzde=((float)basariliKizSay/(float)kizSay)*100;
    erkekBasariYuzde=((float)basariliErkekSay/(float)erkekSay)*100;
    genelBasariYuzde=((float)basariliOgrenciSay/(float)ogrenciSay)*100;
    erkekNotOrt=((float)erkekNotTop/(float)erkekSay);
    kizNotOrt=((float)kizNotTop/(float)kizSay);
    genelNotOrt=((float)kizNotTop+(float)erkekNotTop)/(float)ogrenciSay;
    genelKrediOrt=(float)genelKrediTop/(float)ogrenciSay;
    min60yuzde=((float)min60/(float)ogrenciSay)*100;
    notOrt35yuzde=((float)notOrt35/(float)ogrenciSay)*100;
    notOrt85yuzde=((float)notOrt85/(float)ogrenciSay)*100;
    bursBuyuk300=bursBuyuk300;
    yurtBasariYuzde=((float)yurtBasariliSay/(float)yurttaKalanSay)*100;
    aileBasariYuzde=((float)aileBasariliSay/(float)aileKalanSay)*100;
    evBasariYuzde=((float)evBasariliSay/(float)evdeKalanSay)*100;





    //bütün ögrencilere ait istenilen istatistiksel bilgilerin yazdirilmasi..

    printf("\nKizlar icin basari yuzdesi:%.2f",kizBasariYuzde);
    printf("\nErkekler icin basari yuzdesi:%.2f",erkekBasariYuzde);
    printf("\nOkulun geneli icin basari yuzdesi:%.2f",genelBasariYuzde);
    printf("\nKizlar icin agirlikli not ortalamasi:%.2f",kizNotOrt);
    printf("\nErkekler icin agirlikli not ortalamasi:%.2f",erkekNotOrt);
    printf("\nOkulun geneli icin agirlikli not ortalamasi:%.2f",genelNotOrt);
    printf("\nOgrencilerin aldigi derslerin kredi ortalamasi:%.2f",genelKrediOrt);
    printf("\nO donem aldigi ders sayisi 3 ve altinda olanlarin sayisi:%d",max3ders);
    printf("\nHicbir dersi 60 in altinda olmayanlarin sayisi:%d",min60);
    printf("\nHicbir dersi 60 in altinda olmayanlarin yuzdesi:%.2f",min60yuzde);
    printf("\nAgirlikli not ortalamasi 35 in altinda olanlarin sayisi:%d",notOrt35);
    printf("\nAgirlikli not ortalamasi 35 in altinda olanlarin yuzdesi:%.2f",notOrt35yuzde);
    printf("\nAgirlikli not ortalamasi 85 in ustunde olanlarin sayisi:%d",notOrt85);
    printf("\nAgirlikli not ortalamasi 85 in ustunde olanlarin yuzdesi:%.2f",notOrt85yuzde);
    printf("\nSonraki donem alacagi burs miktari 300 den fazla olanlarin sayisi:%d",bursBuyuk300);
    printf("\nOkul birincisinin numarasi:%d",okulBirincisiNo);
    printf("\nOkul birincisinin aldigi derslerin kredileri toplami:%d",okulBirincisiTopKrediSay);
    printf("\nOkul birincisin agirlikli not ortalamasi:%.2f",okulBirincisiNotOrt);
    printf("\nOkul birincisinin sonraki donem alacagi aylik burs miktari:%.2f",okulBirincisiBurs);
    printf("\nSonraki donem en con burs alacak ogrencinin numarasi:%d",maxBursOgrenciNo);
    printf("\nSonraki donem en con burs alacak ogrencinin aldigi derslerin toplam kredisi:%d",maxBursKrediTop);
    printf("\nSonraki donem en con burs alacak ogrencinin agirlikli not ortalamasi:%.2f",maxBursNotOrt);
    printf("\nSonraki donem en con burs alacak ogrencinin alacagi aylik burs miktari:%.2f",maxBurs);
    printf("\nOgrencilere sonraki donem her ay odenecek toplam burs miktari:%.2f",topBursMiktari);




    // ikamet adreslerine göre basari yüzdelerinin kiyaslanmasi ve en düsük basari yüzdesine sahip ikamet adresinin yazdirilmasi...

    if(yurtBasariYuzde<aileBasariYuzde && yurtBasariYuzde<evBasariYuzde)
    {

        printf("\nBasarili ogrencilerin yuzdesinin en dusuk oldugu ikamet yeri: YURT");

    }

    if(evBasariYuzde<aileBasariYuzde && evBasariYuzde<yurtBasariYuzde)
    {

        printf("\nBasarili ogrencilerin yuzdesinin en dusuk oldugu ikamet yeri: EV");



    }
    if(aileBasariYuzde<yurtBasariYuzde && aileBasariYuzde<evBasariYuzde)
    {

        printf("\nBasarili ogrencilerin yuzdesinin en dusuk oldugu ikamet yeri: AILE");

    }

    if(aileBasariYuzde==yurtBasariYuzde && yurtBasariYuzde==evBasariYuzde){

        printf("\n EV,YURT ve AILE basari yuzdeleri esittir.\n");

    }


    return 0;//programin sonlandirilmasi
}
