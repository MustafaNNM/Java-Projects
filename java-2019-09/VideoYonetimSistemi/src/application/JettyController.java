package application;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.me.javawsdiscovery.DeviceDiscovery;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgproc.Moments;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;
import org.opencv.video.BackgroundSubtractorMOG2;
import org.opencv.video.Video;
import org.opencv.videoio.VideoCapture;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import service.Utils;

public class JettyController {
	// @FXML etiketli deðiþkenler private static yapýldýðý zaman hata çýkýyor.
	// @FXML etiketli fonksiyonlar protected void olmadýðý zaman hata çýkýyor.
	@FXML
	private MediaView mediaView;
	// the FXML mainborder pane
	@FXML
	private BorderPane mainborderpane;
	@FXML
	private TabPane maintabpane;
	@FXML
	private Tab livestreamtab;
	@FXML
	private AnchorPane livestreamtabanchorpane;
	// the FXML subcenter
	@FXML
	private BorderPane mainsubcenterborderpane;
	@FXML
	private Pane subcentersubbottomborderpane;
	// the FXML button
	@FXML
	private Button find_onvif_devices;
	@FXML
	private Pane subcentersubcenterborderpane;
	@FXML
	private TextArea onvif_ip_device_list;
	@FXML
	private Pane subcentersubtopborderpane;
	@FXML
	private Label onvif_device_list_label;
	// the FXML image view
	@FXML
	private ImageView company_logo;
	@FXML
	private Image url;
	@FXML
	private Tab takephototab;
	@FXML
	private AnchorPane takephototabanchorpane;
	// the FXML subleft
	@FXML
	private BorderPane mainsubleftborderpane;
	@FXML
	private Pane subleftsubcenterborderpane;
	@FXML
	private Pane subleftsubbottomborderpane;
	// the FXML button
	@FXML
	private Button start_button;
	// the FXML border pane
	@FXML
	private TextArea network_url;
	@FXML
	private TextField network_url_field;
	// the FXML image view
	@FXML
	private ImageView currentframe;
	@FXML
	private Insets x1;
	@FXML
	private Pane subleftsubtopborderpane;
	@FXML
	private Label live_stream_label;
	@FXML
	private Tab onvifdevicelisttab;
	// the FXML subright
	@FXML
	private AnchorPane onvifdevicelisttabanchorpane;
	@FXML
	private BorderPane mainsubrightborderpane;
	@FXML
	private Pane subrightsubbottomborderpane;
	@FXML
	private Pane subrightsubcenterborderpane;
	// the FXML button
	@FXML
	private Button screanshut_button;
	@FXML
	private ImageView screanshut;
	@FXML
	private Insets x2;
	// the FXML image view
	@FXML
	private Pane subrightsubtopborderpane;
	@FXML
	private Label screanshut_label;
	@FXML
	private Tab settingstab;
	@FXML
	private AnchorPane settingstabanchorpane;
	@FXML
	private WebView webview;
	@FXML
	private Tab onviftab;
	@FXML
	private AnchorPane onviftabanchorpane;
	@FXML
	private WebView onvif_webview;
	@FXML
	private Tab communication_tab;
	@FXML
	private AnchorPane communication_tabanchorpane;
	@FXML
	private Label sirket_adi_label;
	@FXML
	private Label ofis_turu_label;
	@FXML
	private Label il_label;
	@FXML
	private Label ilce_label;
	@FXML
	private Label mahalle_label;
	@FXML
	private Label cadde_label;
	@FXML
	private Label dis_kapi_no_label;
	@FXML
	private Label ic_kapi_no_label;
	@FXML
	private Label telefon_no_label;
	@FXML
	private Label fax_no_label;
	@FXML
	private Label sirket_adi_bilgisi;
	@FXML
	private Label yonetim_ofisi_bilgisi;
	@FXML
	private Label il_bilgisi;
	@FXML
	private Label ilce_bilgisi;
	@FXML
	private Label mahalle_bilgisi;
	@FXML
	private Label cadde_bilgisi;
	@FXML
	private Label bina_bilgisi;
	@FXML
	private Label ic_kapi_bilgisi;
	@FXML
	private Label telefon_bilgisi;
	@FXML
	private Label fax_bilgisi;
	@FXML
	private Label eposta_label;
	@FXML
	private Label eposta_bilgisi;
	@FXML
	private Tab motiontab;
	@FXML
	private AnchorPane motiontabanchorpane;
	@FXML
	private Label ilkfotolabel;
	@FXML
	private Label ikincifotolabel;
	@FXML
	private Label sonfotolabel;
	@FXML
	private ImageView ilkimageview;
	@FXML
	private ImageView ikinciimageview;
	@FXML
	private ImageView sonimageview;
	// the FXML button
	@FXML
	private Button ilkbutton;
	// the FXML button
	@FXML
	private Button ikincibutton;
	// the FXML button
	@FXML
	private Button sonbutton;
	@FXML
	private Tab music_player_tab;
	@FXML
	private AnchorPane music_player_tabanchorpane;
	@FXML
	private Button play_button;

