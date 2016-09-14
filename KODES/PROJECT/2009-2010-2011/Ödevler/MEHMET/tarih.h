#ifndef TARIH_H_INCLUDED
#define TARIH_H_INCLUDED
#include <iostream>
#include <iomanip>
using namespace std;
class Tarih {
    friend ostream &operator<<( ostream&, const Tarih & );
    //�ye olmayan a��r� y�kleme fonksiyonu
  private:
  const int gun,ay,yil;
  public:
  //Constructor
  Tarih(int,int,int);
  //�ye a��r� y�kleme fonksiyonlar�
  bool operator<(const Tarih &) const;//k���kl�k karsilastirma
  bool operator>(const Tarih &) const;//b�y�kl�k karsilastirma
  bool operator<=(const Tarih &karsilastirilan) const//k���k e�itlik karsilastirma
  { return !(*this>karsilastirilan); }
  bool operator>=(const Tarih &karsilastirilan) const//b�y�k e�itlik karsilastirma
  { return !(*this<karsilastirilan); }
  bool operator==(const Tarih &) const;//e�itlik karsilastirma
  //get functions
  int Tarih::getgun() const;
  int Tarih::getay() const;
  int Tarih::getyil() const;
};
#endif // TARIH_H_INCLUDED
