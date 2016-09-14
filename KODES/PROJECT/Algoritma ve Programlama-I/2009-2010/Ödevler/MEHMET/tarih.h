#ifndef TARIH_H_INCLUDED
#define TARIH_H_INCLUDED
#include <iostream>
#include <iomanip>
using namespace std;
class Tarih {
    friend ostream &operator<<( ostream&, const Tarih & );
    //üye olmayan aþýrý yükleme fonksiyonu
  private:
  const int gun,ay,yil;
  public:
  //Constructor
  Tarih(int,int,int);
  //üye aþýrý yükleme fonksiyonlarý
  bool operator<(const Tarih &) const;//küçüklük karsilastirma
  bool operator>(const Tarih &) const;//büyüklük karsilastirma
  bool operator<=(const Tarih &karsilastirilan) const//küçük eþitlik karsilastirma
  { return !(*this>karsilastirilan); }
  bool operator>=(const Tarih &karsilastirilan) const//büyük eþitlik karsilastirma
  { return !(*this<karsilastirilan); }
  bool operator==(const Tarih &) const;//eþitlik karsilastirma
  //get functions
  int Tarih::getgun() const;
  int Tarih::getay() const;
  int Tarih::getyil() const;
};
#endif // TARIH_H_INCLUDED
