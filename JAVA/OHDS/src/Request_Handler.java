
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.util.IO;

import java.net.URL;
import java.util.Enumeration;
import java.util.NoSuchElementException;

public class Request_Handler extends AbstractHandler {
	private static HtmlCodePrinterofHost htmlcodeprinterofhost = new HtmlCodePrinterofHost();
	int kullanici_tipi=3;//root=0,admin=1,standart=2,ziyaretçi=3
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String requestURI = "";
		requestURI = request.getRequestURI();
		if (requestURI.equals("/anasayfa")) {// Kullanýcý anasayfaya girmek isterse
			response.setContentType("text/html;charset=utf-8");
			response.setStatus(HttpServletResponse.SC_OK);
			out = response.getWriter();
			try {
				String word = "<a href=\"http://localhost:8080/anasayfa\">Anasayfa</a>\r\n"
						+ "<a href=\"http://localhost:8080/login\">Login</a>\r\n";
				out.print(word);
			} finally {
				out.close();
			}
			baseRequest.setHandled(true);
			return;
		} else {// Kullanýcý login sayfasýna girmek isterse
			if (requestURI.equals("/login")) {
				System.out.println("login sayfasýna girdi");
				response.setContentType("text/html;charset=utf-8");
				response.setStatus(HttpServletResponse.SC_OK);
				Enumeration<String> parameterNames;
				String name = "";
				String value = "";
				String kullanici_adi = "";
				String password = "";
				String giris_parametreleri = "";
				Boolean parametre_varmi = false;
				parameterNames = request.getParameterNames();
				
				try {
					giris_parametreleri = requestURI.substring(6);
				} catch (StringIndexOutOfBoundsException e1) {
					e1.printStackTrace();
				}
				
				while (parameterNames.hasMoreElements()) {
					parametre_varmi = true;
					try {
						name = (String) parameterNames.nextElement();
					} catch (NoSuchElementException e) {
						response.setStatus(HttpServletResponse.SC_OK);
						baseRequest.setHandled(true);
						e.printStackTrace();
						return;
					}
					value = request.getParameter(name).toString();
					System.out.println(String.format("%s==%s\n", name, value));
					if (name.equals("kullanici_adi")) {
						try {
							kullanici_adi = request.getParameter(name);
						} catch (Exception e) {
							response.setStatus(HttpServletResponse.SC_OK);
							baseRequest.setHandled(true);
							return;
						}
					} else {
						if (name.equals("password")) {
							try {
								password = request.getParameter(name);
								
							} catch (Exception e) {
								response.setStatus(HttpServletResponse.SC_OK);
								baseRequest.setHandled(true);
								return;
							}
						} 
						}
					}
				
				if (parametre_varmi == false) {
					out = response.getWriter();
					try {
						String word = "<a href=\"http://localhost:8080/anasayfa\">Anasayfa</a>\r\n"
								+ "<a href=\"http://localhost:8080/login\">Login</a>\r\n";
						out.print(word);
					} finally {
						out.close();
					}
					baseRequest.setHandled(true);
					return;
				} else {
					System.out.println("giriþ parametreleri:" + giris_parametreleri);
					kullanici_tipi=kullanici_adinin_ve_sifresinin_kontrol_edilmesi(kullanici_adi, password);
				}

			} else {

			}
		}
	}

	private int kullanici_adinin_ve_sifresinin_kontrol_edilmesi(String kullanici_adi, String password) {
		
		return kullanici_tipi;
	}

	byte[] _favicon;
	boolean _serveIcon = true;
	private PrintWriter out;

	public Request_Handler() {
		try {
			URL fav = this.getClass().getClassLoader().getResource("./img/favicon.ico");
			if (fav != null) {
				_favicon = IO.readBytes(fav.openStream());
			} else {
				// yapýlmadý
			}
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
	 * @param htmlcodeprinterofhost
	 *            the htmlcodeprinterofhost to set
	 */
	public static void setHtmlcodeprinterofhost(HtmlCodePrinterofHost htmlcodeprinterofhost) {
		Request_Handler.htmlcodeprinterofhost = htmlcodeprinterofhost;
	}
}