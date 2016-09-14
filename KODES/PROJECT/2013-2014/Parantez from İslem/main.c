#include <stdio.h>
#include <stdlib.h>
//#include <conio.h>
#include <math.h>

float birinci_sayi=0;
float ikinci_sayi=0;
float ucuncu_sayi=0;
char islem;
void menu(void);
float karekok_parantez(void);
void calculator(void);
float topla(float birinci_sayi);
float cikar(float birinci_sayi);
float carp(float birinci_sayi);
float bol(float birinci_sayi);
float ussunu_al(float birinci_sayi);
float karekok(void);
float ilk_islem_arti(float birinci_sayi);
float ilk_islem_eksi(float birinci_sayi);
float parantez(void);
int main()
{
    calculator();
    return 0;
}
void menu(void)
{
    char *s=" yerine kullanilmaktadir.)\n";
    printf("Islem onceligi yuksek olan islemleri:{'*' ve '/' islemlerini}\nparantez icerisinde yapiniz!\n");
    printf("Ayrica ilk islem olarak 0 sayisini girmeniz\ntum islemlere direk olarak olanak verir.\n");
    printf("Her parantezden once ve icine girilince 0 yazilmasi mecburidir!\nNOT:Istisnalari vardir\n");
    printf("Parantezleri kapatirken } karakterini kullaniniz\n");
    printf("Kapatmaniz gereken parantez sayisina dikkat edin!\n");
    printf("Kapatilabilinecek parantez/ler varsa\nislem seciniz: mesaji ile karsilasirsiniz\n");
    printf("a,e,c,b,u ve k parantez '{' olarak sayilmaktadir.\n");
    printf("Yuksek dereceli islemler yaparken\nparantezle baslamaniz gerekebilir\n");
    printf("Programin destekledigi islemler:\n");
    printf("+ islemi\n- islemi\n* islemi\n/ islemi\n");
    printf("@ islemi ( +&{}^0.5%s",s);
    printf("é islemi ( -&{}^0.5%s",s);
    printf("m islemi ( *&{}^0.5%s",s);
    printf("d islemi ( /&{}^0.5%s",s);
    printf("a islemi ( +{%s",s);
    printf("e islemi ( -{%s",s);
    printf("c islemi ( *{%s",s);
    printf("b islemi ( /{%s",s);
    printf("u islemi ( ^{}%s",s);
    printf("} islemi parantezi kapatir\n\n");
}
float topla(float birinci_sayi)
{
    float ikinci_sayi;
    printf("Sayi:");
    scanf("%f",&ikinci_sayi);

    return birinci_sayi;
}
float cikar(float birinci_sayi)
{
    float ikinci_sayi;
    printf("Sayi:");
    scanf("%f",&ikinci_sayi);
    return birinci_sayi;
}
float carp(float birinci_sayi)
{
    float ikinci_sayi;
    printf("Sayi:");
    scanf("%f",&ikinci_sayi);
    return birinci_sayi*ikinci_sayi;
}
float bol(float birinci_sayi)
{
    float ikinci_sayi;
    printf("Sayi:");
    scanf("%f",&ikinci_sayi);
    return birinci_sayi/ikinci_sayi;
}
float ussunu_al(float birinci_sayi)
{
    float us;
    printf("Sayi:");
    scanf("%f",&us);
    return pow(birinci_sayi,us);
}
float karekok(void)
{
    float birinci_sayi;
    printf("Sayi:");
    scanf("%f",&birinci_sayi);
    return sqrt(birinci_sayi);
}
float ilk_islem_arti(float birinci_sayi)
{
    //ilk islem arti
    printf("Sayi:");
    scanf("%f",&ikinci_sayi);//b
    islem=getchar();//ikinci islem
    switch(islem) { //ikinci islem hangisi
    case '+'://artidan sonra ki islem arti
        birinci_sayi=ilk_islem_arti(birinci_sayi+ikinci_sayi);
        ikinci_sayi=0;
        break;
    case '-'://artidan sonra ki islem eksi
        sonuc+=ikinci_sayi;
        ikinci_sayi=0;
        break;
    case '*'://artidan sonra ki islem carpi
        sonuc=carp(ikinci_sayi);
        ikinci_sayi=0;
        break;
    case '/'://artidan sonra ki islem bolu
        sonuc=bol(ikinci_sayi);
        ikinci_sayi=0;
        break;
    case 'u'://artidan sonra ki islem parantezli us alma
        sonuc=pow(ikinci_sayi,parantez());
        ikinci_sayi=0;
        break;
    case '@'://artidan sonra ki islem arti karekok parantez
        sonuc+=ikinci_sayi;
        ikinci_sayi=0;
        sonuc+=karekok();
        break;
    case 'é'://artidan sonra ki islem eksi karekok parantez
        sonuc+=ikinci_sayi;
        ikinci_sayi=0;
        sonuc-=karekok();
        break;
    case 'm'://artidan sonra ki islem carpi karekok parantez
        sonuc+=ikinci_sayi;
        ikinci_sayi=0;
        sonuc*=karekok();
        break;
    case 'd'://artidan sonra ki islem bolu karekok parantez
        sonuc+=ikinci_sayi;
        ikinci_sayi=0;
        sonuc/=karekok();
        break;
    case 'a'://artidan sonra ki islem arti parantez
        sonuc+=ikinci_sayi;
        ikinci_sayi=0;
        sonuc+=parantez();
        break;
    case 'e'://artidan sonra ki islem eksi parantez
        sonuc+=ikinci_sayi;
        ikinci_sayi=0;
        sonuc-=parantez();
        break;
    case 'c'://artidan sonra ki islem carpi parantez
        sonuc+=ikinci_sayi;
        ikinci_sayi=0;
        sonuc*=parantez();
        break;
    case 'b'://artidan sonra ki islem bolu parantez
        sonuc+=ikinci_sayi;
        ikinci_sayi=0;
        sonuc/=parantez();
        break;
    default://a+b islemi
        islem='}';
        birinci_sayi+=sonuc;//a+b
        break;
    }
    break;
}
float ilk_islem_eksi(float birinci_sayi)
{
    do {
        printf("Sayi:");
        scanf("%f",&ikinci_sayi);
        islem=getchar();//ikinci islem
        switch(islem) { //ikinci islem hangisi
        case '+'://eksiden sonra ki islem arti
            sonuc-=ikinci_sayi;
            ikinci_sayi=0;
            break;
        case '-'://eksiden sonra ki islem eksi
            sonuc-=ikinci_sayi;
            ikinci_sayi=0;
            break;
        case '*'://eksiden sonra ki islem carpi
            sonuc=carp(ikinci_sayi);
            ikinci_sayi=0;
            break;
        case '/'://eksiden sonra ki islem bolu
            sonuc=bol(ikinci_sayi);
            ikinci_sayi=0;
            break;
        case 'u'://artidan sonra ki islem parantezli us alma
            sonuc=pow(ikinci_sayi,parantez());
            ikinci_sayi=0;
            break;
        case '@'://eksiden sonra ki islem arti karekok parantez
            sonuc-=ikinci_sayi;
            ikinci_sayi=0;
            sonuc+=karekok();
            break;
        case 'é'://eksiden sonra ki islem eksi karekok parantez
            sonuc-=ikinci_sayi;
            ikinci_sayi=0;
            sonuc-=karekok();
            break;
        case 'm'://eksiden sonra ki islem carpi karekok parantez
            sonuc-=ikinci_sayi;
            ikinci_sayi=0;
            sonuc*=karekok();
            break;
        case 'd'://eksiden sonra ki islem bolu karekok parantez
            sonuc-=ikinci_sayi;
            ikinci_sayi=0;
            sonuc/=karekok();
            break;
        case 'a'://eksiden sonra ki islem arti parantez
            sonuc-=ikinci_sayi;
            ikinci_sayi=0;
            sonuc+=parantez();
            break;
        case 'e'://eksiden sonra ki islem eksi parantez
            sonuc-=ikinci_sayi;
            ikinci_sayi=0;
            sonuc-=parantez();
            break;
        case 'c'://eksiden sonra ki islem carpi parantez
            sonuc-=ikinci_sayi;
            ikinci_sayi=0;
            sonuc*=parantez();
            break;
        case 'b'://eksiden sonra ki islem bolu parantez
            sonuc-=ikinci_sayi;
            ikinci_sayi=0;
            sonuc/=parantez();
            break;
        default:// a-b islemi
            islem='}';
            birinci_sayi-=sonuc;
            break;
        }
    } while(islem!='}');

}
float parantez(void)
{
    float sonuc=0;
    printf("Sayi:");
    scanf("%f",&birinci_sayi);//a
    islem=getchar();//ilk islem
    switch(islem) { //ilk islem hangisi
    case '+'://ilk islem arti
        ilk_islem_arti(birinci_sayi);
        break;
    case '-'://ilk islem eksi
        ilk_islem_eksi(birinci_sayi);
        break;
    case '*'://ilk islem carpi

        printf("Sayi:");
        scanf("%f",&ikinci_sayi);
        islem=getchar();//ikinci islem
        switch(islem) { //ikinci islem hangisi
        case '+'://carpidan sonra ki islem arti
            /*ilk iki sayi carpilmali sonuc bir sayi olacagindan ilk islem arti ya benzer*/
            ilk_islem_arti(birinci_sayi*ikinci_sayi);
            break;
        case '-'://carpidan sonra ki islem eksi
            break;
        case '*'://carpidan sonra ki islem carpi
            break;
        case '/'://carpidan sonra ki islem bolu
            break;
        case 'p'://carpidan sonra ki islem pozitif us alma
            break;
        case 'u'://artidan sonra ki islem parantezli us alma
            sonuc=pow(ikinci_sayi,parantez());
            break;
        case '@'://carpidan sonra ki islem arti karekok parantez
            break;
        case 'é'://carpidan sonra ki islem eksi karekok parantez
            break;
        case 'm'://carpidan sonra ki islem carpi karekok parantez
            break;
        case 'd'://carpidan sonra ki islem bolu karekok parantez
            break;
        case 'a'://carpidan sonra ki islem arti parantez
            break;
        case 'e'://carpidan sonra ki islem eksi parantez
            break;
        case 'c'://carpidan sonra ki islem carpi parantez
            break;
        case 'b'://carpidan sonra ki islem bolu parantez
            break;
        default:// a*b islemi
            islem='}';
            birinci_sayi*=ikinci_sayi;
            break;
        }
        break;
    case '/'://ilk islem bolu
        do {
            printf("Sayi:");
            scanf("%f",&ikinci_sayi);
            islem=getchar();//ikinci islem
            switch(islem) {//ikinci islem hangisi
            case '+'://bolumden sonra ki islem arti
                break;
            case '-'://bolumden sonra ki islem eksi
                break;
            case '*'://bolumden sonra ki islem carpi
                break;
            case '/'://bolumden sonra ki islem bolu
                break;
            case 'p'://bolumden sonra ki islem pozitif us alma
                break;
            case 'u'://artidan sonra ki islem parantezli us alma
                sonuc=pow(ikinci_sayi,parantez());
                break;
            case '@'://bolumden sonra ki islem arti karekok parantez
                break;
            case 'é'://bolumden sonra ki islem eksi karekok parantez
                break;
            case 'm'://bolumden sonra ki islem carpi karekok parantez
                break;
            case 'd'://bolumden sonra ki islem bolu karekok parantez
                break;
            case 'a'://bolumden sonra ki islem arti parantez
                break;
            case 'e'://bolumden sonra ki islem eksi parantez
                break;
            case 'c'://bolumden sonra ki islem carpi parantez
                break;
            case 'b'://bolumden sonra ki islem bolu parantez
                break;
            default:// a/b islemi
                islem='}';
                birinci_sayi/=sonuc;
                break;
            }
        } while(islem!='}');
        break;
    case 'p'://ilk islem pozitif us alma
        printf("Sayi:");
        scanf("%f",&ikinci_sayi);
        islem=getchar();//ikinci islem
        switch(islem) {//ikinci islem hangisi
        case '+'://pozitif us almadan sonra ki islem arti
            break;
        case '-'://pozitif us almadan sonra ki islem eksi
            break;
        case '*'://pozitif us almadan sonra ki islem carpi
            break;
        case '/'://pozitif us almadan sonra ki islem bolu
            break;
        case 'p'://pozitif us almadan sonra ki islem pozitif us alma
            break;
        case 'u'://artidan sonra ki islem parantezli us alma
            sonuc=pow(ikinci_sayi,parantez());
            break;
        case '@'://pozitif us almadan sonra ki islem arti karekok parantez
            break;
        case 'é'://pozitif us almadan sonra ki islem eksi karekok parantez
            break;
        case 'm'://pozitif us almadan sonra ki islem carpi karekok parantez
            break;
        case 'd'://pozitif us almadan sonra ki islem bolu karekok parantez
            break;
        case 'a'://pozitif us almadan sonra ki islem arti parantez
            break;
        case 'e'://pozitif us almadan sonra ki islem eksi parantez
            break;
        case 'c'://pozitif us almadan sonra ki islem carpi parantez
            break;
        case 'b'://pozitif us almadan sonra ki islem bolu parantez
            break;
        default://a^b islemi
            islem='}';
            birinci_sayi^=ikinci_sayi;
            break;
        }
        break;
    case 'u'://ilk islem parantezli us alma
        birinci_sayi=pow(birinci_sayi,parantez());
        break;
    case '@'://ilk islem arti karekok parantez
        printf("Sayi:");
        scanf("%f",&ikinci_sayi);
        islem=getchar();//ikinci islem
        switch(islem) {//ikinci islem hangisi
        case '+'://arti karekok parantezden sonra ki islem arti
            break;
        case '-'://arti karekok parantezden sonra ki islem eksi
            break;
        case '*'://arti karekok parantezden sonra ki islem carpi
            break;
        case '/'://arti karekok parantezden sonra ki islem bolu
            break;
        case 'p'://arti karekok parantezden sonra ki islem pozitif us alma
            break;
        case 'u'://arti karekok parantezden sonra ki islem negatif us alma
            sonuc=pow(ikinci_sayi,parantez());
            break;
        case '%'://arti karekok parantezden sonra ki islem mod alma
            //pozitif olmasi gerekir
            break;
        case '@'://arti karekok parantezden sonra ki islem arti karekok parantez
            break;
        case 'é'://arti karekok parantezden sonra ki islem eksi karekok parantez
            break;
        case 'm'://arti karekok parantezden sonra ki islem carpi karekok parantez
            break;
        case 'd'://arti karekok parantezden sonra ki islem bolu karekok parantez
            break;
        case 'a'://arti karekok parantezden sonra ki islem arti parantez
            break;
        case 'e'://arti karekok parantezden sonra ki islem eksi parantez
            break;
        case 'c'://arti karekok parantezden sonra ki islem carpi parantez
            break;
        case 'b'://arti karekok parantezden sonra ki islem bolu parantez
            break;
        default:// a+&b islemi
            islem='}';
            break;
        }
        break;
    case 'é'://ilk islem eksi karekok parantez
        printf("Sayi:");
        scanf("%f",&ikinci_sayi);
        islem=getchar();//ikinci islem
        switch(islem) {//ikinci islem hangisi
        case '+'://eksi karekok parantezden sonra ki islem arti
            break;
        case '-'://eksi karekok parantezden sonra ki islem eksi
            break;
        case '*'://eksi karekok parantezden sonra ki islem carpi
            break;
        case '/'://eksi karekok parantezden sonra ki islem bolu
            break;
        case 'p'://eksi karekok parantezden sonra ki islem pozitif us alma
            break;
        case 'u'://eksi karekok parantezden sonra ki islem negatif us alma
            sonuc=pow(ikinci_sayi,parantez());
            break;
        case '%'://eksi karekok parantezden sonra ki islem mod alma
            //pozitif olmasi gerekir
            break;
        case '@'://eksi karekok parantezden sonra ki islem arti karekok parantez
            break;
        case 'é'://eksi karekok parantezden sonra ki islem eksi karekok parantez
            break;
        case 'm'://eksi karekok parantezden sonra ki islem carpi karekok parantez
            break;
        case 'd'://eksi karekok parantezden sonra ki islem bolu karekok parantez
            break;
        case 'a'://eksi karekok parantezden sonra ki islem arti parantez
            break;
        case 'e'://eksi karekok parantezden sonra ki islem eksi parantez
            break;
        case 'c'://eksi karekok parantezden sonra ki islem carpi parantez
            break;
        case 'b'://eksi karekok parantezden sonra ki islem bolu parantez
            break;
        default:// a-&b islemi
            islem='}';
            break;
        }
        break;
    case 'm'://ilk islem carpi karekok parantez
        printf("Sayi:");
        scanf("%f",&ikinci_sayi);
        islem=getchar();//ikinci islem
        switch(islem) {//ikinci islem hangisi
        case '+'://carpi karekok parantezden sonra ki islem arti
            break;
        case '-'://carpi karekok parantezden sonra ki islem eksi
            break;
        case '*'://carpi karekok parantezden sonra ki islem carpi
            break;
        case '/'://carpi karekok parantezden sonra ki islem bolu
            break;
        case 'p'://carpi karekok parantezden sonra ki islem pozitif us alma
            break;
        case 'u'://artidan sonra ki islem parantezli us alma
            sonuc=pow(ikinci_sayi,parantez());
            break;
        case '%'://carpi karekok parantezden sonra ki islem mod alma
            //pozitif olmasi gerekir
            break;
        case '@'://carpi karekok parantezden sonra ki islem arti karekok parantez
            break;
        case 'é'://carpi karekok parantezden sonra ki islem eksi karekok parantez
            break;
        case 'm'://carpi karekok parantezden sonra ki islem carpi karekok parantez
            break;
        case 'd'://carpi karekok parantezden sonra ki islem bolu karekok parantez
            break;
        case 'a'://carpi karekok parantezden sonra ki islem arti parantez
            break;
        case 'e'://carpi karekok parantezden sonra ki islem eksi parantez
            break;
        case 'c'://carpi karekok parantezden sonra ki islem carpi parantez
            break;
        case 'b'://carpi karekok parantezden sonra ki islem bolu parantez
            break;
        default:// a*&b islemi
            islem='}';
            break;
        }
        break;
    case 'd'://ilk islem bolu karekok parantez
        printf("Sayi:");
        scanf("%f",&ikinci_sayi);
        islem=getchar();//ikinci islem
        switch(islem) {//ikinci islem hangisi
        case '+'://bolu karekok parantezden sonra ki islem arti
            break;
        case '-'://bolu karekok parantezden sonra ki islem eksi
            break;
        case '*'://bolu karekok parantezden sonra ki islem carpi
            break;
        case '/'://bolu karekok parantezden sonra ki islem bolu
            break;
        case 'p'://bolu karekok parantezden sonra ki islem pozitif us alma
            break;
        case 'u'://artidan sonra ki islem parantezli us alma
            sonuc=pow(ikinci_sayi,parantez());
            break;
        case '%'://bolu karekok parantezden sonra ki islem mod alma
            //pozitif olmasi gerekir
            break;
        case '@'://bolu karekok parantezden sonra ki islem arti karekok parantez
            break;
        case 'é'://bolu karekok parantezden sonra ki islem eksi karekok parantez
            break;
        case 'm'://bolu karekok parantezden sonra ki islem carpi karekok parantez
            break;
        case 'd'://bolu karekok parantezden sonra ki islem bolu karekok parantez
            break;
        case 'a'://bolu karekok parantezden sonra ki islem arti parantez
            break;
        case 'e'://bolu karekok parantezden sonra ki islem eksi parantez
            break;
        case 'c'://bolu karekok parantezden sonra ki islem carpi parantez
            break;
        case 'b'://bolu karekok parantezden sonra ki islem bolu parantez
            break;
        default:// a/&b islemi
            islem='}';
            break;
        }
        break;
    case 'a'://ilk islem arti parantez
        printf("Sayi:");
        scanf("%f",&ikinci_sayi);
        islem=getchar();//ikinci islem
        switch(islem) {//ikinci islem hangisi
        case '+'://arti parantezden sonra ki islem arti
            break;
        case '-'://arti parantezden sonra ki islem eksi
            break;
        case '*'://arti parantezden sonra ki islem carpi
            break;
        case '/'://arti parantezden sonra ki islem bolu
            break;
        case 'p'://arti parantezden sonra ki islem pozitif us alma
            break;
        case 'u'://arti parantezden sonra ki islem negatif us alma
            sonuc=pow(ikinci_sayi,parantez());
            break;
        case '%'://arti parantezden sonra ki islem mod alma
            //pozitif olmasi gerekir
            break;
        case '@'://arti parantezden sonra ki islem arti karekok parantez
            break;
        case 'é'://arti parantezden sonra ki islem eksi karekok parantez
            break;
        case 'm'://arti parantezden sonra ki islem carpi karekok parantez
            break;
        case 'd'://arti parantezden sonra ki islem bolu karekok parantez
            break;
        case 'a'://arti parantezden sonra ki islem arti parantez
            break;
        case 'e'://arti parantezden sonra ki islem eksi parantez
            break;
        case 'c'://arti parantezden sonra ki islem carpi parantez
            break;
        case 'b'://arti parantezden sonra ki islem bolu parantez
            break;
        default:// a+{...} islemi
            islem='}';
            break;
        }
        break;
    case 'e'://ilk islem eksi parantez
        printf("Sayi:");
        scanf("%f",&ikinci_sayi);
        islem=getchar();//ikinci islem
        switch(islem) {//ikinci islem hangisi
        case '+'://eksi parantezden sonra ki islem arti
            break;
        case '-'://eksi parantezden sonra ki islem eksi
            break;
        case '*'://eksi parantezden sonra ki islem carpi
            break;
        case '/'://eksi parantezden sonra ki islem bolu
            break;
        case 'p'://eksi parantezden sonra ki islem pozitif us alma
            break;
        case 'u'://eksi parantezden sonra ki islem negatif us alma
            sonuc=pow(ikinci_sayi,parantez());
            break;
        case '%'://eksi parantezden sonra ki islem mod alma
            //pozitif olmasi gerekir
            break;
        case '@'://eksi parantezden sonra ki islem arti karekok parantez
            break;
        case 'é'://eksi parantezden sonra ki islem eksi karekok parantez
            break;
        case 'm'://eksi parantezden sonra ki islem carpi karekok parantez
            break;
        case 'd'://eksi parantezden sonra ki islem bolu karekok parantez
            break;
        case 'a'://eksi parantezden sonra ki islem arti parantez
            break;
        case 'e'://eksi parantezden sonra ki islem eksi parantez
            break;
        case 'c'://eksi parantezden sonra ki islem carpi parantez
            break;
        case 'b'://eksi parantezden sonra ki islem bolu parantez
            break;
        default:// a-{...} islemi
            islem='}';
            break;
        }
        break;
    case 'c'://ilk islem carpi parantez
        printf("Sayi:");
        scanf("%f",&ikinci_sayi);
        islem=getchar();//ikinci islem
        switch(islem) {//ikinci islem hangisi
        case '+'://carpi parantezden sonra ki islem arti
            break;
        case '-'://carpi parantezden sonra ki islem eksi
            break;
        case '*'://carpi parantezden sonra ki islem carpi
            break;
        case '/'://carpi parantezden sonra ki islem bolu
            break;
        case 'p'://carpi parantezden sonra ki islem pozitif us alma
            break;
        case 'u'://carpi parantezden sonra ki islem negatif us alma
            sonuc=pow(ikinci_sayi,parantez());
            break;
        case '%'://carpi parantezden sonra ki islem mod alma
            //pozitif olmasi gerekir
            break;
        case '@'://carpi parantezden sonra ki islem arti karekok parantez
            break;
        case 'é'://carpi parantezden sonra ki islem eksi karekok parantez
            break;
        case 'm'://carpi parantezden sonra ki islem carpi karekok parantez
            break;
        case 'd'://carpi parantezden sonra ki islem bolu karekok parantez
            break;
        case 'a'://carpi parantezden sonra ki islem arti parantez
            break;
        case 'e'://carpi parantezden sonra ki islem eksi parantez
            break;
        case 'c'://carpi parantezden sonra ki islem carpi parantez
            break;
        case 'b'://carpi parantezden sonra ki islem bolu parantez
            break;
        default:// a*{...} islemi
            islem='}';
            break;
        }
        break;
    case 'b'://ilk islem bolu parantez
        printf("Sayi:");
        scanf("%f",&ikinci_sayi);
        islem=getchar();//ikinci islem
        switch(islem) {//ikinci islem hangisi
        case '+'://bolu parantezden sonra ki islem arti
            break;
        case '-'://bolu parantezden sonra ki islem eksi
            break;
        case '*'://bolu parantezden sonra ki islem carpi
            break;
        case '/'://bolu parantezden sonra ki islem bolu
            break;
        case 'p'://bolu parantezden sonra ki islem pozitif us alma
            break;
        case 'u'://bolu parantezden sonra ki islem negatif us alma
            sonuc=pow(ikinci_sayi,parantez());
            break;
        case '%'://bolu parantezden sonra ki islem mod alma
            //pozitif olmasi gerekir
            break;
        case '@'://bolu parantezden sonra ki islem arti karekok parantez
            break;
        case 'é'://bolu parantezden sonra ki islem eksi karekok parantez
            break;
        case 'm'://bolu parantezden sonra ki islem carpi karekok parantez
            break;
        case 'd'://bolu parantezden sonra ki islem bolu karekok parantez
            break;
        case 'a'://bolu parantezden sonra ki islem arti parantez
            break;
        case 'e'://bolu parantezden sonra ki islem eksi parantez
            break;
        case 'c'://bolu parantezden sonra ki islem carpi parantez
            break;
        case 'b'://bolu parantezden sonra ki islem bolu parantez
            break;
        default:// a/{...} islemi
            islem='}';
            break;
        }
        break;
    default://hic bir islem yapilmadiysa
        // { a } islemi
        islem='}';
        break;
    }
    while(islem!='}');
    return birinci_sayi;//sonuc
}
float karekok_parantez(void)
{
    float birinci_sayi;
    birinci_sayi=parantez();
    return sqrt(birinci_sayi);
}
void calculator(void)
{
    float answer=0;
    menu();
    do {
        printf("{\n");
        answer=parantez();
        printf("sonuc:%.3f\n",answer);
        fflush(stdin);
        printf("Devam etsin mi {Cikis {#}}\n?");
    } while(getchar()!='#');
    //fflush(stdin);printf("Kapatmak icin bir tusa basin...");getch();
}
