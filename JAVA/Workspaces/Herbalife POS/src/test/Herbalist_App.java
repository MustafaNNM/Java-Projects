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

import aðaç.Node;
import aðaçlar.Vector_Aðaç;

import veri_tabaný.Bitki_veri_tabaný;
import veri_tabaný.Hastalýk_veri_tabaný;
import veri_tabaný.Kategori_veri_tabaný;
import javax.swing.JScrollPane;

import dert.Hastalýk;
import deva.Kategori;

public class Herbalist_App {

	private JFrame Herbalist_Application = null; // @jve:decl-index=0:visual-constraint="10,0"
	private JPanel Menü = null;
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
	private JTabbedPane Kullanýcý_Menüsü = null;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JTabbedPane Müþteri_Menüsü = null;
	private JPanel jPanel2 = null;
	private JPanel Belirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi = null;
	private JPanel Verilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi = null;
	private JPanel Ürün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý = null;
	private JLabel Müþteri_Menüsü_Baþlýðý = null;
	private JLabel Personel_Menüsü_Baþlýðý = null;
	private JTabbedPane Personel_Menüsü = null;
	private JPanel jPanel6 = null;
	private JPanel Firmaya_Yeni_Türde_Ürün_Giriþi = null;
	private JPanel Adýndan_Ürün_Arama_ve_Silme = null;
	private JPanel Ürün_Bilgilerinde_Deðiþiklik = null;
	private JPanel Yeni_Hastalýk_Bilgisi_Giriþi = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JPanel Kategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma = null;
	private JPanel Kategori_Aðaçlarýný_Dengeleme = null;
	private JPanel Verilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan = null;
	private JPanel Belli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý = null;
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
	private JTabbedPane Kategori_Ekleme_ve_Silme_Menüsü = null;
	private JPanel Kategori_Ekleme = null;
	private JPanel Kategori_Silme = null;
	private JLabel jLabel13 = null;
	private JLabel jLabel14 = null;
	private JLabel jLabel15 = null;
	private JLabel jLabel16 = null;
	private JLabel jLabel17 = null;
	private JLabel jLabel18 = null;
	private JTextArea jTextArea = null;
	private JPanel Adýndan_Ürün_Arama_ve_Listeleme = null;
	private JPanel jPanel23 = null;
	private JLabel jLabel21 = null;
	private static JTextField jTextField = null;
	private JTextArea jTextArea1 = null;
	private JButton jButton = null;

