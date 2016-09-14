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

int main()
{
    struct dugum *cab;
    FILE gfptr;

    int TIME=0;
    if ((gfptr=fopen("girdiler.txt","w+"))==NULL)
    {
        printf("Dosya acilamadi\n");
    }
    else
    {
        cab->no=0;
        while (TIME<=24)
        {
            cab->tur=1+TIME%4;
            cab->dakika=TIME;
            cab->no++;
            fprintf(gfptr,"%d %d %d\n",cab->no,cab->tur,cab->dakika);
            TIME+=30+rand()%120;
        }
    }
    fclose(gfptr);
    return 0;
}
