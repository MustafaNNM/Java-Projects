package ��_gi�e;

import java.util.Vector;

import tek_gi�e.�statistikler;

public class Banka {
	private int gi�e_say�s�;
	private Vector<Gi�e> vezneler;
	private �statistikler rapor_klas�r�;

	public Banka(int n) {
		setVezneler(new Vector<Gi�e>());
		setGi�e_say�s�(3);
		getVezneler().setSize(getGi�e_say�s�());
		for(int i=0;i<getVezneler().size();i++){
			getVezneler().set(i, new Gi�e());	
		}
		setRapor_klas�r�(new �statistikler(n));
	}

	public Vector<Gi�e> getVezneler() {
		return vezneler;
	}

	public void setVezneler(Vector<Gi�e> vezneler) {
		this.vezneler = vezneler;
	}

	public int getGi�e_say�s�() {
		return gi�e_say�s�;
	}

	public void setGi�e_say�s�(int gi�e_say�s�) {
		this.gi�e_say�s� = gi�e_say�s�;
	}

	public �statistikler getRapor_klas�r�() {
		return rapor_klas�r�;
	}

	public void setRapor_klas�r�(�statistikler rapor_klas�r�) {
		this.rapor_klas�r� = rapor_klas�r�;
	}
}
