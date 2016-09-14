


public class Ay {
	public int max;
	public int sicakliklar[];
	public int deger;
	
	
	public Ay(int m,int d) {
		sicakliklar=new int[max=m];
		deger=d;
		sicakliklariHesapla();
		
	}

	private void sicakliklariHesapla(){
		for(int i=0;i<max;i++){
			sicakliklar[i]=random(i+1,deger);
		}
	}

	private int random(int k, int ay) {
		double angle=(ay*31*Math.PI)/365;
        double derece= (Math.sin(angle)*30)+Math.random()*4;
        
        return (int) derece;
		
	}
}
