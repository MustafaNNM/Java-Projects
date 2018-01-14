package veri_tabaný;

import java.util.Vector;

public class Ýl_veri_tabaný {
	private int il_miktarý;
	private Vector<String> iller;

	public Ýl_veri_tabaný() {
		// Vektörde aylarýn gün sayýlarý tutuluyor
		setIller(new Vector<String>());
		getIller().setSize(getIl_miktarý());
		for (int i = 0; i < getIl_miktarý(); i++) {
			getIller().set(i, "");
		}
	}

	public Vector<String> getIller() {
		return iller;
	}

	public void setIller(Vector<String> iller) {
		this.iller = iller;
	}

	public int getIl_miktarý() {
		return il_miktarý;
	}

	public void setIl_miktarý(int il_miktarý) {
		this.il_miktarý = il_miktarý;
	}
}