	private WebEngine engine;
	private WebEngine onvif_engine;
	private DeviceDiscovery ws_discovery;

	private VideoCapture capture;
	// a timer for acquiring the video stream
	private Runnable frameGrabber;
	private ScheduledExecutorService camera_timer;
	private ScheduledExecutorService timer2;
	private static Mat frame;
	// image sequence
	private Mat old_img, new_img, last_img, motion;
	private Image imageToShow;
	private Image new_imageToShow;
	private Image old_imageToShow;
	private Image last_imageToShow;
	// a flag to change the button behavior
	private boolean camera_active;
	private int absoluteFaceSize;
	private CascadeClassifier faceCascade;
	private BackgroundSubtractorMOG2 bgsubtraction;
	private boolean player_active;
	@FXML
	private Tab media_player_tab;
	@FXML
	private AnchorPane media_player_tabanchorpane;
	@FXML
	private Button media_play_button;
	private boolean media_player_active;

	Scalar color;

	Mat dst;
	int i;
	long startTime;
	long endTime;
	long estimatedTime;

	// Callable<Moments> calc_moments;
	Runnable currentframe_updater;
	Runnable set_to_play_play_button;
	Runnable set_to_stop_play_button;
	Runnable set_to_start_start_button;
	Runnable set_to_stop_start_button;
	Runnable screanshut_updater;
	Runnable ilkimageview_updater;
	Runnable draw_contours_to_frame;
	MatOfByte buffer;
	MatOfByte buffer2;
	MatOfRect faces;
	Mat grayFrame;
	int a;
	Rect[] facesArray;
	byte[] buffer_array;
	byte[] buffer_array2;
	ByteArrayInputStream buffer_array_input_stream;
	ByteArrayInputStream buffer_array_input_stream2;
	private FileInputStream fileInputStream = null;
	private Player player;
	URL ip_camera_url = null;
	URL onvif_url = null;
	Mat fgMask1;
	Mat fgMask2;
	private String filePath;
	private MediaPlayer mediaPlayer;
	DynacolorAuthenticator dynacolor_authenticator;
	String classifierPath;
	FileChooser fileChooser;
	File file;
	int j;

	

	
	
	public JettyController() {

	}

