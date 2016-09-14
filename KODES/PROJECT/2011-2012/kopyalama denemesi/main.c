#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    char *hedef;
    char satir[]={'a','l','l','a','h','\0'};

    hedef=malloc(sizeof(strlen(satir)));
    /*hedef[0]='a';
    hedef[1]='l';
    hedef[2]='l';
    hedef[3]='a';
    hedef[4]='h';
    hedef[5]='\0';
    */
    strcpy(hedef,satir);
    hedef[strlen(satir)]='\0';
    printf("#%s#%s#\n",hedef,satir);
    return 0;
}
