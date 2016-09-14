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

import agac.Node;
import agaclar.Vector_Agac;

import veri_tabani.Bitki_veri_tabani;
import veri_tabani.Hastalik_veri_tabani;
import veri_tabani.Kategori_veri_tabani;

import javax.swing.JScrollPane;

import dert.Hastalik;
import deva.Kategori;

public class Herbalist_App {

	private static JTextField jTextField = null;
	private JTabbedPane getKullanici_Menusu() {
		if (data.Kullanici_Menusu == null) {
			data.Kullanici_Menusu = new JTabbedPane();
			data.Kullanici_Menusu.setBounds(new Rectangle(0, 0, 985, 635));
			data.Kullanici_Menusu.addTab(null, null, Musterilerin_Kulanabilecekleri_Bolum(), null);
			data.Kullanici_Menusu.addTab(null, null, getJPanel1(), null);
		}
		return data.Kullanici_Menusu;
	}

	private JPanel Musterilerin_Kulanabilecekleri_Bolum() {
		if (data.jPanel == null) {
			data.Musteri_Menusu_Basligi = new JLabel();
			data.Musteri_Menusu_Basligi.setBounds(new Rectangle(0, 0, 343, 16));
			data.Musteri_Menusu_Basligi
					.setText("Müsterilerin Kulanabilecekleri Bolum");
			data.jPanel = new JPanel();
			data.jPanel.setLayout(null);
			data.jPanel.add(getMusteri_Menusu(), null);
			data.jPanel.add(data.Musteri_Menusu_Basligi, null);
		}
		return data.jPanel;
	}

	private JPanel getJPanel1() {
		if (data.jPanel1 == null) {
			data.Personel_Menusu_Basligi = new JLabel();
			data.Personel_Menusu_Basligi.setBounds(new Rectangle(0, 0, 346, 16));
			data.Personel_Menusu_Basligi
					.setText("Sadece Firma Personelinin Kullanabilecegi Bolum");
			data.jPanel1 = new JPanel();
			data.jPanel1.setLayout(null);
			data.jPanel1.add(data.Personel_Menusu_Basligi, null);
			data.jPanel1.add(getPersonel_Menusu(), null);
		}
		return data.jPanel1;
	}

	private JTabbedPane getMusteri_Menusu() {
		if (data.Musteri_Menusu == null) {
			data.Musteri_Menusu = new JTabbedPane();
			data.Musteri_Menusu.setBounds(new Rectangle(0, 16, 979, 589));
			data.Musteri_Menusu.addTab(null, null, getJPanel2(), null);
			data.Musteri_Menusu
					.addTab(
							null,
							null,
							getBelirli_Fiyatlar_Arasindaki_Tum_Turlerin_Bulunup_Listelenmesi(),
							null);
			data.Musteri_Menusu
					.addTab(
							null,
							null,
							getVerilen_Bir_Kelimenin_Kategori_Agaclarinda_Tutulan_Bitkilerin_Ozellikleri_Icinden_Aratilmasi_Bulunan_Bitki_Isimlerinin_Listelenmesi(),
							null);
			data.Musteri_Menusu.addTab(null, null,
					getUrun_Siparisi_Birden_Cok_Paket_Istenebilir_ve_Alimi(),
					null);
			data.Musteri_Menusu
					.addTab(
							null,
							null,
							getKategori_Listeleme_Agac_Derinligi_ve_Eleman_Sayisini_Yazdirma(),
							null);
			data.Musteri_Menusu.addTab(null, null,
					getKategori_Agaclarini_Dengeleme(), null);
			data.Musteri_Menusu
					.addTab(
							null,
							null,
							getVerilen_Bir_Hastaliga_Iliskin_Bilgilerin_Listelenmesi_Hash_Table_Dan(),
							null);
			data.Musteri_Menusu
					.addTab(
							null,
							null,
							getBelli_Bir_Hastaliga_Iyi_Gelebilen_Bitkilerin_Fiyatlarina_Gore_Heap_e_Atilmasi_ve_N_Tanesinden_Birer_Paket_Satin_Alinmasi(),
							null);
		}
		return data.Musteri_Menusu;
	}

	private JPanel getJPanel2() {
		if (data.jPanel2 == null) {
			data.jLabel2 = new JLabel();
			data.jLabel2.setBounds(new Rectangle(0, 0, 974, 16));
			data.jLabel2.setText("Adindan Urun Arama ve Bilgilerini Listeleme");
			data.jPanel2 = new JPanel();
			data.jPanel2.setLayout(null);
			data.jPanel2.add(data.jLabel2, null);
			data.jPanel2.add(getAdindan_Urun_Arama_ve_Listeleme(), null);
		}
		return data.jPanel2;
	}

	private JPanel getBelirli_Fiyatlar_Arasindaki_Tum_Turlerin_Bulunup_Listelenmesi() {
		if (data.Belirli_Fiyatlar_Arasindaki_Tum_Turlerin_Bulunup_Listelenmesi == null) {
			data.jLabel48 = new JLabel();
			data.jLabel48.setBounds(new Rectangle(330, 17, 166, 16));
			data.jLabel48.setText("Maxsimum Fiyati Giriniz");
			data.jLabel47 = new JLabel();
			data.jLabel47.setBounds(new Rectangle(-2, 17, 168, 16));
			data.jLabel47.setText("Minimum Fiyati Giriniz");
			data.jLabel3 = new JLabel();
			data.jLabel3.setBounds(new Rectangle(0, 1, 495, 16));
			data.jLabel3
					.setText("Belirli Fiyatlar Arasýndaki Tum Urunlerin Bulunup Listelenmesi");
			data.Belirli_Fiyatlar_Arasindaki_Tum_Turlerin_Bulunup_Listelenmesi = new JPanel();
			data.Belirli_Fiyatlar_Arasindaki_Tum_Turlerin_Bulunup_Listelenmesi
					.setLayout(null);
			data.Belirli_Fiyatlar_Arasindaki_Tum_Turlerin_Bulunup_Listelenmesi.add(
					data.jLabel3, null);
			data.Belirli_Fiyatlar_Arasindaki_Tum_Turlerin_Bulunup_Listelenmesi.add(
					data.jLabel47, null);
			data.Belirli_Fiyatlar_Arasindaki_Tum_Turlerin_Bulunup_Listelenmesi.add(
					data.jLabel48, null);
			data.Belirli_Fiyatlar_Arasindaki_Tum_Turlerin_Bulunup_Listelenmesi.add(
					getJTextField11(), null);
			data.Belirli_Fiyatlar_Arasindaki_Tum_Turlerin_Bulunup_Listelenmesi.add(
					getJTextField16(), null);
			data.Belirli_Fiyatlar_Arasindaki_Tum_Turlerin_Bulunup_Listelenmesi.add(
					getJButton13(), null);
			data.Belirli_Fiyatlar_Arasindaki_Tum_Turlerin_Bulunup_Listelenmesi.add(
					getJTextArea15(), null);
		}
		return data.Belirli_Fiyatlar_Arasindaki_Tum_Turlerin_Bulunup_Listelenmesi;
	}

	private JPanel getVerilen_Bir_Kelimenin_Kategori_Agaclarinda_Tutulan_Bitkilerin_Ozellikleri_Icinden_Aratilmasi_Bulunan_Bitki_Isimlerinin_Listelenmesi() {
		if (data.Verilen_Bir_Kelimenin_Kategori_Agaclarinda_Tutulan_Bitkilerin_Ozellikleri_Icinden_Aratilmasi_Bulunan_Bitki_Isimlerinin_Listelenmesi == null) {
			data.jLabel4 = new JLabel();
			data.jLabel4.setBounds(new Rectangle(0, 2, 779, 16));
			data.jLabel4
					.setText("Verilen Bir Kelimenin Kategori Aðaçlarýnda Tutulan Bitkilerin Özellikleri Ýçinden Aratýlmasý,Bulunan Bitki Ýsimlerinin Listelenmesi");
			data.Verilen_Bir_Kelimenin_Kategori_Agaclarinda_Tutulan_Bitkilerin_Ozellikleri_Icinden_Aratilmasi_Bulunan_Bitki_Isimlerinin_Listelenmesi = new JPanel();
			data.Verilen_Bir_Kelimenin_Kategori_Agaclarinda_Tutulan_Bitkilerin_Ozellikleri_Icinden_Aratilmasi_Bulunan_Bitki_Isimlerinin_Listelenmesi
					.setLayout(null);
			data.Verilen_Bir_Kelimenin_Kategori_Agaclarinda_Tutulan_Bitkilerin_Ozellikleri_Icinden_Aratilmasi_Bulunan_Bitki_Isimlerinin_Listelenmesi
					.add(data.jLabel4, null);
		}
		return data.Verilen_Bir_Kelimenin_Kategori_Agaclarinda_Tutulan_Bitkilerin_Ozellikleri_Icinden_Aratilmasi_Bulunan_Bitki_Isimlerinin_Listelenmesi;
	}

	private JPanel getUrun_Siparisi_Birden_Cok_Paket_Istenebilir_ve_Alimi() {
		if (data.Urun_Siparisi_Birden_Cok_Paket_Istenebilir_ve_Alimi == null) {
			data.jLabel5 = new JLabel();
			data.jLabel5.setBounds(new Rectangle(0, 2, 779, 16));
			data.jLabel5
					.setText("Ürün Sipariþi (Birden Çok Paket Ýstenebilir )ve Alýmý");
			data.Urun_Siparisi_Birden_Cok_Paket_Istenebilir_ve_Alimi = new JPanel();
			data.Urun_Siparisi_Birden_Cok_Paket_Istenebilir_ve_Alimi.setLayout(null);
			data.Urun_Siparisi_Birden_Cok_Paket_Istenebilir_ve_Alimi.add(data.jLabel5,
					null);
		}
		return data.Urun_Siparisi_Birden_Cok_Paket_Istenebilir_ve_Alimi;
	}

