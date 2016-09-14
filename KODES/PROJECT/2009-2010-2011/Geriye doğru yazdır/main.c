#include <stdio.h>
#include <stdlib.h>
void yaz(int);
int main()
{
    yaz(10);
    return 0;
}
void yaz(int tur){
    if(--tur>0)
    {
        yaz(tur);
    }
    printf("%d ",tur);
}