	/**
	 * This method initializes Kullanýcý_Menüsü
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getKullanýcý_Menüsü() {
		if (Kullanýcý_Menüsü == null) {
			Kullanýcý_Menüsü = new JTabbedPane();
			Kullanýcý_Menüsü.setBounds(new Rectangle(0, 0, 985, 635));
			Kullanýcý_Menüsü.addTab(null, null, getJPanel(), null);
			Kullanýcý_Menüsü.addTab(null, null, getJPanel1(), null);
		}
		return Kullanýcý_Menüsü;
	}

	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			Müþteri_Menüsü_Baþlýðý = new JLabel();
			Müþteri_Menüsü_Baþlýðý.setBounds(new Rectangle(0, 0, 343, 16));
			Müþteri_Menüsü_Baþlýðý
					.setText("Müþterilerin Kulanabilecekleri Bölüm");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(getMüþteri_Menüsü(), null);
			jPanel.add(Müþteri_Menüsü_Baþlýðý, null);
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
			Personel_Menüsü_Baþlýðý = new JLabel();
			Personel_Menüsü_Baþlýðý.setBounds(new Rectangle(0, 0, 346, 16));
			Personel_Menüsü_Baþlýðý
					.setText("Sadece Firma Personelinin Kullanabileceði Bölüm");
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.add(Personel_Menüsü_Baþlýðý, null);
			jPanel1.add(getPersonel_Menüsü(), null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes Müþteri_Menüsü
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getMüþteri_Menüsü() {
		if (Müþteri_Menüsü == null) {
			Müþteri_Menüsü = new JTabbedPane();
			Müþteri_Menüsü.setBounds(new Rectangle(0, 16, 979, 589));
			Müþteri_Menüsü.addTab(null, null, getJPanel2(), null);
			Müþteri_Menüsü
					.addTab(
							null,
							null,
							getBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi(),
							null);
			Müþteri_Menüsü
					.addTab(
							null,
							null,
							getVerilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi(),
							null);
			Müþteri_Menüsü.addTab(null, null,
					getÜrün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý(),
					null);
			Müþteri_Menüsü
					.addTab(
							null,
							null,
							getKategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma(),
							null);
			Müþteri_Menüsü.addTab(null, null,
					getKategori_Aðaçlarýný_Dengeleme(), null);
			Müþteri_Menüsü
					.addTab(
							null,
							null,
							getVerilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan(),
							null);
			Müþteri_Menüsü
					.addTab(
							null,
							null,
							getBelli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý(),
							null);
		}
		return Müþteri_Menüsü;
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
			jLabel2.setText("Adýndan Ürün Arama ve Bilgilerini Listeleme");
			jPanel2 = new JPanel();
			jPanel2.setLayout(null);
			jPanel2.add(jLabel2, null);
			jPanel2.add(getAdýndan_Ürün_Arama_ve_Listeleme(), null);
		}
		return jPanel2;
	}

	/**
	 * This method initializes
	 * Belirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi() {
		if (Belirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi == null) {
			jLabel48 = new JLabel();
			jLabel48.setBounds(new Rectangle(330, 17, 166, 16));
			jLabel48.setText("Maxsimum Fiyatý Giriniz");
			jLabel47 = new JLabel();
			jLabel47.setBounds(new Rectangle(-2, 17, 168, 16));
			jLabel47.setText("Minimum Fiyatý Giriniz");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(0, 1, 495, 16));
			jLabel3
					.setText("Belirli Fiyatlar Arasýndaki Tüm Ürünlerin Bulunup Listelenmesi");
			Belirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi = new JPanel();
			Belirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi
					.setLayout(null);
			Belirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi.add(
					jLabel3, null);
			Belirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi.add(jLabel47, null);
			Belirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi.add(jLabel48, null);
			Belirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi.add(getJTextField11(), null);
			Belirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi.add(getJTextField16(), null);
			Belirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi.add(getJButton13(), null);
			Belirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi.add(getJTextArea15(), null);
		}
		return Belirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi;
	}

	/**
	 * ThismethodinitializesVerilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getVerilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi() {
		if (Verilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi == null) {
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(0, 2, 779, 16));
			jLabel4
					.setText("Verilen Bir Kelimenin Kategori Aðaçlarýnda Tutulan Bitkilerin Özellikleri Ýçinden Aratýlmasý,Bulunan Bitki Ýsimlerinin Listelenmesi");
			Verilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi = new JPanel();
			Verilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi
					.setLayout(null);
			Verilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi
					.add(jLabel4, null);
		}
		return Verilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi;
	}

	/**
	 * This method initializes
	 * Ürün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getÜrün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý() {
		if (Ürün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý == null) {
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(0, 2, 779, 16));
			jLabel5
					.setText("Ürün Sipariþi (Birden Çok Paket Ýstenebilir )ve Alýmý");
			Ürün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý = new JPanel();
			Ürün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý.setLayout(null);
			Ürün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý.add(jLabel5,
					null);
		}
		return Ürün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý;
	}

	/**
	 * This method initializes Personel_Menüsü
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getPersonel_Menüsü() {
		if (Personel_Menüsü == null) {
			Personel_Menüsü = new JTabbedPane();
			Personel_Menüsü.setBounds(new Rectangle(0, 16, 979, 590));
			Personel_Menüsü.addTab(null, null, getJPanel6(), null);
			Personel_Menüsü.addTab(null, null,
					getFirmaya_Yeni_Türde_Ürün_Giriþi(), null);
			Personel_Menüsü.addTab(null, null,
					getAdýndan_Ürün_Arama_ve_Silme(), null);
			Personel_Menüsü.addTab(null, null,
					getÜrün_Bilgilerinde_Deðiþiklik(), null);
			Personel_Menüsü.addTab(null, null,
					getYeni_Hastalýk_Bilgisi_Giriþi(), null);
		}
		return Personel_Menüsü;
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
			jPanel6.add(getKategori_Ekleme_ve_Silme_Menüsü(), null);
		}
		return jPanel6;
	}

	/**
	 * This method initializes Firmaya_Yeni_Türde_Ürün_Giriþi
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getFirmaya_Yeni_Türde_Ürün_Giriþi() {
		if (Firmaya_Yeni_Türde_Ürün_Giriþi == null) {
			jLabel49 = new JLabel();
			jLabel49.setBounds(new Rectangle(241, 16, 316, 16));
			jLabel49.setText("Eklenmek Ýstenen Ürün Aðaç Kategorilerinde Var Mý?");
			jLabel46 = new JLabel();
			jLabel46.setBounds(new Rectangle(1, 16, 241, 16));
			jLabel46.setText("Eklemek Ýstediðiniz Ürünün Adýný Giriniz");
			jLabel15 = new JLabel();
			jLabel15.setBounds(new Rectangle(0, 0, 778, 16));
			jLabel15.setText("Firmaya Yeni Türde Ürün Giriþi");
			Firmaya_Yeni_Türde_Ürün_Giriþi = new JPanel();
			Firmaya_Yeni_Türde_Ürün_Giriþi.setLayout(null);
			Firmaya_Yeni_Türde_Ürün_Giriþi.add(jLabel15, null);
			Firmaya_Yeni_Türde_Ürün_Giriþi.add(getGeçici_metin_kutusu(), null);
			Firmaya_Yeni_Türde_Ürün_Giriþi.add(jLabel46, null);
			Firmaya_Yeni_Türde_Ürün_Giriþi.add(getJTextField17(), null);
			Firmaya_Yeni_Türde_Ürün_Giriþi.add(jLabel49, null);
			Firmaya_Yeni_Türde_Ürün_Giriþi.add(getJTextField18(), null);
			Firmaya_Yeni_Türde_Ürün_Giriþi.add(getJButton19(), null);
		}
		return Firmaya_Yeni_Türde_Ürün_Giriþi;
	}

	/**
	 * This method initializes Adýndan_Ürün_Arama_ve_Silme
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAdýndan_Ürün_Arama_ve_Silme() {
		if (Adýndan_Ürün_Arama_ve_Silme == null) {
			jLabel33 = new JLabel();
			jLabel33.setBounds(new Rectangle(-1, 72, 112, 16));
			jLabel33.setText("Ürün Bilgisi");
			jLabel20 = new JLabel();
			jLabel20.setBounds(new Rectangle(300, 16, 300, 16));
			jLabel20.setText("Aranan Ürün Var Mý?");
			jLabel19 = new JLabel();
			jLabel19.setBounds(new Rectangle(0, 16, 300, 16));
			jLabel19.setText("Aranan Ürünün Adýný Giriniz");
			jLabel16 = new JLabel();
			jLabel16.setBounds(new Rectangle(0, 0, 778, 16));
			jLabel16.setText("Adýndan Ürün Bilgisi Arama ve Silme");
			Adýndan_Ürün_Arama_ve_Silme = new JPanel();
			Adýndan_Ürün_Arama_ve_Silme.setLayout(null);
			Adýndan_Ürün_Arama_ve_Silme.add(jLabel16, null);
			Adýndan_Ürün_Arama_ve_Silme.add(jLabel19, null);
			Adýndan_Ürün_Arama_ve_Silme.add(getJTextField7(), null);
			Adýndan_Ürün_Arama_ve_Silme.add(getJButton10(), null);
			Adýndan_Ürün_Arama_ve_Silme.add(jLabel20, null);
			Adýndan_Ürün_Arama_ve_Silme.add(getJTextField8(), null);
			Adýndan_Ürün_Arama_ve_Silme.add(getJButton11(), null);
			Adýndan_Ürün_Arama_ve_Silme.add(jLabel33, null);
			Adýndan_Ürün_Arama_ve_Silme
					.add(getÜrün_Bilgisi_Listeleyici(), null);
			Adýndan_Ürün_Arama_ve_Silme.add(getJTextArea8(), null);
		}
		return Adýndan_Ürün_Arama_ve_Silme;
	}

	/**
	 * This method initializes Ürün_Bilgilerinde_Deðiþiklik
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getÜrün_Bilgilerinde_Deðiþiklik() {
		if (Ürün_Bilgilerinde_Deðiþiklik == null) {
			jLabel17 = new JLabel();
			jLabel17.setBounds(new Rectangle(0, 0, 775, 16));
			jLabel17.setText("Ürün Bilgilerinde Deðiþiklik");
			Ürün_Bilgilerinde_Deðiþiklik = new JPanel();
			Ürün_Bilgilerinde_Deðiþiklik.setLayout(null);
			Ürün_Bilgilerinde_Deðiþiklik.add(jLabel17, null);
			Ürün_Bilgilerinde_Deðiþiklik.add(getJTextArea(), null);
		}
		return Ürün_Bilgilerinde_Deðiþiklik;
	}

	/**
	 * This method initializes Yeni_Hastalýk_Bilgisi_Giriþi
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getYeni_Hastalýk_Bilgisi_Giriþi() {
		if (Yeni_Hastalýk_Bilgisi_Giriþi == null) {
			jLabel45 = new JLabel();
			jLabel45.setBounds(new Rectangle(4, 448, 220, 23));
			jLabel45.setText("Kaydetme Bilgisi");
			jLabel36 = new JLabel();
			jLabel36.setBounds(new Rectangle(0, 427, 225, 16));
			jLabel36.setText("Bilgileri Kaydetmek Ýstiyor Musunuz?");
			jLabel44 = new JLabel();
			jLabel44.setBounds(new Rectangle(468, 313, 318, 16));
			jLabel44.setText("Tavsiye Edilen Bitkiler");
			jLabel43 = new JLabel();
			jLabel43.setBounds(new Rectangle(1, 213, 224, 16));
			jLabel43.setText("Tedavi Yöntemi");
			jLabel42 = new JLabel();
			jLabel42.setBounds(new Rectangle(470, 163, 314, 16));
			jLabel42.setText("Nedenler");
			jLabel41 = new JLabel();
			jLabel41.setBounds(new Rectangle(471, 17, 314, 16));
			jLabel41.setText("Belirtiler");
			jLabel40 = new JLabel();
			jLabel40.setBounds(new Rectangle(0, 179, 222, 16));
			jLabel40.setText("Önerilen Bitkileri Ekleme Yeri");
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
			jLabel35.setText("Hastalýk Veri Tabanýnda Var Mý?");
			jLabel31 = new JLabel();
			jLabel31.setBounds(new Rectangle(0, 16, 227, 16));
			jLabel31.setText("Hastalýk Adýný Giriniz");
			jLabel18 = new JLabel();
			jLabel18.setBounds(new Rectangle(0, 0, 780, 16));
			jLabel18.setText("Yeni Hastalýk Bilgisi Giriþi");
			Yeni_Hastalýk_Bilgisi_Giriþi = new JPanel();
			Yeni_Hastalýk_Bilgisi_Giriþi.setLayout(null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(jLabel18, null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(jLabel31, null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(getJTextField4(), null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(getJButton7(), null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(jLabel35, null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(getJTextField10(), null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(jLabel37, null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(getJTextField12(), null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(getJButton14(), null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(jLabel38, null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(getJTextField13(), null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(getJButton15(), null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(jLabel39, null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(getJTextField14(), null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(getJButton16(), null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(jLabel40, null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(getJButton17(), null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(getJTextField15(), null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(getJTextArea10(), null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(jLabel41, null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(jLabel42, null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(getJTextArea11(), null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(jLabel43, null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(getJTextArea12(), null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(jLabel44, null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(getJTextArea13(), null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(getJButton18(), null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(jLabel36, null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(getJTextArea14(), null);
			Yeni_Hastalýk_Bilgisi_Giriþi.add(jLabel45, null);
		}
		return Yeni_Hastalýk_Bilgisi_Giriþi;
	}

	/**
	 * This method initializes
	 * Kategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getKategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma() {
		if (Kategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma == null) {
			jLabel10 = new JLabel();
			jLabel10.setBounds(new Rectangle(0, 16, 783, 16));
			jLabel10
					.setText(" Ýlgili Aðacýn Derinliðini ve Eleman Sayýsýný Yazdýrma");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(1, 2, 778, 16));
			jLabel6
					.setText("Belirtilen Bir Kategorideki Tüm Ürünleri Düzeyleri Ýle Birlikte Listeleme(Inorder,Preorder,Postorder).");
			Kategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma = new JPanel();
			Kategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma
					.setLayout(null);
			Kategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma.add(
					jLabel6, null);
			Kategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma.add(
					jLabel10, null);
			Kategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma.add(
					getJTabbedPane3(), null);
		}
		return Kategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma;
	}

	/**
	 * This method initializes Kategori_Aðaçlarýný_Dengeleme
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getKategori_Aðaçlarýný_Dengeleme() {
		if (Kategori_Aðaçlarýný_Dengeleme == null) {
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(2, 1, 778, 16));
			jLabel7.setText("Kategori Aðaçlarýný Dengeleme");
			Kategori_Aðaçlarýný_Dengeleme = new JPanel();
			Kategori_Aðaçlarýný_Dengeleme.setLayout(null);
			Kategori_Aðaçlarýný_Dengeleme.add(jLabel7, null);
		}
		return Kategori_Aðaçlarýný_Dengeleme;
	}

	/**
	 * This method initializes
	 * Verilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getVerilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan() {
		if (Verilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan == null) {
			jLabel34 = new JLabel();
			jLabel34.setBounds(new Rectangle(0, 16, 260, 16));
			jLabel34.setText("Aranan Hastalýðýn Adýný Giriniz");
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(0, 0, 783, 16));
			jLabel8
					.setText("Verilen Bir Hastalýða Ýliþkin Bilgilerin Listelenmesi (Hash Table'dan)");
			Verilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan = new JPanel();
			Verilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan
					.setLayout(null);
			Verilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan
					.add(jLabel8, null);
			Verilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan
					.add(getJTextField9(), null);
			Verilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan
					.add(jLabel34, null);
			Verilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan
					.add(getJButton12(), null);
			Verilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan
					.add(getJTextArea9(), null);
		}
		return Verilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan;
	}

	/**
	 * ThismethodinitializesBelli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getBelli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý() {
		if (Belli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý == null) {
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(0, 16, 784, 16));
			jLabel11.setText("En Ucuz N Tanesinden 1'er Paket Satýn Alýnmasý");
			jLabel9 = new JLabel();
			jLabel9.setBounds(new Rectangle(0, 1, 780, 16));
			jLabel9
					.setText("Belli Bir Hastalýða Ýyi Gelebilen Bitkilerin Fiyatlarýna Göre Heap'e Atýlmasý");
			Belli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý = new JPanel();
			Belli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý
					.setLayout(null);
			Belli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý
					.add(jLabel9, null);
			Belli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý
					.add(jLabel11, null);
		}
		return Belli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý;
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
			jLabel50.setText("Eleman Sayýsý");
			jLabel27 = new JLabel();
			jLabel27.setBounds(new Rectangle(819, 3, 143, 16));
			jLabel27.setText("Aðacýn Derinliði");
			jLabel26 = new JLabel();
			jLabel26.setBounds(new Rectangle(405, 32, 410, 16));
			jLabel26.setText("Kategori Var Mý?");
			jLabel25 = new JLabel();
			jLabel25.setBounds(new Rectangle(0, 16, 777, 16));
			jLabel25
					.setText("Lütfen Listelemek Ýstediðiniz Kategoriyi Belirtiniz");
			jLabel61 = new JLabel();
			jLabel61.setBounds(new Rectangle(1, 1, 776, 16));
			jLabel61
					.setText("Belirtilen Bir Kategorideki Tüm Ürünleri Düzeyleri Ýle Birlikte Listeleme(Inorder,Preorder,Postorder).");
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
	 * This method initializes Kategori_Ekleme_ve_Silme_Menüsü
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getKategori_Ekleme_ve_Silme_Menüsü() {
		if (Kategori_Ekleme_ve_Silme_Menüsü == null) {
			Kategori_Ekleme_ve_Silme_Menüsü = new JTabbedPane();
			Kategori_Ekleme_ve_Silme_Menüsü.setBounds(new Rectangle(0, 16, 973,
					555));
			Kategori_Ekleme_ve_Silme_Menüsü.addTab(null, null,
					getKategori_Ekleme(), null);
			Kategori_Ekleme_ve_Silme_Menüsü.addTab(null, null,
					getKategori_Silme(), null);
		}
		return Kategori_Ekleme_ve_Silme_Menüsü;
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
			jLabel29.setText("Kategori Var Mý?");
			jLabel28 = new JLabel();
			jLabel28.setBounds(new Rectangle(0, 16, 291, 16));
			jLabel28
					.setText("Lütfen Eklemek Ýstediðiniz Kategori Ýsmini Giriniz");
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
			jLabel1.setText("Kategori Var Mý?");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(0, 16, 252, 16));
			jLabel.setText("Silmek Ýstediðiniz Kategorinin Adýný Giriniz");
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
					.setText("Bitkiye Ýliþkin Bilgiler:\nBitki Adý,\nKategori,\nBitkinin Latince Ýsmi,\nBitkinin Özellikleri,\nMiktarý,\nFiyatý,\nBitki Resminin Diskteki Yeri\nBitki Ýsminin Diskteki Adý,\nÖnerilen Hastalýklar\nVectore ekleme yapýlacak þekilde ayarlanmalý");
		}
		return jTextArea;
	}

	/**
	 * This method initializes Adýndan_Ürün_Arama_ve_Listeleme
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAdýndan_Ürün_Arama_ve_Listeleme() {
		if (Adýndan_Ürün_Arama_ve_Listeleme == null) {
			Adýndan_Ürün_Arama_ve_Listeleme = new JPanel();
			Adýndan_Ürün_Arama_ve_Listeleme.setLayout(null);
			Adýndan_Ürün_Arama_ve_Listeleme.setBounds(new Rectangle(0, 16, 971,
					550));
			Adýndan_Ürün_Arama_ve_Listeleme.add(getJPanel23(), null);
			Adýndan_Ürün_Arama_ve_Listeleme.add(getJTextArea1(), null);
		}
		return Adýndan_Ürün_Arama_ve_Listeleme;
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
			jLabel21.setText("Aranan Ürünün Adýný Giriniz:");
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

	private static String aranan_ürünün_bilgilerini_listele(String aranan_ürün) {
		String yanýt = "";

		for (int i = 0; i < getAðaç_vektörü().getAðaçlar().size(); i++) {
			yanýt = getAðaç_vektörü().getAðaçlar().elementAt(i).find(
					getAðaç_vektörü().getAðaçlar().elementAt(i).getNode(),
					aranan_ürün);
			if (yanýt.compareTo("Bulunamadý") != 0) {
				break;
			}
		}
		return yanýt;
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
			jButton.setText("Aranan Ürünün Bilgilerini Listele");
			jButton.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					jTextArea1
							.setText(aranan_ürünün_bilgilerini_listele(jTextField
									.getText()));
					System.out.println("Aranan Ürün Bilgileri Listelendi"); // TODO
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
	private static Kategori_veri_tabaný kategori_veri_tabaný;
	private static Bitki_veri_tabaný bitki_veri_tabaný;
	private static Vector_Aðaç aðaç_vektörü;
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

	public static String kategori_var_mý(String aranan) {
		String yanýt = getKategori_veri_tabaný().kategoriyi_araþtýr(aranan);
		return yanýt;
	}

	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	String yanýt = ""; // @jve:decl-index=0:
	private JTextArea jTextArea6 = null;
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(1, 50, 399, 21));
			jButton1.setText("Kategori Var Mý?");
			jButton1.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					yanýt = kategori_var_mý(jTextField1.getText());
					jTextArea5.setText(yanýt);
					if(yanýt.compareTo("Bulunamadý")!=0){
						int endex = getKategori_veri_tabaný()
						.getAranan_kategori_kaçýnçý_sýrada_bulundu();
				getAðaç_vektörü().getAðaçlar().elementAt(endex);
				jTextField20.setText(""+getAðaç_vektörü().getAðaçlar().elementAt(endex).node_sayýsý);
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
			jTextArea5.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
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
					jButton2.setText("Týklandý zaten...");
					if (jTextArea5.getText().compareTo(
							"Ýlk Önce Arama Yapmanýz Gerekmektedir.") != 0
							&& jTextArea5.getText().compareTo(
									"Böyle Bir Kategori Bulunmamaktadýr") != 0) {
						int endex = getKategori_veri_tabaný()
								.getAranan_kategori_kaçýnçý_sýrada_bulundu();
						getAðaç_vektörü().getAðaçlar().elementAt(endex)
								.setInorder(new Vector<String>());
						getAðaç_vektörü().getAðaçlar().elementAt(endex)
								.inOrder(
										getAðaç_vektörü().getAðaçlar()
												.elementAt(endex).getNode(), 0);
						jTextArea2.setText(getAðaç_vektörü().getAðaçlar()
								.elementAt(endex).inOrder_yazdýr());
						// jTextArea2.setText(getAðaç_vektörü().getAðaçlar().elementAt(endex).preOrder_yazdýr());
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
					jButton3.setText("Týklandý zaten...");
					if (jTextArea5.getText().compareTo(
							"Ýlk Önce Arama Yapmanýz Gerekmektedir.") != 0
							&& jTextArea5.getText().compareTo(
									"Böyle Bir Kategori Bulunmamaktadýr") != 0) {
						int endex = getKategori_veri_tabaný()
								.getAranan_kategori_kaçýnçý_sýrada_bulundu();
						getAðaç_vektörü().getAðaçlar().elementAt(endex)
								.setPreorder(new Vector<String>());
						getAðaç_vektörü().getAðaçlar().elementAt(endex)
								.preOrder(
										getAðaç_vektörü().getAðaçlar()
												.elementAt(endex).getNode(), 0);
						// jTextArea3.setText(getAðaç_vektörü().getAðaçlar().elementAt(endex).inOrder_yazdýr());
						jTextArea3.setText(getAðaç_vektörü().getAðaçlar()
								.elementAt(endex).preOrder_yazdýr());
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
					jButton4.setText("Týklandý zaten...");
					if (jTextArea5.getText().compareTo(
							"Ýlk Önce Arama Yapmanýz Gerekmektedir.") != 0
							&& jTextArea5.getText().compareTo(
									"Böyle Bir Kategori Bulunmamaktadýr") != 0) {

						int endex = getKategori_veri_tabaný()
								.getAranan_kategori_kaçýnçý_sýrada_bulundu();
						getAðaç_vektörü().getAðaçlar().elementAt(endex)
								.setPostorder(new Vector<String>());
						getAðaç_vektörü().getAðaçlar().elementAt(endex)
								.postOrder(
										getAðaç_vektörü().getAðaçlar()
												.elementAt(endex).getNode(), 0);
						// jTextArea6.setText(getAðaç_vektörü().getAðaçlar().elementAt(endex).postOrder_yazdýr());
						jTextArea6.setText(getAðaç_vektörü().getAðaçlar()
								.elementAt(endex).postOrder_yazdýr());
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
	private static Hastalýk_veri_tabaný hastalýk_veri_tabaný;
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
	private JButton Ürün_Bilgisi_Listeleyici = null;
	private static JTextArea jTextArea8 = null;
	private JTextArea geçici_metin_kutusu = null;
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
			jTextField3.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
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
			jButton5.setText("Kategori Var Mý?");
			jButton5.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					yanýt = kategori_var_mý(jTextField2.getText());
					jTextField3.setText(yanýt);
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
			jButton6.setText("Ekleme Yapmak Ýçin Týklayýnýz");
			jTextField3.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
			jButton6.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (jTextField3.getText().compareTo("Bulundu") != 0
							&& jTextField3.getText().compareTo(
									"Ýlk Önce Arama Yapmanýz Gerekmektedir.") != 0) {
						jTextField3
								.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
						kategori_ekle();
						jTextField2.setText("Ekleme Yapýldý");
					}
					jTextArea4.setText("Yenileniyor Lütfen Bekleyiniz");
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
		int kategori_no = Kategori_veri_tabaný.getKategoriler().size();
		String kategori_adý = jTextField2.getText();
		Kategori kategori = new Kategori(kategori_no, kategori_adý);
		getKategori_veri_tabaný().add_kategori(kategori);
		getKategori_veri_tabaný().update_file();
		System.out.println(Kategori_veri_tabaný.getKategoriler().lastElement()
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
			jButton7.setText("Veri Tabanýnda Ara");
			jButton7.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Hastalýk aranan;
					aranan = hash_table.getHash().get(jTextField4.getText());
					if(aranan==null){
						jTextField10.setText("Bulunamadý");
						yanýt="";
					}
					else{
						jTextField10.setText("Bulundu");
						yanýt=jTextField4.getText();
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
							jTextArea4.setText(Kategori_veri_tabaný
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
			jTextField6.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
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
			jButton8.setText("Kategori Var Mý?");
			jButton8.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					yanýt = kategori_var_mý(jTextField5.getText());
					jTextField6.setText(yanýt);
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
			jButton9.setText("Kategoriyi Silmek Ýçin Týklayýnýz");
			jButton9.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (jTextField6.getText().compareTo("Bulundu") == 0) {
						jTextField6
								.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
						kategori_sil();
						jTextField5.setText("Kategori Silindi");
					}
					jTextArea7.setText("Yenileniyor Lütfen Bekleyiniz");
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
		getKategori_veri_tabaný().kategoriyi_sil();
		getKategori_veri_tabaný().update_file();
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
							jTextArea7.setText(Kategori_veri_tabaný
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
			jButton10.setText("Ürün Var Mý?");
			jButton10.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					// Ürünü Aðaçta Ara
					yanýt = aðaç_kategorilerinde_ara(jTextField7.getText());
					if (yanýt.compareTo("Bulunamadý") != 0) {
						jTextField8.setText("Bulundu");
					} else {
						jTextField8.setText(yanýt);
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

	public String aðaç_kategorilerinde_ara(String aranan_ürün) {
		String aranan_bitki = "";
		aranan_bitki = aðaç_vektörü.find(jTextField7.getText());
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
			jTextField8.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir");
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
			jButton11.setText("Ürünü Silmek Ýçin Týklayýnýz");
			jButton11.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {

					if (jTextField8.getText().compareTo("Bulundu") == 0) {
						jTextArea8
								.setText("Veri Tabaný Yenileniyor.Lütfen Bekleyiniz");
						aðaç_vektöründen_kaldýr();
						bitki_veri_tabanýndan_kaldýr();
						jTextField8
								.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir");
						jTextField7.setText("Silindi");
						/*
						 * yanýt = " "; jTextArea8.setText(" ");// Silinen Ürün
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

	public static void bitki_veri_tabanýndan_kaldýr() {
		getBitki_veri_tabaný().remove(jTextField7.getText());
		getBitki_veri_tabaný().update_file();
	}

	public static void aðaç_vektöründen_kaldýr() {
		int ürünün_bulunduðu_kategorinin_nosu;
		ürünün_bulunduðu_kategorinin_nosu = aðaç_vektörü
				.getAranan_ürün_hangi_kategoride_bulundu();
		boolean sonuç = aðaç_vektörü.getAðaçlar().elementAt(
				ürünün_bulunduðu_kategorinin_nosu)
				.remove(jTextField7.getText());
		if (sonuç == true) {
			jTextArea8.setText("aðaç_vektöründen Ürün Silindi");
			System.out.println("aðaç_vektöründen Ürün Silindi");
		} else {
			jTextArea8.setText("aðaç_vektöründe Ürün Bulunamadý");
			System.out.println("aðaç_vektöründe Ürün Bulunamadý");
		}
	}

	/**
	 * This method initializes Ürün_Bilgisi_Listeleyici
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getÜrün_Bilgisi_Listeleyici() {
		if (Ürün_Bilgisi_Listeleyici == null) {
			Ürün_Bilgisi_Listeleyici = new JButton();
			Ürün_Bilgisi_Listeleyici.setBounds(new Rectangle(110, 73, 193, 15));
			Ürün_Bilgisi_Listeleyici.setText("Ürün Bilgisi Listeleyici");
			Ürün_Bilgisi_Listeleyici
					.addMouseListener(new java.awt.event.MouseListener() {
						public void mouseClicked(java.awt.event.MouseEvent e) {
							jTextArea8.setText(yanýt);
							System.out.println("Yanýt Listelendi"); // TODO
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
		return Ürün_Bilgisi_Listeleyici;
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
	 * This method initializes geçici_metin_kutusu
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getGeçici_metin_kutusu() {
		if (geçici_metin_kutusu == null) {
			geçici_metin_kutusu = new JTextArea();
			geçici_metin_kutusu.setBounds(new Rectangle(604, 58, 238, 150));
			geçici_metin_kutusu
					.setText("String adý\n, String kategori\n, String latince_adý\n, int miktarý\n,float fiyatý\n, String diskteki_yeri\n, String diskteki_adý\n,Vector<String> önerilen_hastalýklar\n, Vector<String> özellikleri");
		}
		return geçici_metin_kutusu;
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
			jButton12.setText("Aranan Hastalýðýn Bilgilerini Listele");
			jButton12.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					yanýt = hash_table.getHash().get(jTextField9.getText())
							.toString();

					if (yanýt != null) {
						jTextArea9.setText(yanýt);
						System.out
								.println("Aranan Hastalýðýn Bilgileri Listelendi"); // TODO
						// Auto-generated
						// Event
						// stub
						// mouseClicked()
					} else {
						jTextArea9.setText("Bulunamadý");
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
			jButton14.setText("Belirtiyi Eklemek için Týklayýnýz");
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
			jButton15.setText("Nedeni Eklemek Ýçin Týklayýnýz");
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
			jButton16.setText("Tedavi Eklemek Ýçin Týklayýnýz");
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
			jButton17.setText("Bitkiyi Eklemek Ýçin Týklayýnýz");
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
			jButton18.setText("Bilgileri Kaydetmek Ýstiyorum");
			jButton18.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					/* belirtiler nedenler tedaviler bitkiler */
					if (jTextField10.getText().compareTo("Bulunamadý") == 0) {
						jTextArea14.setText("Veriler Kaydediliyor");
						Hastalýk yeni = new Hastalýk(jTextField4.getText(),
								belirtiler, nedenler, tedaviler, bitkiler);
						hash_table.getHash().put(jTextField4.getText(), yeni);
						Hastalýk_veri_tabaný.getHastalýklar().add(yeni);
						hastalýk_veri_tabaný.update_file();
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
			jButton13.setText("Ürünleri Listele");
			jButton13.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					float min,max;
					min=Float.parseFloat(jTextField11.getText());
					max=Float.parseFloat(jTextField16.getText());
					if(min>=0&&max>=min){
						jTextArea15.setText(getBitki_veri_tabaný().ürünleri_listele(min,max));
					}else{
						jTextArea15.setText("Doðru Aralýkta Sayýlar Giriniz");
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
			jTextField18.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
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
			jButton19.setText("Aðaç Vektöründe Var Mý?");
		}
		return jButton19;
	}

