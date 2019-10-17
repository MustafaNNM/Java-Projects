package specification.deviceio;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

import application.web.Page;
import application.web.pages.Not_found_page;
import specification.enumeration.Environment;

public class DeviceBinding_page extends Page {
	private String subrequestURI;
	private String requestURI;// loglanmasý gerekiyor.
	private String sayfalar;

	private String requestler;

	public DeviceBinding_page(String string) {
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
				+ "<a href=\"http://localhost:8080/deviceio/DeviceBinding/UpgradeSystemFirmware\">UpgradeSystemFirmware</a>\r\n<br>";
		subrequestURI = "";
	}

	public void load(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DeviceBinding_page loading");
		/* request uri starts with Environment.devicebinding_page.getURI() */
		if (target != null) {
			if (target.equals(Environment.devicebinding_page.getURI())) {
				/* request uri equals Environment.devicebinding_page.getURI() */
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
		target = target.substring(Environment.devicebinding_page.getSize());
		if (target.equals("/AddIPAddressFilter")) {
			DeviceBinding.AddIPAddressFilter(target, baseRequest, request, response);
		} else {
			if (target.equals("/AddScopes")) {
				DeviceBinding.AddScopes(target, baseRequest, request, response);
			} else {
				if (target.equals("/CreateCertificate")) {
					DeviceBinding.CreateCertificate(target, baseRequest, request, response);
				} else {
					if (target.equals("/CreateDot1XConfiguration")) {
						DeviceBinding.CreateDot1XConfiguration(target, baseRequest, request, response);
					} else {
						if (target.equals("/CreateStorageConfiguration")) {
							DeviceBinding.CreateStorageConfiguration(target, baseRequest, request, response);
						} else {
							if (target.equals("/CreateUsers")) {
								DeviceBinding.CreateUsers(target, baseRequest, request, response);
							} else {
								if (target.equals("/DeleteCertificates")) {
									DeviceBinding.DeleteCertificates(target, baseRequest, request, response);
								} else {
									if (target.equals("/DeleteDot1XConfiguration")) {
										DeviceBinding.DeleteDot1XConfiguration(target, baseRequest, request, response);
									} else {
										if (target.equals("/DeleteGeoLocation")) {
											DeviceBinding.DeleteGeoLocation(target, baseRequest, request, response);
										} else {
											if (target.equals("/DeleteStorageConfiguration")) {
												DeviceBinding.DeleteStorageConfiguration(target, baseRequest, request,
														response);
											} else {
												if (target.equals("/DeleteUsers")) {
													DeviceBinding.DeleteUsers(target, baseRequest, request, response);
												} else {
													if (target.equals("/GetAccessPolicy")) {
														DeviceBinding.GetAccessPolicy(target, baseRequest, request,
																response);
													} else {
														if (target.equals("/GetCACertificates")) {
															DeviceBinding.GetCACertificates(target, baseRequest,
																	request, response);
														} else {
															if (target.equals("/CreateCertificate")) {
																DeviceBinding.CreateCertificate(target, baseRequest,
																		request, response);
															} else {
																if (target.equals("/GetCapabilities")) {
																	DeviceBinding.GetCapabilities(target, baseRequest,
																			request, response);
																} else {
																	if (target.equals("/GetCertificateInformation")) {
																		DeviceBinding.GetCertificateInformation(target,
																				baseRequest, request, response);
																	} else {
																		if (target.equals("/GetCertificates")) {
																			DeviceBinding.GetCertificates(target,
																					baseRequest, request, response);
																		} else {
																			if (target
																					.equals("/GetCertificatesStatus")) {
																				DeviceBinding.GetCertificatesStatus(
																						target, baseRequest, request,
																						response);
																			} else {
																				if (target.equals(
																						"/GetClientCertificateMode")) {
																					DeviceBinding
																							.GetClientCertificateMode(
																									target, baseRequest,
																									request, response);
																				} else {
																					if (target.equals(
																							"/GetDeviceInformation")) {
																						DeviceBinding
																								.GetDeviceInformation(
																										target,
																										baseRequest,
																										request,
																										response);
																					} else {
																						if (target.equals(
																								"/GetDiscoveryMode")) {
																							DeviceBinding
																									.GetDiscoveryMode(
																											target,
																											baseRequest,
																											request,
																											response);
																						} else {
																							if (target.equals(
																									"/GetDNS")) {
																								DeviceBinding.GetDNS(
																										target,
																										baseRequest,
																										request,
																										response);
																							} else {
																								if (target.equals(
																										"/GetDot11Capabilities")) {
																									DeviceBinding
																											.GetDot11Capabilities(
																													target,
																													baseRequest,
																													request,
																													response);
																								} else {
																									if (target.equals(
																											"/GetDot11Status")) {
																										DeviceBinding
																												.GetDot11Status(
																														target,
																														baseRequest,
																														request,
																														response);
																									} else {
																										if (target
																												.equals("/GetDot1XConfiguration")) {
																											DeviceBinding
																													.GetDot1XConfiguration(
																															target,
																															baseRequest,
																															request,
																															response);
																										} else {
																											if (target
																													.equals("/GetDot1XConfigurations")) {
																												DeviceBinding
																														.GetDot1XConfigurations(
																																target,
																																baseRequest,
																																request,
																																response);
																											} else {
																												if (target
																														.equals("/GetDPAddresses")) {
																													DeviceBinding
																															.GetDPAddresses(
																																	target,
																																	baseRequest,
																																	request,
																																	response);
																												} else {
																													if (target
																															.equals("/GetDynamicDNS")) {
																														DeviceBinding
																																.GetDynamicDNS(
																																		target,
																																		baseRequest,
																																		request,
																																		response);
																													} else {
																														if (target
																																.equals("/GetEndpointReference")) {
																															DeviceBinding
																																	.GetEndpointReference(
																																			target,
																																			baseRequest,
																																			request,
																																			response);
																														} else {
																															if (target
																																	.equals("/GetGeoLocation")) {
																																DeviceBinding
																																		.GetGeoLocation(
																																				target,
																																				baseRequest,
																																				request,
																																				response);
																															} else {
																																if (target
																																		.equals("/GetHostname")) {
																																	DeviceBinding
																																			.GetHostname(
																																					target,
																																					baseRequest,
																																					request,
																																					response);
																																} else {
																																	if (target
																																			.equals("/GetIPAddressFilter")) {
																																		DeviceBinding
																																				.GetIPAddressFilter(
																																						target,
																																						baseRequest,
																																						request,
																																						response);
																																	} else {
																																		if (target
																																				.equals("/GetNetworkDefaultGateway")) {
																																			DeviceBinding
																																					.GetNetworkDefaultGateway(
																																							target,
																																							baseRequest,
																																							request,
																																							response);
																																		} else {
																																			if (target
																																					.equals("/GetNetworkInterfaces")) {
																																				DeviceBinding
																																						.GetNetworkInterfaces(
																																								target,
																																								baseRequest,
																																								request,
																																								response);
																																			} else {
																																				if (target
																																						.equals("/GetNetworkProtocols")) {
																																					DeviceBinding
																																							.GetNetworkProtocols(
																																									target,
																																									baseRequest,
																																									request,
																																									response);
																																				} else {
																																					if (target
																																							.equals("/GetNTP")) {
																																						DeviceBinding
																																								.GetNTP(target,
																																										baseRequest,
																																										request,
																																										response);
																																					} else {
																																						if (target
																																								.equals("/GetPkcs10Request")) {
																																							DeviceBinding
																																									.GetPkcs10Request(
																																											target,
																																											baseRequest,
																																											request,
																																											response);
																																						} else {
																																							if (target
																																									.equals("/GetRelayOutputs")) {
																																								DeviceBinding
																																										.GetRelayOutputs(
																																												target,
																																												baseRequest,
																																												request,
																																												response);
																																							} else {
																																								if (target
																																										.equals("/GetRemoteDiscoveryMode")) {
																																									DeviceBinding
																																											.GetRemoteDiscoveryMode(
																																													target,
																																													baseRequest,
																																													request,
																																													response);
																																								} else {
																																									if (target
																																											.equals("/GetRemoteUser")) {
																																										DeviceBinding
																																												.GetRemoteUser(
																																														target,
																																														baseRequest,
																																														request,
																																														response);
																																									} else {
																																										if (target
																																												.equals("/GetScopes")) {
																																											DeviceBinding
																																													.GetScopes(
																																															target,
																																															baseRequest,
																																															request,
																																															response);
																																										} else {
																																											if (target
																																													.equals("/GetServiceCapabilities")) {
																																												DeviceBinding
																																														.GetServiceCapabilities(
																																																target,
																																																baseRequest,
																																																request,
																																																response);
																																											} else {
																																												if (target
																																														.equals("/GetServices")) {
																																													DeviceBinding
																																															.GetServices(
																																																	target,
																																																	baseRequest,
																																																	request,
																																																	response);
																																												} else {
																																													if (target
																																															.equals("/GetStorageConfiguration")) {
																																														DeviceBinding
																																																.GetStorageConfiguration(
																																																		target,
																																																		baseRequest,
																																																		request,
																																																		response);
																																													} else {
																																														if (target
																																																.equals("/GetStorageConfigurations")) {
																																															DeviceBinding
																																																	.GetStorageConfigurations(
																																																			target,
																																																			baseRequest,
																																																			request,
																																																			response);
																																														} else {
																																															if (target
																																																	.equals("/GetSystemBackup")) {
																																																DeviceBinding
																																																		.GetSystemBackup(
																																																				target,
																																																				baseRequest,
																																																				request,
																																																				response);
																																															} else {
																																																if (target
																																																		.equals("/GetSystemDateAndTime")) {
																																																	DeviceBinding
																																																			.GetSystemDateAndTime(
																																																					target,
																																																					baseRequest,
																																																					request,
																																																					response);
																																																} else {
																																																	if (target
																																																			.equals("/GetSystemLog")) {
																																																		DeviceBinding
																																																				.GetSystemLog(
																																																						target,
																																																						baseRequest,
																																																						request,
																																																						response);
																																																	} else {
																																																		if (target
																																																				.equals("/GetSystemSupportInformation")) {
																																																			DeviceBinding
																																																					.GetSystemSupportInformation(
																																																							target,
																																																							baseRequest,
																																																							request,
																																																							response);
																																																		} else {
																																																			if (target
																																																					.equals("/GetSystemUris")) {
																																																				DeviceBinding
																																																						.GetSystemUris(
																																																								target,
																																																								baseRequest,
																																																								request,
																																																								response);
																																																			} else {
																																																				if (target
																																																						.equals("/GetUsers")) {
																																																					DeviceBinding
																																																							.GetUsers(
																																																									target,
																																																									baseRequest,
																																																									request,
																																																									response);
																																																				} else {
																																																					if (target
																																																							.equals("/GetWsdlUrl")) {
																																																						DeviceBinding
																																																								.GetWsdlUrl(
																																																										target,
																																																										baseRequest,
																																																										request,
																																																										response);
																																																					} else {
																																																						if (target
																																																								.equals("/GetZeroConfiguration")) {
																																																							DeviceBinding
																																																									.GetZeroConfiguration(
																																																											target,
																																																											baseRequest,
																																																											request,
																																																											response);
																																																						} else {
																																																							if (target
																																																									.equals("/LoadCACertificates")) {
																																																								DeviceBinding
																																																										.LoadCACertificates(
																																																												target,
																																																												baseRequest,
																																																												request,
																																																												response);
																																																							} else {
																																																								if (target
																																																										.equals("/LoadCertificates")) {
																																																									DeviceBinding
																																																											.LoadCertificates(
																																																													target,
																																																													baseRequest,
																																																													request,
																																																													response);
																																																								} else {
																																																									if (target
																																																											.equals("/LoadCertificateWithPrivateKey")) {
																																																										DeviceBinding
																																																												.LoadCertificateWithPrivateKey(
																																																														target,
																																																														baseRequest,
																																																														request,
																																																														response);
																																																									} else {
																																																										if (target
																																																												.equals("/RemoveIPAddressFilter")) {
																																																											DeviceBinding
																																																													.RemoveIPAddressFilter(
																																																															target,
																																																															baseRequest,
																																																															request,
																																																															response);
																																																										} else {
																																																											if (target
																																																													.equals("/RemoveScopes")) {
																																																												DeviceBinding
																																																														.RemoveScopes(
																																																																target,
																																																																baseRequest,
																																																																request,
																																																																response);
																																																											} else {
																																																												if (target
																																																														.equals("/RestoreSystem")) {
																																																													DeviceBinding
																																																															.RestoreSystem(
																																																																	target,
																																																																	baseRequest,
																																																																	request,
																																																																	response);
																																																												} else {
																																																													if (target
																																																															.equals("/ScanAvailableDot11Networks")) {
																																																														DeviceBinding
																																																																.ScanAvailableDot11Networks(
																																																																		target,
																																																																		baseRequest,
																																																																		request,
																																																																		response);
																																																													} else {
																																																														if (target
																																																																.equals("/SendAuxiliaryCommand")) {
																																																															DeviceBinding
																																																																	.SendAuxiliaryCommand(
																																																																			target,
																																																																			baseRequest,
																																																																			request,
																																																																			response);
																																																														} else {
																																																															if (target
																																																																	.equals("/SetAccessPolicy")) {
																																																																DeviceBinding
																																																																		.SetAccessPolicy(
																																																																				target,
																																																																				baseRequest,
																																																																				request,
																																																																				response);
																																																															} else {
																																																																if (target
																																																																		.equals("/SetCertificatesStatus")) {
																																																																	DeviceBinding
																																																																			.SetCertificatesStatus(
																																																																					target,
																																																																					baseRequest,
																																																																					request,
																																																																					response);
																																																																} else {
																																																																	if (target
																																																																			.equals("/SetClientCertificateMode")) {
																																																																		DeviceBinding
																																																																				.SetClientCertificateMode(
																																																																						target,
																																																																						baseRequest,
																																																																						request,
																																																																						response);
																																																																	} else {
																																																																		if (target
																																																																				.equals("/SetDiscoveryMode")) {
																																																																			DeviceBinding
																																																																					.SetDiscoveryMode(
																																																																							target,
																																																																							baseRequest,
																																																																							request,
																																																																							response);
																																																																		} else {
																																																																			if (target
																																																																					.equals("/SetDNS")) {
																																																																				DeviceBinding
																																																																						.SetDNS(target,
																																																																								baseRequest,
																																																																								request,
																																																																								response);
																																																																			} else {
																																																																				if (target
																																																																						.equals("/SetDot1XConfiguration")) {
																																																																					DeviceBinding
																																																																							.SetDot1XConfiguration(
																																																																									target,
																																																																									baseRequest,
																																																																									request,
																																																																									response);
																																																																				} else {
																																																																					if (target
																																																																							.equals("/SetDPAddresses")) {
																																																																						DeviceBinding
																																																																								.SetDPAddresses(
																																																																										target,
																																																																										baseRequest,
																																																																										request,
																																																																										response);
																																																																					} else {
																																																																						if (target
																																																																								.equals("/SetDynamicDNS")) {
																																																																							DeviceBinding
																																																																									.SetDynamicDNS(
																																																																											target,
																																																																											baseRequest,
																																																																											request,
																																																																											response);
																																																																						} else {
																																																																							if (target
																																																																									.equals("/SetGeoLocation")) {
																																																																								DeviceBinding
																																																																										.SetGeoLocation(
																																																																												target,
																																																																												baseRequest,
																																																																												request,
																																																																												response);
																																																																							} else {
																																																																								if (target
																																																																										.equals("/SetHostname")) {
																																																																									DeviceBinding
																																																																											.SetHostname(
																																																																													target,
																																																																													baseRequest,
																																																																													request,
																																																																													response);
																																																																								} else {
																																																																									if (target
																																																																											.equals("/SetHostnameFromDHCP")) {
																																																																										DeviceBinding
																																																																												.SetHostnameFromDHCP(
																																																																														target,
																																																																														baseRequest,
																																																																														request,
																																																																														response);
																																																																									} else {
																																																																										if (target
																																																																												.equals("/SetIPAddressFilter")) {
																																																																											DeviceBinding
																																																																													.SetIPAddressFilter(
																																																																															target,
																																																																															baseRequest,
																																																																															request,
																																																																															response);
																																																																										} else {
																																																																											if (target
																																																																													.equals("/SetNetworkDefaultGateway")) {
																																																																												DeviceBinding
																																																																														.SetNetworkDefaultGateway(
																																																																																target,
																																																																																baseRequest,
																																																																																request,
																																																																																response);
																																																																											} else {
																																																																												if (target
																																																																														.equals("/SetNetworkInterfaces")) {
																																																																													DeviceBinding
																																																																															.SetNetworkInterfaces(
																																																																																	target,
																																																																																	baseRequest,
																																																																																	request,
																																																																																	response);
																																																																												} else {
																																																																													if (target
																																																																															.equals("/SetNetworkProtocols")) {
																																																																														DeviceBinding
																																																																																.SetNetworkProtocols(
																																																																																		target,
																																																																																		baseRequest,
																																																																																		request,
																																																																																		response);
																																																																													} else {
																																																																														if (target
																																																																																.equals("/SetNTP")) {
																																																																															DeviceBinding
																																																																																	.SetNTP(target,
																																																																																			baseRequest,
																																																																																			request,
																																																																																			response);
																																																																														} else {
																																																																															if (target
																																																																																	.equals("/SetRelayOutputSettings")) {
																																																																																DeviceBinding
																																																																																		.SetRelayOutputSettings(
																																																																																				target,
																																																																																				baseRequest,
																																																																																				request,
																																																																																				response);
																																																																															} else {
																																																																																if (target
																																																																																		.equals("/SetRelayOutputState")) {
																																																																																	DeviceBinding
																																																																																			.SetRelayOutputState(
																																																																																					target,
																																																																																					baseRequest,
																																																																																					request,
																																																																																					response);
																																																																																} else {
																																																																																	if (target
																																																																																			.equals("/SetRemoteDiscoveryMode")) {
																																																																																		DeviceBinding
																																																																																				.SetRemoteDiscoveryMode(
																																																																																						target,
																																																																																						baseRequest,
																																																																																						request,
																																																																																						response);
																																																																																	} else {
																																																																																		if (target
																																																																																				.equals("/SetRemoteUser")) {
																																																																																			DeviceBinding
																																																																																					.SetRemoteUser(
																																																																																							target,
																																																																																							baseRequest,
																																																																																							request,
																																																																																							response);
																																																																																		} else {
																																																																																			if (target
																																																																																					.equals("/SetScopes")) {
																																																																																				DeviceBinding
																																																																																						.SetScopes(
																																																																																								target,
																																																																																								baseRequest,
																																																																																								request,
																																																																																								response);
																																																																																			} else {
																																																																																				if (target
																																																																																						.equals("/SetStorageConfiguration")) {
																																																																																					DeviceBinding
																																																																																							.SetStorageConfiguration(
																																																																																									target,
																																																																																									baseRequest,
																																																																																									request,
																																																																																									response);
																																																																																				} else {
																																																																																					if (target
																																																																																							.equals("/SetSystemDateAndTime")) {
																																																																																						DeviceBinding
																																																																																								.SetSystemDateAndTime(
																																																																																										target,
																																																																																										baseRequest,
																																																																																										request,
																																																																																										response);
																																																																																					} else {
																																																																																						if (target
																																																																																								.equals("/SetSystemFactoryDefault")) {
																																																																																							DeviceBinding
																																																																																									.SetSystemFactoryDefault(
																																																																																											target,
																																																																																											baseRequest,
																																																																																											request,
																																																																																											response);
																																																																																						} else {
																																																																																							if (target
																																																																																									.equals("/SetUser")) {
																																																																																								DeviceBinding
																																																																																										.SetUser(
																																																																																												target,
																																																																																												baseRequest,
																																																																																												request,
																																																																																												response);
																																																																																							} else {
																																																																																								if (target
																																																																																										.equals("/SetZeroConfiguration")) {
																																																																																									DeviceBinding
																																																																																											.SetZeroConfiguration(
																																																																																													target,
																																																																																													baseRequest,
																																																																																													request,
																																																																																													response);
																																																																																								} else {
																																																																																									if (target
																																																																																											.equals("/StartFirmwareUpgrade")) {
																																																																																										DeviceBinding
																																																																																												.StartFirmwareUpgrade(
																																																																																														target,
																																																																																														baseRequest,
																																																																																														request,
																																																																																														response);
																																																																																									} else {
																																																																																										if (target
																																																																																												.equals("/StartSystemRestore")) {
																																																																																											DeviceBinding
																																																																																													.StartSystemRestore(
																																																																																															target,
																																																																																															baseRequest,
																																																																																															request,
																																																																																															response);
																																																																																										} else {
																																																																																											if (target
																																																																																													.equals("/SystemReboot")) {
																																																																																												DeviceBinding
																																																																																														.SystemReboot(
																																																																																																target,
																																																																																																baseRequest,
																																																																																																request,
																																																																																																response);
																																																																																											} else {
																																																																																												if (target
																																																																																														.equals("/UpgradeSystemFirmware")) {
																																																																																													DeviceBinding
																																																																																															.UpgradeSystemFirmware(
																																																																																																	target,
																																																																																																	baseRequest,
																																																																																																	request,
																																																																																																	response);
																																																																																												} else {
																																																																																													load_not_found_page(
																																																																																															target,
																																																																																															baseRequest,
																																																																																															request,
																																																																																															response);
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
