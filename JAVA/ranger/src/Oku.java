import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Oku {
	Vector<String> satýrlar = new Vector<String>();
	private static int tür=-1;
	int size = 0;
	public String metin;

	public Oku(final String fileName) {
		// TODO Auto-generated method stub

		BufferedReader input = null;
		try {
			// her okumada tek satir okuyacak sekilde kullanabilecegimiz yapi
			input = new BufferedReader(new FileReader(fileName));
			String satýr = null; // while dongusu icinde tanimlamiyoruz
			
			while ((satýr = input.readLine()) != null) {
				satýrlar.add(satýr);
				ayrýþtýr(satýrlar.elementAt(size++));
			}
			if(4==getTür()){
				System.out.println("beklenen karakter '}' bulunamadý");
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
	private void ayrýþtýr(String karakter) {
		// TODO Auto-generated method stub
		int i = 0;
		char h=' ';
		metin = "";
		while (i < karakter.length()) {
			if(getTür()!=4){
			h = karakter.charAt(i++);
			tür_belirle(h);}
			switch(getTür()){
			case 10:System.out.println("bilinmeyen karakter:("+h+")");break;
			case 0:
				break;
			case 1:System.out.println("satýr sonu");break;
			case 2:System.out.println("sol parantez'('");break;
			case 3:System.out.println("sol parantez')'");break;
			case 4:
				while(i < karakter.length()){
					h = karakter.charAt(i++);
					tür_belirle(h);
					if(5!=getTür())
					{
						setTür(4);
					}
				}
				break;
			case 5:break;
			case 6:
				if(h=='-')
				{
					while(i < karakter.length()){
						h = karakter.charAt(i++);
						tür_belirle(h);
						if(8==getTür()){
							break;
						}
						else
						{
							setTür(4);
						}
					}
				}
				break;
			case 7:break;
			case 8:
				while(i < karakter.length()&&8==getTür()){
					metin+=h;
					h = karakter.charAt(i++);
					tür_belirle(h);
				}
				System.out.println("tür:"+getTür());
				System.out.println("pozitif sayý:"+metin);
				metin="";
				metin+=h;
				break;
			case 9:
				System.out.println("tür:"+getTür());
				while(i < karakter.length()&&9==getTür()){
					metin+=h;
					h = karakter.charAt(i++);
					tür_belirle(h);
				}
				System.out.println("tür:"+getTür());
				System.out.println("deðiþken adý:"+metin);
				metin="";
				metin+=h;
				break;
			}
		}
	}

	private void tür_belirle(char h) {
		switch (h) {
		case ' ':setTür(0);break;
		case ';':setTür(1);break;
		case '(':setTür(2);break;
		case ')':setTür(3);break;
		case '{':setTür(4);break;
		case '}':setTür(5);break;
		case '+':case '-':case '*':setTür(6);break;
		case '<':case '>':case '=':setTür(7);break;
		case '1':case '3':case '5':case '7':case '9':
		case '0':case '2':case '4':case '6':case '8':
			setTür(8);break;
		case 'a':case 'A':case 'b':case 'B':case 'c':case 'C':case 'ç':case 'Ç':
		case 'd':case 'D':case 'e':case 'E':case 'f':case 'F':case 'g':case 'G':
		case 'ð':case 'Ð':case 'h':case 'H':case 'ý':case 'I':case 'i':case 'Ý':
		case 'j':case 'J':case 'k':case 'K':case 'l':case 'L':case 'm':case 'M':
		case 'n':case 'N':case 'o':case 'O':case 'ö':case 'Ö':case 'p':case 'P':
		case 'q':case 'Q':case 'r':case 'R':case 's':case 'S':case 'þ':case 'Þ':
		case 't':case 'T':case 'u':case 'U':case 'ü':case 'Ü':case 'v':case 'V':
		case 'w':case 'W':case 'x':case 'X':case 'y':case 'Y':case 'z':case 'Z':
			setTür(9);break;
		default:
			setTür(10);
		}
	}

	public void setTür(int sayi) {
		tür = sayi;
	}

	public int getTür() {
		return tür;
	}
	String ToString() {
		String metin = "";
		int i = 0;
		while (i < satýrlar.size()) {
			metin += (i + 1) + "\t" + satýrlar.elementAt(i++) + "\n";
		}
		return metin;
	}
}
