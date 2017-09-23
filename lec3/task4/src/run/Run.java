package run;

import restaurant.Cook;
import restaurant.Kitchen;
import restaurant.Food;
import restaurant.Menu;
import restaurant.Order;
import restaurant.Table;

public class Run {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Food food1 = new Food ("potato", 1);
        Food food2 = new Food ("chiken", 3);
        Food food3 = new Food ("mushrooms", 2);
        Food food4 = new Food ("salad", 1);
        Cook cook1 = new Cook("Vasya");
        Cook cook2 = new Cook("Petya");
        Table table1 = new Table(7);
        Order order1 = new Order(1, table1);
        Order order2 = new Order(2, table1);
        Kitchen kitchen = new Kitchen();

        menu.addFood(food1);
        menu.addFood(food2);
        menu.addFood(food3);
        menu.addFood(food4);
        kitchen.addCook(cook1);
        kitchen.addCook(cook2);

        order1.addFood(food1);
        order1.addFood(food2);
        order2.addFood(food3);
        order2.addFood(food4);

        cook1.setOrder(order1);
        cook2.setOrder(order2);

        table1.setOrder(order1);
        System.out.println("Table № " + table1.getNumId() + " - Total price of order: " + table1.getOrder().getOrderPrice());

        System.out.println();

        System.out.println(cook1.getName() + " doing order № " + cook1.getOrder().getNumId() + " for table № " + cook1.getOrder().getTable().getNumId());

        System.out.println();
        kitchen.getCooksWithOrder();

        System.out.println();

        menu.getMenu();
    }
}
