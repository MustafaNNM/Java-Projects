package herbalist;

import javax.swing.SwingUtilities;

public class Form {

	/**
	 * 
	 */
	void appgui() {
		Herbalist_App.veri_tabanlarını_oluştur();
		Herbalist_App.veri_tabanlarını_veri_yapılarına_kopyala();
	
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Herbalist_App application = new Herbalist_App();
				application.getHerbalist_Application().setVisible(true);
			}
		});
	}

}
