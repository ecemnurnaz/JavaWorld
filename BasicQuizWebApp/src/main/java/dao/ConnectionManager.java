package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static String server = "localhost:3306";
	private static String database = "quiz";
	private static String username = "root";
	private static String password = "199092ecemNUR!";

	public static Connection getConnection() throws SQLException {

		Connection conn = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database, username, password);

		return conn;

	}

}
