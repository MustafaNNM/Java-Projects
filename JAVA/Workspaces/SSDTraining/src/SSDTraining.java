import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SSDTraining {

	private void writeFile() throws FileNotFoundException, IOException {
		FileOutputStream fosCharFile = new FileOutputStream("C:\\Users\\MehmetAkif-PC\\workspace\\SSDTraining\\src\\test.txt");
		
		int ch=0;
		
		for(ch=0;ch<256;ch++) {
			fosCharFile.write(ch);
		}
		
		fosCharFile.close();
	}
	
	public static void readFile() throws FileNotFoundException,IOException {
		
		FileInputStream fisCharFile;
		
		fisCharFile =new FileInputStream("C:\\Users\\MehmetAkif-PC\\workspace\\SSDTraining\\src\\test.txt");
		
		int ch=0;
		while((ch=fisCharFile.read())!=-1) {
			System.out.println((char)ch);
		}
		
		fisCharFile.close();
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		SSDTraining train = new SSDTraining();
		train.writeFile();
		SSDTraining.readFile();
	}

	private SSDTraining() throws IOException,FileNotFoundException{
		
		writeFile();
	}


}
