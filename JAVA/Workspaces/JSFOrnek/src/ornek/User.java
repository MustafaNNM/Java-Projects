package ornek;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userBean")
@SessionScoped
public class User {

	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		// Database ba�lant�s� ile do�rulama yap�labilir

		// kitap �d�n� alabilen kullan�c�lar
		if (name.equalsIgnoreCase("user") || name.equalsIgnoreCase("enes")
				&& password.equalsIgnoreCase("pass")) {
			return "user";
		}
		// ekleme, d�zenleme ve silme yetkisi olan admin kullan�c�s�
		else if (name.equalsIgnoreCase("admin")
				&& password.equalsIgnoreCase("admin")) {
			return "admin";
		} else {
			return "failed";
		}

	}

}
