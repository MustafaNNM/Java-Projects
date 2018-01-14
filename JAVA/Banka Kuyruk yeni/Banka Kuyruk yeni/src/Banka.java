import java.util.Vector;

import javax.swing.JOptionPane;


public class Banka {
	private Vector<Müþteri> sýra;
	private int N;
	private int timer=0;
	private int AOW;
	
	public Banka()
	{
		initKuyruk();
		run();
	}

	private void run() {
		runAccordA();
		runAccordB();
		runAccordC();
	}

	private void runAccordC() {
		timer=0;
		int toplamWait=0;
		System.out.println("\n\n\n\nbüyükten küçüðe sýralý müþteriler iþlendi !__________________");
		büyüktenküçüðeSýrala();
		Müþteri M;
		for(int im=0;im<sýra.size();im++){
			M=sýra.get(im);
			timer+=M.getIþlem_süresi();
			M.setBdenK(timer);
			System.out.println(M.getNo()+" Nolu müþteri bekleme süresi :"+timer);
			toplamWait+=timer;
		}
		System.out.println("\nMüþterilerin ortalama bekleme süresi : "+toplamWait/N+"___________________");
		listBtenK_FIFO();
		double fark=0;
		System.out.println("Ortalama iþlem tamamlanma süresündeki kazanc(FIFO'ya göre)\n"+
							"fark = "+(fark=AOW-(toplamWait/N))+
							"\n yüzde = "+fark/AOW);
	}

	private void runAccordB() {
		timer=0;
		int toplamWait=0;
		System.out.println("\n\n\n\nküçükten büðüðe sýralý müþteriler iþlendi !__________________");
		küçüktenBüyüðeSýrala();
		Müþteri M;
		for(int im=0;im<sýra.size();im++){
			M=sýra.get(im);
			timer+=M.getIþlem_süresi();
			M.setKtenB(timer);
			System.out.println(M.getNo()+" Nolu müþteri bekleme süresi :"+timer);
			toplamWait+=timer;
		}
		System.out.println("\nMüþterilerin ortalama bekleme süresi : "+toplamWait/N+"_____________________");
		listKtenB_FIFO();
		double fark=0;
		System.out.println("Ortalama iþlem tamamlanma süresündeki kazanc(FIFO'ya göre)\n"+
							"fark = "+(fark=AOW-(toplamWait/N))+
							"\n yüzde = "+fark/AOW);
	}
	private void büyüktenküçüðeSýrala() {
			
			Müþteri depo;
			for(int r=0;r<(sýra.size()-1);r++) {
				for(int s=0;s<(sýra.size()-r-1);s++) {
					if(sýra.get(s+1).getIþlem_süresi()>sýra.get(s).getIþlem_süresi()) {
						depo = sýra.get(s);
						sýra.set(s,sýra.get(s+1));
						sýra.set(s+1,depo);
					}
				}
			}
	}

	private void listKtenB_FIFO() {
		System.out.println("FIFO ' ya göre daha az bekleyen müþteriler");
		Müþteri M;
		for(int i=0;i<sýra.size();i++){
			if((M=sýra.get(i)).getKtenB()-M.getFIFO()<0)
				System.out.println(M.getNo()+" nolu müþteri iþlem süresi : "+M.getIþlem_süresi());
		}
	}
	private void listBtenK_FIFO() {
		System.out.println("FIFO ' ya göre daha az bekleyen müþteriler");
		Müþteri M;
		for(int i=0;i<sýra.size();i++){
			if((M=sýra.get(i)).getBdenK()-M.getFIFO()<0)
				System.out.println(M.getNo()+" nolu müþteri iþlem süresi : "+M.getIþlem_süresi());
		}
	}

	private void küçüktenBüyüðeSýrala() {
		büyüktenküçüðeSýrala();
		tersÇevir();
	}

	private void tersÇevir() {
		Vector<Müþteri> yeni=new Vector<Müþteri>();
		for(int i=sýra.size()-1;0<=i;i--){
			yeni.add(sýra.get(i));
		}
		sýra=yeni;
	}

	private void runAccordA() {
		timer=0;
		int toplamWait=0;
		System.out.println("\n\n\n\nFIFO'ya göre müþterler iþlendi !_____________________________");
		Müþteri M;
		for(int im=0;im<sýra.size();im++){
			M=sýra.get(im);
			timer+=M.getIþlem_süresi();
			M.setFIFO(timer);
			System.out.println(M.getNo()+" Nolu müþteri bekleme süresi :"+timer);
			toplamWait+=timer;
		}
		System.out.println("\nMüþterilerin ortalama bekleme süresi : "+( AOW=toplamWait/N)+"_________________");
	}

	private void initKuyruk() {
		a:
		try{
			N=Integer.parseInt(JOptionPane.showInputDialog(null,"Müþteri sayýsýný gir:"));
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Hatalý veri!");
			break a;
		}
		sýra=new Vector<Müþteri>();
		for(int fedai=0;fedai<12;fedai++){
			sýra.add(new Müþteri(fedai));
		}
	}
	
	public static void main(String[] args) {
		new Banka();
	}
	
}
