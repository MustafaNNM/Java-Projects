
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
	private int kullanici_tipi = -1;
	private PrintWriter out = null;
	private String requestURI = "";
	private Enumeration<String> parameterNames;
	private String name = "";
	private String value = "";
	private String kullanici_adi = "";
	private String sifre = "";
	private String admin_anamenu_option = "";
	private String admin_anamenu_kullanici_duzenle_option = "";
	private String admin_anamenu_lokasyon_duzenle_option = "";
	private String standart_anamenu_option = "";
	private Boolean kullanici_adi_parametre_varmi = false;
	private Boolean admin_anamenu_option_parametre_varmi = false;
	private Boolean admin_anamenu_kullanici_duzenle_option_parametre_varmi = false;
	private Boolean admin_anamenu_lokasyon_duzenle_option_parametre_varmi = false;
	private Boolean sifre_parametre_varmi = false;
	private Boolean standart_anamenu_option_parametre_varmi = false;
	private String sayfalar = "<a href=\"http://localhost:8080/anasayfa\">Anasayfa</a>\r\n"
			+ "<a href=\"http://localhost:8080/login\">Login</a>\r\n"
			+ "<a href=\"http://localhost:8080/admin_anamenu\">Admin Anamenu</a>\r\n"
			+ "<a href=\"http://localhost:8080/standart_anamenu\">Standart Anamenu</a>\r\n"
			+ "<a href=\"http://localhost:8080/admin_anamenu/lokasyon_duzenle\">/Lokasyon Duzenle</a>\r\n"
			+ "<a href=\"http://localhost:8080/admin_anamenu/kullanici_duzenle\">/Kullanici Duzenle</a>\r\n"
			+ "<a href=\"http://localhost:8080/admin_anamenu/hava_durumu\">/Admin Hava Durumu</a>\r\n"
			+ "<a href=\"http://localhost:8080/admin_anamenu/raporlar\">/Admin Raporlar</a>\r\n"
			+ "<a href=\"http://localhost:8080/standart_anamenu/hava_durumu\">/Standart Hava Durumu</a>\r\n"
			+ "<a href=\"http://localhost:8080/standart_anamenu/raporlar\">/Standart Raporlar</a>\r\n" + "<br>"
			+ "<a href=\"http://localhost:8080/admin_anamenu/kullanici_duzenle/kullanici_listeleme\">/Kullanici Listeleme</a>\r\n"
			+ "<a href=\"http://localhost:8080/admin_anamenu/kullanici_duzenle/kullanici_ekleme\">/Kullanici Ekleme</a>\r\n"
			+ "<a href=\"http://localhost:8080/admin_anamenu/kullanici_duzenle/kullanici_guncelleme\">/Kullanici Guncelleme</a>\r\n"
			+ "<a href=\"http://localhost:8080/admin_anamenu/kullanici_duzenle/kullanici_silme\">/Kullanici Silme</a>\r\n"
			+ "<a href=\"http://localhost:8080/admin_anamenu/lokasyon_duzenle/lokasyon_listeleme\">/Lokasyon Listeleme</a>\r\n"
			+ "<a href=\"http://localhost:8080/admin_anamenu/lokasyon_duzenle/lokasyon_ekleme\">/Lokasyon Ekleme</a>\r\n"
			+ "<a href=\"http://localhost:8080/admin_anamenu/lokasyon_duzenle/lokasyon_guncelleme\">/Lokasyon Guncelleme</a>\r\n"
			+ "<a href=\"http://localhost:8080/admin_anamenu/lokasyon_duzenle/lokasyon_silme\">/Lokasyon Silme</a>\r\n"
			+ "<br>";// admin_anamenu/hava_durumu

	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		requestURI = "";
		name = "";
		value = "";
		kullanici_adi = "";
		sifre = "";
		admin_anamenu_option = "";
		admin_anamenu_kullanici_duzenle_option = "";
		admin_anamenu_lokasyon_duzenle_option = "";
		standart_anamenu_option = "";
		kullanici_adi_parametre_varmi = false;
		admin_anamenu_option_parametre_varmi = false;
		admin_anamenu_kullanici_duzenle_option_parametre_varmi = false;
		admin_anamenu_lokasyon_duzenle_option_parametre_varmi = false;
		sifre_parametre_varmi = false;
		standart_anamenu_option_parametre_varmi = false;
		System.out.println("DEBUG:1");
		// requestin işlenmesi
		// root=0,admin=1,standart=2,ziyaretçi=3
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		out = response.getWriter();
		requestURI = request.getRequestURI();
		parametrelerin_ayrilmasi(baseRequest, request, response);
		requeste_gore_sayfalarin_yuklenmesi(target, baseRequest, request, response);
		out.close();
		baseRequest.setHandled(true);
		return;
	}

	/**
	 * @param baseRequest
	 * @param request
	 * @param response
	 */
	private void parametrelerin_ayrilmasi(Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("DEBUG:2");

		parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			try {
				name = (String) parameterNames.nextElement();
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
			value = request.getParameter(name).toString();
			System.out.println(String.format("%s==%s\n", name, value));
			if (name.equals("kullanici_adi")) {
				try {
					kullanici_adi = request.getParameter(name);
					kullanici_adi_parametre_varmi = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				if (name.equals("sifre")) {
					try {
						sifre = request.getParameter(name);
						sifre_parametre_varmi = true;
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					if (name.equals("admin_anamenu_option")) {
						try {
							admin_anamenu_option = request.getParameter(name);
							admin_anamenu_option_parametre_varmi = true;
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						if (name.equals("admin_anamenu_kullanici_duzenle_option")) {
							try {
								admin_anamenu_kullanici_duzenle_option = request.getParameter(name);
								admin_anamenu_kullanici_duzenle_option_parametre_varmi = true;
							} catch (Exception e) {
								e.printStackTrace();
							}
						} else {
							if (name.equals("admin_anamenu_lokasyon_duzenle_option")) {
								try {
									admin_anamenu_lokasyon_duzenle_option = request.getParameter(name);
									admin_anamenu_lokasyon_duzenle_option_parametre_varmi = true;
								} catch (Exception e) {
									e.printStackTrace();
								}
							} else {
								if (name.equals("standart_anamenu_option")) {
									try {
										standart_anamenu_option = request.getParameter(name);
										standart_anamenu_option_parametre_varmi = true;
									} catch (Exception e) {
										e.printStackTrace();
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
	 * @throws IOException
	 */
	private void requeste_gore_sayfalarin_yuklenmesi(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		System.out.println("DEBUG:3");

		if (requestURI.equals("/anasayfa")) {
			// Kullanıcı anasayfaya girmek isterse
			ana_sayfanin_yukenmesi(target, baseRequest, request, response);
		} else {
			if (requestURI.equals("/login")
					&& (kullanici_adi_parametre_varmi == false || sifre_parametre_varmi == false)) {
				login_sayfasinin_yuklenmesi(target, baseRequest, request, response);
			} else {
				// Kullanıcı login sayfasına girmek isterse
				if (requestURI.equals("/login") && kullanici_adi_parametre_varmi == true
						&& sifre_parametre_varmi == true) {
					// parametre var
					kullanici_tipi = kullanici_adinin_ve_sifresinin_kontrol_edilmesi(kullanici_adi, sifre);
					kullanici_tipine_gore_menuye_yonlendir(target, baseRequest, request, response);
				} else {
					if (requestURI.equals("/admin_anamenu") && (kullanici_tipi == 0 || kullanici_tipi == 1)) {
						// admin_menu_option
						// yetki var
						if (admin_anamenu_option_parametre_varmi == true) {
							// adminin anamenu secimine gore alt sayfaya gonderilmesi
							adminin_admin_anamenu_optiona_gore_alt_sayfaya_yonlendirilmesi(baseRequest, response);
						} else {// parametre yok
							// yetki var
							admin_anamenu_sayfasinin_yuklenmesi(target, baseRequest, request, response);
						}
					} else {
						if (requestURI.equals("/admin_anamenu/lokasyon_duzenle")
								&& (kullanici_tipi == 0 || kullanici_tipi == 1)
								&& (kullanici_tipi == 0 || kullanici_tipi == 1)) {
							// lokasyon_duzenle
							// yetki var
							if (admin_anamenu_lokasyon_duzenle_option_parametre_varmi == true) {
								// yetki var
								// parametre var
								// adminin kullanici duzenleme secimine gore alt sayfaya gonderilmesi
								adminin_admin_anamenu_lokasyon_duzenle_optiona_gore_alt_sayfaya_gonderilmesi(
										baseRequest, response);
							} else {
								// parametre yok
								// yetki var
								adminin_admin_anamenu_lokasyon_duzenleme_sayfasinin_yuklenmesi(target, baseRequest,
										request, response);
							}
						} else {
							if (requestURI.equals("/admin_anamenu/hava_durumu")
									&& (kullanici_tipi == 0 || kullanici_tipi == 1)) {
								// hava_durumu
								// yetki var
								// comboboxtan secim yapılması gerekiyor önce lokasyon ekleme işlemlerin
								// yapılması gerekiyor.
								// comboboxta veri varsa seçim yapılması gerekiyor.
								// düzenleme aşamasında
								admin_anamenu_hava_durumu_sayfasinin_yuklenmesi(target, baseRequest, request, response);
							} else {
								if (requestURI.equals("/admin_anamenu/kullanici_duzenle")
										&& (kullanici_tipi == 0 || kullanici_tipi == 1)) {
									// kullanici_duzenle
									// yetki var
									if (admin_anamenu_kullanici_duzenle_option_parametre_varmi == true) {
										// adminin kullanici duzenleme secimine gore alt sayfaya gonderilmesi
										adminin_admin_anamenu_kullanici_duzenle_optiona_gore_alt_sayfaya_yonlendirilmesi(
												baseRequest, response);
									} else {
										// parapetre yok
										// yetki var
										adminin_admin_anamenu_kullanici_duzenle_sayfasinin_yuklenmesi(target,
												baseRequest, request, response);
									}
								} else {
									if (requestURI.equals("/admin_anamenu/raporlar")
											&& (kullanici_tipi == 0 || kullanici_tipi == 1)) {
										// kullanici_duzenle
										// yetki var
										// raporlar kısmı düzenleme aşamasında
										admin_anamenu_raporlar_sayfasinin_yuklenmesi(target, baseRequest, request,
												response);
									} else {
										if (requestURI.equals("/admin_anamenu/kullanici_duzenle/kullanici_ekleme")
												&& (kullanici_tipi == 0 || kullanici_tipi == 1)) {
											// yetki var
											// düzenleme aşamasında
											admin_anamenu_kullanici_duzenle_kullanici_ekleme_sayfasinin_yuklenmesi(
													target, baseRequest, request, response);
										} else {
											if (requestURI
													.equals("/admin_anamenu/kullanici_duzenle/kullanici_guncelleme")
													&& (kullanici_tipi == 0 || kullanici_tipi == 1)) {
												// yetki var
												// düzenleme aşamasında
												// root kontrol işlemi gerekiyor
												admin_anamenu_kullanici_duzenle_kullanici_guncelleme_sayfasinin_yuklenmesi(
														target, baseRequest, request, response);
											} else {
												if (requestURI.equals("/admin_anamenu/kullanici_duzenle/kulanici_silme")
														&& (kullanici_tipi == 0 || kullanici_tipi == 1)) {
													// yetki var
													// düzenleme aşamasında
													// root kontrol işlemi gerekiyor
													admin_anamenu_kullanici_duzenle_kulanici_silme_sayfasinin_yuklenmesi(
															target, baseRequest, request, response);
												} else {
													if (requestURI.equals(
															"/admin_anamenu/kullanici_duzenle/kullanici_listeleme")
															&& (kullanici_tipi == 0 || kullanici_tipi == 1)) {
														// yetki var
														admin_anamenu_kullanici_duzenle_kullanici_listeleme_sayfasinin_yuklenmesi(
																target, baseRequest, request, response);
													} else {
														if (_serveIcon && _favicon != null
																&& requestURI.equals("/favicon.ico")) {
															// parametre ve yetki gerektirmiyor
															faviconun_yuklenmesi(baseRequest, response);
														} else {
															if (requestURI.equals(
																	"/admin_anamenu/lokasyon_duzenle/lokasyon_listeleme")
																	&& (kullanici_tipi == 0 || kullanici_tipi == 1)) {
																// admin_anamenu_lokasyon_duzenle_options =
																// ['lokasyon_ekleme',
																// 'lokasyon_guncelleme', 'lokasyon_silme',
																// 'lokasyon_listeleme']
																// yetki var
																// düzenlenme aşamasında
																admin_anamenu_lokasyon_duzenle_lokasyon_listeleme_sayfasinin_yuklenmesi(
																		target, baseRequest, request, response);
															} else {
																if (requestURI.equals(
																		"/admin_anamenu/lokasyon_duzenle/lokasyon_ekleme")
																		&& (kullanici_tipi == 0
																				|| kullanici_tipi == 1)) {
																	// yetki var
																	// düzenlenme aşamasında
																	admin_anamenu_lokasyon_duzenle_lokasyon_ekleme_sayfasinin_yuklenmesi(
																			target, baseRequest, request, response);
																} else {
																	if (requestURI.equals(
																			"/admin_anamenu/lokasyon_duzenle/lokasyon_silme")
																			&& (kullanici_tipi == 0
																					|| kullanici_tipi == 1)) {
																		// yetki var
																		// düzenlenme aşamasında
																		admin_anamenu_lokasyon_duzenle_lokasyon_silme_sayfasinin_yuklenmesi(
																				target, baseRequest, request, response);
																	} else {
																		if (requestURI.equals(
																				"/admin_anamenu/lokasyon_duzenle/lokasyon_guncelleme")
																				&& (kullanici_tipi == 0
																						|| kullanici_tipi == 1)) {
																			// yetki var
																			// düzenlenme aşamasında
																			admin_anamenu_lokasyon_duzenle_lokasyon_guncelleme_sayfasinin_yuklenmesi(
																					target, baseRequest, request,
																					response);
																		} else {
																			if (requestURI.equals("/standart_anamenu")
																					&& kullanici_tipi == 2) {// standart_menu_option
																				// standart kullanıcı yetkisi var
																				if (standart_anamenu_option_parametre_varmi == true) {
																					// parametre var
																					// standart kullanıcının standart
																					// anamenu secimine gore alt
																					// sayfaya gonderilmesi
																					standart_kullanicinin_standart_anamenu_optiona_gore_alt_sayfaya_yonlendirilmesi(
																							baseRequest, response);
																				} else {
																					// standart menüye yönlendir
																					standart_anamenu_sayfasinin_yuklenmesi(
																							target, baseRequest,
																							request, response);
																				}
																			} else {
																				if (requestURI.equals(
																						"/standart_anamenu/hava_durumu")
																						&& kullanici_tipi == 2) {
																					// hava_durumu
																					// yetki var
																					// düzenlenme aşamasında
																					standart_anamenu_hava_durumu_sayfasinin_yuklenmesi(
																							target, baseRequest,
																							request, response);
																				} else {
																					if (requestURI.equals(
																							"/standart_anamenu/raporlar")
																							&& kullanici_tipi == 2) {
																						// yetki var
																						// raporlar
																						// düzenlenme aşamasında
																						standart_anamenu_raporlar_sayfasinin_yuklenmesi(
																								target, baseRequest,
																								request, response);
																					} else {
																						if (requestURI.equals(
																								"/standart_anamenu")
																								&& kullanici_tipi == 1) {// standart_menu_option
																							// standart kullanıcı
																							// yetkisi var
																							if (admin_anamenu_option_parametre_varmi == true) {
																								// parametre var
																								// adminin admin
																								// anamenu secimine gore
																								// alt
																								// sayfaya gonderilmesi
																								adminin_admin_anamenu_optiona_gore_alt_sayfaya_yonlendirilmesi(
																										baseRequest,
																										response);
																							} else {
																								// admin menüye
																								// yönlendir
																								adminin_admin_anamenuye_yonlendirilmesi(
																										target,
																										baseRequest,
																										request,
																										response);
																							}
																						} else {
																							if (requestURI.equals(
																									"/standart_anamenu/raporlar")
																									&& kullanici_tipi == 1) {
																								// yetki var
																								// raporlar
																								// düzenlenme aşamasında
																								adminin_admin_anamenu_raporlar_sayfasina_yonlendirilmesi(
																										target,
																										baseRequest,
																										request,
																										response);
																							} else {// sayfa bulunamadı
																									// yada
																									// yetkisiz
																									// kullanıcı
																									// request var
																								ziyaretcinin_anasayfaya_yonlendirilmesi(
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

	private void adminin_admin_anamenu_raporlar_sayfasina_yonlendirilmesi(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("/admin_anamenu/raporlar");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @param out
	 */
	private void ana_sayfanin_yukenmesi(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("DEBUG:4");
		out.flush();
		out.print(sayfalar);
	}

	/**
	 * @param target
	 * @param baseRequest
	 * @param request
	 * @param response
	 */
	private void kullanici_tipine_gore_menuye_yonlendir(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("DEBUG:11");
		if (kullanici_tipi == 0 || kullanici_tipi == 1) {
			// response_redirect yapılması gerekiyor
			adminin_admin_anamenuye_yonlendirilmesi(target, baseRequest, request, response);
		} else {
			// response redirect gerekiyor
			standart_menuye_yada_logine_yonlendir(target, baseRequest, request, response);
		}
	}

	/**
	 * @param out
	 */
	private void login_sayfasinin_yuklenmesi(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("DEBUG:5");
		String word = sayfalar + "        <form method=\"post\" action=\"login\">\r\n"
				+ "        Kullanici Adi:<input type=\"text\" name=\"kullanici_adi\" /><br/>\r\n"
				+ "        Sifre        :<input type=\"text\" name=\"sifre\" /><br/>\r\n"
				+ "        <input type=\"submit\" value=\"login\" />\r\n" + "        </form>\r\n";
		out.print(word);
	}

	// sa yerine db user eklenmeli.
	// kullanıcı eklendiğinde db bağlantı adı db user adı ile gerçekleşmeli

	private int kullanici_adinin_ve_sifresinin_kontrol_edilmesi(String kullanici_adi, String sifre) {
		System.out.println("DEBUG:6");
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

	private String veritabanindan_kullanicilari_listele() {
		System.out.println("DEBUG:7");
		String sorgu_sonuc = "";
		if (kullanici_tipi == 0 || kullanici_tipi == 1) {
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

			sorgu = "SELECT Person_Id, kullanici_adi, sifre, kullanici_tipi FROM dbo.PERSON";
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
						sorgu_sonuc += "Person_Id:" + resultset.getString("Person_Id") + "kullanici_adi:"
								+ resultset.getString("kullanici_adi") + "sifre:" + resultset.getString("sifre")
								+ "kullanici_tipi:" + resultset.getString("kullanici_tipi") + "<br>";
					} catch (SQLException e) {

						e.printStackTrace();
					}
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
			return sorgu_sonuc;
		} else {
			return sorgu_sonuc;
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
		System.out.println("DEBUG:8");
		if (kullanici_tipi == 2) {
			// response redirect gerekiyor
			standart_kullanicinin_standart_anamenuye_yonlendirilmesi(baseRequest, response);
		} else {
			// response redirect gerekiyor
			// ziyaretçinin login sayfasına yönlendirilmesi
			ziyaretcinin_logine_yonlendirilmesi(baseRequest, response);
		}
	}

	/**
	 * @param baseRequest
	 * @param response
	 */
	private void ziyaretcinin_logine_yonlendirilmesi(Request baseRequest, HttpServletResponse response) {
		System.out.println("DEBUG:9");
		try {
			response.sendRedirect("/login");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param baseRequest
	 * @param response
	 */
	private void standart_kullanicinin_standart_anamenuye_yonlendirilmesi(Request baseRequest,
			HttpServletResponse response) {
		System.out.println("DEBUG:10");
		try {
			response.sendRedirect("/standart_anamenu");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param target
	 * @param baseRequest
	 * @param request
	 * @param response
	 */
	private void adminin_admin_anamenuye_yonlendirilmesi(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("DEBUG:12");
		try {
			response.sendRedirect("/admin_anamenu");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void standart_anamenu_raporlar_sayfasinin_yuklenmesi(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DEBUG:13");
		ana_sayfanin_yukenmesi(target, baseRequest, request, response);
	}

	private void standart_anamenu_hava_durumu_sayfasinin_yuklenmesi(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DEBUG:14");
		ana_sayfanin_yukenmesi(target, baseRequest, request, response);
	}

	private void standart_kullanicinin_standart_anamenu_optiona_gore_alt_sayfaya_yonlendirilmesi(Request baseRequest,
			HttpServletResponse response) {
		System.out.println("DEBUG:15");
		try {
			response.sendRedirect("/standart_anamenu/" + standart_anamenu_option);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// standart_anamenu_options = [
		// 'hava_durumu', 'raporlar']
	}

	private void admin_anamenu_lokasyon_duzenle_lokasyon_guncelleme_sayfasinin_yuklenmesi(String target,
			Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DEBUG:16");
		ana_sayfanin_yukenmesi(target, baseRequest, request, response);
	}

	private void admin_anamenu_lokasyon_duzenle_lokasyon_silme_sayfasinin_yuklenmesi(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DEBUG:17");
		ana_sayfanin_yukenmesi(target, baseRequest, request, response);
	}

	private void admin_anamenu_lokasyon_duzenle_lokasyon_ekleme_sayfasinin_yuklenmesi(String target,
			Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		ana_sayfanin_yukenmesi(target, baseRequest, request, response);
	}

	private void admin_anamenu_lokasyon_duzenle_lokasyon_listeleme_sayfasinin_yuklenmesi(String target,
			Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DEBUG:19");
		ana_sayfanin_yukenmesi(target, baseRequest, request, response);
	}

	private void admin_anamenu_kullanici_duzenle_kullanici_listeleme_sayfasinin_yuklenmesi(String target,
			Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DEBUG:20");
		// yapıldı
		ana_sayfanin_yukenmesi(target, baseRequest, request, response);
		out.print(veritabanindan_kullanicilari_listele());
	}

	private void admin_anamenu_kullanici_duzenle_kulanici_silme_sayfasinin_yuklenmesi(String target,
			Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DEBUG:21");
		ana_sayfanin_yukenmesi(target, baseRequest, request, response);
	}

	private void admin_anamenu_kullanici_duzenle_kullanici_guncelleme_sayfasinin_yuklenmesi(String target,
			Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DEBUG:22");
		ana_sayfanin_yukenmesi(target, baseRequest, request, response);
	}

	private void admin_anamenu_kullanici_duzenle_kullanici_ekleme_sayfasinin_yuklenmesi(String target,
			Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DEBUG:23");
		ana_sayfanin_yukenmesi(target, baseRequest, request, response);
	}

	private void admin_anamenu_raporlar_sayfasinin_yuklenmesi(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DEBUG:24");
		ana_sayfanin_yukenmesi(target, baseRequest, request, response);
	}

	private void admin_anamenu_hava_durumu_sayfasinin_yuklenmesi(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DEBUG:25");
		ana_sayfanin_yukenmesi(target, baseRequest, request, response);
	}

	/**
	 * @param baseRequest
	 * @param response
	 */
	private void adminin_admin_anamenu_kullanici_duzenle_optiona_gore_alt_sayfaya_yonlendirilmesi(Request baseRequest,
			HttpServletResponse response) {
		System.out.println("DEBUG:26");
		try {
			response.sendRedirect("/admin_anamenu/kullanici_duzenle/" + admin_anamenu_kullanici_duzenle_option);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// admin_anamenu_kullanici_duzenle_options = ['kullanici_ekleme',
		// 'kullanici_guncelleme', 'kulanici_silme', 'kullanici_listeleme']
	}

	/**
	 * @param baseRequest
	 * @param response
	 */
	private void adminin_admin_anamenu_optiona_gore_alt_sayfaya_yonlendirilmesi(Request baseRequest,
			HttpServletResponse response) {
		System.out.println("DEBUG:27");
		try {
			response.sendRedirect("/admin_anamenu/" + admin_anamenu_option);// IllegalStateException
		} catch (IllegalStateException e) {
			e.printStackTrace();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// admin_anamenu_options = ['lokasyon_duzenle', 'hava_durumu',
		// 'kullanici_duzenle', 'raporlar']
	}

	/**
	 * @param baseRequest
	 * @param response
	 */
	private void adminin_admin_anamenu_lokasyon_duzenle_optiona_gore_alt_sayfaya_gonderilmesi(Request baseRequest,
			HttpServletResponse response) {
		System.out.println("DEBUG:28");
		try {
			response.sendRedirect("/admin_anamenu/lokasyon_duzenle/" + admin_anamenu_lokasyon_duzenle_option);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// admin_anamenu_lokasyon_duzenle_options = ['lokasyon_ekleme',
		// 'lokasyon_guncelleme', 'lokasyon_silme', 'lokasyon_listeleme']
	}

	private void adminin_admin_anamenu_lokasyon_duzenleme_sayfasinin_yuklenmesi(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DEBUG:29");
		// Url,parametre,combobox adı sayfa linkleri gibi string değişkenler oluşturulup
		// html kod
		// arasına eklenmesi gerekmektedir.
		String word = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
				+ "    <meta charset=\"utf-8\" />\r\n" + "    <title>Lokasyon Duzenleme</title>\r\n" + sayfalar
				+ "    <link id=\"themecss\" rel=\"stylesheet\" type=\"text/css\" href=\"//www.shieldui.com/shared/components/latest/css/light/all.min.css\" />\r\n"
				+ "    <script type=\"text/javascript\" src=\"//www.shieldui.com/shared/components/latest/js/jquery-1.11.1.min.js\"></script>\r\n"
				+ "    <script type=\"text/javascript\" src=\"//www.shieldui.com/shared/components/latest/js/shieldui-all.min.js\"></script>\r\n"
				+ "</head>\r\n" + "<body class=\"theme-light\">\r\n" + "<div>\r\n" + "    <div class=\"outerDiv\">\r\n"
				+ "        <div class=\"innerDiv\">\r\n"
				+ "            <label for=\"comboBoxAdmin_anamenu_lokasyon_duzenle_options\">Menu Seciniz</label>\r\n"
				+ "            <br />\r\n"
				+ "            <input id=\"comboBoxAdmin_anamenu_lokasyon_duzenle_options\" />\r\n"
				+ "            <br />\r\n" + "            <button id=\"submit\">Sorgula</button>\r\n"
				+ "        </div>\r\n" + "        <div class=\"imageDiv\">\r\n"
				+ "            <img class=\"img-responsive\" src=\"/Content/img/combobox/codesnippet.png\" />\r\n"
				+ "        </div>\r\n" + "    </div>\r\n" + "</div>\r\n" + "<script type=\"text/javascript\">\r\n" +
				/* veritabanindan veri çekmek gerekiyor */
				"    var Admin_anamenu_lokasyon_duzenle_options = ['lokasyon_listeleme', 'lokasyon_silme', 'lokasyon_ekleme', 'lokasyon_guncelleme'];\r\n"
				+ "    jQuery(function ($) {\r\n"
				+ "        $(\"#comboBoxAdmin_anamenu_lokasyon_duzenle_options\").shieldComboBox({\r\n"
				+ "            dataSource: {\r\n" + "                data: Admin_anamenu_lokasyon_duzenle_options\r\n"
				+ "            },\r\n" + "            autoComplete: {\r\n" + "                enabled: true\r\n"
				+ "            }\r\n" + "        });\r\n" + "        $(\"#submit\").shieldButton({\r\n"
				+ "            events: {\r\n" + "                click: function () {\r\n"
				+ "                    var Admin_anamenu_lokasyon_duzenle_option = $(\"#comboBoxAdmin_anamenu_lokasyon_duzenle_options\").swidget().value();\r\n"
				+ "window.location.assign(\"http://localhost:8080/admin_anamenu/lokasyon_duzenle?admin_anamenu_lokasyon_duzenle_option=\"+Admin_anamenu_lokasyon_duzenle_option)"
				+ "                }\r\n" + "            }\r\n" + "        });\r\n" + "    });\r\n" + "</script>\r\n"
				+ "<style>\r\n" + "    .outerDiv\r\n" + "    {\r\n" + "        max-width: 600px;\r\n"
				+ "        content: \".\";\r\n" + "        display: block;\r\n" + "        overflow: hidden;\r\n"
				+ "        margin-left: auto;\r\n" + "        margin-right: auto;\r\n" + "    }\r\n"
				+ "    .innerDiv\r\n" + "    {\r\n" + "        display: inline-block;\r\n" + "        margin: 10px;\r\n"
				+ "    }\r\n" + "    .innerDiv label\r\n" + "    {\r\n" + "        font-style: italic;\r\n"
				+ "        font-size: 1.1em;\r\n" + "    }\r\n" + "    .imageDiv\r\n" + "    {\r\n"
				+ "        display: inline-block;\r\n" + "        max-width: 300px;\r\n" + "        margin: 10px;\r\n"
				+ "    }\r\n" + "    .innerDiv .sui-combobox\r\n" + "    {\r\n"
				+ "        font-family: Arial, sans-serif;\r\n" + "        font-size: 14px;\r\n"
				+ "        margin-bottom: 10px;\r\n" + "    }\r\n" + "</style>\r\n" + "</body>\r\n" + "</html>";
		out.print(word);
	}

	private void ziyaretcinin_anasayfaya_yonlendirilmesi(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("DEBUG:30");
		try {
			response.sendRedirect("/anasayfa");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void adminin_admin_anamenu_kullanici_duzenle_sayfasinin_yuklenmesi(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DEBUG:31");
		// Url,parametre,combobox adı sayfa linkleri gibi string değişkenler oluşturulup
		// html kod
		// arasına eklenmesi gerekmektedir.
		String word = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
				+ "    <meta charset=\"utf-8\" />\r\n" + "    <title>Kullanici Duzenleme</title>\r\n" + sayfalar
				+ "    <link id=\"themecss\" rel=\"stylesheet\" type=\"text/css\" href=\"//www.shieldui.com/shared/components/latest/css/light/all.min.css\" />\r\n"
				+ "    <script type=\"text/javascript\" src=\"//www.shieldui.com/shared/components/latest/js/jquery-1.11.1.min.js\"></script>\r\n"
				+ "    <script type=\"text/javascript\" src=\"//www.shieldui.com/shared/components/latest/js/shieldui-all.min.js\"></script>\r\n"
				+ "</head>\r\n" + "<body class=\"theme-light\">\r\n" + "<div>\r\n" + "    <div class=\"outerDiv\">\r\n"
				+ "        <div class=\"innerDiv\">\r\n"
				+ "            <label for=\"comboBoxAdmin_anamenu_kullanici_duzenle_options\">Menu Seciniz</label>\r\n"
				+ "            <br />\r\n"
				+ "            <input id=\"comboBoxAdmin_anamenu_kullanici_duzenle_options\" />\r\n"
				+ "            <br />\r\n" + "            <button id=\"submit\">Sorgula</button>\r\n"
				+ "        </div>\r\n" + "        <div class=\"imageDiv\">\r\n"
				+ "            <img class=\"img-responsive\" src=\"/Content/img/combobox/codesnippet.png\" />\r\n"
				+ "        </div>\r\n" + "    </div>\r\n" + "</div>\r\n" + "<script type=\"text/javascript\">\r\n" +
				/* veritabanindan veri çekmek gerekiyor */
				"    var Admin_anamenu_kullanici_duzenle_options = ['kullanici_listeleme', 'kullanici_silme', 'kullanici_ekleme', 'kullanici_guncelleme'];\r\n"
				+ "    jQuery(function ($) {\r\n"
				+ "        $(\"#comboBoxAdmin_anamenu_kullanici_duzenle_options\").shieldComboBox({\r\n"
				+ "            dataSource: {\r\n" + "                data: Admin_anamenu_kullanici_duzenle_options\r\n"
				+ "            },\r\n" + "            autoComplete: {\r\n" + "                enabled: true\r\n"
				+ "            }\r\n" + "        });\r\n" + "        $(\"#submit\").shieldButton({\r\n"
				+ "            events: {\r\n" + "                click: function () {\r\n"
				+ "                    var Admin_anamenu_kullanici_duzenle_option = $(\"#comboBoxAdmin_anamenu_kullanici_duzenle_options\").swidget().value();\r\n"
				+ "window.location.assign(\"http://localhost:8080/admin_anamenu/kullanici_duzenle?admin_anamenu_kullanici_duzenle_option=\"+Admin_anamenu_kullanici_duzenle_option)"
				+ "                }\r\n" + "            }\r\n" + "        });\r\n" + "    });\r\n" + "</script>\r\n"
				+ "<style>\r\n" + "    .outerDiv\r\n" + "    {\r\n" + "        max-width: 600px;\r\n"
				+ "        content: \".\";\r\n" + "        display: block;\r\n" + "        overflow: hidden;\r\n"
				+ "        margin-left: auto;\r\n" + "        margin-right: auto;\r\n" + "    }\r\n"
				+ "    .innerDiv\r\n" + "    {\r\n" + "        display: inline-block;\r\n" + "        margin: 10px;\r\n"
				+ "    }\r\n" + "    .innerDiv label\r\n" + "    {\r\n" + "        font-style: italic;\r\n"
				+ "        font-size: 1.1em;\r\n" + "    }\r\n" + "    .imageDiv\r\n" + "    {\r\n"
				+ "        display: inline-block;\r\n" + "        max-width: 300px;\r\n" + "        margin: 10px;\r\n"
				+ "    }\r\n" + "    .innerDiv .sui-combobox\r\n" + "    {\r\n"
				+ "        font-family: Arial, sans-serif;\r\n" + "        font-size: 14px;\r\n"
				+ "        margin-bottom: 10px;\r\n" + "    }\r\n" + "</style>\r\n" + "</body>\r\n" + "</html>";
		out.print(word);
	}

	private void standart_anamenu_sayfasinin_yuklenmesi(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("DEBUG:32");
		// Url,parametre,combobox adı sayfa linkleri gibi string değişkenler oluşturulup
		// html kod
		// arasına eklenmesi gerekmektedir.
		String word = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
				+ "    <meta charset=\"utf-8\" />\r\n" + "    <title>Standart Anamenu</title>\r\n" + sayfalar
				+ "    <link id=\"themecss\" rel=\"stylesheet\" type=\"text/css\" href=\"//www.shieldui.com/shared/components/latest/css/light/all.min.css\" />\r\n"
				+ "    <script type=\"text/javascript\" src=\"//www.shieldui.com/shared/components/latest/js/jquery-1.11.1.min.js\"></script>\r\n"
				+ "    <script type=\"text/javascript\" src=\"//www.shieldui.com/shared/components/latest/js/shieldui-all.min.js\"></script>\r\n"
				+ "</head>\r\n" + "<body class=\"theme-light\">\r\n" + "<div>\r\n" + "    <div class=\"outerDiv\">\r\n"
				+ "        <div class=\"innerDiv\">\r\n"
				+ "            <label for=\"comboBoxStandart_anamenu_options\">Menu Seciniz</label>\r\n"
				+ "            <br />\r\n" + "            <input id=\"comboBoxStandart_anamenu_options\" />\r\n"
				+ "            <br />\r\n" + "            <button id=\"submit\">Sorgula</button>\r\n"
				+ "        </div>\r\n" + "        <div class=\"imageDiv\">\r\n"
				+ "            <img class=\"img-responsive\" src=\"/Content/img/combobox/codesnippet.png\" />\r\n"
				+ "        </div>\r\n" + "    </div>\r\n" + "</div>\r\n" + "<script type=\"text/javascript\">\r\n" +
				/* veritabanindan veri çekmek gerekiyor */
				"    var Standart_anamenu_options = ['hava_durumu', 'raporlar'];\r\n" + "    jQuery(function ($) {\r\n"
				+ "        $(\"#comboBoxStandart_anamenu_options\").shieldComboBox({\r\n"
				+ "            dataSource: {\r\n" + "                data: Standart_anamenu_options\r\n"
				+ "            },\r\n" + "            autoComplete: {\r\n" + "                enabled: true\r\n"
				+ "            }\r\n" + "        });\r\n" + "        $(\"#submit\").shieldButton({\r\n"
				+ "            events: {\r\n" + "                click: function () {\r\n"
				+ "                    var Standart_anamenu_option = $(\"#comboBoxStandart_anamenu_options\").swidget().value();\r\n"
				+ "window.location.assign(\"http://localhost:8080/standart_anamenu?standart_anamenu_option=\"+Standart_anamenu_option)"
				+ "                }\r\n" + "            }\r\n" + "        });\r\n" + "    });\r\n" + "</script>\r\n"
				+ "<style>\r\n" + "    .outerDiv\r\n" + "    {\r\n" + "        max-width: 600px;\r\n"
				+ "        content: \".\";\r\n" + "        display: block;\r\n" + "        overflow: hidden;\r\n"
				+ "        margin-left: auto;\r\n" + "        margin-right: auto;\r\n" + "    }\r\n"
				+ "    .innerDiv\r\n" + "    {\r\n" + "        display: inline-block;\r\n" + "        margin: 10px;\r\n"
				+ "    }\r\n" + "    .innerDiv label\r\n" + "    {\r\n" + "        font-style: italic;\r\n"
				+ "        font-size: 1.1em;\r\n" + "    }\r\n" + "    .imageDiv\r\n" + "    {\r\n"
				+ "        display: inline-block;\r\n" + "        max-width: 300px;\r\n" + "        margin: 10px;\r\n"
				+ "    }\r\n" + "    .innerDiv .sui-combobox\r\n" + "    {\r\n"
				+ "        font-family: Arial, sans-serif;\r\n" + "        font-size: 14px;\r\n"
				+ "        margin-bottom: 10px;\r\n" + "    }\r\n" + "</style>\r\n" + "</body>\r\n" + "</html>";
		out.print(word);
	}

	private void admin_anamenu_sayfasinin_yuklenmesi(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("DEBUG:33");
		// Url,parametre,combobox adı sayfa linkleri gibi string değişkenler oluşturulup
		// html kod
		// arasına eklenmesi gerekmektedir.
		String word = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
				+ "    <meta charset=\"utf-8\" />\r\n" + "    <title>Admin Ana Menu</title>\r\n" + sayfalar
				+ "    <link id=\"themecss\" rel=\"stylesheet\" type=\"text/css\" href=\"//www.shieldui.com/shared/components/latest/css/light/all.min.css\" />\r\n"
				+ "    <script type=\"text/javascript\" src=\"//www.shieldui.com/shared/components/latest/js/jquery-1.11.1.min.js\"></script>\r\n"
				+ "    <script type=\"text/javascript\" src=\"//www.shieldui.com/shared/components/latest/js/shieldui-all.min.js\"></script>\r\n"
				+ "</head>\r\n" + "<body class=\"theme-light\">\r\n" + "<div>\r\n" + "    <div class=\"outerDiv\">\r\n"
				+ "        <div class=\"innerDiv\">\r\n"
				+ "            <label for=\"comboBoxAdmin_anamenu_options\">Menu Seciniz</label>\r\n"
				+ "            <br />\r\n" + "            <input id=\"comboBoxAdmin_anamenu_options\" />\r\n"
				+ "            <br />\r\n" + "            <button id=\"submit\">Sorgula</button>\r\n"
				+ "        </div>\r\n" + "        <div class=\"imageDiv\">\r\n"
				+ "            <img class=\"img-responsive\" src=\"/Content/img/combobox/codesnippet.png\" />\r\n"
				+ "        </div>\r\n" + "    </div>\r\n" + "</div>\r\n" + "<script type=\"text/javascript\">\r\n" +
				/* veritabanindan veri çekmek gerekiyor */
				"    var Admin_anamenu_options = ['lokasyon_duzenle', 'hava_durumu', 'kullanici_duzenle', 'raporlar'];\r\n"
				+ "    jQuery(function ($) {\r\n" + "        $(\"#comboBoxAdmin_anamenu_options\").shieldComboBox({\r\n"
				+ "            dataSource: {\r\n" + "                data: Admin_anamenu_options\r\n"
				+ "            },\r\n" + "            autoComplete: {\r\n" + "                enabled: true\r\n"
				+ "            }\r\n" + "        });\r\n" + "        $(\"#submit\").shieldButton({\r\n"
				+ "            events: {\r\n" + "                click: function () {\r\n"
				+ "                    var Admin_anamenu_option = $(\"#comboBoxAdmin_anamenu_options\").swidget().value();\r\n"
				+ "window.location.assign(\"http://localhost:8080/admin_anamenu?admin_anamenu_option=\"+Admin_anamenu_option)"
				+ "                }\r\n" + "            }\r\n" + "        });\r\n" + "    });\r\n" + "</script>\r\n"
				+ "<style>\r\n" + "    .outerDiv\r\n" + "    {\r\n" + "        max-width: 600px;\r\n"
				+ "        content: \".\";\r\n" + "        display: block;\r\n" + "        overflow: hidden;\r\n"
				+ "        margin-left: auto;\r\n" + "        margin-right: auto;\r\n" + "    }\r\n"
				+ "    .innerDiv\r\n" + "    {\r\n" + "        display: inline-block;\r\n" + "        margin: 10px;\r\n"
				+ "    }\r\n" + "    .innerDiv label\r\n" + "    {\r\n" + "        font-style: italic;\r\n"
				+ "        font-size: 1.1em;\r\n" + "    }\r\n" + "    .imageDiv\r\n" + "    {\r\n"
				+ "        display: inline-block;\r\n" + "        max-width: 300px;\r\n" + "        margin: 10px;\r\n"
				+ "    }\r\n" + "    .innerDiv .sui-combobox\r\n" + "    {\r\n"
				+ "        font-family: Arial, sans-serif;\r\n" + "        font-size: 14px;\r\n"
				+ "        margin-bottom: 10px;\r\n" + "    }\r\n" + "</style>\r\n" + "</body>\r\n" + "</html>";
		out.print(word);
	}

	static String str = "jdbc:sqlserver://localhost:1433;databaseName=OHDS;user=sa;password=123456";

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
	 * @param baseRequest
	 * @param response
	 * @throws IOException
	 */
	private void faviconun_yuklenmesi(Request baseRequest, HttpServletResponse response) throws IOException {
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("image/x-icon");
		response.setContentLength(_favicon.length);
		response.getOutputStream().write(_favicon);
		return;
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

	/**
	 * @return the kullanici_tipi
	 */
	public int getKullanici_tipi() {
		return kullanici_tipi;
	}

	/**
	 * @param kullanici_tipi
	 *            the kullanici_tipi to set
	 */
	public void setKullanici_tipi(int kullanici_tipi) {
		this.kullanici_tipi = kullanici_tipi;
	}

	/**
	 * @return the out
	 */
	public PrintWriter getOut() {
		return out;
	}

	/**
	 * @param out
	 *            the out to set
	 */
	public void setOut(PrintWriter out) {
		this.out = out;
	}

	/**
	 * @return the requestURI
	 */
	public String getRequestURI() {
		return requestURI;
	}

	/**
	 * @param requestURI
	 *            the requestURI to set
	 */
	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}

	/**
	 * @return the parameterNames
	 */
	public Enumeration<String> getParameterNames() {
		return parameterNames;
	}

	/**
	 * @param parameterNames
	 *            the parameterNames to set
	 */
	public void setParameterNames(Enumeration<String> parameterNames) {
		this.parameterNames = parameterNames;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the kullanici_adi
	 */
	public String getKullanici_adi() {
		return kullanici_adi;
	}

	/**
	 * @param kullanici_adi
	 *            the kullanici_adi to set
	 */
	public void setKullanici_adi(String kullanici_adi) {
		this.kullanici_adi = kullanici_adi;
	}

	/**
	 * @return the sifre
	 */
	public String getSifre() {
		return sifre;
	}

	/**
	 * @param sifre
	 *            the sifre to set
	 */
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	/**
	 * @return the admin_anamenu_option
	 */
	public String getAdmin_anamenu_option() {
		return admin_anamenu_option;
	}

	/**
	 * @param admin_anamenu_option
	 *            the admin_anamenu_option to set
	 */
	public void setAdmin_anamenu_option(String admin_anamenu_option) {
		this.admin_anamenu_option = admin_anamenu_option;
	}

	/**
	 * @return the admin_anamenu_kullanici_duzenle_option
	 */
	public String getAdmin_anamenu_kullanici_duzenle_option() {
		return admin_anamenu_kullanici_duzenle_option;
	}

	/**
	 * @param admin_anamenu_kullanici_duzenle_option
	 *            the admin_anamenu_kullanici_duzenle_option to set
	 */
	public void setAdmin_anamenu_kullanici_duzenle_option(String admin_anamenu_kullanici_duzenle_option) {
		this.admin_anamenu_kullanici_duzenle_option = admin_anamenu_kullanici_duzenle_option;
	}

	/**
	 * @return the admin_anamenu_lokasyon_duzenle_option
	 */
	public String getAdmin_anamenu_lokasyon_duzenle_option() {
		return admin_anamenu_lokasyon_duzenle_option;
	}

	/**
	 * @param admin_anamenu_lokasyon_duzenle_option
	 *            the admin_anamenu_lokasyon_duzenle_option to set
	 */
	public void setAdmin_anamenu_lokasyon_duzenle_option(String admin_anamenu_lokasyon_duzenle_option) {
		this.admin_anamenu_lokasyon_duzenle_option = admin_anamenu_lokasyon_duzenle_option;
	}

	/**
	 * @return the standart_anamenu_option
	 */
	public String getStandart_anamenu_option() {
		return standart_anamenu_option;
	}

	/**
	 * @param standart_anamenu_option
	 *            the standart_anamenu_option to set
	 */
	public void setStandart_anamenu_option(String standart_anamenu_option) {
		this.standart_anamenu_option = standart_anamenu_option;
	}

	/**
	 * @return the kullanici_adi_parametre_varmi
	 */
	public Boolean getKullanici_adi_parametre_varmi() {
		return kullanici_adi_parametre_varmi;
	}

	/**
	 * @param kullanici_adi_parametre_varmi
	 *            the kullanici_adi_parametre_varmi to set
	 */
	public void setKullanici_adi_parametre_varmi(Boolean kullanici_adi_parametre_varmi) {
		this.kullanici_adi_parametre_varmi = kullanici_adi_parametre_varmi;
	}

	/**
	 * @return the admin_anamenu_option_parametre_varmi
	 */
	public Boolean getAdmin_anamenu_option_parametre_varmi() {
		return admin_anamenu_option_parametre_varmi;
	}

	/**
	 * @param admin_anamenu_option_parametre_varmi
	 *            the admin_anamenu_option_parametre_varmi to set
	 */
	public void setAdmin_anamenu_option_parametre_varmi(Boolean admin_anamenu_option_parametre_varmi) {
		this.admin_anamenu_option_parametre_varmi = admin_anamenu_option_parametre_varmi;
	}

	/**
	 * @return the admin_anamenu_kullanici_duzenle_option_parametre_varmi
	 */
	public Boolean getAdmin_anamenu_kullanici_duzenle_option_parametre_varmi() {
		return admin_anamenu_kullanici_duzenle_option_parametre_varmi;
	}

	/**
	 * @param admin_anamenu_kullanici_duzenle_option_parametre_varmi
	 *            the admin_anamenu_kullanici_duzenle_option_parametre_varmi to set
	 */
	public void setAdmin_anamenu_kullanici_duzenle_option_parametre_varmi(
			Boolean admin_anamenu_kullanici_duzenle_option_parametre_varmi) {
		this.admin_anamenu_kullanici_duzenle_option_parametre_varmi = admin_anamenu_kullanici_duzenle_option_parametre_varmi;
	}

	/**
	 * @return the admin_anamenu_lokasyon_duzenle_option_parametre_varmi
	 */
	public Boolean getAdmin_anamenu_lokasyon_duzenle_option_parametre_varmi() {
		return admin_anamenu_lokasyon_duzenle_option_parametre_varmi;
	}

	/**
	 * @param admin_anamenu_lokasyon_duzenle_option_parametre_varmi
	 *            the admin_anamenu_lokasyon_duzenle_option_parametre_varmi to set
	 */
	public void setAdmin_anamenu_lokasyon_duzenle_option_parametre_varmi(
			Boolean admin_anamenu_lokasyon_duzenle_option_parametre_varmi) {
		this.admin_anamenu_lokasyon_duzenle_option_parametre_varmi = admin_anamenu_lokasyon_duzenle_option_parametre_varmi;
	}

	/**
	 * @return the sifre_parametre_varmi
	 */
	public Boolean getSifre_parametre_varmi() {
		return sifre_parametre_varmi;
	}

	/**
	 * @param sifre_parametre_varmi
	 *            the sifre_parametre_varmi to set
	 */
	public void setSifre_parametre_varmi(Boolean sifre_parametre_varmi) {
		this.sifre_parametre_varmi = sifre_parametre_varmi;
	}

	/**
	 * @return the standart_anamenu_option_parametre_varmi
	 */
	public Boolean getStandart_anamenu_option_parametre_varmi() {
		return standart_anamenu_option_parametre_varmi;
	}

	/**
	 * @param standart_anamenu_option_parametre_varmi
	 *            the standart_anamenu_option_parametre_varmi to set
	 */
	public void setStandart_anamenu_option_parametre_varmi(Boolean standart_anamenu_option_parametre_varmi) {
		this.standart_anamenu_option_parametre_varmi = standart_anamenu_option_parametre_varmi;
	}

	/**
	 * @return the sayfalar
	 */
	public String getSayfalar() {
		return sayfalar;
	}

	/**
	 * @param sayfalar
	 *            the sayfalar to set
	 */
	public void setSayfalar(String sayfalar) {
		this.sayfalar = sayfalar;
	}

	/**
	 * @return the str
	 */
	public static String getStr() {
		return str;
	}

	/**
	 * @param str
	 *            the str to set
	 */
	public static void setStr(String str) {
		Request_Handler.str = str;
	}

	/**
	 * @return the _favicon
	 */
	public byte[] get_favicon() {
		return _favicon;
	}

	/**
	 * @param _favicon
	 *            the _favicon to set
	 */
	public void set_favicon(byte[] _favicon) {
		this._favicon = _favicon;
	}

	/**
	 * @return the _serveIcon
	 */
	public boolean is_serveIcon() {
		return _serveIcon;
	}

	/**
	 * @param _serveIcon
	 *            the _serveIcon to set
	 */
	public void set_serveIcon(boolean _serveIcon) {
		this._serveIcon = _serveIcon;
	}
}