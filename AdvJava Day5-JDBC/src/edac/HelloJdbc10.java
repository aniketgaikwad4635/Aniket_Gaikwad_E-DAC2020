package edac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class HelloJdbc10 {

	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/edac";
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "edac2020";

	public static void main(String[] args) throws Exception {

		Connection con = null;
		try {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter USERID ");
			int qid = scanner.nextInt();

			Class.forName(DB_DRIVER);

			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			String sql = "SELECT * FROM USER WHERE ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, qid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String username = rs.getString("USERNAME");

				System.out.println(id + " " + username);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}

	}
}