	private JTabbedPane getPersonel_Menusu() {
		if (data.Personel_Menusu == null) {
			data.Personel_Menusu = new JTabbedPane();
			data.Personel_Menusu.setBounds(new Rectangle(0, 16, 979, 590));
			data.Personel_Menusu.addTab(null, null, Kategori_Ekleme_ve_Kategori_Silme(), null);
			data.Personel_Menusu.addTab(null, null,
					getFirmaya_Yeni_Türde_Ürün_Giriþi(), null);
			data.Personel_Menusu.addTab(null, null,
					getAdýndan_Ürün_Arama_ve_Silme(), null);
			data.Personel_Menusu.addTab(null, null,
					getÜrün_Bilgilerinde_Deðiþiklik(), null);
			data.Personel_Menusu.addTab(null, null,
					getYeni_Hastalýk_Bilgisi_Giriþi(), null);
		}
		return data.Personel_Menusu;
	}

	private JPanel Kategori_Ekleme_ve_Kategori_Silme() {
		if (data.jPanel6 == null) {
			data.jLabel12 = new JLabel();
			data.jLabel12.setBounds(new Rectangle(0, 0, 779, 16));
			data.jLabel12.setText("Kategori Ekleme ve Kategori Silme");
			data.jPanel6 = new JPanel();
			data.jPanel6.setLayout(null);
			data.jPanel6.add(data.jLabel12, null);
			data.jPanel6.add(getKategori_Ekleme_ve_Silme_Menüsü(), null);
		}
		return data.jPanel6;
	}

	private JPanel getFirmaya_Yeni_Türde_Ürün_Giriþi() {
		if (data.Firmaya_Yeni_Turde_Urun_Girisi == null) {
			data.jLabel49 = new JLabel();
			data.jLabel49.setBounds(new Rectangle(241, 16, 316, 16));
			data.jLabel49
					.setText("Eklenmek Ýstenen Ürün Aðaç Kategorilerinde Var Mý?");
			data.jLabel46 = new JLabel();
			data.jLabel46.setBounds(new Rectangle(1, 16, 241, 16));
			data.jLabel46.setText("Eklemek Ýstediðiniz Ürünün Adýný Giriniz");
			data.jLabel15 = new JLabel();
			data.jLabel15.setBounds(new Rectangle(0, 0, 778, 16));
			data.jLabel15.setText("Firmaya Yeni Türde Ürün Giriþi");
			data.Firmaya_Yeni_Turde_Urun_Girisi = new JPanel();
			data.Firmaya_Yeni_Turde_Urun_Girisi.setLayout(null);
			data.Firmaya_Yeni_Turde_Urun_Girisi.add(data.jLabel15, null);
			data.Firmaya_Yeni_Turde_Urun_Girisi.add(getGecici_metin_kutusu(), null);
			data.Firmaya_Yeni_Turde_Urun_Girisi.add(data.jLabel46, null);
			data.Firmaya_Yeni_Turde_Urun_Girisi.add(getJTextField17(), null);
			data.Firmaya_Yeni_Turde_Urun_Girisi.add(data.jLabel49, null);
			data.Firmaya_Yeni_Turde_Urun_Girisi.add(getJTextField18(), null);
			data.Firmaya_Yeni_Turde_Urun_Girisi.add(getJButton19(), null);
		}
		return data.Firmaya_Yeni_Turde_Urun_Girisi;
	}

	private JPanel getAdýndan_Ürün_Arama_ve_Silme() {
		if (data.Adindan_Urun_Arama_ve_Silme == null) {
			data.jLabel33 = new JLabel();
			data.jLabel33.setBounds(new Rectangle(-1, 72, 112, 16));
			data.jLabel33.setText("Ürün Bilgisi");
			data.jLabel20 = new JLabel();
			data.jLabel20.setBounds(new Rectangle(300, 16, 300, 16));
			data.jLabel20.setText("Aranan Ürün Var Mý?");
			data.jLabel19 = new JLabel();
			data.jLabel19.setBounds(new Rectangle(0, 16, 300, 16));
			data.jLabel19.setText("Aranan Ürünün Adýný Giriniz");
			data.jLabel16 = new JLabel();
			data.jLabel16.setBounds(new Rectangle(0, 0, 778, 16));
			data.jLabel16.setText("Adýndan Ürün Bilgisi Arama ve Silme");
			data.Adindan_Urun_Arama_ve_Silme = new JPanel();
			data.Adindan_Urun_Arama_ve_Silme.setLayout(null);
			data.Adindan_Urun_Arama_ve_Silme.add(data.jLabel16, null);
			data.Adindan_Urun_Arama_ve_Silme.add(data.jLabel19, null);
			data.Adindan_Urun_Arama_ve_Silme.add(getJTextField7(), null);
			data.Adindan_Urun_Arama_ve_Silme.add(getJButton10(), null);
			data.Adindan_Urun_Arama_ve_Silme.add(data.jLabel20, null);
			data.Adindan_Urun_Arama_ve_Silme.add(getJTextField8(), null);
			data.Adindan_Urun_Arama_ve_Silme.add(getJButton11(), null);
			data.Adindan_Urun_Arama_ve_Silme.add(data.jLabel33, null);
			data.Adindan_Urun_Arama_ve_Silme
					.add(getUrun_Bilgisi_Listeleyici(), null);
			data.Adindan_Urun_Arama_ve_Silme.add(getJTextArea8(), null);
		}
		return data.Adindan_Urun_Arama_ve_Silme;
	}

	private JPanel getÜrün_Bilgilerinde_Deðiþiklik() {
		if (data.Urun_Bilgilerinde_Degisiklik == null) {
			data.jLabel17 = new JLabel();
			data.jLabel17.setBounds(new Rectangle(0, 0, 775, 16));
			data.jLabel17.setText("Ürün Bilgilerinde Deðiþiklik");
			data.Urun_Bilgilerinde_Degisiklik = new JPanel();
			data.Urun_Bilgilerinde_Degisiklik.setLayout(null);
			data.Urun_Bilgilerinde_Degisiklik.add(data.jLabel17, null);
			data.Urun_Bilgilerinde_Degisiklik.add(getJTextArea(), null);
		}
		return data.Urun_Bilgilerinde_Degisiklik;
	}

