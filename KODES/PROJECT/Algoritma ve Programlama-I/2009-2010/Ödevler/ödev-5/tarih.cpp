#include <iostream>

using namespace std;
#include <iomanip>
using std::setw;
using std::setfill;

#include "Tarih.h"

Tarih::Tarih(int arg_gun,int arg_ay,int arg_yil) : gun(arg_gun),ay(arg_ay),yil(arg_yil)
{
    //Tarih s�n�f� i�in constractor metodum
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
{// = operat�r�ne aa��r� y�kleme yaparak atama yap�yorum
    gun = atanan.gun;
    ay = atanan.ay;
    yil = atanan.yil;

    return *this;
}
bool Tarih::operator==(const Tarih &trh) const
{ // == operat�r�n� tarih s�n�f� i�in a��r� y�kl�yorum
    if(gun==trh.gun && ay==trh.ay && yil==trh.ay)
        return true;
    else return false;
}
bool Tarih::operator < (const Tarih &trh) const
{// < operat�r�n�n a��r� y�klenmesi
    if(yil< trh.yil)
        return true;//soldaki de�er kucukse true d�nd�r
    else if(yil == trh.yil)
    {
        if(this->ay< trh.ay)
            return true;//soldaki de�er kucukse true d�nd�r
        else if(this->ay == trh.ay)
        {
            if(this->gun< trh.gun)
                return true;//soldaki de�er kucukse true d�nd�r
            else return false;//soldaki de�er buyukse false d�nd�r
        }
        else return false;//soldaki de�er buyukse false d�nd�r
    }
    else return false;//soldaki de�er buyukse false d�nd�r
}
bool Tarih::operator > (const Tarih &trh) const
{// > operat�r�n�n a��r� y�klenmesi
    if(yil > trh.yil)
        return true;//soldaki de�er b�y�kse true d�nd�r
    else if(yil == trh.yil)
    {//Y�l de�eri e�itse
        if(ay> trh.ay)//soldaki de�er b�y�kse true d�nd�r
            return true;//soldaki de�er b�y�kse true d�nd�r
        else if(ay == trh.ay)
        {//ay de�eri i�itse
            if(gun> trh.gun)
                return true;//soldaki de�er b�y�kse true d�nd�r
            else return false;//soldaki de�er k���kse false d�nd�r
        }
        else return false;//soldaki de�er k���kse false d�nd�r
    }
    else return false;//soldaki de�er k���kse false d�nd�r
}
ostream &operator<<(ostream &cikti, const Tarih &trh)
{ //   << operatoru tarih s�n�f� i�in a��r� y�kleniyor
    cout.fill('0');
    cikti <<setw(2)<<trh.gun<<'-'<<setw(2)<<trh.ay << '-' <<setw(4)<<trh.yil;
    cikti<<setfill(' ');
            //Sonu� olarak ��kt�m : gg-aa-yyyy �eklinde olacakt�r
    return cikti;
}
istream &operator>>(istream &girdi,Tarih &trh)
{//Rahat girdiler i�in >> operat�r�n� tarih s�n�f� i�in a��r� y�kl�yorum
    girdi>>setw(3)>>trh.gun;//2 haneli g�n de�erini al�yorum
    girdi.ignore(1);//Aradaki ayrac� atl�yorum ( / - . , gibi ay�ra�lar olabilir)
    girdi>>setw(3)>>trh.ay;//2 haneli ay de�erini al�yorum
    girdi.ignore(1);//aradaki ayrac� atl�yorum
    girdi>>setw(0)>>trh.yil;//4 haneli y�l de�erini al�yorum
            //�stteki ad�mda setw(0) dememin sebebi, daha sonra yap�lacak girdilerde karakter s�n�rlamas� olmamas�n� sa�lamakt�r.
    return girdi;
}
