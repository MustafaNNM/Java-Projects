package sirket;

import java.util.Vector;

public class sirket {
	private Vector<isIlan> birIsIlan=new Vector<isIlan>();//isIlan gosterici
	private isyerBilgi birIsyerBilgi;
	
	public sirket(isyerBilgi bilgi,Vector<isIlan> ilan)
	{
		birIsIlan=ilan;
		birIsyerBilgi=bilgi;
		
	}

	public Vector<isIlan> getBirIsIlan() {
		return birIsIlan;
	}

	public void setBirIsIlan(Vector<isIlan> birIsIlan) {
		this.birIsIlan = birIsIlan;
	}

	public isyerBilgi getBirIsyerBilgi() {
		return birIsyerBilgi;
	}

	public void setBirIsyerBilgi(isyerBilgi birIsyerBilgi) {
		this.birIsyerBilgi = birIsyerBilgi;
	}
	

}
