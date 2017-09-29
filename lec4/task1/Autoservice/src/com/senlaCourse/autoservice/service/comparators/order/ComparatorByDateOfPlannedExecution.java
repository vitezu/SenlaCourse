package com.senlaCourse.autoservice.service.comparators.order;

import com.senlaCourse.autoservice.entity.Order;

import java.util.Comparator;

public class ComparatorByDateOfPlannedExecution implements Comparator<Order> {
        @Override
        public int compare(Order obj1, Order obj2) {
            if (obj1.getDateOfPlaningEnd() == null) {
                return (obj2.getDateOfPlaningEnd() == null) ? 0 : -1;
            }
            if (obj2.getDateOfPlaningEnd() == null) {
                return 1;
            }
            return obj1.getDateOfPlaningEnd().compareTo(obj2.getDateOfPlaningEnd());
        }
    }



