package balonpatlatma;

public class Dugum {
    public Dugum sonraki;
    public Sepet birSepet;
    public Dugum(int no){
        birSepet=new Sepet(no);
        sonraki=null;
    }

}
