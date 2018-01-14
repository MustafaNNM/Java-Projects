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
	public static JLabel lblKullancýlar = new JLabel("Kullan\u0131c\u0131lar");
	public static JLabel lblGelenKutusu = new JLabel("Gelen Kutusu");
	public static TextArea GelenKutusu = new TextArea();
	public static TextArea Kullanýcýlar = new TextArea();
	public static JLabel lblGidenKutusu = new JLabel("Giden Kutusu");
	public static JButton btnYazMesajGnder;
	public static JTextArea YazýMesajý = new JTextArea();
	String kick = "kick";

	public ChatRoomApplet() {
		super();
		Boolean hata_var_mý = false;
		chatroom = new ChatRoom();
		if (chatroom != null) {
			if (chatroom.getHata_var_mý() == false) {
				getContentPane().setLayout(null);

				panel.setBounds(0, 0, 707, 418);
				getContentPane().add(panel);
				panel.setLayout(null);

				lblChatRoomApplet.setBounds(0, 0, 91, 14);
				panel.add(lblChatRoomApplet);

				lblKullancýlar.setBounds(353, 22, 81, 14);
				panel.add(lblKullancýlar);

				lblGelenKutusu.setBounds(0, 22, 91, 14);
				panel.add(lblGelenKutusu);

				GelenKutusu.setBounds(0, 42, 330, 240);
				GelenKutusu.setText("");
				panel.add(GelenKutusu);

				Kullanýcýlar.setBounds(353, 42, 330, 240);
				panel.add(Kullanýcýlar);

				lblGidenKutusu.setBounds(0, 309, 81, 14);
				panel.add(lblGidenKutusu);

				YazýMesajý.setBounds(0, 338, 330, 56);
				panel.add(YazýMesajý);

				btnYazMesajGnder = new JButton("Yaz\u0131 Mesaj\u0131 G\u00F6nder");
				btnYazMesajGnder.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						String message = "";
						Boolean hata_var_mý = false;
						message = YazýMesajý.getText();
						YazýMesajý.setText("");

						if (message.startsWith(kick)) {
							hata_var_mý = chatroom.getServer().kick(message);
							
						} else {
							message += "\n";// mesajý kapatýyoruz
							hata_var_mý = chatroom.getServer().create_multi_message_writer_thread(message);
							if (hata_var_mý == false) {
								GelenKutusu.append(message);
							} else {
								// hata_var_mý=true;
								message = "Mesaj Gönderilemedi!";
								GelenKutusu.append(message);
								// threadin durdurulmasý gerekiyor
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
			hata_var_mý = true;
			if (hata_var_mý) {
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
