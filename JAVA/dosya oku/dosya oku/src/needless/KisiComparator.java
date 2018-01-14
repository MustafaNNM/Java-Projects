package needless;

import java.util.Comparator;

public class KisiComparator implements Comparator<Kisi> {

	@Override
	public int compare(Kisi v1, Kisi v2) {
		// TODO Auto-generated method stub
		return ((Kisi)v1).getAdý().compareTo(((Kisi)v2).getAdý());
	}

}
