package gui.server;

import java.awt.TextArea;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import server.ChatRoom;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatRoomApplet extends JApplet {
	/**
	 * 
	 */
	public static ChatRoom chatroom;
	private static final long serialVersionUID = 1L;
	public static JPanel panel = new JPanel();
	public static JLabel lblChatRoomApplet = new JLabel("ChatRoomApplet");
	public static JLabel lblKullanc�lar = new JLabel("Kullan\u0131c\u0131lar");
	public static JLabel lblGelenKutusu = new JLabel("Gelen Kutusu");
	public static TextArea GelenKutusu = new TextArea();
	public static TextArea Kullan�c�lar = new TextArea();
	public static JLabel lblGidenKutusu = new JLabel("Giden Kutusu");
	public static JButton btnYazMesajGnder;
	public static JTextArea Yaz�Mesaj� = new JTextArea();
	String kick = "kick";

	public ChatRoomApplet() {
		super();
		Boolean hata_var_m� = false;
		chatroom = new ChatRoom();
		if (chatroom != null) {
			if (chatroom.getHata_var_m�() == false) {
				getContentPane().setLayout(null);

				panel.setBounds(0, 0, 707, 418);
				getContentPane().add(panel);
				panel.setLayout(null);

				lblChatRoomApplet.setBounds(0, 0, 91, 14);
				panel.add(lblChatRoomApplet);

				lblKullanc�lar.setBounds(353, 22, 81, 14);
				panel.add(lblKullanc�lar);

				lblGelenKutusu.setBounds(0, 22, 91, 14);
				panel.add(lblGelenKutusu);

				GelenKutusu.setBounds(0, 42, 330, 240);
				GelenKutusu.setText("");
				panel.add(GelenKutusu);

				Kullan�c�lar.setBounds(353, 42, 330, 240);
				panel.add(Kullan�c�lar);

				lblGidenKutusu.setBounds(0, 309, 81, 14);
				panel.add(lblGidenKutusu);

				Yaz�Mesaj�.setBounds(0, 338, 330, 56);
				panel.add(Yaz�Mesaj�);

				btnYazMesajGnder = new JButton("Yaz\u0131 Mesaj\u0131 G\u00F6nder");
				btnYazMesajGnder.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						String message = "";
						Boolean hata_var_m� = false;
						message = Yaz�Mesaj�.getText();
						Yaz�Mesaj�.setText("");

						if (message.startsWith(kick)) {
							hata_var_m� = chatroom.getServer().kick(message);
							
						} else {
							message += "\n";// mesaj� kapat�yoruz
							hata_var_m� = chatroom.getServer().create_multi_message_writer_thread(message);
							if (hata_var_m� == false) {
								GelenKutusu.append(message);
							} else {
								// hata_var_m�=true;
								message = "Mesaj G�nderilemedi!";
								GelenKutusu.append(message);
								// threadin durdurulmas� gerekiyor
							}
						}
					}
				});
				btnYazMesajGnder.setBounds(353, 334, 148, 23);
				panel.add(btnYazMesajGnder);
			} else {
				// exit
			}
		} else {
			hata_var_m� = true;
			if (hata_var_m�) {
				System.exit(ERROR);
			} else {
				// continue
			}
		}
	}

	/**
	 * @return the chatroom
	 */
	public static ChatRoom getChatroom() {
		return chatroom;
	}

	/**
	 * @param chatroom
	 *            the chatroom to set
	 */
	public static void setChatroom(ChatRoom chatroom) {
		ChatRoomApplet.chatroom = chatroom;
	}
}
