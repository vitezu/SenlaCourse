package com.senlaCourse.autoservice.service.comparators.order;

import com.senlaCourse.autoservice.entity.Order;

import java.util.Comparator;

public class ComparatorByPriceOfOrder implements Comparator<Order> {
   public int compare (Order obj1, Order obj2){
       return obj1.getPrice().compareTo(obj2.getPrice());
   }
    }

