/**
 * @(#)Kisi.java
 *
 *
 * @author
 * @version 1.00 2010/4/9
 */


public class Kisi {

    public String TcKimlikNo,adSoyad;
    Adres adres;

  public Kisi(String Tckim,String adso,Adres adr){
	TcKimlikNo=Tckim;
	adSoyad=adso;
	adres=adr;
	}



    public String getadSoyad() {
    	return adSoyad;
    }

    public Adres getadres(){
    	return adres;
    }
    public String gettcKimlikno() {
        return TcKimlikNo;
    }


    public void setadSoyad(String yeniad) {
    	adSoyad=yeniad;
    }
    public void settcKimlikNo(String tc) {
        TcKimlikNo=tc;
    }

    public void setadres(Adres yeniadres){
       adres=yeniadres;
    }

    public String ToString() {
    	return "Tc Kimlik No=" + TcKimlikNo + " Ad Soyad=" + adSoyad +"Adres"+ adres;
    }
}
