#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void fal();
void kart_kar(int *desteptr);
char secim();

int main()
{
    char devam_mi;
    char *s="Niyet tut.Puanin 100 e ne kadar yakinsa gercekleklesme ihtimali o kadar yuksek!\n\nDevam etmek icin acilan her karttan sonra enter a basiniz\n\n";
    do
    {
        printf("%s",s);
        fal();
        printf("Fal bakmaya devam\n?");
        devam_mi=secim();
    }
    while(devam_mi=='e'||devam_mi=='E');
    return 0;
}
void fal()
{
    char *yuz[4]= {"Kupa","Karo","Maca","Sinek"};
    char *no[13]= {"As","Ikili","Uclu","Dortlu","Besli","Altili","Yedili","Sekizli","Dokuzlu","Onlu","Vale","Kiz","Papaz"};
    int deste[2][4][13]= {{{0}}};
    int *desteptr;
    int puan[13]= {0};
    int acilan_kartlar[13]= {0};
    int i=51,b=0,j=12,g_k_k_s=52;

    desteptr=&deste[0][0][0];
    kart_kar(desteptr);
    while(g_k_k_s>0)
    {
        if(j==12){j=0;}else{++j;}
        if(i==51){i=0;}else{++i;}
        if(desteptr[i+52]==0)
        {
            b=desteptr[i]%13;
            acilan_kartlar[j]=i;
            if(g_k_k_s!=j)
            {
                printf("%s %s ",yuz[desteptr[i]/13],no[b]);
                if(j==b){printf("= ");}
                printf("%d\n",j+1);
                getchar();fflush(stdin);
                if(j==b)
                {
                    ++puan[j];
                    desteptr[i+52]=1;//Puan kaðýdý//kart iptal//
                    --g_k_k_s;
                    printf("**Ustteki kart iptal edildi!**%d kart kaldi**\n\n",g_k_k_s);
                    j=12;
                }
                else
                {
                    if(j==12)
                    {
                        g_k_k_s-=13;
                        printf("**Ustteki %d kart iptal edildi!**%d kart kaldi**\n\n",13,g_k_k_s);
                        for(j=0; j<13; ++j){desteptr[acilan_kartlar[j]+52]=1;/*kart iptal*/}
                        j=12;
                    }
                }
            }else{break;}
        }
        else{--j;}
    }
    for(i=1; i<10; ++i)
    {
        b+=puan[i];
    }
    b*=2;
    b+=puan[0]+(puan[10]+puan[11]+puan[12])*10;
    printf("Puaniniz:%d\n",b);
}
void kart_kar(int *desteptr)
{
    int i,sayi;
    int kullanildi[52]= {0};

    srand(time(NULL));

    for(i=0; i<52; i++)
    {
        sayi=rand()%52;
        if(kullanildi[sayi]==0)
        {
            desteptr[i]=sayi;
            kullanildi[sayi]=1;
        }
        else
        {
            while(kullanildi[sayi]==1)
            {
                sayi=rand()%52;
            }
            desteptr[i]=sayi;
            kullanildi[sayi]=1;
        }
    }
}
char secim()
{
    char devam;
    int sayac=0;

    do
    {
        if(sayac>0)
        {
            printf("Hatali girdiniz\n");
        }
        devam=getchar();
        fflush(stdin);
        ++sayac;
    }
    while('e' != devam && 'E' != devam && 'h' != devam && 'H' != devam);
    return devam;
}
