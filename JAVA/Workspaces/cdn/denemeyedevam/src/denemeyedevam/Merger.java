/**
 * 
 */
package denemeyedevam;

/**
 * @author ENTER-NET
 *
 */
public class Merger {
	@SuppressWarnings("unused")
	private static void merge() throws Exception{
		Scalar scalar = new Scalar();
		String path1 = scalar.scale("./img/france.jpg", 50, 50, "first.jpg");
		String path2 = scalar.scale("./img/nature.jpg", 50, 50, "second.jpg");
		String merge = scalar.merge(path1, path2, "merged.jpg");
		scalar.toGray("./img/tumbnails/merged.jpg");
	}
}
