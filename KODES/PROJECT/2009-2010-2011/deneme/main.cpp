#include <iostream>

using namespace std;

#include "karmasik.h"

int main()
{
	karmasik k1;
	karmasik k2(1,1);
	k1.goster();
	k2.goster();
	k1.reelAyarla(2);
	k1.sanalAyarla(3);
	k1.goster();
	k1.topla(k2);
	k1.goster();
	k1.cikar(k2);
	k1.goster();
	cout << endl;
	return 0;
}
