/**
 * 
 */
package specification.devicemanagement;

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
public class Devicemanagement_page extends Page {
	private String requestURI = null;// loglanmasý gerekiyor.
	
	private String sayfalar;

	private String requestler;
	
	private String subrequestURI = "";

	public Devicemanagement_page(String target) {
		super(target);
		requestURI="";
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
		requestler = "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/AddIPAddressFilter\">AddIPAddressFilter</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/AddScopes\">AddScopes</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/CreateCertificate\">CreateCertificate</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/CreateDot1XConfiguration\">CreateDot1XConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/CreateStorageConfiguration\">CreateStorageConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/CreateUsers\">CreateUsers</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/DeleteCertificates\">DeleteCertificates</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/DeleteDot1XConfiguration\">DeleteDot1XConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/DeleteGeoLocation\">DeleteGeoLocation</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/DeleteStorageConfiguration\">DeleteStorageConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/DeleteUsers\">DeleteUsers</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetAccessPolicy\">GetAccessPolicy</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetCACertificates\">GetCACertificates</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetCapabilities\">GetCapabilities</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetCertificateInformation\">GetCertificateInformation</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetCertificates\">GetCertificates</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetCertificatesStatus\">GetCertificatesStatus</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetClientCertificateMode\">GetClientCertificateMode</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetDeviceInformation\">GetDeviceInformation</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetDiscoveryMode\">GetDiscoveryMode</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetDNS\">GetDNS</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetDot11Capabilities\">GetDot11Capabilities</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetDot11Status\">GetDot11Status</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetDot1XConfiguration\">GetDot1XConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetDot1XConfigurations\">GetDot1XConfigurations</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetDPAddresses\">GetDPAddresses</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetDynamicDNS\">GetDynamicDNS</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetEndpointReference\">GetEndpointReference</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetGeoLocation\">GetGeoLocation</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetHostname\">GetHostname</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetIPAddressFilter\">GetIPAddressFilter</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetNetworkDefaultGateway\">GetNetworkDefaultGateway</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetNetworkInterfaces\">GetNetworkInterfaces</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetNetworkProtocols\">GetNetworkProtocols</a>\r\nv"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetNTP\">GetNTP</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetPkcs10Request\">GetPkcs10Request</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetRelayOutputs\">GetRelayOutputs</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetRemoteDiscoveryMode\">GetRemoteDiscoveryMode</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetRemoteUser\">GetRemoteUser</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetScopes\">GetScopes</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetServiceCapabilities\">GetServiceCapabilities</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetServices\">GetServices</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetStorageConfiguration\">GetStorageConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetStorageConfigurations\">GetStorageConfigurations</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetSystemBackup\">GetSystemBackup</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetSystemDateAndTime\">GetSystemDateAndTime</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetSystemLog\">GetSystemLog</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetSystemSupportInformation\">GetSystemSupportInformation</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetSystemUris\">GetSystemUris</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetUsers\">GetUsers</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetWsdlUrl\">GetWsdlUrl</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/GetZeroConfiguration\">GetZeroConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/LoadCACertificates\">LoadCACertificates</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/LoadCertificates\">LoadCertificates</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/LoadCertificateWithPrivateKey\">LoadCertificateWithPrivateKey</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/RemoveIPAddressFilter\">RemoveIPAddressFilter</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/RemoveScopes\">RemoveScopes</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/RestoreSystem\">RestoreSystem</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/ScanAvailableDot11Networks\">ScanAvailableDot11Networks</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SendAuxiliaryCommand\">SendAuxiliaryCommand</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetAccessPolicy\">SetAccessPolicy</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetCertificatesStatus\">SetCertificatesStatus</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetClientCertificateMode\">SetClientCertificateMode</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetDiscoveryMode\">SetDiscoveryMode</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetDNS\">SetDNS</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetDot1XConfiguration\">SetDot1XConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetDPAddresses\">SetDPAddresses</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetDynamicDNS\">SetDynamicDNS</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetGeoLocation\">SetGeoLocation</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetHostname\">SetHostname</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetHostnameFromDHCP\">SetHostnameFromDHCP</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetIPAddressFilter\">SetIPAddressFilter</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetNetworkDefaultGateway\">SetNetworkDefaultGateway</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetNetworkInterfaces\">SetNetworkInterfaces</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetNetworkProtocols\">SetNetworkProtocols</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetNTP\">SetNTP</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetRelayOutputSettings\">SetRelayOutputSettings</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetRelayOutputState\">SetRelayOutputState</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetRemoteDiscoveryMode\">SetRemoteDiscoveryMode</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetRemoteUser\">SetRemoteUser</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetScopes\">SetScopes</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetStorageConfiguration\">SetStorageConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetSystemDateAndTime\">SetSystemDateAndTime</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetSystemFactoryDefault\">SetSystemFactoryDefault</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetUser\">SetUser</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SetZeroConfiguration\">SetZeroConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/StartFirmwareUpgrade\">StartFirmwareUpgrade</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/StartSystemRestore\">StartSystemRestore</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/SystemReboot\">SystemReboot</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/devicemanagement/DeviceBinding/UpgradeSystemFirmware\">UpgradeSystemFirmware</a>\r\n<br>";
		subrequestURI = "";
	}

	public void load(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Devicemanagement_page loading");
		/* request uri starts with Environment.devicemanagement_page.getURI() */
		if (target != null) {
			if (target.equals("")) {
				/* request uri equals Environment.devicemanagement_page.getURI() */
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
	private void load_DeviceBinding_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		DeviceBinding_page devicebinding_page = null;
		devicebinding_page = new DeviceBinding_page(target);
		if (devicebinding_page != null) {
			devicebinding_page.load(target, baseRequest, request, response);
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
