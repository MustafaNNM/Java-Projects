/**
 * 
 */
package application.web.pages;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

import application.web.Page;

/**
 * @author MehmetAkif-PC
 *
 */
public class H264_2_page extends Page {
	@SuppressWarnings("unused")
	private String requestURI = "";// loglanmasý gerekiyor.
	private String sayfalar = "<a href=\"http://localhost:8080/home\">Anasayfa</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/video\">Video</a>\r\n<br>"
			+ "<a href=\"http://localhost:8080/h264_2\">H264_2</a>\r\n<br>"
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
	@SuppressWarnings("unused")
	private String html_code2= "<!DOCTYPE html>\r\n" + "<html>\r\n" + "  <head>\r\n"
			+ "    <title>Video Stream</title>\r\n"
			+ "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" + "  </head>\r\n"
			+ "  <body>\r\n" + sayfalar + "    <div>\r\n" + "<img style=\"-webkit-user-select: none;\" src=\"http://24.172.4.142/mjpg/video.mjpg?COUNTER\">"
			+ "    </div>\r\n" + "  </body>\r\n" + "</html>";
	private String uri_constant="uri";
	@SuppressWarnings("unused")
	private String html_code1="<!DOCTYPE html>\r\n" + "<html>\r\n" + "  <head>\r\n"
			+ "    <title>Video Stream</title>\r\n"
			+ "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" + "  </head>\r\n"
			+ "  <body>\r\n" + sayfalar + "    <div>\r\n" + "      <video id=\"video\" controls>  \r\n"
			+ "        <source src=\"ip_camera?" + uri_constant + "=rtsp://192.168.1.36:554/h264_2\" />  \r\n" + "      </video>\r\n"
			+ "    </div>\r\n" + "  </body>\r\n" + "</html>";
	private String html_code = "<embed type=\"application/x-vlc-plugin\" pluginspage=\"http://www.videolan.org\" autoplay=\"yes\" loop=\"no\" width=\"300\" height=\"200\" target=\"rtsp://10.20.50.15:554/0/888888:888888/main\" />\r\n" + 
			"<object classid=\"clsid:9BE31822-FDAD-461B-AD51-BE1D1C159921\" codebase=\"http://download.videolan.org/pub/videolan/vlc/last/win32/axvlc.cab\" style=\"display:none;\"></object>";



	public H264_2_page(String target) {
		super(target);
		// TODO Auto-generated constructor stub
	}
	
	public void load(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("H264_2_page load fonksiyonu");
		requestURI_toString(request);
		response.setContentType("text/html;charset=utf-8");
		System.out.println("DEBUG:132");
		response.setStatus(HttpServletResponse.SC_OK);
		response_writer_println(baseRequest, response,html_code);
		System.out.println("DEBUG:134");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		System.out.println("DEBUG:136");
		return;
	}
	
	/**
	 * @return the html_code
	 */
	public String getHtml_code() {
		return html_code;
	}
	/**
	 * @param html_code the html_code to set
	 */
	public void setHtml_code(String html_code) {
		this.html_code = html_code;
	}

}