	private JPanel getYeni_Hastalýk_Bilgisi_Giriþi() {
		if (data.Yeni_Hastalik_Bilgisi_Girisi == null) {
			data.jLabel45 = new JLabel();
			data.jLabel45.setBounds(new Rectangle(4, 448, 220, 23));
			data.jLabel45.setText("Kaydetme Bilgisi");
			data.jLabel36 = new JLabel();
			data.jLabel36.setBounds(new Rectangle(0, 427, 225, 16));
			data.jLabel36.setText("Bilgileri Kaydetmek Ýstiyor Musunuz?");
			data.jLabel44 = new JLabel();
			data.jLabel44.setBounds(new Rectangle(468, 313, 318, 16));
			data.jLabel44.setText("Tavsiye Edilen Bitkiler");
			data.jLabel43 = new JLabel();
			data.jLabel43.setBounds(new Rectangle(1, 213, 224, 16));
			data.jLabel43.setText("Tedavi Yöntemi");
			data.jLabel42 = new JLabel();
			data.jLabel42.setBounds(new Rectangle(470, 163, 314, 16));
			data.jLabel42.setText("Nedenler");
			data.jLabel41 = new JLabel();
			data.jLabel41.setBounds(new Rectangle(471, 17, 314, 16));
			data.jLabel41.setText("Belirtiler");
			data.jLabel40 = new JLabel();
			data.jLabel40.setBounds(new Rectangle(0, 179, 222, 16));
			data.jLabel40.setText("Önerilen Bitkileri Ekleme Yeri");
			data.jLabel39 = new JLabel();
			data.jLabel39.setBounds(new Rectangle(-1, 144, 222, 16));
			data.jLabel39.setText("Tedavileri Ekleme Yeri");
			data.jLabel38 = new JLabel();
			data.jLabel38.setBounds(new Rectangle(1, 109, 220, 16));
			data.jLabel38.setText("Nedenleri Ekleme Yeri");
			data.jLabel37 = new JLabel();
			data.jLabel37.setBounds(new Rectangle(1, 72, 222, 16));
			data.jLabel37.setText("Belirtileri Ekleme Yeri");
			data.jLabel35 = new JLabel();
			data.jLabel35.setBounds(new Rectangle(226, 15, 240, 16));
			data.jLabel35.setText("Hastalýk Veri Tabanýnda Var Mý?");
			data.jLabel31 = new JLabel();
			data.jLabel31.setBounds(new Rectangle(0, 16, 227, 16));
			data.jLabel31.setText("Hastalýk Adýný Giriniz");
			data.jLabel18 = new JLabel();
			data.jLabel18.setBounds(new Rectangle(0, 0, 780, 16));
			data.jLabel18.setText("Yeni Hastalýk Bilgisi Giriþi");
			data.Yeni_Hastalik_Bilgisi_Girisi = new JPanel();
			data.Yeni_Hastalik_Bilgisi_Girisi.setLayout(null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(data.jLabel18, null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(data.jLabel31, null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(getJTextField4(), null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(getJButton7(), null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(data.jLabel35, null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(getJTextField10(), null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(data.jLabel37, null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(getJTextField12(), null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(getJButton14(), null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(data.jLabel38, null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(getJTextField13(), null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(getJButton15(), null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(data.jLabel39, null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(getJTextField14(), null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(getJButton16(), null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(data.jLabel40, null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(getJButton17(), null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(getJTextField15(), null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(getJTextArea10(), null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(data.jLabel41, null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(data.jLabel42, null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(getJTextArea11(), null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(data.jLabel43, null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(getJTextArea12(), null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(data.jLabel44, null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(getJTextArea13(), null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(getJButton18(), null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(data.jLabel36, null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(getJTextArea14(), null);
			data.Yeni_Hastalik_Bilgisi_Girisi.add(data.jLabel45, null);
		}
		return data.Yeni_Hastalik_Bilgisi_Girisi;
	}

	private JPanel getKategori_Listeleme_Agac_Derinligi_ve_Eleman_Sayisini_Yazdirma() {
		if (data.Kategori_Listeleme_Agac_Derinligi_ve_Eleman_Sayisini_Yazdirma == null) {
			data.jLabel10 = new JLabel();
			data.jLabel10.setBounds(new Rectangle(0, 16, 783, 16));
			data.jLabel10
					.setText(" Ýlgili Aðacýn Derinliðini ve Eleman Sayýsýný Yazdýrma");
			data.jLabel6 = new JLabel();
			data.jLabel6.setBounds(new Rectangle(1, 2, 778, 16));
			data.jLabel6
					.setText("Belirtilen Bir Kategorideki Tüm Ürünleri Düzeyleri Ýle Birlikte Listeleme(Inorder,Preorder,Postorder).");
			data.Kategori_Listeleme_Agac_Derinligi_ve_Eleman_Sayisini_Yazdirma = new JPanel();
			data.Kategori_Listeleme_Agac_Derinligi_ve_Eleman_Sayisini_Yazdirma
					.setLayout(null);
			data.Kategori_Listeleme_Agac_Derinligi_ve_Eleman_Sayisini_Yazdirma.add(
					data.jLabel6, null);
			data.Kategori_Listeleme_Agac_Derinligi_ve_Eleman_Sayisini_Yazdirma.add(
					data.jLabel10, null);
			data.Kategori_Listeleme_Agac_Derinligi_ve_Eleman_Sayisini_Yazdirma.add(
					getJTabbedPane3(), null);
		}
		return data.Kategori_Listeleme_Agac_Derinligi_ve_Eleman_Sayisini_Yazdirma;
	}

	private JPanel getKategori_Agaclarini_Dengeleme() {
		if (data.Kategori_Agaclarini_Dengeleme == null) {
			data.jLabel7 = new JLabel();
			data.jLabel7.setBounds(new Rectangle(2, 1, 778, 16));
			data.jLabel7.setText("Kategori Aðaçlarýný Dengeleme");
			data.Kategori_Agaclarini_Dengeleme = new JPanel();
			data.Kategori_Agaclarini_Dengeleme.setLayout(null);
			data.Kategori_Agaclarini_Dengeleme.add(data.jLabel7, null);
		}
		return data.Kategori_Agaclarini_Dengeleme;
	}

	private JPanel getVerilen_Bir_Hastaliga_Iliskin_Bilgilerin_Listelenmesi_Hash_Table_Dan() {
		if (data.Verilen_Bir_Hastaliga_Iliskin_Bilgilerin_Listelenmesi_Hash_Table_Dan == null) {
			data.jLabel34 = new JLabel();
			data.jLabel34.setBounds(new Rectangle(0, 16, 260, 16));
			data.jLabel34.setText("Aranan Hastalýðýn Adýný Giriniz");
			data.jLabel8 = new JLabel();
			data.jLabel8.setBounds(new Rectangle(0, 0, 783, 16));
			data.jLabel8
					.setText("Verilen Bir Hastalýða Ýliþkin Bilgilerin Listelenmesi (Hash Table'dan)");
			data.Verilen_Bir_Hastaliga_Iliskin_Bilgilerin_Listelenmesi_Hash_Table_Dan = new JPanel();
			data.Verilen_Bir_Hastaliga_Iliskin_Bilgilerin_Listelenmesi_Hash_Table_Dan
					.setLayout(null);
			data.Verilen_Bir_Hastaliga_Iliskin_Bilgilerin_Listelenmesi_Hash_Table_Dan
					.add(data.jLabel8, null);
			data.Verilen_Bir_Hastaliga_Iliskin_Bilgilerin_Listelenmesi_Hash_Table_Dan
					.add(getJTextField9(), null);
			data.Verilen_Bir_Hastaliga_Iliskin_Bilgilerin_Listelenmesi_Hash_Table_Dan
					.add(data.jLabel34, null);
			data.Verilen_Bir_Hastaliga_Iliskin_Bilgilerin_Listelenmesi_Hash_Table_Dan
					.add(getJButton12(), null);
			data.Verilen_Bir_Hastaliga_Iliskin_Bilgilerin_Listelenmesi_Hash_Table_Dan
					.add(getJTextArea9(), null);
		}
		return data.Verilen_Bir_Hastaliga_Iliskin_Bilgilerin_Listelenmesi_Hash_Table_Dan;
	}

	private JPanel getBelli_Bir_Hastaliga_Iyi_Gelebilen_Bitkilerin_Fiyatlarina_Gore_Heap_e_Atilmasi_ve_N_Tanesinden_Birer_Paket_Satin_Alinmasi() {
		if (data.Belli_Bir_Hastaliga_Iyi_Gelebilen_Bitkilerin_Fiyatlarina_Gore_Heap_e_Atilmasi_ve_N_Tanesinden_Birer_Paket_Satin_Alinmasi == null) {
			data.jLabel11 = new JLabel();
			data.jLabel11.setBounds(new Rectangle(0, 16, 784, 16));
			data.jLabel11.setText("En Ucuz N Tanesinden 1'er Paket Satýn Alýnmasý");
			data.jLabel9 = new JLabel();
			data.jLabel9.setBounds(new Rectangle(0, 1, 780, 16));
			data.jLabel9
					.setText("Belli Bir Hastalýða Ýyi Gelebilen Bitkilerin Fiyatlarýna Göre Heap'e Atýlmasý");
			data.Belli_Bir_Hastaliga_Iyi_Gelebilen_Bitkilerin_Fiyatlarina_Gore_Heap_e_Atilmasi_ve_N_Tanesinden_Birer_Paket_Satin_Alinmasi = new JPanel();
			data.Belli_Bir_Hastaliga_Iyi_Gelebilen_Bitkilerin_Fiyatlarina_Gore_Heap_e_Atilmasi_ve_N_Tanesinden_Birer_Paket_Satin_Alinmasi
					.setLayout(null);
			data.Belli_Bir_Hastaliga_Iyi_Gelebilen_Bitkilerin_Fiyatlarina_Gore_Heap_e_Atilmasi_ve_N_Tanesinden_Birer_Paket_Satin_Alinmasi
					.add(data.jLabel9, null);
			data.Belli_Bir_Hastaliga_Iyi_Gelebilen_Bitkilerin_Fiyatlarina_Gore_Heap_e_Atilmasi_ve_N_Tanesinden_Birer_Paket_Satin_Alinmasi
					.add(data.jLabel11, null);
		}
		return data.Belli_Bir_Hastaliga_Iyi_Gelebilen_Bitkilerin_Fiyatlarina_Gore_Heap_e_Atilmasi_ve_N_Tanesinden_Birer_Paket_Satin_Alinmasi;
	}

	private JTabbedPane getJTabbedPane3() {
		if (data.jTabbedPane3 == null) {
			data.jTabbedPane3 = new JTabbedPane();
			data.jTabbedPane3.setBounds(new Rectangle(-1, 31, 972, 531));
			data.jTabbedPane3.addTab(null, null, Ürünleri_Düzeyleri_Ýle_Birlikte_Listeleme(), null);
		}
		return data.jTabbedPane3;
	}

	private JPanel Ürünleri_Düzeyleri_Ýle_Birlikte_Listeleme() {
		if (data.jPanel16 == null) {
			data.jLabel50 = new JLabel();
			data.jLabel50.setBounds(new Rectangle(819, 37, 144, 16));
			data.jLabel50.setText("Eleman Sayýsý");
			data.jLabel27 = new JLabel();
			data.jLabel27.setBounds(new Rectangle(819, 3, 143, 16));
			data.jLabel27.setText("Aðacýn Derinliði");
			data.jLabel26 = new JLabel();
			data.jLabel26.setBounds(new Rectangle(405, 32, 410, 16));
			data.jLabel26.setText("Kategori Var Mý?");
			data.jLabel25 = new JLabel();
			data.jLabel25.setBounds(new Rectangle(0, 16, 777, 16));
			data.jLabel25
					.setText("Lütfen Listelemek Ýstediðiniz Kategoriyi Belirtiniz");
			data.jLabel61 = new JLabel();
			data.jLabel61.setBounds(new Rectangle(1, 1, 776, 16));
			data.jLabel61
					.setText("Belirtilen Bir Kategorideki Tüm Ürünleri Düzeyleri Ýle Birlikte Listeleme(Inorder,Preorder,Postorder).");
			data.jPanel16 = new JPanel();
			data.jPanel16.setLayout(null);
			data.jPanel16.add(data.jLabel61, null);
			data.jPanel16.add(getJTabbedPane6(), null);
			data.jPanel16.add(data.jLabel25, null);
			data.jPanel16.add(getJTextField1(), null);
			data.jPanel16.add(Derinlik_Bul(), null);
			data.jPanel16.add(Uyari(), null);
			data.jPanel16.add(data.jLabel26, null);
			data.jPanel16.add(data.jLabel27, null);
			data.jPanel16.add(getJTextField19(), null);
			data.jPanel16.add(data.jLabel50, null);
			data.jPanel16.add(getJTextField20(), null);
		}
		return data.jPanel16;
	}

	private JTabbedPane getKategori_Ekleme_ve_Silme_Menüsü() {
		if (data.Kategori_Ekleme_ve_Silme_Menusu == null) {
			data.Kategori_Ekleme_ve_Silme_Menusu = new JTabbedPane();
			data.Kategori_Ekleme_ve_Silme_Menusu.setBounds(new Rectangle(0, 16, 973,
					555));
			data.Kategori_Ekleme_ve_Silme_Menusu.addTab(null, null,
					getKategori_Ekleme(), null);
			data.Kategori_Ekleme_ve_Silme_Menusu.addTab(null, null,
					getKategori_Silme(), null);
		}
		return data.Kategori_Ekleme_ve_Silme_Menusu;
	}

	private JPanel getKategori_Ekleme() {
		if (data.Kategori_Ekleme == null) {
			data.jLabel29 = new JLabel();
			data.jLabel29.setBounds(new Rectangle(290, 16, 283, 16));
			data.jLabel29.setText("Kategori Var Mý?");
			data.jLabel28 = new JLabel();
			data.jLabel28.setBounds(new Rectangle(0, 16, 291, 16));
			data.jLabel28
					.setText("Lütfen Eklemek Ýstediðiniz Kategori Ýsmini Giriniz");
			data.jLabel13 = new JLabel();
			data.jLabel13.setBounds(new Rectangle(0, 0, 771, 16));
			data.jLabel13.setText("Kategori Ekleme");
			data.Kategori_Ekleme = new JPanel();
			data.Kategori_Ekleme.setLayout(null);
			data.Kategori_Ekleme.add(data.jLabel13, null);
			data.Kategori_Ekleme.add(data.jLabel28, null);
			data.Kategori_Ekleme.add(getJTextField2(), null);
			data.Kategori_Ekleme.add(data.jLabel29, null);
			data.Kategori_Ekleme.add(getJTextField3(), null);
			data.Kategori_Ekleme.add(Kategori_Listele(), null);
			data.Kategori_Ekleme.add(getJButton6(), null);
			data.Kategori_Ekleme.add(getJLabel30(), null);
			data.Kategori_Ekleme.add(getJTextArea4(), null);
			data.Kategori_Ekleme.add(getKategori_Listeleyici(), null);
		}
		return data.Kategori_Ekleme;
	}

	private JPanel getKategori_Silme() {
		if (data.Kategori_Silme == null) {
			data.jLabel32 = new JLabel();
			data.jLabel32.setBounds(new Rectangle(0, 72, 111, 16));
			data.jLabel32.setText("Kategori Listesi");
			data.jLabel1 = new JLabel();
			data.jLabel1.setBounds(new Rectangle(252, 16, 240, 16));
			data.jLabel1.setText("Kategori Var Mý?");
			data.jLabel = new JLabel();
			data.jLabel.setBounds(new Rectangle(0, 16, 252, 16));
			data.jLabel.setText("Silmek Ýstediðiniz Kategorinin Adýný Giriniz");
			data.jLabel14 = new JLabel();
			data.jLabel14.setBounds(new Rectangle(0, 0, 771, 16));
			data.jLabel14.setText("Kategori Silme");
			data.Kategori_Silme = new JPanel();
			data.Kategori_Silme.setLayout(null);
			data.Kategori_Silme.add(data.jLabel14, null);
			data.Kategori_Silme.add(data.jLabel, null);
			data.Kategori_Silme.add(getJTextField5(), null);
			data.Kategori_Silme.add(data.jLabel1, null);
			data.Kategori_Silme.add(getJTextField6(), null);
			data.Kategori_Silme.add(getJButton8(), null);
			data.Kategori_Silme.add(getJButton9(), null);
			data.Kategori_Silme.add(data.jLabel32, null);
			data.Kategori_Silme.add(getKategori_Listeleyici_2(), null);
			data.Kategori_Silme.add(getJTextArea7(), null);
		}
		return data.Kategori_Silme;
	}

	private JTextArea getJTextArea() {
		if (data.jTextArea == null) {
			data.jTextArea = new JTextArea();
			data.jTextArea.setBounds(new Rectangle(0, 16, 776, 181));
			data.jTextArea
					.setText("Bitkiye Ýliþkin Bilgiler:\nBitki Adý,\nKategori,\nBitkinin Latince Ýsmi,\nBitkinin Özellikleri,\nMiktarý,\nFiyatý,\nBitki Resminin Diskteki Yeri\nBitki Ýsminin Diskteki Adý,\nÖnerilen Hastalýklar\nVectore ekleme yapýlacak þekilde ayarlanmalý");
		}
		return data.jTextArea;
	}

	private JPanel getAdindan_Urun_Arama_ve_Listeleme() {
		if (data.Adindan_Urun_Arama_ve_Listeleme == null) {
			data.Adindan_Urun_Arama_ve_Listeleme = new JPanel();
			data.Adindan_Urun_Arama_ve_Listeleme.setLayout(null);
			data.Adindan_Urun_Arama_ve_Listeleme.setBounds(new Rectangle(0, 16, 971,
					550));
			data.Adindan_Urun_Arama_ve_Listeleme.add(Urun_Arama(), null);
			data.Adindan_Urun_Arama_ve_Listeleme.add(getJTextArea1(), null);
		}
		return data.Adindan_Urun_Arama_ve_Listeleme;
	}

	private JPanel Urun_Arama() {
		if (data.jPanel23 == null) {
			data.jLabel21 = new JLabel();
			data.jLabel21.setBounds(new Rectangle(0, 0, 249, 16));
			data.jLabel21.setText("Aranan Ürünün Adýný Giriniz:");
			data.jPanel23 = new JPanel();
			data.jPanel23.setLayout(null);
			data.jPanel23.setBounds(new Rectangle(0, 0, 251, 64));
			data.jPanel23.add(data.jLabel21, null);
			data.jPanel23.add(getJTextField(), null);
			data.jPanel23.add(Urun_Listele(), null);
		}
		return data.jPanel23;
	}

	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(0, 16, 249, 16));
			jTextField.setText("");
		}
		return jTextField;
	}

	private JTextArea getJTextArea1() {
		if (data.jTextArea1 == null) {
			data.jTextArea1 = new JTextArea();
			data.jTextArea1.setBounds(new Rectangle(0, 65, 965, 450));
			data.jTextArea1.setText("");
		}
		return data.jTextArea1;
	}

	private static String aranan_ürünün_bilgilerini_listele(String aranan_ürün) {
		String yanit = "";

		for (int i = 0; i < getAgac_vektoru().getAgaclar().size(); i++) {
			yanit = getAgac_vektoru().getAgaclar().elementAt(i).find(
					getAgac_vektoru().getAgaclar().elementAt(i).getNode(),
					aranan_ürün);
			if (yanit.compareTo("Bulunamadý") != 0) {
				break;
			}
		}
		return yanit;
	}

	private JButton Urun_Listele() {
		if (data.jButton == null) {
			data.jButton = new JButton();
			data.jButton.setBounds(new Rectangle(2, 31, 246, 33));
			data.jButton.setText("Aranan Ürünün Bilgilerini Listele");
			data.jButton.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					data.jTextArea1
							.setText(aranan_ürünün_bilgilerini_listele(jTextField
									.getText()));
					System.out.println("Aranan Ürün Bilgileri Listelendi");
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
		return data.jButton;
	}

	/**
	 * @param args
	 */
	private static Kategori_veri_tabani kategori_veri_tabani;
	private static Bitki_veri_tabani bitki_veri_tabani;
	private static Vector_Agac agac_vektoru;
	private JTabbedPane getJTabbedPane6() {
		if (data.jTabbedPane6 == null) {
			data.jTabbedPane6 = new JTabbedPane();
			data.jTabbedPane6.setBounds(new Rectangle(0, 71, 963, 432));
			data.jTabbedPane6.addTab(null, null, getJPanel11(), null);
			data.jTabbedPane6.addTab(null, null, getJPanel24(), null);
			data.jTabbedPane6.addTab(null, null, getJPanel25(), null);
		}
		return data.jTabbedPane6;
	}

	private JPanel getJPanel11() {
		if (data.jPanel11 == null) {
			data.jLabel22 = new JLabel();
			data.jLabel22.setBounds(new Rectangle(0, 0, 59, 16));
			data.jLabel22.setText("Inorder");
			data.jPanel11 = new JPanel();
			data.jPanel11.setLayout(null);
			data.jPanel11.add(data.jLabel22, null);
			data.jPanel11.add(inOrder_yazdir(), null);
			data.jPanel11.add(getJTextArea2(), null);
		}
		return data.jPanel11;
	}

	private JPanel getJPanel24() {
		if (data.jPanel24 == null) {
			data.jLabel23 = new JLabel();
			data.jLabel23.setBounds(new Rectangle(0, 0, 64, 16));
			data.jLabel23.setText("Preorder");
			data.jPanel24 = new JPanel();
			data.jPanel24.setLayout(null);
			data.jPanel24.add(data.jLabel23, null);
			data.jPanel24.add(getJScrollPane1(), null);
			data.jPanel24.add(preOrder_yazdir(), null);
		}
		return data.jPanel24;
	}

	private JPanel getJPanel25() {
		if (data.jPanel25 == null) {
			data.jLabel24 = new JLabel();
			data.jLabel24.setBounds(new Rectangle(0, 0, 76, 16));
			data.jLabel24.setText("Postorder");
			data.jPanel25 = new JPanel();
			data.jPanel25.setLayout(null);
			data.jPanel25.add(data.jLabel24, null);
			data.jPanel25.add(postOrder_yazdir(), null);
			data.jPanel25.add(getJTextArea6(), null);
		}
		return data.jPanel25;
	}

	private JScrollPane getJScrollPane1() {
		if (data.jScrollPane1 == null) {
			data.jScrollPane1 = new JScrollPane();
			data.jScrollPane1.setBounds(new Rectangle(0, 16, 957, 445));
			data.jScrollPane1.setViewportView(getJTextArea3());
		}
		return data.jScrollPane1;
	}

	private JTextArea getJTextArea3() {
		if (data.jTextArea3 == null) {
			data.jTextArea3 = new JTextArea();
			data.jTextArea3.setText("");
		}
		return data.jTextArea3;
	}

	private JTextField getJTextField1() {
		if (data.jTextField1 == null) {
			data.jTextField1 = new JTextField();
			data.jTextField1.setBounds(new Rectangle(0, 32, 400, 20));
			data.jTextField1.setText("");
		}
		return data.jTextField1;
	}

	public static String kategori_var_mý(String aranan) {
		String yanit = getKategori_veri_tabani().kategoriyi_arastir(aranan);
		return yanit;
	}

	private JButton Derinlik_Bul() {
		if (data.jButton1 == null) {
			data.jButton1 = new JButton();
			data.jButton1.setBounds(new Rectangle(1, 50, 399, 21));
			data.jButton1.setText("Kategori Var Mý?");
			data.jButton1.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					data.yanit = kategori_var_mý(data.jTextField1.getText());
					data.jTextArea5.setText(data.yanit);
					if (data.yanit.compareTo("Bulunamadý") != 0) {
						int endex = getKategori_veri_tabani()
								.getAranan_kategori_kacinci_sirada_bulundu();
						getAgac_vektoru().getAgaclar().elementAt(endex);
						data.jTextField20.setText(""
								+ getAgac_vektoru().getAgaclar().elementAt(
										endex).node_sayýsý);
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
		return data.jButton1;
	}

	private JTextArea Uyari() {
		if (data.jTextArea5 == null) {
			data.jTextArea5 = new JTextArea();
			data.jTextArea5.setBounds(new Rectangle(407, 51, 408, 18));
			data.jTextArea5.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
		}
		return data.jTextArea5;
	}

	private JButton inOrder_yazdir() {
		if (data.jButton2 == null) {
			data.jButton2 = new JButton();
			data.jButton2.setBounds(new Rectangle(59, 1, 115, 15));
			data.jButton2.setText("Listele");
			data.jButton2.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					data.jButton2.setText("Týklandý zaten...");
					if (data.jTextArea5.getText().compareTo(
							"Ýlk Önce Arama Yapmanýz Gerekmektedir.") != 0
							&& data.jTextArea5.getText().compareTo(
									"Böyle Bir Kategori Bulunmamaktadýr") != 0) {
						int endex = getKategori_veri_tabani()
								.getAranan_kategori_kacinci_sirada_bulundu();
						getAgac_vektoru().getAgaclar().elementAt(endex)
								.setInorder(new Vector<String>());
						getAgac_vektoru().getAgaclar().elementAt(endex)
								.inOrder(
										getAgac_vektoru().getAgaclar()
												.elementAt(endex).getNode(), 0);
						data.jTextArea2.setText(getAgac_vektoru().getAgaclar()
								.elementAt(endex).inOrder_yazdir());
						// jTextArea2.setText(getAgac_vektoru().getAgaclar().elementAt(endex).preOrder_yazdir());
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
		return data.jButton2;
	}

	private JButton preOrder_yazdir() {
		if (data.jButton3 == null) {
			data.jButton3 = new JButton();
			data.jButton3.setBounds(new Rectangle(65, 1, 115, 15));
			data.jButton3.setText("Listele");
			data.jButton3.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					data.jButton3.setText("Týklandý zaten...");
					if (data.jTextArea5.getText().compareTo(
							"Ýlk Önce Arama Yapmanýz Gerekmektedir.") != 0
							&& data.jTextArea5.getText().compareTo(
									"Böyle Bir Kategori Bulunmamaktadýr") != 0) {
						int endex = getKategori_veri_tabani()
								.getAranan_kategori_kacinci_sirada_bulundu();
						getAgac_vektoru().getAgaclar().elementAt(endex)
								.setPreorder(new Vector<String>());
						getAgac_vektoru().getAgaclar().elementAt(endex)
								.preOrder(
										getAgac_vektoru().getAgaclar()
												.elementAt(endex).getNode(), 0);
						// jTextArea3.setText(getAgac_vektoru().getAgaclar().elementAt(endex).inOrder_yazdýr());
						data.jTextArea3.setText(getAgac_vektoru().getAgaclar()
								.elementAt(endex).preOrder_yazdir());
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
		return data.jButton3;
	}

	private JButton postOrder_yazdir() {
		if (data.jButton4 == null) {
			data.jButton4 = new JButton();
			data.jButton4.setBounds(new Rectangle(74, 1, 115, 15));
			data.jButton4.setText("Listele");
			data.jButton4.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					data.jButton4.setText("Týklandý zaten...");
					if (data.jTextArea5.getText().compareTo(
							"Ýlk Önce Arama Yapmanýz Gerekmektedir.") != 0
							&& data.jTextArea5.getText().compareTo(
									"Böyle Bir Kategori Bulunmamaktadýr") != 0) {

						int endex = getKategori_veri_tabani()
								.getAranan_kategori_kacinci_sirada_bulundu();
						getAgac_vektoru().getAgaclar().elementAt(endex)
								.setPostorder(new Vector<String>());
						getAgac_vektoru().getAgaclar().elementAt(endex)
								.postOrder(
										getAgac_vektoru().getAgaclar()
												.elementAt(endex).getNode(), 0);
						// jTextArea6.setText(getAgac_vektoru().getAgaclar().elementAt(endex).postOrder_yazdir());
						data.jTextArea6.setText(getAgac_vektoru().getAgaclar()
								.elementAt(endex).postOrder_yazdir());
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
		return data.jButton4;
	}

	private JTextArea getJTextArea2() {
		if (data.jTextArea2 == null) {
			data.jTextArea2 = new JTextArea();
			data.jTextArea2.setBounds(new Rectangle(0, 16, 953, 385));
			data.jTextArea2.setText("");
		}
		return data.jTextArea2;
	}

	private JTextArea getJTextArea6() {
		if (data.jTextArea6 == null) {
			data.jTextArea6 = new JTextArea();
			data.jTextArea6.setBounds(new Rectangle(0, 16, 953, 385));
			data.jTextArea6.setText("");
		}
		return data.jTextArea6;
	}

	private static Hash_Table hash_table; // @jve:decl-index=0:
	private static Hastalik_veri_tabani hastalik_veri_tabani;
	private static JTextField jTextField2 = null;
	private static JTextField jTextField3 = null;
	private static JTextField jTextField5 = null;
	private static JTextField jTextField7 = null;
	private static JTextArea jTextArea8 = null;
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(0, 32, 291, 20));
			jTextField2.setText("");
		}
		return jTextField2;
	}

	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setBounds(new Rectangle(290, 32, 284, 20));
			jTextField3.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
		}
		return jTextField3;
	}

	private JButton Kategori_Listele() {
		if (data.jButton5 == null) {
			data.jButton5 = new JButton();
			data.jButton5.setBounds(new Rectangle(2, 51, 288, 18));
			data.jButton5.setText("Kategori Var Mý?");
			data.jButton5.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					data.yanit = kategori_var_mý(jTextField2.getText());
					jTextField3.setText(data.yanit);
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
		return data.jButton5;
	}

	private JButton getJButton6() {
		if (data.jButton6 == null) {
			data.jButton6 = new JButton();
			data.jButton6.setBounds(new Rectangle(290, 51, 282, 18));
			data.jButton6.setText("Ekleme Yapmak Ýçin Týklayýnýz");
			jTextField3.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
			data.jButton6.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (jTextField3.getText().compareTo("Bulundu") != 0
							&& jTextField3.getText().compareTo(
									"Ýlk Önce Arama Yapmanýz Gerekmektedir.") != 0) {
						jTextField3
								.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
						kategori_ekle();
						jTextField2.setText("Ekleme Yapýldý");
					}
					data.jTextArea4.setText("Yenileniyor Lütfen Bekleyiniz");
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
		return data.jButton6;
	}

	public static void kategori_ekle() {
		int kategori_no = Kategori_veri_tabani.getKategoriler().size();
		String kategori_adi = jTextField2.getText();
		Kategori kategori = new Kategori(kategori_no, kategori_adi);
		getKategori_veri_tabani().add_kategori(kategori);
		getKategori_veri_tabani().update_file();
		System.out.println(Kategori_veri_tabani.getKategoriler().lastElement()
				.toString());
	}

	private JLabel getJLabel30() {
		if (data.jLabel30 == null) {
			data.jLabel30 = new JLabel();
			data.jLabel30.setText("Kategori Listesi");
			data.jLabel30.setBounds(new Rectangle(2, 70, 166, 16));
		}
		return data.jLabel30;
	}

	private JTextArea getJTextArea4() {
		if (data.jTextArea4 == null) {
			data.jTextArea4 = new JTextArea();
			data.jTextArea4.setBounds(new Rectangle(4, 87, 569, 430));
			data.jTextArea4.setText("");
		}
		return data.jTextArea4;
	}

	private JTextField getJTextField4() {
		if (data.jTextField4 == null) {
			data.jTextField4 = new JTextField();
			data.jTextField4.setBounds(new Rectangle(0, 32, 226, 20));
			data.jTextField4.setText("");
		}
		return data.jTextField4;
	}

	private JButton getJButton7() {
		if (data.jButton7 == null) {
			data.jButton7 = new JButton();
			data.jButton7.setBounds(new Rectangle(1, 52, 224, 20));
			data.jButton7.setText("Veri Tabanýnda Ara");
			data.jButton7.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Hastalik aranan;
					aranan = hash_table.getHash().get(data.jTextField4.getText());
					if (aranan == null) {
						data.jTextField10.setText("Bulunamadý");
						data.yanit = "";
					} else {
						data.jTextField10.setText("Bulundu");
						data.yanit = data.jTextField4.getText();
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
		return data.jButton7;
	}

	private JButton getKategori_Listeleyici() {
		if (data.Kategori_Listeleyici == null) {
			data.Kategori_Listeleyici = new JButton();
			data.Kategori_Listeleyici.setBounds(new Rectangle(166, 69, 152, 17));
			data.Kategori_Listeleyici.setText("Kategori Listeleyici");
			data.Kategori_Listeleyici
					.addMouseListener(new java.awt.event.MouseListener() {
						public void mouseClicked(java.awt.event.MouseEvent e) {
							data.jTextArea4.setText(Kategori_veri_tabani
									.getKategoriler().toString());
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
		return data.Kategori_Listeleyici;
	}

	private JTextField getJTextField5() {
		if (jTextField5 == null) {
			jTextField5 = new JTextField();
			jTextField5.setBounds(new Rectangle(0, 32, 251, 20));
			jTextField5.setText("");
		}
		return jTextField5;
	}

	private JTextField getJTextField6() {
		if (data.jTextField6 == null) {
			data.jTextField6 = new JTextField();
			data.jTextField6.setBounds(new Rectangle(250, 32, 243, 20));
			data.jTextField6.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
		}
		return data.jTextField6;
	}

	private JButton getJButton8() {
		if (data.jButton8 == null) {
			data.jButton8 = new JButton();
			data.jButton8.setBounds(new Rectangle(0, 52, 252, 20));
			data.jButton8.setText("Kategori Var Mý?");
			data.jButton8.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					data.yanit = kategori_var_mý(jTextField5.getText());
					data.jTextField6.setText(data.yanit);
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
		return data.jButton8;
	}

	private JButton getJButton9() {
		if (data.jButton9 == null) {
			data.jButton9 = new JButton();
			data.jButton9.setBounds(new Rectangle(252, 52, 241, 20));
			data.jButton9.setText("Kategoriyi Silmek Ýçin Týklayýnýz");
			data.jButton9.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (data.jTextField6.getText().compareTo("Bulundu") == 0) {
						data.jTextField6
								.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
						kategori_sil();
						jTextField5.setText("Kategori Silindi");
					}
					data.jTextArea7.setText("Yenileniyor Lütfen Bekleyiniz");
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
		return data.jButton9;
	}

	public static void kategori_sil() {
		getKategori_veri_tabani().kategoriyi_sil();
		getKategori_veri_tabani().update_file();
	}

	private JButton getKategori_Listeleyici_2() {
		if (data.Kategori_Listeleyici_2 == null) {
			data.Kategori_Listeleyici_2 = new JButton();
			data.Kategori_Listeleyici_2.setBounds(new Rectangle(109, 73, 143, 16));
			data.Kategori_Listeleyici_2.setText("Kategori Listeleyici");
			data.Kategori_Listeleyici_2
					.addMouseListener(new java.awt.event.MouseListener() {
						public void mouseClicked(java.awt.event.MouseEvent e) {
							data.jTextArea7.setText(Kategori_veri_tabani
									.getKategoriler().toString());
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
		return data.Kategori_Listeleyici_2;
	}

	private JTextArea getJTextArea7() {
		if (data.jTextArea7 == null) {
			data.jTextArea7 = new JTextArea();
			data.jTextArea7.setBounds(new Rectangle(0, 90, 965, 429));
		}
		return data.jTextArea7;
	}

	private JTextField getJTextField7() {
		if (jTextField7 == null) {
			jTextField7 = new JTextField();
			jTextField7.setBounds(new Rectangle(1, 32, 300, 20));
			jTextField7.setText("");
		}
		return jTextField7;
	}

	private JButton getJButton10() {
		if (data.jButton10 == null) {
			data.jButton10 = new JButton();
			data.jButton10.setBounds(new Rectangle(0, 51, 299, 21));
			data.jButton10.setText("Ürün Var Mý?");
			data.jButton10.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					// Ürünü Aðaçta Ara
					data.yanit = agac_kategorilerinde_ara(jTextField7.getText());
					if (data.yanit.compareTo("Bulunamadý") != 0) {
						data.jTextField8.setText("Bulundu");
					} else {
						data.jTextField8.setText(data.yanit);
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
		return data.jButton10;
	}

	public String agac_kategorilerinde_ara(String aranan_ürün) {
		String aranan_bitki = "";
		aranan_bitki = agac_vektoru.find(jTextField7.getText());
		return aranan_bitki;
	}

	private JTextField getJTextField8() {
		if (data.jTextField8 == null) {
			data.jTextField8 = new JTextField();
			data.jTextField8.setBounds(new Rectangle(299, 32, 301, 20));
			data.jTextField8.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir");
		}
		return data.jTextField8;
	}

	private JButton getJButton11() {
		if (data.jButton11 == null) {
			data.jButton11 = new JButton();
			data.jButton11.setBounds(new Rectangle(299, 51, 301, 20));
			data.jButton11.setText("Ürünü Silmek Ýçin Týklayýnýz");
			data.jButton11.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {

					if (data.jTextField8.getText().compareTo("Bulundu") == 0) {
						jTextArea8
								.setText("Veri Tabaný Yenileniyor.Lütfen Bekleyiniz");
						agac_vektorunden_kaldir();
						bitki_veri_tabanindan_kaldir();
						data.jTextField8
								.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir");
						jTextField7.setText("Silindi");
						/*
						 * yanit = " "; jTextArea8.setText(" ");// Silinen Ürün
						 * Bilgileri // Ekrandan // Siliniyor
						 */
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
		return data.jButton11;
	}

	public static void bitki_veri_tabanindan_kaldir() {
		getBitki_veri_tabani().remove(jTextField7.getText());
		getBitki_veri_tabani().update_file();
	}

	public static void agac_vektorunden_kaldir() {
		int urunun_bulundugu_kategorinin_nosu;
		urunun_bulundugu_kategorinin_nosu = agac_vektoru
				.getAranan_urun_hangi_kategoride_bulundu();
		boolean sonuç = agac_vektoru.getAgaclar().elementAt(
				urunun_bulundugu_kategorinin_nosu)
				.remove(jTextField7.getText());
		if (sonuç == true) {
			jTextArea8.setText("aðaç_vektöründen Ürün Silindi");
			System.out.println("aðaç_vektöründen Ürün Silindi");
		} else {
			jTextArea8.setText("aðaç_vektöründe Ürün Bulunamadý");
			System.out.println("aðaç_vektöründe Ürün Bulunamadý");
		}
	}

	private JButton getUrun_Bilgisi_Listeleyici() {
		if (data.Urun_Bilgisi_Listeleyici == null) {
			data.Urun_Bilgisi_Listeleyici = new JButton();
			data.Urun_Bilgisi_Listeleyici.setBounds(new Rectangle(110, 73, 193, 15));
			data.Urun_Bilgisi_Listeleyici.setText("Ürün Bilgisi Listeleyici");
			data.Urun_Bilgisi_Listeleyici
					.addMouseListener(new java.awt.event.MouseListener() {
						public void mouseClicked(java.awt.event.MouseEvent e) {
							jTextArea8.setText(data.yanit);
							System.out.println("yanit Listelendi");
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
		return data.Urun_Bilgisi_Listeleyici;
	}

	private JTextArea getJTextArea8() {
		if (jTextArea8 == null) {
			jTextArea8 = new JTextArea();
			jTextArea8.setBounds(new Rectangle(-2, 89, 970, 469));
		}
		return jTextArea8;
	}

	private JTextArea getGecici_metin_kutusu() {
		if (data.gecici_metin_kutusu == null) {
			data.gecici_metin_kutusu = new JTextArea();
			data.gecici_metin_kutusu.setBounds(new Rectangle(604, 58, 238, 150));
			data.gecici_metin_kutusu
					.setText("String adý\n, String kategori\n, String latince_adý\n, int miktarý\n,float fiyatý\n, String diskteki_yeri\n, String diskteki_adý\n,Vector<String> önerilen_hastalýklar\n, Vector<String> özellikleri");
		}
		return data.gecici_metin_kutusu;
	}

	private JTextField getJTextField9() {
		if (data.jTextField9 == null) {
			data.jTextField9 = new JTextField();
			data.jTextField9.setBounds(new Rectangle(0, 31, 262, 20));
			data.jTextField9.setText("");
		}
		return data.jTextField9;
	}

	private JButton getJButton12() {
		if (data.jButton12 == null) {
			data.jButton12 = new JButton();
			data.jButton12.setBounds(new Rectangle(0, 49, 262, 18));
			data.jButton12.setText("Aranan Hastalýðýn Bilgilerini Listele");
			data.jButton12.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					data.yanit = hash_table.getHash().get(data.jTextField9.getText())
							.toString();

					if (data.yanit != null) {
						data.jTextArea9.setText(data.yanit);
						System.out
								.println("Aranan Hastalýðýn Bilgileri Listelendi");
					} else {
						data.jTextArea9.setText("Bulunamadý");
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
		return data.jButton12;
	}

	private JTextArea getJTextArea9() {
		if (data.jTextArea9 == null) {
			data.jTextArea9 = new JTextArea();
			data.jTextArea9.setBounds(new Rectangle(1, 67, 972, 494));
			data.jTextArea9.setText("");
		}
		return data.jTextArea9;
	}

	private JTextField getJTextField10() {
		if (data.jTextField10 == null) {
			data.jTextField10 = new JTextField();
			data.jTextField10.setBounds(new Rectangle(223, 31, 244, 20));
			data.jTextField10.setText("");
		}
		return data.jTextField10;
	}

	private JTextField getJTextField12() {
		if (data.jTextField12 == null) {
			data.jTextField12 = new JTextField();
			data.jTextField12.setBounds(new Rectangle(1, 89, 465, 20));
			data.jTextField12.setText("");
		}
		return data.jTextField12;
	}

	public Herbalist_AppData data = new Herbalist_AppData(null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, "", null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, new Vector<String>(), new Vector<String>(),
			new Vector<String>(), new Vector<String>(), null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null);

	private JButton getJButton14() {
		if (data.jButton14 == null) {
			data.jButton14 = new JButton();
			data.jButton14.setBounds(new Rectangle(224, 67, 243, 22));
			data.jButton14.setText("Belirtiyi Eklemek için Týklayýnýz");
			data.jButton14.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (data.jTextField12.getText().compareTo("Eklendi") != 0)
						data.belirtiler.add(data.jTextField12.getText());
					String metin = "";
					for (int i = 0; i < data.belirtiler.size(); i++) {
						metin += data.belirtiler.elementAt(i);
					}
					data.jTextArea10.setText(metin);
					data.jTextField12.setText("Eklendi");
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
		return data.jButton14;
	}

	private JTextField getJTextField13() {
		if (data.jTextField13 == null) {
			data.jTextField13 = new JTextField();
			data.jTextField13.setBounds(new Rectangle(1, 125, 463, 20));
			data.jTextField13.setText("");
		}
		return data.jTextField13;
	}

	private JButton getJButton15() {
		if (data.jButton15 == null) {
			data.jButton15 = new JButton();
			data.jButton15.setBounds(new Rectangle(220, 108, 240, 19));
			data.jButton15.setText("Nedeni Eklemek Ýçin Týklayýnýz");
			data.jButton15.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (data.jTextField13.getText().compareTo("Eklendi") != 0) {
						data.nedenler.add(data.jTextField13.getText());
						String metin = "";
						for (int i = 0; i < data.nedenler.size(); i++) {
							metin += data.nedenler.elementAt(i);
						}
						data.jTextArea11.setText(metin);
						data.jTextField13.setText("Eklendi");
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
		return data.jButton15;
	}

	private JTextField getJTextField14() {
		if (data.jTextField14 == null) {
			data.jTextField14 = new JTextField();
			data.jTextField14.setBounds(new Rectangle(0, 160, 465, 20));
			data.jTextField14.setText("");
		}
		return data.jTextField14;
	}

	private JButton getJButton16() {
		if (data.jButton16 == null) {
			data.jButton16 = new JButton();
			data.jButton16.setBounds(new Rectangle(220, 143, 240, 16));
			data.jButton16.setText("Tedavi Eklemek Ýçin Týklayýnýz");
			data.jButton16.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (data.jTextField14.getText().compareTo("Eklendi") != 0) {
						data.tedaviler.add(data.jTextField14.getText());
						String metin = "";
						for (int i = 0; i < data.tedaviler.size(); i++) {
							metin += data.tedaviler.elementAt(i);
						}
						data.jTextArea12.setText(metin);
						data.jTextField14.setText("Eklendi");
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
		return data.jButton16;
	}

	private JButton getJButton17() {
		if (data.jButton17 == null) {
			data.jButton17 = new JButton();
			data.jButton17.setBounds(new Rectangle(222, 180, 241, 14));
			data.jButton17.setText("Bitkiyi Eklemek Ýçin Týklayýnýz");
			data.jButton17.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					if (data.jTextField15.getText().compareTo("Eklendi") != 0) {
						data.bitkiler.add(data.jTextField15.getText());
						String metin = "";
						for (int i = 0; i < data.bitkiler.size(); i++) {
							metin += data.bitkiler.elementAt(i);
						}
						data.jTextArea13.setText(metin);
						data.jTextField15.setText("Eklendi");
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
		return data.jButton17;
	}

	private JTextField getJTextField15() {
		if (data.jTextField15 == null) {
			data.jTextField15 = new JTextField();
			data.jTextField15.setBounds(new Rectangle(-1, 194, 464, 20));
			data.jTextField15.setText("");
		}
		return data.jTextField15;
	}

	private JTextArea getJTextArea10() {
		if (data.jTextArea10 == null) {
			data.jTextArea10 = new JTextArea();
			data.jTextArea10.setBounds(new Rectangle(472, 35, 500, 127));
		}
		return data.jTextArea10;
	}

	private JTextArea getJTextArea11() {
		if (data.jTextArea11 == null) {
			data.jTextArea11 = new JTextArea();
			data.jTextArea11.setBounds(new Rectangle(468, 180, 505, 135));
		}
		return data.jTextArea11;
	}

	private JTextArea getJTextArea12() {
		if (data.jTextArea12 == null) {
			data.jTextArea12 = new JTextArea();
			data.jTextArea12.setBounds(new Rectangle(0, 229, 463, 197));
		}
		return data.jTextArea12;
	}

	private JTextArea getJTextArea13() {
		if (data.jTextArea13 == null) {
			data.jTextArea13 = new JTextArea();
			data.jTextArea13.setBounds(new Rectangle(470, 330, 500, 225));
		}
		return data.jTextArea13;
	}

	private JButton getJButton18() {
		if (data.jButton18 == null) {
			data.jButton18 = new JButton();
			data.jButton18.setBounds(new Rectangle(223, 427, 241, 16));
			data.jButton18.setText("Bilgileri Kaydetmek Ýstiyorum");
			data.jButton18.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					/* belirtiler nedenler tedaviler bitkiler */
					if (data.jTextField10.getText().compareTo("Bulunamadý") == 0) {
						data.jTextArea14.setText("Veriler Kaydediliyor");
						Hastalik yeni = new Hastalik(data.jTextField4.getText(),
								data.belirtiler, data.nedenler, data.tedaviler, data.bitkiler);
						hash_table.getHash().put(data.jTextField4.getText(), yeni);
						Hastalik_veri_tabani.getHastaliklar().add(yeni);
						hastalik_veri_tabani.update_file();
						data.jTextArea14.setText("Veriler Kaydedildi");
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
		return data.jButton18;
	}

	private JTextArea getJTextArea14() {
		if (data.jTextArea14 == null) {
			data.jTextArea14 = new JTextArea();
			data.jTextArea14.setBounds(new Rectangle(3, 474, 459, 80));
			data.jTextArea14.setText("");
		}
		return data.jTextArea14;
	}

	private JTextField getJTextField11() {
		if (data.jTextField11 == null) {
			data.jTextField11 = new JTextField();
			data.jTextField11.setBounds(new Rectangle(166, 17, 165, 20));
			data.jTextField11.setText("0");
		}
		return data.jTextField11;
	}

	private JTextField getJTextField16() {
		if (data.jTextField16 == null) {
			data.jTextField16 = new JTextField();
			data.jTextField16.setBounds(new Rectangle(494, 16, 167, 20));
			data.jTextField16.setText("0");
		}
		return data.jTextField16;
	}

	private JButton getJButton13() {
		if (data.jButton13 == null) {
			data.jButton13 = new JButton();
			data.jButton13.setBounds(new Rectangle(662, 17, 139, 18));
			data.jButton13.setText("Ürünleri Listele");
			data.jButton13.addMouseListener(new java.awt.event.MouseListener() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					float min, max;
					min = Float.parseFloat(data.jTextField11.getText());
					max = Float.parseFloat(data.jTextField16.getText());
					if (min >= 0 && max >= min) {
						data.jTextArea15.setText(getBitki_veri_tabani()
								.urunleri_listele(min, max));
					} else {
						data.jTextArea15.setText("Doðru Aralýkta Sayýlar Giriniz");
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
		return data.jButton13;
	}

	private JTextArea getJTextArea15() {
		if (data.jTextArea15 == null) {
			data.jTextArea15 = new JTextArea();
			data.jTextArea15.setBounds(new Rectangle(6, 40, 964, 518));
		}
		return data.jTextArea15;
	}

	private JTextField getJTextField17() {
		if (data.jTextField17 == null) {
			data.jTextField17 = new JTextField();
			data.jTextField17.setBounds(new Rectangle(0, 33, 238, 20));
			data.jTextField17.setText("");
		}
		return data.jTextField17;
	}

	private JTextField getJTextField18() {
		if (data.jTextField18 == null) {
			data.jTextField18 = new JTextField();
			data.jTextField18.setBounds(new Rectangle(238, 33, 320, 20));
			data.jTextField18.setText("Ýlk Önce Arama Yapmanýz Gerekmektedir.");
		}
		return data.jTextField18;
	}

	private JTextField getJTextField19() {
		if (data.jTextField19 == null) {
			data.jTextField19 = new JTextField();
			data.jTextField19.setBounds(new Rectangle(818, 19, 145, 20));
		}
		return data.jTextField19;
	}

	private JTextField getJTextField20() {
		if (data.jTextField20 == null) {
			data.jTextField20 = new JTextField();
			data.jTextField20.setBounds(new Rectangle(820, 52, 143, 20));
		}
		return data.jTextField20;
	}

	private JButton getJButton19() {
		if (data.jButton19 == null) {
			data.jButton19 = new JButton();
			data.jButton19.setBounds(new Rectangle(3, 51, 235, 22));
			data.jButton19.setText("Aðaç Vektöründe Var Mý?");
		}
		return data.jButton19;
	}

	// *************************MAIN********************************************************
	public static void main(String[] args) {
		veri_tabanlarini_olustur();
		veri_tabanlarini_veri_yapilarina_kopyala();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Herbalist_App application = new Herbalist_App();
				application.getHerbalist_Application().setVisible(true);
			}
		});
	}

	static void veri_tabanlarini_veri_yapilarina_kopyala() {
		kategorilere_gore_agac_vektorunu_olustur();
		bitki_veri_tabanini_agac_vektorune_kopyala();
		hastalik_veri_tabanini_hash_table_ye_kopyala();
	}

	private static void hastalik_veri_tabanini_hash_table_ye_kopyala() {
		hash_table = new Hash_Table(Hastalik_veri_tabani.getHastaliklar());
	}

	private static void kategorilere_gore_agac_vektorunu_olustur() {
		setAgac_vektoru(new Vector_Agac(Kategori_veri_tabani.getKategoriler()
				.size() + 1));
		// Son vektor elemaný Kategorisiz olan bitkiler için
	}

	public static void veri_tabanlarini_olustur() {
		setKategori_veri_tabani(new Kategori_veri_tabani("kategori.txt"));
		setBitki_veri_tabani(new Bitki_veri_tabani("bitki.txt"));
		setHastalik_veri_tabani(new Hastalik_veri_tabani("hastalýk.txt"));
	}

	public static void bitki_veri_tabanini_agac_vektorune_kopyala() {
		int aranan, endex;
		Node newnode;
		for (int i = 0; i < getBitki_veri_tabani().getBitkiler().size(); i++) {
			newnode = new Node(getBitki_veri_tabani().getBitkiler()
					.elementAt(i));
			aranan = newnode.getBitki().getKategori();
			endex = getKategori_veri_tabani().bitkinin_kategorisini_bul(aranan);
			getAgac_vektoru().getAgaclar().elementAt(endex).insert(newnode);
		}
	}

	

	private JPanel getMenü() {
		if (data.Menu == null) {
			data.Menu = new JPanel();
			data.Menu.setLayout(null);
			data.Menu.add(getKullanici_Menusu(), null);
		}
		return data.Menu;
	}


	public static void setKategori_veri_tabani(
			Kategori_veri_tabani kategori_veri_tabani) {
		Herbalist_App.kategori_veri_tabani = kategori_veri_tabani;
	}

	public static Kategori_veri_tabani getKategori_veri_tabani() {
		return kategori_veri_tabani;
	}

	public static void setBitki_veri_tabani(Bitki_veri_tabani bitki_veri_tabani) {
		Herbalist_App.bitki_veri_tabani = bitki_veri_tabani;
	}

	public static Bitki_veri_tabani getBitki_veri_tabani() {
		return bitki_veri_tabani;
	}

	public static void setAgac_vektoru(Vector_Agac agac_vektoru) {
		Herbalist_App.agac_vektoru = agac_vektoru;
	}

	public static Vector_Agac getAgac_vektoru() {
		return agac_vektoru;
	}

	public static void setHash_table(Hash_Table hash_table) {
		Herbalist_App.hash_table = hash_table;
	}

	public static Hash_Table getHash_table() {
		return hash_table;
	}

	public static void setHastalik_veri_tabani(
			Hastalik_veri_tabani hastalik_veri_tabani) {
		Herbalist_App.hastalik_veri_tabani = hastalik_veri_tabani;
	}

	public static Hastalik_veri_tabani getHastalik_veri_tabani() {
		return hastalik_veri_tabani;
	}
	private JFrame getHerbalist_Application() {
		if (data.Herbalist_Application == null) {
			data.Herbalist_Application = new JFrame();
			data.Herbalist_Application
					.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			data.Herbalist_Application.setJMenuBar(getJJMenuBar());
			data.Herbalist_Application.setSize(1000, 700);
			data.Herbalist_Application.setContentPane(getMenü());
			data.Herbalist_Application.setTitle("Herbalist Application");
		}
		return data.Herbalist_Application;
	}
	private JMenuBar getJJMenuBar() {
		if (data.jJMenuBar == null) {
			data.jJMenuBar = new JMenuBar();
			data.jJMenuBar.add(getFileMenu());
			data.jJMenuBar.add(getEditMenu());
			data.jJMenuBar.add(getHelpMenu());
		}
		return data.jJMenuBar;
	}

	private JMenu getFileMenu() {
		if (data.fileMenu == null) {
			data.fileMenu = new JMenu();
			data.fileMenu.setText("File");
			data.fileMenu.add(getSaveMenuItem());
			data.fileMenu.add(getExitMenuItem());
		}
		return data.fileMenu;
	}

	private JMenu getEditMenu() {
		if (data.editMenu == null) {
			data.editMenu = new JMenu();
			data.editMenu.setText("Edit");
			data.editMenu.add(getCutMenuItem());
			data.editMenu.add(getCopyMenuItem());
			data.editMenu.add(getPasteMenuItem());
		}
		return data.editMenu;
	}

	private JMenu getHelpMenu() {
		if (data.helpMenu == null) {
			data.helpMenu = new JMenu();
			data.helpMenu.setText("Help");
			data.helpMenu.add(getAboutMenuItem());
		}
		return data.helpMenu;
	}

	private JMenuItem getExitMenuItem() {
		if (data.exitMenuItem == null) {
			data.exitMenuItem = new JMenuItem();
			data.exitMenuItem.setText("Exit");
			data.exitMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return data.exitMenuItem;
	}

	private JMenuItem getAboutMenuItem() {
		if (data.aboutMenuItem == null) {
			data.aboutMenuItem = new JMenuItem();
			data.aboutMenuItem.setText("About");
			data.aboutMenuItem.addActionListener(new ActionListener() {
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
		return data.aboutMenuItem;
	}

	private JDialog getAboutDialog() {
		if (data.aboutDialog == null) {
			data.aboutDialog = new JDialog(getHerbalist_Application(), true);
			data.aboutDialog.setTitle("About");
			data.aboutDialog.setContentPane(getAboutContentPane());
		}
		return data.aboutDialog;
	}

	private JPanel getAboutContentPane() {
		if (data.aboutContentPane == null) {
			data.aboutContentPane = new JPanel();
			data.aboutContentPane.setLayout(new BorderLayout());
			data.aboutContentPane.add(getAboutVersionLabel(), BorderLayout.CENTER);
		}
		return data.aboutContentPane;
	}

	private JLabel getAboutVersionLabel() {
		if (data.aboutVersionLabel == null) {
			data.aboutVersionLabel = new JLabel();
			data.aboutVersionLabel.setText("Version 1.0");
			data.aboutVersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return data.aboutVersionLabel;
	}

	private JMenuItem getCutMenuItem() {
		if (data.cutMenuItem == null) {
			data.cutMenuItem = new JMenuItem();
			data.cutMenuItem.setText("Cut");
			data.cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
					Event.CTRL_MASK, true));
		}
		return data.cutMenuItem;
	}

	private JMenuItem getCopyMenuItem() {
		if (data.copyMenuItem == null) {
			data.copyMenuItem = new JMenuItem();
			data.copyMenuItem.setText("Copy");
			data.copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
					Event.CTRL_MASK, true));
		}
		return data.copyMenuItem;
	}

	private JMenuItem getPasteMenuItem() {
		if (data.pasteMenuItem == null) {
			data.pasteMenuItem = new JMenuItem();
			data.pasteMenuItem.setText("Paste");
			data.pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
					Event.CTRL_MASK, true));
		}
		return data.pasteMenuItem;
	}

	private JMenuItem getSaveMenuItem() {
		if (data.saveMenuItem == null) {
			data.saveMenuItem = new JMenuItem();
			data.saveMenuItem.setText("Save");
			data.saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
					Event.CTRL_MASK, true));
		}
		return data.saveMenuItem;
	}
}
