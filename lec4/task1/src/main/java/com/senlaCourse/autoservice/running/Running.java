package com.senlaCourse.autoservice.running;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.service.Manager;
import com.senlaCourse.autoservice.service.StateOrder;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Place;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Running {
    public static void main(String[] args) throws Exception {
        StateOrder stateOrderOperating = StateOrder.OPERATING;
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
        Date dt1 =  df.parse("20-09-2017");
        Date dt2 =  df.parse("02-10-2017");
        Date dt3 =  df.parse("21-09-2017");
        Date dt4 =  df.parse("13-10-2017");
        Date dt5 =  df.parse("15-09-2017");
        Date dt6 =  df.parse("11-11-2017");

        List<Order>  orders = new ArrayList();
        Order order1 = new Order(1, dt1, dt2, 50.0f);
        Order order2 = new Order(2, dt3, dt4, 70.0f);
        Order order3 = new Order(3, dt5, dt6, 65.0f);
        order2.setDateOfEnd(dt3);

        manager.addOrder(order1);
        manager.addOrder(order2);
        manager.addOrder(order3);

        manager.addPlace(place1);
        manager.addPlace(place2);
        System.out.println("Free places: " + manager.getFreePlaces());

        master1.setOrder(order1);
        master2.setOrder(order2);

        order1.setStateOrder(stateOrderOperating);
        order2.setStateOrder(stateOrderOperating);
        order3.setStateOrder(stateOrderCanceled);
        manager.sortByDateOfOrder();
        manager.sortByDateOfPlaningEndOrder();
        manager.sortByDateOfEndOrder();
        manager.sortByPriceOfOrder();

        manager.addMaster(master1);
        manager.addMaster(master2);
        manager.addMaster(master3);

        manager.sortByNameOfMaster();
        manager.sortByStateOfMaster();

        manager.sortByPriceOfOperationOrder();
        manager.sortByDateOfOperationOrder();
        System.out.println();

        System.out.println(master1.getName() + master1.getOrder());

        System.out.println(manager.calcFreePlaces());
    }
}
