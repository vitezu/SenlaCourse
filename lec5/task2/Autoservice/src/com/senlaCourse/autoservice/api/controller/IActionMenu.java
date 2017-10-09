package com.senlaCourse.autoservice.api.controller;


import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.Place;

public interface IActionMenu {
    void addPlace(Place place);

    void deletePlace(Place place);

    void addOrder(Order order);

    void deleteOrder(Order order);

    void addMaster(Master master);

    void deleteMaster(Master master);

    void createOrder(Integer num, Float price);

}
