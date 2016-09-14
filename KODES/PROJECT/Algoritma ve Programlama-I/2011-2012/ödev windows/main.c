#include <stdio.h>
#include <stdlib.h>


struct ham_madde {
        int urun_no;
        struct urun* urunler;
        struct ara_urun* ara_urunler;
        struct ham_madde* ham_maddeler;
};
struct ara_urun {
        int urun_no;
        struct urun* urunler;
        struct ara_urun* ara_urunler;
        struct ham_madde* ham_maddeler;
};
struct urun {
        int urun_no;
        struct urun* urunler;
        struct ara_urun* ara_urunler;
        struct ham_madde* ham_maddeler;
};

int main()
{
        struct urun* urun_listesi;

        urun_listesi=malloc(sizeof(struct urun));
        urun_listesi->urun_no=0;
        struct urun bes_urun[5];
        int i;
        for(i=0; i<5; i++) {
                bes_urun[i].urun_no=i+1;
        }
        urun_listesi->urunler=bes_urun;
        printf("besinci urunun nosu: %d\n",urun_listesi->urunler[4].urun_no);

        return 0;
}
