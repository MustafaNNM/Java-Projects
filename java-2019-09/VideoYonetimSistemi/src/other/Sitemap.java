/**
 * 
 */
package other;

import application.web.Page;

/**
 * @author MehmetAkif-PC
 *
 */
public class Sitemap {	
	public Page home_page = null;
	public Page video_page = null;
	public Page stream_page = null;
	public Page favicon_page = null;
	public Page not_found_page = null;
	public Page devicemanagement_page = null;
	public Page accesscontrol_page = null;
	public Page actionengine_page = null;
	public Page advancedsecurity_page = null;
	public Page analytics_page = null;
	public Page analyticsdevice_page = null;
	public Page authenticationbehavior_page = null;
	public Page credential_page = null;
	public Page deviceio_page = null;
	public Page display_page = null;
	public Page doorcontrol_page = null;
	public Page event_page = null;
	public Page imaging_page = null;
	public Page media_page = null;
	public Page media2_page = null;
	public Page provisioning_page = null;
	public Page ptz_page = null;
	public Page receiver_page = null;
	public Page recording_page = null;
	public Page replay_page = null;
	public Page schedule_page = null;
	public Page search_page = null;
	public Page thermal_page = null;
	public Page devicebinding_page = null;
	public Page root_page=null;
	
	public Sitemap() {
		init_pages();
	}

	/**
	 * 
	 */
	private void init_pages() {
		root_page=new Page("/");
		home_page = new Page("home_page");
		video_page = new Page("video_page");
		stream_page = new Page("stream_page");
		favicon_page = new Page("favicon_page");
		not_found_page = new Page("not_found_page");
		devicemanagement_page = new Page("devicemanagement_page");
		accesscontrol_page = new Page("accesscontrol_page");
		actionengine_page = new Page("actionengine_page");
		advancedsecurity_page = new Page("advancedsecurity_page");
		analytics_page = new Page("analytics_page");
		analyticsdevice_page = new Page("analyticsdevice_page");
		authenticationbehavior_page = new Page("authenticationbehavior_page");
		credential_page = new Page("credential_page");
		deviceio_page = new Page("deviceio_page");
		display_page = new Page("display_page");
		doorcontrol_page = new Page("doorcontrol_page");
		event_page = new Page("event_page");
		imaging_page = new Page("imaging_page");
		media_page = new Page("media_page");
		media2_page = new Page("media2_page");
		provisioning_page = new Page("provisioning_page");
		ptz_page = new Page("ptz_page");
		receiver_page = new Page("receiver_page");
		recording_page = new Page("recording_page");
		replay_page = new Page("replay_page");
		schedule_page = new Page("schedule_page");
		search_page = new Page("search_page");
		thermal_page = new Page("thermal_page");
		devicebinding_page = new Page("devicebinding_page");
	}

}
