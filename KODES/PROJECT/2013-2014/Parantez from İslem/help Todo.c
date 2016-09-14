        case '+'://ilk islem arti
                do {
                        printf("Sayi:");
                        scanf("%f",&ikinci_sayi);
                        islem=getchar();//ikinci islem
                        switch(islem) { //ikinci islem hangisi
                        case '+'://artidan sonra ki islem arti
                                sonuc+=ikinci_sayi;
                                ikinci_sayi=0;
                                break;
                        case '-'://artidan sonra ki islem eksi
                                sonuc+=ikinci_sayi;
                                ikinci_sayi=0;
                                break;
                        case '*'://artidan sonra ki islem carpi
                                sonuc=carp(ikinci_sayi);
                                ikinci_sayi=0;
                                break;
                        case '/'://artidan sonra ki islem bolu
                                sonuc=bol(ikinci_sayi);
                                ikinci_sayi=0;
                                break;
                        case 'p'://artidan sonra ki islem pozitif us alma
                                sonuc=ussunu_al(ikinci_sayi);
                                ikinci_sayi=0;
                                break;
                        case 'n'://artidan sonra ki islem negatif us alma
                                sonuc=1/ussunu_al(ikinci_sayi);
                                ikinci_sayi=0;
                                break;
                        case '@'://artidan sonra ki islem arti karekok parantez
                                sonuc+=ikinci_sayi;
                                ikinci_sayi=0;
                                sonuc+=karekok();
                                break;
                        case 'é'://artidan sonra ki islem eksi karekok parantez
                                sonuc+=ikinci_sayi;
                                ikinci_sayi=0;
                                sonuc-=karekok();
                                break;
                        case 'm'://artidan sonra ki islem carpi karekok parantez
                                sonuc+=ikinci_sayi;
                                ikinci_sayi=0;
                                sonuc*=karekok();
                                break;
                        case 'd'://artidan sonra ki islem bolu karekok parantez
                                sonuc+=ikinci_sayi;
                                ikinci_sayi=0;
                                sonuc/=karekok();
                                break;
                        case 'a'://artidan sonra ki islem arti parantez
                                sonuc+=ikinci_sayi;
                                ikinci_sayi=0;
                                sonuc+=parantez();
                                break;
                        case 'e'://artidan sonra ki islem eksi parantez
                                sonuc+=ikinci_sayi;
                                ikinci_sayi=0;
                                sonuc-=parantez();
                                break;
                        case 'c'://artidan sonra ki islem carpi parantez
                                sonuc+=ikinci_sayi;
                                ikinci_sayi=0;
                                sonuc*=parantez();
                                break;
                        case 'b'://artidan sonra ki islem bolu parantez
                                sonuc+=ikinci_sayi;
                                ikinci_sayi=0;
                                sonuc/=parantez();
                                break;
                        default://a+b islemi
                                islem='}';
                                birinci_sayi+=sonuc;//a+b
                                break;
                        }
                } while(islem!='}');
                break;

