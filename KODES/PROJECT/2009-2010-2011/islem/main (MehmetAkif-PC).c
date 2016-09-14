#include <stdio.h>
#include <stdlib.h>
//#include <conio.h>
#include <math.h>


void menu(void);
void islem(void);
float topla(float sayi);
float cikar(float sayi);
float carp(float sayi);
float bol(float sayi);
float ussunu_al(float sayi);
float karekok(void);
float parantez(void);
int main()
{
    islem();
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
    printf("^ islemi (us alma islemi)\n");
    printf("& islemi (karekok alma islemi)\n");
    printf("a islemi ( +{%s",s);
    printf("e islemi ( -{%s",s);
    printf("c islemi ( *{%s",s);
    printf("b islemi ( /{%s",s);
    printf("u islemi ( ^{%s",s);
    printf("k islemi ( {}^0.5%s",s);
}
float topla(float sayi)
{
    float yeni_sayi;
    printf("Sayi:");
    scanf("%f",&yeni_sayi);
    return sayi+yeni_sayi;
}
float cikar(float sayi)
{
    float yeni_sayi;
    printf("Sayi:");
    scanf("%f",&yeni_sayi);
    return sayi-yeni_sayi;
}
float carp(float sayi)
{
    float yeni_sayi;
    printf("Sayi:");
    scanf("%f",&yeni_sayi);
    return sayi*yeni_sayi;
}
float bol(float sayi)
{
    float yeni_sayi;
    printf("Sayi:");
    scanf("%f",&yeni_sayi);
    return sayi/yeni_sayi;
}
float ussunu_al(float sayi)
{
    float us;
    printf("Sayi:");
    scanf("%f",&us);
    return pow(sayi,us);
}
float karekok(void)
{
    float sayi;
    printf("Sayi:");
    scanf("%f",&sayi);
    return sqrt(sayi);
}
float parantez(void)
{
    float sayi;
    char islem;
    printf("Sayi:");
    scanf("%f",&sayi);
    do
    {
        fflush(stdin);
        printf("islem seciniz:");
        islem=getchar();
        switch (islem)
        {
        case '+':sayi=topla(sayi);break;
        case '-':sayi=cikar(sayi);break;
        case '*':sayi=carp(sayi);break;
        case '/':sayi=bol(sayi);break;
        case '^':sayi=ussunu_al(sayi);break;
        case '&':sayi=karekok();break;
        case 'a':sayi+=parantez();break;
        case 'e':sayi-=parantez();break;
        case 'c':sayi*=parantez();break;
        case 'b':sayi/=parantez();break;
        case 'u':sayi=pow(sayi,parantez());break;
        case 'k':sayi=sqrt(parantez());break;
        }
    }
    while(islem!='}');

    return sayi;
}
void islem(void)
{
    float sayi;
    menu();
    do
    {
        printf("{\n");sayi=parantez();printf("sonuc:%.3f\n",sayi);fflush(stdin);
        printf("Devam etsin mi {Cikis {#}}\n?");
    }
    while(getchar()!='#');
    //fflush(stdin);printf("Kapatmak icin bir tusa basin...");getch();
}
