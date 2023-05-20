import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://140.119.203.60:3306/dbms_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER = "benson";
	static final String PASS = "123456789";

	public DBConnector() {
		mysql_connect();
	}

	public void mysql_connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("mysql Connection Success");
		} catch (ClassNotFoundException e) {
			System.out.println("Can't find driver");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean login(String account, String password) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement stat = conn.prepareStatement("SELECT * FROM `user` WHERE Account = ? AND Password = ?");
			stat.setString(1, account);
			stat.setString(2, password);

			ResultSet rs = stat.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public String register(String account, String email, String password, String repassword) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Check userName duplication
			PreparedStatement stat = conn.prepareStatement("SELECT * "
														 + "FROM `user` WHERE Account = ?");
			stat.setString(1, account);
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				return "此名稱已被使用";
			}

			// Check email duplication
			stat = conn.prepareStatement("SELECT * "
									   + "FROM `user` WHERE Email = ?");
			stat.setString(1, email);
			rs = stat.executeQuery();
			if (rs.next()) {
				return "此Email已被使用";
			}
			
			if(!password.equals(repassword)) {
				return "密碼前後不一致";
			}

			// Insert values
			stat = conn.prepareStatement("INSERT INTO user(Account, Email, Password)\r\n"
									   + "VALUES (?, ?, ?);");
			stat.setString(1, account);
			stat.setString(2, email);
			stat.setString(3, password);
			stat.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return "發生未知錯誤";
		}
		return "註冊成功";
	}
}
