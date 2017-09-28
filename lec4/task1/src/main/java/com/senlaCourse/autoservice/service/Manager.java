package com.senlaCourse.autoservice.service;

import com.senlaCourse.autoservice.comparator.master.ComparatorByNameOfMaster;
import com.senlaCourse.autoservice.comparator.master.ComparatorByStateOfMaster;
import com.senlaCourse.autoservice.comparator.order.ComparatorByDateOfEndOrder;
import com.senlaCourse.autoservice.comparator.order.ComparatorByDateOfOrder;
import com.senlaCourse.autoservice.comparator.order.ComparatorByDateOfPlaningEndOrder;
import com.senlaCourse.autoservice.comparator.order.ComparatorByPriceOfOrder;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.Place;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Manager {
    private final String MESSAGE1 = "Sorted by date of order";
    private final String MESSAGE2 = "Sorted by price of order";
    private final String MESSAGE3 = "Sorted by name of master";
    private final String MESSAGE4 = "Sorted by state of master";
    private final String MESSAGE5 = "Sorted by price of operation order";
    private final String MESSAGE6 = "Sorted by date of planing end order";
    private final String MESSAGE7 = "Sorted by date of end order";
    private final String MESSAGE8 = "Sorted by date of operation order";
    private final String MESSAGE9 = "Count of free places in future";
    private final String MESSAGE10 = "Free places";
    private final String MESSAGE11 = "Sorted by date order with state";

    private List<Place> places = new ArrayList<Place>(15);
    private List<Order> orders = new ArrayList<Order>();
    private List<Master> masters = new ArrayList<Master>();

    public List<Master> getMasters() {
        return masters;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addPlace(Place place) {
        {
            places.add(place);
        }
    }

    public void deletePlace(Place place) {
        {
            places.remove(place);
        }
    }

    public void deleteMaster(Master master) {
        masters.remove(master);
    }

    public void addOrder(Order order) {
        {
            orders.add(order);
        }
    }

    public void addMaster(Master master) {
        masters.add(master);
    }

    public void sortByDateOfOrder() {
        System.out.println();
        Collections.sort(orders, new ComparatorByDateOfOrder());
        System.out.println(MESSAGE1);
        for (Order order : orders)
            System.out.println(order.toString());
    }

    public void sortByDateOfPlaningEndOrder() {
        System.out.println();
        Collections.sort(orders, new ComparatorByDateOfPlaningEndOrder());
        System.out.println(MESSAGE6);
        for (Order order : orders)
            System.out.println(order.toString());
    }

    public void sortByDateOfEndOrder() {
        System.out.println();
        try {
            Collections.sort(orders, new ComparatorByDateOfEndOrder());
        } catch (NullPointerException e) {
            System.out.println("Some date is null");
        }
        System.out.println(MESSAGE7);
        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }

    public void sortByPriceOfOrder() {
        System.out.println();
        Collections.sort(orders, new ComparatorByPriceOfOrder());
        System.out.println(MESSAGE2);
        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }

    public void sortByNameOfMaster() {
        System.out.println();
        Collections.sort(masters, new ComparatorByNameOfMaster());
        System.out.println(MESSAGE3);
        for (Master master : masters) {
            System.out.println(master.toString());
        }
    }

    public void sortByStateOfMaster() {
        System.out.println();
        Collections.sort(masters, new ComparatorByStateOfMaster());
        System.out.println(MESSAGE4);
        for (Master master : masters)
            System.out.println(master.toString());
    }

    public void sortByPriceOfOperationOrder() {
        System.out.println();
        Collections.sort(orders, new ComparatorByPriceOfOrder());
        System.out.println(MESSAGE5);
        for (Order order : orders) {
            if (order.getStateOrder() == StateOrder.OPERATING)
                System.out.println(order.toString());
        }
    }

    public void sortByDateOfOperationOrder() {
        System.out.println();
        Collections.sort(orders, new ComparatorByDateOfOrder());
        System.out.println(MESSAGE8);
        for (Order order : orders) {
            if (order.getStateOrder() == StateOrder.OPERATING)
                System.out.println(order.toString());
        }
    }

    public void getFreePlaces() {
        System.out.println();
        System.out.println(MESSAGE10);
        for (Place place : places) {
            if (place.getStateFree() == true) {
                System.out.println(place);
            }
        }
    }

    public int calcFreePlaces() {
        System.out.println();
        System.out.println(MESSAGE9);
        int countFreePlace = 0;
        int countFreeMaster = 0;

        for (Place place : places) {
            if (place.getStateFree() == true) {
                countFreePlace++;
            }
        }

        for (Master master : masters) {
            if (master.getStateFree() == true) {
                countFreeMaster++;
            }
        }
        return (countFreePlace + countFreeMaster)/2;
    }
    public void sortByDateOrderWithState () {
        System.out.println();
        Collections.sort(orders, new ComparatorByDateOfOrder());
        System.out.println(MESSAGE11);
        for (Order order : orders) {
            if (order.getStateOrder() != null)
                System.out.println(order.toString());
        }
    }
    public void canceleOrder (Order order) {
        order.setStateOrder(StateOrder.CANCELED);
    }
    public void deleteOrder (Order order) {
        order.setStateOrder(StateOrder.DELETED);
    }
    public void closeOrder (Order order) {
        order.setStateOrder(StateOrder.COMPLETED);
    }
    public void shiftDateOfPlaningEnd (Order order, Date date) {
        order.setDateOfPlaningEnd(date);
    }
}