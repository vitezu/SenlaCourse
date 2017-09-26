package com.senlaCourse.autoservice.comparator.order;

import com.senlaCourse.autoservice.entity.Order;
import java.util.Comparator;

public class ComparatorByDateOfOrder implements Comparator<Order> {
    @Override
    public int compare(Order obj1, Order obj2) {
        return obj1.getDateOfOrder().compareTo(obj2.getDateOfOrder());
    }
}
