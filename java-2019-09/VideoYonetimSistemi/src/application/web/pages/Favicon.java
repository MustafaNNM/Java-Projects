/**
 * 
 */
package application.web.pages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import application.web.Page;
import net.sf.image4j.codec.ico.ICODecoder;

/**
 * @author MehmetAkif-PC
 *
 */
public class Favicon extends Page {
	private String requestURI = null;// loglanmasý gerekiyor.
	BufferedImage originalImage = null;
	List<BufferedImage> images = null;

	public Favicon(String string) {
		super(string);
		File f = null;
		String images_folder_path = ".\\img\\";
		String image_name = "favicon.ico";
		if (image_name.length() > 0) {
			try {
				f = new File("" + images_folder_path + image_name);
			} catch (NullPointerException e) {
				e.printStackTrace();
				System.exit(1);
				return;
			} catch (Exception e) {
				System.out.println("Exception");
				e.printStackTrace();
				System.exit(1);
				return;
			}
		} else {
			System.out.println("favicon dosya adý giriniz!");
			return;
		}
		if (f.exists() && f.isFile()) {
			try {
				System.out.println("DEBUG:115");
				images = ICODecoder.read(f);
				System.out.println("DEBUG:116");
			} catch (IIOException e) {
				System.out.println("IIOException");
				e.printStackTrace();
				System.exit(1);
				return;
			} catch (IOException e) {
				System.out.println("IOException");
				e.printStackTrace();
				System.exit(1);
				return;
			} catch (Exception e) {
				System.out.println("Exception");
				e.printStackTrace();
				System.exit(1);
				return;
			}
		} else {
			System.out.println("Dosya bulunamadý!");
		}
	}

	public void load(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		if (originalImage != null) {
			response.setHeader("Content-Type", "image/jpg");
			// response.setHeader("Content-Length", String.format("%s", originalImage.));
			ServletOutputStream output = null;
			try {
				output = response.getOutputStream();
			} catch (IOException e1) {
				System.out.println("IOException");
				e1.printStackTrace();
				response.setStatus(HttpServletResponse.SC_OK);
				baseRequest.setHandled(true);
				System.exit(1);
				return;
			} catch (Exception e) {
				System.out.println("Exception");
				e.printStackTrace();
				response.setStatus(HttpServletResponse.SC_OK);
				baseRequest.setHandled(true);
				System.exit(1);
				return;
			}
			try {
				ImageIO.write(originalImage, "jpg", output);
			} catch (IOException e) {
				System.out.println("IOException");
				e.printStackTrace();
				response.setStatus(HttpServletResponse.SC_OK);
				baseRequest.setHandled(true);
				System.exit(1);
				return;
			} catch (Exception e) {
				System.out.println("Exception");
				e.printStackTrace();
				response.setStatus(HttpServletResponse.SC_OK);
				baseRequest.setHandled(true);
				System.exit(1);
				return;
			}
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			System.exit(1);
			return;
		} else {
			System.out.println("originalImage null");
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			System.exit(1);
			return;
		}
	}
}
