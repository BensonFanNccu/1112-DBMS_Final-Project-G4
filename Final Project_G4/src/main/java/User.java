import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {

	private int userID;
	private String account;
	private String password;
	private String type;
	private ArrayList<Integer> collection = new ArrayList<Integer>();

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://140.119.203.60:3306/dbms_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER = "yenrong";
	static final String PASS = "dbmsproject";

	public User(int id) {
		this.userID = id;
	}
	
	public User(int id, String account, String password) {
		userID = id;
		this.account = account;
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}
	
	public String getAccount() {
		return account;
	}
	
	public String getPassword() {
		return password;
	}

	public String getType() {
		return type;
	}

	public void viewReview(Restaurant r) {
		// r = ?;
		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			String query = "SELECT UserID, RestID, Time, Stars FROM Review WHERE Name = " + r.getName() + ";";
			Statement stat = con.createStatement();
			boolean hasResult = stat.execute(query);

			if (hasResult) {
				ResultSet result = stat.getResultSet();
				int count = 0;
				while (result.next()) {
					count++;
				}

				if (count == 0) {
					System.out.println("這家餐廳還沒有人評論過");
				} else {
					// 如何呈現??
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void changeComment(Restaurant r, String newComm) {
		// r = ?;

		int comID = 0;
		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			String query = "SELECT CommentID FROM Review WHERE UserID = " + userID + " AND RestID = " + r.getRestID()
					+ ";";
			Statement stat = con.createStatement();
			boolean hasResult = stat.execute(query);
			if (hasResult) {
				ResultSet resultset = stat.getResultSet();
				while (resultset.next()) {
					comID = Integer.parseInt(resultset.getString(0));// 多筆評論?
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			String query = "UPDATE Review SET Comment = " + newComm + " WHERE CommentID = " + comID + ";";
			Statement stat = con.createStatement();
			boolean change = stat.execute(query);

			if (change) {
				System.out.println("成功修改您的評論內容");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void changeStar(Restaurant r, int newStar) {
		// r = ?;

		int comID = 0;
		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			String query = "SELECT CommentID FROM Review WHERE UserID = " + userID + " AND RestID = " + r.getRestID()
					+ ";";
			Statement stat = con.createStatement();
			boolean hasResult = stat.execute(query);
			if (hasResult) {
				ResultSet resultset = stat.getResultSet();
				while (resultset.next()) {
					comID = Integer.parseInt(resultset.getString(0));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			String query = "UPDATE Review SET Stars = " + newStar + " WHERE CommentID = " + comID + ";";
			Statement stat = con.createStatement();
			boolean change = stat.execute(query);

			if (change) {
				System.out.println("成功修改您的評論星級");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteReview(Restaurant r) {
		// r = ?;

		int comID = 0;
		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			String query = "SELECT CommentID FROM Review WHERE UserID = " + userID + " AND RestID = " + r.getRestID()
					+ ";";
			Statement stat = con.createStatement();
			boolean hasResult = stat.execute(query);
			if (hasResult) {
				ResultSet resultset = stat.getResultSet();
				while (resultset.next()) {
					comID = Integer.parseInt(resultset.getString(0));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			String query = "DELETE FROM Review WHERE CommentID = " + comID + ";";
			Statement stat = con.createStatement();
			boolean del = stat.execute(query);

			if (del) {
				System.out.println("成功刪除您的評論");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String collect(Restaurant r) {
		String result = "";
		double weight = 1; // 預設值
		// if(有設定權重) {
		// weight = ;
		// }

		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			if (collection.size() < 3) {
				String query = "INSERT INTO Collection (UserID, RestID, Weight) VALUES(" + userID + ", " + r.getRestID()
						+ ", " + weight + ");";
				Statement stat = con.createStatement();
				stat.execute(query);
				collection.add(r.getRestID());
				result = "收藏成功!";
			} else {
				result = "您的收藏餐廳數已達上限";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public void viewCollection() {
		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			String query = "SELECT RestID, Time, Weight FROM Collection WHERE UserID = " + userID + ";";
			Statement stat = con.createStatement();
			stat.execute(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void changeWeight(Restaurant r, double newWeight) {
		// r = ?;
		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			String query = "UPDATE Collection SET Weight = " + newWeight + " WHERE UserID = " + userID
					+ " AND RestID = " + r.getRestID() + ";";
			Statement stat = con.createStatement();
			boolean change = stat.execute(query);

			if (change) {
				System.out.println("成功修改您的收藏餐廳權重");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCollection(Restaurant r) {
		// r = ?;
		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			String query = "DELETE FROM Collection WHERE UserID = " + userID + " AND RestID = " + r.getRestID() + ";";
			Statement stat = con.createStatement();
			boolean del = stat.execute(query);

			if (del) {
				System.out.println("成功刪除您的收藏");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int RNameToID(String name) {
		int id = 0;
		String DB_URL = "jdbc:mysql://140.119.203.60:3306/dbms_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
		String USER = "yenrong";
		String PASS = "dbmsproject";

		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			String query = "SELECT RestID FROM Restaurant WHERE Name = " + name + ";";
			Statement stat = con.createStatement();
			boolean hasResult = stat.execute(query);

			if (hasResult) {
				ResultSet result = stat.getResultSet();
				while (result.next()) {
					id = Integer.parseInt(result.getString(0));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}

}
