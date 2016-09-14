#include <stdio.h>
#include <stdlib.h>


void main()
{
    // int i_liste=0;
     FILE *fptr;
     char *dosya_adi="C:\\akif.txt",*amac="r";

        if((fptr=fopen(dosya_adi,amac))==NULL)
        {
            printf("%s dosyasi acilamadi\n",dosya_adi);
        }
}

