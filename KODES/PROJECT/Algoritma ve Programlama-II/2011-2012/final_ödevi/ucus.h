#ifndef UCUS_H
#define UCUS_H

#include <iostream>
#include <iomanip>

using namespace std;

class Ucus
{
    friend ostream &operator<<(ostream &cikti, const Ucus &ucus);
    friend istream &operator>>(istream &girdi, Ucus &ucus);
public:
        Ucus();
        Ucus(int no,int normal,int luks);
        Ucus(int no,char *kalkis,char *varis,char *zaman,int normal,int luks);
        virtual ~Ucus();
        //set functions
        void setKalkis_yeri(char *);
        void setVaris_yeri(char *);
        void setKalkis_zamani(char *);
        void setSonraki_ucus(Ucus *);
        void setAda_gore_sonraki_ucus(Ucus *);
        void setAda_gore_onceki_ucus(Ucus *);
        //get functions
        int getUcus_no();
        char *getKalkis_yeri();
        char *getVaris_yeri();
        char *getKalkis_zamani();
        int getNormal_ks();
        int getLuks_ks();
        Ucus* getSonraki_ucus();
        Ucus* getAda_gore_sonraki_ucus();
        Ucus* getAda_gore_onceki_ucus();
protected:
private:
        const int ucus_no;
        char kalkis_yeri[21];
        char varis_yeri[21];
        char kalkis_zamani[6];
        int normal_ks;
        int luks_ks;
        Ucus* sonraki_ucus;//uçuþ numarasýna göre küçükten büyüðe doðru sýralý
        Ucus* ada_gore_sonraki_ucus;
        Ucus* ada_gore_onceki_ucus;
};

#endif // UCUS_H
