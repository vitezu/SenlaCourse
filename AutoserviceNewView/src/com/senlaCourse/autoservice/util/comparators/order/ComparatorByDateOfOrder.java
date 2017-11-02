package com.senlaCourse.autoservice.util.comparators.order;

import com.senlaCourse.autoservice.entity.Order;

import java.util.Comparator;

public class ComparatorByDateOfOrder implements Comparator<Order> {
    @Override
    public int compare(Order obj1, Order obj2) {
        if (obj1.getDateOfOrder() == null) {
            return (obj2.getDateOfOrder() == null) ? 0 : -1;
        }
        if (obj2.getDateOfOrder() == null) {
            return 1;
        }
        return obj1.getDateOfOrder().compareTo(obj2.getDateOfOrder());
    }
}
