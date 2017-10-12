package com.senlaCourse.autoservice.api.service;

import com.senlaCourse.autoservice.entity.Order;

import java.util.Date;
import java.util.List;

public interface IOrderService {

    void addOrder (Order order);

    void deleteOrder (Order order);

    List<Order> sortByDateOfOrder();

    List<Order> sortByPriceOfOrder();

    List<Order> sortByDateOfPlannedExecution();

    List<Order> sortByDateOfExecution();

    List<Order> sortByPriceOfOperationOrder();

    List<Order> sortByDateOfOperationOrder();

    List<Order> sortByDateOfExecutionOperationOrder();

    void canceleOrder(Order order);

    void closeOrder(Order order, Date date);

    void operateOrder(Order order);

    List<Order> getOrderStore ();
}
