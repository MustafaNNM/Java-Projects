package test;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Herbalist_AppData {
	public JFrame Herbalist_Application;
	public JPanel Menu;
	public JMenuBar jJMenuBar;
	public JMenu fileMenu;
	public JMenu editMenu;
	public JMenu helpMenu;
	public JMenuItem exitMenuItem;
	public JMenuItem aboutMenuItem;
	public JMenuItem cutMenuItem;
	public JMenuItem copyMenuItem;
	public JMenuItem pasteMenuItem;
	public JMenuItem saveMenuItem;
	public JDialog aboutDialog;
	public JPanel aboutContentPane;
	public JLabel aboutVersionLabel;
	public JTabbedPane Kullanici_Menusu;
	public JPanel jPanel;
	public JPanel jPanel1;
	public JTabbedPane Musteri_Menusu;
	public JPanel jPanel2;
	public JPanel Belirli_Fiyatlar_Arasindaki_Tum_Turlerin_Bulunup_Listelenmesi;
	public JPanel Verilen_Bir_Kelimenin_Kategori_Agaclarinda_Tutulan_Bitkilerin_Ozellikleri_Icinden_Aratilmasi_Bulunan_Bitki_Isimlerinin_Listelenmesi;
	public JPanel Urun_Siparisi_Birden_Cok_Paket_Istenebilir_ve_Alimi;
	public JLabel Musteri_Menusu_Basligi;
	public JLabel Personel_Menusu_Basligi;
	public JTabbedPane Personel_Menusu;
	public JPanel jPanel6;
	public JPanel Firmaya_Yeni_Turde_Urun_Girisi;
	public JPanel Adindan_Urun_Arama_ve_Silme;
	public JPanel Urun_Bilgilerinde_Degisiklik;
	public JPanel Yeni_Hastalik_Bilgisi_Girisi;
	public JLabel jLabel2;
	public JLabel jLabel3;
	public JLabel jLabel4;
	public JLabel jLabel5;
	public JPanel Kategori_Listeleme_Agac_Derinligi_ve_Eleman_Sayisini_Yazdirma;
	public JPanel Kategori_Agaclarini_Dengeleme;
	public JPanel Verilen_Bir_Hastaliga_Iliskin_Bilgilerin_Listelenmesi_Hash_Table_Dan;
	public JPanel Belli_Bir_Hastaliga_Iyi_Gelebilen_Bitkilerin_Fiyatlarina_Gore_Heap_e_Atilmasi_ve_N_Tanesinden_Birer_Paket_Satin_Alinmasi;
	public JLabel jLabel6;
	public JLabel jLabel7;
	public JLabel jLabel8;
	public JLabel jLabel9;
	public JLabel jLabel10;
	public JTabbedPane jTabbedPane3;
	public JPanel jPanel16;
	public JLabel jLabel61;
	public JLabel jLabel11;
	public JLabel jLabel12;
	public JTabbedPane Kategori_Ekleme_ve_Silme_Menusu;
	public JPanel Kategori_Ekleme;
	public JPanel Kategori_Silme;
	public JLabel jLabel13;
	public JLabel jLabel14;
	public JLabel jLabel15;
	public JLabel jLabel16;
	public JLabel jLabel17;
	public JLabel jLabel18;
	public JTextArea jTextArea;
	public JPanel Adindan_Urun_Arama_ve_Listeleme;
	public JPanel jPanel23;
	public JLabel jLabel21;
	public JTextArea jTextArea1;
	public JButton jButton;
	public JTabbedPane jTabbedPane6;
	public JPanel jPanel11;
	public JPanel jPanel24;
	public JPanel jPanel25;
	public JLabel jLabel22;
	public JLabel jLabel23;
	public JLabel jLabel24;
	public JScrollPane jScrollPane1;
	public JTextArea jTextArea3;
	public JLabel jLabel25;
	public JTextField jTextField1;
	public JButton jButton1;
	public JTextArea jTextArea5;
	public JLabel jLabel26;
	public JButton jButton2;
	public JButton jButton3;
	public JButton jButton4;
	public JTextArea jTextArea2;
	public String yanit;
	public JTextArea jTextArea6;
	public JLabel jLabel28;
	public JLabel jLabel29;
	public JButton jButton5;
	public JButton jButton6;
	public JLabel jLabel30;
	public JTextArea jTextArea4;
	public JLabel jLabel31;
	public JTextField jTextField4;
	public JButton jButton7;
	public JButton Kategori_Listeleyici;
	public JLabel jLabel;
	public JLabel jLabel1;
	public JTextField jTextField6;
	public JButton jButton8;
	public JButton jButton9;
	public JLabel jLabel32;
	public JButton Kategori_Listeleyici_2;
	public JTextArea jTextArea7;
	public JLabel jLabel19;
	public JButton jButton10;
	public JLabel jLabel20;
	public JTextField jTextField8;
	public JButton jButton11;
	public JLabel jLabel33;
	public JButton Urun_Bilgisi_Listeleyici;
	public JTextArea gecici_metin_kutusu;
	public JTextField jTextField9;
	public JLabel jLabel34;
	public JButton jButton12;
	public JTextArea jTextArea9;
	public JLabel jLabel35;
	public JTextField jTextField10;
	public JLabel jLabel37;
	public JTextField jTextField12;
	public JButton jButton14;
	public JLabel jLabel38;
	public JTextField jTextField13;
	public JButton jButton15;
	public JLabel jLabel39;
	public JTextField jTextField14;
	public JButton jButton16;
	public JLabel jLabel40;
	public JButton jButton17;
	public JTextField jTextField15;
	public JTextArea jTextArea10;
	public JLabel jLabel41;
	public JLabel jLabel42;
	public JTextArea jTextArea11;
	public JLabel jLabel43;
	public JTextArea jTextArea12;
	public JLabel jLabel44;
	public JTextArea jTextArea13;
	public JButton jButton18;
	public JLabel jLabel36;
	public JTextArea jTextArea14;
	public JLabel jLabel45;
	public Vector<String> belirtiler;
	public Vector<String> nedenler;
	public Vector<String> tedaviler;
	public Vector<String> bitkiler;
	public JLabel jLabel46;
	public JLabel jLabel47;
	public JLabel jLabel48;
	public JTextField jTextField11;
	public JTextField jTextField16;
	public JButton jButton13;
	public JTextArea jTextArea15;
	public JTextField jTextField17;
	public JLabel jLabel49;
	public JTextField jTextField18;
	public JLabel jLabel27;
	public JTextField jTextField19;
	public JLabel jLabel50;
	public JTextField jTextField20;
	public JButton jButton19;

	public Herbalist_AppData(
			JFrame herbalist_Application,
			JPanel menu,
			JMenuBar jJMenuBar,
			JMenu fileMenu,
			JMenu editMenu,
			JMenu helpMenu,
			JMenuItem exitMenuItem,
			JMenuItem aboutMenuItem,
			JMenuItem cutMenuItem,
			JMenuItem copyMenuItem,
			JMenuItem pasteMenuItem,
			JMenuItem saveMenuItem,
			JDialog aboutDialog,
			JPanel aboutContentPane,
			JLabel aboutVersionLabel,
			JTabbedPane kullanici_Menusu,
			JPanel jPanel,
			JPanel jPanel1,
			JTabbedPane musteri_Menusu,
			JPanel jPanel2,
			JPanel belirli_Fiyatlar_Arasindaki_Tum_Turlerin_Bulunup_Listelenmesi,
			JPanel verilen_Bir_Kelimenin_Kategori_Agaclarinda_Tutulan_Bitkilerin_Ozellikleri_Icinden_Aratilmasi_Bulunan_Bitki_Isimlerinin_Listelenmesi,
			JPanel urun_Siparisi_Birden_Cok_Paket_Istenebilir_ve_Alimi,
			JLabel musteri_Menusu_Basligi,
			JLabel personel_Menusu_Basligi,
			JTabbedPane personel_Menusu,
			JPanel jPanel6,
			JPanel firmaya_Yeni_Turde_Urun_Girisi,
			JPanel adindan_Urun_Arama_ve_Silme,
			JPanel urun_Bilgilerinde_Degisiklik,
			JPanel yeni_Hastalik_Bilgisi_Girisi,
			JLabel jLabel2,
			JLabel jLabel3,
			JLabel jLabel4,
			JLabel jLabel5,
			JPanel kategori_Listeleme_Agac_Derinligi_ve_Eleman_Sayisini_Yazdirma,
			JPanel kategori_Agaclarini_Dengeleme,
			JPanel verilen_Bir_Hastaliga_Iliskin_Bilgilerin_Listelenmesi_Hash_Table_Dan,
			JPanel belli_Bir_Hastaliga_Iyi_Gelebilen_Bitkilerin_Fiyatlarina_Gore_Heap_e_Atilmasi_ve_N_Tanesinden_Birer_Paket_Satin_Alinmasi,
			JLabel jLabel6, JLabel jLabel7, JLabel jLabel8, JLabel jLabel9,
			JLabel jLabel10, JTabbedPane jTabbedPane3, JPanel jPanel16,
			JLabel jLabel61, JLabel jLabel11, JLabel jLabel12,
			JTabbedPane kategori_Ekleme_ve_Silme_Menusu,
			JPanel kategori_Ekleme, JPanel kategori_Silme, JLabel jLabel13,
			JLabel jLabel14, JLabel jLabel15, JLabel jLabel16, JLabel jLabel17,
			JLabel jLabel18, JTextArea jTextArea,
			JPanel adindan_Urun_Arama_ve_Listeleme, JPanel jPanel23,
			JLabel jLabel21, JTextArea jTextArea1, JButton jButton,
			JTabbedPane jTabbedPane6, JPanel jPanel11, JPanel jPanel24,
			JPanel jPanel25, JLabel jLabel22, JLabel jLabel23, JLabel jLabel24,
			JScrollPane jScrollPane1, JTextArea jTextArea3, JLabel jLabel25,
			JTextField jTextField1, JButton jButton1, JTextArea jTextArea5,
			JLabel jLabel26, JButton jButton2, JButton jButton3,
			JButton jButton4, JTextArea jTextArea2, String yanit,
			JTextArea jTextArea6, JLabel jLabel28, JLabel jLabel29,
			JButton jButton5, JButton jButton6, JLabel jLabel30,
			JTextArea jTextArea4, JLabel jLabel31, JTextField jTextField4,
			JButton jButton7, JButton kategori_Listeleyici, JLabel jLabel,
			JLabel jLabel1, JTextField jTextField6, JButton jButton8,
			JButton jButton9, JLabel jLabel32, JButton kategori_Listeleyici_2,
			JTextArea jTextArea7, JLabel jLabel19, JButton jButton10,
			JLabel jLabel20, JTextField jTextField8, JButton jButton11,
			JLabel jLabel33, JButton urun_Bilgisi_Listeleyici,
			JTextArea gecici_metin_kutusu, JTextField jTextField9,
			JLabel jLabel34, JButton jButton12, JTextArea jTextArea9,
			JLabel jLabel35, JTextField jTextField10, JLabel jLabel37,
			JTextField jTextField12, JButton jButton14, JLabel jLabel38,
			JTextField jTextField13, JButton jButton15, JLabel jLabel39,
			JTextField jTextField14, JButton jButton16, JLabel jLabel40,
			JButton jButton17, JTextField jTextField15, JTextArea jTextArea10,
			JLabel jLabel41, JLabel jLabel42, JTextArea jTextArea11,
			JLabel jLabel43, JTextArea jTextArea12, JLabel jLabel44,
			JTextArea jTextArea13, JButton jButton18, JLabel jLabel36,
			JTextArea jTextArea14, JLabel jLabel45, Vector<String> belirtiler,
			Vector<String> nedenler, Vector<String> tedaviler,
			Vector<String> bitkiler, JLabel jLabel46, JLabel jLabel47,
			JLabel jLabel48, JTextField jTextField11, JTextField jTextField16,
			JButton jButton13, JTextArea jTextArea15, JTextField jTextField17,
			JLabel jLabel49, JTextField jTextField18, JLabel jLabel27,
			JTextField jTextField19, JLabel jLabel50, JTextField jTextField20,
			JButton jButton19) {
		Herbalist_Application = herbalist_Application;
		Menu = menu;
		this.jJMenuBar = jJMenuBar;
		this.fileMenu = fileMenu;
		this.editMenu = editMenu;
		this.helpMenu = helpMenu;
		this.exitMenuItem = exitMenuItem;
		this.aboutMenuItem = aboutMenuItem;
		this.cutMenuItem = cutMenuItem;
		this.copyMenuItem = copyMenuItem;
		this.pasteMenuItem = pasteMenuItem;
		this.saveMenuItem = saveMenuItem;
		this.aboutDialog = aboutDialog;
		this.aboutContentPane = aboutContentPane;
		this.aboutVersionLabel = aboutVersionLabel;
		Kullanici_Menusu = kullanici_Menusu;
		this.jPanel = jPanel;
		this.jPanel1 = jPanel1;
		Musteri_Menusu = musteri_Menusu;
		this.jPanel2 = jPanel2;
		Belirli_Fiyatlar_Arasindaki_Tum_Turlerin_Bulunup_Listelenmesi = belirli_Fiyatlar_Arasindaki_Tum_Turlerin_Bulunup_Listelenmesi;
		Verilen_Bir_Kelimenin_Kategori_Agaclarinda_Tutulan_Bitkilerin_Ozellikleri_Icinden_Aratilmasi_Bulunan_Bitki_Isimlerinin_Listelenmesi = verilen_Bir_Kelimenin_Kategori_Agaclarinda_Tutulan_Bitkilerin_Ozellikleri_Icinden_Aratilmasi_Bulunan_Bitki_Isimlerinin_Listelenmesi;
		Urun_Siparisi_Birden_Cok_Paket_Istenebilir_ve_Alimi = urun_Siparisi_Birden_Cok_Paket_Istenebilir_ve_Alimi;
		Musteri_Menusu_Basligi = musteri_Menusu_Basligi;
		Personel_Menusu_Basligi = personel_Menusu_Basligi;
		Personel_Menusu = personel_Menusu;
		this.jPanel6 = jPanel6;
		Firmaya_Yeni_Turde_Urun_Girisi = firmaya_Yeni_Turde_Urun_Girisi;
		Adindan_Urun_Arama_ve_Silme = adindan_Urun_Arama_ve_Silme;
		Urun_Bilgilerinde_Degisiklik = urun_Bilgilerinde_Degisiklik;
		Yeni_Hastalik_Bilgisi_Girisi = yeni_Hastalik_Bilgisi_Girisi;
		this.jLabel2 = jLabel2;
		this.jLabel3 = jLabel3;
		this.jLabel4 = jLabel4;
		this.jLabel5 = jLabel5;
		Kategori_Listeleme_Agac_Derinligi_ve_Eleman_Sayisini_Yazdirma = kategori_Listeleme_Agac_Derinligi_ve_Eleman_Sayisini_Yazdirma;
		Kategori_Agaclarini_Dengeleme = kategori_Agaclarini_Dengeleme;
		Verilen_Bir_Hastaliga_Iliskin_Bilgilerin_Listelenmesi_Hash_Table_Dan = verilen_Bir_Hastaliga_Iliskin_Bilgilerin_Listelenmesi_Hash_Table_Dan;
		Belli_Bir_Hastaliga_Iyi_Gelebilen_Bitkilerin_Fiyatlarina_Gore_Heap_e_Atilmasi_ve_N_Tanesinden_Birer_Paket_Satin_Alinmasi = belli_Bir_Hastaliga_Iyi_Gelebilen_Bitkilerin_Fiyatlarina_Gore_Heap_e_Atilmasi_ve_N_Tanesinden_Birer_Paket_Satin_Alinmasi;
		this.jLabel6 = jLabel6;
		this.jLabel7 = jLabel7;
		this.jLabel8 = jLabel8;
		this.jLabel9 = jLabel9;
		this.jLabel10 = jLabel10;
		this.jTabbedPane3 = jTabbedPane3;
		this.jPanel16 = jPanel16;
		this.jLabel61 = jLabel61;
		this.jLabel11 = jLabel11;
		this.jLabel12 = jLabel12;
		Kategori_Ekleme_ve_Silme_Menusu = kategori_Ekleme_ve_Silme_Menusu;
		Kategori_Ekleme = kategori_Ekleme;
		Kategori_Silme = kategori_Silme;
		this.jLabel13 = jLabel13;
		this.jLabel14 = jLabel14;
		this.jLabel15 = jLabel15;
		this.jLabel16 = jLabel16;
		this.jLabel17 = jLabel17;
		this.jLabel18 = jLabel18;
		this.jTextArea = jTextArea;
		Adindan_Urun_Arama_ve_Listeleme = adindan_Urun_Arama_ve_Listeleme;
		this.jPanel23 = jPanel23;
		this.jLabel21 = jLabel21;
		this.jTextArea1 = jTextArea1;
		this.jButton = jButton;
		this.jTabbedPane6 = jTabbedPane6;
		this.jPanel11 = jPanel11;
		this.jPanel24 = jPanel24;
		this.jPanel25 = jPanel25;
		this.jLabel22 = jLabel22;
		this.jLabel23 = jLabel23;
		this.jLabel24 = jLabel24;
		this.jScrollPane1 = jScrollPane1;
		this.jTextArea3 = jTextArea3;
		this.jLabel25 = jLabel25;
		this.jTextField1 = jTextField1;
		this.jButton1 = jButton1;
		this.jTextArea5 = jTextArea5;
		this.jLabel26 = jLabel26;
		this.jButton2 = jButton2;
		this.jButton3 = jButton3;
		this.jButton4 = jButton4;
		this.jTextArea2 = jTextArea2;
		this.yanit = yanit;
		this.jTextArea6 = jTextArea6;
		this.jLabel28 = jLabel28;
		this.jLabel29 = jLabel29;
		this.jButton5 = jButton5;
		this.jButton6 = jButton6;
		this.jLabel30 = jLabel30;
		this.jTextArea4 = jTextArea4;
		this.jLabel31 = jLabel31;
		this.jTextField4 = jTextField4;
		this.jButton7 = jButton7;
		Kategori_Listeleyici = kategori_Listeleyici;
		this.jLabel = jLabel;
		this.jLabel1 = jLabel1;
		this.jTextField6 = jTextField6;
		this.jButton8 = jButton8;
		this.jButton9 = jButton9;
		this.jLabel32 = jLabel32;
		Kategori_Listeleyici_2 = kategori_Listeleyici_2;
		this.jTextArea7 = jTextArea7;
		this.jLabel19 = jLabel19;
		this.jButton10 = jButton10;
		this.jLabel20 = jLabel20;
		this.jTextField8 = jTextField8;
		this.jButton11 = jButton11;
		this.jLabel33 = jLabel33;
		Urun_Bilgisi_Listeleyici = urun_Bilgisi_Listeleyici;
		this.gecici_metin_kutusu = gecici_metin_kutusu;
		this.jTextField9 = jTextField9;
		this.jLabel34 = jLabel34;
		this.jButton12 = jButton12;
		this.jTextArea9 = jTextArea9;
		this.jLabel35 = jLabel35;
		this.jTextField10 = jTextField10;
		this.jLabel37 = jLabel37;
		this.jTextField12 = jTextField12;
		this.jButton14 = jButton14;
		this.jLabel38 = jLabel38;
		this.jTextField13 = jTextField13;
		this.jButton15 = jButton15;
		this.jLabel39 = jLabel39;
		this.jTextField14 = jTextField14;
		this.jButton16 = jButton16;
		this.jLabel40 = jLabel40;
		this.jButton17 = jButton17;
		this.jTextField15 = jTextField15;
		this.jTextArea10 = jTextArea10;
		this.jLabel41 = jLabel41;
		this.jLabel42 = jLabel42;
		this.jTextArea11 = jTextArea11;
		this.jLabel43 = jLabel43;
		this.jTextArea12 = jTextArea12;
		this.jLabel44 = jLabel44;
		this.jTextArea13 = jTextArea13;
		this.jButton18 = jButton18;
		this.jLabel36 = jLabel36;
		this.jTextArea14 = jTextArea14;
		this.jLabel45 = jLabel45;
		this.belirtiler = belirtiler;
		this.nedenler = nedenler;
		this.tedaviler = tedaviler;
		this.bitkiler = bitkiler;
		this.jLabel46 = jLabel46;
		this.jLabel47 = jLabel47;
		this.jLabel48 = jLabel48;
		this.jTextField11 = jTextField11;
		this.jTextField16 = jTextField16;
		this.jButton13 = jButton13;
		this.jTextArea15 = jTextArea15;
		this.jTextField17 = jTextField17;
		this.jLabel49 = jLabel49;
		this.jTextField18 = jTextField18;
		this.jLabel27 = jLabel27;
		this.jTextField19 = jTextField19;
		this.jLabel50 = jLabel50;
		this.jTextField20 = jTextField20;
		this.jButton19 = jButton19;
	}
}