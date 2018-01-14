import java.util.Vector;

import javax.swing.JOptionPane;


public class Banka {
	private Vector<M��teri> s�ra;
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
		System.out.println("\n\n\n\nb�y�kten k����e s�ral� m��teriler i�lendi !__________________");
		b�y�ktenk����eS�rala();
		M��teri M;
		for(int im=0;im<s�ra.size();im++){
			M=s�ra.get(im);
			timer+=M.getI�lem_s�resi();
			M.setBdenK(timer);
			System.out.println(M.getNo()+" Nolu m��teri bekleme s�resi :"+timer);
			toplamWait+=timer;
		}
		System.out.println("\nM��terilerin ortalama bekleme s�resi : "+toplamWait/N+"___________________");
		listBtenK_FIFO();
		double fark=0;
		System.out.println("Ortalama i�lem tamamlanma s�res�ndeki kazanc(FIFO'ya g�re)\n"+
							"fark = "+(fark=AOW-(toplamWait/N))+
							"\n y�zde = "+fark/AOW);
	}

	private void runAccordB() {
		timer=0;
		int toplamWait=0;
		System.out.println("\n\n\n\nk���kten b����e s�ral� m��teriler i�lendi !__________________");
		k���ktenB�y��eS�rala();
		M��teri M;
		for(int im=0;im<s�ra.size();im++){
			M=s�ra.get(im);
			timer+=M.getI�lem_s�resi();
			M.setKtenB(timer);
			System.out.println(M.getNo()+" Nolu m��teri bekleme s�resi :"+timer);
			toplamWait+=timer;
		}
		System.out.println("\nM��terilerin ortalama bekleme s�resi : "+toplamWait/N+"_____________________");
		listKtenB_FIFO();
		double fark=0;
		System.out.println("Ortalama i�lem tamamlanma s�res�ndeki kazanc(FIFO'ya g�re)\n"+
							"fark = "+(fark=AOW-(toplamWait/N))+
							"\n y�zde = "+fark/AOW);
	}
	private void b�y�ktenk����eS�rala() {
			
			M��teri depo;
			for(int r=0;r<(s�ra.size()-1);r++) {
				for(int s=0;s<(s�ra.size()-r-1);s++) {
					if(s�ra.get(s+1).getI�lem_s�resi()>s�ra.get(s).getI�lem_s�resi()) {
						depo = s�ra.get(s);
						s�ra.set(s,s�ra.get(s+1));
						s�ra.set(s+1,depo);
					}
				}
			}
	}

	private void listKtenB_FIFO() {
		System.out.println("FIFO ' ya g�re daha az bekleyen m��teriler");
		M��teri M;
		for(int i=0;i<s�ra.size();i++){
			if((M=s�ra.get(i)).getKtenB()-M.getFIFO()<0)
				System.out.println(M.getNo()+" nolu m��teri i�lem s�resi : "+M.getI�lem_s�resi());
		}
	}
	private void listBtenK_FIFO() {
		System.out.println("FIFO ' ya g�re daha az bekleyen m��teriler");
		M��teri M;
		for(int i=0;i<s�ra.size();i++){
			if((M=s�ra.get(i)).getBdenK()-M.getFIFO()<0)
				System.out.println(M.getNo()+" nolu m��teri i�lem s�resi : "+M.getI�lem_s�resi());
		}
	}

	private void k���ktenB�y��eS�rala() {
		b�y�ktenk����eS�rala();
		ters�evir();
	}

	private void ters�evir() {
		Vector<M��teri> yeni=new Vector<M��teri>();
		for(int i=s�ra.size()-1;0<=i;i--){
			yeni.add(s�ra.get(i));
		}
		s�ra=yeni;
	}

	private void runAccordA() {
		timer=0;
		int toplamWait=0;
		System.out.println("\n\n\n\nFIFO'ya g�re m��terler i�lendi !_____________________________");
		M��teri M;
		for(int im=0;im<s�ra.size();im++){
			M=s�ra.get(im);
			timer+=M.getI�lem_s�resi();
			M.setFIFO(timer);
			System.out.println(M.getNo()+" Nolu m��teri bekleme s�resi :"+timer);
			toplamWait+=timer;
		}
		System.out.println("\nM��terilerin ortalama bekleme s�resi : "+( AOW=toplamWait/N)+"_________________");
	}

	private void initKuyruk() {
		a:
		try{
			N=Integer.parseInt(JOptionPane.showInputDialog(null,"M��teri say�s�n� gir:"));
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Hatal� veri!");
			break a;
		}
		s�ra=new Vector<M��teri>();
		for(int fedai=0;fedai<12;fedai++){
			s�ra.add(new M��teri(fedai));
		}
	}
	
	public static void main(String[] args) {
		new Banka();
	}
	
}
