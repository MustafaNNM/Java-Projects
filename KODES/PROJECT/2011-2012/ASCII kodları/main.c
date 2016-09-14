#include <stdio.h>
#include <stdlib.h>

int main()
{
    char karakter;
    do{
    scanf("%c",&karakter);
    fflush(stdin);
    printf("%c 'nin ASCII kodu: %d\n",karakter,karakter);
    }while(karakter!='#');
    return 0;
}
