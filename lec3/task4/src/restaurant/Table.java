package restaurant;

public class Table {
    private Integer numId;
    private Order order;
    private Integer count = 0;

    public Table(Integer numId) {
        this.numId = numId;
    }

    public void setOrder (Order order) {
        this.order = order;
    }
    public void cancelOrder () {
        this.order = null;
    }

    public Order getOrder() {
        return order;
    }

    public Integer getNumId() {
        return numId;
    }
}
