package com.senlaCourse.autoservice.api;

import com.senlaCourse.autoservice.entity.Order;

public interface IOrderStore extends IGeneric<Order>    {

    @Override
    void delete(Order order);

    @Override
    void add(Order order);

    void canceleOrder(Order order);

    void deleteOrder(Order order);

    void closeOrder(Order order);


}
