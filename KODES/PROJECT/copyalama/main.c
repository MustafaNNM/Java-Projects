#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    char *hedef="";
    char satir[]={'a','k','i','f','\0'};


    strcpy(hedef,satir);
    printf("#%s#%s#\n",hedef,satir);
    return 0;
}
