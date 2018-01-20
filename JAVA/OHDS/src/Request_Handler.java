
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.util.IO;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.NoSuchElementException;

public class Request_Handler extends AbstractHandler {
	private static HtmlCodePrinterofHost htmlcodeprinterofhost = new HtmlCodePrinterofHost();
	int kullanici_tipi = -1;
	String sayfalar = "<a href=\"http://localhost:8080/anasayfa\">Anasayfa</a>\r\n"
			+ "<a href=\"http://localhost:8080/login\">Login</a>\r\n"
			+ "<a href=\"http://localhost:8080/admin_anamenu\">Admin Anamenu</a>\r\n"
			+ "<a href=\"http://localhost:8080/standart_anamenu\">Standart Anamenu</a>\r\n"
			+ "<a href=\"http://localhost:8080/admin_anamenu/lokasyon_duzenle\">/Lokasyon Duzenle</a>\r\n";
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = null;
		out = response.getWriter();
		// root=0,admin=1,standart=2,ziyaretçi=3
		String requestURI = "";
		requestURI = request.getRequestURI();
		Enumeration<String> parameterNames;
		String name = "";
		String value = "";
		String kullanici_adi = "";
		String sifre = "";
		String admin_anamenu_option = "";
		String admin_anamenu_kullanici_duzenle_option = "";
		String admin_anamenu_lokasyon_duzenle_option = "";
		String standart_anamenu_option = "";
		Boolean kullanici_adi_parametre_varmi = false;
		Boolean admin_anamenu_option_parametre_varmi = false;
		Boolean admin_anamenu_kullanici_duzenle_option_parametre_varmi = false;
		Boolean admin_anamenu_lokasyon_duzenle_option_parametre_varmi = false;
		Boolean sifre_parametre_varmi = false;
		Boolean standart_anamenu_option_parametre_varmi = false;

		parameterNames = request.getParameterNames();

