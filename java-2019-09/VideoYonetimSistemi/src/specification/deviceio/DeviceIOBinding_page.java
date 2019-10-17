package specification.deviceio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

import application.web.Page;
import application.web.pages.Not_found_page;

public class DeviceIOBinding_page extends Page {
	private String subrequestURI;
	private String requestURI;// loglanmasý gerekiyor.
	private String sayfalar;

	private String requestler;

	public DeviceIOBinding_page(String string) {
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
		requestler = "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetAudioOutputConfiguration\">GetAudioOutputConfiguration</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetAudioOutputConfigurationOptions\">GetAudioOutputConfigurationOptions</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetAudioOutputs\">GetAudioOutputs</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetAudioSourceConfiguration\">GetAudioSourceConfiguration</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetAudioSourceConfigurationOptions\">GetAudioSourceConfigurationOptions</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetAudioSources\">GetAudioSources</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetDigitalInputConfigurationOptions\">GetDigitalInputConfigurationOptions</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetDigitalInputs\">GetDigitalInputs</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetRelayOutputOptions\">GetRelayOutputOptions</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetRelayOutputs\">GetRelayOutputs</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetSerialPortConfiguration\">GetSerialPortConfiguration</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetSerialPortConfigurationOptions\">GetSerialPortConfigurationOptions</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetSerialPorts\">GetSerialPorts</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetServiceCapabilities\">GetServiceCapabilities</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetVideoOutputConfiguration\">GetVideoOutputConfiguration</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetVideoOutputConfigurationOptions\">GetVideoOutputConfigurationOptions</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetVideoOutputs\">GetVideoOutputs</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetVideoSourceConfiguration\">GetVideoSourceConfiguration</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetVideoSourceConfigurationOptions\">GetVideoSourceConfigurationOptions</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetVideoSources\">GetVideoSources</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/SendReceiveSerialCommand\">SendReceiveSerialCommand</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/SetAudioOutputConfiguration\">SetAudioOutputConfiguration</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/SetAudioSourceConfiguration\">SetAudioSourceConfiguration</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/SetDigitalInputConfigurations\">SetDigitalInputConfigurations</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/SetRelayOutputSettings\">SetRelayOutputSettings</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/SetRelayOutputState\">SetRelayOutputState</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/SetSerialPortConfiguration\">SetSerialPortConfiguration</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/SetVideoOutputConfiguration\">SetVideoOutputConfiguration</a>\r\n"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/SetVideoSourceConfiguration\">SetVideoSourceConfiguration</a>\r\n";
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

	public void load(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
