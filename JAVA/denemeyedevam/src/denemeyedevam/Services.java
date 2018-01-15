/**
 * 
 */
package denemeyedevam;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.ServletOutputStream;

/**
 * @author ENTER-NET
 *
 */
public class Services {
	public Merger merger=new Merger();
	public Scalar scalar=new Scalar();
	public void resmi_oku(String uRL_to_make_request, String image_name) {
		// TODO Auto-generated method stub
		
	}
	
	public void saveImage(String imageUrl, String image_name, ServletOutputStream servletOutputStream) throws IOException {
	    URL url = new URL(""+imageUrl+image_name);
	    InputStream is = url.openStream();
	    OutputStream os = new FileOutputStream("./img/"+image_name);

	    byte[] b = new byte[2048];
	    int length;

	    while ((length = is.read(b)) != -1) {
	    	servletOutputStream.write(b, 0, length);
	        os.write(b, 0, length);//cache yaz sonra dosyaya
	    }

	    is.close();
	    os.close();
	}
}
