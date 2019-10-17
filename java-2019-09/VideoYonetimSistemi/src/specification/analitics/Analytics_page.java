/**
 * 
 */
package specification.analitics;

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
public class Analytics_page extends Page {
	private String requestURI = "";// loglanması gerekiyor.

	private String sayfalar;

	private String requestler;

	public Analytics_page(String string) {
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
		requestler = "<a href=\"http://localhost:8080/analytics/AnalyticsEngineBinding/CreateAnalyticsModules\">CreateAnalyticsModules</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/analytics/AnalyticsEngineBinding/DeleteAnalyticsModules\">DeleteAnalyticsModules</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/analytics/AnalyticsEngineBinding/GetAnalyticsModuleOptions\">GetAnalyticsModuleOptions</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/analytics/AnalyticsEngineBinding/GetAnalyticsModules\">GetAnalyticsModules</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/analytics/AnalyticsEngineBinding/GetServiceCapabilities\">GetServiceCapabilities</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/analytics/AnalyticsEngineBinding/GetSupportedAnalyticsModules\">GetSupportedAnalyticsModules</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/analytics/AnalyticsEngineBinding/ModifyAnalyticsModules\">ModifyAnalyticsModules</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/analytics/RuleEngineBinding/CreateRules\">CreateRules</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/analytics/RuleEngineBinding/DeleteRules\">DeleteRules</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/analytics/RuleEngineBinding/GetRuleOptions\">GetRuleOptions</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/analytics/RuleEngineBinding/GetRules\">GetRules</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/analytics/RuleEngineBinding/GetSupportedRules\">GetSupportedRules</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/analytics/RuleEngineBinding/ModifyRules\">ModifyRules</a>\r\n<br>";
	}

	public void load(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Analytics_page loading");
		/* request uri starts with Environment.analytics_page.getURI() */
		if (target != null) {
			if (target.equals("")) {
				/* request uri equals Environment.analytics_page.getURI() */
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
				if (target.startsWith(Environment.actionenginebinding_page.getURI())) {
					load_AnalyticsEngineBinding_page(target, baseRequest, request, response);
				} else {
					if (target.startsWith(Environment.ruleenginebinding_page.getURI())) {
						load_RuleEngineBinding_page(target, baseRequest, request, response);
					} else {
						/* there is no other binding in analytics */
						load_not_found_page(target, baseRequest, request, response);
					}
				}
			}
		} else {
			System.out.println("target null");
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	private void load_RuleEngineBinding_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void load_AnalyticsEngineBinding_page(String target, Request baseRequest, HttpServletRequest request,
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

}
