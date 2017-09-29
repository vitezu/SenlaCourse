package com.senlaCourse.autoservice.stores;

import com.senlaCourse.autoservice.api.IOrderStore;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.StateOrder;

import java.util.ArrayList;
import java.util.List;

public class OrderStoreImpl implements IOrderStore {
    List<Order> orders = new ArrayList<Order>();

    @Override
    public void delete(Order order) {
        orders.remove(order);
    }

    @Override
    public void add(Order order) {
        orders.add(order);
    }

    @Override
    public void canceleOrder (Order order) {
        order.setStateOrder(StateOrder.CANCELED);
    }

    @Override
    public void deleteOrder (Order order) {
        order.setStateOrder(StateOrder.DELETED);
    }

    @Override
    public void closeOrder (Order order) {
        order.setStateOrder(StateOrder.COMPLETED);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}

