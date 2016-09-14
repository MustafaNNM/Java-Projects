#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a,b,c,max;
     for (a=1;a<=3;++a)
    {
        for (b=1;b<=3;++b)
        {
            for (c=1;c<=3;++c)
            {
    if(a>=b&&a>=c){max=a;}//2
    if(b>=a&&b>=c){max=b;}//4,3
    if(c>=a&&c>=b){max=c;}//6,5
    //5,6
    printf("max:%d a:%d b:%d c:%d\n",max,a,b,c);
    max=0;
    }}}
    return 0;
}
