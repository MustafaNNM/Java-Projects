
package sinav;
import java.util.*;
public class Ogrenci {
    private int OgrNo;
    private String OgrAdi;

    public Ogrenci(){

        String RandomAd="";
        int RandomNo;
        int strlen=10;
        Random rand=new Random();
        Random generator=new Random();

        for(int i=0;i<strlen; i++){
             RandomAd+=""+(char)(rand.nextInt(26)+65);
            // RandomNo+=""+(int)generator.nextInt(10);

        }
        RandomNo=generator.nextInt(1000000);

        this.OgrAdi=RandomAd;
        this.OgrNo=RandomNo;



    }

    public String getOgrAdi() {
        return OgrAdi;
    }

    public void setOgrAdi(String OgrAdi) {
        this.OgrAdi = OgrAdi;
    }

    public int getOgrNo() {
        return OgrNo;
    }

    public void setOgrNo(int OgrNo) {
        this.OgrNo = OgrNo;
    }

    public void yazdir(){

        System.out.println("Ogrenci NO:"+OgrNo+" Ogrenci ADI:"+OgrAdi);
    }




}
