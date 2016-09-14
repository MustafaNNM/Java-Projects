#ifndef ADAY_H_INCLUDED
#define ADAY_H_INCLUDED

class Aday {
private:
    const int no;
    const int boy;
    Aday *sonraki;
public:
    Aday(int, int);

    int noOku();
    int boyOku();
    Aday *sonrakiOku();

    void sonrakiAyarla(Aday *);

    void yazdir();
};

#endif // ADAY_H_INCLUDED
