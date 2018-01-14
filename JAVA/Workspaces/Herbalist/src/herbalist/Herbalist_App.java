package herbalist;

import hash_table.Hash_Table;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Event;
import java.awt.BorderLayout;

import javax.swing.SwingConstants;
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

	private JTabbedPane getKullanýcý_Menüsü() {
		if (herbalist_app_data.getKullanýcý_Menüsü() == null) {
			herbalist_app_data.setKullanýcý_Menüsü(new JTabbedPane());
			herbalist_app_data.getKullanýcý_Menüsü().setBounds(new Rectangle(0, 0, 985, 635));
			herbalist_app_data.getKullanýcý_Menüsü().addTab(null, null, getJPanel(), null);
			herbalist_app_data.getKullanýcý_Menüsü().addTab(null, null, getJPanel1(), null);
		}
		return herbalist_app_data.getKullanýcý_Menüsü();
	}

	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (herbalist_app_data.getjPanel() == null) {
			herbalist_app_data.setMüþteri_Menüsü_Baþlýðý(new JLabel());
			herbalist_app_data.getMüþteri_Menüsü_Baþlýðý().setBounds(new Rectangle(0, 0, 343, 16));
			herbalist_app_data.getMüþteri_Menüsü_Baþlýðý()
					.setText("Müþterilerin Kulanabilecekleri Bölüm");
			herbalist_app_data.setjPanel(new JPanel());
			herbalist_app_data.getjPanel().setLayout(null);
			herbalist_app_data.getjPanel().add(getMüþteri_Menüsü(), null);
			herbalist_app_data.getjPanel().add(herbalist_app_data.getMüþteri_Menüsü_Baþlýðý(), null);
		}
		return herbalist_app_data.getjPanel();
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel1() {
		if (herbalist_app_data.getjPanel1() == null) {
			herbalist_app_data.setPersonel_Menüsü_Baþlýðý(new JLabel());
			herbalist_app_data.getPersonel_Menüsü_Baþlýðý().setBounds(new Rectangle(0, 0, 346, 16));
			herbalist_app_data.getPersonel_Menüsü_Baþlýðý()
					.setText("Sadece Firma Personelinin Kullanabileceði Bölüm");
			herbalist_app_data.setjPanel1(new JPanel());
			herbalist_app_data.getjPanel1().setLayout(null);
			herbalist_app_data.getjPanel1().add(herbalist_app_data.getPersonel_Menüsü_Baþlýðý(), null);
			herbalist_app_data.getjPanel1().add(getPersonel_Menüsü(), null);
		}
		return herbalist_app_data.getjPanel1();
	}

	/**
	 * This method initializes Müþteri_Menüsü
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getMüþteri_Menüsü() {
		if (herbalist_app_data.getMüþteri_Menüsü() == null) {
			herbalist_app_data.setMüþteri_Menüsü(new JTabbedPane());
			herbalist_app_data.getMüþteri_Menüsü().setBounds(new Rectangle(0, 16, 979, 589));
			herbalist_app_data.getMüþteri_Menüsü().addTab(null, null, getJPanel2(), null);
			herbalist_app_data.getMüþteri_Menüsü()
					.addTab(
							null,
							null,
							getBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi(),
							null);
			herbalist_app_data.getMüþteri_Menüsü()
					.addTab(
							null,
							null,
							getVerilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi(),
							null);
			herbalist_app_data.getMüþteri_Menüsü().addTab(null, null,
					getÜrün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý(),
					null);
			herbalist_app_data.getMüþteri_Menüsü()
					.addTab(
							null,
							null,
							getKategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma(),
							null);
			herbalist_app_data.getMüþteri_Menüsü().addTab(null, null,
					getKategori_Aðaçlarýný_Dengeleme(), null);
			herbalist_app_data.getMüþteri_Menüsü()
					.addTab(
							null,
							null,
							getVerilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan(),
							null);
			herbalist_app_data.getMüþteri_Menüsü()
					.addTab(
							null,
							null,
							getBelli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý(),
							null);
		}
		return herbalist_app_data.getMüþteri_Menüsü();
	}

	/**
	 * This method initializes jPanel2
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel2() {
		if (herbalist_app_data.getjPanel2() == null) {
			herbalist_app_data.setjLabel2(new JLabel());
			herbalist_app_data.getjLabel2().setBounds(new Rectangle(0, 0, 974, 16));
			herbalist_app_data.getjLabel2().setText("Adýndan Ürün Arama ve Bilgilerini Listeleme");
			herbalist_app_data.setjPanel2(new JPanel());
			herbalist_app_data.getjPanel2().setLayout(null);
			herbalist_app_data.getjPanel2().add(herbalist_app_data.getjLabel2(), null);
			herbalist_app_data.getjPanel2().add(getAdýndan_Ürün_Arama_ve_Listeleme(), null);
		}
		return herbalist_app_data.getjPanel2();
	}

	/**
	 * This method initializes
	 * Belirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi() {
		if (herbalist_app_data
				.getBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi() == null) {
			herbalist_app_data.setjLabel48(new JLabel());
			herbalist_app_data.getjLabel48().setBounds(new Rectangle(330, 17, 166, 16));
			herbalist_app_data.getjLabel48().setText("Maxsimum Fiyatý Giriniz");
			herbalist_app_data.setjLabel47(new JLabel());
			herbalist_app_data.getjLabel47().setBounds(new Rectangle(-2, 17, 168, 16));
			herbalist_app_data.getjLabel47().setText("Minimum Fiyatý Giriniz");
			herbalist_app_data.setjLabel3(new JLabel());
			herbalist_app_data.getjLabel3().setBounds(new Rectangle(0, 1, 495, 16));
			herbalist_app_data.getjLabel3()
					.setText("Belirli Fiyatlar Arasýndaki Tüm Ürünlerin Bulunup Listelenmesi");
			herbalist_app_data
					.setBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi(new JPanel());
			herbalist_app_data
					.getBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi()
					.setLayout(null);
			herbalist_app_data
					.getBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi().add(
					herbalist_app_data.getjLabel3(), null);
			herbalist_app_data
					.getBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi().add(herbalist_app_data.getjLabel47(), null);
			herbalist_app_data
					.getBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi().add(herbalist_app_data.getjLabel48(), null);
			herbalist_app_data
					.getBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi().add(getJTextField11(), null);
			herbalist_app_data
					.getBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi().add(getJTextField16(), null);
			herbalist_app_data
					.getBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi().add(getJButton13(), null);
			herbalist_app_data
					.getBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi().add(getJTextArea15(), null);
		}
		return herbalist_app_data
				.getBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi();
	}

	/**
	 * ThismethodinitializesVerilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getVerilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi() {
		if (herbalist_app_data
				.getVerilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi() == null) {
			herbalist_app_data.setjLabel4(new JLabel());
			herbalist_app_data.getjLabel4().setBounds(new Rectangle(0, 2, 779, 16));
			herbalist_app_data.getjLabel4()
					.setText("Verilen Bir Kelimenin Kategori Aðaçlarýnda Tutulan Bitkilerin Özellikleri Ýçinden Aratýlmasý,Bulunan Bitki Ýsimlerinin Listelenmesi");
			herbalist_app_data
					.setVerilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi(new JPanel());
			herbalist_app_data
					.getVerilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi()
					.setLayout(null);
			herbalist_app_data
					.getVerilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi()
					.add(herbalist_app_data.getjLabel4(), null);
		}
		return herbalist_app_data
				.getVerilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi();
	}

	/**
	 * This method initializes
	 * Ürün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getÜrün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý() {
		if (herbalist_app_data
				.getÜrün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý() == null) {
			herbalist_app_data.setjLabel5(new JLabel());
			herbalist_app_data.getjLabel5().setBounds(new Rectangle(0, 2, 779, 16));
			herbalist_app_data.getjLabel5()
					.setText("Ürün Sipariþi (Birden Çok Paket Ýstenebilir )ve Alýmý");
			herbalist_app_data
					.setÜrün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý(new JPanel());
			herbalist_app_data
					.getÜrün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý().setLayout(null);
			herbalist_app_data
					.getÜrün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý().add(herbalist_app_data.getjLabel5(),
					null);
		}
		return herbalist_app_data
				.getÜrün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý();
	}

	/**
	 * This method initializes Personel_Menüsü
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getPersonel_Menüsü() {
		if (herbalist_app_data.getPersonel_Menüsü() == null) {
			herbalist_app_data.setPersonel_Menüsü(new JTabbedPane());
			herbalist_app_data.getPersonel_Menüsü().setBounds(new Rectangle(0, 16, 979, 590));
			herbalist_app_data.getPersonel_Menüsü().addTab(null, null, Kategori_Ekleme_ve_Kategori_Silme(), null);
			herbalist_app_data.getPersonel_Menüsü().addTab(null, null,
					getFirmaya_Yeni_Türde_Ürün_Giriþi(), null);
			herbalist_app_data.getPersonel_Menüsü().addTab(null, null,
					getAdýndan_Ürün_Arama_ve_Silme(), null);
			herbalist_app_data.getPersonel_Menüsü().addTab(null, null,
					getÜrün_Bilgilerinde_Deðiþiklik(), null);
			herbalist_app_data.getPersonel_Menüsü().addTab(null, null,
					getYeni_Hastalýk_Bilgisi_Giriþi(), null);
		}
		return herbalist_app_data.getPersonel_Menüsü();
	}

	/**
	 * This method initializes jPanel6
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel Kategori_Ekleme_ve_Kategori_Silme() {
		if (herbalist_app_data.getjPanel6() == null) {
			herbalist_app_data.setjLabel12(new JLabel());
			herbalist_app_data.getjLabel12().setBounds(new Rectangle(0, 0, 779, 16));
			herbalist_app_data.getjLabel12().setText("Kategori Ekleme ve Kategori Silme");
			herbalist_app_data.setjPanel6(new JPanel());
			herbalist_app_data.getjPanel6().setLayout(null);
			herbalist_app_data.getjPanel6().add(herbalist_app_data.getjLabel12(), null);
			herbalist_app_data.getjPanel6().add(getKategori_Ekleme_ve_Silme_Menüsü(), null);
		}
		return herbalist_app_data.getjPanel6();
	}

	/**
	 * This method initializes Firmaya_Yeni_Türde_Ürün_Giriþi
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getFirmaya_Yeni_Türde_Ürün_Giriþi() {
		if (herbalist_app_data.getFirmaya_Yeni_Türde_Ürün_Giriþi() == null) {
			herbalist_app_data.setjLabel49(new JLabel());
			herbalist_app_data.getjLabel49().setBounds(new Rectangle(241, 16, 316, 16));
			herbalist_app_data.getjLabel49().setText("Eklenmek Ýstenen Ürün Aðaç Kategorilerinde Var Mý?");
			herbalist_app_data.setjLabel46(new JLabel());
			herbalist_app_data.getjLabel46().setBounds(new Rectangle(1, 16, 241, 16));
			herbalist_app_data.getjLabel46().setText("Eklemek Ýstediðiniz Ürünün Adýný Giriniz");
			herbalist_app_data.setjLabel15(new JLabel());
			herbalist_app_data.getjLabel15().setBounds(new Rectangle(0, 0, 778, 16));
			herbalist_app_data.getjLabel15().setText("Firmaya Yeni Türde Ürün Giriþi");
			herbalist_app_data.setFirmaya_Yeni_Türde_Ürün_Giriþi(new JPanel());
			herbalist_app_data.getFirmaya_Yeni_Türde_Ürün_Giriþi().setLayout(null);
			herbalist_app_data.getFirmaya_Yeni_Türde_Ürün_Giriþi().add(herbalist_app_data.getjLabel15(), null);
			herbalist_app_data.getFirmaya_Yeni_Türde_Ürün_Giriþi().add(getGeçici_metin_kutusu(), null);
			herbalist_app_data.getFirmaya_Yeni_Türde_Ürün_Giriþi().add(herbalist_app_data.getjLabel46(), null);
			herbalist_app_data.getFirmaya_Yeni_Türde_Ürün_Giriþi().add(getJTextField17(), null);
			herbalist_app_data.getFirmaya_Yeni_Türde_Ürün_Giriþi().add(herbalist_app_data.getjLabel49(), null);
			herbalist_app_data.getFirmaya_Yeni_Türde_Ürün_Giriþi().add(getJTextField18(), null);
			herbalist_app_data.getFirmaya_Yeni_Türde_Ürün_Giriþi().add(getJButton19(), null);
		}
		return herbalist_app_data.getFirmaya_Yeni_Türde_Ürün_Giriþi();
	}

	/**
	 * This method initializes Adýndan_Ürün_Arama_ve_Silme
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAdýndan_Ürün_Arama_ve_Silme() {
		if (herbalist_app_data.getAdýndan_Ürün_Arama_ve_Silme() == null) {
			herbalist_app_data.setjLabel33(new JLabel());
			herbalist_app_data.getjLabel33().setBounds(new Rectangle(-1, 72, 112, 16));
			herbalist_app_data.getjLabel33().setText("Ürün Bilgisi");
			herbalist_app_data.setjLabel20(new JLabel());
			herbalist_app_data.getjLabel20().setBounds(new Rectangle(300, 16, 300, 16));
			herbalist_app_data.getjLabel20().setText("Aranan Ürün Var Mý?");
			herbalist_app_data.setjLabel19(new JLabel());
			herbalist_app_data.getjLabel19().setBounds(new Rectangle(0, 16, 300, 16));
			herbalist_app_data.getjLabel19().setText("Aranan Ürünün Adýný Giriniz");
			herbalist_app_data.setjLabel16(new JLabel());
			herbalist_app_data.getjLabel16().setBounds(new Rectangle(0, 0, 778, 16));
			herbalist_app_data.getjLabel16().setText("Adýndan Ürün Bilgisi Arama ve Silme");
			herbalist_app_data.setAdýndan_Ürün_Arama_ve_Silme(new JPanel());
			herbalist_app_data.getAdýndan_Ürün_Arama_ve_Silme().setLayout(null);
			herbalist_app_data.getAdýndan_Ürün_Arama_ve_Silme().add(herbalist_app_data.getjLabel16(), null);
			herbalist_app_data.getAdýndan_Ürün_Arama_ve_Silme().add(herbalist_app_data.getjLabel19(), null);
			herbalist_app_data.getAdýndan_Ürün_Arama_ve_Silme().add(getJTextField7(), null);
			herbalist_app_data.getAdýndan_Ürün_Arama_ve_Silme().add(getJButton10(), null);
			herbalist_app_data.getAdýndan_Ürün_Arama_ve_Silme().add(herbalist_app_data.getjLabel20(), null);
			herbalist_app_data.getAdýndan_Ürün_Arama_ve_Silme().add(getJTextField8(), null);
			herbalist_app_data.getAdýndan_Ürün_Arama_ve_Silme().add(getJButton11(), null);
			herbalist_app_data.getAdýndan_Ürün_Arama_ve_Silme().add(herbalist_app_data.getjLabel33(), null);
			herbalist_app_data.getAdýndan_Ürün_Arama_ve_Silme()
					.add(getÜrün_Bilgisi_Listeleyici(), null);
			herbalist_app_data.getAdýndan_Ürün_Arama_ve_Silme().add(getJTextArea8(), null);
		}
		return herbalist_app_data.getAdýndan_Ürün_Arama_ve_Silme();
	}

	/**
	 * This method initializes Ürün_Bilgilerinde_Deðiþiklik
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getÜrün_Bilgilerinde_Deðiþiklik() {
		if (herbalist_app_data.getÜrün_Bilgilerinde_Deðiþiklik() == null) {
			herbalist_app_data.setjLabel17(new JLabel());
			herbalist_app_data.getjLabel17().setBounds(new Rectangle(0, 0, 775, 16));
			herbalist_app_data.getjLabel17().setText("Ürün Bilgilerinde Deðiþiklik");
			herbalist_app_data.setÜrün_Bilgilerinde_Deðiþiklik(new JPanel());
			herbalist_app_data.getÜrün_Bilgilerinde_Deðiþiklik().setLayout(null);
			herbalist_app_data.getÜrün_Bilgilerinde_Deðiþiklik().add(herbalist_app_data.getjLabel17(), null);
			herbalist_app_data.getÜrün_Bilgilerinde_Deðiþiklik().add(getJTextArea(), null);
		}
		return herbalist_app_data.getÜrün_Bilgilerinde_Deðiþiklik();
	}

	/**
	 * This method initializes Yeni_Hastalýk_Bilgisi_Giriþi
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getYeni_Hastalýk_Bilgisi_Giriþi() {
		if (herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi() == null) {
			herbalist_app_data.setjLabel45(new JLabel());
			herbalist_app_data.getjLabel45().setBounds(new Rectangle(4, 448, 220, 23));
			herbalist_app_data.getjLabel45().setText("Kaydetme Bilgisi");
			herbalist_app_data.setjLabel36(new JLabel());
			herbalist_app_data.getjLabel36().setBounds(new Rectangle(0, 427, 225, 16));
			herbalist_app_data.getjLabel36().setText("Bilgileri Kaydetmek Ýstiyor Musunuz?");
			herbalist_app_data.setjLabel44(new JLabel());
			herbalist_app_data.getjLabel44().setBounds(new Rectangle(468, 313, 318, 16));
			herbalist_app_data.getjLabel44().setText("Tavsiye Edilen Bitkiler");
			herbalist_app_data.setjLabel43(new JLabel());
			herbalist_app_data.getjLabel43().setBounds(new Rectangle(1, 213, 224, 16));
			herbalist_app_data.getjLabel43().setText("Tedavi Yöntemi");
			herbalist_app_data.setjLabel42(new JLabel());
			herbalist_app_data.getjLabel42().setBounds(new Rectangle(470, 163, 314, 16));
			herbalist_app_data.getjLabel42().setText("Nedenler");
			herbalist_app_data.setjLabel41(new JLabel());
			herbalist_app_data.getjLabel41().setBounds(new Rectangle(471, 17, 314, 16));
			herbalist_app_data.getjLabel41().setText("Belirtiler");
			herbalist_app_data.setjLabel40(new JLabel());
			herbalist_app_data.getjLabel40().setBounds(new Rectangle(0, 179, 222, 16));
			herbalist_app_data.getjLabel40().setText("Önerilen Bitkileri Ekleme Yeri");
			herbalist_app_data.setjLabel39(new JLabel());
			herbalist_app_data.getjLabel39().setBounds(new Rectangle(-1, 144, 222, 16));
			herbalist_app_data.getjLabel39().setText("Tedavileri Ekleme Yeri");
			herbalist_app_data.setjLabel38(new JLabel());
			herbalist_app_data.getjLabel38().setBounds(new Rectangle(1, 109, 220, 16));
			herbalist_app_data.getjLabel38().setText("Nedenleri Ekleme Yeri");
			herbalist_app_data.setjLabel37(new JLabel());
			herbalist_app_data.getjLabel37().setBounds(new Rectangle(1, 72, 222, 16));
			herbalist_app_data.getjLabel37().setText("Belirtileri Ekleme Yeri");
			herbalist_app_data.setjLabel35(new JLabel());
			herbalist_app_data.getjLabel35().setBounds(new Rectangle(226, 15, 240, 16));
			herbalist_app_data.getjLabel35().setText("Hastalýk Veri Tabanýnda Var Mý?");
			herbalist_app_data.setjLabel31(new JLabel());
			herbalist_app_data.getjLabel31().setBounds(new Rectangle(0, 16, 227, 16));
			herbalist_app_data.getjLabel31().setText("Hastalýk Adýný Giriniz");
			herbalist_app_data.setjLabel18(new JLabel());
			herbalist_app_data.getjLabel18().setBounds(new Rectangle(0, 0, 780, 16));
			herbalist_app_data.getjLabel18().setText("Yeni Hastalýk Bilgisi Giriþi");
			herbalist_app_data.setYeni_Hastalýk_Bilgisi_Giriþi(new JPanel());
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().setLayout(null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(herbalist_app_data.getjLabel18(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(herbalist_app_data.getjLabel31(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(getJTextField4(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(getJButton7(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(herbalist_app_data.getjLabel35(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(getJTextField10(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(herbalist_app_data.getjLabel37(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(getJTextField12(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(getJButton14(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(herbalist_app_data.getjLabel38(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(getJTextField13(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(getJButton15(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(herbalist_app_data.getjLabel39(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(getJTextField14(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(getJButton16(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(herbalist_app_data.getjLabel40(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(getJButton17(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(getJTextField15(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(getJTextArea10(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(herbalist_app_data.getjLabel41(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(herbalist_app_data.getjLabel42(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(getJTextArea11(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(herbalist_app_data.getjLabel43(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(getJTextArea12(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(herbalist_app_data.getjLabel44(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(getJTextArea13(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(getJButton18(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(herbalist_app_data.getjLabel36(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(getJTextArea14(), null);
			herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi().add(herbalist_app_data.getjLabel45(), null);
		}
		return herbalist_app_data.getYeni_Hastalýk_Bilgisi_Giriþi();
	}

	/**
	 * This method initializes
	 * Kategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getKategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma() {
		if (herbalist_app_data
				.getKategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma() == null) {
			herbalist_app_data.setjLabel10(new JLabel());
			herbalist_app_data.getjLabel10().setBounds(new Rectangle(0, 16, 783, 16));
			herbalist_app_data.getjLabel10()
					.setText(" Ýlgili Aðacýn Derinliðini ve Eleman Sayýsýný Yazdýrma");
			herbalist_app_data.setjLabel6(new JLabel());
			herbalist_app_data.getjLabel6().setBounds(new Rectangle(1, 2, 778, 16));
			herbalist_app_data.getjLabel6()
					.setText("Belirtilen Bir Kategorideki Tüm Ürünleri Düzeyleri Ýle Birlikte Listeleme(Inorder,Preorder,Postorder).");
			herbalist_app_data
					.setKategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma(new JPanel());
			herbalist_app_data
					.getKategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma()
					.setLayout(null);
			herbalist_app_data
					.getKategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma().add(
					herbalist_app_data.getjLabel6(), null);
			herbalist_app_data
					.getKategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma().add(
					herbalist_app_data.getjLabel10(), null);
			herbalist_app_data
					.getKategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma().add(
					getJTabbedPane3(), null);
		}
		return herbalist_app_data
				.getKategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma();
	}

	/**
	 * This method initializes Kategori_Aðaçlarýný_Dengeleme
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getKategori_Aðaçlarýný_Dengeleme() {
		if (herbalist_app_data.getKategori_Aðaçlarýný_Dengeleme() == null) {
			herbalist_app_data.setjLabel7(new JLabel());
			herbalist_app_data.getjLabel7().setBounds(new Rectangle(2, 1, 778, 16));
			herbalist_app_data.getjLabel7().setText("Kategori Aðaçlarýný Dengeleme");
			herbalist_app_data.setKategori_Aðaçlarýný_Dengeleme(new JPanel());
			herbalist_app_data.getKategori_Aðaçlarýný_Dengeleme().setLayout(null);
			herbalist_app_data.getKategori_Aðaçlarýný_Dengeleme().add(herbalist_app_data.getjLabel7(), null);
		}
		return herbalist_app_data.getKategori_Aðaçlarýný_Dengeleme();
	}

	/**
	 * This method initializes
	 * Verilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getVerilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan() {
		if (herbalist_app_data
				.getVerilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan() == null) {
			herbalist_app_data.setjLabel34(new JLabel());
			herbalist_app_data.getjLabel34().setBounds(new Rectangle(0, 16, 260, 16));
			herbalist_app_data.getjLabel34().setText("Aranan Hastalýðýn Adýný Giriniz");
			herbalist_app_data.setjLabel8(new JLabel());
			herbalist_app_data.getjLabel8().setBounds(new Rectangle(0, 0, 783, 16));
			herbalist_app_data.getjLabel8()
					.setText("Verilen Bir Hastalýða Ýliþkin Bilgilerin Listelenmesi (Hash Table'dan)");
			herbalist_app_data
					.setVerilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan(new JPanel());
			herbalist_app_data
					.getVerilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan()
					.setLayout(null);
			herbalist_app_data
					.getVerilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan()
					.add(herbalist_app_data.getjLabel8(), null);
			herbalist_app_data
					.getVerilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan()
					.add(getJTextField9(), null);
			herbalist_app_data
					.getVerilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan()
					.add(herbalist_app_data.getjLabel34(), null);
			herbalist_app_data
					.getVerilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan()
					.add(getJButton12(), null);
			herbalist_app_data
					.getVerilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan()
					.add(getJTextArea9(), null);
		}
		return herbalist_app_data
				.getVerilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan();
	}

	/**
	 * ThismethodinitializesBelli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getBelli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý() {
		if (herbalist_app_data
				.getBelli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý() == null) {
			herbalist_app_data.setjLabel11(new JLabel());
			herbalist_app_data.getjLabel11().setBounds(new Rectangle(0, 16, 784, 16));
			herbalist_app_data.getjLabel11().setText("En Ucuz N Tanesinden 1'er Paket Satýn Alýnmasý");
			herbalist_app_data.setjLabel9(new JLabel());
			herbalist_app_data.getjLabel9().setBounds(new Rectangle(0, 1, 780, 16));
			herbalist_app_data.getjLabel9()
					.setText("Belli Bir Hastalýða Ýyi Gelebilen Bitkilerin Fiyatlarýna Göre Heap'e Atýlmasý");
			herbalist_app_data
					.setBelli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý(new JPanel());
			herbalist_app_data
					.getBelli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý()
					.setLayout(null);
			herbalist_app_data
					.getBelli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý()
					.add(herbalist_app_data.getjLabel9(), null);
			herbalist_app_data
					.getBelli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý()
					.add(herbalist_app_data.getjLabel11(), null);
		}
		return herbalist_app_data
				.getBelli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý();
	}

	/**
	 * This method initializes jTabbedPane3
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getJTabbedPane3() {
		if (herbalist_app_data.getjTabbedPane3() == null) {
			herbalist_app_data.setjTabbedPane3(new JTabbedPane());
			herbalist_app_data.getjTabbedPane3().setBounds(new Rectangle(-1, 31, 972, 531));
			herbalist_app_data.getjTabbedPane3().addTab(null, null, getJPanel16(), null);
		}
		return herbalist_app_data.getjTabbedPane3();
	}

	/**
	 * This method initializes jPanel16
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel16() {
		if (herbalist_app_data.getjPanel16() == null) {
			herbalist_app_data.setjLabel50(new JLabel());
			herbalist_app_data.getjLabel50().setBounds(new Rectangle(819, 37, 144, 16));
			herbalist_app_data.getjLabel50().setText("Eleman Sayýsý");
			herbalist_app_data.setjLabel27(new JLabel());
			herbalist_app_data.getjLabel27().setBounds(new Rectangle(819, 3, 143, 16));
			herbalist_app_data.getjLabel27().setText("Aðacýn Derinliði");
			herbalist_app_data.setjLabel26(new JLabel());
			herbalist_app_data.getjLabel26().setBounds(new Rectangle(405, 32, 410, 16));
			herbalist_app_data.getjLabel26().setText("Kategori Var Mý?");
			herbalist_app_data.setjLabel25(new JLabel());
			herbalist_app_data.getjLabel25().setBounds(new Rectangle(0, 16, 777, 16));
			herbalist_app_data.getjLabel25()
					.setText("Lütfen Listelemek Ýstediðiniz Kategoriyi Belirtiniz");
			herbalist_app_data.setjLabel61(new JLabel());
			herbalist_app_data.getjLabel61().setBounds(new Rectangle(1, 1, 776, 16));
			herbalist_app_data.getjLabel61()
					.setText("Belirtilen Bir Kategorideki Tüm Ürünleri Düzeyleri Ýle Birlikte Listeleme(Inorder,Preorder,Postorder).");
			herbalist_app_data.setjPanel16(new JPanel());
			herbalist_app_data.getjPanel16().setLayout(null);
			herbalist_app_data.getjPanel16().add(herbalist_app_data.getjLabel61(), null);
			herbalist_app_data.getjPanel16().add(getJTabbedPane6(), null);
			herbalist_app_data.getjPanel16().add(herbalist_app_data.getjLabel25(), null);
			herbalist_app_data.getjPanel16().add(getJTextField1(), null);
			herbalist_app_data.getjPanel16().add(getJButton1(), null);
			herbalist_app_data.getjPanel16().add(getJTextArea5(), null);
			herbalist_app_data.getjPanel16().add(herbalist_app_data.getjLabel26(), null);
			herbalist_app_data.getjPanel16().add(herbalist_app_data.getjLabel27(), null);
			herbalist_app_data.getjPanel16().add(getJTextField19(), null);
			herbalist_app_data.getjPanel16().add(herbalist_app_data.getjLabel50(), null);
			herbalist_app_data.getjPanel16().add(getJTextField20(), null);
		}
		return herbalist_app_data.getjPanel16();
	}

	/**
	 * This method initializes Kategori_Ekleme_ve_Silme_Menüsü
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getKategori_Ekleme_ve_Silme_Menüsü() {
		if (herbalist_app_data.getKategori_Ekleme_ve_Silme_Menüsü() == null) {
			herbalist_app_data
					.setKategori_Ekleme_ve_Silme_Menüsü(new JTabbedPane());
			herbalist_app_data.getKategori_Ekleme_ve_Silme_Menüsü().setBounds(new Rectangle(0, 16, 973,
					555));
			herbalist_app_data.getKategori_Ekleme_ve_Silme_Menüsü().addTab(null, null,
					getKategori_Ekleme(), null);
			herbalist_app_data.getKategori_Ekleme_ve_Silme_Menüsü().addTab(null, null,
					getKategori_Silme(), null);
		}
		return herbalist_app_data.getKategori_Ekleme_ve_Silme_Menüsü();
	}

	/**
	 * This method initializes Kategori_Ekleme
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getKategori_Ekleme() {
		if (herbalist_app_data.getKategori_Ekleme() == null) {
			herbalist_app_data.setjLabel29(new JLabel());
			herbalist_app_data.getjLabel29().setBounds(new Rectangle(290, 16, 283, 16));
			herbalist_app_data.getjLabel29().setText("Kategori Var Mý?");
			herbalist_app_data.setjLabel28(new JLabel());
			herbalist_app_data.getjLabel28().setBounds(new Rectangle(0, 16, 291, 16));
			herbalist_app_data.getjLabel28()
					.setText("Lütfen Eklemek Ýstediðiniz Kategori Ýsmini Giriniz");
			herbalist_app_data.setjLabel13(new JLabel());
			herbalist_app_data.getjLabel13().setBounds(new Rectangle(0, 0, 771, 16));
			herbalist_app_data.getjLabel13().setText("Kategori Ekleme");
			herbalist_app_data.setKategori_Ekleme(new JPanel());
			herbalist_app_data.getKategori_Ekleme().setLayout(null);
			herbalist_app_data.getKategori_Ekleme().add(herbalist_app_data.getjLabel13(), null);
			herbalist_app_data.getKategori_Ekleme().add(herbalist_app_data.getjLabel28(), null);
			herbalist_app_data.getKategori_Ekleme().add(getJTextField2(), null);
			herbalist_app_data.getKategori_Ekleme().add(herbalist_app_data.getjLabel29(), null);
			herbalist_app_data.getKategori_Ekleme().add(getJTextField3(), null);
			herbalist_app_data.getKategori_Ekleme().add(getJButton5(), null);
			herbalist_app_data.getKategori_Ekleme().add(getJButton6(), null);
			herbalist_app_data.getKategori_Ekleme().add(getJLabel30(), null);
			herbalist_app_data.getKategori_Ekleme().add(getJTextArea4(), null);
			herbalist_app_data.getKategori_Ekleme().add(getKategori_Listeleyici(), null);
		}
		return herbalist_app_data.getKategori_Ekleme();
	}

	/**
	 * This method initializes Kategori_Silme
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getKategori_Silme() {
		if (herbalist_app_data.getKategori_Silme() == null) {
			herbalist_app_data.setjLabel32(new JLabel());
			herbalist_app_data.getjLabel32().setBounds(new Rectangle(0, 72, 111, 16));
			herbalist_app_data.getjLabel32().setText("Kategori Listesi");
			herbalist_app_data.setjLabel1(new JLabel());
			herbalist_app_data.getjLabel1().setBounds(new Rectangle(252, 16, 240, 16));
			herbalist_app_data.getjLabel1().setText("Kategori Var Mý?");
			herbalist_app_data.setjLabel(new JLabel());
			herbalist_app_data.getjLabel().setBounds(new Rectangle(0, 16, 252, 16));
			herbalist_app_data.getjLabel().setText("Silmek Ýstediðiniz Kategorinin Adýný Giriniz");
			herbalist_app_data.setjLabel14(new JLabel());
			herbalist_app_data.getjLabel14().setBounds(new Rectangle(0, 0, 771, 16));
			herbalist_app_data.getjLabel14().setText("Kategori Silme");
			herbalist_app_data.setKategori_Silme(new JPanel());
			herbalist_app_data.getKategori_Silme().setLayout(null);
			herbalist_app_data.getKategori_Silme().add(herbalist_app_data.getjLabel14(), null);
			herbalist_app_data.getKategori_Silme().add(herbalist_app_data.getjLabel(), null);
			herbalist_app_data.getKategori_Silme().add(getJTextField5(), null);
			herbalist_app_data.getKategori_Silme().add(herbalist_app_data.getjLabel1(), null);
			herbalist_app_data.getKategori_Silme().add(getJTextField6(), null);
			herbalist_app_data.getKategori_Silme().add(getJButton8(), null);
			herbalist_app_data.getKategori_Silme().add(getJButton9(), null);
			herbalist_app_data.getKategori_Silme().add(herbalist_app_data.getjLabel32(), null);
			herbalist_app_data.getKategori_Silme().add(getKategori_Listeleyici_2(), null);
			herbalist_app_data.getKategori_Silme().add(getJTextArea7(), null);
		}
		return herbalist_app_data.getKategori_Silme();
	}

	/**
	 * This method initializes jTextArea
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea() {
		if (herbalist_app_data.getjTextArea() == null) {
			herbalist_app_data.setjTextArea(new JTextArea());
			herbalist_app_data.getjTextArea().setBounds(new Rectangle(0, 16, 776, 181));
			herbalist_app_data.getjTextArea()
					.setText("Bitkiye Ýliþkin Bilgiler:\nBitki Adý,\nKategori,\nBitkinin Latince Ýsmi,\nBitkinin Özellikleri,\nMiktarý,\nFiyatý,\nBitki Resminin Diskteki Yeri\nBitki Ýsminin Diskteki Adý,\nÖnerilen Hastalýklar\nVectore ekleme yapýlacak þekilde ayarlanmalý");
		}
		return herbalist_app_data.getjTextArea();
	}

	/**
	 * This method initializes Adýndan_Ürün_Arama_ve_Listeleme
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAdýndan_Ürün_Arama_ve_Listeleme() {
		if (herbalist_app_data.getAdýndan_Ürün_Arama_ve_Listeleme() == null) {
			herbalist_app_data
					.setAdýndan_Ürün_Arama_ve_Listeleme(new JPanel());
			herbalist_app_data.getAdýndan_Ürün_Arama_ve_Listeleme().setLayout(null);
			herbalist_app_data.getAdýndan_Ürün_Arama_ve_Listeleme().setBounds(new Rectangle(0, 16, 971,
					550));
			herbalist_app_data.getAdýndan_Ürün_Arama_ve_Listeleme().add(getJPanel23(), null);
			herbalist_app_data.getAdýndan_Ürün_Arama_ve_Listeleme().add(getJTextArea1(), null);
		}
		return herbalist_app_data.getAdýndan_Ürün_Arama_ve_Listeleme();
	}

	/**
	 * This method initializes jPanel23
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel23() {
		if (herbalist_app_data.getjPanel23() == null) {
			herbalist_app_data.setjLabel21(new JLabel());
			herbalist_app_data.getjLabel21().setBounds(new Rectangle(0, 0, 249, 16));
			herbalist_app_data.getjLabel21().setText("Aranan Ürünün Adýný Giriniz:");
			herbalist_app_data.setjPanel23(new JPanel());
			herbalist_app_data.getjPanel23().setLayout(null);
			herbalist_app_data.getjPanel23().setBounds(new Rectangle(0, 0, 251, 64));
			herbalist_app_data.getjPanel23().add(herbalist_app_data.getjLabel21(), null);
			herbalist_app_data.getjPanel23().add(getJTextField(), null);
			herbalist_app_data.getjPanel23().add(getJButton(), null);
		}
		return herbalist_app_data.getjPanel23();
	}

	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField() {
		if (Herbalist_AppJTextFieldData.getjTextField() == null) {
			Herbalist_AppJTextFieldData.setjTextField(new JTextField());
			Herbalist_AppJTextFieldData.getjTextField().setBounds(new Rectangle(0, 16, 249, 16));
			Herbalist_AppJTextFieldData.getjTextField().setText("");
		}
		return Herbalist_AppJTextFieldData.getjTextField();
	}

	/**
	 * This method initializes jTextArea1
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea1() {
		if (herbalist_app_data.getjTextArea1() == null) {
			herbalist_app_data.setjTextArea1(new JTextArea());
			herbalist_app_data.getjTextArea1().setBounds(new Rectangle(0, 65, 965, 450));
			herbalist_app_data.getjTextArea1().setText("");
		}
		return herbalist_app_data.getjTextArea1();
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
		if (herbalist_app_data.getjButton() == null) {
			herbalist_app_data.setjButton(new JButton());
			herbalist_app_data.getjButton().setBounds(new Rectangle(2, 31, 246, 33));
			herbalist_app_data.getjButton().setText("Aranan Ürünün Bilgilerini Listele");
			herbalist_app_data.getjButton().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					herbalist_app_data.getjTextArea1()
							.setText(aranan_ürünün_bilgilerini_listele(Herbalist_AppJTextFieldData.getjTextField()
									.getText()));
					System.out.println("Aranan Ürün Bilgileri Listelendi");
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
		return herbalist_app_data.getjButton();
	}

	/**
	 * @param args
	 */
	private static Kategori_veri_tabaný kategori_veri_tabaný;
	private static Bitki_veri_tabaný bitki_veri_tabaný;
	private static Vector_Aðaç aðaç_vektörü;
	/**
	 * This method initializes jTabbedPane6
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getJTabbedPane6() {
		if (herbalist_app_data.getjTabbedPane6() == null) {
			herbalist_app_data.setjTabbedPane6(new JTabbedPane());
			herbalist_app_data.getjTabbedPane6().setBounds(new Rectangle(0, 71, 963, 432));
			herbalist_app_data.getjTabbedPane6().addTab(null, null, getJPanel11(), null);
			herbalist_app_data.getjTabbedPane6().addTab(null, null, getJPanel24(), null);
			herbalist_app_data.getjTabbedPane6().addTab(null, null, getJPanel25(), null);
		}
		return herbalist_app_data.getjTabbedPane6();
	}

	/**
	 * This method initializes jPanel11
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel11() {
		if (herbalist_app_data.getjPanel11() == null) {
			herbalist_app_data.setjLabel22(new JLabel());
			herbalist_app_data.getjLabel22().setBounds(new Rectangle(0, 0, 59, 16));
			herbalist_app_data.getjLabel22().setText("Inorder");
			herbalist_app_data.setjPanel11(new JPanel());
			herbalist_app_data.getjPanel11().setLayout(null);
			herbalist_app_data.getjPanel11().add(herbalist_app_data.getjLabel22(), null);
			herbalist_app_data.getjPanel11().add(getJButton2(), null);
			herbalist_app_data.getjPanel11().add(getJTextArea2(), null);
		}
		return herbalist_app_data.getjPanel11();
	}

	/**
	 * This method initializes jPanel24
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel24() {
		if (herbalist_app_data.getjPanel24() == null) {
			herbalist_app_data.setjLabel23(new JLabel());
			herbalist_app_data.getjLabel23().setBounds(new Rectangle(0, 0, 64, 16));
			herbalist_app_data.getjLabel23().setText("Preorder");
			herbalist_app_data.setjPanel24(new JPanel());
			herbalist_app_data.getjPanel24().setLayout(null);
			herbalist_app_data.getjPanel24().add(herbalist_app_data.getjLabel23(), null);
			herbalist_app_data.getjPanel24().add(getJScrollPane1(), null);
			herbalist_app_data.getjPanel24().add(getJButton3(), null);
		}
		return herbalist_app_data.getjPanel24();
	}

	/**
	 * This method initializes jPanel25
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel25() {
		if (herbalist_app_data.getjPanel25() == null) {
			herbalist_app_data.setjLabel24(new JLabel());
			herbalist_app_data.getjLabel24().setBounds(new Rectangle(0, 0, 76, 16));
			herbalist_app_data.getjLabel24().setText("Postorder");
			herbalist_app_data.setjPanel25(new JPanel());
			herbalist_app_data.getjPanel25().setLayout(null);
			herbalist_app_data.getjPanel25().add(herbalist_app_data.getjLabel24(), null);
			herbalist_app_data.getjPanel25().add(getJButton4(), null);
			herbalist_app_data.getjPanel25().add(getJTextArea6(), null);
		}
		return herbalist_app_data.getjPanel25();
	}

	/**
	 * This method initializes jScrollPane1
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane1() {
		if (herbalist_app_data.getjScrollPane1() == null) {
			herbalist_app_data.setjScrollPane1(new JScrollPane());
			herbalist_app_data.getjScrollPane1().setBounds(new Rectangle(0, 16, 957, 445));
			herbalist_app_data.getjScrollPane1().setViewportView(getJTextArea3());
		}
		return herbalist_app_data.getjScrollPane1();
	}

	/**
	 * This method initializes jTextArea3
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea3() {
		if (herbalist_app_data.getjTextArea3() == null) {
			herbalist_app_data.setjTextArea3(new JTextArea());
			herbalist_app_data.getjTextArea3().setText("");
		}
		return herbalist_app_data.getjTextArea3();
	}

	/**
	 * This method initializes jTextField1
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField1() {
		if (herbalist_app_data.getjTextField1() == null) {
			herbalist_app_data.setjTextField1(new JTextField());
			herbalist_app_data.getjTextField1().setBounds(new Rectangle(0, 32, 400, 20));
			herbalist_app_data.getjTextField1().setText("");
		}
		return herbalist_app_data.getjTextField1();
	}

	public static String kategori_var_mý(String aranan) {
		String yanýt = getKategori_veri_tabaný().kategoriyi_araþtýr(aranan);
		return yanýt;
	}

	private JButton getJButton1() {
		if (herbalist_app_data.getjButton1() == null) {
			herbalist_app_data.setjButton1(new JButton());
			herbalist_app_data.getjButton1().setBounds(new Rectangle(1, 50, 399, 21));
			herbalist_app_data.getjButton1().setText("Kategori Var Mý?");
			herbalist_app_data.getjButton1().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					herbalist_app_data.setYanýt(kategori_var_mý(herbalist_app_data.getjTextField1().getText()));
					herbalist_app_data.getjTextArea5().setText(herbalist_app_data.getYanýt());
					if(herbalist_app_data.getYanýt().compareTo("Bulunamadý")!=0){
						int endex = getKategori_veri_tabaný()
						.getAranan_kategori_kaçýnçý_sýrada_bulundu();
				getAðaç_vektörü().getAðaçlar().elementAt(endex);
				herbalist_app_data.getjTextField20().setText(""+getAðaç_vektörü().getAðaçlar().elementAt(endex).node_sayýsý);
					}
					System.out.println("mouseClicked()");
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
		return herbalist_app_data.getjButton1();
	}

	/**
	 * This method initializes jTextArea5
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea5() {
		if (herbalist_app_data.getjTextArea5() == null) {
			herbalist_app_data.setjTextArea5(new JTextArea());
			herbalist_app_data.getjTextArea5().setBounds(new Rectangle(407, 51, 408, 18));
			herbalist_app_data.getjTextArea5().setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
		}
		return herbalist_app_data.getjTextArea5();
	}

	/**
	 * This method initializes jButton2
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton2() {
		if (herbalist_app_data.getjButton2() == null) {
			herbalist_app_data.setjButton2(new JButton());
			herbalist_app_data.getjButton2().setBounds(new Rectangle(59, 1, 115, 15));
			herbalist_app_data.getjButton2().setText("Listele");
			herbalist_app_data.getjButton2().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					herbalist_app_data.getjButton2().setText("Týklandý zaten...");
					if (herbalist_app_data.getjTextArea5().getText().compareTo(
							"Ýlk Önce Arama Yapmanýz Gerekmektedir.") != 0
							&& herbalist_app_data.getjTextArea5().getText().compareTo(
									"Böyle Bir Kategori Bulunmamaktadýr") != 0) {
						int endex = getKategori_veri_tabaný()
								.getAranan_kategori_kaçýnçý_sýrada_bulundu();
						getAðaç_vektörü().getAðaçlar().elementAt(endex)
								.setInorder(new Vector<String>());
						getAðaç_vektörü().getAðaçlar().elementAt(endex)
								.inOrder(
										getAðaç_vektörü().getAðaçlar()
												.elementAt(endex).getNode(), 0);
						herbalist_app_data.getjTextArea2().setText(getAðaç_vektörü().getAðaçlar()
								.elementAt(endex).inOrder_yazdýr());
						// jTextArea2.setText(getAðaç_vektörü().getAðaçlar().elementAt(endex).preOrder_yazdýr());
					}
					System.out.println("mouseClicked()");
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
		return herbalist_app_data.getjButton2();
	}

	/**
	 * This method initializes jButton3
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton3() {
		if (herbalist_app_data.getjButton3() == null) {
			herbalist_app_data.setjButton3(new JButton());
			herbalist_app_data.getjButton3().setBounds(new Rectangle(65, 1, 115, 15));
			herbalist_app_data.getjButton3().setText("Listele");
			herbalist_app_data.getjButton3().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					herbalist_app_data.getjButton3().setText("Týklandý zaten...");
					if (herbalist_app_data.getjTextArea5().getText().compareTo(
							"Ýlk Önce Arama Yapmanýz Gerekmektedir.") != 0
							&& herbalist_app_data.getjTextArea5().getText().compareTo(
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
						herbalist_app_data.getjTextArea3().setText(getAðaç_vektörü().getAðaçlar()
								.elementAt(endex).preOrder_yazdýr());
					}
					System.out.println("mouseClicked()"); 
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
		return herbalist_app_data.getjButton3();
	}

	/**
	 * This method initializes jButton4
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton4() {
		if (herbalist_app_data.getjButton4() == null) {
			herbalist_app_data.setjButton4(new JButton());
			herbalist_app_data.getjButton4().setBounds(new Rectangle(74, 1, 115, 15));
			herbalist_app_data.getjButton4().setText("Listele");
			herbalist_app_data.getjButton4().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					herbalist_app_data.getjButton4().setText("Týklandý zaten...");
					if (herbalist_app_data.getjTextArea5().getText().compareTo(
							"Ýlk Önce Arama Yapmanýz Gerekmektedir.") != 0
							&& herbalist_app_data.getjTextArea5().getText().compareTo(
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
						herbalist_app_data.getjTextArea6().setText(getAðaç_vektörü().getAðaçlar()
								.elementAt(endex).postOrder_yazdýr());
					}
					System.out.println("mouseClicked()"); 
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
		return herbalist_app_data.getjButton4();
	}

	/**
	 * This method initializes jTextArea2
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea2() {
		if (herbalist_app_data.getjTextArea2() == null) {
			herbalist_app_data.setjTextArea2(new JTextArea());
			herbalist_app_data.getjTextArea2().setBounds(new Rectangle(0, 16, 953, 385));
			herbalist_app_data.getjTextArea2().setText("");
		}
		return herbalist_app_data.getjTextArea2();
	}

	/**
	 * This method initializes jTextArea6
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea6() {
		if (herbalist_app_data.getjTextArea6() == null) {
			herbalist_app_data.setjTextArea6(new JTextArea());
			herbalist_app_data.getjTextArea6().setBounds(new Rectangle(0, 16, 953, 385));
			herbalist_app_data.getjTextArea6().setText("");
		}
		return herbalist_app_data.getjTextArea6();
	}

	private static Hash_Table hash_table; // @jve:decl-index=0:
	private static Hastalýk_veri_tabaný hastalýk_veri_tabaný;
	private static JTextField jTextField2 = null;
	private static JTextField jTextField3 = null;
	private static JTextField jTextField5 = null;
	private static JTextField jTextField7 = null;
	private static JTextArea jTextArea8 = null;
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
		if (herbalist_app_data.getjButton5() == null) {
			herbalist_app_data.setjButton5(new JButton());
			herbalist_app_data.getjButton5().setBounds(new Rectangle(2, 51, 288, 18));
			herbalist_app_data.getjButton5().setText("Kategori Var Mý?");
			herbalist_app_data.getjButton5().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					herbalist_app_data.setYanýt(kategori_var_mý(jTextField2.getText()));
					jTextField3.setText(herbalist_app_data.getYanýt());
					System.out.println("mouseClicked()"); 
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
		return herbalist_app_data.getjButton5();
	}

	/**
	 * This method initializes jButton6
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton6() {
		if (herbalist_app_data.getjButton6() == null) {
			herbalist_app_data.setjButton6(new JButton());
			herbalist_app_data.getjButton6().setBounds(new Rectangle(290, 51, 282, 18));
			herbalist_app_data.getjButton6().setText("Ekleme Yapmak Ýçin Týklayýnýz");
			jTextField3.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
			herbalist_app_data.getjButton6().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (jTextField3.getText().compareTo("Bulundu") != 0
							&& jTextField3.getText().compareTo(
									"Ýlk Önce Arama Yapmanýz Gerekmektedir.") != 0) {
						jTextField3
								.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
						kategori_ekle();
						jTextField2.setText("Ekleme Yapýldý");
					}
					herbalist_app_data.getjTextArea4().setText("Yenileniyor Lütfen Bekleyiniz");
					System.out.println("mouseClicked()");
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
		return herbalist_app_data.getjButton6();
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
		if (herbalist_app_data.getjLabel30() == null) {
			herbalist_app_data.setjLabel30(new JLabel());
			herbalist_app_data.getjLabel30().setText("Kategori Listesi");
			herbalist_app_data.getjLabel30().setBounds(new Rectangle(2, 70, 166, 16));
		}
		return herbalist_app_data.getjLabel30();
	}

	/**
	 * This method initializes jTextArea4
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea4() {
		if (herbalist_app_data.getjTextArea4() == null) {
			herbalist_app_data.setjTextArea4(new JTextArea());
			herbalist_app_data.getjTextArea4().setBounds(new Rectangle(4, 87, 569, 430));
			herbalist_app_data.getjTextArea4().setText("");
		}
		return herbalist_app_data.getjTextArea4();
	}

	/**
	 * This method initializes jTextField4
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField4() {
		if (herbalist_app_data.getjTextField4() == null) {
			herbalist_app_data.setjTextField4(new JTextField());
			herbalist_app_data.getjTextField4().setBounds(new Rectangle(0, 32, 226, 20));
			herbalist_app_data.getjTextField4().setText("");
		}
		return herbalist_app_data.getjTextField4();
	}

	/**
	 * This method initializes jButton7
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton7() {
		if (herbalist_app_data.getjButton7() == null) {
			herbalist_app_data.setjButton7(new JButton());
			herbalist_app_data.getjButton7().setBounds(new Rectangle(1, 52, 224, 20));
			herbalist_app_data.getjButton7().setText("Veri Tabanýnda Ara");
			herbalist_app_data.getjButton7().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Hastalýk aranan;
					aranan = hash_table.getHash().get(herbalist_app_data.getjTextField4().getText());
					if(aranan==null){
						herbalist_app_data.getjTextField10().setText("Bulunamadý");
						herbalist_app_data.setYanýt("");
					}
					else{
						herbalist_app_data.getjTextField10().setText("Bulundu");
						herbalist_app_data.setYanýt(herbalist_app_data.getjTextField4().getText());
					}
					
					System.out.println("mouseClicked()"); 
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
		return herbalist_app_data.getjButton7();
	}

	/**
	 * This method initializes Kategori_Listeleyici
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getKategori_Listeleyici() {
		if (herbalist_app_data.getKategori_Listeleyici() == null) {
			herbalist_app_data.setKategori_Listeleyici(new JButton());
			herbalist_app_data.getKategori_Listeleyici().setBounds(new Rectangle(166, 69, 152, 17));
			herbalist_app_data.getKategori_Listeleyici().setText("Kategori Listeleyici");
			herbalist_app_data.getKategori_Listeleyici()
					.addMouseListener(new java.awt.event.MouseListener() {
						public void mouseClicked(java.awt.event.MouseEvent e) {
							herbalist_app_data.getjTextArea4().setText(Kategori_veri_tabaný
									.getKategoriler().toString());
							System.out.println("mouseClicked()"); 
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
		return herbalist_app_data.getKategori_Listeleyici();
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
		if (herbalist_app_data.getjTextField6() == null) {
			herbalist_app_data.setjTextField6(new JTextField());
			herbalist_app_data.getjTextField6().setBounds(new Rectangle(250, 32, 243, 20));
			herbalist_app_data.getjTextField6().setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
		}
		return herbalist_app_data.getjTextField6();
	}

	/**
	 * This method initializes jButton8
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton8() {
		if (herbalist_app_data.getjButton8() == null) {
			herbalist_app_data.setjButton8(new JButton());
			herbalist_app_data.getjButton8().setBounds(new Rectangle(0, 52, 252, 20));
			herbalist_app_data.getjButton8().setText("Kategori Var Mý?");
			herbalist_app_data.getjButton8().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					herbalist_app_data.setYanýt(kategori_var_mý(jTextField5.getText()));
					herbalist_app_data.getjTextField6().setText(herbalist_app_data.getYanýt());
					System.out.println("mouseClicked()"); 
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
		return herbalist_app_data.getjButton8();
	}

	/**
	 * This method initializes jButton9
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton9() {
		if (herbalist_app_data.getjButton9() == null) {
			herbalist_app_data.setjButton9(new JButton());
			herbalist_app_data.getjButton9().setBounds(new Rectangle(252, 52, 241, 20));
			herbalist_app_data.getjButton9().setText("Kategoriyi Silmek Ýçin Týklayýnýz");
			herbalist_app_data.getjButton9().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (herbalist_app_data.getjTextField6().getText().compareTo("Bulundu") == 0) {
						herbalist_app_data.getjTextField6()
								.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
						kategori_sil();
						jTextField5.setText("Kategori Silindi");
					}
					herbalist_app_data.getjTextArea7().setText("Yenileniyor Lütfen Bekleyiniz");
					System.out.println("mouseClicked()"); 
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
		return herbalist_app_data.getjButton9();
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
		if (herbalist_app_data.getKategori_Listeleyici_2() == null) {
			herbalist_app_data.setKategori_Listeleyici_2(new JButton());
			herbalist_app_data.getKategori_Listeleyici_2().setBounds(new Rectangle(109, 73, 143, 16));
			herbalist_app_data.getKategori_Listeleyici_2().setText("Kategori Listeleyici");
			herbalist_app_data.getKategori_Listeleyici_2()
					.addMouseListener(new java.awt.event.MouseListener() {
						public void mouseClicked(java.awt.event.MouseEvent e) {
							herbalist_app_data.getjTextArea7().setText(Kategori_veri_tabaný
									.getKategoriler().toString());
							System.out.println("mouseClicked()"); 
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
		return herbalist_app_data.getKategori_Listeleyici_2();
	}

	/**
	 * This method initializes jTextArea7
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea7() {
		if (herbalist_app_data.getjTextArea7() == null) {
			herbalist_app_data.setjTextArea7(new JTextArea());
			herbalist_app_data.getjTextArea7().setBounds(new Rectangle(0, 90, 965, 429));
		}
		return herbalist_app_data.getjTextArea7();
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
		if (herbalist_app_data.getjButton10() == null) {
			herbalist_app_data.setjButton10(new JButton());
			herbalist_app_data.getjButton10().setBounds(new Rectangle(0, 51, 299, 21));
			herbalist_app_data.getjButton10().setText("Ürün Var Mý?");
			herbalist_app_data.getjButton10().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					// Ürünü Aðaçta Ara
					herbalist_app_data.setYanýt(aðaç_kategorilerinde_ara(jTextField7.getText()));
					if (herbalist_app_data.getYanýt().compareTo("Bulunamadý") != 0) {
						herbalist_app_data.getjTextField8().setText("Bulundu");
					} else {
						herbalist_app_data.getjTextField8().setText(herbalist_app_data.getYanýt());
					}
					System.out.println("mouseClicked()"); 
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
		return herbalist_app_data.getjButton10();
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
		if (herbalist_app_data.getjTextField8() == null) {
			herbalist_app_data.setjTextField8(new JTextField());
			herbalist_app_data.getjTextField8().setBounds(new Rectangle(299, 32, 301, 20));
			herbalist_app_data.getjTextField8().setText("Ýlk Önce Arama Yapmanýz Gerekmektedir");
		}
		return herbalist_app_data.getjTextField8();
	}

	/**
	 * This method initializes jButton11
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton11() {
		if (herbalist_app_data.getjButton11() == null) {
			herbalist_app_data.setjButton11(new JButton());
			herbalist_app_data.getjButton11().setBounds(new Rectangle(299, 51, 301, 20));
			herbalist_app_data.getjButton11().setText("Ürünü Silmek Ýçin Týklayýnýz");
			herbalist_app_data.getjButton11().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {

					if (herbalist_app_data.getjTextField8().getText().compareTo("Bulundu") == 0) {
						jTextArea8
								.setText("Veri Tabaný Yenileniyor.Lütfen Bekleyiniz");
						aðaç_vektöründen_kaldýr();
						bitki_veri_tabanýndan_kaldýr();
						herbalist_app_data.getjTextField8()
								.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir");
						jTextField7.setText("Silindi");
						/*
						 * yanýt = " "; jTextArea8.setText(" ");// Silinen Ürün
						 * Bilgileri // Ekrandan // Siliniyor
						 */
					}

					System.out.println("mouseClicked()"); 
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
		return herbalist_app_data.getjButton11();
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
		if (herbalist_app_data.getÜrün_Bilgisi_Listeleyici() == null) {
			herbalist_app_data.setÜrün_Bilgisi_Listeleyici(new JButton());
			herbalist_app_data.getÜrün_Bilgisi_Listeleyici().setBounds(new Rectangle(110, 73, 193, 15));
			herbalist_app_data.getÜrün_Bilgisi_Listeleyici().setText("Ürün Bilgisi Listeleyici");
			herbalist_app_data.getÜrün_Bilgisi_Listeleyici()
					.addMouseListener(new java.awt.event.MouseListener() {
						public void mouseClicked(java.awt.event.MouseEvent e) {
							jTextArea8.setText(herbalist_app_data.getYanýt());
							System.out.println("Yanýt Listelendi"); 
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
		return herbalist_app_data.getÜrün_Bilgisi_Listeleyici();
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
		if (herbalist_app_data.getGeçici_metin_kutusu() == null) {
			herbalist_app_data.setGeçici_metin_kutusu(new JTextArea());
			herbalist_app_data.getGeçici_metin_kutusu().setBounds(new Rectangle(604, 58, 238, 150));
			herbalist_app_data.getGeçici_metin_kutusu()
					.setText("String adý\n, String kategori\n, String latince_adý\n, int miktarý\n,float fiyatý\n, String diskteki_yeri\n, String diskteki_adý\n,Vector<String> önerilen_hastalýklar\n, Vector<String> özellikleri");
		}
		return herbalist_app_data.getGeçici_metin_kutusu();
	}

	/**
	 * This method initializes jTextField9
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField9() {
		if (herbalist_app_data.getjTextField9() == null) {
			herbalist_app_data.setjTextField9(new JTextField());
			herbalist_app_data.getjTextField9().setBounds(new Rectangle(0, 31, 262, 20));
			herbalist_app_data.getjTextField9().setText("");
		}
		return herbalist_app_data.getjTextField9();
	}

	/**
	 * This method initializes jButton12
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton12() {
		if (herbalist_app_data.getjButton12() == null) {
			herbalist_app_data.setjButton12(new JButton());
			herbalist_app_data.getjButton12().setBounds(new Rectangle(0, 49, 262, 18));
			herbalist_app_data.getjButton12().setText("Aranan Hastalýðýn Bilgilerini Listele");
			herbalist_app_data.getjButton12().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					herbalist_app_data.setYanýt(hash_table.getHash().get(herbalist_app_data.getjTextField9().getText())
							.toString());

					if (herbalist_app_data.getYanýt() != null) {
						herbalist_app_data.getjTextArea9().setText(herbalist_app_data.getYanýt());
						System.out
								.println("Aranan Hastalýðýn Bilgileri Listelendi"); 
						// Auto-generated
						// Event
						// stub
						// mouseClicked()
					} else {
						herbalist_app_data.getjTextArea9().setText("Bulunamadý");
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
		return herbalist_app_data.getjButton12();
	}

	/**
	 * This method initializes jTextArea9
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea9() {
		if (herbalist_app_data.getjTextArea9() == null) {
			herbalist_app_data.setjTextArea9(new JTextArea());
			herbalist_app_data.getjTextArea9().setBounds(new Rectangle(1, 67, 972, 494));
			herbalist_app_data.getjTextArea9().setText("");
		}
		return herbalist_app_data.getjTextArea9();
	}

	/**
	 * This method initializes jTextField10
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField10() {
		if (herbalist_app_data.getjTextField10() == null) {
			herbalist_app_data.setjTextField10(new JTextField());
			herbalist_app_data.getjTextField10().setBounds(new Rectangle(223, 31, 244, 20));
			herbalist_app_data.getjTextField10().setText("");
		}
		return herbalist_app_data.getjTextField10();
	}

	/**
	 * This method initializes jTextField12
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField12() {
		if (herbalist_app_data.getjTextField12() == null) {
			herbalist_app_data.setjTextField12(new JTextField());
			herbalist_app_data.getjTextField12().setBounds(new Rectangle(1, 89, 465, 20));
			herbalist_app_data.getjTextField12().setText("");
		}
		return herbalist_app_data.getjTextField12();
	}

	public Herbalist_AppData herbalist_app_data = new Herbalist_AppData(null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, "", null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, new Vector<String>(),
			new Vector<String>(), new Vector<String>(), new Vector<String>(), null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null);
	private static Form form1;

	private JButton getJButton14() {
		if (herbalist_app_data.getjButton14() == null) {
			herbalist_app_data.setjButton14(new JButton());
			herbalist_app_data.getjButton14().setBounds(new Rectangle(224, 67, 243, 22));
			herbalist_app_data.getjButton14().setText("Belirtiyi Eklemek için Týklayýnýz");
			herbalist_app_data.getjButton14().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (herbalist_app_data.getjTextField12().getText().compareTo("Eklendi") != 0)
						herbalist_app_data.getBelirtiler().add(herbalist_app_data.getjTextField12().getText());
					String metin = "";
					for (int i = 0; i < herbalist_app_data.getBelirtiler().size(); i++) {
						metin += herbalist_app_data.getBelirtiler().elementAt(i);
					}
					herbalist_app_data.getjTextArea10().setText(metin);
					herbalist_app_data.getjTextField12().setText("Eklendi");
					System.out.println("mouseClicked()"); 
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
		return herbalist_app_data.getjButton14();
	}

	/**
	 * This method initializes jTextField13
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField13() {
		if (herbalist_app_data.getjTextField13() == null) {
			herbalist_app_data.setjTextField13(new JTextField());
			herbalist_app_data.getjTextField13().setBounds(new Rectangle(1, 125, 463, 20));
			herbalist_app_data.getjTextField13().setText("");
		}
		return herbalist_app_data.getjTextField13();
	}

	/**
	 * This method initializes jButton15
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton15() {
		if (herbalist_app_data.getjButton15() == null) {
			herbalist_app_data.setjButton15(new JButton());
			herbalist_app_data.getjButton15().setBounds(new Rectangle(220, 108, 240, 19));
			herbalist_app_data.getjButton15().setText("Nedeni Eklemek Ýçin Týklayýnýz");
			herbalist_app_data.getjButton15().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (herbalist_app_data.getjTextField13().getText().compareTo("Eklendi") != 0) {
						herbalist_app_data.getNedenler().add(herbalist_app_data.getjTextField13().getText());
						String metin = "";
						for (int i = 0; i < herbalist_app_data.getNedenler().size(); i++) {
							metin += herbalist_app_data.getNedenler().elementAt(i);
						}
						herbalist_app_data.getjTextArea11().setText(metin);
						herbalist_app_data.getjTextField13().setText("Eklendi");
					}
					System.out.println("mouseClicked()"); 
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
		return herbalist_app_data.getjButton15();
	}

	/**
	 * This method initializes jTextField14
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField14() {
		if (herbalist_app_data.getjTextField14() == null) {
			herbalist_app_data.setjTextField14(new JTextField());
			herbalist_app_data.getjTextField14().setBounds(new Rectangle(0, 160, 465, 20));
			herbalist_app_data.getjTextField14().setText("");
		}
		return herbalist_app_data.getjTextField14();
	}

	/**
	 * This method initializes jButton16
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton16() {
		if (herbalist_app_data.getjButton16() == null) {
			herbalist_app_data.setjButton16(new JButton());
			herbalist_app_data.getjButton16().setBounds(new Rectangle(220, 143, 240, 16));
			herbalist_app_data.getjButton16().setText("Tedavi Eklemek Ýçin Týklayýnýz");
			herbalist_app_data.getjButton16().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (herbalist_app_data.getjTextField14().getText().compareTo("Eklendi") != 0) {
						herbalist_app_data.getTedaviler().add(herbalist_app_data.getjTextField14().getText());
						String metin = "";
						for (int i = 0; i < herbalist_app_data.getTedaviler().size(); i++) {
							metin += herbalist_app_data.getTedaviler().elementAt(i);
						}
						herbalist_app_data.getjTextArea12().setText(metin);
						herbalist_app_data.getjTextField14().setText("Eklendi");
					}
					System.out.println("mouseClicked()"); 
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
		return herbalist_app_data.getjButton16();
	}

	/**
	 * This method initializes jButton17
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton17() {
		if (herbalist_app_data.getjButton17() == null) {
			herbalist_app_data.setjButton17(new JButton());
			herbalist_app_data.getjButton17().setBounds(new Rectangle(222, 180, 241, 14));
			herbalist_app_data.getjButton17().setText("Bitkiyi Eklemek Ýçin Týklayýnýz");
			herbalist_app_data.getjButton17().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (herbalist_app_data.getjTextField15().getText().compareTo("Eklendi") != 0) {
						herbalist_app_data.getBitkiler().add(herbalist_app_data.getjTextField15().getText());
						String metin = "";
						for (int i = 0; i < herbalist_app_data.getBitkiler().size(); i++) {
							metin += herbalist_app_data.getBitkiler().elementAt(i);
						}
						herbalist_app_data.getjTextArea13().setText(metin);
						herbalist_app_data.getjTextField15().setText("Eklendi");
					}
					System.out.println("mouseClicked()"); 
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
		return herbalist_app_data.getjButton17();
	}

	/**
	 * This method initializes jTextField15
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField15() {
		if (herbalist_app_data.getjTextField15() == null) {
			herbalist_app_data.setjTextField15(new JTextField());
			herbalist_app_data.getjTextField15().setBounds(new Rectangle(-1, 194, 464, 20));
			herbalist_app_data.getjTextField15().setText("");
		}
		return herbalist_app_data.getjTextField15();
	}

	/**
	 * This method initializes jTextArea10
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea10() {
		if (herbalist_app_data.getjTextArea10() == null) {
			herbalist_app_data.setjTextArea10(new JTextArea());
			herbalist_app_data.getjTextArea10().setBounds(new Rectangle(472, 35, 500, 127));
		}
		return herbalist_app_data.getjTextArea10();
	}

	/**
	 * This method initializes jTextArea11
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea11() {
		if (herbalist_app_data.getjTextArea11() == null) {
			herbalist_app_data.setjTextArea11(new JTextArea());
			herbalist_app_data.getjTextArea11().setBounds(new Rectangle(468, 180, 505, 135));
		}
		return herbalist_app_data.getjTextArea11();
	}

	/**
	 * This method initializes jTextArea12
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea12() {
		if (herbalist_app_data.getjTextArea12() == null) {
			herbalist_app_data.setjTextArea12(new JTextArea());
			herbalist_app_data.getjTextArea12().setBounds(new Rectangle(0, 229, 463, 197));
		}
		return herbalist_app_data.getjTextArea12();
	}

	/**
	 * This method initializes jTextArea13
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea13() {
		if (herbalist_app_data.getjTextArea13() == null) {
			herbalist_app_data.setjTextArea13(new JTextArea());
			herbalist_app_data.getjTextArea13().setBounds(new Rectangle(470, 330, 500, 225));
		}
		return herbalist_app_data.getjTextArea13();
	}

	/**
	 * This method initializes jButton18
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton18() {
		if (herbalist_app_data.getjButton18() == null) {
			herbalist_app_data.setjButton18(new JButton());
			herbalist_app_data.getjButton18().setBounds(new Rectangle(223, 427, 241, 16));
			herbalist_app_data.getjButton18().setText("Bilgileri Kaydetmek Ýstiyorum");
			herbalist_app_data.getjButton18().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					/* belirtiler nedenler tedaviler bitkiler */
					if (herbalist_app_data.getjTextField10().getText().compareTo("Bulunamadý") == 0) {
						herbalist_app_data.getjTextArea14().setText("Veriler Kaydediliyor");
						Hastalýk yeni = new Hastalýk(herbalist_app_data.getjTextField4().getText(),
								herbalist_app_data.getBelirtiler(), herbalist_app_data.getNedenler(), herbalist_app_data.getTedaviler(), herbalist_app_data.getBitkiler());
						hash_table.getHash().put(herbalist_app_data.getjTextField4().getText(), yeni);
						Hastalýk_veri_tabaný.getHastalýklar().add(yeni);
						hastalýk_veri_tabaný.update_file();
						herbalist_app_data.getjTextArea14().setText("Veriler Kaydedildi");
					}
					System.out.println("mouseClicked()"); 
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
		return herbalist_app_data.getjButton18();
	}

	/**
	 * This method initializes jTextArea14
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea14() {
		if (herbalist_app_data.getjTextArea14() == null) {
			herbalist_app_data.setjTextArea14(new JTextArea());
			herbalist_app_data.getjTextArea14().setBounds(new Rectangle(3, 474, 459, 80));
			herbalist_app_data.getjTextArea14().setText("");
		}
		return herbalist_app_data.getjTextArea14();
	}

	/**
	 * This method initializes jTextField11	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField11() {
		if (herbalist_app_data.getjTextField11() == null) {
			herbalist_app_data.setjTextField11(new JTextField());
			herbalist_app_data.getjTextField11().setBounds(new Rectangle(166, 17, 165, 20));
			herbalist_app_data.getjTextField11().setText("0");
		}
		return herbalist_app_data.getjTextField11();
	}

	/**
	 * This method initializes jTextField16	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField16() {
		if (herbalist_app_data.getjTextField16() == null) {
			herbalist_app_data.setjTextField16(new JTextField());
			herbalist_app_data.getjTextField16().setBounds(new Rectangle(494, 16, 167, 20));
			herbalist_app_data.getjTextField16().setText("0");
		}
		return herbalist_app_data.getjTextField16();
	}

	/**
	 * This method initializes jButton13	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton13() {
		if (herbalist_app_data.getjButton13() == null) {
			herbalist_app_data.setjButton13(new JButton());
			herbalist_app_data.getjButton13().setBounds(new Rectangle(662, 17, 139, 18));
			herbalist_app_data.getjButton13().setText("Ürünleri Listele");
			herbalist_app_data.getjButton13().addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					float min,max;
					min=Float.parseFloat(herbalist_app_data.getjTextField11().getText());
					max=Float.parseFloat(herbalist_app_data.getjTextField16().getText());
					if(min>=0&&max>=min){
						herbalist_app_data.getjTextArea15().setText(getBitki_veri_tabaný().ürünleri_listele(min,max));
					}else{
						herbalist_app_data.getjTextArea15().setText("Doðru Aralýkta Sayýlar Giriniz");
					}
					System.out.println("mouseClicked()");
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
		return herbalist_app_data.getjButton13();
	}
	
	/**
	 * This method initializes jTextArea15	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea15() {
		if (herbalist_app_data.getjTextArea15() == null) {
			herbalist_app_data.setjTextArea15(new JTextArea());
			herbalist_app_data.getjTextArea15().setBounds(new Rectangle(6, 40, 964, 518));
		}
		return herbalist_app_data.getjTextArea15();
	}

	/**
	 * This method initializes jTextField17	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField17() {
		if (herbalist_app_data.getjTextField17() == null) {
			herbalist_app_data.setjTextField17(new JTextField());
			herbalist_app_data.getjTextField17().setBounds(new Rectangle(0, 33, 238, 20));
			herbalist_app_data.getjTextField17().setText("");
		}
		return herbalist_app_data.getjTextField17();
	}

	/**
	 * This method initializes jTextField18	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField18() {
		if (herbalist_app_data.getjTextField18() == null) {
			herbalist_app_data.setjTextField18(new JTextField());
			herbalist_app_data.getjTextField18().setBounds(new Rectangle(238, 33, 320, 20));
			herbalist_app_data.getjTextField18().setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
		}
		return herbalist_app_data.getjTextField18();
	}

	/**
	 * This method initializes jTextField19	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField19() {
		if (herbalist_app_data.getjTextField19() == null) {
			herbalist_app_data.setjTextField19(new JTextField());
			herbalist_app_data.getjTextField19().setBounds(new Rectangle(818, 19, 145, 20));
		}
		return herbalist_app_data.getjTextField19();
	}

	/**
	 * This method initializes jTextField20	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField20() {
		if (herbalist_app_data.getjTextField20() == null) {
			herbalist_app_data.setjTextField20(new JTextField());
			herbalist_app_data.getjTextField20().setBounds(new Rectangle(820, 52, 143, 20));
		}
		return herbalist_app_data.getjTextField20();
	}

	/**
	 * This method initializes jButton19	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton19() {
		if (herbalist_app_data.getjButton19() == null) {
			herbalist_app_data.setjButton19(new JButton());
			herbalist_app_data.getjButton19().setBounds(new Rectangle(3, 51, 235, 22));
			herbalist_app_data.getjButton19().setText("Aðaç Vektöründe Var Mý?");
		}
		return herbalist_app_data.getjButton19();
	}

	// *************************MAIN********************************************************
	public static void main(String[] args) {
		setForm1(new Form());
		form1.appgui();
	}



	static void veri_tabanlarýný_veri_yapýlarýna_kopyala() {
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
	JFrame getHerbalist_Application() {
		if (herbalist_app_data.getHerbalist_Application() == null) {
			herbalist_app_data.setHerbalist_Application(new JFrame());
			herbalist_app_data.getHerbalist_Application()
					.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			herbalist_app_data.getHerbalist_Application().setJMenuBar(getJJMenuBar());
			herbalist_app_data.getHerbalist_Application().setSize(1000, 700);
			herbalist_app_data.getHerbalist_Application().setContentPane(getMenü());
			herbalist_app_data.getHerbalist_Application().setTitle("Herbalist Uygulamasý");
		}
		return herbalist_app_data.getHerbalist_Application();
	}

	/**
	 * This method initializes Menü
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getMenü() {
		if (herbalist_app_data.getMenü() == null) {
			herbalist_app_data.setMenü(new JPanel());
			herbalist_app_data.getMenü().setLayout(null);
			herbalist_app_data.getMenü().add(getKullanýcý_Menüsü(), null);
		}
		return herbalist_app_data.getMenü();
	}

	/**
	 * This method initializes jJMenuBar
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getJJMenuBar() {
		if (herbalist_app_data.getjJMenuBar() == null) {
			herbalist_app_data.setjJMenuBar(new JMenuBar());
			herbalist_app_data.getjJMenuBar().add(getFileMenu());
			herbalist_app_data.getjJMenuBar().add(getEditMenu());
			herbalist_app_data.getjJMenuBar().add(getHelpMenu());
		}
		return herbalist_app_data.getjJMenuBar();
	}

	/**
	 * This method initializes jMenu
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getFileMenu() {
		if (herbalist_app_data.getFileMenu() == null) {
			herbalist_app_data.setFileMenu(new JMenu());
			herbalist_app_data.getFileMenu().setText("Dosya");
			herbalist_app_data.getFileMenu().add(getSaveMenuItem());
			herbalist_app_data.getFileMenu().add(getExitMenuItem());
		}
		return herbalist_app_data.getFileMenu();
	}

	/**
	 * This method initializes jMenu
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getEditMenu() {
		if (herbalist_app_data.getEditMenu() == null) {
			herbalist_app_data.setEditMenu(new JMenu());
			herbalist_app_data.getEditMenu().setText("Düzenle");
			herbalist_app_data.getEditMenu().add(getCutMenuItem());
			herbalist_app_data.getEditMenu().add(getCopyMenuItem());
			herbalist_app_data.getEditMenu().add(getPasteMenuItem());
		}
		return herbalist_app_data.getEditMenu();
	}

	/**
	 * This method initializes jMenu
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getHelpMenu() {
		if (herbalist_app_data.getHelpMenu() == null) {
			herbalist_app_data.setHelpMenu(new JMenu());
			herbalist_app_data.getHelpMenu().setText("Yardým");
			herbalist_app_data.getHelpMenu().add(getAboutMenuItem());
		}
		return herbalist_app_data.getHelpMenu();
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getExitMenuItem() {
		if (herbalist_app_data.getExitMenuItem() == null) {
			herbalist_app_data.setExitMenuItem(new JMenuItem());
			herbalist_app_data.getExitMenuItem().setText("Çýkýþ");
			herbalist_app_data.getExitMenuItem().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return herbalist_app_data.getExitMenuItem();
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getAboutMenuItem() {
		if (herbalist_app_data.getAboutMenuItem() == null) {
			herbalist_app_data.setAboutMenuItem(new JMenuItem());
			herbalist_app_data.getAboutMenuItem().setText("Hakkýnda");
			herbalist_app_data.getAboutMenuItem().addActionListener(new ActionListener() {
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
		return herbalist_app_data.getAboutMenuItem();
	}

	/**
	 * This method initializes aboutDialog
	 * 
	 * @return javax.swing.JDialog
	 */
	private JDialog getAboutDialog() {
		if (herbalist_app_data.getAboutDialog() == null) {
			herbalist_app_data.setAboutDialog(new JDialog(getHerbalist_Application(), true));
			herbalist_app_data.getAboutDialog().setTitle("Hakkýnda");
			herbalist_app_data.getAboutDialog().setContentPane(getAboutContentPane());
		}
		return herbalist_app_data.getAboutDialog();
	}

	/**
	 * This method initializes aboutContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAboutContentPane() {
		if (herbalist_app_data.getAboutContentPane() == null) {
			herbalist_app_data.setAboutContentPane(new JPanel());
			herbalist_app_data.getAboutContentPane().setLayout(new BorderLayout());
			herbalist_app_data.getAboutContentPane().add(getAboutVersionLabel(), BorderLayout.CENTER);
		}
		return herbalist_app_data.getAboutContentPane();
	}

	/**
	 * This method initializes aboutVersionLabel
	 * 
	 * @return javax.swing.JLabel
	 */
	private JLabel getAboutVersionLabel() {
		if (herbalist_app_data.getAboutVersionLabel() == null) {
			herbalist_app_data.setAboutVersionLabel(new JLabel());
			herbalist_app_data.getAboutVersionLabel().setText("Versiyon 1.1");
			herbalist_app_data.getAboutVersionLabel().setHorizontalAlignment(SwingConstants.CENTER);
		}
		return herbalist_app_data.getAboutVersionLabel();
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getCutMenuItem() {
		if (herbalist_app_data.getCutMenuItem() == null) {
			herbalist_app_data.setCutMenuItem(new JMenuItem());
			herbalist_app_data.getCutMenuItem().setText("Kes");
			herbalist_app_data.getCutMenuItem().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
					Event.CTRL_MASK, true));
		}
		return herbalist_app_data.getCutMenuItem();
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getCopyMenuItem() {
		if (herbalist_app_data.getCopyMenuItem() == null) {
			herbalist_app_data.setCopyMenuItem(new JMenuItem());
			herbalist_app_data.getCopyMenuItem().setText("Kopyala");
			herbalist_app_data.getCopyMenuItem().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
					Event.CTRL_MASK, true));
		}
		return herbalist_app_data.getCopyMenuItem();
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getPasteMenuItem() {
		if (herbalist_app_data.getPasteMenuItem() == null) {
			herbalist_app_data.setPasteMenuItem(new JMenuItem());
			herbalist_app_data.getPasteMenuItem().setText("Yapýþtýr");
			herbalist_app_data.getPasteMenuItem().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
					Event.CTRL_MASK, true));
		}
		return herbalist_app_data.getPasteMenuItem();
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getSaveMenuItem() {
		if (herbalist_app_data.getSaveMenuItem() == null) {
			herbalist_app_data.setSaveMenuItem(new JMenuItem());
			herbalist_app_data.getSaveMenuItem().setText("Kaydet");
			herbalist_app_data.getSaveMenuItem().setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
					Event.CTRL_MASK, true));
		}
		return herbalist_app_data.getSaveMenuItem();
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

	/**
	 * @return the form1
	 */
	public static Form getForm1() {
		return form1;
	}

	/**
	 * @param form1 the form1 to set
	 */
	public static void setForm1(Form form1) {
		Herbalist_App.form1 = form1;
	}

}
