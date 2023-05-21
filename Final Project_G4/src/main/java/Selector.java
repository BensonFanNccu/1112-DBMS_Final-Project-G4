import java.util.ArrayList;

public class Selector {
    private ArrayList<String> type = new ArrayList<String>();
    private ArrayList<String> budget = new ArrayList<String>();
    private ArrayList<String> time = new ArrayList<String>();
    private ArrayList<String> distance = new ArrayList<String>();

    public void suggest() {
        boolean delTpye = type.remove("不限");
        boolean delBud = budget.remove("不限");
        boolean delTime = time.remove("不限");
        boolean delDist = distance.remove("不限");

        int count = 0;
        String query = "SELECT Name FROM Restaurant WHERE";

        for (int i = 0; i < type.size(); i++) {
            if (count > 0) {
                query += " OR ";
            }
            query += "Type = " + type.get(i);
            count++;
        }

        for (int i = 0; i < budget.size(); i++) {
            query += " OR ";
            query += "Budget = " + budget.get(i);
        }

        for (int i = 0; i < time.size(); i++) {
            query += " OR ";
            query += "Time = " + time.get(i);
        }

        for (int i = 0; i < distance.size(); i++) {
            query += " OR ";
            query += "Distance = " + distance.get(i);
        }

        String weekday = "SELECT CONVERT(WEEKDAY(CURDATE()), char)";

        query += "AND (Open1 LIKE \'%" + weekday + "%\' AND CURTIME() BETWEEN " +
                "CONVERT(substring(Time1, 1, 8), time) AND CONVERT(substring(Time1, 10, 8), time)) " +
                "OR (Open2 LIKE \'%" + weekday + "%\' AND CURTIME() BETWEEN " +
                "CONVERT(substring(Time2, 1, 8), time) AND CONVERT(substring(Time2, 10, 8), time)) " +
                "OR (Open3 LIKE \'%" + weekday + "%\' AND CURTIME() BETWEEN " +
                "CONVERT(substring(Time3, 1, 8), time) AND CONVERT(substring(Time3, 10, 8), time));";

    }
}

