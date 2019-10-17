/**
 * 
 */
package specification.media;

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
public class Media_page extends Page{
	private String requestURI;// loglanmasý gerekiyor.

	private String sayfalar;
	
	private String requestler;

	public Media_page(String string) {
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
		requestler = "<a href=\"http://localhost:8080/media/MediaBinding/AddAudioDecoderConfiguration\">AddAudioDecoderConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/AddAudioEncoderConfiguration\">AddAudioEncoderConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/AddAudioOutputConfiguration\">AddAudioOutputConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/AddAudioSourceConfiguration\">AddAudioSourceConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/AddMetadataConfiguration\">AddMetadataConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/AddPTZConfiguration\">AddPTZConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/AddVideoAnalyticsConfiguration\">AddVideoAnalyticsConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/AddVideoEncoderConfiguration\">AddVideoEncoderConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/AddVideoSourceConfiguration\">AddVideoSourceConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/CreateOSD\">CreateOSD</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/CreateProfile\">CreateProfile</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/DeleteOSD\">DeleteOSD</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/DeleteProfile\">DeleteProfile</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetAudioDecoderConfiguration\">GetAudioDecoderConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetAudioDecoderConfigurationOptions\">GetAudioDecoderConfigurationOptions</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetAudioDecoderConfigurations\">GetAudioDecoderConfigurations</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetAudioEncoderConfiguration\">GetAudioEncoderConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetAudioEncoderConfigurationOptions\">GetAudioEncoderConfigurationOptions</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetAudioEncoderConfigurations\">GetAudioEncoderConfigurations</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetAudioOutputConfiguration\">GetAudioOutputConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetAudioOutputConfigurationOptions\">GetAudioOutputConfigurationOptions</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetAudioOutputConfigurations\">GetAudioOutputConfigurations</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetAudioOutputs\">GetAudioOutputs</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetAudioSourceConfiguration\">GetAudioSourceConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetAudioSourceConfigurationOptions\">GetAudioSourceConfigurationOptions</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetAudioSourceConfigurations\">GetAudioSourceConfigurations</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetAudioSources\">GetAudioSources</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetCompatibleAudioDecoderConfigurations\">GetCompatibleAudioDecoderConfigurations</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetCompatibleAudioEncoderConfigurations\">GetCompatibleAudioEncoderConfigurations</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetCompatibleAudioOutputConfigurations\">GetCompatibleAudioOutputConfigurations</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetCompatibleAudioSourceConfigurations\">GetCompatibleAudioSourceConfigurations</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetCompatibleMetadataConfigurations\">GetCompatibleMetadataConfigurations</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetCompatibleVideoAnalyticsConfigurations\">GetCompatibleVideoAnalyticsConfigurations</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetCompatibleVideoEncoderConfigurations\">GetCompatibleVideoEncoderConfigurations</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetCompatibleVideoSourceConfigurations\">GetCompatibleVideoSourceConfigurations</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetGuaranteedNumberOfVideoEncoderInstances\">GetGuaranteedNumberOfVideoEncoderInstances</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetMetadataConfiguration\">GetMetadataConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetMetadataConfigurationOptions\">GetMetadataConfigurationOptions</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetMetadataConfigurations\">GetMetadataConfigurations</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetOSD\">GetOSD</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetOSDOptions\">GetOSDOptions</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetOSDs\">GetOSDs</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetProfile\">GetProfile</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetProfiles\">GetProfiles</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetServiceCapabilities\">GetServiceCapabilities</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetSnapshotUri\">GetSnapshotUri</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetStreamUri\">GetStreamUri</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetVideoAnalyticsConfiguration\">GetVideoAnalyticsConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetVideoAnalyticsConfigurations\">GetVideoAnalyticsConfigurations</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetVideoEncoderConfiguration\">GetVideoEncoderConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetVideoEncoderConfigurationOptions\">GetVideoEncoderConfigurationOptions</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetVideoEncoderConfigurations\">GetVideoEncoderConfigurations</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetVideoSourceConfiguration\">GetVideoSourceConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetVideoSourceConfigurationOptions\">GetVideoSourceConfigurationOptions</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetVideoSourceConfigurations\">GetVideoSourceConfigurations</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetVideoSourceModes\">GetVideoSourceModes</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/GetVideoSources\">GetVideoSources</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/RemoveAudioDecoderConfiguration\">RemoveAudioDecoderConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/RemoveAudioEncoderConfiguration\">RemoveAudioEncoderConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/RemoveAudioOutputConfiguration\">RemoveAudioOutputConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/RemoveAudioSourceConfiguration\">RemoveAudioSourceConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/RemoveMetadataConfiguration\">RemoveMetadataConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/RemovePTZConfiguration\">RemovePTZConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/RemoveVideoAnalyticsConfiguration\">RemoveVideoAnalyticsConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/RemoveVideoEncoderConfiguration\">RemoveVideoEncoderConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/RemoveVideoSourceConfiguration\">RemoveVideoSourceConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/SetAudioDecoderConfiguration\">SetAudioDecoderConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/SetAudioEncoderConfiguration\">SetAudioEncoderConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/SetAudioOutputConfiguration\">SetAudioOutputConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/SetAudioSourceConfiguration\">SetAudioSourceConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/SetMetadataConfiguration\">SetMetadataConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/SetOSD\">SetOSD</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/SetSynchronizationPoint\">SetSynchronizationPoint</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/SetVideoAnalyticsConfiguration\">SetVideoAnalyticsConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/SetVideoEncoderConfiguration\">SetVideoEncoderConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/SetVideoSourceConfiguration\">SetVideoSourceConfiguration</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/SetVideoSourceMode\">SetVideoSourceMode</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/StartMulticastStreaming\">StartMulticastStreaming</a>\r\n"+
				"<a href=\"http://localhost:8080/media/MediaBinding/StopMulticastStreaming\">StopMulticastStreaming</a>\r\n";
	}

	public void load(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Media_page loading");
		/* request uri starts with Environment.media_page.getURI() */
		if (target != null) {
			if (target.equals("")) {
				/* request uri equals Environment.media_page.getURI() */
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
				if (target.startsWith(Environment.mediabinding_page.getURI())) {
					load_MediaBinding_page(target, baseRequest, request, response);
				} else {
					/* there is no other binding in media */
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
	
	private void load_MediaBinding_page(String target, Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
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
