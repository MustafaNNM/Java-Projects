/**
 * 
 */
package specification.authenticationbehavior;

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
public class Authenticationbehavior_page extends Page{
	private String requestURI;// loglanmasý gerekiyor.

	private String sayfalar;
	
	private String requestler;

	public Authenticationbehavior_page(String string) {
		super(string);
		requestURI = "";
		sayfalar = "<a href=\"http://localhost:8080/home\">Anasayfa</a>\r\n<br>"
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
		requestler = "<a href=\"http://localhost:8080/authenticationbehavior/AuthenticationBehaviorBinding/CreateAuthenticationProfile\">CreateAuthenticationProfile</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/authenticationbehavior/AuthenticationBehaviorBinding/CreateSecurityLevel\">CreateSecurityLevel</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/authenticationbehavior/AuthenticationBehaviorBinding/DeleteAuthenticationProfile\">DeleteAuthenticationProfile</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/authenticationbehavior/AuthenticationBehaviorBinding/DeleteSecurityLevel\">DeleteSecurityLevel</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/authenticationbehavior/AuthenticationBehaviorBinding/GetAuthenticationProfileInfo\">GetAuthenticationProfileInfo</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/authenticationbehavior/AuthenticationBehaviorBinding/GetAuthenticationProfileInfoList\">GetAuthenticationProfileInfoList</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/authenticationbehavior/AuthenticationBehaviorBinding/GetAuthenticationProfileList\">GetAuthenticationProfileList</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/authenticationbehavior/AuthenticationBehaviorBinding/GetAuthenticationProfiles\">GetAuthenticationProfiles</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/authenticationbehavior/AuthenticationBehaviorBinding/GetSecurityLevelInfo\">GetSecurityLevelInfo</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/authenticationbehavior/AuthenticationBehaviorBinding/GetSecurityLevelInfoList\">GetSecurityLevelInfoList</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/authenticationbehavior/AuthenticationBehaviorBinding/GetSecurityLevelList\">GetSecurityLevelList</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/authenticationbehavior/AuthenticationBehaviorBinding/GetSecurityLevels\">GetSecurityLevels</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/authenticationbehavior/AuthenticationBehaviorBinding/GetServiceCapabilities\">GetServiceCapabilities</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/authenticationbehavior/AuthenticationBehaviorBinding/ModifyAuthenticationProfile\">ModifyAuthenticationProfile</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/authenticationbehavior/AuthenticationBehaviorBinding/ModifySecurityLevel\">ModifySecurityLevel</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/authenticationbehavior/AuthenticationBehaviorBinding/SetAuthenticationProfile\">SetAuthenticationProfile</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/authenticationbehavior/AuthenticationBehaviorBinding/SetSecurityLevel\">SetSecurityLevel</a>\r\n<br>";
	}

	public void load(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Authenticationbehavior_page loading");
		/* request uri starts with Environment.authenticationbehavior_page.getURI() */
		if (target != null) {
			if (target.equals("")) {
				/* request uri equals Environment.authenticationbehavior_page.getURI() */
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
				if (target.startsWith(Environment.authenticationbehaviorbinding_page.getURI())) {
					load_AuthenticationBehaviorBinding_page(target, baseRequest, request, response);
				} else {
					/* there is no other binding in authenticationbehavior */
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
	
	private void load_AuthenticationBehaviorBinding_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
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

	public String getRequestURI() {
		return requestURI;
	}

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

}
