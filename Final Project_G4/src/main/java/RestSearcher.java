import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class RestSearcher {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/db_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER = "root";
	static final String PASS = "000000";
	
	public RestSearcher() {
		mysql_connect();
	}
	
	public void mysql_connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			System.out.println("Can't find driver");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Restaurant searchByName(String name) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement stat = conn.prepareStatement("SELECT RestID, RName, Address, Phone, Business_hour, Closed, Vegan"
														 + " FROM Restaurant"
														 + " WHERE RName=?");
			stat.setString(1, name);
			ResultSet rs = stat.executeQuery();
			
			if(rs.next()) {
				Restaurant r = new Restaurant(rs.getString("RestID"), rs.getString("RName"), rs.getString("Address"), rs.getString("Phone"), rs.getString("Business_hour"), rs.getString("Closed"), rs.getString("Vegan"));
				return r;
			}else {
				return null;
			}
			
//			if(hasResult) {
//				ResultSet result = stat.getResultSet();
//				ResultSetMetaData metaData = result.getMetaData();
//				int columnCount = metaData.getColumnCount();
//			 
//				for (int i = 1; i <= columnCount; i++) {
//				 	str += metaData.getColumnLabel(i);
//				}
//			 
//				while (result.next()) {
//					for (int i = 1; i <= columnCount; i++) {
//						str += result.getString(i);
//				 	}
//			 	}
//			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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

	public void searchByType() {
		ArrayList<String> type = new ArrayList<String>();
		ArrayList<String> budget = new ArrayList<String>();
		ArrayList<String> time = new ArrayList<String>();
		ArrayList<String> distance = new ArrayList<String>();

		type.remove("不限");
		budget.remove("不限");
		time.remove("不限");
		distance.remove("不限");

		int count = 0;
		String query = "SELECT Name, Address, Phone, Business_hour, Closed, Vegan FROM Restaurant WHERE (";

		for (int i = 0; i < type.size(); i++) {
			if (count > 0) {
				query += " OR ";
			}
			query += "Type = " + type.get(i);
			count++;
		}
		query += ") AND (";

		for (int i = 0; i < budget.size(); i++) {
			query += " OR Budget = " + budget.get(i);
		}
		query += ") AND (";

		for (int i = 0; i < time.size(); i++) {
			query += " OR Time = " + time.get(i);
		}
		query += ") AND (";

		for (int i = 0; i < distance.size(); i++) {
			query += " OR Distance = " + distance.get(i);
		}
		query += ");";

		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stat = con.createStatement();
			boolean hasResult = stat.execute(query);

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
