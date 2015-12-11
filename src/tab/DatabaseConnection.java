package tab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	
	private static final String CONFIG = "databaseConfig";
	private final String databaseUrl;
	private final String userName;
	private final String password;
	private Connection connection;
	
	public DatabaseConnection() throws SQLException, FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(DatabaseConnection.CONFIG));
		
		this.userName = properties.getProperty("username");
		this.password = properties.getProperty("password");
		this.databaseUrl = properties.getProperty("databaseUrl");
	}

	public void openConnection() throws SQLException {
		connection = DriverManager.getConnection(databaseUrl , userName, password);
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
}
