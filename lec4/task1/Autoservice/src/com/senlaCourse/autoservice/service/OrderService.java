package com.senlaCourse.autoservice.service;

import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.service.comparators.order.ComparatorByDateOfOrder;
import com.senlaCourse.autoservice.service.comparators.order.ComparatorByPriceOfOrder;
import com.senlaCourse.autoservice.util.Printer;

import java.util.ArrayList;
import java.util.Collections;

public class OrderService {
    private final String MESSAGE1 = "Sorted by date of order";
    private final String MESSAGE2 = "Sorted by price of order";
    private final ComparatorByDateOfOrder comparatorByDateOfOrder = new ComparatorByDateOfOrder();
    private final ComparatorByPriceOfOrder comparatorByPriceOfOrder = new ComparatorByPriceOfOrder();
    private Printer printer = new Printer();

    public void sortByDateOfOrder(ArrayList<Order> orders) {
        ArrayList<Order> ordersSorted = (ArrayList<Order>) orders.clone();
        Collections.sort(ordersSorted, comparatorByDateOfOrder);
        printer.printLineEmpty();
        printer.printMessage(MESSAGE1);
        for (Order order : ordersSorted)
            printer.printObject(order);
    }

    public void sortByPriceOfOrder(ArrayList<Order> orders) {
        ArrayList<Order> ordersSorted = (ArrayList<Order>) orders.clone();
        printer.printLineEmpty();
        Collections.sort(ordersSorted, comparatorByPriceOfOrder);
        printer.printMessage(MESSAGE2);
        for (Order order : ordersSorted)
            printer.printObject(order);
    }
}
