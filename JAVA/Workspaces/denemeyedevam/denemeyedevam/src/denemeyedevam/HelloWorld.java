package denemeyedevam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
 
public class HelloWorld extends AbstractHandler
{
	private static final int IMG_WIDTH = 500;
	private static final int IMG_HEIGHT = 500;
	
	//BufferedImage createResizedCopy()
	 private static BufferedImage resizeImage(BufferedImage originalImage, int type){
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();

		return resizedImage;
	    }
	
    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response) 
        throws IOException, ServletException
    {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        //response.getWriter().println("<h1>Bismillahirrahmanirrahim</h1>");
        //Enumeration<String> parameterNames=request.getParameterNames();
        //while(parameterNames.hasMoreElements())
        //{
        //	String name=(String) parameterNames.nextElement();
        //	String value= request.getParameter(name).toString();
        //	response.getWriter().write(String.format("%s==%s\n",name,value));
        //	if(name.startsWith("width")) {
			//	Integer width=Integer.parseInt(request.getParameter(name));
            //   response.getWriter().println("geniþlik:"+width);
        BufferedImage originalImage = ImageIO.read(new
        		File("C:\\Users\\MehmetAkif-PC\\Desktop\\anime_girl_12-wallpaper-2560x1440.jpg"));
        		response.setHeader("Content-Type", "image/jpg");// or png or gif, etc
        		int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
        		originalImage=resizeImage(originalImage, type);
        		ImageIO.write(originalImage,"jpg",response.getOutputStream());
        //}
       // }
        baseRequest.setHandled(true);
        		//response.getOutputStream().close();
        //response.sendRedirect("http://www.google.com");
        //response.getWriter().println("<h1>Bismillahirrahmanirrahim</h1>");
        return;
    }
 
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);
        server.setHandler(new HelloWorld());
        server.start();
        server.join();
    }
}