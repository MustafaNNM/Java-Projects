#include <stdio.h>
#include <stdlib.h>

struct program{
int *sonsuz_dizi;
};
struct identifier{
char letter;
char *letter_or_digit;
};
int main()
{
    int sonsuz_dizi[]={0};
    sonsuz_dizi[10]=100;
    printf("%d\n",sonsuz_dizi[10]);

    struct program benim;
benim.sonsuz_dizi=sonsuz_dizi;
    printf("%d\n",benim.sonsuz_dizi[10]);

    struct identifier id;
id.letter='a';
id.letter_or_digit="kif";
    printf("%c%s\n",id.letter,id.letter_or_digit);
    return 0;
}
