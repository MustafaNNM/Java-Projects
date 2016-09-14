#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

int uzunluk_bul(char *girdi);

int main()
{
        char girdi[]= {'0','\0'};

        printf("%s",girdi);
        gets(girdi);
        printf("metin=%s uzunluk=%d",girdi,uzunluk_bul(girdi));

        return 0;
}

int uzunluk_bul(char *girdi)
{
        int uzunluk=0;

        while(girdi[uzunluk]!='\0') {
                ++uzunluk;
        }

        return uzunluk;
}
