#ifndef PERSONEL_H_INCLUDED
#define PERSONEL_H_INCLUDED
#include <iostream>
#include "tarih.h"
class Personel {
  private:
  const int personel_no,
  sure;//Diðer kurumlardaki hizmet süresi (gün)
  char ad[13],//diziler const yapýlmayacak
  soyad[13],//diziler const yapýlmayacak
  unvan[13];//diziler const yapýlmayacak
  float m_k;//maaþ katsayýsý deðiþtirilebilir olduðu için const deðil
  Personel *sonraki;//personel noya göre sonrakini gösteren ptr
  Personel *sonraki_tarih;//tarihe göre sonrakini gösteren ptr
  Personel *onceki_tarih;//tarihe göre öncekini gösteren ptr
  const Tarih d_tarih;//doðum tarihi
  const Tarih a_tarih;//atanma tarihi
  public:
  //Constructor
  Personel(int,int,char *,char *,char *,float,int,int,int,int,int,int);
  //set functions
  void setpersonel(char *,char *,char *,float);
  void setad(char *);
  void setsoyad(char *);
  void setunvan(char *);
  void setm_k(float);
  void sonraki_ayarla(Personel *);
  void sonraki_tarih_ayarla(Personel *);
  void onceki_tarih_ayarla(Personel *);
  //get functions
  int getpersonel_no() const;//returns personel_no
  int getsure() const;//returns sure
  char getad() const;//returns ad
  char getsoyad() const;//returns soyad
  char getunvan() const;//returns unvan
  float getm_k() const;//returns m_k
  Tarih getd_tarih() const;//returns d_tarih
  Tarih geta_tarih() const;//returns a_tarih
  friend ostream &operator<<( ostream&, const Personel & );
  Personel *sonrakioku();
  Personel *sonraki_tarih_oku();
  Personel *onceki_tarih_oku();
};
#endif // PERSONEL_H_INCLUDED
