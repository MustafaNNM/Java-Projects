/**
 * @(#)Denemesinifi.java
 *
 *
 * @author
 * @version 1.00 2010/4/9
 */


    class Denemesinifi {

    public static void main(String[] args) {
       Adres al = new Adres("Chicago","CentalofChicago");
       Profesyonelsporcu f1 = new Profesyonelsporcu("17856432","Ronaldo",al,"forvit","Milan",80750);
       System.out.println("Profesyonel Sporcu Bilgileri:\n\n"+f1+"\n");
       f1.transferYap(6548,"RealMadiad");
       System.out.println("Profesyonel Sporcu Bilgileri:\n\n"+f1+"\n");
       f1.cezaode(730);
       System.out.println("Profesyonel Sporcu Bilgileri:\n\n"+f1+"\n");
    }
    }
