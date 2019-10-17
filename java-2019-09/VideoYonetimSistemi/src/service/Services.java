/**
 * 
 */
package service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * @author ENTER-NET
 *
 */
public class Services {
	public Merger merger=new Merger();
	public Scalar scalar=new Scalar();
	
	

	public void image_transfer_to_disk(BufferedImage resizedImage, String image_name) throws IOException {
		try {
		    // retrieve image
		    File outputfile = new File("image_name");
		    ImageIO.write(resizedImage, "jpg", outputfile);
		} catch (IOException e) {
		   e.printStackTrace();
		}
	}
}






