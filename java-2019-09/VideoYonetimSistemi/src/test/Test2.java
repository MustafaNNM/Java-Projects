package test;

import net.java.dev.wlanapi.WifiManager;

public class Test2 {
	public static void main(String[] args) {
		try {
			WifiManager a=new WifiManager();
			//a.connect("WLAN","ZyXEL_HGW_W3A3Y");
			//a.waitForConnect("ZyXEL_HGW_W3A3Y", 100, TimeUnit.SECONDS);
			//System.out.println("ConfiguredNetworks:"+a.getConfiguredNetworks());
			//a.addNetwork("ZyXEL_HGW_W3A3Y");
			//System.out.printf("Wifi Enabled: %s\n\n",a.isWifiEnabled());//bir iþe yaramýyor
			System.out.println("connectedSsid:"+a.connectedSsid());
			//a.removeNetwork("ZyXEL_HGW_W3A3Y");
			
		} catch (Exception e) {
			System.out.println("Exception e");
			e.printStackTrace();
		}
	}
}
