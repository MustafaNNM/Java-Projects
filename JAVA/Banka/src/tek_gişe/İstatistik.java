package tek_giþe;

public class Ýstatistik {
	private int no, giþe_no, müþterinin_kuyrukta_beklediði_süre = 0,
			veznedeki_iþlem_süresi = 0, bankada_beklediði_süre = 0;
	int daha_az_bekledi_mi = 0;

	public Ýstatistik() {
		setMüþterinin_kuyrukta_beklediði_süre(0);
		setVeznedeki_iþlem_süresi(0);
		setBankada_beklediði_süre(0);
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getGiþe_no() {
		return giþe_no;
	}

	public void setGiþe_no(int giþe_no) {
		this.giþe_no = giþe_no;
	}

	public int getDaha_az_bekledi_mi() {
		return daha_az_bekledi_mi;
	}

	public void setDaha_az_bekledi_mi(int daha_az_bekledi_mi) {
		this.daha_az_bekledi_mi = daha_az_bekledi_mi;
	}

	public int getMüþterinin_kuyrukta_beklediði_süre() {
		return müþterinin_kuyrukta_beklediði_süre;
	}

	public void setMüþterinin_kuyrukta_beklediði_süre(
			int müþterinin_kuyrukta_beklediði_süre) {
		this.müþterinin_kuyrukta_beklediði_süre = müþterinin_kuyrukta_beklediði_süre;
	}

	public int getVeznedeki_iþlem_süresi() {
		return veznedeki_iþlem_süresi;
	}

	public void setVeznedeki_iþlem_süresi(int veznedeki_iþlem_süresi) {
		this.veznedeki_iþlem_süresi = veznedeki_iþlem_süresi;
	}

	public int getBankada_beklediði_süre() {
		return bankada_beklediði_süre;
	}

	public void setBankada_beklediði_süre(int bankada_beklediði_süre) {
		this.bankada_beklediði_süre = bankada_beklediði_süre;
	}

	public String toString() {
		System.out.println("Müþterinin~\nNosu: " + no + "\nGiþe no:"
				+ getGiþe_no() + "\nVeznedeki iþlem süresi:"
				+ veznedeki_iþlem_süresi + "\nBankada beklediði süre:"
				+ bankada_beklediði_süre + "\nDaha az bekledi mi:"
				+ daha_az_bekledi_mi());
		return "";
	}

	private String daha_az_bekledi_mi() {
		if (getDaha_az_bekledi_mi() == 1) {
			return "evet";
		} else {
			return "hayýr";
		}
	}
}
