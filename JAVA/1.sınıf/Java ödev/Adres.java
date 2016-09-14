/**
 * @(#)Adres.java
 *
 *
 * @author
 * @version 1.00 2010/4/9
 */

public class Adres {
 String evAdresi;
 String isAdresi;

    public Adres(String evadr, String isadr) {
    	evAdresi=evadr;
    	isAdresi=isadr;
    }

    public String getEvAdresi() {
    	return evAdresi;
    }

    public String getIsAdresi() {
    	return isAdresi;
    }

    public void setEvAdresi(String yeniadres) {
    	evAdresi=yeniadres;
    }

    public void setIsAdresi(String yeniadres) {
    	isAdresi=yeniadres;
    }

    public String ToString() {
    	return "Ev Adresi=" + evAdresi + " Is Adresi=" + isAdresi;
    }
}
