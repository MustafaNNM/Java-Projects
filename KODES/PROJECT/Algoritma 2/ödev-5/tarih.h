#ifndef TARIH_H_INCLUDED
#define TARIH_H_INCLUDED

#include <iostream>
#include <iomanip>

using std::ostream;
using std::istream;

class Tarih{
    friend ostream &operator<<(ostream &, const Tarih &);//iostream ile friend ettiðim overloading fonksiyonlarý
    friend istream &operator>>(istream &,Tarih &);
private:
    int gun;
    int ay;
    int yil;
public:
    Tarih(int=0,int=0,int=0);//Varsayýlan deðerlerimi atýyorum

    int getGun();//private gun deðerini döndüren fonksiyonum
    int getAy();//private ay deðerini döndüren fonksiyonum
    int getYil();//private yil deðerini döndüren fonksiyonum

    //Operatörlerimi aþýrý yüklüyorum (Operator overloading)
    const Tarih& operator=(const Tarih &);//atama
    bool operator == (const Tarih&) const;
    bool operator != (const Tarih& trh) const
    {return !(*this==trh);}
    bool operator < (const Tarih&) const;
    bool operator > (const Tarih&) const;
    bool operator <= (const Tarih& trh) const
    {return !(*this>trh);}
    bool operator >= (const Tarih& trh) const
    {return !(*this<trh);}

};


#endif // TARIH_H_INCLUDED
