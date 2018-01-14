package clientside;
import javax.swing.*;


public class ClientTest {

	public static void main(String[] args) {
		Client kassim = new Client("88.250.184.125");
		kassim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
        	if(kassim!=null) {
			kassim.startRunning();
        	}
        	System.out.println("kassim null deðil");
		} catch (NullPointerException e) {
			System.out.println("bir yerde null var");
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("bir yerde hata var");
			e.printStackTrace();
		}
	}

}
