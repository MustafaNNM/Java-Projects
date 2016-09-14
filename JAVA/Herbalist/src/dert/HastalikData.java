package dert;

import java.util.Vector;

public class HastalikData {
	private int bilgi_sayisi;
	private Vector<String> tedavisi;
	private Vector<String> onerilen_bitkiler;

	public HastalikData() {
	}

	public int getBilgi_sayisi() {
		return bilgi_sayisi;
	}

	public void setBilgi_sayisi(int bilgi_sayisi) {
		this.bilgi_sayisi = bilgi_sayisi;
	}

	public Vector<String> getTedavisi() {
		return tedavisi;
	}

	public void setTedavisi(Vector<String> tedavisi) {
		this.tedavisi = tedavisi;
	}

	public Vector<String> getOnerilen_bitkiler() {
		return onerilen_bitkiler;
	}

	public void setOnerilen_bitkiler(Vector<String> onerilen_bitkiler) {
		this.onerilen_bitkiler = onerilen_bitkiler;
	}
}