package specification.devicemanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InvalidClassException;
import java.io.OptionalDataException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StreamCorruptedException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.IllegalBlockingModeException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

public class DeviceBinding {

	public static void AddIPAddressFilter(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("Bismillahirrahmanirrahim");
		System.out.println("AddIPAddressFilter");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		return;
	}

	public static void AddScopes(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
			}

	public static void CreateCertificate(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
			}

	public static void CreateDot1XConfiguration(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
			}

	public static void CreateStorageConfiguration(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		}

	public static void CreateUsers(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void DeleteCertificates(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void DeleteDot1XConfiguration(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void DeleteGeoLocation(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void DeleteStorageConfiguration(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void DeleteUsers(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetAccessPolicy(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetCACertificates(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetCapabilities(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetCertificateInformation(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetCertificates(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetCertificatesStatus(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetClientCertificateMode(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetDeviceInformation(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetDiscoveryMode(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetDNS(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetDot11Capabilities(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetDot11Status(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetDot1XConfiguration(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetDot1XConfigurations(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetDPAddresses(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetDynamicDNS(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetEndpointReference(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetGeoLocation(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetHostname(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetIPAddressFilter(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetNetworkDefaultGateway(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetNetworkInterfaces(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetNetworkProtocols(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetNTP(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetPkcs10Request(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetRelayOutputs(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetRemoteDiscoveryMode(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetRemoteUser(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetScopes(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetServiceCapabilities(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetServices(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetStorageConfiguration(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetStorageConfigurations(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetSystemBackup(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetSystemDateAndTime(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetSystemLog(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetSystemSupportInformation(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetSystemUris(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void GetUsers(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param connectionStream
	 * @param inputStreamReader
	 * @return inputStreamReader
	 */
	private static InputStreamReader createinputstreamreader(InputStream connectionStream,
			InputStreamReader inputStreamReader) {
		try {
			inputStreamReader = new InputStreamReader(connectionStream, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		return inputStreamReader;
	}

	/**
	 * @param inputStreamReader
	 * @return buffered_reader
	 */
	private static BufferedReader createbuffered_reader(InputStreamReader inputstreamreader) {
		BufferedReader buffered_reader;
		buffered_reader = new BufferedReader(inputstreamreader);
		return buffered_reader;
	}

	private static String GetWsdlUrl_response = "";

	/**
	 * @param buffered_reader
	 */
	private static void readlinesofbuffered_reader(BufferedReader buffered_reader, InputStreamReader inputstreamreader,
			InputStream inputstream) {
		String line;
		StringBuffer sb = new StringBuffer("");
		@SuppressWarnings("unused")
		Boolean hata_var_mý = false;

		try {
			while ((line = buffered_reader.readLine()) != null) {
				sb.append(line);/* \n vardý */
			}
		} catch (ConnectException e) {

			System.out.println(
					"Signals that an error occurred while attempting to connect a socket to a remote address and port. Typically, the connection was refused remotely (e.g., no process is listening on the remote address/port).");
			e.printStackTrace();// cs null
		} catch (InvalidClassException e) {
			hata_var_mý = true;

			System.out.println("InvalidClassException");
			e.printStackTrace();
		} catch (OptionalDataException e) {
			hata_var_mý = true;
			System.out.println("OptionalDataException");
			e.printStackTrace();
		} catch (StreamCorruptedException sce) {
			hata_var_mý = true;
			System.out.println("StreamCorruptedException");
			sce.printStackTrace();
		} catch (NullPointerException e) {
			hata_var_mý = true;
			System.out.println("NullPointerException");
			e.printStackTrace();
		} catch (SocketException e) {
			hata_var_mý = true;
			System.out.println("SocketException");
			try {
				buffered_reader.close();
				inputstreamreader.close();
				inputstream.close();
			} catch (IOException e1) {
				hata_var_mý = true;
				System.out.println("IOException");
				e1.printStackTrace();
			}
			// e.printStackTrace();
		} catch (UnknownHostException e) {
			hata_var_mý = true;
			e.printStackTrace();
		} catch (IllegalBlockingModeException e) {
			hata_var_mý = true;
			System.out.println("IllegalBlockingModeException");
			e.printStackTrace();
		} catch (SocketTimeoutException e) {
			hata_var_mý = true;
			System.out.println("SocketTimeoutException");
			e.printStackTrace();
		} catch (IOException e) {
			hata_var_mý = true;
			System.out.println("IOException");
			e.printStackTrace();
		} catch (Exception e) {
			hata_var_mý = true;
			System.out.println("Exception");
			e.printStackTrace();
		}
		System.out.println(sb);
		setGetWsdlUrl_response(sb.toString());
	}

	@SuppressWarnings("unused")
	public static void GetWsdlUrl(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		String http_protocol = "http://";
		String ip_address = "192.168.1.253";
		InputStreamReader inputstreamreader = null;
		BufferedReader buffered_reader = null;

		URL u = null;
		try {
			u = new URL(http_protocol + ip_address + "/onvif/device_service");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		URLConnection uc = null;
		HttpURLConnection connection = null;
		OutputStream out = null;
		OutputStreamWriter wout = null;
		String GetWsdlUrl_xml = "";
		InputStream inputstream = null;
		GetWsdlUrl_xml = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:wsdl=\"http://www.onvif.org/ver10/device/wsdl\">\r\n"
				+ "   <soap:Header/>\r\n" + "   <soap:Body>\r\n" + "      <wsdl:GetWsdlUrl/>\r\n"
				+ "   </soap:Body>\r\n" + "</soap:Envelope>";
		if (u != null) {
			try {
				uc = u.openConnection();
			} catch (Exception e) {
				System.out.println("Exception");
				e.printStackTrace();
				response.setStatus(HttpServletResponse.SC_OK);
				baseRequest.setHandled(true);
				return;
			}
			if (uc != null) {
				try {
					connection = (HttpURLConnection) uc;
				} catch (Exception e) {
					System.out.println("Exception");
					e.printStackTrace();
					response.setStatus(HttpServletResponse.SC_OK);
					baseRequest.setHandled(true);
					return;
				}
				if (connection != null) {
					connection.setDoOutput(true);
					connection.setDoInput(true);
					try {
						connection.setRequestMethod("POST");
					} catch (SecurityException e) {
						// TODO: handle exception
						System.out.println("SecurityException");
						e.printStackTrace();
						response.setStatus(HttpServletResponse.SC_OK);
						baseRequest.setHandled(true);
						return;
					} catch (ProtocolException e) {
						// TODO: handle exception
						System.out.println("ProtocolException");
						e.printStackTrace();
						response.setStatus(HttpServletResponse.SC_OK);
						baseRequest.setHandled(true);
						return;
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("ConnectException");
						e.printStackTrace();
						response.setStatus(HttpServletResponse.SC_OK);
						baseRequest.setHandled(true);
						return;
					}
					try {
						out = connection.getOutputStream();
					} catch (ConnectException e) {
						System.out.println("ConnectException baðlý olmayan kamera ip:"+ip_address);
						e.printStackTrace();
						response.setStatus(HttpServletResponse.SC_OK);
						baseRequest.setHandled(true);
						return;
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Exception");
						e.printStackTrace();
						response.setStatus(HttpServletResponse.SC_OK);
						baseRequest.setHandled(true);
						return;
					}
					if (out != null) {
						try {
							wout = new OutputStreamWriter(out, "UTF-8");
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Exception");
							e.printStackTrace();
							response.setStatus(HttpServletResponse.SC_OK);
							baseRequest.setHandled(true);
							return;
						}
						if (wout != null) {
							try {
								wout.write(GetWsdlUrl_xml);
							} catch (Exception e) {
								// TODO: handle exception
								System.out.println("Exception");
								e.printStackTrace();
								response.setStatus(HttpServletResponse.SC_OK);
								baseRequest.setHandled(true);
								return;
							}
							try {
								wout.flush();/* iafdjgiasdþlkjgiasþlkdjfsldfjþasldkfisldifþl */
							} catch (Exception e) {
								// TODO: handle exception
								System.out.println("Exception");
								e.printStackTrace();
								response.setStatus(HttpServletResponse.SC_OK);
								baseRequest.setHandled(true);
								return;
							}
							try {
								wout.close();
							} catch (IOException e) {
								// TODO: handle exception
								System.out.println("IOException");
								e.printStackTrace();
								response.setStatus(HttpServletResponse.SC_OK);
								baseRequest.setHandled(true);
								return;
							} catch (Exception e) {
								// TODO: handle exception
								System.out.println("Exception");
								e.printStackTrace();
								response.setStatus(HttpServletResponse.SC_OK);
								baseRequest.setHandled(true);
								return;
							}
							try {
								out.close();
							} catch (UnknownServiceException e) {
								System.out.println("DEBUG:2");
								e.printStackTrace();
								response.setStatus(HttpServletResponse.SC_OK);
								baseRequest.setHandled(true);
								return;
							} catch (IOException e) {
								System.out.println("IOException");
								e.printStackTrace();
								response.setStatus(HttpServletResponse.SC_OK);
								baseRequest.setHandled(true);
								return;
							} catch (Exception e) {
								// TODO: handle exception
								System.out.println("Exception");
								e.printStackTrace();
								response.setStatus(HttpServletResponse.SC_OK);
								baseRequest.setHandled(true);
								return;
							}
							try {
								inputstream = connection.getInputStream();
							} catch (UnknownServiceException e) {
								System.out.println("DEBUG:2");
								e.printStackTrace();
								response.setStatus(HttpServletResponse.SC_OK);
								baseRequest.setHandled(true);
								return;
							} catch (IOException e) {
								System.out.println("DEBUG:4");
								e.printStackTrace();
								response.setStatus(HttpServletResponse.SC_OK);
								baseRequest.setHandled(true);
								return;
							} catch (Exception e) {
								System.out.println("DEBUG:4");
								e.printStackTrace();
								response.setStatus(HttpServletResponse.SC_OK);
								baseRequest.setHandled(true);
								return;
							}
							if(inputstream!=null) {
								try {
									inputstreamreader = createinputstreamreader(inputstream, inputstreamreader);
								} catch (Exception e) {
									System.out.println("DEBUG:3");
									e.printStackTrace();
									response.setStatus(HttpServletResponse.SC_OK);
									baseRequest.setHandled(true);
									return;
								}
								if(inputstreamreader!=null) {
									try {
										buffered_reader = createbuffered_reader(inputstreamreader);
									} catch (Exception e) {
										System.out.println("DEBUG:4");
										e.printStackTrace();
										response.setStatus(HttpServletResponse.SC_OK);
										baseRequest.setHandled(true);
										return;
									}
									try {
									readlinesofbuffered_reader(buffered_reader, inputstreamreader, inputstream);
									} catch (Exception e) {
										System.out.println("DEBUG:5");
										e.printStackTrace();
										response.setStatus(HttpServletResponse.SC_OK);
										baseRequest.setHandled(true);
										return;
									}
									System.out.println();
									try {
										inputstream.close();
									} catch (UnknownServiceException e) {
										System.out.println("DEBUG:2");
										e.printStackTrace();
										response.setStatus(HttpServletResponse.SC_OK);
										baseRequest.setHandled(true);
										return;
									} catch (IOException e) {
										// TODO: handle exception
										System.out.println("Exception");
										e.printStackTrace();
									} catch (Exception e) {
										// TODO: handle exception
										System.out.println("Exception");
										e.printStackTrace();
									}
									response.setContentType("text/html;charset=utf-8");
									try {
										response.getWriter().println(GetWsdlUrl_response);
									} catch (IOException e) {
										System.out.println("IOException");
										response.setStatus(HttpServletResponse.SC_OK);
										baseRequest.setHandled(true);
										e.printStackTrace();
										return;
									} catch (Exception e) {
										System.out.println("DEBUG:4");
										e.printStackTrace();
										response.setStatus(HttpServletResponse.SC_OK);
										baseRequest.setHandled(true);
										return;
									}
									response.setStatus(HttpServletResponse.SC_OK);
									baseRequest.setHandled(true);
									return;
								}else {
									System.out.println("inputstreamreader null");
									response.setStatus(HttpServletResponse.SC_OK);
									baseRequest.setHandled(true);
									return;
								}
							}else {
								System.out.println("inputstream null");
								response.setStatus(HttpServletResponse.SC_OK);
								baseRequest.setHandled(true);
								return;
							}
						} else {
							System.out.println("wout null");
							response.setStatus(HttpServletResponse.SC_OK);
							baseRequest.setHandled(true);
							return;
						}
					} else {
						System.out.println("out null");
						response.setStatus(HttpServletResponse.SC_OK);
						baseRequest.setHandled(true);
						return;
					}
				} else {
					System.out.println("connection null");
					response.setStatus(HttpServletResponse.SC_OK);
					baseRequest.setHandled(true);
					return;
				}
			}else {
				System.out.println("uc null");
				response.setStatus(HttpServletResponse.SC_OK);
				baseRequest.setHandled(true);
				return;
			}
		}else {
			System.out.println("u null");
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	public static void GetZeroConfiguration(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void LoadCACertificates(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void LoadCertificates(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void LoadCertificateWithPrivateKey(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void RemoveIPAddressFilter(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void RemoveScopes(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void RestoreSystem(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void ScanAvailableDot11Networks(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SendAuxiliaryCommand(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetAccessPolicy(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetCertificatesStatus(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetClientCertificateMode(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetDiscoveryMode(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetDNS(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetDot1XConfiguration(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetDPAddresses(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetDynamicDNS(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetGeoLocation(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetHostname(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetHostnameFromDHCP(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetIPAddressFilter(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetNetworkDefaultGateway(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetNetworkInterfaces(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetNetworkProtocols(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetNTP(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetRelayOutputSettings(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetRelayOutputState(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetRemoteDiscoveryMode(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetRemoteUser(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetScopes(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetStorageConfiguration(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetSystemDateAndTime(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetSystemFactoryDefault(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetUser(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SetZeroConfiguration(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void StartFirmwareUpgrade(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void StartSystemRestore(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void SystemReboot(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	public static void UpgradeSystemFirmware(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the getWsdlUrl_response
	 */
	public static String getGetWsdlUrl_response() {
		return GetWsdlUrl_response;
	}

	/**
	 * @param getWsdlUrl_response the getWsdlUrl_response to set
	 */
	public static void setGetWsdlUrl_response(String getWsdlUrl_response) {
		GetWsdlUrl_response = getWsdlUrl_response;
	}

}
