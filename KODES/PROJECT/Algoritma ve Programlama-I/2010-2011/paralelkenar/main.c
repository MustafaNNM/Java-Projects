#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i,k,j,yukseklik=4,h=yukseklik,genislik=5;
    for(k=1;k<=yukseklik;k++){
    for(i=0;i<h-1;i++){printf(" ");}
    for(j=0;j<genislik;j++){printf("X");}
    h--;
    printf("\n");
    }
    return 0;
}
