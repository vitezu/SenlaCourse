package com.senlaCourse.autoservice.api.controller;

import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.Place;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface IController {

    void addMaster(Master master);

    void deleteMaster (Master master);

    List<Master> sortByNameOfMaster();

    List<Master> sortByStateFree ();

    List<Master> getMasterStore ();

    List<Master> getFreeMasters ();

    Master getMasterExecuteOrder (Order order);

    void addOrder (Order order);

    void deleteOrder (Order order);

    List<Order> sortByDateOfOrder();

    List<Order> sortByPriceOfOrder();

    List<Order> sortByDateOfStart();

    List<Order> sortByDateOfExecution();

    void sortByPriceOfOperationOrder();

    void sortByDateOfOperationOrder();

    void sortByDateOfExecutionOperationOrder();

    void cancelOrder(Order order);

    void closeOrder(Order order, Date date);

    void operateOrder(Order order);

    List<Order> getOrderStore();

    Order getOrderExecuteMaster(Master master);

    List<Order> getOrdersIntervalTime (Date date1, Date date2);

    void addPlace(Place place);

    void deletePlace(Place place);

    Integer calcFreePlaces();

    List<Place> getFreePlaces();

    List<Place> getPlaceStore ();

    void shiftTimeEnd (Date time, Order order);
}
