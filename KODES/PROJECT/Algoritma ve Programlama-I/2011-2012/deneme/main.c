#include <stdio.h>
#include <stdlib.h>
#define X 2
void yazdir(int boyut,int **dizi[boyut]);

int main()
{
        int N=4;
        int **dizi[N/2];
        //int a[3]={1,2,3};
        //int b[4]={4,5,6,7};

        {
                int a[][2]= {{1,2},{3,4}};
                int *ptr=&a[0][0];
                dizi[0]=&ptr;
        }
        {
                int a[][3]= {{1,2,3},{4,5,6}};
                int *ptr=&a[0][0];
                dizi[1]=&ptr;
        }
        //{
         //       int a[4]= {5,6,7,8};
           //     dizi[1]=&a[0][0];
        //}
        //dizi[0]=&a[0];
        //dizi[1]=&b[0];

        printf("a[0]:%d a[1]:%d a[2]:%d a[3]:%d\n",dizi[0][0][0],dizi[0][0][1],dizi[0][0][2],dizi[0][0][3]);
        printf("b[0]:%d b[1]:%d b[2]:%d b[3]:%d b[4]:%d b[5]:%d\n",dizi[1][0][0],dizi[1][0][1],dizi[1][0][2],dizi[1][0][3],dizi[1][0][4],dizi[1][0][5]);
        yazdir(N/2,dizi);
        printf("a[0]:%d a[1]:%d a[2]:%d a[3]:%d\n",dizi[0][0][0],dizi[0][0][1],dizi[0][0][2],dizi[0][0][3]);
        printf("b[0]:%d b[1]:%d b[2]:%d b[3]:%d b[4]:%d b[5]:%d\n",dizi[1][0][0],dizi[1][0][1],dizi[1][0][2],dizi[1][0][3],dizi[1][0][4],dizi[1][0][5]);
        return 0;
}
void yazdir(int boyut,int **dizi[boyut])
{
        printf("a[0]:%d a[1]:%d a[2]:%d a[3]:%d\n",dizi[0][0][0],dizi[0][0][1],dizi[0][0][2],dizi[0][0][3]);
        printf("b[0]:%d b[1]:%d b[2]:%d b[3]:%d b[4]:%d b[5]:%d\n",dizi[1][0][0],dizi[1][0][1],dizi[1][0][2],dizi[1][0][3],dizi[1][0][4],dizi[1][0][5]);
        dizi[1][0][5]=78;
}

