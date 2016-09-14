#include <stdio.h>

int main()
{
    char ch;
    int x=0,y=0,cumle=0,kelime=0,karakter=0,harf=0,ozel=0;

    while ( ( ch = getchar() ) != '#' )
    {
        if(x==y){printf("\n");x=0;++y;}
        switch(ch)
        {
            case '.':
            case '!':
            case '?':
            case ':':++cumle;++kelime;break;
            case ' ':
            case ',':
            case ';':++kelime;break;
            default:printf("%c",ch);++x;++karakter;++harf;if(('a'>ch||ch>'z')&&('A'>ch||ch>'Z')){++ozel;}break;
        }
    }
    printf("\ncumle:%d\nkelime:%d\nkarakter:%d\nharf:%d\nozel:%d\n",cumle,kelime,karakter,harf,ozel);
    return 0;
}
