/**
 * @(#)Perfsyonalsporcu.java
 *
 *
 * @author
 * @version 1.00 2010/4/9
 */

public class Profesyonelsporcu extends Kisi {
   private String branssporcu,kulupsporcu;
   private int paraMiktari;

   public Profesyonelsporcu(String tc ,String ad,Adres adr,String bran,String kulup ,int para){
       super(tc,ad,adr);
       branssporcu=bran;
       kulupsporcu=kulup;
       paraMiktari=para;
   }
    public String getTcKimlikno() {

        return TcKimlikNo;
    }
    public String getbrans(){
        return branssporcu;
    }
    public String getkulup(){
        return kulupsporcu;
    }
    public int getpara(){
        return paraMiktari;
    }

    public String getAdSoyad() {
    	return adSoyad;
    }

    public Adres getAdres(){
    	return adres;
    }

    public void setTcKimlikNo(String yenitc) {
    	TcKimlikNo=yenitc;
    }

    public void setAdSoyad(String yeniad) {
    	adSoyad=yeniad;
    }
    public void setAdres(Adres yeniadres){
       adres=yeniadres;
    }

    public void setbrans(String yenibrans){
       branssporcu=yenibrans;
    }
    public void setkulup(String yenikulup){
       kulupsporcu=yenikulup;
    }
    public void setpara(int yenipara){
       paraMiktari=yenipara;
    }

    public void transferYap(int trfUcreti,String yenikulup){
    kulupsporcu=yenikulup;
    paraMiktari+=trfUcreti;
    }
    public void cezaode(int cezamiktari){
    paraMiktari-=cezamiktari;
    }
 	public String ToString() {
    	return super.ToString()+"Brans="+branssporcu+"Kulup ismi="+kulupsporcu+"Para miktarý="+paraMiktari;
    }
}