	@FXML
	public void initialize() {
		color = new Scalar(0, 255, 0);
		imageToShow = null;
		currentframe_updater = new Runnable() {
			@Override
			public void run() {
				currentframe.setImage(imageToShow);
				// Utils.onFXThread(currentframe.imageProperty(), imageToShow);
			}
		};
		screanshut_updater = new Runnable() {
			@Override
			public void run() {
				screanshut.setImage(imageToShow);
				// Utils.onFXThread(currentframe.imageProperty(), imageToShow);
			}
		};
		ilkimageview_updater = new Runnable() {
			@Override
			public void run() {
				ilkimageview.setImage(old_imageToShow);
				// Utils.onFXThread(currentframe.imageProperty(), imageToShow);
			}
		};
//		calc_moments = new Callable<Moments>() {
//			@Override
//			public Moments call() {
//				synchronized (contours) {
//					return Imgproc.moments(contours.remove(0));
//				}
//			}
//		};

		draw_contours_to_frame = new Runnable() {
			@Override
			public void run() {
				int n = Runtime.getRuntime().availableProcessors();
				long startTime2;
				long endTime2;
				long estimatedTime2;
				Vector<MatOfPoint> contours;
				Mat hierarchy = null;
				Vector<Moments> mu = null;
				//Vector<Point> mc = null;
				int contours_size;
				ExecutorService executor;
				//ExecutorService executor2;
				Future<Moments> moments_future;
				//Future<Point> point_future;
				int mu_size = 0;
				executor = Executors.newFixedThreadPool(n);
				//executor2 = Executors.newFixedThreadPool(n);
				contours = new Vector<MatOfPoint>();
				hierarchy = new Mat();
				mu = new Vector<Moments>();
				//mc = new Vector<Point>();
				startTime2 = System.nanoTime();
				// System.out.println("motion detect");
//				//System.out.println("motion = new Mat();");
//				// detectfaces(frame);//imageToShow = Utils.mat2Image(frame);// face detection
//				//System.out.println("bgsubtraction.apply(frame, motion);");
				// draw contours every 21*33 ms

				// System.out.println(startTime2);

				// System.out.println("init");
//				dst = new Mat();
				Imgproc.equalizeHist(motion, motion);
				Imgproc.threshold(motion, motion, 40, 255, Imgproc.THRESH_BINARY | Imgproc.THRESH_OTSU);

				// System.out.println("aranýyor");
				if (contours != null) {
					//System.out.println("findContours");
					Imgproc.findContours(motion, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);
					contours_size = contours.size();
					if (contours_size > 0) {
						if (mu != null) {
							// ExecutorService executorService = Executors.newFixedThreadPool(2);
							// System.out.println("contours_size:" + contours_size);
							for (j = 0; j < contours_size; j++) {
								// future = executor.submit(calc_moments);
								// System.out.println("future = executor.submit(() -> {");
								try {
									final MatOfPoint moment = contours.get(j);
									moments_future = executor.submit(() -> {
										// System.out.println("contours.size():" + contours.size());
										return Imgproc.moments(moment);
									});
								} catch (IndexOutOfBoundsException e) {
									System.out.println("j:" + j);
									System.out.println("mu.size():" + mu.size());
									e.printStackTrace();
									System.exit(1);
									return;
								} catch (RejectedExecutionException e) {
									System.out.println("input.position(start); Exception");
									e.printStackTrace();
									System.exit(1);
									return;
								} catch (NullPointerException e) {
									System.out.println("input.position(start); Exception");
									e.printStackTrace();
									System.exit(1);
									return;
								}
								catch (Exception e) {
									System.out.println("input.position(start); Exception");
									e.printStackTrace();
									System.exit(1);
									return;
								}
								try {
									mu.add(moments_future.get());
									// IncompatibleClassChangeError
									// CancellationException
									// UnsupportedOperationException
									// ClassCastException
								} catch (IndexOutOfBoundsException e) {
									System.out.println("j:" + j);
									System.out.println("mu.size():" + mu.size());
									e.printStackTrace();
									System.exit(1);
									return;
								} catch (InterruptedException e) {
									System.out.println("input.position(start); Exception");
									e.printStackTrace();
									System.exit(1);
									return;
								} catch (ExecutionException e) {
									System.out.println("input.position(start); Exception");
									e.printStackTrace();
									System.exit(1);
									return;
								}
							}
							// System.out.println("Start");
							executor.shutdown();
							while (!executor.isTerminated()) {
							}
							// System.out.println("Finish");
//						try {
//				            executor.awaitTermination(1, TimeUnit.MINUTES);
//				        } catch (InterruptedException e) {
//				        	System.out.println("input.position(start); Exception");
//							e.printStackTrace();
//							System.exit(1);
//							return;
//				        }catch (Exception e) {
//							System.out.println("input.position(start); Exception");
//							e.printStackTrace();
//							System.exit(1);
//							return;
//						}
							mu_size = mu.size();
							if(mu_size>0) {
//								if (mc != null) {
//									int k;
//									for (k = 0; k < mu_size; k++) {
//										// add 1e-5 to avoid division by zero
//										final Moments moments = mu.get(k);
//										try {
//										point_future = executor2.submit(() -> {
//											// System.out.println("contours.size():" + contours.size());
//											return new Point(moments.m10 / (moments.m00 + 1e-5),
//													moments.m01 / (moments.m00 + 1e-5));
//										});
//										} catch (IndexOutOfBoundsException e) {
//											System.out.println("j:" + j);
//											System.out.println("mu.size():" + mu.size());
//											e.printStackTrace();
//											System.exit(1);
//											return;
//										} catch (RejectedExecutionException e) {
//											System.out.println("input.position(start); Exception");
//											e.printStackTrace();
//											System.exit(1);
//											return;
//										} catch (NullPointerException e) {
//											System.out.println("input.position(start); Exception");
//											e.printStackTrace();
//											System.exit(1);
//											return;
//										}
//										catch (Exception e) {
//											System.out.println("input.position(start); Exception");
//											e.printStackTrace();
//											System.exit(1);
//											return;
//										}
//										try {
//										mc.add(point_future.get());
//										// mc.add(new Point(mu.get(k).m10 / (mu.get(k).m00 + 1e-5),
//										// mu.get(k).m01 / (mu.get(k).m00 + 1e-5)));
//										} catch (IndexOutOfBoundsException e) {
//											System.out.println("j:" + j);
//											System.out.println("mu.size():" + mu.size());
//											e.printStackTrace();
//											System.exit(1);
//											return;
//										} catch (InterruptedException e) {
//											System.out.println("input.position(start); Exception");
//											e.printStackTrace();
//											System.exit(1);
//											return;
//										} catch (ExecutionException e) {
//											System.out.println("input.position(start); Exception");
//											e.printStackTrace();
//											System.exit(1);
//											return;
//										}
//									}
//									executor.shutdown();
//									while (!executor.isTerminated()) {
//									}
//									
//								}
							}
							motion = Mat.zeros(motion.size(), CvType.CV_8UC1);
//							System.out.println("contours.size():" + contours.size());
//							System.out.println("mu.size():" + mu.size());
//							System.out.println("mc.size():" + mc.size());
							int boyut=mu_size;
							if(contours_size<boyut) {boyut=contours_size;}
							int l;
							for (l = 0; l < boyut; l++) {
								if (contours.get(l).height() > 100 && Imgproc
										.arcLength(new MatOfPoint2f(contours.get(l).toArray()), true) > 100
										&& mu.get(l).m00 > 10) {
//										System.out.println("mu.get(l).m00" + mu.get(l).m00);
//										// 100 hassasiyet olsun
									synchronized (frame) {
										// System.out.println("çiziliyor");
										try {
										Imgproc.drawContours(frame, contours, l, color, 2, Core.LINE_8, hierarchy,
												0, new Point());
//										Imgproc.circle(frame, mc.get(l), 4, color, -1);
										}catch(Exception e) {
											System.out.println("input.position(start); Exception");
//											e.printStackTrace();
//											System.exit(1);
//											return;
										}
										}
								}
							}
						}
					}
				}
//				buffer2 = new MatOfByte();
//				Imgcodecs.imencode(".png", frame, buffer2);
//				if (buffer2 != null) {
//					buffer_array2 = buffer2.toArray();
//					if (buffer_array2 != null) {
//						buffer_array_input_stream2 = new ByteArrayInputStream(buffer_array2);
//						if (buffer_array_input_stream2 != null) {
//							imageToShow = new Image(buffer_array_input_stream2);
//						}
//					}
//				}
				// int m;
////	        System.out.println("\t Info: Area and Contour Length \n");
////	        for (i = 0; i < contours.size(); i++) {
////	            System.out.format(" * Contour[%d] - Area (M_00) = %.2f - Area OpenCV: %.2f - Length: %.2f\n", i,
////	                    mu.get(i).m00, Imgproc.contourArea(contours.get(i)),
////	                    Imgproc.arcLength(new MatOfPoint2f(contours.get(i).toArray()), true));
////	        }

				synchronized (frame) {
					imageToShow = Utils.mat2Image(frame);// motion detection
				}
				// Bu metod ile GUI deki bir metodu tetikliyoruz.
				if (imageToShow != null) {
					synchronized (imageToShow) {
						Platform.runLater(currentframe_updater);
						// System.out.println("yazdýrýldý2");
					}
				} else {
					// System.out.println("Empty buffer array imageToShow :(");
				}
				endTime2 = System.nanoTime();
				estimatedTime2 = endTime2 - startTime2; // Geçen süreyi nanosaniye cinsinden elde ediyoruz
				// double seconds = (double) estimatedTime / 1000000000; // saniyeye çevirmek
				// için milyar'a
				// bölüyoruz.
				System.out.println(estimatedTime2);
			}
		};
		frame = null;
		buffer = null;
		buffer_array = null;
		buffer_array_input_stream = null;
		imageToShow = null;
		frameGrabber = new Runnable() {

			@Override
			public void run() {
				startTime = System.nanoTime();
				try {
					// read the current frame
					capture.read(frame);
				} catch (Exception e) {
					System.err.println("Exception");
					e.printStackTrace();
					return;
				}
					// System.out.println("capture.read(frame);");
					// frame = grabFrame();
					// if the frame is not empty, process it
					if (frame != null) {
						// convert and show the frame
						/// Convert the image to Gray
						// Mat mat = new Mat(frame.height(), frame.width(), CvType.CV_8UC3);// face
						// detection
						// Imgproc.cvtColor(frame, mat, Imgproc.COLOR_RGB2GRAY);// face detection
						if (!frame.empty()) {
							motion = new Mat();
							if (motion != null) {
								synchronized (frame) {
									bgsubtraction.apply(frame, motion);// motion detection
								}
							} else {

							}
							
							
//							buffer = new MatOfByte();
//							Imgcodecs.imencode(".png", frame, buffer);
//							if (buffer != null) {
//								buffer_array = buffer.toArray();
//								if (buffer_array != null) {
//									buffer_array_input_stream = new ByteArrayInputStream(buffer_array);
//									if (buffer_array_input_stream != null) {
//										try {
//										imageToShow = new Image(buffer_array_input_stream);
//										}catch (NullPointerException e) {
//											System.err.println("Exception");
//											e.printStackTrace();
//											return;
//										} catch (Exception e) {
//											System.err.println("Exception");
//											e.printStackTrace();
//											return;
//										}
//										// imageToShow = Utils.mat2Image(frame);// motion detection
//										// Bu metod ile GUI deki bir metodu tetikliyoruz.
//										if (imageToShow != null) {
//											synchronized (imageToShow) {
//												Platform.runLater(currentframe_updater);
//												// System.out.println("yazdýrýldý1");
//											}
//										} else {
//											// System.out.println("Empty buffer array imageToShow :(");
//										}
//									} else {
//										// System.out.println("Empty buffer array input stream :(");
//									}
//								} else {
//									// System.out.println("Empty buffer array :(");
//								}
//							} else {
//								// System.out.println("Empty buffer :(");
//							}
							
							
							
							
							
						} else {
							// System.out.println("Empty frame :(");
						}
					} else {
						// System.out.println("Null frame :(");
					}
				
				if (motion != null) {
					Thread t = new Thread(draw_contours_to_frame);
					// threadlerin sýralý olarak bitmesi gerekiyor
					try {
						// EofException//IOException
						t.start();
					} catch (SecurityException e) {
						System.out.println("input.position(start); IOException");
						e.printStackTrace();
						System.exit(1);
						return;
					} catch (Exception e) {
						System.out.println("input.position(start); Exception");
						e.printStackTrace();
						System.exit(1);
						return;
					}
				}
				endTime = System.nanoTime();
				estimatedTime = endTime - startTime; // Geçen süreyi nanosaniye cinsinden elde ediyoruz
				// double seconds = (double) estimatedTime / 1000000000; // saniyeye çevirmek
				// için milyar'a
				// bölüyoruz.
				// System.err.println(estimatedTime);
			}
		};
		player = null;
		set_to_play_play_button = new Runnable() {
			@Override
			public void run() {
				try {
					// Bu metod ile GUI deki bir metodu tetikliyoruz.
					play_button.setText("Play");
				} catch (IllegalStateException e) {// IllegalStateException
					System.out.println("IllegalStateException");
					e.printStackTrace();
					return;
				} catch (NullPointerException e) {//
					System.err.println("Exception");
					e.printStackTrace();
					return;
				} catch (Exception e) {
					System.err.println("Exception");
					e.printStackTrace();
					return;
				}
			}
		};
		set_to_stop_play_button = new Runnable() {
			@Override
			public void run() {
				try {
					// Bu metod ile GUI deki bir metodu tetikliyoruz.
					play_button.setText("Stop");
				} catch (IllegalStateException e) {// IllegalStateException
					System.out.println("IllegalStateException");
					e.printStackTrace();
					return;
				} catch (NullPointerException e) {//
					System.err.println("Exception");
					e.printStackTrace();
					return;
				} catch (Exception e) {
					System.err.println("Exception");
					e.printStackTrace();
					return;
				}
			}
		};
		set_to_stop_start_button = new Runnable() {
			@Override
			public void run() {
				try {
					start_button.setText("Stop Camera");
				} catch (NullPointerException e) {
					System.err.println("NullPointerException");
					e.printStackTrace();
					return;
				} catch (Exception e) {
					System.err.println("Exception");
					e.printStackTrace();
					return;
				}
			}
		};
		set_to_start_start_button = new Runnable() {
			@Override
			public void run() {
				try {
					start_button.setText("Start Camera");
				} catch (NullPointerException e) {
					System.err.println("NullPointerException");
					e.printStackTrace();
					return;
				} catch (Exception e) {
					System.err.println("Exception");
					e.printStackTrace();
					return;
				}
			}
		};
		if (webview != null) {
			try {
				engine = webview.getEngine();
			} catch (NullPointerException e) {
				System.err.println("NullPointerException");
				e.printStackTrace();
				return;
			} catch (Exception e) {
				System.err.println("Exception");
				e.printStackTrace();
				return;
			}
		}
		if (onvif_webview != null) {
			try {
				onvif_engine = onvif_webview.getEngine();
			} catch (NullPointerException e) {
				System.err.println("NullPointerException");
				e.printStackTrace();
				return;
			} catch (Exception e) {
				System.err.println("Exception");
				e.printStackTrace();
				return;
			}
			try {
				ws_discovery = new DeviceDiscovery();
			} catch (NullPointerException e) {
				System.err.println("NullPointerException");
				e.printStackTrace();
				return;
			} catch (Exception e) {
				System.err.println("Exception");
				e.printStackTrace();
				return;
			}
			try {
				frame = new Mat();
			} catch (NullPointerException e) {
				System.err.println("NullPointerException");
				e.printStackTrace();
				return;
			} catch (Exception e) {
				System.err.println("Exception");
				e.printStackTrace();
				return;
			}
			camera_active = false;
			engine.setUserAgent(
					"Mozilla/5.0 (Linux; Android 5.0; SM-G900F Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.105 Mobile Safari/537.36");
			onvif_engine.setUserAgent(
					"Mozilla/5.0 (Linux; Android 5.0; SM-G900F Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.105 Mobile Safari/537.36");
			try {
				ip_camera_url = new URL("http://192.168.1.253");// ip camera adresi
			} catch (NullPointerException e) {
				System.err.println("NullPointerException");
				e.printStackTrace();
				return;
			} catch (MalformedURLException e1) {
				System.err.println("Exception");
				e1.printStackTrace();
				return;
			}catch (Exception e) {
				System.err.println("Exception");
				e.printStackTrace();
				return;
			}
			try {
				onvif_url = new URL("http://127.0.0.1:8080/home");
			} catch (NullPointerException e) {
				System.err.println("NullPointerException");
				e.printStackTrace();
				return;
			} catch (MalformedURLException e1) {
				System.err.println("Exception");
				e1.printStackTrace();
				return;
			}catch (Exception e) {
				System.err.println("Exception");
				e.printStackTrace();
				return;
			}
			dynacolor_authenticator = new DynacolorAuthenticator();
			/* if(camera.marka.string==dynacolor.string) */
			if (dynacolor_authenticator != null) {
				Authenticator.setDefault(dynacolor_authenticator);
				if (ip_camera_url != null) {
					try {
						// engine.executeScript("window.location =
						// \"http://192.168.1.36/cgi-bin/logout.cgi?\";");
						engine.load(ip_camera_url.toString());
					} catch (NullPointerException e) {
						System.err.println("NullPointerException");
						e.printStackTrace();
						return;
					} catch (Exception e) {
						System.err.println("Exception");
						e.printStackTrace();
						return;
					}
				}else {
					
				}
			}
		}
		if (onvif_url != null) {
			try {
				// engine.executeScript("window.location =
				// \"http://192.168.1.36/cgi-bin/logout.cgi?\";");
				onvif_engine.load(onvif_url.toString());
			} catch (NullPointerException e) {
				System.err.println("NullPointerException");
				e.printStackTrace();
				return;
			} catch (Exception e) {
				System.err.println("Exception");
				e.printStackTrace();
				return;
			}
		}else {
			
		}
		capture = new VideoCapture();
		faceCascade = new CascadeClassifier();
		String classifierPath = "C:\\opencv\\build\\etc\\haarcascades\\haarcascade_frontalface_default.xml";
		faceCascade.load(classifierPath);
		absoluteFaceSize = 0;
		// set a fixed width for the frame
		// currentframe.setFitWidth(600);
		// preserve image ratio
		// currentframe.setPreserveRatio(true);
		bgsubtraction = Video.createBackgroundSubtractorMOG2();
		camera_active = false;
		setPlayer_active(false);
		media_player_active = false;
	}

