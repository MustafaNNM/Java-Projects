/**
 * 
 */
package specification.event;

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
public class Event_page extends Page{
	private String requestURI;// loglanmasý gerekiyor.

	private String sayfalar;
	
	private String requestler;

	public Event_page(String string) {
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
		 requestler = "<a href=\"http://localhost:8080/event/CreatePullPointBinding/CreatePullPoint\">CreatePullPoint</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/EventBinding/CreatePullPointSubscription\">CreatePullPointSubscription</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/EventBinding/GetEventProperties\">GetEventProperties</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/EventBinding/GetServiceCapabilities\">GetServiceCapabilities</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/NotificationConsumerBinding/Notify\">Notify</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/NotificationProducerBinding/GetCurrentMessage\">GetCurrentMessage</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/NotificationProducerBinding/Subscribe\">Subscribe</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/PausableSubscriptionManagerBinding/PauseSubscription\">PauseSubscription</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/PausableSubscriptionManagerBinding/Renew\">Renew</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/PausableSubscriptionManagerBinding/ResumeSubscription\">ResumeSubscription</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/PausableSubscriptionManagerBinding/Unsubscribe\">Unsubscribe</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/PullPointBinding/DestroyPullPoint\">DestroyPullPoint</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/PullPointBinding/GetMessages\">GetMessages</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/PullPointBinding/Notify\">Notify</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/PullPointSubscriptionBinding/PullMessages\">PullMessages</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/PullPointSubscriptionBinding/Seek\">Seek</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/PullPointSubscriptionBinding/SetSynchronizationPoint\">SetSynchronizationPoint</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/PullPointSubscriptionBinding/Unsubscribe\">Unsubscribe</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/SubscriptionManagerBinding/Renew\">Renew</a>\r\n<br>"
					+ "<a href=\"http://localhost:8080/event/SubscriptionManagerBinding/Unsubscribe\">Unsubscribe</a>\r\n<br>";
	}

	public void load(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Event_page loading");
		/* request uri starts with Environment.event_page.getURI() */
		if (target != null) {
			if (target.equals("")) {
				/* request uri equals Environment.event_page.getURI() */
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
				if (target.startsWith(Environment.createpullpointbinding_page.getURI())) {
					load_CreatePullPointBinding_page(target, baseRequest, request, response);
				} else {
					if (target.startsWith(Environment.eventbinding_page.getURI())) {
						load_EventBinding_page(target, baseRequest, request, response);
					} else {
						if (target.startsWith(Environment.notificationconsumerbinding_page.getURI())) {
							load_NotificationConsumerBinding_page(target, baseRequest, request, response);
						} else {
							if (target.startsWith(Environment.notificationproducerbinding_page.getURI())) {
								load_NotificationProducerBinding_page(target, baseRequest, request, response);
							} else {
								if (target.startsWith(Environment.pausablesubscriptionmanagerbinding_page.getURI())) {
									load_PausableSubscriptionManagerBinding_page(target, baseRequest, request, response);
								} else {
									if (target.startsWith(Environment.pullpointbinding_page.getURI())) {
										load_PullPointBinding_page(target, baseRequest, request, response);
									} else {
										if (target.startsWith(Environment.pullpointsubscriptionbinding_page.getURI())) {
											load_PullPointSubscriptionBinding_page(target, baseRequest, request, response);
										} else {
											if (target.startsWith(Environment.subscriptionmanagerbinding_page.getURI())) {
												load_SubscriptionManagerBinding_page(target, baseRequest, request, response);
											} else {
												/* there is no other binding in event */
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
		} else {
			System.out.println("target null");
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	
	private void load_SubscriptionManagerBinding_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void load_PullPointSubscriptionBinding_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void load_PullPointBinding_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void load_PausableSubscriptionManagerBinding_page(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void load_NotificationProducerBinding_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void load_NotificationConsumerBinding_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void load_EventBinding_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void load_CreatePullPointBinding_page(String target, Request baseRequest, HttpServletRequest request,
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

}
