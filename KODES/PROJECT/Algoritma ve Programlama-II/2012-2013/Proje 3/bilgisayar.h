#ifndef BILGISAYAR_H
#define BILGISAYAR_H

#include <iostream>
#include <iomanip>

#include "string.h"

using namespace std;

class Bilgisayar
{
        friend ostream &operator<<(ostream &, Bilgisayar &);
        friend istream &operator>>(istream  &, Bilgisayar &);
        friend ostream &operator<<(ostream &, Bilgisayar* &);
        friend istream &operator>>(istream  &, Bilgisayar* &);
private:
        char seri[13];
        char marka[11];
        char model[11];
public:
        //constructor
        Bilgisayar();
        Bilgisayar(char[],char[],char[]);
        //deconstructor
        virtual ~Bilgisayar();
//sets
        void setSeri(char[]);
        void setMarka(char[]);
        void setModel(char[]);
//gets
        char* getSeri(void);
        char* getMarka(void);
        char* getModel(void);
};

#endif // BILGISAYAR_H
