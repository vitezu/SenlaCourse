package com.senlaCourse.autoservice.util.comparators.order;

import com.senlaCourse.autoservice.entity.Order;

import java.util.Comparator;

public class ComparatorByDateOfStart implements Comparator<Order> {
        @Override
        public int compare(Order obj1, Order obj2) {
            if (obj1.getDateOfStart() == null) {
                return (obj2.getDateOfStart() == null) ? 0 : -1;
            }
            if (obj2.getDateOfStart() == null) {
                return 1;
            }
            return obj1.getDateOfStart().compareTo(obj2.getDateOfStart());
        }
    }



