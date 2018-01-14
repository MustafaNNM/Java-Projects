public class BisikletDeneme {
	public static void main(final String[] args) {

		// Iki farkli bisiklet nesnesi yaratalim
		final Bisiklet bisiklet1 = new Bisiklet(1, 10, 1);
		final Bisiklet bisiklet2 = new Bisiklet(2, 20, 2);

		bisiklet1.durumuYaz();
		bisiklet2.durumuYaz();
	}
}