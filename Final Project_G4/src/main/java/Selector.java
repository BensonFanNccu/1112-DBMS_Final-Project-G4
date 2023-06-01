import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Selector {
	private ArrayList<String> type = new ArrayList<String>();
	private ArrayList<String> budget = new ArrayList<String>();
	private ArrayList<String> time = new ArrayList<String>();
	private ArrayList<String> distance = new ArrayList<String>();
    private ArrayList<String> result = new ArrayList<String>();

    static final String DB_URL = "jdbc:mysql://140.119.203.60:3306/dbms_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "yenrong";
    static final String PASS = "dbmsproject";
    
    public void fetch(HttpServletRequest request) {
    	if(request.getParameter("below100") != null) {
			budget.add("100元以下");
		}
		
		if(request.getParameter("100-150") != null) {
			budget.add("100-150元");
		}
		
		if(request.getParameter("150-200") != null) {
			budget.add("150-200元");
		}
		
		if(request.getParameter("200-250") != null) {
			budget.add("200-250元");
		}
		
		if(request.getParameter("250up") != null) {
			budget.add("250元以上");
		}
		
		if(request.getParameter("below 30min") != null) {
			time.add("30分以下");
		}
		
		if(request.getParameter("30min-1hr") != null) {
			time.add("30分-1小時");
		}
		
		if(request.getParameter("1hr up") != null) {
			time.add("1小時以上");
		}
		
		if(request.getParameter("type1") != null) {
			type.add("中式");
		}
		
		if(request.getParameter("type2") != null) {
			type.add("韓式");
			type.add("日式");
			type.add("美式");
			type.add("義式");
		}
		
		if(request.getParameter("type3") != null) {
			type.add("輕食");
			type.add("速食");
		}
		
		if(request.getParameter("dist1") != null) {
			distance.add("麥側");
		}
		
		if(request.getParameter("dist2") != null) {
			distance.add("正門");
		}
		
		if(request.getParameter("dist3") != null) {
			distance.add("東側門");
		}
    }

    public void suggest() {

        if (type.isEmpty()) {
            // 如何表達?
        }

        if (budget.isEmpty()) {

        }

        if (time.isEmpty()) {

        }

        if (distance.isEmpty()) {

        }

        int count = 0;
        String query = "SELECT Name FROM Restaurant WHERE (";

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
        query += ") ";

        String weekday = "";
        try {
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            String weekdayQuery = "SELECT CONVERT(WEEKDAY(CURDATE()), char)";
            Statement stat = con.createStatement();
            boolean hasResult = stat.execute(weekdayQuery);
            if (hasResult) {
                ResultSet resultset = stat.getResultSet();
                while (resultset.next()) {
                    weekday = resultset.getString(0);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        query += "AND (Open1 LIKE \'%" + weekday + "%\' AND CURTIME() BETWEEN " +
                "CONVERT(substring(Time1, 1, 8), time) AND CONVERT(substring(Time1, 10, 8), time)) " +
                "OR (Open2 LIKE \'%" + weekday + "%\' AND CURTIME() BETWEEN " +
                "CONVERT(substring(Time2, 1, 8), time) AND CONVERT(substring(Time2, 10, 8), time)) " +
                "OR (Open3 LIKE \'%" + weekday + "%\' AND CURTIME() BETWEEN " +
                "CONVERT(substring(Time3, 1, 8), time) AND CONVERT(substring(Time3, 10, 8), time));";

        try {
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stat = con.createStatement();
            boolean hasResult = stat.execute(query);
            if (hasResult) {
                ResultSet resultset = stat.getResultSet();
                while (resultset.next()) {
                    result.add(resultset.getString(0));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result.isEmpty()) {
            System.out.println("非常抱歉，根據您所選擇的條件，我們沒有找到任何餐廳...");
        }

        if (result.size() > 3) {
            result = sort(result);
        }
    }

    public ArrayList<String> sort(ArrayList<String> input) {
        ArrayList<String> output = new ArrayList<String>();

        // how to sort?

        return output;
    }

    public String allRandom() {
        Random ran = new Random();
        int upperbound = 72;
        int id = ran.nextInt(upperbound) + 1;

        String query = "SELECT Name FROM Restaurant WHERE RestID = " + id;
        String weekday = "";
        String result = "";

        try {
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            String weekdayQuery = "SELECT CONVERT(WEEKDAY(CURDATE()), char)";
            Statement weekStat = con.createStatement();
            boolean weekHasResult = weekStat.execute(weekdayQuery);
            if (weekHasResult) {
                ResultSet resultSet = weekStat.getResultSet();
                while (resultSet.next()) {
                    weekday = resultSet.getString(0);
                }
            }

            query += " AND (Open1 LIKE \'%" + weekday + "%\' AND CURTIME() BETWEEN " +
                    "CONVERT(substring(Time1, 1, 8), time) AND CONVERT(substring(Time1, 10, 8), time)) " +
                    "OR (Open2 LIKE \'%" + weekday + "%\' AND CURTIME() BETWEEN " +
                    "CONVERT(substring(Time2, 1, 8), time) AND CONVERT(substring(Time2, 10, 8), time)) " +
                    "OR (Open3 LIKE \'%" + weekday + "%\' AND CURTIME() BETWEEN " +
                    "CONVERT(substring(Time3, 1, 8), time) AND CONVERT(substring(Time3, 10, 8), time));";

            Statement stat = con.createStatement();
            boolean hasResult = stat.execute(query);
            if (hasResult) {
                ResultSet resultset = stat.getResultSet();
                while (resultset.next()) {
                    result = resultset.getString(0);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void partRandom(ArrayList<String> type, ArrayList<String> budget, ArrayList<String> time,
            ArrayList<String> distance) {

        ArrayList<String> random = new ArrayList<String>();
        int count = 0;
        String query = "SELECT Name FROM Restaurant WHERE (";

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
        query += ") ";

        String weekday = "";
        try {
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            String weekdayQuery = "SELECT CONVERT(WEEKDAY(CURDATE()), char)";
            Statement stat = con.createStatement();
            boolean hasResult = stat.execute(weekdayQuery);
            if (hasResult) {
                ResultSet resultset = stat.getResultSet();
                while (resultset.next()) {
                    weekday = resultset.getString(0);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        query += "AND (Open1 LIKE \'%" + weekday + "%\' AND CURTIME() BETWEEN " +
                "CONVERT(substring(Time1, 1, 8), time) AND CONVERT(substring(Time1, 10, 8), time)) " +
                "OR (Open2 LIKE \'%" + weekday + "%\' AND CURTIME() BETWEEN " +
                "CONVERT(substring(Time2, 1, 8), time) AND CONVERT(substring(Time2, 10, 8), time)) " +
                "OR (Open3 LIKE \'%" + weekday + "%\' AND CURTIME() BETWEEN " +
                "CONVERT(substring(Time3, 1, 8), time) AND CONVERT(substring(Time3, 10, 8), time));";

        try {
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stat = con.createStatement();
            boolean hasResult = stat.execute(query);
            if (hasResult) {
                ResultSet resultset = stat.getResultSet();
                while (resultset.next()) {
                    random.add(resultset.getString(0));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (random.isEmpty()) {
            System.out.println("您所選擇的條件沒有任何餐廳符合");
        } else {
            Random ran = new Random();
            int id = ran.nextInt(random.size());
            result.add(random.get(id));
        }
    }
}
