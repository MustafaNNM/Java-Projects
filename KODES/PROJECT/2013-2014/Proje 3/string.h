#ifndef STRING_H
#define STRING_H

using namespace std;

#include <iomanip>
#include <iostream>

class String
{
private:
        int uzunluk;
        char *ptr;
public:
        String();
        String(int);
        void setUzunluk(int);
        int getUzunluk(void);
        virtual ~String();
        bool operator==(const String &);
        bool operator!=(String &);
        bool operator<(String &);
        bool operator>(const String &);
        bool operator<=(String &);
        bool operator>=(String &);
        friend istream &operator>>(istream &,String &);
        friend ostream &operator<<(ostream &,const String &);
        friend istream &operator>>(istream &,String* &);
        friend ostream &operator<<(ostream &,const String* &);
        char &operator[](int);

};

#endif // STRING_H
