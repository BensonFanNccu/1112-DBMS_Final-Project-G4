import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
	
	private int userID;
	private String type;
	private String comments;
	private ArrayList<Integer> collection = new ArrayList<Integer>();
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://140.119.203.60:3306/dbms_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static final String USER = "yenrong";
	static final String PASS = "dbmsproject";
	
	public User(int id, String type) {
		this.userID = id;
		this.type = type;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public String getType() {
		return type;
	}
	
	public void Write(Restaurant r) { //time default?
		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			
			String query = "INSERT INTO Review VALUES(" + userID + ", " + r.getRestID() + ", `" + comments + "`);";
			
			Statement stat = con.createStatement();
			stat.execute(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	} 
	
	public String collect(Restaurant r) { // time?
		String result = "";
		double weight = 1; //預設值
//		if(有設定權重) {
//			weight = ;
//		}
		
		try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);

			if(collection.size() < 3) {
				String query = "INSERT INTO Collection VALUES(" + userID + ", " + r.getRestID() + ", " + weight + ");";
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
	
}
