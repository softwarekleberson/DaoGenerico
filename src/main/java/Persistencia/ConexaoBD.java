package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/pooDao",
                							"postgres",
                							"VAISANTOS1");
	}
}