		while (parameterNames.hasMoreElements()) {

			try {
				name = (String) parameterNames.nextElement();
			} catch (NoSuchElementException e) {
				response.setStatus(HttpServletResponse.SC_OK);
				baseRequest.setHandled(true);
				e.printStackTrace();
				// return;
			}
			value = request.getParameter(name).toString();
			System.out.println(String.format("%s==%s\n", name, value));
			if (name.equals("kullanici_adi")) {
				try {
					kullanici_adi = request.getParameter(name);
					kullanici_adi_parametre_varmi = true;
				} catch (Exception e) {
					response.setStatus(HttpServletResponse.SC_OK);
					baseRequest.setHandled(true);
					// return;
				}
			} else {
				if (name.equals("sifre")) {
					try {
						sifre = request.getParameter(name);
						sifre_parametre_varmi = true;
					} catch (Exception e) {
						response.setStatus(HttpServletResponse.SC_OK);
						baseRequest.setHandled(true);
						// return;
					}
				} else {
					if (name.equals("admin_anamenu_option")) {
						try {
							admin_anamenu_option = request.getParameter(name);
							admin_anamenu_option_parametre_varmi = true;
						} catch (Exception e) {
							response.setStatus(HttpServletResponse.SC_OK);
							baseRequest.setHandled(true);
							// return;
						}
					} else {
						if (name.equals("admin_anamenu_kullanici_duzenle_option")) {
							try {
								admin_anamenu_kullanici_duzenle_option = request.getParameter(name);
								admin_anamenu_kullanici_duzenle_option_parametre_varmi = true;
							} catch (Exception e) {
								response.setStatus(HttpServletResponse.SC_OK);
								baseRequest.setHandled(true);
								// return;
							}
						} else {
							if (name.equals("admin_anamenu_lokasyon_duzenle_option")) {
								try {
									admin_anamenu_lokasyon_duzenle_option = request.getParameter(name);
									admin_anamenu_lokasyon_duzenle_option_parametre_varmi = true;
								} catch (Exception e) {
									response.setStatus(HttpServletResponse.SC_OK);
									baseRequest.setHandled(true);
									// return;
								}
							} else {
								if (name.equals("standart_anamenu_option")) {
									try {
										standart_anamenu_option = request.getParameter(name);
										standart_anamenu_option_parametre_varmi = true;
									} catch (Exception e) {
										response.setStatus(HttpServletResponse.SC_OK);
										baseRequest.setHandled(true);
										// return;
									}
								}
							}
						}
					}
				}
			}
		}
		if (requestURI.equals("/anasayfa")) {// Kullanıcı anasayfaya girmek isterse
			response.setContentType("text/html;charset=utf-8");
			response.setStatus(HttpServletResponse.SC_OK);
			try {
				String word = sayfalar;
				out.print(word);
			} finally {
				out.close();
			}
			baseRequest.setHandled(true);
			return;
		} else {// Kullanıcı login sayfasına girmek isterse
			if (requestURI.equals("/login")) {
				response.setContentType("text/html;charset=utf-8");
				response.setStatus(HttpServletResponse.SC_OK);
				//login yetkisine göre yönlendirme yapılıyor
				if (kullanici_adi_parametre_varmi == true && sifre_parametre_varmi == true) {
					// System.out.println("giriş parametreleri:" + giris_parametreleri);
					kullanici_tipi = kullanici_adinin_ve_sifresinin_kontrol_edilmesi(kullanici_adi, sifre);
					kullanici_tipine_gore_menuye_yonlendir(target, baseRequest, request, response);
				} else {// parametre yok
					// ziyaretçinin login sayfasına yönlendirilmesi
					ziyaretcinin_logine_yonlendirilmesi(target, baseRequest, request, response);
				}
			} else {
				if (requestURI.equals("/admin_anamenu")) {// admin_menu_option
					response.setContentType("text/html;charset=utf-8");
					response.setStatus(HttpServletResponse.SC_OK);
					if (admin_anamenu_option_parametre_varmi == true && (kullanici_tipi == 0 || kullanici_tipi == 1)) {
						// adminin anamenu secimine gore alt sayfaya gonderilmesi
						response.sendRedirect("/admin_anamenu/" + admin_anamenu_option);
						out.close();
						baseRequest.setHandled(true);
						return;
						// admin_anamenu_options = ['lokasyon_duzenle', 'hava_durumu',
						// 'kullanici_duzenle', 'raporlar']
					} else {
						//standart kullanıcı yada ziyaretçi tipine göre yönlendirme yapılıyor
						standart_menuye_yada_logine_yonlendir(
								target, baseRequest, request,
								response);
					}
				} else {
					if (requestURI.equals("/admin_anamenu/lokasyon_duzenle")) {// kullanici_duzenle
						response.setContentType("text/html;charset=utf-8");
						response.setStatus(HttpServletResponse.SC_OK);
						if (admin_anamenu_lokasyon_duzenle_option_parametre_varmi == true&& (kullanici_tipi == 0 || kullanici_tipi == 1)) {
							// adminin kullanici duzenleme secimine gore alt sayfaya gonderilmesi
							response.sendRedirect(
									"/admin_anamenu/lokasyon_duzenle/" + admin_anamenu_lokasyon_duzenle_option);
							out.close();
							baseRequest.setHandled(true);
							return;
							// admin_anamenu_lokasyon_duzenle_options = ['lokasyon_ekleme',
							// 'lokasyon_guncelleme', 'lokasyon_silme', 'lokasyon_listeleme']
						} else {
							//parametre yok
							if(kullanici_tipi == 0 || kullanici_tipi == 1) {
								adminin_admin_anamenu_lokasyon_duzenleye_yonlendirilmesi(target, baseRequest, request,
										response);
							}else {
								//standart kullanıcı yada ziyaretçi tipine göre yönlendirme yapılıyor
								standart_menuye_yada_logine_yonlendir(
										target, baseRequest, request,
										response);
							}
							
						}
					} else {
						if (requestURI.equals("/admin_anamenu/hava_durumu")) {// hava_durumu
							response.setContentType("text/html;charset=utf-8");
							response.setStatus(HttpServletResponse.SC_OK);
							try {
								String word = sayfalar+ "hava_durumu";
								out.print(word);
							} finally {
								out.close();
							}
							baseRequest.setHandled(true);
							return;
						} else {
							if (requestURI.equals("/admin_anamenu/kullanici_duzenle")) {// kullanici_duzenle
								response.setContentType("text/html;charset=utf-8");
								response.setStatus(HttpServletResponse.SC_OK);
								if (admin_anamenu_kullanici_duzenle_option_parametre_varmi == true) {
									// adminin kullanici duzenleme secimine gore alt sayfaya gonderilmesi
									response.sendRedirect("/admin_anamenu/kullanici_duzenle/"
											+ admin_anamenu_kullanici_duzenle_option);
									out.close();
									baseRequest.setHandled(true);
									return;
									// admin_anamenu_kullanici_duzenle_options = ['kullanici_ekleme',
									// 'kullanici_guncelleme', 'kulanici_silme', 'kullanici_listeleme']
								} else {
									adminin_admin_anamenu_kullanici_duzenleye_yonlendirilmesi(target, baseRequest,
											request, response);
								}
							} else {
								if (requestURI.equals("/admin_anamenu/raporlar")) {// kullanici_duzenle
									response.setContentType("text/html;charset=utf-8");
									response.setStatus(HttpServletResponse.SC_OK);
									try {
										String word = sayfalar+ "raporlar";
										out.print(word);
									} finally {
										out.close();
									}
									baseRequest.setHandled(true);
									return;
								} else {
									if (requestURI.equals("/admin_anamenu/kullanici_duzenle/kullanici_ekleme")) {
										response.setContentType("text/html;charset=utf-8");
										response.setStatus(HttpServletResponse.SC_OK);
										try {
											String word = sayfalar+ "kullanici_ekleme";
											out.print(word);
										} finally {
											out.close();
										}
										baseRequest.setHandled(true);
										return;
									} else {
										if (requestURI
												.equals("/admin_anamenu/kullanici_duzenle/kullanici_guncelleme")) {
											response.setContentType("text/html;charset=utf-8");
											response.setStatus(HttpServletResponse.SC_OK);
											try {
												String word =sayfalar+ "kullanici_guncelleme";
												out.print(word);
											} finally {
												out.close();
											}
											baseRequest.setHandled(true);
											return;
										} else {
											if (requestURI.equals("/admin_anamenu/kullanici_duzenle/kulanici_silme")) {
												response.setContentType("text/html;charset=utf-8");
												response.setStatus(HttpServletResponse.SC_OK);
												try {
													String word =sayfalar+ "kulanici_silme";
													out.print(word);
												} finally {
													out.close();
												}
												baseRequest.setHandled(true);
												return;
											} else {
												if (requestURI.equals(
														"/admin_anamenu/kullanici_duzenle/kullanici_listeleme")) {
													response.setContentType("text/html;charset=utf-8");
													response.setStatus(HttpServletResponse.SC_OK);
													try {
														String word = sayfalar+ "kullanici_listeleme";
														out.print(word);
													} finally {
														out.close();
													}
													baseRequest.setHandled(true);
													return;
												} else {
													if (_serveIcon && _favicon != null
															&& requestURI.equals("/favicon.ico")) {
														response.setStatus(HttpServletResponse.SC_OK);
														response.setContentType("image/x-icon");
														response.setContentLength(_favicon.length);
														response.getOutputStream().write(_favicon);
														return;
													} else {
														// admin_anamenu_lokasyon_duzenle_options = ['lokasyon_ekleme',
														// 'lokasyon_guncelleme', 'lokasyon_silme',
														// 'lokasyon_listeleme']
														if (requestURI.equals(
																"/admin_anamenu/lokasyon_duzenle/lokasyon_listeleme")) {
															response.setContentType("text/html;charset=utf-8");
															response.setStatus(HttpServletResponse.SC_OK);
															try {
																String word = sayfalar+ "lokasyon_listeleme";
																out.print(word);
															} finally {
																out.close();
															}
															baseRequest.setHandled(true);
															return;
														} else {
															if (requestURI.equals(
																	"/admin_anamenu/lokasyon_duzenle/lokasyon_ekleme")) {
																response.setContentType("text/html;charset=utf-8");
																response.setStatus(HttpServletResponse.SC_OK);
																try {
																	String word = sayfalar+ "lokasyon_ekleme";
																	out.print(word);
																} finally {
																	out.close();
																}
																baseRequest.setHandled(true);
																return;
															} else {
																if (requestURI.equals(
																		"/admin_anamenu/lokasyon_duzenle/lokasyon_silme")) {
																	response.setContentType("text/html;charset=utf-8");
																	response.setStatus(HttpServletResponse.SC_OK);
																	try {
																		String word = sayfalar+ "lokasyon_silme";
																		out.print(word);
																	} finally {
																		out.close();
																	}
																	baseRequest.setHandled(true);
																	return;
																} else {
																	if (requestURI.equals(
																			"/admin_anamenu/lokasyon_duzenle/lokasyon_guncelleme")) {
																		response.setContentType(
																				"text/html;charset=utf-8");
																		response.setStatus(HttpServletResponse.SC_OK);
																		try {
																			String word = sayfalar+ "lokasyon_guncelleme";
																			out.print(word);
																		} finally {
																			out.close();
																		}
																		baseRequest.setHandled(true);
																		return;
																	} else {
																		if (requestURI.equals("/standart_anamenu")) {// standart_menu_option
																			response.setContentType(
																					"text/html;charset=utf-8");
																			response.setStatus(
																					HttpServletResponse.SC_OK);
																			if (standart_anamenu_option_parametre_varmi == true
																					&& kullanici_tipi == 2) {
																				// adminin anamenu secimine gore alt
																				// sayfaya gonderilmesi
																				response.sendRedirect(
																						"/standart_anamenu/"
																								+ standart_anamenu_option);
																				out.close();
																				baseRequest.setHandled(true);
																				return;
																				// standart_anamenu_options = [
																				// 'hava_durumu', 'raporlar']
																			} else {
																				standart_menuye_yada_logine_yonlendir(
																						target, baseRequest, request,
																						response);
																			}
																		}else {
																			if (requestURI.equals("/standart_anamenu/hava_durumu")) {// hava_durumu
																				response.setContentType("text/html;charset=utf-8");
																				response.setStatus(HttpServletResponse.SC_OK);
																				try {
																					String word = sayfalar+ "hava_durumu";
																					out.print(word);
																				} finally {
																					out.close();
																				}
																				baseRequest.setHandled(true);
																				return;
																			}else {
																				if (requestURI.equals("/standart_anamenu/raporlar")) {// hava_durumu
																					response.setContentType("text/html;charset=utf-8");
																					response.setStatus(HttpServletResponse.SC_OK);
																					try {
																						String word = sayfalar+ "raporlar";
																						out.print(word);
																					} finally {
																						out.close();
																					}
																					baseRequest.setHandled(true);
																					return;
																				}else {
																					
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
	 */
	private void standart_menuye_yada_logine_yonlendir(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		if (kullanici_tipi == 2) {
			standart_kullanicinin_standart_kullanici_anamenusune_yonlendirilmesi(target, baseRequest, request,
					response);
		} else {
			// ziyaretçinin login sayfasına yönlendirilmesi
			ziyaretcinin_logine_yonlendirilmesi(target, baseRequest, request, response);
		}
	}

	/**
	 * @param target
	 * @param baseRequest
	 * @param request
	 * @param response
	 */
	private void kullanici_tipine_gore_menuye_yonlendir(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		if (kullanici_tipi == 0 || kullanici_tipi == 1) {
			adminin_admin_anamenuye_yonlendirilmesi(target, baseRequest, request, response);
		}else {
		standart_menuye_yada_logine_yonlendir(target, baseRequest, request, response);
		}
	}

	private void adminin_admin_anamenu_lokasyon_duzenleye_yonlendirilmesi(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response) {
		// Url,parametre,combobox adı sayfa linkleri gibi string değişkenler oluşturulup
		// html kod
		// arasına eklenmesi gerekmektedir.
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		try {
			
			String word = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
					+ "    <meta charset=\"utf-8\" />\r\n" + "    <title>JavaScript Shield UI Demos</title>\r\n"
					+ sayfalar
					+ "    <link id=\"themecss\" rel=\"stylesheet\" type=\"text/css\" href=\"//www.shieldui.com/shared/components/latest/css/light/all.min.css\" />\r\n"
					+ "    <script type=\"text/javascript\" src=\"//www.shieldui.com/shared/components/latest/js/jquery-1.11.1.min.js\"></script>\r\n"
					+ "    <script type=\"text/javascript\" src=\"//www.shieldui.com/shared/components/latest/js/shieldui-all.min.js\"></script>\r\n"
					+ "</head>\r\n" + "<body class=\"theme-light\">\r\n" + "<div>\r\n"
					+ "    <div class=\"outerDiv\">\r\n" + "        <div class=\"innerDiv\">\r\n"
					+ "            <label for=\"comboBoxAdmin_anamenu_lokasyon_duzenle_options\">Menu Seciniz</label>\r\n"
					+ "            <br />\r\n"
					+ "            <input id=\"comboBoxAdmin_anamenu_lokasyon_duzenle_options\" />\r\n"
					+ "            <br />\r\n" + "            <button id=\"submit\">Sorgula</button>\r\n"
					+ "        </div>\r\n" + "        <div class=\"imageDiv\">\r\n"
					+ "            <img class=\"img-responsive\" src=\"/Content/img/combobox/codesnippet.png\" />\r\n"
					+ "        </div>\r\n" + "    </div>\r\n" + "</div>\r\n" + "<script type=\"text/javascript\">\r\n" +
					/* veritabanindan veri çekmek gerekiyor */
					"    var Admin_anamenu_lokasyon_duzenle_options = ['lokasyon_ekleme', 'lokasyon_guncelleme', 'lokasyon_silme', 'lokasyon_listeleme'];\r\n"
					+ "    jQuery(function ($) {\r\n"
					+ "        $(\"#comboBoxAdmin_anamenu_lokasyon_duzenle_options\").shieldComboBox({\r\n"
					+ "            dataSource: {\r\n"
					+ "                data: Admin_anamenu_lokasyon_duzenle_options\r\n" + "            },\r\n"
					+ "            autoComplete: {\r\n" + "                enabled: true\r\n" + "            }\r\n"
					+ "        });\r\n" + "        $(\"#submit\").shieldButton({\r\n" + "            events: {\r\n"
					+ "                click: function () {\r\n"
					+ "                    var Admin_anamenu_lokasyon_duzenle_option = $(\"#comboBoxAdmin_anamenu_kullanici_duzenle_options\").swidget().value();\r\n"
					+ "window.location.assign(\"http://localhost:8080/admin_anamenu/lokasyon_duzenle?admin_anamenu_lokasyon_duzenle_option=\"+Admin_anamenu_lokasyon_duzenle_option)"
					+ "                }\r\n" + "            }\r\n" + "        });\r\n" + "    });\r\n"
					+ "</script>\r\n" + "<style>\r\n" + "    .outerDiv\r\n" + "    {\r\n"
					+ "        max-width: 600px;\r\n" + "        content: \".\";\r\n" + "        display: block;\r\n"
					+ "        overflow: hidden;\r\n" + "        margin-left: auto;\r\n"
					+ "        margin-right: auto;\r\n" + "    }\r\n" + "    .innerDiv\r\n" + "    {\r\n"
					+ "        display: inline-block;\r\n" + "        margin: 10px;\r\n" + "    }\r\n"
					+ "    .innerDiv label\r\n" + "    {\r\n" + "        font-style: italic;\r\n"
					+ "        font-size: 1.1em;\r\n" + "    }\r\n" + "    .imageDiv\r\n" + "    {\r\n"
					+ "        display: inline-block;\r\n" + "        max-width: 300px;\r\n"
					+ "        margin: 10px;\r\n" + "    }\r\n" + "    .innerDiv .sui-combobox\r\n" + "    {\r\n"
					+ "        font-family: Arial, sans-serif;\r\n" + "        font-size: 14px;\r\n"
					+ "        margin-bottom: 10px;\r\n" + "    }\r\n" + "</style>\r\n" + "</body>\r\n" + "</html>";
			out.print(word);
		} finally {
			// out.close();
		}
		baseRequest.setHandled(true);
		return;
	}

	private void ziyaretcinin_logine_yonlendirilmesi(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		try {
			String word = sayfalar+ "        <form method=\"post\" action=\"login\">\r\n"
					+ "        Kullanici Adi:<input type=\"text\" name=\"kullanici_adi\" /><br/>\r\n"
					+ "        Sifre        :<input type=\"text\" name=\"sifre\" /><br/>\r\n"
					+ "        <input type=\"submit\" value=\"login\" />\r\n" + "        </form>\r\n";
			out.print(word);
		} finally {
			out.close();
		}
		baseRequest.setHandled(true);
		return;
	}

	private void adminin_admin_anamenu_kullanici_duzenleye_yonlendirilmesi(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response) {
		// Url,parametre,combobox adı sayfa linkleri gibi string değişkenler oluşturulup
		// html kod
		// arasına eklenmesi gerekmektedir.
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		try {
			String word = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
					+ "    <meta charset=\"utf-8\" />\r\n" + "    <title>JavaScript Shield UI Demos</title>\r\n"
					+ sayfalar + "    <link id=\"themecss\" rel=\"stylesheet\" type=\"text/css\" href=\"//www.shieldui.com/shared/components/latest/css/light/all.min.css\" />\r\n"
					+ "    <script type=\"text/javascript\" src=\"//www.shieldui.com/shared/components/latest/js/jquery-1.11.1.min.js\"></script>\r\n"
					+ "    <script type=\"text/javascript\" src=\"//www.shieldui.com/shared/components/latest/js/shieldui-all.min.js\"></script>\r\n"
					+ "</head>\r\n" + "<body class=\"theme-light\">\r\n" + "<div>\r\n"
					+ "    <div class=\"outerDiv\">\r\n" + "        <div class=\"innerDiv\">\r\n"
					+ "            <label for=\"comboBoxAdmin_anamenu_kullanici_duzenle_options\">Menu Seciniz</label>\r\n"
					+ "            <br />\r\n"
					+ "            <input id=\"comboBoxAdmin_anamenu_kullanici_duzenle_options\" />\r\n"
					+ "            <br />\r\n" + "            <button id=\"submit\">Sorgula</button>\r\n"
					+ "        </div>\r\n" + "        <div class=\"imageDiv\">\r\n"
					+ "            <img class=\"img-responsive\" src=\"/Content/img/combobox/codesnippet.png\" />\r\n"
					+ "        </div>\r\n" + "    </div>\r\n" + "</div>\r\n" + "<script type=\"text/javascript\">\r\n" +
					/* veritabanindan veri çekmek gerekiyor */
					"    var Admin_anamenu_kullanici_duzenle_options = ['lokasyon_duzenle', 'hava_durumu', 'kullanici_duzenle', 'raporlar'];\r\n"
					+ "    jQuery(function ($) {\r\n"
					+ "        $(\"#comboBoxAdmin_anamenu_kullanici_duzenle_options\").shieldComboBox({\r\n"
					+ "            dataSource: {\r\n"
					+ "                data: Admin_anamenu_kullanici_duzenle_options\r\n" + "            },\r\n"
					+ "            autoComplete: {\r\n" + "                enabled: true\r\n" + "            }\r\n"
					+ "        });\r\n" + "        $(\"#submit\").shieldButton({\r\n" + "            events: {\r\n"
					+ "                click: function () {\r\n"
					+ "                    var Admin_anamenu_kullanici_duzenle_option = $(\"#comboBoxAdmin_anamenu_kullanici_duzenle_options\").swidget().value();\r\n"
					+ "window.location.assign(\"http://localhost:8080/admin_anamenu/kullanici_duzenle?admin_anamenu_kullanici_duzenle_option=\"+Admin_anamenu_kullanici_duzenle_option)"
					+ "                }\r\n" + "            }\r\n" + "        });\r\n" + "    });\r\n"
					+ "</script>\r\n" + "<style>\r\n" + "    .outerDiv\r\n" + "    {\r\n"
					+ "        max-width: 600px;\r\n" + "        content: \".\";\r\n" + "        display: block;\r\n"
					+ "        overflow: hidden;\r\n" + "        margin-left: auto;\r\n"
					+ "        margin-right: auto;\r\n" + "    }\r\n" + "    .innerDiv\r\n" + "    {\r\n"
					+ "        display: inline-block;\r\n" + "        margin: 10px;\r\n" + "    }\r\n"
					+ "    .innerDiv label\r\n" + "    {\r\n" + "        font-style: italic;\r\n"
					+ "        font-size: 1.1em;\r\n" + "    }\r\n" + "    .imageDiv\r\n" + "    {\r\n"
					+ "        display: inline-block;\r\n" + "        max-width: 300px;\r\n"
					+ "        margin: 10px;\r\n" + "    }\r\n" + "    .innerDiv .sui-combobox\r\n" + "    {\r\n"
					+ "        font-family: Arial, sans-serif;\r\n" + "        font-size: 14px;\r\n"
					+ "        margin-bottom: 10px;\r\n" + "    }\r\n" + "</style>\r\n" + "</body>\r\n" + "</html>";
			out.print(word);
		} finally {
			// out.close();
		}
		baseRequest.setHandled(true);
		return;
	}

	private void standart_kullanicinin_standart_kullanici_anamenusune_yonlendirilmesi(String target,
			Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		// Url,parametre,combobox adı sayfa linkleri gibi string değişkenler oluşturulup
		// html kod
		// arasına eklenmesi gerekmektedir.
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		try {
			String word = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
					+ "    <meta charset=\"utf-8\" />\r\n" + "    <title>JavaScript Shield UI Demos</title>\r\n"
					+sayfalar + "    <link id=\"themecss\" rel=\"stylesheet\" type=\"text/css\" href=\"//www.shieldui.com/shared/components/latest/css/light/all.min.css\" />\r\n"
					+ "    <script type=\"text/javascript\" src=\"//www.shieldui.com/shared/components/latest/js/jquery-1.11.1.min.js\"></script>\r\n"
					+ "    <script type=\"text/javascript\" src=\"//www.shieldui.com/shared/components/latest/js/shieldui-all.min.js\"></script>\r\n"
					+ "</head>\r\n" + "<body class=\"theme-light\">\r\n" + "<div>\r\n"
					+ "    <div class=\"outerDiv\">\r\n" + "        <div class=\"innerDiv\">\r\n"
					+ "            <label for=\"comboBoxStandart_anamenu_options\">Menu Seciniz</label>\r\n"
					+ "            <br />\r\n" + "            <input id=\"comboBoxStandart_anamenu_options\" />\r\n"
					+ "            <br />\r\n" + "            <button id=\"submit\">Sorgula</button>\r\n"
					+ "        </div>\r\n" + "        <div class=\"imageDiv\">\r\n"
					+ "            <img class=\"img-responsive\" src=\"/Content/img/combobox/codesnippet.png\" />\r\n"
					+ "        </div>\r\n" + "    </div>\r\n" + "</div>\r\n" + "<script type=\"text/javascript\">\r\n" +
					/* veritabanindan veri çekmek gerekiyor */
					"    var Standart_anamenu_options = ['hava_durumu', 'raporlar'];\r\n"
					+ "    jQuery(function ($) {\r\n"
					+ "        $(\"#comboBoxStandart_anamenu_options\").shieldComboBox({\r\n"
					+ "            dataSource: {\r\n" + "                data: Standart_anamenu_options\r\n"
					+ "            },\r\n" + "            autoComplete: {\r\n" + "                enabled: true\r\n"
					+ "            }\r\n" + "        });\r\n" + "        $(\"#submit\").shieldButton({\r\n"
					+ "            events: {\r\n" + "                click: function () {\r\n"
					+ "                    var Standart_anamenu_option = $(\"#comboBoxStandart_anamenu_options\").swidget().value();\r\n"
					+ "window.location.assign(\"http://localhost:8080/standart_anamenu?standart_anamenu_option=\"+Standart_anamenu_option)"
					+ "                }\r\n" + "            }\r\n" + "        });\r\n" + "    });\r\n"
					+ "</script>\r\n" + "<style>\r\n" + "    .outerDiv\r\n" + "    {\r\n"
					+ "        max-width: 600px;\r\n" + "        content: \".\";\r\n" + "        display: block;\r\n"
					+ "        overflow: hidden;\r\n" + "        margin-left: auto;\r\n"
					+ "        margin-right: auto;\r\n" + "    }\r\n" + "    .innerDiv\r\n" + "    {\r\n"
					+ "        display: inline-block;\r\n" + "        margin: 10px;\r\n" + "    }\r\n"
					+ "    .innerDiv label\r\n" + "    {\r\n" + "        font-style: italic;\r\n"
					+ "        font-size: 1.1em;\r\n" + "    }\r\n" + "    .imageDiv\r\n" + "    {\r\n"
					+ "        display: inline-block;\r\n" + "        max-width: 300px;\r\n"
					+ "        margin: 10px;\r\n" + "    }\r\n" + "    .innerDiv .sui-combobox\r\n" + "    {\r\n"
					+ "        font-family: Arial, sans-serif;\r\n" + "        font-size: 14px;\r\n"
					+ "        margin-bottom: 10px;\r\n" + "    }\r\n" + "</style>\r\n" + "</body>\r\n" + "</html>";
			out.print(word);
		} finally {
			// out.close();
		}
		baseRequest.setHandled(true);
		return;
	}

	private void adminin_admin_anamenuye_yonlendirilmesi(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// Url,parametre,combobox adı sayfa linkleri gibi string değişkenler oluşturulup
		// html kod
		// arasına eklenmesi gerekmektedir.
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.flush();
		try {
			String word = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
					+ "    <meta charset=\"utf-8\" />\r\n" + "    <title>JavaScript Shield UI Demos</title>\r\n"
					+ sayfalar+ "    <link id=\"themecss\" rel=\"stylesheet\" type=\"text/css\" href=\"//www.shieldui.com/shared/components/latest/css/light/all.min.css\" />\r\n"
					+ "    <script type=\"text/javascript\" src=\"//www.shieldui.com/shared/components/latest/js/jquery-1.11.1.min.js\"></script>\r\n"
					+ "    <script type=\"text/javascript\" src=\"//www.shieldui.com/shared/components/latest/js/shieldui-all.min.js\"></script>\r\n"
					+ "</head>\r\n" + "<body class=\"theme-light\">\r\n" + "<div>\r\n"
					+ "    <div class=\"outerDiv\">\r\n" + "        <div class=\"innerDiv\">\r\n"
					+ "            <label for=\"comboBoxAdmin_anamenu_options\">Menu Seciniz</label>\r\n"
					+ "            <br />\r\n" + "            <input id=\"comboBoxAdmin_anamenu_options\" />\r\n"
					+ "            <br />\r\n" + "            <button id=\"submit\">Sorgula</button>\r\n"
					+ "        </div>\r\n" + "        <div class=\"imageDiv\">\r\n"
					+ "            <img class=\"img-responsive\" src=\"/Content/img/combobox/codesnippet.png\" />\r\n"
					+ "        </div>\r\n" + "    </div>\r\n" + "</div>\r\n" + "<script type=\"text/javascript\">\r\n" +
					/* veritabanindan veri çekmek gerekiyor */
					"    var Admin_anamenu_options = ['lokasyon_duzenle', 'hava_durumu', 'kullanici_duzenle', 'raporlar'];\r\n"
					+ "    jQuery(function ($) {\r\n"
					+ "        $(\"#comboBoxAdmin_anamenu_options\").shieldComboBox({\r\n"
					+ "            dataSource: {\r\n" + "                data: Admin_anamenu_options\r\n"
					+ "            },\r\n" + "            autoComplete: {\r\n" + "                enabled: true\r\n"
					+ "            }\r\n" + "        });\r\n" + "        $(\"#submit\").shieldButton({\r\n"
					+ "            events: {\r\n" + "                click: function () {\r\n"
					+ "                    var Admin_anamenu_option = $(\"#comboBoxAdmin_anamenu_options\").swidget().value();\r\n"
					+ "window.location.assign(\"http://localhost:8080/admin_anamenu?admin_anamenu_option=\"+Admin_anamenu_option)"
					+ "                }\r\n" + "            }\r\n" + "        });\r\n" + "    });\r\n"
					+ "</script>\r\n" + "<style>\r\n" + "    .outerDiv\r\n" + "    {\r\n"
					+ "        max-width: 600px;\r\n" + "        content: \".\";\r\n" + "        display: block;\r\n"
					+ "        overflow: hidden;\r\n" + "        margin-left: auto;\r\n"
					+ "        margin-right: auto;\r\n" + "    }\r\n" + "    .innerDiv\r\n" + "    {\r\n"
					+ "        display: inline-block;\r\n" + "        margin: 10px;\r\n" + "    }\r\n"
					+ "    .innerDiv label\r\n" + "    {\r\n" + "        font-style: italic;\r\n"
					+ "        font-size: 1.1em;\r\n" + "    }\r\n" + "    .imageDiv\r\n" + "    {\r\n"
					+ "        display: inline-block;\r\n" + "        max-width: 300px;\r\n"
					+ "        margin: 10px;\r\n" + "    }\r\n" + "    .innerDiv .sui-combobox\r\n" + "    {\r\n"
					+ "        font-family: Arial, sans-serif;\r\n" + "        font-size: 14px;\r\n"
					+ "        margin-bottom: 10px;\r\n" + "    }\r\n" + "</style>\r\n" + "</body>\r\n" + "</html>";
			out.print(word);
		} finally {
			// out.close();
		}
		baseRequest.setHandled(true);
		return;
	}

	static String str = "jdbc:sqlserver://localhost:1433;databaseName=OHDS;user=sa;password=123456";

	// sa yerine db user eklenmeli.
	// kullanıcı eklendiğinde db bağlantı adı db user adı ile gerçekleşmeli

	private int kullanici_adinin_ve_sifresinin_kontrol_edilmesi(String kullanici_adi, String sifre) {
		int kullanici_tipi = -1;// root=0,admin=1,standart=2,ziyaretçi=3
		try {
			// String server = "localhost";
			// String database = "OHDS";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(str);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sorgu = "";
		sorgu = "SELECT Person_Id, kullanici_adi, sifre, kullanici_tipi FROM dbo.PERSON" + " WHERE kullanici_adi = '"
				+ kullanici_adi + "' and sifre = '" + sifre + "'";
		// + " WHERE kullanici_adi = "+kullanici_adi+" and sifre = "+password
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet resultset = null;
		try {
			resultset = statement.executeQuery(sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		} // SQLException
		try {
			while (resultset.next()) {
				try {
					System.out.println("Person_Id:" + resultset.getString("Person_Id") + "kullanici_adi:"
							+ resultset.getString("kullanici_adi") + "sifre:" + resultset.getString("sifre")
							+ "kullanici_tipi:" + resultset.getString("kullanici_tipi"));
				} catch (SQLException e) {

					e.printStackTrace();
				}
				try {
					kullanici_tipi = Integer.parseInt(resultset.getString("kullanici_tipi"));
				} catch (NumberFormatException e) {

					e.printStackTrace();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (kullanici_tipi > 0) {
				return kullanici_tipi;
			} else {
				// ziyaretçi bulunamadı
				kullanici_tipi = 3;
				System.out.println("kullanıcı veritabanında bulunamadı.");
				return kullanici_tipi;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*
		 * en fazla 1 tane kullanıcının geri dönmesi gerekmektedir. birden fazla
		 * kullanıcı geri dönerse veritabanında hata var demektir ve de veri tabanının
		 * sadece admin ve standart kullanıcı tiplerinde kullanıcı kabul edecek şekilde
		 * tasarlanması gerekmektedir.
		 */
		return kullanici_tipi;
	}

	byte[] _favicon;
	boolean _serveIcon = true;

	public Request_Handler() {
		try {
			URL fav = this.getClass().getClassLoader().getResource("./ohds/favicon.ico");
			if (fav != null) {
				_favicon = IO.readBytes(fav.openStream());
			} else {
				// favicon resmi img klasorunde yok
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Log.warn(e);
		}
	}

	/**
	 * @return the htmlcodeprinterofhost
	 */
	public static HtmlCodePrinterofHost getHtmlcodeprinterofhost() {
		return htmlcodeprinterofhost;
	}

	/**
	 * @param htmlcodeprinterofhost
	 *            the htmlcodeprinterofhost to set
	 */
	public static void setHtmlcodeprinterofhost(HtmlCodePrinterofHost htmlcodeprinterofhost) {
		Request_Handler.htmlcodeprinterofhost = htmlcodeprinterofhost;
	}
}