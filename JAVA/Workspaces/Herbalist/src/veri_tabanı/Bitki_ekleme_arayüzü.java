package veri_taban�;

//import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;

public class Bitki_ekleme_aray�z� extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;

	/**
	 * This is the default constructor
	 */
	public Bitki_ekleme_aray�z�() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Bitki Ekleme Aray�z�");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(17, 78, 77, 16));
			jLabel2.setText("JLabel");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(16, 45, 76, 16));
			jLabel1.setText("Kategori");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(13, 14, 77, 16));
			jLabel.setText("Bitki ad�");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="11,11"
