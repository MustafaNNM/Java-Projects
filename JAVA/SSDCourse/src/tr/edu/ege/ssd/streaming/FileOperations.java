package tr.edu.ege.ssd.streaming;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperations {

	public FileOperations() throws IOException {
		copyFile();
	}

	/**
	 * Reads Zara.xlsx and copies to ZaraCopy.xlsx
	 * @throws IOException 
	 */
	private void copyFile() throws IOException {
		FileInputStream isZara = null;
		FileOutputStream osZaraCopy = null;

		try {
			isZara = new FileInputStream("./files/Zara.xlsx");
			osZaraCopy = new FileOutputStream("./files/ZaraCopy.xlsx");
			int read = 0;
			while ((read = isZara.read()) != -1) {
				osZaraCopy.write(read);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			isZara.close();
			osZaraCopy.close();
		}
	}

	/**
	 * Reads Zara.xlsx and writes to screen
	 * 
	 * @throws IOException
	 */
	private void printScreen() throws IOException {
		FileInputStream isZara = null;
		try {
			isZara = new FileInputStream("./files/Zara.xlsx");
			int read = 0;
			while ((read = isZara.read()) != -1) {
				System.out.println(read);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			isZara.close();
		}
	}

	public static void main(String[] args) throws IOException {
		new FileOperations();
	}
}
