
public class Müþteri {
	private int no;
	private int iþlem_süresi;
	private int FIFO,KtenB,BdenK;
	
	public Müþteri(int no){
		this.no=no;
		iþlem_süresi_hesapla();
	}

	private void iþlem_süresi_hesapla() {
		iþlem_süresi=(int) (20+Math.random()*480);
	}

	public final int getFIFO() {
		return FIFO;
	}

	public final void setFIFO(int fifo) {
		FIFO = fifo;
	}

	public final int getKtenB() {
		return KtenB;
	}

	public final void setKtenB(int ktenB) {
		KtenB = ktenB;
	}

	public final int getBdenK() {
		return BdenK;
	}

	public final void setBdenK(int bdenK) {
		BdenK = bdenK;
	}

	public final int getNo() {
		return no;
	}

	public final int getIþlem_süresi() {
		return iþlem_süresi;
	}
	
	
}
