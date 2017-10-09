package com.senlaCourse.autoservice.api.service;

import com.senlaCourse.autoservice.entity.Order;

import java.util.Date;
import java.util.List;

public interface IOrderService {

    void addOrder (Order order);

    void deleteOrder (Order order);

    void sortByDateOfOrder();

    void sortByPriceOfOrder();

    void sortByDateOfStart();

    List<Order> sortByDateOfExecution();

    void sortByPriceOfOperationOrder();

    void sortByDateOfOperationOrder();

    void sortByDateOfExecutionOperationOrder();

    void canceleOrder(Order order);

    void closeOrder(Order order, Date date);

    void operateOrder(Order order);

    List<Order> getOrderStore ();
}
