
public class Main {
	static Araba porþe;

	public String[] opel = { "Astra", "Vectra", "Insignia" };
	public String[] renault = { "Megane", "Laguna" };
	public String[] vw = { "Golf", "Passat" };

	// Variables declaration - do not modify//GEN-BEGIN:variables
	public javax.swing.JRadioButton b16;
	public javax.swing.JRadioButton b20;
	public javax.swing.ButtonGroup buttonGroup1;
	public javax.swing.ButtonGroup buttonGroup2;
	public javax.swing.JButton jButton1;
	public javax.swing.JLabel jLabel1;
	public javax.swing.JLabel jLabel2;
	public javax.swing.JLabel jLabel3;
	public javax.swing.JPanel jPanel2;
	public javax.swing.JPanel jPanel3;
	public javax.swing.JPanel jPanel4;
	public javax.swing.JScrollPane jScrollPane1;
	public javax.swing.JTextArea liste;
	public javax.swing.JRadioButton man;
	public javax.swing.JComboBox<?> marka;
	public javax.swing.JComboBox<?> model;
	public javax.swing.JCheckBox op1;
	public javax.swing.JCheckBox op2;
	public javax.swing.JCheckBox op3;
	public javax.swing.JRadioButton oto;
	// End of variables declaration//GEN-END:variables

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new Araba().setVisible(true);
			}
		});
	}

}
