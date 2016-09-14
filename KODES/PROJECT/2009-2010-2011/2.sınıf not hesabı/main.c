#include <stdio.h>
#include <stdlib.h>

char menu(int);
void ek(float);
char devam_mi(void);
void ikinci_sinif_not_hesabi();

int main()
{
    ikinci_sinif_not_hesabi();

    return 0;
}
char menu(int i)
{
    printf("\n****************************MENU*******************************\n\n\n");
    printf("     Sadece %d. sinif notlarini hesaplamada kullanabilirsiniz!\n",i);
    printf("     1)1. donem not hesabi\n");
    printf("     2)2. donem not hesabi\n");
    printf("     3)Kredilerin goruntulenmesi\n");
    printf("     4)Cikis\n");
    printf("     Seciminiz[1-4]\n?");
    fflush(stdin);
    return getchar();
}
void ek(float ortalama)
{
    printf("Diger donem notunuz en az %5.2f olmali",ortalama);
    printf("\nyada yaz okulundan ders almalisiniz");
    printf("\nIsterseniz notlarinizi yukseltmek");
    printf("\nicinde yaz okulundan ders alabilirsiniz");
}
char devam_mi(void)
{
    printf("\nDevam {1} Menu {0}\n?");
    fflush(stdin);
    return getchar();
}
void ikinci_sinif_not_hesabi()
{
    int i;
    char secim,*s=" notunu giriniz\n?";
    char *ders1[6]={"DIFERANSIYEL DENKLEMLER","ELECTRICAL CIRCUITS","DATA STRUCTURES","OLASILIK VE ISTATISTIK ","MANTIK DEVRELERI TASARIMI","AUTOMATA THEORY"};
    char *ders2[4]={"DIGITAL ELECTRONICS","PROGRAMMING LANGUAGES","SAYISAL BILGISAYAR TASARIMI","MODERN BIYOLOJI"};
    float katsayi1[6]={3,4,3.5,3.5,4,3};
    float katsayi2[4]={4,3,4,3};
    float toplam=0,ortalama,puan;

    do
    {
        fflush(stdin);
        secim=menu(2);
        switch (secim)
        {
        case '1':
            do
            {
                for (i=0;i<6;i++)
                {
                    printf("%s%s",ders1[i],s);
                    fflush(stdin);
                    scanf("%f",&puan);
                    toplam+=puan*katsayi1[i];
                }
                ortalama=toplam/21;
                toplam=0;
                printf("1. donem notunuz:%5.2f\n",ortalama);
                ek(3.6-ortalama);
            }
            while (devam_mi()=='1');
            break;
        case '2':
            do
            {
                for (i=0;i<4;i++)
                {
                    printf("%s%s",ders2[i],s);
                    fflush(stdin);
                    scanf("%f",&puan);
                    toplam+=puan*katsayi2[i];
                }
                ortalama=toplam/14;
                toplam=0;
                printf("2. donem notunuz:%5.2f\n",ortalama);
                ek(3.6-ortalama);
            }
            while (devam_mi()=='1');
            break;
        case '3':
            printf("\nBirinci donem kredileri:\n\n");
            for (i=0;i<6;i++)
            {
                printf("%-13s:%2.0f\n",ders1[i],katsayi1[i]);
            }
            printf("\nIkinci donem kredileri:\n\n");
            for (i=0;i<4;i++)
            {
                printf("%-13s:%2.0f\n",ders2[i],katsayi2[i]);
            }
            printf("\n");
            break;
        }
    }
    while (secim!='4');
}
