/**
 * 
 */
package denemeyedevam;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * @author ENTER-NET
 *
 */
public class Scalar {
	
	public static String TUMBNAILS = "./img/tumbnails/";

	/**
	 * Generates a tumbnail of an image depicted by given path.
	 * 
	 * @param path
	 *            Absolute position of an image file.
	 * @param fileName New file's name. 
	 * @return path of geneterated tumbnail.
	 * @throws Exception
	 */
	public String scale(String path, String fileName, int IMG_WIDTH, int IMG_HEIGHT) throws Exception {
		BufferedImage originalImage = ImageIO.read(new File(path));
		BufferedImage resizedCopy = createResizedCopy(originalImage, IMG_WIDTH, IMG_HEIGHT, true);
		File tosave = new File(TUMBNAILS + fileName);
		ImageIO.write(resizedCopy, "jpg", tosave);
		return tosave.getAbsolutePath();
	}

	/**
	 * Generates a tumbnail of an image depicted by given path.
	 * 
	 * @param path
	 *            Path of an image file.
	 * @param width
	 *            Width of new image.
	 * @param height
	 *            Height of new image.
	 * @param filename Name on which new file is expected to be found.
	 * @return path of geneterated tumbnail.
	 * @throws Exception
	 */
	public String scale(String path, int width, int height, String filename) throws Exception {
		BufferedImage originalImage = ImageIO.read(new File(path));
		BufferedImage resizedCopy = createResizedCopy(originalImage, width, height, true);
		File tosave = new File(TUMBNAILS + filename);
		ImageIO.write(resizedCopy, "jpg", tosave);
		return tosave.getAbsolutePath();
	}

	/**
	 * Merges given images with path parameters into a new image
	 * @param path1 File path of first image
	 * @param path2 File path of second image
	 * @param filename  Target file name.
	 * @return Path of new image file. 
	 * @throws Exception
	 */
	public String merge(String path1, String path2, String filename) throws Exception {
		BufferedImage firstImage = ImageIO.read(new File(path1));
		BufferedImage secondImage = ImageIO.read(new File(path2));
		BufferedImage resizedCopy = merge(firstImage, secondImage);
		File tosave = new File(TUMBNAILS + filename);
		ImageIO.write(resizedCopy, "jpg", tosave);
		return tosave.getAbsolutePath();
	}

	/**
	 * Generates a tumbnail of an image depicted by given path.
	 * 
	 * @param path
	 *            Absolute position of an image file.
	 * @return path of geneterated tumbnail.
	 * @throws Exception
	 */
	public String toGray(String path) throws Exception {
		BufferedImage originalImage = ImageIO.read(new File(path));
		BufferedImage resizedCopy = convertGrayScale(originalImage);
		//transfer gerek önce
		File tosave = new File(TUMBNAILS + "gray.jpg");
		ImageIO.write(resizedCopy, "jpg", tosave);
		return tosave.getAbsolutePath();
	}

	/**
	 * Takes original {@link Image} and scales it according to the scaledWidth
	 * and scaledHeight parameters. If original image contains alpha color code
	 * and you want to save them, please set preserveAlpha parameter true.
	 * 
	 * @param originalImage
	 *            Image to scale
	 * @param scaledWidth
	 *            Target image's width
	 * @param scaledHeight
	 *            Target image' height
	 * @param preserveAlpha
	 *            condition to care alpha color code.
	 * @return Scaled {@link Image} object.
	 */
	private BufferedImage createResizedCopy(Image originalImage, int scaledWidth, int scaledHeight,
			boolean preserveAlpha) {
		System.out.println("resizing...");
		int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
		BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
		Graphics2D g = scaledBI.createGraphics();
		if (preserveAlpha) {
			g.setComposite(AlphaComposite.Src);
		}
		g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
		g.dispose();
		return scaledBI;
	}
	// BufferedImage createResizedCopy()
		BufferedImage resizeImage(BufferedImage originalImage, int IMG_WIDTH, int IMG_HEIGHT) {
			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB
					: originalImage.getType();// ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
			BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
			g.dispose();
			return resizedImage;
		}
	/**
	 * Converts given image to gray scale.
	 * 
	 * @param originalImage
	 *            to transform into gray scale.
	 * @return gray scaled copy of original image.
	 */
	private BufferedImage convertGrayScale(BufferedImage originalImage) {
		int width = originalImage.getWidth();
		int height = originalImage.getHeight();

		BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		for (int i = 0; i < height; i++) {

			for (int j = 0; j < width; j++) {

				Color c = new Color(originalImage.getRGB(j, i));
				int red = (int) (c.getRed() * 0.299);
				int green = (int) (c.getGreen() * 0.587);
				int blue = (int) (c.getBlue() * 0.114);
				Color newColor = new Color(red + green + blue,

						red + green + blue, red + green + blue);

				newImg.setRGB(j, i, newColor.getRGB());
			}
		}
		return newImg;
	}

	/**
	 * Merges given to images into one.
	 * 
	 * @param firstImage
	 *            First image to tile.
	 * @param secondImage
	 *            Second image to tile.
	 * @return merged image.
	 */
	private BufferedImage merge(BufferedImage firstImage, BufferedImage secondImage) {
		BufferedImage newImage = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);
		Graphics g = newImage.getGraphics();
		g.drawImage(firstImage, 0, 0, null);
		g.drawImage(secondImage, 50, 0, null);
		return newImage;
	}

//	public static void main(String[] args) throws Exception {
//		for(int i=0;i<100;i++){
//			long startTime = System.currentTimeMillis();			
//			merge();		
//			long duration = System.currentTimeMillis() - startTime;
//			System.out.println("Converted in " + duration);
//		}
////		String path = "./img/all/0000000000_1_1_1.jpg";
////		// "0001000000_2_1_1.jpg"
////		// "0045384999_1_1_1.jpg"
////		// "0045385999_1_1_1.jpg"
////		// "0045386999_1_1_1.jpg"
////		// "0045412999_1_1_1.jpg"
////		// "0045414999_1_1_1.jpg"
////		// "0045415999_1_1_1.jpg"
////		// String path = "./img/france.jpg";
////		// new Scalar().scale(path);
////		new Scalar().toGray(path);
//	}
	
	
}
