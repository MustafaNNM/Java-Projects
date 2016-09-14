#include <iostream>

using namespace std;

#include "aday.h"

Aday::Aday(int arg_no, int arg_boy) : no(arg_no),boy(arg_boy)//const veri uyeleri ilkleniyor
{
    sonraki=NULL;
}

int Aday::noOku()
{
    return no;
}

int Aday::boyOku()
{
    return boy;
}

Aday *Aday::sonrakiOku()
{
    return sonraki;
}

void Aday::sonrakiAyarla(Aday *arg_sonraki)
{
    sonraki=arg_sonraki;
}

void Aday::yazdir()
{
    cout << "   " << no << "    " << boy << endl;
}
