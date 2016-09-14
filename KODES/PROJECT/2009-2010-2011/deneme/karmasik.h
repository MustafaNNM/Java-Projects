//FONKSÝYON PROTOTÝPLERÝNÝ GÖSTEREN HEADER DOSYASI
#ifndef KARMASIK_H_INCLUDED
#define KARMASIK_H_INCLUDED

class karmasik {

private:

    double reel;
    double sanal;

public:

    karmasik(double=0, double=0);//DEFAUTL VARIABLES

    void reelAyarla(double);
    void sanalAyarla(double);

    double reelOku();
    double sanalOku();

    void topla(karmasik);
    void cikar(karmasik);
    void goster();
};


#endif // KARMASIK_H_INCLUDED
