package herbalist;

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
	private Herbalist_AppStringData stringdata = new Herbalist_AppStringData();
	private Herbalist_AppGUIData guidata = new Herbalist_AppGUIData(
			new Herbalist_AppJMenuData(), new Herbalist_AppJMenuItemData(), new Herbalist_AppJTabbedPaneData(), new Herbalist_AppJTextAreaData(),
			new Herbalist_AppJPanelData(), new Herbalist_AppJTextFieldData(), new Herbalist_AppJButtonData());

	public Herbalist_AppData(
			JFrame herbalist_Application,
			JPanel menü,
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
			JTabbedPane kullanýcý_Menüsü,
			JPanel jPanel,
			JPanel jPanel1,
			JTabbedPane müþteri_Menüsü,
			JPanel jPanel2,
			JPanel belirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi,
			JPanel verilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi,
			JPanel ürün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý,
			JLabel müþteri_Menüsü_Baþlýðý,
			JLabel personel_Menüsü_Baþlýðý,
			JTabbedPane personel_Menüsü,
			JPanel jPanel6,
			JPanel firmaya_Yeni_Türde_Ürün_Giriþi,
			JPanel adýndan_Ürün_Arama_ve_Silme,
			JPanel ürün_Bilgilerinde_Deðiþiklik,
			JPanel yeni_Hastalýk_Bilgisi_Giriþi,
			JLabel jLabel2,
			JLabel jLabel3,
			JLabel jLabel4,
			JLabel jLabel5,
			JPanel kategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma,
			JPanel kategori_Aðaçlarýný_Dengeleme,
			JPanel verilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan,
			JPanel belli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý,
			JLabel jLabel6, JLabel jLabel7, JLabel jLabel8, JLabel jLabel9,
			JLabel jLabel10, JTabbedPane jTabbedPane3, JPanel jPanel16,
			JLabel jLabel61, JLabel jLabel11, JLabel jLabel12,
			JTabbedPane kategori_Ekleme_ve_Silme_Menüsü,
			JPanel kategori_Ekleme, JPanel kategori_Silme, JLabel jLabel13,
			JLabel jLabel14, JLabel jLabel15, JLabel jLabel16, JLabel jLabel17,
			JLabel jLabel18, JTextArea jTextArea,
			JPanel adýndan_Ürün_Arama_ve_Listeleme, JPanel jPanel23,
			JLabel jLabel21, JTextArea jTextArea1, JButton jButton,
			JTabbedPane jTabbedPane6, JPanel jPanel11, JPanel jPanel24,
			JPanel jPanel25, JLabel jLabel22, JLabel jLabel23, JLabel jLabel24,
			JScrollPane jScrollPane1, JTextArea jTextArea3, JLabel jLabel25,
			JTextField jTextField1, JButton jButton1, JTextArea jTextArea5,
			JLabel jLabel26, JButton jButton2, JButton jButton3,
			JButton jButton4, JTextArea jTextArea2, String yanýt,
			JTextArea jTextArea6, JLabel jLabel28, JLabel jLabel29,
			JButton jButton5, JButton jButton6, JLabel jLabel30,
			JTextArea jTextArea4, JLabel jLabel31, JTextField jTextField4,
			JButton jButton7, JButton kategori_Listeleyici, JLabel jLabel,
			JLabel jLabel1, JTextField jTextField6, JButton jButton8,
			JButton jButton9, JLabel jLabel32, JButton kategori_Listeleyici_2,
			JTextArea jTextArea7, JLabel jLabel19, JButton jButton10,
			JLabel jLabel20, JTextField jTextField8, JButton jButton11,
			JLabel jLabel33, JButton ürün_Bilgisi_Listeleyici,
			JTextArea geçici_metin_kutusu, JTextField jTextField9,
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
		guidata.setHerbalist_Application(herbalist_Application);
		guidata.getJpaneldata().setMenü(menü);
		this.guidata.setjJMenuBar(jJMenuBar);
		this.guidata.getJmenudata().setFileMenu(fileMenu);
		this.guidata.getJmenudata().setEditMenu(editMenu);
		this.guidata.getJmenudata().setHelpMenu(helpMenu);
		this.guidata.getJmenuitemdata().setExitMenuItem(exitMenuItem);
		this.guidata.getJmenuitemdata().setAboutMenuItem(aboutMenuItem);
		this.guidata.getJmenuitemdata().setCutMenuItem(cutMenuItem);
		this.guidata.getJmenuitemdata().setCopyMenuItem(copyMenuItem);
		this.guidata.getJmenuitemdata().setPasteMenuItem(pasteMenuItem);
		this.guidata.getJmenuitemdata().setSaveMenuItem(saveMenuItem);
		this.guidata.setAboutDialog(aboutDialog);
		this.guidata.getJpaneldata().setAboutContentPane(aboutContentPane);
		this.guidata.getJpaneldata().setAboutVersionLabel(aboutVersionLabel);
		guidata.getJtabbedpanedata().setKullanýcý_Menüsü(kullanýcý_Menüsü);
		this.guidata.getJpaneldata().setjPanel(jPanel);
		this.guidata.getJpaneldata().setjPanel1(jPanel1);
		guidata.getJtabbedpanedata().setMüþteri_Menüsü(müþteri_Menüsü);
		this.guidata.getJpaneldata().setjPanel2(jPanel2);
		guidata.getJpaneldata()
				.setBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi(belirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi);
		guidata.getJpaneldata()
				.setVerilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi(verilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi);
		guidata.getJpaneldata()
				.setÜrün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý(ürün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý);
		guidata.getJpaneldata().setMüþteri_Menüsü_Baþlýðý(müþteri_Menüsü_Baþlýðý);
		guidata.getJpaneldata().setPersonel_Menüsü_Baþlýðý(personel_Menüsü_Baþlýðý);
		guidata.getJtabbedpanedata().setPersonel_Menüsü(personel_Menüsü);
		this.guidata.getJpaneldata().setjPanel6(jPanel6);
		guidata.getJpaneldata().setFirmaya_Yeni_Türde_Ürün_Giriþi(firmaya_Yeni_Türde_Ürün_Giriþi);
		guidata.getJpaneldata().setAdýndan_Ürün_Arama_ve_Silme(adýndan_Ürün_Arama_ve_Silme);
		guidata.getJpaneldata().setÜrün_Bilgilerinde_Deðiþiklik(ürün_Bilgilerinde_Deðiþiklik);
		guidata.getJpaneldata().setYeni_Hastalýk_Bilgisi_Giriþi(yeni_Hastalýk_Bilgisi_Giriþi);
		this.guidata.getJpaneldata().setjLabel2(jLabel2);
		this.guidata.getJpaneldata().setjLabel3(jLabel3);
		this.guidata.getJpaneldata().setjLabel4(jLabel4);
		this.guidata.getJpaneldata().setjLabel5(jLabel5);
		guidata.getJpaneldata()
				.setKategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma(kategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma);
		guidata.getJpaneldata().setKategori_Aðaçlarýný_Dengeleme(kategori_Aðaçlarýný_Dengeleme);
		guidata.getJpaneldata()
				.setVerilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan(verilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan);
		guidata.getJpaneldata()
				.setBelli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý(belli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý);
		this.guidata.getJpaneldata().setjLabel6(jLabel6);
		this.guidata.getJpaneldata().setjLabel7(jLabel7);
		this.guidata.getJpaneldata().setjLabel8(jLabel8);
		this.guidata.getJpaneldata().setjLabel9(jLabel9);
		this.guidata.getJpaneldata().setjLabel10(jLabel10);
		this.guidata.getJtabbedpanedata().setjTabbedPane3(jTabbedPane3);
		this.guidata.getJpaneldata().setjPanel16(jPanel16);
		this.guidata.getJpaneldata().setjLabel61(jLabel61);
		this.guidata.getJpaneldata().setjLabel11(jLabel11);
		this.guidata.getJpaneldata().setjLabel12(jLabel12);
		guidata.getJtabbedpanedata().setKategori_Ekleme_ve_Silme_Menüsü(kategori_Ekleme_ve_Silme_Menüsü);
		guidata.getJpaneldata().setKategori_Ekleme(kategori_Ekleme);
		guidata.getJpaneldata().setKategori_Silme(kategori_Silme);
		this.guidata.getJpaneldata().setjLabel13(jLabel13);
		this.guidata.getJpaneldata().setjLabel14(jLabel14);
		this.guidata.getJpaneldata().setjLabel15(jLabel15);
		this.guidata.getJpaneldata().setjLabel16(jLabel16);
		this.guidata.getJpaneldata().setjLabel17(jLabel17);
		this.guidata.getJpaneldata().setjLabel18(jLabel18);
		this.guidata.getJtextareadata().setjTextArea(jTextArea);
		guidata.getJpaneldata().setAdýndan_Ürün_Arama_ve_Listeleme(adýndan_Ürün_Arama_ve_Listeleme);
		this.guidata.getJpaneldata().setjPanel23(jPanel23);
		this.guidata.getJpaneldata().setjLabel21(jLabel21);
		this.guidata.getJtextareadata().setjTextArea1(jTextArea1);
		this.guidata.getJbuttondata().setjButton(jButton);
		this.guidata.getJtabbedpanedata().setjTabbedPane6(jTabbedPane6);
		this.guidata.getJpaneldata().setjPanel11(jPanel11);
		this.guidata.getJpaneldata().setjPanel24(jPanel24);
		this.guidata.getJpaneldata().setjPanel25(jPanel25);
		this.guidata.getJpaneldata().setjLabel22(jLabel22);
		this.guidata.getJpaneldata().setjLabel23(jLabel23);
		this.guidata.getJpaneldata().setjLabel24(jLabel24);
		this.guidata.setjScrollPane1(jScrollPane1);
		this.guidata.getJtextareadata().setjTextArea3(jTextArea3);
		this.guidata.getJpaneldata().setjLabel25(jLabel25);
		this.guidata.getJtextfielddata().setjTextField1(jTextField1);
		this.guidata.getJpaneldata().setjButton1(jButton1);
		this.guidata.getJtextareadata().setjTextArea5(jTextArea5);
		this.guidata.getJpaneldata().setjLabel26(jLabel26);
		this.guidata.getJbuttondata().setjButton2(jButton2);
		this.guidata.getJbuttondata().setjButton3(jButton3);
		this.guidata.getJbuttondata().setjButton4(jButton4);
		this.guidata.getJtextareadata().setjTextArea2(jTextArea2);
		this.stringdata.setYanýt(yanýt);
		this.guidata.getJtextareadata().setjTextArea6(jTextArea6);
		this.guidata.getJpaneldata().setjLabel28(jLabel28);
		this.guidata.getJpaneldata().setjLabel29(jLabel29);
		this.guidata.getJbuttondata().setjButton5(jButton5);
		this.guidata.getJbuttondata().setjButton6(jButton6);
		this.guidata.getJpaneldata().setjLabel30(jLabel30);
		this.guidata.getJtextareadata().setjTextArea4(jTextArea4);
		this.guidata.getJpaneldata().setjLabel31(jLabel31);
		this.guidata.getJtextfielddata().setjTextField4(jTextField4);
		this.guidata.getJbuttondata().setjButton7(jButton7);
		guidata.getJbuttondata().setKategori_Listeleyici(kategori_Listeleyici);
		this.guidata.getJpaneldata().setjLabel(jLabel);
		this.guidata.getJpaneldata().setjLabel1(jLabel1);
		this.guidata.getJtextfielddata().setjTextField6(jTextField6);
		this.guidata.getJbuttondata().setjButton8(jButton8);
		this.guidata.getJbuttondata().setjButton9(jButton9);
		this.guidata.getJpaneldata().setjLabel32(jLabel32);
		guidata.getJbuttondata().setKategori_Listeleyici_2(kategori_Listeleyici_2);
		this.guidata.getJtextareadata().setjTextArea7(jTextArea7);
		this.guidata.getJpaneldata().setjLabel19(jLabel19);
		this.guidata.getJbuttondata().setjButton10(jButton10);
		this.guidata.getJpaneldata().setjLabel20(jLabel20);
		this.guidata.getJtextfielddata().setjTextField8(jTextField8);
		this.guidata.getJbuttondata().setjButton11(jButton11);
		this.guidata.getJpaneldata().setjLabel33(jLabel33);
		guidata.getJbuttondata().setÜrün_Bilgisi_Listeleyici(ürün_Bilgisi_Listeleyici);
		this.guidata.getJtextareadata().setGeçici_metin_kutusu(geçici_metin_kutusu);
		this.guidata.getJtextfielddata().setjTextField9(jTextField9);
		this.guidata.getJpaneldata().setjLabel34(jLabel34);
		this.guidata.getJbuttondata().setjButton12(jButton12);
		this.guidata.getJtextareadata().setjTextArea9(jTextArea9);
		this.guidata.getJpaneldata().setjLabel35(jLabel35);
		this.guidata.getJtextfielddata().setjTextField10(jTextField10);
		this.guidata.getJpaneldata().setjLabel37(jLabel37);
		this.guidata.getJtextfielddata().setjTextField12(jTextField12);
		this.guidata.getJbuttondata().setjButton14(jButton14);
		this.guidata.getJpaneldata().setjLabel38(jLabel38);
		this.guidata.getJtextfielddata().setjTextField13(jTextField13);
		this.guidata.getJbuttondata().setjButton15(jButton15);
		this.guidata.getJpaneldata().setjLabel39(jLabel39);
		this.guidata.getJtextfielddata().setjTextField14(jTextField14);
		this.guidata.getJbuttondata().setjButton16(jButton16);
		this.guidata.getJpaneldata().setjLabel40(jLabel40);
		this.guidata.getJbuttondata().setjButton17(jButton17);
		this.guidata.getJtextfielddata().setjTextField15(jTextField15);
		this.guidata.getJtextareadata().setjTextArea10(jTextArea10);
		this.guidata.getJpaneldata().setjLabel41(jLabel41);
		this.guidata.getJpaneldata().setjLabel42(jLabel42);
		this.guidata.getJtextareadata().setjTextArea11(jTextArea11);
		this.guidata.getJpaneldata().setjLabel43(jLabel43);
		this.guidata.getJtextareadata().setjTextArea12(jTextArea12);
		this.guidata.getJpaneldata().setjLabel44(jLabel44);
		this.guidata.getJtextareadata().setjTextArea13(jTextArea13);
		this.guidata.getJbuttondata().setjButton18(jButton18);
		this.guidata.getJpaneldata().setjLabel36(jLabel36);
		this.guidata.getJtextareadata().setjTextArea14(jTextArea14);
		this.guidata.getJpaneldata().setjLabel45(jLabel45);
		this.stringdata.setBelirtiler(belirtiler);
		this.stringdata.setNedenler(nedenler);
		this.stringdata.setTedaviler(tedaviler);
		this.stringdata.setBitkiler(bitkiler);
		this.guidata.getJpaneldata().setjLabel46(jLabel46);
		this.guidata.getJpaneldata().setjLabel47(jLabel47);
		this.guidata.getJpaneldata().setjLabel48(jLabel48);
		this.guidata.getJtextfielddata().setjTextField11(jTextField11);
		this.guidata.getJtextfielddata().setjTextField16(jTextField16);
		this.guidata.getJbuttondata().setjButton13(jButton13);
		this.guidata.getJtextareadata().setjTextArea15(jTextArea15);
		this.guidata.getJtextfielddata().setjTextField17(jTextField17);
		this.guidata.getJpaneldata().setjLabel49(jLabel49);
		this.guidata.getJtextfielddata().setjTextField18(jTextField18);
		this.guidata.getJpaneldata().setjLabel27(jLabel27);
		this.guidata.getJtextfielddata().setjTextField19(jTextField19);
		this.guidata.getJpaneldata().setjLabel50(jLabel50);
		this.guidata.getJtextfielddata().setjTextField20(jTextField20);
		this.guidata.getJbuttondata().setjButton19(jButton19);
	}

	public JFrame getHerbalist_Application() {
		return guidata.getHerbalist_Application();
	}

	public void setHerbalist_Application(JFrame herbalist_Application) {
		guidata.setHerbalist_Application(herbalist_Application);
	}

	public JPanel getMenü() {
		return guidata.getJpaneldata().getMenü();
	}

	public void setMenü(JPanel menü) {
		guidata.getJpaneldata().setMenü(menü);
	}

	public JMenuBar getjJMenuBar() {
		return guidata.getjJMenuBar();
	}

	public void setjJMenuBar(JMenuBar jJMenuBar) {
		this.guidata.setjJMenuBar(jJMenuBar);
	}

	public JMenu getFileMenu() {
		return guidata.getJmenudata().getFileMenu();
	}

	public void setFileMenu(JMenu fileMenu) {
		this.guidata.getJmenudata().setFileMenu(fileMenu);
	}

	public JMenu getEditMenu() {
		return guidata.getJmenudata().getEditMenu();
	}

	public void setEditMenu(JMenu editMenu) {
		this.guidata.getJmenudata().setEditMenu(editMenu);
	}

	public JMenu getHelpMenu() {
		return guidata.getJmenudata().getHelpMenu();
	}

	public void setHelpMenu(JMenu helpMenu) {
		this.guidata.getJmenudata().setHelpMenu(helpMenu);
	}

	public JMenuItem getExitMenuItem() {
		return guidata.getJmenuitemdata().getExitMenuItem();
	}

	public void setExitMenuItem(JMenuItem exitMenuItem) {
		this.guidata.getJmenuitemdata().setExitMenuItem(exitMenuItem);
	}

	public JMenuItem getAboutMenuItem() {
		return guidata.getJmenuitemdata().getAboutMenuItem();
	}

	public void setAboutMenuItem(JMenuItem aboutMenuItem) {
		this.guidata.getJmenuitemdata().setAboutMenuItem(aboutMenuItem);
	}

	public JMenuItem getCutMenuItem() {
		return guidata.getJmenuitemdata().getCutMenuItem();
	}

	public void setCutMenuItem(JMenuItem cutMenuItem) {
		this.guidata.getJmenuitemdata().setCutMenuItem(cutMenuItem);
	}

	public JMenuItem getCopyMenuItem() {
		return guidata.getJmenuitemdata().getCopyMenuItem();
	}

	public void setCopyMenuItem(JMenuItem copyMenuItem) {
		this.guidata.getJmenuitemdata().setCopyMenuItem(copyMenuItem);
	}

	public JMenuItem getPasteMenuItem() {
		return guidata.getJmenuitemdata().getPasteMenuItem();
	}

	public void setPasteMenuItem(JMenuItem pasteMenuItem) {
		this.guidata.getJmenuitemdata().setPasteMenuItem(pasteMenuItem);
	}

	public JMenuItem getSaveMenuItem() {
		return guidata.getJmenuitemdata().getSaveMenuItem();
	}

	public void setSaveMenuItem(JMenuItem saveMenuItem) {
		this.guidata.getJmenuitemdata().setSaveMenuItem(saveMenuItem);
	}

	public JDialog getAboutDialog() {
		return guidata.getAboutDialog();
	}

	public void setAboutDialog(JDialog aboutDialog) {
		this.guidata.setAboutDialog(aboutDialog);
	}

	public JPanel getAboutContentPane() {
		return guidata.getJpaneldata().getAboutContentPane();
	}

	public void setAboutContentPane(JPanel aboutContentPane) {
		this.guidata.getJpaneldata().setAboutContentPane(aboutContentPane);
	}

	public JLabel getAboutVersionLabel() {
		return guidata.getJpaneldata().getAboutVersionLabel();
	}

	public void setAboutVersionLabel(JLabel aboutVersionLabel) {
		this.guidata.getJpaneldata().setAboutVersionLabel(aboutVersionLabel);
	}

	public JTabbedPane getKullanýcý_Menüsü() {
		return guidata.getJtabbedpanedata().getKullanýcý_Menüsü();
	}

	public void setKullanýcý_Menüsü(JTabbedPane kullanýcý_Menüsü) {
		guidata.getJtabbedpanedata().setKullanýcý_Menüsü(kullanýcý_Menüsü);
	}

	public JPanel getjPanel() {
		return guidata.getJpaneldata().getjPanel();
	}

	public void setjPanel(JPanel jPanel) {
		this.guidata.getJpaneldata().setjPanel(jPanel);
	}

	public JPanel getjPanel1() {
		return guidata.getJpaneldata().getjPanel1();
	}

	public void setjPanel1(JPanel jPanel1) {
		this.guidata.getJpaneldata().setjPanel1(jPanel1);
	}

	public JTabbedPane getMüþteri_Menüsü() {
		return guidata.getJtabbedpanedata().getMüþteri_Menüsü();
	}

	public void setMüþteri_Menüsü(JTabbedPane müþteri_Menüsü) {
		guidata.getJtabbedpanedata().setMüþteri_Menüsü(müþteri_Menüsü);
	}

	public JPanel getjPanel2() {
		return guidata.getJpaneldata().getjPanel2();
	}

	public void setjPanel2(JPanel jPanel2) {
		this.guidata.getJpaneldata().setjPanel2(jPanel2);
	}

	public JPanel getBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi() {
		return guidata.getJpaneldata()
				.getBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi();
	}

	public void setBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi(
			JPanel belirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi) {
		guidata.getJpaneldata()
				.setBelirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi(belirli_Fiyatlar_Arasýndaki_Tüm_Türlerin_Bulunup_Listelenmesi);
	}

	public JPanel getVerilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi() {
		return guidata.getJpaneldata()
				.getVerilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi();
	}

	public void setVerilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi(
			JPanel verilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi) {
		guidata.getJpaneldata()
				.setVerilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi(verilen_Bir_Kelimenin_Kategori_Aðaçlarýnda_Tutulan_Bitkilerin_Özellikleri_Ýçinden_Aratýlmasý_Bulunan_Bitki_Ýsimlerinin_Listelenmesi);
	}

	public JPanel getÜrün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý() {
		return guidata.getJpaneldata().getÜrün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý();
	}

	public void setÜrün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý(
			JPanel ürün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý) {
		guidata.getJpaneldata()
				.setÜrün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý(ürün_Sipariþi_Birden_Çok_Paket_Ýstenebilir_ve_Alýmý);
	}

	public JLabel getMüþteri_Menüsü_Baþlýðý() {
		return guidata.getJpaneldata().getMüþteri_Menüsü_Baþlýðý();
	}

	public void setMüþteri_Menüsü_Baþlýðý(JLabel müþteri_Menüsü_Baþlýðý) {
		guidata.getJpaneldata().setMüþteri_Menüsü_Baþlýðý(müþteri_Menüsü_Baþlýðý);
	}

	public JLabel getPersonel_Menüsü_Baþlýðý() {
		return guidata.getJpaneldata().getPersonel_Menüsü_Baþlýðý();
	}

	public void setPersonel_Menüsü_Baþlýðý(JLabel personel_Menüsü_Baþlýðý) {
		guidata.getJpaneldata().setPersonel_Menüsü_Baþlýðý(personel_Menüsü_Baþlýðý);
	}

	public JTabbedPane getPersonel_Menüsü() {
		return guidata.getJtabbedpanedata().getPersonel_Menüsü();
	}

	public void setPersonel_Menüsü(JTabbedPane personel_Menüsü) {
		guidata.getJtabbedpanedata().setPersonel_Menüsü(personel_Menüsü);
	}

	public JPanel getjPanel6() {
		return guidata.getJpaneldata().getjPanel6();
	}

	public void setjPanel6(JPanel jPanel6) {
		this.guidata.getJpaneldata().setjPanel6(jPanel6);
	}

	public JPanel getFirmaya_Yeni_Türde_Ürün_Giriþi() {
		return guidata.getJpaneldata().getFirmaya_Yeni_Türde_Ürün_Giriþi();
	}

	public void setFirmaya_Yeni_Türde_Ürün_Giriþi(
			JPanel firmaya_Yeni_Türde_Ürün_Giriþi) {
		guidata.getJpaneldata().setFirmaya_Yeni_Türde_Ürün_Giriþi(firmaya_Yeni_Türde_Ürün_Giriþi);
	}

	public JPanel getAdýndan_Ürün_Arama_ve_Silme() {
		return guidata.getJpaneldata().getAdýndan_Ürün_Arama_ve_Silme();
	}

	public void setAdýndan_Ürün_Arama_ve_Silme(
			JPanel adýndan_Ürün_Arama_ve_Silme) {
		guidata.getJpaneldata().setAdýndan_Ürün_Arama_ve_Silme(adýndan_Ürün_Arama_ve_Silme);
	}

	public JPanel getÜrün_Bilgilerinde_Deðiþiklik() {
		return guidata.getJpaneldata().getÜrün_Bilgilerinde_Deðiþiklik();
	}

	public void setÜrün_Bilgilerinde_Deðiþiklik(
			JPanel ürün_Bilgilerinde_Deðiþiklik) {
		guidata.getJpaneldata().setÜrün_Bilgilerinde_Deðiþiklik(ürün_Bilgilerinde_Deðiþiklik);
	}

	public JPanel getYeni_Hastalýk_Bilgisi_Giriþi() {
		return guidata.getJpaneldata().getYeni_Hastalýk_Bilgisi_Giriþi();
	}

	public void setYeni_Hastalýk_Bilgisi_Giriþi(
			JPanel yeni_Hastalýk_Bilgisi_Giriþi) {
		guidata.getJpaneldata().setYeni_Hastalýk_Bilgisi_Giriþi(yeni_Hastalýk_Bilgisi_Giriþi);
	}

	public JLabel getjLabel2() {
		return guidata.getJpaneldata().getjLabel2();
	}

	public void setjLabel2(JLabel jLabel2) {
		this.guidata.getJpaneldata().setjLabel2(jLabel2);
	}

	public JLabel getjLabel3() {
		return guidata.getJpaneldata().getjLabel3();
	}

	public void setjLabel3(JLabel jLabel3) {
		this.guidata.getJpaneldata().setjLabel3(jLabel3);
	}

	public JLabel getjLabel4() {
		return guidata.getJpaneldata().getjLabel4();
	}

	public void setjLabel4(JLabel jLabel4) {
		this.guidata.getJpaneldata().setjLabel4(jLabel4);
	}

	public JLabel getjLabel5() {
		return guidata.getJpaneldata().getjLabel5();
	}

	public void setjLabel5(JLabel jLabel5) {
		this.guidata.getJpaneldata().setjLabel5(jLabel5);
	}

	public JPanel getKategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma() {
		return guidata.getJpaneldata()
				.getKategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma();
	}

	public void setKategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma(
			JPanel kategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma) {
		guidata.getJpaneldata()
				.setKategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma(kategori_Listeleme_Aðaç_Derinlliði_ve_Eleman_Sayýsýný_Yazdýrma);
	}

	public JPanel getKategori_Aðaçlarýný_Dengeleme() {
		return guidata.getJpaneldata().getKategori_Aðaçlarýný_Dengeleme();
	}

	public void setKategori_Aðaçlarýný_Dengeleme(
			JPanel kategori_Aðaçlarýný_Dengeleme) {
		guidata.getJpaneldata().setKategori_Aðaçlarýný_Dengeleme(kategori_Aðaçlarýný_Dengeleme);
	}

	public JPanel getVerilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan() {
		return guidata.getJpaneldata()
				.getVerilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan();
	}

	public void setVerilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan(
			JPanel verilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan) {
		guidata.getJpaneldata()
				.setVerilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan(verilen_Bir_Hastalýða_Ýliþkin_Bilgilerin_Listelenmesi_Hash_Table_Dan);
	}

	public JPanel getBelli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý() {
		return guidata.getJpaneldata()
				.getBelli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý();
	}

	public void setBelli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý(
			JPanel belli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý) {
		guidata.getJpaneldata()
				.setBelli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý(belli_Bir_Hastalýða_Ýyi_Gelebilen_Bitkilerin_Fiyatlarýna_Göre_Heap_e_Atýlmasý_ve_N_Tanesinden_Birer_Paket_Satýn_Alýnmasý);
	}

	public JLabel getjLabel6() {
		return guidata.getJpaneldata().getjLabel6();
	}

	public void setjLabel6(JLabel jLabel6) {
		this.guidata.getJpaneldata().setjLabel6(jLabel6);
	}

	public JLabel getjLabel7() {
		return guidata.getJpaneldata().getjLabel7();
	}

	public void setjLabel7(JLabel jLabel7) {
		this.guidata.getJpaneldata().setjLabel7(jLabel7);
	}

	public JLabel getjLabel8() {
		return guidata.getJpaneldata().getjLabel8();
	}

	public void setjLabel8(JLabel jLabel8) {
		this.guidata.getJpaneldata().setjLabel8(jLabel8);
	}

	public JLabel getjLabel9() {
		return guidata.getJpaneldata().getjLabel9();
	}

	public void setjLabel9(JLabel jLabel9) {
		this.guidata.getJpaneldata().setjLabel9(jLabel9);
	}

	public JLabel getjLabel10() {
		return guidata.getJpaneldata().getjLabel10();
	}

	public void setjLabel10(JLabel jLabel10) {
		this.guidata.getJpaneldata().setjLabel10(jLabel10);
	}

	public JTabbedPane getjTabbedPane3() {
		return guidata.getJtabbedpanedata().getjTabbedPane3();
	}

	public void setjTabbedPane3(JTabbedPane jTabbedPane3) {
		this.guidata.getJtabbedpanedata().setjTabbedPane3(jTabbedPane3);
	}

	public JPanel getjPanel16() {
		return guidata.getJpaneldata().getjPanel16();
	}

	public void setjPanel16(JPanel jPanel16) {
		this.guidata.getJpaneldata().setjPanel16(jPanel16);
	}

	public JLabel getjLabel61() {
		return guidata.getJpaneldata().getjLabel61();
	}

	public void setjLabel61(JLabel jLabel61) {
		this.guidata.getJpaneldata().setjLabel61(jLabel61);
	}

	public JLabel getjLabel11() {
		return guidata.getJpaneldata().getjLabel11();
	}

	public void setjLabel11(JLabel jLabel11) {
		this.guidata.getJpaneldata().setjLabel11(jLabel11);
	}

	public JLabel getjLabel12() {
		return guidata.getJpaneldata().getjLabel12();
	}

	public void setjLabel12(JLabel jLabel12) {
		this.guidata.getJpaneldata().setjLabel12(jLabel12);
	}

	public JTabbedPane getKategori_Ekleme_ve_Silme_Menüsü() {
		return guidata.getJtabbedpanedata().getKategori_Ekleme_ve_Silme_Menüsü();
	}

	public void setKategori_Ekleme_ve_Silme_Menüsü(
			JTabbedPane kategori_Ekleme_ve_Silme_Menüsü) {
		guidata.getJtabbedpanedata().setKategori_Ekleme_ve_Silme_Menüsü(kategori_Ekleme_ve_Silme_Menüsü);
	}

	public JPanel getKategori_Ekleme() {
		return guidata.getJpaneldata().getKategori_Ekleme();
	}

	public void setKategori_Ekleme(JPanel kategori_Ekleme) {
		guidata.getJpaneldata().setKategori_Ekleme(kategori_Ekleme);
	}

	public JPanel getKategori_Silme() {
		return guidata.getJpaneldata().getKategori_Silme();
	}

	public void setKategori_Silme(JPanel kategori_Silme) {
		guidata.getJpaneldata().setKategori_Silme(kategori_Silme);
	}

	public JLabel getjLabel13() {
		return guidata.getJpaneldata().getjLabel13();
	}

	public void setjLabel13(JLabel jLabel13) {
		this.guidata.getJpaneldata().setjLabel13(jLabel13);
	}

	public JLabel getjLabel14() {
		return guidata.getJpaneldata().getjLabel14();
	}

	public void setjLabel14(JLabel jLabel14) {
		this.guidata.getJpaneldata().setjLabel14(jLabel14);
	}

	public JLabel getjLabel15() {
		return guidata.getJpaneldata().getjLabel15();
	}

	public void setjLabel15(JLabel jLabel15) {
		this.guidata.getJpaneldata().setjLabel15(jLabel15);
	}

	public JLabel getjLabel16() {
		return guidata.getJpaneldata().getjLabel16();
	}

	public void setjLabel16(JLabel jLabel16) {
		this.guidata.getJpaneldata().setjLabel16(jLabel16);
	}

	public JLabel getjLabel17() {
		return guidata.getJpaneldata().getjLabel17();
	}

	public void setjLabel17(JLabel jLabel17) {
		this.guidata.getJpaneldata().setjLabel17(jLabel17);
	}

	public JLabel getjLabel18() {
		return guidata.getJpaneldata().getjLabel18();
	}

	public void setjLabel18(JLabel jLabel18) {
		this.guidata.getJpaneldata().setjLabel18(jLabel18);
	}

	public JTextArea getjTextArea() {
		return guidata.getJtextareadata().getjTextArea();
	}

	public void setjTextArea(JTextArea jTextArea) {
		this.guidata.getJtextareadata().setjTextArea(jTextArea);
	}

	public JPanel getAdýndan_Ürün_Arama_ve_Listeleme() {
		return guidata.getJpaneldata().getAdýndan_Ürün_Arama_ve_Listeleme();
	}

	public void setAdýndan_Ürün_Arama_ve_Listeleme(
			JPanel adýndan_Ürün_Arama_ve_Listeleme) {
		guidata.getJpaneldata().setAdýndan_Ürün_Arama_ve_Listeleme(adýndan_Ürün_Arama_ve_Listeleme);
	}

	public JPanel getjPanel23() {
		return guidata.getJpaneldata().getjPanel23();
	}

	public void setjPanel23(JPanel jPanel23) {
		this.guidata.getJpaneldata().setjPanel23(jPanel23);
	}

	public JLabel getjLabel21() {
		return guidata.getJpaneldata().getjLabel21();
	}

	public void setjLabel21(JLabel jLabel21) {
		this.guidata.getJpaneldata().setjLabel21(jLabel21);
	}

	public JTextArea getjTextArea1() {
		return guidata.getJtextareadata().getjTextArea1();
	}

	public void setjTextArea1(JTextArea jTextArea1) {
		this.guidata.getJtextareadata().setjTextArea1(jTextArea1);
	}

	public JButton getjButton() {
		return guidata.getJbuttondata().getjButton();
	}

	public void setjButton(JButton jButton) {
		this.guidata.getJbuttondata().setjButton(jButton);
	}

	public JTabbedPane getjTabbedPane6() {
		return guidata.getJtabbedpanedata().getjTabbedPane6();
	}

	public void setjTabbedPane6(JTabbedPane jTabbedPane6) {
		this.guidata.getJtabbedpanedata().setjTabbedPane6(jTabbedPane6);
	}

	public JPanel getjPanel11() {
		return guidata.getJpaneldata().getjPanel11();
	}

	public void setjPanel11(JPanel jPanel11) {
		this.guidata.getJpaneldata().setjPanel11(jPanel11);
	}

	public JPanel getjPanel24() {
		return guidata.getJpaneldata().getjPanel24();
	}

	public void setjPanel24(JPanel jPanel24) {
		this.guidata.getJpaneldata().setjPanel24(jPanel24);
	}

	public JPanel getjPanel25() {
		return guidata.getJpaneldata().getjPanel25();
	}

	public void setjPanel25(JPanel jPanel25) {
		this.guidata.getJpaneldata().setjPanel25(jPanel25);
	}

	public JLabel getjLabel22() {
		return guidata.getJpaneldata().getjLabel22();
	}

	public void setjLabel22(JLabel jLabel22) {
		this.guidata.getJpaneldata().setjLabel22(jLabel22);
	}

	public JLabel getjLabel23() {
		return guidata.getJpaneldata().getjLabel23();
	}

	public void setjLabel23(JLabel jLabel23) {
		this.guidata.getJpaneldata().setjLabel23(jLabel23);
	}

	public JLabel getjLabel24() {
		return guidata.getJpaneldata().getjLabel24();
	}

	public void setjLabel24(JLabel jLabel24) {
		this.guidata.getJpaneldata().setjLabel24(jLabel24);
	}

	public JScrollPane getjScrollPane1() {
		return guidata.getjScrollPane1();
	}

	public void setjScrollPane1(JScrollPane jScrollPane1) {
		this.guidata.setjScrollPane1(jScrollPane1);
	}

	public JTextArea getjTextArea3() {
		return guidata.getJtextareadata().getjTextArea3();
	}

	public void setjTextArea3(JTextArea jTextArea3) {
		this.guidata.getJtextareadata().setjTextArea3(jTextArea3);
	}

	public JLabel getjLabel25() {
		return guidata.getJpaneldata().getjLabel25();
	}

	public void setjLabel25(JLabel jLabel25) {
		this.guidata.getJpaneldata().setjLabel25(jLabel25);
	}

	public JTextField getjTextField1() {
		return guidata.getJtextfielddata().getjTextField1();
	}

	public void setjTextField1(JTextField jTextField1) {
		this.guidata.getJtextfielddata().setjTextField1(jTextField1);
	}

	public JButton getjButton1() {
		return guidata.getJpaneldata().getjButton1();
	}

	public void setjButton1(JButton jButton1) {
		this.guidata.getJpaneldata().setjButton1(jButton1);
	}

	public JTextArea getjTextArea5() {
		return guidata.getJtextareadata().getjTextArea5();
	}

	public void setjTextArea5(JTextArea jTextArea5) {
		this.guidata.getJtextareadata().setjTextArea5(jTextArea5);
	}

	public JLabel getjLabel26() {
		return guidata.getJpaneldata().getjLabel26();
	}

	public void setjLabel26(JLabel jLabel26) {
		this.guidata.getJpaneldata().setjLabel26(jLabel26);
	}

	public JButton getjButton2() {
		return guidata.getJbuttondata().getjButton2();
	}

	public void setjButton2(JButton jButton2) {
		this.guidata.getJbuttondata().setjButton2(jButton2);
	}

	public JButton getjButton3() {
		return guidata.getJbuttondata().getjButton3();
	}

	public void setjButton3(JButton jButton3) {
		this.guidata.getJbuttondata().setjButton3(jButton3);
	}

	public JButton getjButton4() {
		return guidata.getJbuttondata().getjButton4();
	}

	public void setjButton4(JButton jButton4) {
		this.guidata.getJbuttondata().setjButton4(jButton4);
	}

	public JTextArea getjTextArea2() {
		return guidata.getJtextareadata().getjTextArea2();
	}

	public void setjTextArea2(JTextArea jTextArea2) {
		this.guidata.getJtextareadata().setjTextArea2(jTextArea2);
	}

	public String getYanýt() {
		return stringdata.getYanýt();
	}

	public void setYanýt(String yanýt) {
		this.stringdata.setYanýt(yanýt);
	}

	public JTextArea getjTextArea6() {
		return guidata.getJtextareadata().getjTextArea6();
	}

	public void setjTextArea6(JTextArea jTextArea6) {
		this.guidata.getJtextareadata().setjTextArea6(jTextArea6);
	}

	public JLabel getjLabel28() {
		return guidata.getJpaneldata().getjLabel28();
	}

	public void setjLabel28(JLabel jLabel28) {
		this.guidata.getJpaneldata().setjLabel28(jLabel28);
	}

	public JLabel getjLabel29() {
		return guidata.getJpaneldata().getjLabel29();
	}

	public void setjLabel29(JLabel jLabel29) {
		this.guidata.getJpaneldata().setjLabel29(jLabel29);
	}

	public JButton getjButton5() {
		return guidata.getJbuttondata().getjButton5();
	}

	public void setjButton5(JButton jButton5) {
		this.guidata.getJbuttondata().setjButton5(jButton5);
	}

	public JButton getjButton6() {
		return guidata.getJbuttondata().getjButton6();
	}

	public void setjButton6(JButton jButton6) {
		this.guidata.getJbuttondata().setjButton6(jButton6);
	}

	public JLabel getjLabel30() {
		return guidata.getJpaneldata().getjLabel30();
	}

	public void setjLabel30(JLabel jLabel30) {
		this.guidata.getJpaneldata().setjLabel30(jLabel30);
	}

	public JTextArea getjTextArea4() {
		return guidata.getJtextareadata().getjTextArea4();
	}

	public void setjTextArea4(JTextArea jTextArea4) {
		this.guidata.getJtextareadata().setjTextArea4(jTextArea4);
	}

	public JLabel getjLabel31() {
		return guidata.getJpaneldata().getjLabel31();
	}

	public void setjLabel31(JLabel jLabel31) {
		this.guidata.getJpaneldata().setjLabel31(jLabel31);
	}

	public JTextField getjTextField4() {
		return guidata.getJtextfielddata().getjTextField4();
	}

	public void setjTextField4(JTextField jTextField4) {
		this.guidata.getJtextfielddata().setjTextField4(jTextField4);
	}

	public JButton getjButton7() {
		return guidata.getJbuttondata().getjButton7();
	}

	public void setjButton7(JButton jButton7) {
		this.guidata.getJbuttondata().setjButton7(jButton7);
	}

	public JButton getKategori_Listeleyici() {
		return guidata.getJbuttondata().getKategori_Listeleyici();
	}

	public void setKategori_Listeleyici(JButton kategori_Listeleyici) {
		guidata.getJbuttondata().setKategori_Listeleyici(kategori_Listeleyici);
	}

	public JLabel getjLabel() {
		return guidata.getJpaneldata().getjLabel();
	}

	public void setjLabel(JLabel jLabel) {
		this.guidata.getJpaneldata().setjLabel(jLabel);
	}

	public JLabel getjLabel1() {
		return guidata.getJpaneldata().getjLabel1();
	}

	public void setjLabel1(JLabel jLabel1) {
		this.guidata.getJpaneldata().setjLabel1(jLabel1);
	}

	public JTextField getjTextField6() {
		return guidata.getJtextfielddata().getjTextField6();
	}

	public void setjTextField6(JTextField jTextField6) {
		this.guidata.getJtextfielddata().setjTextField6(jTextField6);
	}

	public JButton getjButton8() {
		return guidata.getJbuttondata().getjButton8();
	}

	public void setjButton8(JButton jButton8) {
		this.guidata.getJbuttondata().setjButton8(jButton8);
	}

	public JButton getjButton9() {
		return guidata.getJbuttondata().getjButton9();
	}

	public void setjButton9(JButton jButton9) {
		this.guidata.getJbuttondata().setjButton9(jButton9);
	}

	public JLabel getjLabel32() {
		return guidata.getJpaneldata().getjLabel32();
	}

	public void setjLabel32(JLabel jLabel32) {
		this.guidata.getJpaneldata().setjLabel32(jLabel32);
	}

	public JButton getKategori_Listeleyici_2() {
		return guidata.getJbuttondata().getKategori_Listeleyici_2();
	}

	public void setKategori_Listeleyici_2(JButton kategori_Listeleyici_2) {
		guidata.getJbuttondata().setKategori_Listeleyici_2(kategori_Listeleyici_2);
	}

	public JTextArea getjTextArea7() {
		return guidata.getJtextareadata().getjTextArea7();
	}

	public void setjTextArea7(JTextArea jTextArea7) {
		this.guidata.getJtextareadata().setjTextArea7(jTextArea7);
	}

	public JLabel getjLabel19() {
		return guidata.getJpaneldata().getjLabel19();
	}

	public void setjLabel19(JLabel jLabel19) {
		this.guidata.getJpaneldata().setjLabel19(jLabel19);
	}

	public JButton getjButton10() {
		return guidata.getJbuttondata().getjButton10();
	}

	public void setjButton10(JButton jButton10) {
		this.guidata.getJbuttondata().setjButton10(jButton10);
	}

	public JLabel getjLabel20() {
		return guidata.getJpaneldata().getjLabel20();
	}

	public void setjLabel20(JLabel jLabel20) {
		this.guidata.getJpaneldata().setjLabel20(jLabel20);
	}

	public JTextField getjTextField8() {
		return guidata.getJtextfielddata().getjTextField8();
	}

	public void setjTextField8(JTextField jTextField8) {
		this.guidata.getJtextfielddata().setjTextField8(jTextField8);
	}

	public JButton getjButton11() {
		return guidata.getJbuttondata().getjButton11();
	}

	public void setjButton11(JButton jButton11) {
		this.guidata.getJbuttondata().setjButton11(jButton11);
	}

	public JLabel getjLabel33() {
		return guidata.getJpaneldata().getjLabel33();
	}

	public void setjLabel33(JLabel jLabel33) {
		this.guidata.getJpaneldata().setjLabel33(jLabel33);
	}

	public JButton getÜrün_Bilgisi_Listeleyici() {
		return guidata.getJbuttondata().getÜrün_Bilgisi_Listeleyici();
	}

	public void setÜrün_Bilgisi_Listeleyici(JButton ürün_Bilgisi_Listeleyici) {
		guidata.getJbuttondata().setÜrün_Bilgisi_Listeleyici(ürün_Bilgisi_Listeleyici);
	}

	public JTextArea getGeçici_metin_kutusu() {
		return guidata.getJtextareadata().getGeçici_metin_kutusu();
	}

	public void setGeçici_metin_kutusu(JTextArea geçici_metin_kutusu) {
		this.guidata.getJtextareadata().setGeçici_metin_kutusu(geçici_metin_kutusu);
	}

	public JTextField getjTextField9() {
		return guidata.getJtextfielddata().getjTextField9();
	}

	public void setjTextField9(JTextField jTextField9) {
		this.guidata.getJtextfielddata().setjTextField9(jTextField9);
	}

	public JLabel getjLabel34() {
		return guidata.getJpaneldata().getjLabel34();
	}

	public void setjLabel34(JLabel jLabel34) {
		this.guidata.getJpaneldata().setjLabel34(jLabel34);
	}

	public JButton getjButton12() {
		return guidata.getJbuttondata().getjButton12();
	}

	public void setjButton12(JButton jButton12) {
		this.guidata.getJbuttondata().setjButton12(jButton12);
	}

	public JTextArea getjTextArea9() {
		return guidata.getJtextareadata().getjTextArea9();
	}

	public void setjTextArea9(JTextArea jTextArea9) {
		this.guidata.getJtextareadata().setjTextArea9(jTextArea9);
	}

	public JLabel getjLabel35() {
		return guidata.getJpaneldata().getjLabel35();
	}

	public void setjLabel35(JLabel jLabel35) {
		this.guidata.getJpaneldata().setjLabel35(jLabel35);
	}

	public JTextField getjTextField10() {
		return guidata.getJtextfielddata().getjTextField10();
	}

	public void setjTextField10(JTextField jTextField10) {
		this.guidata.getJtextfielddata().setjTextField10(jTextField10);
	}

	public JLabel getjLabel37() {
		return guidata.getJpaneldata().getjLabel37();
	}

	public void setjLabel37(JLabel jLabel37) {
		this.guidata.getJpaneldata().setjLabel37(jLabel37);
	}

	public JTextField getjTextField12() {
		return guidata.getJtextfielddata().getjTextField12();
	}

	public void setjTextField12(JTextField jTextField12) {
		this.guidata.getJtextfielddata().setjTextField12(jTextField12);
	}

	public JButton getjButton14() {
		return guidata.getJbuttondata().getjButton14();
	}

	public void setjButton14(JButton jButton14) {
		this.guidata.getJbuttondata().setjButton14(jButton14);
	}

	public JLabel getjLabel38() {
		return guidata.getJpaneldata().getjLabel38();
	}

	public void setjLabel38(JLabel jLabel38) {
		this.guidata.getJpaneldata().setjLabel38(jLabel38);
	}

	public JTextField getjTextField13() {
		return guidata.getJtextfielddata().getjTextField13();
	}

	public void setjTextField13(JTextField jTextField13) {
		this.guidata.getJtextfielddata().setjTextField13(jTextField13);
	}

	public JButton getjButton15() {
		return guidata.getJbuttondata().getjButton15();
	}

	public void setjButton15(JButton jButton15) {
		this.guidata.getJbuttondata().setjButton15(jButton15);
	}

	public JLabel getjLabel39() {
		return guidata.getJpaneldata().getjLabel39();
	}

	public void setjLabel39(JLabel jLabel39) {
		this.guidata.getJpaneldata().setjLabel39(jLabel39);
	}

	public JTextField getjTextField14() {
		return guidata.getJtextfielddata().getjTextField14();
	}

	public void setjTextField14(JTextField jTextField14) {
		this.guidata.getJtextfielddata().setjTextField14(jTextField14);
	}

	public JButton getjButton16() {
		return guidata.getJbuttondata().getjButton16();
	}

	public void setjButton16(JButton jButton16) {
		this.guidata.getJbuttondata().setjButton16(jButton16);
	}

	public JLabel getjLabel40() {
		return guidata.getJpaneldata().getjLabel40();
	}

	public void setjLabel40(JLabel jLabel40) {
		this.guidata.getJpaneldata().setjLabel40(jLabel40);
	}

	public JButton getjButton17() {
		return guidata.getJbuttondata().getjButton17();
	}

	public void setjButton17(JButton jButton17) {
		this.guidata.getJbuttondata().setjButton17(jButton17);
	}

	public JTextField getjTextField15() {
		return guidata.getJtextfielddata().getjTextField15();
	}

	public void setjTextField15(JTextField jTextField15) {
		this.guidata.getJtextfielddata().setjTextField15(jTextField15);
	}

	public JTextArea getjTextArea10() {
		return guidata.getJtextareadata().getjTextArea10();
	}

	public void setjTextArea10(JTextArea jTextArea10) {
		this.guidata.getJtextareadata().setjTextArea10(jTextArea10);
	}

	public JLabel getjLabel41() {
		return guidata.getJpaneldata().getjLabel41();
	}

	public void setjLabel41(JLabel jLabel41) {
		this.guidata.getJpaneldata().setjLabel41(jLabel41);
	}

	public JLabel getjLabel42() {
		return guidata.getJpaneldata().getjLabel42();
	}

	public void setjLabel42(JLabel jLabel42) {
		this.guidata.getJpaneldata().setjLabel42(jLabel42);
	}

	public JTextArea getjTextArea11() {
		return guidata.getJtextareadata().getjTextArea11();
	}

	public void setjTextArea11(JTextArea jTextArea11) {
		this.guidata.getJtextareadata().setjTextArea11(jTextArea11);
	}

	public JLabel getjLabel43() {
		return guidata.getJpaneldata().getjLabel43();
	}

	public void setjLabel43(JLabel jLabel43) {
		this.guidata.getJpaneldata().setjLabel43(jLabel43);
	}

	public JTextArea getjTextArea12() {
		return guidata.getJtextareadata().getjTextArea12();
	}

	public void setjTextArea12(JTextArea jTextArea12) {
		this.guidata.getJtextareadata().setjTextArea12(jTextArea12);
	}

	public JLabel getjLabel44() {
		return guidata.getJpaneldata().getjLabel44();
	}

	public void setjLabel44(JLabel jLabel44) {
		this.guidata.getJpaneldata().setjLabel44(jLabel44);
	}

	public JTextArea getjTextArea13() {
		return guidata.getJtextareadata().getjTextArea13();
	}

	public void setjTextArea13(JTextArea jTextArea13) {
		this.guidata.getJtextareadata().setjTextArea13(jTextArea13);
	}

	public JButton getjButton18() {
		return guidata.getJbuttondata().getjButton18();
	}

	public void setjButton18(JButton jButton18) {
		this.guidata.getJbuttondata().setjButton18(jButton18);
	}

	public JLabel getjLabel36() {
		return guidata.getJpaneldata().getjLabel36();
	}

	public void setjLabel36(JLabel jLabel36) {
		this.guidata.getJpaneldata().setjLabel36(jLabel36);
	}

	public JTextArea getjTextArea14() {
		return guidata.getJtextareadata().getjTextArea14();
	}

	public void setjTextArea14(JTextArea jTextArea14) {
		this.guidata.getJtextareadata().setjTextArea14(jTextArea14);
	}

	public JLabel getjLabel45() {
		return guidata.getJpaneldata().getjLabel45();
	}

	public void setjLabel45(JLabel jLabel45) {
		this.guidata.getJpaneldata().setjLabel45(jLabel45);
	}

	public Vector<String> getBelirtiler() {
		return stringdata.getBelirtiler();
	}

	public void setBelirtiler(Vector<String> belirtiler) {
		this.stringdata.setBelirtiler(belirtiler);
	}

	public Vector<String> getNedenler() {
		return stringdata.getNedenler();
	}

	public void setNedenler(Vector<String> nedenler) {
		this.stringdata.setNedenler(nedenler);
	}

	public Vector<String> getTedaviler() {
		return stringdata.getTedaviler();
	}

	public void setTedaviler(Vector<String> tedaviler) {
		this.stringdata.setTedaviler(tedaviler);
	}

	public Vector<String> getBitkiler() {
		return stringdata.getBitkiler();
	}

	public void setBitkiler(Vector<String> bitkiler) {
		this.stringdata.setBitkiler(bitkiler);
	}

	public JLabel getjLabel46() {
		return guidata.getJpaneldata().getjLabel46();
	}

	public void setjLabel46(JLabel jLabel46) {
		this.guidata.getJpaneldata().setjLabel46(jLabel46);
	}

	public JLabel getjLabel47() {
		return guidata.getJpaneldata().getjLabel47();
	}

	public void setjLabel47(JLabel jLabel47) {
		this.guidata.getJpaneldata().setjLabel47(jLabel47);
	}

	public JLabel getjLabel48() {
		return guidata.getJpaneldata().getjLabel48();
	}

	public void setjLabel48(JLabel jLabel48) {
		this.guidata.getJpaneldata().setjLabel48(jLabel48);
	}

	public JTextField getjTextField11() {
		return guidata.getJtextfielddata().getjTextField11();
	}

	public void setjTextField11(JTextField jTextField11) {
		this.guidata.getJtextfielddata().setjTextField11(jTextField11);
	}

	public JTextField getjTextField16() {
		return guidata.getJtextfielddata().getjTextField16();
	}

	public void setjTextField16(JTextField jTextField16) {
		this.guidata.getJtextfielddata().setjTextField16(jTextField16);
	}

	public JButton getjButton13() {
		return guidata.getJbuttondata().getjButton13();
	}

	public void setjButton13(JButton jButton13) {
		this.guidata.getJbuttondata().setjButton13(jButton13);
	}

	public JTextArea getjTextArea15() {
		return guidata.getJtextareadata().getjTextArea15();
	}

	public void setjTextArea15(JTextArea jTextArea15) {
		this.guidata.getJtextareadata().setjTextArea15(jTextArea15);
	}

	public JTextField getjTextField17() {
		return guidata.getJtextfielddata().getjTextField17();
	}

	public void setjTextField17(JTextField jTextField17) {
		this.guidata.getJtextfielddata().setjTextField17(jTextField17);
	}

	public JLabel getjLabel49() {
		return guidata.getJpaneldata().getjLabel49();
	}

	public void setjLabel49(JLabel jLabel49) {
		this.guidata.getJpaneldata().setjLabel49(jLabel49);
	}

	public JTextField getjTextField18() {
		return guidata.getJtextfielddata().getjTextField18();
	}

	public void setjTextField18(JTextField jTextField18) {
		this.guidata.getJtextfielddata().setjTextField18(jTextField18);
	}

	public JLabel getjLabel27() {
		return guidata.getJpaneldata().getjLabel27();
	}

	public void setjLabel27(JLabel jLabel27) {
		this.guidata.getJpaneldata().setjLabel27(jLabel27);
	}

	public JTextField getjTextField19() {
		return guidata.getJtextfielddata().getjTextField19();
	}

	public void setjTextField19(JTextField jTextField19) {
		this.guidata.getJtextfielddata().setjTextField19(jTextField19);
	}

	public JLabel getjLabel50() {
		return guidata.getJpaneldata().getjLabel50();
	}

	public void setjLabel50(JLabel jLabel50) {
		this.guidata.getJpaneldata().setjLabel50(jLabel50);
	}

	public JTextField getjTextField20() {
		return guidata.getJtextfielddata().getjTextField20();
	}

	public void setjTextField20(JTextField jTextField20) {
		this.guidata.getJtextfielddata().setjTextField20(jTextField20);
	}

	public JButton getjButton19() {
		return guidata.getJbuttondata().getjButton19();
	}

	public void setjButton19(JButton jButton19) {
		this.guidata.getJbuttondata().setjButton19(jButton19);
	}
}