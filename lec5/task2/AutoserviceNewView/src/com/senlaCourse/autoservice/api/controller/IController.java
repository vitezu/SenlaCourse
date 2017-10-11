package com.senlaCourse.autoservice.api.controller;

import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.Place;

import java.util.Date;
import java.util.List;

public interface IController {

    void addPlace(Place place);

    void deletePlace(Place place);

    void calcFreePlaces();

    List<Place> getFreePlaces();

    void addOrder (Order order);

    void deleteOrder (Order order);

    void sortByDateOfOrder();

    void sortByPriceOfOrder();

    void sortByDateOfStart();

    void sortByDateOfExecution();

    void sortByPriceOfOperationOrder();

    void sortByDateOfOperationOrder();

    void sortByDateOfExecutionOperationOrder();

    void canceleOrder(Order order);

    void closeOrder(Order order, Date date);

    void operateOrder(Order order);

    void addMaster(Master master);

    void deleteMaster (Master master);

    void sortByNameOfMaster();

    void sortByStateFree();

    List<Place> getAllPlaces();

    List<Order> getAllOrders ();

    List<Master> getAllMasters();

    String[] convertInArrayOfPlaces ();

    String[] convertInArrayOfOrders ();

    String[] convertInArrayOfMasters ();

    void createOrder (Integer num, Float price);
}
