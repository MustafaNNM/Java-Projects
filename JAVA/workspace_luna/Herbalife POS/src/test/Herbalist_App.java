package test;

import hash_table.Hash_Table;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Event;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.KeyStroke;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JDialog;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import a�a�.Node;
import a�a�lar.Vector_A�a�;

import veri_taban�.Bitki_veri_taban�;
import veri_taban�.Hastal�k_veri_taban�;
import veri_taban�.Kategori_veri_taban�;
import javax.swing.JScrollPane;

import dert.Hastal�k;
import deva.Kategori;

public class Herbalist_App {

	private JFrame Herbalist_Application = null; // @jve:decl-index=0:visual-constraint="10,0"
	private JPanel Men� = null;
	private JMenuBar jJMenuBar = null;
	private JMenu fileMenu = null;
	private JMenu editMenu = null;
	private JMenu helpMenu = null;
	private JMenuItem exitMenuItem = null;
	private JMenuItem aboutMenuItem = null;
	private JMenuItem cutMenuItem = null;
	private JMenuItem copyMenuItem = null;
	private JMenuItem pasteMenuItem = null;
	private JMenuItem saveMenuItem = null;
	private JDialog aboutDialog = null;
	private JPanel aboutContentPane = null;
	private JLabel aboutVersionLabel = null;
	private JTabbedPane Kullan�c�_Men�s� = null;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JTabbedPane M��teri_Men�s� = null;
	private JPanel jPanel2 = null;
	private JPanel Belirli_Fiyatlar_Aras�ndaki_T�m_T�rlerin_Bulunup_Listelenmesi = null;
	private JPanel Verilen_Bir_Kelimenin_Kategori_A�a�lar�nda_Tutulan_Bitkilerin_�zellikleri_��inden_Arat�lmas�_Bulunan_Bitki_�simlerinin_Listelenmesi = null;
	private JPanel �r�n_Sipari�i_Birden_�ok_Paket_�stenebilir_ve_Al�m� = null;
	private JLabel M��teri_Men�s�_Ba�l��� = null;
	private JLabel Personel_Men�s�_Ba�l��� = null;
	private JTabbedPane Personel_Men�s� = null;
	private JPanel jPanel6 = null;
	private JPanel Firmaya_Yeni_T�rde_�r�n_Giri�i = null;
	private JPanel Ad�ndan_�r�n_Arama_ve_Silme = null;
	private JPanel �r�n_Bilgilerinde_De�i�iklik = null;
	private JPanel Yeni_Hastal�k_Bilgisi_Giri�i = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JPanel Kategori_Listeleme_A�a�_Derinlli�i_ve_Eleman_Say�s�n�_Yazd�rma = null;
	private JPanel Kategori_A�a�lar�n�_Dengeleme = null;
	private JPanel Verilen_Bir_Hastal��a_�li�kin_Bilgilerin_Listelenmesi_Hash_Table_Dan = null;
	private JPanel Belli_Bir_Hastal��a_�yi_Gelebilen_Bitkilerin_Fiyatlar�na_G�re_Heap_e_At�lmas�_ve_N_Tanesinden_Birer_Paket_Sat�n_Al�nmas� = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	private JLabel jLabel9 = null;
	private JLabel jLabel10 = null;
	private JTabbedPane jTabbedPane3 = null;
	private JPanel jPanel16 = null;
	private JLabel jLabel61 = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel12 = null;
	private JTabbedPane Kategori_Ekleme_ve_Silme_Men�s� = null;
	private JPanel Kategori_Ekleme = null;
	private JPanel Kategori_Silme = null;
	private JLabel jLabel13 = null;
	private JLabel jLabel14 = null;
	private JLabel jLabel15 = null;
	private JLabel jLabel16 = null;
	private JLabel jLabel17 = null;
	private JLabel jLabel18 = null;
	private JTextArea jTextArea = null;
	private JPanel Ad�ndan_�r�n_Arama_ve_Listeleme = null;
	private JPanel jPanel23 = null;
	private JLabel jLabel21 = null;
	private static JTextField jTextField = null;
	private JTextArea jTextArea1 = null;
	private JButton jButton = null;

