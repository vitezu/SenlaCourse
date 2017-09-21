package run;

import restaurant.Cook;
import restaurant.Department;
import restaurant.Food;
import restaurant.Menu;
import restaurant.Order;
import restaurant.Table;

import java.util.Arrays;

public class Run {
    public static void main(String[] args) {
        Food food1 = new Food ("potato", 1);
        Food food2 = new Food ("chiken", 3);
        Food food3 = new Food ("mushrooms", 2);
        Food food4 = new Food ("salad", 1);
        Cook cook1 = new Cook("Vasya", true);
        Cook cook2 = new Cook("Petya", true);
        Table table1 = new Table(7, true);
        Order order1 = new Order(1, table1);
        Order order2 = new Order(2, table1);
        Menu menu = new Menu();
        Department kitchen = new Department();

        menu.addFood(food1);
        menu.addFood(food2);
        menu.addFood(food3);
        menu.addFood(food4);

        kitchen.addCook(cook1);
        kitchen.addCook(cook2);

//        Оформление заказа
        order1.addFood(food1);
        order1.addFood(food2);
        order2.addFood(food3);
        order2.addFood(food4);

//        получение заказа поваром
        cook1.getOrder(order1);
        cook2.getOrder(order2);

//      Стоимость заказа
        System.out.println("Total price of order1: " + order1.getOrderPrice(order1));

//        Просмотр заказа
        System.out.println(cook1.getName() + " order № " + cook1.showOrder().getNumId() + " table № " + cook1.showOrder().getTable().getNumId());

//      Список поваров с заказами
        System.out.println(cook1.getName() + " order № " + cook1.showOrder().getNumId());
        System.out.println(cook2.getName() + " order № " + cook2.showOrder().getNumId());

//        Просмотр меню
        System.out.println(Arrays.toString(menu.getMenu()));
    }
}
