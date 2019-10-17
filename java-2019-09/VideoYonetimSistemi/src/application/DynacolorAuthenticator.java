package application;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class DynacolorAuthenticator extends Authenticator {
	// Called when password authorization is needed
	protected PasswordAuthentication getPasswordAuthentication() {
		String username = "Admin";
		String password = "1234";
		// Return the information (a data holder that is used by Authenticator)
		return new PasswordAuthentication(username, password.toCharArray());
	}
}