	// *************************MAIN********************************************************
	public static void main(String[] args) {
		veri_tabanlarýný_oluþtur();
		veri_tabanlarýný_veri_yapýlarýna_kopyala();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Herbalist_App application = new Herbalist_App();
				application.getHerbalist_Application().setVisible(true);
			}
		});
	}

	private static void veri_tabanlarýný_veri_yapýlarýna_kopyala() {
		kategorilere_göre_aðaç_vektörünü_oluþtur();
		bitki_veri_tabanýný_aðaç_vektörüne_kopyala();
		hastalýk_veri_tabanýný_hash_table_ye_kopyala();
	}

	private static void hastalýk_veri_tabanýný_hash_table_ye_kopyala() {
		hash_table = new Hash_Table(Hastalýk_veri_tabaný.getHastalýklar());
	}

	private static void kategorilere_göre_aðaç_vektörünü_oluþtur() {
		setAðaç_vektörü(new Vector_Aðaç(Kategori_veri_tabaný.getKategoriler()
				.size() + 1));
		// Son vektor elemaný Kategorisiz olan bitkiler için
	}

	public static void veri_tabanlarýný_oluþtur() {
		setKategori_veri_tabaný(new Kategori_veri_tabaný("kategori.txt"));
		setBitki_veri_tabaný(new Bitki_veri_tabaný("bitki.txt"));
		setHastalýk_veri_tabaný(new Hastalýk_veri_tabaný("hastalýk.txt"));
	}

	public static void bitki_veri_tabanýný_aðaç_vektörüne_kopyala() {
		int aranan, endex;
		Node newnode;
		for (int i = 0; i < getBitki_veri_tabaný().getBitkiler().size(); i++) {
			newnode = new Node(getBitki_veri_tabaný().getBitkiler()
					.elementAt(i));
			aranan = newnode.getBitki().getKategori();
			endex = getKategori_veri_tabaný().bitkinin_kategorisini_bul(aranan);
			getAðaç_vektörü().getAðaçlar().elementAt(endex).insert(newnode);
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
			Herbalist_Application.setContentPane(getMenü());
			Herbalist_Application.setTitle("Herbalist Application");
		}
		return Herbalist_Application;
	}

	/**
	 * This method initializes Menü
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getMenü() {
		if (Menü == null) {
			Menü = new JPanel();
			Menü.setLayout(null);
			Menü.add(getKullanýcý_Menüsü(), null);
		}
		return Menü;
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

	public static void setKategori_veri_tabaný(
			Kategori_veri_tabaný kategori_veri_tabaný) {
		Herbalist_App.kategori_veri_tabaný = kategori_veri_tabaný;
	}

	public static Kategori_veri_tabaný getKategori_veri_tabaný() {
		return kategori_veri_tabaný;
	}

	public static void setBitki_veri_tabaný(Bitki_veri_tabaný bitki_veri_tabaný) {
		Herbalist_App.bitki_veri_tabaný = bitki_veri_tabaný;
	}

	public static Bitki_veri_tabaný getBitki_veri_tabaný() {
		return bitki_veri_tabaný;
	}

	public static void setAðaç_vektörü(Vector_Aðaç aðaç_vektörü) {
		Herbalist_App.aðaç_vektörü = aðaç_vektörü;
	}

	public static Vector_Aðaç getAðaç_vektörü() {
		return aðaç_vektörü;
	}

	public static void setHash_table(Hash_Table hash_table) {
		Herbalist_App.hash_table = hash_table;
	}

	public static Hash_Table getHash_table() {
		return hash_table;
	}

	public static void setHastalýk_veri_tabaný(
			Hastalýk_veri_tabaný hastalýk_veri_tabaný) {
		Herbalist_App.hastalýk_veri_tabaný = hastalýk_veri_tabaný;
	}

	public static Hastalýk_veri_tabaný getHastalýk_veri_tabaný() {
		return hastalýk_veri_tabaný;
	}

}
