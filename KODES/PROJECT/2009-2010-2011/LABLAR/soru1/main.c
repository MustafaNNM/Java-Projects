#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int menu()
{
    printf("Seciminiz:\n");
    printf("1-Kodu verilen bir urunun aranmasi ve bilgilerinin goruntulenmesi\n");
    printf("2-Adi verilen bir urunun aranmasi ve bilgilerinin goruntulenmesi\n");
    printf("3-Tum urunlerin bilgilerinin goruntulenmesi\n");
    printf("4-Stok miktari verilen bir degerin altina dusmus");
    printf(" \n  urunlerin bilgilerinin goruntulenmesi\n");
    printf("5-Kodu verilen bir urunun bilgilerinin silinmesi\n");
    printf("6-Urunlerin fiyatlarinin toplu olarak guncellenmesi\n");
    printf("7-Urunlerin stok miktarlarinin toplu olarak guncellenmesi\n");
    printf("8-Cikis\n?");
    return 0;
}
int main()
{
    int urun_kodu,stok_miktari,secim,sayi,buldu=0;
    char urun_adi[15],ad[15],*x,*y;
    double birim_fiyati;
    FILE *cfPtr;/*cfPtr=urunler.dat dosya göstericisi */
    FILE *dosya;/*dosya=geçici dosya göstericisi */

    if ((cfPtr=fopen("urunler.dat","r"))==NULL)
        printf("Dosya acilamadi\n");
    else
    {
        do
        {
            menu();
            scanf("%d",&secim);
            switch (secim)
            {
            case 1:
                printf("Kodu giriniz\n?");
                scanf("%d",&sayi);
                do
                {
                    fscanf(cfPtr,"%d%s%d%lf",&urun_kodu,urun_adi,&stok_miktari,&birim_fiyati);
                    if (sayi==urun_kodu)
                    {
                        printf("%-10d%-11s%-12d%13.2f\n",urun_kodu,urun_adi,stok_miktari,birim_fiyati);
                        buldu=1;
                        break;
                    }
                }
                while (!feof(cfPtr));
                if (buldu==0)
                {
                    printf("HATA!Girilen koda dair bilgi yok!\n");
                }
                buldu=0;
                break;
            case 2:
                printf("Adi giriniz\n?");
                scanf("%s",ad);
                y=ad;
                do
                {
                    fscanf(cfPtr,"%d%s%d%lf",&urun_kodu,urun_adi,&stok_miktari,&birim_fiyati);
                    x=urun_adi;
                    if (*x==*y)
                    {
                        printf("%-10d%-11s%-12d%13.2f\n",urun_kodu,urun_adi,stok_miktari,birim_fiyati);
                        buldu=1;
                        break;
                    }
                }
                while (!feof(cfPtr));
                if (buldu==0)
                {
                    printf("HATA!Girilen urun adina dair bilgi yok!\n");
                }
                buldu=0;
                break;
            case 3:
                printf("%-10s%-11s%-12s%13s\n","URUN KODU","URUN ADI","STOK MIKTARI","BIRIM FIYATI");
                fscanf(cfPtr,"%d%s%d%lf",&urun_kodu,urun_adi,&stok_miktari,&birim_fiyati);
                do
                {
                    printf("%-10d%-11s%-12d%13.2f\n",urun_kodu,urun_adi,stok_miktari,birim_fiyati);
                    fscanf(cfPtr,"%d%s%d%lf",&urun_kodu,urun_adi,&stok_miktari,&birim_fiyati);
                }
                while (!feof(cfPtr));
                break;
            case 4:
                printf("Sinirlayici kota miktarini giriniz\n?");
                scanf("%d",&sayi);
                printf("Stok miktarinin altinda olanlar:\n");
                do
                {
                    fscanf(cfPtr,"%d%s%d%lf",&urun_kodu,urun_adi,&stok_miktari,&birim_fiyati);
                    if (sayi>stok_miktari)
                    {
                        printf("%-10d%-11s%-12d%13.2f\n",urun_kodu,urun_adi,stok_miktari,birim_fiyati);
                        buldu=1;
                    }
                }
                while (!feof(cfPtr));
                if (buldu==0)
                {
                    printf("HATA!Girilen stok miktarinin altinda urun yok!\n");
                }
                buldu=0;
                break;
            case 5:
                if ((dosya=fopen("gecici.dat","w+"))==NULL)
                    printf("Dosya acilamadi\n");
                else
                {
                    printf("Silmek istediginiz urunun kodunu giriniz\n?");
                    scanf("%d",&sayi);
                    fscanf(cfPtr,"%d%s%d%lf",&urun_kodu,urun_adi,&stok_miktari,&birim_fiyati);
                    do
                    {
                        if (sayi!=urun_kodu)
                        {
                            fprintf(dosya,"%-10d%-11s%-12d%13.2f\n",urun_kodu,urun_adi,stok_miktari,birim_fiyati);
                        }
                        else
                        {
                            printf("Kayit silindi\n");
                            buldu=1;
                        }
                        fscanf(cfPtr,"%d%s%d%lf",&urun_kodu,urun_adi,&stok_miktari,&birim_fiyati);
                    }
                    while (!feof(cfPtr));

                    if (buldu==0)
                    {
                        printf("HATA!Girilen koda dair bilgi yok!\n");
                    }
                    buldu=0;
                }
                fclose(dosya);
                fclose(cfPtr);
                remove("urunler.dat");
                rename("gecici.dat","urunler.dat");
                cfPtr=fopen("urunler.dat","r");
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                break;
            }
            rewind(cfPtr);
        }
        while (secim!=8);
        fclose(cfPtr);
    }
    return 0;
}