	/**
	 * This method initializes Kullan�c�_Men�s�
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getKullan�c�_Men�s�() {
		if (Kullan�c�_Men�s� == null) {
			Kullan�c�_Men�s� = new JTabbedPane();
			Kullan�c�_Men�s�.setBounds(new Rectangle(0, 0, 985, 635));
			Kullan�c�_Men�s�.addTab(null, null, getJPanel(), null);
			Kullan�c�_Men�s�.addTab(null, null, getJPanel1(), null);
		}
		return Kullan�c�_Men�s�;
	}

	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			M��teri_Men�s�_Ba�l��� = new JLabel();
			M��teri_Men�s�_Ba�l���.setBounds(new Rectangle(0, 0, 343, 16));
			M��teri_Men�s�_Ba�l���
					.setText("M��terilerin Kulanabilecekleri B�l�m");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(getM��teri_Men�s�(), null);
			jPanel.add(M��teri_Men�s�_Ba�l���, null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			Personel_Men�s�_Ba�l��� = new JLabel();
			Personel_Men�s�_Ba�l���.setBounds(new Rectangle(0, 0, 346, 16));
			Personel_Men�s�_Ba�l���
					.setText("Sadece Firma Personelinin Kullanabilece�i B�l�m");
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.add(Personel_Men�s�_Ba�l���, null);
			jPanel1.add(getPersonel_Men�s�(), null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes M��teri_Men�s�
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getM��teri_Men�s�() {
		if (M��teri_Men�s� == null) {
			M��teri_Men�s� = new JTabbedPane();
			M��teri_Men�s�.setBounds(new Rectangle(0, 16, 979, 589));
			M��teri_Men�s�.addTab(null, null, getJPanel2(), null);
			M��teri_Men�s�
					.addTab(
							null,
							null,
							getBelirli_Fiyatlar_Aras�ndaki_T�m_T�rlerin_Bulunup_Listelenmesi(),
							null);
			M��teri_Men�s�
					.addTab(
							null,
							null,
							getVerilen_Bir_Kelimenin_Kategori_A�a�lar�nda_Tutulan_Bitkilerin_�zellikleri_��inden_Arat�lmas�_Bulunan_Bitki_�simlerinin_Listelenmesi(),
							null);
			M��teri_Men�s�.addTab(null, null,
					get�r�n_Sipari�i_Birden_�ok_Paket_�stenebilir_ve_Al�m�(),
					null);
			M��teri_Men�s�
					.addTab(
							null,
							null,
							getKategori_Listeleme_A�a�_Derinlli�i_ve_Eleman_Say�s�n�_Yazd�rma(),
							null);
			M��teri_Men�s�.addTab(null, null,
					getKategori_A�a�lar�n�_Dengeleme(), null);
			M��teri_Men�s�
					.addTab(
							null,
							null,
							getVerilen_Bir_Hastal��a_�li�kin_Bilgilerin_Listelenmesi_Hash_Table_Dan(),
							null);
			M��teri_Men�s�
					.addTab(
							null,
							null,
							getBelli_Bir_Hastal��a_�yi_Gelebilen_Bitkilerin_Fiyatlar�na_G�re_Heap_e_At�lmas�_ve_N_Tanesinden_Birer_Paket_Sat�n_Al�nmas�(),
							null);
		}
		return M��teri_Men�s�;
	}

	/**
	 * This method initializes jPanel2
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(0, 0, 974, 16));
			jLabel2.setText("Ad�ndan �r�n Arama ve Bilgilerini Listeleme");
			jPanel2 = new JPanel();
			jPanel2.setLayout(null);
			jPanel2.add(jLabel2, null);
			jPanel2.add(getAd�ndan_�r�n_Arama_ve_Listeleme(), null);
		}
		return jPanel2;
	}

	/**
	 * This method initializes
	 * Belirli_Fiyatlar_Aras�ndaki_T�m_T�rlerin_Bulunup_Listelenmesi
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getBelirli_Fiyatlar_Aras�ndaki_T�m_T�rlerin_Bulunup_Listelenmesi() {
		if (Belirli_Fiyatlar_Aras�ndaki_T�m_T�rlerin_Bulunup_Listelenmesi == null) {
			jLabel48 = new JLabel();
			jLabel48.setBounds(new Rectangle(330, 17, 166, 16));
			jLabel48.setText("Maxsimum Fiyat� Giriniz");
			jLabel47 = new JLabel();
			jLabel47.setBounds(new Rectangle(-2, 17, 168, 16));
			jLabel47.setText("Minimum Fiyat� Giriniz");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(0, 1, 495, 16));
			jLabel3
					.setText("Belirli Fiyatlar Aras�ndaki T�m �r�nlerin Bulunup Listelenmesi");
			Belirli_Fiyatlar_Aras�ndaki_T�m_T�rlerin_Bulunup_Listelenmesi = new JPanel();
			Belirli_Fiyatlar_Aras�ndaki_T�m_T�rlerin_Bulunup_Listelenmesi
					.setLayout(null);
			Belirli_Fiyatlar_Aras�ndaki_T�m_T�rlerin_Bulunup_Listelenmesi.add(
					jLabel3, null);
			Belirli_Fiyatlar_Aras�ndaki_T�m_T�rlerin_Bulunup_Listelenmesi.add(jLabel47, null);
			Belirli_Fiyatlar_Aras�ndaki_T�m_T�rlerin_Bulunup_Listelenmesi.add(jLabel48, null);
			Belirli_Fiyatlar_Aras�ndaki_T�m_T�rlerin_Bulunup_Listelenmesi.add(getJTextField11(), null);
			Belirli_Fiyatlar_Aras�ndaki_T�m_T�rlerin_Bulunup_Listelenmesi.add(getJTextField16(), null);
			Belirli_Fiyatlar_Aras�ndaki_T�m_T�rlerin_Bulunup_Listelenmesi.add(getJButton13(), null);
			Belirli_Fiyatlar_Aras�ndaki_T�m_T�rlerin_Bulunup_Listelenmesi.add(getJTextArea15(), null);
		}
		return Belirli_Fiyatlar_Aras�ndaki_T�m_T�rlerin_Bulunup_Listelenmesi;
	}

	/**
	 * ThismethodinitializesVerilen_Bir_Kelimenin_Kategori_A�a�lar�nda_Tutulan_Bitkilerin_�zellikleri_��inden_Arat�lmas�_Bulunan_Bitki_�simlerinin_Listelenmesi
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getVerilen_Bir_Kelimenin_Kategori_A�a�lar�nda_Tutulan_Bitkilerin_�zellikleri_��inden_Arat�lmas�_Bulunan_Bitki_�simlerinin_Listelenmesi() {
		if (Verilen_Bir_Kelimenin_Kategori_A�a�lar�nda_Tutulan_Bitkilerin_�zellikleri_��inden_Arat�lmas�_Bulunan_Bitki_�simlerinin_Listelenmesi == null) {
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(0, 2, 779, 16));
			jLabel4
					.setText("Verilen Bir Kelimenin Kategori A�a�lar�nda Tutulan Bitkilerin �zellikleri ��inden Arat�lmas�,Bulunan Bitki �simlerinin Listelenmesi");
			Verilen_Bir_Kelimenin_Kategori_A�a�lar�nda_Tutulan_Bitkilerin_�zellikleri_��inden_Arat�lmas�_Bulunan_Bitki_�simlerinin_Listelenmesi = new JPanel();
			Verilen_Bir_Kelimenin_Kategori_A�a�lar�nda_Tutulan_Bitkilerin_�zellikleri_��inden_Arat�lmas�_Bulunan_Bitki_�simlerinin_Listelenmesi
					.setLayout(null);
			Verilen_Bir_Kelimenin_Kategori_A�a�lar�nda_Tutulan_Bitkilerin_�zellikleri_��inden_Arat�lmas�_Bulunan_Bitki_�simlerinin_Listelenmesi
					.add(jLabel4, null);
		}
		return Verilen_Bir_Kelimenin_Kategori_A�a�lar�nda_Tutulan_Bitkilerin_�zellikleri_��inden_Arat�lmas�_Bulunan_Bitki_�simlerinin_Listelenmesi;
	}

	/**
	 * This method initializes
	 * �r�n_Sipari�i_Birden_�ok_Paket_�stenebilir_ve_Al�m�
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel get�r�n_Sipari�i_Birden_�ok_Paket_�stenebilir_ve_Al�m�() {
		if (�r�n_Sipari�i_Birden_�ok_Paket_�stenebilir_ve_Al�m� == null) {
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(0, 2, 779, 16));
			jLabel5
					.setText("�r�n Sipari�i (Birden �ok Paket �stenebilir )ve Al�m�");
			�r�n_Sipari�i_Birden_�ok_Paket_�stenebilir_ve_Al�m� = new JPanel();
			�r�n_Sipari�i_Birden_�ok_Paket_�stenebilir_ve_Al�m�.setLayout(null);
			�r�n_Sipari�i_Birden_�ok_Paket_�stenebilir_ve_Al�m�.add(jLabel5,
					null);
		}
		return �r�n_Sipari�i_Birden_�ok_Paket_�stenebilir_ve_Al�m�;
	}

	/**
	 * This method initializes Personel_Men�s�
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getPersonel_Men�s�() {
		if (Personel_Men�s� == null) {
			Personel_Men�s� = new JTabbedPane();
			Personel_Men�s�.setBounds(new Rectangle(0, 16, 979, 590));
			Personel_Men�s�.addTab(null, null, getJPanel6(), null);
			Personel_Men�s�.addTab(null, null,
					getFirmaya_Yeni_T�rde_�r�n_Giri�i(), null);
			Personel_Men�s�.addTab(null, null,
					getAd�ndan_�r�n_Arama_ve_Silme(), null);
			Personel_Men�s�.addTab(null, null,
					get�r�n_Bilgilerinde_De�i�iklik(), null);
			Personel_Men�s�.addTab(null, null,
					getYeni_Hastal�k_Bilgisi_Giri�i(), null);
		}
		return Personel_Men�s�;
	}

	/**
	 * This method initializes jPanel6
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel6() {
		if (jPanel6 == null) {
			jLabel12 = new JLabel();
			jLabel12.setBounds(new Rectangle(0, 0, 779, 16));
			jLabel12.setText("Kategori Ekleme ve Kategori Silme");
			jPanel6 = new JPanel();
			jPanel6.setLayout(null);
			jPanel6.add(jLabel12, null);
			jPanel6.add(getKategori_Ekleme_ve_Silme_Men�s�(), null);
		}
		return jPanel6;
	}

	/**
	 * This method initializes Firmaya_Yeni_T�rde_�r�n_Giri�i
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getFirmaya_Yeni_T�rde_�r�n_Giri�i() {
		if (Firmaya_Yeni_T�rde_�r�n_Giri�i == null) {
			jLabel49 = new JLabel();
			jLabel49.setBounds(new Rectangle(241, 16, 316, 16));
			jLabel49.setText("Eklenmek �stenen �r�n A�a� Kategorilerinde Var M�?");
			jLabel46 = new JLabel();
			jLabel46.setBounds(new Rectangle(1, 16, 241, 16));
			jLabel46.setText("Eklemek �stedi�iniz �r�n�n Ad�n� Giriniz");
			jLabel15 = new JLabel();
			jLabel15.setBounds(new Rectangle(0, 0, 778, 16));
			jLabel15.setText("Firmaya Yeni T�rde �r�n Giri�i");
			Firmaya_Yeni_T�rde_�r�n_Giri�i = new JPanel();
			Firmaya_Yeni_T�rde_�r�n_Giri�i.setLayout(null);
			Firmaya_Yeni_T�rde_�r�n_Giri�i.add(jLabel15, null);
			Firmaya_Yeni_T�rde_�r�n_Giri�i.add(getGe�ici_metin_kutusu(), null);
			Firmaya_Yeni_T�rde_�r�n_Giri�i.add(jLabel46, null);
			Firmaya_Yeni_T�rde_�r�n_Giri�i.add(getJTextField17(), null);
			Firmaya_Yeni_T�rde_�r�n_Giri�i.add(jLabel49, null);
			Firmaya_Yeni_T�rde_�r�n_Giri�i.add(getJTextField18(), null);
			Firmaya_Yeni_T�rde_�r�n_Giri�i.add(getJButton19(), null);
		}
		return Firmaya_Yeni_T�rde_�r�n_Giri�i;
	}

	/**
	 * This method initializes Ad�ndan_�r�n_Arama_ve_Silme
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAd�ndan_�r�n_Arama_ve_Silme() {
		if (Ad�ndan_�r�n_Arama_ve_Silme == null) {
			jLabel33 = new JLabel();
			jLabel33.setBounds(new Rectangle(-1, 72, 112, 16));
			jLabel33.setText("�r�n Bilgisi");
			jLabel20 = new JLabel();
			jLabel20.setBounds(new Rectangle(300, 16, 300, 16));
			jLabel20.setText("Aranan �r�n Var M�?");
			jLabel19 = new JLabel();
			jLabel19.setBounds(new Rectangle(0, 16, 300, 16));
			jLabel19.setText("Aranan �r�n�n Ad�n� Giriniz");
			jLabel16 = new JLabel();
			jLabel16.setBounds(new Rectangle(0, 0, 778, 16));
			jLabel16.setText("Ad�ndan �r�n Bilgisi Arama ve Silme");
			Ad�ndan_�r�n_Arama_ve_Silme = new JPanel();
			Ad�ndan_�r�n_Arama_ve_Silme.setLayout(null);
			Ad�ndan_�r�n_Arama_ve_Silme.add(jLabel16, null);
			Ad�ndan_�r�n_Arama_ve_Silme.add(jLabel19, null);
			Ad�ndan_�r�n_Arama_ve_Silme.add(getJTextField7(), null);
			Ad�ndan_�r�n_Arama_ve_Silme.add(getJButton10(), null);
			Ad�ndan_�r�n_Arama_ve_Silme.add(jLabel20, null);
			Ad�ndan_�r�n_Arama_ve_Silme.add(getJTextField8(), null);
			Ad�ndan_�r�n_Arama_ve_Silme.add(getJButton11(), null);
			Ad�ndan_�r�n_Arama_ve_Silme.add(jLabel33, null);
			Ad�ndan_�r�n_Arama_ve_Silme
					.add(get�r�n_Bilgisi_Listeleyici(), null);
			Ad�ndan_�r�n_Arama_ve_Silme.add(getJTextArea8(), null);
		}
		return Ad�ndan_�r�n_Arama_ve_Silme;
	}

	/**
	 * This method initializes �r�n_Bilgilerinde_De�i�iklik
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel get�r�n_Bilgilerinde_De�i�iklik() {
		if (�r�n_Bilgilerinde_De�i�iklik == null) {
			jLabel17 = new JLabel();
			jLabel17.setBounds(new Rectangle(0, 0, 775, 16));
			jLabel17.setText("�r�n Bilgilerinde De�i�iklik");
			�r�n_Bilgilerinde_De�i�iklik = new JPanel();
			�r�n_Bilgilerinde_De�i�iklik.setLayout(null);
			�r�n_Bilgilerinde_De�i�iklik.add(jLabel17, null);
			�r�n_Bilgilerinde_De�i�iklik.add(getJTextArea(), null);
		}
		return �r�n_Bilgilerinde_De�i�iklik;
	}

	/**
	 * This method initializes Yeni_Hastal�k_Bilgisi_Giri�i
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getYeni_Hastal�k_Bilgisi_Giri�i() {
		if (Yeni_Hastal�k_Bilgisi_Giri�i == null) {
			jLabel45 = new JLabel();
			jLabel45.setBounds(new Rectangle(4, 448, 220, 23));
			jLabel45.setText("Kaydetme Bilgisi");
			jLabel36 = new JLabel();
			jLabel36.setBounds(new Rectangle(0, 427, 225, 16));
			jLabel36.setText("Bilgileri Kaydetmek �stiyor Musunuz?");
			jLabel44 = new JLabel();
			jLabel44.setBounds(new Rectangle(468, 313, 318, 16));
			jLabel44.setText("Tavsiye Edilen Bitkiler");
			jLabel43 = new JLabel();
			jLabel43.setBounds(new Rectangle(1, 213, 224, 16));
			jLabel43.setText("Tedavi Y�ntemi");
			jLabel42 = new JLabel();
			jLabel42.setBounds(new Rectangle(470, 163, 314, 16));
			jLabel42.setText("Nedenler");
			jLabel41 = new JLabel();
			jLabel41.setBounds(new Rectangle(471, 17, 314, 16));
			jLabel41.setText("Belirtiler");
			jLabel40 = new JLabel();
			jLabel40.setBounds(new Rectangle(0, 179, 222, 16));
			jLabel40.setText("�nerilen Bitkileri Ekleme Yeri");
			jLabel39 = new JLabel();
			jLabel39.setBounds(new Rectangle(-1, 144, 222, 16));
			jLabel39.setText("Tedavileri Ekleme Yeri");
			jLabel38 = new JLabel();
			jLabel38.setBounds(new Rectangle(1, 109, 220, 16));
			jLabel38.setText("Nedenleri Ekleme Yeri");
			jLabel37 = new JLabel();
			jLabel37.setBounds(new Rectangle(1, 72, 222, 16));
			jLabel37.setText("Belirtileri Ekleme Yeri");
			jLabel35 = new JLabel();
			jLabel35.setBounds(new Rectangle(226, 15, 240, 16));
			jLabel35.setText("Hastal�k Veri Taban�nda Var M�?");
			jLabel31 = new JLabel();
			jLabel31.setBounds(new Rectangle(0, 16, 227, 16));
			jLabel31.setText("Hastal�k Ad�n� Giriniz");
			jLabel18 = new JLabel();
			jLabel18.setBounds(new Rectangle(0, 0, 780, 16));
			jLabel18.setText("Yeni Hastal�k Bilgisi Giri�i");
			Yeni_Hastal�k_Bilgisi_Giri�i = new JPanel();
			Yeni_Hastal�k_Bilgisi_Giri�i.setLayout(null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(jLabel18, null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(jLabel31, null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(getJTextField4(), null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(getJButton7(), null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(jLabel35, null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(getJTextField10(), null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(jLabel37, null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(getJTextField12(), null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(getJButton14(), null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(jLabel38, null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(getJTextField13(), null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(getJButton15(), null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(jLabel39, null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(getJTextField14(), null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(getJButton16(), null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(jLabel40, null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(getJButton17(), null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(getJTextField15(), null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(getJTextArea10(), null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(jLabel41, null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(jLabel42, null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(getJTextArea11(), null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(jLabel43, null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(getJTextArea12(), null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(jLabel44, null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(getJTextArea13(), null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(getJButton18(), null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(jLabel36, null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(getJTextArea14(), null);
			Yeni_Hastal�k_Bilgisi_Giri�i.add(jLabel45, null);
		}
		return Yeni_Hastal�k_Bilgisi_Giri�i;
	}

	/**
	 * This method initializes
	 * Kategori_Listeleme_A�a�_Derinlli�i_ve_Eleman_Say�s�n�_Yazd�rma
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getKategori_Listeleme_A�a�_Derinlli�i_ve_Eleman_Say�s�n�_Yazd�rma() {
		if (Kategori_Listeleme_A�a�_Derinlli�i_ve_Eleman_Say�s�n�_Yazd�rma == null) {
			jLabel10 = new JLabel();
			jLabel10.setBounds(new Rectangle(0, 16, 783, 16));
			jLabel10
					.setText(" �lgili A�ac�n Derinli�ini ve Eleman Say�s�n� Yazd�rma");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(1, 2, 778, 16));
			jLabel6
					.setText("Belirtilen Bir Kategorideki T�m �r�nleri D�zeyleri �le Birlikte Listeleme(Inorder,Preorder,Postorder).");
			Kategori_Listeleme_A�a�_Derinlli�i_ve_Eleman_Say�s�n�_Yazd�rma = new JPanel();
			Kategori_Listeleme_A�a�_Derinlli�i_ve_Eleman_Say�s�n�_Yazd�rma
					.setLayout(null);
			Kategori_Listeleme_A�a�_Derinlli�i_ve_Eleman_Say�s�n�_Yazd�rma.add(
					jLabel6, null);
			Kategori_Listeleme_A�a�_Derinlli�i_ve_Eleman_Say�s�n�_Yazd�rma.add(
					jLabel10, null);
			Kategori_Listeleme_A�a�_Derinlli�i_ve_Eleman_Say�s�n�_Yazd�rma.add(
					getJTabbedPane3(), null);
		}
		return Kategori_Listeleme_A�a�_Derinlli�i_ve_Eleman_Say�s�n�_Yazd�rma;
	}

	/**
	 * This method initializes Kategori_A�a�lar�n�_Dengeleme
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getKategori_A�a�lar�n�_Dengeleme() {
		if (Kategori_A�a�lar�n�_Dengeleme == null) {
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(2, 1, 778, 16));
			jLabel7.setText("Kategori A�a�lar�n� Dengeleme");
			Kategori_A�a�lar�n�_Dengeleme = new JPanel();
			Kategori_A�a�lar�n�_Dengeleme.setLayout(null);
			Kategori_A�a�lar�n�_Dengeleme.add(jLabel7, null);
		}
		return Kategori_A�a�lar�n�_Dengeleme;
	}

	/**
	 * This method initializes
	 * Verilen_Bir_Hastal��a_�li�kin_Bilgilerin_Listelenmesi_Hash_Table_Dan
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getVerilen_Bir_Hastal��a_�li�kin_Bilgilerin_Listelenmesi_Hash_Table_Dan() {
		if (Verilen_Bir_Hastal��a_�li�kin_Bilgilerin_Listelenmesi_Hash_Table_Dan == null) {
			jLabel34 = new JLabel();
			jLabel34.setBounds(new Rectangle(0, 16, 260, 16));
			jLabel34.setText("Aranan Hastal���n Ad�n� Giriniz");
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(0, 0, 783, 16));
			jLabel8
					.setText("Verilen Bir Hastal��a �li�kin Bilgilerin Listelenmesi (Hash Table'dan)");
			Verilen_Bir_Hastal��a_�li�kin_Bilgilerin_Listelenmesi_Hash_Table_Dan = new JPanel();
			Verilen_Bir_Hastal��a_�li�kin_Bilgilerin_Listelenmesi_Hash_Table_Dan
					.setLayout(null);
			Verilen_Bir_Hastal��a_�li�kin_Bilgilerin_Listelenmesi_Hash_Table_Dan
					.add(jLabel8, null);
			Verilen_Bir_Hastal��a_�li�kin_Bilgilerin_Listelenmesi_Hash_Table_Dan
					.add(getJTextField9(), null);
			Verilen_Bir_Hastal��a_�li�kin_Bilgilerin_Listelenmesi_Hash_Table_Dan
					.add(jLabel34, null);
			Verilen_Bir_Hastal��a_�li�kin_Bilgilerin_Listelenmesi_Hash_Table_Dan
					.add(getJButton12(), null);
			Verilen_Bir_Hastal��a_�li�kin_Bilgilerin_Listelenmesi_Hash_Table_Dan
					.add(getJTextArea9(), null);
		}
		return Verilen_Bir_Hastal��a_�li�kin_Bilgilerin_Listelenmesi_Hash_Table_Dan;
	}

	/**
	 * ThismethodinitializesBelli_Bir_Hastal��a_�yi_Gelebilen_Bitkilerin_Fiyatlar�na_G�re_Heap_e_At�lmas�_ve_N_Tanesinden_Birer_Paket_Sat�n_Al�nmas�
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getBelli_Bir_Hastal��a_�yi_Gelebilen_Bitkilerin_Fiyatlar�na_G�re_Heap_e_At�lmas�_ve_N_Tanesinden_Birer_Paket_Sat�n_Al�nmas�() {
		if (Belli_Bir_Hastal��a_�yi_Gelebilen_Bitkilerin_Fiyatlar�na_G�re_Heap_e_At�lmas�_ve_N_Tanesinden_Birer_Paket_Sat�n_Al�nmas� == null) {
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(0, 16, 784, 16));
			jLabel11.setText("En Ucuz N Tanesinden 1'er Paket Sat�n Al�nmas�");
			jLabel9 = new JLabel();
			jLabel9.setBounds(new Rectangle(0, 1, 780, 16));
			jLabel9
					.setText("Belli Bir Hastal��a �yi Gelebilen Bitkilerin Fiyatlar�na G�re Heap'e At�lmas�");
			Belli_Bir_Hastal��a_�yi_Gelebilen_Bitkilerin_Fiyatlar�na_G�re_Heap_e_At�lmas�_ve_N_Tanesinden_Birer_Paket_Sat�n_Al�nmas� = new JPanel();
			Belli_Bir_Hastal��a_�yi_Gelebilen_Bitkilerin_Fiyatlar�na_G�re_Heap_e_At�lmas�_ve_N_Tanesinden_Birer_Paket_Sat�n_Al�nmas�
					.setLayout(null);
			Belli_Bir_Hastal��a_�yi_Gelebilen_Bitkilerin_Fiyatlar�na_G�re_Heap_e_At�lmas�_ve_N_Tanesinden_Birer_Paket_Sat�n_Al�nmas�
					.add(jLabel9, null);
			Belli_Bir_Hastal��a_�yi_Gelebilen_Bitkilerin_Fiyatlar�na_G�re_Heap_e_At�lmas�_ve_N_Tanesinden_Birer_Paket_Sat�n_Al�nmas�
					.add(jLabel11, null);
		}
		return Belli_Bir_Hastal��a_�yi_Gelebilen_Bitkilerin_Fiyatlar�na_G�re_Heap_e_At�lmas�_ve_N_Tanesinden_Birer_Paket_Sat�n_Al�nmas�;
	}

	/**
	 * This method initializes jTabbedPane3
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getJTabbedPane3() {
		if (jTabbedPane3 == null) {
			jTabbedPane3 = new JTabbedPane();
			jTabbedPane3.setBounds(new Rectangle(-1, 31, 972, 531));
			jTabbedPane3.addTab(null, null, getJPanel16(), null);
		}
		return jTabbedPane3;
	}

	/**
	 * This method initializes jPanel16
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel16() {
		if (jPanel16 == null) {
			jLabel50 = new JLabel();
			jLabel50.setBounds(new Rectangle(819, 37, 144, 16));
			jLabel50.setText("Eleman Say�s�");
			jLabel27 = new JLabel();
			jLabel27.setBounds(new Rectangle(819, 3, 143, 16));
			jLabel27.setText("A�ac�n Derinli�i");
			jLabel26 = new JLabel();
			jLabel26.setBounds(new Rectangle(405, 32, 410, 16));
			jLabel26.setText("Kategori Var M�?");
			jLabel25 = new JLabel();
			jLabel25.setBounds(new Rectangle(0, 16, 777, 16));
			jLabel25
					.setText("L�tfen Listelemek �stedi�iniz Kategoriyi Belirtiniz");
			jLabel61 = new JLabel();
			jLabel61.setBounds(new Rectangle(1, 1, 776, 16));
			jLabel61
					.setText("Belirtilen Bir Kategorideki T�m �r�nleri D�zeyleri �le Birlikte Listeleme(Inorder,Preorder,Postorder).");
			jPanel16 = new JPanel();
			jPanel16.setLayout(null);
			jPanel16.add(jLabel61, null);
			jPanel16.add(getJTabbedPane6(), null);
			jPanel16.add(jLabel25, null);
			jPanel16.add(getJTextField1(), null);
			jPanel16.add(getJButton1(), null);
			jPanel16.add(getJTextArea5(), null);
			jPanel16.add(jLabel26, null);
			jPanel16.add(jLabel27, null);
			jPanel16.add(getJTextField19(), null);
			jPanel16.add(jLabel50, null);
			jPanel16.add(getJTextField20(), null);
		}
		return jPanel16;
	}

	/**
	 * This method initializes Kategori_Ekleme_ve_Silme_Men�s�
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getKategori_Ekleme_ve_Silme_Men�s�() {
		if (Kategori_Ekleme_ve_Silme_Men�s� == null) {
			Kategori_Ekleme_ve_Silme_Men�s� = new JTabbedPane();
			Kategori_Ekleme_ve_Silme_Men�s�.setBounds(new Rectangle(0, 16, 973,
					555));
			Kategori_Ekleme_ve_Silme_Men�s�.addTab(null, null,
					getKategori_Ekleme(), null);
			Kategori_Ekleme_ve_Silme_Men�s�.addTab(null, null,
					getKategori_Silme(), null);
		}
		return Kategori_Ekleme_ve_Silme_Men�s�;
	}

	/**
	 * This method initializes Kategori_Ekleme
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getKategori_Ekleme() {
		if (Kategori_Ekleme == null) {
			jLabel29 = new JLabel();
			jLabel29.setBounds(new Rectangle(290, 16, 283, 16));
			jLabel29.setText("Kategori Var M�?");
			jLabel28 = new JLabel();
			jLabel28.setBounds(new Rectangle(0, 16, 291, 16));
			jLabel28
					.setText("L�tfen Eklemek �stedi�iniz Kategori �smini Giriniz");
			jLabel13 = new JLabel();
			jLabel13.setBounds(new Rectangle(0, 0, 771, 16));
			jLabel13.setText("Kategori Ekleme");
			Kategori_Ekleme = new JPanel();
			Kategori_Ekleme.setLayout(null);
			Kategori_Ekleme.add(jLabel13, null);
			Kategori_Ekleme.add(jLabel28, null);
			Kategori_Ekleme.add(getJTextField2(), null);
			Kategori_Ekleme.add(jLabel29, null);
			Kategori_Ekleme.add(getJTextField3(), null);
			Kategori_Ekleme.add(getJButton5(), null);
			Kategori_Ekleme.add(getJButton6(), null);
			Kategori_Ekleme.add(getJLabel30(), null);
			Kategori_Ekleme.add(getJTextArea4(), null);
			Kategori_Ekleme.add(getKategori_Listeleyici(), null);
		}
		return Kategori_Ekleme;
	}

	/**
	 * This method initializes Kategori_Silme
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getKategori_Silme() {
		if (Kategori_Silme == null) {
			jLabel32 = new JLabel();
			jLabel32.setBounds(new Rectangle(0, 72, 111, 16));
			jLabel32.setText("Kategori Listesi");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(252, 16, 240, 16));
			jLabel1.setText("Kategori Var M�?");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(0, 16, 252, 16));
			jLabel.setText("Silmek �stedi�iniz Kategorinin Ad�n� Giriniz");
			jLabel14 = new JLabel();
			jLabel14.setBounds(new Rectangle(0, 0, 771, 16));
			jLabel14.setText("Kategori Silme");
			Kategori_Silme = new JPanel();
			Kategori_Silme.setLayout(null);
			Kategori_Silme.add(jLabel14, null);
			Kategori_Silme.add(jLabel, null);
			Kategori_Silme.add(getJTextField5(), null);
			Kategori_Silme.add(jLabel1, null);
			Kategori_Silme.add(getJTextField6(), null);
			Kategori_Silme.add(getJButton8(), null);
			Kategori_Silme.add(getJButton9(), null);
			Kategori_Silme.add(jLabel32, null);
			Kategori_Silme.add(getKategori_Listeleyici_2(), null);
			Kategori_Silme.add(getJTextArea7(), null);
		}
		return Kategori_Silme;
	}

	/**
	 * This method initializes jTextArea
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setBounds(new Rectangle(0, 16, 776, 181));
			jTextArea
					.setText("Bitkiye �li�kin Bilgiler:\nBitki Ad�,\nKategori,\nBitkinin Latince �smi,\nBitkinin �zellikleri,\nMiktar�,\nFiyat�,\nBitki Resminin Diskteki Yeri\nBitki �sminin Diskteki Ad�,\n�nerilen Hastal�klar\nVectore ekleme yap�lacak �ekilde ayarlanmal�");
		}
		return jTextArea;
	}

	/**
	 * This method initializes Ad�ndan_�r�n_Arama_ve_Listeleme
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAd�ndan_�r�n_Arama_ve_Listeleme() {
		if (Ad�ndan_�r�n_Arama_ve_Listeleme == null) {
			Ad�ndan_�r�n_Arama_ve_Listeleme = new JPanel();
			Ad�ndan_�r�n_Arama_ve_Listeleme.setLayout(null);
			Ad�ndan_�r�n_Arama_ve_Listeleme.setBounds(new Rectangle(0, 16, 971,
					550));
			Ad�ndan_�r�n_Arama_ve_Listeleme.add(getJPanel23(), null);
			Ad�ndan_�r�n_Arama_ve_Listeleme.add(getJTextArea1(), null);
		}
		return Ad�ndan_�r�n_Arama_ve_Listeleme;
	}

	/**
	 * This method initializes jPanel23
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel23() {
		if (jPanel23 == null) {
			jLabel21 = new JLabel();
			jLabel21.setBounds(new Rectangle(0, 0, 249, 16));
			jLabel21.setText("Aranan �r�n�n Ad�n� Giriniz:");
			jPanel23 = new JPanel();
			jPanel23.setLayout(null);
			jPanel23.setBounds(new Rectangle(0, 0, 251, 64));
			jPanel23.add(jLabel21, null);
			jPanel23.add(getJTextField(), null);
			jPanel23.add(getJButton(), null);
		}
		return jPanel23;
	}

	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(0, 16, 249, 16));
			jTextField.setText("");
		}
		return jTextField;
	}

	/**
	 * This method initializes jTextArea1
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea1() {
		if (jTextArea1 == null) {
			jTextArea1 = new JTextArea();
			jTextArea1.setBounds(new Rectangle(0, 65, 965, 450));
			jTextArea1.setText("");
		}
		return jTextArea1;
	}

	private static String aranan_�r�n�n_bilgilerini_listele(String aranan_�r�n) {
		String yan�t = "";

		for (int i = 0; i < getA�a�_vekt�r�().getA�a�lar().size(); i++) {
			yan�t = getA�a�_vekt�r�().getA�a�lar().elementAt(i).find(
					getA�a�_vekt�r�().getA�a�lar().elementAt(i).getNode(),
					aranan_�r�n);
			if (yan�t.compareTo("Bulunamad�") != 0) {
				break;
			}
		}
		return yan�t;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(2, 31, 246, 33));
			jButton.setText("Aranan �r�n�n Bilgilerini Listele");
			jButton.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jTextArea1
							.setText(aranan_�r�n�n_bilgilerini_listele(jTextField
									.getText()));
					System.out.println("Aranan �r�n Bilgileri Listelendi"); // TODO
					// Auto-generated
					// Event stub
					// mouseClicked()
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jButton;
	}

	/**
	 * @param args
	 */
	private static Kategori_veri_taban� kategori_veri_taban�;
	private static Bitki_veri_taban� bitki_veri_taban�;
	private static Vector_A�a� a�a�_vekt�r�;
	private JTabbedPane jTabbedPane6 = null;
	private JPanel jPanel11 = null;
	private JPanel jPanel24 = null;
	private JPanel jPanel25 = null;
	private JLabel jLabel22 = null;
	private JLabel jLabel23 = null;
	private JLabel jLabel24 = null;
	private JScrollPane jScrollPane1 = null;
	private JTextArea jTextArea3 = null;
	private JLabel jLabel25 = null;
	private JTextField jTextField1 = null;
	private JButton jButton1 = null;
	private JTextArea jTextArea5 = null;
	private JLabel jLabel26 = null;
	private JButton jButton2 = null;
	private JButton jButton3 = null;
	private JButton jButton4 = null;
	private JTextArea jTextArea2 = null;

