package edac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class HelloJdbc8 {

	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/edac";
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "edac2020";
	
	public static void main(String[] args) throws Exception {
		
		Connection con = null;
		
		try {
			// Dynamic Loading!! the class Driver
			Class.forName(DB_DRIVER);
			
			// Open Connection
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			String sql = "UPDATE USER SET USERNAME='virat', EMAIL='virat@gmail.com' WHERE ID=1";
			PreparedStatement ps =  con.prepareStatement(sql);
			ps.executeUpdate();
			
			System.out.println("Update Successful!!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally Block executed");
			// Close Connection
			con.close();
		}
		
	}

}

