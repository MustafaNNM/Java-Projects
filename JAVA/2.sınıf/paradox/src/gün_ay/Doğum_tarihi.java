package g�n_ay;

public class Do�um_tarihi {
	
	private Metot metot;
	private Random t�ret;
	private int random_g�n, random_ay;
	
	public Do�um_tarihi() {
		setMetot(new Metot());
		setT�ret(new Random());
	}

	public int random_ay(){
		//verilen s�n�ra g�re rasgele say� �retiliyor
		return random_ay=t�ret.random(getMetot().getG�n_miktarlar�().size());
	}
	
	public int random_g�n(){
		//verilen s�n�ra g�re rasgele say� �retiliyor
		return t�ret.random(getMetot().getG�n_miktarlar�().elementAt(random_ay));
	}
	public int random_y�l(){
		//verilen s�n�ra g�re rasgele say� �retiliyor
		return t�ret.random(3);//1990,1991 ve 1992 y�llar� i�in
	}
	private Metot getMetot() {
		return metot;
	}

	private void setMetot(Metot metot) {
		this.metot = metot;
	}

	public Random getT�ret() {
		return t�ret;
	}

	public void setT�ret(Random t�ret) {
		this.t�ret = t�ret;
	}

	@SuppressWarnings("unused")
	private int getRandom_g�n() {
		return random_g�n;
	}

	@SuppressWarnings("unused")
	private void setRandom_g�n(int random_g�n) {
		this.random_g�n = random_g�n;
	}

}
