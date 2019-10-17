package application.web;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import application.web.pages.Favicon;
import application.web.pages.H264_2_page;
import application.web.pages.Home_page;
import application.web.pages.IP_Camera_page;
import application.web.pages.Not_found_page;
import application.web.pages.Root_page;
import application.web.pages.Stream_page;
import application.web.pages.Video_page;
import specification.accescontrol.Accesscontrol_page;
import specification.actionengine.Actionengine_page;
import specification.advancedsecurity.Advancedsecurity_page;
import specification.analitics.Analytics_page;
import specification.analiticsdevice.Analyticsdevice_page;
import specification.authenticationbehavior.Authenticationbehavior_page;
import specification.credential.Credential_page;
import specification.deviceio.Deviceio_page;
//import specification.deviceio.DeviceBinding_page;
//import specification.devicemanagement.DeviceBinding_page;
import specification.devicemanagement.Devicemanagement_page;
import specification.display.Display_page;
import specification.doorcontrol.Doorcontrol_page;
import specification.enumeration.Environment;
import specification.event.Event_page;
import specification.imaging.Imaging_page;
import specification.media.Media_page;
import specification.media2.Media2_page;
import specification.provisioning.Provisioning_page;
import specification.ptz.Ptz_page;
import specification.receiver.Receiver_page;
import specification.recording.Recording_page;
import specification.replay.Replay_page;
import specification.schedule.Schedule_page;
import specification.search.Search_page;
import specification.thermal.Thermal_page;

public class Pages extends AbstractHandler {

	public Root_page root_page = null;
	public Home_page home_page = null;
	public Video_page video_page = null;
	public H264_2_page h264_2_page = null;
	public Stream_page stream_page = null;
	public Favicon favicon_page = null;
	public Not_found_page not_found_page = null;
	public Devicemanagement_page devicemanagement_page = null;
	public Accesscontrol_page accesscontrol_page = null;
	public Actionengine_page actionengine_page = null;
	public Advancedsecurity_page advancedsecurity_page = null;
	public Analytics_page analytics_page = null;
	public Analyticsdevice_page analyticsdevice_page = null;
	public Authenticationbehavior_page authenticationbehavior_page = null;
	public Credential_page credential_page = null;
	public Deviceio_page deviceio_page = null;
	public Display_page display_page = null;
	public Doorcontrol_page doorcontrol_page = null;
	public Event_page event_page = null;
	public Imaging_page imaging_page = null;
	public Media_page media_page = null;
	public Media2_page media2_page = null;
	public Provisioning_page provisioning_page = null;
	public Ptz_page ptz_page = null;
	public Receiver_page receiver_page = null;
	public Recording_page recording_page = null;
	public Replay_page replay_page = null;
	public Schedule_page schedule_page = null;
	public Search_page search_page = null;
	public Thermal_page thermal_page = null;
	// public specification.devicemanagement.DeviceBinding_page
	// devicemanagement_devicebinding_page = null;
	// public specification.deviceio.DeviceBinding_page deviceio_devicebinding_page
	// = null;

