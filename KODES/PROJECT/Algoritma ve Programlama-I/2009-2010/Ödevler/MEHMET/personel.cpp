#include <iostream>
#include <iomanip>
using namespace std;
#include "tarih.h"
#include "personel.h"
  //Constructor
  Personel::Personel(int p_no,int s,
  char *fname,char *lname,char *nick,
  float m_k,
  int d_gun,int d_ay,int d_yil,
  int a_gun,int a_ay,int a_yil)
  : personel_no(p_no),//const variables
  sure(s),//const variables
  d_tarih(d_gun,d_ay,d_yil),//const variables
  a_tarih(a_gun,a_ay,a_yil)//const variables
  {setpersonel(fname,lname,nick,m_k);sonraki=NULL;sonraki_tarih=NULL;onceki_tarih=NULL;}
  //set functions
  void Personel::setpersonel(char *fname,char *lname,char *nick,float mk){setad(fname);setsoyad(lname);setunvan(nick);setm_k(mk);}
  void Personel::setad(char *fname){int length=strlen(fname);length =(length<13?length:12);strncpy(ad,fname,length);ad[length]='\0';}
  void Personel::setsoyad(char *lname){int length=strlen(lname);length=(length<13?length:12);strncpy(soyad,lname,length);soyad[length]='\0';}
  void Personel::setunvan(char *nick){int length=strlen(nick);length=(length<13?length:12);strncpy(unvan,nick,length);unvan[length]='\0';}
  void Personel::setm_k(float mk){m_k=mk;}
  void Personel::sonraki_ayarla(Personel *arg){sonraki=arg;}
  void Personel::sonraki_tarih_ayarla(Personel *arg){sonraki_tarih=arg;}
  void Personel::onceki_tarih_ayarla(Personel *arg){onceki_tarih=arg;}
  //get functions
  int Personel::getpersonel_no() const{return personel_no;}
  int Personel::getsure() const{return sure;}
  char Personel::getad() const{return *ad;}
  char Personel::getsoyad() const{return *soyad;}
  char Personel::getunvan() const{return *unvan;}
  float Personel::getm_k() const{return m_k;}
  Tarih Personel::getd_tarih() const{return d_tarih;}
  Tarih Personel::geta_tarih() const{return a_tarih;}
  Personel *Personel::sonrakioku(){return sonraki;}
  Personel *Personel::sonraki_tarih_oku(){return sonraki_tarih;}
  Personel *Personel::onceki_tarih_oku(){return onceki_tarih;}
  ostream &operator<<(ostream& output,const Personel &personel){
      output<<personel.personel_no<<" "<<personel.ad
      <<" "<<personel.soyad<<" "<<personel.unvan<<
      " "<<personel.m_k<<" "<<personel.sure<<" "<<
      personel.d_tarih<<" "<<personel.a_tarih;
      return output;
  }
