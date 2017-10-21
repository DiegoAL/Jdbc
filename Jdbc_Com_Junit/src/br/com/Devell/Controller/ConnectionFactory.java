package br.com.Devell.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {
		String user = "root";
		String passwrd = "root";
		String urlConnection = "jdbc:mysql://localhost/biblioteca?useSSL=false";

		try {
			Connection connection = DriverManager.getConnection(urlConnection, user, passwrd);
			return connection;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
}
