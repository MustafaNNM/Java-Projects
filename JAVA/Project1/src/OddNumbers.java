import java.util.Vector;

public class OddNumbers implements Series {

	private Vector<DemoOddNumbers> TekSay�larListesi;

	public OddNumbers() {
		setTekSay�larListesi(new Vector<DemoOddNumbers>());
	}

	private int start;

	private int pozisyon; // en son kald�g� yerden devam etmesi icin gerekli

	// degisken
	// kontrol amacl� da kullan�l�r(bir sonraki eleman�n null olup olmad�g�
	// listenin size�ndan buyuk mu degilmi gibi)
	public void create_numbers() {
		int size = (1000 - start) / 2;//listeye ka� tane say�n�n eklenmesi gerekti�i hesaplan�yor
		int number = start;
		//ba�lang�� say�s�n�n tek olup olmad��� kontrol ediliyor
		if ((start % 2) == 0) {
			//say� �ift ise bir art�r�l�p tek say� olmas� sa�lan�yor
			number++;
		}
		else{
			size++;
			//say� tek ise size'�n bir artmas� gerekiyor
			//1. ex;
			//0-6 aras�nda 3 tek say� {1,3,5} vard�r
			//first step 6-0=6
			//second step 6/2=3;
			//result is 3;
			//third step 0 is a even number then ok
			//there is 3 odd number
			//2. ex;
			//1-6 aras�nda 3 tek say� {1,3,5} vard�r
			//first step 6-1=5
			//second step 5/2=2,5; cause of variable's type result is 2; 
			//third step 1 is a even number then 2+1=3;
			//there is 3 odd number
		}
		getTekSay�larListesi().setSize(size);
		for (int i = 0; i < TekSay�larListesi.size(); i++) {
			TekSay�larListesi.set(i, new DemoOddNumbers());
			TekSay�larListesi.elementAt(i).setNumber(number);
			number += 2;
		}
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int valid() {
		if (getStart() < 101 || getStart() > 999) {
			// invalid case
			return 0;
		} else {
			// valid case
			return 1;
		}
	}

	public int getNext() {
		DemoOddNumbers oddnumber = TekSay�larListesi.get(getPozisyon());
		setPozisyon(getPozisyon() + 1);
		return oddnumber.getNumber();
	}

	public void reset() {
		setPozisyon(0);
	}

	public void setTekSay�larListesi(Vector<DemoOddNumbers> tekSay�larListesi) {
		TekSay�larListesi = tekSay�larListesi;
	}

	public Vector<DemoOddNumbers> getTekSay�larListesi() {
		return TekSay�larListesi;
	}

	public void setPozisyon(int pozisyon) {
		this.pozisyon = pozisyon;
	}

	public int getPozisyon() {
		return pozisyon;
	}

	public String toString() {
		String metin = "";
		for (int i = 0; i < TekSay�larListesi.size(); i++) {
			metin += TekSay�larListesi.elementAt(i).getNumber() + "\n";
		}
		return metin;
	}
}
