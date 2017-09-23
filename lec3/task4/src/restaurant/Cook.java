package restaurant;

public class Cook {
    private String name;
    private Order order;
    private Boolean statFree = true;

    public Cook(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOrder (Order order) {
        if (statFree) {
            this.order = order;
            statFree = false;
        } else {
            System.out.println("Cook is busy");
        }

    }
    public Order getOrder (){
        return this.order;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cook{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
