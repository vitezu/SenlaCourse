package com.senlaCourse.autoservice.controller;

import com.senlaCourse.autoservice.api.controller.IController;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.service.MasterServiceImpl;
import com.senlaCourse.autoservice.service.OrderServiceImpl;
import com.senlaCourse.autoservice.service.PlaceServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControllerImpl implements IController {

    @Override
    public void addPlace(Place place) {
        PlaceServiceImpl.getInstance().addPlace(place);
    }

    @Override
    public void deletePlace(Place place) {
        PlaceServiceImpl.getInstance().deletePlace(place);
    }

    @Override
    public void calcFreePlaces() {
        List<Place> places = getFreePlaces();
        List<Master> masters = getAllMasters();
        PlaceServiceImpl.getInstance().calcFreePlaces(places, masters);
    }

    @Override
    public List<Place> getFreePlaces() {
        return PlaceServiceImpl.getInstance().getFreePlaces();
    }

    @Override
    public void addOrder(Order order) {


        OrderServiceImpl.getInstance().addOrder(order);
    }

    @Override
    public void deleteOrder(Order order) {
        OrderServiceImpl.getInstance().deleteOrder(order);
    }

    @Override
    public void sortByDateOfOrder() {
        OrderServiceImpl.getInstance().sortByDateOfOrder();
    }

    @Override
    public void sortByPriceOfOrder() {
        OrderServiceImpl.getInstance().sortByPriceOfOrder();
    }

    @Override
    public void sortByDateOfStart() {
        OrderServiceImpl.getInstance().sortByDateOfStart();
    }

    @Override
    public void sortByDateOfExecution() {
        OrderServiceImpl.getInstance().sortByDateOfExecution();
    }

    @Override
    public void sortByPriceOfOperationOrder() {
        OrderServiceImpl.getInstance().sortByPriceOfOperationOrder();
    }

    @Override
    public void sortByDateOfOperationOrder() {
        OrderServiceImpl.getInstance().sortByDateOfOperationOrder();
    }

    @Override
    public void sortByDateOfExecutionOperationOrder() {
        OrderServiceImpl.getInstance().sortByDateOfExecutionOperationOrder();
    }

    @Override
    public void canceleOrder(Order order) {
        OrderServiceImpl.getInstance().canceleOrder(order);
    }

    @Override
    public void closeOrder(Order order, Date date) {
        OrderServiceImpl.getInstance().closeOrder(order, date);

    }

    @Override
    public void operateOrder(Order order) {
        OrderServiceImpl.getInstance().operateOrder(order);
    }

    @Override
    public void addMaster(Master master) {
        MasterServiceImpl.getInstance().addMaster(master);
    }

    @Override
    public void deleteMaster(Master master) {
        MasterServiceImpl.getInstance().deleteMaster(master);
    }

    @Override
    public void sortByNameOfMaster() {
        MasterServiceImpl.getInstance().sortByNameOfMaster();
    }

    @Override
    public void sortByStateFree() {
        MasterServiceImpl.getInstance().sortByStateFree();
    }

    @Override
    public List<Place> getAllPlaces() {
        return PlaceServiceImpl.getInstance().getPlaceStore();
    }

    @Override
    public List<Order> getAllOrders() {
        return OrderServiceImpl.getInstance().getOrderStore();
    }

    @Override
    public List<Master> getAllMasters() {
        List<Master> masters = MasterServiceImpl.getInstance().getMasterStore();
        for (Master master : masters) {
            System.out.println(master);
        }
        return masters;
    }

    public String[] convertInArrayOfPlaces() {
        String[] arrayPlaces = new String[PlaceServiceImpl.getInstance().getPlaceStore().size()];
        for (int i = 0; i < PlaceServiceImpl.getInstance().getPlaceStore().size(); i++) {
            arrayPlaces[i] = String.valueOf(PlaceServiceImpl.getInstance().getPlaceStore().get(i));
        }
        return arrayPlaces;
    }

    @Override
    public String[] convertInArrayOfOrders() {
        String[] arrayOrders = new String[OrderServiceImpl.getInstance().getOrderStore().size()];
        for (int i = 0; i < OrderServiceImpl.getInstance().getOrderStore().size(); i++) {
            arrayOrders[i] = String.valueOf(OrderServiceImpl.getInstance().getOrderStore().get(i));
        }
        return arrayOrders;
    }

    @Override
    public String[] convertInArrayOfMasters() {
        String[] arrayMasters = new String[MasterServiceImpl.getInstance().getMasterStore().size()];
        for (int i = 0; i < MasterServiceImpl.getInstance().getMasterStore().size(); i++) {
            arrayMasters[i] = String.valueOf(MasterServiceImpl.getInstance().getMasterStore().get(i));
        }
        return arrayMasters;
    }

    @Override
    public void createOrder(Integer num, Float price) {
        List<Place> freePlaces = PlaceServiceImpl.getInstance().getFreePlaces();
        List<Master> freeMasters = MasterServiceImpl.getInstance().getFreeMasters();
        List<Order> orders = OrderServiceImpl.getInstance().sortByDateOfExecution();

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

            OrderServiceImpl.getInstance().addOrder(newOrder);

            System.out.println(newOrder);
        } else {
            System.out.println("Place or master not exist!!!");
        }
    }


}
