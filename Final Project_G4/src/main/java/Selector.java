
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
        String query = "Select name From Restaurant Where";

        for (int i = 0; i < type.size(); i++) {
            if (count > 0) {
                query += " or ";
            }
            query += "Type = " + type.get(i);
            count++;
        }

        for (int i = 0; i < budget.size(); i++) {
            query += " or ";
            query += "Budget = " + budget.get(i);
        }

        for (int i = 0; i < time.size(); i++) {
            query += " or ";
            query += "Time = " + time.get(i);
        }

        for (int i = 0; i < distance.size(); i++) {
            query += " or ";
            query += "Distance = " + distance.get(i);
        }

        String weekday = "select CONVERT(WEEKDAY(CURDATE()), char)"; #尚未完成

        query += "and (Open1 like \'%" + weekday + "%\' and CURTIME() between " +
                "CONVERT(substring(Time1, 1, 8), time) and CONVERT(substring(Time1, 10, 8), time)) " +
                "or (Open2 like \'%" + weekday + "%\' and CURTIME() between " +
                "CONVERT(substring(Time2, 1, 8), time) and CONVERT(substring(Time2, 10, 8), time)) " +
                "or (Open3 like \'%" + weekday + "%\' and CURTIME() between " +
                "CONVERT(substring(Time3, 1, 8), time) and CONVERT(substring(Time3, 10, 8), time))";

    }
}
