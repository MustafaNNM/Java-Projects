#include <iostream>
#include <iomanip>

#include "string.h"
#include "bilgisayar.h"

using namespace std;

ostream &operator<<(ostream &output, Bilgisayar &bilgisayar)
{
        output<<bilgisayar.getSeri()<<" "<<bilgisayar.getMarka()<<" "<<bilgisayar.getModel();
        return output;
}
istream &operator>>(istream  &input, Bilgisayar &bilgisayar)
{
    cout<<"seri noyu giriniz\n";
    input>>bilgisayar.seri;
    cout<<"seri marka giriniz\n";
    input>>bilgisayar.marka;
    cout<<"seri model giriniz\n";
    input>>bilgisayar.model;
    return input;
}
ostream &operator<<(ostream &output, Bilgisayar* &bilgisayar)
{
        output<<bilgisayar->getSeri()<<" "<<bilgisayar->getMarka()<<" "<<bilgisayar->getModel();
        return output;
}
istream &operator>>(istream  &input, Bilgisayar* &bilgisayar)
{
    cout<<"seri noyu giriniz\n";
    input>>bilgisayar->seri;
    cout<<"seri marka giriniz\n";
    input>>bilgisayar->marka;
    cout<<"seri model giriniz\n";
    input>>bilgisayar->model;
    return input;
}
Bilgisayar::Bilgisayar()
{
        //ctor
}
Bilgisayar::Bilgisayar(char seri_num[],char ma[],char mo[])
{
        //ctor
        setSeri(seri_num);
        setMarka(ma);
        setModel(mo);
}
Bilgisayar::~Bilgisayar()
{
        //dtor
}
//sets
void Bilgisayar::setSeri(char s[])
{
      int i;
    for (i=0;i<13;i++)
    {
    	seri[i]=s[i];
    }
}
void Bilgisayar::setMarka(char ma[])
{
     int i;
    for (i=0;i<16;i++)
    {
    	marka[i]=ma[i];
    }
}
void Bilgisayar::setModel(char mo[])
{
     int i;
    for (i=0;i<16;i++)
    {
    	model[i]=mo[i];
    }
}
//gets
char* Bilgisayar::getSeri(void)
{
        return seri;
}
char* Bilgisayar::getMarka(void)
{
        return marka;
}
char* Bilgisayar::getModel(void)
{
        return model;
}
