#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <conio.h>

int zar_at();

int main()
{
    for(;;)
    {
        if(!zar_at())
        {
            break;
        }
    }
    return 0;
}
int zar_at()
{
    int zar[6]= {0};
    int i;

    srand(time(NULL));
    printf("Zar 900000000 kez atildi\n");
    for(i=1; i<=900000000; ++i)
    {
        ++zar[rand()%6];
    }
    for(i=1; i<7; ++i)
    {
        printf("%d. yuzu %d kez geldi.\n",i,zar[i-1]);
    }
    printf("Devam etmek icin bir tusa basiniz...\n");
    return getch();
}
