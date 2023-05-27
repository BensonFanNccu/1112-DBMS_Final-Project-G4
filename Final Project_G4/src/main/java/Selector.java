import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class Selector {
    private ArrayList<String> type = new ArrayList<String>();
    private ArrayList<String> budget = new ArrayList<String>();
    private ArrayList<String> time = new ArrayList<String>();
    private ArrayList<String> distance = new ArrayList<String>();
    private ArrayList<String> result = new ArrayList<String>();

    static final String DB_URL = "jdbc:mysql://140.119.203.60:3306/dbms_project?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "yenrong";
    static final String PASS = "dbmsproject";

    public void suggest() {
        type.remove("不限");
        budget.remove("不限");
        time.remove("不限");
        distance.remove("不限");

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

    public String allRandom() { // 轉盤要推薦幾個?
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

    public void partRandom() { // 轉盤要推薦幾個?
        type.remove("不限");
        budget.remove("不限");
        time.remove("不限");
        distance.remove("不限");

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
