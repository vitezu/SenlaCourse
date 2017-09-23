package restaurant;

import java.util.Arrays;

public class Order {
    private Integer numId;
    private Table table;
    private Food[] foods = new Food[20];
    private Integer count = 0;


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
        foods[count] = food;
        count++;
    }

    public Integer getOrderPrice() {
        Integer sum = 0;
        for (int i = 0; i < foods.length; i++) {
            if (foods[i] != null) {
                sum += foods[i].getPrice();
            } else break;
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "numId=" + numId +
                ", table=" + table +
                ", foods=" + Arrays.toString(foods) +
                ", count=" + count +
                '}';
    }
}
