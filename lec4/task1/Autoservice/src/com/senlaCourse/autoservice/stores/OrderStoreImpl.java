package com.senlaCourse.autoservice.stores;

import com.senlaCourse.autoservice.api.story.IOrderStore;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.StateOrder;

import java.util.ArrayList;
import java.util.List;

public class OrderStoreImpl implements IOrderStore {

    private List<Order> orders = new ArrayList<Order>();

    @Override
    public void delete(Order order) {
        orders.remove(order);
    }

    @Override
    public void add(Order order) {
        orders.add(order);
    }

    @Override
    public List<Order> getAll() {
        return orders;
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

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}

