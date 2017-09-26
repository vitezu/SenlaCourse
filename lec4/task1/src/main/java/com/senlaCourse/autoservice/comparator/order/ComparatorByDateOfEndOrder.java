package com.senlaCourse.autoservice.comparator.order;

import com.senlaCourse.autoservice.entity.Order;

import java.util.Comparator;

public class ComparatorByDateOfEndOrder implements Comparator<Order> {
    @Override
    public int compare(Order obj1, Order obj2) {
        return obj1.getDateOfEnd().compareTo(obj2.getDateOfEnd());
    }
}