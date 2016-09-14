#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#define MAX 20
int oncelik_bul(char karakter);
void ortaek_sonek_donustur(char *ortaek, char *sonek);
int hesapla(char *sonek);
void push(int *yigin, int *tepe, int yeni);
int pop(int *yigin, int *tepe);
int tepe_eleman(int *yigin, int tepe);
char bos_mu(int tepe);
int main()
{
    char ortaek[MAX], sonek[MAX],devam;
    do
    {
    printf("Ortaek ifadeyi giriniz: ");
    scanf("%s",ortaek);
    ortaek_sonek_donustur(ortaek,sonek);
    printf("Girilen ortaek ifadenin sonek ifadeye cevrilmis hali: %s\n",sonek);
    printf("Girilen ifadenin sonucu: %d\n",hesapla(sonek));
    printf("Devam etmek istiyor musunuz{[e/E]/[h/H]}\n?");
    fflush(stdin);
    devam=getchar();
    }while(devam=='e'||devam=='E');
    return 0;
}
void ortaek_sonek_donustur(char *ortaek, char *sonek)
{
    int yigin[MAX];//yiginda karakterlerin ascii kodu saklanacak...
    int tepe=-1;
    int i,j=0;
    push(yigin,&tepe,ortaek[0]);//ilk karakterin ascii kodu direk yigina ekleniyor
    for(i=1;ortaek[i]!='\0';i++)//ortaek ifadenin sonuna kadar...
    {
        //eldeki karakterin onceligi yiginin tepesindekinin onceliginden buyukse yigina ekle
        if(oncelik_bul(ortaek[i])>oncelik_bul(tepe_eleman(yigin,tepe)))
            push(yigin,&tepe,ortaek[i]);
        else
        {
            do
            {
                //yigin bosalincaya kadar ya da eldekinin onceliginden daha kucuk oncelige sahip
                //bir elemana rastlayincaya kadar yigindan al ve sonek ifadeye ekle
                sonek[j]=pop(yigin,&tepe);
                j++;
            } while(bos_mu(tepe)=='y' && oncelik_bul(tepe_eleman(yigin,tepe))>=oncelik_bul(ortaek[i]));
            push(yigin,&tepe,ortaek[i]);//eldekini yigina ekle
        }
     }
    //yiginda kalanlar sonek ifadeye ekle
    while(bos_mu(tepe)=='y')
    {
        sonek[j]=pop(yigin,&tepe);
        j++;
    }
    sonek[j]='\0';//sonek ifade string haline getiriliyor
    return;
}
int oncelik_bul(char karakter)
{
    int oncelik=0;
    if(isalnum(karakter)!=0)//karakter, bir harf ya da rakam ise
        oncelik=3;
    else
        switch (karakter)
        {
            case '*': case '/': oncelik=2; break;
            case '+': case '-': oncelik=1; break;
        }
    return oncelik;
}

void push(int *yigin, int *tepe, int yeni)
{
    //hem donusturme hem hesaplamada ayni push fonksiyonu (tamsayi ekleyen) kullaniliyor
    //donusturme isleminde yigina ekleme yapilirken karakterin ascii kodu eklenmektedir
    if(*tepe==MAX-1)
        printf("yigin dolu!\n");
    else
    {
        *tepe=*tepe+1;
        yigin[*tepe]=yeni;
    }
    return;
}

int pop(int *yigin, int *tepe)
{
    //hem donusturme hem hesaplamada ayni pop fonksiyonu (tamsayi donduren) kullaniliyor
    //donusturme isleminde yigindan alinan sayi karaktere cevrilerek kullanilmaktadir.
    int gecici;
    gecici=yigin[*tepe];
    *tepe=*tepe-1;
    return gecici;
}

int tepe_eleman(int *yigin, int tepe)//tepedeki elemani silmeden dondur
{
    return yigin[tepe];
}

char bos_mu(int tepe)
{
    if(tepe==-1)
        return 'd';//yigin bossa d(dogru) dondur
    else
        return 'y';//yigin bos degilse y(yanlis) dondur
}

int hesapla(char *sonek)
{
    int yigin[MAX];
    int tepe=-1;
    int i,sayi,operand1,operand2;
    char rakam[2];//atoi() fonksiyonuna string tipinde parametre gondermek icin kullanilacak

    rakam[1]='\0';
    for(i=0;sonek[i]!='\0';++i)
    {
        if(isdigit(sonek[i]))//karakter, rakam ise...
        {
            rakam[0]=sonek[i];
            push(yigin,&tepe,atoi(rakam));//sayiya donustur ve yigina ekle
        }
        else
            if(isalpha(sonek[i]))//karakter, harf ise...
            {
                printf("%c nin degerini giriniz(tamsayi): ",sonek[i]);
                scanf("%d",&sayi);//kullanicidan degiskenin degerini al
                push(yigin,&tepe,sayi);//ve yigina ekle
            }
            else//karakter, bir islem operatoru ise...
            {
                operand2=pop(yigin,&tepe);
                operand1=pop(yigin,&tepe);
                switch(sonek[i])//islemi yap ve sonucunu yigina ekle
                {
                    case '*': push(yigin,&tepe,operand1*operand2); break;
                    case '/': push(yigin,&tepe,operand1/operand2); break;//tam bolme yapiliyor!
                    case '+': push(yigin,&tepe,operand1+operand2); break;
                    case '-': push(yigin,&tepe,operand1-operand2); break;
                }
            }
     }
    return pop(yigin,&tepe);//yiginda kalan son eleman sonek ifadenin sonucudur
}
