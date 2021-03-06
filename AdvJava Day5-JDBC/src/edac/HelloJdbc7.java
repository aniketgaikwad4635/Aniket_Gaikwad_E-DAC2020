package edac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class HelloJdbc7 {
	
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/edac";
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "edac2020";
	
	public static void main(String[] args) throws Exception {
		
		Connection con = null;
		
		try {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter Username ");
			String username = scanner.nextLine();
			
			System.out.println("Enter Password ");
			String password = scanner.nextLine();
			
			System.out.println("Enter Email ");
			String email = scanner.nextLine();
			
			System.out.println("Enter Mobile ");
			String mobile = scanner.nextLine();
			
			System.out.println(username + password + email + mobile);
			
			// Dynamic Loading!! the class Driver
			Class.forName(DB_DRIVER);
			
			// Open Connection
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			String sql = "INSERT INTO  USER (USERNAME, PASSWORD, EMAIL, MOBILE) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, mobile);
			ps.executeUpdate();
			
			
			System.out.println("Insert Successful!!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally Block executed");
			// Close Connection
			con.close();
		}
		
	}

}


