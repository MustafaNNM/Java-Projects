package veri_taban�;

import java.util.Vector;

public class �l_veri_taban� {
	private int il_miktar�;
	private Vector<String> iller;

	public �l_veri_taban�() {
		// Vekt�rde aylar�n g�n say�lar� tutuluyor
		setIller(new Vector<String>());
		getIller().setSize(getIl_miktar�());
		for (int i = 0; i < getIl_miktar�(); i++) {
			getIller().set(i, "");
		}
	}

	public Vector<String> getIller() {
		return iller;
	}

	public void setIller(Vector<String> iller) {
		this.iller = iller;
	}

	public int getIl_miktar�() {
		return il_miktar�;
	}

	public void setIl_miktar�(int il_miktar�) {
		this.il_miktar� = il_miktar�;
	}
}
