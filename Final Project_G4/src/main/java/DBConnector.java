import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://140.119.203.60:3306/yourDB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER = "benson";
	static final String PASS = "123456789";
	
	public DBConnector() {
		mysql_connect();
	}
	
	public void mysql_connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded!");			   
//			DriverManager.getConnection(DB_URL, USER, PASS);
//			System.out.println("mysql Connection Success");
			} catch (ClassNotFoundException e) {
				System.out.println("Can't find driver");
				e.printStackTrace();
			}
//			} catch(SQLException e) {
//				e.printStackTrace();
//			}
	}
	
	public String login(String email, String password) {
		
		
		
		return "";
	}
}