	/**
	 * This method initializes jTabbedPane6
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getJTabbedPane6() {
		if (jTabbedPane6 == null) {
			jTabbedPane6 = new JTabbedPane();
			jTabbedPane6.setBounds(new Rectangle(0, 71, 963, 432));
			jTabbedPane6.addTab(null, null, getJPanel11(), null);
			jTabbedPane6.addTab(null, null, getJPanel24(), null);
			jTabbedPane6.addTab(null, null, getJPanel25(), null);
		}
		return jTabbedPane6;
	}

	/**
	 * This method initializes jPanel11
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel11() {
		if (jPanel11 == null) {
			jLabel22 = new JLabel();
			jLabel22.setBounds(new Rectangle(0, 0, 59, 16));
			jLabel22.setText("Inorder");
			jPanel11 = new JPanel();
			jPanel11.setLayout(null);
			jPanel11.add(jLabel22, null);
			jPanel11.add(getJButton2(), null);
			jPanel11.add(getJTextArea2(), null);
		}
		return jPanel11;
	}

	/**
	 * This method initializes jPanel24
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel24() {
		if (jPanel24 == null) {
			jLabel23 = new JLabel();
			jLabel23.setBounds(new Rectangle(0, 0, 64, 16));
			jLabel23.setText("Preorder");
			jPanel24 = new JPanel();
			jPanel24.setLayout(null);
			jPanel24.add(jLabel23, null);
			jPanel24.add(getJScrollPane1(), null);
			jPanel24.add(getJButton3(), null);
		}
		return jPanel24;
	}

	/**
	 * This method initializes jPanel25
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel25() {
		if (jPanel25 == null) {
			jLabel24 = new JLabel();
			jLabel24.setBounds(new Rectangle(0, 0, 76, 16));
			jLabel24.setText("Postorder");
			jPanel25 = new JPanel();
			jPanel25.setLayout(null);
			jPanel25.add(jLabel24, null);
			jPanel25.add(getJButton4(), null);
			jPanel25.add(getJTextArea6(), null);
		}
		return jPanel25;
	}

	/**
	 * This method initializes jScrollPane1
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(new Rectangle(0, 16, 957, 445));
			jScrollPane1.setViewportView(getJTextArea3());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jTextArea3
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea3() {
		if (jTextArea3 == null) {
			jTextArea3 = new JTextArea();
			jTextArea3.setText("");
		}
		return jTextArea3;
	}

	/**
	 * This method initializes jTextField1
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(0, 32, 400, 20));
			jTextField1.setText("");
		}
		return jTextField1;
	}

	public static String kategori_var_m�(String aranan) {
		String yan�t = getKategori_veri_taban�().kategoriyi_ara�t�r(aranan);
		return yan�t;
	}

	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	String yan�t = ""; // @jve:decl-index=0:
	private JTextArea jTextArea6 = null;
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(1, 50, 399, 21));
			jButton1.setText("Kategori Var M�?");
			jButton1.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					yan�t = kategori_var_m�(jTextField1.getText());
					jTextArea5.setText(yan�t);
					if(yan�t.compareTo("Bulunamad�")!=0){
						int endex = getKategori_veri_taban�()
						.getAranan_kategori_ka��n��_s�rada_bulundu();
				getA�a�_vekt�r�().getA�a�lar().elementAt(endex);
				jTextField20.setText(""+getA�a�_vekt�r�().getA�a�lar().elementAt(endex).node_say�s�);
					}
					System.out.println("mouseClicked()"); // TODO Auto-generated
					// Event stub
					// mouseClicked()
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});

		}
		return jButton1;
	}

	/**
	 * This method initializes jTextArea5
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea5() {
		if (jTextArea5 == null) {
			jTextArea5 = new JTextArea();
			jTextArea5.setBounds(new Rectangle(407, 51, 408, 18));
			jTextArea5.setText("�lk �nce Arama Yapman�z Gerekmektedir.");
		}
		return jTextArea5;
	}

	/**
	 * This method initializes jButton2
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(59, 1, 115, 15));
			jButton2.setText("Listele");
			jButton2.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jButton2.setText("T�kland� zaten...");
					if (jTextArea5.getText().compareTo(
							"�lk �nce Arama Yapman�z Gerekmektedir.") != 0
							&& jTextArea5.getText().compareTo(
									"B�yle Bir Kategori Bulunmamaktad�r") != 0) {
						int endex = getKategori_veri_taban�()
								.getAranan_kategori_ka��n��_s�rada_bulundu();
						getA�a�_vekt�r�().getA�a�lar().elementAt(endex)
								.setInorder(new Vector<String>());
						getA�a�_vekt�r�().getA�a�lar().elementAt(endex)
								.inOrder(
										getA�a�_vekt�r�().getA�a�lar()
												.elementAt(endex).getNode(), 0);
						jTextArea2.setText(getA�a�_vekt�r�().getA�a�lar()
								.elementAt(endex).inOrder_yazd�r());
						// jTextArea2.setText(getA�a�_vekt�r�().getA�a�lar().elementAt(endex).preOrder_yazd�r());
					}
					System.out.println("mouseClicked()"); // TODO Auto-generated
					// Event stub
					// mouseClicked()
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jButton3
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(65, 1, 115, 15));
			jButton3.setText("Listele");
			jButton3.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jButton3.setText("T�kland� zaten...");
					if (jTextArea5.getText().compareTo(
							"�lk �nce Arama Yapman�z Gerekmektedir.") != 0
							&& jTextArea5.getText().compareTo(
									"B�yle Bir Kategori Bulunmamaktad�r") != 0) {
						int endex = getKategori_veri_taban�()
								.getAranan_kategori_ka��n��_s�rada_bulundu();
						getA�a�_vekt�r�().getA�a�lar().elementAt(endex)
								.setPreorder(new Vector<String>());
						getA�a�_vekt�r�().getA�a�lar().elementAt(endex)
								.preOrder(
										getA�a�_vekt�r�().getA�a�lar()
												.elementAt(endex).getNode(), 0);
						// jTextArea3.setText(getA�a�_vekt�r�().getA�a�lar().elementAt(endex).inOrder_yazd�r());
						jTextArea3.setText(getA�a�_vekt�r�().getA�a�lar()
								.elementAt(endex).preOrder_yazd�r());
					}
					System.out.println("mouseClicked()"); // TODO Auto-generated
					// Event stub
					// mouseClicked()
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jButton3;
	}

	/**
	 * This method initializes jButton4
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setBounds(new Rectangle(74, 1, 115, 15));
			jButton4.setText("Listele");
			jButton4.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jButton4.setText("T�kland� zaten...");
					if (jTextArea5.getText().compareTo(
							"�lk �nce Arama Yapman�z Gerekmektedir.") != 0
							&& jTextArea5.getText().compareTo(
									"B�yle Bir Kategori Bulunmamaktad�r") != 0) {

						int endex = getKategori_veri_taban�()
								.getAranan_kategori_ka��n��_s�rada_bulundu();
						getA�a�_vekt�r�().getA�a�lar().elementAt(endex)
								.setPostorder(new Vector<String>());
						getA�a�_vekt�r�().getA�a�lar().elementAt(endex)
								.postOrder(
										getA�a�_vekt�r�().getA�a�lar()
												.elementAt(endex).getNode(), 0);
						// jTextArea6.setText(getA�a�_vekt�r�().getA�a�lar().elementAt(endex).postOrder_yazd�r());
						jTextArea6.setText(getA�a�_vekt�r�().getA�a�lar()
								.elementAt(endex).postOrder_yazd�r());
					}
					System.out.println("mouseClicked()"); // TODO Auto-generated
					// Event stub
					// mouseClicked()
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jButton4;
	}

	/**
	 * This method initializes jTextArea2
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea2() {
		if (jTextArea2 == null) {
			jTextArea2 = new JTextArea();
			jTextArea2.setBounds(new Rectangle(0, 16, 953, 385));
			jTextArea2.setText("");
		}
		return jTextArea2;
	}

	/**
	 * This method initializes jTextArea6
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea6() {
		if (jTextArea6 == null) {
			jTextArea6 = new JTextArea();
			jTextArea6.setBounds(new Rectangle(0, 16, 953, 385));
			jTextArea6.setText("");
		}
		return jTextArea6;
	}

	private static Hash_Table hash_table; // @jve:decl-index=0:
	private static Hastal�k_veri_taban� hastal�k_veri_taban�;
	private JLabel jLabel28 = null;
	private static JTextField jTextField2 = null;
	private JLabel jLabel29 = null;
	private static JTextField jTextField3 = null;
	private JButton jButton5 = null;
	private JButton jButton6 = null;
	private JLabel jLabel30 = null;
	private JTextArea jTextArea4 = null;
	private JLabel jLabel31 = null;
	private JTextField jTextField4 = null;
	private JButton jButton7 = null;
	private JButton Kategori_Listeleyici = null;
	private JLabel jLabel = null;
	private static JTextField jTextField5 = null;
	private JLabel jLabel1 = null;
	private JTextField jTextField6 = null;
	private JButton jButton8 = null;
	private JButton jButton9 = null;
	private JLabel jLabel32 = null;
	private JButton Kategori_Listeleyici_2 = null;
	private JTextArea jTextArea7 = null;
	private JLabel jLabel19 = null;
	private static JTextField jTextField7 = null;
	private JButton jButton10 = null;
	private JLabel jLabel20 = null;
	private JTextField jTextField8 = null;
	private JButton jButton11 = null;
	private JLabel jLabel33 = null;
	private JButton �r�n_Bilgisi_Listeleyici = null;
	private static JTextArea jTextArea8 = null;
	private JTextArea ge�ici_metin_kutusu = null;
	private JTextField jTextField9 = null;
	private JLabel jLabel34 = null;
	private JButton jButton12 = null;
	private JTextArea jTextArea9 = null;
	private JLabel jLabel35 = null;
	private JTextField jTextField10 = null;
	private JLabel jLabel37 = null;
	private JTextField jTextField12 = null;
	private JButton jButton14 = null;
	private JLabel jLabel38 = null;
	private JTextField jTextField13 = null;
	private JButton jButton15 = null;
	private JLabel jLabel39 = null;
	private JTextField jTextField14 = null;
	private JButton jButton16 = null;
	private JLabel jLabel40 = null;
	private JButton jButton17 = null;
	private JTextField jTextField15 = null;
	private JTextArea jTextArea10 = null;
	private JLabel jLabel41 = null;
	private JLabel jLabel42 = null;
	private JTextArea jTextArea11 = null;
	private JLabel jLabel43 = null;
	private JTextArea jTextArea12 = null;
	private JLabel jLabel44 = null;
	private JTextArea jTextArea13 = null;
	private JButton jButton18 = null;
	private JLabel jLabel36 = null;
	private JTextArea jTextArea14 = null;
	private JLabel jLabel45 = null;

	/**
	 * This method initializes jTextField2
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(0, 32, 291, 20));
			jTextField2.setText("");
		}
		return jTextField2;
	}

	/**
	 * This method initializes jTextField3
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setBounds(new Rectangle(290, 32, 284, 20));
			jTextField3.setText("�lk �nce Arama Yapman�z Gerekmektedir.");
		}
		return jTextField3;
	}

	/**
	 * This method initializes jButton5
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.setBounds(new Rectangle(2, 51, 288, 18));
			jButton5.setText("Kategori Var M�?");
			jButton5.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					yan�t = kategori_var_m�(jTextField2.getText());
					jTextField3.setText(yan�t);
					System.out.println("mouseClicked()"); // TODO Auto-generated
					// Event stub
					// mouseClicked()
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jButton5;
	}

	/**
	 * This method initializes jButton6
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton6() {
		if (jButton6 == null) {
			jButton6 = new JButton();
			jButton6.setBounds(new Rectangle(290, 51, 282, 18));
			jButton6.setText("Ekleme Yapmak ��in T�klay�n�z");
			jTextField3.setText("�lk �nce Arama Yapman�z Gerekmektedir.");
			jButton6.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (jTextField3.getText().compareTo("Bulundu") != 0
							&& jTextField3.getText().compareTo(
									"�lk �nce Arama Yapman�z Gerekmektedir.") != 0) {
						jTextField3
								.setText("�lk �nce Arama Yapman�z Gerekmektedir.");
						kategori_ekle();
						jTextField2.setText("Ekleme Yap�ld�");
					}
					jTextArea4.setText("Yenileniyor L�tfen Bekleyiniz");
					System.out.println("mouseClicked()"); // TODO Auto-generated
					// Event stub
					// mouseClicked()
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jButton6;
	}

	public static void kategori_ekle() {
		int kategori_no = Kategori_veri_taban�.getKategoriler().size();
		String kategori_ad� = jTextField2.getText();
		Kategori kategori = new Kategori(kategori_no, kategori_ad�);
		getKategori_veri_taban�().add_kategori(kategori);
		getKategori_veri_taban�().update_file();
		System.out.println(Kategori_veri_taban�.getKategoriler().lastElement()
				.toString());
	}

	/**
	 * This method initializes jLabel30
	 * 
	 * @return javax.swing.JLabel
	 */
	private JLabel getJLabel30() {
		if (jLabel30 == null) {
			jLabel30 = new JLabel();
			jLabel30.setText("Kategori Listesi");
			jLabel30.setBounds(new Rectangle(2, 70, 166, 16));
		}
		return jLabel30;
	}

