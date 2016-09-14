package Dosya;
import Heap.Node;
import KisiBilgi.*;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.Vector;

import sirket.isIlan;
import sirket.isyerBilgi;

public class Application {
	
	public static void main(String[] args) {
		IsciBinaryTree newTree=new IsciBinaryTree();
		DosyaIslem a = new DosyaIslem();
		a.okuEleman("eleman.txt", newTree);
		Hashtable<String,isyerBilgi> currentHashtabe=a.okuSirket("sirket.txt");
		menu(newTree,currentHashtabe);
		a.openFile(newTree.getRoot(), "eleman.txt");
		a.yazSirket(currentHashtabe, "sirket.txt");
	}
	
	public static void menu(IsciBinaryTree tree,Hashtable<String, isyerBilgi> table)
	{
		int secim;
		do{
		System.out.println("1:Is Basvuru Yapan Kisilerin Kullanacagi Bolum");
		System.out.println("2:Eleman arayan Sirketlerin Kullanacagi Bolum");
		System.out.println("3:Agac Islemler\n4:Sistemden Cikma");
		System.out.println("Seciminizi giriniz");
		Scanner str=new Scanner(System.in);
		secim=str.nextInt();
		switch(secim){
			case 1:
				secim1 (tree,table);
				break;
			case 2:
				secim2(table);
				break;
			case 3:
				secim3(tree);
				break;
			case 4:
				break;
				
		}
		}while(secim!=4);
		return;
		
	}

	private static void secim1(IsciBinaryTree tree,Hashtable<String, isyerBilgi> birHashtable) {
		int secim;
		do{
			System.out.println("1:Sisteme Kayit\n2.Sistemdeki Bilgilerini Gunleme\n3:Sistemden Cikma\n4:Sistemdeki Bir Ise Basvurma");
			System.out.println("5:Back");
			System.out.println("Seciminizi giriniz...");
			Scanner str=new Scanner(System.in);
			secim=str.nextInt();
			switch (secim) {
				case 1:
					sistemeKayit(tree);
					break;
				case 2:
					sistemdeGunleme(tree);
					break;
				case 3:
					sistemdenCikma(tree);
					break;
				case 4:		
					birIseBasvurma(birHashtable, tree);				
					break;
				case 5:
					break;
	
			}
		}while(secim!=5);
		
		

		return;
		
	}
	private static void sistemdenCikma(IsciBinaryTree tree) {
		Scanner scan=new Scanner(System.in);
		System.out.println("adininizi giriniz");
		String silinecekad=scan.next();
		tree.remove(silinecekad);
	}

	private static void sistemdeGunleme(IsciBinaryTree tree) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Adinizi giriniz:");
		String input=scan.next();
		IsciDugum a=new IsciDugum();
		int secim=0;
		a=tree.bul(input);
		
