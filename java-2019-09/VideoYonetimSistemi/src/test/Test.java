package test;

import application.web.pages.Favicon;
import specification.enumeration.Environment;

public class Test {

	public static void main(String[] args) {
		try {
			System.out.println("target:" + Environment.home_page.getURI());
		} catch (Exception e) {
			System.out.println("Exception e");
			e.printStackTrace();
		}
		new Favicon("/favicon.ico");
	}
}
