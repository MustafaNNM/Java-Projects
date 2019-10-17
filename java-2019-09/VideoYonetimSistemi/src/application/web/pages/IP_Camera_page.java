package application.web.pages;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import application.web.Page;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import service.Utils;

public class IP_Camera_page extends Page {
	private String requestURI = "";// loglanmasý gerekiyor.

	public String uri_constant = "uri";
	private int BUFFER_LENGTH = 1024 * 16;// Bu nedir?
	private long EXPIRE_TIME = 1000 * 60 * 60 * 24;// Bu nedir?
	private Pattern RANGE_PATTERN = Pattern.compile("bytes=(?<start>\\d*)-(?<end>\\d*)");
	private String video_klasor_path = "D:\\MCF Akýllý Güv. Teknolojileri A.Þ\\videomanagementsystem - Documents\\eclipse-photon-workspace\\JFXOpenCVJetty\\videos\\";
	private String videolar = "<a href=\"http://localhost:8080/home\">Anasayfa</a>\r\n" + "<br>"
			+ "<a href=\"http://localhost:8080/ip_camera?" + uri_constant
			+ "=rtsp://192.168.1.36:554/h264_2\">IP Kamera Canlý Yayýný</a>\r\n" + "<br>";// ip_camera sayfasýna
																							// yönlendirme yapýyor

	static Mat frame = new Mat();
	Image imageToShow;

	public IP_Camera_page(String string) {
		super(string);
	}

	/**
	 * @param baseRequest
	 * @param request
	 * @param response
	 * @throws NumberFormatException
	 */
	@SuppressWarnings({ "unused" })
	public void load(String target, Request baseRequest, HttpServletRequest request, final HttpServletResponse response)
			throws NumberFormatException {
		response.setContentType("text/html;charset=utf-8");

		requestURI_toString(request);
		String video_file_name_parameter = null;
		video_file_name_parameter = request.getParameter(uri_constant);
		if (video_file_name_parameter == null) {
			requestURI_toString(request);
			response.setContentType("text/html;charset=utf-8");
			response_writer_println(baseRequest, response,videolar);
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		} else {
			int start = 0;
			int end = 0;
			String range = request.getHeader("Range");
			if (range == null) {
				System.out.println("Range null");
				try {
					response.sendRedirect("/ip_camera");
				} catch (IOException e) {
					e.printStackTrace();
					response.setStatus(HttpServletResponse.SC_OK);
					baseRequest.setHandled(true);System.exit(1);
					return;
				} catch (Exception e) {
					e.printStackTrace();
					response.setStatus(HttpServletResponse.SC_OK);
					baseRequest.setHandled(true);System.exit(1);
					return;
				}
				response.setStatus(HttpServletResponse.SC_OK);
				baseRequest.setHandled(true);
				return;
			} else {
				System.out.println("Range:" + range);
				Matcher matcher = RANGE_PATTERN.matcher(range);
				if (matcher == null) {
					System.out.println("matcher null");
					response.setStatus(HttpServletResponse.SC_OK);
					baseRequest.setHandled(true);
					return;
				} else {
					System.out.println("matcher null deðil");
					if (!matcher.matches()) {
						System.out.println("no matches");
						response.setStatus(HttpServletResponse.SC_OK);
						baseRequest.setHandled(true);
						return;
					} else {
						System.out.println("yes matches");
						String startGroup = matcher.group("start");
						if (startGroup == null) {
							System.out.println("startGroup null");
							response.setStatus(HttpServletResponse.SC_OK);
							baseRequest.setHandled(true);
							return;
						} else {
							System.out.println("startGroup null deðil");
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
								return;
							} else {
								System.out.println("endGroup null degil");
								if (endGroup.isEmpty()) {
								} else {
									end = Integer.valueOf(endGroup);
								} // endGroup.isEmpty()

								int contentLength = end - start + 1;
								response.reset();
								response.setBufferSize(BUFFER_LENGTH);
								response.setHeader("Content-Disposition",
										String.format("inline;filename=\"%s\"", "deneme"));
								response.setHeader("Accept-Ranges", "bytes");
								response.setDateHeader("Last-Modified", System.currentTimeMillis());
								response.setDateHeader("Expires", System.currentTimeMillis() + EXPIRE_TIME);
								Path video_path = Paths.get(video_klasor_path, "omcek.mov");
								try {
									response.setContentType(Files.probeContentType(video_path));
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
									System.exit(1);
									return;
								}
								try {
									response.setContentType(Files.probeContentType(video_path));
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
									System.exit(1);return;
								}
								response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);

								System.out.println("IP_Camera page load fonksiyonu");
								VideoCapture capture = new VideoCapture();
								/*
								 * kutu textbox eklenmesi gerekmektedir.urinin text boxtan alýnmasý
								 * gerekmektedir.
								 */
								/* stop button gerekmektedir. */
								capture.open("rtsp://184.72.239.149/vod/mp4:BigBuckBunny_175k.mov");
								// rtsp://184.72.239.149/vod/mp4:BigBuckBunny_175k.mov
								// rtsp://192.168.1.41/h264_2
								if (!capture.isOpened()) {
									System.out.print("Not opened :( \r");

								} else {
									try {
										// read the current frame
										capture.read(frame);

										// if the frame is not empty, process it
										if (!frame.empty()) {
											// convert and show the frame
											imageToShow = Utils.mat2Image(frame);
											BufferedImage image = SwingFXUtils.fromFXImage(imageToShow, null);
											ByteArrayOutputStream baos = new ByteArrayOutputStream();
											ImageIO.write(image, "jpg", baos);
											baos.flush();
											byte[] imageInByte = baos.toByteArray();
											baos.close();
											// --Send the data to response

											OutputStream os = response.getOutputStream();
										
											os.write(imageInByte);
											os.close();
										} else {
											System.out.print("Empty frame :( \r");
										}

									} catch (Exception e) {
										// log the error
										System.err.println("Exception during the image elaboration: " + e);
										System.exit(1);
										return;
									}
								}
								System.out.print("Opened :( \r");
							}
						}
					}
				}
			}
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}// load


}
