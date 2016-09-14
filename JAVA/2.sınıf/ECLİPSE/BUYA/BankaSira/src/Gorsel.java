/* Class: Gorsel
 * Author: Umut BENZER
 * 
 * Görsel öðeler de içeren asýl sýnýftýr. Ayrýntýlý bilgi için 
 *  public void actionPerformed(java.awt.event.ActionEvent e) {
 * kýsmýndaki commentlere bakýnýz.
 * 
 * Görsel kodlar Eclipse Ganymede üzerinde Visual Editör ile yaratýlmýþtýr.
 */

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.List;
import javax.swing.WindowConstants;
import java.awt.Checkbox;

public class Gorsel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null; // @jve:decl-index=0:visual-constraint="82,26"
	private JButton butonMusteri = null;
	private JLabel etiketBaslik = null;
	private JTextField textMusteriSayisi = null;
	private List listSonuc = null;
	private List listSonucP = null;
	private JLabel labelUyari = null;
	private List listMusteri = null;
	private List listeCokBekleyen = null;
	private Checkbox checkTorpil = null;

	/*
	 * Gelen string verisinin bir Integer olup olmadýðýný TRUE ya da FALSE
	 * olarak geri döndürür.
	 */
	public boolean isParsableToInt(String i) {
		try {
			Integer.parseInt(i);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	private JButton getButonMusteri() {
		if (butonMusteri == null) {
			butonMusteri = new JButton();
			butonMusteri.setBounds(new Rectangle(142, 13, 83, 21));
			butonMusteri.setText("Yarat");
			butonMusteri.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					/* Sayý mý? */
					if (isParsableToInt(textMusteriSayisi.getText())
							&& Integer.parseInt(textMusteriSayisi.getText()) > 0) {
						/* Gerekli deðiþkenler ve nesneler yaratýlýr. */
						int musteriSayisi = Integer.parseInt(textMusteriSayisi
								.getText());
						int islemSuresi;
						int toplamBeklemeSuresi = 0;
						int oncekiBeklemeSuresi = 0;

						BListe kuyruk = new BListe();
						BListe oncelikliKuyruk = new BListe(true);

						/*
						 * Önceki çalýþmadan bir þeyler kalma ihtimaline karþý
						 * listeleri vs. temizlemek gerekir.
						 */
						listMusteri.removeAll();
						listSonuc.removeAll();
						listSonucP.removeAll();
						listeCokBekleyen.removeAll();
						labelUyari.setText("");

						/* Program süpriz yumurta içermektedir. */
						/* http://en.wikipedia.org/wiki/Easter_egg_(media) */
						if (checkTorpil.getState()) {
							listMusteri.add("Torpilli müþteri");
							listSonuc.add("Torpilli müþteri bekletti de bekletti...");
							listSonucP.add("Torpilli müþterilerimiz önceliklidir.");
						}
						
						/*
						 * Rastgele iþlem süreli n müþteri yaratýp önceliksiz
						 * kuyruða atýlýr.
						 */
						for (int i = 1; i <= musteriSayisi; i++) {
							islemSuresi = (int) (30 + Math.random() * 270);
							kuyruk.ekle(i, islemSuresi);
							listMusteri.add(i + ".müþteri iþlem süresi: "
									+ islemSuresi);
						}

						/* Tüm kuyruk boþalana kadar simülasyon sürdürülür. */
						while (!kuyruk.bosMu()) {
							Musteri guncel = kuyruk.cikar();
							guncel.FIFOBeklemeSuresi = guncel.islemSuresi
									+ oncekiBeklemeSuresi;

							/*
							 * Bir yandan önceliksiz kuyruktan müþteriler
							 * çýkarýlýr ve bu kuyruða ait ortalamalar
							 * hesaplanýrken diðer yandan çýkan müþteriler
							 * önceliksiz bekleme süresi bilgileri ile beraber
							 * öncelikli kuyruða atýlýr.
							 */
							oncelikliKuyruk.ekle(guncel.musteriNo,
									guncel.islemSuresi,
									guncel.FIFOBeklemeSuresi);

							oncekiBeklemeSuresi = guncel.FIFOBeklemeSuresi;
							toplamBeklemeSuresi += guncel.FIFOBeklemeSuresi;

							listSonuc.add(guncel.musteriNo
									+ " numaralý müþteri "
									+ guncel.FIFOBeklemeSuresi
									+ " saniye bekledi.\n");
						}

						listSonuc.add("Ortalama bekleme süresi: "
								+ toplamBeklemeSuresi / musteriSayisi
								+ " saniye.");

						/* Ayný iþlemler öncelikli kuyruk için tekrarlanýr. */
						toplamBeklemeSuresi = 0;
						oncekiBeklemeSuresi = 0;
						while (oncelikliKuyruk.bosMu() == false) {
							Musteri guncel = oncelikliKuyruk.cikar();
							guncel.PBeklemeSuresi = guncel.islemSuresi
									+ oncekiBeklemeSuresi;

							oncekiBeklemeSuresi = guncel.PBeklemeSuresi;
							toplamBeklemeSuresi += guncel.PBeklemeSuresi;

							/*
							 * Çok bekleyen müþterilerin çemkirmesi de listeleme
							 * esnasýnda yapýlýr.
							 */
							if (guncel.PBeklemeSuresi > guncel.FIFOBeklemeSuresi) {
								listeCokBekleyen
										.add(guncel.musteriNo
												+ ". müþteri öncelikli kuyrukta "
												+ (guncel.PBeklemeSuresi - guncel.FIFOBeklemeSuresi)
												+ " saniye daha çok bekledi.");
							}

							listSonucP.add(guncel.musteriNo
									+ " numaralý müþteri "
									+ guncel.PBeklemeSuresi
									+ " saniye bekledi.\n");
						}

						listSonucP.add("Ortalama bekleme süresi: "
								+ toplamBeklemeSuresi / musteriSayisi
								+ " saniye.");

					} else { /* Deðil */
						textMusteriSayisi.setText("30");
						labelUyari
								.setText("Lütfen insan gibi bir sayý giriniz!");
					}
				}

			});
		}
		return butonMusteri;
	}

	/**
	 * This method initializes textMusteriSayisi
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getTextMusteriSayisi() {
		if (textMusteriSayisi == null) {
			textMusteriSayisi = new JTextField();
			textMusteriSayisi.setBounds(new Rectangle(96, 12, 45, 24));
			textMusteriSayisi.setText("30");
		}
		return textMusteriSayisi;
	}

	/**
	 * This method initializes listSonuc
	 * 
	 * @return java.awt.List
	 */
	private List getListSonuc() {
		if (listSonuc == null) {
			listSonuc = new List();
			listSonuc.setBounds(new Rectangle(232, 36, 293, 366));
		}
		return listSonuc;
	}

	/**
	 * This method initializes listSonucP
	 * 
	 * @return java.awt.List
	 */
	private List getListSonucP() {
		if (listSonucP == null) {
			listSonucP = new List();
			listSonucP.setBounds(new Rectangle(532, 37, 250, 367));
		}
		return listSonucP;
	}

	/**
	 * This method initializes listMusteri
	 * 
	 * @return java.awt.List
	 */
	private List getListMusteri() {
		if (listMusteri == null) {
			listMusteri = new List();
			listMusteri.setBounds(new Rectangle(8, 37, 218, 365));
		}
		return listMusteri;
	}

	/**
	 * This method initializes listeCokBekleyen
	 * 
	 * @return java.awt.List
	 */
	private List getListeCokBekleyen() {
		if (listeCokBekleyen == null) {
			listeCokBekleyen = new List();
			listeCokBekleyen.setBounds(new Rectangle(10, 410, 768, 155));
		}
		return listeCokBekleyen;
	}

	/**
	 * This method initializes checkTorpil	
	 * 	
	 * @return java.awt.Checkbox	
	 */
	private Checkbox getCheckTorpil() {
		if (checkTorpil == null) {
			checkTorpil = new Checkbox();
			checkTorpil.setBounds(new Rectangle(232, 16, 238, 19));
			checkTorpil.setLabel("Tanýdýklara torpil geç");
		}
		return checkTorpil;
	}

	public static void main(String[] args) {
		Gorsel form = new Gorsel();
		form.setVisible(true);
	}

	/**
	 * This is the default constructor
	 */
	public Gorsel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(800, 600);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setTitle("Banka Kuyruðu - Çökmez Biliþim Sistemleri");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			labelUyari = new JLabel();
			labelUyari.setBounds(new Rectangle(531, 18, 239, 16));
			labelUyari.setText("");
			etiketBaslik = new JLabel();
			etiketBaslik.setBounds(new Rectangle(13, 12, 82, 24));
			etiketBaslik.setText("Müþteri sayýsý:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setSize(new Dimension(448, 272));
			jContentPane.add(getButonMusteri(), null);
			jContentPane.add(etiketBaslik, null);
			jContentPane.add(getTextMusteriSayisi(), null);
			jContentPane.add(getListSonuc(), null);
			jContentPane.add(getListSonucP(), null);
			jContentPane.add(labelUyari, null);
			jContentPane.add(getListMusteri(), null);
			jContentPane.add(getListeCokBekleyen(), null);
			jContentPane.add(getCheckTorpil(), null);
		}
		return jContentPane;
	}

} // @jve:decl-index=0:visual-constraint="30,12"
