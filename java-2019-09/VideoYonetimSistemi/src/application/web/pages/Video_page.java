package application.web.pages;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

import application.web.Page;

public class Video_page extends Page {
	private String requestURI = "";// loglanmasý gerekiyor.
	public String video_file_name_constant = "video_file_name";// Stream_page classý içerisindeki deðiþken ile ayný
																// deðere sahip olmasý gerekiyor.
	
	private String sayfalar = "<a href=\"http://localhost:8080/home\">Anasayfa</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/video\">Video</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/devicemanagement\">Devicemanagement</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/accesscontrol\">Accesscontrol</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/actionengine\">Actionengine</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/advancedsecurity\">Advancedsecurity</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/analytics\">Analytics</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/analyticsdevice\">Analyticsdevice</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/authenticationbehavior\">Authenticationbehavior</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/credential\">Credential</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/deviceio\">Deviceio</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/display\">Display</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/doorcontrol\">Doorcontrol</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/event\">Event</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/imaging\">Imaging</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/media\">Media</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/media2\">Media2</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/provisioning\">Provisioning</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/ptz\">PTZ</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/receiver\">Receiver</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/recording\">Recording</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/replay\">Replay</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/schedule\">Schedule</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/search\">Search</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/thermal\">Thermal</a>\r\n<br>";
	
	private String html_code = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "  <head>\r\n"
			+ "    <title>Video Stream</title>\r\n"
			+ "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" + "  </head>\r\n"
			+ "  <body>\r\n" + sayfalar + "    <div>\r\n" + "      <video id=\"video\" controls>  \r\n"
			+ "        <source src=\"stream?" + video_file_name_constant + "=omcek.mov\" />  \r\n" + "      </video>\r\n"
			+ "    </div>\r\n" + "  </body>\r\n" + "</html>";
	
	// film_listesi.getelementat(i)
	// Video_page.html dosyasýndan okuma yaptýrma iþlemi
	// yapýlabilinir.
	// Böylece sayfalar harici yazýlýmla düzenlenebilir.
	// Oluþabilinecek kod hatalarýna dikkat etmek gerekir.

	public Video_page(String string) {
		super(string);
	}

	public void load(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("video page load fonksiyonu");
		requestURI_toString(request);
		response.setContentType("text/html;charset=utf-8");
		System.out.println("DEBUG:132");
		response.setStatus(HttpServletResponse.SC_OK);
		System.out.println("DEBUG:133");
		try {
			response.getWriter().println(html_code);
		} catch (IOException e1) {
			System.out.println("Class:Video_page,function:load,Exception:IOException,parameter:e1");
			e1.printStackTrace();
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			System.exit(1);return;
		} catch (Exception e2) {
			System.out.println("Class:Video_page,function:load,Exception:IOException,parameter:e2");
			e2.printStackTrace();
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			System.exit(1);return;
		}
		System.out.println("DEBUG:134");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		System.out.println("DEBUG:136");
		System.exit(1);return;
	}


	public String getRequestURI() {
		return requestURI;
	}

	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}

}
