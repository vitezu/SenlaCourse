package com.senlaCourse.autoservice.controller;

import com.senlaCourse.autoservice.api.controller.IController;
import com.senlaCourse.autoservice.api.service.IMasterService;
import com.senlaCourse.autoservice.api.service.IOrderService;
import com.senlaCourse.autoservice.api.service.IPlaceService;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.service.MasterServiceImpl;
import com.senlaCourse.autoservice.service.OrderServiceImpl;
import com.senlaCourse.autoservice.service.PlaceServiceImpl;

import java.util.Date;
import java.util.List;

public class ControllerImpl implements IController {

    private IPlaceService placeService = new PlaceServiceImpl();
    private IMasterService masterService = new MasterServiceImpl();
    private IOrderService orderService = new OrderServiceImpl();

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
    public void getFreePlaces() {
        placeService.getFreePlaces();
    }

    @Override
    public void addOrder(Order order) {
        orderService.addOrder(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderService.deleteOrder(order);
    }

    @Override
    public void sortByDateOfOrder() {
        orderService.sortByDateOfOrder();
    }

    @Override
    public void sortByPriceOfOrder() {
        orderService.sortByPriceOfOrder();
    }

    @Override
    public void sortByDateOfPlannedExecution() {
        orderService.sortByDateOfPlannedExecution();
    }

    @Override
    public void sortByDateOfExecution() {
        orderService.sortByDateOfExecution();
    }

    @Override
    public void sortByPriceOfOperationOrder() {
        orderService.sortByPriceOfOperationOrder();
    }

    @Override
    public void sortByDateOfOperationOrder() {
        orderService.sortByDateOfOperationOrder();
    }

    @Override
    public void sortByDateOfExecutionOperationOrder() {
        orderService.sortByDateOfExecutionOperationOrder();
    }

    @Override
    public void canceleOrder(Order order) {
        orderService.canceleOrder(order);
    }

    @Override
    public void closeOrder(Order order, Date date) {
        orderService.closeOrder(order, date);

    }

    @Override
    public void operateOrder(Order order) {
        orderService.operateOrder(order);
    }

    @Override
    public void addMaster(Master master) {
        masterService.addMaster(master);
    }

    @Override
    public void deleteMaster(Master master) {
        masterService.deleteMaster(master);
    }

    @Override
    public void sortByNameOfMaster() {
        masterService.sortByNameOfMaster();
    }

    @Override
    public void sortByStateFree() {
        masterService.sortByStateFree();
    }

    @Override
    public List<Place> getAllPlaces() {
        return placeService.getPlaceStore();
    }

    @Override
    public List<Order> getAllOrders() {
        return orderService.getOrderStore();
    }

    @Override
    public List<Master> getAllMasters() {
        return masterService.getMasterStore();
    }

    public String[] convertInArrayOfPlaces() {
        String[] arrayPlaces = new String[placeService.getPlaceStore().size()];
        for (int i = 0; i < placeService.getPlaceStore().size(); i++) {
            arrayPlaces[i] = String.valueOf(placeService.getPlaceStore().get(i));
        }
        return arrayPlaces;
    }

    @Override
    public String[] convertInArrayOfOrders() {
        String[] arrayOrders = new String[orderService.getOrderStore().size()];
        for (int i = 0; i < orderService.getOrderStore().size(); i++) {
            arrayOrders[i] = String.valueOf(orderService.getOrderStore().get(i));
        }
        return arrayOrders;
    }

    @Override
    public String[] convertInArrayOfMasters() {
        String[] arrayMasters = new String[masterService.getMasterStore().size()];
        for (int i = 0; i < masterService.getMasterStore().size(); i++) {
            arrayMasters[i] = String.valueOf(masterService.getMasterStore().get(i));
        }
        return arrayMasters;
    }

}
