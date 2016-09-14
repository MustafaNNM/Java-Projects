#include <iostream>

using namespace std;
#include <iomanip>
using std::setw;
using std::setfill;

#include "Tarih.h"

Tarih::Tarih(int arg_gun,int arg_ay,int arg_yil) : gun(arg_gun),ay(arg_ay),yil(arg_yil)
{
    //Tarih sýnýfý için constractor metodum
}
int Tarih::getGun()
{
    return gun;
}
int Tarih::getAy()
{
    return ay;
}
int Tarih::getYil()
{
    return yil;
}
const Tarih& Tarih::operator=(const Tarih &atanan)
{// = operatörüne aaþýrý yükleme yaparak atama yapýyorum
    gun = atanan.gun;
    ay = atanan.ay;
    yil = atanan.yil;

    return *this;
}
bool Tarih::operator==(const Tarih &trh) const
{ // == operatörünü tarih sýnýfý için aþýrý yüklüyorum
    if(gun==trh.gun && ay==trh.ay && yil==trh.ay)
        return true;
    else return false;
}
bool Tarih::operator < (const Tarih &trh) const
{// < operatörünün aþýrý yüklenmesi
    if(yil< trh.yil)
        return true;//soldaki deðer kucukse true döndür
    else if(yil == trh.yil)
    {
        if(this->ay< trh.ay)
            return true;//soldaki deðer kucukse true döndür
        else if(this->ay == trh.ay)
        {
            if(this->gun< trh.gun)
                return true;//soldaki deðer kucukse true döndür
            else return false;//soldaki deðer buyukse false döndür
        }
        else return false;//soldaki deðer buyukse false döndür
    }
    else return false;//soldaki deðer buyukse false döndür
}
bool Tarih::operator > (const Tarih &trh) const
{// > operatörünün aþýrý yüklenmesi
    if(yil > trh.yil)
        return true;//soldaki deðer büyükse true döndür
    else if(yil == trh.yil)
    {//Yýl deðeri eþitse
        if(ay> trh.ay)//soldaki deðer büyükse true döndür
            return true;//soldaki deðer büyükse true döndür
        else if(ay == trh.ay)
        {//ay deðeri iþitse
            if(gun> trh.gun)
                return true;//soldaki deðer büyükse true döndür
            else return false;//soldaki deðer küçükse false döndür
        }
        else return false;//soldaki deðer küçükse false döndür
    }
    else return false;//soldaki deðer küçükse false döndür
}
ostream &operator<<(ostream &cikti, const Tarih &trh)
{ //   << operatoru tarih sýnýfý için aþýrý yükleniyor
    cout.fill('0');
    cikti <<setw(2)<<trh.gun<<'-'<<setw(2)<<trh.ay << '-' <<setw(4)<<trh.yil;
    cikti<<setfill(' ');
            //Sonuþ olarak çýktým : gg-aa-yyyy þeklinde olacaktýr
    return cikti;
}
istream &operator>>(istream &girdi,Tarih &trh)
{//Rahat girdiler için >> operatörünü tarih sýnýfý için aþýrý yüklüyorum
    girdi>>setw(3)>>trh.gun;//2 haneli gün deðerini alýyorum
    girdi.ignore(1);//Aradaki ayracý atlýyorum ( / - . , gibi ayýraçlar olabilir)
    girdi>>setw(3)>>trh.ay;//2 haneli ay deðerini alýyorum
    girdi.ignore(1);//aradaki ayracý atlýyorum
    girdi>>setw(0)>>trh.yil;//4 haneli yýl deðerini alýyorum
            //Üstteki adýmda setw(0) dememin sebebi, daha sonra yapýlacak girdilerde karakter sýnýrlamasý olmamasýný saðlamaktýr.
    return girdi;
}
