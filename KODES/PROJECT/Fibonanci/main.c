#include <stdio.h>
#include <stdlib.h>

extern int F(int n);
extern int main();

extern int F(int n)
{
    if(n==0) {
        //F(0)=0;
        return 0;
    } else {
        if(n==1) {
            //F(1)=1;
            return 1;
        } else {
            return F(n-1) + F(n-2);
        }
    }
}
extern  int main()
{
    int n=0;

    printf("Kacinci fibonanci sayisini goruntulemek istersiniz:{0}Cikis");
    scanf("%d",&n);
    printf("%d",F(n));
    fflush(stdin);


return 0;
}
