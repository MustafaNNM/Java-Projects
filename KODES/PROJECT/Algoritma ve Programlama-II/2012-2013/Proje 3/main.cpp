#include <iostream>
#include <iomanip>

#include "ogrenci_dizisi.h"
#include "ogrenci.h"
#include "bilgisayar.h"
#include "string.h"
#include "tarih.h"

using namespace std;

int menu();

int main()
{
        int secenek;
        int no;
        int ort;
        int yil;
        bool ogrenci_var_mi;
        Tarih tarih;
        Ogrenci_dizisi *ogrenci_dizisi=new Ogrenci_dizisi();

        do {
                secenek=menu();
                switch(secenek) {
                case 1://Yeni kazanan ogrencinin okula kayitlanmasi
                        cout<<"Yeni ogrencinin numarasini giriniz\n";
                        cin>>no;
                        ogrenci_var_mi=ogrenci_dizisi->noya_gore_ogrenci_var_mi(no);
                        if(ogrenci_var_mi) {
                                cout<<no<<"'lu ogrenci bulunmaktadir.\n";
                        } else {
                                ogrenci_dizisi->nolu_ogrenciyi_kaydet(no);
                                //cout<<ogrenci_dizisi->getOgrenci()[no-1]<<endl;
                        }
                        break;
                case 2://Yatay gecisle gelen ogrencinin okula kayitlanmasi
                        cout<<"Yeni ogrencinin numarasini giriniz\n";
                        cin>>no;
                        ogrenci_var_mi=ogrenci_dizisi->noya_gore_ogrenci_var_mi(no);
                        if(ogrenci_var_mi) {
                                cout<<no<<"'lu ogrenci bulunmaktadir. !!!\n";
                        } else {
                                ogrenci_dizisi->nolu_ogrenciyi_kaydet(no);
                                cout<<"Ogrencinin ortalamasini giriniz\n";
                                cin>>ort;
                                ogrenci_dizisi->getOgrenci()[no-1]->setNot_ortalamasi(ort);
                                cout<<ogrenci_dizisi->getOgrenci()[no-1]<<endl;


                                //cout<<ogrenci_dizisi<<endl;
                        }
                        break;

                case 3:
                        ogrenci_dizisi->update();
                        cout<<"Guncelleme islemi basariyla gerceklesmistir \n";
                        break;
                case 4://Numarasi verilen ogrencinin bilgilerinin silinmesi
                        cout<<"Yeni ogrencinin numarasini giriniz\n";
                        cin>>no;
                        ogrenci_var_mi=ogrenci_dizisi->noya_gore_ogrenci_var_mi(no);
                        if(ogrenci_var_mi) {
                                cout<<no<<"'lu ogrenci silindi.\n";
                                ogrenci_dizisi->nolu_ogrenciyi_sil(no);
                        } else {
                                cout<<no<<"'lu ogrenci zaten bulunmamaktadir.\n";
                        }
                        break;
                case 5://Numarasi verilen ogrencinin bilgilerinin listelenmesi
                        cout<<"Yeni ogrencinin numarasini giriniz\n";
                        cin>>no;
                        ogrenci_var_mi=ogrenci_dizisi->noya_gore_ogrenci_var_mi(no);
                        if(ogrenci_var_mi) {
                                cout<<"\nOgr No  Ad          Soyad            Sinif  Not Ort"<<endl;
                                cout<<"------  ----------  ---------------  -----  -------"<<endl;
                                cout<<ogrenci_dizisi->getOgrenci()[no-1]<<endl;
                        } else {
                                cout<<no<<"'lu ogrenci bulunmamaktadir.\n";
                        }
                        break;
                case 6://Tum ogrencilerin ogrenci numarasina gore listelenmesi
                        cout<<"\nOgr No  Ad          Soyad            Sinif  Not Ort"<<endl;
                        cout<<"------  ----------  ---------------  -----  -------"<<endl;
                        cout<<ogrenci_dizisi<<endl;
                        break;
                case 7://Bir sinifta okuyan ogrencilerin listelenmesi
                        ogrenci_dizisi->siniftaki_ogrencileri_listele();
                        break;
                case 8://Belirli bir ada sahip ogrencilerin listelenmesi
                        ogrenci_dizisi->ogrencileri_ada_gore_listele();
                        break;
                case 9://Belirli bir tarihten once dogan ogrencilerin listelenmesi
                        cin>>tarih;
                        ogrenci_dizisi->tarihe_gore_ogrenci_listele(tarih);
                        break;
                case 10://Belirli bir yildan sonra kayitlanmis ogrencileri listelenmesi
                        cout<<"Yil verisini giriniz\n";
                        cin>>yil;
                        ogrenci_dizisi->yila_gore_ogrenci_listele(yil);
                        break;
                case 11://Bir pc verilmis ogrencilerin listelenmesi
                        ogrenci_dizisi->ogrencileri_seriye_gore_listele();
                        break;
                case 12://Belirli bir marka ve modele sahip pc verilmis ogrencilerin listelenmesi
                        ogrenci_dizisi->marka_modele_gore_listele();
                        break;
                }
        } while (secenek!=13);
        return 0;
}
int menu(void)
{

        int secim;
        cout<<"\n";
        cout<<"\t**********************    MENU   ************************\n\n";
        cout<<" 1. Yeni kazanan ogrencinin okula kayitlanmasi...\n";
        cout<<" 2. Yatay gecisle gelen ogrencinin okula kayitlanmasi...\n";
        cout<<" 3. Yil sonunda ogrencilerin sýnýflarinin ve not ortlamalarinin guncellemesi.\n";
        cout<<" 4. Numarasi verilen ogrencinin bilgilerinin silinmesi\n";
        cout<<" 5. Numarasi verilen ogrencinin bilgilerinin listelenmesi\n";
        cout<<" 6. Tum ogrencilerin ogrenci numarasina gore listelenmesi\n";
        cout<<" 7. Bir sinifta okuyan ogrencilerin listelenmesi\n";
        cout<<" 8. Belirli bir ada sahip ogrencilerin listelenmesi\n";
        cout<<" 9. Belirli bir tarihten once dogan ogrencilerin listelenmesi\n";
        cout<<"10. Belirli bir yildan sonra kayitlanmis ogrencileri listelenmesi\n";
        cout<<"11. Bir pc verilmis ogrencilerin listelenmesi...\n";
        cout<<"12. Belirli bir marka ve modele sahip pc verilmis ogrencilerin listelenmesi...\n";
        cout<<"13. Cikis\n";

        do {
                cout<<"\nSeciminizi Giriniz:  ";
                cin>>secim;
        } while(secim<1 || secim>13);

        return secim;
}
