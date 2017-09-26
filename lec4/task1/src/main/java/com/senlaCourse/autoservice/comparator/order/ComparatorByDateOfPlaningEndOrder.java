package com.senlaCourse.autoservice.comparator.order;

import com.senlaCourse.autoservice.entity.Order;

import java.util.Comparator;

public class ComparatorByDateOfPlaningEndOrder implements Comparator<Order> {
        @Override
        public int compare(Order obj1, Order obj2) {
            return obj1.getDateOfPlaningEnd().compareTo(obj2.getDateOfPlaningEnd());
        }
    }



