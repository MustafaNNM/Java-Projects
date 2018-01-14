package herbalist;

import javax.swing.SwingUtilities;

public class Form {

	/**
	 * 
	 */
	void appgui() {
		Herbalist_App.veri_tabanlarýný_oluþtur();
		Herbalist_App.veri_tabanlarýný_veri_yapýlarýna_kopyala();
	
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Herbalist_App application = new Herbalist_App();
				application.getHerbalist_Application().setVisible(true);
			}
		});
	}

}
