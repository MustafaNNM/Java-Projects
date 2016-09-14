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
    
    public String toString() {
    	return "Ev Adresi=" + evAdresi +
    	 " Is Adresi=" + isAdresi;
    }
    
}