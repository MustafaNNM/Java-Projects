#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <conio.h>

#define BOYUT 19
#define SINIR BOYUT+1
#define RANDOM rand()%BOYUT

int menu();
void oyun(int kullanici);

int main()
{
    srand(time(NULL));
    int secim;
    secim=menu();
    while(secim!=2){oyun(secim);secim=menu();}
    return 0;
}

int menu()
{
    int secim;

    printf("\n");
    printf("0) Izlemek istiyorum\n");
    printf("1) Oynamak istiyorum\n");
    printf("2) Cikmak  istiyorum\n");
    scanf("%d",&secim);
    fflush(stdin);
    system("cls");

    return secim;
}

void oyun(int kullanici)
{
    int x=RANDOM,y=RANDOM;
    int i,j,git=0,kirli=0;
    int miktar=1,seviye=2;
    int x2=RANDOM,y2=RANDOM;
    char yon;

    do
    {
        if(kirli){system("cls");kirli=0;}
        printf("  X   Y\n");
        printf("%03d %03d Simdiki Konumunuz\n",x,y);
        printf("%03d %03d Simdiki Hedefiniz\n",x2,y2);
        kirli=1;

        for(i=0;i<100;++i){for(j=0;j<5000;++j){}}

        if(x==x2&&y==y2)
        {
            if(kirli){system("cls");kirli=0;}
            printf("  X   Y\n");
            printf("%03d %03d Simdiki Konumunuz\n",x,y);
            printf("%03d %03d Simdiki Hedefiniz\n",x2,y2);
            printf("Tebrikler!%d. Seviyedesiniz!",seviye);
            kirli=1;++seviye;x=RANDOM;y=RANDOM;x2=RANDOM;y2=RANDOM;
        }
        else
        {
            for(i=0; i<y; ++i){printf("\n");}
            for(j=0; j<x; ++j){printf(" ");}
            printf("#");kirli=1;
        }

        miktar=1+rand()%seviye;fflush(stdin);

        if(kullanici)
        {
            yon=getch();//fflush(stdin);
            switch(yon)
            {
                case 119:case 87:git=0;break;
                case 97 :case 65:git=1;break;
                case 115:case 83:git=2;break;
                case 100:case 68:git=3;break;
            }
        }
        else
        {
            if(x2<x){git=1;}
            else
            {
                if(x2>x){git=3;}
                if(y2<y){git=0;}else{if(y2>y){git=2;}}
            }
            for(i=0;i<100;++i){for(j=0;j<2000000;++j){}}
        }

        switch(git)
        {
            case 0:y-=miktar;break;
            case 1:x-=miktar;break;
            case 2:y+=miktar;break;
            case 3:x+=miktar;break;
        }
        if(0>x){x=SINIR;}else{if(SINIR<x){x=0;}}
        if(0>y){y=SINIR;}else{if(SINIR<y){y=0;if(kirli){system("cls");kirli=0;}}}
    }
    while(seviye!=10);

    for(i=0;i<200;++i){for(j=0;j<3000000;++j){}}

    if(kirli){system("cls");kirli=0;}

}
