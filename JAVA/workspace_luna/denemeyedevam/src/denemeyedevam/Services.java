/**
 * 
 */
package denemeyedevam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;

/**
 * @author ENTER-NET
 *
 */
public class Services {
	public Merger merger=new Merger();
	public Scalar scalar=new Scalar();
	
	
	public void image_upload_and_download(String imageUrl, String image_name, ServletOutputStream servletOutputStream) throws IOException {
	    URL url = new URL(""+imageUrl+image_name);
	    InputStream is = url.openStream();
	    OutputStream os = new FileOutputStream("./img/"+image_name);

	    byte[] b = new byte[2048];
	    int length;

	    while ((length = is.read(b)) != -1) {
	    	servletOutputStream.write(b, 0, length);//upload
	    	//thread
	        os.write(b, 0, length);//download//cache
	    }
	    is.close();
	    os.close();
	}
	public void image_transfer_to_disk(BufferedImage resizedImage, String image_name) throws IOException {
		try {
		    // retrieve image
		    File outputfile = new File("image_name");
		    ImageIO.write(resizedImage, "jpg", outputfile);
		} catch (IOException e) {
		   e.printStackTrace();
		}
	}


	public boolean image_transfer_from_disk(File f, ServletOutputStream servletOutputStream) {
		BufferedImage originalImage = null;
		boolean hata_var_mý = false;
		
		try {
			System.out.println("DEBUG:115");
			originalImage = ImageIO.read(f);
			System.out.println("DEBUG:116");
		} catch (IIOException e) {
			System.out.println("DEBUG:117");
			hata_var_mý = true;
			// Can't create an ImageInputStream!
			System.out.println("DEBUG:119");
			e.printStackTrace();
			System.out.println("DEBUG:121");
	
			System.out.println("DEBUG:122");
			return hata_var_mý;
		} catch (IOException e) {
			e.printStackTrace();
			return hata_var_mý;
		}
		System.out.println("DEBUG:123");
		if (hata_var_mý == false) {
			System.out.println("DEBUG:124");
			System.out.println("DEBUG:125");
			try {
				ImageIO.write(originalImage, "jpg",
						servletOutputStream);
			} catch (IOException e1) {
				e1.printStackTrace();
				hata_var_mý = true;
				return hata_var_mý;
			}
			try {
				servletOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
				hata_var_mý = true;
				return hata_var_mý;
			}
			return hata_var_mý;
	}else{
		return hata_var_mý;
	}
	}
}






