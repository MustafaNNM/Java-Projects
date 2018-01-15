
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.util.IO;

import java.net.URL;

public class HelloWorld extends AbstractHandler {
	private static HtmlCodePrinterofHost htmlcodeprinterofhost=new HtmlCodePrinterofHost();
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("DEBUG:1");
		String requestURI = "";
		System.out.println("DEBUG:2");
		requestURI = request.getRequestURI();
		System.out.println("DEBUG:3");
		if (requestURI.startsWith("/ohds/")) {
			response.setContentType("text/html;charset=utf-8");
			//String sorgu = "";
			System.out.println("DEBUG:4");
			String host = "http://api.wunderground.com/api/d967493a39902bc0/conditions/lang:TR/q/Turkey/Kahramanmaras.json";
            //"http://api.wunderground.com/api/d967493a39902bc0/conditions/q/CA/San_Francisco.json";
			//System.out.println("requestURI:" + requestURI);

			System.out.println("DEBUG:5");

			try {
				//sorgu = requestURI.substring(6);
			} catch (StringIndexOutOfBoundsException e1) {
				e1.printStackTrace();
			}
			//System.out.println("resim adý:" + sorgu);
			System.out.println("DEBUG:132");
			response.setStatus(HttpServletResponse.SC_OK);
			System.out.println("DEBUG:133");
			out = response.getWriter();
			try {
				String word="<form action=\"http://localhost:8080/ohds\"><div>\r\n" + 
						"<select name=\"menu\">\r\n" + 
						"<option value=\"0\" selected>(please select:)</option>\r\n" + 
						"<option value=\"1\">TR</option>\r\n" + 
						"<option value=\"2\">two</option>\r\n" + 
						"<option value=\"3\">three</option>\r\n" + 
						"<option value=\"other\">other, please specify:</option>\r\n" + 
						"</select>\r\n" + 
						"<input type=\"text\" name=\"choicetext\"></div>\r\n" + 
						"<div><input type=\"submit\" value=\"submit\"></div>\r\n" + 
						"</form>";
				out.print(word);
				} finally { 
				//out.close();
				}
			//response.getWriter().println("Online Hava Durumu Sorgulama");
			htmlcodeprinterofhost.printhtmlcodesofhost(response,host);
			System.out.println("DEBUG:134");
			response.setStatus(HttpServletResponse.SC_OK);
			System.out.println("DEBUG:135");
			baseRequest.setHandled(true);
			System.out.println("DEBUG:136");
			return;

		} else {
			System.out.println("DEBUG:137");
			// little cheat for common request
			if (_serveIcon && _favicon != null && requestURI.equals("/favicon.ico")) {
				System.out.println("DEBUG:138");
				response.setStatus(HttpServletResponse.SC_OK);
				System.out.println("DEBUG:139");
				response.setContentType("image/x-icon");
				
				System.out.println("DEBUG:140");
				response.setContentLength(_favicon.length);
				System.out.println("DEBUG:141");
				response.getOutputStream().write(_favicon);
				System.out.println("DEBUG:142");
				return;
			} else {
				System.out.println("DEBUG:143");
				response.setStatus(HttpServletResponse.SC_OK);
				System.out.println("DEBUG:144");
				baseRequest.setHandled(true);
				System.out.println("DEBUG:145");
				return;
			}
		}
	}

	// @Override
	// public void handle(String target, Request baseRequest, HttpServletRequest
	// request, HttpServletResponse response)
	// throws IOException, ServletException {
	// response.setContentType("text/html;charset=utf-8");
	// response.setStatus(HttpServletResponse.SC_OK);
	// baseRequest.setHandled(true);
	// response.getWriter().println("Bismillahirrahmanirrahim");
	// return;
	// }
	byte[] _favicon;
	boolean _serveIcon = true;
	private PrintWriter out;

	public HelloWorld() {
		try {
			URL fav = this.getClass().getClassLoader().getResource("./img/favicon.ico");
			if (fav != null)
				_favicon = IO.readBytes(fav.openStream());
		} catch (Exception e) {
			e.printStackTrace();
			// Log.warn(e);
		}
	}

	/**
	 * @return the htmlcodeprinterofhost
	 */
	public static HtmlCodePrinterofHost getHtmlcodeprinterofhost() {
		return htmlcodeprinterofhost;
	}

	/**
	 * @param htmlcodeprinterofhost the htmlcodeprinterofhost to set
	 */
	public static void setHtmlcodeprinterofhost(HtmlCodePrinterofHost htmlcodeprinterofhost) {
		HelloWorld.htmlcodeprinterofhost = htmlcodeprinterofhost;
	}
}