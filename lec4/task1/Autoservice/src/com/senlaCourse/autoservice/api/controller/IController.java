package com.senlaCourse.autoservice.api.controller;

import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.Place;

import java.util.Date;
import java.util.List;

public interface IController {

    void addPlace(Place place);

    void deletePlace(Place place);

    void calcFreePlaces(List<Place> places, List<Master> masters);

    List<Place> getFreePlaces();

    void addOrder (Order order);

    void deleteOrder (Order order);

    List<Order> sortByDateOfOrder();

    List<Order> sortByPriceOfOrder();

    List<Order> sortByDateOfPlannedExecution();

    List<Order> sortByDateOfExecution();

    List<Order> sortByPriceOfOperationOrder();

    List<Order> sortByDateOfOperationOrder();

    List<Order> sortByDateOfExecutionOperationOrder();

    void canceleOrder(Order order);

    void closeOrder(Order order, Date date);

    void operateOrder(Order order);

    void addMaster(Master master);

    void deleteMaster (Master master);

    List<Master> sortByNameOfMaster();

    List<Master> sortByStateFree();

    List<Place> getAllPlaces();

    List<Order> getAllOrders ();

    List<Master> getAllMasters();

    String[] convertInArrayOfPlaces ();

    String[] convertInArrayOfOrders ();

    String[] convertInArrayOfMasters ();

    void createOrder(Integer num, Float price);
}
