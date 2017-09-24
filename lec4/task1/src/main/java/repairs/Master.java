package repairs;

import control.Order;

public class Master {

    private String name;
    private Boolean statFree;
    private Order order;

    public Master(String name, Boolean statFree) {
        this.name = name;
        this.statFree = statFree;
    }

    public void setOrder (Order order) {
        this.order = order;
        statFree = false;
    }


    public String getName() {
        return name;
    }

    public Boolean getStatFree() {
        return statFree;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Master{");
        sb.append("name='").append(name).append('\'');
        sb.append(", statFree=").append(statFree);
        sb.append(", control=").append(order);
        sb.append('}');
        return sb.toString();
    }
}
