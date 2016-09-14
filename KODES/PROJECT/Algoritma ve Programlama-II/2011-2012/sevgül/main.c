#include <stdio.h>
#include <stdlib.h>

struct ucus
{
    int ucus_numarasi;
    char kalkis_yeri[21];
    char varis_yeri[21];
    int kalkis_saat;
    int kalkis_dak;
    int koltuk_kapasitesi;
    int bos_koltuk;
    float bas_bilet_fiyati;
};
typedef struct ucus ucus_type;

int main()
{
    FILE *dosya;
    ucus_type bir_ucus={0,"","",0,0,0,0,0};
    if((dosya=fopen("ucus.dat","r"))==NULL)
    {
        printf("dosya acilamadi\n");
    }
    else
    {
        rewind(dosya);

        printf("Ucus No  Kalkis yeri  Varis Yeri  Zamani  Kapasite  Bos Koltuk  Doluluk  \n");
        printf("-------  -----------  ----------  ------  --------  ----------  ---------\n");
        while(!feof(dosya))
        {

            fread(&bir_ucus, sizeof(ucus_type), 1, dosya);
            if(bir_ucus.ucus_numarasi!=0)
            {

                printf("%d#%s#%s#%d:%d#%d#%d\n", bir_ucus.ucus_numarasi, bir_ucus.kalkis_yeri, bir_ucus.varis_yeri, bir_ucus.kalkis_saat, bir_ucus.kalkis_dak,bir_ucus.koltuk_kapasitesi,
                        bir_ucus.bos_koltuk);
                //printf("%s\n", bir_ucus.kalkis_yeri);
                //printf("%s\n",bir_ucus.varis_yeri);
                //printf("%d:%d", bir_ucus.kalkis_saat, bir_ucus.kalkis_dak);
                //printf("%d\n", bir_ucus.koltuk_kapasitesi);
                //printf("%d\n", bir_ucus.bos_koltuk);
                //printf("%f\n\n\n", bir_ucus.bas_bilet_fiyati);
            }
        }
        fclose(dosya);
    }


    return 0;
}
