/**
 * 
 */
package specification.accescontrol;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

import application.web.Page;
import application.web.pages.Not_found_page;
import specification.enumeration.Environment;

/**
 * @author MehmetAkif-PC
 *
 */
public class Accesscontrol_page extends Page{
	private String requestURI;// loglanmasý gerekiyor.

	private String sayfalar;
	
	private String requestler;

	private String subrequestURI;
	
	public Accesscontrol_page(String target) {
		super(target);
		this.requestURI = "";
		this.sayfalar = "<a href=\"http://localhost:8080/home\">Anasayfa</a>\r\n<br>"
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
		this.requestler = "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/CreateAccessPoint\">CreateAccessPoint</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/CreateArea\">CreateArea</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/DeleteAccessPoint\">DeleteAccessPoint</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/DeleteAccessPointAuthenticationProfile\">DeleteAccessPointAuthenticationProfile</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/DeleteArea\">DeleteArea</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/DisableAccessPoint\">DisableAccessPoint</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/EnableAccessPoint\">EnableAccessPoint</a>\r\n"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/ExternalAuthorization\">ExternalAuthorization</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/GetAccessPointInfo\">GetAccessPointInfo</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/GetAccessPointInfoList\">GetAccessPointInfoList</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/GetAccessPointList\">GetAccessPointList</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/GetAccessPoints\">GetAccessPoints</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/GetAccessPointState\">GetAccessPointState</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/GetAreaInfo\">GetAreaInfo</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/GetAreaInfoList\">GetAreaInfoList</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/GetAreaList\">GetAreaList</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/GetAreas\">GetAreas</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/GetServiceCapabilities\">GetServiceCapabilities</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/ModifyAccessPoint\">ModifyAccessPoint</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/ModifyArea\">ModifyArea</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/SetAccessPoint\">SetAccessPoint</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/SetAccessPointAuthenticationProfile\">SetAccessPointAuthenticationProfile</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/accesscontrol/PACSBinding/SetArea\">SetArea</a>\r\n<br>";
		subrequestURI = "";
	}

	public void load(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Accesscontrol_page loading");
		/* request uri starts with Environment.accesscontrol_page.getURI() */
		if (target != null) {
			if (target.equals("")) {
				/* request uri equals Environment.accesscontrol_page.getURI() */
				response.setContentType("text/html;charset=utf-8");
				try {
					response.getWriter().println(requestler);
				} catch (IOException e) {
					response.setStatus(HttpServletResponse.SC_OK);
					baseRequest.setHandled(true);
					e.printStackTrace();
					return;
				}
				response.setStatus(HttpServletResponse.SC_OK);
				baseRequest.setHandled(true);
				return;
			} else {
				if (target.startsWith(Environment.pacsbinding_page.getURI())) {
					load_PACSBinding_page(target, baseRequest, request, response);
				} else {
					/* there is no other binding in devicemanagement */
					load_not_found_page(target, baseRequest, request, response);
				}
			}
		} else {
			System.out.println("target null");
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}
	


	@SuppressWarnings("unused")
	private void load_PACSBinding_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		PACSBinding_page pacsbinding_page = null;
		pacsbinding_page = new PACSBinding_page(target);
		if (pacsbinding_page != null) {
			pacsbinding_page.load(target, baseRequest, request, response);
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	/**
	 * @param target
	 * @param baseRequest
	 * @param request
	 * @param response
	 * @param requestURI
	 */
	@SuppressWarnings("unused")
	private void load_not_found_page(String target, Request baseRequest, HttpServletRequest request,
			final HttpServletResponse response) {
		System.out.println("requestURI:" + request.getRequestURI());
		Not_found_page not_found_page = null;
		not_found_page = new Not_found_page(target);
		if (not_found_page != null) {
			not_found_page.load(target, baseRequest, request, response);
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}
	
	/**
	 * @return the requestler
	 */
	public String getRequestler() {
		return requestler;
	}

	/**
	 * @param requestler the requestler to set
	 */
	public void setRequestler(String requestler) {
		this.requestler = requestler;
	}

	/**
	 * @return the requestURI
	 */
	public String getRequestURI() {
		return requestURI;
	}

	/**
	 * @param requestURI the requestURI to set
	 */
	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}

	/**
	 * @return the sayfalar
	 */
	public String getSayfalar() {
		return sayfalar;
	}

	/**
	 * @param sayfalar the sayfalar to set
	 */
	public void setSayfalar(String sayfalar) {
		this.sayfalar = sayfalar;
	}

	/**
	 * @return the subrequestURI
	 */
	public String getSubrequestURI() {
		return subrequestURI;
	}

	/**
	 * @param subrequestURI the subrequestURI to set
	 */
	public void setSubrequestURI(String subrequestURI) {
		this.subrequestURI = subrequestURI;
	}

}