	/**
	 * This method initializes jTextArea4
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea4() {
		if (jTextArea4 == null) {
			jTextArea4 = new JTextArea();
			jTextArea4.setBounds(new Rectangle(4, 87, 569, 430));
			jTextArea4.setText("");
		}
		return jTextArea4;
	}

	/**
	 * This method initializes jTextField4
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField4() {
		if (jTextField4 == null) {
			jTextField4 = new JTextField();
			jTextField4.setBounds(new Rectangle(0, 32, 226, 20));
			jTextField4.setText("");
		}
		return jTextField4;
	}

	/**
	 * This method initializes jButton7
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton7() {
		if (jButton7 == null) {
			jButton7 = new JButton();
			jButton7.setBounds(new Rectangle(1, 52, 224, 20));
			jButton7.setText("Veri Taban�nda Ara");
			jButton7.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Hastal�k aranan;
					aranan = hash_table.getHash().get(jTextField4.getText());
					if(aranan==null){
						jTextField10.setText("Bulunamad�");
						yan�t="";
					}
					else{
						jTextField10.setText("Bulundu");
						yan�t=jTextField4.getText();
					}
					
					System.out.println("mouseClicked()"); // TODO Auto-generated
					// Event stub
					// mouseClicked()
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jButton7;
	}

	/**
	 * This method initializes Kategori_Listeleyici
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getKategori_Listeleyici() {
		if (Kategori_Listeleyici == null) {
			Kategori_Listeleyici = new JButton();
			Kategori_Listeleyici.setBounds(new Rectangle(166, 69, 152, 17));
			Kategori_Listeleyici.setText("Kategori Listeleyici");
			Kategori_Listeleyici
					.addMouseListener(new java.awt.event.MouseListener() {
						public void mouseClicked(java.awt.event.MouseEvent e) {
							jTextArea4.setText(Kategori_veri_taban�
									.getKategoriler().toString());
							System.out.println("mouseClicked()"); // TODO
							// Auto-generated
							// Event
							// stub
							// mouseClicked()
						}

						public void mousePressed(java.awt.event.MouseEvent e) {
						}

						public void mouseReleased(java.awt.event.MouseEvent e) {
						}

						public void mouseEntered(java.awt.event.MouseEvent e) {
						}

						public void mouseExited(java.awt.event.MouseEvent e) {
						}
					});
		}
		return Kategori_Listeleyici;
	}

	/**
	 * This method initializes jTextField5
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField5() {
		if (jTextField5 == null) {
			jTextField5 = new JTextField();
			jTextField5.setBounds(new Rectangle(0, 32, 251, 20));
			jTextField5.setText("");
		}
		return jTextField5;
	}

	/**
	 * This method initializes jTextField6
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField6() {
		if (jTextField6 == null) {
			jTextField6 = new JTextField();
			jTextField6.setBounds(new Rectangle(250, 32, 243, 20));
			jTextField6.setText("�lk �nce Arama Yapman�z Gerekmektedir.");
		}
		return jTextField6;
	}

	/**
	 * This method initializes jButton8
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton8() {
		if (jButton8 == null) {
			jButton8 = new JButton();
			jButton8.setBounds(new Rectangle(0, 52, 252, 20));
			jButton8.setText("Kategori Var M�?");
			jButton8.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					yan�t = kategori_var_m�(jTextField5.getText());
					jTextField6.setText(yan�t);
					System.out.println("mouseClicked()"); // TODO Auto-generated
					// Event stub
					// mouseClicked()
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jButton8;
	}

	/**
	 * This method initializes jButton9
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton9() {
		if (jButton9 == null) {
			jButton9 = new JButton();
			jButton9.setBounds(new Rectangle(252, 52, 241, 20));
			jButton9.setText("Kategoriyi Silmek ��in T�klay�n�z");
			jButton9.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (jTextField6.getText().compareTo("Bulundu") == 0) {
						jTextField6
								.setText("�lk �nce Arama Yapman�z Gerekmektedir.");
						kategori_sil();
						jTextField5.setText("Kategori Silindi");
					}
					jTextArea7.setText("Yenileniyor L�tfen Bekleyiniz");
					System.out.println("mouseClicked()"); // TODO Auto-generated
					// Event stub
					// mouseClicked()
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jButton9;
	}

	public static void kategori_sil() {
		getKategori_veri_taban�().kategoriyi_sil();
		getKategori_veri_taban�().update_file();
	}

	/**
	 * This method initializes Kategori_Listeleyici_2
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getKategori_Listeleyici_2() {
		if (Kategori_Listeleyici_2 == null) {
			Kategori_Listeleyici_2 = new JButton();
			Kategori_Listeleyici_2.setBounds(new Rectangle(109, 73, 143, 16));
			Kategori_Listeleyici_2.setText("Kategori Listeleyici");
			Kategori_Listeleyici_2
					.addMouseListener(new java.awt.event.MouseListener() {
						public void mouseClicked(java.awt.event.MouseEvent e) {
							jTextArea7.setText(Kategori_veri_taban�
									.getKategoriler().toString());
							System.out.println("mouseClicked()"); // TODO
							// Auto-generated
							// Event
							// stub
							// mouseClicked()
						}

						public void mousePressed(java.awt.event.MouseEvent e) {
						}

						public void mouseReleased(java.awt.event.MouseEvent e) {
						}

						public void mouseEntered(java.awt.event.MouseEvent e) {
						}

						public void mouseExited(java.awt.event.MouseEvent e) {
						}
					});
		}
		return Kategori_Listeleyici_2;
	}

	/**
	 * This method initializes jTextArea7
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea7() {
		if (jTextArea7 == null) {
			jTextArea7 = new JTextArea();
			jTextArea7.setBounds(new Rectangle(0, 90, 965, 429));
		}
		return jTextArea7;
	}

	/**
	 * This method initializes jTextField7
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField7() {
		if (jTextField7 == null) {
			jTextField7 = new JTextField();
			jTextField7.setBounds(new Rectangle(1, 32, 300, 20));
			jTextField7.setText("");
		}
		return jTextField7;
	}

	/**
	 * This method initializes jButton10
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton10() {
		if (jButton10 == null) {
			jButton10 = new JButton();
			jButton10.setBounds(new Rectangle(0, 51, 299, 21));
			jButton10.setText("�r�n Var M�?");
			jButton10.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					// �r�n� A�a�ta Ara
					yan�t = a�a�_kategorilerinde_ara(jTextField7.getText());
					if (yan�t.compareTo("Bulunamad�") != 0) {
						jTextField8.setText("Bulundu");
					} else {
						jTextField8.setText(yan�t);
					}
					System.out.println("mouseClicked()"); // TODO Auto-generated
					// Event stub
					// mouseClicked()
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jButton10;
	}

	public String a�a�_kategorilerinde_ara(String aranan_�r�n) {
		String aranan_bitki = "";
		aranan_bitki = a�a�_vekt�r�.find(jTextField7.getText());
		return aranan_bitki;
	}

	/**
	 * This method initializes jTextField8
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField8() {
		if (jTextField8 == null) {
			jTextField8 = new JTextField();
			jTextField8.setBounds(new Rectangle(299, 32, 301, 20));
			jTextField8.setText("�lk �nce Arama Yapman�z Gerekmektedir");
		}
		return jTextField8;
	}

	/**
	 * This method initializes jButton11
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton11() {
		if (jButton11 == null) {
			jButton11 = new JButton();
			jButton11.setBounds(new Rectangle(299, 51, 301, 20));
			jButton11.setText("�r�n� Silmek ��in T�klay�n�z");
			jButton11.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {

					if (jTextField8.getText().compareTo("Bulundu") == 0) {
						jTextArea8
								.setText("Veri Taban� Yenileniyor.L�tfen Bekleyiniz");
						a�a�_vekt�r�nden_kald�r();
						bitki_veri_taban�ndan_kald�r();
						jTextField8
								.setText("�lk �nce Arama Yapman�z Gerekmektedir");
						jTextField7.setText("Silindi");
						/*
						 * yan�t = " "; jTextArea8.setText(" ");// Silinen �r�n
						 * Bilgileri // Ekrandan // Siliniyor
						 */
					}

					System.out.println("mouseClicked()"); // TODO Auto-generated
					// Event stub
					// mouseClicked()
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jButton11;
	}

	public static void bitki_veri_taban�ndan_kald�r() {
		getBitki_veri_taban�().remove(jTextField7.getText());
		getBitki_veri_taban�().update_file();
	}

	public static void a�a�_vekt�r�nden_kald�r() {
		int �r�n�n_bulundu�u_kategorinin_nosu;
		�r�n�n_bulundu�u_kategorinin_nosu = a�a�_vekt�r�
				.getAranan_�r�n_hangi_kategoride_bulundu();
		boolean sonu� = a�a�_vekt�r�.getA�a�lar().elementAt(
				�r�n�n_bulundu�u_kategorinin_nosu)
				.remove(jTextField7.getText());
		if (sonu� == true) {
			jTextArea8.setText("a�a�_vekt�r�nden �r�n Silindi");
			System.out.println("a�a�_vekt�r�nden �r�n Silindi");
		} else {
			jTextArea8.setText("a�a�_vekt�r�nde �r�n Bulunamad�");
			System.out.println("a�a�_vekt�r�nde �r�n Bulunamad�");
		}
	}

	/**
	 * This method initializes �r�n_Bilgisi_Listeleyici
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton get�r�n_Bilgisi_Listeleyici() {
		if (�r�n_Bilgisi_Listeleyici == null) {
			�r�n_Bilgisi_Listeleyici = new JButton();
			�r�n_Bilgisi_Listeleyici.setBounds(new Rectangle(110, 73, 193, 15));
			�r�n_Bilgisi_Listeleyici.setText("�r�n Bilgisi Listeleyici");
			�r�n_Bilgisi_Listeleyici
					.addMouseListener(new java.awt.event.MouseListener() {
						public void mouseClicked(java.awt.event.MouseEvent e) {
							jTextArea8.setText(yan�t);
							System.out.println("Yan�t Listelendi"); // TODO
							// Auto-generated
							// Event
							// stub
							// mouseClicked()
						}

						public void mousePressed(java.awt.event.MouseEvent e) {
						}

						public void mouseReleased(java.awt.event.MouseEvent e) {
						}

						public void mouseEntered(java.awt.event.MouseEvent e) {
						}

						public void mouseExited(java.awt.event.MouseEvent e) {
						}
					});
		}
		return �r�n_Bilgisi_Listeleyici;
	}

	/**
	 * This method initializes jTextArea8
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea8() {
		if (jTextArea8 == null) {
			jTextArea8 = new JTextArea();
			jTextArea8.setBounds(new Rectangle(-2, 89, 970, 469));
		}
		return jTextArea8;
	}

	/**
	 * This method initializes ge�ici_metin_kutusu
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getGe�ici_metin_kutusu() {
		if (ge�ici_metin_kutusu == null) {
			ge�ici_metin_kutusu = new JTextArea();
			ge�ici_metin_kutusu.setBounds(new Rectangle(604, 58, 238, 150));
			ge�ici_metin_kutusu
					.setText("String ad�\n, String kategori\n, String latince_ad�\n, int miktar�\n,float fiyat�\n, String diskteki_yeri\n, String diskteki_ad�\n,Vector<String> �nerilen_hastal�klar\n, Vector<String> �zellikleri");
		}
		return ge�ici_metin_kutusu;
	}

	/**
	 * This method initializes jTextField9
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField9() {
		if (jTextField9 == null) {
			jTextField9 = new JTextField();
			jTextField9.setBounds(new Rectangle(0, 31, 262, 20));
			jTextField9.setText("");
		}
		return jTextField9;
	}

	/**
	 * This method initializes jButton12
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton12() {
		if (jButton12 == null) {
			jButton12 = new JButton();
			jButton12.setBounds(new Rectangle(0, 49, 262, 18));
			jButton12.setText("Aranan Hastal���n Bilgilerini Listele");
			jButton12.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					yan�t = hash_table.getHash().get(jTextField9.getText())
							.toString();

					if (yan�t != null) {
						jTextArea9.setText(yan�t);
						System.out
								.println("Aranan Hastal���n Bilgileri Listelendi"); // TODO
						// Auto-generated
						// Event
						// stub
						// mouseClicked()
					} else {
						jTextArea9.setText("Bulunamad�");
					}
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jButton12;
	}

	/**
	 * This method initializes jTextArea9
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea9() {
		if (jTextArea9 == null) {
			jTextArea9 = new JTextArea();
			jTextArea9.setBounds(new Rectangle(1, 67, 972, 494));
			jTextArea9.setText("");
		}
		return jTextArea9;
	}

	/**
	 * This method initializes jTextField10
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField10() {
		if (jTextField10 == null) {
			jTextField10 = new JTextField();
			jTextField10.setBounds(new Rectangle(223, 31, 244, 20));
			jTextField10.setText("");
		}
		return jTextField10;
	}

	/**
	 * This method initializes jTextField12
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField12() {
		if (jTextField12 == null) {
			jTextField12 = new JTextField();
			jTextField12.setBounds(new Rectangle(1, 89, 465, 20));
			jTextField12.setText("");
		}
		return jTextField12;
	}

	/**
	 * This method initializes jButton14
	 * 
	 * @return javax.swing.JButton
	 */
	public Vector<String> belirtiler = new Vector<String>(); // @jve:decl-index=0:
	public Vector<String> nedenler = new Vector<String>(); // @jve:decl-index=0:
	public Vector<String> tedaviler = new Vector<String>(); // @jve:decl-index=0:
	public Vector<String> bitkiler = new Vector<String>(); // @jve:decl-index=0:
	private JLabel jLabel46 = null;
	private JLabel jLabel47 = null;
	private JLabel jLabel48 = null;
	private JTextField jTextField11 = null;
	private JTextField jTextField16 = null;
	private JButton jButton13 = null;
	private JTextArea jTextArea15 = null;
	private JTextField jTextField17 = null;
	private JLabel jLabel49 = null;
	private JTextField jTextField18 = null;
	private JLabel jLabel27 = null;
	private JTextField jTextField19 = null;
	private JLabel jLabel50 = null;
	private JTextField jTextField20 = null;
	private JButton jButton19 = null;
	private JButton getJButton14() {
		if (jButton14 == null) {
			jButton14 = new JButton();
			jButton14.setBounds(new Rectangle(224, 67, 243, 22));
			jButton14.setText("Belirtiyi Eklemek i�in T�klay�n�z");
			jButton14.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (jTextField12.getText().compareTo("Eklendi") != 0)
						belirtiler.add(jTextField12.getText());
					String metin = "";
					for (int i = 0; i < belirtiler.size(); i++) {
						metin += belirtiler.elementAt(i);
					}
					jTextArea10.setText(metin);
					jTextField12.setText("Eklendi");
					System.out.println("mouseClicked()"); // TODO Auto-generated
					// Event stub
					// mouseClicked()
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jButton14;
	}

	/**
	 * This method initializes jTextField13
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField13() {
		if (jTextField13 == null) {
			jTextField13 = new JTextField();
			jTextField13.setBounds(new Rectangle(1, 125, 463, 20));
			jTextField13.setText("");
		}
		return jTextField13;
	}

	/**
	 * This method initializes jButton15
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton15() {
		if (jButton15 == null) {
			jButton15 = new JButton();
			jButton15.setBounds(new Rectangle(220, 108, 240, 19));
			jButton15.setText("Nedeni Eklemek ��in T�klay�n�z");
			jButton15.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (jTextField13.getText().compareTo("Eklendi") != 0) {
						nedenler.add(jTextField13.getText());
						String metin = "";
						for (int i = 0; i < nedenler.size(); i++) {
							metin += nedenler.elementAt(i);
						}
						jTextArea11.setText(metin);
						jTextField13.setText("Eklendi");
					}
					System.out.println("mouseClicked()"); // TODO Auto-generated
					// Event stub
					// mouseClicked()
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jButton15;
	}

	/**
	 * This method initializes jTextField14
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField14() {
		if (jTextField14 == null) {
			jTextField14 = new JTextField();
			jTextField14.setBounds(new Rectangle(0, 160, 465, 20));
			jTextField14.setText("");
		}
		return jTextField14;
	}

	/**
	 * This method initializes jButton16
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton16() {
		if (jButton16 == null) {
			jButton16 = new JButton();
			jButton16.setBounds(new Rectangle(220, 143, 240, 16));
			jButton16.setText("Tedavi Eklemek ��in T�klay�n�z");
			jButton16.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (jTextField14.getText().compareTo("Eklendi") != 0) {
						tedaviler.add(jTextField14.getText());
						String metin = "";
						for (int i = 0; i < tedaviler.size(); i++) {
							metin += tedaviler.elementAt(i);
						}
						jTextArea12.setText(metin);
						jTextField14.setText("Eklendi");
					}
					System.out.println("mouseClicked()"); // TODO Auto-generated
					// Event stub
					// mouseClicked()
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jButton16;
	}

	/**
	 * This method initializes jButton17
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton17() {
		if (jButton17 == null) {
			jButton17 = new JButton();
			jButton17.setBounds(new Rectangle(222, 180, 241, 14));
			jButton17.setText("Bitkiyi Eklemek ��in T�klay�n�z");
			jButton17.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (jTextField15.getText().compareTo("Eklendi") != 0) {
						bitkiler.add(jTextField15.getText());
						String metin = "";
						for (int i = 0; i < bitkiler.size(); i++) {
							metin += bitkiler.elementAt(i);
						}
						jTextArea13.setText(metin);
						jTextField15.setText("Eklendi");
					}
					System.out.println("mouseClicked()"); // TODO Auto-generated
					// Event stub
					// mouseClicked()
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jButton17;
	}

	/**
	 * This method initializes jTextField15
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField15() {
		if (jTextField15 == null) {
			jTextField15 = new JTextField();
			jTextField15.setBounds(new Rectangle(-1, 194, 464, 20));
			jTextField15.setText("");
		}
		return jTextField15;
	}

	/**
	 * This method initializes jTextArea10
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea10() {
		if (jTextArea10 == null) {
			jTextArea10 = new JTextArea();
			jTextArea10.setBounds(new Rectangle(472, 35, 500, 127));
		}
		return jTextArea10;
	}

	/**
	 * This method initializes jTextArea11
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea11() {
		if (jTextArea11 == null) {
			jTextArea11 = new JTextArea();
			jTextArea11.setBounds(new Rectangle(468, 180, 505, 135));
		}
		return jTextArea11;
	}

	/**
	 * This method initializes jTextArea12
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea12() {
		if (jTextArea12 == null) {
			jTextArea12 = new JTextArea();
			jTextArea12.setBounds(new Rectangle(0, 229, 463, 197));
		}
		return jTextArea12;
	}

	/**
	 * This method initializes jTextArea13
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea13() {
		if (jTextArea13 == null) {
			jTextArea13 = new JTextArea();
			jTextArea13.setBounds(new Rectangle(470, 330, 500, 225));
		}
		return jTextArea13;
	}

	/**
	 * This method initializes jButton18
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton18() {
		if (jButton18 == null) {
			jButton18 = new JButton();
			jButton18.setBounds(new Rectangle(223, 427, 241, 16));
			jButton18.setText("Bilgileri Kaydetmek �stiyorum");
			jButton18.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					/* belirtiler nedenler tedaviler bitkiler */
					if (jTextField10.getText().compareTo("Bulunamad�") == 0) {
						jTextArea14.setText("Veriler Kaydediliyor");
						Hastal�k yeni = new Hastal�k(jTextField4.getText(),
								belirtiler, nedenler, tedaviler, bitkiler);
						hash_table.getHash().put(jTextField4.getText(), yeni);
						Hastal�k_veri_taban�.getHastal�klar().add(yeni);
						hastal�k_veri_taban�.update_file();
						jTextArea14.setText("Veriler Kaydedildi");
					}
					System.out.println("mouseClicked()"); // TODO Auto-generated
					// Event stub
					// mouseClicked()
				}

				public void mousePressed(java.awt.event.MouseEvent e) {
				}

				public void mouseReleased(java.awt.event.MouseEvent e) {
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
				}

				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jButton18;
	}

	/**
	 * This method initializes jTextArea14
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea14() {
		if (jTextArea14 == null) {
			jTextArea14 = new JTextArea();
			jTextArea14.setBounds(new Rectangle(3, 474, 459, 80));
			jTextArea14.setText("");
		}
		return jTextArea14;
	}

	/**
	 * This method initializes jTextField11	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField11() {
		if (jTextField11 == null) {
			jTextField11 = new JTextField();
			jTextField11.setBounds(new Rectangle(166, 17, 165, 20));
			jTextField11.setText("0");
		}
		return jTextField11;
	}

	/**
	 * This method initializes jTextField16	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField16() {
		if (jTextField16 == null) {
			jTextField16 = new JTextField();
			jTextField16.setBounds(new Rectangle(494, 16, 167, 20));
			jTextField16.setText("0");
		}
		return jTextField16;
	}

	/**
	 * This method initializes jButton13	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton13() {
		if (jButton13 == null) {
			jButton13 = new JButton();
			jButton13.setBounds(new Rectangle(662, 17, 139, 18));
			jButton13.setText("�r�nleri Listele");
			jButton13.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					float min,max;
					min=Float.parseFloat(jTextField11.getText());
					max=Float.parseFloat(jTextField16.getText());
					if(min>=0&&max>=min){
						jTextArea15.setText(getBitki_veri_taban�().�r�nleri_listele(min,max));
					}else{
						jTextArea15.setText("Do�ru Aral�kta Say�lar Giriniz");
					}
					System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
				}
				public void mousePressed(java.awt.event.MouseEvent e) {
				}
				public void mouseReleased(java.awt.event.MouseEvent e) {
				}
				public void mouseEntered(java.awt.event.MouseEvent e) {
				}
				public void mouseExited(java.awt.event.MouseEvent e) {
				}
			});
		}
		return jButton13;
	}
	
	/**
	 * This method initializes jTextArea15	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea15() {
		if (jTextArea15 == null) {
			jTextArea15 = new JTextArea();
			jTextArea15.setBounds(new Rectangle(6, 40, 964, 518));
		}
		return jTextArea15;
	}

	/**
	 * This method initializes jTextField17	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField17() {
		if (jTextField17 == null) {
			jTextField17 = new JTextField();
			jTextField17.setBounds(new Rectangle(0, 33, 238, 20));
			jTextField17.setText("");
		}
		return jTextField17;
	}

	/**
	 * This method initializes jTextField18	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField18() {
		if (jTextField18 == null) {
			jTextField18 = new JTextField();
			jTextField18.setBounds(new Rectangle(238, 33, 320, 20));
			jTextField18.setText("�lk �nce Arama Yapman�z Gerekmektedir.");
		}
		return jTextField18;
	}

	/**
	 * This method initializes jTextField19	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField19() {
		if (jTextField19 == null) {
			jTextField19 = new JTextField();
			jTextField19.setBounds(new Rectangle(818, 19, 145, 20));
		}
		return jTextField19;
	}

	/**
	 * This method initializes jTextField20	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField20() {
		if (jTextField20 == null) {
			jTextField20 = new JTextField();
			jTextField20.setBounds(new Rectangle(820, 52, 143, 20));
		}
		return jTextField20;
	}

	/**
	 * This method initializes jButton19	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton19() {
		if (jButton19 == null) {
			jButton19 = new JButton();
			jButton19.setBounds(new Rectangle(3, 51, 235, 22));
			jButton19.setText("A�a� Vekt�r�nde Var M�?");
		}
		return jButton19;
	}

	// *************************MAIN********************************************************
	public static void main(String[] args) {
		veri_tabanlar�n�_olu�tur();
		veri_tabanlar�n�_veri_yap�lar�na_kopyala();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Herbalist_App application = new Herbalist_App();
				application.getHerbalist_Application().setVisible(true);
			}
		});
	}

	private static void veri_tabanlar�n�_veri_yap�lar�na_kopyala() {
		kategorilere_g�re_a�a�_vekt�r�n�_olu�tur();
		bitki_veri_taban�n�_a�a�_vekt�r�ne_kopyala();
		hastal�k_veri_taban�n�_hash_table_ye_kopyala();
	}

	private static void hastal�k_veri_taban�n�_hash_table_ye_kopyala() {
		hash_table = new Hash_Table(Hastal�k_veri_taban�.getHastal�klar());
	}

	private static void kategorilere_g�re_a�a�_vekt�r�n�_olu�tur() {
		setA�a�_vekt�r�(new Vector_A�a�(Kategori_veri_taban�.getKategoriler()
				.size() + 1));
		// Son vektor eleman� Kategorisiz olan bitkiler i�in
	}

	public static void veri_tabanlar�n�_olu�tur() {
		setKategori_veri_taban�(new Kategori_veri_taban�("kategori.txt"));
		setBitki_veri_taban�(new Bitki_veri_taban�("bitki.txt"));
		setHastal�k_veri_taban�(new Hastal�k_veri_taban�("hastal�k.txt"));
	}

	public static void bitki_veri_taban�n�_a�a�_vekt�r�ne_kopyala() {
		int aranan, endex;
		Node newnode;
		for (int i = 0; i < getBitki_veri_taban�().getBitkiler().size(); i++) {
			newnode = new Node(getBitki_veri_taban�().getBitkiler()
					.elementAt(i));
			aranan = newnode.getBitki().getKategori();
			endex = getKategori_veri_taban�().bitkinin_kategorisini_bul(aranan);
			getA�a�_vekt�r�().getA�a�lar().elementAt(endex).insert(newnode);
		}
	}

	/**
	 * This method initializes Herbalist_Application
	 * 
	 * @return javax.swing.JFrame
	 */
	private JFrame getHerbalist_Application() {
		if (Herbalist_Application == null) {
			Herbalist_Application = new JFrame();
			Herbalist_Application
					.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Herbalist_Application.setJMenuBar(getJJMenuBar());
			Herbalist_Application.setSize(1000, 700);
			Herbalist_Application.setContentPane(getMen�());
			Herbalist_Application.setTitle("Herbalist Application");
		}
		return Herbalist_Application;
	}

	/**
	 * This method initializes Men�
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getMen�() {
		if (Men� == null) {
			Men� = new JPanel();
			Men�.setLayout(null);
			Men�.add(getKullan�c�_Men�s�(), null);
		}
		return Men�;
	}

	/**
	 * This method initializes jJMenuBar
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getFileMenu());
			jJMenuBar.add(getEditMenu());
			jJMenuBar.add(getHelpMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("File");
			fileMenu.add(getSaveMenuItem());
			fileMenu.add(getExitMenuItem());
		}
		return fileMenu;
	}

	/**
	 * This method initializes jMenu
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getEditMenu() {
		if (editMenu == null) {
			editMenu = new JMenu();
			editMenu.setText("Edit");
			editMenu.add(getCutMenuItem());
			editMenu.add(getCopyMenuItem());
			editMenu.add(getPasteMenuItem());
		}
		return editMenu;
	}

	/**
	 * This method initializes jMenu
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getHelpMenu() {
		if (helpMenu == null) {
			helpMenu = new JMenu();
			helpMenu.setText("Help");
			helpMenu.add(getAboutMenuItem());
		}
		return helpMenu;
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText("Exit");
			exitMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitMenuItem;
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getAboutMenuItem() {
		if (aboutMenuItem == null) {
			aboutMenuItem = new JMenuItem();
			aboutMenuItem.setText("About");
			aboutMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog aboutDialog = getAboutDialog();
					aboutDialog.pack();
					Point loc = getHerbalist_Application().getLocation();
					loc.translate(20, 20);
					aboutDialog.setLocation(loc);
					aboutDialog.setVisible(true);
				}
			});
		}
		return aboutMenuItem;
	}

	/**
	 * This method initializes aboutDialog
	 * 
	 * @return javax.swing.JDialog
	 */
	private JDialog getAboutDialog() {
		if (aboutDialog == null) {
			aboutDialog = new JDialog(getHerbalist_Application(), true);
			aboutDialog.setTitle("About");
			aboutDialog.setContentPane(getAboutContentPane());
		}
		return aboutDialog;
	}

	/**
	 * This method initializes aboutContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAboutContentPane() {
		if (aboutContentPane == null) {
			aboutContentPane = new JPanel();
			aboutContentPane.setLayout(new BorderLayout());
			aboutContentPane.add(getAboutVersionLabel(), BorderLayout.CENTER);
		}
		return aboutContentPane;
	}

	/**
	 * This method initializes aboutVersionLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private JLabel getAboutVersionLabel() {
		if (aboutVersionLabel == null) {
			aboutVersionLabel = new JLabel();
			aboutVersionLabel.setText("Version 1.0");
			aboutVersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return aboutVersionLabel;
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getCutMenuItem() {
		if (cutMenuItem == null) {
			cutMenuItem = new JMenuItem();
			cutMenuItem.setText("Cut");
			cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
					Event.CTRL_MASK, true));
		}
		return cutMenuItem;
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getCopyMenuItem() {
		if (copyMenuItem == null) {
			copyMenuItem = new JMenuItem();
			copyMenuItem.setText("Copy");
			copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
					Event.CTRL_MASK, true));
		}
		return copyMenuItem;
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getPasteMenuItem() {
		if (pasteMenuItem == null) {
			pasteMenuItem = new JMenuItem();
			pasteMenuItem.setText("Paste");
			pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
					Event.CTRL_MASK, true));
		}
		return pasteMenuItem;
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getSaveMenuItem() {
		if (saveMenuItem == null) {
			saveMenuItem = new JMenuItem();
			saveMenuItem.setText("Save");
			saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
					Event.CTRL_MASK, true));
		}
		return saveMenuItem;
	}

	public static void setKategori_veri_taban�(
			Kategori_veri_taban� kategori_veri_taban�) {
		Herbalist_App.kategori_veri_taban� = kategori_veri_taban�;
	}

	public static Kategori_veri_taban� getKategori_veri_taban�() {
		return kategori_veri_taban�;
	}

	public static void setBitki_veri_taban�(Bitki_veri_taban� bitki_veri_taban�) {
		Herbalist_App.bitki_veri_taban� = bitki_veri_taban�;
	}

	public static Bitki_veri_taban� getBitki_veri_taban�() {
		return bitki_veri_taban�;
	}

	public static void setA�a�_vekt�r�(Vector_A�a� a�a�_vekt�r�) {
		Herbalist_App.a�a�_vekt�r� = a�a�_vekt�r�;
	}

	public static Vector_A�a� getA�a�_vekt�r�() {
		return a�a�_vekt�r�;
	}

	public static void setHash_table(Hash_Table hash_table) {
		Herbalist_App.hash_table = hash_table;
	}

	public static Hash_Table getHash_table() {
		return hash_table;
	}

	public static void setHastal�k_veri_taban�(
			Hastal�k_veri_taban� hastal�k_veri_taban�) {
		Herbalist_App.hastal�k_veri_taban� = hastal�k_veri_taban�;
	}

	public static Hastal�k_veri_taban� getHastal�k_veri_taban�() {
		return hastal�k_veri_taban�;
	}

}
