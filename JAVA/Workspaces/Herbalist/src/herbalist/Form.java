package herbalist;

import javax.swing.SwingUtilities;

public class Form {

	/**
	 * 
	 */
	void appgui() {
		Herbalist_App.veri_tabanlar�n�_olu�tur();
		Herbalist_App.veri_tabanlar�n�_veri_yap�lar�na_kopyala();
	
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Herbalist_App application = new Herbalist_App();
				application.getHerbalist_Application().setVisible(true);
			}
		});
	}

}
