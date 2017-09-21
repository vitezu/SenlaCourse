package restaurant;

public class Cook {
    private String name;
    private Boolean category;
    private Order order;
    private Boolean statFree = true;

    public Cook(String name, Boolean category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void getOrder (Order order) {
        if (statFree) {
            this.order = order;
            statFree = false;
        } else {
            System.out.println("Cook is busy");
        }

    }
    public Order showOrder (){
        return this.order;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cook{");
        sb.append("name='").append(name).append('\'');
        sb.append(", category=").append(category);
        sb.append('}');
        return sb.toString();
    }
}
