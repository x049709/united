package allchapters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EdDerbyQueries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBUtils dU = new DBUtils();
		dU.selectAnimals();
	}
}

class DBUtils {
	
	void selectAnimals()  {
		String urlString = "jdbc:derby:zoo";
		try (
			Connection conn = DriverManager.getConnection(urlString); 
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select name, date_born from animal")) 
		{
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t " +rs.getDate(2).toLocalDate() + "\t" + rs.getTime(2).toLocalTime());
			}
		} catch (SQLException e) {
			
		} finally {
			
		}
	}
}	
