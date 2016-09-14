#include <iostream>
#include <iomanip>

#include "ogrenci.h"
#include "bilgisayar.h"
#include "string.h"
#include "tarih.h"

using namespace std;

ostream &operator<<(ostream &output, Ogrenci & ogrenci)
{
        output<<setw(8)<<ogrenci.ogrenci_numarasi<<setw(14)<<ogrenci.adi<<setw(19)<<ogrenci.soyadi<<setw(7)<<ogrenci.sinifi<<setw(8)<<ogrenci.not_ortalamasi;
        return output;
}
istream &operator>>(istream &input, Ogrenci &ogrenci)
{
        cout<<"ogrencinin numarasini giriniz\n";
        cout<<"";
        input>>ogrenci.ogrenci_numarasi;
        cout<<"ogrencinin adini giriniz\n";
        input>>setw(16)>>ogrenci.adi;
        cout<<"ogrencinin soyadini giriniz\n";
        input>>setw(21)>>ogrenci.soyadi;
        cout<<"ogrencin dogum tarihini giriniz\n";
        input>>ogrenci.dogum_tarihi;
        cout<<"ogrencinin kayit tarihini giriniz\n";
        input>>ogrenci.kayit_tarihi;
        cout<<"ogrencinin tasinabilir bilgisayar bilgilerini giriniz\n";
        input>>ogrenci.tasinabilir_bilgisayar;
        cout<<"ogrencinin sinifini giriniz\n";
        input>>ogrenci.sinifi;
        ogrenci.not_ortalamasi=0;
        return input;
}
ostream &operator<<(ostream &output, Ogrenci* & ogrenci)
{
        output<<ogrenci->ogrenci_numarasi<<setw(14)<<ogrenci->adi<<setw(19)<<ogrenci->soyadi<<setw(7)<<ogrenci->sinifi<<setw(8)<<ogrenci->not_ortalamasi;
        return output;
}
istream &operator>>(istream &input, Ogrenci* &ogrenci)
{
        //cout<<"ogrencinin numarasini giriniz\n";
        //input>>ogrenci->ogrenci_numarasi;
        cout<<"ogrencinin adini giriniz\n";
        input>>setw(16)>>ogrenci->adi;
        cout<<"ogrencinin soyadini giriniz\n";
        input>>setw(21)>>ogrenci->soyadi;
        cout<<"ogrencin dogum tarihini giriniz\n";
        input>>ogrenci->dogum_tarihi;
        cout<<"ogrencinin kayit tarihini giriniz\n";
        input>>ogrenci->kayit_tarihi;
        cout<<"ogrencinin tasinabilir bilgisayar bilgilerini giriniz\n";
        input>>ogrenci->tasinabilir_bilgisayar;
        cout<<"ogrencinin sinifini giriniz\n";
        input>>ogrenci->sinifi;
        ogrenci->not_ortalamasi=0;
        return input;
}
Ogrenci::Ogrenci()
{
        //ctor
        setOgrenci_numarasi(0);
        setSinifi(0);
        setNot_ortalamasi(0);
}
Ogrenci::Ogrenci(int num,char ad[],char soyad[],Tarih dogum_t,Tarih kayit_t,Bilgisayar tasinabilir_b,int sinif,float not_ort)
{
        //ctor
        setOgrenci_numarasi(num);
        setAdi(ad);
        setSoyadi(soyad);
        setDogum_tarihi(dogum_t);
        setKayit_tarihi(kayit_t);
        setTasinabilir_bilgisayar(tasinabilir_b);
        setSinifi(sinif);
        setNot_ortalamasi(not_ort);
}
Ogrenci::~Ogrenci()
{
        //dtor
}
//sets
void Ogrenci::setOgrenci_numarasi(int no)
{
        ogrenci_numarasi=no;
}
void Ogrenci::setAdi(char a[])
{
    int i;
    for (i=0;i<16;i++)
    {
    	adi[i]=a[i];
    }

}
void Ogrenci::setSoyadi(char s[])
{

    int i;
    for (i=0;i<16;i++)
    {
    	soyadi[i]=s[i];
    }

}
void Ogrenci::setDogum_tarihi(Tarih d_t)
{
        dogum_tarihi=d_t;
}
void Ogrenci::setKayit_tarihi(Tarih k_t)
{
        kayit_tarihi=k_t;
}
void Ogrenci::setTasinabilir_bilgisayar(Bilgisayar t_b)
{
        tasinabilir_bilgisayar=t_b;
}
void Ogrenci::setSinifi(int s)
{
        sinifi=s;
}
void Ogrenci::setNot_ortalamasi(float n_o)
{
        not_ortalamasi=n_o;
}
//gets
int Ogrenci::getOgrenci_numarasi(void)
{
        return ogrenci_numarasi;
}
char* Ogrenci::getAdi(void)
{
        return adi;
}
char* Ogrenci::getSoyadi(void)
{
        return soyadi;
}
Tarih Ogrenci::getDogum_tarihi(void)
{
        return dogum_tarihi;
}
Tarih Ogrenci::getKayit_tarihi(void)
{
        return kayit_tarihi;
}
Bilgisayar Ogrenci::getTasinabilir_bilgisayar(void)
{
        return tasinabilir_bilgisayar;
}
int Ogrenci::getSinifi(void)
{
        return sinifi;
}
float Ogrenci::getNot_ortalamasi(void)
{
        return not_ortalamasi;
}

