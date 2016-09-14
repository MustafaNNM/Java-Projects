package balonpatlatma;


public class BListe {

    private Dugum bas;

    public BListe(){
        bas=null;
       
    }
    public void liste(int sayi)
    {
        int i=sayi;
        Dugum ilk=new Dugum(i);
        bas=ilk;

        ilk.sonraki=bas;
        Dugum son=bas;
        //bas.sonraki=ilk;
        //Dugum gecici=bas.sonraki;
        i=i-1;
        while (i>0)
        {
            basaEkle(i,son);
            i--;
        }
        listele();
    }

    public void basaEkle(int i,Dugum son)
    {
        Dugum yenidugum=new Dugum(i);
        yenidugum.sonraki=bas;
        bas=yenidugum;
        son.sonraki=bas;
    }

    public void listele()
    {
        Dugum etkin =bas;
        Dugum g=bas.sonraki;
        etkin.birSepet.yazdir();
        etkin=etkin.sonraki;
        //while(etkin!=bas)
        for(int i=0;i<8;i++)
        {
           etkin.birSepet.yazdir();
           etkin=etkin.sonraki;
        }
    }

}
