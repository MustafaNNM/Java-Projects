package ��_gi�e;

import java.util.Comparator;

public class M��teriComparator implements Comparator<Object> {
	public int compare(Object v1, Object v2) {
		String S1 = "", S2 = "";
		S1 += ((M��teri) v1).getS�re();
		S2 += ((M��teri) v2).getS�re();
		return (S1.compareTo(S2));
	}
}
