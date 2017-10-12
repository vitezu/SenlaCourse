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
    public List<Place> getFreePlaces() {
       return placeService.getFreePlaces();
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
    public List<Order> sortByDateOfOrder() {
        return orderService.sortByDateOfOrder();
    }

    @Override
    public List<Order> sortByPriceOfOrder() {
        return orderService.sortByPriceOfOrder();
    }

    @Override
    public List<Order> sortByDateOfPlannedExecution() {
        return orderService.sortByDateOfPlannedExecution();
    }

    @Override
    public List<Order> sortByDateOfExecution() {
        return orderService.sortByDateOfExecution();
    }

    @Override
    public List<Order> sortByPriceOfOperationOrder() {
        return orderService.sortByPriceOfOperationOrder();
    }

    @Override
    public List<Order> sortByDateOfOperationOrder() {
       return orderService.sortByDateOfOperationOrder();
    }

    @Override
    public List<Order> sortByDateOfExecutionOperationOrder() {
        return orderService.sortByDateOfExecutionOperationOrder();
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
    public List<Master> sortByNameOfMaster() {
       return masterService.sortByNameOfMaster();
    }

    @Override
    public List<Master> sortByStateFree() {
        return masterService.sortByStateFree();
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

    @Override
    public void createOrder(Integer num, Float price) {
        List<Place> freePlaces = placeService.getFreePlaces();
        List<Master> freeMasters = masterService.getFreeMasters();
        List<Order> orders = orderService.sortByDateOfExecution();

        Date dateNow = new Date();

        Order newOrder = new Order(num, dateNow, dateNow, price);

        Place place = new Place();
        if (freePlaces.size() > 0) {
            place = freePlaces.get(0);
            place.setStateFree(false);
        } else {
            if (orders.size() > 0) {
                Order order = orders.get(0);
                place = order.getPlace();

                if (newOrder.getDateOfStart().getTime() < order.getDateOfEnd().getTime()) {
                    newOrder.setDateOfStart(order.getDateOfEnd());
                }
            }
        }

        Master master = new Master();
        if (freeMasters.size() > 0) {
            master = freeMasters.get(0);
            master.setStateFree(false);
        } else {
            if (orders.size() > 0) {
                Order order = orders.get(0);
                master = order.getMaster();

                if (newOrder.getDateOfStart().getTime() < order.getDateOfEnd().getTime()) {
                    newOrder.setDateOfStart(order.getDateOfEnd());
                }
            }
        }

        if (master.getName() != null && place.getNumPlace() != null) {
            newOrder.setMaster(master);
            newOrder.setPlace(place);
            master.setOrder(newOrder);
            orderService.operateOrder(newOrder);
            orderService.addOrder(newOrder);
        } else {
            System.out.println("Place or master not exist!!!");
        }
    }
}
