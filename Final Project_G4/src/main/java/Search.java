import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Search {

	static final String DB_URL = "jdbc:mysql://140.119.203.60:3306/dbms_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER = "yenrong";
	static final String PASS = "dbmsproject";

	public void searchByName(String name) {
		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			String query = "SELECT Name, Address, Phone, Business_hour, Closed, Vegan FROM Restaurant WHERE Name = "
					+ name + ";";
			// 要呈現出哪些column?
			Statement stat = con.createStatement();
			boolean hasResult = stat.execute(query);

			/*
			 * if(hasResult) {
			 * ResultSet result = stat.getResultSet();
			 * ResultSetMetaData metaData = result.getMetaData();
			 * int columnCount = metaData.getColumnCount();
			 * 
			 * for (int i = 1; i <= columnCount; i++) {
			 * str += metaData.getColumnLabel(i);
			 * }
			 * 
			 * while (result.next()) {
			 * for (int i = 1; i <= columnCount; i++) {
			 * str += result.getString(i);
			 * }
			 * }
			 * }
			 */

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void searchByText(String partName) {
		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			PreparedStatement stat = con.prepareStatement("SELECT Name FROM Restaurant WHERE Name LIKE %?%;");
			stat.setString(1, partName);
			stat.execute();

			String name = ""; // 選擇的餐廳名
			// 判斷點了哪個
			searchByName(name);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void searchVegan() {
		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			String query = "SELECT Name, Address, Phone, Business_hour, Closed, Vegan FROM Restaurant WHERE Vegan = '是';";
			Statement stat = con.createStatement();
			boolean hasResult = stat.execute(query);

			/*
			 * if(hasResult) {
			 * ResultSet result = stat.getResultSet();
			 * ResultSetMetaData metaData = result.getMetaData();
			 * int columnCount = metaData.getColumnCount();
			 * 
			 * for (int i = 1; i <= columnCount; i++) {
			 * str += metaData.getColumnLabel(i);
			 * }
			 * 
			 * while (result.next()) {
			 * for (int i = 1; i <= columnCount; i++) {
			 * str += result.getString(i);
			 * }
			 * }
			 * }
			 */

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void menu(Restaurant r) {
		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			// 要呈現哪些?
			String query = "SELECT DishName, Price, Vegan, Nutrients FROM Menu WHERE RestID = " + r.getRestID() + ";";
			Statement stat = con.createStatement();
			boolean hasResult = stat.execute(query);

			/*
			 * if(hasResult) {
			 * ResultSet result = stat.getResultSet();
			 * ResultSetMetaData metaData = result.getMetaData();
			 * int columnCount = metaData.getColumnCount();
			 * 
			 * for (int i = 1; i <= columnCount; i++) {
			 * str += metaData.getColumnLabel(i);
			 * }
			 * 
			 * while (result.next()) {
			 * for (int i = 1; i <= columnCount; i++) {
			 * str += result.getString(i);
			 * }
			 * }
			 * }
			 */

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