	@FXML
	protected void start_camera(ActionEvent event) {
		// capture = new VideoCapture();
		// System.out.print("capture = new VideoCapture();");

		/*
		 * web kamerasý kullanýyorsanýz usb giriþinin hýzlý bir porta takýldýðýndan emin
		 * olmanýz gerekiyor.baðlantý süresi yavaþ olursa timer metodu ile görüntü
		 * alamayabilirsiniz.
		 */
		if (!camera_active) {
			System.out.println("kamera aktifleþtiriliyor");
			if (capture != null) {
				try {
					capture.open(0);
					/*
					 * GUI içerisinde network_url isimli textbox bulunmaktadýr. urinin text boxtan
					 * alýnmasý gerekmektedir.
					 */
					//capture.open(network_url.getText());
				} catch (NullPointerException e) {
					System.err.println("NullPointerException");
					e.printStackTrace();
					return;
				} catch (Exception e) {
					System.err.println("Exception");
					e.printStackTrace();
					return;
				}
				// System.out.print("capture.open(network_url.getText());");
				// rtsp://184.72.239.149/vod/mp4:BigBuckBunny_175k.mov
				// rtsp://192.168.1.40/h264
				if (!capture.isOpened()) {
					// System.out.print("Not opened :( \r");
					// log the error
					System.err.println("Failed to open the camera connection...");
				} else {
					// init everything
					// Kamera acildi mi ?
					System.out.println("Opened :( \r");
					camera_active = true;
					// grab a frame every 33 ms (30 frames/sec)
					camera_timer = Executors.newSingleThreadScheduledExecutor();
					// timer.scheduleWithFixedDelay(frameGrabber, 0, 699999993,
					// TimeUnit.NANOSECONDS);
					if (camera_timer != null) {                         //212713900
						//ip camera 699999993
						// web cam 166666665
						camera_timer.scheduleAtFixedRate(frameGrabber, 0, 166666665, TimeUnit.NANOSECONDS);
					} else {
						System.err.println("timer null");
						return;
					}
//					timer2 = Executors.newSingleThreadScheduledExecutor();
//					if (timer2 != null) {
//						timer2.scheduleWithFixedDelay(draw_contours_to_frame, 0, 699999993, TimeUnit.NANOSECONDS);
//						// timer2.scheduleAtFixedRate(draw_contours_to_frame, 0, 699999993,
//						// TimeUnit.NANOSECONDS);
//					} else {
//						System.err.println("timer null");
//						return;
//					}
					Platform.runLater(set_to_stop_start_button);
				}
			} else {
				// System.out.print("capture is null");
			}
		} else {
			// System.out.print("kamera durduruluyor");
			camera_active = false;
			Platform.runLater(set_to_start_start_button);
			// stop the timer
			this.stopAcquisition();
		}
	}

