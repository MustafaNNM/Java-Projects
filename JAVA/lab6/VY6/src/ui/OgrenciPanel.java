package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import veri.Ogrenci;
import dosya.OgrenciIslemleri;

public class OgrenciPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private final OgrenciListelemeFrame frame;
	private JTextField txtGirisYili;
	private JTextField txtIsim;
	private JTextField txtNumara;

	private JTextField txtSinif;

	public OgrenciPanel(final OgrenciListelemeFrame _frame) {
		frame = _frame;
		initialize();
	}

	private void initialize() {
		this.setLayout(null);
		final int uzunluk = 100;
		final int yukseklik = 25;
		int y = 0;

		JLabel lbl = new JLabel("Numara:");
		lbl.setBounds(0, y, uzunluk, yukseklik);
		this.add(lbl);

		txtNumara = new JTextField();
		txtNumara.setBounds(uzunluk, y, 200, yukseklik);
		this.add(txtNumara);

		y += yukseklik;

		lbl = new JLabel("Ýsim:");
		lbl.setBounds(0, y, uzunluk, yukseklik);
		this.add(lbl);

		txtIsim = new JTextField();
		txtIsim.setBounds(uzunluk, y, 200, yukseklik);
		this.add(txtIsim);

		y += yukseklik;

		lbl = new JLabel("Sýnýf:");
		lbl.setBounds(0, y, uzunluk, yukseklik);
		this.add(lbl);

		txtSinif = new JTextField();
		txtSinif.setBounds(uzunluk, y, 200, yukseklik);
		this.add(txtSinif);

		y += yukseklik;

		lbl = new JLabel("GiriÅŸ YÄ±lÄ±:");
		lbl.setBounds(0, y, uzunluk, yukseklik);
		this.add(lbl);
		txtGirisYili = new JTextField();
		txtGirisYili.setBounds(uzunluk, y, 200, yukseklik);
		this.add(txtGirisYili);

		y += yukseklik;

		final JButton btn = new JButton("Ekle");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				final Ogrenci ogrenci = new Ogrenci();
				ogrenci.setNumara(txtNumara.getText());
				ogrenci.setIsim(txtIsim.getText());
				ogrenci.setSinif(Integer.parseInt(txtSinif.getText()));
				ogrenci.setGirisYili(Integer.parseInt(txtGirisYili.getText()));
				// Dosyanin sonuna ogrenci ekleyelim
				OgrenciIslemleri.ogrenciEkle(ogrenci, "ogrenciler.txt", true);
				// Listeyi yenileyelim
				frame.yenile();
			}
		});
		btn.setBounds(uzunluk, y, 100, yukseklik);
		this.add(btn);

	}

	public void ogrenciyiGoster(final Ogrenci ogrenci) {
		txtNumara.setText(ogrenci.getNumara());
		txtIsim.setText(ogrenci.getIsim());
		txtSinif.setText(Integer.toString(ogrenci.getSinif()));
		txtGirisYili.setText(Integer.toString(ogrenci.getGirisYili()));
	}
}
