package com.senlaCourse.autoservice.api.story;

import com.senlaCourse.autoservice.entity.Order;

import java.util.List;

public interface IOrderStore extends IGeneric<Order> {

    @Override
    void delete(Order order);

    @Override
    void add(Order order);

    @Override
    List<Order> getAll();

    void canceleOrder(Order order);

    void deleteOrder(Order order);

    void closeOrder(Order order);

}
