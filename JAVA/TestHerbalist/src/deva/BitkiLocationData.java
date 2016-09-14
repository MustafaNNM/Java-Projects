package deva;

public class BitkiLocationData {
	private String diskteki_yeri;
	private String diskteki_adi;

	public BitkiLocationData(String diskteki_yeri, String diskteki_adi) {
		this.diskteki_yeri = diskteki_yeri;
		this.diskteki_adi = diskteki_adi;
	}

	public String getDiskteki_yeri() {
		return diskteki_yeri;
	}

	public void setDiskteki_yeri(String diskteki_yeri) {
		this.diskteki_yeri = diskteki_yeri;
	}

	public String getDiskteki_adi() {
		return diskteki_adi;
	}

	public void setDiskteki_adi(String diskteki_adi) {
		this.diskteki_adi = diskteki_adi;
	}
}