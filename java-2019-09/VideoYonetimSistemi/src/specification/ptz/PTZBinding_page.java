package specification.ptz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

import application.web.Page;
import application.web.pages.Not_found_page;

public class PTZBinding_page extends Page{
	private String subrequestURI;
	private String requestURI;// loglanması gerekiyor.
	private String sayfalar;
	private String requestler;
	
	public PTZBinding_page(String string) {
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
		requestler = "<a href=\"http://localhost:8080/ptz/PTZBinding/AbsoluteMove\">AbsoluteMove</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/ContinuousMove\">ContinuousMove</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/CreatePresetTour\">CreatePresetTour</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/GeoMove\">GeoMove</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/GetCompatibleConfigurations\">GetCompatibleConfigurations</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/GetConfiguration\">GetConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/GetConfigurationOptions\">GetConfigurationOptions</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/GetConfigurations\">GetConfigurations</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/GetNode\">GetNode</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/GetNodes\">GetNodes</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/GetPresets\">GetPresets</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/GetPresetTour\">GetPresetTour</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/GetPresetTourOptions\">GetPresetTourOptions</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/GetPresetTours\">GetPresetTours</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/GetServiceCapabilities\">GetServiceCapabilities</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/GetStatus\">GetStatus</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/GotoHomePosition\">GotoHomePosition</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/GotoPreset\">GotoPreset</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/ModifyPresetTour\">ModifyPresetTour</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/OperatePresetTour\">OperatePresetTour</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/RelativeMove\">RelativeMove</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/RemovePreset\">RemovePreset</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/RemovePresetTour\">RemovePresetTour</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/SendAuxiliaryCommand\">SendAuxiliaryCommand</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/SetConfiguration\">SetConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/SetHomePosition\">SetHomePosition</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/SetPreset\">SetPreset</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/ptz/PTZBinding/Stop\">Stop</a>\r\n<br>";
		subrequestURI = "";
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
