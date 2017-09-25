package com.senlaCourse.autoservice.running;
import com.senlaCourse.autoservice.control.Order;
import com.senlaCourse.autoservice.control.Manager;
import com.senlaCourse.autoservice.control.StateOrder;
import com.senlaCourse.autoservice.repairs.Master;
import com.senlaCourse.autoservice.repairs.Place;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Running {
    public static void main(String[] args) throws Exception {
        StateOrder stateOrderCanceled = StateOrder.CANCELED;
        StateOrder stateOrderDeleted = StateOrder.DELETED;
        StateOrder stateOrderCompleted = StateOrder.COMPLETED;

        Place place1 = new Place(1, true);
        Place place2 = new Place(2, true);
        Manager manager = new Manager();
        Master master1 = new Master("Ivanov", true);
        Master master2 = new Master("Bobrov", true);
        Master master3 = new Master("Sidorov", true);

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date dt1 =  df.parse("01-01-2016");
        Date dt2 =  df.parse("02-02-2017");
        Date dt3 =  df.parse("01-03-2016");
        Date dt4 =  df.parse("13-010-2015");

        List<Order>  orders = new ArrayList();
        Order order1 = new Order(1, dt1, null, null, 50.0f);
        Order order2 = new Order(2, dt2, null, null, 43.0f);
        Order order3 = new Order(3, dt3, null, null, 70.0f);
        Order order4 = new Order(4, dt4, null, null, 60.0f);
        order1.setStateOrder(stateOrderCanceled);

        manager.addPlace(place1);
        manager.addPlace(place2);
        System.out.println("Free places: " + manager.getFreePlaces());

        manager.addOrder(order1);
        manager.addOrder(order2);
        manager.addOrder(order3);
        manager.addOrder(order4);
        manager.sortedByDateOfOrder();
        manager.sortedByPriceOfOrder();

        master1.setOrder(order1);
        master2.setOrder(order2);
        master3.setOrder(order2);

        manager.addMaster(master1);
        manager.addMaster(master2);
        manager.addMaster(master3);

        manager.sortedByNameOfMaster();
        manager.sortedByStateOfMaster();
        System.out.println();

        System.out.println(master1.getName() + master1.getOrder());

        order1.setMaster(master1);
        order1.setMaster(master2);
//        System.out.println("Order №" + order1.getNum() + order1.getMasters());




    }
}
