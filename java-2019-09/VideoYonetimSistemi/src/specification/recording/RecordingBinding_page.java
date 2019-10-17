package specification.recording;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

import application.web.Page;
import application.web.pages.Not_found_page;

public class RecordingBinding_page extends Page{
	private String subrequestURI;
	private String requestURI;// loglanmasý gerekiyor.
	private String sayfalar;
	
	private String requestler;
	
	public RecordingBinding_page(String string) {
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
