#include <iostream>
#include "tarih.h"
#include "personel.h"
#include "tek_bagli_liste.h"
#include "cift_bagli_liste.h"
using namespace std;
int menu();
int main()
{
    int secim;
    do
    {
    secim=menu();
    switch(secim)
    {
     case 1:break;
     case 2:break;
     case 3:break;
     case 4:break;
     case 5:break;
     case 6:break;
     case 7:break;
     case 8:break;
     case 9:break;
     case 10:break;
     case 11:break;
     case 12:break;
    }
    cout <<secim<< endl;
    }while(secim!=0);
    return 0;
}
int menu()
{
    int sayi;
    cout<<
    "  0) Cikis\n"<<
    "  1) Ilk defa memur olan bir personelin kuruma atanmasi\n"<<
    "  2) Baska bir kurumdan nakil olan bir personelin kuruma atanmasi\n"<<
    "  3) Bir personelin unvan ve maas katsayisinin guncellenmesi\n"<<
    "  4) Bir personelin silinmesi\n"<<
    "  5) Bir personelin bilgilerinin listelenmesi\n"<<
    "  6) Tum personelin, personel numarasi sirasina gore listelenmesi\n"<<
    "  7) Tum personelin, kuruma atanma tarihi sirasina gore listelenmesi\n"<<
    "  8) Belirli bir tarihten sonra kuruma atanan personelin listelenmesi\n"<<
    "  9) Belirli bir yilda kuruma atanan personelin listelenmesi\n"<<
    " 10) Belirli bir tarihten once dogmus personelin listelenmesi\n"<<
    " 11) Belirli bir ayda dogmus personelin listelenmesi\n"<<
    " 12) Belirli bir unvana sahip personelden,\n     "<<
    "kuruma en son atanan personelin bilgilerinin listelenmesi\n"<<
    endl;
    do{
    printf("Seciminiz\n?");
    cin>>sayi;
    }while(sayi<0&&sayi>12);
    return sayi;
}
