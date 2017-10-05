package com.senlaCourse.autoservice.service;

import com.senlaCourse.autoservice.api.service.IOrderService;
import com.senlaCourse.autoservice.api.story.IOrderStore;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.util.StateOrder;
import com.senlaCourse.autoservice.util.comparators.order.ComparatorByDateOfExecution;
import com.senlaCourse.autoservice.util.comparators.order.ComparatorByDateOfOrder;
import com.senlaCourse.autoservice.util.comparators.order.ComparatorByDateOfPlannedExecution;
import com.senlaCourse.autoservice.util.comparators.order.ComparatorByPriceOfOrder;
import com.senlaCourse.autoservice.stores.OrderStoreImpl;
import com.senlaCourse.autoservice.util.Printer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements IOrderService {
    private final String MESSAGE1 = "Sorted by date of order";
    private final String MESSAGE2 = "Sorted by price of order";
    private final String MESSAGE3 = "Sorted by date of planned execution order";
    private final String MESSAGE4 = "Sorted by date of execution";
    private final String MESSAGE5 = "Sorted by price of operation order";
    private final String MESSAGE6 = "Sorted by date of operation order";
    private final String MESSAGE7 = "Sorted by date of execution operation order";

    private final ComparatorByDateOfOrder comparatorByDateOfOrder = new ComparatorByDateOfOrder();
    private final ComparatorByPriceOfOrder comparatorByPriceOfOrder = new ComparatorByPriceOfOrder();
    private final ComparatorByDateOfPlannedExecution comparatorByDateOfPlannedExecution = new ComparatorByDateOfPlannedExecution();
    private final ComparatorByDateOfExecution comparatorByDateOfExecution = new ComparatorByDateOfExecution();
    private Printer printer = new Printer();
    private IOrderStore orderStore = new OrderStoreImpl();

    @Override
    public void addOrder(Order order) {
        orderStore.add(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderStore.delete(order);
        order.setStateOrder(StateOrder.DELETED);
    }

    @Override
    public void sortByDateOfOrder() {
        List<Order> ordersSorted = new ArrayList<>(orderStore.getAll());
        ordersSorted.sort(comparatorByDateOfOrder);
        printer.printMessage(MESSAGE1);
        for (Order order : ordersSorted)
            printer.printObject(order);
    }

    @Override
    public void sortByPriceOfOrder() {
        List<Order> ordersSorted = new ArrayList<>(orderStore.getAll());
        ordersSorted.sort(comparatorByPriceOfOrder);
        printer.printMessage(MESSAGE2);
        for (Order order : ordersSorted)
            printer.printObject(order);
    }

    @Override
    public void sortByDateOfPlannedExecution() {
        List<Order> ordersSorted = new ArrayList<>(orderStore.getAll());
        ordersSorted.sort(comparatorByDateOfPlannedExecution);
        printer.printMessage(MESSAGE3);
        for (Order order : ordersSorted)
            printer.printObject(order);
    }

    @Override
    public void sortByDateOfExecution() {
        List<Order> ordersSorted = new ArrayList<>(orderStore.getAll());
        ordersSorted.sort(comparatorByDateOfExecution);
        printer.printMessage(MESSAGE4);
        for (Order order : ordersSorted)
            printer.printObject(order);
    }

    @Override
    public void sortByPriceOfOperationOrder() {
        List<Order> ordersSorted = new ArrayList<>(orderStore.getAll());
        ordersSorted.sort(comparatorByPriceOfOrder);
        printer.printMessage(MESSAGE5);
        for (Order order : ordersSorted) {
            if (order.getStateOrder() == StateOrder.OPERATING) printer.printObject(order);
        }
    }

    @Override
    public void sortByDateOfExecutionOperationOrder (){
        List<Order> ordersSorted = new ArrayList<>(orderStore.getAll());
        ordersSorted.sort(comparatorByDateOfExecution);
        printer.printMessage(MESSAGE7);
        for (Order order : ordersSorted) {
            if (order.getStateOrder() == StateOrder.OPERATING)
                printer.printObject(order);
        }
    }

    @Override
    public void sortByDateOfOperationOrder() {
        List<Order> ordersSorted = new ArrayList<>(orderStore.getAll());
        ordersSorted.sort(comparatorByDateOfOrder);
        printer.printMessage(MESSAGE6);
        for (Order order : ordersSorted) {
            if (order.getStateOrder() == StateOrder.OPERATING)
                printer.printObject(order);
        }
    }

    public void setDateOfExecution (Date date) {
        orderStore.getAll();
    }

    @Override
    public void canceleOrder(Order order) {
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
}
