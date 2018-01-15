
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

public class HelloWorld extends AbstractHandler {
	private static HtmlCodePrinterofHost htmlcodeprinterofhost = new HtmlCodePrinterofHost();

	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("DEBUG:1");
		String requestURI = "";
		System.out.println("DEBUG:2");
		requestURI = request.getRequestURI();
		System.out.println("DEBUG:3");
		if (requestURI.startsWith("/ohds/")) {
			response.setContentType("text/html;charset=utf-8");
			// String sorgu = "";
			System.out.println("DEBUG:4");

			// "http://api.wunderground.com/api/d967493a39902bc0/conditions/q/CA/San_Francisco.json";
			// System.out.println("requestURI:" + requestURI);

			System.out.println("DEBUG:5");

			try {
				// sorgu = requestURI.substring(6);
			} catch (StringIndexOutOfBoundsException e1) {
				e1.printStackTrace();
			}
			// System.out.println("resim adý:" + sorgu);
			System.out.println("DEBUG:132");
			response.setStatus(HttpServletResponse.SC_OK);
			System.out.println("DEBUG:133");
			out = response.getWriter();
			try {
				String word = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
						+ "    <meta charset=\"utf-8\" />\r\n" + "    <title>JavaScript Shield UI Demos</title>\r\n"
						+ "    <link id=\"themecss\" rel=\"stylesheet\" type=\"text/css\" href=\"//www.shieldui.com/shared/components/latest/css/light/all.min.css\" />\r\n"
						+ "    <script type=\"text/javascript\" src=\"//www.shieldui.com/shared/components/latest/js/jquery-1.11.1.min.js\"></script>\r\n"
						+ "    <script type=\"text/javascript\" src=\"//www.shieldui.com/shared/components/latest/js/shieldui-all.min.js\"></script>\r\n"
						+ "</head>\r\n" + "<body class=\"theme-light\">\r\n" + "<div>\r\n"
						+ "    <div class=\"outerDiv\">\r\n" + "        <div class=\"innerDiv\">\r\n"
						+ "            <label for=\"comboBoxLocations\">Select technology</label>\r\n"
						+ "            <br />\r\n" + "            <input id=\"comboBoxLocations\" />\r\n"
						+ "            <br />\r\n" + "            <button id=\"submit\">Sorgula</button>\r\n"
						+ "        </div>\r\n" + "        <div class=\"imageDiv\">\r\n"
						+ "            <img class=\"img-responsive\" src=\"/Content/img/combobox/codesnippet.png\" />\r\n"
						+ "        </div>\r\n" + "    </div>\r\n" + "</div>\r\n"
						+ "<script type=\"text/javascript\">\r\n" +
						/* veritabanindan veri çekmek gerekiyor */
						"    var Locations = ['Turkey/Kahramanmaras', 'Turkey/Ankara', 'Turkey/Bursa', 'Turkey/Izmir', 'Turkey/Istanbul', 'Turkey/Diyarbakir', 'Turkey/Kahramanmaras', 'Turkey/Kahramanmaras', 'Turkey/Kahramanmaras', 'Turkey/Kahramanmaras'];\r\n"
						+ "    jQuery(function ($) {\r\n" + "        $(\"#comboBoxLocations\").shieldComboBox({\r\n"
						+ "            dataSource: {\r\n" + "                data: Locations\r\n" + "            },\r\n"
						+ "            autoComplete: {\r\n" + "                enabled: true\r\n" + "            }\r\n"
						+ "        });\r\n" + "        $(\"#submit\").shieldButton({\r\n" + "            events: {\r\n"
						+ "                click: function () {\r\n"
						+ "                    var Location = $(\"#comboBoxLocations\").swidget().value();\r\n" +
						/* burada request yapýlmasý lazým */
						"                    alert(\"Location: \" + Location);\r\n"
						+ "window.location.assign(\"http://localhost:8080/ohds/?location=\"+Location)"
						+ "                }\r\n" + "            }\r\n" + "        });\r\n" + "    });\r\n"
						+ "</script>\r\n" + "<style>\r\n" + "    .outerDiv\r\n" + "    {\r\n"
						+ "        max-width: 600px;\r\n" + "        content: \".\";\r\n"
						+ "        display: block;\r\n" + "        overflow: hidden;\r\n"
						+ "        margin-left: auto;\r\n" + "        margin-right: auto;\r\n" + "    }\r\n"
						+ "    .innerDiv\r\n" + "    {\r\n" + "        display: inline-block;\r\n"
						+ "        margin: 10px;\r\n" + "    }\r\n" + "    .innerDiv label\r\n" + "    {\r\n"
						+ "        font-style: italic;\r\n" + "        font-size: 1.1em;\r\n" + "    }\r\n"
						+ "    .imageDiv\r\n" + "    {\r\n" + "        display: inline-block;\r\n"
						+ "        max-width: 300px;\r\n" + "        margin: 10px;\r\n" + "    }\r\n"
						+ "    .innerDiv .sui-combobox\r\n" + "    {\r\n"
						+ "        font-family: Arial, sans-serif;\r\n" + "        font-size: 14px;\r\n"
						+ "        margin-bottom: 10px;\r\n" + "    }\r\n" + "</style>\r\n" + "</body>\r\n" + "</html>";
				out.print(word);
			} finally {
				// out.close();
			}
			// response.getWriter().println("Online Hava Durumu Sorgulama");
			// Urlyi parse edip lokasyon deðerini almamýz gerekiyor.
			Enumeration<String> parameterNames;
			System.out.println("DEBUG:7");
			parameterNames = request.getParameterNames();
			System.out.println("DEBUG:8");
			String name = "";
			String value = "";
			String lokasyon = "Turkey/Kahramanmaras";
			@SuppressWarnings("unused")
			boolean hata_var_mý = false;
			while (parameterNames.hasMoreElements()) {
				System.out.println("DEBUG:9");
				try {
					System.out.println("DEBUG:10");
					name = (String) parameterNames.nextElement();
					System.out.println("DEBUG:11");
				} catch (NoSuchElementException e) {
					System.out.println("DEBUG:12");
					hata_var_mý = true;
					System.out.println("DEBUG:13");
					response.setStatus(HttpServletResponse.SC_OK);
					System.out.println("DEBUG:14");
					baseRequest.setHandled(true);
					System.out.println("DEBUG:15");
					e.printStackTrace();
					System.out.println("DEBUG:16");
					return;
				}
				System.out.println("DEBUG:17");
				value = request.getParameter(name).toString();
				System.out.println("DEBUG:18");
				System.out.println(String.format("%s==%s\n", name, value));
				System.out.println("DEBUG:19");
				if (name.startsWith("location")) {
					System.out.println("DEBUG:20");
					try {
						System.out.println("DEBUG:21");
						lokasyon = request.getParameter(name);
						String host = "http://api.wunderground.com/api/d967493a39902bc0/conditions/lang:TR/q/"
								+ lokasyon + ".json";
						htmlcodeprinterofhost.printhtmlcodesofhost(response, host);
						System.out.println("DEBUG:22");
					} catch (NumberFormatException e) {
						System.out.println("DEBUG:23");
						System.out.println("DEBUG:24");
						hata_var_mý = true;
						System.out.println("DEBUG:25");
						e.printStackTrace();
						System.out.println("DEBUG:26");
						response.setStatus(HttpServletResponse.SC_OK);
						System.out.println("DEBUG:27");
						baseRequest.setHandled(true);
						System.out.println("DEBUG:28");
						return;
					}
					System.out.println("DEBUG:29");
				} else {
					response.setStatus(HttpServletResponse.SC_OK);
					System.out.println("DEBUG:45");
					baseRequest.setHandled(true);
					System.out.println("DEBUG:46");
					return;
				}
				System.out.println("DEBUG:47");
			}

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
	 * @param htmlcodeprinterofhost
	 *            the htmlcodeprinterofhost to set
	 */
	public static void setHtmlcodeprinterofhost(HtmlCodePrinterofHost htmlcodeprinterofhost) {
		HelloWorld.htmlcodeprinterofhost = htmlcodeprinterofhost;
	}
}