package com.senlaCourse.autoservice.controller;

import com.senlaCourse.autoservice.api.controller.IController;
import com.senlaCourse.autoservice.api.service.IPlaceService;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.service.PlaceServiceImpl;

import java.util.List;

public class ControllerImpl implements IController {

    private IPlaceService placeService = new PlaceServiceImpl();

    @Override
    public void addPlace(Place place) {
        placeService.addPlace(place);
    }

    @Override
    public void deletePlace(Place place) {
        placeService.deletePlace(place);
    }

    @Override
    public void calcFreePlaces(List<Place> places, List<Master> masters) {
        placeService.calcFreePlaces(places, masters);
    }

    @Override
    public void getFreePlaces(List<Place> places) {
        placeService.getFreePlaces(places);
    }

    @Override
    public void addOrder(Order order) {

    }

    @Override
    public void deleteOrder(Order order) {

    }

    @Override
    public void sortByDateOfOrder() {

    }

    @Override
    public void sortByPriceOfOrder() {

    }

    @Override
    public void sortByDateOfPlannedExecution() {

    }

    @Override
    public void sortByDateOfExecution() {

    }

    @Override
    public void sortByPriceOfOperationOrder() {

    }

    @Override
    public void sortByDateOfOperationOrder() {

    }

    @Override
    public void canceleOrder(Order order) {

    }

    @Override
    public void closeOrder(Order order) {

    }

    @Override
    public void operateOrder(Order order) {

    }

    @Override
    public void addMaster(Master master) {

    }

    @Override
    public void deleteMaster(Master master) {

    }

    @Override
    public void sortByNameOfMaster() {

    }

    @Override
    public void sortByStateFree() {

    }

    public IPlaceService getPlaceService () {
        return placeService;
    }
}
