package dosya;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DosyaYazma {

	public static void main(final String[] args) {
		try {
			final BufferedWriter out = new BufferedWriter(new FileWriter(
					"yeni.txt"));
			final PrintWriter pw = new PrintWriter(out);
//buffer için flussh metodu var
			pw.println("mehmet");
			out.write("akif");
			out.close();
		} catch (final IOException e) {
		}
	}
}
