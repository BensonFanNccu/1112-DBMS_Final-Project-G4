import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Restaurant {
    private int restID;
    private String name;
    private double typeWei;
    private double budWei;
    private double dTimeWei;
    private double distWei;
    private double score;

    public Restaurant(int id, String name, double typeWei, double budWei, double dTimeWei, double distWei) {
        this.restID = id;
        this.name = name;
        this.typeWei = typeWei;
        this.budWei = budWei;
        this.dTimeWei = dTimeWei;
        this.distWei = distWei;
    }

    public void calScore() {

    }

    public double getScore() {
        return score;
    }

    public int getRestID() {
        return restID;
    }

    public String getName() {
        return name;
    }
    
    public int nameToID(String name) {
    	int id = 0;
    	String DB_URL = "jdbc:mysql://140.119.203.60:3306/dbms_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    	String USER = "yenrong";
    	String PASS = "dbmsproject";
    	
    	try {
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			
			String query = "SELECT RestID FROM Restaurant WHERE Name = " + name + ";";
			Statement stat = con.createStatement();
			boolean hasResult = stat.execute(query);
			
			if(hasResult) {
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
