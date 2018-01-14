package needless;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String, Kisi> hash= new Hashtable<String, Kisi>();
		Comparator<?> comparator = new KisiComparator();
		PriorityQueue<Kisi> heap =new PriorityQueue<Kisi>(7,extracted(comparator)); 
		System.out.println("*************************************" +
				hash.size());
		final Vector<Kisi> kisiler = kisileriOku("kullanýcýlar.txt");
		for (final Kisi kisi : kisiler) {
			hash.put(kisi.getAdý(), kisi);
			heap.add(kisi);//poll kullan
			System.out.println(kisi.yazdir2() + "*******");
		}
		
		if(hash.get("Deniz Derya")!=null){
			Kisi kisi2=hash.get("Deniz Derya");
			System.out.println("#######################\n"+kisi2.yazdir2()+"\n#######################");
		}
		else{
			System.out.println("Bulunamadý\n");
		}
		
		System.out.println(heap.poll().getAdý() + "sdgsdf*******");
		Aðaç_dolaþ(kisiler);
	}
	
	@SuppressWarnings("unchecked")
	private static Comparator<? super Kisi> extracted(Comparator<?> comparator) {
		return (Comparator<? super Kisi>) comparator;
	}

	public static Vector<Kisi> kisileriOku(final String fileName) {

		final Vector<Kisi> kisiler = new Vector<Kisi>();

		// burada tanimliyoruz boylece finally blogunda gorulebiliyor
		BufferedReader input = null;
		try {
			// her okumada tek satir okuyacak sekilde kullanabilecegimiz yapi
			input = new BufferedReader(new FileReader(fileName));
			String line = null; // while dongusu icinde tanimlamiyoruz

			while ((line = input.readLine()) != null) {
				final StringTokenizer st = new StringTokenizer(line, "#");
				Kisi kisi = new Kisi(st.nextToken(), st.nextToken(),
						st.nextToken(), st.nextToken(), st.nextToken(),
						st.nextToken(), st.nextToken(), st.nextToken(),
						st.nextToken(), st.nextToken());
				String toplu_bilgiler = st.nextToken();
				StringTokenizer st2 = new StringTokenizer(toplu_bilgiler, ">>");
				int bilgi_sayýsý = Integer.parseInt(st2.nextToken());
				String karma_bilgiler = "";
				while (bilgi_sayýsý > 0) {
					bilgi_sayýsý--;
					karma_bilgiler = st2.nextToken();
					StringTokenizer st3 = new StringTokenizer(karma_bilgiler,
							"_");
					Bilgi bilgi = new Bilgi(st3.nextToken(), st3.nextToken(),st3.nextToken(),
							Integer.parseInt(st3.nextToken()), 
							Integer.parseInt(st3.nextToken()),
							Integer.parseInt(st3.nextToken()));
					kisi.asd(bilgi);
				}
				kisiler.add(kisi);
			}
		} catch (final FileNotFoundException ex) {
			// Dosya bulunamadi hatasi
			// Bir hata olusursa ekrana yaziyoruz
			ex.printStackTrace();
		} catch (final IOException ex) {
			// Herhangi bir I/O hatasi
			// Bir hata olusursa ekrana yaziyoruz
			ex.printStackTrace();
		} finally {
			try {
				if (input != null) {
					// actigimiz dosyayi kapatmaliyiz
					input.close();
				}
			} catch (final IOException ex) {
				// Bir hata olusursa ekrana yaziyoruz
				ex.printStackTrace();
			}
		}
		return kisiler;
	}
	private static void Aðaç_dolaþ(Vector<Kisi> kisiler){
		Tree theTree = new Tree();
		// Agaca 10 tane sayý yerlestirilmesi
		System.out.println("Kisiler : ");
		for (int i = 0; i < kisiler.size(); ++i) {
			theTree.insert(kisiler.elementAt(i));
		}
		InOrder(theTree);
		PreOrder(theTree);
		PostOrder(theTree);
	}
	private static void InOrder(Tree theTree){
		System.out.println("Agacýn InOrder Dolasýlmasý :");
		theTree.inOrder(theTree.getRoot());
	}
private static void PreOrder(Tree theTree){
	System.out.println("Agacýn PreOrder Dolasýlmasý :");
	theTree.preOrder(theTree.getRoot());
	}
private static void PostOrder(Tree theTree){
	System.out.println("Agacýn PostOrder Dolasýlmasý :");
	theTree.postOrder(theTree.getRoot());
}
}
