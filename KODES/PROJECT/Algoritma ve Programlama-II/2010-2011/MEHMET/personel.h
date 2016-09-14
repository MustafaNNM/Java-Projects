#ifndef PERSONEL_H_INCLUDED
#define PERSONEL_H_INCLUDED
#include <iostream>
#include "tarih.h"
class Personel {
  private:
  const int personel_no,
  sure;//Di�er kurumlardaki hizmet s�resi (g�n)
  char ad[13],//diziler const yap�lmayacak
  soyad[13],//diziler const yap�lmayacak
  unvan[13];//diziler const yap�lmayacak
  float m_k;//maa� katsay�s� de�i�tirilebilir oldu�u i�in const de�il
  Personel *sonraki;//personel noya g�re sonrakini g�steren ptr
  Personel *sonraki_tarih;//tarihe g�re sonrakini g�steren ptr
  Personel *onceki_tarih;//tarihe g�re �ncekini g�steren ptr
  const Tarih d_tarih;//do�um tarihi
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