		//System.out.println(a.getAdi());
		if(a!=null)
		{
			do{
			System.out.println("1.Adi\n2.Adres\n3.ePosta\n4.Uyrugu\n"+
			"5.Dogum Yer\n6.medeniDurumn\7.YabanciDil\n"+
			"8IilgiAlan\n9.telefon\n10.DogumTarih\n11.ReferansKisi\n"+
			"12.isDeneyimi\n13.EgitimDurum\nSeciminizi giriniz.........");
			secim=scan.nextInt();
			switch (secim) {
			case 1:
				 degistir(a,1);
				break;
			case 2:
				degistir(a, 2);
				break;
			case 3:
				degistir(a, 3);
				break;
			case 4:
				degistir(a, 4);
				break;
			case 5:
				degistir(a, 5);
				break;
			case 6:
				degistir(a, 6);
				break;
			case 7:
				degistir(a, 7);
				break;
			case 8:
				degistir(a, 8);
				break;
			case 9:
				degistir(a, 9);
				break;
			case 10:
				degistir(a, 10);
				break;
			case 11:
				degistir(a, 11);
				break;
			case 12:
				degistir(a, 12);
				break;
			case 13:
				degistir(a, 13);
				break;
			}
			}while(secim!=14);
			
			
		}
		
	}

	private static void degistir(IsciDugum a, int i) {
		
		if(i==12)
		{
			
			System.out.println("Is yer adini giriniz");
			String yeniAd=readStr();
			System.out.println("Is adresini giriniz");
			String yeniAdres=readStr();
			System.out.println("Is yerindeki pozisyonunu giriniz");
			String yeniPozisyon=readStr();
			System.out.println("Is yer gorevini giriniz");
			String yeniGorev=readStr();
			
			IsDeneyimi yeni=new IsDeneyimi(yeniAd, yeniAdres,yeniPozisyon, yeniGorev);
			if(!a.getIsDeneyimi().isEmpty()){
			a.getIsDeneyimi().firstElement().displayIsDeneyim();
			a.getIsDeneyimi().lastElement().displayIsDeneyim();
				a.getIsDeneyimi().remove(0);}
				a.getIsDeneyimi().add(0,yeni);
				a.getIsDeneyimi().firstElement().displayIsDeneyim();
				a.getIsDeneyimi().lastElement().displayIsDeneyim();
			
		}
		else if(i==13)
		{
			System.out.println("Okul adini giriniz");
			String yeniOkul=readStr();
			System.out.println("Bolumunuzu giriniz");
			String yeniBolum=readStr();
			int yeniBasTarih=readInt("Baslangic tarihini giriniz");
			int yeniBitTarih=readInt("Bitis tarihini giriniz");
			Double yeniNotOrt=readDouble("Ortalamanizi giriniz");
			EgitimDurum yeni=new EgitimDurum(yeniOkul,yeniBolum,yeniBasTarih, yeniBitTarih,yeniNotOrt);
			/*
			*debug before edit(first element)
			*/
			if(!a.getEgitimDurumu().isEmpty())
			{
				a.getEgitimDurumu().firstElement().displayEgitim();
				a.getEgitimDurumu().lastElement().displayEgitim();
				a.getEgitimDurumu().remove(0);
			}
			a.getEgitimDurumu().add(0,yeni);
			/*
			*debug after edit(first element)
			*/
			a.getEgitimDurumu().firstElement().displayEgitim();			
			a.getEgitimDurumu().lastElement().displayEgitim();
			
		}else{
		System.out.println("yeni bilginizi giriniz");
		String s=readStr();
		if(i==1)
			a.setAdi(s);
		else if(i==2)
			a.setEvAdresi(s);
		else if(i==3)
			a.setE_posta(s);
		else if(i==4)a.setUyrugu(s);
		else if(i==5)a.setDogumYeri(s);
		else if(i==6)a.setMedeniDurum(s);
		else if(i==7)a.setYabanciDil(s);
		else if(i==8)a.setIlgiAlan(s);
		else if(i==9)a.setTelefon(Integer.parseInt(s));
		else if(i==10)a.setDogumTarihi(Integer.parseInt(s));
		else if(i==11)a.setReferanKisiler(s);
		}
	}
