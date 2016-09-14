#include <stdio.h>
#include <stdlib.h>
#include <math.h>

char menu(void);
void ek(float);

int main()
{
    int i;
    char donem;
    char *s=" notunu giriniz\n?";
    char devam_mi;
    char *ders1[8]={"YAZILI ANLATIM","BIYOLOJI","BILGISAYAR I","MATEMATIK I","E.B.G.","TARIH","INGILIZCE I","UYGARLIK TARIHI"};
    char *ders2[9]={"SOZLU ANLATIM","KIMYA","BÝLGISAYAR II","MATEMATIK II","E.P","COGRAFYA","INGILIZCE II","T.K.T","A.I.T"};
    float katsayi1[8]={2,2,3,2,3,2,3,2};
    float katsayi2[9]={2,2,3,3,3,2,3,2,2};
    float toplam=0;
    float ortalama;
    float puan;

    donem=menu();
    do
    {
        switch (donem)
        {
        case 'q':
        case 'Q':
            exit(EXIT_SUCCESS);
            break;
        case '1':
            do
            {
                for (i=0;i<=7;i++)
                {
                    printf("%s%s",ders1[i],s);
                    fflush(stdin);
                    scanf("%f",&puan);
                    toplam+=puan*katsayi1[i];
                }
                ortalama=toplam/19;
                toplam=0;
                printf("1. donem notunuz:%5.2f\n",ortalama);
                ek(3.6-ortalama);
                fflush(stdin);
                devam_mi=getchar();
            }
            while (devam_mi=='e'||devam_mi=='E');
            break;
        case '2':
            do
            {
                for (i=0;i<=8;i++)
                {
                    printf("%s%s",ders2[i],s);
                    fflush(stdin);
                    scanf("%f",&puan);
                    toplam+=puan*katsayi2[i];
                }
                ortalama=toplam/22;
                toplam=0;
                printf("2. donem notunuz:%5.2f\n",ortalama);
                ek(3.6-ortalama);
                fflush(stdin);
                devam_mi=getchar();
            }
            while (devam_mi=='e'||devam_mi=='E');
            break;
        case '3':
            printf("\nBirinci sinif kredileri:\n\n");
            for (i=0;i<=7;i++)
            {
                printf("%-16s%.2f\n",ders1[i],katsayi1[i]);
            }
            printf("\nIkinci sinif kredileri:\n\n");
            for (i=0;i<=6;i++)
            {
                printf("%-16s%.2f\n",ders2[i],katsayi2[i]);
            }
            break;
        }
        donem=menu();
    }
    while (donem!='q' && donem!='Q');

    return 0;
}
char menu(void)
{
    printf("\n****************************MENU*******************************\n\n\n");
    printf("     Sadece 1. sinif notlarini hesaplamada kullanabilirsiniz!\n");
    printf("     Q)Cikis\n");
    printf("     1)Birinci donem not hesabi\n");
    printf("     2)Ikinci donem not hesabi\n");
    printf("     3)Kredilerin goruntulenmesi\n");
    printf("     Seciminiz{[q/Q]/[1-3]}\n?");
    fflush(stdin);
    return getchar();
}
void ek(float ortalama)
{
    printf("\nDiger donem notunuz en az %5.2f olmali",ortalama);
    printf("\nyada yaz okulundan ders almalisiniz");
    printf("\nIsterseniz notlarinizi yukseltmek");
    printf("\nicinde yaz okulundan ders alabilirsiniz");
    printf("\nDevam{[E/e]/[H/h]}\n?");
}
