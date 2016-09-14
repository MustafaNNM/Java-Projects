#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_AD_UZUNLUGU 21
#define PUAN_SAY 4
#define MAX_ULKE_SAY 20

struct ulke
{
    char ulke_adi[MAX_AD_UZUNLUGU];
    char yarismaci_adi[MAX_AD_UZUNLUGU];
    int aldigi_puan;
    char puan_verdigi_ulkelerin_adlari[PUAN_SAY][MAX_AD_UZUNLUGU];//string dizisi
};

int dosyadan_oku(struct ulke [], int *);
void puanla(struct ulke [], int, int []);
void sirala(struct ulke [], int);
void yazdir(struct ulke [], int, int []);

int main()
{
    struct ulke ulkeler[MAX_ULKE_SAY];//ulke bilgilerinin tutuldugu dizi
    int puanlar[PUAN_SAY]= {1,2,5,10}; //4., 3., 2. ve 1.'ye verilen puanlarin tutuldugu dizi
    int ulke_say=0;

    if(dosyadan_oku(ulkeler,&ulke_say))
    {
        puanla(ulkeler,ulke_say,puanlar);
        sirala(ulkeler,ulke_say);
        yazdir(ulkeler,ulke_say,puanlar);
    }

    return 0;
}

int dosyadan_oku(struct ulke *ulkeler, int *ulke_say)
{
    FILE *fptr;
    int uzunluk;

    if((fptr=fopen("eurovision.txt","r"))==NULL)
    {
        printf("eurovision.txt dosyasi acilamadi!\n");
        return 0;
    }
    else
    {
        fgets(ulkeler[*ulke_say].ulke_adi,MAX_AD_UZUNLUGU,fptr);//satir sonuna kadar oku
        fgets(ulkeler[*ulke_say].yarismaci_adi,MAX_AD_UZUNLUGU,fptr);
        while(!feof(fptr))
        {
            uzunluk=strlen(ulkeler[*ulke_say].ulke_adi);
            ulkeler[*ulke_say].ulke_adi[uzunluk-1]='\0';//satir sonu karakterini adin sonundan kaldir
            uzunluk=strlen(ulkeler[*ulke_say].yarismaci_adi);
            ulkeler[*ulke_say].yarismaci_adi[uzunluk-1]='\0';//satir sonu karakterini adin sonundan kaldir
            ulkeler[*ulke_say].aldigi_puan=0;//puani sifirla
            (*ulke_say)++;//yarismaya katilan ulke sayisini artir

            fgets(ulkeler[*ulke_say].ulke_adi,MAX_AD_UZUNLUGU,fptr);
            fgets(ulkeler[*ulke_say].yarismaci_adi,MAX_AD_UZUNLUGU,fptr);
        }
    }

    fclose(fptr);
    return 1;
}

void puanla(struct ulke *ulkeler, int ulke_say, int *puanlar)
{
    int i,j,k;
    char ulke_adi[MAX_AD_UZUNLUGU];
    int ulke_adi_hatali,bulundu;

    printf("Puanlama Basliyor!\n\n");

    for(i=0; i<ulke_say; i++)
    {
        printf("%s jurisinin verdigi puanlari giriniz:\n",ulkeler[i].ulke_adi);

        for(j=0; j<PUAN_SAY; j++)
        {
            do
            {
                printf("%d puan:",puanlar[j]);
                gets(ulke_adi);

                ulke_adi_hatali=1;
                for(k=0; k<ulke_say; k++)
                {
                    if(strcmp(ulke_adi,ulkeler[k].ulke_adi)==0)  //yarismaya katilan bir ulke adi girdiyse
                    {
                        ulke_adi_hatali=0;
                        break;
                    }
                }//sayaci k olan for dongusunun sonu
                if(ulke_adi_hatali==1)//yarismaya katilmayan bir ulke adi girdiyse
                    printf("Yarismaya boyle bir ulke katilmiyor!\n");
                else  //1. else //yarismaya katilan bir ulke adi girdiyse
                {
                    if(strcmp(ulke_adi,ulkeler[i].ulke_adi)==0)  //puani kendine mi veriyor diye bak
                    {
                        ulke_adi_hatali=1;
                        printf("kendi ulkenize puan veremezsiniz!\n");
                    }
                    else  //2. else
                    {
                        bulundu=0;
                        for(k=0; k<j; k++) //bu ulkeye daha once puan vermis mi diye bak
                        {
                            if(strcmp(ulke_adi,ulkeler[i].puan_verdigi_ulkelerin_adlari[k])==0)
                            {
                                bulundu=1;
                                break;
                            }
                        }//sayaci k olan for dongusunun sonu

                        if(bulundu==1)  //daha once bu ulkeye puan verdiyse
                        {
                            ulke_adi_hatali=1;
                            printf("bu ulkeye daha once puan vermistiniz!\n");
                        }
                        else  //3. else //daha once bu ulkeye puan vermediyse
                        {
                            ulkeler[k].aldigi_puan+=puanlar[j];//adi girilen ulkenin puanini artir
                            strcpy(ulkeler[i].puan_verdigi_ulkelerin_adlari[j],ulke_adi);
                        }//3. else sonu
                    }//2. else sonu
                }//1. else sonu
            }
            while(ulke_adi_hatali==1);  //gecerli bir ulke adi girinceye kadar
        }//sayaci j olan for dongusunun sonu
    }//sayaci i olan for dongusunun sonu

}

void sirala(struct ulke *ulkeler, int ulke_say)
{
    int i,j,max_indeks;
    struct ulke gecici;

    for(i=0; i<ulke_say-1; i++)
    {
        max_indeks=i;
        for(j=i+1; j<ulke_say; j++)
        {
            if(ulkeler[max_indeks].aldigi_puan<ulkeler[j].aldigi_puan)
                max_indeks=j;
        }
        if(max_indeks!=i)
        {
            gecici=ulkeler[i];
            ulkeler[i]=ulkeler[max_indeks];
            ulkeler[max_indeks]=gecici;
        }
    }

}

void yazdir(struct ulke *ulkeler, int ulke_say, int *puanlar)
{
    int i,j;

    printf("                                                Verdigi Puanlar\n");
    printf("Ulke        Yarismaci      Puan");
    for(i=0; i<PUAN_SAY; i++)
        printf("   %2d Puan  ",puanlar[i]);
    printf("\n");
    printf("----------- -------------- ----");
    for(i=0; i<PUAN_SAY; i++)
        printf(" -----------");
    printf("\n");

    for(i=0; i<ulke_say; i++)
    {
        printf("%-12s", ulkeler[i].ulke_adi);
        printf("%-15s", ulkeler[i].yarismaci_adi);
        printf("%4d ",ulkeler[i].aldigi_puan);
        for(j=0; j<PUAN_SAY; j++)
            printf("%-12s",ulkeler[i].puan_verdigi_ulkelerin_adlari[j]);
        printf("\n");
    }

}
