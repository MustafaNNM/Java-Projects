public class Otomobil {
	private String marka, plaka;
	private int model;
	//CONSTRUCTOR
	public Otomobil(String m, String p, int mod) {
		marka=m;
		plaka=p;
		model=mod;
	}
	//GETTER FUNCTIONS
	public String markaOkuma() { return marka; }
	public String plakaOkuma() { return plaka; }
	public int modelOkuma() { return model; }
	//SETTER FUNCTIONS
	public void markaAtama(String yenimarka) { marka=yenimarka;}
	public void plakaAtama(String yeniplaka) { plaka=yeniplaka;}
	public void modelAtama(int yenimodel) { model=yenimodel;}

	public String toString() {
		return "MARKA:" + marka + " PLAKA:" + plaka + " MODEL:" + model;
	}

}