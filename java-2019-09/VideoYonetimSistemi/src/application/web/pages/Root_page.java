package application.web.pages;

import application.web.Page;

public class Root_page extends Page {
	private String requestURI = null;// loglanmasý gerekiyor.
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

	public Root_page(String string) {
		super(string);
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

}
