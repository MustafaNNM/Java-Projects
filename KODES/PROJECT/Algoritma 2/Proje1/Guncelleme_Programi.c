#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct yer_bilgileri {
        char kalkis[21];
        char varis[21];
};
struct kalkis_zamani {
        int saat;
        int dakika;
};
struct koltuk_bilgileri {
        int kapasite;
        int bos_olan;
        float fiyati;
};
struct ucus_bilgileri {
        int no;
        struct yer_bilgileri yer;
        struct kalkis_zamani kalkis;
        struct koltuk_bilgileri koltuk;
};

struct bilet_bilgileri {
        int ucus_no;
        char yolcu_tc_kimlik_no[12];
        float fiyati;
};

int main()
{
        return 0;
}