	public Pages() {
	}

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private void init_pages() {
		root_page = new Root_page("/");
		home_page = new Home_page("/home");
		video_page = new Video_page("/video");
		h264_2_page = new H264_2_page("/h264_2");
		stream_page = new Stream_page("/stream");
		favicon_page = new Favicon("/favicon.ico");
		not_found_page = new Not_found_page("/not_found");
		devicemanagement_page = new Devicemanagement_page("/devicemanagement");
		accesscontrol_page = new Accesscontrol_page("/accesscontrol");
		actionengine_page = new Actionengine_page("/actionengine");
		advancedsecurity_page = new Advancedsecurity_page("/advancedsecurity");
		analytics_page = new Analytics_page("/analytics");
		analyticsdevice_page = new Analyticsdevice_page("/analyticsdevice");
		authenticationbehavior_page = new Authenticationbehavior_page("/authenticationbehavior");
		credential_page = new Credential_page("/credential");
		deviceio_page = new Deviceio_page("/deviceio");
		display_page = new Display_page("/display");
		doorcontrol_page = new Doorcontrol_page("/doorcontrol");
		event_page = new Event_page("/event");
		imaging_page = new Imaging_page("/imaging");
		media_page = new Media_page("/media");
		media2_page = new Media2_page("/media2");
		provisioning_page = new Provisioning_page("/provisioning");
		ptz_page = new Ptz_page("/ptz");
		receiver_page = new Receiver_page("/receiver");
		recording_page = new Recording_page("/recording");
		replay_page = new Replay_page("/replay");
		schedule_page = new Schedule_page("/schedule");
		search_page = new Search_page("/search");
		thermal_page = new Thermal_page("/thermal");
		// devicemanagement_devicebinding_page = new
		// specification.devicemanagement.DeviceBinding_page("/DeviceBinding");
		// deviceio_devicebinding_page = new
		// specification.deviceio.DeviceBinding_page("/DeviceBinding");
	}

	private PrintWriter out = null;
	private String requestURI = null;

	public PrintWriter getOut() {
		return out;
	}

