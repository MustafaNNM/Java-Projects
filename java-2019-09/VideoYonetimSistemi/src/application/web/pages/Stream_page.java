package application.web.pages;

import static java.nio.file.StandardOpenOption.READ;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.io.EofException;
import org.eclipse.jetty.server.Request;

import application.web.Page;

/**
 * @author MehmetAkif-PC
 *
 */
public class Stream_page extends Page {
	private String requestURI;// loglanmasý gerekiyor.

	public String video_file_name_constant;
	private int BUFFER_LENGTH;
	private long EXPIRE_TIME;
	private Pattern RANGE_PATTERN;

	private String video_klasor_path;
	private String videolar;// stream sayfasýna yönlendirme yapýyor

	public Stream_page(String string) {
		super(string);
		try {
			requestURI = "";
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		} // loglanmasý gerekiyor.
		try {
			video_file_name_constant = "video_file_name";
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		}
		BUFFER_LENGTH = 46062305;// Bu nedir?
		EXPIRE_TIME = 1000 * 60 * 60 * 24;// Bu nedir?
		try {
			RANGE_PATTERN = Pattern.compile("bytes=(?<start>\\d*)-(?<end>\\d*)");
		} catch (PatternSyntaxException e) {
			// TODO: handle exception
			System.out.println("Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		}
		/*
		 * video dosyasý için path ayarý yapýlmasý gerekmektedir.jar dosyasý içerisine
		 * atýlmasý gerekmektedir. Ýçerisinde urllerin bulunduðu videolar.txt dosyasý
		 * gibi birþey gerekebilir. Video yayýnlama kýsmýnýn geliþtirilmesi
		 * gerekmektedir.
		 */
		try {
			video_klasor_path = "D:\\MCF Akýllý Güv. Teknolojileri A.Þ\\videomanagementsystem - Documents\\eclipse-photon-workspace\\JFXOpenCVJetty\\videos\\";
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		}
		try {
			videolar = "<a href=\"http://localhost:8080/home\">Anasayfa</a>\r\n" + "<br>"
					+ "<a href=\"http://localhost:8080/stream?" + video_file_name_constant
					+ "=omcek.mov\">Ýnanýlmaz Örümcek Adam Fragmaný</a>\r\n" + "<br>";
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		}
	}

	/**
	 * @param baseRequest
	 * @param request
	 * @param response
	 * @throws NumberFormatException
	 */
	public void load(String target, Request baseRequest, HttpServletRequest request, final HttpServletResponse response)
			throws NumberFormatException {
		// System.out.println("stream page load fonksiyonu");
		response.setContentType("text/html;charset=utf-8");
		// requestURI_toString(request);/*Hata kontrolü amacý ile yazýlmýþ kod parçasý*/
		String video_file_name_parameter = null;
		video_file_name_parameter = request.getParameter(video_file_name_constant);
		if (video_file_name_parameter == null) {
			/* Parametre yoksa vidolar sayfasýna yönlendiriyor. */
			response.setContentType("text/html;charset=utf-8");
			response_writer_println(baseRequest, response, videolar);
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			close_response_writer(response);
			return;
		} else {
			String character_encoding = "UTF-8";
			String video_file_name = null;
			try {
				video_file_name = URLDecoder.decode(video_file_name_parameter, character_encoding);
			} catch (UnsupportedEncodingException e) {
				System.out.println(
						"video_file_name = URLDecoder.decode(video_file_name_parameter, character_encoding); UnsupportedEncodingException");
				response.setStatus(HttpServletResponse.SC_OK);
				baseRequest.setHandled(true);
				e.printStackTrace();
				close_response_writer(response);
				System.exit(1);
				return;
			} catch (IllegalArgumentException e) {
				System.out.println(
						"video_file_name = URLDecoder.decode(video_file_name_parameter, character_encoding); IllegalArgumentException");
				response.setStatus(HttpServletResponse.SC_OK);
				baseRequest.setHandled(true);
				e.printStackTrace();
				close_response_writer(response);
				System.exit(1);
				return;
			} catch (SecurityException e) {
				System.out.println(
						"video_file_name = URLDecoder.decode(video_file_name_parameter, character_encoding); SecurityException");
				response.setStatus(HttpServletResponse.SC_OK);
				baseRequest.setHandled(true);
				e.printStackTrace();
				close_response_writer(response);
				System.exit(1);
				return;
			} catch (Exception e) {
				System.out.println(
						"video_file_name = URLDecoder.decode(video_file_name_parameter, character_encoding); Exception");
				response.setStatus(HttpServletResponse.SC_OK);
				baseRequest.setHandled(true);
				e.printStackTrace();
				close_response_writer(response);
				System.exit(1);
				return;
			}
			System.out.println("videoFilename:" + video_file_name);
			if (video_file_name == null) {
				System.out.println("video_file_name null");
			} else {
				Path video_path = null;
				try {
					video_path = Paths.get(video_klasor_path, video_file_name);
				} catch (InvalidPathException e) {
					System.out.println(
							"video_path = Paths.get(video_klasor_path, video_file_name); InvalidPathException");
					response.setStatus(HttpServletResponse.SC_OK);
					baseRequest.setHandled(true);
					e.printStackTrace();
					close_response_writer(response);
					System.exit(1);
					return;
				} catch (SecurityException e) {
					System.out.println("video_path = Paths.get(video_klasor_path, video_file_name); SecurityException");
					response.setStatus(HttpServletResponse.SC_OK);
					baseRequest.setHandled(true);
					e.printStackTrace();
					close_response_writer(response);
					System.exit(1);
					return;
				} catch (Exception e) {
					System.out.println("video_path = Paths.get(video_klasor_path, video_file_name); Exception");
					response.setStatus(HttpServletResponse.SC_OK);
					baseRequest.setHandled(true);
					e.printStackTrace();
					close_response_writer(response);
					System.exit(1);
					return;
				}
				if (video_path == null) {
					System.out.println("video_klasor_path:" + video_klasor_path + "bulunamadi");
				} else {
					int length = 0;
					try {
						length = (int) Files.size(video_path);
					} catch (EofException e) {
						System.out.println("length = (int) Files.size(video_path); EofException");
						response.setStatus(HttpServletResponse.SC_OK);
						baseRequest.setHandled(true);
						e.printStackTrace();
						close_response_writer(response);
						System.exit(1);
						return;
					} catch (IOException e) {
						System.out.println("length = (int) Files.size(video_path); IOException");
						response.setStatus(HttpServletResponse.SC_OK);
						baseRequest.setHandled(true);
						e.printStackTrace();
						close_response_writer(response);
						System.exit(1);
						return;
					} catch (SecurityException e) {
						System.out.println("length = (int) Files.size(video_path); IOException");
						response.setStatus(HttpServletResponse.SC_OK);
						baseRequest.setHandled(true);
						e.printStackTrace();
						close_response_writer(response);
						System.exit(1);
						return;
					} catch (Exception e) {
						System.out.println("length = (int) Files.size(video_path); Exception");
						response.setStatus(HttpServletResponse.SC_OK);
						baseRequest.setHandled(true);
						e.printStackTrace();
						close_response_writer(response);
						System.exit(1);
						return;
					}
					int start = 0;
					int end = length - 1;
					String range = request.getHeader("Range");
					if (range == null) {
						System.out.println("Range null");
						try {
							response.sendRedirect("/video");
						} catch (EofException e) {
							System.out.println("response.sendRedirect(\"/video\"); EofException");
							response.setStatus(HttpServletResponse.SC_OK);
							baseRequest.setHandled(true);
							e.printStackTrace();
							close_response_writer(response);
							System.exit(1);
							return;
						} catch (IOException e) {
							System.out.println("response.sendRedirect(\"/video\"); IOException");
							response.setStatus(HttpServletResponse.SC_OK);
							baseRequest.setHandled(true);
							e.printStackTrace();
							close_response_writer(response);
							System.exit(1);
							return;
						} catch (SecurityException e) {
							System.out.println("response.sendRedirect(\"/video\"); IOException");
							response.setStatus(HttpServletResponse.SC_OK);
							baseRequest.setHandled(true);
							e.printStackTrace();
							close_response_writer(response);
							System.exit(1);
							return;
						} catch (Exception e) {
							System.out.println("response.sendRedirect(\"/video\"); Exception");
							response.setStatus(HttpServletResponse.SC_OK);
							baseRequest.setHandled(true);
							e.printStackTrace();
							close_response_writer(response);
							System.exit(1);
							return;
						}
						response.setStatus(HttpServletResponse.SC_OK);
						baseRequest.setHandled(true);
						close_response_writer(response);
						System.exit(1);
						return;
					} else {
						System.out.println("Range:" + range);
						Matcher matcher = null;
						try {
							matcher = RANGE_PATTERN.matcher(range);
						} catch (Exception e) {
							System.out.println("matcher = RANGE_PATTERN.matcher(range); Exception");
							response.setStatus(HttpServletResponse.SC_OK);
							baseRequest.setHandled(true);
							e.printStackTrace();
							close_response_writer(response);
							System.exit(1);
							return;
						}
						if (matcher == null) {
							System.out.println("matcher null");
							response.setStatus(HttpServletResponse.SC_OK);
							baseRequest.setHandled(true);
							close_response_writer(response);
							System.exit(1);
							return;
						} else {
							if (!matcher.matches()) {
								System.out.println("no matches");
								response.setStatus(HttpServletResponse.SC_OK);
								baseRequest.setHandled(true);
								close_response_writer(response);
								System.exit(1);
								return;
							} else {
								String startGroup = matcher.group("start");
								if (startGroup == null) {
									System.out.println("startGroup null");
									response.setStatus(HttpServletResponse.SC_OK);
									baseRequest.setHandled(true);
									close_response_writer(response);
									System.exit(1);
									return;
								} else {
									if (startGroup.isEmpty()) {
									} else {
										start = Integer.valueOf(startGroup);
									} // startGroup.isEmpty()
									if (start < 0) {
										start = 0;
									} else {
									} // start < 0
									String endGroup = matcher.group("end");
									if (endGroup == null) {
										System.out.println("endGroup null");
										response.setStatus(HttpServletResponse.SC_OK);
										baseRequest.setHandled(true);
										close_response_writer(response);
										System.exit(1);
										return;
									} else {
										if (endGroup.isEmpty()) {
										} else {
											end = Integer.valueOf(endGroup);
										} // endGroup.isEmpty()
										if (end > length - 1) {
											end = length - 1;
										} else {
										} // end > length - 1
										int contentLength = end - start + 1;

										try {
											response.reset();
										} catch (Exception e) {
											response.setStatus(HttpServletResponse.SC_OK);
											baseRequest.setHandled(true);
											e.printStackTrace();
											close_response_writer(response);
											System.exit(1);
											return;
										}
										try {
											response.setBufferSize(BUFFER_LENGTH);
										} catch (Exception e) {
											response.setStatus(HttpServletResponse.SC_OK);
											baseRequest.setHandled(true);
											e.printStackTrace();
											close_response_writer(response);
											System.exit(1);
											return;
										}
										try {
											response.setHeader("Content-Disposition",
													String.format("inline;filename=\"%s\"", video_file_name));
										} catch (Exception e) {
											response.setStatus(HttpServletResponse.SC_OK);
											baseRequest.setHandled(true);
											e.printStackTrace();
											close_response_writer(response);
											System.exit(1);
											return;
										}
										try {
											response.setHeader("Accept-Ranges", "bytes");
										} catch (Exception e) {
											response.setStatus(HttpServletResponse.SC_OK);
											baseRequest.setHandled(true);
											e.printStackTrace();
											close_response_writer(response);
											System.exit(1);
											return;
										}
										FileTime last_modified = null;
										try {
											last_modified = Files.getLastModifiedTime(video_path);
										} catch (EofException e) {
											System.out.println(
													"last_modified = Files.getLastModifiedTime(video_path); EofException");
											response.setStatus(HttpServletResponse.SC_OK);
											baseRequest.setHandled(true);
											e.printStackTrace();
											close_response_writer(response);
											System.exit(1);
											return;
										} catch (IOException e) {
											System.out.println(
													"last_modified = Files.getLastModifiedTime(video_path); IOException");
											response.setStatus(HttpServletResponse.SC_OK);
											baseRequest.setHandled(true);
											e.printStackTrace();
											close_response_writer(response);
											System.exit(1);
											return;
										} catch (SecurityException e) {
											System.out.println(
													"last_modified = Files.getLastModifiedTime(video_path); IOException");
											response.setStatus(HttpServletResponse.SC_OK);
											baseRequest.setHandled(true);
											e.printStackTrace();
											close_response_writer(response);
											System.exit(1);
											return;
										} catch (Exception e) {
											System.out.println(
													"last_modified = Files.getLastModifiedTime(video_path); Exception");
											response.setStatus(HttpServletResponse.SC_OK);
											baseRequest.setHandled(true);
											e.printStackTrace();
											close_response_writer(response);
											System.exit(1);
											return;
										}
										if (last_modified != null) {
											try {
												response.setDateHeader("Last-Modified", last_modified.toMillis());
											} catch (Exception e) {
												System.out.println(
														"response.setDateHeader(\"Last-Modified\", last_modified.toMillis()); Exception");
												response.setStatus(HttpServletResponse.SC_OK);
												baseRequest.setHandled(true);
												e.printStackTrace();
												close_response_writer(response);
												System.exit(1);
												return;
											}
										} else {
											System.out.println("Last-Modified null");
											response.setStatus(HttpServletResponse.SC_OK);
											baseRequest.setHandled(true);
											close_response_writer(response);
											System.exit(1);
											return;
										}
										response.setDateHeader("Expires", System.currentTimeMillis() + EXPIRE_TIME);
										try {
											response.setContentType(Files.probeContentType(video_path));
										} catch (EofException e) {
											System.out.println(
													"response.setDateHeader(\"Expires\", System.currentTimeMillis() + EXPIRE_TIME); EofException");
											response.setStatus(HttpServletResponse.SC_OK);
											baseRequest.setHandled(true);
											e.printStackTrace();
											close_response_writer(response);
											System.exit(1);
											return;
										} catch (IOException e) {
											System.out.println(
													"response.setDateHeader(\"Expires\", System.currentTimeMillis() + EXPIRE_TIME); IOException");
											response.setStatus(HttpServletResponse.SC_OK);
											baseRequest.setHandled(true);
											e.printStackTrace();
											close_response_writer(response);
											System.exit(1);
											return;
										} catch (SecurityException e) {
											System.out.println(
													"response.setDateHeader(\"Expires\", System.currentTimeMillis() + EXPIRE_TIME); IOException");
											response.setStatus(HttpServletResponse.SC_OK);
											baseRequest.setHandled(true);
											e.printStackTrace();
											close_response_writer(response);
											System.exit(1);
											return;
										} catch (Exception e) {
											System.out.println(
													"response.setDateHeader(\"Expires\", System.currentTimeMillis() + EXPIRE_TIME); Exception");
											response.setStatus(HttpServletResponse.SC_OK);
											baseRequest.setHandled(true);
											e.printStackTrace();
											close_response_writer(response);
											System.exit(1);
											return;
										}
										try {
											response.setHeader("Content-Range",
													String.format("bytes %s-%s/%s", start, end, length));
										} catch (Exception e) {
											System.out.println("response.setHeader(\"Content-Range\",\r\n"
													+ "														String.format(\"bytes %s-%s/%s\", start, end, length));Exception");
											response.setStatus(HttpServletResponse.SC_OK);
											baseRequest.setHandled(true);
											e.printStackTrace();
											close_response_writer(response);
											System.exit(1);
											return;
										}
										response.setHeader("Content-Length", String.format("%s", contentLength));
										response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
										int bytesRead;
										int bytesLeft = contentLength;
										ByteBuffer buffer = null;
										try {
											buffer = ByteBuffer.allocate(BUFFER_LENGTH);
										} catch (Exception e) {
											System.out
													.println("buffer = ByteBuffer.allocate(BUFFER_LENGTH); Exception");
											response.setStatus(HttpServletResponse.SC_OK);
											baseRequest.setHandled(true);
											e.printStackTrace();
											close_response_writer(response);
											System.exit(1);
											return;
										}
										if (buffer != null) {
											SeekableByteChannel input = null;
											try {
												input = Files.newByteChannel(video_path, READ);
											} catch (NullPointerException e) {
												System.out.println(
														"SeekableByteChannel input = null; NullPointerException Ram yetersiz.");
												response.setStatus(HttpServletResponse.SC_OK);
												baseRequest.setHandled(true);
												e.printStackTrace();
												close_response_writer(response);
												System.exit(1);
												return;
											} catch (IllegalArgumentException e) {
												System.out.println(
														"input = Files.newByteChannel(video_path, READ); IllegalArgumentException");
												response.setStatus(HttpServletResponse.SC_OK);
												baseRequest.setHandled(true);
												e.printStackTrace();
												close_response_writer(response);
												System.exit(1);
												return;
											} catch (UnsupportedOperationException e) {
												System.out.println(
														"input = Files.newByteChannel(video_path, READ); UnsupportedOperationException");
												response.setStatus(HttpServletResponse.SC_OK);
												baseRequest.setHandled(true);
												e.printStackTrace();
												close_response_writer(response);
												System.exit(1);
												return;
											} catch (FileAlreadyExistsException e) {
												System.out.println(
														"input = Files.newByteChannel(video_path, READ); FileAlreadyExistsException");
												response.setStatus(HttpServletResponse.SC_OK);
												baseRequest.setHandled(true);
												e.printStackTrace();
												close_response_writer(response);
												System.exit(1);
												return;
											} catch (EofException e) {
												System.out.println(
														"input = Files.newByteChannel(video_path, READ); EofException");
												response.setStatus(HttpServletResponse.SC_OK);
												baseRequest.setHandled(true);
												e.printStackTrace();
												close_response_writer(response);
												System.exit(1);
												return;
											} catch (IOException e) {
												System.out.println(
														"input = Files.newByteChannel(video_path, READ); IOException");
												response.setStatus(HttpServletResponse.SC_OK);
												baseRequest.setHandled(true);
												e.printStackTrace();
												close_response_writer(response);
												System.exit(1);
												return;
											} catch (SecurityException e) {
												System.out.println(
														"input = Files.newByteChannel(video_path, READ); IOException");
												response.setStatus(HttpServletResponse.SC_OK);
												baseRequest.setHandled(true);
												e.printStackTrace();
												close_response_writer(response);
												System.exit(1);
												return;
											} catch (Exception e) {
												System.out.println(
														"input = Files.newByteChannel(video_path, READ); Exception");
												response.setStatus(HttpServletResponse.SC_OK);
												baseRequest.setHandled(true);
												e.printStackTrace();
												close_response_writer(response);
												System.exit(1);
												return;
											}
											if (input == null) {
												response.setStatus(HttpServletResponse.SC_OK);
												baseRequest.setHandled(true);
												close_response_writer(response);
												System.exit(1);
												return;
											} else {
												OutputStream output = null;
												try {
													output = response.getOutputStream();
												} catch (NullPointerException e) {
													response.setStatus(HttpServletResponse.SC_OK);
													baseRequest.setHandled(true);
													System.out.println(
															"output = response.getOutputStream(); NullPointerException Ram yetersiz.");
													e.printStackTrace();
													close_input(input);
													close_response_writer(response);
													System.exit(1);
													return;
												} catch (EofException e) {
													close_input(input);
													System.out.println(
															"output = response.getOutputStream(); EofException");
													response.setStatus(HttpServletResponse.SC_OK);
													baseRequest.setHandled(true);
													e.printStackTrace();
													close_response_writer(response);
													System.exit(1);
													return;
												} catch (IOException e) {
													close_input(input);
													System.out.println(
															"output = response.getOutputStream(); IOException");
													response.setStatus(HttpServletResponse.SC_OK);
													baseRequest.setHandled(true);
													e.printStackTrace();
													close_response_writer(response);
													System.exit(1);
													return;
												} catch (SecurityException e) {
													close_input(input);
													System.out.println(
															"output = response.getOutputStream(); IOException");
													response.setStatus(HttpServletResponse.SC_OK);
													baseRequest.setHandled(true);
													e.printStackTrace();
													close_response_writer(response);
													System.exit(1);
													return;
												} catch (Exception e) {
													close_input(input);
													System.out
															.println("output = response.getOutputStream(); Exception");
													response.setStatus(HttpServletResponse.SC_OK);
													baseRequest.setHandled(true);
													e.printStackTrace();
													close_response_writer(response);
													System.exit(1);
													return;
												}
												try {
													input.position(start);
												} catch (EofException e) {
													close_input(input);
													System.out.println("input.position(start); EofException");
													response.setStatus(HttpServletResponse.SC_OK);
													baseRequest.setHandled(true);
													e.printStackTrace();
													close_response_writer(response);
													System.exit(1);
													return;
												} catch (IOException e) {
													close_input(input);
													System.out.println("input.position(start); IOException");
													response.setStatus(HttpServletResponse.SC_OK);
													baseRequest.setHandled(true);
													e.printStackTrace();
													close_response_writer(response);
													System.exit(1);
													return;
												} catch (SecurityException e) {
													close_input(input);
													System.out.println("input.position(start); IOException");
													response.setStatus(HttpServletResponse.SC_OK);
													baseRequest.setHandled(true);
													e.printStackTrace();
													close_response_writer(response);
													System.exit(1);
													return;
												} catch (Exception e) {
													close_input(input);
													System.out.println("input.position(start); Exception");
													response.setStatus(HttpServletResponse.SC_OK);
													baseRequest.setHandled(true);
													e.printStackTrace();
													close_response_writer(response);
													System.exit(1);
													return;
												}
												try {
													bytesRead = input.read(buffer);
												} catch (EofException e) {
													close_input(input);
													System.out.println("input.position(start); EofException");
													response.setStatus(HttpServletResponse.SC_OK);
													baseRequest.setHandled(true);
													e.printStackTrace();
													close_response_writer(response);
													System.exit(1);
													return;
												} catch (IOException e) {
													close_input(input);
													System.out.println("input.position(start); IOException");
													response.setStatus(HttpServletResponse.SC_OK);
													baseRequest.setHandled(true);
													e.printStackTrace();
													close_response_writer(response);
													System.exit(1);
													return;
												} catch (SecurityException e) {
													close_input(input);
													System.out.println("input.position(start); IOException");
													response.setStatus(HttpServletResponse.SC_OK);
													baseRequest.setHandled(true);
													e.printStackTrace();
													close_response_writer(response);
													System.exit(1);
													return;
												} catch (Exception e) {
													close_input(input);
													System.out.println("input.position(start); Exception");
													response.setStatus(HttpServletResponse.SC_OK);
													baseRequest.setHandled(true);
													e.printStackTrace();
													close_response_writer(response);
													System.exit(1);
													return;
												}
												byte[] b = null;
												// while kýsmýný deðiþtirmem gerekiyor olabilir.
												while (bytesRead > 0 && bytesLeft > 0) {
													if (buffer != null) {
														try {
															b = buffer.array();
														} catch (ReadOnlyBufferException e) {
															close_input(input);
															System.out.println("Exception");
															response.setStatus(HttpServletResponse.SC_OK);
															baseRequest.setHandled(true);
															e.printStackTrace();
															close_response_writer(response);
															System.exit(1);
															return;
														} catch (UnsupportedOperationException e) {
															close_input(input);
															// exception//ReadOnlyBufferException//UnsupportedOperationException
															System.out.println("Exception");
															response.setStatus(HttpServletResponse.SC_OK);
															baseRequest.setHandled(true);
															e.printStackTrace();
															close_response_writer(response);
															System.exit(1);
															return;
														} catch (Exception e) {
															close_input(input);
															// exception//ReadOnlyBufferException//UnsupportedOperationException
															System.out.println("Exception");
															response.setStatus(HttpServletResponse.SC_OK);
															baseRequest.setHandled(true);
															e.printStackTrace();
															close_response_writer(response);
															System.exit(1);
															return;
														}
														if (b != null) {
															if (bytesLeft < bytesRead) {
																System.out.println("bytesLeft:" + bytesLeft
																		+ "\nbytesRead:" + bytesRead);
																try {
																	output.write(b, 0, bytesLeft);// try
																	// catch
																	// lazým
																	// buffer.array()
																	// için
																} catch (IllegalStateException e1) {
																	System.out.println(
																			"output.write(b, 0, bytesRead); IOException");
																	response.setStatus(HttpServletResponse.SC_OK);
																	baseRequest.setHandled(true);
																	e1.printStackTrace();
																	close_input(input);
																	close_response_writer(response);
																	System.exit(1);
																	return;
																} catch (IOException e1) {
																	close_input(input);
																	System.out.println(
																			"output.write(b, 0, bytesRead); IOException");
																	response.setStatus(HttpServletResponse.SC_OK);
																	baseRequest.setHandled(true);
																	e1.printStackTrace();
																	close_response_writer(response);
																	System.exit(1);
																	return;
																} catch (SecurityException e) {
																	close_input(input);
																	close_output(output);
																	System.out.println(
																			"output.write(buffer.array(), 0, bytesLeft); IOException");
																	response.setStatus(HttpServletResponse.SC_OK);
																	baseRequest.setHandled(true);
																	e.printStackTrace();
																	close_response_writer(response);
																	System.exit(1);
																	return;
																} catch (Exception e) {
																	close_input(input);
																	close_output(output);
																	System.out.println(
																			"output.write(buffer.array(), 0, bytesLeft); Exception");
																	response.setStatus(HttpServletResponse.SC_OK);
																	baseRequest.setHandled(true);
																	e.printStackTrace();
																	close_response_writer(response);
																	System.exit(1);
																	return;
																}
																buffer.clear();
															} else {
																try {
																	System.out.println("bytesLeft:" + bytesLeft
																			+ "\nbytesRead:" + bytesRead);
																	output.write(b, 0, bytesRead);
																	// lazým
																	// buffer.array()
																	// için
																} catch (EofException e) {
																	close_input(input);
																	System.out.println(
																			"output.write(b, 0, bytesRead); EofException");
																	response.setStatus(HttpServletResponse.SC_OK);
																	baseRequest.setHandled(true);
																	e.printStackTrace();
																	close_response_writer(response);
																	System.exit(1);
																	return;
																} catch (IOException e) {
																	close_input(input);
																	System.out.println(
																			"output.write(b, 0, bytesRead); IOException");
																	response.setStatus(HttpServletResponse.SC_OK);
																	baseRequest.setHandled(true);
																	e.printStackTrace();
																	close_response_writer(response);
																	System.exit(1);
																	return;
																} catch (SecurityException e) {
																	close_input(input);
																	close_output(output);
																	System.out.println(
																			"output.write(b, 0, bytesRead); SecurityException");
																	response.setStatus(HttpServletResponse.SC_OK);
																	baseRequest.setHandled(true);
																	e.printStackTrace();
																	close_response_writer(response);
																	System.exit(1);
																	return;
																} catch (Exception e) {
																	close_input(input);
																	close_output(output);
																	System.out.println(
																			"output.write(buffer.array(), 0, bytesRead); Exception");
																	response.setStatus(HttpServletResponse.SC_OK);
																	baseRequest.setHandled(true);
																	e.printStackTrace();
																	close_response_writer(response);
																	System.exit(1);
																	return;
																}
															}
															bytesLeft -= bytesRead;
															try {
																bytesRead = input.read(buffer);
															} catch (EofException e) {
																close_input(input);
																System.out
																		.println("input.position(start); EofException");
																response.setStatus(HttpServletResponse.SC_OK);
																baseRequest.setHandled(true);
																e.printStackTrace();
																close_response_writer(response);
																System.exit(1);
																return;
															} catch (IOException e) {
																close_input(input);
																System.out
																		.println("input.position(start); IOException");
																response.setStatus(HttpServletResponse.SC_OK);
																baseRequest.setHandled(true);
																e.printStackTrace();
																close_response_writer(response);
																System.exit(1);
																return;
															} catch (SecurityException e) {
																close_input(input);
																System.out
																		.println("input.position(start); IOException");
																response.setStatus(HttpServletResponse.SC_OK);
																baseRequest.setHandled(true);
																e.printStackTrace();
																close_response_writer(response);
																System.exit(1);
																return;
															} catch (Exception e) {
																close_input(input);
																System.out.println("input.position(start); Exception");
																response.setStatus(HttpServletResponse.SC_OK);
																baseRequest.setHandled(true);
																e.printStackTrace();
																close_response_writer(response);
																System.exit(1);
																return;
															}
														} else {
															close_input(input);
															close_output(output);
															System.out.println("b null");
															response.setStatus(HttpServletResponse.SC_OK);
															baseRequest.setHandled(true);
															close_response_writer(response);
															System.exit(1);
															return;
														} // b == null

													} else {
														System.out.println("buffer null");
														close_input(input);
														close_output(output);
														response.setStatus(HttpServletResponse.SC_OK);
														baseRequest.setHandled(true);
														close_response_writer(response);
														System.exit(1);
														return;
													}
												} // while
											} // input != null
										} else {
											response.setStatus(HttpServletResponse.SC_OK);
											baseRequest.setHandled(true);
											close_response_writer(response);
											System.exit(1);
											return;
										} // buffer != null
									} // endGroup == null
								} // startGroup==null
							} // !matcher.matches()
						} // matcher == null
					} // range == null
				} // video_path == null
			} // video_file_name == null
		} // video_file_name_parameter==null
	}// load

	/**
	 * @param output
	 */
	private void close_output(OutputStream output) {
		try {
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		return;
	}

	/**
	 * @param input
	 */
	private void close_input(SeekableByteChannel input) {
		try {
			input.close();
		} catch (IOException e2) {
			e2.printStackTrace();
			System.exit(1);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
			return;
		}
		return;
	}

}
