package restaurant;


public class Department {
    private String name;
    Cook[] cooks = new Cook[3];
    private Integer n = 0;

    public void setName(String name) {
        this.name = name;
    }
    public void addCook (Cook cook) {
        cooks[n] = cook;
        n++;
    }

    public void deleteCook (int n) {
        cooks[n] = null;
    }
}
