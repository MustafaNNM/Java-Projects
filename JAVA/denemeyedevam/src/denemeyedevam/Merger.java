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
		Scalar services = new Scalar();
		String path1 = services.scale("./img/france.jpg", 50, 50, "first.jpg");
		String path2 = services.scale("./img/nature.jpg", 50, 50, "second.jpg");
		String merge = services.merge(path1, path2, "merged.jpg");
		services.toGray("./img/tumbnails/merged.jpg");
	}
}
