public class ProfesyonelSporcu extends Kisi {
	String brans;
    String kulupIsmi;
	int paraMiktari;

	public ProfesyonelSporcu(String tc, String as, Adres adr, String b, String k_i, int p_m){
		super(tc,as,adr);
		brans=b;
		kulupIsmi=k_i;
		paraMiktari=p_m;
	}

	public String getbrans() {
		return brans;
	}

	public String getkulupIsmi() {
		return kulupIsmi;
	}

	public int getparaMiktari() {
		return paraMiktari;
	}

	public void setbrans(String b) {
		brans = b;
	}

	public void setkulupIsmi(String k_i) {
		kulupIsmi = k_i;
	}

	public void setparaMiktari(int p_m) {
		paraMiktari = p_m;
	}

	public void transferYap(int transfer_ucreti,String yeni_kulup) {
		paraMiktari +=transfer_ucreti;
		setkulupIsmi(yeni_kulup);
	}

	public void cezaOde(int ceza_miktari) {
		paraMiktari -=ceza_miktari;
	}

	public String toString(){
		return
		super.toString()+
		"\nBrans:" + brans +
	    "\nKulup Ismi:" + kulupIsmi +
		"\nPara Miktari:" + paraMiktari;
	}
}