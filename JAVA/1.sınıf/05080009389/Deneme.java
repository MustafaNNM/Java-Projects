    import javax.swing.*;
    class Deneme {
    public static void main(String[] args) {
       Adres al = new Adres("K.MARAÞ/ELBÝSTAN","ÝZMÝR/BORNOVA");
       String tc=JOptionPane.showInputDialog("Tc no giriniz:");
       String ad=JOptionPane.showInputDialog("Ad Soyad giriniz:");
       String br=JOptionPane.showInputDialog("Branþ giriniz:");
       String ki=JOptionPane.showInputDialog("Kulüp Ýsmi giriniz:");
       int sayi=3456+(int)(Math.random()*600);
       ProfesyonelSporcu f1 = new ProfesyonelSporcu(tc,ad,al,br,ki,sayi);
       System.out.println("Profesyonel Sporcu Bilgileri:\n\n"+f1+"\n");
       JOptionPane.showMessageDialog(null,"Profesyonel Sporcu Bilgileri:\n\n"+f1+"\n");
       f1.transferYap(1234+(int)(Math.random()*600),"RealMadiad");
       System.out.println("Profesyonel Sporcu Bilgileri:\n\n"+f1+"\n");
       JOptionPane.showMessageDialog(null,"Profesyonel Sporcu Bilgileri:\n\n"+f1+"\n");
       f1.cezaOde((int)(Math.random()*600));
       System.out.println("Profesyonel Sporcu Bilgileri:\n\n"+f1+"\n");
       JOptionPane.showMessageDialog(null,"Profesyonel Sporcu Bilgileri:\n\n"+f1+"\n");
    }
    }
