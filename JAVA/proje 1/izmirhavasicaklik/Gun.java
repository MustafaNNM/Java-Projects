package izmirhavasicaklik;
import java.util.*;


public class Gun {
    public static int GunlukSicaklik(int KullaniciGirilenGunSayi){
        int GunlukDerece;
        double deger,angle;
        Random rand=new Random();
        angle=(KullaniciGirilenGunSayi*Math.PI)/365;
        deger=(Math.sin(angle)*35+rand.nextInt(6));
                GunlukDerece=(int)deger;
        return GunlukDerece;



    }



}
