package restaurant;

public class Order {
    private Integer numId;
    private Table table;
    private Food[] foods = new Food[6];
    private Integer n = 0;


    public Order(Integer numId, Table table) {
        this.numId = numId;
        this.table = table;
    }

    public Integer getNumId() {
        return numId;
    }

    public Table getTable() {
        return table;
    }

    public void addFood(Food food) {
        foods[n] = food;
        n++;
    }

    public Integer getOrderPrice(Order order) {
        Integer sum = 0;
        for (int i = 0; i < order.foods.length; i++) {
            if (order.foods[i] != null) {
                sum += order.foods[i].getPrice();
            } else break;
        }
        return sum;
    }
}
