#include <iostream>
#include <iomanip>
#include "tarih.h"
using namespace std;
  Tarih::Tarih(int g,int a,int y): gun(g),ay(a),yil(y){}
  bool Tarih::operator<(const Tarih &karsilastirilan) const//küçüklük karsilastirma
  {
      if(yil<karsilastirilan.yil)
      return true;

      if(yil==karsilastirilan.yil&&ay<karsilastirilan.ay)
      return true;

      if(yil==karsilastirilan.yil&&ay==karsilastirilan.ay&&gun<karsilastirilan.gun)
      return true;

      return false;
  }
  bool Tarih::operator>(const Tarih &karsilastirilan) const//büyüklük karsilastirma
  {
      if(yil>karsilastirilan.yil)
      return true;

      if(yil==karsilastirilan.yil&&ay>karsilastirilan.ay)
      return true;

      if(yil==karsilastirilan.yil&&ay==karsilastirilan.ay&&gun>karsilastirilan.gun)
      return true;

      return false;
  }
  bool Tarih::operator==(const Tarih &karsilastirilan) const//eþitlik karsilastirma
  {
      if(gun==karsilastirilan.gun&&ay==karsilastirilan.ay&&karsilastirilan.yil)
      return true;

      return false;
  }
  ostream &operator<<(ostream &output,const Tarih &date){output<<date.gun<<"."<<date.ay<< "."<<date.yil;return output;}
  int Tarih::getgun() const{return gun;}
  int Tarih::getay() const{return ay;}
  int Tarih::getyil() const{return yil;}
