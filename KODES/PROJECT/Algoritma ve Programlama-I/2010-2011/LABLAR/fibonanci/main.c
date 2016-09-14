#include <stdio.h>
#include <stdlib.h>


extern int main();

extern int main()
{
    int sayi=0;
    int a[2]= {0};
    int b[2]= {0};
    int istenen=0;

    printf("Kacinci fibonanci sayisini goruntulemek istersiniz:{0}Cikis");
    scanf("%d",&istenen);
    if(istenen==0){
        exit(EXIT_SUCCESS);
    }else{
    do {
        sayi=2;
        a[0]=0;
        a[1]=1;

        if(istenen==1||istenen==2) {
            printf("%d\n",a[(istenen+1)%2]);//birinci kat
            fflush(stdin);
        } else {
            do {
                b[0]=a[0]+a[1];//1
                b[1]=b[0]+a[1];//2
                a[0]=b[0];//1
                a[1]=b[1];//2
                istenen-=2;
                if(istenen==1||istenen==2) {
                    printf("%d\n",a[(istenen+1)%2]);//birinci kat
                    fflush(stdin);
                } else {
                    b[0]=0;//0
                    b[1]=0;//0
                }
            } while(0<istenen-sayi);
        }
        printf("Kacinci fibonanci sayisini goruntulemek istersiniz:");
        scanf("%d",&istenen);
    } while(istenen!=0);
    exit(EXIT_SUCCESS);
    }
    return 0;
}
