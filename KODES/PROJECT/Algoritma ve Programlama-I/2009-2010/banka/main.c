#include <stdio.h>
#include <stdlib.h>

struct musteriVerisi{
    int hesapNo;
    char soyisim[15];
    char isim[10];
    double bakiye;
};

void kredi(){
long int i;

    struct musteriVerisi bosVeri={ .hesapNo = 0 , .soyisim = "" , .isim = "" , .bakiye = 0.0 };
    FILE *cfPtr;
    printf("Kac kisilik bir hesap takip sistemi olusturmak istiyorsunuz\n?");
    long int sayi;
    scanf("%ld",&sayi);

    if((cfPtr=fopen("a.lnk","a"))==NULL){
    printf("Dosya acilamadi\n");}
    else{
        for(i=1;i<=sayi;i++)
        fwrite(&bosVeri,sizeof(struct musteriVerisi),1,cfPtr);
        rename("a.lnk","mehmet.txt");
        }fclose(cfPtr);
}
int main()
{
    kredi();
    return 0;
}
