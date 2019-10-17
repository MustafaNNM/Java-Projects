/**
 * 
 */
package application.web.pages;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

import application.web.Page;

/**
 * @author MehmetAkif-PC
 *
 */
public class Home_page extends Page {
	private String requestURI = "";// loglanmasý gerekiyor.
	
	private String sayfalar = "<a href=\"http://localhost:8080/home\">Anasayfa</a>\r\n"
			+ "<a href=\"http://localhost:8080/video\">Video</a>\r\n"
			+ "<a href=\"http://localhost:8080/devicemanagement\">Devicemanagement</a>\r\n"
			+ "<a href=\"http://localhost:8080/accesscontrol\">Accesscontrol</a>\r\n"
			+ "<a href=\"http://localhost:8080/actionengine\">Actionengine</a>\r\n"
			+ "<a href=\"http://localhost:8080/advancedsecurity\">Advancedsecurity</a>\r\n"
			+ "<a href=\"http://localhost:8080/analytics\">Analytics</a>\r\n"
			+ "<a href=\"http://localhost:8080/analyticsdevice\">Analyticsdevice</a>\r\n"
			+ "<a href=\"http://localhost:8080/authenticationbehavior\">Authenticationbehavior</a>\r\n"
			+ "<a href=\"http://localhost:8080/credential\">Credential</a>\r\n"
			+ "<a href=\"http://localhost:8080/deviceio\">Deviceio</a>\r\n"
			+ "<a href=\"http://localhost:8080/display\">Display</a>\r\n"
			+ "<a href=\"http://localhost:8080/doorcontrol\">Doorcontrol</a>\r\n"
			+ "<a href=\"http://localhost:8080/event\">Event</a>\r\n"
			+ "<a href=\"http://localhost:8080/imaging\">Imaging</a>\r\n"
			+ "<a href=\"http://localhost:8080/media\">Media</a>\r\n"
			+ "<a href=\"http://localhost:8080/media2\">Media2</a>\r\n"
			+ "<a href=\"http://localhost:8080/provisioning\">Provisioning</a>\r\n"
			+ "<a href=\"http://localhost:8080/ptz\">PTZ</a>\r\n"
			+ "<a href=\"http://localhost:8080/receiver\">Receiver</a>\r\n"
			+ "<a href=\"http://localhost:8080/recording\">Recording</a>\r\n"
			+ "<a href=\"http://localhost:8080/replay\">Replay</a>\r\n"
			+ "<a href=\"http://localhost:8080/schedule\">Schedule</a>\r\n"
			+ "<a href=\"http://localhost:8080/search\">Search</a>\r\n"
			+ "<a href=\"http://localhost:8080/thermal\">Thermal</a>\r\n"
			+ "<br>";

	public Home_page(String string) {
		super(string);
	}

	public void load(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		requestURI_toString(request);
		response.setContentType("text/html;charset=utf-8");
		response_writer_println(baseRequest, response,sayfalar);
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		return;
	}


	public String getSayfalar() {
		return sayfalar;
	}

	public void setSayfalar(String sayfalar) {
		this.sayfalar = sayfalar;
	}
}
