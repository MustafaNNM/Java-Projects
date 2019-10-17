/**
 * 
 */
package specification.recording;

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
public class Recording_page extends Page{
	private String requestURI;// loglanması gerekiyor.

	private String sayfalar;
	
	private String requestler;

	public Recording_page(String string) {
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
		requestler = "<a href=\"http://localhost:8080/recording/RecordingBinding/CreateRecording\">CreateRecording</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/CreateRecordingJob\">CreateRecordingJob</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/CreateTrack\">CreateTrack</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/DeleteRecording\">DeleteRecording</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/DeleteRecordingJob\">DeleteRecordingJob</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/DeleteTrack\">DeleteTrack</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/ExportRecordedData\">ExportRecordedData</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/GetExportRecordedDataState\">GetExportRecordedDataState</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/GetRecordingConfiguration\">GetRecordingConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/GetRecordingJobConfiguration\">GetRecordingJobConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/GetRecordingJobs\">GetRecordingJobs</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/GetRecordingJobState\">GetRecordingJobState</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/GetRecordingOptions\">GetRecordingOptions</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/GetRecordings\">GetRecordings</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/GetServiceCapabilities\">GetServiceCapabilities</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/GetTrackConfiguration\">GetTrackConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/SetRecordingConfiguration\">SetRecordingConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/SetRecordingJobConfiguration\">SetRecordingJobConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/SetRecordingJobMode\">SetRecordingJobMode</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/SetTrackConfiguration\">SetTrackConfiguration</a>\r\n<br>"
				+ "<a href=\"http://localhost:8080/recording/RecordingBinding/StopExportRecordedData\">StopExportRecordedData</a>\r\n<br>";
	}

	public void load(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Recording_page loading");
		/* request uri starts with Environment.recording_page.getURI() */
		if (target != null) {
			if (target.equals("")) {
				/* request uri equals Environment.recording_page.getURI() */
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
				if (target.startsWith(Environment.recordingbinding_page.getURI())) {
					load_RecordingBinding_page(target, baseRequest, request, response);
				} else {
					/* there is no other binding in recording */
					load_not_found_page(target, baseRequest, request, response);
				}
			}
		} else {
			System.out.println("target null");
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			return;
		}
	}

	private void load_RecordingBinding_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
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
