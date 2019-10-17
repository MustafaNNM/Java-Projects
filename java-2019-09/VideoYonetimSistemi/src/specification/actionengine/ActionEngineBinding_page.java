package specification.actionengine;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

import application.web.Page;
import application.web.pages.Not_found_page;
import specification.enumeration.Environment;

public class ActionEngineBinding_page extends Page {
	private String requestURI;// loglanması gerekiyor.

	private String sayfalar;

	private String requestler;

	private String subrequestURI;

	public ActionEngineBinding_page(String target) {
		super(target);
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
		requestler = "<a href=\"http://localhost:8080/actionengine/ActionEngineBinding/CreateActions\">CreateActions</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/actionengine/ActionEngineBinding/CreateActionTriggers\">CreateActionTriggers</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/actionengine/ActionEngineBinding/DeleteActions\">DeleteActions</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/actionengine/ActionEngineBinding/DeleteActionTriggers\">DeleteActionTriggers</a>\r\nv"
				+ "<a href=\"http://localhost:8080/actionengine/ActionEngineBinding/GetActions\">GetActions</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/actionengine/ActionEngineBinding/GetActionTriggers\">GetActionTriggers</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/actionengine/ActionEngineBinding/GetServiceCapabilities\">GetServiceCapabilities</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/actionengine/ActionEngineBinding/GetSupportedActions\">GetSupportedActions</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/actionengine/ActionEngineBinding/ModifyActions\">ModifyActions</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/actionengine/ActionEngineBinding/ModifyActionTriggers\">ModifyActionTriggers</a>\r\n<br>";
		subrequestURI = "";
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

	public void load(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ActionEngineBinding loading");
		/* request uri starts with Environment.actionenginebinding_page.getURI() */
		if (target != null) {
			if (target.equals(Environment.actionenginebinding_page.getURI())) {
				/* request uri equals Environment.actionenginebinding_page.getURI() */
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
				load_operations(target, baseRequest, request, response);
			}
		} else {
			System.out.println("Target null");
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	private void load_operations(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		target = target.substring(Environment.actionenginebinding_page.getSize());
		if (target.equals("/CreateActions")) {
			ActionEngineBinding.CreateActions(target, baseRequest, request, response);
		} else {
			if (target.equals("/CreateActionTriggers")) {
				ActionEngineBinding.CreateActionTriggers(target, baseRequest, request, response);
			} else {
				if (target.equals("/DeleteActions")) {
					ActionEngineBinding.DeleteActions(target, baseRequest, request, response);
				} else {
					if (target.equals("/DeleteActionTriggers")) {
						ActionEngineBinding.DeleteActionTriggers(target, baseRequest, request, response);
					} else {
						if (target.equals("/GetActions")) {
							ActionEngineBinding.CreateStorageConfiguration(target, baseRequest, request, response);
						} else {
							if (target.equals("/GetActionTriggers")) {
								ActionEngineBinding.GetActionTriggers(target, baseRequest, request, response);
							} else {
								if (target.equals("/GetServiceCapabilities")) {
									ActionEngineBinding.GetServiceCapabilities(target, baseRequest, request, response);
								} else {
									if (target.equals("/GetSupportedActions")) {
										ActionEngineBinding.GetSupportedActions(target, baseRequest, request, response);
									} else {
										if (target.equals("/ModifyActions")) {
											ActionEngineBinding.ModifyActions(target, baseRequest, request, response);
										} else {
											if (target.equals("/ModifyActionTriggers")) {
												ActionEngineBinding.ModifyActionTriggers(target, baseRequest, request,
														response);
											} else {
												load_not_found_page(target, baseRequest, request, response);
											}
										}
									}
								}
							}
						}
					}
				}
			}
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
		requestURI_toString(request);
		Not_found_page not_found_page = null;
		not_found_page = new Not_found_page(target);
		if (not_found_page != null) {
			not_found_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}
}
