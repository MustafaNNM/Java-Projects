package specification.advancedsecurity;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

import application.web.Page;
import application.web.pages.Not_found_page;
import specification.enumeration.Environment;

public class KeystoreBinding_page extends Page{
	private String requestURI;// loglanmasý gerekiyor.

	private String sayfalar;
	
	private String requestler;


	public KeystoreBinding_page(String target) {
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
		requestler ="<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/CreateCertificationPath\">CreateCertificationPath</a>\r\n<br>"
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
				+ "<a href=\"http://localhost:8080/advancedsecurity/KeystoreBinding/UploadPassphrase\">UploadPassphrase</a>\r\n<br>";
	}

	public void load(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("KeystoreBinding_page loading");
		/* request uri starts with Environment.keystorebinding_page.getURI() */
		if (target != null) {
			if (target.equals(Environment.keystorebinding_page.getURI())) {
				/* request uri equals Environment.keystorebinding_page.getURI() */
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
		target = target.substring(Environment.keystorebinding_page.getSize());
		if (target.equals("/CreateCertificationPath")) {
			KeystoreBinding.CreateCertificationPath(target, baseRequest, request, response);
		} else {
			if (target.equals("/CreateCertPathValidationPolicy")) {
				KeystoreBinding.CreateCertPathValidationPolicy(target, baseRequest, request, response);
			} else {
				if (target.equals("/CreatePKCS10CSR")) {
					KeystoreBinding.CreatePKCS10CSR(target, baseRequest, request, response);
				} else {
					if (target.equals("/CreateRSAKeyPair")) {
						KeystoreBinding.CreateRSAKeyPair(target, baseRequest, request, response);
					} else {
						if (target.equals("/CreateSelfSignedCertificate")) {
							KeystoreBinding.CreateSelfSignedCertificate(target, baseRequest, request, response);
						} else {
							if (target.equals("/DeleteCertificate")) {
								KeystoreBinding.DeleteCertificate(target, baseRequest, request, response);
							} else {
								if (target.equals("/DeleteCertificationPath")) {
									KeystoreBinding.DeleteCertificationPath(target, baseRequest, request, response);
								} else {
									if (target.equals("/DeleteCertPathValidationPolicy")) {
										KeystoreBinding.DeleteCertPathValidationPolicy(target, baseRequest, request, response);
									} else {
										if (target.equals("/DeleteCRL")) {
											KeystoreBinding.DeleteCRL(target, baseRequest, request, response);
										} else {
											if (target.equals("/DeleteKey")) {
												KeystoreBinding.DeleteKey(target, baseRequest, request,
														response);
											} else {
												if (target.equals("/DeletePassphrase")) {
													KeystoreBinding.DeletePassphrase(target, baseRequest, request, response);
												} else {
													if (target.equals("/GetAllCertificates")) {
														KeystoreBinding.GetAllCertificates(target, baseRequest, request,
																response);
													} else {
														if (target.equals("/GetAllCertificationPaths")) {
															KeystoreBinding.GetAllCertificationPaths(target, baseRequest,
																	request, response);
														} else {
															if (target.equals("/GetAllCertPathValidationPolicies")) {
																KeystoreBinding.GetAllCertPathValidationPolicies(target, baseRequest,
																		request, response);
															} else {
																if (target.equals("/GetAllCRLs")) {
																	KeystoreBinding.GetAllCRLs(target, baseRequest,
																			request, response);
																} else {
																	if (target.equals("/GetAllKeys")) {
																		KeystoreBinding.GetAllKeys(target,
																				baseRequest, request, response);
																	} else {
																		if (target.equals("/GetAllPassphrases")) {
																			KeystoreBinding.GetAllPassphrases(target,
																					baseRequest, request, response);
																		} else {
																			if (target
																					.equals("/GetCertificate")) {
																				KeystoreBinding.GetCertificate(
																						target, baseRequest, request,
																						response);
																			} else {
																				if (target.equals(
																						"/GetCertificationPath")) {
																					KeystoreBinding
																							.GetCertificationPath(
																									target, baseRequest,
																									request, response);
																				} else {
																					if (target.equals(
																							"/GetCertPathValidationPolicy")) {
																						KeystoreBinding
																								.GetCertPathValidationPolicy(
																										target,
																										baseRequest,
																										request,
																										response);
																					} else {
																						if (target.equals(
																								"/GetCRL")) {
																							KeystoreBinding
																									.GetCRL(
																											target,
																											baseRequest,
																											request,
																											response);
																						} else {
																							if (target.equals(
																									"/GetKeyStatus")) {
																								KeystoreBinding.GetKeyStatus(
																										target,
																										baseRequest,
																										request,
																										response);
																							} else {
																								if (target.equals(
																										"/GetPrivateKeyStatus")) {
																									KeystoreBinding
																											.GetPrivateKeyStatus(
																													target,
																													baseRequest,
																													request,
																													response);
																								} else {
																									if (target.equals(
																											"/UploadCertificate")) {
																										KeystoreBinding
																												.UploadCertificate(
																														target,
																														baseRequest,
																														request,
																														response);
																									} else {
																										if (target.equals(
																												"/UploadCertificateWithPrivateKeyInPKCS12")) {
																											KeystoreBinding
																													.UploadCertificateWithPrivateKeyInPKCS12(
																															target,
																															baseRequest,
																															request,
																															response);
																										} else {
																											if (target.equals(
																													"/UploadCRL")) {
																												KeystoreBinding
																														.UploadCRL(
																																target,
																																baseRequest,
																																request,
																																response);
																											} else {
																												if (target.equals(
																														"/UploadKeyPairInPKCS8")) {
																													KeystoreBinding
																															.UploadKeyPairInPKCS8(
																																	target,
																																	baseRequest,
																																	request,
																																	response);
																												} else {
																													if (target.equals(
																															"/UploadCertificateWithPrivateKeyInPKCS12")) {
																														KeystoreBinding
																																.UploadCertificateWithPrivateKeyInPKCS12(
																																		target,
																																		baseRequest,
																																		request,
																																		response);
																													} else {
																														if (target.equals(
																																"/UploadPassphrase")) {
																															KeystoreBinding
																																	.UploadPassphrase(
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
