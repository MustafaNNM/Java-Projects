#ifndef OGRENCI_H
#define OGRENCI_H

#include <iostream>
#include <iomanip>

#include "bilgisayar.h"
#include "string.h"
#include "tarih.h"

using namespace std;

class Ogrenci
{
        friend ostream &operator<<(ostream &, Ogrenci &);
        friend istream &operator>>(istream &, Ogrenci &);
        friend ostream &operator<<(ostream &, Ogrenci* &);
        friend istream &operator>>(istream &, Ogrenci* &);
private:
        int ogrenci_numarasi;
        char adi[16];
        char soyadi[21];
        Tarih dogum_tarihi;
        Tarih kayit_tarihi;
        Bilgisayar tasinabilir_bilgisayar;
        int sinifi;
        float not_ortalamasi;

public:
        //constructor
        Ogrenci();
        Ogrenci(int,char[],char[],Tarih,Tarih,Bilgisayar,int,float);
        //deconstructor
        virtual ~Ogrenci();
//sets
        void setOgrenci_numarasi(int);
        void setAdi(char[]);
        void setSoyadi(char[]);
        void setDogum_tarihi(Tarih);
        void setKayit_tarihi(Tarih);
        void setTasinabilir_bilgisayar(Bilgisayar);
        void setSinifi(int);
        void setNot_ortalamasi(float);
//gets
        int getOgrenci_numarasi();
        char* getAdi();
        char* getSoyadi();
        Tarih getDogum_tarihi();
        Tarih getKayit_tarihi();
        Bilgisayar getTasinabilir_bilgisayar();
        int getSinifi();
        float getNot_ortalamasi();
};

#endif // OGRENCI_H