/*
 *  siteme kayitlama fonksiyon 
 */
	private static void sistemeKayit(IsciBinaryTree currenTree) {
		String atama;
		IsciDugum yeniIsci=new IsciDugum();
		Vector<IsDeneyimi> denetim=new Vector<IsDeneyimi>();
		Vector<EgitimDurum> egitimDrum=new Vector<EgitimDurum>();
		//sisteme kayit yapan kisinin bilgilerini aliyor
		System.out.println("Adiniz");
		atama=readStr();
		yeniIsci.setAdi(atama);
		System.out.println("Adresiniz");
		atama=readStr();
		yeniIsci.setEvAdresi(atama);
		System.out.println("E-postani");
		atama=readStr();
		yeniIsci.setE_posta(atama);
		System.out.println("Uyrugunuz");
		atama=readStr();
		yeniIsci.setUyrugu(atama);
		System.out.println("Dogum yeriniz");
		atama=readStr();
		yeniIsci.setDogumYeri(atama);
		System.out.println("Medeni durumunuz");
		atama=readStr();
		yeniIsci.setMedeniDurum(atama);
		System.out.println("Bildiginiz yabanci diliniz");
		atama=readStr();
		yeniIsci.setYabanciDil(atama);
		System.out.println("Ilgi alaniniz");
		atama=readStr();
		yeniIsci.setIlgiAlan(atama);
		yeniIsci.setTelefon(readInt("Telefon numaraniz"));
		yeniIsci.setDogumTarihi(readInt("Dogum tarihiniz"));
		System.out.println("Referans olan kisileriniz");
		atama=readStr();
		yeniIsci.setReferanKisiler(atama);
		do {
			System.out.println("Egitim durumunuz hakkinda bilgi eklemek ister misiniz?(E/H)");
			atama=readStr();
			
			if (atama.equalsIgnoreCase("E")) {
				atama = "H";
				egitimDurumEkle(egitimDrum);
				
			}
		} while (!atama.equalsIgnoreCase("H"));
		
		do {
			System.out.println("Deneyiminiz hakkinda bilgi eglemek ister misiniz? (E/H)");
			atama=readStr();
			
			if (atama.equalsIgnoreCase("E")) {
				atama = "H";
				deneyimEkle(denetim);
			}
		} while (!atama.equalsIgnoreCase("H"));
		
		yeniIsci.setIsDeneyimi(denetim);
		yeniIsci.setEgitimDurumu(egitimDrum);
		yeniIsci.displayIsciDugum();
		currenTree.insert(yeniIsci);
	}

	private static void deneyimEkle(Vector<IsDeneyimi> denetim) {
	
			String adi,adres,poziyon,gorev,atama;
			System.out.println("Is yer adini giriniz:");
			adi=readStr();
			System.out.println("Is yer adresini giriniz:");
			adres=readStr();
			System.out.println("Is yer pozisoynunu giriniz:");
			poziyon=readStr();
			System.out.println("Is yer gorevinizi giriniz:");
			gorev=readStr();
			IsDeneyimi deneyim=new IsDeneyimi(adi,adres,poziyon,gorev);
			denetim.add(deneyim);
			do {
				System.out.println("Baska bir is deneyim girmek ister misiniz? (E/H)");
				atama=readStr();				
				if (atama.equalsIgnoreCase("E"))
				{
					atama = "H";
					deneyimEkle(denetim);
				}				
			} while (!atama.equalsIgnoreCase("H"));
		
	}

	private static void egitimDurumEkle(Vector<EgitimDurum> egitimDrum) {
		String atama;
		
			String okulAdi,bolumu;
			int baslangicTarih,bitisTarih;
			double notortalama;
			System.out.println("okulunuzu giriniz");
			okulAdi=readStr();
			System.out.println("Bolumunuzu giriniz");
			bolumu=readStr();
			baslangicTarih=readInt("Baslangic tarihini giriniz");			
			bitisTarih=readInt("Bitis tarihini giriniz");			
			notortalama=readDouble("Not ortalamanizi giriniz");
			EgitimDurum egitim=new EgitimDurum(okulAdi, bolumu, baslangicTarih, bitisTarih, notortalama);
			egitimDrum.add(egitim);
			do {
				System.out.println("Sonraki okulunuz var mi? (E/H)");
				atama=readStr();
				
				if (atama.equalsIgnoreCase("E")){
				atama = "H";
				egitimDurumEkle(egitimDrum);
				
				}
				
			} while (!atama.equalsIgnoreCase("H"));
		
		
	}
	/*
	 * ise basvurma fonksiyon
	 */
	private static void birIseBasvurma(Hashtable<String, isyerBilgi> birHashtable,IsciBinaryTree currentTree)
	{
		System.out.println("Basvurmak istediginiz ilana ilgili sirketin adini girin");
		String sirketAdi=readStr();
		if(birHashtable.get(sirketAdi)==null)
		{
			System.out.println("!!!!!!!!!!Bu adindan kayitli sirket yok!!!!!!!!");
			return;
		}
		System.out.println("Kayitli olup olmadigini kontrol etmek icin adinizi giriniz:");
		Scanner str43=new Scanner(System.in);
		String ad=str43.next();
		IsciDugum arananDugum=currentTree.bul(ad);
		
		if(arananDugum!=null)
		{
			Vector<isIlan> yeniVector=birHashtable.get(sirketAdi).getIsIlanVector();
			if(yeniVector.isEmpty())
			{
				System.out.println("!!!!!!!!Bu sirketin hic ilani yok!!!!!!!!!!");
				return;
			}
			else
			{		
			
				System.out.println("\t\t******"+sirketAdi+"*******");
				
				System.out.println(sirketAdi+" ilanlar:");
				for(int i=0; i<yeniVector.size(); i++)
				{
					System.out.print(i+1+":");
					yeniVector.elementAt(i).displayIlan();
					
				}
				System.out.println("Basvurmak istediginiz ilanin numarasini giriniz:");
				int index;
				double key=0;
				Scanner str=new Scanner(System.in);
				index=str.nextInt();
				isIlan currentIlan=yeniVector.elementAt(index-1);
				System.out.println("Ise uygunlugunu gosteren (0-10) sayisini girin: [kullanici taraftan girmek istiyor ise (S/s)]");
				System.out.println("                                                [bilgisayar tarafindan urettirmek icin (B/b) giriniz]");	
				String uygun=readStr();
				if(uygun.compareTo("k")==0 || uygun.compareTo("K")==0)
				{
					System.out.println("Uygunlugu giriniz");
					Scanner str2=new Scanner(System.in);
					key=str2.nextDouble();
				}
				else if(uygun.compareTo("b")==0 || uygun.compareTo("B")==0)
				{
			        key=Math.random()*10;	
			        System.out.println("Bilgisardan uretti");
			        System.out.println("ureten sayi:"+key);
					
				}	
				int index1=currentIlan.getIlanHeap().insert(key);
				//currentIlan.getIlanHeap().displayHeap();
				currentIlan.getIlanHeap().heap.get(index1).setBirIlanIliskinBasvurularinReferans(arananDugum);
				//currentIlan.getIlanHeap().heap.get(index1).getBirIlanIliskinBasvurularinReferans().displayIsciDugum();
				System.out.println("Basvurunuz basariyla gerceklesti");
			}
			
		
		}
		else
			System.out.println("Kayitli degilsin basvurmak istiyorsan kayit yapiniz");
		
		
	}
	
	/*
	 * string kullanicidan alir
	 */

	private static String readStr() {
		Scanner scan=new Scanner(System.in);
		return scan.next();

	}
	
	/*
	 * kullanicidan sayiyi strign olarak alip inte donduruyor arada kontrol yapilir
	 */
	public static int readInt(String s) {
		String metin;
		Scanner scr1=new Scanner(System.in);
		//System.out.println(s);
		
		do{
			System.out.println(s);
			metin=scr1.next();
		}while (!isParsableToInt(metin)) ;
		return Integer.parseInt(metin);
	}

	public static boolean isParsableToInt(String i) {

		try {
			Integer.parseInt(i);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
	/*
	 * kullanicidan sayiyi string olarak alip double-e donduruyor arada kontrol yapilir
	 */
	public static Double readDouble(String s) {
		String metin;
		Scanner scr2=new Scanner(System.in);
		System.out.println(s);
		metin=scr2.next();
		while (!isParsableToDouble(metin)) {
			System.out.println(s);
			metin=scr2.next();
		}
		return Double.parseDouble(metin);
	}

	public static boolean isParsableToDouble(String i) {

		try {
			Double.parseDouble(i);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
	/*
	 * eleman arayan sirketlerin kullanacagi bolumun menusu
	 */
	private static void secim2(Hashtable<String, isyerBilgi> table) {
		int secim;
		do{
			System.out.println("1:Sisteme Kayit(Isyer bilgilerini ekleme)\n2:Sistemdeki Bilgilerini Gunleme\n3:Yeni bir Is ilan verme\n4:Ise Basvuran tum adaylarin Bilgilerini listeleme");
			System.out.println("5:En uygun adayi Ise alma\n6:Is ilanini sistemden kimseye almadan cekme\n7:Back");
        	System.out.println("Seciminizi giriniz....");
			
		
			Scanner str=new Scanner(System.in);
			secim=str.nextInt();
			switch (secim) {
				case 1:
					sistemeIsyerekle(table);
					break;
				case 2:
					sistemdeGunlemeIsyer(table);
					break;
				case 3:
					birIlanVerme(table);
					break;
				case 4:
					iseVuranlariListeleme(table);
					break;
				case 5:
					IsciDugum enUygun=enUygunAdayiIseAlma(table);
					System.out.println("Ise alinan en uygun aday bilgileri");
					enUygun.displayIsciDugum();
					break;
				case 6:
					isIlan cekilenIlan=isIlaniniCekme(table);
					System.out.println("Cekilen ilan:");
					cekilenIlan.displayIlan();
					
					break;
				case 7:
					//isIlanlariGoster(table, "esse");
					break;
		
			}
		}while(secim!=7);
		
		

		return;
		
	}
	/*
	 * ilan verme fonsiyon
	 */
	private static void birIlanVerme(Hashtable<String, isyerBilgi> currentHashtable)
	{
		System.out.println("sirket adin girin");
		String sirketAd=readStr();
		if(currentHashtable.get(sirketAd)==null)
		{
			System.out.println("!!!!!!!bu adindan kayitli sirket yok!!!!!!!!!!");
			return;
		}
		String isTanim,elemanOzellik;
		System.out.println("Is Tanimi giriniz:");
		Scanner str=new Scanner(System.in);
		isTanim=str.nextLine();
		System.out.println("Eleman Ozellikleri giriniz:");
		Scanner str5=new Scanner(System.in);
		elemanOzellik=str5.nextLine();
		isIlan yeniIlan=new isIlan(isTanim, elemanOzellik);
		currentHashtable.get(sirketAd).getIsIlanVector().add(yeniIlan);
		System.out.println("Is ilanlarina basariyla eklendi");
		
		
	}
	private static void iseVuranlariListeleme(Hashtable<String, isyerBilgi> currentHastable)
	{
		System.out.println("Sirket adi girin");
		String sirketAdi=readStr();
		isyerBilgi current=currentHastable.get(sirketAdi);
		current.disp();
		if(current.getIsIlanVector()!=null){
		for(int i=0; i<current.getIsIlanVector().size(); i++)
		{
			if(current.getIsIlanVector().elementAt(i).getIlanHeap().heap!=null)
			{
				for(int j=0; j<current.getIsIlanVector().elementAt(i).getIlanHeap().heap.size(); j++)
					if(current.getIsIlanVector().elementAt(i).getIlanHeap().heap.elementAt(j).getBirIlanIliskinBasvurularinReferans()!=null)
					{
						current.getIsIlanVector().elementAt(i).getIlanHeap().heap.elementAt(j).getBirIlanIliskinBasvurularinReferans().displayIsciDugum();
					
					}
			}
			else
				System.out.println("Hic bir kisi ise vurmamis");
		}
		}
		
	}
	private static IsciDugum enUygunAdayiIseAlma(Hashtable<String, isyerBilgi> currentHashtable)
	{
		System.out.println("Sirket adi girin");
		String sirketAdi=readStr();
		isyerBilgi current=currentHashtable.get(sirketAdi);
		if(currentHashtable.get(sirketAdi)!=null)
		{
			
			System.out.println("Hangi ilandan eleman ise almak istiyorsun numarasini giriniz");
			for(int i=0; i<current.getIsIlanVector().size(); i++)
			{
				System.out.print(i+1);
				current.getIsIlanVector().elementAt(i).displayIlan();
			}
			Scanner str4=new Scanner(System.in);
			int index=str4.nextInt();
			
			Node currentNode=current.getIsIlanVector().elementAt(index-1).getIlanHeap().remove();
			
			return currentNode.getBirIlanIliskinBasvurularinReferans();
		}
		else
			System.out.println("Bu adindan sirket yok");
		return null;
		
	}
	private static isIlan isIlaniniCekme(Hashtable<String, isyerBilgi> currentHashtable)
	{
		System.out.println("Sirket adi girin");
		String sirketAdi3=readStr();
		isyerBilgi current=currentHashtable.get(sirketAdi3);
		System.out.println("Hangi ilandan eleman ise almak istiyorsun numarasini giriniz");
	
		for(int i=0; i<current.getIsIlanVector().size(); i++)
		{
			System.out.println((i+1)+":");
			current.getIsIlanVector().elementAt(i).displayIlan();
		}
		String s1=readStr();
		int index1=readInt(s1);
		return current.getIsIlanVector().remove(index1-1);
		
		
	}

	

	
	
	private static void sistemdeGunlemeIsyer(Hashtable<String, isyerBilgi> table) {
		int num;
		Scanner scan=new Scanner(System.in);
		System.out.println("isyer adini giriniz");
		String ad=readStr();
		isyerBilgi gunlen=table.get(ad);
		table.remove(ad);
		if(gunlen==null)
			System.out.println("Sistemde Bilginiz bulunmamaktadir\n");
		else{
		do{
		System.out.println("1.isYerAdi\n2.isYerAdresi\n3.isYerEPostatelefon\n4.faks\n5.Cikis\n"+
				"Gunlemek isteginiz bilginizin numarasini giriniz");
		num=scan.nextInt();
		switch (num) {
		case 1:
			gunlen.setIsYerAdi(readStr());
			break;
		case 2:
			gunlen.setIsYerAdresi(readStr());
			break;
		case 3:
			gunlen.setIsYerEPosta(readStr());
			break;
		case 4:
			gunlen.setFaks(readStr());
		default:
			break;
		}
		}while(num!=5);
		table.put(gunlen.getIsYerAdi(), gunlen);}
	}

	private static void sistemeIsyerekle(Hashtable<String, isyerBilgi> table) {
		Scanner scan=new Scanner(System.in);
		isyerBilgi yeni=new isyerBilgi();
		System.out.println("Is yer adini giriniz");
		yeni.setIsYerAdi(scan.next());
		System.out.println("Is yer adresini giriniz");
		yeni.setIsYerAdresi(scan.next());
		System.out.println("Is yer telefonunu giriniz");
		yeni.setTelefon(scan.next());
		System.out.println("Is yer faksini giriniz");
		yeni.setFaks(scan.next());
		System.out.println("Is yer e-postasini giriniz");
		yeni.setIsYerEPosta(scan.next());
		table.put(yeni.getIsYerAdi(), yeni);
		
	}

	private static void secim3(IsciBinaryTree tree) {
		int secim;
		do{
			System.out.println("1:Adindan kişi arama, tüm bilgilerini listeleme (başvurduğu işlerle birlikte)\n2:Not ortalamalarından en az birisi, 90’ın üzerinde olan kişilerin adlarının listelenmesi\n3:İngilizce bilen kişilerin adlarının listelenmesi");
			System.out.println("4:İkili arama ağacındaki tüm kişilerin adlarını düzeyleri ile birlikte Listeleme (Inorder, preorder, postorder). Ağacın derinliğini ve eleman sayısını yazdırma");
			System.out.println("5:Back\nSeciminizi giriniz...");
		
			Scanner str=new Scanner(System.in);
			secim=str.nextInt();
			switch (secim) {
				case 1:
					System.out.println("Bilgilerini gormek istedigin kisini adini giriniz");
					Scanner s=new Scanner(System.in);
					String adi=s.next();
					try {
						tree.bul(adi).displayIsciDugum();
					} catch (Exception e) {
						System.out.println("Bulunamadi");
					}
					break;
				case 2:
					System.out.println("\n****Not ortalamasi 90 uzerinde olan kisiler****");
					tree.ortalamaGoreListele(90, tree.getRoot());
					break;
				case 3:
					tree.yabanciDilBilen("english", tree.getRoot());
					break;
				case 4:
					System.out.println("***\nIn order***");
					tree.inorder(tree.getRoot());
					
					System.out.println("\n**Post order***");
					tree.postorder(tree.getRoot());
					System.out.println("\n***Pre order***");
					tree.preorder(tree.getRoot());
					System.out.println("\n---Agacin derinligi---"+tree.getRoot().getHeight());	
					System.out.println("AVL agac oldu icin eklerken dengeli tutuyor");
					break;
				case 5:
					break;
	
			}
		}while(secim!=5);
		
			return;
		
	}


}