	@SuppressWarnings("unused")
	private Mat findContours(Mat src) {
		List<MatOfPoint> contours = new ArrayList<>();
		Mat srcGray = new Mat();
		Mat hierarchy = new Mat();
		Imgproc.cvtColor(src, srcGray, Imgproc.COLOR_BGR2GRAY);
		Imgproc.findContours(srcGray, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);
		List<Moments> mu = new ArrayList<>(contours.size());
		for (int i = 0; i < contours.size(); i++) {
			mu.add(Imgproc.moments(contours.get(i)));
		}
		List<Point> mc = new ArrayList<>(contours.size());
		for (int i = 0; i < contours.size(); i++) {
			// add 1e-5 to avoid division by zero
			mc.add(new Point(mu.get(i).m10 / (mu.get(i).m00 + 1e-5), mu.get(i).m01 / (mu.get(i).m00 + 1e-5)));
		}
		Mat drawing = Mat.zeros(srcGray.size(), CvType.CV_8UC3);
		for (int i = 0; i < contours.size(); i++) {
			Scalar color = new Scalar(0, 255, 0);// new Scalar(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
			Imgproc.drawContours(drawing, contours, i, color, 2, Core.LINE_8, hierarchy, 0, new Point());
			Imgproc.circle(drawing, mc.get(i), 4, color, -1);
		}
		System.out.println("\t Info: Area and Contour Length \n");
		for (int i = 0; i < contours.size(); i++) {
			System.out.format(" * Contour[%d] - Area (M_00) = %.2f - Area OpenCV: %.2f - Length: %.2f\n", i,
					mu.get(i).m00, Imgproc.contourArea(contours.get(i)),
					Imgproc.arcLength(new MatOfPoint2f(contours.get(i).toArray()), true));
		}
		return drawing;
	}

