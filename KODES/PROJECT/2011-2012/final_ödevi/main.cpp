#include <iostream>

#include "ucus.h"
#include "ucus_numarasina_gore_ucus_listesi.h"
#include "kalkis_yerine_gore_ucus_listesi.h"

using namespace std;

int menu(void);

int main()
{
        int secim;
        Ucus_Numarasina_Gore_Ucus_Listesi ucus_noya_gore;

        for(;;) {
                secim=menu();
                switch(secim) {
                case 1:

                int no,normal;
                char kalkis[21],varis[21],zaman[6];
                do{
                cout<<"noyu giriniz\n";
                cin>>no;
                }while(ucus_noya_gore.Ucus_ara(no)!=NULL);
                cin.ignore();
                cout<<"kalkis yerini giriniz\n";
                cin>>setw(21)>>kalkis;
                cin.ignore();
                cout<<"varis yerini giriniz\n";
                cin>>setw(21)>>varis;
                cin.ignore();
                cout<<"zamani giriniz\n";
                cin>>setw(6)>>zaman;
                cin.ignore();
                cout<<"normal koltuk sayisini giriniz\n";
                cin>>normal;
                cin.ignore();
                Ucus *yeni;
                yeni=new Ucus(no,kalkis,varis,zaman,normal,0);
                //yeni=new Ucus(0,"","","",0,0);
                //cout<<*yeni;
                ucus_noya_gore.Normal_ucus_ekle(yeni);
                        break;
                case 2:
                        break;
                case 3:
                        break;
                case 4:
                        break;
                case 5:
                        break;
                case 6:
                        break;
                case 7:
                        break;
                case 8:
                        break;
                case 9:
                        break;
            }
        }
        return 0;
}

int menu(void)
{
        int c;

        cout<<"0)  Cikis\n"
        <<"1)  Luks koltuk icermeyen yeni bir ucusun eklenmesi\n"
        <<"2)  Luks koltuk iceren yeni bir ucusun eklenmesi\n"
        <<"3)  Bir ucusun luks koltuk sayisinin guncellenmesi\n"
        <<"4)  Bir ucusun iptal edilmesi\n"
        <<"5)  Bir ucusun bilgilerinin goruntulenmesi\n"
        <<"6)  Luks koltuk iceren ucuslarin listelenmesi\n"
        <<"7)  Bir yere olan ucuslarin listelenmesi\n"
        <<"8)  Bir yerden kalkan ucuslarin listelenmesi\n"
        <<"9)  Bir yerden bir yere olan ucuslarin listelenmesi\n"<<endl;

        do {
                cout<<"\nSeciminizi giriniz\n?"<<endl;
                cin>>c;
                cin.ignore();
           } while (c<0 || c>9);

        return c;
}
