/**
 * 
 */
package specification.deviceio;

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
public class Deviceio_page extends Page {
	private String requestURI;// loglanmasý gerekiyor.

	private String sayfalar;

	private String requestler;

	private String subrequestURI;

	public Deviceio_page(String string) {
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
		requestler = "<a href=\"http://localhost:8080/deviceio/DeviceBinding/AddIPAddressFilter\">AddIPAddressFilter</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/AddScopes\">AddScopes</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/CreateCertificate\">CreateCertificate</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/CreateDot1XConfiguration\">CreateDot1XConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/CreateStorageConfiguration\">CreateStorageConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/CreateUsers\">CreateUsers</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/DeleteCertificates\">DeleteCertificates</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/DeleteDot1XConfiguration\">DeleteDot1XConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/DeleteGeoLocation\">DeleteGeoLocation</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/DeleteStorageConfiguration\">DeleteStorageConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/DeleteUsers\">DeleteUsers</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetAccessPolicy\">GetAccessPolicy</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetCACertificates\">GetCACertificates</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetCapabilities\">GetCapabilities</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetCertificateInformation\">GetCertificateInformation</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetCertificates\">GetCertificates</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetCertificatesStatus\">GetCertificatesStatus</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetClientCertificateMode\">GetClientCertificateMode</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetDeviceInformation\">GetDeviceInformation</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetDiscoveryMode\">GetDiscoveryMode</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetDNS\">GetDNS</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetDot11Capabilities\">GetDot11Capabilities</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetDot11Status\">GetDot11Status</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetDot1XConfiguration\">GetDot1XConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetDot1XConfigurations\">GetDot1XConfigurations</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetDPAddresses\">GetDPAddresses</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetDynamicDNS\">GetDynamicDNS</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetEndpointReference\">GetEndpointReference</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetGeoLocation\">GetGeoLocation</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetHostname\">GetHostname</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetIPAddressFilter\">GetIPAddressFilter</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetNetworkDefaultGateway\">GetNetworkDefaultGateway</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetNetworkInterfaces\">GetNetworkInterfaces</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetNetworkProtocols\">GetNetworkProtocols</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetNTP\">GetNTP</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetPkcs10Request\">GetPkcs10Request</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetRelayOutputs\">GetRelayOutputs</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetRemoteDiscoveryMode\">GetRemoteDiscoveryMode</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetRemoteUser\">GetRemoteUser</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetScopes\">GetScopes</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetServiceCapabilities\">GetServiceCapabilities</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetServices\">GetServices</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetStorageConfiguration\">GetStorageConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetStorageConfigurations\">GetStorageConfigurations</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetSystemBackup\">GetSystemBackup</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetSystemDateAndTime\">GetSystemDateAndTime</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetSystemLog\">GetSystemLog</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetSystemSupportInformation\">GetSystemSupportInformation</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetSystemUris\">GetSystemUris</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetUsers\">GetUsers</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetWsdlUrl\">GetWsdlUrl</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/GetZeroConfiguration\">GetZeroConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/LoadCACertificates\">LoadCACertificates</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/LoadCertificates\">LoadCertificates</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/LoadCertificateWithPrivateKey\">LoadCertificateWithPrivateKey</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/RemoveIPAddressFilter\">RemoveIPAddressFilter</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/RemoveScopes\">RemoveScopes</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/RestoreSystem\">RestoreSystem</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/ScanAvailableDot11Networks\">ScanAvailableDot11Networks</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SendAuxiliaryCommand\">SendAuxiliaryCommand</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetAccessPolicy\">SetAccessPolicy</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetCertificatesStatus\">SetCertificatesStatus</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetClientCertificateMode\">SetClientCertificateMode</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetDiscoveryMode\">SetDiscoveryMode</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetDNS\">SetDNS</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetDot1XConfiguration\">SetDot1XConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetDPAddresses\">SetDPAddresses</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetDynamicDNS\">SetDynamicDNS</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetGeoLocation\">SetGeoLocation</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetHostname\">SetHostname</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetHostnameFromDHCP\">SetHostnameFromDHCP</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetIPAddressFilter\">SetIPAddressFilter</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetNetworkDefaultGateway\">SetNetworkDefaultGateway</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetNetworkInterfaces\">SetNetworkInterfaces</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetNetworkProtocols\">SetNetworkProtocols</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetNTP\">SetNTP</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetRelayOutputSettings\">SetRelayOutputSettings</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetRelayOutputState\">SetRelayOutputState</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetRemoteDiscoveryMode\">SetRemoteDiscoveryMode</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetRemoteUser\">SetRemoteUser</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetScopes\">SetScopes</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetStorageConfiguration\">SetStorageConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetSystemDateAndTime\">SetSystemDateAndTime</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetSystemFactoryDefault\">SetSystemFactoryDefault</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetUser\">SetUser</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SetZeroConfiguration\">SetZeroConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/StartFirmwareUpgrade\">StartFirmwareUpgrade</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/StartSystemRestore\">StartSystemRestore</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/SystemReboot\">SystemReboot</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/UpgradeSystemFirmware\">UpgradeSystemFirmware</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/deviceio/DeviceIOBinding/GetAudioOutputConfiguration\">GetAudioOutputConfiguration</a>\r\n"
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
		subrequestURI = "";
	}

	public void load(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Deviceio_page loading");
		/* request uri starts with Environment.deviceio_page.getURI() */
		if (target != null) {
			if (target.equals("")) {
				/* request uri equals Environment.deviceio_page.getURI() */
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
				if (target.startsWith(Environment.devicebinding_page.getURI())) {
					load_DeviceBinding_page(target, baseRequest, request, response);
				} else {
					if (target.startsWith(Environment.deviceiobinding_page.getURI())) {
						load_DeviceIOBinding_page(target, baseRequest, request, response);
					} else {
						/* there is no other binding in deviceio */
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

	@SuppressWarnings("unused")
	private void load_DeviceIOBinding_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		DeviceIOBinding_page deviceiobinding_page = null;
		deviceiobinding_page = new DeviceIOBinding_page(target);
		if (deviceiobinding_page != null) {
			deviceiobinding_page.load(target, baseRequest, request, response);
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
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_DeviceBinding_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		DeviceBinding_page devicebinding_page = null;
		devicebinding_page = new DeviceBinding_page(target);
		if (devicebinding_page != null) {
			devicebinding_page.load(target, baseRequest, request, response);
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
