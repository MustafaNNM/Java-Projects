/* Class: Gorsel
 * Author: Umut BENZER
 * 
 * G�rsel ��eler de i�eren as�l s�n�ft�r. Ayr�nt�l� bilgi i�in 
 *  public void actionPerformed(java.awt.event.ActionEvent e) {
 * k�sm�ndaki commentlere bak�n�z.
 * 
 * G�rsel kodlar Eclipse Ganymede �zerinde Visual Edit�r ile yarat�lm��t�r.
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
	 * Gelen string verisinin bir Integer olup olmad���n� TRUE ya da FALSE
	 * olarak geri d�nd�r�r.
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
					/* Say� m�? */
					if (isParsableToInt(textMusteriSayisi.getText())
							&& Integer.parseInt(textMusteriSayisi.getText()) > 0) {
						/* Gerekli de�i�kenler ve nesneler yarat�l�r. */
						int musteriSayisi = Integer.parseInt(textMusteriSayisi
								.getText());
						int islemSuresi;
						int toplamBeklemeSuresi = 0;
						int oncekiBeklemeSuresi = 0;

						BListe kuyruk = new BListe();
						BListe oncelikliKuyruk = new BListe(true);

						/*
						 * �nceki �al��madan bir �eyler kalma ihtimaline kar��
						 * listeleri vs. temizlemek gerekir.
						 */
						listMusteri.removeAll();
						listSonuc.removeAll();
						listSonucP.removeAll();
						listeCokBekleyen.removeAll();
						labelUyari.setText("");

						/* Program s�priz yumurta i�ermektedir. */
						/* http://en.wikipedia.org/wiki/Easter_egg_(media) */
						if (checkTorpil.getState()) {
							listMusteri.add("Torpilli m��teri");
							listSonuc.add("Torpilli m��teri bekletti de bekletti...");
							listSonucP.add("Torpilli m��terilerimiz �nceliklidir.");
						}
						
						/*
						 * Rastgele i�lem s�reli n m��teri yarat�p �nceliksiz
						 * kuyru�a at�l�r.
						 */
						for (int i = 1; i <= musteriSayisi; i++) {
							islemSuresi = (int) (30 + Math.random() * 270);
							kuyruk.ekle(i, islemSuresi);
							listMusteri.add(i + ".m��teri i�lem s�resi: "
									+ islemSuresi);
						}

						/* T�m kuyruk bo�alana kadar sim�lasyon s�rd�r�l�r. */
						while (!kuyruk.bosMu()) {
							Musteri guncel = kuyruk.cikar();
							guncel.FIFOBeklemeSuresi = guncel.islemSuresi
									+ oncekiBeklemeSuresi;

							/*
							 * Bir yandan �nceliksiz kuyruktan m��teriler
							 * ��kar�l�r ve bu kuyru�a ait ortalamalar
							 * hesaplan�rken di�er yandan ��kan m��teriler
							 * �nceliksiz bekleme s�resi bilgileri ile beraber
							 * �ncelikli kuyru�a at�l�r.
							 */
							oncelikliKuyruk.ekle(guncel.musteriNo,
									guncel.islemSuresi,
									guncel.FIFOBeklemeSuresi);

							oncekiBeklemeSuresi = guncel.FIFOBeklemeSuresi;
							toplamBeklemeSuresi += guncel.FIFOBeklemeSuresi;

							listSonuc.add(guncel.musteriNo
									+ " numaral� m��teri "
									+ guncel.FIFOBeklemeSuresi
									+ " saniye bekledi.\n");
						}

						listSonuc.add("Ortalama bekleme s�resi: "
								+ toplamBeklemeSuresi / musteriSayisi
								+ " saniye.");

						/* Ayn� i�lemler �ncelikli kuyruk i�in tekrarlan�r. */
						toplamBeklemeSuresi = 0;
						oncekiBeklemeSuresi = 0;
						while (oncelikliKuyruk.bosMu() == false) {
							Musteri guncel = oncelikliKuyruk.cikar();
							guncel.PBeklemeSuresi = guncel.islemSuresi
									+ oncekiBeklemeSuresi;

							oncekiBeklemeSuresi = guncel.PBeklemeSuresi;
							toplamBeklemeSuresi += guncel.PBeklemeSuresi;

							/*
							 * �ok bekleyen m��terilerin �emkirmesi de listeleme
							 * esnas�nda yap�l�r.
							 */
							if (guncel.PBeklemeSuresi > guncel.FIFOBeklemeSuresi) {
								listeCokBekleyen
										.add(guncel.musteriNo
												+ ". m��teri �ncelikli kuyrukta "
												+ (guncel.PBeklemeSuresi - guncel.FIFOBeklemeSuresi)
												+ " saniye daha �ok bekledi.");
							}

							listSonucP.add(guncel.musteriNo
									+ " numaral� m��teri "
									+ guncel.PBeklemeSuresi
									+ " saniye bekledi.\n");
						}

						listSonucP.add("Ortalama bekleme s�resi: "
								+ toplamBeklemeSuresi / musteriSayisi
								+ " saniye.");

					} else { /* De�il */
						textMusteriSayisi.setText("30");
						labelUyari
								.setText("L�tfen insan gibi bir say� giriniz!");
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
			checkTorpil.setLabel("Tan�d�klara torpil ge�");
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
		this.setTitle("Banka Kuyru�u - ��kmez Bili�im Sistemleri");
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
			etiketBaslik.setText("M��teri say�s�:");
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
