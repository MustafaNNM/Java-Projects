import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Created on 06.Mar.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author cenk
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class vtornek1 {

	public static void main(String[] args) {
		Statement stmt1;
		ResultSet rs1;
		try {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			} catch (Exception e) {
				System.out.println("Driver Yüklemesi Hatasý\n");
			}

			Connection dbCon =
				DriverManager.getConnection("jdbc:odbc:kursvtlogical", "", "");
			stmt1 = dbCon.createStatement();
			rs1 = stmt1.executeQuery("select * from Tablo1");
			while (rs1.next()) {
				System.out.println(rs1.getInt("no") + ",");
				System.out.println(rs1.getString("ad") + ",");
				System.out.println(rs1.getString("soyad") + ",");
				System.out.println(rs1.getString("adres") + "..." + " \n ");
			}
			rs1 = stmt1.executeQuery("select * from Tablo1 where ad='veli'");
			while (rs1.next()) {
				System.out.println(rs1.getInt("no") + ",");
				System.out.println(rs1.getString("ad") + ",");
				System.out.println(rs1.getString("soyad") + ",");
				System.out.println(rs1.getString("adres") + "..." + " \n ");
			}
			stmt1.close();
			dbCon.close();
		} catch (SQLException se) {
			System.out.println("\n SQL EXCEPTION=" + se.getMessage() + "\n");
		}
	}
}
