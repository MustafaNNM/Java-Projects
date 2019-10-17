/**
 * 
 */
package specification.advancedsecurity;

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
public class Advancedsecurity_page extends Page{
	private String requestURI;// loglanmasý gerekiyor.

	private String sayfalar;
	
	private String requestler;
	
	private String subrequestURI;

	public Advancedsecurity_page(String target) {
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
		requestler = "<a href=\"http://localhost:8080/advancedsecurity/AdvancedSecurityServiceBinding/GetServiceCapabilities\">GetServiceCapabilities</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/Dot1XBinding/AddDot1XConfiguration\">AddDot1XConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/Dot1XBinding/DeleteDot1XConfiguration\">DeleteDot1XConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/Dot1XBinding/DeleteNetworkInterfaceDot1XConfiguration\">DeleteNetworkInterfaceDot1XConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/Dot1XBinding/GetAllDot1XConfigurations\">GetAllDot1XConfigurations</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/Dot1XBinding/GetDot1XConfiguration\">GetDot1XConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/Dot1XBinding/GetNetworkInterfaceDot1XConfiguration\">GetNetworkInterfaceDot1XConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/Dot1XBinding/SetNetworkInterfaceDot1XConfiguration\">SetNetworkInterfaceDot1XConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/CreateCertificationPath\">CreateCertificationPath</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/CreateCertPathValidationPolicy\">CreateCertPathValidationPolicy</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/CreatePKCS10CSR\">CreatePKCS10CSR</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/CreateRSAKeyPair\">CreateRSAKeyPair</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/CreateSelfSignedCertificate\">CreateSelfSignedCertificate</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/DeleteCertificate\">DeleteCertificate</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/DeleteCertificationPath\">DeleteCertificationPath</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/DeleteCertPathValidationPolicy\">DeleteCertPathValidationPolicy</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/DeleteCRL\">DeleteCRL</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/DeleteKey\">DeleteKey</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/DeletePassphrase\">DeletePassphrase</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/GetAllCertificates\">GetAllCertificates</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/GetAllCertificationPaths\">GetAllCertificationPaths</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/GetAllCertPathValidationPolicies\">GetAllCertPathValidationPolicies</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/GetAllCRLs\">GetAllCRLs</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/GetAllKeys\">GetAllKeys</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/GetAllPassphrases\">GetAllPassphrases</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/GetCertificate\">GetCertificate</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/GetCertificationPath\">GetCertificationPath</a>\r\nv"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/GetCertPathValidationPolicy\">GetCertPathValidationPolicy</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/GetCRL\">GetCRL</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/GetKeyStatus\">GetKeyStatus</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/GetPrivateKeyStatus\">GetPrivateKeyStatus</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/UploadCertificate\">UploadCertificate</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/UploadCertificateWithPrivateKeyInPKCS12\">UploadCertificateWithPrivateKeyInPKCS12</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/UploadCRL\">UploadCRL</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/UploadKeyPairInPKCS8\">UploadKeyPairInPKCS8</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/UploadPassphrase\">UploadPassphrase</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/TLSServerBinding/AddCertPathValidationPolicyAssignment\">AddCertPathValidationPolicyAssignment</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/TLSServerBinding/AddServerCertificateAssignment\">AddServerCertificateAssignment</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/TLSServerBinding/GetAssignedCertPathValidationPolicies\">GetAssignedCertPathValidationPolicies</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/TLSServerBinding/GetAssignedServerCertificates\">GetAssignedServerCertificates</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/TLSServerBinding/GetClientAuthenticationRequired\">GetClientAuthenticationRequired</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/TLSServerBinding/RemoveCertPathValidationPolicyAssignment\">RemoveCertPathValidationPolicyAssignment</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/TLSServerBinding/RemoveServerCertificateAssignment\">RemoveServerCertificateAssignment</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/TLSServerBinding/ReplaceCertPathValidationPolicyAssignment\">ReplaceCertPathValidationPolicyAssignment</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/TLSServerBinding/ReplaceServerCertificateAssignment\">ReplaceServerCertificateAssignment</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/advancedsecurity/TLSServerBinding/SetClientAuthenticationRequired\">SetClientAuthenticationRequired</a>\r\n<br>";
		subrequestURI="";
	}

	public void load(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Advancedsecurity_page loading");
		/* request uri starts with Environment.advancedsecurityservicebinding_page.getURI() */
		if (target != null) {
			if (target.equals("")) {
				/* request uri equals Environment.advancedsecurityservicebinding_page.getURI() */
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
				if (target.startsWith(Environment.advancedsecurityservicebinding_page.getURI())) {
					load_AdvancedSecurityServiceBinding_page(target, baseRequest, request, response);
				} else {
					if (target.startsWith(Environment.dot1xbinding_page.getURI())) {
						load_Dot1XBinding_page(target, baseRequest, request, response);
					} else {
						if (target.startsWith(Environment.keystorebinding_page.getURI())) {
							load_KeystoreBinding_page(target, baseRequest, request, response);
						} else {
							if (target.startsWith(Environment.tlsserverbinding_page.getURI())) {
								load_TLSServerBinding_page(target, baseRequest, request, response);
							} else {
								/* there is no other binding in advancedsecurityservice */
								load_not_found_page(target, baseRequest, request, response);
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

	@SuppressWarnings("unused")
	private void load_TLSServerBinding_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		TLSServerBinding_page tlsserverbinding_page = null;
		tlsserverbinding_page = new TLSServerBinding_page(target);
		if (tlsserverbinding_page != null) {
			tlsserverbinding_page.load(target, baseRequest, request, response);
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_KeystoreBinding_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		KeystoreBinding_page keystorebinding_page = null;
		keystorebinding_page= new KeystoreBinding_page(target);
		if (keystorebinding_page != null) {
			keystorebinding_page.load(target, baseRequest, request, response);
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_Dot1XBinding_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Dot1XBinding_page dot1xbinding_page = null;
		dot1xbinding_page = new Dot1XBinding_page(target);
		if (dot1xbinding_page != null) {
			dot1xbinding_page.load(target, baseRequest, request, response);
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_AdvancedSecurityServiceBinding_page(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response) {
		AdvancedSecurityServiceBinding_page advancedsecurityservicebinding_page = null;
		advancedsecurityservicebinding_page = new AdvancedSecurityServiceBinding_page(target);
		if (advancedsecurityservicebinding_page != null) {
			advancedsecurityservicebinding_page.load(target, baseRequest, request, response);
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
