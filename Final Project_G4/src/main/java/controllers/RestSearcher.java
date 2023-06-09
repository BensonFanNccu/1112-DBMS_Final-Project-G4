package controllers;

import entities.Restaurant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RestSearcher {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://140.119.203.60:3306/db_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER = "benson";
	static final String PASS = "123456789";
	
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
	
	public String searchByText(String input) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement stat = conn.prepareStatement("SELECT Name "
														 + "FROM `Restaurant` "
														 + "WHERE Name LIKE ?");
			stat.setString(1, "%" + input + "%");
			ResultSet rs = stat.executeQuery();
			
			if(rs.next()) {
				return rs.getString("Name");
			}else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getIdByName(String name) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement stat = conn.prepareStatement("SELECT RestID"
														 + " FROM Restaurant"
														 + " WHERE Name=?");
			stat.setString(1, name);
			ResultSet rs = stat.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("RestID");
				return id;
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Restaurant getRestaurant(String restID) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement stat = conn.prepareStatement("SELECT * "
														 + "FROM Restaurant "
														 + "WHERE RestID=?");
			stat.setString(1, restID);
			ResultSet rs = stat.executeQuery();
			
			if(rs.next()) {
				Restaurant r = new Restaurant(restID, rs.getString("Name"), rs.getString("Address"), rs.getString("Dining_time"));
				return r;
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getNameById(String id) {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement stat = conn.prepareStatement("SELECT * "
														 + "FROM Restaurant "
														 + "WHERE RestID=?");
			stat.setString(1, id);
			ResultSet rs = stat.executeQuery();
			
			if(rs.next()) {
				return rs.getString("Name");
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
