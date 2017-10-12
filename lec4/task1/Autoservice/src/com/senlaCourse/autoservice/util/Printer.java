package com.senlaCourse.autoservice.util;

import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.Place;

import java.util.List;

public class Printer {
    public void printObject(Object object) {
        System.out.println(object);
    }

    public void printLineEmpty() {
        System.out.println();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMasters(String message, List<Master> masters) {
        System.out.println();
        System.out.println(message);
        for (Master master : masters) {
            System.out.println(master);
        }
    }

    public void printPlaces(String message, List<Place> places) {
        System.out.println();
        System.out.println(message);
        for (Place place : places) {
            System.out.println(place);
        }
    }

    public void printOrders(String message, List<Order> orders) {
        System.out.println();
        System.out.println(message);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
