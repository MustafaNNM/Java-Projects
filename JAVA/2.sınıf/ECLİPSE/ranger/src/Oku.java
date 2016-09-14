import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Oku {
	Vector<String> sat�rlar = new Vector<String>();
	private static int t�r=-1;
	int size = 0;
	public String metin;

	public Oku(final String fileName) {
		// TODO Auto-generated method stub

		BufferedReader input = null;
		try {
			// her okumada tek satir okuyacak sekilde kullanabilecegimiz yapi
			input = new BufferedReader(new FileReader(fileName));
			String sat�r = null; // while dongusu icinde tanimlamiyoruz
			
			while ((sat�r = input.readLine()) != null) {
				sat�rlar.add(sat�r);
				ayr��t�r(sat�rlar.elementAt(size++));
			}
			if(4==getT�r()){
				System.out.println("beklenen karakter '}' bulunamad�");
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
	}
	private void ayr��t�r(String karakter) {
		// TODO Auto-generated method stub
		int i = 0;
		char h=' ';
		metin = "";
		while (i < karakter.length()) {
			if(getT�r()!=4){
			h = karakter.charAt(i++);
			t�r_belirle(h);}
			switch(getT�r()){
			case 10:System.out.println("bilinmeyen karakter:("+h+")");break;
			case 0:
				break;
			case 1:System.out.println("sat�r sonu");break;
			case 2:System.out.println("sol parantez'('");break;
			case 3:System.out.println("sol parantez')'");break;
			case 4:
				while(i < karakter.length()){
					h = karakter.charAt(i++);
					t�r_belirle(h);
					if(5!=getT�r())
					{
						setT�r(4);
					}
				}
				break;
			case 5:break;
			case 6:
				if(h=='-')
				{
					while(i < karakter.length()){
						h = karakter.charAt(i++);
						t�r_belirle(h);
						if(8==getT�r()){
							break;
						}
						else
						{
							setT�r(4);
						}
					}
				}
				break;
			case 7:break;
			case 8:
				while(i < karakter.length()&&8==getT�r()){
					metin+=h;
					h = karakter.charAt(i++);
					t�r_belirle(h);
				}
				System.out.println("t�r:"+getT�r());
				System.out.println("pozitif say�:"+metin);
				metin="";
				metin+=h;
				break;
			case 9:
				System.out.println("t�r:"+getT�r());
				while(i < karakter.length()&&9==getT�r()){
					metin+=h;
					h = karakter.charAt(i++);
					t�r_belirle(h);
				}
				System.out.println("t�r:"+getT�r());
				System.out.println("de�i�ken ad�:"+metin);
				metin="";
				metin+=h;
				break;
			}
		}
	}

	private void t�r_belirle(char h) {
		switch (h) {
		case ' ':setT�r(0);break;
		case ';':setT�r(1);break;
		case '(':setT�r(2);break;
		case ')':setT�r(3);break;
		case '{':setT�r(4);break;
		case '}':setT�r(5);break;
		case '+':case '-':case '*':setT�r(6);break;
		case '<':case '>':case '=':setT�r(7);break;
		case '1':case '3':case '5':case '7':case '9':
		case '0':case '2':case '4':case '6':case '8':
			setT�r(8);break;
		case 'a':case 'A':case 'b':case 'B':case 'c':case 'C':case '�':case '�':
		case 'd':case 'D':case 'e':case 'E':case 'f':case 'F':case 'g':case 'G':
		case '�':case '�':case 'h':case 'H':case '�':case 'I':case 'i':case '�':
		case 'j':case 'J':case 'k':case 'K':case 'l':case 'L':case 'm':case 'M':
		case 'n':case 'N':case 'o':case 'O':case '�':case '�':case 'p':case 'P':
		case 'q':case 'Q':case 'r':case 'R':case 's':case 'S':case '�':case '�':
		case 't':case 'T':case 'u':case 'U':case '�':case '�':case 'v':case 'V':
		case 'w':case 'W':case 'x':case 'X':case 'y':case 'Y':case 'z':case 'Z':
			setT�r(9);break;
		default:
			setT�r(10);
		}
	}

	public void setT�r(int sayi) {
		t�r = sayi;
	}

	public int getT�r() {
		return t�r;
	}
	String ToString() {
		String metin = "";
		int i = 0;
		while (i < sat�rlar.size()) {
			metin += (i + 1) + "\t" + sat�rlar.elementAt(i++) + "\n";
		}
		return metin;
	}
}
