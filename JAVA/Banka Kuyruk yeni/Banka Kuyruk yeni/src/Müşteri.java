
public class M��teri {
	private int no;
	private int i�lem_s�resi;
	private int FIFO,KtenB,BdenK;
	
	public M��teri(int no){
		this.no=no;
		i�lem_s�resi_hesapla();
	}

	private void i�lem_s�resi_hesapla() {
		i�lem_s�resi=(int) (20+Math.random()*480);
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

	public final int getI�lem_s�resi() {
		return i�lem_s�resi;
	}
	
	
}