	@SuppressWarnings("unused")
	private Mat grabFrame() {
		Mat frame = new Mat();
		// check if the capture is open
		if (capture.isOpened()) {
			try {
				// read the current frame
				capture.read(frame);
				// if the frame is not empty, process it
				if (!frame.empty()) {
					// face detection
					this.detectfaces(frame);
				}
			} catch (Exception e) {
				// log the (full) error
				System.err.println("Exception during the image elaboration: " + e);
			}
		}
		return frame;
	}

	private void detectfaces(Mat frame) {
		faces = new MatOfRect();
		grayFrame = new Mat();

		// convert the frame in gray scale
		Imgproc.cvtColor(frame, grayFrame, Imgproc.COLOR_BGR2GRAY);
		// equalize the frame histogram to improve the result
		Imgproc.equalizeHist(grayFrame, grayFrame);

		// compute minimum face size (10% of the frame height, in our case)
//		if (this.absoluteFaceSize == 0) {
//			int height = grayFrame.rows();
//			if (Math.round(height * 0.1f) > 0) {
//				this.absoluteFaceSize = Math.round(height * 0.1f);
//			}
//		}
		absoluteFaceSize = 16;
		// detect faces
		faceCascade.detectMultiScale(grayFrame, faces, 2, 2, 0 | Objdetect.CASCADE_SCALE_IMAGE,
				new Size(absoluteFaceSize, absoluteFaceSize), new Size());
		// each rectangle in faces is a face: draw them!
		facesArray = faces.toArray();
		for (a = 0; a < facesArray.length; a++)
			Imgproc.rectangle(frame, facesArray[a].tl(), facesArray[a].br(), new Scalar(255, 0, 0), 3);
	}

