#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x,y,z,sonuc,a,b,c,istenen;
    char yazdirilsin_mi;

    do
    {
        do
        {
            printf("Istenen degeri giriniz[3'ten buyuk tam sayi]{Cikis[0]}\n?");
            fflush(stdin);
            scanf("%d",&istenen);
        }
        while (istenen<=3);
        printf("Yazdirilsin mi?{[E/e]/[H/h]}\n");
        fflush(stdin);
        yazdirilsin_mi=getchar();
        if (istenen==0)
        {
            exit(EXIT_SUCCESS);
        }
        switch(yazdirilsin_mi)
        {
        case 'e':
        case 'E':
            for (a=1; a<istenen; a++)
            {
                x=a;
                for (b=1; b<istenen; b++)
                {
                    y=b;
                    for (c=1; c<istenen; c++)
                    {
                        z=c;
                        sonuc=x+y+z;
                        //if (sonuc==istenen)
                        {
                            printf("x:%d,y:%d,z=%d\n",x,y,z);
                        }
                    }
                }
            }
            break;
        }
        printf("%d farkli deger var\n",(istenen-2)*(istenen-1)/2);//orijinal formül:(istenen-2)*((istenen-2)+1)/2
    }
    while (istenen!=0);

    return 0;
}
