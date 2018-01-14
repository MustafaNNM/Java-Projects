/*
 * Created on 07.Mar.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author cenk
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LisansustuOgrenci extends Ogrenci {
	private String tez;
	private String danisman;
	
	public LisansustuOgrenci(int n, String a, String s, String adr, String t, String d){
		super(n,a,s,adr);
		tez=t;
		danisman=d;
	}
		

	/**
	 * @return
	 */
	public String getDanisman() {
		return danisman;
	}

	/**
	 * @return
	 */
	public String getTez() {
		return tez;
	}

	/**
	 * @param string
	 */
	public void setDanisman(String string) {
		danisman = string;
	}

	/**
	 * @param string
	 */
	public void setTez(String string) {
		tez = string;
	}
	
	public void kimlik_yaz(){
		super.kimlik_yaz();
		System.out.println("Tez:"+tez+"\n"+"Danisman:"+danisman+"\n");
	}

}
