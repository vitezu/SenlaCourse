package com.senlaCourse.autoservice.stores;

import com.senlaCourse.autoservice.api.story.IOrderStore;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.util.Printer;
import com.senlaCourse.autoservice.util.StateOrder;

import java.util.ArrayList;
import java.util.List;

public class OrderStoreImpl implements IOrderStore {

    private List<Order> orders = new ArrayList<Order>();
    private Printer printer;


    @Override
    public void delete(Order order) {
        {
            int index = 0;
            boolean flag = false;
            for (int i=0; i<orders.size(); i++){
                if (orders.get(i).getNum() == order.getNum()){
                    flag = true;
                    index = i;
                    orders.get(i).getMaster().setStateFree(true);
                    orders.get(i).getPlace().setStateFree(true);
                    break;
                }
            }
            if (flag) {
                orders.remove(index);
            }
            else {
                printer.printMessage("You cannot delete this element!");
            }
        }
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
    public void canceleOrder(Order order) {
        order.setStateOrder(StateOrder.CANCELED);
    }

    @Override
    public void deleteOrder(Order order) {
        order.setStateOrder(StateOrder.DELETED);
    }

    @Override
    public void closeOrder(Order order) {
        order.setStateOrder(StateOrder.COMPLETED);
    }

}

