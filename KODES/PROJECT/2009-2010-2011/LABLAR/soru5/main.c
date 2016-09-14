#include <stdio.h>
#include <stdlib.h>

#define SALON_SAY 5
#define KAPASITE 50


struct aday {
    int no;
    char ad_soyad[21];
    int boy;
};
typedef struct aday Aday;
void d_ekle(Aday *kuyruk, int *on, int *arka,Aday yeni);
Aday d_sil(Aday *kuyruk, int *on, int *arka);
char bos_mu(int on);
void d_listele(Aday *kuyruk, int on, int arka);
int menu_secim(void);
int main()
{
    Aday kuyruk[SALON_SAY][KAPASITE];//kuyruklar icin, herbiri 50 elemanli olan 5 adet vektorden olusan vektor
    int on[SALON_SAY],arka[SALON_SAY];//kuyruklarin on ve arkalarini belirtmek icin 5'er elemanli vektorler
    Aday bir_aday;
    int salon_no,i,secenek;

    for(i=0;i<SALON_SAY;i++) {//kuyruklar ilkleniyor
        on[i]=-1;
        arka[i]=-1;
    }
	do {
        secenek=menu_secim();
        switch(secenek) {
            case 1:
                printf("Adayin numarasini giriniz:");
                scanf("%d",&bir_aday.no);
                printf("Adayin adini soyadini giriniz:");
                fflush(stdin);
                gets(bir_aday.ad_soyad);
                printf("Adayin boyunu giriniz:");
                scanf("%d",&bir_aday.boy);
                salon_no=(bir_aday.no-1)/100+1;//adayin beklemesi gereken salon bulunuyor
                d_ekle(kuyruk[salon_no-1],&on[salon_no-1],&arka[salon_no-1],bir_aday);//aday, ilgili salondaki kuyrugun sonuna ekleniyor
                break;
            case 2:
                printf("Salon numarasini giriniz:");
                scanf("%d",&salon_no);
                if (bos_mu(on[salon_no-1])=='y') {//salon bos degilse...
                    bir_aday=d_sil(kuyruk[salon_no-1],&on[salon_no-1],&arka[salon_no-1]);//o salondan siradaki aday sinava cagriliyor
                    printf("Aday No  Ad Soyad              Boy\n");
                    printf("-------  --------------------  ---\n");
                    printf("%-7d  %-20s  %d\n",bir_aday.no,bir_aday.ad_soyad,bir_aday.boy);
                }
                else
                    printf("Bu salon bos\n");
                break;
            case 3:
                printf("Salon numarasini giriniz:");
                scanf("%d",&salon_no);
                if (bos_mu(on[salon_no-1])=='y')//salon bos degilse...
                    d_listele(kuyruk[salon_no-1],on[salon_no-1],arka[salon_no-1]);//o salonda bekleyen tum adaylar gelis sirasina gore listeleniyor
                else
                    printf("Bu salon bos\n");
                break;
        }
    } while (secenek!=4);

    return 0;
}
int menu_secim(void)
{
    int c;
    printf("\n");
    printf("********************MENU************************************\n");
    printf("            1. Bir adayin uygun salona alinmasi\n");
    printf("            2. Bir salondan siradaki adayin sinava cagrilmasi\n");
    printf("            3. Bir salonda bekleyen adaylarin listelenmesi\n");
    printf("            4. Cikis\n");
    printf("\n");
    do {
        printf("\nSeciminizi Giriniz:  ");
        scanf("%d", &c);
    }while(c<0 || c>4);

    return c;
}

void d_ekle(Aday *kuyruk, int *on, int *arka,Aday yeni)
{
    if((*arka+1)%KAPASITE==*on)
        printf("Salon dolu!\n");
    else {
        *arka=(*arka+1)%KAPASITE;//kuyruk dairesel olarak kullaniliyor
        kuyruk[*arka]=yeni;
        if(*on==-1) *on=0;//ilk eleman ekleniyorsa
    }
}
Aday d_sil(Aday *kuyruk, int *on, int *arka)
{
    Aday gecici;

    gecici=kuyruk[*on];
    if(*on==*arka) {//son eleman siliniyorsa
        *on=-1;
        *arka=-1;
    }
    else *on=(*on+1)%KAPASITE;//kuyruk dairesel olarak kullaniliyor

    return gecici;
}
char bos_mu(int on)
{
    if(on==-1)
        return 'd';//kuyruk bossa d(dogru) dondur
    else
        return 'y';//kuyruk bos degilse y(yanlis) dondur
}
void d_listele(Aday *kuyruk, int on, int arka)//on ve arka call-by-value ile aktariliyor
{
    printf("Aday No  Ad Soyad              Boy\n");
    printf("-------  --------------------  ---\n");
    while(on!=arka) {
        printf("%-7d  %-20s  %d\n",kuyruk[on].no,kuyruk[on].ad_soyad,kuyruk[on].boy);
        on=(on+1)%KAPASITE;//on 1 oteleniyor ama main'deki on degismiyor
    };
    printf("%-7d  %-20s  %d\n",kuyruk[on].no,kuyruk[on].ad_soyad,kuyruk[on].boy);//son eleman yazdiriliyor
}
