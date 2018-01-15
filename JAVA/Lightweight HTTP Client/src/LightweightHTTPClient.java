public class LightweightHTTPClient  {

	private static HtmlCodePrinterofHost htmlcodeprinterofhost=new HtmlCodePrinterofHost();

	public static void main(String[] args) {
		String host = "http://api.wunderground.com/api/d967493a39902bc0/conditions/lang:TR/q/Turkey/Kahramanmaras.json";
		              //"http://api.wunderground.com/api/d967493a39902bc0/conditions/q/CA/San_Francisco.json";
		htmlcodeprinterofhost.printhtmlcodesofhost(host);
		
		
	}

	public static HtmlCodePrinterofHost getHtmlcodeprinterofhost() {
		return htmlcodeprinterofhost;
	}

	public static void setHtmlcodeprinterofhost(HtmlCodePrinterofHost htmlcodeprinterofhost) {
		LightweightHTTPClient.htmlcodeprinterofhost = htmlcodeprinterofhost;
	}
}
