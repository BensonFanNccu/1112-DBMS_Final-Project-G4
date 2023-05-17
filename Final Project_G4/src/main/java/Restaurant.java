
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
}