	public VideoCapture getCapture() {
		return capture;
	}

	public void setCapture(VideoCapture capture) {
		this.capture = capture;
	}

	/**
	 * Stop the acquisition from the camera and release all the resources
	 */
	private void stopAcquisition() {
		if (camera_timer != null && !camera_timer.isShutdown()) {
			try {
				// stop the timer
				camera_timer.shutdown();
			} catch (SecurityException e) {
				// log any exception
				System.err.println(
						"Resim çekme iþlemi durdurulurken hata oluþtu,kamera serbest býrakýlmaya çalýþýlýyor." + e);
				return;
			} catch (Exception e) {
				// log the error
				System.err.println("Exception " + e);
				e.printStackTrace();
				return;
			}
		}
		if (capture.isOpened()) {
			// release the camera
			capture.release();
			System.out.println("Kamera kapatýldý");
		} else {
			System.out.println("Kamera zaten kapalý");
		}
	}

	@FXML
	protected void take_screanshut(ActionEvent event) {
		// updateImageView(screanshut, imageToShow);
		Platform.runLater(screanshut_updater);
	}

	@FXML
	protected void firstscreanshut(ActionEvent event) {
		if (frame != null) {
			old_img = frame;// java.lang.ArrayIndexOutOfBoundsException
			fgMask1 = new Mat();
			bgsubtraction.apply(old_img, fgMask1);
			// Imgproc.cvtColor(old_img, old_img, Imgproc.COLOR_RGB2GRAY);
			old_imageToShow = Utils.mat2Image(fgMask1);
			Platform.runLater(ilkimageview_updater);
			// updateImageView(ilkimageview, old_imageToShow);
			// output nesnesini kullanabilirsiniz
		} else {
			System.out.println("frame null!");
		}
	}

	@FXML
	protected void secondscreanshut(ActionEvent event) {
		if (frame != null) {
			new_img = frame;
			fgMask2 = new Mat();
			bgsubtraction.apply(new_img, fgMask2);
			// Imgproc.cvtColor(new_img, new_img, Imgproc.COLOR_RGB2GRAY);
			new_imageToShow = Utils.mat2Image(fgMask2);
			updateImageView(ikinciimageview, new_imageToShow);
		}
	}

