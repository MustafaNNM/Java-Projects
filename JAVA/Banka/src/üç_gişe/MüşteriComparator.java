package üç_giþe;

import java.util.Comparator;

public class MüþteriComparator implements Comparator<Object> {
	public int compare(Object v1, Object v2) {
		String S1 = "", S2 = "";
		S1 += ((Müþteri) v1).getSüre();
		S2 += ((Müþteri) v2).getSüre();
		return (S1.compareTo(S2));
	}
}
