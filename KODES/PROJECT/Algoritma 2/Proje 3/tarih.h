#ifndef TARIH_H_INCLUDED
#define TARIH_H_INCLUDED

#include <iostream>
#include <iomanip>

using namespace std;

class Tarih
{
        friend ostream &operator<<(ostream &,const Tarih &);//iostream ile friend ettiðim overloading fonksiyonlarý
        friend istream &operator>>(istream &,Tarih &);
        friend ostream &operator<<(ostream &,const Tarih* &);//iostream ile friend ettiðim overloading fonksiyonlarý
        friend istream &operator>>(istream &,Tarih* &);
private:
        int gun;
        int ay;
        int yil;
public:
        Tarih();
        Tarih(int,int,int);//Varsayýlan deðerlerimi atýyorum
        //set methots
        void setGun(int);
        void setAy(int);
        void setYil(int);
        //get methots
        int getGun(void);//private gun deðerini döndüren fonksiyonum
        int getAy(void);//private ay deðerini döndüren fonksiyonum
        int getYil(void);//private yil deðerini döndüren fonksiyonum
        //Operatörlerimi aþýrý yüklüyorum (Operator overloading)
        const Tarih& operator=(const Tarih &);//atama
        bool operator == (const Tarih&) const;
        bool operator != (const Tarih& trh) const {
                return !(*this==trh);
        }
        bool operator < (const Tarih&) const;
        bool operator > (const Tarih&) const;
        bool operator <= (const Tarih& trh) const {
                return !(*this>trh);
        }
        bool operator >= (const Tarih& trh) const {
                return !(*this<trh);
        }

};


#endif // TARIH_H_INCLUDED
