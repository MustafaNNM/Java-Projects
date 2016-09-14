#include <iostream>
using namespace std;
#include "aday.h"
#include "oncelik_kuyrugu.h"

int menu_secim(void);

int main()
{
    Oncelik_Kuyrugu kuyruk;//Oncelik_Kuyrugu sinifindan bir kuyruk nesnesi turetiliyor
    int aday_no=1;//aday numaralarini otomatik olarak artirmak icin kullanilacak degisken
    int boy;
    Aday *birAday;

    int secenek;

	do {
        secenek=menu_secim();
        switch(secenek) {
            case 1:
                cout << aday_no << " numarali adayin boyunu giriniz:";
                cin >> boy;
                birAday=new Aday(aday_no,boy);//yeni gelen aday icin Aday sinifindan bir nesne turetiliyor
                kuyruk.ekle(birAday);//aday, kuyruga boy sirasina gore yerlestiriliyor
                aday_no++;
                break;
            case 2:
                if (!kuyruk.bos()) {//kuyruk bos degilse...
                    cout << "Sinava cagrilan aday:" << endl;
                    cout << "Aday No Boy" << endl;
                    cout << "------- ---" << endl;
                    kuyruk.bastanSil();//siradaki aday sinava cagiriliyor
                }
                else
                    cout << "Kuyruk bos" << endl;
                break;
            case 3:
                cout << "Kuyrukta bekleyen aday sayisi:" << kuyruk.bekleyen_sayisiOku() << endl;
                break;
            case 4:
                if (!kuyruk.bos()) {//kuyruk bos degilse...
                    cout << "Kuyrukta bekleyen adaylar:" << endl;
                    cout << "Aday No Boy" << endl;
                    cout << "------- ---" << endl;
                    kuyruk.listele();//o salonda bekleyen tum adaylar boy sirasina gore listeleniyor
                }
                else
                    cout << "Kuyruk bos" << endl;
                break;
        }
    } while (secenek!=5);
    return 0;
}

int menu_secim(void){

    int c;
    printf("\n");
    printf("********************MENU************************************\n");
    printf("            1. Bir adayin bekleme kuyruguna yerlestirilmesi\n");
    printf("            2. Siradaki adayin sinava cagrilmasi\n");
    printf("            3. Kuyrukta bekleyen aday sayisi\n");
    printf("            4. Kuyrukta bekleyen adaylarin listelenmesi\n");
    printf("            5. Cikis\n");
    printf("\n");
    do {
        printf("\nSeciminizi Giriniz:  ");
        scanf("%d", &c);

    }while(c<0 || c>5);

    return c;

}
