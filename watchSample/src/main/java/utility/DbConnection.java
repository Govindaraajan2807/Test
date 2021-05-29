package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "Welcome@135$";
	private static final String url = "jdbc:mysql://localhost:3306/item";

	public Connection getConnection() {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return connection;
	}

	public void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
