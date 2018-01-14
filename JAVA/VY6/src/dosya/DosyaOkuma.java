package dosya;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DosyaOkuma {

	public static void main(final String[] args) {
		try {
			final BufferedReader in = new BufferedReader(new FileReader(
					"ogrenciler.txt"));
			String str;
			while ((str = in.readLine()) != null) {
				System.out.println(str);
			}
			in.close();
		} catch (final IOException e) {
		}
	}
}