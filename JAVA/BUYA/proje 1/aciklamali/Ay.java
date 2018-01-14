
//Ay sinifindan aylara iliskin nesneler uretilecek ve icinde tanimli degiskenleri tutar

public class Ay {
	public int max;						//max-ayin toplam gun sayisini tutar
	public int sicakliklar[];			//sicaklikar dizisi gunlerin sicaklik degerleri tutar
	public int deger;					//deger-kacinci ay oldugunu belirleyecek
	
	//constructor
	public Ay(int m,int d) {
		sicakliklar=new int[max=m];
		deger=d;
		sicakliklariHesapla(); 
		
	}
	
	//sicakliklarHesapla metot sicaklik degerleri random meto yardimiyla uretir
	private void sicakliklariHesapla(){
		for(int i=0;i<max;i++){
			sicakliklar[i]=random(i+1,deger);
		}
	}
	// aya bagli olarak sin fonksiyon yardimiyla 4 derecelik frekansla random degerler dondurur
	private int random(int k, int ay) {
		double angle=(ay*31*Math.PI)/365;
        double derece= (Math.sin(angle)*30)+Math.random()*4;
        
        return (int) derece;
		
	}
}