	@FXML
	protected void lastscreanshut(ActionEvent event) {
		if (fgMask2 != null && fgMask2 != null) {
			last_img = new Mat();
			Core.absdiff(fgMask2, fgMask1, last_img);
			last_imageToShow = Utils.mat2Image(last_img);
			updateImageView(sonimageview, last_imageToShow);
		}
	}

	private static void updateImageView(ImageView currentframe, Image imageToShow) {
		Utils.onFXThread(currentframe.imageProperty(), imageToShow);
	}

	@FXML
	protected void find_onvif_devices(ActionEvent event) {
		try {
			onvif_ip_device_list.setText(ws_discovery.onvif_device_uri_list());
		} catch (Exception e) {
			System.out.println("find_onvif_devices(ActionEvent event)");
			e.printStackTrace();
			return;
		}
	}

	/**
	 * @return the camera_active
	 */
	public boolean isCamera_active() {
		return camera_active;
	}

	/**
	 * @param camera_active the camera_active to set
	 */
	public void setCamera_active(boolean camera_active) {
		this.camera_active = camera_active;
	}

	/**
	 * @return the motion
	 */
	public Mat getMotion() {
		return motion;
	}

	/**
	 * @param motion the motion to set
	 */
	public void setMotion(Mat motion) {
		this.motion = motion;
	}

	@FXML
	protected void play_media(ActionEvent event) {
		if (!media_player_active) {
			fileChooser = new FileChooser();
			FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("select your media(*.mp4)",
					new String[] { "*.mp4" });
			fileChooser.getExtensionFilters().add(filter);
			file = fileChooser.showOpenDialog(null);
			filePath = file.toURI().toString();
			if (filePath != null) {
				Media media = new Media(filePath);
				mediaPlayer = new MediaPlayer(media);
				mediaView.setMediaPlayer(mediaPlayer);
				DoubleProperty width = mediaView.fitWidthProperty();
				DoubleProperty hieght = mediaView.fitHeightProperty();
				width.bind(Bindings.selectDouble(mediaView.sceneProperty(), new String[] { "width" }));
				hieght.bind(Bindings.select(mediaView.sceneProperty(), new String[] { "hieght" }));
				mediaPlayer.play();
			}
		}
	}

	@FXML
	protected void play_music(ActionEvent event) {
		if (!player_active) {
			try {
				fileInputStream = new FileInputStream(
						"beep-21.mp3");/* dosya adýnýn deðiþken hale getirilmesi gerekmektedir. */
			} catch (FileNotFoundException e) {
				System.err.println("Exception");
				e.printStackTrace();
				return;
			} catch (Exception e) {
				System.err.println("Exception");
				e.printStackTrace();
				return;
			}
			try {
				player = new Player(fileInputStream);
			} catch (JavaLayerException e) {
				System.err.println("Exception");
				e.printStackTrace();
				return;
			} catch (Exception e) {
				System.err.println("Exception");
				e.printStackTrace();
				return;
			}
			try {
				player.play();
			} catch (JavaLayerException e) {
				System.err.println("Exception");
				e.printStackTrace();
				return;
			} catch (Exception e) {
				System.err.println("Exception");
				e.printStackTrace();
				return;
			}
			player_active = false;
			Platform.runLater(set_to_play_play_button);
			player.close();
			try {
				fileInputStream.close();
			} catch (IOException e) {
				System.err.println("Exception");
				e.printStackTrace();
				return;
			} catch (SecurityException e) {
				System.err.println("Exception");
				e.printStackTrace();
				return;
			} catch (Exception e) {
				System.err.println("Exception");
				e.printStackTrace();
				return;
			}
			System.out.println("Þarký bitti");
			player_active = true;
			Platform.runLater(set_to_stop_play_button);
		} else {
			stop_music();
		}
	}

	public void stop_music() {
		player_active = false;
		Platform.runLater(set_to_play_play_button);
		player.close();
		try {// EofException//IOException
			fileInputStream.close();
		} catch (IOException e) {
			System.err.println("Exception");
			e.printStackTrace();
			return;
		} catch (SecurityException e) {
			System.err.println("Exception");
			e.printStackTrace();
			return;
		} catch (Exception e) {
			System.err.println("Exception");
			e.printStackTrace();
			return;
		}
	}

	/**
	 * @return the player_active
	 */
	public boolean isPlayer_active() {
		return player_active;
	}

	/**
	 * @param player_active the player_active to set
	 */
	public void setPlayer_active(boolean player_active) {
		this.player_active = player_active;
	}

	/**
	 * @return the media_player_active
	 */
	public boolean isMedia_player_active() {
		return media_player_active;
	}

	/**
	 * @param media_player_active the media_player_active to set
	 */
	public void setMedia_player_active(boolean media_player_active) {
		this.media_player_active = media_player_active;
	}

	/**
	 * @return the timer2
	 */
	public ScheduledExecutorService getTimer2() {
		return timer2;
	}

	/**
	 * @param timer2 the timer2 to set
	 */
	public void setTimer2(ScheduledExecutorService timer2) {
		this.timer2 = timer2;
	}
}
