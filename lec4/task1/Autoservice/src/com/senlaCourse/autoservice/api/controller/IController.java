package com.senlaCourse.autoservice.api.controller;

import com.senlaCourse.autoservice.api.service.IPlaceService;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.Place;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface IController {

    void addPlace(Place place);

    void deletePlace(Place place);

    void calcFreePlaces(List<Place> places, List<Master> masters);

    void getFreePlaces(List<Place> places);

    void addOrder (Order order);

    void deleteOrder (Order order);

    void sortByDateOfOrder();

    void sortByPriceOfOrder();

    void sortByDateOfPlannedExecution();

    void sortByDateOfExecution();

    void sortByPriceOfOperationOrder();

    void sortByDateOfOperationOrder();

    void canceleOrder(Order order);

    void closeOrder(Order order);

    void operateOrder(Order order);

    void addMaster(Master master);

    void deleteMaster (Master master);

    void sortByNameOfMaster();

    void sortByStateFree();

    IPlaceService getPlaceService ();
}
