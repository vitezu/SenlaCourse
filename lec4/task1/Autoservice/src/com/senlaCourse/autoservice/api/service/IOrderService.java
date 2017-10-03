package com.senlaCourse.autoservice.api.service;

import com.senlaCourse.autoservice.entity.Order;

public interface IOrderService {

    void addOrder (Order order);

    void deleteOrder (Order order);

    void sortByDateOfOrder();

    void sortByPriceOfOrder();

    void sortByDateOfPlannedExecution();

    void sortByDateOfExecution();

    void sortByPriceOfOperationOrder();

    void sortByDateOfOperationOrder();

    void canceleOrder(Order order);

    void closeOrder(Order order);

    void operateOrder(Order order);
}
