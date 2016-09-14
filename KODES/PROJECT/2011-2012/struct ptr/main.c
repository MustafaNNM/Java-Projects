#include <stdio.h>
#include <stdlib.h>

struct a{
int a;
struct b *sonraki;
};

struct b{
int b;
struct a *sonraki;
};

int main()
{
    printf("Hello world!\n");
    return 0;
}
