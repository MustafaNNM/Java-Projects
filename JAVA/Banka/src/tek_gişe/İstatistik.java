package tek_gi�e;

public class �statistik {
	private int no, gi�e_no, m��terinin_kuyrukta_bekledi�i_s�re = 0,
			veznedeki_i�lem_s�resi = 0, bankada_bekledi�i_s�re = 0;
	int daha_az_bekledi_mi = 0;

	public �statistik() {
		setM��terinin_kuyrukta_bekledi�i_s�re(0);
		setVeznedeki_i�lem_s�resi(0);
		setBankada_bekledi�i_s�re(0);
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getGi�e_no() {
		return gi�e_no;
	}

	public void setGi�e_no(int gi�e_no) {
		this.gi�e_no = gi�e_no;
	}

	public int getDaha_az_bekledi_mi() {
		return daha_az_bekledi_mi;
	}

	public void setDaha_az_bekledi_mi(int daha_az_bekledi_mi) {
		this.daha_az_bekledi_mi = daha_az_bekledi_mi;
	}

	public int getM��terinin_kuyrukta_bekledi�i_s�re() {
		return m��terinin_kuyrukta_bekledi�i_s�re;
	}

	public void setM��terinin_kuyrukta_bekledi�i_s�re(
			int m��terinin_kuyrukta_bekledi�i_s�re) {
		this.m��terinin_kuyrukta_bekledi�i_s�re = m��terinin_kuyrukta_bekledi�i_s�re;
	}

	public int getVeznedeki_i�lem_s�resi() {
		return veznedeki_i�lem_s�resi;
	}

	public void setVeznedeki_i�lem_s�resi(int veznedeki_i�lem_s�resi) {
		this.veznedeki_i�lem_s�resi = veznedeki_i�lem_s�resi;
	}

	public int getBankada_bekledi�i_s�re() {
		return bankada_bekledi�i_s�re;
	}

	public void setBankada_bekledi�i_s�re(int bankada_bekledi�i_s�re) {
		this.bankada_bekledi�i_s�re = bankada_bekledi�i_s�re;
	}

	public String toString() {
		System.out.println("M��terinin~\nNosu: " + no + "\nGi�e no:"
				+ getGi�e_no() + "\nVeznedeki i�lem s�resi:"
				+ veznedeki_i�lem_s�resi + "\nBankada bekledi�i s�re:"
				+ bankada_bekledi�i_s�re + "\nDaha az bekledi mi:"
				+ daha_az_bekledi_mi());
		return "";
	}

	private String daha_az_bekledi_mi() {
		if (getDaha_az_bekledi_mi() == 1) {
			return "evet";
		} else {
			return "hay�r";
		}
	}
}
