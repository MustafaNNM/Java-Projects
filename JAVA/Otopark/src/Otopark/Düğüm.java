package Otopark;

public class D���m {
	private Araba araba;
	private D���m sonraki;

	public D���m() {
		setAraba(new Araba());

	}

	public Araba getAraba() {
		return araba;
	}

	public void setAraba(Araba araba) {
		this.araba = araba;
	}

	public D���m getSonraki() {
		return sonraki;
	}

	public void setSonraki(D���m sonraki) {
		this.sonraki = sonraki;
	}

	public String toString() {
		return araba.toString();
	}

}
