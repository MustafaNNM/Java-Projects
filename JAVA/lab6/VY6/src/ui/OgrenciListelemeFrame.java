package ui;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import veri.Ogrenci;
import dosya.OgrenciIslemleri;

public class OgrenciListelemeFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public static void main(final String[] args) {
		new OgrenciListelemeFrame();
	}

	private JList<Object> lstOgrenci = null;
	Vector<Ogrenci> ogrenciler;
	private OgrenciPanel pnlOgrenci = null;

	public OgrenciListelemeFrame() {
		this.setTitle("Öðrenci Listeleme");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize();
	}

	private JPanel createContentPane() {
		final JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(createLstOgrenci(), BorderLayout.WEST);
		contentPane.add(createPnlOgrenci(), BorderLayout.CENTER);
		return contentPane;
	}

	private JScrollPane createLstOgrenci() {
		if (lstOgrenci == null) {
			lstOgrenci = new JList<Object>();
			ogrenciler = OgrenciIslemleri.ogrencileriOku("ogrenciler.txt");
			lstOgrenci.setListData(ogrenciler);
			lstOgrenci
					.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			lstOgrenci.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(final ListSelectionEvent e) {
					if (e.getValueIsAdjusting() == false) {

						if (lstOgrenci.getSelectedIndex() != -1) {
							pnlOgrenci.ogrenciyiGoster(ogrenciler
									.get(lstOgrenci.getSelectedIndex()));
						}
					}
				}
			});
		}
		return new JScrollPane(lstOgrenci);
	}

	private JPanel createPnlOgrenci() {
		if (pnlOgrenci == null) {
			pnlOgrenci = new OgrenciPanel(this);
		}
		return pnlOgrenci;
	}

	private void initialize() {
		this.setContentPane(createContentPane());
		this.setSize(550, 200);
		this.setVisible(true);

	}

	public void yenile() {
		ogrenciler = OgrenciIslemleri.ogrencileriOku("ogrenciler.txt");
		lstOgrenci.setListData(ogrenciler);
		lstOgrenci.repaint();
	}

}