	public void setOut(PrintWriter out) {
		this.out = out;
	}

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request,
			final HttpServletResponse response) {
		requestURI = request.getRequestURI();
		if (requestURI == null || requestURI.isEmpty() == true) {
			System.out.println("DEBUG:1");
			load_not_found_page(target, baseRequest, request, response);
		} else {
			if (requestURI.equals(Environment.favicon_page.getURI())) {
				load_favicon(target.substring(Environment.favicon_page.getSize()), baseRequest, request, response);
			} else {
				if (requestURI.equals(Environment.root_page.getURI())) {
					load_home_page(target.substring(Environment.root_page.getSize()), baseRequest, request, response);
				} else {
					if (requestURI.equals(Environment.home_page.getURI())) {
						load_home_page(target.substring(Environment.home_page.getSize()), baseRequest, request,
								response);
					} else {
						if (requestURI.equals(Environment.video_page.getURI())) {
							System.out.println("requestURI.equals(Environment.video_page.getURI()");
							load_video_page(target.substring(Environment.video_page.getSize()), baseRequest, request,
									response);
						} else {
							if (requestURI.equals(Environment.h264_2_page.getURI())) {
								System.out.println("Environment.h264_2_page.getURI()");
								load_h264_2_page(target.substring(Environment.h264_2_page.getSize()), baseRequest,
										request, response);
							} else {
								if (requestURI.equals(Environment.ip_camera_page.getURI())) {
									System.out.println("Environment.ip_camera_page.getURI()");
									load_ip_camera_page(target.substring(Environment.ip_camera_page.getSize()), baseRequest,
											request, response);
								} else {
									if (requestURI.equals(Environment.stream_page.getURI())) {
										System.out.println("Environment.stream_page.getURI()");
										load_stream_page(target.substring(Environment.stream_page.getSize()),
												baseRequest, request, response);
									} else {
										if (requestURI.startsWith(Environment.devicemanagement_page.getURI())) {
											load_devicemanagement_page(
													target.substring(Environment.devicemanagement_page.getSize()),
													baseRequest, request, response);
										} else {
											if (requestURI.startsWith(Environment.accesscontrol_page.getURI())) {
												load_accesscontrol_page(
														target.substring(Environment.accesscontrol_page.getSize()),
														baseRequest, request, response);
											} else {
												if (requestURI.startsWith(Environment.actionengine_page.getURI())) {
													load_actionengine_page(
															target.substring(Environment.actionengine_page.getSize()),
															baseRequest, request, response);
												} else {
													if (requestURI
															.startsWith(Environment.advancedsecurity_page.getURI())) {
														load_advancedsecurity_page(
																target.substring(
																		Environment.advancedsecurity_page.getSize()),
																baseRequest, request, response);
													} else {
														if (requestURI
																.startsWith(Environment.analytics_page.getURI())) {
															load_analytics_page(
																	target.substring(
																			Environment.analytics_page.getSize()),
																	baseRequest, request, response);
														} else {
															if (requestURI.startsWith(
																	Environment.analyticsdevice_page.getURI())) {
																load_analyticsdevice_page(target.substring(
																		Environment.analyticsdevice_page.getSize()),
																		baseRequest, request, response);
															} else {
																if (requestURI.startsWith(
																		Environment.authenticationbehavior_page
																				.getURI())) {
																	load_authenticationbehavior_page(target.substring(
																			Environment.authenticationbehavior_page
																					.getSize()),
																			baseRequest, request, response);
																} else {
																	if (requestURI.startsWith(
																			Environment.credential_page.getURI())) {
																		load_credential_page(target.substring(
																				Environment.credential_page.getSize()),
																				baseRequest, request, response);
																	} else {
																		if (requestURI.startsWith(
																				Environment.deviceio_page.getURI())) {
																			load_deviceio_page(
																					target.substring(
																							Environment.deviceio_page
																									.getSize()),
																					baseRequest, request, response);
																		} else {
																			if (requestURI
																					.startsWith(Environment.display_page
																							.getURI())) {
																				load_display_page(
																						target.substring(
																								Environment.display_page
																										.getSize()),
																						baseRequest, request, response);
																			} else {
																				if (requestURI.startsWith(
																						Environment.doorcontrol_page
																								.getURI())) {
																					load_doorcontrol_page(
																							target.substring(
																									Environment.doorcontrol_page
																											.getSize()),
																							baseRequest, request,
																							response);
																				} else {
																					if (requestURI.startsWith(
																							Environment.event_page
																									.getURI())) {
																						load_event_page(
																								target.substring(
																										Environment.event_page
																												.getSize()),
																								baseRequest, request,
																								response);
																					} else {
																						if (requestURI.startsWith(
																								Environment.imaging_page
																										.getURI())) {
																							load_imaging_page(
																									target.substring(
																											Environment.imaging_page
																													.getSize()),
																									baseRequest,
																									request, response);
																						} else {
																							if (requestURI.startsWith(
																									Environment.media_page
																											.getURI())) {
																								load_media_page(target
																										.substring(
																												Environment.media_page
																														.getSize()),
																										baseRequest,
																										request,
																										response);
																							} else {
																								if (requestURI
																										.startsWith(
																												Environment.media2_page
																														.getURI())) {
																									load_media2_page(
																											target.substring(
																													Environment.media2_page
																															.getSize()),
																											baseRequest,
																											request,
																											response);
																								} else {
																									if (requestURI
																											.startsWith(
																													Environment.provisioning_page
																															.getURI())) {
																										load_provisioning_page(
																												target.substring(
																														Environment.provisioning_page
																																.getSize()),
																												baseRequest,
																												request,
																												response);
																									} else {
																										if (requestURI
																												.startsWith(
																														Environment.ptz_page
																																.getURI())) {
																											load_ptz_page(
																													target.substring(
																															Environment.ptz_page
																																	.getSize()),
																													baseRequest,
																													request,
																													response);
																										} else {
																											if (requestURI
																													.startsWith(
																															Environment.receiver_page
																																	.getURI())) {
																												load_receiver_page(
																														target.substring(
																																Environment.receiver_page
																																		.getSize()),
																														baseRequest,
																														request,
																														response);
																											} else {
																												if (requestURI
																														.startsWith(
																																Environment.recording_page
																																		.getURI())) {
																													load_recording_page(
																															target.substring(
																																	Environment.recording_page
																																			.getSize()),
																															baseRequest,
																															request,
																															response);
																												} else {
																													if (requestURI
																															.startsWith(
																																	Environment.replay_page
																																			.getURI())) {
																														load_replay_page(
																																target.substring(
																																		Environment.replay_page
																																				.getSize()),
																																baseRequest,
																																request,
																																response);
																													} else {
																														if (requestURI
																																.startsWith(
																																		Environment.schedule_page
																																				.getURI())) {
																															load_schedule_page(
																																	target.substring(
																																			Environment.schedule_page
																																					.getSize()),
																																	baseRequest,
																																	request,
																																	response);
																														} else {
																															if (requestURI
																																	.startsWith(
																																			Environment.search_page
																																					.getURI())) {
																																load_search_page(
																																		target.substring(
																																				Environment.search_page
																																						.getSize()),
																																		baseRequest,
																																		request,
																																		response);
																															} else {
																																if (requestURI
																																		.startsWith(
																																				Environment.thermal_page
																																						.getURI())) {
																																	load_thermal_page(
																																			target.substring(
																																					Environment.thermal_page
																																							.getSize()),
																																			baseRequest,
																																			request,
																																			response);
																																} else {
																																	if (requestURI
																																			.startsWith(
																																					Environment.not_found_page
																																							.getURI())) {
																																		load_not_found_page(
																																				target.substring(
																																						Environment.not_found_page
																																								.getSize()),
																																				baseRequest,
																																				request,
																																				response);
																																	} else {
																																		requestURI = request
																																				.getRequestURI();
																																		System.out
																																				.println(
																																						"requestURI:"
																																								+ requestURI);
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

		return;
	}

	@SuppressWarnings("unused")
	private void load_ip_camera_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		IP_Camera_page ip_camera_page = null;
		ip_camera_page = new IP_Camera_page(Environment.ip_camera_page.getURI());
		if (ip_camera_page != null) {
			ip_camera_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_h264_2_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		H264_2_page h264_2_page = null;
		h264_2_page = new H264_2_page(Environment.h264_2_page.getURI());
		if (h264_2_page != null) {
			h264_2_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_thermal_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Thermal_page thermal_page = null;
		thermal_page = new Thermal_page(Environment.thermal_page.getURI());
		if (thermal_page != null) {
			thermal_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_search_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Search_page search_page = null;
		search_page = new Search_page(Environment.search_page.getURI());
		if (search_page != null) {
			search_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_schedule_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Schedule_page schedule_page = null;
		schedule_page = new Schedule_page(Environment.schedule_page.getURI());
		if (schedule_page != null) {
			schedule_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_replay_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Replay_page replay_page = null;
		replay_page = new Replay_page(Environment.replay_page.getURI());
		if (replay_page != null) {
			replay_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_recording_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Recording_page recording_page = null;
		recording_page = new Recording_page(Environment.recording_page.getURI());
		if (recording_page != null) {
			recording_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_receiver_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Receiver_page receiver_page = null;
		receiver_page = new Receiver_page(Environment.receiver_page.getURI());
		if (receiver_page != null) {
			receiver_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_ptz_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Ptz_page ptz_page = null;
		ptz_page = new Ptz_page(Environment.ptz_page.getURI());
		if (ptz_page != null) {
			ptz_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_provisioning_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Provisioning_page provisioning_page = null;
		provisioning_page = new Provisioning_page(Environment.provisioning_page.getURI());
		if (provisioning_page != null) {
			provisioning_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_media2_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Media2_page media2_page = null;
		media2_page = new Media2_page(Environment.media2_page.getURI());
		if (media2_page != null) {
			media2_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_media_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Media_page media_page = null;
		media_page = new Media_page(Environment.media_page.getURI());
		if (media_page != null) {
			media_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_imaging_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Imaging_page imaging_page = null;
		imaging_page = new Imaging_page(Environment.imaging_page.getURI());
		if (imaging_page != null) {
			imaging_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_event_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Event_page event_page = null;
		event_page = new Event_page(Environment.event_page.getURI());
		if (event_page != null) {
			event_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_doorcontrol_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Doorcontrol_page doorcontrol_page = null;
		doorcontrol_page = new Doorcontrol_page(Environment.doorcontrol_page.getURI());
		if (doorcontrol_page != null) {
			doorcontrol_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_display_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Display_page display_page = null;
		display_page = new Display_page(Environment.display_page.getURI());
		if (display_page != null) {
			display_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_deviceio_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Deviceio_page deviceio_page = null;
		deviceio_page = new Deviceio_page(Environment.deviceio_page.getURI());
		if (deviceio_page != null) {
			deviceio_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_credential_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Credential_page credential_page = null;
		credential_page = new Credential_page(Environment.credential_page.getURI());
		if (credential_page != null) {
			credential_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_authenticationbehavior_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Authenticationbehavior_page authenticationbehavior_page = null;
		authenticationbehavior_page = new Authenticationbehavior_page(Environment.authenticationbehavior_page.getURI());
		if (authenticationbehavior_page != null) {
			authenticationbehavior_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_analyticsdevice_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Analyticsdevice_page analyticsdevice_page = null;
		analyticsdevice_page = new Analyticsdevice_page(Environment.analyticsdevice_page.getURI());
		if (analyticsdevice_page != null) {
			analyticsdevice_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_analytics_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Analytics_page analytics_page = null;
		analytics_page = new Analytics_page(Environment.analytics_page.getURI());
		if (analytics_page != null) {
			analytics_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_advancedsecurity_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Advancedsecurity_page advancedsecurity_page = null;
		advancedsecurity_page = new Advancedsecurity_page(Environment.advancedsecurity_page.getURI());
		if (advancedsecurity_page != null) {
			advancedsecurity_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_actionengine_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Actionengine_page actionengine_page = null;
		actionengine_page = new Actionengine_page(Environment.actionengine_page.getURI());
		if (actionengine_page != null) {
			actionengine_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_accesscontrol_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Accesscontrol_page accesscontrol_page = null;
		accesscontrol_page = new Accesscontrol_page(Environment.accesscontrol_page.getURI());
		if (accesscontrol_page != null) {
			accesscontrol_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	@SuppressWarnings("unused")
	private void load_devicemanagement_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Devicemanagement_page devicemanagement_page = null;
		devicemanagement_page = new Devicemanagement_page(Environment.devicemanagement_page.getURI());
		if (devicemanagement_page != null) {
			devicemanagement_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	/**
	 * @param request
	 */
	@SuppressWarnings("unused")
	private void requestURI_toString(HttpServletRequest request) {
		requestURI = request.getRequestURI();
		System.out.println("requestURI:" + requestURI);
	}

	@SuppressWarnings("unused")
	private void load_home_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("requestURI:" + request.getRequestURI());
		Home_page home_page = null;
		home_page = new Home_page(Environment.home_page.getURI());
		if (home_page != null) {
			home_page.load(target, baseRequest, request, response);
		} else {
			System.out.println("Home_page null!");
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
	 */
	@SuppressWarnings("unused")
	private void load_favicon(String target, Request baseRequest, HttpServletRequest request,
			final HttpServletResponse response) {
		Favicon favicon = null;
		favicon = new Favicon(Environment.favicon_page.getURI());
		if (favicon != null) {
			favicon.load(target, baseRequest, request, response);
		} else {
			System.out.println("Favicon null!");
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
		System.out.println("Hata Pages class içerisinde");
		System.out.println("requestURI:" + request.getRequestURI());
		Not_found_page not_found_page = null;
		not_found_page = new Not_found_page(Environment.not_found_page.getURI());
		if (not_found_page != null) {
			not_found_page.load(target, baseRequest, request, response);
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
	 * @throws NumberFormatException
	 */
	@SuppressWarnings("unused")
	private void load_stream_page(String target, Request baseRequest, HttpServletRequest request,
			final HttpServletResponse response) {
		System.out.println("load_stream_page");
		Stream_page stream_page = null;
		stream_page = new Stream_page(Environment.stream_page.getURI());
		if (stream_page != null) {
			stream_page.load(target, baseRequest, request, response);
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
	 */
	@SuppressWarnings("unused")
	private void load_video_page(String target, Request baseRequest, HttpServletRequest request,
			final HttpServletResponse response) {
		Video_page video_page = null;
		video_page = new Video_page(Environment.video_page.getURI());
		if (video_page != null) {
			video_page.load(target, baseRequest, request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}
}
