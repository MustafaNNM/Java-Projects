package Otopark;

public class Düðüm {
	private Araba araba;
	private Düðüm sonraki;

	public Düðüm() {
		setAraba(new Araba());

	}

	public Araba getAraba() {
		return araba;
	}

	public void setAraba(Araba araba) {
		this.araba = araba;
	}

	public Düðüm getSonraki() {
		return sonraki;
	}

	public void setSonraki(Düðüm sonraki) {
		this.sonraki = sonraki;
	}

	public String toString() {
		return araba.toString();
	}

}
