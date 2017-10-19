package com.senlaCourse.autoservice.util.comparators.order;

import com.senlaCourse.autoservice.entity.Order;

import java.util.Comparator;

public class ComparatorByDateOfExecution implements Comparator<Order> {
    @Override
    public int compare(Order obj1, Order obj2) {
        if (obj1.getDateOfExecution() == null) {
            return (obj2.getDateOfExecution() == null) ? 0 : -1;
        }
        if (obj2.getDateOfExecution() == null) {
            return 1;
        }
        return obj1.getDateOfExecution().compareTo(obj2.getDateOfExecution());
    }
}