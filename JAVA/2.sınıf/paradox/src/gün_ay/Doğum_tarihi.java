package gün_ay;

public class Doðum_tarihi {
	
	private Metot metot;
	private Random türet;
	private int random_gün, random_ay;
	
	public Doðum_tarihi() {
		setMetot(new Metot());
		setTüret(new Random());
	}

	public int random_ay(){
		//verilen sýnýra göre rasgele sayý üretiliyor
		return random_ay=türet.random(getMetot().getGün_miktarlarý().size());
	}
	
	public int random_gün(){
		//verilen sýnýra göre rasgele sayý üretiliyor
		return türet.random(getMetot().getGün_miktarlarý().elementAt(random_ay));
	}
	public int random_yýl(){
		//verilen sýnýra göre rasgele sayý üretiliyor
		return türet.random(3);//1990,1991 ve 1992 yýllarý için
	}
	private Metot getMetot() {
		return metot;
	}

	private void setMetot(Metot metot) {
		this.metot = metot;
	}

	public Random getTüret() {
		return türet;
	}

	public void setTüret(Random türet) {
		this.türet = türet;
	}

	@SuppressWarnings("unused")
	private int getRandom_gün() {
		return random_gün;
	}

	@SuppressWarnings("unused")
	private void setRandom_gün(int random_gün) {
		this.random_gün = random_gün;
	}

}
