package herbalist;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;

public class Herbalist_AppGUIData {
	private JFrame Herbalist_Application;
	private JMenuBar jJMenuBar;
	private Herbalist_AppJMenuData jmenudata;
	private Herbalist_AppJMenuItemData jmenuitemdata;
	private JDialog aboutDialog;
	private Herbalist_AppJTabbedPaneData jtabbedpanedata;
	private JScrollPane jScrollPane1;
	private Herbalist_AppJTextAreaData jtextareadata;
	private Herbalist_AppJPanelData jpaneldata;
	private Herbalist_AppJTextFieldData jtextfielddata;
	private Herbalist_AppJButtonData jbuttondata;

	public Herbalist_AppGUIData(Herbalist_AppJMenuData jmenudata,
			Herbalist_AppJMenuItemData jmenuitemdata,
			Herbalist_AppJTabbedPaneData jtabbedpanedata,
			Herbalist_AppJTextAreaData jtextareadata,
			Herbalist_AppJPanelData jpaneldata,
			Herbalist_AppJTextFieldData jtextfielddata,
			Herbalist_AppJButtonData jbuttondata) {
		this.jmenudata = jmenudata;
		this.jmenuitemdata = jmenuitemdata;
		this.jtabbedpanedata = jtabbedpanedata;
		this.jtextareadata = jtextareadata;
		this.jpaneldata = jpaneldata;
		this.jtextfielddata = jtextfielddata;
		this.jbuttondata = jbuttondata;
	}

	public JFrame getHerbalist_Application() {
		return Herbalist_Application;
	}

	public void setHerbalist_Application(JFrame herbalist_Application) {
		Herbalist_Application = herbalist_Application;
	}

	public JMenuBar getjJMenuBar() {
		return jJMenuBar;
	}

	public void setjJMenuBar(JMenuBar jJMenuBar) {
		this.jJMenuBar = jJMenuBar;
	}

	public Herbalist_AppJMenuData getJmenudata() {
		return jmenudata;
	}

	public void setJmenudata(Herbalist_AppJMenuData jmenudata) {
		this.jmenudata = jmenudata;
	}

	public Herbalist_AppJMenuItemData getJmenuitemdata() {
		return jmenuitemdata;
	}

	public void setJmenuitemdata(Herbalist_AppJMenuItemData jmenuitemdata) {
		this.jmenuitemdata = jmenuitemdata;
	}

	public JDialog getAboutDialog() {
		return aboutDialog;
	}

	public void setAboutDialog(JDialog aboutDialog) {
		this.aboutDialog = aboutDialog;
	}

	public Herbalist_AppJTabbedPaneData getJtabbedpanedata() {
		return jtabbedpanedata;
	}

	public void setJtabbedpanedata(Herbalist_AppJTabbedPaneData jtabbedpanedata) {
		this.jtabbedpanedata = jtabbedpanedata;
	}

	public JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public void setjScrollPane1(JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}

	public Herbalist_AppJTextAreaData getJtextareadata() {
		return jtextareadata;
	}

	public void setJtextareadata(Herbalist_AppJTextAreaData jtextareadata) {
		this.jtextareadata = jtextareadata;
	}

	public Herbalist_AppJPanelData getJpaneldata() {
		return jpaneldata;
	}

	public void setJpaneldata(Herbalist_AppJPanelData jpaneldata) {
		this.jpaneldata = jpaneldata;
	}

	public Herbalist_AppJTextFieldData getJtextfielddata() {
		return jtextfielddata;
	}

	public void setJtextfielddata(Herbalist_AppJTextFieldData jtextfielddata) {
		this.jtextfielddata = jtextfielddata;
	}

	public Herbalist_AppJButtonData getJbuttondata() {
		return jbuttondata;
	}

	public void setJbuttondata(Herbalist_AppJButtonData jbuttondata) {
		this.jbuttondata = jbuttondata;
	}
}