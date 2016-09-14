#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    srand(time(NULL));
  //  int kalinan yer[4][];
    /*char *ad[100]={"ALI","AYSE","AHMET","ADNAN","ARIF","ALIM","ADIL","AKIF","ALEV","AFET",
                      "BELGIN","BELKIS","BETUL","BURCU","BENGU","BASAK","BARIKA","BUSRA","BINNUR","BIHTER",
                      "CANSU","CANAN","CAFER","CEMIL","CEMIL","CEZMI","CUMHUR","DELIL","DILA","DILEK"
                      "DOGAN","BARIS","ERHAN","MEHMET","SAID","FATIH","MUSTAFA","YASIN","RAMAZAN","ILAYDA"
                      "MUSLUM","BUSE","YUSUF","BEYZA","HILAL","ESRA","NEJLA","BUREYDE","OMER","OMAR"
                      "ABRAHAM","CAHID","KEMAL","GOZDE","OZGE","ILYAS","ILAYDA","IREM","GIZEM","KIYMET"
                      "FULYA","GUL","GOKCE","SEBNEM","ECE","SIMGE","MELTEM","OYKU","DENIZ","CEREN"
                      "AYDAN","ESIN","FATMA","PINAR","IKBAL","RABIA","TAHA","CAGRI","MESUT","ERCAN"
                      "NURAN","NURCAN","NAZAN","BERAT","SALIH","YIGIT","CETIN","ERMAN","HALIL","CEM"
                      "CAGDAS","ERTAN","MUZAFFER","ENGIN","BURAK","SULEYMAN","UGUR","DENIZ","BATU","BAHTIYAR"};
    char *soyad[100]={"AKARSU","GURSES","ATATURK","ERSOY","TATLISES","GUNAY","SALMAN","TAHSIN","BORAN","TAYLAN",
                      "DOSTER","UNALAN","SARANAYEV","ALTINBAS","ERDEN","ILYASOGULLARI","KAPTANOGULLARI","FIRINCIOGULLARI","KARAARSLAN","KARAASLAN",
                      "CINAL","AYKUT","SONMEZ","SEKER","BALCI","CETIN","SADIGOV","GUL","ERDOGAN","INCECAY"
                      "MEMILI","DABAN","AHMADSOY","KOKTURK","TURK","TUTUNCU","SARI","MUTI","KAYA","COSKUNER"
                      "KONUK","BAYRAKTAR","CELEGEN","ABACI","KUPELI","GULTEKIN","SARICAM","OZMEN","KARADON","KAPTIKACTI"
                      "PAR","PEKACAR","YIGIT","YUCEL","YUKSEL","AYGUN","DOGAN","TUYJI","YAZAL","OZTURK"
                      "OZEN","AYAZ","NEHIR","TUREMIS","ISIK","ERCAN","CICEK","BAL","CILEK","GENERAL"
                      "AVEA","ARIA","TURKSELIM","KANDEMIR","BILMUH","EGE","IZMIRLI","MARASLI","TARAKCIOGLU","SOZEN"
                      "NEHIR","CALISKAN","OZCALISKAN","CAVUS","ATES","KANDEMIR","CANDEMIR","BUDA","GELIR","GECER"
                      "EKIZ","YALCIN","ERGUVAN","DALKIRAN","UNVER","BERBER","KUCUK","KIZILAY","KIZILKAYA","GOKTURK"};*/
    int i=4;
    int N,n;
    int oda[4]= {0};
    char yanit;

    printf("Kac turist geldi\n?");
    scanf("%d,",&N);
    n=N;
    fflush(stdin);
    printf("Kucuk oda istediler mi\n?");
    scanf("%c",&yanit);
    if(yanit=='h'||yanit=='H')
    {
        do
        {
            if(i*5<N&&oda[i-1]<2){++oda[i-1];N-=i*5;}
            else{if(i==0){N=0;++oda[0];}--i;}
        }
        while(N>0);
    }
    else
    {
        i=1;
        do
        {
            if(oda[i-1]<2){++oda[i-1];N-=i*5;}
            else{++i;}
        }
        while(N>0);
    }
    for(i=0; i<4; i++)
    {
        printf("%2d lik odalardan %d tane kullanildi\n",5*(i+1),oda[i]);
    }
    i=1;
        do
        {
            if(oda[i-1]>0){--oda[i-1];--n;}
            else{++i;}
        }
        while(n>0);
    return main();
}
