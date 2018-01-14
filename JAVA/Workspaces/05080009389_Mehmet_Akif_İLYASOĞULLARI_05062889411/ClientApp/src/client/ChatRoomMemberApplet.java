package client;

import java.awt.TextArea;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChatRoomMemberApplet extends JApplet {
	public static JPanel panel= new JPanel();
	public static JLabel lblChatRoomMemberApplet= new JLabel("ChatRoomMemberApplet");
	public static JLabel lblKullanclar=new JLabel("Kullan\u0131c\u0131lar");
	public static JLabel lblGelenKutusu= new JLabel("Gelen Kutusu");
	public static TextArea GelenKutusu= new TextArea();
	public static TextArea Kullan�c�lar= new TextArea();
	public static JLabel GidenKutusu= new JLabel("Giden Kutusu");
	public static JTextArea Yaz�Mesaj� = new JTextArea();
	public static JButton btnYazMesajGnder= new JButton("Yaz\u0131 Mesaj\u0131 G\u00F6nder");
	public static ChatRoomMember chatRoomMember=new ChatRoomMember();;
	public static String message="";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the applet.
	 */
	public ChatRoomMemberApplet() {
		super();
		getContentPane().setLayout(null);

		panel.setBounds(0, 0, 707, 418);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblChatRoomMemberApplet.setBounds(0, 0, 128, 14);
		panel.add(lblChatRoomMemberApplet);

		lblKullanclar.setBounds(366, 22, 81, 14);
		panel.add(lblKullanclar);

		lblGelenKutusu.setBounds(0, 22, 91, 14);
		panel.add(lblGelenKutusu);

		GelenKutusu.setBounds(0, 42, 330, 240);
		panel.add(GelenKutusu);

		Kullan�c�lar.setBounds(366, 42, 330, 240);
		panel.add(Kullan�c�lar);
		
		GidenKutusu.setBounds(0, 309, 81, 14);
		panel.add(GidenKutusu);
		
		Yaz�Mesaj�.setBounds(0, 338, 330, 56);
		panel.add(Yaz�Mesaj�);
		
		btnYazMesajGnder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				message=Yaz�Mesaj�.getText()+"\n";
				//client.create_single_message_writer_thread olmas� las�m
				chatRoomMember.getClient().create_single_message_writer_thread(message);
			}
		});
		btnYazMesajGnder.setBounds(366, 334, 148, 23);
		panel.add(btnYazMesajGnder);
	}
	
	/**
	 * @return the chatRoomMember
	 */
	public static ChatRoomMember getChatRoomMember() {
		return chatRoomMember;
	}

	/**
	 * @param chatRoomMember
	 *            the chatRoomMember to set
	 */
	public static void setChatRoomMember(ChatRoomMember chatRoomMember) {
		ChatRoomMemberApplet.chatRoomMember = chatRoomMember;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the panel
	 */
	public static JPanel getPanel() {
		return panel;
	}

	/**
	 * @param panel
	 *            the panel to set
	 */
	public static void setPanel(JPanel panel) {
		ChatRoomMemberApplet.panel = panel;
	}

	/**
	 * @return the lblNewLabel
	 */
	public static JLabel getLblNewLabel() {
		return lblChatRoomMemberApplet;
	}

	/**
	 * @param lblNewLabel
	 *            the lblNewLabel to set
	 */
	public static void setLblNewLabel(JLabel lblNewLabel) {
		ChatRoomMemberApplet.lblChatRoomMemberApplet = lblNewLabel;
	}

	/**
	 * @return the lblKullanclar
	 */
	public static JLabel getLblKullanclar() {
		return lblKullanclar;
	}

	/**
	 * @param lblKullanclar
	 *            the lblKullanclar to set
	 */
	public static void setLblKullanclar(JLabel lblKullanclar) {
		ChatRoomMemberApplet.lblKullanclar = lblKullanclar;
	}

	/**
	 * @return the lblGelenKutusu
	 */
	public static JLabel getLblGelenKutusu() {
		return lblGelenKutusu;
	}

	/**
	 * @param lblGelenKutusu
	 *            the lblGelenKutusu to set
	 */
	public static void setLblGelenKutusu(JLabel lblGelenKutusu) {
		ChatRoomMemberApplet.lblGelenKutusu = lblGelenKutusu;
	}

	/**
	 * @return the gelenKutusu
	 */
	public static TextArea getGelenKutusu() {
		return GelenKutusu;
	}

	/**
	 * @param gelenKutusu
	 *            the gelenKutusu to set
	 */
	public static void setGelenKutusu(TextArea gelenKutusu) {
		GelenKutusu = gelenKutusu;
	}

	/**
	 * @return the kullan�c�lar
	 */
	public static TextArea getKullan�c�lar() {
		return Kullan�c�lar;
	}

	/**
	 * @return the label
	 */
	public static JLabel getLabel() {
		return GidenKutusu;
	}

	/**
	 * @param label the label to set
	 */
	public static void setLabel(JLabel label) {
		ChatRoomMemberApplet.GidenKutusu = label;
	}

	/**
	 * @return the textArea
	 */
	public static JTextArea getTextArea() {
		return Yaz�Mesaj�;
	}

	/**
	 * @param textArea the textArea to set
	 */
	public static void setTextArea(JTextArea textArea) {
		ChatRoomMemberApplet.Yaz�Mesaj� = textArea;
	}

	/**
	 * @return the button
	 */
	public static JButton getButton() {
		return btnYazMesajGnder;
	}

	/**
	 * @param button the button to set
	 */
	public static void setButton(JButton button) {
		ChatRoomMemberApplet.btnYazMesajGnder = button;
	}

	/**
	 * @param kullan�c�lar
	 *            the kullan�c�lar to set
	 */
	public static void setKullan�c�lar(TextArea kullan�c�lar) {
		Kullan�c�lar = kullan�c�lar;
	}
}
