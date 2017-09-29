package com.senlaCourse.autoservice.service.comparators.order;

import com.senlaCourse.autoservice.entity.Order;

import java.util.Comparator;

public class ComparatorByDateOfExecution implements Comparator<Order> {
    @Override
    public int compare(Order obj1, Order obj2) {
        if (obj1.getDateOfEnd() == null) {
            return (obj2.getDateOfEnd() == null) ? 0 : -1;
        }
        if (obj2.getDateOfEnd() == null) {
            return 1;
        }
        return obj1.getDateOfEnd().compareTo(obj2.getDateOfEnd());
    }
}