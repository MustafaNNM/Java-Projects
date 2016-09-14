#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
	char metin[1000];
	char yeni_metin[1000]="";
	char aranan[30];
	char yerine_konan[30];
	char *bulunan_konum;//arama sonucunu tutacak isaretci
	char *arama_baslangici;//metnin aramaya baslanacak konumunu gosteren isaretci
	int uzunluk,bulunma_sayisi=0;

	printf("Metin: ");gets(metin);
	printf("Aranan metin parcasi: ");gets(aranan);
    printf("Yeni metin parcasi: ");gets(yerine_konan);
	uzunluk=strlen(aranan);//aranan kelimenin karakter sayisi bir degiskene ataniyor
	arama_baslangici=metin;//aramaya metnin ilk karakterinden baslanacak
	printf("\nBulundugu konumlar: ");
	do {
	    bulunan_konum=strstr(arama_baslangici,aranan);//metinde kaldigin yerden itibaren yeni bir arama yap
	    if (bulunan_konum!=NULL) {//bulunursa...
	        bulunma_sayisi++;
	        printf("%d ",bulunan_konum-metin+1);
	        //once, metnin arama baslangicindan bulunan konuma kadar olan karakterlerini yeni metne bitistir.
	        strncat(yeni_metin,arama_baslangici,bulunan_konum-arama_baslangici);
	        strcat(yeni_metin,yerine_konan);//sonra, yeni metin parcasini yeni metne bitistir.
	        arama_baslangici=bulunan_konum+uzunluk;//aramaya bulunan metnin sagindan devam edilecek...
	    }
	} while (bulunan_konum!=NULL);
	strcat(yeni_metin,arama_baslangici);//metnin, son bulunan metin parcasindan sonraki karakterlerini de yeni metne bitistir.
	printf("\nBulunma sayisi: %d\n",bulunma_sayisi);
	printf("\nYeni metin: %s\n",yeni_metin);
	return 0;
}
