public class LightweightHTTPClient  {

	private static HtmlCodePrinterofHost htmlcodeprinterofhost=new HtmlCodePrinterofHost();

	public static void main(String[] args) {
		String host = "http://galaksiya.com";
		htmlcodeprinterofhost.printhtmlcodesofhost(host);
		
		
	}

	public static HtmlCodePrinterofHost getHtmlcodeprinterofhost() {
		return htmlcodeprinterofhost;
	}

	public static void setHtmlcodeprinterofhost(HtmlCodePrinterofHost htmlcodeprinterofhost) {
		LightweightHTTPClient.htmlcodeprinterofhost = htmlcodeprinterofhost;
	}
}
