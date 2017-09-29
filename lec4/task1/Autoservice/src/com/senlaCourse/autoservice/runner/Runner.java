package com.senlaCourse.autoservice.runner;

import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.service.MasterService;
import com.senlaCourse.autoservice.service.OrderService;
import com.senlaCourse.autoservice.stores.MasterStoreImpl;
import com.senlaCourse.autoservice.stores.OrderStoreImpl;
import com.senlaCourse.autoservice.util.DateUtil;

import java.text.ParseException;
import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) throws ParseException {
        OrderStoreImpl orderStore = new OrderStoreImpl();
        OrderService orderService = new OrderService();
        MasterStoreImpl masterStore = new MasterStoreImpl();
        MasterService masterService = new MasterService();
        DateUtil du = new DateUtil();

        Order order1 = new Order(1, du.create("01/10/2017"), null, 50.0f);
        Order order2 = new Order(2, du.create("11/08/2017"), null, 70.0f);
        Order order3 = new Order(3, du.create("13/07/2017"), null, 65.0f);

        Master master1 = new Master("Pupkin", true);
        Master master2 = new Master("Ivanov", true);

        orderStore.add(order1);
        orderStore.add(order2);
        orderStore.add(order3);
        orderService.sortByPriceOfOrder((ArrayList<Order>) orderStore.getOrders());
        orderService.sortByDateOfOrder((ArrayList<Order>) orderStore.getOrders());

        masterStore.add(master1);
        masterStore.add(master2);
        masterService.sortByNameOfMaster((ArrayList<Master>) masterStore.getMasters());



    }

}
