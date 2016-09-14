#include <iostream>
#include <cstdio>
#include <cstring>
#include "string.h"


String::String()
{
        //ctor
}
String::String(int u)
{
        //ctor
        uzunluk=21;
        ptr=new char[uzunluk];
}

String::~String()
{
        //dtor

}

void String::setUzunluk(int u)
{
        uzunluk=u;
}
int String::getUzunluk(void)
{
        return uzunluk;
}
bool String::operator==(const String &a)
{
        if(strcmp(ptr,a.ptr)==0)
                return true;
        else return false;
}
bool String::operator!=(String &a)
{
        if(strcmp(ptr,a.ptr)!=0)
                return true;
        else return false;
}
bool String::operator<(String &a)
{
        if(strcmp(ptr,a.ptr)<0)
                return true;
        else return false;
}
bool String::operator>(const String &a)
{
        if(strcmp(ptr,a.ptr)>0)
                return true;
        else return false;
}
bool String::operator<=(String &a)
{
        if(strcmp(ptr,a.ptr)<=0)
                return true;
        else return false;
}

bool String::operator>=(String &a)
{
        if(strcmp(ptr,a.ptr)>=0)
                return true;
        else return false;
}

char &String::operator[](int sira)
{
        return ptr[sira];
}

istream &operator>>(istream &girdi,String &a)
{
        girdi>>setw(a.getUzunluk())>>a;
        return girdi;
}
ostream &operator<<(ostream &cikti,const String &a)
{
        for(int i=0; i<a.uzunluk; i++) {
                if(a.ptr[i]!='\0') {
                        cikti<<a.ptr[i];
                } else {
                        break;
                }
        }
        return cikti;
}
istream &operator>>(istream &girdi,String* &a)
{
         char b;
        for(int i=0; i<a->uzunluk; i++) {
                girdi>>b;
                girdi.clear();
                if(b!='\n') {
                        a->ptr[i]=b;
                        break;
                } else {
                        a->ptr[i]='\0';
                        printf("ASCII b:%d\n",b);
                }
        }
        return girdi;
}
ostream &operator<<(ostream &cikti,const String* &a)
{
        for(int i=0; i<a->uzunluk; i++) {
                if(a->ptr[i]!='\0')
                {
                    cikti<<a->ptr[i];
                }
                else {break;}
        }
        return cikti;
}
