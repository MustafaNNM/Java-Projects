package veri;

public class Ogrenci {

	private int girisYili;
	private String isim;
	private String numara;
	private int sinif;

	public int getGirisYili() {
		return girisYili;
	}

	public String getIsim() {
		return isim;
	}

	public String getNumara() {
		return numara;
	}

	public int getSinif() {
		return sinif;
	}

	public void setGirisYili(final int girisYili) {
		this.girisYili = girisYili;
	}

	public void setIsim(final String isim) {
		this.isim = isim;
	}

	public void setNumara(final String numara) {
		this.numara = numara;
	}

	public void setSinif(final int sinif) {
		this.sinif = sinif;
	}

	@Override
	public String toString() {
		return numara + " " + isim + " " + sinif + " " + girisYili;
	}

}
