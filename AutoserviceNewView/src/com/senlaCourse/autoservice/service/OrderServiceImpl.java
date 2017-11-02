package com.senlaCourse.autoservice.service;

import com.senlaCourse.autoservice.api.service.IOrderService;
import com.senlaCourse.autoservice.api.story.IOrderStore;
import com.senlaCourse.autoservice.dependancy.DependancyInjection;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.util.StateOrder;
import com.senlaCourse.autoservice.util.comparators.order.ComparatorByDateOfExecution;
import com.senlaCourse.autoservice.util.comparators.order.ComparatorByDateOfOrder;
import com.senlaCourse.autoservice.util.comparators.order.ComparatorByDateOfStart;
import com.senlaCourse.autoservice.util.comparators.order.ComparatorByPriceOfOrder;
import com.senlaCourse.autoservice.stores.OrderStoreImpl;
import com.senlaCourse.autoservice.util.Printer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements IOrderService {

    private final String MESSAGE5 = "Sorted by price of operation order";
    private final String MESSAGE6 = "Sorted by date of operation order";
    private final String MESSAGE7 = "Sorted by date of execution operation order";

    private static final ComparatorByDateOfOrder COMPARATOR_BY_DATE_OF_ORDER = new ComparatorByDateOfOrder();
    private static final ComparatorByPriceOfOrder COMPARATOR_BY_PRICE_OF_ORDER = new ComparatorByPriceOfOrder();
    private static final ComparatorByDateOfStart COMPARATOR_BY_DATE_OF_START = new ComparatorByDateOfStart();
    private static final ComparatorByDateOfExecution COMPARATOR_BY_DATE_OF_EXECUTION = new ComparatorByDateOfExecution();
    private Printer printer = new Printer();
    private IOrderStore orderStore = (IOrderStore) DependancyInjection.getInstance().load(IOrderStore.class);

    @Override
    public void addOrder(Order order) {
        orderStore.add(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderStore.delete(order);
        order.setStateOrder(StateOrder.DELETED);
    }

    public List<Order> ordersSorted(Comparator comparator) {
        List<Order> ordersSorted = new ArrayList<>(orderStore.getAll());
        ordersSorted.sort(comparator);
        return ordersSorted;
    }

    @Override
    public List<Order> sortByDateOfOrder() {
        List<Order> ordersSorted = ordersSorted(COMPARATOR_BY_DATE_OF_ORDER);
        return ordersSorted;
    }

    @Override
    public List<Order> sortByPriceOfOrder() {
        List<Order> ordersSorted = ordersSorted(COMPARATOR_BY_PRICE_OF_ORDER);
        return ordersSorted;
    }

    @Override
    public List<Order> sortByDateOfStart() {
        List<Order> ordersSorted = ordersSorted(COMPARATOR_BY_DATE_OF_START);
        return ordersSorted;
    }

    @Override
    public List<Order> sortByDateOfExecution() {
        List<Order> ordersSorted = new ArrayList<>(orderStore.getAll());
        ordersSorted.sort(COMPARATOR_BY_DATE_OF_EXECUTION);
        return ordersSorted;
    }

    @Override
    public void sortByPriceOfOperationOrder() {
        List<Order> ordersSorted = new ArrayList<>(orderStore.getAll());
        ordersSorted.sort(COMPARATOR_BY_PRICE_OF_ORDER);
        printer.printMessage(MESSAGE5);
        for (Order order : ordersSorted) {
            if (order.getStateOrder() == StateOrder.OPERATING) printer.printObject(order);
        }
    }

    @Override
    public void sortByDateOfExecutionOperationOrder() {
        List<Order> ordersSorted = new ArrayList<>(orderStore.getAll());
        ordersSorted.sort(COMPARATOR_BY_DATE_OF_EXECUTION);
        printer.printMessage(MESSAGE7);
        for (Order order : ordersSorted) {
            if (order.getStateOrder() == StateOrder.OPERATING) printer.printObject(order);
        }
    }

    @Override
    public void sortByDateOfOperationOrder() {
        List<Order> ordersSorted = new ArrayList<>(orderStore.getAll());
        ordersSorted.sort(COMPARATOR_BY_DATE_OF_ORDER);
        printer.printMessage(MESSAGE6);
        for (Order order : ordersSorted) {
            if (order.getStateOrder() == StateOrder.OPERATING) printer.printObject(order);
        }
    }

    @Override
    public void cancelOrder(Order order) {
        order.setStateOrder(StateOrder.CANCELED);
    }

    @Override
    public void closeOrder(Order order, Date date) {
        order.setStateOrder(StateOrder.COMPLETED);
        order.setDateOfExecution(date);
    }

    @Override
    public void operateOrder(Order order) {
        order.setStateOrder(StateOrder.OPERATING);
    }

    @Override
    public List<Order> getOrderStore() {
        return orderStore.getAll();
    }

    @Override
    public Order getOrderExecuteMaster(Master master) {
        Order order = new Order();
        for (Order or : getOrderStore()) {
            if (or.getMaster().getName().equals(master.getName())) {
                order = or;
            }
        }
        if (order.getNum() == null) {
            return null;
        }
        return order;
    }

    @Override
    public List<Order> getOrdersIntervalTime(Date date1, Date date2) {
        List<Order> orders = new ArrayList<Order>();
        for (Order order : getOrderStore()) {
            if (date1.getTime() < order.getDateOfOrder().getTime() && order.getDateOfOrder().getTime() < date2.getTime()) {
                orders.add(order);
            }
        }
        if (orders.size() == 0) {
            return null;
        }
        return orders;
    }
}
