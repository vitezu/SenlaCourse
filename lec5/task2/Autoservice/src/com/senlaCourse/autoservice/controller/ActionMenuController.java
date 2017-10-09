package com.senlaCourse.autoservice.controller;

import com.senlaCourse.autoservice.api.controller.IActionMenu;
import com.senlaCourse.autoservice.entity.Master;
import com.senlaCourse.autoservice.entity.Order;
import com.senlaCourse.autoservice.entity.Place;
import com.senlaCourse.autoservice.service.MasterServiceImpl;
import com.senlaCourse.autoservice.service.OrderServiceImpl;
import com.senlaCourse.autoservice.service.PlaceServiceImpl;

import java.util.Date;
import java.util.List;

public class ActionMenuController implements IActionMenu {

    @Override
    public void addPlace(Place place) {
        PlaceServiceImpl.getInstance().addPlace(place);
    }

    @Override
    public void deletePlace(Place place) {
        PlaceServiceImpl.getInstance().deletePlace(place);
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
    public void addMaster(Master master) {
        MasterServiceImpl.getInstance().addMaster(master);
    }

    @Override
    public void deleteMaster(Master master) {
        MasterServiceImpl.getInstance().deleteMaster(master);
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
