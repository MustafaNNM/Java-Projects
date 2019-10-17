package specification.enumeration;

public enum Environment
{
	root_page("/",1),
	home_page("/home",5),
	h264_2_page("/h264_2",7),
	ip_camera_page("/ip_camera",10),
	video_page("/video",6),
	stream_page("/stream",7),
	favicon_page("/favicon.ico",12),
	not_found_page("/not_found",10),
	devicemanagement_page("/devicemanagement",17),
	accesscontrol_page("/accesscontrol",14),
	actionengine_page("/actionengine_page",18),
	advancedsecurity_page("/advancedsecurity",17),
	analytics_page("/analytics_page",15),
	analyticsdevice_page("/analyticsdevice",16),
	authenticationbehavior_page("/authenticationbehavior",23),
	credential_page("/credential",11),
	deviceio_page("/deviceio",9),
	display_page("/display",8),
	doorcontrol_page("/doorcontrol",12),
	event_page("/event",6),
	imaging_page("/imaging",8),
	media_page("/media",6),
	media2_page("/media2",7),
	provisioning_page("/provisioning",13),
	ptz_page("/ptz",4),
	receiver_page("/receiver",9),
	recording_page("/recording",10),
	replay_page("/replay",7),
	schedule_page("/schedule",9),
	search_page("/search",7),
	thermal_page("/thermal",8),
	devicebinding_page("/DeviceBinding",14),
	pacsbinding_page("/PACSBinding",12),
	actionenginebinding_page("/ActionEngineBinding",20),
	advancedsecurityservicebinding_page("/AdvancedSecurityServiceBinding",31),
	dot1xbinding_page("/Dot1XBinding",13),
	keystorebinding_page("/KeystoreBinding",16),
	tlsserverbinding_page("/TLSServerBinding",17),
	analyticsenginebinding_page("/AnalyticsEngineBinding",23),
	ruleenginebinding_page("/RuleEngineBinding",18),
	analyticsdevicebinding_page("/AnalyticsDeviceBinding",23),
	authenticationbehaviorbinding_page("/AuthenticationBehaviorBinding",30),
	credentialbinding_page("/CredentialBinding",18),
	deviceiobinding_page("/DeviceIOBinding",16),
	displaybinding_page("/DisplayBinding",15),
	doorcontrolbinding_page("/DoorControlBinding",19),
	createpullpointbinding_page("/CreatePullPointBinding",23),
	eventbinding_page("/EventBinding",13),
	notificationconsumerbinding_page("/NotificationConsumerBinding",27),
	notificationproducerbinding_page("/NotificationProducerBinding",28),
	pausablesubscriptionmanagerbinding_page("/PausableSubscriptionManagerBinding",35),
	pullpointbinding_page("/PullPointBinding",17),
	pullpointsubscriptionbinding_page("/PullPointSubscriptionBinding",29),
	subscriptionmanagerbinding_page("/SubscriptionManagerBinding",27),
	imagingbinding_page("/ImagingBinding",15),
	mediabinding_page("/MediaBinding",13),
	media2binding_page("/Media2Binding",14),
	provisioningbinding_page("/ProvisioningBinding",20),
	ptzbinding_page("/PTZBinding",11),
	receiverbinding_page("/ReceiverBinding",16),
	recordingbinding_page("/RecordingBinding",17),
	replaybinding_page("/ReplayBinding",14),
	schedulebinding_page("/ScheduleBinding",16),
	searchbinding_page("/SearchBinding",14),
	thermalbinding_page("/ThermalBinding",15);
 
	private String URI;
	private int size;
 
    Environment(String envUrl,int uzunluk) {
        this.URI = envUrl;
        this.size=uzunluk;
    }
 
    public String getURI() {
        return URI;
    }

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
}