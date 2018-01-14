import java.util.Vector;

public class OddNumbers implements Series {

	private Vector<DemoOddNumbers> TekSayýlarListesi;

	public OddNumbers() {
		setTekSayýlarListesi(new Vector<DemoOddNumbers>());
	}

	private int start;

	private int pozisyon; // en son kaldýgý yerden devam etmesi icin gerekli

	// degisken
	// kontrol amaclý da kullanýlýr(bir sonraki elemanýn null olup olmadýgý
	// listenin sizeýndan buyuk mu degilmi gibi)
	public void create_numbers() {
		int size = (1000 - start) / 2;//listeye kaç tane sayýnýn eklenmesi gerektiði hesaplanýyor
		int number = start;
		//baþlangýç sayýsýnýn tek olup olmadýðý kontrol ediliyor
		if ((start % 2) == 0) {
			//sayý çift ise bir artýrýlýp tek sayý olmasý saðlanýyor
			number++;
		}
		else{
			size++;
			//sayý tek ise size'ýn bir artmasý gerekiyor
			//1. ex;
			//0-6 arasýnda 3 tek sayý {1,3,5} vardýr
			//first step 6-0=6
			//second step 6/2=3;
			//result is 3;
			//third step 0 is a even number then ok
			//there is 3 odd number
			//2. ex;
			//1-6 arasýnda 3 tek sayý {1,3,5} vardýr
			//first step 6-1=5
			//second step 5/2=2,5; cause of variable's type result is 2; 
			//third step 1 is a even number then 2+1=3;
			//there is 3 odd number
		}
		getTekSayýlarListesi().setSize(size);
		for (int i = 0; i < TekSayýlarListesi.size(); i++) {
			TekSayýlarListesi.set(i, new DemoOddNumbers());
			TekSayýlarListesi.elementAt(i).setNumber(number);
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
		DemoOddNumbers oddnumber = TekSayýlarListesi.get(getPozisyon());
		setPozisyon(getPozisyon() + 1);
		return oddnumber.getNumber();
	}

	public void reset() {
		setPozisyon(0);
	}

	public void setTekSayýlarListesi(Vector<DemoOddNumbers> tekSayýlarListesi) {
		TekSayýlarListesi = tekSayýlarListesi;
	}

	public Vector<DemoOddNumbers> getTekSayýlarListesi() {
		return TekSayýlarListesi;
	}

	public void setPozisyon(int pozisyon) {
		this.pozisyon = pozisyon;
	}

	public int getPozisyon() {
		return pozisyon;
	}

	public String toString() {
		String metin = "";
		for (int i = 0; i < TekSayýlarListesi.size(); i++) {
			metin += TekSayýlarListesi.elementAt(i).getNumber() + "\n";
		}
		return metin;
	}
}
