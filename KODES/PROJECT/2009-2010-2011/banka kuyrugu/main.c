#include <stdio.h>
#include <stdlib.h>

struct dugum
{
    int no;
    int tur;
    int dakika;
    int sure;
    struct dugum *sonraki;
};
struct vezne
{
    int no;
    int dakika;
    int cikis;
    int hizmet;
    int musteri;
    char dolu_mu;
};
struct Olay
{
    int platin;
    int altin;
    int gumus;
    int standart;
    int kuyruk_miktari;
};
void sirali_ekle(struct dugum **bas, struct dugum *yeni);

struct dugum bastan_sil(struct dugum **bas);

int main()
{
    FILE *gfptr;
    FILE *cfptr;
    int i,dk=0,toplam=0;
    struct dugum *kisi;
    struct dugum *ilk=NULL;
    struct dugum gecici;
    struct vezne gise[3];
    struct Olay olay;
    for (i=0;i<=2;i++)
    {
        gise[i].no=0;
        gise[i].dakika=0;
        gise[i].hizmet=0;
        gise[i].dolu_mu='h';
    }
    if ((gfptr=fopen("girdiler.txt","r"))==NULL)
    {
        printf("Dosya acilamadi\n");
    }
    else
    {
        olay.kuyruk_miktari=0;
        do
            {
                kisi=malloc(sizeof(struct dugum));
            }
            while (kisi==NULL);
        fscanf(gfptr,"%d%d%d%d",&kisi->no,&kisi->tur,&kisi->dakika,&kisi->sure);
        fflush(stdin);
        while (!feof(gfptr))
        {
            ++olay.kuyruk_miktari;sirali_ekle(&ilk,kisi);
            do{kisi=malloc(sizeof(struct dugum));}while (kisi==NULL);
            fscanf(gfptr,"%d%d%d%d",&kisi->no,&kisi->tur,&kisi->dakika,&kisi->sure);fflush(stdin);
        }
    }
    fclose(gfptr);
    if ((cfptr=fopen("ciktilar.txt","w"))==NULL)
    {
        printf("Dosya acilamadi\n");
    }
    else
    {
        do
        {
            for (i=0;i<=2;++i)
            {
                if (dk==gise[i].cikis)
                {
                    fprintf(cfptr,"%d. dakikada Musteri-%d Gise-%d i terketti\n",dk,gise[i].musteri,i+1);
                    printf("%d. dakikada Musteri-%d Gise-%d i terketti\n",dk,gise[i].musteri,i+1);
                    --olay.kuyruk_miktari;
                }
                if (gise[i].dolu_mu=='h')
                {
                    gecici=bastan_sil(&ilk);
                    gise[i].musteri=gecici.no;
                    switch (gecici.tur)
                    {
                    case 1:++olay.platin;break;
                    case 2:++olay.altin;break;
                    case 3:++olay.gumus;break;
                    case 4:++olay.standart;break;
                    }
                    fprintf(cfptr,"%d. dakikada Musteri-%d e Gise-%d de hizmet verilmeye baslandi\n",dk,gecici.no,i+1);
                    printf("%d. dakikada Musteri-%d e Gise-%d de hizmet verilmeye baslandi\n",dk,gecici.no,i+1);
                    gise[i].dakika+=gecici.sure;
                    ++gise[i].hizmet;
                    gise[i].cikis=dk+gecici.sure;
                    gise[i].dolu_mu='e';
                }//doluysa 'e' bossa 'h'
            }
            toplam=gise[0].hizmet+gise[1].hizmet+gise[2].hizmet;
            for (i=0;i<=2;i++)
            {
                --gise[i].dakika;
                if (gise[i].dakika==0)
                {
                    gise[i].dolu_mu='h';
                }
            }
            ++dk;
        }
        while (3<olay.kuyruk_miktari);//0!=olay.kuyruk_miktari
        do
        {
        for (i=0;i<=2;++i)
            {
                if (dk==gise[i].cikis)
                {
                    fprintf(cfptr,"%d. dakikada Musteri-%d Gise-%d i terketti\n",dk,gise[i].musteri,i+1);
                    printf("%d. dakikada Musteri-%d Gise-%d i terketti\n",dk,gise[i].musteri,i+1);
                    --olay.kuyruk_miktari;
                }
            }
            ++dk;
        }while(0<olay.kuyruk_miktari);
        fprintf(cfptr,"Simulasyon bitti, sonuclar:\n");
        fprintf(cfptr,"Herhangi bir zamanda bekleme kuyrugunda bulunan en fazla musteri sayisi\n");
        fprintf(cfptr,"Bekleme kuyrugunda en uzun sure bekleyen musterinin bekleme suresi:\n");
        fprintf(cfptr,"Musteri Sinifi Bir Musterinin Bekleme Kuyrugunda Ortalama Bekleme Suresi\n");
        fprintf(cfptr,"------------------------------------------------------------------------\n");
        fprintf(cfptr,"Gise No Toplam Musteri Sayisi Ortalama Hizmet Verme Suresi\n");
        fprintf(cfptr,"----------------------------------------------------------\n");
        fprintf(cfptr,"Gise 1\nGise 2\nGise 2\n");
        printf("Simulasyon ciktisi icin ciktilar.txt dosyasina bakiniz!");
    }
    return 0;
}
void sirali_ekle(struct dugum **bas,struct dugum *yeni)
{
    struct dugum *gecici, *onceki;

    if (*bas==NULL)  //kuyruk bossa
    {
        yeni->sonraki=NULL;
        *bas=yeni;
    }
    else
        if (yeni->no<(*bas)->no)  //en basa eklenecekse
        {
            yeni->sonraki=*bas;
            *bas=yeni;
        }
        else  //araya ya da sona eklenecekse
        {
            onceki=*bas;
            gecici=(*bas)->sonraki;
            while ((gecici!=NULL) && (gecici->no<yeni->no))  //eklenecek uygun yer araniyor
            {
                onceki=gecici;
                gecici=gecici->sonraki;
            }
            yeni->sonraki=gecici;//gecici NULL ise en sona, degilse onceki dugumu ile gecici dugumu arasina ekleniyor
            onceki->sonraki=yeni;
        }
}
struct dugum bastan_sil(struct dugum **bas)
{
    struct dugum *gecici;
    struct dugum silinen;

    gecici=*bas;
    silinen=*gecici;
    *bas=(*bas)->sonraki;
    // *bas=gecici->sonraki;
    // *bas=silinen.sonraki;
    free(gecici);
    return silinen;
}
