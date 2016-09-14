//(YAPICI) CONSTRUCTOR METHOD , GET-SET METHOD AND TO STRING MEDHOD
#include <iostream>

using namespace std;

#include "karmasik.h"

karmasik::karmasik(double r, double s)
{
    reelAyarla(r);
    sanalAyarla(s);
}

void karmasik::reelAyarla(double r)
{
    reel=r;
}

void karmasik::sanalAyarla(double s)
{
    sanal=s;
}

double karmasik::reelOku()
{
    return reel;
}

double karmasik::sanalOku()
{
    return sanal;
}

void karmasik::topla(karmasik toplanan)
{
    reel+=toplanan.reelOku();
    sanal+=toplanan.sanalOku();
}

void karmasik::cikar(karmasik cikan)
{
    reel-=cikan.reelOku();
    sanal-=cikan.sanalOku();
}

void karmasik::goster()
{
    cout << '(' << reel << ", " << sanal << ')' << endl;
}
